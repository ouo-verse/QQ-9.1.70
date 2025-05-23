package com.tencent.paysdk.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.l;
import com.tencent.paysdk.api.q;
import com.tencent.paysdk.log.c;
import com.tencent.paysdk.util.ThreadCenter;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010!\u001a\u00020\u0001\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0017\u0010!\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#R\u001c\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010#R\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/paysdk/core/JsDelegatorDecorator;", "Lcom/tencent/paysdk/api/l;", "Lcom/tencent/paysdk/api/q;", "", "width", "height", "", "f", "e", "b", "g", "onCreate", h.F, "d", "c", "onHide", "onShow", "onAttach", "onDetach", "a", "", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "loadOverTimeRunnable", "Lcom/tencent/paysdk/api/l;", "j", "()Lcom/tencent/paysdk/api/l;", "realJsDelegator", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "runOnDetach", "runOnLoadFinish", "runOnLoadFinishOverTime", "<init>", "(Lcom/tencent/paysdk/api/l;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class JsDelegatorDecorator implements l, q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Runnable loadOverTimeRunnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l realJsDelegator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> runOnDetach;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> runOnLoadFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> runOnLoadFinishOverTime;

    public JsDelegatorDecorator(@NotNull l realJsDelegator, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02, @Nullable Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(realJsDelegator, "realJsDelegator");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, realJsDelegator, function0, function02, function03);
            return;
        }
        this.realJsDelegator = realJsDelegator;
        this.runOnDetach = function0;
        this.runOnLoadFinish = function02;
        this.runOnLoadFinishOverTime = function03;
        this.loadOverTimeRunnable = new Runnable() { // from class: com.tencent.paysdk.core.JsDelegatorDecorator$loadOverTimeRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) JsDelegatorDecorator.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function0 function04;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                JsDelegatorDecorator.this.c();
                c.a("JsDelegatorDecorator", "onH5LoadOvertime: " + JsDelegatorDecorator.this);
                function04 = JsDelegatorDecorator.this.runOnLoadFinishOverTime;
                if (function04 != null) {
                }
            }
        };
    }

    @Override // com.tencent.paysdk.api.q
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.realJsDelegator.g().a();
            ThreadCenter.d(this.loadOverTimeRunnable);
        }
    }

    @Override // com.tencent.paysdk.api.l
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.realJsDelegator.b();
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.realJsDelegator.g().c();
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.realJsDelegator.g().d();
        Function0<Unit> function0 = this.runOnLoadFinish;
        if (function0 != null) {
            function0.invoke();
        }
        ThreadCenter.d(this.loadOverTimeRunnable);
    }

    @Override // com.tencent.paysdk.api.l
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.realJsDelegator.e();
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        return Intrinsics.areEqual(this.realJsDelegator, other);
    }

    @Override // com.tencent.paysdk.api.l
    public void f(int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(width), Integer.valueOf(height));
        } else {
            this.realJsDelegator.f(width, height);
        }
    }

    @Override // com.tencent.paysdk.api.l
    @NotNull
    public q g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (q) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.paysdk.api.q
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.realJsDelegator.g().h();
        ThreadCenter.d(this.loadOverTimeRunnable);
        ThreadCenter.b(null, this.loadOverTimeRunnable, TimeUnit.SECONDS.toMillis(10L));
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.realJsDelegator.hashCode();
    }

    @NotNull
    public final l j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (l) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.realJsDelegator;
    }

    @Override // com.tencent.paysdk.api.q
    public void onAttach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.realJsDelegator.g().onAttach();
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.realJsDelegator.g().onCreate();
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.realJsDelegator.g().onDetach();
        Function0<Unit> function0 = this.runOnDetach;
        if (function0 != null) {
            function0.invoke();
        }
        ThreadCenter.d(this.loadOverTimeRunnable);
    }

    @Override // com.tencent.paysdk.api.q
    public void onHide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.realJsDelegator.g().onHide();
        }
    }

    @Override // com.tencent.paysdk.api.q
    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.realJsDelegator.g().onShow();
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.realJsDelegator.toString();
    }

    public /* synthetic */ JsDelegatorDecorator(l lVar, Function0 function0, Function0 function02, Function0 function03, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, (i3 & 2) != 0 ? null : function0, (i3 & 4) != 0 ? null : function02, (i3 & 8) == 0 ? function03 : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, this, lVar, function0, function02, function03, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
