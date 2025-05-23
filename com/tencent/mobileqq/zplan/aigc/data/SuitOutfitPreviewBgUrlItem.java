package com.tencent.mobileqq.zplan.aigc.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/SuitOutfitPreviewBgUrlItem;", "", "()V", "bgUrl", "", "getBgUrl", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "thumbBgUrl", "getThumbBgUrl", "setThumbBgUrl", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewBgUrlItem {

    @SerializedName("bgUrl")
    private String bgUrl = "";

    @SerializedName("thumbBgUrl")
    private String thumbBgUrl = "";

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getThumbBgUrl() {
        return this.thumbBgUrl;
    }

    public final void setBgUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgUrl = str;
    }

    public final void setThumbBgUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thumbBgUrl = str;
    }
}
