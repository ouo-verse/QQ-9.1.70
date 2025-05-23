package com.tencent.mobileqq.troop.troopsquare.home;

import android.view.MotionEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J(\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/c;", "Lcom/tencent/mobileqq/troop/troopsquare/home/d;", "", HippyTKDListViewAdapter.X, "y", "", "b", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "a", "velocityX", "velocityY", "c", "", "D", "angle", "<init>", "(D)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final double angle;

    public c(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16));
        } else {
            this.angle = d16;
        }
    }

    private final boolean b(float x16, float y16) {
        double abs = Math.abs(Math.atan2(y16, x16) - Math.toRadians(this.angle)) % 6.283185307179586d;
        if (abs >= 0.5235987755982988d && abs <= 5.759586531581287d) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.home.d
    public boolean a(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) startEvent, (Object) nowEvent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(startEvent, "startEvent");
        Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
        return b(nowEvent.getX() - startEvent.getX(), nowEvent.getY() - startEvent.getY());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.home.d
    public boolean c(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, startEvent, nowEvent, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(startEvent, "startEvent");
        Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
        if (!b(velocityX, velocityX) && !b(nowEvent.getX() - startEvent.getX(), nowEvent.getY() - startEvent.getY())) {
            return false;
        }
        return true;
    }
}
