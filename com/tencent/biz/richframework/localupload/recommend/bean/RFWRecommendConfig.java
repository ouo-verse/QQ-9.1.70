package com.tencent.biz.richframework.localupload.recommend.bean;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWRecommendConfig;", "", "", "minCountLimit", "I", "getMinCountLimit", "()I", "setMinCountLimit", "(I)V", "", CommonConstant.KEY_DISPLAY_NAME, "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "<init>", "()V", "(Ljava/lang/String;I)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWRecommendConfig {

    @NotNull
    private String displayName;
    private int minCountLimit;

    public RFWRecommendConfig() {
        this.minCountLimit = 5;
        this.displayName = "";
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getMinCountLimit() {
        return this.minCountLimit;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RFWRecommendConfig(@NotNull String displayName) {
        this(displayName, 3);
        Intrinsics.checkNotNullParameter(displayName, "displayName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RFWRecommendConfig(@NotNull String displayName, int i3) {
        this();
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.displayName = displayName;
        this.minCountLimit = i3;
    }
}
