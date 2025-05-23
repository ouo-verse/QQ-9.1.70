package com.tencent.biz.qqcircle.immersive.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.imsdk.BuildConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchGoodsCardData;", "", "()V", BuildConfig.FLAVOR, "Lcom/tencent/biz/qqcircle/immersive/bean/BasicInfo;", "getBasic", "()Lcom/tencent/biz/qqcircle/immersive/bean/BasicInfo;", "searchAd", "Lcom/tencent/biz/qqcircle/immersive/bean/SearchAdInfo;", "getSearchAd", "()Lcom/tencent/biz/qqcircle/immersive/bean/SearchAdInfo;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSSearchGoodsCardData {

    @NotNull
    private final BasicInfo basic = new BasicInfo();

    @SerializedName("search_ad")
    @NotNull
    private final SearchAdInfo searchAd = new SearchAdInfo();

    @NotNull
    public final BasicInfo getBasic() {
        return this.basic;
    }

    @NotNull
    public final SearchAdInfo getSearchAd() {
        return this.searchAd;
    }
}
