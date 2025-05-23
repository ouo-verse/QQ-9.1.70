package com.tencent.biz.qqcircle.immersive.redpacket.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "cmd", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "toastMsg", "<init>", "(ILjava/lang/String;)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class DialogState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String toastMsg;

    public DialogState(int i3, @NotNull String toastMsg) {
        Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
        this.cmd = i3;
        this.toastMsg = toastMsg;
    }

    /* renamed from: a, reason: from getter */
    public final int getCmd() {
        return this.cmd;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getToastMsg() {
        return this.toastMsg;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogState)) {
            return false;
        }
        DialogState dialogState = (DialogState) other;
        if (this.cmd == dialogState.cmd && Intrinsics.areEqual(this.toastMsg, dialogState.toastMsg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.cmd * 31) + this.toastMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "DialogState(cmd=" + this.cmd + ", toastMsg=" + this.toastMsg + ")";
    }

    public /* synthetic */ DialogState(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }
}
