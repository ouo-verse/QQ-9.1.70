package com.tencent.mobileqq.ai;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/ai/QuickLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "value", "", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;)V", "postValue", "", "delayMs", "f", "(Ljava/lang/Object;J)V", "", "d", "Z", "hadLoadHandler", "Landroid/os/Handler;", "e", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "handler", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QuickLiveData<T> extends MutableLiveData<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hadLoadHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy handler;

    public QuickLiveData() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>(this) { // from class: com.tencent.mobileqq.ai.QuickLiveData$handler$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QuickLiveData<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Handler invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Handler) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ((QuickLiveData) this.this$0).hadLoadHandler = true;
                    return new Handler(Looper.getMainLooper());
                }
            });
            this.handler = lazy;
        }
    }

    private final Handler e() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QuickLiveData this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.setValue(obj);
    }

    public final void f(final T value, long delayMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, value, Long.valueOf(delayMs));
        } else {
            e().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ai.j
                @Override // java.lang.Runnable
                public final void run() {
                    QuickLiveData.g(QuickLiveData.this, value);
                }
            }, delayMs);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) value);
            return;
        }
        if (this.hadLoadHandler) {
            e().removeCallbacksAndMessages(null);
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            super.setValue(value);
        } else {
            super.postValue(value);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) value);
            return;
        }
        if (this.hadLoadHandler) {
            e().removeCallbacksAndMessages(null);
        }
        super.setValue(value);
    }

    public QuickLiveData(T t16) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            super.setValue(t16);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
        }
    }
}
