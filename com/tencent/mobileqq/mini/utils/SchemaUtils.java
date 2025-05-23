package com.tencent.mobileqq.mini.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u001c\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/utils/SchemaUtils;", "", "()V", "SCHEMA_HTTP", "", "SCHEMA_HTTPS", "SCHEMA_MQQAPI", "TAG", "gotoH5", "", "context", "Landroid/content/Context;", "urlString", "hideOperationBar", "", "hideMoreButton", "gotoMqq", "url", "gotoUri", LayoutAttrDefine.CLICK_URI, "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SchemaUtils {
    public static final SchemaUtils INSTANCE = new SchemaUtils();
    public static final String SCHEMA_HTTP = "http";
    public static final String SCHEMA_HTTPS = "https";
    public static final String SCHEMA_MQQAPI = "mqqapi";
    public static final String TAG = "SchemaUtils";

    SchemaUtils() {
    }

    @JvmStatic
    public static final void gotoH5(Context context, String urlString, boolean hideOperationBar, boolean hideMoreButton) {
        if (context == null) {
            QLog.w(TAG, 1, "gotoH5 fail, context is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", urlString);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("hide_operation_bar", hideOperationBar);
        intent.putExtra("hide_more_button", hideMoreButton);
        QLog.d(TAG, 4, "gotoH5 url: " + urlString);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    @JvmStatic
    public static final void gotoMqq(Context context, String url) {
        if (context == null) {
            QLog.w(TAG, 4, "gotoMqq fail, context is null");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(url));
        QLog.d(TAG, 2, "gotoMqq url: " + url);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final boolean gotoUri(Context context, String uri) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        if (context != null && uri != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(uri, "https", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(uri, "http", false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(uri, SCHEMA_MQQAPI, false, 2, null);
                    if (!startsWith$default3) {
                        return false;
                    }
                    gotoMqq(context, uri);
                    return true;
                }
            }
            gotoH5$default(context, uri, false, false, 12, null);
            return true;
        }
        QLog.w(TAG, 1, "goto fail, context is null");
        return false;
    }

    public static /* synthetic */ void gotoH5$default(Context context, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        gotoH5(context, str, z16, z17);
    }
}
