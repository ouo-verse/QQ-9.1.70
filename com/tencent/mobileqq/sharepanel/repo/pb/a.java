package com.tencent.mobileqq.sharepanel.repo.pb;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.model.b;
import com.tencent.mobileqq.sharepanel.model.c;
import com.tencent.mobileqq.sharepanel.model.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J8\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002J8\u0010\u0013\u001a\u00020\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/repo/pb/a;", "", "Lcom/tencent/mobileqq/sharepanel/model/b;", "T", "", "bizID", "", "platInt", "Lcom/tencent/mobileqq/sharepanel/repo/pb/ServicePB$CreateShareRsp;", "rsp", "Lcom/tencent/mobileqq/sharepanel/api/a;", "callback", "", "b", "Lcom/tencent/mobileqq/sharepanel/model/c;", "reqData", "dataType", "", "bizData", "c", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f287583a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/sharepanel/repo/pb/a$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.repo.pb.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8590a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.sharepanel.api.a<T> f287584d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f287585e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f287586f;

        C8590a(com.tencent.mobileqq.sharepanel.api.a<T> aVar, c cVar, int i3) {
            this.f287584d = aVar;
            this.f287585e = cVar;
            this.f287586f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, cVar, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0 && data != null) {
                ServicePB$CreateShareRsp servicePB$CreateShareRsp = new ServicePB$CreateShareRsp();
                servicePB$CreateShareRsp.mergeFrom(data);
                QLog.d("ShareDataRepo", 4, "requestShareData , error code:" + servicePB$CreateShareRsp.err.code.get() + ", error msg: " + servicePB$CreateShareRsp.err.f287582msg.get() + "rsp template_data: " + servicePB$CreateShareRsp.template_data.get() + ", plat_data: " + servicePB$CreateShareRsp.plat_data.get());
                int i3 = servicePB$CreateShareRsp.err.code.get();
                String resultErrorMsg = servicePB$CreateShareRsp.err.f287582msg.get();
                if (i3 == 0) {
                    a.f287583a.b(this.f287585e.a(), this.f287586f, servicePB$CreateShareRsp, this.f287584d);
                    return;
                }
                com.tencent.mobileqq.sharepanel.api.a<T> aVar = this.f287584d;
                Intrinsics.checkNotNullExpressionValue(resultErrorMsg, "resultErrorMsg");
                aVar.a(false, errorCode, resultErrorMsg, null, null);
                return;
            }
            QLog.e("ShareDataRepo", 1, "requestShareData errorCode: " + errorCode);
            this.f287584d.a(false, errorCode, "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef", null, null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42681);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287583a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends b> void b(String bizID, int platInt, ServicePB$CreateShareRsp rsp, com.tencent.mobileqq.sharepanel.api.a<T> callback) {
        String str;
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        byte[] bArr2;
        com.tencent.mobileqq.sharepanel.util.a aVar = com.tencent.mobileqq.sharepanel.util.a.f287599a;
        String str5 = rsp.plat_data.get();
        Intrinsics.checkNotNullExpressionValue(str5, "rsp.plat_data.get()");
        HashMap<String, String> a16 = aVar.a(str5);
        if (a16 == null) {
            QLog.e("ShareJsonUtil", 1, "data error json = " + rsp.plat_data.get());
            callback.a(false, -1, "data error", null, null);
            return;
        }
        String str6 = "";
        if (platInt == 2 || platInt == 3) {
            String str7 = a16.get("url");
            if (str7 == null) {
                str = "";
            } else {
                str = str7;
            }
            String str8 = a16.get("title");
            if (str8 == null) {
                str2 = "";
            } else {
                str2 = str8;
            }
            String str9 = a16.get("description");
            if (str9 == null) {
                str3 = "";
            } else {
                str3 = str9;
            }
            String str10 = a16.get("icon_url");
            if (str10 == null) {
                str4 = "";
            } else {
                str4 = str10;
            }
            byte[] byteArray = rsp.info.busi_data.get().toByteArray();
            if (byteArray == null) {
                bArr = null;
            } else {
                bArr = byteArray;
            }
            callback.a(true, 0, "", new e(bizID, str2, str3, str4, str), bArr);
        }
        if (platInt == 1) {
            String str11 = rsp.template_data.get();
            if (str11 == null) {
                str11 = "";
            }
            String str12 = a16.get(QQCustomArkDialogUtil.BIZ_SRC);
            if (str12 == null) {
                str12 = "";
            }
            String str13 = a16.get("prompt");
            if (str13 != null) {
                str6 = str13;
            }
            byte[] byteArray2 = rsp.info.busi_data.get().toByteArray();
            if (byteArray2 == null) {
                bArr2 = null;
            } else {
                bArr2 = byteArray2;
            }
            callback.a(true, 0, "", new com.tencent.mobileqq.sharepanel.model.a(bizID, str11, str12, str6), bArr2);
        }
    }

    public final <T extends b> void c(@NotNull c reqData, int dataType, @Nullable byte[] bizData, @NotNull com.tencent.mobileqq.sharepanel.api.a<T> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, reqData, Integer.valueOf(dataType), bizData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ServicePB$CreateShareReq servicePB$CreateShareReq = new ServicePB$CreateShareReq();
        ServicePB$ShareInfo servicePB$ShareInfo = servicePB$CreateShareReq.info;
        ServicePB$ShareInfo servicePB$ShareInfo2 = new ServicePB$ShareInfo();
        servicePB$ShareInfo2.busi_id.set(reqData.a());
        servicePB$ShareInfo2.resource_id.set(reqData.b());
        servicePB$ShareInfo2.template.set(reqData.d());
        servicePB$ShareInfo2.plat.set(dataType);
        servicePB$ShareInfo2.busi_data.set(ByteStringMicro.copyFrom(bizData));
        servicePB$ShareInfo.set(servicePB$ShareInfo2);
        C8590a c8590a = new C8590a(callback, reqData, dataType);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ProtoUtils.a(peekAppRuntime, c8590a, servicePB$CreateShareReq.toByteArray(), "OidbSvcTrpcTcp.0x9409_" + reqData.c(), 37897, reqData.c());
        }
    }
}
