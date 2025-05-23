package com.tencent.aio.widget.textView.creator;

import android.content.Context;
import android.graphics.Typeface;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/a;", "Lcom/tencent/aio/widget/textView/creator/e;", "", "Landroid/content/Context;", "context", "Lcom/tencent/aio/widget/textView/param/b;", "param", "Landroid/text/TextPaint;", "paint", "g", "", "currentAPi", "", "e", "Lcom/tencent/aio/widget/textView/creator/b;", "manager", "", "f", "Landroid/text/StaticLayout;", "d", "a", "Lcom/tencent/aio/widget/textView/creator/b;", "acquire", "<init>", "()V", "b", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class a implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b acquire;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.creator.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private final TextPaint g(Context context, com.tencent.aio.widget.textView.param.b param, TextPaint paint) {
        paint.setTextSize(param.l());
        Typeface n3 = param.n();
        if (n3 == null) {
            b bVar = this.acquire;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("acquire");
            }
            n3 = bVar.e().a(param.m(), context);
        }
        paint.setTypeface(n3);
        paint.setAntiAlias(true);
        return paint;
    }

    @NotNull
    public final synchronized StaticLayout d(@NotNull Context context, @NotNull TextPaint paint, @NotNull com.tencent.aio.widget.textView.param.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StaticLayout) iPatchRedirector.redirect((short) 3, this, context, paint, param);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(param, "param");
        return b(param, g(context, param, paint));
    }

    public final boolean e(int currentAPi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, currentAPi)).booleanValue();
        }
        if (a() <= currentAPi && currentAPi <= c()) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull b manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) manager);
        } else {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.acquire = manager;
        }
    }
}
