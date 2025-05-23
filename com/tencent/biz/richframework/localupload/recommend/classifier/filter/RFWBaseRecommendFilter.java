package com.tencent.biz.richframework.localupload.recommend.classifier.filter;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWBaseRecommendFilter;", "", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "getTag", "", "isRecommendCanShow", "", "recommendInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RFWBaseRecommendFilter {
    public RFWBaseRecommendFilter(@NotNull RecommendContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public abstract String getTag();

    public abstract boolean isRecommendCanShow(@NotNull RFWUploadRecommendInfo recommendInfo);
}
