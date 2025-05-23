package com.tencent.qqnt.aio.api.impl;

import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.api.IGuildAIOForegroundContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/GuildAIOForegroundContainerImpl;", "Lcom/tencent/qqnt/aio/api/IGuildAIOForegroundContainer;", "Lcom/tencent/qqnt/aio/data/a;", "factory", "", "addFactory", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", OperateCustomButton.OPERATE_CREATE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vbFactoryList", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class GuildAIOForegroundContainerImpl implements IGuildAIOForegroundContainer {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<GuildAIOForegroundContainerImpl> instance$delegate;

    @NotNull
    private final ArrayList<com.tencent.qqnt.aio.data.a> vbFactoryList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/GuildAIOForegroundContainerImpl$a;", "", "Lcom/tencent/qqnt/aio/api/impl/GuildAIOForegroundContainerImpl;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/aio/api/impl/GuildAIOForegroundContainerImpl;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.GuildAIOForegroundContainerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final GuildAIOForegroundContainerImpl a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GuildAIOForegroundContainerImpl) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (GuildAIOForegroundContainerImpl) GuildAIOForegroundContainerImpl.instance$delegate.getValue();
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
        Lazy<GuildAIOForegroundContainerImpl> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58142);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(GuildAIOForegroundContainerImpl$Companion$instance$2.INSTANCE);
        instance$delegate = lazy;
    }

    public GuildAIOForegroundContainerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.vbFactoryList = new ArrayList<>();
        }
    }

    @Override // com.tencent.qqnt.aio.api.IGuildAIOForegroundContainer
    public void addFactory(@NotNull com.tencent.qqnt.aio.data.a factory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) factory);
        } else {
            Intrinsics.checkNotNullParameter(factory, "factory");
            this.vbFactoryList.add(factory);
        }
    }

    @NotNull
    public final List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> create(@NotNull ViewGroup rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ArrayList arrayList = new ArrayList(this.vbFactoryList.size());
        Iterator<T> it = this.vbFactoryList.iterator();
        while (it.hasNext()) {
            com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> create = ((com.tencent.qqnt.aio.data.a) it.next()).create();
            if (create != null) {
                arrayList.add(create);
            }
        }
        ArrayList<com.tencent.qqnt.aio.data.a> injectVBFactoryList = x71.a.f447390a;
        Intrinsics.checkNotNullExpressionValue(injectVBFactoryList, "injectVBFactoryList");
        Iterator<T> it5 = injectVBFactoryList.iterator();
        while (it5.hasNext()) {
            com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> create2 = ((com.tencent.qqnt.aio.data.a) it5.next()).create();
            if (create2 != null) {
                arrayList.add(create2);
            }
        }
        return arrayList;
    }
}
