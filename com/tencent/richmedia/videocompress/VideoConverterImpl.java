package com.tencent.richmedia.videocompress;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.converter.AsyncHardwareConverter;
import com.tencent.richmedia.videocompress.converter.HardwareConverter;
import com.tencent.richmedia.videocompress.converter.IHardwareConverter;
import com.tencent.richmedia.videocompress.converter.SoftwareConverter;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoConverterImpl {
    public static final int FFMPEG_FILE_NOT_FIND = -1;
    public static final int FFMPEG_LOAD_ERROR = -2;
    private static int FFMPEG_LOAD_STATUS = -3;
    public static final int FFMPEG_LOAD_SUCCESS = 0;
    public static final int FFMPEG_LOAD_UNINIT = -3;
    private static final String TAG = "VideoConverter";
    public static String mOutPutVideoCodecMIMEType = MediaCodecSupport.AVC_CODEC_MIME;
    private VideoConverter.Processor mConverterCallback;
    private Throwable mException;
    private Process mProcess;
    private WeakReference<Thread> mThreadRef;
    private boolean useNativeCodec = false;
    private int compressMode = 3;
    private boolean running = false;
    private boolean mCancelled = false;
    private boolean noNeedCompress = false;

    private void initConverterCallback(final VideoConverter.Processor processor) {
        this.mConverterCallback = new VideoConverter.Processor() { // from class: com.tencent.richmedia.videocompress.VideoConverterImpl.1
            @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
            public VideoConverterConfig getEncodeConfig(int i3, int i16) {
                return processor.getEncodeConfig(i3, i16);
            }

            @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
            public void onCancel() {
                VideoConverterImpl.this.mCancelled = true;
                processor.onCancel();
            }

            @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
            public void onFail(Throwable th5) {
                if (VideoConverterConstant.KEY_NO_NEED_COMPRESS.equals(th5.getMessage())) {
                    VideoConverterImpl.this.noNeedCompress = true;
                } else {
                    VideoConverterImpl.this.mException = th5;
                    processor.onFail(th5);
                }
            }

            @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
            public void onProgress(int i3) {
                processor.onProgress(i3);
            }

            @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
            public void onSuccess() {
                processor.onSuccess();
            }
        };
    }

    private synchronized void loadFFmpegSo(String str) {
        if (FFMPEG_LOAD_STATUS == 0) {
            return;
        }
        if (!new File(str).exists()) {
            FFMPEG_LOAD_STATUS = -1;
            ConvertLog.i(TAG, 1, "loadFFmpegSo, file not found");
            return;
        }
        try {
            System.load(str);
            FFMPEG_LOAD_STATUS = -2;
            ConvertLog.i(TAG, 1, "loadFFmpegSo success");
        } catch (Throwable th5) {
            FFMPEG_LOAD_STATUS = -2;
            ConvertLog.e(TAG, 1, "loadFFmpegSo error", th5);
        }
    }

    @SuppressLint({"NewApi"})
    private int startHardwareConvert(String str, VideoConverter.Processor processor, boolean z16, boolean z17) {
        IHardwareConverter hardwareConverter;
        IHardwareConverter iHardwareConverter;
        if (this.useNativeCodec) {
            iHardwareConverter = null;
        } else {
            initConverterCallback(processor);
            if (z17) {
                hardwareConverter = new AsyncHardwareConverter(str, this.mConverterCallback);
            } else {
                hardwareConverter = new HardwareConverter(str, this.mConverterCallback);
            }
            iHardwareConverter = hardwareConverter;
            iHardwareConverter.setOutPutVideoCodecMIMEType(mOutPutVideoCodecMIMEType);
        }
        BaseThread baseThread = new BaseThread(iHardwareConverter, TAG);
        this.mThreadRef = new WeakReference<>(baseThread);
        baseThread.start();
        if (z16) {
            try {
                baseThread.join();
            } catch (InterruptedException e16) {
                ConvertLog.e(TAG, 1, "startHardwareConvert error", e16);
            }
        }
        if (this.mException != null) {
            return -1003;
        }
        if (this.mCancelled) {
            return -1002;
        }
        if (this.noNeedCompress) {
            return -1;
        }
        return 0;
    }

    private int startSoftwareConvert(String str, final VideoConverter.Processor processor) {
        int compressVideo = SoftwareConverter.compressVideo(str, new SoftwareConverter.ProcessCallBack() { // from class: com.tencent.richmedia.videocompress.VideoConverterImpl.2
            @Override // com.tencent.richmedia.videocompress.converter.SoftwareConverter.ProcessCallBack
            public VideoConverterConfig getEncodeConfig() {
                return processor.getEncodeConfig(0, 0);
            }

            @Override // com.tencent.richmedia.videocompress.converter.SoftwareConverter.ProcessCallBack
            public void onDestroy() {
                VideoConverterImpl.this.mProcess = null;
            }

            @Override // com.tencent.richmedia.videocompress.converter.SoftwareConverter.ProcessCallBack
            public void onStart(Process process) {
                VideoConverterImpl.this.mProcess = process;
            }

            @Override // com.tencent.richmedia.videocompress.converter.SoftwareConverter.ProcessCallBack
            public void onStop() {
                VideoConverterImpl.this.mProcess = null;
            }
        });
        try {
            Process process = this.mProcess;
            if (process != null) {
                process.destroy();
                this.mProcess = null;
            }
        } catch (Exception unused) {
        }
        return compressVideo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cancel() {
        Thread thread;
        WeakReference<Thread> weakReference = this.mThreadRef;
        if (weakReference != null && (thread = weakReference.get()) != null) {
            thread.interrupt();
        }
        Process process = this.mProcess;
        if (process != null) {
            process.destroy();
            return true;
        }
        return true;
    }

    public int executeFFmpegCmd(List<String> list) {
        return SoftwareConverter.executeFFmpegCmd(list, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCompressMode(int i3) {
        this.compressMode = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFFmpegBinAndSoPath(String str, String str2, boolean z16) {
        SoftwareConverter.setFFmpegBinAndSoPath(str, str2);
        if (z16) {
            loadFFmpegSo(str2);
            new File(str).setExecutable(true);
        }
    }

    public void setOutPutVideoCodecMIMEType(String str) {
        mOutPutVideoCodecMIMEType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int start(Context context, String str, VideoConverter.Processor processor, boolean z16) {
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        boolean z26;
        if (!this.running) {
            boolean z27 = true;
            this.running = true;
            int i16 = this.compressMode;
            int checkSupportMediaCodecFeature = MediaCodecSupport.checkSupportMediaCodecFeature(context);
            if ((checkSupportMediaCodecFeature & 1) > 0 && (checkSupportMediaCodecFeature & 2) > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            int i17 = this.compressMode;
            if ((i17 == 1 || i17 == 5) && !z17) {
                return -6;
            }
            if (i17 != 3 && i17 != 1 && i17 != 5) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z17 && z18) {
                if (i17 == 5) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                i3 = startHardwareConvert(str, processor, z16, z26);
            } else {
                i3 = -5;
            }
            boolean supportCodec = SoftwareConverter.supportCodec();
            if (!z17 && this.compressMode == 3) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (this.compressMode != 2 && !z19) {
                z27 = false;
            }
            if (supportCodec && z27) {
                return startSoftwareConvert(str, processor);
            }
            return i3;
        }
        return -4;
    }
}
