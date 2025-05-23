package com.tencent.qqnt;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernel.api.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b\u001a\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\u0018\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u0018\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e\u001aA\u0010\u001a\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001aC\u0010\u001c\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001b\"\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"", "startMills", DomainData.DOMAIN_NAME, "", "", "d", "", "from", "", "callback", "o", "Lcom/tencent/mobileqq/persistence/EntityManager;", "b", "canAutoRetrieve", "Ljava/lang/Runnable;", "runnable", "", "g", "e", "i", "Landroid/content/Context;", "context", "iconType", "msg", "duration", "yOffset", "j", "(Landroid/content/Context;ILjava/lang/String;ILjava/lang/Integer;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/api/s;", "c", "()Lcom/tencent/qqnt/kernel/api/s;", "groupService", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    @Nullable
    public static final EntityManager b() {
        EntityManagerFactory entityManagerFactory;
        AppRuntime f16 = bg.f();
        if (f16 != null && (entityManagerFactory = f16.getEntityManagerFactory()) != null) {
            return entityManagerFactory.createEntityManager();
        }
        return null;
    }

    @Nullable
    public static final s c() {
        return bg.i(null, 1, null);
    }

    public static final boolean d(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    public static final void e(boolean z16, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.excute(runnable, 32, null, z16);
    }

    public static /* synthetic */ void f(boolean z16, Runnable runnable, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        e(z16, runnable);
    }

    public static final void g(boolean z16, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.excute(runnable, 16, null, z16);
    }

    public static /* synthetic */ void h(boolean z16, Runnable runnable, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        g(z16, runnable);
    }

    public static final void i(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public static final void j(@Nullable final Context context, final int i3, @NotNull final String msg2, final int i16, @Nullable final Integer num) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            m(context, i3, msg2, i16, num);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.l(context, i3, msg2, i16, num);
                }
            });
        }
    }

    public static /* synthetic */ void k(Context context, int i3, String str, int i16, Integer num, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            context = null;
        }
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        if ((i17 & 16) != 0) {
            num = null;
        }
        j(context, i3, str, i16, num);
    }

    public static final void l(Context context, int i3, String msg2, int i16, Integer num) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        m(context, i3, msg2, i16, num);
    }

    private static final void m(Context context, int i3, String str, int i16, Integer num) {
        QQToast makeText = QQToast.makeText(context, i3, str, i16);
        if (num != null) {
            makeText.show(num.intValue());
        } else {
            makeText.show();
        }
    }

    public static final long n(long j3) {
        return System.currentTimeMillis() - j3;
    }

    @NotNull
    public static final String o(@NotNull String from, @Nullable Object obj) {
        int i3;
        Intrinsics.checkNotNullParameter(from, "from");
        if (obj != null) {
            i3 = obj.hashCode();
        } else {
            i3 = 0;
        }
        return from + "-" + i3;
    }
}
