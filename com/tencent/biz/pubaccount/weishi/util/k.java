package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stJumpInfo;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {
    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, stJumpInfo stjumpinfo, int i3, int i16) {
        if (stjumpinfo == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.r(str, str2, i3, stjumpinfo);
        com.tencent.biz.pubaccount.weishi.report.dc898.d.j(stjumpinfo.url, i16, stjumpinfo.f25121id);
    }

    public void c(WSVerticalPageFragment wSVerticalPageFragment, int i3, int i16) {
        stJumpInfo h16;
        String str;
        if (wSVerticalPageFragment == null || (h16 = iz.a.g().h(i16)) == null) {
            return;
        }
        String str2 = h16.schema_url;
        if (!TextUtils.isEmpty(h16.h5url)) {
            str = h16.h5url;
        } else {
            str = h16.url;
        }
        String str3 = str;
        x.b("WSBlockPage", "schemaUrl:" + str2 + ",h5url:" + str3 + ",jumpurl:" + h16.url);
        bb.e(wSVerticalPageFragment.getBaseActivity(), str2, str3, "", 5, new a(wSVerticalPageFragment, wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), h16));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportBlockPage, id:");
        sb5.append(h16.f25121id);
        sb5.append(" ,pageType:");
        sb5.append(5);
        x.b("WSBlockPage", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements bb.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f81767a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81768b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f81769c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stJumpInfo f81770d;

        a(WSVerticalPageFragment wSVerticalPageFragment, String str, String str2, stJumpInfo stjumpinfo) {
            this.f81767a = wSVerticalPageFragment;
            this.f81768b = str;
            this.f81769c = str2;
            this.f81770d = stjumpinfo;
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void c(String str, int i3) {
            ao.f(this.f81767a.getBaseActivity(), "biz_src_jc_gzh_weishi", str, 1, iz.a.g().p(), 0);
            k.this.b(this.f81768b, this.f81769c, this.f81770d, 1000003, 1);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void d(String str, int i3) {
            k.this.b(this.f81768b, this.f81769c, this.f81770d, 1000004, 2);
            com.tencent.biz.pubaccount.weishi.z.h(this.f81767a.getBaseActivity(), str);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void b(Activity activity) {
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void a(String str, int i3) {
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void e(String str, int i3) {
        }
    }
}
