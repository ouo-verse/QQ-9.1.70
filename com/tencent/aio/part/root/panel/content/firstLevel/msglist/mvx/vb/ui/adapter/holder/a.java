package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.list.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0017\u0012\u000e\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/b;", "Lcom/tencent/aio/api/list/m;", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/c;", "listener", "", "p", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/c;)V", "onViewRecycled", "", "l", "k", "g", "Ljava/lang/ref/WeakReference;", "E", "Ljava/lang/ref/WeakReference;", "recycledListener", "Lcom/tencent/aio/base/mvvm/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/aio/base/mvvm/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/aio/base/mvvm/a;", "vb", "<init>", "(Lcom/tencent/aio/base/mvvm/a;)V", "G", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends b implements m {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final C0644a G;

    /* renamed from: E, reason: from kotlin metadata */
    private WeakReference<c> recycledListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.base.mvvm.a<?, ?> vb;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0644a {
        static IPatchRedirector $redirector_;

        C0644a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ C0644a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            G = new C0644a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.aio.base.mvvm.a<?, ?> vb5) {
        super(vb5.getHostView());
        Intrinsics.checkNotNullParameter(vb5, "vb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) vb5);
        } else {
            this.vb = vb5;
        }
    }

    private final m o() {
        g mUIModel = this.vb.getMUIModel();
        if (!(mUIModel instanceof m)) {
            mUIModel = null;
        }
        return (m) mUIModel;
    }

    @Override // com.tencent.aio.api.list.m
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        m o16 = o();
        if (o16 != null) {
            o16.g();
        }
    }

    @Override // com.tencent.aio.api.list.m
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        m o16 = o();
        if (o16 != null) {
            o16.k();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.b
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        FrameworkVM mUIModel = this.vb.getMUIModel();
        if (mUIModel != null) {
            return ((com.tencent.aio.api.list.b) mUIModel).l();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.api.list.BaseMessageCellVM<out com.tencent.mvi.base.mvi.MviIntent, out com.tencent.mvi.base.mvi.MviUIState>");
    }

    @NotNull
    public final com.tencent.aio.base.mvvm.a<?, ?> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.vb;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.b
    public void onViewRecycled() {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        WeakReference<c> weakReference = this.recycledListener;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            cVar.U(this);
        }
    }

    public final void p(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener);
            return;
        }
        if (listener == null) {
            this.recycledListener = null;
        }
        this.recycledListener = new WeakReference<>(listener);
    }
}
