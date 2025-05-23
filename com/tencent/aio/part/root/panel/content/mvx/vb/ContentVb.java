package com.tencent.aio.part.root.panel.content.mvx.vb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aio.api.factory.d;
import com.tencent.aio.api.factory.e;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.aio.part.root.panel.content.firstLevel.mvx.vb.FirstLevelVB;
import com.tencent.aio.part.root.panel.content.thirdLevel.mvx.vb.ThirdLevelVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Landroid/view/View;", "hostView", "", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "mUIModel", "", "afterCreateVM", "", "d", "Z", "loadThird", "e", "loadReserve1", "f", "loadReserve2", h.F, "useDispatcher", "<init>", "(Z)V", "i", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ContentVb extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f69693i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean loadThird;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean loadReserve1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean loadReserve2;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean useDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/mvx/vb/ContentVb$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f69693i = new a(null);
        }
    }

    public ContentVb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.useDispatcher = z16;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<ol3.b, MviUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.api.runtime.a mAIOContext$sdk_debug;
        com.tencent.mvi.api.runtime.a a16;
        e eVar;
        T t16;
        com.tencent.aio.api.runtime.a mAIOContext$sdk_debug2;
        com.tencent.mvi.api.runtime.a a17;
        d dVar;
        com.tencent.aio.api.runtime.a mAIOContext$sdk_debug3;
        com.tencent.mvi.api.runtime.a a18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (!this.useDispatcher) {
            return;
        }
        if (!this.loadThird && (mAIOContext$sdk_debug3 = getMAIOContext$sdk_debug()) != null && (a18 = mAIOContext$sdk_debug3.a()) != null) {
            a18.f(new Runnable() { // from class: com.tencent.aio.part.root.panel.content.mvx.vb.ContentVb$afterCreateVM$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ContentVb.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    } else {
                        ContentVb.this.addChildVB(new ThirdLevelVB());
                        ContentVb.this.loadThird = true;
                    }
                }
            });
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve2UIState> aVar = null;
        objectRef.element = null;
        if (!this.loadReserve1) {
            com.tencent.mvi.runtime.strategy.b mStrategyService = getMStrategyService();
            if (mStrategyService != null && (dVar = (d) mStrategyService.b(d.class)) != null) {
                t16 = dVar.a();
            } else {
                t16 = 0;
            }
            objectRef.element = t16;
            if (t16 != 0 && (mAIOContext$sdk_debug2 = getMAIOContext$sdk_debug()) != null && (a17 = mAIOContext$sdk_debug2.a()) != null) {
                a17.f(new Runnable(objectRef) { // from class: com.tencent.aio.part.root.panel.content.mvx.vb.ContentVb$afterCreateVM$2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Ref.ObjectRef f69698d;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f69698d = objectRef;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ContentVb.this, (Object) objectRef);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this);
                        } else {
                            ContentVb.this.addChildVB((com.tencent.aio.base.mvvm.a) this.f69698d.element, 1);
                            ContentVb.this.loadReserve1 = true;
                        }
                    }
                });
            }
        }
        if (!this.loadReserve2) {
            com.tencent.mvi.runtime.strategy.b mStrategyService2 = getMStrategyService();
            if (mStrategyService2 != null && (eVar = (e) mStrategyService2.b(e.class)) != null) {
                aVar = eVar.a();
            }
            if (aVar != null && (mAIOContext$sdk_debug = getMAIOContext$sdk_debug()) != null && (a16 = mAIOContext$sdk_debug.a()) != null) {
                a16.f(new Runnable(aVar, objectRef) { // from class: com.tencent.aio.part.root.panel.content.mvx.vb.ContentVb$afterCreateVM$3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.aio.base.mvvm.a f69699d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Ref.ObjectRef f69700e;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f69699d = aVar;
                        this.f69700e = objectRef;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, ContentVb.this, aVar, objectRef);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this);
                            return;
                        }
                        ContentVb contentVb = ContentVb.this;
                        com.tencent.aio.base.mvvm.a aVar2 = this.f69699d;
                        if (((com.tencent.aio.base.mvvm.a) this.f69700e.element) == null) {
                            i3 = 2;
                        } else {
                            i3 = 3;
                        }
                        contentVb.addChildVB(aVar2, i3);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        e eVar;
        com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve2UIState> a16;
        d dVar;
        com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve1UIState> a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FirstLevelVB());
        if (!this.useDispatcher || isPreload()) {
            com.tencent.mvi.runtime.strategy.b mStrategyService = getMStrategyService();
            if (mStrategyService != null && (dVar = (d) mStrategyService.b(d.class)) != null && (a17 = dVar.a()) != null) {
                arrayList.add(a17);
            }
            arrayList.add(new ThirdLevelVB());
            com.tencent.mvi.runtime.strategy.b mStrategyService2 = getMStrategyService();
            if (mStrategyService2 != null && (eVar = (e) mStrategyService2.b(e.class)) != null && (a16 = eVar.a()) != null) {
                arrayList.add(a16);
            }
            this.loadThird = true;
            this.loadReserve1 = true;
            this.loadReserve2 = true;
        }
        return arrayList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public /* synthetic */ ContentVb(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
