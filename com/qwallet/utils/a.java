package com.qwallet.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a.\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\n"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "resId", "fragment", "", "tag", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "animation", "", "a", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a {
    public static final void a(@NotNull Fragment fragment, int i3, @NotNull Fragment fragment2, @NotNull String tag, @Nullable FragmentAnimation fragmentAnimation) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        Intrinsics.checkNotNullParameter(tag, "tag");
        FragmentActivity activity = fragment.getActivity();
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        FragmentTransaction beginTransaction = fragment.getParentFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "parentFragmentManager.beginTransaction()");
        if (fragmentAnimation != null) {
            beginTransaction.setCustomAnimations(fragmentAnimation.getOpenEnterAnimation(), fragmentAnimation.getOpenExitAnimation(), fragmentAnimation.getCloseEnterAnimation(), fragmentAnimation.getCloseExitAnimation());
        }
        beginTransaction.replace(i3, fragment2, tag);
        beginTransaction.addToBackStack(tag);
        QLog.d("BindBank", 1, "tag = " + tag + " commit id:" + beginTransaction.commit());
    }

    public static /* synthetic */ void b(Fragment fragment, int i3, Fragment fragment2, String str, FragmentAnimation fragmentAnimation, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            fragmentAnimation = null;
        }
        a(fragment, i3, fragment2, str, fragmentAnimation);
    }
}
