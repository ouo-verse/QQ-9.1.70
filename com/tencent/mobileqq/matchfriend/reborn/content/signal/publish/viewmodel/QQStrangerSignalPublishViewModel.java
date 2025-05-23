package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.b;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBaseViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import g82.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBaseViewModel;", "Lg82/a;", "", "", "getLogTag", "", "S1", "", "partnerId", "partnerAdjID", "T1", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "signalConfig", "R1", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository;", "D", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository;", "publishConfigRepository", "<init>", "()V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishViewModel extends QQStrangerSignalBaseViewModel<a, Object> {

    /* renamed from: D, reason: from kotlin metadata */
    private final QQStrangerSignalPublishRepository publishConfigRepository = new QQStrangerSignalPublishRepository();

    public final void S1() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSignalPublishViewModel", Boolean.FALSE, null, null, new QQStrangerSignalPublishViewModel$refreshSignalConfigs$1(this, null), 12, null);
    }

    public final void T1(long partnerId, long partnerAdjID) {
        QLog.i("QQStrangerSignalPublishViewModel", 2, "[requestLastPublishSignalInfo] partnerId: " + partnerId + ", partnerAdjId: " + partnerAdjID);
        if (partnerId != 0 && partnerAdjID != 0) {
            O1(new a.QQStrangerUpdateLastPublishSignalInfoState(partnerId, partnerAdjID));
            return;
        }
        SignalPlazaSvrPB$SignalInfo b16 = b.f244871a.b();
        if (b16 == null) {
            b16 = new SignalPlazaSvrPB$SignalInfo();
            b16.signal_meta.partner_id.set(-1L);
            b16.signal_meta.partner_adj.partner_adj_id.set(-1L);
        }
        O1(new a.QQStrangerUpdateLastPublishSignalInfoState(b16.signal_meta.partner_id.get(), b16.signal_meta.partner_adj.partner_adj_id.get()));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QQStrangerSignalPublishViewModel";
    }

    public final void R1(SignalPB$SignalConfig signalConfig, long partnerAdjID) {
        Intrinsics.checkNotNullParameter(signalConfig, "signalConfig");
        QLog.i("QQStrangerSignalPublishViewModel", 1, "publishSignal signalConfig:  partnerId: " + signalConfig.partner_id + ", partnerAdjId: " + partnerAdjID);
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSignalPublishViewModel", Boolean.FALSE, null, null, new QQStrangerSignalPublishViewModel$publishSignal$1(this, signalConfig, partnerAdjID, null), 12, null);
    }
}
