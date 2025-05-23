package com.tencent.mobileqq.guild.channellist.process;

import androidx.annotation.UiThread;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.channellist.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\tB#\u0012\u001a\u0010\u0017\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00150#\"\u0006\u0012\u0002\b\u00030\u0015\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u0013\u0010\u000b\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001f8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/Processors;", "", "", "account", "", "f", "b", "c", "guildId", "a", "g", h.F, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/guild/channellist/c;", VideoTemplateParser.ITEM_LIST, "", "isFirstTimeUpdate", "e", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/guild/channellist/process/a;", "Ljava/util/List;", "processors", "Z", "isActivate", "isClear", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "d", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/channellist/process/b;", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "", "<init>", "([Lcom/tencent/mobileqq/guild/channellist/process/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class Processors {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a<?>> processors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isActivate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isClear;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RuntimeServiceHolder serviceHolder;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/Processors$a;", "", "Lcom/tencent/mobileqq/guild/channellist/process/Processors;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.process.Processors$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Processors a() {
            return new Processors(new GuildSummaryProcessor(), new AppChnnPreInfoProcessor());
        }

        Companion() {
        }
    }

    public Processors(@NotNull a<?>... processors) {
        List<a<?>> mutableList;
        Intrinsics.checkNotNullParameter(processors, "processors");
        mutableList = ArraysKt___ArraysKt.toMutableList(processors);
        this.processors = mutableList;
        this.serviceHolder = new RuntimeServiceHolder();
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        for (a<?> aVar : processors) {
            aVar.q(l3, this.serviceHolder);
        }
    }

    @UiThread
    public final void a(@NotNull String guildId) {
        boolean z16;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger.f235387a.d().i("Processor", 1, "activateGuild(" + guildId + ")");
        if (guildId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            c();
        }
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.c(guildId);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "exception for activateGuild(" + guildId + ")";
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Processor", 1, (String) it5.next(), m479exceptionOrNullimpl);
                }
            }
        }
        if (!z16) {
            b();
        }
    }

    @UiThread
    public final void b() {
        int collectionSizeOrDefault;
        Object m476constructorimpl;
        if (this.isActivate) {
            Logger.f235387a.d().i("Processor", 1, "activate() is already called");
            return;
        }
        this.isActivate = true;
        List<a<?>> list = this.processors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                String name = aVar.getName();
                long currentTimeMillis = System.currentTimeMillis();
                aVar.b();
                m476constructorimpl = Result.m476constructorimpl(TuplesKt.to(name, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("exception for activate()");
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Processor", 1, (String) it5.next(), m479exceptionOrNullimpl);
                }
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            Pair pair = (Pair) m476constructorimpl;
            if (pair == null) {
                pair = TuplesKt.to(aVar.getName(), Long.MAX_VALUE);
            }
            arrayList.add(pair);
        }
        Logger.f235387a.d().i("Processor", 1, "activate() costs: " + arrayList);
    }

    @UiThread
    public final void c() {
        Object m476constructorimpl;
        if (!this.isActivate) {
            Logger.f235387a.d().i("Processor", 1, "deactivate() is already called");
            return;
        }
        this.isActivate = false;
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.e();
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("exception for deactivate()");
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Processor", 1, (String) it5.next(), m479exceptionOrNullimpl);
                }
            }
        }
    }

    @NotNull
    public final Flow<ItemsProcessEvent<?>> d() {
        int collectionSizeOrDefault;
        List<a<?>> list = this.processors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).g());
        }
        return FlowKt.merge(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0075 -> B:12:0x0077). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(@NotNull List<? extends c> list, boolean z16, @NotNull Continuation<? super Unit> continuation) {
        Processors$notifyItemList$1 processors$notifyItemList$1;
        Object coroutine_suspended;
        int i3;
        Processors processors;
        boolean z17;
        Iterator it;
        Object m476constructorimpl;
        boolean z18;
        if (continuation instanceof Processors$notifyItemList$1) {
            processors$notifyItemList$1 = (Processors$notifyItemList$1) continuation;
            int i16 = processors$notifyItemList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                processors$notifyItemList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = processors$notifyItemList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = processors$notifyItemList$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        boolean z19 = processors$notifyItemList$1.Z$0;
                        it = (Iterator) processors$notifyItemList$1.L$2;
                        List<? extends c> list2 = (List) processors$notifyItemList$1.L$1;
                        processors = (Processors) processors$notifyItemList$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th5) {
                            Result.Companion companion = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                        Processors$notifyItemList$1 processors$notifyItemList$12 = processors$notifyItemList$1;
                        boolean z26 = z19;
                        list = list2;
                        Object obj2 = coroutine_suspended;
                        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                        if (m479exceptionOrNullimpl != null) {
                            Logger logger = Logger.f235387a;
                            Logger.b bVar = new Logger.b();
                            bVar.a().add("exception for notifyItemList()");
                            Iterator<T> it5 = bVar.a().iterator();
                            while (it5.hasNext()) {
                                Logger.f235387a.d().e("Processor", 1, (String) it5.next(), m479exceptionOrNullimpl);
                            }
                        }
                        z17 = z26;
                        processors$notifyItemList$1 = processors$notifyItemList$12;
                        coroutine_suspended = obj2;
                        if (it.hasNext()) {
                            a aVar = (a) it.next();
                            try {
                            } catch (Throwable th6) {
                                list2 = list;
                                z19 = z17;
                                Result.Companion companion2 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                            }
                            Result.Companion companion3 = Result.INSTANCE;
                            if (z17) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            processors$notifyItemList$1.L$0 = processors;
                            processors$notifyItemList$1.L$1 = list;
                            processors$notifyItemList$1.L$2 = it;
                            processors$notifyItemList$1.Z$0 = z17;
                            processors$notifyItemList$1.label = 1;
                            if (aVar.j(list, z18, processors$notifyItemList$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list2 = list;
                            z19 = z17;
                            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                            Processors$notifyItemList$1 processors$notifyItemList$122 = processors$notifyItemList$1;
                            boolean z262 = z19;
                            list = list2;
                            Object obj22 = coroutine_suspended;
                            Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl2 != null) {
                            }
                            z17 = z262;
                            processors$notifyItemList$1 = processors$notifyItemList$122;
                            coroutine_suspended = obj22;
                            if (it.hasNext()) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    processors = this;
                    z17 = z16;
                    it = this.processors.iterator();
                    if (it.hasNext()) {
                    }
                }
            }
        }
        processors$notifyItemList$1 = new Processors$notifyItemList$1(this, continuation);
        Object obj3 = processors$notifyItemList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = processors$notifyItemList$1.label;
        if (i3 == 0) {
        }
    }

    public final void f(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().i("Processor", 1, "onAccountChanged(" + account + ")");
        c();
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        this.serviceHolder = new RuntimeServiceHolder();
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((a) it.next()).q(l3, this.serviceHolder);
        }
        b();
    }

    public final void g() {
        Logger.f235387a.d().i("Processor", 1, "onClear");
        c();
        this.processors.clear();
        this.serviceHolder = new RuntimeServiceHolder();
        this.isClear = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0061 -> B:12:0x0064). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull Continuation<? super Unit> continuation) {
        Processors$resetReplayCache$1 processors$resetReplayCache$1;
        Object coroutine_suspended;
        int i3;
        Processors processors;
        Iterator it;
        Object m476constructorimpl;
        if (continuation instanceof Processors$resetReplayCache$1) {
            processors$resetReplayCache$1 = (Processors$resetReplayCache$1) continuation;
            int i16 = processors$resetReplayCache$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                processors$resetReplayCache$1.label = i16 - Integer.MIN_VALUE;
                Object obj = processors$resetReplayCache$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = processors$resetReplayCache$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        it = (Iterator) processors$resetReplayCache$1.L$1;
                        processors = (Processors) processors$resetReplayCache$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th5) {
                            Result.Companion companion = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                        if (m479exceptionOrNullimpl != null) {
                            Logger logger = Logger.f235387a;
                            Logger.b bVar = new Logger.b();
                            bVar.a().add("exception for resetReplayCache");
                            Iterator<T> it5 = bVar.a().iterator();
                            while (it5.hasNext()) {
                                Logger.f235387a.d().e("Processor", 1, (String) it5.next(), m479exceptionOrNullimpl);
                            }
                        }
                        if (it.hasNext()) {
                            a aVar = (a) it.next();
                            Result.Companion companion2 = Result.INSTANCE;
                            processors$resetReplayCache$1.L$0 = processors;
                            processors$resetReplayCache$1.L$1 = it;
                            processors$resetReplayCache$1.label = 1;
                            if (aVar.o(processors$resetReplayCache$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                            Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl2 != null) {
                            }
                            if (it.hasNext()) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    processors = this;
                    it = this.processors.iterator();
                    if (it.hasNext()) {
                    }
                }
            }
        }
        processors$resetReplayCache$1 = new Processors$resetReplayCache$1(this, continuation);
        Object obj2 = processors$resetReplayCache$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = processors$resetReplayCache$1.label;
        if (i3 == 0) {
        }
    }
}
