package com.tencent.mobileqq.search.searchdetail;

import android.util.Base64;
import android.view.View;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.mobileqq.search.util.ap;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchDeviceInfo;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tJ0\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002J\\\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\rJ&\u0010\u001e\u001a\u00020\u001d*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001bJ\u001e\u0010 \u001a\u00020\u001d*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\rJ\b\u0010$\u001a\u0004\u0018\u00010#J\u0006\u0010&\u001a\u00020%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/r;", "", "", IProfileCardConst.KEY_FROM_TYPE, ForwardRecentActivity.KEY_SEARCH_SOURCE, "", DomainData.DOMAIN_NAME, "b", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchDeviceInfo;", "i", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "", "currentTraceId", "traceIdForFirstScreenData", "pageMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "searchId", "parentSearchId", "pageNum", "sessionId", "needWXFunToken", "j", "l", "Landroid/view/View;", "elementId", "", "elementParams", "", "d", "Lorg/json/JSONObject;", "e", "f", tl.h.F, "Lmqq/app/AppRuntime;", "g", "Lcom/tencent/common/app/AppInterface;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f284572a = new r();

    r() {
    }

    public static /* synthetic */ String k(r rVar, int i3, int i16, String str, String str2, String str3, String str4, int i17, int i18, String str5, boolean z16, int i19, Object obj) {
        String str6;
        String str7;
        boolean z17;
        if ((i19 & 8) != 0) {
            str6 = "";
        } else {
            str6 = str2;
        }
        if ((i19 & 256) != 0) {
            str7 = "";
        } else {
            str7 = str5;
        }
        if ((i19 & 512) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        return rVar.j(i3, i16, str, str6, str3, str4, i17, i18, str7, z17);
    }

    @JvmStatic
    public static final boolean n(int fromType, int searchSource) {
        int checkRadix;
        if ((searchSource & 8192) != 0) {
            checkRadix = CharsKt__CharJVMKt.checkRadix(2);
            String num = Integer.toString(searchSource, checkRadix);
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            QLog.w("UnifySearchUtils", 1, "interruptNTContactsFilter fromType = [" + fromType + "], searchSource = [" + num + "]");
            return true;
        }
        return false;
    }

    @NotNull
    public final AppInterface a() {
        AppRuntime g16 = g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) g16;
    }

    public final boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102700", false);
    }

    public final boolean c() {
        return true;
    }

    public final void d(@NotNull View view, @NotNull String elementId, @NotNull Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(elementParams, "elementParams");
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementParams(view, elementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public final void e(@NotNull View view, @NotNull String elementId, @Nullable JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                VideoReport.setElementParam(view, str, jSONObject.get(str));
            }
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @NotNull
    public final String f() {
        return h() + "_" + System.currentTimeMillis() + "_" + ap.f285014a.a();
    }

    @Nullable
    public final AppRuntime g() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @NotNull
    public final String h() {
        String account;
        AppRuntime g16 = g();
        if (g16 == null || (account = g16.getAccount()) == null) {
            return "0";
        }
        return account;
    }

    @NotNull
    public final SearchDeviceInfo i() {
        SearchDeviceInfo searchDeviceInfo = new SearchDeviceInfo();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        searchDeviceInfo.platform = 2;
        searchDeviceInfo.studyModeStatus = studyModeSwitch;
        searchDeviceInfo.nightModeStatus = isNowThemeIsNight;
        return searchDeviceInfo;
    }

    @NotNull
    public final String j(int querySource, int userSource, @NotNull String currentTraceId, @NotNull String traceIdForFirstScreenData, @NotNull String searchId, @NotNull String parentSearchId, int pageNum, int pageMode, @NotNull String sessionId, boolean needWXFunToken) {
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo;
        Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
        Intrinsics.checkNotNullParameter(traceIdForFirstScreenData, "traceIdForFirstScreenData");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        String h16 = ah.f284994a.h("lastSelectedAIModel", "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("traceId", currentTraceId);
        jSONObject.put("firstTraceId", traceIdForFirstScreenData);
        jSONObject.put(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, querySource);
        jSONObject.put("userSource", userSource);
        jSONObject.put("pageMode", pageMode);
        jSONObject.put("modelRealName", h16);
        jSONObject.put("noNeedAICard", ap2.a.f26672a.b());
        jSONObject.put("begid", pageNum);
        jSONObject.put("deviceType", "android");
        jSONObject.put(Constants.SP_DEVICE_ID, 2);
        jSONObject.put("netType", f284572a.l());
        jSONObject.put("sessionId", sessionId);
        jSONObject.put("searchId", searchId);
        jSONObject.put("parentSearchId", parentSearchId);
        if (needWXFunToken && (bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo()) != null) {
            jSONObject.put("wxFuncToken", bindingWeChatUserInfo.h());
        }
        af afVar = af.f284993a;
        QLog.i("QS.UnifySearchUtils", 1, "req extension data " + jSONObject, null);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(jsonObjec\u2026eArray(), Base64.NO_WRAP)");
        return encodeToString;
    }

    @NotNull
    public final String l() {
        int netWorkType = NetworkUtil.getNetWorkType();
        if (netWorkType != 1) {
            if (netWorkType != 2) {
                if (netWorkType != 3) {
                    if (netWorkType != 4) {
                        if (netWorkType != 6) {
                            return "none";
                        }
                        return "5G";
                    }
                    return "4G";
                }
                return "3G";
            }
            return "2G";
        }
        return "wifi";
    }

    @NotNull
    public final String m(int querySource, int userSource, @NotNull String currentTraceId, @NotNull String traceIdForFirstScreenData, int pageMode) {
        Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
        Intrinsics.checkNotNullParameter(traceIdForFirstScreenData, "traceIdForFirstScreenData");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("traceId", currentTraceId);
        jSONObject.put("firstTraceId", traceIdForFirstScreenData);
        jSONObject.put(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, querySource);
        jSONObject.put("userSource", userSource);
        jSONObject.put("pageMode", pageMode);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }
}
