package com.tencent.biz.pubaccount.weishi.verticalvideo.utils;

import UserGrowth.stAcquisitionInfo;
import UserGrowth.stBusinessIconInfo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.q;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.g;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;
import kz.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82312a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82313b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f82314c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSchema f82315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f82316e;

        a(String str, String str2, j jVar, stSchema stschema, boolean z16) {
            this.f82312a = str;
            this.f82313b = str2;
            this.f82314c = jVar;
            this.f82315d = stschema;
            this.f82316e = z16;
        }

        @Override // h00.d, h00.b
        public void a() {
            super.a();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.S(this.f82312a, this.f82313b, 1000004, this.f82314c, this.f82315d.H5Url, this.f82316e);
        }

        @Override // h00.d, h00.b
        public void c() {
            super.c();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.S(this.f82312a, this.f82313b, 1000007, this.f82314c, this.f82315d.miniAppSchema, this.f82316e);
        }

        @Override // h00.d, h00.b
        public void d() {
            super.d();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.S(this.f82312a, this.f82313b, 1000003, this.f82314c, this.f82315d.schema, this.f82316e);
        }

        @Override // h00.d
        public void f() {
            super.f();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.S(this.f82312a, this.f82313b, 1000009, this.f82314c, this.f82315d.H5Url, this.f82316e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82317a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82318b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f82319c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f82320d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f82321e;

        b(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, Map map) {
            this.f82317a = str;
            this.f82318b = str2;
            this.f82319c = str3;
            this.f82320d = stsimplemetafeed;
            this.f82321e = map;
        }

        @Override // h00.d, h00.b
        public void a() {
            super.a();
            d.m(this.f82317a, this.f82318b, this.f82319c, this.f82320d, 1000004, this.f82321e);
        }

        @Override // h00.d, h00.b
        public void b() {
            super.b();
            d.m(this.f82317a, this.f82318b, this.f82319c, this.f82320d, 1000002, this.f82321e);
        }

        @Override // h00.d, h00.b
        public void d() {
            super.d();
            d.m(this.f82317a, this.f82318b, this.f82319c, this.f82320d, 1000003, this.f82321e);
        }

        @Override // h00.d
        public void f() {
            super.f();
            d.m(this.f82317a, this.f82318b, this.f82319c, this.f82320d, 1000009, this.f82321e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82322a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82323b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f82324c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f82325d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f82326e;

        c(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, Map map) {
            this.f82322a = str;
            this.f82323b = str2;
            this.f82324c = str3;
            this.f82325d = stsimplemetafeed;
            this.f82326e = map;
        }

        @Override // h00.d, h00.b
        public void a() {
            super.a();
            d.m(this.f82322a, this.f82323b, this.f82324c, this.f82325d, 1000004, this.f82326e);
        }

        @Override // h00.d, h00.b
        public void d() {
            super.d();
            d.m(this.f82322a, this.f82323b, this.f82324c, this.f82325d, 1000003, this.f82326e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0838d extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82327a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82328b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f82329c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f82330d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f82331e;

        C0838d(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, Map map) {
            this.f82327a = str;
            this.f82328b = str2;
            this.f82329c = str3;
            this.f82330d = stsimplemetafeed;
            this.f82331e = map;
        }

        @Override // h00.d, h00.b
        public void a() {
            d.m(this.f82327a, this.f82328b, this.f82329c, this.f82330d, 1000004, this.f82331e);
        }

        @Override // h00.d, h00.b
        public void b() {
            d.m(this.f82327a, this.f82328b, this.f82329c, this.f82330d, 1000002, this.f82331e);
            com.tencent.biz.pubaccount.weishi.report.dc898.d.e("videolay_prof_dl_ws");
        }

        @Override // h00.d, h00.b
        public void c() {
            d.m(this.f82327a, this.f82328b, this.f82329c, this.f82330d, 1000007, this.f82331e);
        }

        @Override // h00.d, h00.b
        public void d() {
            d.m(this.f82327a, this.f82328b, this.f82329c, this.f82330d, 1000003, this.f82331e);
            com.tencent.biz.pubaccount.weishi.report.dc898.d.e("videolay_prof_clk_ws");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82332a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82333b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f82334c;

        e(String str, String str2, stSimpleMetaFeed stsimplemetafeed) {
            this.f82332a = str;
            this.f82333b = str2;
            this.f82334c = stsimplemetafeed;
        }

        @Override // h00.d, h00.b
        public void a() {
            super.a();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.L(this.f82332a, this.f82333b, 1000004, this.f82334c);
        }

        @Override // h00.d, h00.b
        public void b() {
            super.b();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.L(this.f82332a, this.f82333b, 1000002, this.f82334c);
        }

        @Override // h00.d, h00.b
        public void d() {
            super.d();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.L(this.f82332a, this.f82333b, 1000003, this.f82334c);
        }

        @Override // h00.d
        public void f() {
            super.f();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.L(this.f82332a, this.f82333b, 1000009, this.f82334c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class f implements kz.a<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f82335a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f82336b;

        f(Context context, boolean z16) {
            this.f82335a = context;
            this.f82336b = z16;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Integer num) {
            if (num.intValue() == 1) {
                QQToast.makeText(this.f82335a, 2, this.f82335a.getResources().getString(R.string.f169724x84), 0).show();
            }
        }

        @Override // kz.a
        public void onFailure(int i3, String str) {
            if (this.f82336b) {
                return;
            }
            QQToast.makeText(this.f82335a, 1, this.f82335a.getResources().getString(R.string.f169723x83), 0).show();
        }
    }

    private static WSDownloadParams b(WSVerticalPageFragment wSVerticalPageFragment, int i3, String str) {
        WSDownloadParams wSDownloadParams = new WSDownloadParams();
        wSDownloadParams.mScene = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.l(wSVerticalPageFragment.getFrom());
        wSDownloadParams.mLinkStrategyType = iz.a.g().p();
        wSDownloadParams.mEventId = i3;
        wSDownloadParams.mTestId = bb.x(wSDownloadParams.mScene);
        wSDownloadParams.mScheme = str;
        return wSDownloadParams;
    }

    public static void e(String str, WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed) {
        stSimpleMetaPerson stsimplemetaperson;
        com.tencent.biz.pubaccount.weishi.report.dc898.d.d();
        if (wSVerticalPageFragment == null || stsimplemetafeed == null || (stsimplemetaperson = stsimplemetafeed.poster) == null || stsimplemetaperson.avatarSchema == null) {
            return;
        }
        String from = wSVerticalPageFragment.getFrom();
        String playScene = wSVerticalPageFragment.getPlayScene();
        Map<String, String> h06 = wSVerticalPageFragment.getPresenter().h0();
        stSimpleMetaPerson stsimplemetaperson2 = stsimplemetafeed.poster;
        new h00.j(wSVerticalPageFragment.getActivity()).o(stsimplemetaperson2.avatarSchema).i(b(wSVerticalPageFragment, 1, stsimplemetaperson2.avatarSchema.schema)).m(new C0838d(from, playScene, str, stsimplemetafeed, h06)).h();
    }

    public static void f(WSVerticalPageFragment wSVerticalPageFragment, j jVar) {
        g d16;
        int i3;
        int i16;
        if (bb.E() || jVar == null || (d16 = jVar.d()) == null) {
            return;
        }
        boolean z16 = d16.b().dramaInfo.isFollowed;
        if (z16) {
            i3 = 2;
            i16 = 1003038;
        } else {
            i3 = 1;
            i16 = 1003030;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.C(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), wSVerticalPageFragment.Th(), i16, wSVerticalPageFragment.getPresenter().h0());
        k.a(d16.a(), i3, new f(BaseApplication.getContext(), z16));
    }

    public static void k(WSVerticalPageFragment wSVerticalPageFragment, j jVar, boolean z16) {
        if (bb.E() || wSVerticalPageFragment == null) {
            return;
        }
        if (c(jVar)) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.S(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), 1000001, jVar, "", z16);
            wSVerticalPageFragment.Sh(jVar);
        } else {
            h(wSVerticalPageFragment, jVar, z16);
        }
    }

    public static void l(WSVerticalPageFragment wSVerticalPageFragment, j jVar) {
        stSchema b16;
        if (bb.E() || wSVerticalPageFragment == null || jVar == null || jVar.f() == null || (b16 = jVar.f().b()) == null) {
            return;
        }
        new h00.j(wSVerticalPageFragment.getActivity()).o(b16).l(true).h();
    }

    public static void j(WSVerticalPageFragment wSVerticalPageFragment, j jVar) {
        k(wSVerticalPageFragment, jVar, false);
    }

    private static boolean c(j jVar) {
        if (jVar == null) {
            return false;
        }
        ez.a f16 = jVar.f();
        return (f16 instanceof ez.b) && ((ez.b) f16).e() == 9;
    }

    public static void d(String str, WSVerticalPageFragment wSVerticalPageFragment, j jVar) {
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stBusinessIconInfo stbusinessiconinfo;
        stSchema stschema;
        if (wSVerticalPageFragment == null || jVar == null || (e16 = jVar.e()) == null || (stacquisitioninfo = e16.acquisitionInfo) == null || (stbusinessiconinfo = stacquisitioninfo.businessIcon) == null || (stschema = stbusinessiconinfo.schema) == null) {
            return;
        }
        String from = wSVerticalPageFragment.getFrom();
        String playScene = wSVerticalPageFragment.getPlayScene();
        Map<String, String> h06 = wSVerticalPageFragment.getPresenter().h0();
        if (q.b(e16)) {
            i.c(wSVerticalPageFragment, jVar, new b(from, playScene, str, e16, h06));
        } else {
            new h00.j(wSVerticalPageFragment.getActivity()).o(stschema).l(true).m(new c(from, playScene, str, e16, h06)).h();
        }
    }

    public static void g(WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed) {
        if (wSVerticalPageFragment == null || stsimplemetafeed == null || stsimplemetafeed.weishiButton == null || bb.E()) {
            return;
        }
        new h00.j(wSVerticalPageFragment.getActivity()).o(stsimplemetafeed.weishiButton.schema).l(true).k(true).p(com.tencent.biz.pubaccount.weishi.util.a.c(wSVerticalPageFragment.getContext())).m(new e(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), stsimplemetafeed)).h();
    }

    private static void h(WSVerticalPageFragment wSVerticalPageFragment, j jVar, boolean z16) {
        stSchema b16;
        if (wSVerticalPageFragment == null || jVar == null || jVar.f() == null || (b16 = jVar.f().b()) == null) {
            return;
        }
        new h00.j(wSVerticalPageFragment.getActivity()).o(b16).l(true).p(com.tencent.biz.pubaccount.weishi.util.a.c(wSVerticalPageFragment.getContext())).m(new a(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), jVar, b16, z16)).h();
    }

    public static void i(WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed) {
        String a16;
        if (wSVerticalPageFragment == null || stsimplemetafeed == null || bb.E()) {
            return;
        }
        if (ao.d(stsimplemetafeed.feed_material_jump_url)) {
            a16 = stsimplemetafeed.feed_material_jump_url;
        } else {
            a16 = ao.a(stsimplemetafeed);
        }
        if (l.c(BaseApplication.getContext())) {
            ao.e(wSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.p(str, str2, str3, i3, stsimplemetafeed, map);
    }
}
