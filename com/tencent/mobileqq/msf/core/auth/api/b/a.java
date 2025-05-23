package com.tencent.mobileqq.msf.core.auth.api.b;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.auth.api.UIDFileUtil;
import com.tencent.mobileqq.msf.core.auth.pb.ThirdPartLogin;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.msf.core.auth.api.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f247377b = "UIDApiImpl";

    /* renamed from: c, reason: collision with root package name */
    private static final String f247378c = "login_uid_fail";

    /* renamed from: d, reason: collision with root package name */
    private static final String f247379d = "sourceUID";

    /* renamed from: e, reason: collision with root package name */
    private static final String f247380e = "storeUID";

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f247381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.auth.api.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC8069a implements Runnable {
        static IPatchRedirector $redirector_;

        RunnableC8069a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                com.tencent.mobileqq.msf.core.b0.a.b().a().sync(true);
            } catch (Exception e16) {
                QLog.e(a.f247377b, 1, e16, new Object[0]);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f247381a = new ConcurrentHashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.auth.api.a
    public boolean a(String str, WUserSigInfo wUserSigInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) wUserSigInfo)).booleanValue();
        }
        tlv_t tlv_tVar = wUserSigInfo.loginResultTLVMap.get(Integer.valueOf(util.KEY_TLV543_IN_TLV199));
        if (tlv_tVar == null) {
            return false;
        }
        try {
            ThirdPartLogin.RspBody mergeFrom = new ThirdPartLogin.RspBody().mergeFrom(tlv_tVar.get_data());
            if (!mergeFrom.has() || !mergeFrom.msg_rsp_common_info.has()) {
                return false;
            }
            String str2 = mergeFrom.msg_rsp_common_info.msg_rsp_nt.str_uid.get();
            if (TextUtils.isEmpty(str2)) {
                QLog.d(f247377b, 1, "[parseAndSaveUID]: uid is null");
                return false;
            }
            a(str, str2);
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(f247377b, 1, "[parseAndSaveUID]: 0x543 tlv illegal, merge error : InvalidProtocolBufferMicroException ", e16);
            return false;
        } catch (Throwable th5) {
            QLog.e(f247377b, 1, "[parseAndSaveUID]: 0x543 tlv illegal, merge error : ", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.auth.api.a
    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (!this.f247381a.containsKey(str)) {
            if (!"0".equals(str)) {
                QLog.d(f247377b, 1, "[getUidWithUin]: not contains uin: " + MsfSdkUtils.getShortUin(str));
                return null;
            }
            return null;
        }
        return this.f247381a.get(str);
    }

    @Override // com.tencent.mobileqq.msf.core.auth.api.a
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (this.f247381a.contains(str) && !TextUtils.isEmpty(this.f247381a.get(str))) {
            QLog.d(f247377b, 1, "uidMapping has uid of this uin:", MsfSdkUtils.getShortUin(str));
        } else {
            a(str);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.auth.api.a
    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        String b16 = b(str);
        if (TextUtils.isEmpty(b16)) {
            return a(str);
        }
        return b16;
    }

    @Override // com.tencent.mobileqq.msf.core.auth.api.a
    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        boolean encodeStringWithReturn = com.tencent.mobileqq.msf.core.b0.a.b().a().encodeStringWithReturn(str, str2);
        q.s().post(new RunnableC8069a());
        QLog.d(f247377b, 1, "[saveUIDToMMKV]: uid has saved in mmkv, result : " + encodeStringWithReturn + " key: " + MsfSdkUtils.getShortUin(str) + " value: ", str2);
        boolean putUIDToFile = UIDFileUtil.putUIDToFile(str, str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[saveUIDToFile]: uid has saved in file, result : ");
        sb5.append(putUIDToFile);
        QLog.d(f247377b, 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.msf.core.auth.api.a
    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        String decodeString = com.tencent.mobileqq.msf.core.b0.a.b().a().decodeString(str, "");
        if (!TextUtils.isEmpty(decodeString)) {
            this.f247381a.put(str, decodeString);
            QLog.d(f247377b, 1, "read uid in mmkv successful, uin: " + str + " uid: " + decodeString);
        }
        return decodeString;
    }
}
