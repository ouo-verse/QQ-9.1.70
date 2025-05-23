package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.api.OnlineStatusListener;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.utils.VMUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J,\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareOnlineStatusComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/state/square/api/OnlineStatusListener;", "()V", "onlineService", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "getSquareGroupVM", "()Lcom/tencent/state/square/SquareViewModel;", "squareGroupVM$delegate", "Lkotlin/Lazy;", "onFragmentDestroyed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onStatusChange", "isSuccess", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusComponent extends SquareBaseComponent implements OnlineStatusListener {
    private static final String TAG = "SquareOnlineStatusComponent";
    private ISquareOnlineStatusService onlineService;

    /* renamed from: squareGroupVM$delegate, reason: from kotlin metadata */
    private final Lazy squareGroupVM;

    public SquareOnlineStatusComponent() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareViewModel>() { // from class: com.tencent.state.square.components.fragment.SquareOnlineStatusComponent$squareGroupVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareViewModel invoke() {
                VasBaseGroupFragment groupFragment;
                SquareViewModel squareViewModel;
                SquareFragment squareFragment = SquareOnlineStatusComponent.this.getSquareFragment();
                if (squareFragment == null || (groupFragment = squareFragment.getGroupFragment()) == null || (squareViewModel = (SquareViewModel) VMUtils.INSTANCE.safelyGet(groupFragment, SquareViewModel.class)) == null) {
                    return null;
                }
                return squareViewModel;
            }
        });
        this.squareGroupVM = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareViewModel getSquareGroupVM() {
        return (SquareViewModel) this.squareGroupVM.getValue();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ISquareOnlineStatusService iSquareOnlineStatusService = this.onlineService;
        if (iSquareOnlineStatusService != null) {
            iSquareOnlineStatusService.destroy();
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (SquareBaseComponentKt.getSquareGroupConfig(this).getEmbedOnlinePanel()) {
            ISquareOnlineStatusService createStatusService = Square.INSTANCE.getConfig().getServiceProvider().createStatusService();
            this.onlineService = createStatusService;
            if (createStatusService != null) {
                createStatusService.registerListener(this);
            }
            ISquareOnlineStatusService iSquareOnlineStatusService = this.onlineService;
            if (iSquareOnlineStatusService != null) {
                iSquareOnlineStatusService.init();
            }
        }
    }

    @Override // com.tencent.state.square.api.OnlineStatusListener
    public void onStatusChange(boolean isSuccess, final int statusId) {
        if (!isSuccess) {
            SquareBaseKt.getSquareLog().i(TAG, "onStatusChange, not success");
            return;
        }
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            if (!fragment.isTopFragment()) {
                SquareBaseKt.getSquareLog().i(TAG, "onStatusChange, but not top");
                return;
            } else {
                VasStatusSquareService.INSTANCE.getUserInfo(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin(), MainScene.SQUARE, null, null, new ResultCallback<SquareAvatarItem>() { // from class: com.tencent.state.square.components.fragment.SquareOnlineStatusComponent$onStatusChange$1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i3, String str, String str2) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareOnlineStatusComponent", "onResultFailure, " + error + ", " + message, null, 4, null);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultSuccess(SquareAvatarItem result) {
                        SquareViewModel squareGroupVM;
                        SquareViewModel squareGroupVM2;
                        Object firstOrNull;
                        if (result == null) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareOnlineStatusComponent", "onStatusChange, onResultSuccess, but null", null, 4, null);
                            return;
                        }
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onStatusChange, onResultSuccess, ");
                        squareGroupVM = SquareOnlineStatusComponent.this.getSquareGroupVM();
                        sb5.append(squareGroupVM == null);
                        sb5.append(", ");
                        sb5.append(statusId);
                        sb5.append(", ");
                        OnlineStatus onlineStatus = result.getExtra().getOnlineStatus();
                        sb5.append(onlineStatus != null ? Integer.valueOf(onlineStatus.getTopStatusId()) : null);
                        sb5.append(", ");
                        OnlineStatus onlineStatus2 = result.getExtra().getOnlineStatus();
                        sb5.append(onlineStatus2 != null ? Integer.valueOf(onlineStatus2.getRichStatus()) : null);
                        squareLog.i("SquareOnlineStatusComponent", sb5.toString());
                        squareGroupVM2 = SquareOnlineStatusComponent.this.getSquareGroupVM();
                        if (squareGroupVM2 != null) {
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) result.getActions());
                            squareGroupVM2.updateMeStatus(new StatusUpdateData((AvatarAction) firstOrNull, result.getExtra().getOnlineStatus()));
                        }
                    }
                });
                return;
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "onStatusChange, fragment is null");
    }
}
