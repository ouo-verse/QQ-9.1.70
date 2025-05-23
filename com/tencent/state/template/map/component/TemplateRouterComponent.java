package com.tencent.state.template.map.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.SubScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J<\u0010\u0011\u001a\u00020\n2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u00030\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/template/map/component/TemplateRouterComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "mainScene", "Lcom/tencent/state/square/detail/MainScene;", "(Lcom/tencent/state/square/detail/MainScene;)V", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "getMainScene", "()Lcom/tencent/state/square/detail/MainScene;", "onFragmentCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "viewId", "extra", "", "openSquareDetailPage", "uin", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateRouterComponent extends TemplateMapBaseComponent {
    private static final String TAG = "TemplateRouterComponent";
    private ISquareBaseMessageService aioService;
    private final MainScene mainScene;

    public TemplateRouterComponent(MainScene mainScene) {
        Intrinsics.checkNotNullParameter(mainScene, "mainScene");
        this.mainScene = mainScene;
    }

    public final MainScene getMainScene() {
        return this.mainScene;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        BasicServiceComponent basicServiceComponent;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentCreated(fm5, f16, savedInstanceState);
        VasBaseFragment fragment = getFragment();
        this.aioService = (fragment == null || (basicServiceComponent = (BasicServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, BasicServiceComponent.class, null, null, 6, null)) == null) ? null : basicServiceComponent.getMessageService();
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId != 3) {
            return;
        }
        if (!(extra instanceof String)) {
            extra = null;
        }
        String str = (String) extra;
        if (str != null) {
            ISquareBaseMessageService iSquareBaseMessageService = this.aioService;
            if (iSquareBaseMessageService != null && !iSquareBaseMessageService.isFriend(str) && SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode()) {
                SquareBaseKt.getSquareLog().d(TAG, "click avatar bubble but is stranger and in study with teenager shield");
            } else {
                openSquareDetailPage(str);
            }
        }
    }

    public final void openSquareDetailPage(String uin) {
        String str;
        Intrinsics.checkNotNullParameter(uin, "uin");
        DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
        VasBaseFragment fragment = getFragment();
        MainScene mainScene = this.mainScene;
        SubScene subScene = SubScene.UNKNOWN;
        QBaseActivity activity = getActivity();
        if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
            str = "";
        }
        DetailFragmentLauncher.launch$default(detailFragmentLauncher, fragment, new EntranceSource(mainScene, subScene, str), uin, null, null, 24, null);
    }
}
