package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/t;", "", "Landroid/content/Context;", "context", "", "c", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f326727a = new t();

    t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        if (r.f(context)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 6);
        try {
            context.startService(intent);
        } catch (Throwable th5) {
            w53.b.d("DisplayUtil", "preLoadPeakProcess, ", th5);
        }
        w53.b.a("DisplayUtil", "preLoadPeakProcess");
    }

    public final boolean b(@NotNull String taskId) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        equals = StringsKt__StringsJVMKt.equals(taskId, QCircleScheme.AttrQQPublish.BUSINESS_TASK_ID_QQ_ROBOT_TABLE, true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(taskId, QCircleScheme.AttrQQPublish.BUSINESS_TASK_ID_QQ_ROBOT_IMAGE, true);
            if (!equals2) {
                equals3 = StringsKt__StringsJVMKt.equals(taskId, QCircleScheme.AttrQQPublish.BUSINESS_TASK_ID_QQ_ROBOT_BANNER, true);
                if (!equals3) {
                    equals4 = StringsKt__StringsJVMKt.equals(taskId, QCircleScheme.AttrQQPublish.BUSINESS_TASK_ID_QQ_ROBOT_SUGGEST, true);
                    if (equals4) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public final void c(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.utils.s
            @Override // java.lang.Runnable
            public final void run() {
                t.d(context);
            }
        }, 64, null, false);
    }
}
