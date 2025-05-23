package com.tencent.mobileqq.vas.utils;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/b;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/b$a;", "", "", WadlProxyConsts.KEY_JUMP_URL, "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.utils.b$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String jumpUrl) {
            boolean startsWith$default;
            boolean startsWith$default2;
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            if (!TextUtils.isEmpty(jumpUrl)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "http", false, 2, null);
                if (startsWith$default) {
                    Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(jumpUrl);
                    if (!argumentsFromURL.containsKey("clmInfo")) {
                        return;
                    }
                    String str = argumentsFromURL.get("clmInfo");
                    if (str == null) {
                        str = "";
                    }
                    jumpUrl = new JSONObject(str).optString("url");
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "jsonObject.optString(\"url\")");
                }
                try {
                    if (!TextUtils.isEmpty(jumpUrl)) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "mqqapi://kuikly/open", false, 2, null);
                        if (startsWith$default2) {
                            String str2 = URLUtil.getArgumentsFromURL(jumpUrl).get("bundle_name");
                            if (!TextUtils.isEmpty(str2)) {
                                QRouteApi api = QRoute.api(IVasKuiklyApi.class);
                                Intrinsics.checkNotNullExpressionValue(api, "api(IVasKuiklyApi::class.java)");
                                Intrinsics.checkNotNull(str2);
                                IVasKuiklyApi.a.a((IVasKuiklyApi) api, str2, null, 2, null);
                            }
                        }
                    }
                } catch (JSONException e16) {
                    QLog.e("VasClmUrlUtils", 1, "jsonException", e16);
                }
            }
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void a(@NotNull String str) {
        INSTANCE.a(str);
    }
}
