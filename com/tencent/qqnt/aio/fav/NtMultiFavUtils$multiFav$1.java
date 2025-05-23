package com.tencent.qqnt.aio.fav;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class NtMultiFavUtils$multiFav$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQAppInterface $app;
    final /* synthetic */ ArrayList<ChatMessage> $chatMsgList;
    final /* synthetic */ Contact $contact;
    final /* synthetic */ Context $context;
    final /* synthetic */ Map<String, String> $uin2NickMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtMultiFavUtils$multiFav$1(QQAppInterface qQAppInterface, Context context, Contact contact, ArrayList<ChatMessage> arrayList, Map<String, String> map) {
        super(0);
        this.$app = qQAppInterface;
        this.$context = context;
        this.$contact = contact;
        this.$chatMsgList = arrayList;
        this.$uin2NickMap = map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, contact, arrayList, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQAppInterface app, Context context, Contact contact, ArrayList chatMsgList, Map uin2NickMap) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(chatMsgList, "$chatMsgList");
        Intrinsics.checkNotNullParameter(uin2NickMap, "$uin2NickMap");
        NtMultiFavUtils.f349920a.q(app, context, contact, chatMsgList, uin2NickMap);
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
        final QQAppInterface qQAppInterface = this.$app;
        final Context context = this.$context;
        final Contact contact = this.$contact;
        final ArrayList<ChatMessage> arrayList = this.$chatMsgList;
        final Map<String, String> map = this.$uin2NickMap;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.fav.g
            @Override // java.lang.Runnable
            public final void run() {
                NtMultiFavUtils$multiFav$1.b(QQAppInterface.this, context, contact, arrayList, map);
            }
        }, 32, null, true);
    }
}
