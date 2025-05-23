package com.tencent.mvi.dispatcher;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.log.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u001cB'\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0000J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mvi/dispatcher/b;", "Lcom/tencent/mvi/dispatcher/AIOTask;", "child", "", "j", HippyNestedScrollComponent.PRIORITY_PARENT, "l", h.F, "Landroid/view/View;", "i", "", "e", "Ljava/util/List;", "childrenVBNodes", "f", "Lcom/tencent/mvi/dispatcher/b;", "parentVBNode", "Lcom/tencent/mvi/mvvm/framework/a;", "g", "Lcom/tencent/mvi/mvvm/framework/a;", "k", "()Lcom/tencent/mvi/mvvm/framework/a;", "vb", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "viewGroup", "<init>", "(Lcom/tencent/mvi/mvvm/framework/a;Landroid/view/ViewGroup;)V", "a", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class b extends AIOTask {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f337776i;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<b> childrenVBNodes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b parentVBNode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.mvvm.framework.a<?, ?, ?> vb;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup viewGroup;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mvi/dispatcher/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes21.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f337776i = new a(null);
        }
    }

    public b(@NotNull com.tencent.mvi.mvvm.framework.a<?, ?, ?> vb5, @Nullable ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(vb5, "vb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) vb5, (Object) viewGroup);
            return;
        }
        this.vb = vb5;
        this.viewGroup = viewGroup;
        this.childrenVBNodes = new ArrayList();
    }

    @Override // com.tencent.mvi.dispatcher.AIOTask
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        KeyEvent.Callback callback = this.viewGroup;
        if (callback == null) {
            b bVar = this.parentVBNode;
            Intrinsics.checkNotNull(bVar);
            callback = bVar.vb.getDispatchHost$mvi_debug();
        }
        com.tencent.mvi.mvvm.framework.a<?, ?, ?> aVar = this.vb;
        Context mContext = aVar.getMContext();
        if (callback != null) {
            this.vb.setDispatchHost$mvi_debug(aVar.onCreateView(new com.tencent.mvi.api.help.a(mContext, (ViewGroup) callback)));
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            c.f337783b.a("VBNode", TokenParser.SP + this.vb + " onExecute  spend " + currentTimeMillis2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @MainThread
    @NotNull
    public final View i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Iterator<T> it = this.childrenVBNodes.iterator();
        while (it.hasNext()) {
            View i3 = ((b) it.next()).i();
            if (i3.getParent() == null && (!Intrinsics.areEqual(this.vb.getHostView(), i3))) {
                View hostView = this.vb.getHostView();
                if (hostView != null) {
                    ((ViewGroup) hostView).addView(i3);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
        }
        return this.vb.getHostView();
    }

    public final void j(@NotNull b child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        this.childrenVBNodes.add(child);
        b(child);
    }

    @NotNull
    public final com.tencent.mvi.mvvm.framework.a<?, ?, ?> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mvi.mvvm.framework.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.vb;
    }

    public final void l(@NotNull b parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parentVBNode = parent;
        f();
    }
}
