package com.tencent.mobileqq.app.handler;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.handler.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C7379a implements com.tencent.mobileqq.thirdsig.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f195674a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseMessageHandler f195675b;

        C7379a(String str, BaseMessageHandler baseMessageHandler) {
            this.f195674a = str;
            this.f195675b = baseMessageHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) baseMessageHandler);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.b
        public void onFail(int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                ReportCenter.f().n(this.f195675b.getApp().getAccount(), "", this.f195674a, "41", "19", "1", "", "", "4", false);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.b
        public void onSuccess(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            OpenID openID = new OpenID();
            openID.appID = this.f195674a;
            openID.openID = str;
            this.f195675b.getEM().persistOrReplace(openID);
            ((e) this.f195675b.getApp().getMsgCache()).D(this.f195674a, openID);
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).addOpenId(this.f195674a, openID, this.f195675b.getApp());
            this.f195675b.notifyUI(1, true, openID);
            ReportCenter.f().n(this.f195675b.getApp().getAccount(), "", this.f195674a, "41", "19", "0", "", "", "4", false);
        }
    }

    public static void a(BaseMessageHandler baseMessageHandler, String str) {
        if (((e) baseMessageHandler.getApp().getMsgCache()).R0(str) != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("openid", 2, "get openid key = " + str);
        }
        b(baseMessageHandler, str);
    }

    private static void b(BaseMessageHandler baseMessageHandler, String str) {
        ((IThirdSigService) baseMessageHandler.getApp().getRuntimeService(IThirdSigService.class, "all")).getOpenId(baseMessageHandler.getApp().getLongAccountUin(), Integer.parseInt(str), "", new C7379a(str, baseMessageHandler));
    }
}
