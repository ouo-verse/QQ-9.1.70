package com.tencent.mobileqq.qqlive.huya;

import com.huya.huyasdk.api.HuyaLiveBarrage;
import com.huya.huyasdk.api.HuyaLiveBarrageSendInfo;
import com.huya.huyasdk.api.HuyaLiveBarrageSendResult;
import com.huya.huyasdk.api.SendLiveBarrageCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveHuYa$sendBarrage$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ b $barrageInfo;
    final /* synthetic */ Function2<Boolean, Integer, Unit> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQLiveHuYa$sendBarrage$1(b bVar, Function2<? super Boolean, ? super Integer, Unit> function2) {
        super(0);
        this.$barrageInfo = bVar;
        this.$callback = function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 function2, HuyaLiveBarrageSendResult huyaLiveBarrageSendResult) {
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(huyaLiveBarrageSendResult.isSuccess), Integer.valueOf(huyaLiveBarrageSendResult.resCode));
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        HuyaLiveBarrageSendInfo huyaLiveBarrageSendInfo = new HuyaLiveBarrageSendInfo();
        huyaLiveBarrageSendInfo.senderNick = this.$barrageInfo.b();
        huyaLiveBarrageSendInfo.content = this.$barrageInfo.a();
        final Function2<Boolean, Integer, Unit> function2 = this.$callback;
        HuyaLiveBarrage.sendBarrage(huyaLiveBarrageSendInfo, new SendLiveBarrageCallback() { // from class: com.tencent.mobileqq.qqlive.huya.i
            @Override // com.huya.huyasdk.api.SendLiveBarrageCallback
            public final void onLiveBarrageSend(HuyaLiveBarrageSendResult huyaLiveBarrageSendResult) {
                QQLiveHuYa$sendBarrage$1.b(Function2.this, huyaLiveBarrageSendResult);
            }
        });
    }
}
