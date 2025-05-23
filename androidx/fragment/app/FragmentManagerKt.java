package androidx.fragment.app;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0086\b\u00f8\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0086\b\u00f8\u0001\u0000\u001a=\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\f"}, d2 = {"commit", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", "body", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "commitNow", "transaction", "now", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class FragmentManagerKt {
    public static final void commit(@NotNull FragmentManager commit, boolean z16, @NotNull Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.checkNotNullParameter(commit, "$this$commit");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z16) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z16, Function1 body, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        Intrinsics.checkNotNullParameter(commit, "$this$commit");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z16) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(@NotNull FragmentManager commitNow, boolean z16, @NotNull Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.checkNotNullParameter(commitNow, "$this$commitNow");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z16) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z16, Function1 body, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        Intrinsics.checkNotNullParameter(commitNow, "$this$commitNow");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z16) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(@NotNull FragmentManager transaction, boolean z16, boolean z17, @NotNull Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z16) {
            if (z17) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z17) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z16, boolean z17, Function1 body, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z16) {
            if (z17) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z17) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
