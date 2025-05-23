package com.tencent.qqnt.chathistory.ui.category;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BD\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012%\u0010\u001c\u001a!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0015\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R6\u0010\u001c\u001a!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u00168\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "position", "", "getPageTitle", "", "", "e", "()[Ljava/lang/String;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "d", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "object", "", "destroyItem", "", "Ljava/util/List;", "tabTexts", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "getFragmentCreator", "()Lkotlin/jvm/functions/Function1;", "fragmentCreator", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Ljava/util/List;Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends FragmentPagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> tabTexts;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, BaseHistoryFragment<?>> fragmentCreator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<Integer> tabTexts, @NotNull FragmentManager fragmentManager, @NotNull Function1<? super Integer, ? extends BaseHistoryFragment<?>> fragmentCreator) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(tabTexts, "tabTexts");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentCreator, "fragmentCreator");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tabTexts, fragmentManager, fragmentCreator);
        } else {
            this.tabTexts = tabTexts;
            this.fragmentCreator = fragmentCreator;
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public BaseHistoryFragment<?> getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseHistoryFragment) iPatchRedirector.redirect((short) 6, (Object) this, position);
        }
        return this.fragmentCreator.invoke(Integer.valueOf(position));
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, container, Integer.valueOf(position), object);
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        super.destroyItem(container, position, object);
    }

    @NotNull
    public final String[] e() {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        List<Integer> list = this.tabTexts;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BaseApplication.getContext().getString(((Number) it.next()).intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.tabTexts.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
        return BaseApplication.getContext().getString(this.tabTexts.get(position).intValue());
    }
}
