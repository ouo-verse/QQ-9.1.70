package com.tencent.mobileqq.aio.troop.api;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.quiblurview.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/troop/api/a;", "", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "b", "()Landroidx/recyclerview/widget/RecyclerView;", "view", "Lcom/tencent/qui/quiblurview/f$b;", "Lcom/tencent/qui/quiblurview/f$b;", "()Lcom/tencent/qui/quiblurview/f$b;", "setDirtyState", "(Lcom/tencent/qui/quiblurview/f$b;)V", "dirtyState", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/qui/quiblurview/f$b;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f.b dirtyState;

    public a(@NotNull RecyclerView view, @NotNull f.b dirtyState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dirtyState, "dirtyState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) dirtyState);
        } else {
            this.view = view;
            this.dirtyState = dirtyState;
        }
    }

    @NotNull
    public final f.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.dirtyState;
    }

    @NotNull
    public final RecyclerView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.view;
    }
}
