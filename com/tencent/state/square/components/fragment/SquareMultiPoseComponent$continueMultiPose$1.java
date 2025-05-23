package com.tencent.state.square.components.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.detail.StatusPublishHelper;
import com.tencent.state.square.detail.StatusReportHelper;
import com.tencent.state.square.invite.ISquareInviteManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/components/fragment/SquareMultiPoseComponent$continueMultiPose$1", "Lcom/tencent/state/service/ResultCallback;", "", "onResultFailure", "", "error", "", "message", "prompt", "onResultSuccess", "billNo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMultiPoseComponent$continueMultiPose$1 implements ResultCallback<String> {
    final /* synthetic */ QBaseActivity $context;
    final /* synthetic */ SquareMultiMotionDetailData $inviteState;
    final /* synthetic */ SquareMultiPoseComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareMultiPoseComponent$continueMultiPose$1(SquareMultiPoseComponent squareMultiPoseComponent, SquareMultiMotionDetailData squareMultiMotionDetailData, QBaseActivity qBaseActivity) {
        this.this$0 = squareMultiPoseComponent;
        this.$inviteState = squareMultiMotionDetailData;
        this.$context = qBaseActivity;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message, String prompt) {
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareMultiPoseComponent", "continueMultiPose failed: error=" + error + ", message=" + message, null, 4, null);
        if (prompt == null || prompt.length() == 0) {
            prompt = "\u7eed\u671f\u5931\u8d25";
        }
        SquareBaseKt.getSquareCommon().showToastSafely(this.$context, prompt, 1);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(String billNo) {
        StatusPublishHelper statusPublishHelper;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        SquareBaseKt.getSquareLog().i("SquareMultiPoseComponent", "continueMultiPose success: billNo=" + billNo + ", action=" + this.$inviteState.getResource().getActionId());
        statusPublishHelper = this.this$0.publishHelper;
        statusPublishHelper.doPublish(this.$context, this.$inviteState.getStatusInfo(), this.$inviteState.getResource().getActionId(), this.$inviteState.getStatusInfo().getCustomText(), new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null), new Function1<StatusPublishHelper.PublishResult, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareMultiPoseComponent$continueMultiPose$1$onResultSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StatusPublishHelper.PublishResult publishResult) {
                invoke2(publishResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StatusPublishHelper.PublishResult it) {
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                ISquareInviteManager inviter;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isStatusSuccess()) {
                    SquareBaseKt.getSquareCommon().showToastSafely(SquareMultiPoseComponent$continueMultiPose$1.this.$context, "\u7eed\u671f\u6210\u529f", 2);
                    StatusReportHelper.INSTANCE.reportPublishSuccess(StatusReportHelper.PublishScene.CONTINUE);
                    SquareMultiPoseComponent squareMultiPoseComponent = SquareMultiPoseComponent$continueMultiPose$1.this.this$0;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(squareMultiPoseComponent instanceof VasBaseFragmentComponentGroup) ? null : squareMultiPoseComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null) && ((parent = squareMultiPoseComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareServiceProvider.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) squareMultiPoseComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareServiceProvider.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) squareMultiPoseComponent).parentFragment;
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
                    inviter.getInviteStatus(true, new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.components.fragment.SquareMultiPoseComponent$continueMultiPose$1$onResultSuccess$1.1
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
                            ISquareViewUpdater updater;
                            Intrinsics.checkNotNullParameter(result, "result");
                            if (result.isInviteSuccess()) {
                                SquareBaseKt.getSquareLog().i("SquareMultiPoseComponent", "update resource when continue multi success: " + result.getResource());
                                SquareView mapView = SquareMultiPoseComponent$continueMultiPose$1.this.this$0.getMapView();
                                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                                    return;
                                }
                                IMapViewUpdater.DefaultImpls.updateMeResource$default(updater, result.getResource(), false, 2, null);
                            }
                        }
                    });
                }
            }
        });
    }
}
