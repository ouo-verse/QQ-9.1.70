package com.tencent.mobileqq.aio.animation.business;

import android.os.Handler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isDragonKing", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
final class DragonKingEggsPlayer$play$1 extends Lambda implements Function1<Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOAnimationContainer $animContainer;
    final /* synthetic */ BaseQQAppInterface $app;
    final /* synthetic */ int $delayTime;
    final /* synthetic */ com.tencent.mobileqq.aio.animation.config.a $rule;
    final /* synthetic */ Handler $uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragonKingEggsPlayer$play$1(com.tencent.mobileqq.aio.animation.config.a aVar, BaseQQAppInterface baseQQAppInterface, Handler handler, int i3, AIOAnimationContainer aIOAnimationContainer) {
        super(1);
        this.$rule = aVar;
        this.$app = baseQQAppInterface;
        this.$uiHandler = handler;
        this.$delayTime = i3;
        this.$animContainer = aIOAnimationContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, baseQQAppInterface, handler, Integer.valueOf(i3), aIOAnimationContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOAnimationContainer animContainer, String str, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.i lottieAnimationInfo) {
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(lottieAnimationInfo, "$lottieAnimationInfo");
        QLog.i("DragonKingEggsPlayer", 1, "[play] start to play animation");
        animContainer.m(7, 400, str, Integer.valueOf(rule.h()), lottieAnimationInfo);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16 && (i3 = this.$rule.i()) != null) {
            final com.tencent.mobileqq.aio.animation.config.a aVar = this.$rule;
            BaseQQAppInterface baseQQAppInterface = this.$app;
            Handler handler = this.$uiHandler;
            int i16 = this.$delayTime;
            final AIOAnimationContainer aIOAnimationContainer = this.$animContainer;
            Iterator<T> it = i3.iterator();
            while (it.hasNext()) {
                final String k3 = ((com.tencent.mobileqq.aio.animation.config.e) it.next()).k();
                if (k3 == null) {
                    QLog.i("DragonKingEggsPlayer", 1, "[play] image valid is empty, rule=" + aVar);
                    return;
                }
                String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
                final com.tencent.mobileqq.aio.animation.data.i iVar = new com.tencent.mobileqq.aio.animation.data.i(1, currentAccountUin, null);
                handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        DragonKingEggsPlayer$play$1.b(AIOAnimationContainer.this, k3, aVar, iVar);
                    }
                }, i16);
            }
        }
    }
}
