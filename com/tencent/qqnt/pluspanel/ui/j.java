package com.tencent.qqnt.pluspanel.ui;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/pluspanel/ui/j;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "b1", "Landroid/view/View;", "root", "d1", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/qqnt/pluspanel/ui/b;", "d", "Lcom/tencent/qqnt/pluspanel/ui/b;", "mExtendPanelLoader", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class j extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList f360611e;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/PlusPanel/Inject_ExtendPanelLoader.yml", version = 1)
    @Nullable
    private b mExtendPanelLoader;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f360611e = arrayList;
        arrayList.add(l61.f.class);
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b1() {
        if (this.mExtendPanelLoader == null) {
            c1();
        }
    }

    private final void d1(View root) {
        FrameLayout frameLayout;
        b1();
        View view = null;
        if (root != null) {
            frameLayout = (FrameLayout) root.findViewById(R.id.uyp);
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            b bVar = this.mExtendPanelLoader;
            if (bVar != null) {
                view = bVar.c(getMContext());
            }
            frameLayout.addView(view);
        }
        b bVar2 = this.mExtendPanelLoader;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @QAutoInitMethod
    public final void c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mExtendPanelLoader = (b) com.tencent.mobileqq.qroute.utils.b.a(f360611e);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<ol3.b, MviUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVM) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        b bVar = this.mExtendPanelLoader;
        if (bVar != null) {
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }
        return new com.tencent.qqnt.pluspanel.logic.f();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View a16 = new com.tencent.qqnt.plus_panel_impl.x2k.a(createViewParams.a(), null, 2, null).a();
        Intrinsics.checkNotNull(a16);
        d1(a16);
        return a16;
    }
}
