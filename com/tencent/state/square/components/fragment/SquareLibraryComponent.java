package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.library.calendar.CalendarGuideManager;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.map.MapData;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.components.SquareBlockDialogUtils;
import com.tencent.state.square.components.SquareGroupLibraryComponent;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J,\u0010\u001b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareLibraryComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "focusDialog", "Lcom/tencent/state/library/focus/FocusDialogTips;", "isForwardToLibrary", "", "reporter", "Lcom/tencent/state/square/IReporter;", "vm", "Lcom/tencent/state/square/SquareMapViewModel;", "gotoLibrary", "", "locateTo", "", "source", "", "locateToLibraryAndShowWelcome", "data", "Lcom/tencent/state/map/MapData;", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFriendStatusPanelClosed", "onMapWelcomeScaleAnimEnd", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareLibraryComponent extends SquareBaseComponent {
    private static final String TAG = "SquareLibraryComponent";
    private boolean isForwardToLibrary;
    private SquareMapViewModel vm;
    private IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
    private final FocusDialogTips focusDialog = FocusDialogTips.INSTANCE;

    private final void gotoLibrary(String locateTo, int source) {
        SquareGroupLibraryComponent squareGroupLibraryComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (squareGroupLibraryComponent = (SquareGroupLibraryComponent) VasBaseLifecycleFragment.getComponent$default(fragment, SquareGroupLibraryComponent.class, null, null, 6, null)) == null) {
            return;
        }
        SquareGroupLibraryComponent.gotoLibrary$default(squareGroupLibraryComponent, null, source, 1, null);
    }

    private final void locateToLibraryAndShowWelcome(MapData data) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        LiveData<Integer> tipType;
        Integer num = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(SquareFriendStatusPanelComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(SquareFriendStatusPanelComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareFriendStatusPanelComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareFriendStatusPanelComponent.class, null, null, 6, null) : null;
        }
        SquareFriendStatusPanelComponent squareFriendStatusPanelComponent = (SquareFriendStatusPanelComponent) component$default;
        if (squareFriendStatusPanelComponent != null && squareFriendStatusPanelComponent.isPanelShowing()) {
            SquareBaseKt.getSquareLog().i(TAG, "locateToLibraryAndShowWelcome cancel by friend panel");
            return;
        }
        if (!GuideContext.INSTANCE.hasCheckedCreateRoleGuide()) {
            SquareBaseKt.getSquareLog().i(TAG, "locateToLibraryAndShowWelcome cancel by guide");
            return;
        }
        if (SquareBlockDialogUtils.INSTANCE.isBlockDialog(getActivity()) || IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_LIBRARY_WELCOME_TIPS, false, null, false, 12, null)) {
            return;
        }
        SquareMapViewModel squareMapViewModel = this.vm;
        if (squareMapViewModel != null && (tipType = squareMapViewModel.getTipType()) != null) {
            num = tipType.getValue();
        }
        if (num != null && num.intValue() == 2) {
            SquareBaseKt.getSquareThread().postOnUi(new SquareLibraryComponent$locateToLibraryAndShowWelcome$1(this, data));
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        CalendarGuideManager.INSTANCE.setNeedInit();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.vm = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(f16, SquareMapViewModel.class);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onFriendStatusPanelClosed() {
        LiveData<MapData> data;
        MapData it;
        SquareMapViewModel squareMapViewModel = this.vm;
        if (squareMapViewModel == null || (data = squareMapViewModel.getData()) == null || (it = data.getValue()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        locateToLibraryAndShowWelcome(it);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapWelcomeScaleAnimEnd(MapData data) {
        if (data != null) {
            locateToLibraryAndShowWelcome(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void gotoLibrary$default(SquareLibraryComponent squareLibraryComponent, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = null;
        }
        squareLibraryComponent.gotoLibrary(str, i3);
    }
}
