package com.tencent.qmethod.pandoraex.api;

/* compiled from: P */
/* loaded from: classes22.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public String f343921a;

    /* renamed from: b, reason: collision with root package name */
    public String f343922b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f343923a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f343924b = null;

        public p a() {
            p pVar = new p();
            pVar.f343921a = this.f343923a;
            pVar.f343922b = this.f343924b;
            return pVar;
        }

        public a b(String str) {
            this.f343924b = str;
            return this;
        }

        public a c(String str) {
            this.f343923a = str;
            return this;
        }
    }

    public String toString() {
        return "PandoraEventRecord{systemApi=" + this.f343921a + ", infoDesc=" + this.f343922b + "}";
    }
}
