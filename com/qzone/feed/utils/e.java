package com.qzone.feed.utils;

import android.os.Parcelable;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import d5.n;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface e extends n<BusinessFeedData> {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f47468a;

        /* renamed from: b, reason: collision with root package name */
        public String f47469b;

        /* renamed from: c, reason: collision with root package name */
        public String f47470c;

        /* renamed from: d, reason: collision with root package name */
        public String f47471d;

        /* renamed from: e, reason: collision with root package name */
        public int f47472e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f47473f;

        /* renamed from: g, reason: collision with root package name */
        public int f47474g;

        /* renamed from: h, reason: collision with root package name */
        public int f47475h;

        /* renamed from: i, reason: collision with root package name */
        public int f47476i;

        /* renamed from: j, reason: collision with root package name */
        public String f47477j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f47478k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f47479l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f47480m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f47481n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f47482o;

        /* renamed from: p, reason: collision with root package name */
        public Map<Integer, String> f47483p;

        /* renamed from: q, reason: collision with root package name */
        public String f47484q;

        public static a a(a aVar) {
            a aVar2 = new a();
            aVar2.f47468a = aVar.f47468a;
            aVar2.f47469b = aVar.f47469b;
            aVar2.f47470c = aVar.f47470c;
            aVar2.f47471d = aVar.f47471d;
            aVar2.f47472e = aVar.f47472e;
            aVar2.f47473f = aVar.f47473f;
            aVar2.f47475h = aVar.f47475h;
            aVar2.f47476i = aVar.f47476i;
            aVar2.f47477j = aVar.f47477j;
            aVar2.f47478k = aVar.f47478k;
            aVar2.f47480m = aVar.f47480m;
            aVar2.f47474g = aVar.f47474g;
            aVar2.f47481n = aVar.f47481n;
            aVar2.f47479l = aVar.f47479l;
            aVar2.f47482o = aVar.f47482o;
            aVar2.f47483p = aVar.f47483p;
            aVar2.f47484q = aVar.f47484q;
            return aVar2;
        }

        public String toString() {
            return "hint = " + this.f47468a + ", autoFill = " + this.f47469b + ", commentId = " + this.f47470c + ", replyId = " + this.f47471d + ", showFontIcon = " + this.f47472e + ", showBarrageEffectIcon = " + this.f47473f + ", showKeyIcon = " + this.f47475h + ", requestCode = " + this.f47476i + ", ugcKey = " + this.f47477j + ", isRapidComment = " + this.f47478k + ", showQuickComment = " + this.f47474g + ", isGifHotPicComment = " + this.f47480m + ", needShowFavoritesEmo = " + this.f47481n + "isNeedShowGifIconreq =" + this.f47482o;
        }
    }

    void x0(a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map);
}
