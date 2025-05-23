package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.nativeinterface.kt.GProStFeedKt;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import uh2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J3\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0013\u0010\u000fJ \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R2\u0010\u001b\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001a\u0012\u0004\u0012\u00020\n0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedDraftServiceV2Impl;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/IFeedDraftServiceV2;", "", "oldDraftSaveToSDK", "", "draftId", "", "draftType", "draftKey", "Lkotlin/Result;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "peekFeedDraftCache-0E7RQCE", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Object;", "peekFeedDraftCache", "getFeedDraft", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draft", "setFeedDraft", "Lkotlinx/coroutines/flow/StateFlow;", "feedDraftFlow", "deleteGuildFeedDraft", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/AsyncDataMemoryStorage;", "Lkotlin/Triple;", "dataStore", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/AsyncDataMemoryStorage;", "<init>", "()V", "Companion", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDraftServiceV2Impl implements IFeedDraftServiceV2 {

    @NotNull
    private static final String TAG = "GuildFeedDraftStorageV2Impl";

    @NotNull
    private final AsyncDataMemoryStorage<Triple<String, Integer, String>, GProGuildFeedDraft> dataStore = new AsyncDataMemoryStorage<>(new FeedDraftServiceV2Impl$dataStore$1(null), new Function2<Triple<? extends String, ? extends Integer, ? extends String>, GProGuildFeedDraft, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$2

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$2$1", f = "FeedDraftServiceV2Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$2$1, reason: invalid class name */
        /* loaded from: classes13.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $draftId;
            final /* synthetic */ String $draftKey;
            final /* synthetic */ int $draftType;
            final /* synthetic */ GProGuildFeedDraft $v;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GProGuildFeedDraft gProGuildFeedDraft, String str, int i3, String str2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$v = gProGuildFeedDraft;
                this.$draftId = str;
                this.$draftType = i3;
                this.$draftKey = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$v, this.$draftId, this.$draftType, this.$draftKey, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                GProStFeed gProStFeed;
                boolean z16;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    GProGuildFeedDraft gProGuildFeedDraft = this.$v;
                    if (gProGuildFeedDraft != null) {
                        gProStFeed = gProGuildFeedDraft.draftFeed;
                    } else {
                        gProStFeed = null;
                    }
                    if (gProStFeed != null) {
                        String str = gProGuildFeedDraft.expandJsonStr;
                        Intrinsics.checkNotNullExpressionValue(str, "v.expandJsonStr");
                        if (str.length() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            c b16 = at.f235448a.b();
                            if (b16 != null) {
                                b16.setGuildFeedDraft(this.$draftId, this.$draftType, this.$draftKey, this.$v, null);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    c b17 = at.f235448a.b();
                    if (b17 != null) {
                        b17.deleteGuildFeedDraft(this.$draftId, this.$draftType, this.$draftKey, null);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends String, ? extends Integer, ? extends String> triple, GProGuildFeedDraft gProGuildFeedDraft) {
            invoke2((Triple<String, Integer, String>) triple, gProGuildFeedDraft);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Triple<String, Integer, String> triple, @Nullable GProGuildFeedDraft gProGuildFeedDraft) {
            Intrinsics.checkNotNullParameter(triple, "<name for destructuring parameter 0>");
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, ae.a().d(), null, new AnonymousClass1(gProGuildFeedDraft, triple.component1(), triple.component2().intValue(), triple.component3(), null), 2, null);
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R3\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedDraftServiceV2Impl$b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "e", "Lmqq/app/AppRuntime;", "appRuntime", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "guild", "cb", "f", "b", "onRemoveGuild", "", "black", "onBeKickFromGuild", "onDestoryGuild", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "_service", "Lkotlin/jvm/functions/Function1;", "_cb", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f223026d = new b();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static IGProGlobalService _service;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static Function1<? super String, Unit> _cb;

        b() {
        }

        private final void e(String guildId) {
            boolean z16;
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            Logger.f235387a.d().i(FeedDraftServiceV2Impl.TAG, 1, "innerDelete: " + guildId);
            Function1<? super String, Unit> function1 = _cb;
            if (function1 != null) {
                function1.invoke(guildId);
            }
        }

        public final void b() {
            IGProGlobalService iGProGlobalService = _service;
            if (iGProGlobalService != null) {
                iGProGlobalService.deleteObserver(this);
            }
        }

        public final void f(@NotNull AppRuntime appRuntime, @NotNull Function1<? super String, Unit> cb5) {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(cb5, "cb");
            _cb = cb5;
            IGProGlobalService iGProGlobalService = (IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "");
            _service = iGProGlobalService;
            if (iGProGlobalService != null) {
                iGProGlobalService.addObserver(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            e(guildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void oldDraftSaveToSDK() {
        String joinToString$default;
        int collectionSizeOrDefault;
        long coerceAtLeast;
        Object m476constructorimpl;
        boolean startsWith$default;
        boolean z16;
        boolean z17;
        if (bw.f235485a.y0()) {
            com.tencent.xaction.log.b.a(TAG, 4, "legacy drafts has migrated before, skip");
            return;
        }
        List<GuildTaskProgressState> G = GuildDbDataHelper.s().G();
        ArrayList arrayList = null;
        boolean z18 = false;
        if (G != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : G) {
                GuildTaskProgressState guildTaskProgressState = (GuildTaskProgressState) obj;
                String str = guildTaskProgressState.mTaskId;
                Intrinsics.checkNotNullExpressionValue(str, "it.mTaskId");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "GuildNativeMain", false, 2, null);
                if (startsWith$default) {
                    String str2 = guildTaskProgressState.mGuildId;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.mGuildId");
                    if (str2.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z16 = true;
                        if (!z16) {
                            arrayList2.add(obj);
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            arrayList = arrayList2;
        }
        ArrayList arrayList3 = arrayList;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            z18 = true;
        }
        if (z18) {
            com.tencent.xaction.log.b.a(TAG, 4, "attempt to migrate but no legacy drafts found, skip");
            bw.f235485a.Q1(true);
            return;
        }
        com.tencent.xaction.log.b.a(TAG, 4, "found " + arrayList.size() + " legacy drafts, attempt to migrate.");
        ArrayList arrayList4 = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((GuildTaskProgressState) obj2).mGuildId)) {
                arrayList5.add(obj2);
            }
        }
        Iterator it = arrayList5.iterator();
        while (true) {
            int i3 = 10;
            if (!it.hasNext()) {
                break;
            }
            GuildTaskProgressState guildTaskProgressState2 = (GuildTaskProgressState) it.next();
            GProGuildFeedDraft gProGuildFeedDraft = new GProGuildFeedDraft();
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(guildTaskProgressState2.getUpdateTime() / 1000, 0L);
            gProGuildFeedDraft.draftUpdateTimeSec = coerceAtLeast;
            gProGuildFeedDraft.expandJsonStr = guildTaskProgressState2.getJson();
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject(guildTaskProgressState2.getJson());
                GProStFeedKt gProStFeedKt = GProStFeedKt.f221782a;
                String optString = jSONObject.optString("contentJsonFeed");
                Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(\"contentJsonFeed\")");
                m476constructorimpl = Result.m476constructorimpl(GProStFeedKt.b(gProStFeedKt, optString, com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.k(jSONObject), jSONObject.optString("patternInfo"), null, 8, null));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            GProStFeed gProStFeed = new GProStFeed();
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = gProStFeed;
            }
            gProGuildFeedDraft.draftFeed = (GProStFeed) m476constructorimpl;
            if (guildTaskProgressState2.getBusinessType() != 7) {
                i3 = 1;
            }
            this.dataStore.g(new Triple<>(guildTaskProgressState2.getGuildId(), Integer.valueOf(i3), ""), gProGuildFeedDraft);
            arrayList4.add(guildTaskProgressState2.getGuildId());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList4, ",", null, null, 0, null, null, 62, null);
        com.tencent.xaction.log.b.a(TAG, 4, "legacy drafts migrate success, clear them, guildIds: " + joinToString$default);
        GuildDbDataHelper s16 = GuildDbDataHelper.s();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((GuildTaskProgressState) it5.next()).mTaskId);
        }
        s16.r(arrayList6);
        bw.f235485a.Q1(true);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2
    public void deleteGuildFeedDraft(@NotNull String draftId, int draftType, @NotNull String draftKey) {
        Intrinsics.checkNotNullParameter(draftId, "draftId");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        com.tencent.xaction.log.b.a(TAG, 1, "deleting feed draft: " + draftId);
        this.dataStore.g(new Triple<>(draftId, Integer.valueOf(draftType), draftKey), null);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2
    @Nullable
    public Object feedDraftFlow(@NotNull String str, int i3, @NotNull String str2, @NotNull Continuation<? super StateFlow<GProGuildFeedDraft>> continuation) {
        oldDraftSaveToSDK();
        return this.dataStore.c(new Triple<>(str, Boxing.boxInt(i3), str2), continuation);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2
    @Nullable
    public Object getFeedDraft(@NotNull String str, int i3, @NotNull String str2, @NotNull Continuation<? super GProGuildFeedDraft> continuation) {
        oldDraftSaveToSDK();
        return AsyncDataMemoryStorage.b(this.dataStore, new Triple(str, Boxing.boxInt(i3), str2), false, continuation, 2, null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, ae.a().c(), null, new FeedDraftServiceV2Impl$onCreate$1(this, null), 2, null);
        b.f223026d.f(appRuntime, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final String guildId) {
                AsyncDataMemoryStorage asyncDataMemoryStorage;
                Intrinsics.checkNotNullParameter(guildId, "guildId");
                asyncDataMemoryStorage = FeedDraftServiceV2Impl.this.dataStore;
                asyncDataMemoryStorage.e(new Function1<Triple<? extends String, ? extends Integer, ? extends String>, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$onCreate$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @NotNull
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Boolean invoke2(@NotNull Triple<String, Integer, String> triple) {
                        Intrinsics.checkNotNullParameter(triple, "<name for destructuring parameter 0>");
                        return Boolean.valueOf(Intrinsics.areEqual(triple.component1(), guildId));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Triple<? extends String, ? extends Integer, ? extends String> triple) {
                        return invoke2((Triple<String, Integer, String>) triple);
                    }
                });
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        b.f223026d.b();
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2
    @NotNull
    /* renamed from: peekFeedDraftCache-0E7RQCE */
    public Object mo185peekFeedDraftCache0E7RQCE(@NotNull String draftId, int draftType, @NotNull String draftKey) {
        Intrinsics.checkNotNullParameter(draftId, "draftId");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        return this.dataStore.f(new Triple<>(draftId, Integer.valueOf(draftType), draftKey));
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2
    public void setFeedDraft(@NotNull String draftId, int draftType, @NotNull String draftKey, @Nullable GProGuildFeedDraft draft) {
        Intrinsics.checkNotNullParameter(draftId, "draftId");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        oldDraftSaveToSDK();
        this.dataStore.g(new Triple<>(draftId, Integer.valueOf(draftType), draftKey), draft);
    }
}
