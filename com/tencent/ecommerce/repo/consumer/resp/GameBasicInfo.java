package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/GameBasicInfo;", "", "()V", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "msg", "getMsg", "tickets", "getTickets", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class GameBasicInfo {

    @SerializedName("app_id")
    private final int appId;

    @SerializedName("app_name")
    private final String appName = "";
    private final String tickets = "";
    private final String msg = "";

    public final int getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getTickets() {
        return this.tickets;
    }
}
