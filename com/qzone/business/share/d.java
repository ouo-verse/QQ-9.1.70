package com.qzone.business.share;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J.\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/business/share/d;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "filePath", "title", "content", "", "g", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper;", "xhsShareHelper", "", "d", tl.h.F, "i", "b", "Ljava/lang/String;", "XHS_SOURCE", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f44790a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String XHS_SOURCE = "QZ_SHARE";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/business/share/d$a", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements XhsShareHelper.e {
        a() {
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onError(String sessionId, int errorCode, String errorMessage, Throwable throwable) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.i("QZoneXhsShareHelper", 1, "shareToXhs onError. sessionId = " + sessionId + " errorCode = " + errorCode + " errorMessage = " + errorMessage);
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onSuccess(String sessionId) {
            QLog.i("QZoneXhsShareHelper", 1, "shareToXhs success. sessionId = " + sessionId);
        }
    }

    d() {
    }

    private final boolean d(final Context context, XhsShareHelper xhsShareHelper) {
        if (xhsShareHelper != null && context != null) {
            VersionCheckResult h16 = xhsShareHelper.h(context);
            if (h16 == null) {
                QLog.e("QZoneXhsShareHelper", 1, "checkResult is null error!");
                return false;
            }
            int i3 = h16.checkResultCode;
            if (i3 == -1) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.business.share.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.e(context);
                    }
                });
                return false;
            }
            if (i3 == 0) {
                return true;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.business.share.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(context);
                }
            });
            return false;
        }
        QLog.e("QZoneXhsShareHelper", 1, "args is null error!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Activity activity, String str, String str2, String str3) {
        d dVar = f44790a;
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        dVar.g(activity, str, str2, str3);
    }

    public final void h(Activity activity, String filePath) {
        i(activity, filePath, "", "");
    }

    public final void i(final Activity activity, final String filePath, final String title, final String content) {
        if (activity != null && filePath != null) {
            if (!d(activity, new XhsShareHelper())) {
                QLog.i("QZoneXhsShareHelper", 1, "isSupportShareToXhs false");
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.business.share.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.j(activity, filePath, title, content);
                    }
                });
                return;
            }
        }
        QLog.e("QZoneXhsShareHelper", 1, "shareToXhs context is null.");
    }

    private final void g(Activity activity, String filePath, String title, String content) {
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(filePath)) {
            XhsShareHelper xhsShareHelper = new XhsShareHelper();
            XhsShareHelper.c cVar = new XhsShareHelper.c(null, null, filePath);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            xhsShareHelper.l(XHS_SOURCE, new WeakReference<>(activity), new XhsShareHelper.b(title, content, arrayList), new WeakReference<>(new a()));
            return;
        }
        QLog.e("QZoneXhsShareHelper", 1, "realShareToXhs args error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context) {
        QQToast.makeText(context, R.string.f2047553r, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context) {
        QQToast.makeText(context, R.string.f2047653s, 0).show();
    }
}
