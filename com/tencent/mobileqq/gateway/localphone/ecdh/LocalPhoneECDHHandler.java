package com.tencent.mobileqq.gateway.localphone.ecdh;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneContant;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneReq;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;
import tencent.im.login.GetLocalPhone$OIDBGetSessionIDReq;
import tencent.im.login.GetLocalPhone$OIDBGetSessionIDRsp;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0004'()&B\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J.\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", Constants.MMCCID, "F2", Const.BUNDLE_KEY_REQUEST, "sendPbReq", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "", "getCommandList", "Ltencent/im/login/GetLocalPhone$OIDBGetSessionIDReq;", "sessionIDReq", "", "serviceType", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "callback", "E2", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneReq;", "phoneReq", Constants.BASE_IN_PLUGIN_VERSION, "cmd", "command", "", "H2", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "b", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LocalPhoneECDHHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$a;", "", "", "OIDB_GET_PHONE_SERVICE", "Ljava/lang/String;", "OIDB_GET_SESSION_ID_SERVICE", "TAG", "", "TIMEOUT", "J", "", "TYPE_GET_PHONE", "I", "TYPE_GET_SESSION_ID", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gateway.localphone.ecdh.LocalPhoneECDHHandler$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void onFail(int errorCode, @Nullable String errorMsg);

        void onSuccess(@Nullable Object data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "errorCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "<init>", "(ILjava/lang/String;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String errorMsg;

        public c(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.errorCode = i3;
                this.errorMsg = str;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.errorCode;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.errorMsg;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.errorCode == cVar.errorCode && Intrinsics.areEqual(this.errorMsg, cVar.errorMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int i3 = this.errorCode * 31;
            String str = this.errorMsg;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "LocalPhoneECDHFailInfo(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$d;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "d", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "getCallback", "()Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;", "callback", "<init>", "(Lcom/tencent/mobileqq/gateway/localphone/ecdh/LocalPhoneECDHHandler$b;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b callback;

        public d(@NotNull b callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            } else {
                this.callback = callback;
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            QLog.d("LocalPhoneECDHHandler", 1, "onUpdate type: " + type + ", isSuccess: " + isSuccess);
            if (!isSuccess) {
                if (data instanceof c) {
                    c cVar = (c) data;
                    this.callback.onFail(cVar.a(), cVar.b());
                    return;
                } else {
                    this.callback.onFail(-1, "network failed!");
                    return;
                }
            }
            this.callback.onSuccess(data);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LocalPhoneECDHHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private final void F2(ToServiceMsg req, FromServiceMsg res, Object data) {
        GetLocalPhone$OIDBGetPhoneRsp getLocalPhone$OIDBGetPhoneRsp = new GetLocalPhone$OIDBGetPhoneRsp();
        if (OidbWrapper.parseOIDBPkg(res, data, new oidb_sso$OIDBSSOPkg(), getLocalPhone$OIDBGetPhoneRsp) != 0) {
            notifyUI(req, 2, false, new c(-1, "unzip oidbPkg Failed"));
        } else {
            notifyUI(req, 2, true, (Object) getLocalPhone$OIDBGetPhoneRsp);
        }
    }

    private final void G2(ToServiceMsg req, FromServiceMsg res, Object data) {
        GetLocalPhone$OIDBGetSessionIDRsp getLocalPhone$OIDBGetSessionIDRsp = new GetLocalPhone$OIDBGetSessionIDRsp();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, new oidb_sso$OIDBSSOPkg(), getLocalPhone$OIDBGetSessionIDRsp);
        if (parseOIDBPkg != 0) {
            QLog.e("LocalPhoneECDHHandler", 1, "handleSessionRsp unzip result: " + parseOIDBPkg);
            notifyUI(req, 1, false, new c(-1, "unzip oidbPkg Failed"));
            return;
        }
        notifyUI(req, 1, true, (Object) getLocalPhone$OIDBGetSessionIDRsp);
    }

    public final void D2(@NotNull GetLocalPhone$OIDBGetPhoneReq phoneReq, int serviceType, @NotNull b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, phoneReq, Integer.valueOf(serviceType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(phoneReq, "phoneReq");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("LocalPhoneECDHHandler", 2, "getPhone serviceType : " + serviceType);
        byte[] byteArray = phoneReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "phoneReq.toByteArray()");
        H2("OidbSvcTrpcTcp.0x90ce", QZoneContant.QZ_START_QZAPP_REQ, serviceType, byteArray, callback);
    }

    public final void E2(@NotNull GetLocalPhone$OIDBGetSessionIDReq sessionIDReq, int serviceType, @NotNull b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, sessionIDReq, Integer.valueOf(serviceType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionIDReq, "sessionIDReq");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("LocalPhoneECDHHandler", 2, "getSessionID serviceType : " + serviceType);
        byte[] byteArray = sessionIDReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "sessionIDReq.toByteArray()");
        H2("OidbSvcTrpcTcp.0x90cd", 37069, serviceType, byteArray, callback);
    }

    public final void H2(@NotNull String cmd, int command, int serviceType, @NotNull byte[] data, @NotNull b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, cmd, Integer.valueOf(command), Integer.valueOf(serviceType), data, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(cmd, command, serviceType, data, 10000L, new d(callback), false);
        QLog.d("LocalPhoneECDHHandler", 2, "sendReq cmd: " + cmd);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            this.allowCmdSet = new HashSet();
        }
        this.allowCmdSet.add("OidbSvcTrpcTcp.0x90ce");
        this.allowCmdSet.add("OidbSvcTrpcTcp.0x90cd");
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, req, res, data);
            return;
        }
        if (res == null || msgCmdFilter(res.getServiceCmd())) {
            return;
        }
        QLog.d("LocalPhoneECDHHandler", 2, "onReceive cmd: " + res.getServiceCmd() + " resultCode: " + res.getResultCode());
        if (data == null) {
            QLog.e("LocalPhoneECDHHandler", 1, "Get session data is null !!");
            notifyUI(req, 1, false, (Object) new c(-1, "Get session data is null !!"));
            return;
        }
        int resultCode = res.getResultCode();
        if (resultCode != 1000) {
            notifyUI(req, 1, false, (Object) new c(resultCode, "network failed!!"));
            return;
        }
        String serviceCmd = res.getServiceCmd();
        if (Intrinsics.areEqual(serviceCmd, "OidbSvcTrpcTcp.0x90cd")) {
            G2(req, res, data);
        } else if (Intrinsics.areEqual(serviceCmd, "OidbSvcTrpcTcp.0x90ce")) {
            F2(req, res, data);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void sendPbReq(@Nullable ToServiceMsg request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
        } else {
            super.sendPbReq(request);
        }
    }
}
