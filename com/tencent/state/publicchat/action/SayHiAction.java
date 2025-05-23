package com.tencent.state.publicchat.action;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/publicchat/action/SayHiAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", "uin", "", "nickname", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getUin", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SayHiAction extends MsgAction {
    private final String nickname;
    private final String uin;

    public SayHiAction(String uin, String nickname) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        this.uin = uin;
        this.nickname = nickname;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    public final SayHiAction copy(String uin, String nickname) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        return new SayHiAction(uin, nickname);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nickname;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SayHiAction(uin=" + this.uin + ", nickname=" + this.nickname + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SayHiAction)) {
            return false;
        }
        SayHiAction sayHiAction = (SayHiAction) other;
        return Intrinsics.areEqual(this.uin, sayHiAction.uin) && Intrinsics.areEqual(this.nickname, sayHiAction.nickname);
    }

    public static /* synthetic */ SayHiAction copy$default(SayHiAction sayHiAction, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sayHiAction.uin;
        }
        if ((i3 & 2) != 0) {
            str2 = sayHiAction.nickname;
        }
        return sayHiAction.copy(str, str2);
    }
}
