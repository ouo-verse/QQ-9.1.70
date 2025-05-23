package com.tencent.aio.base.mvvm;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.base.mvvm.recycler.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 (*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0005:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0017J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR6\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "handleCreateVM", "Landroid/view/View;", "getHostView", "Lcom/tencent/mvi/mvvm/BaseVM;", "mUIModel", "afterCreateVM", "destroy", "", "optLiveData", "mAIOContext", "Lcom/tencent/aio/api/runtime/a;", "getMAIOContext$sdk_debug", "()Lcom/tencent/aio/api/runtime/a;", "setMAIOContext$sdk_debug", "(Lcom/tencent/aio/api/runtime/a;)V", "Lcom/tencent/aio/base/mvvm/recycler/c;", "vmHost", "Lcom/tencent/aio/base/mvvm/recycler/c;", "resume", "Z", "hostView", "Landroid/view/View;", "Lnl3/a;", "mVmIVMProvider", "Lnl3/a;", "getMVmIVMProvider", "()Lnl3/a;", "setMVmIVMProvider", "(Lnl3/a;)V", "<init>", "()V", "Companion", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class a<I extends ol3.b, S extends MviUIState> extends BaseVB<I, S, com.tencent.aio.api.runtime.a> {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final C0624a Companion;

    @Deprecated
    @NotNull
    public static final String TAG = "AIOBaseVB";
    private View hostView;

    @Nullable
    private com.tencent.aio.api.runtime.a mAIOContext;

    @Nullable
    private nl3.a<I, S, com.tencent.aio.api.runtime.a> mVmIVMProvider;
    private boolean resume;
    private c vmHost;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/base/mvvm/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.base.mvvm.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0624a {
        static IPatchRedirector $redirector_;

        C0624a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ C0624a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aio/base/mvvm/a$b", "Lnl3/a;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mvi/mvvm/BaseVM;", "a", "mUIModel", "", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b implements nl3.a<I, S, com.tencent.aio.api.runtime.a> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) a.this);
            }
        }

        @Override // nl3.a
        @Nullable
        public BaseVM<I, S, com.tencent.aio.api.runtime.a> a() {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                c cVar = a.this.vmHost;
                Object obj2 = null;
                if (cVar != null) {
                    obj = cVar.b();
                } else {
                    obj = null;
                }
                if (obj instanceof com.tencent.aio.base.mvvm.b) {
                    obj2 = obj;
                }
                com.tencent.aio.base.mvvm.b bVar = (com.tencent.aio.base.mvvm.b) obj2;
                if (bVar != null) {
                    a.this.resume = true;
                    if (com.tencent.aio.base.a.f69150c.a()) {
                        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
                        C0624a unused = a.Companion;
                        aVar.d(a.TAG, TokenParser.SP + a.this + " \u8bfb\u53d6\u7f13\u5b58 " + bVar);
                        return bVar;
                    }
                    return bVar;
                }
                return (BaseVM<I, S, com.tencent.aio.api.runtime.a>) a.this.createVM();
            }
            return (BaseVM) iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // nl3.a
        public void b(@Nullable BaseVM<I, S, com.tencent.aio.api.runtime.a> mUIModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mUIModel);
                return;
            }
            if (!(mUIModel instanceof com.tencent.aio.base.mvvm.b)) {
                mUIModel = null;
            }
            com.tencent.aio.base.mvvm.b bVar = (com.tencent.aio.base.mvvm.b) mUIModel;
            if (bVar != null) {
                bVar.create();
                bVar.onCreate((com.tencent.aio.api.runtime.a) bVar.getMContext(), a.this.resume);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            Companion = new C0624a(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mVmIVMProvider = new b();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @CallSuper
    public void afterCreateVM(@Nullable BaseVM<I, S, com.tencent.aio.api.runtime.a> mUIModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        c cVar = this.vmHost;
        if (cVar != null && mUIModel != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.a(mUIModel);
        }
        this.vmHost = c.INSTANCE.b(mUIModel);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.destroy();
            this.mAIOContext = null;
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public View getHostView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return super.getHostView();
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a getMAIOContext$sdk_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mAIOContext;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public final nl3.a<I, S, com.tencent.aio.api.runtime.a> getMVmIVMProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (nl3.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mVmIVMProvider;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public boolean optLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Intrinsics.checkNotNull(aVar);
        return com.tencent.aio.runtime.a.a(aVar).t();
    }

    public final void setMAIOContext$sdk_debug(@Nullable com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.mAIOContext = aVar;
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public final void setMVmIVMProvider(@Nullable nl3.a<I, S, com.tencent.aio.api.runtime.a> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.mVmIVMProvider = aVar;
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void handleCreateVM(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAIOContext = context;
        super.handleCreateVM((a<I, S>) context);
    }
}
