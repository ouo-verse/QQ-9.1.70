package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ec;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0019j\b\u0012\u0004\u0012\u00020\r`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildSelectFromAllMemberStrategy;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseModifyRoleMemberStrategy;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProRoleMemberListInfo;", "roleList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "y", "", "count", "", "isForce", "", "a", "", "text", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljy1/a;", "l", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", DomainData.DOMAIN_NAME, "Ljava/util/HashSet;", "mLoadedUserSet", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "o", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSelectFromAllMemberStrategy extends GuildBaseModifyRoleMemberStrategy {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> mLoadedUserSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildMemberSearchResult;", "searchResult", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildMemberSearchResult;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    static final class b implements ec {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<? extends IGProUserInfo>> f232939b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super List<? extends IGProUserInfo>> cancellableContinuation) {
            this.f232939b = cancellableContinuation;
        }

        @Override // wh2.ec
        public final void a(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
            List emptyList;
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.rg..SelectFromAllMemberStrategy", 1, "searchUserData " + i3 + " " + str + " " + iGProGuildMemberSearchResult);
            }
            if (i3 == 0 && iGProGuildMemberSearchResult.getMembers() != null) {
                CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation = this.f232939b;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iGProGuildMemberSearchResult.getMembers()));
            } else {
                GuildSelectFromAllMemberStrategy.this.viewModel.y2(i3, str);
                CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation2 = this.f232939b;
                Result.Companion companion2 = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(emptyList));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSelectFromAllMemberStrategy(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.mLoadedUserSet = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GuildSelectFromAllMemberStrategy this$0, int i3, String str, boolean z16, int i16, List roleList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(false);
        Logger.f235387a.d().d("Guild.rg..SelectFromAllMemberStrategy", 1, "fetchMemberListWithRole " + i3 + ", " + str + ", " + z16 + ", " + i16);
        if (i3 != 0) {
            this$0.viewModel.d2(i3, str);
            return;
        }
        this$0.l(i16);
        this$0.j(!z16);
        jy1.a aVar = this$0.viewModel;
        Intrinsics.checkNotNullExpressionValue(roleList, "roleList");
        aVar.t2(this$0.y(roleList));
    }

    private final List<IGProUserInfo> y(List<? extends IGProRoleMemberListInfo> roleList) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IGProRoleMemberListInfo> it = roleList.iterator();
        while (it.hasNext()) {
            for (IGProUserInfo userInfo : it.next().getMemberList()) {
                if (!this.mLoadedUserSet.contains(userInfo.getTinyId())) {
                    Intrinsics.checkNotNullExpressionValue(userInfo, "userInfo");
                    arrayList.add(userInfo);
                    this.mLoadedUserSet.add(userInfo.getTinyId());
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void a(int count, boolean isForce) {
        k(true);
        ((IGPSService) ch.R0(IGPSService.class)).fetchMemberListWithRole(this.param.getGuildId(), "", count, isForce, new vh2.ai() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.ao
            @Override // vh2.ai
            public final void a(int i3, String str, boolean z16, int i16, List list) {
                GuildSelectFromAllMemberStrategy.x(GuildSelectFromAllMemberStrategy.this, i3, str, z16, i16, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseModifyRoleMemberStrategy
    @Nullable
    public Object s(@NotNull String str, @NotNull Continuation<? super List<? extends IGProUserInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cl clVar = new cl();
        clVar.p(GProGuildMemberSearchSourceId.ALL_MEMBER.ordinal());
        String guildId = this.param.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "param.guildId");
        clVar.l(MiscKt.l(guildId));
        clVar.k((int) com.tencent.mobileqq.qqguildsdk.util.f.f268548a);
        clVar.m(str);
        ((IGPSService) ch.R0(IGPSService.class)).searchGuildMembersBySourceId(clVar, new b(cancellableContinuationImpl));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildSelectFromAllMemberStrategy$searchUser$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().w("Guild.rg..SelectFromAllMemberStrategy", 1, "searchUser cancelled");
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
