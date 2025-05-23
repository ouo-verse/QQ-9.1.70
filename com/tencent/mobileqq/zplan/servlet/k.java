package com.tencent.mobileqq.zplan.servlet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x587.oidb_0x587$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/k;", "", "Ltencent/im/oidb/cmd0x587/oidb_0x587$ReqBody;", "body", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "b", "data", "Ltencent/im/oidb/cmd0x587/oidb_0x587$RspBody;", "c", "", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f335419a = new k();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/k$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements b {
        a() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            try {
                if (k.f335419a.c(data) == null) {
                    QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "uploadPhoneModel fail, extract0x587RespPkg get null");
                } else {
                    QLog.i("[zplan]ZPlanReportDeviceRequest", 1, "uploadPhoneModel success");
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "uploadPhoneModel onUpdate exception:", e16);
            }
        }
    }

    k() {
    }

    private final oidb_sso$OIDBSSOPkg b(oidb_0x587$ReqBody body) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1415);
        oidb_sso_oidbssopkg.uint32_service_type.set(123);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(body.toByteArray()));
        return oidb_sso_oidbssopkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v9, types: [tencent.im.oidb.cmd0x587.oidb_0x587$RspBody, com.tencent.mobileqq.pb.MessageMicro] */
    public final oidb_0x587$RspBody c(Object data) {
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
            oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
            Integer valueOf = oidb_sso_oidbssopkg.uint32_result.has() ? Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()) : null;
            String str = oidb_sso_oidbssopkg.str_error_msg.has() ? oidb_sso_oidbssopkg.str_error_msg.get() : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                ?? r75 = new MessageMicro<oidb_0x587$RspBody>() { // from class: tencent.im.oidb.cmd0x587.oidb_0x587$RspBody
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x587$RspBody.class);
                };
                r75.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                return r75;
            }
            QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "extract0x587RespPkg fail, result:" + valueOf + ", errMsg:" + str);
            return null;
        } catch (Throwable th5) {
            QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "extract0x587RespPkg exception:", th5);
            return null;
        }
    }

    public final void d() {
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        try {
            AppRuntime d16 = bb.f335811a.d();
            if (d16 == null) {
                return;
            }
            long longAccountUin = d16.getLongAccountUin();
            if (longAccountUin < 0) {
                QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "uploadPhoneType uin invalid", Long.valueOf(longAccountUin));
                return;
            }
            oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(longAccountUin));
            oidb_0x587_reqbody.phone_type.set(DeviceInfoMonitor.getModel());
            oidb_sso$OIDBSSOPkg b16 = b(oidb_0x587_reqbody);
            ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
            if (a16 == null) {
                QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "uploadPhoneType error, handler null");
            } else {
                a16.request("OidbSvc.0x587_123", b16.toByteArray(), new a());
            }
        } catch (Exception e16) {
            QLog.e("[zplan]ZPlanReportDeviceRequest", 1, "uploadPhoneType error", e16);
        }
    }
}
