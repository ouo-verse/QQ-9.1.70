package com.tencent.qqnt.contacts.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.base.BaseFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R2\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/contacts/adapter/ContactContainerPageAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "position", "", "getPageTitle", "Landroidx/fragment/app/Fragment;", "getItem", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/base/BaseFragment;", "d", "Lkotlin/jvm/functions/Function1;", "getFragmentCreator", "()Lkotlin/jvm/functions/Function1;", "fragmentCreator", "", "e", "Lkotlin/Lazy;", "()Ljava/util/List;", "tabTexts", "", "f", "[Lcom/tencent/qqnt/base/BaseFragment;", "fragments", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ContactContainerPageAdapter extends FragmentPagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, BaseFragment> fragmentCreator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tabTexts;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseFragment[] fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContactContainerPageAdapter(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super Integer, ? extends BaseFragment> fragmentCreator) {
        super(fragmentManager);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentCreator, "fragmentCreator");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentManager, (Object) fragmentCreator);
            return;
        }
        this.fragmentCreator = fragmentCreator;
        lazy = LazyKt__LazyJVMKt.lazy(ContactContainerPageAdapter$tabTexts$2.INSTANCE);
        this.tabTexts = lazy;
        this.fragments = new BaseFragment[d().size()];
    }

    private final List<Integer> d() {
        return (List) this.tabTexts.getValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return d().size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Fragment) iPatchRedirector.redirect((short) 5, (Object) this, position);
        }
        BaseFragment[] baseFragmentArr = this.fragments;
        if (baseFragmentArr[position] == null) {
            baseFragmentArr[position] = this.fragmentCreator.invoke(Integer.valueOf(position));
        }
        BaseFragment baseFragment = this.fragments[position];
        Intrinsics.checkNotNull(baseFragment);
        return baseFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
        return BaseApplication.getContext().getString(d().get(position).intValue());
    }
}
