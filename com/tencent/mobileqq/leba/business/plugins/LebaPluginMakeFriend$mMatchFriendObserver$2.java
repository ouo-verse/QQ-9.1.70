package com.tencent.mobileqq.leba.business.plugins;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/relation/common/servlet/b;", "invoke", "()Lcom/tencent/relation/common/servlet/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes15.dex */
final class LebaPluginMakeFriend$mMatchFriendObserver$2 extends Lambda implements Function0<com.tencent.relation.common.servlet.b> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LebaPluginMakeFriend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LebaPluginMakeFriend$mMatchFriendObserver$2(LebaPluginMakeFriend lebaPluginMakeFriend) {
        super(0);
        this.this$0 = lebaPluginMakeFriend;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginMakeFriend);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LebaPluginMakeFriend this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("LebaPluginMakeFriend", 2, "mMatchFriendObserver type: " + i3 + " ");
        if (i3 == 14) {
            LebaPluginMakeFriend.W(this$0, false, 1, null);
            this$0.A();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.relation.common.servlet.b invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.relation.common.servlet.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final LebaPluginMakeFriend lebaPluginMakeFriend = this.this$0;
        return new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.leba.business.plugins.n
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                LebaPluginMakeFriend$mMatchFriendObserver$2.b(LebaPluginMakeFriend.this, i3, z16, obj);
            }
        };
    }
}
