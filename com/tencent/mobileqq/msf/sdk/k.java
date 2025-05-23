package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f250583a = "key_recv_queue_wait_length";

    /* renamed from: b, reason: collision with root package name */
    public static String f250584b = "key_add_queue_time";

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f250585c;

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<String> f250586d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17480);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250585c = a();
            f250586d = b();
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(BaseConstants.CMD_START_CONNECT);
        arrayList.add(BaseConstants.CMD_CONNOPENED);
        arrayList.add(BaseConstants.CMD_CONNWEAKNET);
        arrayList.add(BaseConstants.CMD_CONNWEAKNET_NEW);
        arrayList.add(BaseConstants.CMD_NETNEEDSIGNON);
        arrayList.add(BaseConstants.CMD_CONNCLOSED);
        arrayList.add("GrayUinPro.Check");
        return arrayList;
    }

    public static ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("OidbSvcTrpcTcp.0x123c_1");
        arrayList.add("OidbSvcTrpcTcp.0x11de_1");
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        arrayList.add(BaseConstants.CMD_NT_REGPRXSYNC_GROUP_MSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXSYNC_BATCH_GET_MSG);
        arrayList.add(BaseConstants.CMD_NT_PUSH_REGISTER);
        arrayList.add(BaseConstants.CMD_NT_PUSH_UNREGISTER);
        arrayList.add(BaseConstants.CMD_NT_SSO_HEART_BEAT);
        arrayList.add(BaseConstants.CMD_MSG_PBSENDMSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_PUSH_PARAMS);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_PUSH_INFOSYNC);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_PUSH_GROUP_MSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_PUSH_C2C_MSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_C2C_MSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_ROAM_MSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_MSG);
        arrayList.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG);
        arrayList.add(BaseConstants.CMD_MSG_UNREAD_MSG_SEQ);
        arrayList.add(BaseConstants.CMD_NT_SSO_GET_PEER_SEQ);
        return arrayList;
    }
}
