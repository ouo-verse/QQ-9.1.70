package com.tencent.state.library.components.fragments;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.library.LibraryActivityViewModel;
import com.tencent.state.library.LibraryMapViewModel;
import com.tencent.state.publicchat.component.IPublicChatOwnerEventListener;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.activity.TemplateActivityViewModel;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.map.TemplateMapViewModel;
import com.tencent.state.template.map.component.TemplateUiComponent;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryUiComponent;", "Lcom/tencent/state/template/map/component/TemplateUiComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryBinding;", "getActivityViewModel", "Lcom/tencent/state/template/activity/TemplateActivityViewModel;", "f", "Landroidx/fragment/app/Fragment;", "getBackIcon", "Landroid/view/View;", "getMapViewModel", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "getSeatButton", "getTitleContainer", "Landroid/view/ViewGroup;", "onEnterRoom", "", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentResumed", "fm", "Landroidx/fragment/app/FragmentManager;", "onInitView", "v", "updateSeatButtonState", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryUiComponent extends TemplateUiComponent {
    private VasSquareFragmentLibraryBinding binding;

    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    protected TemplateActivityViewModel getActivityViewModel(Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentActivity activity = f16.getActivity();
        if (activity != null) {
            return (LibraryActivityViewModel) new ViewModelProvider(activity).get(LibraryActivityViewModel.class);
        }
        return null;
    }

    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    protected View getBackIcon() {
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding != null) {
            return vasSquareFragmentLibraryBinding.back;
        }
        return null;
    }

    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    protected TemplateMapViewModel getMapViewModel(Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return (TemplateMapViewModel) new ViewModelProvider(f16).get(LibraryMapViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    public View getSeatButton() {
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding != null) {
            return vasSquareFragmentLibraryBinding.seatButton;
        }
        return null;
    }

    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    protected ViewGroup getTitleContainer() {
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding != null) {
            return vasSquareFragmentLibraryBinding.titleContainer;
        }
        return null;
    }

    @Override // com.tencent.state.template.map.component.TemplateUiComponent, com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onEnterRoom(info);
        LibraryUiComponent$onEnterRoom$1 libraryUiComponent$onEnterRoom$1 = new Function1<IPublicChatOwnerEventListener, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryUiComponent$onEnterRoom$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IPublicChatOwnerEventListener iPublicChatOwnerEventListener) {
                invoke2(iPublicChatOwnerEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IPublicChatOwnerEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                IPublicChatOwnerEventListener.DefaultImpls.onSceneReady$default(it, false, 1, null);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(IPublicChatOwnerEventListener.class, null, null, libraryUiComponent$onEnterRoom$1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r3.isTopFragment() == true) goto L10;
     */
    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentResumed(fm5, f16);
        View seatButton = getSeatButton();
        if (seatButton != null) {
            VasBaseFragment fragment = getFragment();
            boolean z16 = fragment != null;
            ViewExtensionsKt.setVisibility(seatButton, z16);
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    public void onInitView(Fragment f16, View v3) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentLibraryBinding.bind(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r1.isTopFragment() == true) goto L10;
     */
    @Override // com.tencent.state.template.map.component.TemplateUiComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateSeatButtonState(SeatButtonState state) {
        TextView textView;
        SquareImageView squareImageView;
        TextView textView2;
        SquareImageView squareImageView2;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        TextView textView3;
        SquareImageView squareImageView3;
        Intrinsics.checkNotNullParameter(state, "state");
        View seatButton = getSeatButton();
        if (seatButton != null) {
            VasBaseFragment fragment = getFragment();
            boolean z16 = fragment != null;
            ViewExtensionsKt.setVisibility(seatButton, z16);
        }
        if (state.isMeSeated()) {
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
            if (vasSquareFragmentLibraryBinding != null && (squareImageView3 = vasSquareFragmentLibraryBinding.seatIcon) != null) {
                squareImageView3.setImageResource(R.drawable.i_g);
            }
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding2 = this.binding;
            if (vasSquareFragmentLibraryBinding2 != null && (textView3 = vasSquareFragmentLibraryBinding2.seatText) != null) {
                textView3.setText(R.string.f169761xg3);
            }
        } else if (state.isRoomFull()) {
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding3 = this.binding;
            if (vasSquareFragmentLibraryBinding3 != null && (squareImageView2 = vasSquareFragmentLibraryBinding3.seatIcon) != null) {
                squareImageView2.setImageResource(R.drawable.i_x);
            }
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding4 = this.binding;
            if (vasSquareFragmentLibraryBinding4 != null && (textView2 = vasSquareFragmentLibraryBinding4.seatText) != null) {
                textView2.setText(R.string.xgh);
            }
        } else {
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding5 = this.binding;
            if (vasSquareFragmentLibraryBinding5 != null && (squareImageView = vasSquareFragmentLibraryBinding5.seatIcon) != null) {
                squareImageView.setImageResource(R.drawable.i_r);
            }
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding6 = this.binding;
            if (vasSquareFragmentLibraryBinding6 != null && (textView = vasSquareFragmentLibraryBinding6.seatText) != null) {
                textView.setText(R.string.xg9);
            }
        }
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(LibraryCalendarComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(LibraryCalendarComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, LibraryCalendarComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, LibraryCalendarComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        LibraryCalendarComponent libraryCalendarComponent = (LibraryCalendarComponent) fragmentComponent;
        if (libraryCalendarComponent != null) {
            libraryCalendarComponent.onUpdateSeatButtonState();
        }
    }
}
