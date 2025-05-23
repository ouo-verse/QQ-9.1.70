package com.tencent.qqnt.aio.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.reserve2.huaweidrag.HuaWeiDragMaskVB;
import com.tencent.mobileqq.aio.reserve2.huaweidrag.HuaweiDragExtKt;
import com.tencent.mobileqq.aio.reserve2.mask.TransparentMaskVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.api.IAIOForegroundContainer;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\t0\bR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOForegroundContainerImpl;", "Lcom/tencent/qqnt/aio/api/IAIOForegroundContainer;", "", "isDragSendSwitchOpen", "Lcom/tencent/qqnt/aio/data/a;", "factory", "", "addFactory", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", OperateCustomButton.OPERATE_CREATE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vbFactoryList", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOForegroundContainerImpl implements IAIOForegroundContainer {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<AIOForegroundContainerImpl> instance$delegate;

    @NotNull
    private final ArrayList<com.tencent.qqnt.aio.data.a> vbFactoryList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOForegroundContainerImpl$a;", "", "Lcom/tencent/qqnt/aio/api/impl/AIOForegroundContainerImpl;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/aio/api/impl/AIOForegroundContainerImpl;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.AIOForegroundContainerImpl$a, reason: from kotlin metadata */
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
        public final AIOForegroundContainerImpl a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOForegroundContainerImpl) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (AIOForegroundContainerImpl) AIOForegroundContainerImpl.instance$delegate.getValue();
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
        Lazy<AIOForegroundContainerImpl> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOForegroundContainerImpl$Companion$instance$2.INSTANCE);
        instance$delegate = lazy;
    }

    public AIOForegroundContainerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.vbFactoryList = new ArrayList<>();
        }
    }

    private final boolean isDragSendSwitchOpen() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_drag_send_switch", true);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOForegroundContainer
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
    public final List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.vbFactoryList.size());
        Iterator<T> it = this.vbFactoryList.iterator();
        while (it.hasNext()) {
            com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> create = ((com.tencent.qqnt.aio.data.a) it.next()).create();
            if (create != null) {
                arrayList.add(create);
            }
        }
        ArrayList<com.tencent.qqnt.aio.data.a> injectVBFactoryList = q.f348968a;
        Intrinsics.checkNotNullExpressionValue(injectVBFactoryList, "injectVBFactoryList");
        Iterator<T> it5 = injectVBFactoryList.iterator();
        while (it5.hasNext()) {
            com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> create2 = ((com.tencent.qqnt.aio.data.a) it5.next()).create();
            if (create2 != null) {
                arrayList.add(create2);
            }
        }
        arrayList.add(new TransparentMaskVB());
        if (isDragSendSwitchOpen() || HuaweiDragExtKt.c()) {
            arrayList.add(new HuaWeiDragMaskVB());
        }
        return arrayList;
    }
}
