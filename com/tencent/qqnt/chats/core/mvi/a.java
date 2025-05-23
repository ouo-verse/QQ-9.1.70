package com.tencent.qqnt.chats.core.mvi;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.base.mvi.a;
import com.tencent.qqnt.base.mvi.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005:\u0001\u001cB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001b\u00a2\u0006\u0004\bC\u0010!J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u001a\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R*\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0014078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00108R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140:8\u0006\u00a2\u0006\f\n\u0004\b+\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000?8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "", "Lcom/tencent/qqnt/chats/core/mvi/BaseFakeVB;", "vb", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "r", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "k", "d", "Lcom/tencent/qqnt/chats/core/uievent/b;", "event", DomainData.DOMAIN_NAME, "userIntent", "o", "(Lcom/tencent/qqnt/base/mvi/b;)V", "l", "Landroidx/lifecycle/LifecycleCoroutineScope;", "a", "Landroidx/lifecycle/LifecycleCoroutineScope;", h.F, "()Landroidx/lifecycle/LifecycleCoroutineScope;", "setScope", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", "scope", "", "b", "Ljava/util/List;", "vbList", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/chats/core/mvi/a$a;", "c", "Lmqq/util/WeakReference;", "f", "()Lmqq/util/WeakReference;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lmqq/util/WeakReference;)V", "listViewModelHandler", "Lcom/tencent/qqnt/chats/api/b;", "Lcom/tencent/qqnt/chats/api/b;", "e", "()Lcom/tencent/qqnt/chats/api/b;", "p", "(Lcom/tencent/qqnt/chats/api/b;)V", "dtReport", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "_uiEvent", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "i", "()Lkotlinx/coroutines/flow/Flow;", "uiEvent", "Landroidx/lifecycle/LiveData;", "j", "()Landroidx/lifecycle/LiveData;", "_newLiveData", "<init>", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a<S extends com.tencent.qqnt.base.mvi.a, I extends b> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LifecycleCoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<BaseFakeVB<S, I>> vbList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<InterfaceC9585a> listViewModelHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.api.b dtReport;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<com.tencent.qqnt.chats.core.uievent.b> _uiEvent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Flow<com.tencent.qqnt.chats.core.uievent.b> uiEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/core/mvi/a$a;", "", "", "title", "contentStr", "leftT", "leftUrl", "rightT", "rightUrl", "", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.mvi.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC9585a {
        void a(@NotNull String title, @NotNull String contentStr, @NotNull String leftT, @NotNull String leftUrl, @NotNull String rightT, @NotNull String rightUrl);
    }

    public a(@NotNull LifecycleCoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope);
            return;
        }
        this.scope = scope;
        this.vbList = new ArrayList();
        this.listViewModelHandler = new WeakReference<>(null);
        Channel<com.tencent.qqnt.chats.core.uievent.b> Channel$default = ChannelKt.Channel$default(0, null, null, 7, null);
        this._uiEvent = Channel$default;
        this.uiEvent = FlowKt.receiveAsFlow(Channel$default);
    }

    public void d(@NotNull BaseFakeVB<S, I> vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) vb5);
            return;
        }
        Intrinsics.checkNotNullParameter(vb5, "vb");
        synchronized (this.vbList) {
            if (!this.vbList.contains(vb5)) {
                this.vbList.add(vb5);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final com.tencent.qqnt.chats.api.b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.chats.api.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.dtReport;
    }

    @NotNull
    public final WeakReference<InterfaceC9585a> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WeakReference) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.listViewModelHandler;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @NotNull
    public final LifecycleCoroutineScope h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LifecycleCoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.scope;
    }

    @NotNull
    public final Flow<com.tencent.qqnt.chats.core.uievent.b> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Flow) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.uiEvent;
    }

    @NotNull
    public abstract LiveData<S> j();

    public void k(@NotNull String jumpUrl, @NotNull BaseQQAppInterface app, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, jumpUrl, app, context);
            return;
        }
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public abstract void l(@NotNull I userIntent);

    public void m(@NotNull BaseFakeVB<S, I> vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) vb5);
            return;
        }
        Intrinsics.checkNotNullParameter(vb5, "vb");
        synchronized (this.vbList) {
            this.vbList.remove(vb5);
        }
    }

    public final void n(@NotNull com.tencent.qqnt.chats.core.uievent.b event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            this._uiEvent.mo2003trySendJP2dKIU(event);
        }
    }

    public final void o(@NotNull I userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) userIntent);
        } else {
            Intrinsics.checkNotNullParameter(userIntent, "userIntent");
            l(userIntent);
        }
    }

    public final void p(@Nullable com.tencent.qqnt.chats.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.dtReport = bVar;
        }
    }

    public final void q(@NotNull WeakReference<InterfaceC9585a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) weakReference);
        } else {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.listViewModelHandler = weakReference;
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }
}
