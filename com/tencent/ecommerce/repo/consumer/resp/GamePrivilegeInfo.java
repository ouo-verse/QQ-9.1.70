package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/GamePrivilegeInfo;", "", "()V", "appName", "", "getAppName", "()Ljava/lang/String;", "developer", "getDeveloper", "privatePoliciesUrl", "getPrivatePoliciesUrl", "version", "getVersion", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class GamePrivilegeInfo {
    private final String developer = "";
    private final String version = "";

    @SerializedName("app_name")
    private final String appName = "";

    @SerializedName("private_policies_url")
    private final String privatePoliciesUrl = "";

    public final String getAppName() {
        return this.appName;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public final String getPrivatePoliciesUrl() {
        return this.privatePoliciesUrl;
    }

    public final String getVersion() {
        return this.version;
    }
}
