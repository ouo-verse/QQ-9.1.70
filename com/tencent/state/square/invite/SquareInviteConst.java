package com.tencent.state.square.invite;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/invite/SquareInviteConst;", "", "()V", "ErrBeginArkInvite", "", "ErrEndArkInvite", "ErrInviteBegin", "ErrInviteGenderLimit", "ErrInviteNotBegin", "ErrInviteNotSucc", "ErrInviteSucc", "ErrQueryStatus", "ErrReceiverInviteBegin", "ErrReceiverInviteSucc", "InviteErrorSet", "", "getInviteErrorSet", "()Ljava/util/Set;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareInviteConst {
    public static final int ErrBeginArkInvite = -23706;
    public static final int ErrEndArkInvite = -23707;
    public static final int ErrInviteBegin = -23701;
    public static final int ErrInviteGenderLimit = -23708;
    public static final int ErrInviteNotBegin = -23703;
    public static final int ErrInviteNotSucc = -23704;
    public static final int ErrInviteSucc = -23702;
    public static final int ErrQueryStatus = -23705;
    public static final int ErrReceiverInviteBegin = -23709;
    public static final int ErrReceiverInviteSucc = -23710;
    public static final SquareInviteConst INSTANCE = new SquareInviteConst();
    private static final Set<Integer> InviteErrorSet;

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(ErrInviteBegin), Integer.valueOf(ErrInviteSucc), Integer.valueOf(ErrInviteNotBegin), Integer.valueOf(ErrInviteNotSucc), Integer.valueOf(ErrInviteGenderLimit)});
        InviteErrorSet = of5;
    }

    SquareInviteConst() {
    }

    public final Set<Integer> getInviteErrorSet() {
        return InviteErrorSet;
    }
}
