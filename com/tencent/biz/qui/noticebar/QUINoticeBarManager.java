package com.tencent.biz.qui.noticebar;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qui/noticebar/QUINoticeBarManager;", "", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qui/noticebar/d;", h.F, "Lcom/tencent/biz/qui/noticebar/f;", "k", "Lcom/tencent/biz/qui/noticebar/c;", "g", "Lyd0/c;", "res", "Lcom/tencent/biz/qui/noticebar/e;", "i", "Landroid/view/View;", "v", "Lcom/tencent/biz/qui/noticebar/b;", "c", "d", "f", "b", "e", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "a", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUINoticeBarManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f95093a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qui/noticebar/QUINoticeBarManager$a;", "", "Lcom/tencent/biz/qui/noticebar/QUINoticeBarManager;", "a", "INSTANCE$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/biz/qui/noticebar/QUINoticeBarManager;", "INSTANCE", "<init>", "()V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.biz.qui.noticebar.QUINoticeBarManager$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        private final QUINoticeBarManager b() {
            return (QUINoticeBarManager) QUINoticeBarManager.f95093a.getValue();
        }

        @JvmStatic
        @NotNull
        public final QUINoticeBarManager a() {
            return b();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUINoticeBarManager>() { // from class: com.tencent.biz.qui.noticebar.QUINoticeBarManager$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUINoticeBarManager invoke() {
                return new QUINoticeBarManager();
            }
        });
        f95093a = lazy;
    }

    public static /* synthetic */ e j(QUINoticeBarManager qUINoticeBarManager, Context context, yd0.c cVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            cVar = null;
        }
        return qUINoticeBarManager.i(context, cVar);
    }

    @JvmStatic
    @NotNull
    public static final QUINoticeBarManager l() {
        return INSTANCE.a();
    }

    @Nullable
    public final c b(@Nullable View v3) {
        Object obj;
        Object obj2 = null;
        if (v3 != null) {
            obj = v3.getTag(R.id.f66623b5);
        } else {
            obj = null;
        }
        if (obj instanceof c) {
            obj2 = obj;
        }
        return (c) obj2;
    }

    @Nullable
    public final b<?> c(@Nullable View v3) {
        Object obj;
        Object obj2 = null;
        if (v3 != null) {
            obj = v3.getTag(R.id.f66623b5);
        } else {
            obj = null;
        }
        if (obj instanceof b) {
            obj2 = obj;
        }
        return (b) obj2;
    }

    @Nullable
    public final d d(@Nullable View v3) {
        Object obj;
        Object obj2 = null;
        if (v3 != null) {
            obj = v3.getTag(R.id.f66623b5);
        } else {
            obj = null;
        }
        if (obj instanceof d) {
            obj2 = obj;
        }
        return (d) obj2;
    }

    @Nullable
    public final e e(@Nullable View v3) {
        Object obj;
        Object obj2 = null;
        if (v3 != null) {
            obj = v3.getTag(R.id.f66623b5);
        } else {
            obj = null;
        }
        if (obj instanceof e) {
            obj2 = obj;
        }
        return (e) obj2;
    }

    @Nullable
    public final f f(@Nullable View v3) {
        Object obj;
        Object obj2 = null;
        if (v3 != null) {
            obj = v3.getTag(R.id.f66623b5);
        } else {
            obj = null;
        }
        if (obj instanceof f) {
            obj2 = obj;
        }
        return (f) obj2;
    }

    @NotNull
    public final c g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new zd0.c(context);
    }

    @NotNull
    public final d h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new zd0.d(context);
    }

    @JvmOverloads
    @NotNull
    public final e i(@NotNull Context context, @Nullable yd0.c res) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (res == null) {
            res = new yd0.c(context);
        }
        return new zd0.e(context, res);
    }

    @NotNull
    public final f k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new zd0.f(context);
    }

    public final boolean m(@Nullable View v3) {
        Object obj;
        if (v3 != null) {
            obj = v3.getTag(R.id.f66623b5);
        } else {
            obj = null;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }
}
