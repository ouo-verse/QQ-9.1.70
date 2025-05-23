package com.tencent.mobileqq.activity.home.chats.callbcak;

import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements DragFrameLayout.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f182998d;

    public b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f182998d = aVar;
        }
    }

    private void a() {
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(1);
        if (chatsListReport != null) {
            chatsListReport.m(1);
        }
    }

    private void b() {
        ((IMainChatsUnreadHelper) QRoute.api(IMainChatsUnreadHelper.class)).notifyClearAll();
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), qUIBadgeDragLayout);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onChange] isDone=");
        sb5.append(z16);
        sb5.append(", dragType=");
        sb5.append(i3);
        sb5.append(", from null ? ");
        if (qUIBadgeDragLayout == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        QLog.d("ConversationDragChangeListener", 1, sb5.toString());
        if (qUIBadgeDragLayout == null) {
            return;
        }
        if (qUIBadgeDragLayout.getMode() == -1) {
            z18 = true;
        }
        FrameHelperActivity.gj(z18, "ConversationDragChangeListener");
        if (z16 && i3 == 2) {
            com.tencent.mobileqq.activity.home.chats.unread.c.f183015a.a(this.f182998d.i());
            b();
            a();
            QLog.d("ConversationDragChangeListener", 1, "cleanAllUnreadCount");
        }
    }
}
