package com.tencent.biz.richframework.localupload.recommend.poi;

import com.tencent.biz.richframework.localupload.recommend.IResultCallBack;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/poi/RFWRecommendPoiWrapper;", "", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "getPoi", "", "needGetPoiList", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "callBack", "Lcom/tencent/biz/richframework/localupload/recommend/IResultCallBack;", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWRecommendPoiWrapper {

    @NotNull
    private final RecommendContext mContext;

    public RFWRecommendPoiWrapper(@NotNull RecommendContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    public final void getPoi(@NotNull List<RFWMediaInfo> needGetPoiList, @NotNull IResultCallBack callBack) {
        List<List<RFWMediaInfo>> chunked;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(needGetPoiList, "needGetPoiList");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (this.mContext.getDelegate().getConfigDelegate().disableGetPoi()) {
            callBack.onFinish(true);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = needGetPoiList.iterator();
        while (true) {
            boolean z26 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RFWMediaInfo rFWMediaInfo = (RFWMediaInfo) next;
            if (rFWMediaInfo.getMLatitude() == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (rFWMediaInfo.getMLatitude() == -1.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (rFWMediaInfo.getMLongitude() == 0.0f) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        if (rFWMediaInfo.getMLongitude() == -1.0f) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (!z19 && Intrinsics.areEqual(rFWMediaInfo.getMCity(), "none")) {
                            z26 = true;
                        }
                    }
                }
            }
            if (z26) {
                arrayList.add(next);
            }
        }
        this.mContext.d("RFWRecommendPoiWrapper", "[getPoi] needGetPoiList size:" + needGetPoiList.size());
        if (arrayList.isEmpty()) {
            callBack.onFinish(false);
            return;
        }
        int poiBatchSize = this.mContext.getDelegate().getConfigDelegate().getPoiBatchSize();
        if (poiBatchSize <= 0) {
            poiBatchSize = 100;
        }
        chunked = CollectionsKt___CollectionsKt.chunked(arrayList, poiBatchSize);
        AtomicInteger atomicInteger = new AtomicInteger(chunked.size());
        for (List<RFWMediaInfo> list : chunked) {
            if (!this.mContext.getIsInQZoneEnv().get()) {
                this.mContext.e("RFWRecommendPoiWrapper", "getPoi isResume return false");
                callBack.onFinish(true);
                return;
            }
            this.mContext.getDelegate().getPoiDelegate().getPoiByMediaInfo(list, new RFWRecommendPoiWrapper$getPoi$1$1(this, callBack, atomicInteger));
        }
    }
}
