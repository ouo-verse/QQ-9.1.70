package com.tencent.mobileqq.vas.social.record;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.social.SocialActionRecordHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.zplan.meme.model.MemeResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J*\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/f;", "Lcom/tencent/mobileqq/vas/social/record/b;", "Lcom/tencent/state/square/api/RecordSuccessListener;", "", "actionId", "Lcom/tencent/state/square/record/RecordIdentifier;", "recordIdentifier", "Lcom/tencent/state/square/data/RecordSource;", "cover", "mp4", "", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "k", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "currentState", "", "p", "type", "errorCode", "onRecordError", "onLocalRecordSuccess", "onCloudRecordSuccess", "onUploadSuccess", UserInfo.SEX_FEMALE, "Ljava/lang/Integer;", "encodeType", "Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", "Lcom/tencent/mobileqq/vas/social/record/c;", "listener", "<init>", "(Lcom/tencent/mobileqq/vas/data/b;Lcom/tencent/mobileqq/vas/social/record/c;)V", "G", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f extends b implements RecordSuccessListener {
    private static boolean H = true;

    /* renamed from: F, reason: from kotlin metadata */
    private Integer encodeType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.tencent.mobileqq.vas.data.b taskInfo, c cVar) {
        super(taskInfo, RecordState.UN_RECORDED, cVar);
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
    }

    private final int r() {
        int h16 = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().h();
        SocialActionRecordHelper socialActionRecordHelper = SocialActionRecordHelper.f310651d;
        QLog.i("RecordStepEngine", 1, "getRecordEncodeType configEncodeType:" + h16 + ", mp4SoftEncoderPrepared:" + socialActionRecordHelper.r());
        return (h16 == 0 && socialActionRecordHelper.r()) ? 0 : 1;
    }

    private final void s(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        getStepProduct().h(mp42);
        getStepProduct().g(cover);
        if (actionId == getTaskInfo().getActionId() && recordIdentifier.equals(getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String())) {
            n();
            ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).removeRecordDoneListener(this);
            QLog.d("RecordStepEngine", 1, "[RECORD] 5-1.3 onRecordSuccess: info:" + getTaskInfo() + ", mp4:" + mp42 + ", cover:" + cover);
        }
    }

    @Override // com.tencent.mobileqq.vas.social.record.b
    public void k(RecordStepProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).addRecordDoneListener(this);
        Integer valueOf = Integer.valueOf(r());
        SocialActionRecordHelper.f310651d.i(getTaskInfo(), valueOf.intValue());
        this.encodeType = valueOf;
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onCloudRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
        s(actionId, recordIdentifier, cover, mp42);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onLocalRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
        s(actionId, recordIdentifier, cover, mp42);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordDone(boolean z16, MemeResult memeResult, RecordIdentifier recordIdentifier) {
        RecordSuccessListener.DefaultImpls.onRecordDone(this, z16, memeResult, recordIdentifier);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordError(int actionId, int type, int errorCode, RecordIdentifier recordIdentifier) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        if (actionId == getTaskInfo().getActionId()) {
            SocialActionRecordHelper socialActionRecordHelper = SocialActionRecordHelper.f310651d;
            if (socialActionRecordHelper.q(type) == getTaskInfo().getMode()) {
                QLog.d("RecordStepEngine", 1, "[RECORD] 5-1.3 onRecordError: errorCode:" + errorCode + ", info:" + getTaskInfo() + ", type:" + type + ", encodeType:" + this.encodeType);
                Integer num = this.encodeType;
                if (num != null && num.intValue() == 0) {
                    this.encodeType = 1;
                    socialActionRecordHelper.i(getTaskInfo(), 1);
                }
            }
        }
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onUploadSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vas.social.record.b
    public boolean p(RecordState currentState) {
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        if (SocialActionRecordHelper.f310651d.m(getTaskInfo()) == null || getTaskInfo().getForceCallback()) {
            return false;
        }
        return super.p(currentState);
    }
}
