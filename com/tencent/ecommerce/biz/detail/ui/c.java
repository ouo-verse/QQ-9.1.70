package com.tencent.ecommerce.biz.detail.ui;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.pts.core.PTSComposer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/c;", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "url", "a", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/ecommerce/biz/detail/ui/ReportCallback;", "b", "Lcom/tencent/ecommerce/biz/detail/ui/ReportCallback;", "reportCallback", "Lcom/tencent/ecommerce/biz/detail/ui/GetCurrentFloatMode;", "c", "Lcom/tencent/ecommerce/biz/detail/ui/GetCurrentFloatMode;", "currentFloatMode", "<init>", "(Landroid/os/Bundle;Lcom/tencent/ecommerce/biz/detail/ui/ReportCallback;Lcom/tencent/ecommerce/biz/detail/ui/GetCurrentFloatMode;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReportCallback reportCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final GetCurrentFloatMode currentFloatMode;

    public c(Bundle bundle, ReportCallback reportCallback, GetCurrentFloatMode getCurrentFloatMode) {
        this.bundle = bundle;
        this.reportCallback = reportCallback;
        this.currentFloatMode = getCurrentFloatMode;
    }

    public final void a(String url) {
        String str;
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Map<String, String> l3 = yi0.a.f450402c.l(Uri.parse(url));
        Map<Object, Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(this.bundle, "ext_userdata").getExtUserDataMap();
        if (extUserDataMap != null) {
            HashMap hashMap = (HashMap) extUserDataMap;
            if (this.currentFloatMode.isFloatMode()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("half", str);
            String str2 = l3.get("target");
            if (str2 == null) {
                str2 = 0;
            }
            if (Intrinsics.areEqual(str2, String.valueOf(33))) {
                url = url + "&is_trans_activity=1";
            }
            if (Intrinsics.areEqual(str2.toString(), String.valueOf(22)) && this.currentFloatMode.isFloatMode()) {
                url = url + "&is_trans_activity=1";
            }
            String string = this.bundle.getString("qz_gdt", "");
            if (string.length() > 0) {
                url = url + "&qz_gdt=" + string;
            }
            ECScheme.e(url, hashMap);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>");
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
        String str;
        if (dataMap == null || (str = dataMap.get("eventType")) == null) {
            return;
        }
        cg0.a.b("ECPTSLiteAllInOneJump", "[onTapEventTriggered] " + str);
        if (Intrinsics.areEqual(str, "allInOneJump")) {
            String str2 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
            if (str2 == null) {
                str2 = "";
            }
            cg0.a.b("ECPTSLiteAllInOneJump", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str2);
            a(str2);
        }
        this.reportCallback.doReport(identifier);
    }
}
