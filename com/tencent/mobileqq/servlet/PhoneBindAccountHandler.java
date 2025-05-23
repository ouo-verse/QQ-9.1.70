package com.tencent.mobileqq.servlet;

import android.os.Bundle;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.oidb_0xeb2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x87a$ReqBody;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$ReqBody;
import tencent.im.oidb.oidb_0x87c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0012\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "H2", "I2", Constants.MMCCID, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "", "getCommandList", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "callback", "E2", "smsCode", "F2", "", PreloadTRTCPlayerParams.KEY_SIG, Constants.BASE_IN_PLUGIN_VERSION, "d", "Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "mCallback", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class PhoneBindAccountHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mCallback;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface a {
        void onFailed(int errorCode, @Nullable String errorMsg);

        void onSuccess(@NotNull Object data);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$b;", "", "", "CMD_GET_PHONE_BIND_ACCOUNT_INFO", "Ljava/lang/String;", "CMD_SEND_SMS_CODE", "CMD_VERIFY_SMS_CODE", "KEY_RAND_STR", "KEY_TICKET", "", "SERVICE_TYPE_PHONE_BIND_ACCOUNT_MANAGER", "I", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.servlet.PhoneBindAccountHandler$b, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneBindAccountHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        }
    }

    private final void G2(FromServiceMsg res, Object data) {
        oidb_0xeb2.RspBody rspBody = new oidb_0xeb2.RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, oidb_sso_oidbssopkg, rspBody);
        if (parseOIDBPkg != 0) {
            QLog.i("PhoneBindAccountHandler", 1, "onGetPhoneBindAccountInfo result : " + parseOIDBPkg);
            a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onFailed(parseOIDBPkg, oidb_sso_oidbssopkg.str_error_msg.get());
                return;
            }
            return;
        }
        a aVar2 = this.mCallback;
        if (aVar2 != null) {
            aVar2.onSuccess(rspBody);
        }
    }

    private final void H2(FromServiceMsg res, Object data) {
        oidb_0x87a$RspBody oidb_0x87a_rspbody = new oidb_0x87a$RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, oidb_sso_oidbssopkg, oidb_0x87a_rspbody);
        if (parseOIDBPkg != 0) {
            QLog.i("PhoneBindAccountHandler", 1, "onGetSmsCode result : " + parseOIDBPkg);
            a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onFailed(parseOIDBPkg, oidb_sso_oidbssopkg.str_error_msg.get());
                return;
            }
            return;
        }
        a aVar2 = this.mCallback;
        if (aVar2 != null) {
            aVar2.onSuccess(oidb_0x87a_rspbody);
        }
    }

    private final void I2(FromServiceMsg res, Object data) {
        oidb_0x87c$RspBody oidb_0x87c_rspbody = new oidb_0x87c$RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, oidb_sso_oidbssopkg, oidb_0x87c_rspbody);
        if (parseOIDBPkg != 0) {
            QLog.i("PhoneBindAccountHandler", 1, "onSmsCodeVerifyResult result : " + parseOIDBPkg);
            a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onFailed(parseOIDBPkg, oidb_sso_oidbssopkg.str_error_msg.get());
                return;
            }
            return;
        }
        a aVar2 = this.mCallback;
        if (aVar2 != null) {
            aVar2.onSuccess(oidb_0x87c_rspbody);
        }
    }

    public final void D2(@NotNull byte[] sig, @NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) sig, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(sig, "sig");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
        oidb_0xeb2.ReqBody reqBody = new oidb_0xeb2.ReqBody();
        reqBody.enum_butype.set(0);
        reqBody.bytes_sig.set(ByteStringMicro.copyFrom(sig));
        reqBody.uint32_source.set(1);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3762);
        oidb_sso_oidbssopkg.uint32_service_type.set(138);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(reqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xeb2_138");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public final void E2(@Nullable Bundle bundle, @Nullable a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle, (Object) callback);
            return;
        }
        this.mCallback = callback;
        oidb_0x87a$ReqBody oidb_0x87a_reqbody = new oidb_0x87a$ReqBody();
        oidb_0x87a_reqbody.enum_butype.set(0);
        if (bundle != null) {
            String string = bundle.getString("ticket");
            String string2 = bundle.getString("rand_str");
            oidb_0x87a_reqbody.fsq_info.bytes_fsq_sig.set(ByteStringMicro.copyFromUtf8(string));
            oidb_0x87a_reqbody.fsq_info.bytes_rand_str.set(ByteStringMicro.copyFromUtf8(string2));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2170);
        oidb_sso_oidbssopkg.uint32_service_type.set(138);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x87a_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x87a_138");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public final void F2(@NotNull String smsCode, @Nullable a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) smsCode, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(smsCode, "smsCode");
        this.mCallback = callback;
        oidb_0x87c$ReqBody oidb_0x87c_reqbody = new oidb_0x87c$ReqBody();
        oidb_0x87c_reqbody.enum_butype.set(0);
        oidb_0x87c_reqbody.str_sms_code.set(smsCode);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2172);
        oidb_sso_oidbssopkg.uint32_service_type.set(138);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x87c_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x87c_138");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @Nullable
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x87a_138");
            this.allowCmdSet.add("OidbSvc.0x87c_138");
            this.allowCmdSet.add("OidbSvc.0xeb2_138");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, req, res, data);
            return;
        }
        QLog.i("PhoneBindAccountHandler", 2, "onReceive");
        if (res == null || msgCmdFilter(res.getServiceCmd())) {
            return;
        }
        if (!res.isSuccess()) {
            QLog.i("PhoneBindAccountHandler", 1, "onReceive resultCode : " + res.getResultCode());
            a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onFailed(-1, "");
                return;
            }
            return;
        }
        String serviceCmd = res.getServiceCmd();
        if (serviceCmd != null) {
            int hashCode = serviceCmd.hashCode();
            if (hashCode != -939971733) {
                if (hashCode != -938124691) {
                    if (hashCode == 1530636254 && serviceCmd.equals("OidbSvc.0xeb2_138")) {
                        G2(res, data);
                        return;
                    }
                    return;
                }
                if (serviceCmd.equals("OidbSvc.0x87c_138")) {
                    I2(res, data);
                    return;
                }
                return;
            }
            if (serviceCmd.equals("OidbSvc.0x87a_138")) {
                H2(res, data);
            }
        }
    }
}
