package com.tencent.mobileqq.zootopia.redpacket;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tJ\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tJ\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/RedPacketDialogUtil;", "", "Lkotlin/Function0;", "", "runnable", "b", "Landroid/content/Context;", "context", "e", "Lkotlin/Function1;", "", "callback", "d", "f", "Lcom/tencent/mobileqq/zplan/model/i;", "info", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RedPacketDialogUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final RedPacketDialogUtil f329064a = new RedPacketDialogUtil();

    RedPacketDialogUtil() {
    }

    private final void b(final Function0<Unit> runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            try {
                runnable.invoke();
                return;
            } catch (Throwable th5) {
                QLog.e("RedPacketDialogUtil", 1, "showDialog error", th5);
                return;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.redpacket.b
            @Override // java.lang.Runnable
            public final void run() {
                RedPacketDialogUtil.c(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        try {
            runnable.invoke();
        } catch (Throwable th5) {
            QLog.e("RedPacketDialogUtil", 1, "showDialog error", th5);
        }
    }

    public final void d(Context context, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b(new RedPacketDialogUtil$showAvatarLoadFailDialog$1(context, callback));
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b(new RedPacketDialogUtil$showAvatarLoadingDialog$1(context));
    }

    public final void f(Context context, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b(new RedPacketDialogUtil$showAvatarSendFailDialog$1(context, callback));
    }

    public final void g(Context context, ZPlanMaintInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        b(new RedPacketDialogUtil$showMaintenanceDialog$1(context, info));
    }
}
