package com.tencent.qqnt.chathistory.ui.category.title;

import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.util.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u001f\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/title/TitleRightUIProcessor;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "Landroid/view/View;", "gd", "u", "", "enable", "", "setEnable", "", "rightContent", "Landroid/view/View$OnClickListener;", "clickListener", "f3", "k8", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "e", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "delegateOwner", "delegate", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/qqnt/chathistory/ui/category/c;Lcom/tencent/qqnt/chathistory/ui/category/c$b;)V", h.F, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TitleRightUIProcessor implements c.b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f353385h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c delegateOwner;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c.b f353388f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/title/TitleRightUIProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f353385h = new a(null);
        }
    }

    public TitleRightUIProcessor(@NotNull LifecycleOwner lifecycleOwner, @NotNull c delegateOwner, @NotNull c.b delegate) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(delegateOwner, "delegateOwner");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, lifecycleOwner, delegateOwner, delegate);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        this.delegateOwner = delegateOwner;
        this.f353388f = delegate;
        delegateOwner.y5(new WeakReference<>(delegate));
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.tencent.qqnt.chathistory.ui.category.title.TitleRightUIProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TitleRightUIProcessor.this);
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                b.a(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public void onDestroy(@NotNull LifecycleOwner owner) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) owner);
                    return;
                }
                Intrinsics.checkNotNullParameter(owner, "owner");
                b.b(this, owner);
                TitleRightUIProcessor.this.lifecycleOwner.getLifecycle().removeObserver(this);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public void onPause(@NotNull LifecycleOwner owner) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) owner);
                    return;
                }
                Intrinsics.checkNotNullParameter(owner, "owner");
                b.c(this, owner);
                TitleRightUIProcessor.this.f3(null, null);
                TitleRightUIProcessor.this.delegateOwner.ff();
                d.f354054a.a("TitleRightUIProcessor", "onPause  " + owner + " ");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public void onResume(@NotNull LifecycleOwner owner) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) owner);
                    return;
                }
                Intrinsics.checkNotNullParameter(owner, "owner");
                b.d(this, owner);
                TitleRightUIProcessor.this.delegateOwner.t6();
                d.f354054a.a("TitleRightUIProcessor", "onResume  " + owner + " ");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                b.e(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                b.f(this, lifecycleOwner2);
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    public void f3(@Nullable String rightContent, @Nullable View.OnClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rightContent, (Object) clickListener);
        } else {
            this.f353388f.f3(rightContent, clickListener);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    @Nullable
    public View gd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f353388f.gd();
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    public void k8(@Nullable String rightContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rightContent);
        } else {
            this.f353388f.k8(rightContent);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    public void setEnable(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, enable);
        } else {
            this.f353388f.setEnable(enable);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c.b
    @Nullable
    public View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f353388f.u();
    }
}
