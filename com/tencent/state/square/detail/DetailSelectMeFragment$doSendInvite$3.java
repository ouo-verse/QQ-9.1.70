package com.tencent.state.square.detail;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.detail.StatusReportHelper;
import com.tencent.state.square.invite.ISquareInviteManager;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.square.resource.MeResourceRecorderKt;
import com.tencent.state.square.resource.RecordRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/detail/DetailSelectMeFragment$doSendInvite$3", "Lcom/tencent/state/service/ResultCallback;", "", "onResultFailure", "", "error", "", "message", "prompt", "onResultSuccess", "billNo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectMeFragment$doSendInvite$3 implements ResultCallback<String> {
    final /* synthetic */ String $customText;
    final /* synthetic */ OnlineStatus $data;
    final /* synthetic */ BaseResourceInfo $motion;
    final /* synthetic */ RecordResourceInfo $resource;
    final /* synthetic */ String $uin;
    final /* synthetic */ DetailSelectMeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetailSelectMeFragment$doSendInvite$3(DetailSelectMeFragment detailSelectMeFragment, OnlineStatus onlineStatus, BaseResourceInfo baseResourceInfo, String str, RecordResourceInfo recordResourceInfo, String str2) {
        this.this$0 = detailSelectMeFragment;
        this.$data = onlineStatus;
        this.$motion = baseResourceInfo;
        this.$customText = str;
        this.$resource = recordResourceInfo;
        this.$uin = str2;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message, String prompt) {
        DetailSelectMeView detailSelectMeView;
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "DetailSelectMeFragment", "doSendInvite failed: error=" + error + ", message=" + message, null, 4, null);
        this.this$0.onInviteRequestFailed(prompt, "\u9080\u8bf7\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        detailSelectMeView = this.this$0.selectedView;
        if (detailSelectMeView != null) {
            detailSelectMeView.failPublish();
        }
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(String billNo) {
        Resource copyResource;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        SquareBaseKt.getSquareLog().i("DetailSelectMeFragment", "doSendInvite success: billNo=" + billNo);
        DetailSelectMeFragment detailSelectMeFragment = this.this$0;
        OnlineStatus onlineStatus = this.$data;
        BaseResourceInfo baseResourceInfo = this.$motion;
        detailSelectMeFragment.doPublish(onlineStatus, (baseResourceInfo != null ? Integer.valueOf(baseResourceInfo.getMotionIdForPublish()) : null).intValue(), this.$customText, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doSendInvite$3$onResultSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ISquareInviteManager inviter = DetailSelectMeFragment$doSendInvite$3.this.this$0.getServiceProvider().getInviter();
                if (inviter != null) {
                    ISquareInviteManager.DefaultImpls.getInviteStatus$default(inviter, true, null, 2, null);
                }
                if (z16) {
                    DetailSelectMeFragment$doSendInvite$3.this.this$0.published = true;
                    StatusReportHelper.INSTANCE.reportPublishSuccess(StatusReportHelper.PublishScene.MULTI);
                }
            }
        });
        copyResource = SquareItemKt.copyResource(r0, (r21 & 1) != 0 ? r0.getActionId() : 0, (r21 & 2) != 0 ? r0.getDynamic() : null, (r21 & 4) != 0 ? r0.getStatic() : null, (r21 & 8) != 0 ? r0.getShowSize() : null, (r21 & 16) != 0 ? r0.getRecordSize() : null, (r21 & 32) != 0 ? r0.getIsDefault() : false, (r21 & 64) != 0 ? r0.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r0.getActionType() : 0, (r21 & 256) != 0 ? r0.getActionStyle() : 0, (r21 & 512) != 0 ? this.$resource.getResource().getFilament() : null);
        final Resource resetDefault = copyResource.resetDefault();
        this.this$0.checkRecord(resetDefault, this.$data, this.$uin, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doSendInvite$3$onResultSuccess$2
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
                MeResourceRecorder meResourceRecorder;
                Integer num;
                List listOf;
                if (z16) {
                    meResourceRecorder = DetailSelectMeFragment$doSendInvite$3.this.this$0.recorder;
                    RecordRequest recordRequest$default = MeResourceRecorderKt.toRecordRequest$default(resetDefault, null, 0, 3, null);
                    DetailSelectMeFragment$doSendInvite$3 detailSelectMeFragment$doSendInvite$3 = DetailSelectMeFragment$doSendInvite$3.this;
                    String str = detailSelectMeFragment$doSendInvite$3.$uin;
                    num = detailSelectMeFragment$doSendInvite$3.this$0.currentFriendGender;
                    UserIdentifier userIdentifier = new UserIdentifier(str, num);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(new UserIdentifier(RecordIdentifier.INSTANCE.getSelfUin(), Integer.valueOf(SquareRecordManager.INSTANCE.getGender())));
                    MeResourceRecorder.startRecord$default(meResourceRecorder, recordRequest$default, userIdentifier, listOf, (IResourceCallback) null, 8, (Object) null);
                }
            }
        });
    }
}
