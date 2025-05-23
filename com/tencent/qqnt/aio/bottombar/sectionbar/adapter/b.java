package com.tencent.qqnt.aio.bottombar.sectionbar.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\"\u001a\u0004\b\u001a\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "", "", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "holder", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "", "f", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "d", "e", h.F, "i", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "Lol3/b;", "k", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/a;", "a", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/a;", "getCallback", "()Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/a;)V", "callback", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "l", "(Lcom/tencent/aio/api/runtime/a;)V", "aioContext", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aioContext;
    }

    public abstract int b();

    public abstract int c();

    public void d(@NotNull MviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    public void e(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public abstract void f(@NotNull RecyclerView.ViewHolder holder, @NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.a model);

    @NotNull
    public abstract RecyclerView.ViewHolder g(@NotNull ViewGroup parent);

    public void h(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public void i(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public final void j(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a aVar = this.callback;
        if (aVar != null) {
            aVar.b(intent);
        }
    }

    public final void k(@NotNull ol3.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(c(), intent);
        }
    }

    public final void l(@Nullable com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.aioContext = aVar;
        }
    }

    public final void m(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.callback = aVar;
        }
    }
}
