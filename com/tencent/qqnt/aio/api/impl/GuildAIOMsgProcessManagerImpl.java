package com.tencent.qqnt.aio.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.api.IGuildAIOMsgProcessManager;
import com.tencent.qqnt.aio.data.AIOMsgProcessorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/GuildAIOMsgProcessManagerImpl;", "Lcom/tencent/qqnt/aio/api/IGuildAIOMsgProcessManager;", "Lcom/tencent/qqnt/aio/data/AIOMsgProcessorFactory;", "processor", "", "addAIOMsgProcessorFactory", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", OperateCustomButton.OPERATE_CREATE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "processorFactoryList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "<init>", "()V", "Companion", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class GuildAIOMsgProcessManagerImpl implements IGuildAIOMsgProcessManager {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<GuildAIOMsgProcessManagerImpl> instance$delegate;

    @NotNull
    private final CopyOnWriteArrayList<AIOMsgProcessorFactory> processorFactoryList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/GuildAIOMsgProcessManagerImpl$a;", "", "Lcom/tencent/qqnt/aio/api/impl/GuildAIOMsgProcessManagerImpl;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/aio/api/impl/GuildAIOMsgProcessManagerImpl;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.GuildAIOMsgProcessManagerImpl$a, reason: from kotlin metadata */
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
        public final GuildAIOMsgProcessManagerImpl a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GuildAIOMsgProcessManagerImpl) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (GuildAIOMsgProcessManagerImpl) GuildAIOMsgProcessManagerImpl.instance$delegate.getValue();
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
        Lazy<GuildAIOMsgProcessManagerImpl> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(GuildAIOMsgProcessManagerImpl$Companion$instance$2.INSTANCE);
        instance$delegate = lazy;
    }

    public GuildAIOMsgProcessManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.processorFactoryList = new CopyOnWriteArrayList<>();
        }
    }

    @Override // com.tencent.qqnt.aio.api.IGuildAIOMsgProcessManager
    public void addAIOMsgProcessorFactory(@NotNull AIOMsgProcessorFactory processor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) processor);
        } else {
            Intrinsics.checkNotNullParameter(processor, "processor");
            this.processorFactoryList.add(processor);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IGuildAIOMsgProcessManager
    @NotNull
    public List<AbsAIOMsgProcessor> create(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) scope);
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.processorFactoryList.iterator();
        while (it.hasNext()) {
            arrayList.add(((AIOMsgProcessorFactory) it.next()).create(aioContext, scope));
        }
        ArrayList<AIOMsgProcessorFactory> injectProcessorFactoryList = x71.d.f447392a;
        Intrinsics.checkNotNullExpressionValue(injectProcessorFactoryList, "injectProcessorFactoryList");
        Iterator<T> it5 = injectProcessorFactoryList.iterator();
        while (it5.hasNext()) {
            arrayList.add(((AIOMsgProcessorFactory) it5.next()).create(aioContext, scope));
        }
        return arrayList;
    }
}
