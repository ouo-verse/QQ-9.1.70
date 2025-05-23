package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J3\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000fJ3\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000fJ.\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0016J.\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u001a\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasHybridRouteImpl;", "Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "", "isEnable", "Landroid/content/Context;", "context", "", "url", "", "openSchema", "openBrowser", "Landroid/os/Bundle;", "extra", "", "requestCode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Landroid/os/Bundle;)V", "openTranslucentBrowser", "pageName", "", "params", "openKuikly", QZoneDTLoginReporter.SCHEMA, "openKuiklySchema", "interceptUrl", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasHybridRouteImpl implements IVasHybridRoute {

    @NotNull
    private static final String TAG = "VasHybridRouteImpl";
    private static final boolean interceptReport;
    private static final boolean isKuiklyCardShopEnable;
    private static final boolean isUseEqualForMatch;

    @NotNull
    private static final UnitedProxy kuiklyCardShopConfig;

    static {
        ar.Companion companion = com.tencent.mobileqq.vas.ar.INSTANCE;
        UnitedProxy a16 = companion.a("shouyouye", "2024-03-14", "vas_profile_card_kuikly_config");
        kuiklyCardShopConfig = a16;
        isKuiklyCardShopEnable = a16.isEnable(false);
        interceptReport = companion.b("shouyouye", "2024-04-19", "vas_card_test_report").isEnable(true);
        isUseEqualForMatch = companion.b("shouyouye", "2024-04-22", "vas_use_equal_for_match").isEnable(true);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        String name = VasHybridRouteImpl.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.javaClass.name");
        return name;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x011c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011d  */
    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean interceptUrl(@NotNull Context context, @NotNull String params) {
        boolean startsWith$default;
        String url;
        boolean z16;
        String str;
        int indexOf$default;
        long j3;
        List split$default;
        JSONArray jSONArray;
        String str2;
        boolean startsWith$default2;
        List split$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "interceptUrl " + params);
        boolean z17 = isKuiklyCardShopEnable;
        QLog.i(TAG, 1, "interceptUrl enable: " + z17);
        if (z17) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(params, "http", false, 2, null);
            String str3 = "";
            if (startsWith$default) {
                url = params;
            } else {
                try {
                    url = new JSONObject(params).optString("url");
                } catch (JSONException e16) {
                    QLog.i(TAG, 1, "exception happend , param: " + params, e16);
                    url = "";
                }
            }
            if (TextUtils.isEmpty(url)) {
                return false;
            }
            JSONObject json = kuiklyCardShopConfig.getJson();
            JSONArray optJSONArray = json.optJSONArray("url_list");
            if (optJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(url, "url");
                JSONArray jSONArray2 = optJSONArray;
                split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
                if (!split$default.isEmpty()) {
                    int length = jSONArray2.length();
                    int i3 = 0;
                    while (i3 < length) {
                        String str4 = (String) split$default.get(0);
                        if (isUseEqualForMatch) {
                            jSONArray = jSONArray2;
                            startsWith$default2 = Intrinsics.areEqual(str4, jSONArray.optString(i3));
                            str2 = str3;
                        } else {
                            jSONArray = jSONArray2;
                            String optString = jSONArray.optString(i3);
                            str2 = str3;
                            Intrinsics.checkNotNullExpressionValue(optString, "cardUrlList.optString(i)");
                            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str4, optString, false, 2, null);
                        }
                        if (startsWith$default2) {
                            split$default2 = StringsKt__StringsKt.split$default((CharSequence) str4, new String[]{"#"}, false, 0, 6, (Object) null);
                            if (split$default2.size() == 2) {
                                str = (String) split$default2.get(1);
                            } else {
                                str = str2;
                            }
                            z16 = true;
                            if (z16) {
                                return false;
                            }
                            String realUrl = json.optString("kuikly_url");
                            if (TextUtils.isEmpty(realUrl)) {
                                return false;
                            }
                            Intrinsics.checkNotNullExpressionValue(url, "url");
                            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
                            if (indexOf$default >= 0) {
                                String substring = url.substring(indexOf$default + 1, url.length());
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                realUrl = realUrl + ContainerUtils.FIELD_DELIMITER + substring;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                realUrl = realUrl + "&auto_jump=" + str;
                            }
                            QLog.i(TAG, 1, "realUrl: " + realUrl);
                            if (json.optInt(FileReaderHelper.OPEN_FILE_FROM_FORCE) == 1) {
                                Intrinsics.checkNotNullExpressionValue(realUrl, "realUrl");
                                openKuiklySchema(context, realUrl, null);
                                QLog.i(TAG, 1, "\u540d\u7247\u5546\u573a\u8df3\u8f6c\u88ab\u62e6\u622a \u5f3a\u8df3");
                                return true;
                            }
                            String abTestName = json.optString("abtest_name");
                            Intrinsics.checkNotNullExpressionValue(abTestName, "abTestName");
                            Pair<ABTest, Map<String, String>> a16 = new com.tencent.mobileqq.vas.ab.b(abTestName).a();
                            if (interceptReport) {
                                ReportInfo hotFeature = VasCommonReporter.getHotFeature("card_test_report");
                                if (a16.getFirst() == ABTest.A) {
                                    j3 = 1;
                                } else if (a16.getFirst() == ABTest.B) {
                                    j3 = 2;
                                } else {
                                    j3 = 0;
                                }
                                ReportInfo.report$default(hotFeature.setNum1(j3).setValue1(realUrl), false, 1, null);
                            }
                            if (a16.getFirst() == ABTest.B) {
                                Intrinsics.checkNotNullExpressionValue(realUrl, "realUrl");
                                openKuiklySchema(context, realUrl, null);
                                QLog.i(TAG, 1, "\u540d\u7247\u5546\u573a\u8df3\u8f6c\u88ab\u62e6\u622a \u547d\u4e2d\u5b9e\u9a8c: " + abTestName);
                                return true;
                            }
                            QLog.i(TAG, 1, "\u540d\u7247\u5546\u573a\u8df3\u8f6c\u672a\u62e6\u622a \u672a\u547d\u4e2d\u5b9e\u9a8c: " + abTestName + " \u4e14\u975e\u5f3a\u8df3");
                        } else {
                            i3++;
                            jSONArray2 = jSONArray;
                            str3 = str2;
                        }
                    }
                }
            }
            z16 = false;
            str = str3;
            if (z16) {
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public boolean isEnable() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openBrowser(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        openBrowser(context, url, null, null);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openKuikly(@NotNull Context context, @NotNull String pageName, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        openKuiklySchema(context, "mqqapi://kuikly/open?page_name=" + pageName, params);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openKuiklySchema(@NotNull Context context, @NotNull String schema, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        StringBuilder sb5 = new StringBuilder(schema);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb5.append(ContainerUtils.FIELD_DELIMITER + ((Object) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) entry.getValue()));
            }
        }
        sb5.append("&clicktime=" + System.currentTimeMillis());
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "schemeUrl.toString()");
        QLog.i(TAG, 1, "openKuiklySchema " + sb6);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(context, sb6);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openSchema(@Nullable Context context, @NotNull String url) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (startsWith$default) {
            if (context == null) {
                context = MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext();
            }
            Intrinsics.checkNotNullExpressionValue(context, "context ?: MobileQQ.sMob\u2026time().applicationContext");
            openBrowser(context, url);
            return;
        }
        QLog.i(TAG, 1, "open " + url);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        ax c16 = bi.c((BaseQQAppInterface) peekAppRuntime2, peekAppRuntime.getApplicationContext(), url);
        if (c16 != null) {
            c16.b();
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openTranslucentBrowser(@NotNull Context context, @NotNull String url, @Nullable Integer requestCode, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i(TAG, 1, "open " + url);
        if (interceptUrl(context, url)) {
            return;
        }
        Navigator withBoolean = QRoute.createNavigator(context, RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER).withString("url", url).withLong("startOpenPageTime", System.currentTimeMillis()).withString("big_brother_source_key", "biz_src_jc_vip").withBoolean("isShowAd", false);
        if (extra != null) {
            withBoolean.withAll(extra);
        }
        if (requestCode != null && (context instanceof Activity)) {
            Navigator.withRequestCode$default(withBoolean, (Activity) context, requestCode.intValue(), (Bundle) null, 4, (Object) null);
        }
        withBoolean.request();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openBrowser(@NotNull Context context, @NotNull String url, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(extra, "extra");
        openBrowser(context, url, null, extra);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasHybridRoute
    public void openBrowser(@NotNull Context context, @NotNull String url, @Nullable Integer requestCode, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i(TAG, 1, "open " + url);
        if (interceptUrl(context, url)) {
            return;
        }
        Navigator withBoolean = QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withString("url", url).withLong("startOpenPageTime", System.currentTimeMillis()).withString("big_brother_source_key", "biz_src_jc_vip").withBoolean("isShowAd", false);
        if (extra != null) {
            withBoolean.withAll(extra);
        }
        if (requestCode != null && (context instanceof Activity)) {
            Navigator.withRequestCode$default(withBoolean, (Activity) context, requestCode.intValue(), (Bundle) null, 4, (Object) null);
        }
        withBoolean.request();
    }
}
