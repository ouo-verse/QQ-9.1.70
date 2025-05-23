package com.tencent.mobileqq.qwallet.utils;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.qwallet.web.api.IDoubleWebApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/l;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "b", "c", "", "a", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f279289a = new l();

    l() {
    }

    private final void b(Context context, Uri uri) {
        QWalletWxMiniAppLauncher.f279245d.a(context, uri);
    }

    private final void c(Context context, Uri uri) {
        if (!((IDoubleWebApi) QRoute.api(IDoubleWebApi.class)).start(context, uri)) {
            QQToast.makeText(context, 1, "\u53c2\u6570\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            QLog.d("TenpayJumpAction", 1, uri);
        }
    }

    public final boolean a(@Nullable Context context, @Nullable Uri uri) {
        String str;
        if (uri != null) {
            str = uri.getScheme();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, TenpayJumpActivity.TENPAY_SCHEME)) {
            return false;
        }
        String authority = uri.getAuthority();
        List<String> pathSegments = uri.getPathSegments();
        if (Intrinsics.areEqual(authority, "wxminiapp")) {
            Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments");
            if ((!pathSegments.isEmpty()) && Intrinsics.areEqual(pathSegments.get(0), "launch")) {
                b(context, uri);
                return true;
            }
        }
        if (Intrinsics.areEqual(authority, "doubleWebPage")) {
            Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments");
            if ((!pathSegments.isEmpty()) && Intrinsics.areEqual(pathSegments.get(0), "open")) {
                c(context, uri);
                return true;
            }
        }
        return false;
    }
}
