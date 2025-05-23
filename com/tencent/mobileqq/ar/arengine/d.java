package com.tencent.mobileqq.ar.arengine;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends n {

    /* renamed from: e, reason: collision with root package name */
    public String f198157e;

    /* renamed from: c, reason: collision with root package name */
    public int f198155c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f198156d = "";

    /* renamed from: f, reason: collision with root package name */
    public int f198158f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f198159g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f198160h = "";

    /* renamed from: i, reason: collision with root package name */
    public a[] f198161i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f198162j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f198163k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f198164l = 0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f198165a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f198166b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f198167c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f198168d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public int f198169e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f198170f = -1;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f198171g = null;

        public String toString() {
            String str;
            try {
                str = new String(this.f198171g, "utf-8");
            } catch (Exception unused) {
                str = "";
            }
            return "ImageTag{imageId = " + this.f198165a + ", tagName = " + this.f198166b + ", tagConfidence = " + this.f198167c + ", tagConfidence_f = " + this.f198168d + ", need_check_lbs = " + this.f198169e + ", cdbRetCode = " + this.f198170f + ", cdbRes = " + str + '}';
        }
    }

    public static boolean b(d dVar) {
        a[] aVarArr;
        if (dVar != null && dVar.f198155c == 0 && dVar.f198158f == 0 && (aVarArr = dVar.f198161i) != null) {
            a aVar = aVarArr[0];
            if (aVar.f198170f == 0 && aVar.f198171g != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.arengine.n
    public String toString() {
        String str;
        if (this.f198161i != null) {
            str = "ImageTags{";
            for (int i3 = 0; i3 < this.f198161i.length; i3++) {
                str = str + ", imageTags[" + i3 + "] = " + this.f198161i[i3];
            }
        } else {
            str = "null";
        }
        return "ARCloudMarkerRecogResult{retCode = " + this.f198155c + ", retMsg = " + this.f198156d + ", recogSvrRetCode = " + this.f198158f + ", recogSvrRetMsg = " + this.f198159g + ", sessionId = " + this.f198160h + ", imageTags = " + str + ", timeLen = " + this.f198162j + ", score = " + this.f198163k + ", kptNum = " + this.f198164l + super.toString() + '}';
    }
}
