package com.tencent.qqnt.kernel.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.utils.c;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B#\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\f8\b@\bX\u0088\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/utils/ClearableLazyImpl;", "Lcom/tencent/qqnt/kernel/utils/c;", "T", "Lcom/tencent/qqnt/kernel/utils/d;", "Ljava/io/Serializable;", "", "isInitialized", "isClear", "", QCircleLpReportDc05507.KEY_CLEAR, "", "toString", "Lkotlin/Function0;", "initializer", "Lkotlin/jvm/functions/Function0;", "", "_value", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, HippyTextInputController.COMMAND_getValue, "()Lcom/tencent/qqnt/kernel/utils/c;", "value", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
final class ClearableLazyImpl<T extends c> implements d<T>, Serializable {
    static IPatchRedirector $redirector_;

    @Nullable
    private volatile Object _value;

    @Nullable
    private Function0<? extends T> initializer;

    @NotNull
    private final Object lock;

    public ClearableLazyImpl(@NotNull Function0<? extends T> initializer, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initializer, obj);
            return;
        }
        this.initializer = initializer;
        this._value = b.f359260a;
        this.lock = obj == null ? this : obj;
    }

    @Override // com.tencent.qqnt.kernel.utils.d
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Object obj = this._value;
        a aVar = a.f359259a;
        if (obj != aVar) {
            synchronized (this.lock) {
                if (this._value != aVar) {
                    this._value = aVar;
                }
                if (obj instanceof c) {
                    ((c) obj).clear();
                } else if (obj == b.f359260a) {
                    QLog.i("ClearableLazy", 1, "obj uninitialized");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public boolean isClear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this._value != a.f359259a) {
            return true;
        }
        return false;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this._value != b.f359260a) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    @Override // kotlin.Lazy
    @Nullable
    public T getValue() {
        T invoke;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object obj = this._value;
        a aVar = a.f359259a;
        if (obj == aVar) {
            return null;
        }
        b bVar = b.f359260a;
        if (obj != bVar) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.tencent.qqnt.kernel.utils.ClearableLazyImpl");
            return (T) obj;
        }
        synchronized (this.lock) {
            Object obj2 = this._value;
            if (obj2 == aVar) {
                return null;
            }
            if (obj2 != bVar) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of com.tencent.qqnt.kernel.utils.ClearableLazyImpl._get_value_$lambda$0");
                invoke = (T) obj2;
            } else {
                Function0<? extends T> function0 = this.initializer;
                Intrinsics.checkNotNull(function0);
                invoke = function0.invoke();
                this._value = invoke;
                this.initializer = null;
            }
            return invoke;
        }
    }

    public /* synthetic */ ClearableLazyImpl(Function0 function0, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i3 & 2) != 0 ? null : obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, function0, obj, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
