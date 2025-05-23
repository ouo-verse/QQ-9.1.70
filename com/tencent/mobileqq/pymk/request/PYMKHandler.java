package com.tencent.mobileqq.pymk.request;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pymk.h;
import com.tencent.mobileqq.pymk.k;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J&\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/pymk/request/PYMKHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "E2", Constants.BASE_IN_PLUGIN_VERSION, "F2", "", "", "getCommandList", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "isSwitchOn", Constants.MMCCID, "reqGetPYMKSetting", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PYMKHandler extends BusinessHandler {
    public PYMKHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private final void F2(Object data) {
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
            oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(data as ByteArray)");
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = mergeFrom;
            int i3 = oidb_sso_oidbssopkg2.uint32_result.get();
            boolean z16 = i3 == 0;
            QLog.d("PYMKHandler", 1, "parseData success=" + z16 + ", resultCode=" + i3);
            if (z16 && oidb_sso_oidbssopkg2.bytes_bodybuffer.has() && oidb_sso_oidbssopkg2.bytes_bodybuffer.get() != null) {
                oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg2.bytes_bodybuffer.get().toByteArray());
                if (!oidb_0x5eb_rspbody.rpt_msg_uin_data.has() || oidb_0x5eb_rspbody.rpt_msg_uin_data.get().size() <= 0) {
                    return;
                }
                oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0);
                if (oidb_0x5eb_udcuindata.uint32_may_know_person_switch.has()) {
                    k.k(k.f261468a, oidb_0x5eb_udcuindata.uint32_may_know_person_switch.get() == 0, this.appRuntime, false, 4, null);
                }
            }
        } catch (Exception e16) {
            QLog.e("PYMKHandler", 1, "handleGetSwitchSetting error " + e16);
        }
    }

    public final void G2(boolean isSwitchOn) {
        QLog.i("PYMKHandler", 1, "reqSetPYMKSetting isSwitchOn:" + isSwitchOn);
        long longAccountUin = this.appRuntime.getLongAccountUin();
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(longAccountUin));
        oidb_0x587_reqbody.uint32_may_know_person_switch.set(!isSwitchOn ? 1 : 0);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x587_74", 1415, 74, oidb_0x587_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("req_set_pymk_setting_tag", Boolean.TRUE);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x587_74");
            this.allowCmdSet.add("OidbSvc.0x5eb_22");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return h.class;
    }

    public final void reqGetPYMKSetting() {
        QLog.i("PYMKHandler", 1, "reqGetPYMKSetting");
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(currentAccountUin)));
            oidb_0x5eb_reqbody.uint32_may_know_person_switch.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("req_get_pymk_setting_tag", Boolean.TRUE);
            makeOIDBPkg.addAttribute("uin", currentAccountUin);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("PYMKHandler", 1, "reqGetPYMKSetting error:", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
        String serviceCmd = res != null ? res.getServiceCmd() : null;
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        if (Intrinsics.areEqual(serviceCmd, "OidbSvc.0x587_74")) {
            E2(req, res, data);
        } else if (Intrinsics.areEqual(serviceCmd, "OidbSvc.0x5eb_22")) {
            D2(req, res, data);
        }
    }

    private final void D2(ToServiceMsg req, FromServiceMsg res, Object data) {
        boolean z16 = false;
        if (req != null ? Intrinsics.areEqual(req.getAttribute("req_get_pymk_setting_tag"), Boolean.TRUE) : false) {
            Object attribute = req.getAttribute("uin");
            Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
            String str = (String) attribute;
            if (TextUtils.isEmpty(str) || !TextUtils.equals(this.appRuntime.getCurrentAccountUin(), str)) {
                return;
            }
            if ((res != null && res.isSuccess()) && data != null) {
                z16 = true;
            }
            if (z16) {
                F2(data);
            }
        }
    }

    private final void E2(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (req != null ? Intrinsics.areEqual(req.getAttribute("req_set_pymk_setting_tag"), Boolean.TRUE) : false) {
            int i3 = -1;
            if ((res != null && res.isSuccess()) && data != null) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(data as ByteArray)");
                    i3 = mergeFrom.uint32_result.get();
                    QLog.d("PYMKHandler", 1, "handleSetSwitchSetting  resultCode=" + i3);
                } catch (Exception e16) {
                    QLog.e("PYMKHandler", 1, "handleSetSwitchSetting error " + e16);
                }
            } else {
                QLog.e("PYMKHandler", 1, "handleSetSwitchSetting isSuccess false, data " + data);
            }
            notifyUI(42089, i3 == 0, null);
        }
    }
}
