package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/JumpInfo;", "", "()V", "jumpType", "", "getJumpType", "()I", "url", "", "getUrl", "()Ljava/lang/String;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class JumpInfo {

    @SerializedName("jump_type")
    private final int jumpType = -1;

    @SerializedName("url")
    private final String url = "";

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getUrl() {
        return this.url;
    }
}
