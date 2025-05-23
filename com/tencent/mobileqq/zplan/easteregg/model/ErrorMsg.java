package com.tencent.mobileqq.zplan.easteregg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "actionId", "b", "errorCode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.easteregg.model.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ErrorMsg {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer errorCode;

    public ErrorMsg() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getActionId() {
        return this.actionId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorMsg)) {
            return false;
        }
        ErrorMsg errorMsg = (ErrorMsg) other;
        if (Intrinsics.areEqual(this.actionId, errorMsg.actionId) && Intrinsics.areEqual(this.errorCode, errorMsg.errorCode)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.actionId;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num2 = this.errorCode;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ErrorMsg(actionId=" + this.actionId + ", errorCode=" + this.errorCode + ')';
    }

    public ErrorMsg(@Nullable Integer num, @Nullable Integer num2) {
        this.actionId = num;
        this.errorCode = num2;
    }

    public /* synthetic */ ErrorMsg(Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : num, (i3 & 2) != 0 ? 0 : num2);
    }
}
