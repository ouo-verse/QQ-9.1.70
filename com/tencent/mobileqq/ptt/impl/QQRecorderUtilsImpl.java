package com.tencent.mobileqq.ptt.impl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.QQRecorder;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.an;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQRecorderUtilsImpl implements IQQRecorderUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQRecorderUtilsImpl";
    static int[] frameSize;
    private String lastRecorderPath;
    private int readLength;
    private final boolean useSecond;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            frameSize = new int[]{13, 14, 16, 18, 20, 21, 27, 32};
        }
    }

    public QQRecorderUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lastRecorderPath = null;
        this.readLength = -1;
        this.useSecond = true;
    }

    private int getFrameLengthPerRead() {
        int i3 = this.readLength;
        if (i3 > -1) {
            return i3;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_audio_record.name());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFrameLengthPerRead | dpc config = " + featureValue);
        }
        this.readLength = 800;
        if (!TextUtils.isEmpty(featureValue)) {
            try {
                String[] split = featureValue.split("\\|");
                if (split.length > 4) {
                    this.readLength = Integer.parseInt(split[4]);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getFrameLengthPerRead error.", e16);
                }
            }
        }
        if (this.readLength == -1) {
            this.readLength = 800;
        }
        return this.readLength;
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public int bytesInMillisecond(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        return bytesInSecond(i3, i16, i17) / 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int bytesInSecond(int i3, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        if (i16 != 2) {
            if (i16 != 3) {
                if (i16 != 4) {
                    if (i16 != 12) {
                        if (i16 != 16) {
                            throw new RuntimeException("channel Illegal");
                        }
                    }
                }
            }
            i18 = 2;
            if (i17 != 2) {
                i19 = 2;
            } else if (i17 != 3) {
                throw new RuntimeException("format Illegal");
            }
            return i3 * i19 * i18;
        }
        i18 = 1;
        if (i17 != 2) {
        }
        return i3 * i19 * i18;
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public boolean checkExternalStorageForRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        try {
            if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e16) {
            String externalStorageState = Environment.getExternalStorageState();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16, "getExternalStorageState: ", externalStorageState);
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public boolean checkIntenalStorageForRecord(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, i3)).booleanValue();
        }
        if (i3 == 0) {
            if (!AmrInputStreamWrapper.e() && FileUtils.getAvailableInnernalMemorySize() <= 327680.0f) {
                return false;
            }
            return true;
        }
        if (!SilkCodecWrapper.h() && FileUtils.getAvailableInnernalMemorySize() <= 1310720.0f) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public d createQQRecorder(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return new QQRecorder(context);
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public int dsToIs(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Double.valueOf(d16))).intValue();
        }
        if (d16 <= 0.5d && d16 > 0.0d) {
            d16 += 0.5d;
        }
        return (int) (d16 + 0.5d);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7 A[Catch: Exception -> 0x00ba, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ba, blocks: (B:55:0x00b2, B:50:0x00b7), top: B:54:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getFilePlayTime(String str) {
        DataInputStream dataInputStream;
        FileInputStream fileInputStream;
        Exception e16;
        double d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e17) {
            fileInputStream = null;
            e16 = e17;
            dataInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            if (fileInputStream2 != null) {
            }
            if (dataInputStream != null) {
            }
            throw th;
        }
        try {
            dataInputStream = new DataInputStream(fileInputStream);
        } catch (Exception e18) {
            e16 = e18;
            dataInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            dataInputStream = null;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
            }
            if (dataInputStream != null) {
            }
            throw th;
        }
        try {
            try {
                int available = fileInputStream.available();
                byte[] bArr = new byte[10];
                if (dataInputStream.read(bArr) == 10) {
                    if (QQAudioUtils.h(bArr)) {
                        d16 = QQAudioUtils.e(bArr[0], dataInputStream) / 1000.0d;
                    } else {
                        d16 = ((available - 6.0d) / frameSize[(byte) (((byte) (bArr[6] >> 3)) & 7)]) / 50.0d;
                    }
                    dataInputStream.close();
                    fileInputStream.close();
                    dataInputStream = null;
                } else {
                    d16 = 0.0d;
                    fileInputStream2 = fileInputStream;
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                return dsToIs(d16);
            } catch (Throwable th7) {
                th = th7;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused2) {
                        throw th;
                    }
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Exception e19) {
            e16 = e19;
            QLog.e(TAG, 1, "getFilePlayTime catch exception\n" + Log.getStackTraceString(e16));
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                    return 0;
                }
            }
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public String getLastRecorderPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.lastRecorderPath;
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public double getMillisecond(int i3, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Double) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3))).doubleValue();
        }
        if (j3 <= 0) {
            return 0.0d;
        }
        return j3 / bytesInMillisecond(i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public int getPttRecordTime(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Double.valueOf(d16))).intValue();
        }
        return ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).msToSec(d16);
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public int getPttShowTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public RecordParams.RecorderParam getRecorderParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RecordParams.RecorderParam) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return new RecordParams.RecorderParam(RecordParams.f307250a, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Byte> getSampleWaveData(String str, int i3) {
        String str2;
        FileInputStream fileInputStream;
        int[] iArr;
        int i16;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
        }
        FileInputStream fileInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int frameLengthPerRead = getFrameLengthPerRead();
        boolean isColorLevel = QLog.isColorLevel();
        String str4 = TAG;
        if (isColorLevel) {
            QLog.d(TAG, 2, "getSampleWaveData curRecorderPath: " + str + ", frameLengthPerRead = " + frameLengthPerRead);
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                iArr = new int[255];
                byte[] bArr = new byte[frameLengthPerRead];
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i26 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr, i17, frameLengthPerRead);
                    if (read == -1) {
                        break;
                    }
                    int b16 = (int) AudioHelper.b(BaseApplication.getContext(), bArr, read, 1.0f);
                    String str5 = str4;
                    int i27 = i18;
                    int i28 = frameLengthPerRead;
                    byte[] bArr2 = bArr;
                    int i29 = i19;
                    try {
                        int millisecond = (int) (i26 + ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getMillisecond(i3, 2, 2, read));
                        int max = Math.max(b16, i27);
                        if (millisecond >= 100) {
                            iArr[i29] = max;
                            if (i29 < 254) {
                                i19 = i29 + 1;
                            } else {
                                i19 = i29;
                            }
                            i18 = 0;
                            i26 = 0;
                        } else {
                            i19 = i29;
                            i26 = millisecond;
                            i18 = max;
                        }
                        frameLengthPerRead = i28;
                        bArr = bArr2;
                        str4 = str5;
                        i17 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        str2 = str5;
                        try {
                            QLog.w(str2, 2, "getSampleWaveData Exception: ", th);
                            if (fileInputStream2 != null) {
                            }
                            return new ArrayList<>();
                        } finally {
                        }
                    }
                }
                i16 = i19;
                str3 = str4;
            } catch (Throwable th6) {
                th = th6;
                str2 = str4;
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = TAG;
        }
        if (i16 >= 0) {
            try {
                ArrayList<Byte> a16 = an.a(iArr, i16);
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                    QLog.w(str3, 2, "getSampleWaveData Exception: ", e16);
                }
                return a16;
            } catch (Throwable th8) {
                th = th8;
                str2 = str3;
                fileInputStream2 = fileInputStream;
                QLog.w(str2, 2, "getSampleWaveData Exception: ", th);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e17) {
                        QLog.w(str2, 2, "getSampleWaveData Exception: ", e17);
                    }
                }
                return new ArrayList<>();
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException e18) {
            QLog.w(str3, 2, "getSampleWaveData Exception: ", e18);
        }
        return new ArrayList<>();
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public int msToSec(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16))).intValue();
        }
        return dsToIs(d16 / 1000.0d);
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public void setLastRecorderPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.lastRecorderPath = str;
        }
    }

    @Override // com.tencent.mobileqq.ptt.IQQRecorderUtils
    public int bytesInSecond(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? bytesInSecond(i3, 2, 2) : ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
    }
}
