package com.tencent.mobileqq.wxmini.impl.account;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$Cmd0x11ceRequest;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$Cmd0x11ceResponse;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$Cmd0x11cfRequest;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$Cmd0x11cfResponse;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$ThirdPartAccountQueryInfo;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$ThirdPartRspInfo;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$WxReqInfo;
import com.tencent.mobileqq.wxmini.pb.AccountLogic$WxRspInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes35.dex */
public class AccountBindingHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private final AtomicLong f327643d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, a> f327644e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, String> f327645f;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class HandlerReqRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        a f327646d;

        /* renamed from: e, reason: collision with root package name */
        FromServiceMsg f327647e;

        /* renamed from: f, reason: collision with root package name */
        Object f327648f;

        public HandlerReqRunnable(a aVar, FromServiceMsg fromServiceMsg, Object obj) {
            this.f327646d = aVar;
            this.f327648f = obj;
            this.f327647e = fromServiceMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f327646d;
            if (aVar != null) {
                aVar.a(this.f327647e, this.f327648f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(FromServiceMsg fromServiceMsg, Object obj);
    }

    protected AccountBindingHandler(AppInterface appInterface) {
        super(appInterface);
        this.f327643d = new AtomicLong();
        this.f327644e = new HashMap<>();
        this.f327645f = new HashMap<>();
    }

    private com.tencent.mobileqq.wxmini.api.data.d D2(AccountLogic$ThirdPartRspInfo accountLogic$ThirdPartRspInfo) {
        com.tencent.mobileqq.wxmini.api.data.d dVar = new com.tencent.mobileqq.wxmini.api.data.d();
        int i3 = accountLogic$ThirdPartRspInfo.account_type.get();
        if (i3 == 1) {
            AccountLogic$WxRspInfo accountLogic$WxRspInfo = accountLogic$ThirdPartRspInfo.wx_info.get();
            dVar.j(i3).q(accountLogic$WxRspInfo.union_id.get()).p(accountLogic$WxRspInfo.openid.get()).o(accountLogic$WxRspInfo.nick_name.get()).r(accountLogic$WxRspInfo.wx_func_token.get()).n(accountLogic$WxRspInfo.head_img_url.get());
        } else {
            QLog.w("AccountBindingHandler", 1, "getThirdAccountInfo | type is invalid");
        }
        return dVar;
    }

    private AccountLogic$ThirdPartAccountQueryInfo E2(int i3, com.tencent.mobileqq.wxmini.api.data.d dVar) {
        AccountLogic$ThirdPartAccountQueryInfo accountLogic$ThirdPartAccountQueryInfo = new AccountLogic$ThirdPartAccountQueryInfo();
        if (i3 == 1) {
            AccountLogic$WxReqInfo accountLogic$WxReqInfo = new AccountLogic$WxReqInfo();
            if (!TextUtils.isEmpty(dVar.c())) {
                accountLogic$WxReqInfo.code.set(dVar.c());
            }
            if (!TextUtils.isEmpty(dVar.b())) {
                accountLogic$WxReqInfo.appid.set(dVar.b());
            }
            if (!TextUtils.isEmpty(dVar.g())) {
                accountLogic$WxReqInfo.union_id.set(dVar.g());
            }
            if (!TextUtils.isEmpty(dVar.h())) {
                accountLogic$WxReqInfo.wx_func_token.set(dVar.h());
            }
            accountLogic$ThirdPartAccountQueryInfo.wx_info.set(accountLogic$WxReqInfo);
        }
        return accountLogic$ThirdPartAccountQueryInfo;
    }

    private String J2(String str, int i3, int i16, byte[] bArr, a aVar) {
        String str2 = str + "-" + this.f327643d.incrementAndGet();
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(str, i3, i16, bArr);
        makeOIDBPkg.addAttribute(MiniAppCmdUtil.CMD_SEQ, str2);
        this.f327644e.put(str2, aVar);
        sendPbReq(makeOIDBPkg);
        return str2;
    }

    public f F2(FromServiceMsg fromServiceMsg, Object obj) {
        AccountLogic$Cmd0x11ceResponse accountLogic$Cmd0x11ceResponse = new AccountLogic$Cmd0x11ceResponse();
        f fVar = new f();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, accountLogic$Cmd0x11ceResponse);
        if (parseOIDBPkg != 0) {
            QLog.d("AccountBindingHandler", 2, "handleAddBind error. res=" + fromServiceMsg.getStringForLog() + " result: " + parseOIDBPkg);
            fVar.d(0);
            return fVar;
        }
        fVar.d(accountLogic$Cmd0x11ceResponse.bind_result.get()).e(accountLogic$Cmd0x11ceResponse.profile_sig.get()).c(D2(accountLogic$Cmd0x11ceResponse.third_part_info.get())).f(accountLogic$Cmd0x11ceResponse.secure_check_url.get());
        return fVar;
    }

    public g G2(FromServiceMsg fromServiceMsg, Object obj) {
        g gVar = new g();
        AccountLogic$Cmd0x11cfResponse accountLogic$Cmd0x11cfResponse = new AccountLogic$Cmd0x11cfResponse();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, accountLogic$Cmd0x11cfResponse);
        if (parseOIDBPkg != 0) {
            String stringForLog = fromServiceMsg.getStringForLog();
            gVar.d(0);
            QLog.d("AccountBindingHandler", 2, "handleAddBind error. res=" + stringForLog + " result: " + parseOIDBPkg);
            return gVar;
        }
        gVar.d(accountLogic$Cmd0x11cfResponse.unbind_result.get()).b(accountLogic$Cmd0x11cfResponse.profile_sig.get()).c(accountLogic$Cmd0x11cfResponse.secure_check_url.get());
        return gVar;
    }

    public void H2(int i3, com.tencent.mobileqq.wxmini.api.data.d dVar, a aVar) {
        AccountLogic$Cmd0x11ceRequest accountLogic$Cmd0x11ceRequest = new AccountLogic$Cmd0x11ceRequest();
        try {
            accountLogic$Cmd0x11ceRequest.account_type.set(i3);
            accountLogic$Cmd0x11ceRequest.third_part_info.set(E2(i3, dVar));
            accountLogic$Cmd0x11ceRequest.appid.set(2);
            this.f327645f.put(J2("OidbSvcTrpcTcp.0x11ce_5", 4558, 5, accountLogic$Cmd0x11ceRequest.toByteArray(), aVar), dVar.c());
        } catch (Exception e16) {
            QLog.e("AccountBindingHandler", 1, "QueryThirdPartBindByUin exception:", e16);
        }
    }

    public void I2(com.tencent.mobileqq.wxmini.api.data.d dVar, boolean z16, int i3, a aVar) {
        AccountLogic$Cmd0x11cfRequest accountLogic$Cmd0x11cfRequest = new AccountLogic$Cmd0x11cfRequest();
        try {
            accountLogic$Cmd0x11cfRequest.account_type.set(i3);
            accountLogic$Cmd0x11cfRequest.third_part_info.set(E2(i3, dVar));
            accountLogic$Cmd0x11cfRequest.is_been_confirmed.set(z16);
            J2("OidbSvcTrpcTcp.0x11cf_5", 4559, 5, accountLogic$Cmd0x11cfRequest.toByteArray(), aVar);
        } catch (Exception e16) {
            QLog.e("AccountBindingHandler", 1, "reqDeleteBind exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x11ce_5");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x11cf_5");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            QLog.d("AccountBindingHandler", 1, "onReceive() cmd is invalid, req.cmd = ", toServiceMsg.getServiceCmd());
            return;
        }
        String str = (String) toServiceMsg.getAttribute(MiniAppCmdUtil.CMD_SEQ);
        if (fromServiceMsg.isSuccess() && this.f327644e.containsKey(str)) {
            ThreadManagerV2.excute(new HandlerReqRunnable(this.f327644e.remove(str), fromServiceMsg, obj), 16, null, true);
        }
        String remove = this.f327645f.remove(str);
        if (remove == null) {
            remove = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("code", remove);
        if ("OidbSvcTrpcTcp.0x11ce_5".equals(fromServiceMsg.getServiceCmd())) {
            this.appRuntime.notifyObservers(com.tencent.mobileqq.wxmini.api.account.a.class, 0, fromServiceMsg.isSuccess(), bundle);
        } else if ("OidbSvcTrpcTcp.0x11cf_5".equals(toServiceMsg.getServiceCmd())) {
            this.appRuntime.notifyObservers(com.tencent.mobileqq.wxmini.api.account.a.class, 1, fromServiceMsg.isSuccess(), bundle);
        }
        QLog.d("AccountBindingHandler", 1, "onReceive:", toServiceMsg.getServiceCmd());
    }
}
