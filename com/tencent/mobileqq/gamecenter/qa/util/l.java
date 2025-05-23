package com.tencent.mobileqq.gamecenter.qa.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/l;", "", "Landroid/content/Context;", "context", "", "url", "", "c", "Landroid/app/Activity;", "a", "roleId", "b", "<init>", "()V", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f212717a = new l();

    l() {
    }

    @Nullable
    public final Activity a() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return Foreground.getTopActivity();
        }
        return qBaseActivity;
    }

    public final boolean b(@Nullable Context context, @Nullable String roleId) {
        boolean z16;
        boolean z17;
        QLog.d("MetaDreamUtil", 2, "openMetaDreamPlayerPage");
        if (context == null) {
            return false;
        }
        if (roleId != null && roleId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("MetaDreamUtil", 2, "openMetaDreamPlayerPage invalid param");
            return false;
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("101687", new byte[0]);
        if (loadRawConfig.length == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            QLog.e("MetaDreamUtil", 1, "openMetaDreamPlayerPage config null ");
            return false;
        }
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String optString = new JSONObject(new String(loadRawConfig, UTF_8)).optString(WadlProxyConsts.KEY_JUMP_URL);
            if (TextUtils.isEmpty(optString)) {
                QLog.e("MetaDreamUtil", 1, "openMetaDreamPlayerPage jumpUrl null");
                return false;
            }
            String url = URLUtil.addParameter(optString, "role_id", roleId);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            c(context, url);
            return true;
        } catch (Exception e16) {
            QLog.e("MetaDreamUtil", 1, "openMetaDreamPlayerPage parse config exception=", e16);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(@NotNull Context context, @NotNull String url) {
        boolean z16;
        boolean startsWith$default;
        boolean z17;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.d("MetaDreamUtil", 1, "openScheme context:" + context + ", url:" + url);
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (!(context instanceof Activity)) {
            context = a();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.content.Context");
        }
        if (!(context instanceof Activity)) {
            QLog.d("MetaDreamUtil", 1, "openScheme not activity context");
            return false;
        }
        String lowerCase = url.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "https://", false, 2, null);
            if (!startsWith$default3) {
                z17 = false;
                if (z17) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "mqqapi://", false, 2, null);
                    if (!startsWith$default2) {
                        return false;
                    }
                    Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                    intent.setData(Uri.parse(url));
                    context.startActivity(intent);
                    return true;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("url", url);
                RouteUtils.startActivity(context, intent2, RouterConstants.UI_ROUTE_BROWSER);
                return true;
            }
        }
        z17 = true;
        if (z17) {
        }
    }
}
