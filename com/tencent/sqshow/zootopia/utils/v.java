package com.tencent.sqshow.zootopia.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\"\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/v;", "", "", "msgRes", "", "debugMsg", "", "c", "msg", "d", "error", "message", "timeOutMsg", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f373305a = new v();

    v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String msg2, String str) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            QQToast.makeText(mobileQQ, msg2 + "", 0).show();
        }
    }

    public final String b(int error, String message, String timeOutMsg) {
        Intrinsics.checkNotNullParameter(timeOutMsg, "timeOutMsg");
        return ((message == null || message.length() == 0) || error == 1002) ? timeOutMsg : message;
    }

    public final void c(int msgRes, String debugMsg) {
        try {
            String string = MobileQQ.sMobileQQ.getResources().getString(msgRes);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getString(msgRes)");
            d(string, debugMsg);
        } catch (Throwable th5) {
            QLog.e("ToastUtils", 1, "showErrTips, err.", th5);
        }
    }

    public final void d(final String msg2, final String debugMsg) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                v.e(msg2, debugMsg);
            }
        });
    }
}
