package com.tencent.mobileqq.troop.shortcut.action.processors;

import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.shortcut.actions.Message;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.actions.a;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/action/processors/b;", "Lcom/tencent/mobileqq/troop/shortcut/actions/a;", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "action", "Lcom/tencent/mobileqq/troop/shortcut/actions/b;", "shortcutContext", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements com.tencent.mobileqq.troop.shortcut.actions.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/action/processors/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.action.processors.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.actions.a
    public boolean a(@NotNull TroopShortcutAction action, @NotNull com.tencent.mobileqq.troop.shortcut.actions.b shortcutContext) {
        j e16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, (Object) shortcutContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(shortcutContext, "shortcutContext");
        if (action.f() != TroopShortcutAction.Type.CMD) {
            return false;
        }
        if (shortcutContext.b() == null) {
            QLog.e("TroopShortcut.SendMessageActionProcessor", 1, "Fail to process SendMessage action: aioContext is null");
            return false;
        }
        List<Message> d16 = action.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj : d16) {
            if (((Message) obj).b() == Message.MessageType.MSG_TYPE_SEND_MESSAGE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(((Message) it.next()).a(), 32);
            com.tencent.aio.api.runtime.a b16 = shortcutContext.b();
            if (b16 != null && (e16 = b16.e()) != null) {
                String qQText2 = qQText.toString();
                Intrinsics.checkNotNullExpressionValue(qQText2, "content.toString()");
                e16.h(new AIOMsgSendEvent.TextSendEvent(qQText2));
            }
        }
        if (size < action.d().size()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.shortcut.actions.a
    public void b(@Nullable com.tencent.mobileqq.troop.shortcut.actions.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            a.C8771a.b(this, bVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.actions.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a.C8771a.a(this);
        }
    }
}
