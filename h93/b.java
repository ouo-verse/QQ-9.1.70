package h93;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lh93/b;", "Lh93/a;", "", "e", "", "d", "Landroid/content/res/Resources;", PM.BASE, "b", "Landroid/view/LayoutInflater;", "a", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Z", "switchOn", "Landroid/content/res/QUIProfileResources;", "Landroid/content/res/QUIProfileResources;", "quiResources", "Landroid/content/res/QUIProfileLayoutInflater;", "Landroid/content/res/QUIProfileLayoutInflater;", "quiLayoutInflater", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setColorPalette", "<init>", "(Landroid/content/Context;Z)V", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean switchOn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIProfileResources quiResources;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIProfileLayoutInflater quiLayoutInflater;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean setColorPalette;

    public b(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.switchOn = z16;
        this.setColorPalette = new AtomicBoolean(false);
    }

    private final boolean d() {
        if (this.switchOn && QQTheme.isDefaultTheme()) {
            return true;
        }
        return false;
    }

    private final void e() {
        if (this.setColorPalette.getAndSet(true)) {
            return;
        }
        be0.a.b(QUIProfileConstants.PROFILE_ID_WINK).c(QUIProfileConstants.DEFAULT_NIGHT_COLOR_PALETTE);
    }

    @Override // h93.a
    @NotNull
    public LayoutInflater a(@NotNull LayoutInflater base) {
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileLayoutInflater qUIProfileLayoutInflater = this.quiLayoutInflater;
        if (qUIProfileLayoutInflater != null) {
            return qUIProfileLayoutInflater;
        }
        if (d()) {
            QLog.i("QQWinkQUIProfileTheme", 1, "use profile layout inflater: " + this.context.getClass().getName());
            this.quiLayoutInflater = new QUIProfileLayoutInflater(base, this.context, QUIProfileConstants.PROFILE_ID_WINK);
            e();
            QUIProfileLayoutInflater qUIProfileLayoutInflater2 = this.quiLayoutInflater;
            Intrinsics.checkNotNull(qUIProfileLayoutInflater2);
            return qUIProfileLayoutInflater2;
        }
        return base;
    }

    @Override // h93.a
    @NotNull
    public Resources b(@NotNull Resources base) {
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileResources qUIProfileResources = this.quiResources;
        if (qUIProfileResources != null) {
            return qUIProfileResources;
        }
        if (d()) {
            QLog.i("QQWinkQUIProfileTheme", 1, "use profile resources: " + this.context.getClass().getName());
            this.quiResources = new QUIProfileResources(base, this.context, QUIProfileConstants.PROFILE_ID_WINK);
            e();
            QUIProfileResources qUIProfileResources2 = this.quiResources;
            Intrinsics.checkNotNull(qUIProfileResources2);
            return qUIProfileResources2;
        }
        return base;
    }

    @Override // h93.a
    public boolean c() {
        return d();
    }
}
