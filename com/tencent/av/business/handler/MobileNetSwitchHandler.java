package com.tencent.av.business.handler;

import android.os.Bundle;
import com.tencent.av.business.servlet.d;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J&\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH\u0014J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u000bJ$\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J$\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/av/business/handler/MobileNetSwitchHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "", "getCommandList", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/av/business/servlet/d;", "E2", Constants.BASE_IN_PLUGIN_VERSION, "resp", "F2", "", "turnOn", "H2", Constants.MMCCID, "d", "Lcom/tencent/av/business/servlet/d;", "mMobileNetSwitchService", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class MobileNetSwitchHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mMobileNetSwitchService;

    public MobileNetSwitchHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        this.mMobileNetSwitchService = new d(appInterface);
    }

    public final void D2() {
        if (this.appRuntime == null) {
            QLog.e("MobileNetSwitchHandler", 1, "getMobileNetSwitch app null");
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        try {
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchHandler", 1, "getMobileNetSwitch uinList: " + this.appRuntime.getLongAccountUin());
            }
            arrayList.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
            oidb_0x5eb_reqbody.uint32_flag_use_mobile_net_switch.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
            makeOIDBPkg.extraData.putBoolean("key_request_from_mobile_switch", true);
            this.mMobileNetSwitchService.d(makeOIDBPkg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("MobileNetSwitchHandler", 2, "getMobileNetSwitch error", e16);
            }
        }
    }

    @NotNull
    /* renamed from: E2, reason: from getter */
    public final d getMMobileNetSwitchService() {
        return this.mMobileNetSwitchService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F2(@Nullable ToServiceMsg req, @Nullable FromServiceMsg resp, @Nullable Object data) {
        boolean z16;
        boolean z17;
        oidb_sso$OIDBSSOPkg mergeFrom;
        int i3;
        Bundle bundle;
        int i16 = 0;
        boolean z18 = false;
        if (req != null && (bundle = req.extraData) != null) {
            z16 = bundle.getBoolean("key_request_from_mobile_switch");
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("MobileNetSwitchHandler", 2, "handleGetMobileNetSwitch isFromMobileNetSwitch false");
            return;
        }
        Intrinsics.checkNotNull(resp);
        if (resp.isSuccess() && data != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MobileNetSwitchHandler", 1, "handleGetMobileNetSwitch success=" + resp.getResultCode());
        }
        try {
            if (z17) {
                try {
                    mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) data);
                    if (mergeFrom.uint32_result.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                } catch (Exception e16) {
                    QLog.e("MobileNetSwitchHandler", 1, "handleGetMobileNetSwitch ex", e16);
                    QLog.e("MobileNetSwitchHandler", 1, "handleGetMobileNetSwitch result=" + z17);
                }
                if (z17 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        i16 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_flag_use_mobile_net_switch.get();
                        if (QLog.isColorLevel()) {
                            QLog.i("MobileNetSwitchHandler", 2, "handleGetMobileNetSwitch flag:" + i16);
                        }
                        i3 = i16;
                        z18 = true;
                    } else {
                        i3 = false;
                    }
                    QLog.e("MobileNetSwitchHandler", 1, "handleGetMobileNetSwitch result=" + z18);
                    boolean z19 = z18;
                    i16 = i3;
                    z17 = z19;
                    notifyUI(1, z17, Integer.valueOf(i16));
                }
            }
            z18 = z17;
            i3 = false;
            QLog.e("MobileNetSwitchHandler", 1, "handleGetMobileNetSwitch result=" + z18);
            boolean z192 = z18;
            i16 = i3;
            z17 = z192;
            notifyUI(1, z17, Integer.valueOf(i16));
        } catch (Throwable th5) {
            QLog.e("MobileNetSwitchHandler", 1, "handleGetMobileNetSwitch result=" + z17);
            throw th5;
        }
    }

    public final void G2(@Nullable ToServiceMsg req, @Nullable FromServiceMsg resp, @Nullable Object data) {
        boolean z16;
        Bundle bundle;
        boolean z17 = false;
        if (resp != null && resp.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MobileNetSwitchHandler", 2, "handleSetMobileNetSwitch() isSuccess " + z16);
        }
        if (z16) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
            byte[] bArr = (byte[]) data;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom(bArr);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(bytes)");
                oidb_sso_oidbssopkg = mergeFrom;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("MobileNetSwitchHandler", 1, "handleSetMobileNetSwitch()  e =", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                z17 = true;
            }
            z16 = z17;
        }
        if (!z16) {
            QLog.e("MobileNetSwitchHandler", 1, "handleSetMobileNetSwitch result false");
        }
        Boolean bool = null;
        if (z16 && req != null && (bundle = req.extraData) != null) {
            bool = Boolean.valueOf(bundle.getBoolean(AppConstants.Preferences.QAV_MOBILE_NET_SUPPORT));
        }
        notifyUI(2, z16, bool);
    }

    public final void H2(boolean turnOn) {
        int i3;
        if (this.appRuntime == null) {
            QLog.e("MobileNetSwitchHandler", 1, "setMobileNetSwitch app null");
            return;
        }
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        try {
            oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
            PBUInt32Field pBUInt32Field = oidb_0x587_reqbody.uint32_flag_use_mobile_net_switch;
            if (turnOn) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            pBUInt32Field.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x587_74", 1415, 74, oidb_0x587_reqbody.toByteArray());
            makeOIDBPkg.extraData.putBoolean(AppConstants.Preferences.QAV_MOBILE_NET_SUPPORT, turnOn);
            if (QLog.isColorLevel()) {
                QLog.d("MobileNetSwitchHandler", 2, "setMobileNetSwitch() setMobileNetSwitch turnOn " + turnOn);
            }
            this.mMobileNetSwitchService.d(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.d("MobileNetSwitchHandler", 1, "setMobileNetSwitch()  e =", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x5eb_22");
            this.allowCmdSet.add("OidbSvc.0x587_74");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return lu.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        if (res != null) {
            str = res.getServiceCmd();
        } else {
            str = null;
        }
        if (msgCmdFilter(str)) {
            return;
        }
        if (Intrinsics.areEqual(str, "OidbSvc.0x5eb_22")) {
            F2(req, res, data);
        } else if (Intrinsics.areEqual(str, "OidbSvc.0x587_74")) {
            G2(req, res, data);
        }
    }
}
