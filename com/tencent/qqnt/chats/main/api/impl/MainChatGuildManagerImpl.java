package com.tencent.qqnt.chats.main.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.api.IMainChatGuildManager;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J-\u0010\f\u001a\u00020\u00042#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/impl/MainChatGuildManagerImpl;", "Lcom/tencent/qqnt/chats/main/api/IMainChatGuildManager;", "Lcom/tencent/qqnt/kernel/api/aa;", "getService", "", "scrollToGuildHelper", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Lkotlin/ParameterName;", "name", "result", "callback", "findGuildHelper", "<init>", "()V", "Companion", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatGuildManagerImpl implements IMainChatGuildManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "MainChatGuildManagerImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/impl/MainChatGuildManagerImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.api.impl.MainChatGuildManagerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MainChatGuildManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void findGuildHelper$lambda$1(Function1 callback, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) arrayList.get(0);
            callback.invoke(recentContactInfo);
            QLog.i(TAG, 4, "[findGuildHelper] guildHelperItem=" + recentContactInfo);
            return;
        }
        callback.invoke(null);
        QLog.i(TAG, 1, "[findGuildHelper] foundContacts == null or size == 0");
    }

    private final aa getService() {
        IKernelService i3 = f.i();
        if (i3 != null) {
            return i3.getRecentContactService();
        }
        return null;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatGuildManager
    public void findGuildHelper(@NotNull final Function1<? super RecentContactInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        aa service = getService();
        if (service != null) {
            Contact contact = new Contact();
            contact.setChatType(60);
            service.F0(contact, new IGetContactsCallback() { // from class: com.tencent.qqnt.chats.main.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    MainChatGuildManagerImpl.findGuildHelper$lambda$1(Function1.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatGuildManager
    public void scrollToGuildHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            findGuildHelper(MainChatGuildManagerImpl$scrollToGuildHelper$1.INSTANCE);
        }
    }
}
