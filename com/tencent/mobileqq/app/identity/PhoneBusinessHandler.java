package com.tencent.mobileqq.app.identity;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$ReqBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;
import tencent.im.oidb.cmd0xa07.oidb_0xa07$BuPhoneAttrTlv;
import tencent.im.oidb.cmd0xa07.oidb_0xa07$ReqBody;
import tencent.im.trpc.TrpcMbm$MbManagementRequest;
import tencent.im.trpc.TrpcMbm$MbManagementResponse;
import tencent.im.trpc.TrpcMbm$SafeCheckInfo;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u0019H\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/app/identity/PhoneBusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "E2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "J2", "I2", "H2", "F2", "Lcom/tencent/mobileqq/app/identity/i;", "observer", Constants.MMCCID, "", "token", Constants.BASE_IN_PLUGIN_VERSION, "K2", "", "getCommandList", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PhoneBusinessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/identity/PhoneBusinessHandler$a;", "", "", "CMD_CANCEL_PHONE_UPGRADE", "Ljava/lang/String;", "CMD_QUICK_PHONE_UPGRADE", "CMD_REQ_PHONE_UPGRADE", "", "ST_CANCEL_PHONE_UPGRADE", "I", "ST_REQ_PHONE_UPGRADE", "TAG", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.identity.PhoneBusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneBusinessHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        }
    }

    private final String E2() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        if (TextUtils.isEmpty(uuid)) {
            return "";
        }
        return new Regex("[^(0-9A-Za-z)]").replace(uuid, "");
    }

    private final String F2() {
        String bytes2HexStr;
        byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
        if (c16 == null || (bytes2HexStr = HexUtil.bytes2HexStr(c16)) == null) {
            return "";
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = bytes2HexStr.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (lowerCase == null) {
            return "";
        }
        return lowerCase;
    }

    private final void H2(ToServiceMsg req, FromServiceMsg res, Object data) {
        notifyUI(req, 3, res.isSuccess(), (Object) null);
    }

    private final void I2(ToServiceMsg req, FromServiceMsg res, Object data) {
        TrpcMbm$MbManagementResponse trpcMbm$MbManagementResponse;
        boolean z16 = false;
        if (res.isSuccess()) {
            trpcMbm$MbManagementResponse = new TrpcMbm$MbManagementResponse();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, trpcMbm$MbManagementResponse);
            if (parseOIDBPkg != 0) {
                QLog.w("PhoneBusinessHandler", 1, "handleQuickPhoneUpgradeRsp result=" + parseOIDBPkg);
            } else {
                z16 = true;
            }
        } else {
            trpcMbm$MbManagementResponse = null;
        }
        notifyUI(req, 2, z16, trpcMbm$MbManagementResponse);
    }

    private final void J2(ToServiceMsg req, FromServiceMsg res, Object data) {
        cmd0x9ae$RspBody cmd0x9ae_rspbody;
        boolean z16 = false;
        if (res.isSuccess()) {
            cmd0x9ae_rspbody = new cmd0x9ae$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, cmd0x9ae_rspbody);
            if (parseOIDBPkg != 0) {
                QLog.w("PhoneBusinessHandler", 1, "handleReqPhoneUpgradeRsp result=" + parseOIDBPkg);
            } else {
                z16 = true;
            }
        } else {
            cmd0x9ae_rspbody = null;
        }
        notifyUI(req, 1, z16, cmd0x9ae_rspbody);
    }

    public final void D2(@NotNull byte[] token, @Nullable i observer) {
        List<oidb_0xa07$BuPhoneAttrTlv> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) token, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        oidb_0xa07$ReqBody oidb_0xa07_reqbody = new oidb_0xa07$ReqBody();
        oidb_0xa07_reqbody.enum_butype.set(12);
        oidb_0xa07_reqbody.enum_source_id.set(2);
        oidb_0xa07$BuPhoneAttrTlv oidb_0xa07_buphoneattrtlv = new oidb_0xa07$BuPhoneAttrTlv();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) NetConnInfoCenter.getServerTime());
        byte[] array = allocate.array();
        oidb_0xa07_buphoneattrtlv.uint32_tag.set(104);
        oidb_0xa07_buphoneattrtlv.bytes_values.set(ByteStringMicro.copyFrom(array));
        oidb_0xa07_buphoneattrtlv.uint32_len.set(array.length);
        oidb_0xa07_buphoneattrtlv.setHasFlag(true);
        PBRepeatMessageField<oidb_0xa07$BuPhoneAttrTlv> pBRepeatMessageField = oidb_0xa07_reqbody.msg_tlv;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(oidb_0xa07_buphoneattrtlv);
        pBRepeatMessageField.set(listOf);
        oidb_0xa07_reqbody.bytes_token.set(ByteStringMicro.copyFrom(token));
        oidb_0xa07_reqbody.setHasFlag(true);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xa07_12", 2567, 12, oidb_0xa07_reqbody.toByteArray());
        addBusinessObserver(makeOIDBPkg, observer, false);
        sendPbReq(makeOIDBPkg);
    }

    public final void G2(@Nullable i observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) observer);
            return;
        }
        cmd0x9ae$ReqBody cmd0x9ae_reqbody = new cmd0x9ae$ReqBody();
        cmd0x9ae_reqbody.enum_req_source.set(2);
        cmd0x9ae_reqbody.setHasFlag(true);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x9ae_16", 2478, 16, cmd0x9ae_reqbody.toByteArray());
        addBusinessObserver(makeOIDBPkg, observer, false);
        sendPbReq(makeOIDBPkg);
    }

    public final void K2(@NotNull byte[] token, @Nullable i observer) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) token, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "0";
        }
        TrpcMbm$MbManagementRequest trpcMbm$MbManagementRequest = new TrpcMbm$MbManagementRequest();
        trpcMbm$MbManagementRequest.mbm_head_info.user_mbm_info.uin.set(bv.b(str, 0L));
        trpcMbm$MbManagementRequest.mbm_head_info.user_mbm_info.setHasFlag(true);
        TrpcMbm$SafeCheckInfo trpcMbm$SafeCheckInfo = trpcMbm$MbManagementRequest.mbm_head_info.safe_check_info;
        trpcMbm$SafeCheckInfo.scene.set(216);
        trpcMbm$SafeCheckInfo.verify_method.set(1);
        trpcMbm$SafeCheckInfo.client_ver.set(AppSetting.f99551k);
        trpcMbm$SafeCheckInfo.client_type.set(1);
        trpcMbm$SafeCheckInfo.platform.set("Android");
        trpcMbm$SafeCheckInfo.dev_name.set(DeviceInfoMonitor.getModel());
        trpcMbm$SafeCheckInfo.guid.set(F2());
        trpcMbm$SafeCheckInfo.qimei36.set(com.tencent.mobileqq.statistics.o.c());
        trpcMbm$SafeCheckInfo.setHasFlag(true);
        trpcMbm$MbManagementRequest.mbm_head_info.setHasFlag(true);
        trpcMbm$MbManagementRequest.set_mbphone_req.token.set(ByteStringMicro.copyFrom(token));
        trpcMbm$MbManagementRequest.set_mbphone_req.setHasFlag(true);
        trpcMbm$MbManagementRequest.setHasFlag(true);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x905a_0", 36954, 0, trpcMbm$MbManagementRequest.toByteArray());
        makeOIDBPkg.setTraceInfo(E2());
        addBusinessObserver(makeOIDBPkg, observer, false);
        sendPbReq(makeOIDBPkg);
        QLog.i("PhoneBusinessHandler", 1, "quickPhoneUpgrade cmd=" + makeOIDBPkg.getServiceCmd() + " traceInfo=" + makeOIDBPkg.getTraceInfo());
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        Set<String> mutableSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            mutableSetOf = SetsKt__SetsKt.mutableSetOf("OidbSvc.0x9ae_16", "OidbSvc.0xa07_12", "OidbSvcTrpcTcp.0x905a_0");
            return mutableSetOf;
        }
        return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        QLog.i("PhoneBusinessHandler", 1, "onReceive cmd:" + res.getServiceCmd() + " resultCode:" + res.getResultCode() + " msg:" + res.getBusinessFailMsg() + " trpcRetCode:" + res.getTrpcRspRetCode() + " trpcRspFuncRetCode:" + res.getTrpcRspFuncRetCode());
        String serviceCmd = res.getServiceCmd();
        if (serviceCmd != null) {
            int hashCode = serviceCmd.hashCode();
            if (hashCode != -2086821438) {
                if (hashCode != -378427467) {
                    if (hashCode == 720115654 && serviceCmd.equals("OidbSvc.0xa07_12")) {
                        H2(req, res, data);
                        return;
                    }
                    return;
                }
                if (serviceCmd.equals("OidbSvc.0x9ae_16")) {
                    J2(req, res, data);
                    return;
                }
                return;
            }
            if (serviceCmd.equals("OidbSvcTrpcTcp.0x905a_0")) {
                I2(req, res, data);
            }
        }
    }
}
