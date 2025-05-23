package com.tencent.mobileqq.zplan.aigc.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/SuitAnimationItem;", "", "()V", "beginTime", "", "getBeginTime", "()D", "setBeginTime", "(D)V", "bodyAction", "", "getBodyAction", "()Ljava/lang/String;", "setBodyAction", "(Ljava/lang/String;)V", "endTime", "getEndTime", "setEndTime", "frameInterval", "getFrameInterval", "setFrameInterval", "headAction", "getHeadAction", "setHeadAction", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SuitAnimationItem {

    @SerializedName("beginTime")
    private double beginTime;

    @SerializedName("endTime")
    private double endTime;

    @SerializedName("headAction")
    private String headAction = "";

    @SerializedName("bodyAction")
    private String bodyAction = "";

    @SerializedName("frameInterval")
    private double frameInterval = 0.33d;

    public final double getBeginTime() {
        return this.beginTime;
    }

    public final String getBodyAction() {
        return this.bodyAction;
    }

    public final double getEndTime() {
        return this.endTime;
    }

    public final double getFrameInterval() {
        return this.frameInterval;
    }

    public final String getHeadAction() {
        return this.headAction;
    }

    public final void setBeginTime(double d16) {
        this.beginTime = d16;
    }

    public final void setBodyAction(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bodyAction = str;
    }

    public final void setEndTime(double d16) {
        this.endTime = d16;
    }

    public final void setFrameInterval(double d16) {
        this.frameInterval = d16;
    }

    public final void setHeadAction(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headAction = str;
    }
}
