package com.tencent.mobileqq.qwallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J<\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J(\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/k;", "", "Landroid/content/Context;", "context", "", "urlString", "", "hideOperationBar", "hideMoreButton", "Landroid/os/Bundle;", "bizExtData", "", "b", "url", "d", "f", tl.h.F, "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "g", "schemaUrl", "a", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f279288a = new k();

    k() {
    }

    @JvmStatic
    public static final void b(@Nullable Context context, @Nullable String urlString, boolean hideOperationBar, boolean hideMoreButton, @Nullable Bundle bizExtData) {
        Activity activity;
        if (context == null) {
            QLog.w("QWallet.SchemaUtils", 1, "gotoH5 fail, context is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", urlString);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("hide_operation_bar", hideOperationBar);
        intent.putExtra("hide_more_button", hideMoreButton);
        if (bizExtData != null) {
            intent.putExtras(bizExtData);
        }
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
        INewQWalletApi iNewQWalletApi = (INewQWalletApi) QRoute.api(INewQWalletApi.class);
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (iNewQWalletApi.shouldInterceptQQBrowserDelegationActivity(activity, urlString, intent)) {
            QLog.i("QWallet.SchemaUtils", 1, "gotoH5 intercept by qwallet: " + urlString);
            return;
        }
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static /* synthetic */ void c(Context context, String str, boolean z16, boolean z17, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        if ((i3 & 16) != 0) {
            bundle = null;
        }
        b(context, str, z16, z17, bundle);
    }

    @JvmStatic
    public static final void d(@Nullable Context context, @Nullable String url, @Nullable Bundle bizExtData) {
        if (context == null) {
            QLog.w("QWallet.SchemaUtils", 1, "gotoMqq fail, context is null");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(url));
        if (bizExtData != null) {
            intent.putExtras(bizExtData);
        }
        context.startActivity(intent);
    }

    public static /* synthetic */ void e(Context context, String str, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        d(context, str, bundle);
    }

    @JvmStatic
    public static final boolean f(@Nullable Context context, @Nullable String url) {
        Uri uri;
        if (context == null) {
            QLog.w("QWallet.SchemaUtils", 1, "gotoTenpay fail, context is null");
            return false;
        }
        if (url != null) {
            uri = Uri.parse(url);
        } else {
            uri = null;
        }
        return l.f279289a.a(context, uri);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        c(r12, r13.toString(), false, false, null, 28, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r2.equals("http") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r2.equals("https") == false) goto L29;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean g(@Nullable Context context, @Nullable Uri uri) {
        if (context != null && uri != null) {
            String scheme = uri.getScheme();
            if (scheme != null) {
                switch (scheme.hashCode()) {
                    case -1066568787:
                        if (scheme.equals(SchemaUtils.SCHEMA_MQQAPI)) {
                            e(context, uri.toString(), null, 4, null);
                            return true;
                        }
                        break;
                    case -877322389:
                        if (scheme.equals(TenpayJumpActivity.TENPAY_SCHEME)) {
                            return f(context, uri.toString());
                        }
                        break;
                    case 3213448:
                        break;
                    case 99617003:
                        break;
                }
            }
            QLog.w("QWallet.SchemaUtils", 1, "goto unspecified uri: " + uri);
            e(context, uri.toString(), null, 4, null);
            return true;
        }
        QLog.w("QWallet.SchemaUtils", 1, "goto fail, context is null");
        return false;
    }

    @JvmStatic
    public static final boolean h(@Nullable Context context, @Nullable String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QWallet.SchemaUtils", 1, "goto fail, url is null or empty");
            return false;
        }
        return g(context, Uri.parse(url));
    }

    public final void a(@Nullable String schemaUrl) {
        boolean z16;
        if (schemaUrl != null && schemaUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QWallet.SchemaUtils", 1, "goOut fail, url is null");
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(schemaUrl));
        intent.setFlags(268435456);
        MobileQQ.sMobileQQ.startActivity(intent);
    }
}
