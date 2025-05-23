package com.tencent.mobileqq.troop.troopsquare.home;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/g;", "Lcom/tencent/mobileqq/troop/troopsquare/home/d;", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "", "a", "", "velocityX", "velocityY", "c", "Landroid/view/View;", "Landroid/view/View;", "starting", "Landroid/graphics/Rect;", "b", "Landroid/graphics/Rect;", "startingHitRect", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class g implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View starting;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect startingHitRect;

    public g(@NotNull View starting) {
        Intrinsics.checkNotNullParameter(starting, "starting");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) starting);
        } else {
            this.starting = starting;
            this.startingHitRect = new Rect();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.home.d
    public boolean a(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) startEvent, (Object) nowEvent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(startEvent, "startEvent");
        Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
        this.starting.getHitRect(this.startingHitRect);
        return this.startingHitRect.contains((int) startEvent.getX(), (int) startEvent.getY());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.home.d
    public boolean c(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, startEvent, nowEvent, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(startEvent, "startEvent");
        Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
        this.starting.getHitRect(this.startingHitRect);
        return this.startingHitRect.contains((int) startEvent.getX(), (int) startEvent.getY());
    }
}
