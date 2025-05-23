package com.tencent.biz.pubaccount.weishi.verticalvideo.data.module;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.mobileqq.app.dv;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c implements com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.cache.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.d f82030a;

        a(jz.d dVar) {
            this.f82030a = dVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.cache.a
        public void a(JceStruct jceStruct) {
            x.i("WSFetchLocalDataModule", "onReadCacheCompleted");
            if (!(jceStruct instanceof stSimpleGetFeedListRsp)) {
                x.i("WSFetchLocalDataModule", "struct not instanceof stSimpleGetFeedListRsp");
                return;
            }
            ArrayList<stSimpleMetaFeed> arrayList = ((stSimpleGetFeedListRsp) jceStruct).feeds;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            stSimpleMetaFeed stsimplemetafeed = arrayList.get(0);
            if (TextUtils.equals(stsimplemetafeed.f25129id, c.this.d())) {
                WSPublicAccReport.getInstance().getRecommendFullScreenInfo().e(x10.a.h(stsimplemetafeed));
                x.i("WSFetchLocalDataModule", "onReadCacheCompleted feeds.size() = " + arrayList.size());
                jz.d dVar = this.f82030a;
                if (dVar != null) {
                    dVar.x(i.d(arrayList));
                }
            }
        }
    }

    private void c(jz.d<j> dVar) {
        x.i("WSFetchLocalDataModule", "fetchVerticalListDataFromLocal");
        WeiShiCacheManager.O().y(new a(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        dv C = bb.C();
        if (C != null) {
            return C.d();
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.a
    public void a(jz.d<j> dVar) {
        c(dVar);
    }
}
