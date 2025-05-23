package com.tencent.robot.slash.temp;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/slash/temp/UpdateRecentUsedRecordTempMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "botInfo", "e", "b", "functionInfo", "f", "I", "c", "()I", "functionType", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;I)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class UpdateRecentUsedRecordTempMsgIntent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Object botInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Object functionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int functionType;

    public UpdateRecentUsedRecordTempMsgIntent(@NotNull Object botInfo, @NotNull Object functionInfo, int i3) {
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
        this.botInfo = botInfo;
        this.functionInfo = functionInfo;
        this.functionType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Object getBotInfo() {
        return this.botInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Object getFunctionInfo() {
        return this.functionInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getFunctionType() {
        return this.functionType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateRecentUsedRecordTempMsgIntent)) {
            return false;
        }
        UpdateRecentUsedRecordTempMsgIntent updateRecentUsedRecordTempMsgIntent = (UpdateRecentUsedRecordTempMsgIntent) other;
        if (Intrinsics.areEqual(this.botInfo, updateRecentUsedRecordTempMsgIntent.botInfo) && Intrinsics.areEqual(this.functionInfo, updateRecentUsedRecordTempMsgIntent.functionInfo) && this.functionType == updateRecentUsedRecordTempMsgIntent.functionType) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    public int hashCode() {
        return (((this.botInfo.hashCode() * 31) + this.functionInfo.hashCode()) * 31) + this.functionType;
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    @NotNull
    public String toString() {
        return "UpdateRecentUsedRecordTempMsgIntent(botInfo=" + this.botInfo + ", functionInfo=" + this.functionInfo + ", functionType=" + this.functionType + ")";
    }
}
