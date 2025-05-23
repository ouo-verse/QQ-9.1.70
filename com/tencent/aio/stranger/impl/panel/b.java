package com.tencent.aio.stranger.impl.panel;

import android.view.View;
import com.tencent.aio.api.factory.i;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOUniversalPanelVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/stranger/impl/panel/b;", "Lcom/tencent/aio/api/factory/i;", "", "panelId", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class b implements i {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aio/stranger/impl/panel/b$a", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class a extends com.tencent.aio.base.mvvm.a<at.c, PanelUIState> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.mvvm.b
        @NotNull
        public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
            }
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            return new View(createViewParams.a());
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.factory.i
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a(int panelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this, panelId);
        }
        if (panelId != 1001) {
            if (panelId != 1003) {
                return new a();
            }
            return ((IAIOUniversalPanelVB) QRoute.api(IAIOUniversalPanelVB.class)).getPhotoPanelVB();
        }
        return ((IAIOUniversalPanelVB) QRoute.api(IAIOUniversalPanelVB.class)).getEmojiPanelVB();
    }
}
