package com.tencent.mobileqq.sharepanel.channel.handler;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.channel.handler.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007R,\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/e;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/f;", "T", "", "param", "", "c", "(Lcom/tencent/mobileqq/sharepanel/channel/handler/f;)V", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "a", "Lmqq/util/WeakReference;", "getActivityRef", "()Lmqq/util/WeakReference;", "d", "(Lmqq/util/WeakReference;)V", "activityRef", "Lcom/tencent/mobileqq/sharepanel/channel/handler/a;", "b", "Lcom/tencent/mobileqq/sharepanel/channel/handler/a;", "()Lcom/tencent/mobileqq/sharepanel/channel/handler/a;", "e", "(Lcom/tencent/mobileqq/sharepanel/channel/handler/a;)V", "callback", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "()V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class e<T extends f> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public a callback;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Activity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Activity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        a aVar = this.callback;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        return null;
    }

    public abstract void c(@NotNull T param);

    public final void d(@Nullable WeakReference<Activity> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference);
        } else {
            this.activityRef = weakReference;
        }
    }

    public final void e(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.callback = aVar;
        }
    }
}
