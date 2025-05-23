package com.tencent.biz.pubaccount.weishi.cache;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.biz.pubaccount.weishi.player.wrapper.f;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a implements WSVideoPreDownloadManager.b {

        /* renamed from: a, reason: collision with root package name */
        stSimpleMetaFeed f80472a;

        a(stSimpleMetaFeed stsimplemetafeed) {
            this.f80472a = stsimplemetafeed;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public List<WSVideoPreDownloadManager.c> a(int i3, boolean z16) {
            WSVideoPreDownloadManager.c cVar = new WSVideoPreDownloadManager.c(x10.a.i(this.f80472a, com.tencent.biz.pubaccount.weishi.video.specurl.d.f82378a.c(this.f80472a.video_spec_urls)), this.f80472a.video.duration, x10.a.e(r0, r7), this.f80472a.gdt_ad_type == 1);
            cVar.f81117h = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.p(this.f80472a);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            return arrayList;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public boolean b() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private WSVideoPreDownloadManager f80473a;

        /* renamed from: b, reason: collision with root package name */
        private f.a f80474b;

        /* renamed from: c, reason: collision with root package name */
        private String f80475c;

        b(WSVideoPreDownloadManager wSVideoPreDownloadManager, String str, f.a aVar) {
            this.f80473a = wSVideoPreDownloadManager;
            this.f80475c = str;
            this.f80474b = aVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f.a
        public void a(String str, String str2) {
            x.i("WSVideoPreloadManager", "[WSVideoPreloadManager.java][onPreloadSuccess] videoVid:" + str);
            if (TextUtils.isEmpty(this.f80475c) || TextUtils.equals(str, i.p(this.f80475c))) {
                this.f80473a.o();
                x.i("WSVideoPreloadManager", "videoPreDownloadManager destroy");
            }
            f.a aVar = this.f80474b;
            if (aVar != null) {
                aVar.a(str, str2);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f.a
        public void b(String str, int i3, String str2) {
            x.i("WSVideoPreloadManager", "onPreloadFailed");
            this.f80473a.o();
            f.a aVar = this.f80474b;
            if (aVar != null) {
                aVar.b(str, i3, str2);
            }
        }
    }

    public static void a(stSimpleMetaFeed stsimplemetafeed, boolean z16) {
        x.j("WSVideoPreloadManager", "[prepareRecommendFloatPageData] download cache video");
        if (z16) {
            b(stsimplemetafeed);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(stsimplemetafeed);
        WSPicLoader.g().t(arrayList, false);
        WeiShiCacheManager.O().o(arrayList);
    }

    public static void b(stSimpleMetaFeed stsimplemetafeed) {
        c(stsimplemetafeed, null);
    }

    public static void c(stSimpleMetaFeed stsimplemetafeed, f.a aVar) {
        if (stsimplemetafeed == null) {
            return;
        }
        WSVideoPreDownloadManager wSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication);
        String h16 = x10.a.h(stsimplemetafeed);
        boolean n3 = wSVideoPreDownloadManager.n(h16);
        x.i("WSVideoPreloadManager", "sec itemInfo : " + stsimplemetafeed + "; isCached = " + n3);
        if (n3) {
            return;
        }
        wSVideoPreDownloadManager.x(new a(stsimplemetafeed));
        wSVideoPreDownloadManager.y(new b(wSVideoPreDownloadManager, h16, aVar));
        wSVideoPreDownloadManager.v(0);
    }
}
