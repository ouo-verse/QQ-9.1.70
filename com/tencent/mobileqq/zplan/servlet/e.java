package com.tencent.mobileqq.zplan.servlet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.zplan.model.AddWhiteListResponse;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.trpcprotocol.zplan.add_whitelist.handle.handle$BatchAddWhitelistReq;
import com.tencent.trpcprotocol.zplan.add_whitelist.handle.handle$BatchAddWhitelistRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/e;", "", "", SimpleAccount._UIN, "", "_appIds", "", "fromScene", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "c", "data", "Lcom/tencent/trpcprotocol/zplan/add_whitelist/handle/handle$BatchAddWhitelistRsp;", "d", "uin", "appIds", "Lnk3/c;", "callback", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f335403a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/e$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nk3.c f335404d;

        a(nk3.c cVar) {
            this.f335404d = cVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            nk3.c cVar;
            try {
                handle$BatchAddWhitelistRsp d16 = e.f335403a.d(data);
                if (d16 == null) {
                    QLog.e("[zplan]AddWhiteListRequest", 1, "addWhiteList \u56de\u590d\u4e3a\u7a7a");
                    if (cVar != null) {
                        return;
                    } else {
                        return;
                    }
                }
                int i3 = d16.errcode.get();
                String str = d16.errmsg.get();
                Intrinsics.checkNotNullExpressionValue(str, "response.errmsg.get()");
                AddWhiteListResponse addWhiteListResponse = new AddWhiteListResponse(i3, str);
                nk3.c cVar2 = this.f335404d;
                if (cVar2 != null) {
                    cVar2.a(addWhiteListResponse);
                }
            } catch (Throwable th5) {
                try {
                    QLog.e("[zplan]AddWhiteListRequest", 1, "addWhiteList \u672a\u77e5\u9519\u8bef", th5);
                    nk3.c cVar3 = this.f335404d;
                    if (cVar3 != null) {
                        cVar3.a(null);
                    }
                } finally {
                    cVar = this.f335404d;
                    if (cVar != null) {
                        cVar.a(null);
                    }
                }
            }
        }
    }

    e() {
    }

    private final oidb_sso$OIDBSSOPkg c(long _uin, List<Long> _appIds, String fromScene) {
        handle$BatchAddWhitelistReq handle_batchaddwhitelistreq = new handle$BatchAddWhitelistReq();
        handle_batchaddwhitelistreq.appids.set(_appIds);
        PBStringField pBStringField = handle_batchaddwhitelistreq.ext_data;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("from_scene", fromScene);
        pBStringField.set(jSONObject.toString());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4426);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(handle_batchaddwhitelistreq.toByteArray()));
        return oidb_sso_oidbssopkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final handle$BatchAddWhitelistRsp d(Object data) {
        Integer num;
        String str;
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
            oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                num = Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get());
            } else {
                QLog.e("[zplan]AddWhiteListRequest", 1, "extractRspPkg \u65e0uint32_result");
                num = null;
            }
            if (oidb_sso_oidbssopkg.str_error_msg.has()) {
                str = oidb_sso_oidbssopkg.str_error_msg.get();
            } else {
                QLog.e("[zplan]AddWhiteListRequest", 1, "extractRspPkg \u65e0str_error_msg");
                str = null;
            }
            if (num != null && num.intValue() == 0) {
                handle$BatchAddWhitelistRsp handle_batchaddwhitelistrsp = new handle$BatchAddWhitelistRsp();
                handle_batchaddwhitelistrsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                return handle_batchaddwhitelistrsp;
            }
            QLog.e("[zplan]AddWhiteListRequest", 1, "extractRspPkg fail, result:" + num + ", errMsg:" + str);
            return null;
        } catch (Throwable th5) {
            QLog.e("[zplan]AddWhiteListRequest", 1, "extractRspPkg exception:", th5);
            return null;
        }
    }

    public final void b(long uin, List<Long> appIds, String fromScene, nk3.c callback) {
        Intrinsics.checkNotNullParameter(appIds, "appIds");
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        try {
            QLog.i("[zplan]AddWhiteListRequest", 1, "uin=" + uin + ", appids=" + appIds + ", fromScene=" + fromScene);
            oidb_sso$OIDBSSOPkg c16 = c(uin, appIds, fromScene);
            ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
            Intrinsics.checkNotNull(a16);
            a16.request("OidbSvcTrpcTcp.0x114a_1", c16.toByteArray(), new a(callback));
        } catch (Throwable th5) {
            QLog.e("[zplan]AddWhiteListRequest", 1, "addWhiteList \u8bf7\u6c42\u5931\u8d25", th5);
            if (callback != null) {
                callback.a(null);
            }
        }
    }
}
