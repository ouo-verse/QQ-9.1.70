package com.tencent.mobileqq.guild.forward.guildselector;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorViewModel$initData$1", f = "GuildSelectorViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class GuildSelectorViewModel$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorViewModel$initData$1$1", f = "GuildSelectorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorViewModel$initData$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ GuildSelectorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildSelectorViewModel guildSelectorViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = guildSelectorViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList<RecentUser> arrayList;
            List list;
            List list2;
            List list3;
            int collectionSizeOrDefault;
            IGProGuildInfo guildInfo;
            List list4;
            List list5;
            IRecentForwardUserProxy recentForwardCache;
            List<RecentUser> recentList;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                IRecentUserProxyService iRecentUserProxyService = (IRecentUserProxyService) (appInterface != null ? appInterface.getRuntimeService(IRecentUserProxyService.class, "") : null);
                if (iRecentUserProxyService == null || (recentForwardCache = iRecentUserProxyService.getRecentForwardCache()) == null || (recentList = recentForwardCache.getRecentList(true)) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj2 : recentList) {
                        RecentUser recentUser = (RecentUser) obj2;
                        boolean z16 = false;
                        if (recentUser.type == 10027) {
                            String str = recentUser.uin;
                            if (!(str == null || str.length() == 0)) {
                                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                                AppInterface appInterface2 = peekAppRuntime2 instanceof AppInterface ? (AppInterface) peekAppRuntime2 : null;
                                IGPSService iGPSService = (IGPSService) (appInterface2 != null ? appInterface2.getRuntimeService(IGPSService.class, "") : null);
                                if (iGPSService != null && iGPSService.isGuildMember(recentUser.uin)) {
                                    z16 = true;
                                }
                            }
                        }
                        if (z16) {
                            arrayList.add(obj2);
                        }
                    }
                }
                list = this.this$0.recentShareGuilds;
                list.clear();
                if (arrayList != null) {
                    GuildSelectorViewModel guildSelectorViewModel = this.this$0;
                    for (RecentUser recentUser2 : arrayList) {
                        AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
                        AppInterface appInterface3 = peekAppRuntime3 instanceof AppInterface ? (AppInterface) peekAppRuntime3 : null;
                        IGPSService iGPSService2 = (IGPSService) (appInterface3 != null ? appInterface3.getRuntimeService(IGPSService.class, "") : null);
                        if (iGPSService2 != null && (guildInfo = iGPSService2.getGuildInfo(recentUser2.uin)) != null) {
                            Intrinsics.checkNotNullExpressionValue(guildInfo, "fetchServiceApi<IGPSServ\u2026it.uin) ?: return@forEach");
                            list4 = guildSelectorViewModel.recentShareGuilds;
                            String guildID = guildInfo.getGuildID();
                            Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
                            String guildName = guildInfo.getGuildName();
                            Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
                            String avatarUrl = guildInfo.getAvatarUrl(100);
                            Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_100)");
                            list4.add(new GuildData(guildID, guildName, avatarUrl, 1));
                            list5 = guildSelectorViewModel.recentShareGuilds;
                            if (list5.size() >= 5) {
                                break;
                            }
                        }
                    }
                }
                AppRuntime peekAppRuntime4 = MobileQQ.sMobileQQ.peekAppRuntime();
                AppInterface appInterface4 = peekAppRuntime4 instanceof AppInterface ? (AppInterface) peekAppRuntime4 : null;
                IGPSService iGPSService3 = (IGPSService) (appInterface4 != null ? appInterface4.getRuntimeService(IGPSService.class, "") : null);
                List<IGProGuildInfo> sortedGuildList = iGPSService3 != null ? iGPSService3.getSortedGuildList() : null;
                if (sortedGuildList == null) {
                    sortedGuildList = CollectionsKt__CollectionsKt.emptyList();
                }
                list2 = this.this$0.allGuilds;
                list2.clear();
                list3 = this.this$0.allGuilds;
                List<IGProGuildInfo> list6 = sortedGuildList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (IGProGuildInfo iGProGuildInfo : list6) {
                    String guildID2 = iGProGuildInfo.getGuildID();
                    Intrinsics.checkNotNullExpressionValue(guildID2, "it.guildID");
                    String guildName2 = iGProGuildInfo.getGuildName();
                    Intrinsics.checkNotNullExpressionValue(guildName2, "it.guildName");
                    String avatarUrl2 = iGProGuildInfo.getAvatarUrl(100);
                    Intrinsics.checkNotNullExpressionValue(avatarUrl2, "it.getAvatarUrl(IGuiildAvatarUrlType.SIZE_100)");
                    arrayList2.add(new GuildData(guildID2, guildName2, avatarUrl2, 2));
                }
                return Boxing.boxBoolean(list3.addAll(arrayList2));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSelectorViewModel$initData$1(GuildSelectorViewModel guildSelectorViewModel, Continuation<? super GuildSelectorViewModel$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuildSelectorViewModel$initData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.Q1();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuildSelectorViewModel$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
