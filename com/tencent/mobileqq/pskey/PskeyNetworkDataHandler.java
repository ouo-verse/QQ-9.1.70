package com.tencent.mobileqq.pskey;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a$GetPSkeyRequest;
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a$GetPSkeyResponse;
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a$PSKey;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J&\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/pskey/PskeyNetworkDataHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", Constants.BASE_IN_PLUGIN_VERSION, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "", "getCommandList", "onReceive", "uin", "", "domains", "Lcom/tencent/mobileqq/pskey/f;", "callback", "E2", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "b", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PskeyNetworkDataHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/pskey/PskeyNetworkDataHandler$a;", "", "", "CMD_REQ_GET_PSKEY", "Ljava/lang/String;", "GET_PSKEY_ERR_MSG", "TAG", "", "TYPE_GET_PSKEY", "I", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pskey.PskeyNetworkDataHandler$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/pskey/PskeyNetworkDataHandler$b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/mobileqq/pskey/f;", "d", "Lcom/tencent/mobileqq/pskey/f;", "callback", "<init>", "(Lcom/tencent/mobileqq/pskey/f;)V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static final class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final f callback;

        public b(@NotNull f callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            } else {
                this.callback = callback;
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @NotNull Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("PskeyNetworkDataHandler", 2, "PskeyBusinessObserver onUpdate type = " + type + " isSuccess = " + isSuccess);
            if (type == 1) {
                if (isSuccess) {
                    this.callback.onSuccess((Map) data);
                } else {
                    this.callback.onFail((String) data);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35134);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PskeyNetworkDataHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private final void D2(ToServiceMsg req, FromServiceMsg res, Object data) {
        boolean z16;
        Boolean bool;
        if (req != null && res != null && res.isSuccess() && data != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (res != null) {
                bool = Boolean.valueOf(res.isSuccess());
            } else {
                bool = null;
            }
            QLog.e("PskeyNetworkDataHandler", 1, "res.isSuccess() = " + bool + ", data = " + data);
            notifyUI(req, 1, false, "RequestPskeyError");
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) data);
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "{\n            pkg.mergeFrom(bytes)\n        }");
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = mergeFrom;
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    oidb_cmd0x102a$GetPSkeyResponse oidb_cmd0x102a_getpskeyresponse = new oidb_cmd0x102a$GetPSkeyResponse();
                    try {
                        oidb_cmd0x102a_getpskeyresponse.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        List<oidb_cmd0x102a$PSKey> list = oidb_cmd0x102a_getpskeyresponse.private_keys.get();
                        if (list != null && !list.isEmpty()) {
                            HashMap hashMap = new HashMap();
                            for (oidb_cmd0x102a$PSKey oidb_cmd0x102a_pskey : list) {
                                String domain = oidb_cmd0x102a_pskey.domain.get();
                                String key = oidb_cmd0x102a_pskey.key.get();
                                String uskey = oidb_cmd0x102a_pskey.uskey.get();
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(domain);
                                sb5.append(",");
                                if (!TextUtils.isEmpty(domain) && (!TextUtils.isEmpty(key) || !TextUtils.isEmpty(uskey))) {
                                    Intrinsics.checkNotNullExpressionValue(domain, "domain");
                                    Intrinsics.checkNotNullExpressionValue(key, "key");
                                    Intrinsics.checkNotNullExpressionValue(uskey, "uskey");
                                    hashMap.put(domain, new a(key, uskey, 0));
                                }
                            }
                            notifyUI(req, 1, true, (Object) hashMap);
                            return;
                        }
                        QLog.e("PskeyNetworkDataHandler", 1, "psKeyList = " + list);
                        notifyUI(req, 1, false, "RequestPskeyError");
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                        QLog.e("PskeyNetworkDataHandler", 1, e16, new Object[0]);
                        notifyUI(req, 1, false, "RequestPskeyError");
                        return;
                    }
                }
                QLog.e("PskeyNetworkDataHandler", 1, "pkg.bytes_bodybuffer.has() = " + oidb_sso_oidbssopkg.bytes_bodybuffer.has() + " pkg.bytes_bodybuffer.get() = " + oidb_sso_oidbssopkg.bytes_bodybuffer.get());
                notifyUI(req, 1, false, "RequestPskeyError");
                return;
            }
            QLog.e("PskeyNetworkDataHandler", 1, "pkg.uint32_result.has() = " + oidb_sso_oidbssopkg.uint32_result.has() + " pkg.uint32_result.get() = " + oidb_sso_oidbssopkg.uint32_result.get());
            notifyUI(req, 1, false, "RequestPskeyError");
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
            QLog.e("PskeyNetworkDataHandler", 1, e17, new Object[0]);
            notifyUI(req, 1, false, "RequestPskeyError");
        }
    }

    public final void E2(@NotNull String uin, @NotNull List<String> domains, @NotNull f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uin, domains, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        QLog.i("PskeyNetworkDataHandler", 2, "sendRequestPskey, uin = " + uin + ", curUin = " + currentAccountUin);
        if (!TextUtils.equals(uin, currentAccountUin)) {
            callback.onFail("uin is changed");
            return;
        }
        List<String> f16 = i.f261182a.f(domains);
        oidb_cmd0x102a$GetPSkeyRequest oidb_cmd0x102a_getpskeyrequest = new oidb_cmd0x102a$GetPSkeyRequest();
        oidb_cmd0x102a_getpskeyrequest.domains.set(f16);
        oidb_cmd0x102a_getpskeyrequest.flag.set(3);
        sendPbReq(makeOIDBPkg("OidbSvcTcp.0x102a", 4138, 0, oidb_cmd0x102a_getpskeyrequest.toByteArray(), 30000L, new b(callback), true));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            synchronized (this) {
                if (this.allowCmdSet == null) {
                    HashSet hashSet = new HashSet();
                    this.allowCmdSet = hashSet;
                    hashSet.add("OidbSvcTcp.0x102a");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, req, res, data);
            return;
        }
        if (res != null) {
            str = res.getServiceCmd();
        } else {
            str = null;
        }
        QLog.i("PskeyNetworkDataHandler", 2, "onReceive cmd = " + str);
        if (TextUtils.equals(str, "OidbSvcTcp.0x102a")) {
            D2(req, res, data);
        }
    }
}
