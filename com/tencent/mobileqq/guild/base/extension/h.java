package com.tencent.mobileqq.guild.base.extension;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/QBaseFragment;", "", "c", "Landroidx/fragment/app/Fragment;", "", "b", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {
    public static final void a(@NotNull Fragment fragment, int i3, int i16, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (!fragment.isAdded()) {
            return;
        }
        List<Fragment> fragments = fragment.getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i3, i16, intent);
        }
    }

    public static final boolean b(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        boolean z16 = false;
        if (!fragment.isAdded()) {
            return false;
        }
        List<Fragment> fragments = fragment.getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        for (Fragment fragment2 : fragments) {
            if ((fragment2 instanceof BasePartFragment) && ((BasePartFragment) fragment2).onBackEvent()) {
                z16 = true;
            }
        }
        Logger.f235387a.d().i("Guild.comm.FragmentEx", 1, "onBackEvent id:" + m.a(fragment) + ": handled=" + z16);
        return z16;
    }

    public static final void c(@NotNull QBaseFragment qBaseFragment) {
        Intrinsics.checkNotNullParameter(qBaseFragment, "<this>");
        if (ImmersiveUtils.isSupporImmersive() != 1) {
            return;
        }
        if (SystemBarActivityModule.getSystemBarComp(qBaseFragment.getQBaseActivity()) == null) {
            SystemBarActivityModule.setImmersiveStatus(qBaseFragment.getQBaseActivity(), 0);
            return;
        }
        SystemBarActivityModule.getSystemBarComp(qBaseFragment.getQBaseActivity()).setStatusBarDrawable(null);
        SystemBarActivityModule.getSystemBarComp(qBaseFragment.getQBaseActivity()).setStatusBarColor(0);
        SystemBarActivityModule.getSystemBarComp(qBaseFragment.getQBaseActivity()).setStatusColor(0);
    }
}
