package com.tencent.mobileqq.aio.foreground;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import at.d;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.utils.api.IPokeMessageApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.impl.AIOForegroundContainerImpl;
import com.tencent.qqnt.aio.reserve2.Reserve2Event;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J&\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00010\r2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u001a\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/foreground/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "Lcom/tencent/qqnt/aio/reserve2/Reserve2Event$PopupWindowShowAtLocation;", "state", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "b1", "c1", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "e", "Lcom/tencent/aio/base/mvvm/a;", "pokeAnimationVB", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends com.tencent.aio.base.mvvm.a<d, Reserve2UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> pokeAnimationVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/foreground/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.foreground.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46464);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d1(Reserve2Event.PopupWindowShowAtLocation state) {
        PopupWindow b16 = state.b();
        RelativeLayout relativeLayout = this.container;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            relativeLayout = null;
        }
        b16.showAtLocation(relativeLayout, state.a(), state.c(), state.d());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<d, Reserve2UIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Reserve2UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof Reserve2Event.PopupWindowShowAtLocation) {
            d1((Reserve2Event.PopupWindowShowAtLocation) state);
            return;
        }
        if ((state instanceof Reserve2Event.AddPokeAnimationView) && this.pokeAnimationVB == null) {
            IPokeMessageApi iPokeMessageApi = (IPokeMessageApi) QRoute.api(IPokeMessageApi.class);
            RelativeLayout relativeLayout = this.container;
            Integer num = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                relativeLayout = null;
            }
            this.pokeAnimationVB = iPokeMessageApi.getPokeAnimationVB(relativeLayout);
            if (QLog.isDevelopLevel()) {
                com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar = this.pokeAnimationVB;
                if (aVar != null) {
                    num = Integer.valueOf(aVar.hashCode());
                }
                QLog.d("AIOForegroundContainerVB", 1, "AddPokeAnimationView " + num);
            }
            com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> aVar2 = this.pokeAnimationVB;
            Intrinsics.checkNotNull(aVar2);
            addChildVB(aVar2);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return AIOForegroundContainerImpl.INSTANCE.a().create();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        RelativeLayout relativeLayout = new RelativeLayout(createViewParams.a());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.container = relativeLayout;
        return relativeLayout;
    }
}
