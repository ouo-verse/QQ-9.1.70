package com.tencent.mobileqq.qqlive.huya;

import com.huya.huyasdk.api.HuyaLiveJoinCallback;
import com.huya.huyasdk.api.HuyaLiveJoinConfig;
import com.huya.huyasdk.api.HuyaLiveJoinResult;
import com.huya.huyasdk.api.HuyaLiveRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveHuYa$enterRoom$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function0<Unit> $failed;
    final /* synthetic */ Function0<Unit> $success;
    final /* synthetic */ long $uid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveHuYa$enterRoom$1(long j3, Function0<Unit> function0, Function0<Unit> function02) {
        super(0);
        this.$uid = j3;
        this.$success = function0;
        this.$failed = function02;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), function0, function02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 function0, Function0 function02, HuyaLiveJoinResult huyaLiveJoinResult) {
        QLog.d("QQLiveHuYa", 2, "enterHuYaRoom joinLive result:" + huyaLiveJoinResult);
        boolean z16 = false;
        if (huyaLiveJoinResult != null && huyaLiveJoinResult.isSucceed) {
            z16 = true;
        }
        if (z16) {
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            QLog.e("QQLiveHuYa", 1, "enterHuYaRoom joinLive failed");
            if (function02 != null) {
                function02.invoke();
            }
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
        HuyaLiveJoinConfig huyaLiveJoinConfig = new HuyaLiveJoinConfig(this.$uid, null);
        final Function0<Unit> function0 = this.$success;
        final Function0<Unit> function02 = this.$failed;
        HuyaLiveRoom.joinLive(huyaLiveJoinConfig, new HuyaLiveJoinCallback() { // from class: com.tencent.mobileqq.qqlive.huya.h
            @Override // com.huya.huyasdk.api.HuyaLiveJoinCallback
            public final void onJoinResult(HuyaLiveJoinResult huyaLiveJoinResult) {
                QQLiveHuYa$enterRoom$1.b(Function0.this, function02, huyaLiveJoinResult);
            }
        });
    }
}
