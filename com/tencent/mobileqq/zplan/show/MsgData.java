package com.tencent.mobileqq.zplan.show;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/show/MsgType;", "a", "Lcom/tencent/mobileqq/zplan/show/MsgType;", "b", "()Lcom/tencent/mobileqq/zplan/show/MsgType;", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "<init>", "(Lcom/tencent/mobileqq/zplan/show/MsgType;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.show.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MsgData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    public MsgData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MsgType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgData)) {
            return false;
        }
        MsgData msgData = (MsgData) other;
        if (this.type == msgData.type && Intrinsics.areEqual(this.text, msgData.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "MsgData(type=" + this.type + ", text=" + this.text + ')';
    }

    public MsgData(@NotNull MsgType type, @NotNull String text) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = type;
        this.text = text;
    }

    public /* synthetic */ MsgData(MsgType msgType, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MsgType.MSG_COMMON : msgType, (i3 & 2) != 0 ? "" : str);
    }
}
