package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForMultiProcess;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.UpdateType;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyPageAsyncLoader;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.intercept.QQKuiklyWebNavigationItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\bH\u0002J4\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00190\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\"\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\"\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020&H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u001a\u0010)\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016Rx\u0010,\u001af\u0012\u0004\u0012\u00020\u0004\u0012(\u0012&\u0012\u0004\u0012\u00020\u0004\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00190\u00190\u00180*j2\u0012\u0004\u0012\u00020\u0004\u0012(\u0012&\u0012\u0004\u0012\u00020\u0004\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00190\u00190\u0018`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyRouterImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyRouter;", "Landroid/content/Context;", "context", "", "schemeUrl", "", "launchKuiklyPage", "Landroid/os/Bundle;", "bundle", "checkIfNeedForceUpdate", "Landroid/content/Intent;", "intent", "args", "launchKuiklyOnSplitMode", "Lcom/tencent/mobileqq/pad/LaunchMode;", "getLaunchModeOnSplitMode", "getFragmentIdOnSplitMode", "url", "", "innerJumpKuiklyPageWithWebUrl", "interceptForQQMCConfig", "localHasRes", "configName", "Lkotlin/Pair;", "", "loadQQMCConfig", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "getStartActivityClass", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, MiniChatConstants.MINI_APP_LANDSCAPE, "getMainProcessStartActivityClass", "getToolProcessStartActivityClass", "getMultiProcessStartActivityClass", "jump", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/KuiklyLaunchParams;", "params", "Lorg/json/JSONObject;", "updateLaunchArgs", "webUrl", "jumpKuiklyPageWithWebUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "qqmcConfigs", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "preloadCenterToggle", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyRouterImpl implements IQQKuiklyRouter {
    private static final String H5_KUIKLY_SCHEMA_KEY = "kuikly_schema";
    public static final String TAG = "QQKuiklyRouter";
    private final HashMap<String, Pair<String, Map<String, Map<String, String>>>> qqmcConfigs = new HashMap<>();
    private final UnitedProxy preloadCenterToggle = ar.INSTANCE.a("shouyouye", "2024-03-28", "vas_kuikly_preload_center");

    private final void checkIfNeedForceUpdate(Bundle bundle) {
        String string = bundle.getString("max_age");
        if (string != null) {
            IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
            String string2 = bundle.getString("bundle_name");
            if (string2 == null) {
                string2 = "";
            }
            Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(KuiklyL\u2026s.PARAM_BUNDLE_NAME)?: \"\"");
            long lastRequestServerTime = iQQKuiklyDexResApi.getLastRequestServerTime(string2);
            if (QLog.isDebugVersion()) {
                QLog.i(TAG, 1, "[launchKuiklyPage] timeStamp: " + lastRequestServerTime + ", max_age: " + string);
            }
            if (lastRequestServerTime <= 0 || System.currentTimeMillis() - lastRequestServerTime <= Long.parseLong(string) * 1000) {
                return;
            }
            bundle.putInt("update_type", UpdateType.TYPE_USE_REMOTE_FORCE.getType());
        }
    }

    private final String getFragmentIdOnSplitMode(Bundle args) {
        String str = "kuikly" + util.base64_pad_url + args.getString("bundle_name", "") + util.base64_pad_url + args.getString("page_name", "");
        Intrinsics.checkNotNullExpressionValue(str, "sBuilder.toString()");
        return str;
    }

    private final LaunchMode getLaunchModeOnSplitMode(Bundle args) {
        String string = args.getString(KuiklyLaunchParams.PARAM_LAUNCH_MODE_ON_SPLIT_MODE, KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD);
        if (Intrinsics.areEqual(string, "single_top")) {
            return LaunchMode.singleTop;
        }
        if (Intrinsics.areEqual(string, KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_SINGLE_TASK)) {
            return LaunchMode.singleTask;
        }
        return LaunchMode.standard;
    }

    private final Class<? extends QPublicFragmentActivity> getStartActivityClass(Bundle bundle) {
        Object obj = bundle.get("process_name");
        KuiklyLaunchParams.Companion companion = KuiklyLaunchParams.INSTANCE;
        boolean l3 = companion.l(bundle);
        boolean k3 = companion.k(bundle);
        if (Intrinsics.areEqual("main", obj)) {
            return getMainProcessStartActivityClass(l3, k3);
        }
        if (Intrinsics.areEqual("tool", obj)) {
            return getToolProcessStartActivityClass(l3, k3);
        }
        if (Intrinsics.areEqual("local", obj)) {
            return getMultiProcessStartActivityClass(l3, k3);
        }
        return getMainProcessStartActivityClass(l3, k3);
    }

    private final boolean innerJumpKuiklyPageWithWebUrl(Context context, String url) {
        boolean contains$default;
        boolean startsWith$default;
        try {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) H5_KUIKLY_SCHEMA_KEY, false, 2, (Object) null);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "jumpKuiklyPageWithWebUrl error: " + th5);
        }
        if (!contains$default) {
            return false;
        }
        String queryParameter = Uri.parse(url).getQueryParameter(H5_KUIKLY_SCHEMA_KEY);
        String str = "";
        if (queryParameter == null) {
            queryParameter = "";
        }
        if (queryParameter.length() > 0) {
            byte[] decode = Base64.decode(queryParameter, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(kuiklySchema, Base64.DEFAULT)");
            String str2 = new String(decode, Charsets.UTF_8);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "mqqapi://", false, 2, null);
            if (startsWith$default) {
                String queryParameter2 = Uri.parse(str2).getQueryParameter(KuiklyLaunchParams.PARAM_MIN_QQ_VERSION);
                if (queryParameter2 != null) {
                    str = queryParameter2;
                }
                if ((str.length() > 0) && !QQKuiklyRenderView.INSTANCE.f(str)) {
                    return false;
                }
                QLog.i(TAG, 1, "jump kuikly from h5: " + url + ", " + str2);
                ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(context, str2);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void interceptForQQMCConfig(Bundle args) {
        boolean z16;
        JSONObject optJSONObject;
        String optString;
        boolean contains$default;
        boolean startsWith$default;
        String configName = args.getString(KuiklyLaunchParams.PARAM_QQMC_CONFIG, "");
        Intrinsics.checkNotNullExpressionValue(configName, "configName");
        if (configName.length() > 0) {
            Pair<String, Map<String, Map<String, String>>> pair = this.qqmcConfigs.get(configName);
            if (pair == null) {
                pair = loadQQMCConfig(configName);
                if (QLog.isDebugVersion()) {
                    QLog.i(TAG, 1, "business config : " + pair);
                }
                this.qqmcConfigs.put(configName, pair);
            }
            String string = args.getString("page_name", "");
            Map<String, String> map = pair.getSecond().get(string);
            if (map != null) {
                Set<String> keySet = map.keySet();
                ArrayList<String> arrayList = new ArrayList();
                for (Object obj : keySet) {
                    String string2 = args.getString((String) obj, "");
                    Intrinsics.checkNotNullExpressionValue(string2, "args.getString(it, \"\")");
                    if (string2.length() == 0) {
                        arrayList.add(obj);
                    }
                }
                for (String str : arrayList) {
                    String str2 = map.get(str);
                    args.putString(str, str2);
                    QLog.i(TAG, 1, "launchKuiklyPage add args: " + str + " " + str2);
                }
            }
            String string3 = args.getString("bundle_name");
            if (string3 != null) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String lowerCase = string3.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase != null) {
                    if (!TextUtils.isEmpty(lowerCase)) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, PreDownloadConstants.DEPARTMENT_VAS, false, 2, null);
                        if (startsWith$default) {
                            z16 = true;
                            if (!z16) {
                                lowerCase = null;
                            }
                            if (lowerCase != null && (optJSONObject = this.preloadCenterToggle.getJson().optJSONObject("vas_center")) != null && (optString = optJSONObject.optString("auto_update_record")) != null) {
                                if (!(true ^ TextUtils.isEmpty(optString))) {
                                    optString = null;
                                }
                                if (optString != null) {
                                    VasMMKV.Companion companion = VasMMKV.INSTANCE;
                                    String decodeString = companion.getCommon().decodeString(optString, "");
                                    if (decodeString == null) {
                                        decodeString = "";
                                    }
                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) decodeString, (CharSequence) lowerCase, false, 2, (Object) null);
                                    if (!contains$default) {
                                        companion.getCommon().encodeString(optString, decodeString + "," + lowerCase);
                                    }
                                }
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                    if (lowerCase != null) {
                        if (!(true ^ TextUtils.isEmpty(optString))) {
                        }
                        if (optString != null) {
                        }
                    }
                }
            }
            VasCommonReporter.getKuiklyOpen().setValue1(string).setValue2(pair.getFirst()).setValue3(args.getString("from", "")).setNum1(0L).setNum3(localHasRes(args) ? 1L : 0L).report(false);
        }
    }

    private final void launchKuiklyOnSplitMode(Context context, Intent intent, Bundle args) {
        com.tencent.mobileqq.pad.b d16 = new com.tencent.mobileqq.pad.b().e(false).g(args.getBoolean("is_need_clear_other_fragment", false)).h(getLaunchModeOnSplitMode(args)).f(args.getBoolean("is_cover_split_page", false)).d(getFragmentIdOnSplitMode(args));
        args.putBoolean("is_load_on_split_mode", true);
        intent.putExtra("launchKuiklyParams", args);
        i.e(context, intent.getExtras(), QQKuiklyFragment.class, d16.a());
        QLog.i(TAG, 1, "[launchKuiklyPage] on split mode");
    }

    private final Pair<String, Map<String, Map<String, String>>> loadQQMCConfig(String configName) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = "0";
        try {
            JSONObject json = new UnitedProxy(configName).getJson();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "load business config : " + json);
            }
            str = json.optString("version", "0");
            Intrinsics.checkNotNullExpressionValue(str, "json.optString(\"version\", version)");
            try {
                JSONArray optJSONArray = json.optJSONArray(DownloadInfo.spKey_Config);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        String pageName = jSONObject.optString("page");
                        Intrinsics.checkNotNullExpressionValue(pageName, "pageName");
                        if (!(pageName.length() == 0)) {
                            HashMap hashMap2 = new HashMap();
                            JSONObject optJSONObject = jSONObject.optJSONObject("params");
                            if (optJSONObject != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"params\")");
                                Iterator keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    Object next = keys.next();
                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                                    String str3 = (String) next;
                                    String optString = optJSONObject.optString(str3);
                                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(key)");
                                    hashMap2.put(str3, optString);
                                }
                            }
                            hashMap.put(pageName, hashMap2);
                        }
                    }
                }
            } catch (Exception e16) {
                e = e16;
                str2 = str;
                QLog.e(TAG, 1, e, new Object[0]);
                str = str2;
                return TuplesKt.to(str, hashMap);
            }
        } catch (Exception e17) {
            e = e17;
        }
        return TuplesKt.to(str, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    private final boolean localHasRes(Bundle args) {
        String bundleName = args.getString("bundle_name", "");
        ?? r26 = 0;
        r26 = 0;
        if (!TextUtils.isEmpty(bundleName)) {
            IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
            Intrinsics.checkNotNullExpressionValue(bundleName, "bundleName");
            if (iQQKuiklyDexResApi.getDexResInfo(bundleName).getResVersion() > 0) {
                r26 = 1;
            }
        }
        args.putInt("has_local_res", r26);
        return r26;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter
    public void jump(Context context, String schemeUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        launchKuiklyPage(context, schemeUrl);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter
    public boolean jumpKuiklyPageWithWebUrl(Context context, String webUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (webUrl == null) {
            return false;
        }
        if (innerJumpKuiklyPageWithWebUrl(context, webUrl)) {
            return true;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (QQKuiklyWebNavigationItem.INSTANCE.a(activity, webUrl) || ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).interceptHttpUrl(activity, webUrl)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter
    public void launchKuiklyPage(Context context, KuiklyLaunchParams params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        launchKuiklyPage(context, params.toBundle());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter
    public void updateLaunchArgs(Bundle args) {
        Intrinsics.checkNotNullParameter(args, "args");
        interceptForQQMCConfig(args);
        args.putLong(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS, System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter
    public void launchKuiklyPage(Context context, JSONObject args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, "args");
        launchKuiklyPage(context, nf2.a.b(nf2.a.a(args)));
    }

    private final void launchKuiklyPage(Context context, String schemeUrl) {
        launchKuiklyPage(context, nf2.a.b(tf2.a.c(schemeUrl)));
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter
    public void launchKuiklyPage(Context context, Bundle args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, "args");
        checkIfNeedForceUpdate(args);
        updateLaunchArgs(args);
        if (QQKuiklyPageAsyncLoader.INSTANCE.e(context, args)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("launchKuiklyParams", args);
        KuiklyLaunchParams.Companion companion = KuiklyLaunchParams.INSTANCE;
        if (!companion.l(args) && companion.g(args)) {
            intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
            Integer a16 = companion.a(args);
            int i3 = R.anim.f154445lb;
            if ((a16 == null || a16.intValue() != 0) && a16 != null && a16.intValue() == 1) {
                i3 = R.anim.activity_new;
            }
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, i3);
            int i16 = R.anim.f154449lf;
            if ((a16 == null || a16.intValue() != 0) && a16 != null && a16.intValue() == 1) {
                i16 = R.anim.activity_out;
            }
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, i16);
            int i17 = R.anim.f154435l2;
            if ((a16 == null || a16.intValue() != 0) && a16 != null && a16.intValue() == 1) {
                i17 = R.anim.activity_back;
            }
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, i17);
            int i18 = R.anim.f154436l4;
            if ((a16 == null || a16.intValue() != 0) && a16 != null && a16.intValue() == 1) {
                i18 = R.anim.activity_finish;
            }
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, i18);
        } else {
            intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, 0);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, 0);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
        }
        if (companion.j(args)) {
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
        }
        Class<? extends QPublicFragmentActivity> startActivityClass = getStartActivityClass(args);
        intent.putExtra("public_fragment_window_feature", 1);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (Intrinsics.areEqual("1", args.getString("single"))) {
            intent.addFlags(335544320);
        }
        if (AppSetting.t(context) && args.getBoolean("is_support_split_mode", false)) {
            launchKuiklyOnSplitMode(context, intent, args);
            return;
        }
        Integer b16 = companion.b(args);
        if (b16 != null) {
            QPublicFragmentActivity.b.f(context, intent, startActivityClass, QQKuiklyFragment.class, b16.intValue());
        } else {
            QPublicFragmentActivity.b.b(context, intent, startActivityClass, QQKuiklyFragment.class);
        }
    }

    private final Class<? extends QPublicFragmentActivity> getMainProcessStartActivityClass(boolean isTransparent, boolean isLandscape) {
        if (isTransparent) {
            if (isLandscape) {
                return QPublicTransFragmentActivityLandscape.class;
            }
            return QPublicTransFragmentActivity.class;
        }
        if (isLandscape) {
            return QPublicFragmentActivityLandscape.class;
        }
        return QPublicFragmentActivity.class;
    }

    private final Class<? extends QPublicFragmentActivity> getMultiProcessStartActivityClass(boolean isTransparent, boolean isLandscape) {
        if (isTransparent) {
            if (isLandscape) {
                return QPublicTransFragmentActivityLandscapeForMultiProcess.class;
            }
            return QPublicTransFragmentActivityForMultiProcess.class;
        }
        if (isLandscape) {
            return QPublicFragmentActivityLandscapeForMultiProcess.class;
        }
        return QPublicFragmentActivityForMultiProcess.class;
    }

    private final Class<? extends QPublicFragmentActivity> getToolProcessStartActivityClass(boolean isTransparent, boolean isLandscape) {
        if (isTransparent) {
            if (isLandscape) {
                return QPublicTransFragmentActivityLandscapeForTool.class;
            }
            return QPublicTransFragmentActivityForTool.class;
        }
        if (isLandscape) {
            return QPublicFragmentActivityLandscapeForTool.class;
        }
        return QPublicFragmentActivityForTool.class;
    }
}
