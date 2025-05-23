package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class EncodeThread implements MaxVideoConst, Runnable {
    public static final String KEY_BACKGROUND_MUSIC_OFFSET = "key_background_music_offset";
    public static final String KEY_BACKGROUND_MUSIC_PATH = "key_background_music_path";
    public static final String KEY_DOODLE_PATH = "key_doodle_path";
    public static final String KEY_LOCAL_RAW_VIDEO_DIR = "key_local_raw_video_dir";
    public static final String KEY_VIDEO_HEIGHT = "key_video_height";
    public static final String KEY_VIDEO_WIDTH = "key_video_width";
    public int errorCode;
    private long mAudioEncodeEndTime;
    private long mAudioEncodeStartTime;
    private boolean mEnableBaselineMp4Encode;
    private boolean mEnableClearAudioData;
    private boolean mEnableDeleteCache;
    private boolean mEnableHardEncode;
    private PublishVideoEntry mEntry;
    private boolean mGenerateGif;
    private Handler mHandler;
    private byte[] mMosaicMask;
    private int mMosaicSize;
    protected boolean mMuteVoice;
    private int mOrientationDegree;
    private String mSourceDirString;
    public String mTargetFilePath;
    private long mVideoEncodeEndFrame;
    private long mVideoEncodeStartFrame;
    private String targetKey;
    private EncodeVideo videoEncode;

    public EncodeThread(Context context, Handler handler, String str, String str2, String str3) {
        this.mEnableDeleteCache = true;
        this.mEnableClearAudioData = false;
        this.mMosaicMask = null;
        this.mMosaicSize = 0;
        this.mVideoEncodeStartFrame = -1L;
        this.mVideoEncodeEndFrame = -1L;
        this.mAudioEncodeStartTime = -1L;
        this.mAudioEncodeEndTime = -1L;
        this.mHandler = handler;
        this.mSourceDirString = str;
        this.targetKey = str3;
        this.videoEncode = new EncodeVideo(handler);
        this.mTargetFilePath = str2;
        this.mEnableHardEncode = true;
        this.mEnableDeleteCache = true;
        this.mEnableClearAudioData = false;
        this.mEnableBaselineMp4Encode = false;
    }

    public static void cancelCurrentEncoder() {
        try {
            EncodeVideo.cancelCurrentEncoder();
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private void doNotify(Message message) {
        Handler handler = this.mHandler;
        if (handler != null) {
            try {
                handler.sendMessage(message);
            } catch (Exception unused) {
            }
        }
    }

    private void notifyEncodeBegin() {
        if (this.mHandler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        doNotify(obtain);
    }

    private void notifyEncodeEnd(int i3, String str) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i3;
        obtain.getData().putString(MaxVideoConst.TAG_FILE_MP4, str);
        obtain.getData().putString("source_path", this.mSourceDirString);
        obtain.getData().putString("client_key", this.targetKey);
        if (i3 == 0 && this.mEntry != null) {
            obtain.getData().putString(KEY_BACKGROUND_MUSIC_PATH, this.mEntry.backgroundMusicPath);
            obtain.getData().putInt(KEY_BACKGROUND_MUSIC_OFFSET, this.mEntry.backgroundMusicOffset);
            obtain.getData().putString(KEY_DOODLE_PATH, this.mEntry.doodlePath);
            obtain.getData().putString(KEY_LOCAL_RAW_VIDEO_DIR, this.mEntry.mLocalRawVideoDir);
            obtain.getData().putInt("key_video_width", this.mEntry.videoWidth);
            obtain.getData().putInt("key_video_height", this.mEntry.videoHeight);
        }
        doNotify(obtain);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int startEncode(String str, String str2, String str3, String str4) {
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16 = this.mEnableBaselineMp4Encode;
        if (z16) {
            CodecParam.setEnableBaseLineMp4Flag(z16);
        }
        int[] configParam = CodecParam.getConfigParam();
        CodecParam.setEnableBaseLineMp4Flag(false);
        byte[] bArr = this.mMosaicMask;
        if (bArr != null && (i18 = this.mMosaicSize) != 0) {
            EncodeVideo.setMosaicData(bArr, i18);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            i3 = 0;
            try {
                i16 = this.videoEncode.startPartEncode(str, this.mVideoEncodeStartFrame, this.mVideoEncodeEndFrame, str2, this.mAudioEncodeStartTime, this.mAudioEncodeEndTime, str3, str4, configParam);
            } catch (UnsatisfiedLinkError e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.e("startPartEncode", 2, "exception:", e);
                }
                i16 = -200;
                id0.a.k("take_video", "create_mp4_result", i3, i16, new String[i3]);
                if (i16 == 0) {
                }
                CodecParam.mSaveMode = i3;
                CodecParam.mCRFValue = 23;
                i17 = i3;
                if (this.mMosaicMask != null) {
                    EncodeVideo.setMosaicData(null, i17);
                }
                return i16;
            }
        } catch (UnsatisfiedLinkError e17) {
            e = e17;
            i3 = 0;
        }
        id0.a.k("take_video", "create_mp4_result", i3, i16, new String[i3]);
        if (i16 == 0) {
            String[] strArr = new String[1];
            strArr[i3] = "" + (SystemClock.uptimeMillis() - uptimeMillis);
            id0.a.k("take_video", "create_mp4_time", i3, i3, strArr);
        }
        CodecParam.mSaveMode = i3;
        CodecParam.mCRFValue = 23;
        i17 = i3;
        if (this.mMosaicMask != null && this.mMosaicSize != 0) {
            EncodeVideo.setMosaicData(null, i17);
        }
        return i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0335  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        long j3;
        String str;
        int i3;
        String str2;
        String str3;
        int i16;
        int i17;
        String str4;
        int i18;
        long currentTimeMillis = System.currentTimeMillis();
        this.errorCode = 0;
        if (TextUtils.isEmpty(this.mSourceDirString)) {
            this.errorCode = 5100;
            notifyEncodeEnd(5100, null);
            QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, "9", null);
            return;
        }
        File file = new File(this.mSourceDirString);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                this.errorCode = 5101;
                if (QLog.isColorLevel()) {
                    QLog.d(MaxVideoConst.TAG, 2, "EncodeThread empty dir, mSourceDirString = " + this.mSourceDirString);
                }
                notifyEncodeEnd(this.errorCode, null);
                QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, "9", null);
                return;
            }
            String str5 = null;
            String str6 = null;
            String str7 = null;
            for (String str8 : list) {
                if (str8.endsWith(".vf")) {
                    str5 = this.mSourceDirString + File.separator + str8;
                } else if (str8.endsWith(".af")) {
                    str6 = this.mSourceDirString + File.separator + str8;
                } else if (str8.endsWith(".ini")) {
                    str7 = this.mSourceDirString + File.separator + str8;
                }
            }
            if (FileUtils.fileExists(str5) && FileUtils.fileExists(str6) && FileUtils.fileExists(str7)) {
                if (this.mGenerateGif) {
                    String str9 = QZoneFilePath.DCIM_CAMERA_PATH;
                    String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(file);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str9);
                    String str10 = File.separator;
                    sb5.append(str10);
                    sb5.append("gif");
                    File file2 = new File(sb5.toString());
                    if (file2.exists() && !file2.isDirectory()) {
                        file2.delete();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String str11 = str9 + str10 + "gif" + str10 + vidFromSourceDirFile + QzoneEmotionUtils.SIGN_ICON_URL_END;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    int generateGifFromVFile = GifProcessor.generateGifFromVFile(str5, str6, this.mOrientationDegree, str11);
                    QLog.i(MaxVideoConst.TAG, 1, "generateGifFromVFile cost=" + (System.currentTimeMillis() - currentTimeMillis2) + " ret=" + generateGifFromVFile);
                    this.mTargetFilePath = str11;
                    if (generateGifFromVFile == 0 && this.mEnableDeleteCache) {
                        FileUtils.deleteDirectory(this.mSourceDirString);
                    }
                    if (generateGifFromVFile == 0) {
                        i18 = 0;
                    } else {
                        i18 = 5109;
                    }
                    this.errorCode = i18;
                    notifyEncodeEnd(i18, str11);
                    return;
                }
                String str12 = str6;
                if (this.mEnableClearAudioData) {
                    FileUtils.deleteFile(str12);
                    try {
                        FileUtils.createFile(str12);
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(MaxVideoConst.TAG, 2, "EncodeThread: createFile audiofile... ", e16);
                        }
                        this.errorCode = 5108;
                        notifyEncodeEnd(5108, null);
                        return;
                    }
                }
                String str13 = this.mTargetFilePath;
                if (TextUtils.isEmpty(str13)) {
                    String str14 = er2.a.c().f397063c + "/output";
                    File file3 = new File(str14);
                    if (!file3.mkdirs() && !file3.isDirectory()) {
                        this.errorCode = 5102;
                        notifyEncodeEnd(5102, null);
                        QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, "10", null);
                        return;
                    }
                    str13 = str14 + File.separator + VidUtil.getVidFromSourceDirFile(file) + ".mp4";
                    this.mTargetFilePath = str13;
                } else {
                    File parentFile = new File(str13).getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                }
                notifyEncodeBegin();
                if (this.mEnableHardEncode) {
                    com.tencent.mobileqq.shortvideo.hwcodec.a aVar = new com.tencent.mobileqq.shortvideo.hwcodec.a(str5, str12, this.mSourceDirString);
                    try {
                        i3 = aVar.l();
                    } catch (NoSuchMethodError e17) {
                        e17.printStackTrace();
                        i3 = -1;
                        if (i3 == 0) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (i3 == -1) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (i16 == 0) {
                        }
                        if (i16 != -1) {
                        }
                        i17 = this.errorCode;
                        if (i17 != 5103) {
                        }
                    } catch (UnsatisfiedLinkError e18) {
                        e18.printStackTrace();
                        i3 = -1;
                        if (i3 == 0) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (i3 == -1) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (i16 == 0) {
                        }
                        if (i16 != -1) {
                        }
                        i17 = this.errorCode;
                        if (i17 != 5103) {
                        }
                    }
                    if (i3 == 0) {
                        String c16 = aVar.c();
                        this.mTargetFilePath = c16;
                        boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(c16);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder();
                            j3 = currentTimeMillis;
                            sb6.append("EncodeThread hwEncode success, mTargetFilePath = ");
                            sb6.append(this.mTargetFilePath);
                            sb6.append(", isExist = ");
                            sb6.append(fileExistsAndNotEmpty);
                            QLog.d(MaxVideoConst.TAG, 2, sb6.toString());
                        } else {
                            j3 = currentTimeMillis;
                        }
                        StringBuilder sb7 = new StringBuilder();
                        str = str13;
                        sb7.append(yq2.a.f450986c);
                        sb7.append("");
                        QzoneVideoBeaconReport.reportVideoEvent(sb7.toString(), QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, QzoneVideoBeaconReport.KEY_ENCODE_HW_SUCCESS, "0", null);
                    } else {
                        j3 = currentTimeMillis;
                        str = str13;
                        QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, QzoneVideoBeaconReport.KEY_ENCODE_HW_SUCCESS, "1", i3 + "_" + DeviceInfoMonitor.getModel());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(MaxVideoConst.TAG, 2, "EncodeThread hwEncode serrcode = " + i3);
                    }
                } else {
                    j3 = currentTimeMillis;
                    str = str13;
                    i3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(MaxVideoConst.TAG, 2, "EncodeThread hwEncode start soft errcode = " + i3 + " mEnableHardEncode=" + this.mEnableHardEncode);
                }
                if (i3 == -1) {
                    if (this.mMuteVoice) {
                        str4 = "";
                    } else {
                        str4 = str12;
                    }
                    str3 = str7;
                    i16 = startEncode(str5, str4, str3, str);
                    QLog.i(MaxVideoConst.TAG, 1, "EncodeThread hwEncode start soft over ret = " + i16);
                    if (i16 == 0) {
                        StringBuilder sb8 = new StringBuilder();
                        str2 = MaxVideoConst.TAG;
                        sb8.append(yq2.a.f450986c);
                        sb8.append("");
                        QzoneVideoBeaconReport.reportVideoEvent(sb8.toString(), QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, QzoneVideoBeaconReport.KEY_ENCODE_SW_SUCCESS, "0", null);
                    } else {
                        str2 = MaxVideoConst.TAG;
                        QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, QzoneVideoBeaconReport.KEY_ENCODE_SW_SUCCESS, "1", i16 + "_" + DeviceInfoMonitor.getModel());
                    }
                } else {
                    str2 = MaxVideoConst.TAG;
                    str3 = str7;
                    i16 = 0;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("vfFilePath is " + str5);
                    sb9.append('\n');
                    sb9.append("afFilePath is " + str12);
                    sb9.append('\n');
                    sb9.append("manifestFilePath is " + str3);
                    sb9.append('\n');
                    sb9.append("targetFile is " + str);
                    QLog.i(str2, 2, sb9.toString());
                }
                if (i16 == 0) {
                    QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, QzoneVideoBeaconReport.KEY_ENCODE_SUCCESS, "0", null);
                } else {
                    QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, QzoneVideoBeaconReport.KEY_ENCODE_SUCCESS, "1", i16 + "_" + DeviceInfoMonitor.getModel());
                }
                if (i16 != -1) {
                    if (i16 != 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 == 4) {
                                        this.errorCode = 5107;
                                    }
                                } else {
                                    this.errorCode = 5106;
                                }
                            } else {
                                this.errorCode = 5103;
                            }
                        } else {
                            this.errorCode = 5105;
                        }
                    } else {
                        this.errorCode = 0;
                        long currentTimeMillis3 = System.currentTimeMillis();
                        QLog.i(str2, 1, "encode af vf to mp4, cost=" + (currentTimeMillis3 - j3));
                        if (this.mEnableDeleteCache) {
                            FileUtils.deleteDirectory(this.mSourceDirString);
                            QLog.i(str2, 1, "EncodeThread encode success delete cache... cost=" + (System.currentTimeMillis() - currentTimeMillis3));
                        }
                    }
                } else {
                    this.errorCode = 5104;
                }
                i17 = this.errorCode;
                if (i17 != 5103) {
                    notifyEncodeEnd(i17, str);
                    return;
                }
                return;
            }
            String str15 = str6;
            String str16 = str7;
            if (QLog.isColorLevel()) {
                QLog.d(MaxVideoConst.TAG, 2, "EncodeThread empty file, mSourceDirString = " + this.mSourceDirString + ",vfFilePath = " + str5 + ",afFilePath = " + str15 + ",manifestFilePath = " + str16);
            }
            this.errorCode = 5101;
            notifyEncodeEnd(5101, null);
            QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, "9", null);
            return;
        }
        this.errorCode = 5100;
        notifyEncodeEnd(5100, null);
        QzoneVideoBeaconReport.reportVideoEvent(yq2.a.f450986c + "", QzoneVideoBeaconReport.EVENT_VIDEO_RECORD, "9", null);
    }

    public void setEnableBaselineMp4Encode(boolean z16) {
        this.mEnableBaselineMp4Encode = z16;
    }

    public void setEnableClearAudioData(boolean z16) {
        this.mEnableClearAudioData = z16;
    }

    public void setEnableDeleteCache(boolean z16) {
        this.mEnableDeleteCache = z16;
    }

    public void setEnableHardEncode(boolean z16) {
        this.mEnableHardEncode = z16;
    }

    public void setGenerateGif(boolean z16) {
        this.mGenerateGif = z16;
    }

    public void setMosaicMask(byte[] bArr, int i3) {
        this.mMosaicMask = bArr;
        this.mMosaicSize = i3;
    }

    public void setMuteVoice(boolean z16) {
        this.mMuteVoice = z16;
    }

    public void setOrientationDegree(int i3) {
        this.mOrientationDegree = i3;
    }

    public void setPartEncodeInfo(long j3, long j16, long j17, long j18) {
        this.mVideoEncodeStartFrame = j3;
        this.mVideoEncodeEndFrame = j16;
        this.mAudioEncodeStartTime = j17;
        this.mAudioEncodeEndTime = j18;
    }

    public EncodeThread(Context context, Handler handler, String str, String str2, String str3, PublishVideoEntry publishVideoEntry) {
        this(context, handler, str, str2, str3);
        this.mEntry = publishVideoEntry;
    }
}
