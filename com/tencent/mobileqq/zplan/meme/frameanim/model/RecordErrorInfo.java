package com.tencent.mobileqq.zplan.meme.frameanim.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/model/b;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "getRetryTime", "()I", "retryTime", "b", "getActionId", "actionId", "c", "errorCode", "<init>", "(III)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.model.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class RecordErrorInfo extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int retryTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    public RecordErrorInfo() {
        this(0, 0, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordErrorInfo)) {
            return false;
        }
        RecordErrorInfo recordErrorInfo = (RecordErrorInfo) other;
        if (this.retryTime == recordErrorInfo.retryTime && this.actionId == recordErrorInfo.actionId && this.errorCode == recordErrorInfo.errorCode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.retryTime * 31) + this.actionId) * 31) + this.errorCode;
    }

    @NotNull
    public String toString() {
        return "RecordErrorInfo(retryTime=" + this.retryTime + ", actionId=" + this.actionId + ", errorCode=" + this.errorCode + ')';
    }

    public /* synthetic */ RecordErrorInfo(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? -1 : i16, (i18 & 4) != 0 ? 0 : i17);
    }

    public RecordErrorInfo(int i3, int i16, int i17) {
        this.retryTime = i3;
        this.actionId = i16;
        this.errorCode = i17;
    }
}
