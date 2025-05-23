package com.tencent.state.library.focus;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.library.components.fragments.LibraryMsgBoxComponent;
import com.tencent.state.library.focus.component.FocusCalendarComponent;
import com.tencent.state.library.focus.component.FocusRecordComponent;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusSingleItem;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/library/focus/FocusSingleMeFragment;", "Lcom/tencent/state/library/focus/FocusSingleBaseFragment;", "Lcom/tencent/state/library/focus/FocusMeListener;", "()V", "doOnViewCreated", "", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusSingleMeFragment extends FocusSingleBaseFragment implements FocusMeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "FocusSingleMeFragment";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/library/focus/FocusSingleMeFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/tencent/state/library/focus/FocusSingleMeFragment;", "singleItem", "Lcom/tencent/state/library/focus/data/FocusSingleItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public final FocusSingleMeFragment newInstance(FocusSingleItem singleItem) {
            Intrinsics.checkNotNullParameter(singleItem, "singleItem");
            FocusSingleMeFragment focusSingleMeFragment = new FocusSingleMeFragment();
            focusSingleMeFragment.setData(singleItem);
            return focusSingleMeFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment
    public void doOnViewCreated() {
        FocusRecordComponent focusRecordComponent;
        Context it = getContext();
        if (it != null) {
            FocusDialogTips focusDialog = getFocusDialog();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            focusDialog.showFirstFocusDialog(it);
        }
        FocusBaseItem data = getData();
        if (!(data instanceof FocusSingleItem)) {
            data = null;
        }
        FocusSingleItem focusSingleItem = (FocusSingleItem) data;
        if (focusSingleItem == null || (focusRecordComponent = (FocusRecordComponent) VasBaseLifecycleFragment.getComponent$default(this, FocusRecordComponent.class, null, null, 6, null)) == null) {
            return;
        }
        focusRecordComponent.doSingleMeRecord(focusSingleItem);
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment, com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment
    protected List<FragmentComponent> getComponents() {
        List listOf;
        List<FragmentComponent> plus;
        List<FragmentComponent> components = super.getComponents();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new FocusRecordComponent(), new LibraryMsgBoxComponent(), new FocusCalendarComponent()});
        plus = CollectionsKt___CollectionsKt.plus((Collection) components, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment, com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment, com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment, com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment, com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.library.focus.FocusSingleBaseFragment, com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}
