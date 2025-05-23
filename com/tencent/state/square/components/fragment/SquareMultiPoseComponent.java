package com.tencent.state.square.components.fragment;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasMultiMotionService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.components.SquareBlockDialogUtils;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareDetailIntent;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.detail.StatusPublishHelper;
import com.tencent.state.square.detail.StatusReportHelper;
import com.tencent.state.square.invite.ISquareInviteManager;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u001a\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareMultiPoseComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "isFromArk", "", "publishHelper", "Lcom/tencent/state/square/detail/StatusPublishHelper;", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "continueMultiPose", "", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "initInviteStatus", "initObserver", "initialize", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "showMultiPoseAutoEndDialog", "context", "Landroid/content/Context;", "showMultiPoseEndByOtherDialog", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMultiPoseComponent extends SquareBaseComponent {
    private static final String FROM_ARK = "em_zplan_entrance_ark_square";
    private static final String TAG = "SquareMultiPoseComponent";
    private boolean isFromArk;
    private final StatusPublishHelper publishHelper = new StatusPublishHelper();
    private SquareViewModel squareGroupVM;

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueMultiPose(SquareMultiMotionDetailData inviteState) {
        QBaseActivity activity = getActivity();
        if (activity != null) {
            VasMultiMotionService.INSTANCE.sendInviteArk(inviteState.getOtherUin(), inviteState.getResource().getActionId(), Integer.valueOf(inviteState.getSingleMotionId()), inviteState.getStatusInfo(), inviteState.getStatusInfo().getCustomText(), new SquareMultiPoseComponent$continueMultiPose$1(this, inviteState, activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initInviteStatus() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ISquareInviteManager inviter;
        if (SquareBlockDialogUtils.INSTANCE.isBlockDialog(getActivity()) && (!Intrinsics.areEqual(SquareGroupReportComponentKt.getSourceFrom(getActivity()), LauncherConst.SQUARE_SOURCE_QQ_ONLINE_STATE))) {
            return;
        }
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareServiceProvider.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareServiceProvider.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareServiceProvider.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        SquareServiceProvider squareServiceProvider = (SquareServiceProvider) fragmentComponent;
        if (squareServiceProvider == null || (inviter = squareServiceProvider.getInviter()) == null) {
            return;
        }
        inviter.getInviteStatus(false, new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.components.fragment.SquareMultiPoseComponent$initInviteStatus$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareMultiMotionDetailData result) {
                QBaseActivity activity;
                QBaseActivity activity2;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.getInviteStatus() == 4) {
                    VasMultiMotionService.resetUserInvite$default(VasMultiMotionService.INSTANCE, null, 1, null);
                    activity2 = SquareMultiPoseComponent.this.getActivity();
                    if (activity2 != null) {
                        SquareMultiPoseComponent.this.showMultiPoseAutoEndDialog(activity2, result);
                        return;
                    }
                    return;
                }
                if (result.getInviteStatus() == 3) {
                    VasMultiMotionService.resetUserInvite$default(VasMultiMotionService.INSTANCE, null, 1, null);
                    activity = SquareMultiPoseComponent.this.getActivity();
                    if (activity != null) {
                        SquareMultiPoseComponent.this.showMultiPoseEndByOtherDialog(activity, result);
                    }
                }
            }
        });
    }

    private final void initObserver() {
        VasBaseFragment parentFragment;
        VasBaseFragment fragment;
        LiveData<Boolean> isScaleAnimDone;
        QBaseActivity activity = getActivity();
        if (activity == null || (parentFragment = getParentFragment()) == null || (fragment = getFragment()) == null) {
            return;
        }
        this.isFromArk = Intrinsics.areEqual(SquareGroupReportComponentKt.getSourceFrom(activity), FROM_ARK);
        this.publishHelper.init();
        SquareViewModel squareViewModel = (SquareViewModel) VMUtils.INSTANCE.safelyGet(parentFragment, SquareViewModel.class);
        this.squareGroupVM = squareViewModel;
        if (squareViewModel == null || (isScaleAnimDone = squareViewModel.isScaleAnimDone()) == null) {
            return;
        }
        isScaleAnimDone.observe(fragment, new Observer<Boolean>() { // from class: com.tencent.state.square.components.fragment.SquareMultiPoseComponent$initObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    SquareMultiPoseComponent.this.initInviteStatus();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMultiPoseAutoEndDialog(Context context, final SquareMultiMotionDetailData inviteState) {
        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
        String str = "\u4f60\u548c" + inviteState.getOtherNick() + "\u7684\u53cc\u4ebaPOSE\u8fc7\u671f\u4e86~";
        String string = context.getString(R.string.f169767xh4);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026i_end_dialog_change_pose)");
        String string2 = context.getString(R.string.xh6);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026end_dialog_continue_pose)");
        squareCommon.showDialog(context, str, string, string2, (String) null, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareMultiPoseComponent$showMultiPoseAutoEndDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                boolean z17;
                if (!z16) {
                    SquareMultiPoseComponent.this.continueMultiPose(inviteState);
                } else {
                    SquareView mapView = SquareMultiPoseComponent.this.getMapView();
                    if (mapView != null) {
                        BaseMapView.scaleToMeDetail$default(mapView, null, 1, null);
                    }
                }
                StatusReportHelper statusReportHelper = StatusReportHelper.INSTANCE;
                z17 = SquareMultiPoseComponent.this.isFromArk;
                statusReportHelper.reportExpiredMultiDialogClick(z16, z17);
            }
        });
        StatusReportHelper.INSTANCE.reportExpiredMultiDialogExposure(this.isFromArk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMultiPoseEndByOtherDialog(Context context, final SquareMultiMotionDetailData inviteState) {
        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
        String str = inviteState.getOtherNick() + "\u7ed3\u675f\u4e86\u4f60\u4eec\u7684\u53cc\u4ebaPOSE~";
        String string = context.getString(R.string.xh5);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026end_dialog_change_pose_2)");
        String string2 = context.getString(R.string.f169766xh3);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026end_dialog_change_friend)");
        squareCommon.showDialog(context, str, string, string2, (String) null, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareMultiPoseComponent$showMultiPoseEndByOtherDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                boolean z17;
                if (z16) {
                    SquareView mapView = SquareMultiPoseComponent.this.getMapView();
                    if (mapView != null) {
                        BaseMapView.scaleToMeDetail$default(mapView, null, 1, null);
                    }
                } else {
                    SquareView mapView2 = SquareMultiPoseComponent.this.getMapView();
                    if (mapView2 != null) {
                        mapView2.scaleToMeDetail(new SquareDetailIntent(Integer.valueOf(inviteState.getResource().getActionId())));
                    }
                }
                StatusReportHelper statusReportHelper = StatusReportHelper.INSTANCE;
                z17 = SquareMultiPoseComponent.this.isFromArk;
                statusReportHelper.reportEndMultiDialogClick(z16, z17);
            }
        });
        StatusReportHelper.INSTANCE.reportEndMultiDialogExposure(this.isFromArk);
    }

    public final void initialize() {
        initObserver();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.publishHelper.destroy();
    }
}
