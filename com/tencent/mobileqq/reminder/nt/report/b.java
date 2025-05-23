package com.tencent.mobileqq.reminder.nt.report;

import Wallet.AcsMsg;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderChats;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.eventprocessor.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/reminder/nt/report/b;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/a$a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "a", "<init>", "()V", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements a.InterfaceC9564a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/nt/report/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.nt.report.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
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

    private final void c(final g item) {
        item.x().b();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.nt.report.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(g.this);
            }
        }, 160, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(g item) {
        IMessageFacade iMessageFacade;
        MessageRecord lastMsgForMsgTab;
        String str;
        String str2 = "";
        Intrinsics.checkNotNullParameter(item, "$item");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (iMessageFacade = (IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")) == null || (lastMsgForMsgTab = iMessageFacade.getLastMsgForMsgTab(item.k(), 9002)) == null) {
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQReminderMsgService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
            AcsMsg lastNoticeMsg = ((IQQReminderMsgService) runtimeService).getLastNoticeMsg(lastMsgForMsgTab);
            if (lastNoticeMsg != null) {
                str = lastNoticeMsg.busi_id;
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            ((IQQReminderChats) QRoute.api(IQQReminderChats.class)).reportDTMsgList("qq_clck", str2);
        } catch (Throwable th5) {
            QLog.e("QQReminderClickHandler", 1, th5, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.biz.eventprocessor.a.InterfaceC9564a
    public void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        g gVar;
        boolean z16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (true) {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            if (b16 != null) {
                obj = b16.get("click_recent_data");
            } else {
                obj = null;
            }
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            g gVar2 = (g) previous;
            if (gVar2.n() == 132 && Intrinsics.areEqual(gVar2.k(), QQConstants.ACTIVATE_FRIENDS_UIN)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                gVar = previous;
                break;
            }
        }
        g gVar3 = gVar;
        if (gVar3 != null) {
            QLog.i("QQReminderClickHandler", 2, "[clicked] " + gVar3);
            c(gVar3);
        }
    }
}
