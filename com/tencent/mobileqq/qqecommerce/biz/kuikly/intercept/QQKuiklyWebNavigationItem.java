package com.tencent.mobileqq.qqecommerce.biz.kuikly.intercept;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.swift.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import nf2.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/intercept/QQKuiklyWebNavigationItem;", "Lcom/tencent/mobileqq/webview/swift/d;", "Landroid/content/Intent;", "intent", "Landroid/app/Activity;", "hostActivity", "", "url", "", "navigateToAnotherActivity", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "needSwitchFragment", "<init>", "()V", "a", "Companion", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyWebNavigationItem implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/intercept/QQKuiklyWebNavigationItem$Companion;", "", "Landroid/content/Context;", "context", "", "url", "", "map", "", "b", "c", "Landroid/app/Activity;", "hostActivity", "a", "DOMAIN_WHITE_LIST_CONFIG_ID", "Ljava/lang/String;", "FORWARD_DOMAIN", "KEY_BUNDLE", "KEY_PAGE", "KEY_QVER", "KEY_SVER", "LINK_DOMAIN", "PARAM_DOMAINS", "PARAM_JUMP_URL", "PARAM_OPEN_KUIKLY_INFO", "PARAM_PLATFORM_ONLY", "PARAM_TYPE", "", "PLATFORM_ALL", "I", "PLATFORM_ANDROID", "TAG", "VALUE_KUIKLY", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(Context context, String url, Map<String, Object> map) {
            if (!TextUtils.isEmpty(url) && map != null && map.get("_kbundle") != null && map.get("_kpage") != null) {
                try {
                    String valueOf = String.valueOf(map.get("_kbundle"));
                    String valueOf2 = String.valueOf(map.get("_kpage"));
                    if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("bundle_name", valueOf);
                        hashMap.put("page_name", valueOf2);
                        if (map.containsKey("_ksver")) {
                            hashMap.put(KuiklyLaunchParams.PARAM_MIN_RES_VERSION, String.valueOf(map.get("_ksver")));
                        }
                        if (map.containsKey("_kqver")) {
                            hashMap.put(KuiklyLaunchParams.PARAM_MIN_QQ_VERSION, String.valueOf(map.get("_kpage")));
                        }
                        hashMap.put("url", url);
                        String c16 = c(url);
                        hashMap.put(KuiklyLaunchParams.PARAM_ERROR_URL, c16);
                        if (QLog.isColorLevel()) {
                            QLog.d("QQKuiklyWebNavigationItem", 2, "[openKuiklyPage] bundle: " + valueOf + ", page: " + valueOf2 + ", errUrl: " + c16);
                        }
                        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, a.b(hashMap));
                        return true;
                    }
                    return false;
                } catch (Exception e16) {
                    QLog.e("QQKuiklyWebNavigationItem", 1, "[openKuiklyPage] " + e16);
                }
            }
            return false;
        }

        private final String c(String url) {
            String replace$default;
            final Uri parse = Uri.parse(url);
            String str = parse.getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER + parse.getAuthority() + parse.getPath();
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
            ArrayList arrayList = new ArrayList();
            for (Object obj : queryParameterNames) {
                if (!Intrinsics.areEqual((String) obj, "_kbundle")) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (!Intrinsics.areEqual((String) obj2, "_kpage")) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : arrayList2) {
                if (!Intrinsics.areEqual((String) obj3, "_ksver")) {
                    arrayList3.add(obj3);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj4 : arrayList3) {
                if (!Intrinsics.areEqual((String) obj4, "_kqver")) {
                    arrayList4.add(obj4);
                }
            }
            String uri = new Uri.Builder().encodedPath(str).encodedQuery(arrayList4.isEmpty() ^ true ? CollectionsKt___CollectionsKt.joinToString$default(arrayList4, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.intercept.QQKuiklyWebNavigationItem$Companion$removeBundleAndPageParam$newQuery$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String str2) {
                    return str2 + ContainerUtils.KEY_VALUE_DELIMITER + parse.getQueryParameter(str2);
                }
            }, 30, null) : null).encodedFragment(parse.getFragment()).build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "Builder()\n              \u2026              .toString()");
            replace$default = StringsKt__StringsJVMKt.replace$default(uri, "?&", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 4, (Object) null);
            return replace$default;
        }

        Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x0197 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0199 A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:41:0x009e, B:44:0x00a7, B:47:0x00bb, B:49:0x00c1, B:51:0x00ca, B:56:0x00e0, B:58:0x00eb, B:62:0x00ff, B:65:0x0107, B:70:0x011d, B:75:0x0139, B:77:0x0147, B:81:0x014f, B:83:0x0156, B:90:0x016a, B:92:0x0175, B:96:0x017f, B:98:0x0185, B:100:0x018b, B:106:0x0199, B:110:0x01a9, B:111:0x01b1, B:113:0x01b7, B:116:0x01c7, B:119:0x01d3, B:125:0x01e1, B:85:0x0162), top: B:40:0x009e }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[Catch: all -> 0x01ef, TRY_LEAVE, TryCatch #1 {all -> 0x01ef, blocks: (B:3:0x001b, B:6:0x002a, B:8:0x0030, B:12:0x0037, B:14:0x0041, B:20:0x004e, B:23:0x005c, B:24:0x0060, B:26:0x0066, B:30:0x0079, B:33:0x0084, B:35:0x008d, B:37:0x0093), top: B:2:0x001b }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0105 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0107 A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:41:0x009e, B:44:0x00a7, B:47:0x00bb, B:49:0x00c1, B:51:0x00ca, B:56:0x00e0, B:58:0x00eb, B:62:0x00ff, B:65:0x0107, B:70:0x011d, B:75:0x0139, B:77:0x0147, B:81:0x014f, B:83:0x0156, B:90:0x016a, B:92:0x0175, B:96:0x017f, B:98:0x0185, B:100:0x018b, B:106:0x0199, B:110:0x01a9, B:111:0x01b1, B:113:0x01b7, B:116:0x01c7, B:119:0x01d3, B:125:0x01e1, B:85:0x0162), top: B:40:0x009e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(Activity hostActivity, String url) {
            boolean contains;
            boolean z16;
            JSONArray optJSONArray;
            boolean z17;
            boolean z18;
            int optInt;
            boolean startsWith$default;
            boolean contains2;
            boolean contains3;
            Intrinsics.checkNotNullParameter(hostActivity, "hostActivity");
            Intrinsics.checkNotNullParameter(url, "url");
            try {
                contains = StringsKt__StringsKt.contains((CharSequence) url, (CharSequence) "type=kuikly", false);
                if (!contains) {
                    contains2 = StringsKt__StringsKt.contains((CharSequence) url, (CharSequence) "open_kuikly_info", false);
                    if (!contains2) {
                        contains3 = StringsKt__StringsKt.contains((CharSequence) url, (CharSequence) "_kbundle", false);
                        if (!contains3) {
                            return false;
                        }
                    }
                }
                Uri parse = Uri.parse(url);
                String host = parse.getHost();
                if (host != null && host.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return false;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String it : queryParameterNames) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            String queryParameter = parse.getQueryParameter(it);
                            if (queryParameter == null) {
                                queryParameter = "";
                            }
                            Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(it) ?: \"\"");
                            linkedHashMap.put(it, queryParameter);
                        }
                    }
                    if (Intrinsics.areEqual("youxi.gamecenter.qq.com", host) && linkedHashMap.containsKey("_kbundle")) {
                        if (linkedHashMap.containsKey("_kpage")) {
                            try {
                                if (b(hostActivity, url, linkedHashMap)) {
                                    return true;
                                }
                                if (!Intrinsics.areEqual(linkedHashMap.get("type"), "kuikly") && linkedHashMap.containsKey(WadlProxyConsts.KEY_JUMP_URL) && Intrinsics.areEqual(host, "static.gamecenter.qq.com")) {
                                    Object obj = linkedHashMap.get(WadlProxyConsts.KEY_JUMP_URL);
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                    String str = (String) obj;
                                    if (str.length() == 0) {
                                        return false;
                                    }
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "mqqapi://kuikly/open", false, 2, null);
                                    if (!startsWith$default) {
                                        return false;
                                    }
                                    Intent intent = new Intent(hostActivity, (Class<?>) JumpActivity.class);
                                    intent.setData(Uri.parse(str));
                                    hostActivity.startActivity(intent);
                                    return true;
                                }
                                if (linkedHashMap.containsKey("open_kuikly_info")) {
                                    return false;
                                }
                                Object obj2 = linkedHashMap.get("open_kuikly_info");
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                                String str2 = (String) obj2;
                                if (str2.length() == 0) {
                                    return false;
                                }
                                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102079", "");
                                if (!(loadAsString.length() == 0) && (optJSONArray = new JSONObject(loadAsString).optJSONArray("domains")) != null && optJSONArray.length() != 0) {
                                    int length = optJSONArray.length();
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length) {
                                            z17 = false;
                                            break;
                                        }
                                        if (Intrinsics.areEqual(host, optJSONArray.optString(i3))) {
                                            z17 = true;
                                            break;
                                        }
                                        i3++;
                                    }
                                    if (!z17) {
                                        return false;
                                    }
                                    JSONObject jSONObject = new JSONObject(str2);
                                    if (jSONObject.has("platform_only") && (optInt = jSONObject.optInt("platform_only")) != 0 && optInt != 2) {
                                        return false;
                                    }
                                    if (jSONObject.has(KuiklyLaunchParams.PARAM_MIN_QQ_VERSION)) {
                                        String minVersion = jSONObject.optString(KuiklyLaunchParams.PARAM_MIN_QQ_VERSION);
                                        if (minVersion != null && minVersion.length() != 0) {
                                            z18 = false;
                                            if (!z18) {
                                                return false;
                                            }
                                            QQKuiklyRenderView.Companion companion = QQKuiklyRenderView.INSTANCE;
                                            Intrinsics.checkNotNullExpressionValue(minVersion, "minVersion");
                                            if (!companion.f(minVersion)) {
                                                return false;
                                            }
                                        }
                                        z18 = true;
                                        if (!z18) {
                                        }
                                    }
                                    for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
                                        if (!Intrinsics.areEqual(entry.getKey(), "open_kuikly_info") && !jSONObject.has(entry.getKey())) {
                                            jSONObject.put(entry.getKey(), entry.getValue());
                                        }
                                    }
                                    ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(hostActivity, jSONObject);
                                    return true;
                                }
                                return false;
                            } catch (Throwable unused) {
                                QLog.e("QQKuiklyWebNavigationItem", 1, "shouldInterceptUrl failed " + url);
                                return false;
                            }
                        }
                    }
                    if (!Intrinsics.areEqual(linkedHashMap.get("type"), "kuikly")) {
                    }
                    if (linkedHashMap.containsKey("open_kuikly_info")) {
                    }
                }
                z16 = true;
                if (!z16) {
                }
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(Intent intent, Activity activity, String url) {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(Intent intent, Activity hostActivity, String url) {
        if ((url == null || url.length() == 0) || intent == null || hostActivity == null) {
            return false;
        }
        return INSTANCE.a(hostActivity, url);
    }
}
