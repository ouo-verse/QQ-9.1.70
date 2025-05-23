package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class t extends n {

    /* renamed from: e, reason: collision with root package name */
    public String f198263e;

    /* renamed from: c, reason: collision with root package name */
    public int f198261c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f198262d = "";

    /* renamed from: f, reason: collision with root package name */
    public int f198264f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f198265g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f198266h = "";

    /* renamed from: i, reason: collision with root package name */
    public a[] f198267i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f198268j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f198269k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f198270l = 0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f198271a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f198272b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f198273c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f198274d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public int f198275e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f198276f = -1;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f198277g = null;

        public String toString() {
            String str;
            try {
                str = new String(this.f198277g, "utf-8");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ARCloudSceneRecogResult", 2, "toString error, msg:" + e16.getMessage());
                }
                str = "";
            }
            return "ImageTag{imageId = " + this.f198271a + ", tagName = " + this.f198272b + ", tagConfidence = " + this.f198273c + ", tagConfidence_f = " + this.f198274d + ", need_check_lbs = " + this.f198275e + ", cdbRetCode = " + this.f198276f + ", cdbRes = " + str + '}';
        }
    }

    public static boolean b(t tVar) {
        a[] aVarArr;
        if (tVar != null && tVar.f198261c == 0 && tVar.f198264f == 0 && (aVarArr = tVar.f198267i) != null) {
            a aVar = aVarArr[0];
            if (aVar.f198276f == 0 && aVar.f198277g != null) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        return this.f198267i[0].f198277g;
    }

    @Override // com.tencent.mobileqq.ar.arengine.n
    public String toString() {
        String str;
        if (this.f198267i != null) {
            str = "ImageTags{";
            for (int i3 = 0; i3 < this.f198267i.length; i3++) {
                str = str + ", imageTags[" + i3 + "] = " + this.f198267i[i3];
            }
        } else {
            str = "null";
        }
        return "ARCloudSceneRecogResult{retCode = " + this.f198261c + ", retMsg = " + this.f198262d + ", recogSvrRetCode = " + this.f198264f + ", recogSvrRetMsg = " + this.f198265g + ", sessionId = " + this.f198266h + ", imageTags = " + str + ", timeLen = " + this.f198268j + ", score = " + this.f198269k + ", kptNum = " + this.f198270l + super.toString() + '}';
    }
}
