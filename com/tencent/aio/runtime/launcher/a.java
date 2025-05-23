package com.tencent.aio.runtime.launcher;

import androidx.activity.result.ActivityResultCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R*\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aio/runtime/launcher/a;", "T", "Landroidx/activity/result/ActivityResultCallback;", "result", "", "onActivityResult", "(Ljava/lang/Object;)V", "a", "Landroidx/activity/result/ActivityResultCallback;", "getRealActivityResult", "()Landroidx/activity/result/ActivityResultCallback;", "setRealActivityResult", "(Landroidx/activity/result/ActivityResultCallback;)V", "realActivityResult", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "callBack", "<init>", "(Landroidx/activity/result/ActivityResultCallback;Lkotlin/jvm/functions/Function0;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a<T> implements ActivityResultCallback<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActivityResultCallback<T> realActivityResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> callBack;

    public a(@Nullable ActivityResultCallback<T> activityResultCallback, @Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activityResultCallback, (Object) function0);
        } else {
            this.realActivityResult = activityResultCallback;
            this.callBack = function0;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(@Nullable T result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) result);
            return;
        }
        ActivityResultCallback<T> activityResultCallback = this.realActivityResult;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(result);
        }
        this.realActivityResult = null;
        Function0<Unit> function0 = this.callBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public /* synthetic */ a(ActivityResultCallback activityResultCallback, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activityResultCallback, (i3 & 2) != 0 ? null : function0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, activityResultCallback, function0, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
