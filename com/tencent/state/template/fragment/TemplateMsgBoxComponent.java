package com.tencent.state.template.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.databinding.VasSquareMsgBoxButtonBinding;
import com.tencent.state.square.friendsetting.SettingTipsController;
import com.tencent.state.square.message.box.IMsgBoxManager;
import com.tencent.state.square.message.box.MsgBoxManager;
import com.tencent.state.square.message.box.MsgBoxOperateFlag;
import com.tencent.state.square.message.box.MsgBoxSource;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.square.resource.ISquareViewBridge;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH$J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010#\u001a\u00020$H\u0002J\u001a\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010(\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/template/fragment/TemplateMsgBoxComponent;", "Lcom/tencent/state/template/fragment/TemplateBaseComponent;", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "Lcom/tencent/state/square/resource/ISquareViewBridge;", "msgBoxSource", "Lcom/tencent/state/square/message/box/MsgBoxSource;", "(Lcom/tencent/state/square/message/box/MsgBoxSource;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareMsgBoxButtonBinding;", "msgBoxManager", "Lcom/tencent/state/square/message/box/IMsgBoxManager;", "getMsgBoxSource", "()Lcom/tencent/state/square/message/box/MsgBoxSource;", "getMsgBoxContainer", "Landroid/view/View;", "f", "Landroidx/fragment/app/Fragment;", "v", "getScreenViewManager", "Lcom/tencent/state/map/IMapItemViewManager;", "getServiceProvider", "Lcom/tencent/state/IVasBaseServiceProvider;", "getSqaureMsgBoxReddot", "getSquareAddIcon", "getSquareLocateIcon", "getSquareMsgBoxIcon", "getSquareRoleManager", "Lcom/tencent/state/square/resource/ISquareRoleManager;", "getSquareViewAbility", "Lcom/tencent/state/map/IMapViewManipulator;", "getSquareViewUpdater", "Lcom/tencent/state/square/ISquareViewUpdater;", "getTipsController", "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "getViewBridge", "initMsgBox", "", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "onFragmentViewCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMsgBoxComponent extends TemplateBaseComponent implements ISquareViewManagerProxy, ISquareViewBridge {
    private VasSquareMsgBoxButtonBinding binding;
    private IMsgBoxManager msgBoxManager;
    private final MsgBoxSource msgBoxSource;

    public TemplateMsgBoxComponent(MsgBoxSource msgBoxSource) {
        Intrinsics.checkNotNullParameter(msgBoxSource, "msgBoxSource");
        this.msgBoxSource = msgBoxSource;
    }

    private final IVasBaseServiceProvider getServiceProvider() {
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            return (BasicServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, BasicServiceComponent.class, null, null, 6, null);
        }
        return null;
    }

    private final void initMsgBox() {
        VasBaseFragment fragment;
        QBaseActivity activity;
        if (this.msgBoxManager != null || (fragment = getFragment()) == null || (activity = getActivity()) == null) {
            return;
        }
        MsgBoxManager msgBoxManager = new MsgBoxManager(activity, fragment, this, getServiceProvider(), this.msgBoxSource);
        msgBoxManager.startObserve(MsgBoxOperateFlag.INIT);
        Unit unit = Unit.INSTANCE;
        this.msgBoxManager = msgBoxManager;
    }

    protected abstract View getMsgBoxContainer(Fragment f16, View v3);

    public final MsgBoxSource getMsgBoxSource() {
        return this.msgBoxSource;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public IMapItemViewManager getScreenViewManager() {
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSqaureMsgBoxReddot() {
        VasSquareMsgBoxButtonBinding vasSquareMsgBoxButtonBinding = this.binding;
        if (vasSquareMsgBoxButtonBinding != null) {
            return vasSquareMsgBoxButtonBinding.msgBoxReddot;
        }
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSquareAddIcon() {
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSquareLocateIcon() {
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewBridge
    public View getSquareMsgBoxIcon() {
        VasSquareMsgBoxButtonBinding vasSquareMsgBoxButtonBinding = this.binding;
        if (vasSquareMsgBoxButtonBinding != null) {
            return vasSquareMsgBoxButtonBinding.msgBoxIconContainer;
        }
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public ISquareRoleManager getSquareRoleManager() {
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public IMapViewManipulator getSquareViewAbility() {
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public ISquareViewUpdater getSquareViewUpdater() {
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public SettingTipsController getTipsController() {
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
        View msgBoxContainer = getMsgBoxContainer(f16, v3);
        this.binding = msgBoxContainer != null ? VasSquareMsgBoxButtonBinding.bind(msgBoxContainer) : null;
        initMsgBox();
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public ISquareViewBridge getViewBridge() {
        return this;
    }
}
