package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m {

    /* renamed from: e, reason: collision with root package name */
    public g f198207e;

    /* renamed from: f, reason: collision with root package name */
    public o f198208f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.mobileqq.ocr.data.a f198209g;

    /* renamed from: h, reason: collision with root package name */
    public h f198210h;

    /* renamed from: i, reason: collision with root package name */
    public al f198211i;

    /* renamed from: j, reason: collision with root package name */
    public ac f198212j;

    /* renamed from: k, reason: collision with root package name */
    public t f198213k;

    /* renamed from: l, reason: collision with root package name */
    public TranslateResult f198214l;

    /* renamed from: a, reason: collision with root package name */
    public String f198203a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f198204b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f198205c = -1;

    /* renamed from: d, reason: collision with root package name */
    public d f198206d = null;

    /* renamed from: m, reason: collision with root package name */
    public long f198215m = 0;

    public static String a(ArrayList<ARRecognition> arrayList, m mVar) {
        String str = "";
        if (mVar == null) {
            return "";
        }
        long j3 = ARRecognition.c(arrayList, mVar).f196964a;
        if (j3 == 1) {
            str = mVar.f198206d.f198161i[0].f198165a;
        } else if (j3 == 2) {
            str = mVar.f198207e.f198180i[0].f198184a;
        } else if (j3 == 2048) {
            str = mVar.f198213k.f198267i[0].f198271a;
        } else if (j3 == 128) {
            str = mVar.f198212j.f198001o;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + str);
        return str;
    }

    public static ArLBSActivity b(ArrayList<ARRecognition> arrayList, m mVar) {
        ArCloudConfigInfo arCloudConfigInfo;
        ArCloudConfigInfo arCloudConfigInfo2;
        ArCloudConfigInfo arCloudConfigInfo3;
        ArCloudConfigInfo arCloudConfigInfo4;
        ArLBSActivity arLBSActivity = null;
        if (mVar == null) {
            return null;
        }
        long j3 = ARRecognition.c(arrayList, mVar).f196964a;
        if (j3 == 1) {
            d dVar = mVar.f198206d;
            if (dVar.f198216a) {
                try {
                    arCloudConfigInfo4 = c.a(new String(dVar.f198161i[0].f198171g, "utf-8"));
                } catch (Exception e16) {
                    QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + e16.getMessage());
                    arCloudConfigInfo4 = null;
                }
                if (arCloudConfigInfo4 != null) {
                    arLBSActivity = arCloudConfigInfo4.L;
                }
            }
        } else if (j3 == 2) {
            g gVar = mVar.f198207e;
            if (gVar.f198216a) {
                try {
                    arCloudConfigInfo3 = c.a(new String(gVar.f198180i[0].f198190g, "utf-8"));
                } catch (Exception e17) {
                    QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + e17.getMessage());
                    arCloudConfigInfo3 = null;
                }
                if (arCloudConfigInfo3 != null) {
                    arLBSActivity = arCloudConfigInfo3.L;
                }
            }
        } else if (j3 == 128) {
            ac acVar = mVar.f198212j;
            if (acVar.f198216a) {
                try {
                    arCloudConfigInfo2 = c.a(new String(acVar.a(), "utf-8"));
                } catch (Exception e18) {
                    QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + e18.getMessage());
                    arCloudConfigInfo2 = null;
                }
                if (arCloudConfigInfo2 != null) {
                    arLBSActivity = arCloudConfigInfo2.L;
                }
            }
        } else if (j3 == 2048) {
            t tVar = mVar.f198213k;
            if (tVar.f198216a) {
                try {
                    arCloudConfigInfo = c.a(new String(tVar.f198267i[0].f198277g, "utf-8"));
                } catch (Exception e19) {
                    QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + e19.getMessage());
                    arCloudConfigInfo = null;
                }
                if (arCloudConfigInfo != null) {
                    arLBSActivity = arCloudConfigInfo.L;
                }
            }
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + arLBSActivity);
        return arLBSActivity;
    }

    public static b c(ArrayList<ARRecognition> arrayList, m mVar) {
        b bVar = new b();
        if (mVar == null) {
            return bVar;
        }
        long j3 = ARRecognition.c(arrayList, mVar).f196964a;
        if (j3 == 1) {
            d dVar = mVar.f198206d;
            if (dVar.f198216a) {
                bVar = dVar.f198217b;
            }
        } else if (j3 == 2) {
            g gVar = mVar.f198207e;
            if (gVar.f198216a) {
                bVar = gVar.f198217b;
            }
        } else if (j3 == 128) {
            ac acVar = mVar.f198212j;
            if (acVar.f198216a) {
                bVar = acVar.f198217b;
            }
        } else if (j3 == 2048) {
            t tVar = mVar.f198213k;
            if (tVar.f198216a) {
                bVar = tVar.f198217b;
            }
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + bVar.f198147a);
        return bVar;
    }

    public static boolean d(ArrayList<ARRecognition> arrayList, m mVar) {
        boolean z16 = false;
        if (mVar == null) {
            return false;
        }
        long j3 = ARRecognition.c(arrayList, mVar).f196964a;
        if (j3 == 1) {
            z16 = mVar.f198206d.f198216a;
        } else if (j3 == 2) {
            z16 = mVar.f198207e.f198216a;
        } else if (j3 == 128) {
            z16 = mVar.f198212j.f198216a;
        } else if (j3 == 2048) {
            z16 = mVar.f198213k.f198216a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + z16);
        return z16;
    }

    public static void e(ArrayList<ARRecognition> arrayList, m mVar, b bVar) {
        if (mVar == null) {
            return;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + bVar.f198147a);
        long j3 = ARRecognition.c(arrayList, mVar).f196964a;
        if (j3 == 1) {
            mVar.f198206d.f198217b = bVar;
            return;
        }
        if (j3 == 2) {
            mVar.f198207e.f198217b = bVar;
        } else if (j3 == 128) {
            mVar.f198212j.f198217b = bVar;
        } else if (j3 == 2048) {
            mVar.f198213k.f198217b = bVar;
        }
    }

    public String toString() {
        return "ARCloudRecogResult{, sessionId = " + this.f198203a + ", recogType = " + this.f198204b + ", businessType = " + this.f198205c + ", markerResult = " + this.f198206d + ", objectClassifyResult = " + this.f198207e + ", faceResult = " + this.f198208f + ", ocrResult = " + this.f198209g + ", preOcrResult = " + this.f198210h + ", questionResult = " + this.f198211i + ", sceneRecogResult = " + this.f198213k + ", translateReslut = " + this.f198214l + ", uin = " + this.f198215m + '}';
    }
}
