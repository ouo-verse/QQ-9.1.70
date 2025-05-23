package com.tencent.state.square.components.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.MapData;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.components.SquareGroupServiceComponent;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.message.box.IMsgBoxManager;
import com.tencent.state.square.message.box.MsgBoxManager;
import com.tencent.state.square.message.box.MsgBoxOperateFlag;
import com.tencent.state.square.resource.ISquareViewBridge;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J,\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareMsgBoxComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/state/square/resource/ISquareViewBridge;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "msgBoxManager", "Lcom/tencent/state/square/message/box/IMsgBoxManager;", "getMsgBoxManager", "getSqaureMsgBoxReddot", "Landroid/view/View;", "getSquareAddIcon", "getSquareLocateIcon", "getSquareMsgBoxIcon", "initMsgBox", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", "v", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onMapDataReceived", "data", "Lcom/tencent/state/map/MapData;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMsgBoxComponent extends SquareBaseComponent implements ISquareViewBridge {
    private static final String TAG = "SquareMsgBoxComponent";
    private VasSquareFragmentSquareBinding binding;
    private IMsgBoxManager msgBoxManager;

    private final void initMsgBox(Activity activity) {
        SquareFragment squareFragment;
        if ((activity instanceof FragmentActivity) && (squareFragment = getSquareFragment()) != null && this.msgBoxManager == null) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            VasBaseFragment fragment = getFragment();
            MsgBoxManager msgBoxManager = new MsgBoxManager(fragmentActivity, squareFragment, squareFragment, fragment != null ? (SquareGroupServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, SquareGroupServiceComponent.class, null, null, 6, null) : null, null, 16, null);
            msgBoxManager.startObserve(MsgBoxOperateFlag.INIT);
            Unit unit = Unit.INSTANCE;
            this.msgBoxManager = msgBoxManager;
        }
    }

    public final IMsgBoxManager getMsgBoxManager() {
        return this.msgBoxManager;
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSquareAddIcon() {
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment != null) {
            return squareFragment.getSelectIconContainer();
        }
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSquareLocateIcon() {
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment != null) {
            return squareFragment.getSquareLocateIcon();
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        IMsgBoxManager iMsgBoxManager = this.msgBoxManager;
        if (iMsgBoxManager != null) {
            iMsgBoxManager.destroy();
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentSquareBinding.bind(v3);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        QBaseActivity activity;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFromCache() || (activity = getActivity()) == null) {
            return;
        }
        initMsgBox(activity);
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSqaureMsgBoxReddot() {
        try {
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
            if (vasSquareFragmentSquareBinding != null) {
                return vasSquareFragmentSquareBinding.msgBoxReddot;
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getSqaureMsgBoxReddot err.", th5);
            return null;
        }
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSquareMsgBoxIcon() {
        try {
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
            if (vasSquareFragmentSquareBinding != null) {
                return vasSquareFragmentSquareBinding.msgBoxIconContainer;
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getSquareMsgBoxIcon err.", th5);
            return null;
        }
    }
}
