package com.tencent.mobileqq.accountbinding.net;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.AccountLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AccountBindingHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, d> f174649d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicLong f174650e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class HandlerReqRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        d f174651d;

        /* renamed from: e, reason: collision with root package name */
        FromServiceMsg f174652e;

        /* renamed from: f, reason: collision with root package name */
        Object f174653f;

        public HandlerReqRunnable(d dVar, FromServiceMsg fromServiceMsg, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, dVar, fromServiceMsg, obj);
                return;
            }
            this.f174651d = dVar;
            this.f174653f = obj;
            this.f174652e = fromServiceMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            d dVar = this.f174651d;
            if (dVar != null) {
                dVar.a(this.f174652e, this.f174653f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f174654a;

        a(c cVar) {
            this.f174654a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountBindingHandler.this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.d
        public void a(FromServiceMsg fromServiceMsg, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                List<com.tencent.mobileqq.accountbinding.data.b> I2 = AccountBindingHandler.this.I2(fromServiceMsg, obj);
                if (I2.size() > 0) {
                    this.f174654a.onSuccess(I2);
                    return;
                } else {
                    this.f174654a.onFail();
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fromServiceMsg, obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(com.tencent.mobileqq.accountbinding.data.b bVar);

        void onFail(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void onFail();

        void onSuccess(List<com.tencent.mobileqq.accountbinding.data.b> list);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(FromServiceMsg fromServiceMsg, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void onFail(int i3);

        void onSuccess();
    }

    protected AccountBindingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f174649d = new HashMap<>();
            this.f174650e = new AtomicLong();
        }
    }

    private com.tencent.mobileqq.accountbinding.data.b E2(AccountLogic.ThirdPartRspInfo thirdPartRspInfo) {
        com.tencent.mobileqq.accountbinding.data.b bVar = new com.tencent.mobileqq.accountbinding.data.b();
        int i3 = thirdPartRspInfo.account_type.get();
        if (i3 != 1) {
            QLog.w("AccountBindingHandler", 1, "getThirdAccountInfo | type is invalid");
        } else {
            AccountLogic.WxRspInfo wxRspInfo = thirdPartRspInfo.wx_info.get();
            bVar.h(i3).o(wxRspInfo.union_id.get()).n(wxRspInfo.openid.get()).m(wxRspInfo.nick_name.get()).l(wxRspInfo.head_img_url.get());
        }
        return bVar;
    }

    private AccountLogic.ThirdPartReqInfo F2(int i3, com.tencent.mobileqq.accountbinding.data.b bVar) {
        AccountLogic.ThirdPartReqInfo thirdPartReqInfo = new AccountLogic.ThirdPartReqInfo();
        if (i3 == 1) {
            AccountLogic.WxReqInfo wxReqInfo = new AccountLogic.WxReqInfo();
            if (!TextUtils.isEmpty(bVar.c())) {
                wxReqInfo.code.set(bVar.c());
            }
            if (!TextUtils.isEmpty(bVar.b())) {
                wxReqInfo.appid.set(bVar.b());
            }
            if (!TextUtils.isEmpty(bVar.f())) {
                wxReqInfo.union_id.set(bVar.f());
            }
            thirdPartReqInfo.wx_info.set(wxReqInfo);
        }
        return thirdPartReqInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.accountbinding.data.b> I2(FromServiceMsg fromServiceMsg, Object obj) {
        AccountLogic.Cmd0x11d0Response cmd0x11d0Response = new AccountLogic.Cmd0x11d0Response();
        ArrayList arrayList = new ArrayList();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x11d0Response);
        if (parseOIDBPkg != 0) {
            QLog.d("AccountBindingHandler", 2, "handleAddBind error. res=" + fromServiceMsg.getStringForLog() + " result: " + parseOIDBPkg);
            return arrayList;
        }
        if (cmd0x11d0Response.third_part_info_list.has() && cmd0x11d0Response.third_part_info_list.get().size() > 0) {
            Iterator<AccountLogic.ThirdPartRspInfo> it = cmd0x11d0Response.third_part_info_list.get().iterator();
            while (it.hasNext()) {
                arrayList.add(E2(it.next()));
            }
            return arrayList;
        }
        QLog.d("AccountBindingHandler", 1, "handleQueryThirdPartBindByUin | no binding third account.");
        return arrayList;
    }

    private void M2(String str, int i3, int i16, byte[] bArr, d dVar) {
        String str2 = str + "-" + this.f174650e.incrementAndGet();
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(str, i3, i16, bArr);
        makeOIDBPkg.addAttribute(MiniAppCmdUtil.CMD_SEQ, str2);
        this.f174649d.put(str2, dVar);
        sendPbReq(makeOIDBPkg);
    }

    public com.tencent.mobileqq.accountbinding.data.a G2(FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.accountbinding.data.a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) fromServiceMsg, obj);
        }
        AccountLogic.Cmd0x11ceResponse cmd0x11ceResponse = new AccountLogic.Cmd0x11ceResponse();
        com.tencent.mobileqq.accountbinding.data.a aVar = new com.tencent.mobileqq.accountbinding.data.a();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x11ceResponse);
        if (parseOIDBPkg != 0) {
            QLog.d("AccountBindingHandler", 2, "handleAddBind error. res=" + fromServiceMsg.getStringForLog() + " result: " + parseOIDBPkg);
            aVar.f(0);
            return aVar;
        }
        aVar.f(cmd0x11ceResponse.bind_result.get()).g(cmd0x11ceResponse.profile_sig.get()).e(E2(cmd0x11ceResponse.third_part_info.get())).h(cmd0x11ceResponse.secure_check_url.get());
        return aVar;
    }

    public com.tencent.mobileqq.accountbinding.data.c H2(FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.accountbinding.data.c) iPatchRedirector.redirect((short) 9, (Object) this, (Object) fromServiceMsg, obj);
        }
        com.tencent.mobileqq.accountbinding.data.c cVar = new com.tencent.mobileqq.accountbinding.data.c();
        AccountLogic.Cmd0x11cfResponse cmd0x11cfResponse = new AccountLogic.Cmd0x11cfResponse();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x11cfResponse);
        if (parseOIDBPkg != 0) {
            String stringForLog = fromServiceMsg.getStringForLog();
            cVar.f(0);
            QLog.d("AccountBindingHandler", 2, "handleAddBind error. res=" + stringForLog + " result: " + parseOIDBPkg);
            return cVar;
        }
        cVar.f(cmd0x11cfResponse.unbind_result.get()).d(cmd0x11cfResponse.profile_sig.get()).e(cmd0x11cfResponse.secure_check_url.get());
        return cVar;
    }

    public void J2(long j3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), cVar);
            return;
        }
        try {
            M2("OidbSvcTrpcTcp.0x11d0_1", 4560, 1, new AccountLogic.Cmd0x11d0Request().toByteArray(), new a(cVar));
        } catch (Exception e16) {
            QLog.e("AccountBindingHandler", 1, "QueryThirdPartBindByUin exception:", e16);
        }
    }

    public void K2(String str, int i3, com.tencent.mobileqq.accountbinding.data.b bVar, String str2, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), bVar, str2, dVar);
            return;
        }
        AccountLogic.Cmd0x11ceRequest cmd0x11ceRequest = new AccountLogic.Cmd0x11ceRequest();
        try {
            if (!TextUtils.isEmpty(str)) {
                cmd0x11ceRequest.profile_sig.set(str);
            }
            cmd0x11ceRequest.account_type.set(i3);
            cmd0x11ceRequest.third_part_info.set(F2(i3, bVar));
            if (!TextUtils.isEmpty(str2)) {
                cmd0x11ceRequest.sig_info.set(str2);
            }
            M2("OidbSvcTrpcTcp.0x11ce_1", 4558, 1, cmd0x11ceRequest.toByteArray(), dVar);
        } catch (Exception e16) {
            QLog.e("AccountBindingHandler", 1, "QueryThirdPartBindByUin exception:", e16);
        }
    }

    public void L2(long j3, com.tencent.mobileqq.accountbinding.data.b bVar, boolean z16, int i3, String str, String str2, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), bVar, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, dVar);
            return;
        }
        AccountLogic.Cmd0x11cfRequest cmd0x11cfRequest = new AccountLogic.Cmd0x11cfRequest();
        try {
            cmd0x11cfRequest.account_type.set(i3);
            if (!TextUtils.isEmpty(str2)) {
                cmd0x11cfRequest.sig_info.set(str2);
            }
            if (!TextUtils.isEmpty(str)) {
                cmd0x11cfRequest.profile_sig.set(str);
            }
            cmd0x11cfRequest.third_part_info.set(F2(i3, bVar));
            cmd0x11cfRequest.is_been_confirmed.set(z16);
            M2("OidbSvcTrpcTcp.0x11cf_1", 4559, 1, cmd0x11cfRequest.toByteArray(), dVar);
        } catch (Exception e16) {
            QLog.e("AccountBindingHandler", 1, "QueryThirdPartBindByUin exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x11d0_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x11ce_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x11cf_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            QLog.d("AccountBindingHandler", 1, "onReceive() cmd is invalid, req.cmd = ", toServiceMsg.getServiceCmd());
            return;
        }
        String str = (String) toServiceMsg.getAttribute(MiniAppCmdUtil.CMD_SEQ);
        if (fromServiceMsg.isSuccess() && this.f174649d.containsKey(str)) {
            ThreadManagerV2.excute(new HandlerReqRunnable(this.f174649d.remove(str), fromServiceMsg, obj), 16, null, true);
        }
    }
}
