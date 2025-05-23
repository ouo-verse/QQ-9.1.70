package com.tencent.state.library.focus.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusRouterComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "onFragmentCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onViewClick", "viewId", "", "extra", "", "openSquareDetailPage", "uin", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusRouterComponent extends FocusBaseComponent {
    private static final String TAG = "FocusRouterComponent";
    private ISquareBaseMessageService aioService;

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        BasicServiceComponent basicServiceComponent;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentCreated(fm5, f16, savedInstanceState);
        VasBaseFragment fragment = getFragment();
        this.aioService = (fragment == null || (basicServiceComponent = (BasicServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, BasicServiceComponent.class, null, null, 6, null)) == null) ? null : basicServiceComponent.getMessageService();
    }

    public final void openSquareDetailPage(String uin) {
        String str;
        Intrinsics.checkNotNullParameter(uin, "uin");
        DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
        VasBaseFragment fragment = getFragment();
        MainScene mainScene = MainScene.LIBRARY;
        SubScene subScene = SubScene.UNKNOWN;
        QBaseActivity activity = getActivity();
        if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
            str = "";
        }
        DetailFragmentLauncher.launch$default(detailFragmentLauncher, fragment, new EntranceSource(mainScene, subScene, str), uin, null, null, 24, null);
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onViewClick(int viewId, Object extra) {
        String uin;
        if (viewId != 4) {
            return;
        }
        if (!(extra instanceof User)) {
            extra = null;
        }
        User user = (User) extra;
        if (user == null || (uin = user.getUin()) == null) {
            return;
        }
        ISquareBaseMessageService iSquareBaseMessageService = this.aioService;
        if (iSquareBaseMessageService != null && !iSquareBaseMessageService.isFriend(uin) && SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode()) {
            SquareBaseKt.getSquareLog().d(TAG, "click avatar bubble but is stranger and in study with teenager shield");
        } else {
            openSquareDetailPage(uin);
        }
    }
}
