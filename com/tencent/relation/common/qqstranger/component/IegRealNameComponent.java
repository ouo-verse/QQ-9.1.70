package com.tencent.relation.common.qqstranger.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.qqstranger.protocol.Security$DocumentConfig;
import com.tencent.relation.common.qqstranger.protocol.Security$IegVerifiedCheckReq;
import com.tencent.relation.common.qqstranger.protocol.Security$IegVerifiedCheckRsp;
import com.tencent.relation.common.servlet.IRelationSSORequestHandler;
import com.tencent.relation.common.servlet.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class IegRealNameComponent {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f364737d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f364738e;

        a(com.tencent.relation.common.qqstranger.component.a aVar, Context context, int i3) {
            this.f364737d = context;
            this.f364738e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, context, Integer.valueOf(i3));
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            byte[] byteArray = bundle.getByteArray("rsp_data");
            if (byteArray != null) {
                Security$IegVerifiedCheckRsp security$IegVerifiedCheckRsp = new Security$IegVerifiedCheckRsp();
                try {
                    security$IegVerifiedCheckRsp.mergeFrom(byteArray);
                    IegRealNameComponent.c(this.f364737d, new b(security$IegVerifiedCheckRsp), null, this.f364738e);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("IegRealNameComponent", 1, e16, new Object[0]);
                    throw null;
                }
            }
            QLog.e("IegRealNameComponent", 1, "checkSecureVerify fail because data=null");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f364739a;

        /* renamed from: b, reason: collision with root package name */
        public String f364740b;

        /* renamed from: c, reason: collision with root package name */
        public String f364741c;

        /* renamed from: d, reason: collision with root package name */
        public String f364742d;

        /* renamed from: e, reason: collision with root package name */
        public String f364743e;

        /* renamed from: f, reason: collision with root package name */
        public String f364744f;

        public b(Security$IegVerifiedCheckRsp security$IegVerifiedCheckRsp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) security$IegVerifiedCheckRsp);
                return;
            }
            this.f364739a = 2;
            this.f364740b = "";
            this.f364741c = "\u63d0\u793a";
            this.f364742d = "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
            this.f364743e = "\u53d6\u6d88";
            this.f364744f = "\u6211\u77e5\u9053\u4e86";
            if (security$IegVerifiedCheckRsp == null) {
                return;
            }
            this.f364739a = security$IegVerifiedCheckRsp.instruction_type.get();
            if (!TextUtils.isEmpty(security$IegVerifiedCheckRsp.jump_url.get())) {
                this.f364740b = security$IegVerifiedCheckRsp.jump_url.get();
            }
            Security$DocumentConfig security$DocumentConfig = security$IegVerifiedCheckRsp.document_config;
            if (security$DocumentConfig == null) {
                return;
            }
            if (!TextUtils.isEmpty(security$DocumentConfig.title.get())) {
                this.f364741c = security$IegVerifiedCheckRsp.document_config.title.get();
            }
            if (!TextUtils.isEmpty(security$IegVerifiedCheckRsp.document_config.body.get())) {
                this.f364742d = security$IegVerifiedCheckRsp.document_config.body.get();
            }
            int i3 = this.f364739a;
            if (i3 != 2) {
                if (i3 == 3) {
                    if (TextUtils.isEmpty(security$IegVerifiedCheckRsp.document_config.confirm_btn_text.get())) {
                        str = "\u6388\u6743\u5b9e\u540d";
                    } else {
                        str = security$IegVerifiedCheckRsp.document_config.confirm_btn_text.get();
                    }
                    this.f364744f = str;
                    this.f364743e = "\u7a0d\u540e\u518d\u8bf4";
                    return;
                }
                return;
            }
            this.f364744f = "\u6211\u77e5\u9053\u4e86";
        }
    }

    public static void b(Context context, com.tencent.relation.common.qqstranger.component.a aVar, int i3) {
        f(context, aVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, b bVar, com.tencent.relation.common.qqstranger.component.a aVar, int i3) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                QLog.i("IegRealNameComponent", 1, "handleRealNameResponse, type=" + bVar.f364739a);
                int i16 = bVar.f364739a;
                if (i16 != 2) {
                    if (i16 != 3) {
                        throw null;
                    }
                    d(activity, bVar, aVar, i3);
                    throw null;
                }
                e(activity, bVar, aVar);
                throw null;
            }
            QLog.e("IegRealNameComponent", 1, "activity is finishing");
            throw null;
        }
        QLog.e("IegRealNameComponent", 1, "context is not activity");
        throw null;
    }

    private static void d(Activity activity, b bVar, com.tencent.relation.common.qqstranger.component.a aVar, int i3) {
        activity.runOnUiThread(new Runnable(aVar, i3, activity, bVar) { // from class: com.tencent.relation.common.qqstranger.component.IegRealNameComponent.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f364731d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Activity f364732e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f364733f;

            {
                this.f364731d = i3;
                this.f364732e = activity;
                this.f364733f = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, aVar, Integer.valueOf(i3), activity, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                throw null;
            }
        });
    }

    private static void e(Activity activity, b bVar, com.tencent.relation.common.qqstranger.component.a aVar) {
        activity.runOnUiThread(new Runnable(aVar, activity, bVar) { // from class: com.tencent.relation.common.qqstranger.component.IegRealNameComponent.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f364734d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f364735e;

            /* compiled from: P */
            /* renamed from: com.tencent.relation.common.qqstranger.component.IegRealNameComponent$3$a */
            /* loaded from: classes25.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }

            {
                this.f364734d = activity;
                this.f364735e = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, aVar, activity, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                b bVar2 = this.f364735e;
                String str = bVar2.f364741c;
                String str2 = bVar2.f364742d;
                String str3 = bVar2.f364744f;
                new a();
                throw null;
            }
        });
    }

    private static void f(Context context, com.tencent.relation.common.qqstranger.component.a aVar, int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            if (((com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4)) != null) {
                Security$IegVerifiedCheckReq security$IegVerifiedCheckReq = new Security$IegVerifiedCheckReq();
                security$IegVerifiedCheckReq.source.set(i3);
                ((IRelationSSORequestHandler) QRoute.api(IRelationSSORequestHandler.class)).request(appInterface, "QQStranger.UserInfo.SsoIegVerifiedCheck", security$IegVerifiedCheckReq.toByteArray(), new a(aVar, context, i3));
                return;
            }
            QLog.e("IegRealNameComponent", 1, "checkSecureVerify fail because IRelationRequestHandler=null");
            throw null;
        }
        QLog.e("IegRealNameComponent", 1, "AppInterface not exist");
        throw null;
    }
}
