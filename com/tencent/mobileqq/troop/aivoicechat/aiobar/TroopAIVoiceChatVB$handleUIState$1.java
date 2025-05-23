package com.tencent.mobileqq.troop.aivoicechat.aiobar;

import android.text.Editable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.a;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.util.TroopAIVoiceChatImeHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatVB$handleUIState$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TroopAIVoiceChatVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopAIVoiceChatVB$handleUIState$1(TroopAIVoiceChatVB troopAIVoiceChatVB) {
        super(0);
        this.this$0 = troopAIVoiceChatVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopAIVoiceChatVB this$0) {
        boolean I1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopAIVoiceChatVB", 1, "[handleUIState] postDelayed ExitAIVoiceChatState");
        I1 = this$0.I1();
        this$0.sendIntent(a.b.f293858d);
        this$0.x1().f().fullScroll(17);
        Editable text = this$0.z1().getText();
        if (text != null) {
            text.clear();
        }
        if (I1) {
            this$0.K1();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TroopAIVoiceChatImeHelper A1;
        QLog.i("TroopAIVoiceChatVB", 1, "[handleUIState] StartAIChatExitAnim animHide");
        A1 = this.this$0.A1();
        TroopAIVoiceChatImeHelper.j(A1, null, 1, null);
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final TroopAIVoiceChatVB troopAIVoiceChatVB = this.this$0;
        uIHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.g
            @Override // java.lang.Runnable
            public final void run() {
                TroopAIVoiceChatVB$handleUIState$1.b(TroopAIVoiceChatVB.this);
            }
        }, 240L);
    }
}
