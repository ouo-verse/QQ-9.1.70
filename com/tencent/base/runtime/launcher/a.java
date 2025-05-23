package com.tencent.base.runtime.launcher;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/base/runtime/launcher/a;", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "result", "", "a", "Landroidx/activity/result/ActivityResultCallback;", "getRealActivityResult", "()Landroidx/activity/result/ActivityResultCallback;", "setRealActivityResult", "(Landroidx/activity/result/ActivityResultCallback;)V", "realActivityResult", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "callBack", "<init>", "(Landroidx/activity/result/ActivityResultCallback;Lkotlin/jvm/functions/Function0;)V", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class a implements ActivityResultCallback<ActivityResult> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActivityResultCallback<ActivityResult> realActivityResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function0<Unit> callBack;

    public a(@Nullable ActivityResultCallback<ActivityResult> activityResultCallback, @Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activityResultCallback, (Object) function0);
        } else {
            this.realActivityResult = activityResultCallback;
            this.callBack = function0;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onActivityResult(@Nullable ActivityResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) result);
            return;
        }
        ActivityResultCallback<ActivityResult> activityResultCallback = this.realActivityResult;
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
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, activityResultCallback, function0, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
