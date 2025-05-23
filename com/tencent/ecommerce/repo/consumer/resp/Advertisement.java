package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.ecommerce.base.config.annotation.RawStringJsonAdapter;
import com.tencent.imsdk.BuildConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "", "()V", BuildConfig.FLAVOR, "Lcom/tencent/ecommerce/repo/consumer/resp/BasicInfo;", "getBasic", "()Lcom/tencent/ecommerce/repo/consumer/resp/BasicInfo;", "commentAd", "Lcom/tencent/ecommerce/repo/consumer/resp/CommentAdInfo;", "getCommentAd", "()Lcom/tencent/ecommerce/repo/consumer/resp/CommentAdInfo;", "ext", "Lcom/tencent/ecommerce/repo/consumer/resp/ExtendInfo;", "getExt", "()Lcom/tencent/ecommerce/repo/consumer/resp/ExtendInfo;", "report", "", "getReport", "()Ljava/lang/String;", "videoAd", "Lcom/tencent/ecommerce/repo/consumer/resp/VideoAdInfo;", "getVideoAd", "()Lcom/tencent/ecommerce/repo/consumer/resp/VideoAdInfo;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class Advertisement {

    @SerializedName("comment_ad")
    private final CommentAdInfo commentAd;
    private final BasicInfo basic = new BasicInfo();

    @SerializedName("video_ad")
    private final VideoAdInfo videoAd = new VideoAdInfo();
    private final ExtendInfo ext = new ExtendInfo();

    @JsonAdapter(RawStringJsonAdapter.class)
    private final String report = "";

    public final BasicInfo getBasic() {
        return this.basic;
    }

    public final CommentAdInfo getCommentAd() {
        return this.commentAd;
    }

    public final ExtendInfo getExt() {
        return this.ext;
    }

    public final String getReport() {
        return this.report;
    }

    public final VideoAdInfo getVideoAd() {
        return this.videoAd;
    }
}
