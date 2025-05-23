package com.tencent.biz.richframework.localupload.recommend.delegate;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "", "getPoiByMediaInfo", "", "mediaInfos", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "callBack", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate$PoiCallBack;", "PoiCallBack", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IRFWRecommendPoiDelegate {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate$PoiCallBack;", "", "onPoiError", "", "mediaInfos", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "onPoiResult", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PoiCallBack {
        void onPoiError(@NotNull List<RFWMediaInfo> mediaInfos);

        void onPoiResult(@NotNull List<RFWMediaInfo> mediaInfos);
    }

    void getPoiByMediaInfo(@NotNull List<RFWMediaInfo> mediaInfos, @NotNull PoiCallBack callBack);
}
