package com.tencent.state.library.focus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.state.FragmentComponent;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.record.RecordFragment;
import com.tencent.state.library.focus.component.FocusBaseComponent;
import com.tencent.state.library.focus.component.FocusSingleComponent;
import com.tencent.state.library.focus.component.FocusSingleReportComponent;
import com.tencent.state.library.focus.component.IFocusEventListener;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.square.databinding.VasSquareLibrarySingleViewBinding;
import com.tencent.state.template.data.User;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0017J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/library/focus/FocusSingleBaseFragment;", "Lcom/tencent/state/library/focus/FocusBaseFragment;", "()V", "doOnDestroy", "", "doOnViewCreated", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getFragmentView", "Lcom/tencent/state/library/focus/IFocusParentView;", "getPageId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFocusBackPress", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class FocusSingleBaseFragment extends FocusBaseFragment {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List listOf;
        List<FragmentComponent> plus;
        List<FragmentComponent> components = super.getComponents();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FocusBaseComponent[]{new FocusSingleComponent(), new FocusSingleReportComponent()});
        plus = CollectionsKt___CollectionsKt.plus((Collection) components, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment
    public IFocusParentView getFragmentView() {
        return (IFocusParentView) VasBaseLifecycleFragment.getComponent$default(this, FocusSingleComponent.class, null, null, 6, null);
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return "pg_zplan_library_single_focus";
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareLibrarySingleViewBinding inflate = VasSquareLibrarySingleViewBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibrarySingleVi\u2026Binding.inflate(inflater)");
        return inflate.getMRv();
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        doOnDestroy();
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment
    public void onFocusBackPress() {
        FocusItem singleItem;
        FocusBaseItem data = getData();
        if (data == null || (singleItem = data.getSingleItem()) == null) {
            return;
        }
        updateLibraryItemVisible(FocusDataKt.getId(singleItem), FocusDataKt.getType(singleItem), true);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FocusCommonView commonView;
        VasSquareLibraryCommonViewBinding binding;
        LibraryFocusTimeBubble libraryFocusTimeBubble;
        FocusCommonView commonView2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        doOnViewCreated();
        IFocusParentView fragmentView = getFragmentView();
        if (fragmentView != null && (commonView2 = fragmentView.getCommonView()) != null) {
            commonView2.setClickListener(new Function1<ClickType, Unit>() { // from class: com.tencent.state.library.focus.FocusSingleBaseFragment$onViewCreated$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClickType clickType) {
                    invoke2(clickType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final ClickType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    FocusSingleBaseFragment.this.forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusSingleBaseFragment$onViewCreated$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IFocusEventListener iFocusEventListener) {
                            invoke2(iFocusEventListener);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IFocusEventListener it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.onFuncButtonClicked(ClickType.this);
                        }
                    });
                }
            });
        }
        IFocusParentView fragmentView2 = getFragmentView();
        if (fragmentView2 == null || (commonView = fragmentView2.getCommonView()) == null || (binding = commonView.getBinding()) == null || (libraryFocusTimeBubble = binding.focusTimeBubble) == null) {
            return;
        }
        libraryFocusTimeBubble.setBubbleClickListener(new Function2<Integer, User, Unit>() { // from class: com.tencent.state.library.focus.FocusSingleBaseFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, User user) {
                invoke(num.intValue(), user);
                return Unit.INSTANCE;
            }

            public final void invoke(final int i3, final User user) {
                Intrinsics.checkNotNullParameter(user, "user");
                if (i3 == 5) {
                    if (user.isMe()) {
                        FocusSingleBaseFragment.this.showFragment(new RecordFragment(PageType.Library));
                    }
                    FocusSingleBaseFragment.this.forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusSingleBaseFragment$onViewCreated$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IFocusEventListener iFocusEventListener) {
                            invoke2(iFocusEventListener);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IFocusEventListener it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.onComeOnButtonClicked(User.this);
                        }
                    });
                    return;
                }
                FocusSingleBaseFragment.this.forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusSingleBaseFragment$onViewCreated$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IFocusEventListener iFocusEventListener) {
                        invoke2(iFocusEventListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IFocusEventListener it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onViewClick(i3, user);
                    }
                });
            }
        });
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    public void doOnDestroy() {
    }

    public void doOnViewCreated() {
    }
}
