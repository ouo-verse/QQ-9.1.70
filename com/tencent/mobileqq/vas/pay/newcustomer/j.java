package com.tencent.mobileqq.vas.pay.newcustomer;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$GetExperienceSvipInfoReq;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$GetExperienceSvipInfoRsp;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$ReceiveExperienceSvipReq;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$ReceiveExperienceSvipRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J$\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/j;", "", "Lmqq/app/AppRuntime;", "app", "", "enteranceId", "Lh23/d;", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$GetExperienceSvipInfoRsp;", "callback", "", tl.h.F, "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$ReceiveExperienceSvipRsp;", "e", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final h23.d callback, int i3, final boolean z16, final Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.i
            @Override // java.lang.Runnable
            public final void run() {
                j.g(z16, obj, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, Object obj, h23.d callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16 && (obj instanceof byte[])) {
            try {
                ExperienceSvipServerPB$ReceiveExperienceSvipRsp result = new MessageMicro<ExperienceSvipServerPB$ReceiveExperienceSvipRsp>() { // from class: com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$ReceiveExperienceSvipRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_succ", "reason"}, new Object[]{Boolean.FALSE, ""}, ExperienceSvipServerPB$ReceiveExperienceSvipRsp.class);
                    public final PBBoolField is_succ = PBField.initBool(false);
                    public final PBStringField reason = PBField.initString("");
                }.mergeFrom((byte[]) obj);
                Intrinsics.checkNotNullExpressionValue(result, "result");
                callback.success(result, obj);
                return;
            } catch (InvalidProtocolBufferNanoException e16) {
                QLog.i("QVipNewCustomerModel", 1, "\u6570\u636e\u89e3\u6790\u5f02\u5e38:" + e16.getMessage());
                callback.a(-100, "exception_happened");
                return;
            }
        }
        callback.a(-101, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final h23.d callback, int i3, final boolean z16, final Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.h
            @Override // java.lang.Runnable
            public final void run() {
                j.j(z16, obj, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(boolean z16, Object obj, h23.d callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16 && (obj instanceof byte[])) {
            try {
                ExperienceSvipServerPB$GetExperienceSvipInfoRsp result = new ExperienceSvipServerPB$GetExperienceSvipInfoRsp().mergeFrom((byte[]) obj);
                Intrinsics.checkNotNullExpressionValue(result, "result");
                callback.success(result, obj);
                return;
            } catch (InvalidProtocolBufferNanoException e16) {
                QLog.i("QVipNewCustomerModel", 1, "\u6570\u636e\u89e3\u6790\u5f02\u5e38:" + e16.getMessage());
                callback.a(-100, "exception_happened");
                return;
            }
        }
        callback.a(-101, "");
    }

    public final void e(@NotNull AppRuntime app, @NotNull String enteranceId, @NotNull final h23.d<ExperienceSvipServerPB$ReceiveExperienceSvipRsp> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(enteranceId, "enteranceId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("QVipNewCustomerModel", 1, "receiveExperience");
        ExperienceSvipServerPB$ReceiveExperienceSvipReq experienceSvipServerPB$ReceiveExperienceSvipReq = new ExperienceSvipServerPB$ReceiveExperienceSvipReq();
        experienceSvipServerPB$ReceiveExperienceSvipReq.enterance_id.set(enteranceId);
        VasUtil.getService(app).getPbRequest().request("trpc.qqva.experience_svip_server.SsoExperienceSvipServer.SsoReceiveExperienceSvip", experienceSvipServerPB$ReceiveExperienceSvipReq.toByteArray(), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.f
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                j.f(h23.d.this, i3, z16, obj);
            }
        });
    }

    public final void h(@NotNull AppRuntime app, @NotNull String enteranceId, @NotNull final h23.d<ExperienceSvipServerPB$GetExperienceSvipInfoRsp> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(enteranceId, "enteranceId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("QVipNewCustomerModel", 1, "request NewCustomer Data");
        ExperienceSvipServerPB$GetExperienceSvipInfoReq experienceSvipServerPB$GetExperienceSvipInfoReq = new ExperienceSvipServerPB$GetExperienceSvipInfoReq();
        experienceSvipServerPB$GetExperienceSvipInfoReq.enterance_id.set(enteranceId);
        VasUtil.getService(app).getPbRequest().request("trpc.qqva.experience_svip_server.SsoExperienceSvipServer.SsoGetExperienceSvipInfo", experienceSvipServerPB$GetExperienceSvipInfoReq.toByteArray(), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.g
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                j.i(h23.d.this, i3, z16, obj);
            }
        });
    }
}
