package com.tencent.mobileqq.aio.notifyservice.input;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.notifyservice.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J&\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/notifyservice/input/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<at.a, InputUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return c.f193012a.a();
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
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.container = frameLayout;
        return frameLayout;
    }
}
