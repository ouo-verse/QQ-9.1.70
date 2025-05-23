package com.tencent.mobileqq.ai.main.feeds;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/g;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "d", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends FragmentStatePagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIAvatarMainViewModel vm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull FragmentManager fm5, @NotNull AIAvatarMainViewModel vm5) {
        super(fm5);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fm5, (Object) vm5);
        } else {
            this.vm = vm5;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.vm.a2();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
        }
        AIAvatarFeedsListFragment aIAvatarFeedsListFragment = new AIAvatarFeedsListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_TAB_POS", position);
        aIAvatarFeedsListFragment.setArguments(bundle);
        return aIAvatarFeedsListFragment;
    }
}
