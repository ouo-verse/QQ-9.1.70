package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stCollection;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81772a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81773b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f81774c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f81775d;

        a(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map map) {
            this.f81772a = str;
            this.f81773b = str2;
            this.f81774c = stsimplemetafeed;
            this.f81775d = map;
        }

        @Override // h00.d, h00.b
        public void a() {
            n.e(this.f81772a, this.f81773b, this.f81774c, 1000004, this.f81775d);
        }

        @Override // h00.d, h00.b
        public void b() {
            n.e(this.f81772a, this.f81773b, this.f81774c, 1000002, this.f81775d);
        }

        @Override // h00.d, h00.b
        public void c() {
            n.e(this.f81772a, this.f81773b, this.f81774c, 1000007, this.f81775d);
        }

        @Override // h00.d, h00.b
        public void d() {
            n.e(this.f81772a, this.f81773b, this.f81774c, 1000003, this.f81775d);
        }

        @Override // h00.d, h00.b
        public void e() {
            super.e();
            n.e(this.f81772a, this.f81773b, this.f81774c, 1000001, this.f81775d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f81776a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f81777b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stCollection f81778c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f81779d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f81780e;

        b(int i3, int i16, stCollection stcollection, stSimpleMetaFeed stsimplemetafeed, String str) {
            this.f81776a = i3;
            this.f81777b = i16;
            this.f81778c = stcollection;
            this.f81779d = stsimplemetafeed;
            this.f81780e = str;
        }

        @Override // h00.d, h00.b
        public void a() {
            com.tencent.biz.pubaccount.weishi.recommend.a.j(this.f81776a, this.f81777b, 1000004, this.f81778c, this.f81779d, this.f81780e);
        }

        @Override // h00.d, h00.b
        public void b() {
            com.tencent.biz.pubaccount.weishi.recommend.a.j(this.f81776a, this.f81777b, 1000002, this.f81778c, this.f81779d, this.f81780e);
        }

        @Override // h00.d, h00.b
        public void c() {
            com.tencent.biz.pubaccount.weishi.recommend.a.j(this.f81776a, this.f81777b, 1000007, this.f81778c, this.f81779d, this.f81780e);
        }

        @Override // h00.d, h00.b
        public void d() {
            com.tencent.biz.pubaccount.weishi.recommend.a.j(this.f81776a, this.f81777b, 1000003, this.f81778c, this.f81779d, this.f81780e);
        }

        @Override // h00.d, h00.b
        public void e() {
            super.e();
            com.tencent.biz.pubaccount.weishi.recommend.a.j(this.f81776a, this.f81777b, 1000001, this.f81778c, this.f81779d, this.f81780e);
            com.tencent.biz.pubaccount.weishi.report.f.l(String.valueOf(System.currentTimeMillis()));
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.m0(this.f81780e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, String str2, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.w(str, str2, stsimplemetafeed, i3, map);
    }

    private static void b(Context context, stSimpleMetaFeed stsimplemetafeed, stSchema stschema, String str, String str2, h00.b bVar) {
        if (stsimplemetafeed == null || stschema == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.qzone.widget.u.COLUMN_TAB_ID, str2);
        bundle.putString("from", str);
        bundle.putSerializable("feed_info", stsimplemetafeed);
        new h00.j(context).o(stschema).j(bundle).m(bVar).h();
    }

    public static void c(Context context, stSimpleMetaFeed stsimplemetafeed, stCollection stcollection, int i3, int i16, String str) {
        if (context == null || stsimplemetafeed == null) {
            return;
        }
        b(context, stsimplemetafeed, stcollection.schema, "vertical_layer_collection_of_card", str, new b(i3, i16, stcollection, stsimplemetafeed, str));
    }

    public static void d(WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed, stSchema stschema, String str, Map<String, String> map) {
        if (wSVerticalPageFragment == null || stsimplemetafeed == null) {
            return;
        }
        b(wSVerticalPageFragment.getActivity(), stsimplemetafeed, stschema, "", str, new a(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), stsimplemetafeed, map));
    }
}
