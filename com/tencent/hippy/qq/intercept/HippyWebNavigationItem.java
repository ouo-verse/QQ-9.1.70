package com.tencent.hippy.qq.intercept;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.webview.swift.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippy/qq/intercept/HippyWebNavigationItem;", "Lcom/tencent/mobileqq/webview/swift/d;", "Landroid/content/Intent;", "intent", "Landroid/app/Activity;", "hostActivity", "", "url", "", "navigateToAnotherActivity", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "needSwitchFragment", "<init>", "()V", "Companion", "hippy-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class HippyWebNavigationItem implements d {

    @NotNull
    private static final String CONFIG_KEY_DOMAINS = "domains";

    @NotNull
    private static final String CONFIG_KEY_SCHEMAS = "schemas";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String HTTP = "http";

    @NotNull
    private static final String HTTPS = "https";

    @NotNull
    private static final String PARAM_JUMP_URL = "jumpUrl";

    @NotNull
    private static final String PARAM_TYPE = "type";

    @NotNull
    public static final String TAG = "HippyWebNavigationItem";

    @NotNull
    private static final String VALUE_HIPPY = "hippy";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/hippy/qq/intercept/HippyWebNavigationItem$Companion;", "", "()V", "CONFIG_KEY_DOMAINS", "", "CONFIG_KEY_SCHEMAS", "HTTP", "HTTPS", "PARAM_JUMP_URL", "PARAM_TYPE", "TAG", "VALUE_HIPPY", "interceptHippyUrl", "", "hostActivity", "Landroid/app/Activity;", "url", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0025 A[Catch: all -> 0x0149, TryCatch #0 {all -> 0x0149, blocks: (B:82:0x000a, B:6:0x0017, B:12:0x0025, B:14:0x0030, B:16:0x0039, B:19:0x0044, B:21:0x004e, B:28:0x005b, B:30:0x0066, B:31:0x006a, B:33:0x0070, B:37:0x0085, B:40:0x008f, B:42:0x009f, B:44:0x00a5, B:49:0x00bd, B:52:0x00d6, B:54:0x00dd, B:60:0x00ef, B:62:0x010e, B:65:0x0118, B:67:0x011f, B:71:0x012f, B:56:0x00e9), top: B:81:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x005b A[Catch: all -> 0x0149, TryCatch #0 {all -> 0x0149, blocks: (B:82:0x000a, B:6:0x0017, B:12:0x0025, B:14:0x0030, B:16:0x0039, B:19:0x0044, B:21:0x004e, B:28:0x005b, B:30:0x0066, B:31:0x006a, B:33:0x0070, B:37:0x0085, B:40:0x008f, B:42:0x009f, B:44:0x00a5, B:49:0x00bd, B:52:0x00d6, B:54:0x00dd, B:60:0x00ef, B:62:0x010e, B:65:0x0118, B:67:0x011f, B:71:0x012f, B:56:0x00e9), top: B:81:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean interceptHippyUrl(@Nullable Activity hostActivity, @Nullable String url) {
            boolean z16;
            boolean z17;
            boolean contains$default;
            boolean startsWith$default;
            boolean startsWith$default2;
            boolean z18;
            boolean z19;
            JSONObject configJsonObj;
            JSONArray optJSONArray;
            boolean z26;
            boolean startsWith$default3;
            if (hostActivity != null) {
                try {
                } catch (Throwable unused) {
                    QLog.e(HippyWebNavigationItem.TAG, 1, "shouldInterceptUrl failed " + url);
                }
                if (!hostActivity.isFinishing()) {
                    z16 = true;
                    if (z16) {
                        if (url != null && url.length() != 0) {
                            z17 = false;
                            if (z17) {
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "type=hippy", false, 2, (Object) null);
                                if (contains$default) {
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
                                    if (startsWith$default) {
                                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
                                        if (startsWith$default2) {
                                            Uri parse = Uri.parse(url);
                                            String host = parse.getHost();
                                            if (host != null && host.length() != 0) {
                                                z18 = false;
                                                if (!z18) {
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
                                                if (Intrinsics.areEqual(linkedHashMap.get("type"), "hippy") && linkedHashMap.containsKey("jumpUrl")) {
                                                    Object obj = linkedHashMap.get("jumpUrl");
                                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                                    String str = (String) obj;
                                                    if (str.length() == 0) {
                                                        z19 = true;
                                                    } else {
                                                        z19 = false;
                                                    }
                                                    if (z19 || (optJSONArray = (configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.HIPPY_URL_INTERCEPT_CONFIG)).optJSONArray(HippyWebNavigationItem.CONFIG_KEY_DOMAINS)) == null) {
                                                        return false;
                                                    }
                                                    int length = optJSONArray.length();
                                                    int i3 = 0;
                                                    while (true) {
                                                        if (i3 < length) {
                                                            if (Intrinsics.areEqual(optJSONArray.optString(i3), host)) {
                                                                z26 = true;
                                                                break;
                                                            }
                                                            i3++;
                                                        } else {
                                                            z26 = false;
                                                            break;
                                                        }
                                                    }
                                                    if (!z26) {
                                                        QLog.e(HippyWebNavigationItem.TAG, 1, "no match urmDomain:" + host + ",config:" + configJsonObj);
                                                        return false;
                                                    }
                                                    JSONArray optJSONArray2 = configJsonObj.optJSONArray(HippyWebNavigationItem.CONFIG_KEY_SCHEMAS);
                                                    if (optJSONArray2 == null) {
                                                        return false;
                                                    }
                                                    int length2 = optJSONArray2.length();
                                                    for (int i16 = 0; i16 < length2; i16++) {
                                                        String optString = optJSONArray2.optString(i16);
                                                        Intrinsics.checkNotNullExpressionValue(optString, "schemas.optString(i)");
                                                        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str, optString, false, 2, null);
                                                        if (startsWith$default3) {
                                                            Intent intent = new Intent();
                                                            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                                                            intent.setData(Uri.parse(str));
                                                            hostActivity.startActivity(intent);
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                            z18 = true;
                                            if (!z18) {
                                            }
                                        }
                                    }
                                }
                                return false;
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    }
                    return false;
                }
            }
            z16 = false;
            if (z16) {
            }
            return false;
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(@Nullable Intent intent, @Nullable Activity hostActivity, @Nullable String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || intent == null || hostActivity == null) {
            return false;
        }
        return INSTANCE.interceptHippyUrl(hostActivity, url);
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(@Nullable Intent intent, @Nullable Activity activity, @Nullable String url) {
        return false;
    }
}
