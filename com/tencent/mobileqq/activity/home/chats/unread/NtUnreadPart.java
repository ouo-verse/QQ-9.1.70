package com.tencent.mobileqq.activity.home.chats.unread;

import android.os.Looper;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.au;
import com.tencent.mobileqq.qcall.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.invorker.d;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class NtUnreadPart extends com.tencent.qqnt.chats.biz.main.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public b f183008f;

    /* renamed from: h, reason: collision with root package name */
    public AppRuntime f183009h;

    /* renamed from: i, reason: collision with root package name */
    d f183010i;

    /* renamed from: m, reason: collision with root package name */
    d f183011m;

    public NtUnreadPart(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        d dVar = new d() { // from class: com.tencent.mobileqq.activity.home.chats.unread.a
            @Override // com.tencent.qqnt.kernel.invorker.d
            public final void O0(int i3, int i16, List list) {
                NtUnreadPart.this.ba(i3, i16, list);
            }
        };
        this.f183010i = dVar;
        this.f183011m = (d) au.a(dVar, d.class);
        this.f183008f = bVar;
    }

    private void Y9(AppRuntime appRuntime) {
        aa aa5;
        if (appRuntime != null && appRuntime.isLogin() && (aa5 = aa(appRuntime)) != null) {
            aa5.addExpandRecentContactListener(this.f183011m);
        }
    }

    private aa aa(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return null;
        }
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba(int i3, int i16, List list) {
        if (i3 == 7) {
            ca();
        } else {
            if (i3 != 1) {
                return;
            }
            try {
                Z9(i16);
            } catch (Exception e16) {
                QLog.i("NtUnreadPart", 1, "fetchUnReadCount", e16);
            }
        }
    }

    private void ca() {
        AppRuntime appRuntime = this.f183009h;
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            ((MiniMsgHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).G2();
            ((IZPlanMiniAIOHelper) QRoute.api(IZPlanMiniAIOHelper.class)).notifyUnreadCount();
            ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).notifyUnreadCount();
        }
    }

    private void da(AppRuntime appRuntime) {
        aa aa5;
        if (appRuntime != null && (aa5 = aa(appRuntime)) != null) {
            aa5.removeExpandRecentContactListener(this.f183011m);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void A9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.f183009h = appRuntime;
            Y9(appRuntime);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void N9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            Y9(this.f183009h);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void R9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            da(appRuntime);
        }
    }

    public void Z9(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        AppRuntime appRuntime = this.f183009h;
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    return;
                }
                int w3 = f.w(qQAppInterface);
                int i16 = i3 + w3;
                b bVar = this.f183008f;
                if (bVar != null) {
                    bVar.updateUnread(i16);
                }
                com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(1);
                if (chatsListReport != null) {
                    chatsListReport.a(i16);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(qQAppInterface, i16) { // from class: com.tencent.mobileqq.activity.home.chats.unread.NtUnreadPart.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f183012d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f183013e;

                    {
                        this.f183012d = qQAppInterface;
                        this.f183013e = i16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, NtUnreadPart.this, qQAppInterface, Integer.valueOf(i16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f183012d.refreshMsgTabUnreadNum(false, this.f183013e);
                        }
                    }
                });
                QLog.i("NtUnreadPart", 1, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s]", Integer.valueOf(i16), Integer.valueOf(i3), Integer.valueOf(w3)));
            } catch (Throwable th5) {
                QLog.i("NtUnreadPart", 1, "fetchUnReadCount", th5);
            }
        }
    }
}
