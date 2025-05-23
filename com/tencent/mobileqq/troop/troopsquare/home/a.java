package com.tencent.mobileqq.troop.troopsquare.home;

import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u001d\b\u0016\u0012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001\u00a2\u0006\u0004\b\u000e\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/a;", "Lcom/tencent/mobileqq/troop/troopsquare/home/d;", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "", "a", "", "velocityX", "velocityY", "c", "", "Ljava/util/List;", "checkers", "<init>", "(Ljava/util/List;)V", "", "([Lcom/tencent/mobileqq/troop/troopsquare/home/d;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> checkers;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull List<? extends d> checkers) {
        Intrinsics.checkNotNullParameter(checkers, "checkers");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.checkers = checkers;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) checkers);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.home.d
    public boolean a(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) startEvent, (Object) nowEvent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(startEvent, "startEvent");
        Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
        Iterator<d> it = this.checkers.iterator();
        while (it.hasNext()) {
            if (!it.next().a(startEvent, nowEvent)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.home.d
    public boolean c(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, startEvent, nowEvent, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(startEvent, "startEvent");
        Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
        Iterator<d> it = this.checkers.iterator();
        while (it.hasNext()) {
            if (!it.next().c(startEvent, nowEvent, velocityX, velocityY)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(@NotNull d... checkers) {
        this((List<? extends d>) r0);
        List asList;
        Intrinsics.checkNotNullParameter(checkers, "checkers");
        asList = ArraysKt___ArraysJvmKt.asList(checkers);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkers);
    }
}
