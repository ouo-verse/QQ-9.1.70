package com.tencent.mobileqq.guild.home.viewmodels.header.processors;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.home.viewmodels.header.f;
import com.tencent.mobileqq.guild.home.viewmodels.header.processors.biz.GuildHomeCommonHeaderBarsUpdateProcessor;
import com.tencent.mobileqq.guild.util.Logger;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB#\u0012\u001a\u0010\u000f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\u001b\"\u0006\u0012\u0002\b\u00030\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007R\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/b;", "", "", "account", "", "d", "guildId", "g", "f", "e", "b", "a", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;", "Ljava/util/List;", "processors", "", "Z", "isActivate", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "c", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "", "<init>", "([Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a<?>> processors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isActivate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RuntimeServiceHolder serviceHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/b$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;", "converter", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/b;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.processors.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a(@NotNull String guildId, @NotNull f converter) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(converter, "converter");
            return new b(new GuildHomeCommonHeaderBarsUpdateProcessor(guildId, converter));
        }

        Companion() {
        }
    }

    public b(@NotNull a<?>... processors) {
        List<a<?>> list;
        Intrinsics.checkNotNullParameter(processors, "processors");
        list = ArraysKt___ArraysKt.toList(processors);
        this.processors = list;
        this.serviceHolder = new RuntimeServiceHolder();
        for (a<?> aVar : processors) {
            aVar.m(this.serviceHolder);
        }
        a();
    }

    @UiThread
    public final void a() {
        int collectionSizeOrDefault;
        Object m476constructorimpl;
        if (this.isActivate) {
            Logger.f235387a.d().i("Guild.MF.headerBars.GuildHeaderBarProcessors", 1, "activate() is already called");
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
                    Logger.f235387a.d().e("Guild.MF.headerBars.GuildHeaderBarProcessors", 1, (String) it5.next(), m479exceptionOrNullimpl);
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
        Logger.f235387a.d().i("Guild.MF.headerBars.GuildHeaderBarProcessors", 1, "activate() costs: " + arrayList);
    }

    @UiThread
    public final void b() {
        Object m476constructorimpl;
        if (!this.isActivate) {
            Logger.f235387a.d().i("Guild.MF.headerBars.GuildHeaderBarProcessors", 1, "deactivate() is already called");
            return;
        }
        this.isActivate = false;
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.d();
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
                    Logger.f235387a.d().e("Guild.MF.headerBars.GuildHeaderBarProcessors", 1, (String) it5.next(), m479exceptionOrNullimpl);
                }
            }
        }
    }

    @NotNull
    public final Flow<c<?>> c() {
        int collectionSizeOrDefault;
        List<a<?>> list = this.processors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).e());
        }
        return FlowKt.merge(arrayList);
    }

    public final void d(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().i("Guild.MF.headerBars.GuildHeaderBarProcessors", 1, "onAccountChanged(" + account + ")");
        b();
        this.serviceHolder = new RuntimeServiceHolder();
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m(this.serviceHolder);
        }
        a();
    }

    public final void e() {
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((a) it.next()).j();
        }
    }

    public final void f() {
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((a) it.next()).k();
        }
    }

    public final void g(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Iterator<T> it = this.processors.iterator();
        while (it.hasNext()) {
            ((a) it.next()).n(guildId);
        }
    }
}
