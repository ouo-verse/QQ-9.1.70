package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends n implements f {

    /* renamed from: e, reason: collision with root package name */
    public String f198176e;

    /* renamed from: c, reason: collision with root package name */
    public int f198174c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f198175d = "";

    /* renamed from: f, reason: collision with root package name */
    public int f198177f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f198178g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f198179h = "";

    /* renamed from: i, reason: collision with root package name */
    public a[] f198180i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f198181j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f198182k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f198183l = 0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f198184a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f198185b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f198186c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f198187d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public int f198188e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f198189f = -1;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f198190g = null;

        public String toString() {
            String str;
            try {
                str = new String(this.f198190g, "utf-8");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ARCloudObjectClassifyResult", 2, "toString error, msg:" + e16.getMessage());
                }
                str = "";
            }
            return "ImageTag{imageId = " + this.f198184a + ", tagName = " + this.f198185b + ", tagConfidence = " + this.f198186c + ", tagConfidence_f = " + this.f198187d + ", need_check_lbs = " + this.f198188e + ", cdbRetCode = " + this.f198189f + ", cdbRes = " + str + '}';
        }
    }

    public static boolean b(g gVar) {
        a[] aVarArr;
        if (gVar != null && gVar.f198174c == 0 && gVar.f198177f == 0 && (aVarArr = gVar.f198180i) != null) {
            a aVar = aVarArr[0];
            if (aVar.f198189f == 0 && aVar.f198190g != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.arengine.f
    public byte[] a() {
        return this.f198180i[0].f198190g;
    }

    @Override // com.tencent.mobileqq.ar.arengine.n
    public String toString() {
        String str;
        if (this.f198180i != null) {
            str = "ImageTags{";
            for (int i3 = 0; i3 < this.f198180i.length; i3++) {
                str = str + ", imageTags[" + i3 + "] = " + this.f198180i[i3];
            }
        } else {
            str = "null";
        }
        return "ARCloudObjectClassifyResult{retCode = " + this.f198174c + ", retMsg = " + this.f198175d + ", recogSvrRetCode = " + this.f198177f + ", recogSvrRetMsg = " + this.f198178g + ", sessionId = " + this.f198179h + ", imageTags = " + str + ", timeLen = " + this.f198181j + ", score = " + this.f198182k + ", kptNum = " + this.f198183l + super.toString() + '}';
    }
}
