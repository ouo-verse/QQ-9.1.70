package com.tencent.biz.richframework.localupload.recommend.poi;

import com.tencent.biz.richframework.localupload.recommend.IResultCallBack;
import com.tencent.biz.richframework.localupload.recommend.RFWRecommendThread;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendPoiDelegate;
import com.tencent.biz.richframework.localupload.recommend.poi.RFWRecommendPoiWrapper;
import com.tencent.biz.richframework.localupload.recommend.poi.RFWRecommendPoiWrapper$getPoi$1$1;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/richframework/localupload/recommend/poi/RFWRecommendPoiWrapper$getPoi$1$1", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate$PoiCallBack;", "onPoiError", "", "mediaInfos", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "onPoiResult", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWRecommendPoiWrapper$getPoi$1$1 implements IRFWRecommendPoiDelegate.PoiCallBack {
    final /* synthetic */ IResultCallBack $callBack;
    final /* synthetic */ AtomicInteger $count;
    final /* synthetic */ RFWRecommendPoiWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWRecommendPoiWrapper$getPoi$1$1(RFWRecommendPoiWrapper rFWRecommendPoiWrapper, IResultCallBack iResultCallBack, AtomicInteger atomicInteger) {
        this.this$0 = rFWRecommendPoiWrapper;
        this.$callBack = iResultCallBack;
        this.$count = atomicInteger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPoiError$lambda$1(RFWRecommendPoiWrapper this$0, AtomicInteger count, IResultCallBack callBack) {
        RecommendContext recommendContext;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(count, "$count");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        recommendContext = this$0.mContext;
        recommendContext.e("RFWRecommendPoiWrapper", "onPoiResult error");
        if (count.decrementAndGet() <= 0) {
            callBack.onFinish(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPoiResult$lambda$0(RFWRecommendPoiWrapper this$0, List mediaInfos, IResultCallBack callBack, AtomicInteger count) {
        RecommendContext recommendContext;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfos, "$mediaInfos");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        Intrinsics.checkNotNullParameter(count, "$count");
        recommendContext = this$0.mContext;
        recommendContext.d("RFWRecommendPoiWrapper", "onPoiResult " + mediaInfos.size());
        callBack.handleBatchResult(mediaInfos, "onPoiResult " + mediaInfos.size());
        if (count.decrementAndGet() <= 0) {
            callBack.onFinish(false);
        }
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendPoiDelegate.PoiCallBack
    public void onPoiError(@NotNull List<RFWMediaInfo> mediaInfos) {
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        RFWRecommendThread rFWRecommendThread = RFWRecommendThread.INSTANCE;
        final RFWRecommendPoiWrapper rFWRecommendPoiWrapper = this.this$0;
        final AtomicInteger atomicInteger = this.$count;
        final IResultCallBack iResultCallBack = this.$callBack;
        rFWRecommendThread.runOnRealTimeThread(new Runnable() { // from class: ke0.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWRecommendPoiWrapper$getPoi$1$1.onPoiError$lambda$1(RFWRecommendPoiWrapper.this, atomicInteger, iResultCallBack);
            }
        });
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendPoiDelegate.PoiCallBack
    public void onPoiResult(@NotNull final List<RFWMediaInfo> mediaInfos) {
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        RFWRecommendThread rFWRecommendThread = RFWRecommendThread.INSTANCE;
        final RFWRecommendPoiWrapper rFWRecommendPoiWrapper = this.this$0;
        final IResultCallBack iResultCallBack = this.$callBack;
        final AtomicInteger atomicInteger = this.$count;
        rFWRecommendThread.runOnRealTimeThread(new Runnable() { // from class: ke0.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWRecommendPoiWrapper$getPoi$1$1.onPoiResult$lambda$0(RFWRecommendPoiWrapper.this, mediaInfos, iResultCallBack, atomicInteger);
            }
        });
    }
}
