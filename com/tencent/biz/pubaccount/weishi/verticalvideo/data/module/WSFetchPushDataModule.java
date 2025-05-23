package com.tencent.biz.pubaccount.weishi.verticalvideo.data.module;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.net.g;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSPushVideoModel;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.Arrays;

/* loaded from: classes32.dex */
public class WSFetchPushDataModule implements a {
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.a
    public void a(jz.d<j> dVar) {
        b(bb.z(), dVar);
    }

    private void b(WSRedDotPushMsg wSRedDotPushMsg, final jz.d<j> dVar) {
        WSPushVideoModel wSPushVideoModel;
        if (wSRedDotPushMsg == null) {
            return;
        }
        IWSPushBaseStrategy iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo;
        if (TextUtils.isEmpty(wSRedDotPushMsg.mFeedIds) || iWSPushBaseStrategy == null || iWSPushBaseStrategy.getType() == 2 || (wSPushVideoModel = ((WSPushStrategyInfo) iWSPushBaseStrategy).mWSPushVideoModel) == null) {
            return;
        }
        final stSimpleMetaFeed a16 = wSPushVideoModel.a(wSRedDotPushMsg.mFeedIds);
        g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.WSFetchPushDataModule.1
            @Override // java.lang.Runnable
            public void run() {
                jz.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.x(i.d(Arrays.asList(a16)));
                }
            }
        });
    }
}
