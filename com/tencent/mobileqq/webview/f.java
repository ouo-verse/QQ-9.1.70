package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.q;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.s;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.IReaderConstants;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.manager.Manager;
import tencent.aio.video.aio_video$ReqGetUinByOpenId;
import tencent.aio.video.aio_video$RspGetUinByOpenId;
import tencent.im.PasswdUrlReport$ReqBody;
import tencent.im.PasswdUrlReport$RspBody;
import tencent.im.PasswdUrlReport$UploadReqItem;
import tencent.im.oidb.oidb_0xbcb$ReqBody;
import tencent.im.oidb.oidb_0xbcb$RspBody;
import tencent.im.oidb.oidb_0xbcb$UrlCheckResult;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f implements Manager {
    static IPatchRedirector $redirector_;
    boolean C;
    boolean D;
    int E;
    String F;
    private InterfaceC8971f G;

    /* renamed from: d, reason: collision with root package name */
    LruCache<String, e> f313842d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<String> f313843e;

    /* renamed from: f, reason: collision with root package name */
    Handler f313844f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f313845h;

    /* renamed from: i, reason: collision with root package name */
    boolean f313846i;

    /* renamed from: m, reason: collision with root package name */
    String f313847m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements InterfaceC8971f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.f.InterfaceC8971f
        public void onResult(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            f fVar = f.this;
            if (fVar.D) {
                return;
            }
            fVar.C = false;
            fVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("urlSecMgr", 2, "receive PasswdUrlReport code=" + i3);
            }
            if (i3 == 0 && bArr != null) {
                PasswdUrlReport$RspBody passwdUrlReport$RspBody = new PasswdUrlReport$RspBody();
                try {
                    passwdUrlReport$RspBody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.d("urlSecMgr", 2, "parse PasswdUrlReport result res=", Integer.valueOf(passwdUrlReport$RspBody.result.get()), " retCode=", Integer.valueOf(passwdUrlReport$RspBody.upload_rsp_item.ret_code.get()));
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("urlSecMgr", 2, "parse error", e16);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                if (bArr != null) {
                    try {
                        str = new PasswdUrlReport$RspBody().mergeFrom(bArr).upload_rsp_item.ret_msg.get();
                    } catch (InvalidProtocolBufferMicroException unused) {
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("PasswdUrlReport error code=");
                    sb5.append(i3);
                    if (bArr != null) {
                        str2 = ", data=null";
                    } else {
                        str2 = ", msg=" + str;
                    }
                    sb5.append(str2);
                    QLog.i("urlSecMgr", 2, sb5.toString());
                }
                str = "";
                StringBuilder sb52 = new StringBuilder();
                sb52.append("PasswdUrlReport error code=");
                sb52.append(i3);
                if (bArr != null) {
                }
                sb52.append(str2);
                QLog.i("urlSecMgr", 2, sb52.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC8971f f313850d;

        c(InterfaceC8971f interfaceC8971f) {
            this.f313850d = interfaceC8971f;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) interfaceC8971f);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String stringUtf8;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("urlSecMgr", 2, "receive getUinWithOpenID code=" + i3);
            }
            String str3 = "";
            int i17 = -1;
            if (i3 == 0 && bArr != null) {
                aio_video$RspGetUinByOpenId aio_video_rspgetuinbyopenid = new aio_video$RspGetUinByOpenId();
                try {
                    aio_video_rspgetuinbyopenid.mergeFrom(bArr);
                    str = String.valueOf(aio_video_rspgetuinbyopenid.uin.get());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    str = "";
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("urlSecMgr", 2, "getUinWithOpenID uin:", Long.valueOf(aio_video_rspgetuinbyopenid.uin.get()));
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.i("urlSecMgr", 2, "parse error", e);
                    }
                    z16 = false;
                    if (this.f313850d == null) {
                    }
                }
            } else {
                if (bArr != null) {
                    try {
                        aio_video$RspGetUinByOpenId aio_video_rspgetuinbyopenid2 = new aio_video$RspGetUinByOpenId();
                        aio_video_rspgetuinbyopenid2.mergeFrom(bArr);
                        stringUtf8 = aio_video_rspgetuinbyopenid2.err_info.err_msg.get().toStringUtf8();
                        try {
                            i17 = aio_video_rspgetuinbyopenid2.err_info.err_code.get();
                        } catch (InvalidProtocolBufferMicroException unused) {
                        }
                    } catch (InvalidProtocolBufferMicroException unused2) {
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getUinWithOpenID error code=");
                        sb5.append(i3);
                        if (bArr == null) {
                            str2 = ", data=null";
                        } else {
                            str2 = ", msg=" + stringUtf8 + ", errCode=" + i17;
                        }
                        sb5.append(str2);
                        QLog.i("urlSecMgr", 2, sb5.toString());
                    }
                    str = "";
                    z16 = false;
                    str3 = stringUtf8;
                }
                stringUtf8 = "";
                if (QLog.isColorLevel()) {
                }
                str = "";
                z16 = false;
                str3 = stringUtf8;
            }
            if (this.f313850d == null) {
                Bundle bundle2 = new Bundle();
                if (!z16) {
                    i16 = i17;
                }
                bundle2.putInt("result", i16);
                bundle2.putString("errMsg", str3);
                bundle2.putString("retUin", str);
                this.f313850d.onResult(bundle2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC8971f f313852d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f313853e;

        d(InterfaceC8971f interfaceC8971f, int i3) {
            this.f313852d = interfaceC8971f;
            this.f313853e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, interfaceC8971f, Integer.valueOf(i3));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x014b  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            e eVar = null;
            if (i3 == 0 && bArr != null) {
                oidb_0xbcb$RspBody oidb_0xbcb_rspbody = new oidb_0xbcb$RspBody();
                try {
                    oidb_0xbcb_rspbody.mergeFrom(bArr);
                    if (QLog.isDevelopLevel()) {
                        QLog.i("UrlCheckLog_urlSecMgr", 2, "receive 0xbcb_0 suc. parse 0xbcb_0 result msg=" + oidb_0xbcb_rspbody.wording.get() + ", count=" + oidb_0xbcb_rspbody.check_url_rsp.results.size());
                    }
                    long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() + (oidb_0xbcb_rspbody.check_url_rsp.next_req_duration.get() * 1000);
                    int size = oidb_0xbcb_rspbody.check_url_rsp.results.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        oidb_0xbcb$UrlCheckResult oidb_0xbcb_urlcheckresult = oidb_0xbcb_rspbody.check_url_rsp.results.get(i16);
                        String str3 = oidb_0xbcb_urlcheckresult.url.get();
                        e eVar2 = new e();
                        eVar2.f313858d = serverTimeMillis;
                        eVar2.f313855a = oidb_0xbcb_urlcheckresult.result.get();
                        eVar2.f313856b = oidb_0xbcb_urlcheckresult.jump_result.get();
                        eVar2.f313857c = oidb_0xbcb_urlcheckresult.jump_url.get();
                        eVar2.f313859e = oidb_0xbcb_urlcheckresult.uint32_level.get();
                        eVar2.f313860f = oidb_0xbcb_urlcheckresult.uint32_sub_level.get();
                        eVar2.f313861g = oidb_0xbcb_urlcheckresult.uint32_umrtype.get();
                        eVar2.f313862h = oidb_0xbcb_urlcheckresult.ret_from.get();
                        eVar2.f313863i = oidb_0xbcb_urlcheckresult.operation_bit.get();
                        eVar2.f313864j = oidb_0xbcb_urlcheckresult.target.get();
                        if (i16 == 0) {
                            eVar = eVar2;
                        }
                        e eVar3 = f.this.f313842d.get(str3);
                        if (eVar3 != null) {
                            eVar2.f313865k = eVar3.f313865k;
                        }
                        f.this.f313842d.put(str3, eVar2);
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w("urlSecMgr", 1, "parse error: " + e16.getMessage(), e16);
                }
            } else if (QLog.isColorLevel()) {
                if (bArr != null) {
                    try {
                        str = new oidb_0xbcb$RspBody().mergeFrom(bArr).wording.get();
                    } catch (InvalidProtocolBufferMicroException unused) {
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("receive 0xbcb_0 error code=");
                    sb5.append(i3);
                    if (bArr != null) {
                        str2 = ", data=null";
                    } else {
                        str2 = ", msg=" + str;
                    }
                    sb5.append(str2);
                    QLog.i("UrlCheckLog_urlSecMgr", 2, sb5.toString());
                }
                str = "";
                StringBuilder sb52 = new StringBuilder();
                sb52.append("receive 0xbcb_0 error code=");
                sb52.append(i3);
                if (bArr != null) {
                }
                sb52.append(str2);
                QLog.i("UrlCheckLog_urlSecMgr", 2, sb52.toString());
            }
            if (this.f313852d != null) {
                Bundle bundle2 = new Bundle();
                if (this.f313853e == 1 && eVar != null) {
                    bundle2.putInt("result", eVar.f313855a);
                    bundle2.putInt("jumpResult", eVar.f313856b);
                    bundle2.putString(WadlProxyConsts.KEY_JUMP_URL, eVar.f313857c);
                    bundle2.putInt("level", eVar.f313859e);
                    bundle2.putInt("subLevel", eVar.f313860f);
                    bundle2.putInt("umrType", eVar.f313861g);
                    bundle2.putInt("retFrom", eVar.f313862h);
                    bundle2.putLong("operationBit", eVar.f313863i);
                    bundle2.putInt("needSdkCheck", eVar.f313864j);
                }
                this.f313852d.onResult(bundle2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f313855a;

        /* renamed from: b, reason: collision with root package name */
        int f313856b;

        /* renamed from: c, reason: collision with root package name */
        String f313857c;

        /* renamed from: d, reason: collision with root package name */
        long f313858d;

        /* renamed from: e, reason: collision with root package name */
        int f313859e;

        /* renamed from: f, reason: collision with root package name */
        int f313860f;

        /* renamed from: g, reason: collision with root package name */
        int f313861g;

        /* renamed from: h, reason: collision with root package name */
        int f313862h;

        /* renamed from: i, reason: collision with root package name */
        long f313863i;

        /* renamed from: j, reason: collision with root package name */
        int f313864j;

        /* renamed from: k, reason: collision with root package name */
        boolean f313865k;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.f$f, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8971f {
        void onResult(Bundle bundle);
    }

    public f(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f313842d = new LruCache<>(64);
        this.f313843e = new ArrayList<>(64);
        this.f313844f = new Handler(Looper.getMainLooper());
        this.f313846i = false;
        this.C = false;
        this.D = false;
        this.E = -1;
        this.G = new a();
        this.f313845h = qQAppInterface;
        this.f313846i = q.a() != 0;
        QLog.i("UrlCheckLog_urlSecMgr", 1, "aio pre check enable=" + this.f313846i);
    }

    private void c(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("urlSecMgr", 2, "apply async check " + com.tencent.biz.common.util.k.f(str, new String[0]));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 10240) {
            str = str.substring(0, 10240);
        }
        e eVar = this.f313842d.get(str);
        if (eVar != null && eVar.f313858d > NetConnInfoCenter.getServerTimeMillis()) {
            return;
        }
        this.f313843e.add(str);
        int size = this.f313843e.size();
        if (size > 40) {
            this.f313843e.subList(0, size - 20).clear();
        }
    }

    private void e(URLCheckParams uRLCheckParams, long j3, int i3, InterfaceC8971f interfaceC8971f) {
        String str;
        oidb_0xbcb$ReqBody oidb_0xbcb_reqbody = new oidb_0xbcb$ReqBody();
        oidb_0xbcb_reqbody.check_url_req.setHasFlag(true);
        if (uRLCheckParams.H.size() > 20) {
            QLog.e("urlSecMgr", 1, "urls size > 20");
            return;
        }
        int i16 = 0;
        for (String str2 : uRLCheckParams.H) {
            i16 += str2.length();
            if (i16 > 10240) {
                QLog.e("urlSecMgr", 1, "url to large");
                return;
            }
            oidb_0xbcb_reqbody.check_url_req.url.add(str2);
        }
        int i17 = uRLCheckParams.f313761e;
        if (i17 != -1) {
            oidb_0xbcb_reqbody.check_url_req.msg_type.set(i17);
            oidb_0xbcb_reqbody.check_url_req.msg_from.set(uRLCheckParams.f313762f);
            if (!TextUtils.isEmpty(uRLCheckParams.f313763h)) {
                try {
                    oidb_0xbcb_reqbody.check_url_req.send_uin.set(Long.parseLong(uRLCheckParams.f313763h));
                } catch (NumberFormatException unused) {
                }
            }
            if (!TextUtils.isEmpty(uRLCheckParams.f313764i)) {
                try {
                    oidb_0xbcb_reqbody.check_url_req.msg_chatid.set(Long.parseLong(uRLCheckParams.f313764i));
                } catch (NumberFormatException unused2) {
                }
            }
        }
        boolean z16 = !TextUtils.isEmpty(uRLCheckParams.D);
        if (z16) {
            oidb_0xbcb_reqbody.check_url_req.ark_name.set(uRLCheckParams.D);
        }
        ArrayList<String> arrayList = uRLCheckParams.G;
        if (arrayList != null) {
            oidb_0xbcb_reqbody.check_url_req.src_urls.addAll(arrayList);
        }
        oidb_0xbcb_reqbody.check_url_req.is_ark.set(z16);
        oidb_0xbcb_reqbody.check_url_req.is_finish.set(uRLCheckParams.E);
        if (uRLCheckParams.F) {
            oidb_0xbcb_reqbody.check_url_req.plateform.set("multiForward");
        }
        oidb_0xbcb_reqbody.check_url_req.src_platform.set(1);
        if (!TextUtils.isEmpty(AppSetting.k())) {
            oidb_0xbcb_reqbody.check_url_req.qua.set(AppSetting.k());
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UrlCheckLog_urlSecMgr", 2, "send 0xbcb_0 urlCheck count:", Integer.valueOf(oidb_0xbcb_reqbody.check_url_req.url.size()), " params: ", uRLCheckParams.toString());
        }
        if (!TextUtils.isEmpty(uRLCheckParams.f313765m)) {
            oidb_0xbcb_reqbody.check_url_req.qq_pf_to.set(uRLCheckParams.f313765m);
        }
        PBStringField pBStringField = oidb_0xbcb_reqbody.check_url_req.req_type;
        if (i3 == 2) {
            str = "aio";
        } else if (i3 == 1) {
            str = "webview";
        } else {
            str = "";
        }
        pBStringField.set(str);
        if (!TextUtils.isEmpty(uRLCheckParams.C)) {
            oidb_0xbcb_reqbody.check_url_req.original_url.set(uRLCheckParams.C);
        }
        try {
            ProtoUtils.c(this.f313845h, new d(interfaceC8971f, i3), oidb_0xbcb_reqbody.toByteArray(), "OidbSvc.0xbcb_0", IReaderConstants.READER_CB_FEATURE_FLAG, 0, null, j3);
        } catch (Exception e16) {
            QLog.e("urlSecMgr", 1, "toByteArray exception: " + e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ListView listView, s sVar) {
        String str;
        String h16;
        long currentTimeMillis = System.currentTimeMillis();
        this.f313843e.clear();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = listView.getLastVisiblePosition();
        int headerViewsCount = listView.getHeaderViewsCount();
        int min = Math.min(lastVisiblePosition - headerViewsCount, sVar.getCount() - 1);
        for (int max = Math.max(0, firstVisiblePosition - headerViewsCount); max <= min; max++) {
            ChatMessage chatMessage = (ChatMessage) sVar.getItem(max);
            if (!chatMessage.isSend()) {
                if (chatMessage instanceof MessageForStructing) {
                    AbsStructMsg absStructMsg = ((MessageForStructing) chatMessage).structingMsg;
                    if (WebAccelerator.r(absStructMsg)) {
                        c(absStructMsg.mMsgUrl);
                    }
                } else if ((chatMessage instanceof MessageForText) && (str = ((MessageForText) chatMessage).f203106msg) != null && (h16 = WebAccelerator.h(str)) != null) {
                    c(h16);
                }
            }
        }
        j();
        if (QLog.isColorLevel()) {
            QLog.d("urlSecMgr", 2, "pre check cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private boolean g(e eVar, String str, boolean z16) {
        if (eVar == null) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UrlCheckLog_urlSecMgr", 2, "forceReportArkPageFinish arkBusinessName=", str, " isPageFinish : ", Boolean.valueOf(z16), " entry.isArkPageFinis=", Boolean.valueOf(eVar.f313865k));
        }
        if (!z16 || eVar.f313865k) {
            return false;
        }
        eVar.f313865k = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.C && this.f313843e.size() > 0) {
            this.C = true;
            HashSet hashSet = new HashSet(20);
            int i3 = 0;
            for (int size = this.f313843e.size() - 1; size >= 0 && hashSet.size() < 20; size--) {
                String str = this.f313843e.get(size);
                if (hashSet.contains(str)) {
                    this.f313843e.remove(size);
                } else {
                    i3 += str.length();
                    if (i3 > 10240) {
                        break;
                    }
                    this.f313843e.remove(size);
                    hashSet.add(str);
                    if (QLog.isColorLevel()) {
                        QLog.i("UrlCheckLog_urlSecMgr", 2, "pre check url=" + com.tencent.biz.common.util.k.f(str, new String[0]));
                    }
                }
            }
            URLCheckParams a16 = URLCheckParams.a(null, this.E, 0, "", this.F, this.f313847m, "", null, false, false, null);
            a16.H = hashSet;
            e(a16, 0L, 2, this.G);
        }
    }

    public void d(URLCheckParams uRLCheckParams, InterfaceC8971f interfaceC8971f) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLCheckParams, (Object) interfaceC8971f);
            return;
        }
        if (TextUtils.isEmpty(uRLCheckParams.f313760d)) {
            return;
        }
        if (uRLCheckParams.f313760d.length() > 10240) {
            uRLCheckParams.f313760d = uRLCheckParams.f313760d.substring(0, 10240);
        }
        e eVar = this.f313842d.get(uRLCheckParams.f313760d);
        boolean g16 = g(eVar, uRLCheckParams.D, uRLCheckParams.E);
        if (eVar != null && eVar.f313858d > NetConnInfoCenter.getServerTimeMillis() && eVar.f313855a == 0 && !g16) {
            if (QLog.isColorLevel()) {
                QLog.i("UrlCheckLog_urlSecMgr", 2, "cache hit");
            }
            Bundle bundle = new Bundle();
            bundle.putInt("result", eVar.f313855a);
            bundle.putInt("jumpResult", eVar.f313856b);
            bundle.putString(WadlProxyConsts.KEY_JUMP_URL, eVar.f313857c);
            bundle.putInt("level", eVar.f313859e);
            bundle.putInt("subLevel", eVar.f313860f);
            bundle.putInt("umrType", eVar.f313861g);
            bundle.putInt("retFrom", eVar.f313862h);
            bundle.putLong("operationBit", eVar.f313863i);
            bundle.putInt("needSdkCheck", eVar.f313864j);
            interfaceC8971f.onResult(bundle);
            return;
        }
        uRLCheckParams.b();
        e(uRLCheckParams, 10000L, 1, interfaceC8971f);
    }

    public void h(String str, String str2, String str3, InterfaceC8971f interfaceC8971f) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, interfaceC8971f);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            long parseLong = Long.parseLong(str3);
            aio_video$ReqGetUinByOpenId aio_video_reqgetuinbyopenid = new aio_video$ReqGetUinByOpenId();
            aio_video_reqgetuinbyopenid.app_id.set(parseInt);
            aio_video_reqgetuinbyopenid.open_id.set(ByteStringMicro.copyFromUtf8(str2));
            aio_video_reqgetuinbyopenid.group_id.set(parseLong);
            ProtoUtils.f(this.f313845h, new c(interfaceC8971f), aio_video_reqgetuinbyopenid.toByteArray(), "QQAIOMediaSvc.get_uin_by_openid", null, false);
        } catch (Exception e16) {
            QLog.e("urlSecMgr", 2, e16.toString());
        }
    }

    public void i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        int i3 = bundle.getInt("uploadType", 1);
        String string = bundle.getString("originUrl");
        String string2 = bundle.getString("url");
        String string3 = bundle.getString("screenshot");
        String string4 = bundle.getString("title");
        String string5 = bundle.getString("uin");
        bundle.getString("inputText");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("text_features");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("js_func_features");
        int i16 = bundle.getInt("passwdShow", -1);
        bundle.getInt("passwdInput", -1);
        int i17 = bundle.getInt("hasVirtualKB", -1);
        PasswdUrlReport$ReqBody passwdUrlReport$ReqBody = new PasswdUrlReport$ReqBody();
        passwdUrlReport$ReqBody.upload_type.set(i3);
        PasswdUrlReport$UploadReqItem passwdUrlReport$UploadReqItem = new PasswdUrlReport$UploadReqItem();
        if (!TextUtils.isEmpty(string)) {
            passwdUrlReport$UploadReqItem.origin_url.set(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            passwdUrlReport$UploadReqItem.url.set(string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            passwdUrlReport$UploadReqItem.screenshot.set(string3);
        }
        if (!TextUtils.isEmpty(string4)) {
            passwdUrlReport$UploadReqItem.title.set(string4);
        }
        if (!TextUtils.isEmpty(string5)) {
            passwdUrlReport$UploadReqItem.uin.set(ByteStringMicro.copyFromUtf8(string5));
        }
        if (stringArrayList != null && stringArrayList.size() > 0) {
            passwdUrlReport$UploadReqItem.text_features.set(stringArrayList);
        }
        if (stringArrayList2 != null && stringArrayList2.size() > 0) {
            passwdUrlReport$UploadReqItem.js_func_features.set(stringArrayList2);
        }
        if (i17 != -1) {
            passwdUrlReport$UploadReqItem.passwd_input.set(i17);
        }
        if (i16 != -1) {
            passwdUrlReport$UploadReqItem.passwd_show.set(i16);
        }
        passwdUrlReport$ReqBody.upload_req_item.set(passwdUrlReport$UploadReqItem);
        if (QLog.isColorLevel()) {
            QLog.d("urlSecMgr", 2, "reportAntiPasswd  originUrl:", string);
        }
        ProtoUtils.c(this.f313845h, new b(), passwdUrlReport$ReqBody.toByteArray(), "PasswdUrlReport.report", 0, 0, null, 10000L);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.D = true;
            this.f313844f.removeCallbacksAndMessages(null);
        }
    }
}
