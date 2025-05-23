package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.GuildChannelSelectedData;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.br;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/PermissionForRoleRepository;", "", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "callback", "", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "channelInfo", "", "i", "c", "", "selectedChannels", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", tl.h.F, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "b", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "permissionType", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PermissionForRoleRepository {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<Integer> f232727e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelPermissionTypeForRole permissionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope coroutineScope;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/PermissionForRoleRepository$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "callback", "", "b", "TAG", "Ljava/lang/String;", "", "", "speakEditableChannelTypes", "Ljava/util/Set;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.guild.base.repository.h callback, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Logger.f235387a.d().i("PermissionForRoleRepository", 1, "onGetCategoryChannelInfoListV2 infoList=" + arrayList);
            ri1.a f16 = ri1.a.f();
            Intrinsics.checkNotNullExpressionValue(f16, "ok()");
            callback.a(f16, arrayList);
        }

        @JvmStatic
        public final void b(@NotNull String guildId, @NotNull final com.tencent.mobileqq.guild.base.repository.h<List<IGProCategoryChannelInfoList>> callback) {
            List emptyList;
            Boolean bool;
            Pair pair;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            String str = "";
            IGPSService iGPSService = (IGPSService) MiscKt.c(IGPSService.class, "PermissionForRoleRepository", "");
            bd bdVar = new bd();
            bdVar.k(MiscKt.l(guildId));
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(guildId);
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            } else {
                bool = null;
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str2 = guildDebugUtils.e().get(guildId);
            if (str2 != null) {
                str = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(guildId, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                bdVar.j(true);
            }
            bdVar.g(true);
            iGPSService.getCategoryChannelInfoListV2(bdVar, new br() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.f
                @Override // wh2.br
                public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                    PermissionForRoleRepository.Companion.c(com.tencent.mobileqq.guild.base.repository.h.this, arrayList);
                }
            });
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lri1/a;", "error", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "result", "", "b", "(Lri1/a;Ljava/util/List;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    static final class b<T> implements com.tencent.mobileqq.guild.base.repository.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<? extends IGProCategoryChannelInfoList>> f232731a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Continuation<? super List<? extends IGProCategoryChannelInfoList>> continuation) {
            this.f232731a = continuation;
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(@NotNull ri1.a error, @Nullable List<? extends IGProCategoryChannelInfoList> list) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error.d() && list != null) {
                this.f232731a.resumeWith(Result.m476constructorimpl(list));
                return;
            }
            Continuation<List<? extends IGProCategoryChannelInfoList>> continuation = this.f232731a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("fetchPermissionForRole failed"))));
        }
    }

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 7, 2, 8});
        f232727e = of5;
    }

    public PermissionForRoleRepository(@NotNull String guildId, @NotNull ChannelPermissionTypeForRole permissionType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        this.guildId = guildId;
        this.permissionType = permissionType;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    private final boolean c(IGProChannel channelInfo) {
        if (this.permissionType == ChannelPermissionTypeForRole.ApproveSpeak && !f232727e.contains(Integer.valueOf(channelInfo.getChannelType()))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(final com.tencent.mobileqq.guild.base.repository.h<List<IGProCategoryChannelInfoList>> callback) {
        List emptyList;
        Boolean bool;
        Pair pair;
        String str = "";
        IGPSService iGPSService = (IGPSService) MiscKt.c(IGPSService.class, "PermissionForRoleRepository", "");
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(this.guildId));
        String str2 = this.guildId;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean contains = emptyList.contains(str2);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(str2);
        if (guildInfo != null) {
            bool = Boolean.valueOf(guildInfo.isMovePostSection());
        } else {
            bool = null;
        }
        if (contains) {
            pair = TuplesKt.to(Boolean.TRUE, "HardCode");
        } else if (bool == null) {
            pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
        } else {
            pair = TuplesKt.to(bool, "GuildInfo");
        }
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        String str3 = guildDebugUtils.e().get(str2);
        if (str3 != null) {
            str = str3;
        }
        Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
        String pair2 = pair.toString();
        if (!Intrinsics.areEqual(str, pair2)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + str2 + MsgSummary.STR_COLON + pair2);
            }
            guildDebugUtils.e().put(str2, pair2);
        }
        if (((Boolean) pair.getFirst()).booleanValue()) {
            bdVar.j(true);
        }
        bdVar.g(true);
        iGPSService.getCategoryChannelInfoListV2(bdVar, new br() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.e
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                PermissionForRoleRepository.g(com.tencent.mobileqq.guild.base.repository.h.this, arrayList);
            }
        });
    }

    @JvmStatic
    public static final void f(@NotNull String str, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<IGProCategoryChannelInfoList>> hVar) {
        INSTANCE.b(str, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(com.tencent.mobileqq.guild.base.repository.h callback, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Logger.f235387a.d().i("PermissionForRoleRepository", 1, "onGetCategoryChannelInfoListV2 infoList=" + arrayList);
        ri1.a f16 = ri1.a.f();
        Intrinsics.checkNotNullExpressionValue(f16, "ok()");
        callback.a(f16, arrayList);
    }

    private final boolean i(IGProChannel channelInfo) {
        if (this.permissionType == ChannelPermissionTypeForRole.ApproveVisible && channelInfo.getVisibleType() == 1) {
            return false;
        }
        if ((this.permissionType == ChannelPermissionTypeForRole.ApproveSpeak && channelInfo.getSpeakPermission() == 1) || c(channelInfo)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(@NotNull Continuation<? super List<? extends IGProCategoryChannelInfoList>> continuation) {
        PermissionForRoleRepository$fetchAllChannelList$1 permissionForRoleRepository$fetchAllChannelList$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        List emptyList;
        if (continuation instanceof PermissionForRoleRepository$fetchAllChannelList$1) {
            permissionForRoleRepository$fetchAllChannelList$1 = (PermissionForRoleRepository$fetchAllChannelList$1) continuation;
            int i16 = permissionForRoleRepository$fetchAllChannelList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                permissionForRoleRepository$fetchAllChannelList$1.label = i16 - Integer.MIN_VALUE;
                obj = permissionForRoleRepository$fetchAllChannelList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = permissionForRoleRepository$fetchAllChannelList$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    PermissionForRoleRepository$fetchAllChannelList$$inlined$suspendCoroutineWithTimeout$1 permissionForRoleRepository$fetchAllChannelList$$inlined$suspendCoroutineWithTimeout$1 = new PermissionForRoleRepository$fetchAllChannelList$$inlined$suspendCoroutineWithTimeout$1(null, this);
                    permissionForRoleRepository$fetchAllChannelList$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(2000L, permissionForRoleRepository$fetchAllChannelList$$inlined$suspendCoroutineWithTimeout$1, permissionForRoleRepository$fetchAllChannelList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj != null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("fetchPermissionForRole timeout");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("PermissionForRoleRepository", 1, (String) it.next(), null);
                    }
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList;
                }
                return obj;
            }
        }
        permissionForRoleRepository$fetchAllChannelList$1 = new PermissionForRoleRepository$fetchAllChannelList$1(this, continuation);
        obj = permissionForRoleRepository$fetchAllChannelList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = permissionForRoleRepository$fetchAllChannelList$1.label;
        if (i3 == 0) {
        }
        if (obj != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull List<String> list, @NotNull Continuation<? super List<GuildChannelSelectedData>> continuation) {
        PermissionForRoleRepository$fetchPermissionForRole$1 permissionForRoleRepository$fetchPermissionForRole$1;
        Object coroutine_suspended;
        int i3;
        List<String> list2;
        Object d16;
        PermissionForRoleRepository permissionForRoleRepository;
        boolean z16;
        boolean z17;
        boolean z18;
        if (continuation instanceof PermissionForRoleRepository$fetchPermissionForRole$1) {
            permissionForRoleRepository$fetchPermissionForRole$1 = (PermissionForRoleRepository$fetchPermissionForRole$1) continuation;
            int i16 = permissionForRoleRepository$fetchPermissionForRole$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                permissionForRoleRepository$fetchPermissionForRole$1.label = i16 - Integer.MIN_VALUE;
                Object obj = permissionForRoleRepository$fetchPermissionForRole$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = permissionForRoleRepository$fetchPermissionForRole$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        List<String> list3 = (List) permissionForRoleRepository$fetchPermissionForRole$1.L$1;
                        PermissionForRoleRepository permissionForRoleRepository2 = (PermissionForRoleRepository) permissionForRoleRepository$fetchPermissionForRole$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        d16 = obj;
                        list2 = list3;
                        permissionForRoleRepository = permissionForRoleRepository2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    permissionForRoleRepository$fetchPermissionForRole$1.L$0 = this;
                    list2 = list;
                    permissionForRoleRepository$fetchPermissionForRole$1.L$1 = list2;
                    permissionForRoleRepository$fetchPermissionForRole$1.label = 1;
                    d16 = d(permissionForRoleRepository$fetchPermissionForRole$1);
                    if (d16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    permissionForRoleRepository = this;
                }
                ArrayList arrayList = new ArrayList();
                for (IGProCategoryChannelInfoList iGProCategoryChannelInfoList : (List) d16) {
                    ArrayList arrayList2 = new ArrayList();
                    String categoryName = iGProCategoryChannelInfoList.getCategoryName();
                    Intrinsics.checkNotNullExpressionValue(categoryName, "categoryInfo.name");
                    if (categoryName.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        GuildChannelSelectedData.Companion companion = GuildChannelSelectedData.INSTANCE;
                        String categoryName2 = iGProCategoryChannelInfoList.getCategoryName();
                        Intrinsics.checkNotNullExpressionValue(categoryName2, "categoryInfo.name");
                        if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        arrayList2.add(companion.a(categoryName2, z18));
                    }
                    Iterator<IGProChannel> it = iGProCategoryChannelInfoList.getChannelInfoList().iterator();
                    while (it.hasNext()) {
                        IGProChannel channelInfo = it.next();
                        String channelName = channelInfo.getChannelName();
                        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
                        Intrinsics.checkNotNullExpressionValue(channelInfo, "channelInfo");
                        boolean i17 = permissionForRoleRepository.i(channelInfo);
                        if (list2.contains(String.valueOf(channelInfo.getChannelId())) && !permissionForRoleRepository.c(channelInfo)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        arrayList2.add(new GuildChannelSelectedData(1, channelName, false, channelInfo, i17, z17, 4, null));
                    }
                    if (arrayList2.size() != 1 || ((GuildChannelSelectedData) arrayList2.get(0)).getType() != 2) {
                        arrayList.addAll(arrayList2);
                    }
                }
                return arrayList;
            }
        }
        permissionForRoleRepository$fetchPermissionForRole$1 = new PermissionForRoleRepository$fetchPermissionForRole$1(this, continuation);
        Object obj2 = permissionForRoleRepository$fetchPermissionForRole$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = permissionForRoleRepository$fetchPermissionForRole$1.label;
        if (i3 == 0) {
        }
        ArrayList arrayList3 = new ArrayList();
        while (r2.hasNext()) {
        }
        return arrayList3;
    }
}
