package com.tencent.icgame.game.liveroom.impl.room.share.timishare;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public c f115633a;

    /* renamed from: b, reason: collision with root package name */
    public String f115634b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f115635c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f115636d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f115637e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f115638f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f115639g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f115640h = "";

    /* renamed from: i, reason: collision with root package name */
    public boolean f115641i = true;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f115642a;

        /* renamed from: b, reason: collision with root package name */
        public String f115643b;

        /* renamed from: c, reason: collision with root package name */
        public String f115644c;

        /* renamed from: d, reason: collision with root package name */
        public String f115645d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r3 != 3) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a a(int i3) {
        a aVar = new a();
        aVar.f115644c = this.f115638f;
        c cVar = this.f115633a;
        if (cVar != null) {
            aVar.f115645d = cVar.b(i3);
        } else {
            aVar.f115645d = this.f115639g;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    aVar.f115642a = this.f115637e;
                    aVar.f115643b = this.f115635c;
                }
            } else {
                String str = this.f115635c;
                aVar.f115642a = str;
                aVar.f115643b = str;
            }
            return aVar;
        }
        aVar.f115642a = this.f115635c;
        aVar.f115643b = this.f115636d;
        return aVar;
    }

    public String toString() {
        return "TgShareParam{tgLiveShareParam=" + this.f115633a + ", simpleTitle='" + this.f115634b + "', mainName='" + this.f115635c + "', originSummary='" + this.f115636d + "', singleSummaryOnly='" + this.f115637e + "', coverImgUrl='" + this.f115638f + "', jumpActionUrl='" + this.f115639g + "', shareAppName='" + this.f115640h + "', showReport=" + this.f115641i + '}';
    }
}
