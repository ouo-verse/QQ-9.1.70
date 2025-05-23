package com.tencent.qbar;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qbar.QbarNative;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QBar {
    static IPatchRedirector $redirector_ = null;
    public static final String QBAR_AI_DATA_DIR = "qbar";
    public static final String QBAR_AI_MODEL_COPY_VERSION = "qbar_ai_model_copy_version";
    public static final String QBAR_AI_MODEL_VERSION = "qbar_ai_model_version";
    public static final int QBAR_AI_MODEL_VERSION_CODE = 101;
    public static final String QBAR_AI_PREFERENCE = "qbar_ai_preference_file";
    protected QbarNative qBarNative;
    protected int qbarId;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class QBarResult {
        static IPatchRedirector $redirector_;
        public String charset;
        public String data;
        public int priorityLevel;
        public byte[] rawData;
        public int typeID;
        public String typeName;

        public QBarResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public QBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.qbarId = -1;
            this.qBarNative = new QbarNative();
        }
    }

    public static Bitmap encode(String str, int i3, int i16, int i17, int i18, String str2, int i19) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        if (QbarNative.EncodeBitmap(str, createBitmap, i3, i16, i17, i18, str2, i19) > 0) {
            return createBitmap;
        }
        return null;
    }

    public static String getVersion() {
        return QbarNative.GetVersion();
    }

    public int GetCodeDetectInfo(int i3, List<QbarNative.QBarCodeDetectInfo> list, List<QbarNative.QBarPoint> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), list, list2)).intValue();
        }
        synchronized (this) {
            if (i3 > 0) {
                if (this.qbarId >= 0) {
                    QbarNative.QBarCodeDetectInfo[] qBarCodeDetectInfoArr = new QbarNative.QBarCodeDetectInfo[i3];
                    QbarNative.QBarPoint[] qBarPointArr = new QbarNative.QBarPoint[i3];
                    for (int i16 = 0; i16 < i3; i16++) {
                        qBarCodeDetectInfoArr[i16] = new QbarNative.QBarCodeDetectInfo();
                        qBarPointArr[i16] = new QbarNative.QBarPoint();
                    }
                    list.clear();
                    list2.clear();
                    this.qBarNative.GetCodeDetectInfo(qBarCodeDetectInfoArr, qBarPointArr, this.qbarId);
                    for (int i17 = 0; i17 < i3; i17++) {
                        QbarNative.QBarCodeDetectInfo qBarCodeDetectInfo = qBarCodeDetectInfoArr[i17];
                        if (qBarCodeDetectInfo.readerId > 0) {
                            list.add(qBarCodeDetectInfo);
                        }
                    }
                    for (int i18 = 0; i18 < i3; i18++) {
                        QbarNative.QBarPoint qBarPoint = qBarPointArr[i18];
                        if (qBarPoint.point_cnt != 0) {
                            list2.add(qBarPoint);
                        }
                    }
                    return list.size();
                }
            }
            return 0;
        }
    }

    public int GetOneResult(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, str2, str3)).intValue();
        }
        synchronized (this) {
            int i3 = this.qbarId;
            if (i3 < 0) {
                return -1;
            }
            byte[] bArr = new byte[100];
            byte[] bArr2 = new byte[3000];
            byte[] bArr3 = new byte[100];
            int[] iArr = new int[4];
            int GetOneResult = this.qBarNative.GetOneResult(bArr, bArr2, bArr3, iArr, i3);
            try {
                String str4 = new String(bArr3, 0, iArr[2], "UTF-8");
                if (str4.equals("ANY")) {
                    new String(bArr, 0, iArr[0], "UTF-8");
                    new String(bArr2, 0, iArr[1], "UTF-8");
                } else {
                    new String(bArr, 0, iArr[0], str4);
                    new String(bArr2, 0, iArr[1], str4);
                }
            } catch (UnsupportedEncodingException unused) {
            }
            return GetOneResult;
        }
    }

    public List<QBarResult> GetResults(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        synchronized (this) {
            if (this.qbarId >= 0 && i3 > 0) {
                QbarNative.QBarResultJNI[] qBarResultJNIArr = new QbarNative.QBarResultJNI[i3];
                for (int i16 = 0; i16 < i3; i16++) {
                    QbarNative.QBarResultJNI qBarResultJNI = new QbarNative.QBarResultJNI();
                    qBarResultJNIArr[i16] = qBarResultJNI;
                    qBarResultJNI.charset = new String();
                    QbarNative.QBarResultJNI qBarResultJNI2 = qBarResultJNIArr[i16];
                    qBarResultJNI2.data = new byte[1024];
                    qBarResultJNI2.typeName = new String();
                }
                this.qBarNative.GetResults(qBarResultJNIArr, this.qbarId);
                ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < i3; i17++) {
                    try {
                        QbarNative.QBarResultJNI qBarResultJNI3 = qBarResultJNIArr[i17];
                        String str = qBarResultJNI3.typeName;
                        if (str != null && !str.isEmpty()) {
                            QBarResult qBarResult = new QBarResult();
                            String str2 = qBarResultJNI3.charset;
                            qBarResult.charset = str2;
                            qBarResult.typeID = qBarResultJNI3.typeID;
                            qBarResult.typeName = qBarResultJNI3.typeName;
                            qBarResult.rawData = qBarResultJNI3.data;
                            if (str2.equals("ANY")) {
                                qBarResult.data = new String(qBarResultJNI3.data, "UTF-8");
                            } else {
                                qBarResult.data = new String(qBarResultJNI3.data, qBarResult.charset);
                            }
                            arrayList.add(qBarResult);
                        }
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return arrayList;
            }
            return null;
        }
    }

    public QbarNative.QBarZoomInfo GetZoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QbarNative.QBarZoomInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        synchronized (this) {
            if (this.qbarId < 0) {
                return null;
            }
            QbarNative.QBarZoomInfo qBarZoomInfo = new QbarNative.QBarZoomInfo();
            this.qBarNative.GetZoomInfo(qBarZoomInfo, this.qbarId);
            return qBarZoomInfo;
        }
    }

    public int init(int i3, int i16, String str, String str2, QbarNative.QbarAiModelParam qbarAiModelParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, qbarAiModelParam)).intValue();
        }
        synchronized (this) {
            if (this.qbarId < 0) {
                this.qbarId = this.qBarNative.init(i3, i16, str, str2, qbarAiModelParam);
            }
            System.out.println("qbarId:" + this.qbarId);
            if (this.qbarId >= 0) {
                return 0;
            }
            return -1;
        }
    }

    public int release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        synchronized (this) {
            if (this.qbarId < 0) {
                return 0;
            }
            int release = this.qBarNative.release();
            this.qbarId = -1;
            return release;
        }
    }

    public int scanImage(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        synchronized (this) {
            if (this.qbarId < 0) {
                return -1;
            }
            return this.qBarNative.scanImage(bArr, i3, i16);
        }
    }

    public int setReaders(int[] iArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iArr, i3)).intValue();
        }
        synchronized (this) {
            if (this.qbarId < 0) {
                return -1;
            }
            return this.qBarNative.setReaders(iArr, i3);
        }
    }

    public static int encode(byte[] bArr, int[] iArr, String str, int i3, int i16, String str2, int i17) {
        return QbarNative.Encode(bArr, iArr, str, i3, i16, str2, i17);
    }

    public int GetResults(int i3, List<QBarResult> list, List<QbarNative.QBarPoint> list2, List<QbarNative.QBarReportMsg> list3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), list, list2, list3)).intValue();
        }
        if (i3 <= 0) {
            return 0;
        }
        QbarNative.QBarResultJNI[] qBarResultJNIArr = new QbarNative.QBarResultJNI[i3];
        QbarNative.QBarPoint[] qBarPointArr = new QbarNative.QBarPoint[i3];
        QbarNative.QBarReportMsg[] qBarReportMsgArr = new QbarNative.QBarReportMsg[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            QbarNative.QBarResultJNI qBarResultJNI = new QbarNative.QBarResultJNI();
            qBarResultJNIArr[i16] = qBarResultJNI;
            qBarResultJNI.charset = new String();
            QbarNative.QBarResultJNI qBarResultJNI2 = qBarResultJNIArr[i16];
            qBarResultJNI2.data = new byte[1024];
            qBarResultJNI2.typeName = new String();
            qBarResultJNIArr[i16].points = new QbarNative.QBarPoint();
            qBarPointArr[i16] = new QbarNative.QBarPoint();
            qBarReportMsgArr[i16] = new QbarNative.QBarReportMsg();
        }
        synchronized (this) {
            int i17 = this.qbarId;
            if (i17 < 0) {
                return 0;
            }
            this.qBarNative.GetResults(qBarResultJNIArr, i17);
            for (int i18 = 0; i18 < i3; i18++) {
                try {
                    QbarNative.QBarResultJNI qBarResultJNI3 = qBarResultJNIArr[i18];
                    if (qBarResultJNI3.typeName != null) {
                        QBarResult qBarResult = new QBarResult();
                        String str = qBarResultJNI3.charset;
                        qBarResult.charset = str;
                        qBarResult.typeID = qBarResultJNI3.typeID;
                        qBarResult.typeName = qBarResultJNI3.typeName;
                        qBarResult.rawData = qBarResultJNI3.data;
                        if (str.equals("ANY")) {
                            String str2 = new String(qBarResultJNI3.data, "UTF-8");
                            qBarResult.data = str2;
                            if (str2.length() == 0) {
                                qBarResult.data = new String(qBarResultJNI3.data, "ASCII");
                            }
                        } else {
                            qBarResult.data = new String(qBarResultJNI3.data, qBarResult.charset);
                        }
                        list.add(qBarResult);
                    }
                } catch (UnsupportedEncodingException unused) {
                }
            }
            if (list2 != null) {
                for (int i19 = 0; i19 < i3; i19++) {
                    QbarNative.QBarPoint qBarPoint = qBarResultJNIArr[i19].points;
                    if (qBarPoint.point_cnt != 0) {
                        list2.add(qBarPoint);
                    }
                }
            }
            if (list3 != null) {
                Collections.addAll(list3, qBarReportMsgArr);
            }
            return list.size();
        }
    }
}
