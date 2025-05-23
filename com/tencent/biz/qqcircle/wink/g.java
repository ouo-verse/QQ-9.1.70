package com.tencent.biz.qqcircle.wink;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.part.publishprogress.q;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/g;", "", "Landroid/content/Context;", "context", "", "traceId", "", IProfileCardConst.KEY_FROM_TYPE, "", "c", "b", "d", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f93952a = new g();

    g() {
    }

    private final boolean b(Context context, String traceId, int fromType) {
        if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.b(context, 1);
            QLog.e("QQWinkLaunchChecker", 1, "[interceptByBindPhoneNum] traceId=" + traceId + ", fromType=" + fromType);
            h.f93953a.b(context, traceId, fromType, "-10004", true);
            return true;
        }
        return false;
    }

    private final boolean c(Context context, String traceId, int fromType) {
        String str;
        boolean z16;
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        Integer num = null;
        if (uq3.c.u5()) {
            QLog.w("QQWinkLaunchChecker", 1, "[checkPublishService], enableSkipPublishNoService");
            if (qfsService == null) {
                QLog.w("QQWinkLaunchChecker", 1, "[checkPublishService], invalid service");
                if (!q.f88294a.a()) {
                    str = "-100010";
                    z16 = false;
                } else {
                    QLog.w("QQWinkLaunchChecker", 1, "[checkPublishService], has running task");
                }
            } else {
                if (uq3.c.g6() && qfsService.hasRunningTask()) {
                    QLog.w("QQWinkLaunchChecker", 1, "[checkPublishService], has running task");
                    if (q.f88294a.a()) {
                        QLog.w("QQWinkLaunchChecker", 1, "QFSBoxProgressManager is showing");
                    } else {
                        QLog.w("QQWinkLaunchChecker", 1, "QFSBoxProgressManager is not showing");
                    }
                }
                z16 = false;
                str = null;
            }
            str = "-10002";
            z16 = true;
        } else if (qfsService == null) {
            QLog.w("QQWinkLaunchChecker", 1, "[checkPublishService], invalid service");
            str = "-100010";
            z16 = true;
        } else {
            if (uq3.c.g6() && qfsService.hasRunningTask()) {
                QLog.w("QQWinkLaunchChecker", 1, "[checkPublishService], has running task");
                str = "-10002";
                z16 = true;
            }
            z16 = false;
            str = null;
        }
        if (z16) {
            if (Intrinsics.areEqual(str, "-10002")) {
                num = Integer.valueOf(R.string.f193944ak);
            } else if (Intrinsics.areEqual(str, "-100010")) {
                num = Integer.valueOf(R.string.f196574ho);
            }
            if (num != null) {
                QCircleToast.h(num.intValue(), 0);
            }
        }
        if (str != null) {
            QLog.e("QQWinkLaunchChecker", 1, "[interceptByPublishService] traceId=" + traceId + ", fromType=" + fromType + ", errorCode=" + ((Object) str));
            h.f93953a.b(context, traceId, fromType, str, z16);
        }
        return z16;
    }

    private final boolean d(Context context, String traceId, int fromType) {
        if (com.tencent.biz.qqcircle.helpers.d.a(7, true)) {
            QLog.e("QQWinkLaunchChecker", 1, "[interceptBySecurity] traceId=" + traceId + ", fromType=" + fromType);
            h.f93953a.b(context, traceId, fromType, "-100014", true);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@Nullable Context context, @Nullable String traceId, int fromType) {
        boolean z16;
        boolean isBlank;
        if (context == null) {
            QLog.i("QQWinkLaunchChecker", 1, "[check] context is null");
            return false;
        }
        if (traceId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(traceId);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    traceId = QCirclePublishQualityReporter.getTraceId();
                }
                Intrinsics.checkNotNullExpressionValue(traceId, "realTraceId");
                if (!c(context, traceId, fromType) || b(context, traceId, fromType) || d(context, traceId, fromType)) {
                    return false;
                }
                return true;
            }
        }
        z16 = true;
        if (z16) {
        }
        Intrinsics.checkNotNullExpressionValue(traceId, "realTraceId");
        return !c(context, traceId, fromType) ? false : false;
    }
}
