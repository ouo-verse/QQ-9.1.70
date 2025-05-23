package com.tencent.biz.pubaccount.weishi.verticalvideo.data.module;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d implements com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.cache.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.d f82032a;

        a(jz.d dVar) {
            this.f82032a = dVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.cache.a
        public void a(JceStruct jceStruct) {
            stSimpleGetFeedListRsp stsimplegetfeedlistrsp;
            ArrayList<stSimpleMetaFeed> arrayList;
            if ((jceStruct instanceof stSimpleGetFeedListRsp) && (arrayList = (stsimplegetfeedlistrsp = (stSimpleGetFeedListRsp) jceStruct).feeds) != null && arrayList.size() > 0) {
                ArrayList<stSimpleMetaFeed> arrayList2 = stsimplegetfeedlistrsp.feeds;
                jz.d dVar = this.f82032a;
                if (dVar != null) {
                    dVar.x(i.d(arrayList2));
                }
            }
        }
    }

    private void b(jz.d<j> dVar) {
        WeiShiCacheManager.O().M(new a(dVar));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.a
    public void a(jz.d<j> dVar) {
        b(dVar);
    }
}
