package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildMediaProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\f\u0010\f\u001a\u00020\u000b*\u00020\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\u000b*\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0016\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR8\u0010!\u001a&\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00110\u0011 \u001e*\u0012\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00140\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/BatchedMediaProgressStateStorageMediator;", "Lin1/a;", "", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "states", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "state", "o", "", "k", "oldState", "i", "j", "b", "", "mediaIds", "delete", "", "a", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/app/bc;", "Lcom/tencent/mobileqq/app/bc;", "handler", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "stateCache", "", "kotlin.jvm.PlatformType", "c", "Ljava/util/Set;", "pendingWrites", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "batchJobScheduled", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "batchRunnable", "<init>", "(Lcom/tencent/mobileqq/app/bc;)V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BatchedMediaProgressStateStorageMediator implements in1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bc handler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, GuildMediaProgressState> stateCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Set<String> pendingWrites;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean batchJobScheduled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable batchRunnable;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "kotlin.jvm.PlatformType", "", "dbResult", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    static final class b<T> implements GuildDbDataHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set<String> f223086a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<List<? extends GuildMediaProgressState>> f223087b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<GuildMediaProgressState> f223088c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BatchedMediaProgressStateStorageMediator f223089d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Set<String> set, Continuation<? super List<? extends GuildMediaProgressState>> continuation, List<GuildMediaProgressState> list, BatchedMediaProgressStateStorageMediator batchedMediaProgressStateStorageMediator) {
            this.f223086a = set;
            this.f223087b = continuation;
            this.f223088c = list;
            this.f223089d = batchedMediaProgressStateStorageMediator;
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onResult(List<GuildMediaProgressState> dbResult) {
            QLog.i("BatchedMediaProgressStateStorageMediator", 1, "[query] dbQuery | missingId.size = " + this.f223086a.size() + ", dbResult.size = " + dbResult.size());
            Intrinsics.checkNotNullExpressionValue(dbResult, "dbResult");
            BatchedMediaProgressStateStorageMediator batchedMediaProgressStateStorageMediator = this.f223089d;
            List<GuildMediaProgressState> list = this.f223088c;
            for (GuildMediaProgressState it : dbResult) {
                ConcurrentHashMap concurrentHashMap = batchedMediaProgressStateStorageMediator.stateCache;
                String taskId = it.getTaskId();
                Intrinsics.checkNotNullExpressionValue(taskId, "it.taskId");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                concurrentHashMap.put(taskId, it);
                list.add(it);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("BatchedMediaProgressStateStorageMediator", 4, "[query] dbQuery | dbResult = " + dbResult);
            }
            Continuation<List<? extends GuildMediaProgressState>> continuation = this.f223087b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(this.f223088c));
        }
    }

    public BatchedMediaProgressStateStorageMediator(@NotNull bc handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
        this.stateCache = new ConcurrentHashMap<>();
        this.pendingWrites = Collections.newSetFromMap(new ConcurrentHashMap());
        this.batchJobScheduled = new AtomicBoolean(false);
        this.batchRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.a
            @Override // java.lang.Runnable
            public final void run() {
                BatchedMediaProgressStateStorageMediator.g(BatchedMediaProgressStateStorageMediator.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BatchedMediaProgressStateStorageMediator this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
        this$0.batchJobScheduled.set(false);
        Set<String> pendingWrites = this$0.pendingWrites;
        Intrinsics.checkNotNullExpressionValue(pendingWrites, "pendingWrites");
        if (!pendingWrites.isEmpty()) {
            this$0.n();
        }
    }

    private final void h(List<? extends GuildMediaProgressState> states) {
        Sequence asSequence;
        Sequence filter;
        Sequence distinctBy;
        Sequence mapNotNull;
        Sequence onEach;
        int count;
        GuildDbDataHelper.s().M(states);
        asSequence = CollectionsKt___CollectionsKt.asSequence(states);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<GuildMediaProgressState, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.BatchedMediaProgressStateStorageMediator$executeDbWrite$mainTaskUpdatedCount$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GuildMediaProgressState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String mainTaskId = it.getMainTaskId();
                return Boolean.valueOf(mainTaskId == null || mainTaskId.length() == 0);
            }
        });
        distinctBy = SequencesKt___SequencesKt.distinctBy(filter, new Function1<GuildMediaProgressState, String>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.BatchedMediaProgressStateStorageMediator$executeDbWrite$mainTaskUpdatedCount$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(@NotNull GuildMediaProgressState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getMainTaskId();
            }
        });
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(distinctBy, new Function1<GuildMediaProgressState, GuildTaskProgressState>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.BatchedMediaProgressStateStorageMediator$executeDbWrite$mainTaskUpdatedCount$3
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final GuildTaskProgressState invoke(@NotNull GuildMediaProgressState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return GuildTaskProgressBoxHelper.o().q(it.getMainTaskId());
            }
        });
        onEach = SequencesKt___SequencesKt.onEach(mapNotNull, new Function1<GuildTaskProgressState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.BatchedMediaProgressStateStorageMediator$executeDbWrite$mainTaskUpdatedCount$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildTaskProgressState guildTaskProgressState) {
                invoke2(guildTaskProgressState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildTaskProgressState task) {
                Intrinsics.checkNotNullParameter(task, "task");
                GuildDbDataHelper.s().Q("mediator", task, false);
            }
        });
        count = SequencesKt___SequencesKt.count(onEach);
        QLog.i("BatchedMediaProgressStateStorageMediator", 1, "[executeDbWrite] states = " + states.size() + ", mainTaskUpdatedCount = " + count);
    }

    private final boolean i(GuildMediaProgressState guildMediaProgressState, GuildMediaProgressState guildMediaProgressState2) {
        if (guildMediaProgressState2 == null || guildMediaProgressState2.getState() != 1 || guildMediaProgressState.getState() != 1 || guildMediaProgressState2.getProgress() < guildMediaProgressState.getProgress()) {
            return false;
        }
        return true;
    }

    private final boolean j(GuildMediaProgressState guildMediaProgressState, GuildMediaProgressState guildMediaProgressState2) {
        if (guildMediaProgressState.getState() == guildMediaProgressState2.getState() && guildMediaProgressState.getProgress() == guildMediaProgressState2.getProgress() && Intrinsics.areEqual(guildMediaProgressState.getPath(), guildMediaProgressState2.getPath()) && Intrinsics.areEqual(guildMediaProgressState.getCoverUrl(), guildMediaProgressState2.getCoverUrl()) && Intrinsics.areEqual(guildMediaProgressState.getMainTaskId(), guildMediaProgressState2.getMainTaskId()) && Intrinsics.areEqual(guildMediaProgressState.getType(), guildMediaProgressState2.getType()) && guildMediaProgressState.getErrCode() == guildMediaProgressState2.getErrCode() && Intrinsics.areEqual(guildMediaProgressState.getErrMsg(), guildMediaProgressState2.getErrMsg()) && Intrinsics.areEqual(guildMediaProgressState.getClientKey(), guildMediaProgressState2.getClientKey())) {
            return true;
        }
        return false;
    }

    private final boolean k(GuildMediaProgressState guildMediaProgressState) {
        if (guildMediaProgressState.getProgress() % 10 == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(BatchedMediaProgressStateStorageMediator this$0, GuildMediaProgressState state) {
        List<? extends GuildMediaProgressState> listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(state.m183clone());
        this$0.h(listOf);
    }

    private final void m() {
        if (this.pendingWrites.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.pendingWrites.iterator();
        while (it.hasNext()) {
            GuildMediaProgressState guildMediaProgressState = this.stateCache.get(it.next());
            if (guildMediaProgressState != null) {
                GuildMediaProgressState m183clone = guildMediaProgressState.m183clone();
                Intrinsics.checkNotNullExpressionValue(m183clone, "it.clone()");
                arrayList.add(m183clone);
            }
            it.remove();
        }
        if (!arrayList.isEmpty()) {
            h(arrayList);
        }
    }

    private final void n() {
        if (this.batchJobScheduled.compareAndSet(false, true)) {
            this.handler.postDelayed(this.batchRunnable, 500L);
        }
    }

    private final void o(final GuildMediaProgressState state) {
        final GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(state.getMainTaskId());
        if (q16 == null) {
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.c
            @Override // java.lang.Runnable
            public final void run() {
                BatchedMediaProgressStateStorageMediator.p(GuildTaskProgressState.this, this, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildTaskProgressState guildTask, BatchedMediaProgressStateStorageMediator this$0, GuildMediaProgressState state) {
        Object obj;
        Intrinsics.checkNotNullParameter(guildTask, "$guildTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        List<GuildMediaProgressState> mediaProgressStates = guildTask.getMediaProgressStates();
        Intrinsics.checkNotNullExpressionValue(mediaProgressStates, "guildTask.mediaProgressStates");
        Iterator<T> it = mediaProgressStates.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((GuildMediaProgressState) obj).getTaskId(), state.getTaskId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GuildMediaProgressState guildMediaProgressState = (GuildMediaProgressState) obj;
        if (this$0.i(state, guildMediaProgressState)) {
            return;
        }
        if (guildMediaProgressState != null) {
            GuildTaskProgressBoxHelper.A(guildTask, state, guildMediaProgressState);
        } else {
            QLog.d("BatchedMediaProgressStateStorageMediator", 1, "[updateMediaProgressState] first add mediaProgressState task");
            guildTask.getMediaProgressStates().add(state);
        }
        GuildTaskProgressBoxHelper.l(guildTask);
        SimpleEventBus.getInstance().dispatchEvent(new GuildTaskProgressStateEvent(guildTask));
    }

    @Override // in1.a
    @Nullable
    public Object a(@NotNull Set<String> set, @NotNull Continuation<? super List<? extends GuildMediaProgressState>> continuation) {
        Continuation intercepted;
        List<String> list;
        Object coroutine_suspended;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : set) {
            GuildMediaProgressState guildMediaProgressState = this.stateCache.get(str);
            if (guildMediaProgressState != null) {
                arrayList.add(guildMediaProgressState);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet.isEmpty()) {
            return arrayList;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("BatchedMediaProgressStateStorageMediator", 4, "[query] dbQuery | missingIds = " + linkedHashSet);
        }
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        GuildDbDataHelper s16 = GuildDbDataHelper.s();
        list = CollectionsKt___CollectionsKt.toList(linkedHashSet);
        s16.I(list, new b(linkedHashSet, safeContinuation, arrayList, this));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // in1.a
    public void b(@NotNull final GuildMediaProgressState state) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        String taskId = state.getTaskId();
        boolean z17 = false;
        if (taskId != null && taskId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        GuildMediaProgressState guildMediaProgressState = this.stateCache.get(state.getTaskId());
        if (guildMediaProgressState != null && j(state, guildMediaProgressState)) {
            return;
        }
        ConcurrentHashMap<String, GuildMediaProgressState> concurrentHashMap = this.stateCache;
        String taskId2 = state.getTaskId();
        Intrinsics.checkNotNullExpressionValue(taskId2, "state.taskId");
        concurrentHashMap.put(taskId2, state);
        if (guildMediaProgressState == null) {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.b
                @Override // java.lang.Runnable
                public final void run() {
                    BatchedMediaProgressStateStorageMediator.l(BatchedMediaProgressStateStorageMediator.this, state);
                }
            });
        } else {
            this.pendingWrites.add(state.getTaskId());
            if (!this.batchJobScheduled.get()) {
                n();
            }
        }
        QLog.d("BatchedMediaProgressStateStorageMediator", 1, "[post] mediaState = " + state);
        SimpleEventBus.getInstance().dispatchEvent(new GuildMediaProgressStateEvent(state), true);
        String mainTaskId = state.getMainTaskId();
        if (mainTaskId == null || mainTaskId.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            o(state);
        }
        if (k(state)) {
            QLog.d("BatchedMediaProgressStateStorageMediator", 1, "[post] mediaState = " + state);
        }
    }

    @Override // in1.a
    public void delete(@NotNull List<String> mediaIds) {
        Intrinsics.checkNotNullParameter(mediaIds, "mediaIds");
        for (String str : mediaIds) {
            this.stateCache.remove(str);
            this.pendingWrites.remove(str);
        }
        GuildDbDataHelper.s().r(mediaIds);
    }
}
