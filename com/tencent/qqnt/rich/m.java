package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nR'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/rich/m;", "", "Lcom/tencent/qqnt/rich/a;", "handler", "", "a", "", "action", "objects", "d", "", "viewId", "e", "b", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/viewgroup/render/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "renderResult", "I", "mLastViewId", "actionHandlers", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> renderResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mLastViewId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> actionHandlers;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.renderResult = new ArrayList<>();
        this.mLastViewId = -1;
        this.actionHandlers = new ArrayList<>();
    }

    public final void a(@NotNull a handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) handler);
        } else {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.actionHandlers.add(handler);
        }
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mLastViewId;
    }

    @NotNull
    public final ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.renderResult;
    }

    public final void d(@NotNull String action, @Nullable Object objects) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, objects);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = this.actionHandlers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).r0(action, objects);
        }
    }

    public final void e(int viewId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, viewId);
        } else {
            this.mLastViewId = viewId;
        }
    }
}
