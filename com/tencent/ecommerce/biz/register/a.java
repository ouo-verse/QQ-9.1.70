package com.tencent.ecommerce.biz.register;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eR\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/register/a;", "", "", "isQualified", "", "d", "c", "f", "g", h.F, "e", "k", "a", "i", "", "isPass", "b", "type", "scene", QzoneIPCModule.RESULT_CODE, "j", "", "J", "uin", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f103962b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final long uin = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();

    a() {
    }

    public final void a() {
        Map<Object, Object> f16 = new e().f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportAuthorizeClk] param = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_realname_authorize_clk", f16, false, 4, null);
    }

    public final void c() {
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportGudingNextClk] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_guding_next_clk", f16, false, 4, null);
    }

    public final void d(boolean isQualified) {
        boolean b16 = b.f103963a.b();
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        eVar.b("isNewReg", String.valueOf(b16 ? 1 : 0));
        eVar.b("is_qualified", String.valueOf(isQualified ? 1 : 0));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportGuidingExp] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_guding_exp", f16, false, 4, null);
    }

    public final void e() {
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportProfileBindClk] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_profile_bind_clk", f16, false, 4, null);
    }

    public final void f() {
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportProfileExp] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_profile_exp", f16, false, 4, null);
    }

    public final void g() {
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportProfileGetcodeClk] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_profile_getcode_clk", f16, false, 4, null);
    }

    public final void h() {
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportProfileHmverifyExp] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_profile_hmverify_exp", f16, false, 4, null);
    }

    public final void i() {
        Map<Object, Object> f16 = new e().f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportRealnameVerify] param = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_authorize_realname_verify", f16, false, 4, null);
    }

    public final void j(int type, int scene, int resultCode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", Integer.valueOf(type));
        linkedHashMap.put("scene", Integer.valueOf(scene));
        linkedHashMap.put("result_code", Integer.valueOf(resultCode));
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_quality_register_process", linkedHashMap, false, 4, null);
    }

    public final void k() {
        boolean b16 = b.f103963a.b();
        e eVar = new e();
        eVar.b("uin", String.valueOf(uin));
        eVar.b("isNewReg", String.valueOf(b16 ? 1 : 0));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportSuccessToast] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_success_toast", f16, false, 4, null);
    }

    public final void b(int isPass) {
        String str;
        if (isPass == 0) {
            str = "1";
        } else {
            str = "0";
        }
        e eVar = new e();
        eVar.b("is_pass", str);
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECommerceRegisterReportUtil", "[reportFaceVerifyResult] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_kt_authorize_face_verify_result", f16, false, 4, null);
    }
}
