package com.tencent.qqnt.aio.adapter.ark;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.a;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u000f\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/ark/ArkAppQQModule;", "Lcom/tencent/mobileqq/ark/module/b;", "", "GetTypeName", "szFunc", "", "HasMethod", "o", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/ark/module/e;", "e", "()[Lcom/tencent/mobileqq/ark/module/e;", "Lcom/tencent/ark/ark$VariantWrapper;", "args", "ret", "Invoke", "(Ljava/lang/String;[Lcom/tencent/ark/ark$VariantWrapper;Lcom/tencent/ark/ark$VariantWrapper;)Z", "Lcom/tencent/ark/ark$Application;", "app", "", "appType", "<init>", "(Lcom/tencent/ark/ark$Application;I)V", "l", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ArkAppQQModule extends b {
    public ArkAppQQModule(@Nullable ark.Application application, int i3) {
        super(application, i3);
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    @NotNull
    public String GetTypeName() {
        return "QQ";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(@NotNull String szFunc) {
        Intrinsics.checkNotNullParameter(szFunc, "szFunc");
        if (Intrinsics.areEqual(szFunc, QZoneJsConstants.METHOD_OPEN_URL)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:14|(2:16|(1:18)(10:19|20|21|22|(6:24|25|26|(4:28|(1:30)|32|(2:34|35)(3:36|(6:39|40|(7:44|(1:46)(2:56|(1:58)(1:59))|47|(1:55)(4:49|(1:51)|52|53)|54|41|42)|60|61|(3:63|(1:65)(1:68)|66))|38))|70|71)|73|26|(0)|70|71))|75|20|21|22|(0)|73|26|(0)|70|71) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        if (r7 != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[Catch: JSONException -> 0x0070, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0070, blocks: (B:22:0x0060, B:24:0x0063), top: B:21:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Invoke(@NotNull String szFunc, @NotNull ark.VariantWrapper[] args, @NotNull ark.VariantWrapper ret) {
        String str;
        JSONObject jSONObject;
        boolean startsWith$default;
        int indexOf$default;
        String str2;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(szFunc, "szFunc");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(ret, "ret");
        if (super.Invoke(szFunc, args, ret)) {
            return true;
        }
        if (!c(szFunc) || !Intrinsics.areEqual(szFunc, QZoneJsConstants.METHOD_OPEN_URL)) {
            return false;
        }
        ret.SetBool(false);
        if (args.length >= 1) {
            String url = args[0].GetString();
            if (!TextUtils.isEmpty(url)) {
                if (args.length > 1) {
                    if (args[1].IsView()) {
                        args[1].GetView();
                    } else {
                        str = args[1].GetTableAsJsonString();
                        if (args.length > 2) {
                            jSONObject = new JSONObject(args[2].GetTableAsJsonString());
                            if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(url, str, jSONObject, this.f199565a, this.f199566b, null)) {
                                Intrinsics.checkNotNullExpressionValue(url, "url");
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
                                if (!startsWith$default) {
                                    Intrinsics.checkNotNullExpressionValue(url, "url");
                                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                                }
                                if (!a.a(this.f199566b, this.f199565a, this.f199570f, "permission.BROWSER")) {
                                    QLog.d("ArkApp.ArkAppModuleBase", 1, "ArkSafe.OpenUrl ModuleCheckPermission invalid!");
                                    return false;
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(str);
                                        Iterator keys = jSONObject2.keys();
                                        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
                                        String str3 = new String();
                                        boolean z16 = false;
                                        while (keys.hasNext()) {
                                            Object next = keys.next();
                                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                                            String str4 = (String) next;
                                            if (jSONObject2.get(str4) instanceof String) {
                                                str2 = jSONObject2.getString(str4);
                                            } else if (jSONObject2.get(str4) instanceof Number) {
                                                Object obj = jSONObject2.get(str4);
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Number");
                                                str2 = ((Number) obj).toString();
                                            } else {
                                                str2 = null;
                                            }
                                            if (!TextUtils.isEmpty(str2)) {
                                                if (z16) {
                                                    str3 = str3 + ContainerUtils.FIELD_DELIMITER;
                                                }
                                                str3 = str3 + str4 + ContainerUtils.KEY_VALUE_DELIMITER + str2;
                                                z16 = true;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str3)) {
                                            Intrinsics.checkNotNullExpressionValue(url, "url");
                                            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 4, (Object) null);
                                            if (indexOf$default != -1) {
                                                str3 = ContainerUtils.FIELD_DELIMITER + str3;
                                            }
                                            url = url + str3;
                                        }
                                    } catch (JSONException unused) {
                                    }
                                }
                                Intent intent = new Intent();
                                intent.putExtra("url", url);
                                ActivityURIRequest activityURIRequest = new ActivityURIRequest(BaseApplication.getContext(), RouterConstants.UI_ROUTE_BROWSER);
                                activityURIRequest.extra().putAll(intent.getExtras());
                                QRoute.startUri(activityURIRequest, (o) null);
                            }
                            QLog.d("ArkApp.ArkAppModuleBase", 1, "ark.OpenUrl ", url);
                            return true;
                        }
                        jSONObject = null;
                        if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(url, str, jSONObject, this.f199565a, this.f199566b, null)) {
                        }
                        QLog.d("ArkApp.ArkAppModuleBase", 1, "ark.OpenUrl ", url);
                        return true;
                    }
                }
                str = null;
                if (args.length > 2) {
                }
                jSONObject = null;
                if (!((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(url, str, jSONObject, this.f199565a, this.f199566b, null)) {
                }
                QLog.d("ArkApp.ArkAppModuleBase", 1, "ark.OpenUrl ", url);
                return true;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    @Nullable
    protected e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return true;
    }
}
