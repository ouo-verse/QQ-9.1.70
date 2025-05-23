package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.b;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBaseViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import k82.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0001\u0011\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareSelfSignalViewModel;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBaseViewModel;", "Lk82/a;", "", "", "getLogTag", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "T1", "U1", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository;", "D", "Lkotlin/Lazy;", "R1", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository;", "factory", "com/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareSelfSignalViewModel$listener$2$1", "E", "S1", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareSelfSignalViewModel$listener$2$1;", "listener", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareSelfSignalViewModel extends QQStrangerSignalBaseViewModel<a, Object> {

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy factory;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy listener;

    public QQStrangerSignalSquareSelfSignalViewModel() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalSquareRepository>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$factory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalSquareRepository invoke() {
                return new QQStrangerSignalSquareRepository();
            }
        });
        this.factory = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<QQStrangerSignalSquareSelfSignalViewModel$listener$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final QQStrangerSignalSquareSelfSignalViewModel qQStrangerSignalSquareSelfSignalViewModel = QQStrangerSignalSquareSelfSignalViewModel.this;
                return new com.tencent.mobileqq.matchfriend.reborn.content.signal.a() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2.1
                    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.a
                    public void a(SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QQStrangerSelfSignalViewModel", 2, "[onSelfSignalInfoUpdate] signalInfo: " + (signalInfo != null ? ModelExtKt.A(signalInfo) : null) + ", justNowPublish: " + justNowPublish);
                        }
                        QQStrangerSignalSquareSelfSignalViewModel.this.O1(new a.QQStrangerUpdateSelfSignalInfoState(signalInfo, justNowPublish));
                        boolean z16 = false;
                        if (signalInfo != null && ModelExtKt.B(signalInfo)) {
                            z16 = true;
                        }
                        if (z16) {
                            CorountineFunKt.e(ViewModelKt.getViewModelScope(QQStrangerSignalSquareSelfSignalViewModel.this), "QQStrangerSelfSignalViewModel", Boolean.FALSE, null, null, new QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1(QQStrangerSignalSquareSelfSignalViewModel.this, null), 12, null);
                        }
                    }
                };
            }
        });
        this.listener = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSignalSquareRepository R1() {
        return (QQStrangerSignalSquareRepository) this.factory.getValue();
    }

    private final QQStrangerSignalSquareSelfSignalViewModel$listener$2.AnonymousClass1 S1() {
        return (QQStrangerSignalSquareSelfSignalViewModel$listener$2.AnonymousClass1) this.listener.getValue();
    }

    public final void T1() {
        b.f244871a.e(true);
    }

    public final void U1() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSelfSignalViewModel", Boolean.FALSE, null, null, new QQStrangerSignalSquareSelfSignalViewModel$saveShowExpireTime$1(this, null), 12, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQStrangerSelfSignalViewModel";
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBaseViewModel
    public void onCreate() {
        b.f244871a.a(S1());
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBaseViewModel
    public void onDestroy() {
        b.f244871a.f(S1());
    }
}
