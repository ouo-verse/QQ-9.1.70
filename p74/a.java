package p74;

import android.content.Context;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUIProfileConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lp74/a;", "", "", "d", "", "c", "Landroid/content/res/Resources;", PM.BASE, "b", "Landroid/view/LayoutInflater;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/content/res/QUIProfileResources;", "Landroid/content/res/QUIProfileResources;", "quiResources", "Landroid/content/res/QUIProfileLayoutInflater;", "Landroid/content/res/QUIProfileLayoutInflater;", "quiLayoutInflater", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setColorPalette", "<init>", "(Landroid/content/Context;)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QUIProfileResources quiResources;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QUIProfileLayoutInflater quiLayoutInflater;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean setColorPalette;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.setColorPalette = new AtomicBoolean(false);
    }

    private final boolean c() {
        return (QQTheme.isNowThemeIsNight() || QQTheme.isDefaultTheme() || Intrinsics.areEqual("2971", QQTheme.getCurrentThemeId())) ? false : true;
    }

    private final void d() {
        if (this.setColorPalette.getAndSet(true)) {
            return;
        }
        be0.a.b("zplan").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
    }

    public final LayoutInflater a(LayoutInflater base) {
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileLayoutInflater qUIProfileLayoutInflater = this.quiLayoutInflater;
        if (qUIProfileLayoutInflater != null) {
            return qUIProfileLayoutInflater;
        }
        if (!c()) {
            return base;
        }
        QLog.i("ZPlanTheme", 1, "use profile layout inflater " + this.context.getClass().getName());
        this.quiLayoutInflater = new QUIProfileLayoutInflater(base, this.context, "zplan");
        d();
        QUIProfileLayoutInflater qUIProfileLayoutInflater2 = this.quiLayoutInflater;
        Intrinsics.checkNotNull(qUIProfileLayoutInflater2);
        return qUIProfileLayoutInflater2;
    }

    public final Resources b(Resources base) {
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileResources qUIProfileResources = this.quiResources;
        if (qUIProfileResources != null) {
            return qUIProfileResources;
        }
        if (!c()) {
            return base;
        }
        QLog.i("ZPlanTheme", 1, "use profile resources " + this.context.getClass().getName());
        this.quiResources = new QUIProfileResources(base, this.context, "zplan");
        d();
        QUIProfileResources qUIProfileResources2 = this.quiResources;
        Intrinsics.checkNotNull(qUIProfileResources2);
        return qUIProfileResources2;
    }
}
