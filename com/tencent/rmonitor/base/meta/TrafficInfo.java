package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00103\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00064"}, d2 = {"Lcom/tencent/rmonitor/base/meta/TrafficInfo;", "", "()V", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "frontState", "getFrontState", "setFrontState", "host", "getHost", "setHost", "hotPatchNum", "getHotPatchNum", "setHotPatchNum", "id", "", "getId", "()I", "setId", "(I)V", "launchID", "getLaunchID", "setLaunchID", "netState", "getNetState", "setNetState", "processLaunchID", "getProcessLaunchID", "setProcessLaunchID", "processName", "getProcessName", "setProcessName", "rx", "getRx", "setRx", "tx", "getTx", "setTx", "type", "getType", "setType", "userData", "Lorg/json/JSONObject;", "getUserData", "()Lorg/json/JSONObject;", "setUserData", "(Lorg/json/JSONObject;)V", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final class TrafficInfo {
    private int rx;
    private int tx;

    @NotNull
    private String processName = "";

    @NotNull
    private String launchID = "";

    @NotNull
    private String type = "";

    @NotNull
    private String processLaunchID = "";

    @NotNull
    private String host = "";

    @NotNull
    private String frontState = "";

    @NotNull
    private String netState = "";
    private int id = -1;

    @NotNull
    private String appVersion = "";

    @NotNull
    private String hotPatchNum = "";

    @NotNull
    private JSONObject userData = new JSONObject();

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getFrontState() {
        return this.frontState;
    }

    @NotNull
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final String getHotPatchNum() {
        return this.hotPatchNum;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getLaunchID() {
        return this.launchID;
    }

    @NotNull
    public final String getNetState() {
        return this.netState;
    }

    @NotNull
    public final String getProcessLaunchID() {
        return this.processLaunchID;
    }

    @NotNull
    public final String getProcessName() {
        return this.processName;
    }

    public final int getRx() {
        return this.rx;
    }

    public final int getTx() {
        return this.tx;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final JSONObject getUserData() {
        return this.userData;
    }

    public final void setAppVersion(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setFrontState(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.frontState = str;
    }

    public final void setHost(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.host = str;
    }

    public final void setHotPatchNum(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.hotPatchNum = str;
    }

    public final void setId(int i3) {
        this.id = i3;
    }

    public final void setLaunchID(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.launchID = str;
    }

    public final void setNetState(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.netState = str;
    }

    public final void setProcessLaunchID(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.processLaunchID = str;
    }

    public final void setProcessName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.processName = str;
    }

    public final void setRx(int i3) {
        this.rx = i3;
    }

    public final void setTx(int i3) {
        this.tx = i3;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.type = str;
    }

    public final void setUserData(@NotNull JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "<set-?>");
        this.userData = jSONObject;
    }

    @NotNull
    public String toString() {
        return "processName = " + this.processName + ", processLaunchID = " + this.processLaunchID + ", host = " + this.host + ", frontState = " + this.frontState + ", netState = " + this.netState + ", rx = " + this.rx + ", tx = " + this.tx + ", appVersion = " + this.appVersion + ", hotPatchNum = " + this.hotPatchNum + ", userData = " + this.userData + ", launchID = " + this.launchID + ", type = " + this.type;
    }
}
