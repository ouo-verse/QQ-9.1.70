package com.tencent.tavsticker.core;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVResourceType;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerAudioResource;
import com.tencent.tavsticker.model.TAVStickerResource;
import com.tencent.tavsticker.utils.FileIoUtils;
import com.tencent.tavsticker.utils.ThreadPoolManager;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerResourceExporter {
    private static final String ERROR_MSG_CREATE_FILE_FAILED = "\u521b\u5efa\u6587\u4ef6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u6743\u9650\u8bbe\u7f6e\u3002";
    private static final String ERROR_MSG_DUPLICATE_EXPORT = "\u6b63\u5728\u5bfc\u51fa\uff0c\u8bf7\u4e0d\u8981\u91cd\u590d\u64cd\u4f5c\u3002";
    private static final String ERROR_MSG_EXPORT_PATH_EMPTY = "\u5bfc\u51fa\u6587\u4ef6\u8def\u5f84\u4e3a\u7a7a\u3002";
    private static final String ERROR_MSG_EXPORT_PATH_INVALID = "\u5bfc\u51fa\u6587\u4ef6\u8def\u5f84\u65e0\u6548\u3002";
    private static final String ERROR_MSG_ILLEGAL_PARAMETER = "\u53c2\u6570\u9519\u8bef\u3002";
    private static final String ERROR_MSG_NO_DATA = "\u6ca1\u6709\u6570\u636e\u3002";
    private static final String TAG = "TAVStickerResourceExporter";
    private List<String> exports;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tavsticker.core.TAVStickerResourceExporter$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tavsticker$model$TAVResourceType;

        static {
            int[] iArr = new int[TAVResourceType.values().length];
            $SwitchMap$com$tencent$tavsticker$model$TAVResourceType = iArr;
            try {
                iArr[TAVResourceType.AUDIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tavsticker$model$TAVResourceType[TAVResourceType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$tavsticker$model$TAVResourceType[TAVResourceType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$tavsticker$model$TAVResourceType[TAVResourceType.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IStickerResourceExportListener {
        void exporting(TAVStickerResource tAVStickerResource, float f16);

        void failed(String str, String str2);

        void start(TAVStickerResource tAVStickerResource);

        void succeed(TAVStickerResource tAVStickerResource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ResourceExportTask implements Runnable {
        public static final int BUFFER_SIZE = 8192;
        private IStickerResourceExportListener exportListener;
        private TAVStickerResource exportResource;

        public ResourceExportTask(TAVStickerResource tAVStickerResource, IStickerResourceExportListener iStickerResourceExportListener) {
            this.exportResource = tAVStickerResource;
            this.exportListener = iStickerResourceExportListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            TAVStickerResource tAVStickerResource = this.exportResource;
            if (tAVStickerResource != null && tAVStickerResource.getByteBuffer() != null) {
                ByteBuffer byteBuffer = this.exportResource.getByteBuffer();
                int capacity = byteBuffer.capacity();
                if (capacity > 0) {
                    int i3 = 0;
                    byteBuffer.position(0);
                    while (i3 < capacity) {
                        int i16 = capacity - i3;
                        if (i16 > 8192) {
                            bArr = new byte[8192];
                        } else {
                            bArr = new byte[i16];
                        }
                        byteBuffer.get(bArr);
                        int position = byteBuffer.position();
                        FileIoUtils.writeFileFromBytesByStream(this.exportResource.getFilePath(), bArr, true);
                        if (this.exportListener != null) {
                            float f16 = (position * 1.0f) / capacity;
                            TLog.d(TAVStickerResourceExporter.TAG, "pos : " + position + ", size : " + capacity + ", progress : " + f16 + ", ThreadId : " + Thread.currentThread().getId());
                            this.exportListener.exporting(this.exportResource, f16);
                            if (position == capacity) {
                                this.exportListener.succeed(this.exportResource);
                                TAVStickerResourceExporter.this.exports.remove(this.exportResource.getFilePath());
                            }
                        }
                        i3 = position;
                    }
                    return;
                }
                IStickerResourceExportListener iStickerResourceExportListener = this.exportListener;
                if (iStickerResourceExportListener != null) {
                    iStickerResourceExportListener.failed(this.exportResource.getFilePath(), TAVStickerResourceExporter.ERROR_MSG_NO_DATA);
                    TAVStickerResourceExporter.this.exports.remove(this.exportResource.getFilePath());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class SingletonHolder {
        private static final TAVStickerResourceExporter INSTANCE = new TAVStickerResourceExporter(null);

        SingletonHolder() {
        }
    }

    /* synthetic */ TAVStickerResourceExporter(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean checkExportFilePath(String str, IStickerResourceExportListener iStickerResourceExportListener) {
        if (TextUtils.isEmpty(str)) {
            notifyExportFailed(str, iStickerResourceExportListener, ERROR_MSG_EXPORT_PATH_EMPTY);
            return false;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            notifyExportFailed(str, iStickerResourceExportListener, ERROR_MSG_EXPORT_PATH_INVALID);
            return false;
        }
        if (file.isFile() && file.exists()) {
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            notifyExportFailed(str, iStickerResourceExportListener, ERROR_MSG_CREATE_FILE_FAILED);
            return false;
        }
    }

    public static TAVStickerResourceExporter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private TAVStickerResource getStickerResource(TAVSticker tAVSticker, TAVResourceType tAVResourceType, String str) {
        if (tAVSticker == null || AnonymousClass1.$SwitchMap$com$tencent$tavsticker$model$TAVResourceType[tAVResourceType.ordinal()] != 1) {
            return null;
        }
        return new TAVStickerAudioResource(TAVResourceType.AUDIO, str, tAVSticker.getAudioData(), new CMTime(tAVSticker.getAudioStartTime()));
    }

    private void notifyExportFailed(String str, IStickerResourceExportListener iStickerResourceExportListener, String str2) {
        if (iStickerResourceExportListener != null) {
            iStickerResourceExportListener.failed(str, str2);
        }
    }

    public synchronized void export(TAVSticker tAVSticker, TAVResourceType tAVResourceType, String str, IStickerResourceExportListener iStickerResourceExportListener) {
        if (this.exports.contains(str)) {
            notifyExportFailed(str, iStickerResourceExportListener, ERROR_MSG_DUPLICATE_EXPORT);
            return;
        }
        if (tAVSticker != null && !TextUtils.isEmpty(str)) {
            if (checkExportFilePath(str, iStickerResourceExportListener)) {
                TAVStickerResource stickerResource = getStickerResource(tAVSticker, tAVResourceType, str);
                if (stickerResource != null && stickerResource.getByteBuffer() != null) {
                    if (iStickerResourceExportListener != null) {
                        iStickerResourceExportListener.start(stickerResource);
                    }
                    this.exports.add(str);
                    ThreadPoolManager.get().start(new ResourceExportTask(stickerResource, iStickerResourceExportListener));
                } else {
                    notifyExportFailed(str, iStickerResourceExportListener, ERROR_MSG_NO_DATA);
                    new File(str).delete();
                }
            }
        } else {
            notifyExportFailed(str, iStickerResourceExportListener, ERROR_MSG_ILLEGAL_PARAMETER);
        }
    }

    public synchronized void exportAudioData(TAVSticker tAVSticker, String str, IStickerResourceExportListener iStickerResourceExportListener) {
        export(tAVSticker, TAVResourceType.AUDIO, str, iStickerResourceExportListener);
    }

    TAVStickerResourceExporter() {
        this.exports = new ArrayList();
    }
}
