package com.tencent.mobileqq.wxmini.impl.account;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.impl.WxaSDKInit;
import com.tencent.mobileqq.wxmini.impl.account.AccountBindingHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final e f327663a = new e();
    }

    e() {
    }

    public static e e() {
        return a.f327663a;
    }

    private String f() {
        return WxaSDKInit.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(AccountBindingHandler accountBindingHandler, FromServiceMsg fromServiceMsg, Object obj, com.tencent.mobileqq.wxmini.api.data.a aVar) {
        f F2 = accountBindingHandler.F2(fromServiceMsg, obj);
        int b16 = F2.b();
        QLog.d("AccountBindingSingleton", 1, "bindResultType |" + b16);
        if (b16 == 0 || b16 == 1 || b16 == 2) {
            aVar.onFail(b16);
        } else {
            if (b16 != 3) {
                return;
            }
            aVar.a(F2.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(final AccountBindingHandler accountBindingHandler, final com.tencent.mobileqq.wxmini.api.data.a aVar, final FromServiceMsg fromServiceMsg, final Object obj) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.account.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(AccountBindingHandler.this, fromServiceMsg, obj, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(AccountBindingHandler accountBindingHandler, FromServiceMsg fromServiceMsg, Object obj, com.tencent.mobileqq.wxmini.api.data.c cVar, com.tencent.mobileqq.wxmini.api.data.d dVar) {
        g G2 = accountBindingHandler.G2(fromServiceMsg, obj);
        int a16 = G2.a();
        if (a16 == -1 || a16 == 0 || a16 == 1) {
            cVar.onFail(a16);
        } else if (a16 == 4) {
            cVar.a(dVar);
        }
        QLog.d("AccountBindingSingleton", 1, "unBindingResultInfo:" + G2 + " bindResultType:" + a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(final AccountBindingHandler accountBindingHandler, final com.tencent.mobileqq.wxmini.api.data.c cVar, final com.tencent.mobileqq.wxmini.api.data.d dVar, final FromServiceMsg fromServiceMsg, final Object obj) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.account.b
            @Override // java.lang.Runnable
            public final void run() {
                e.i(AccountBindingHandler.this, fromServiceMsg, obj, cVar, dVar);
            }
        });
    }

    public void k(String str, final com.tencent.mobileqq.wxmini.api.data.a aVar) {
        final AccountBindingHandler accountBindingHandler = (AccountBindingHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(AccountBindingHandler.class.getName());
        accountBindingHandler.H2(1, new com.tencent.mobileqq.wxmini.api.data.d().k(f()).m(str), new AccountBindingHandler.a() { // from class: com.tencent.mobileqq.wxmini.impl.account.c
            @Override // com.tencent.mobileqq.wxmini.impl.account.AccountBindingHandler.a
            public final void a(FromServiceMsg fromServiceMsg, Object obj) {
                e.h(AccountBindingHandler.this, aVar, fromServiceMsg, obj);
            }
        });
        QLog.d("AccountBindingSingleton", 1, "startAccountBind wxAuthCode:" + str);
    }

    public void l(final com.tencent.mobileqq.wxmini.api.data.c cVar) {
        final AccountBindingHandler accountBindingHandler = (AccountBindingHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(AccountBindingHandler.class.getName());
        final com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo != null && !TextUtils.isEmpty(bindingWeChatUserInfo.h())) {
            bindingWeChatUserInfo.k(f());
            accountBindingHandler.I2(bindingWeChatUserInfo, false, 1, new AccountBindingHandler.a() { // from class: com.tencent.mobileqq.wxmini.impl.account.a
                @Override // com.tencent.mobileqq.wxmini.impl.account.AccountBindingHandler.a
                public final void a(FromServiceMsg fromServiceMsg, Object obj) {
                    e.j(AccountBindingHandler.this, cVar, bindingWeChatUserInfo, fromServiceMsg, obj);
                }
            });
        } else {
            QLog.i("AccountBindingSingleton", 1, "unbind failed thirdAccountInfo is null");
            cVar.a(null);
        }
    }
}
