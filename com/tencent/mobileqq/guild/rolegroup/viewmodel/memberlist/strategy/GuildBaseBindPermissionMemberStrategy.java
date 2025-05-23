package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ec;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ=\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R4\u0010\u001c\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u00190\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseBindPermissionMemberStrategy;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/as;", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "", "text", "", "sourceId", "Lkotlin/Pair;", "Lri1/a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isForce", "", tl.h.F, "r", "Ljy1/a;", "Ljy1/a;", "viewModel", "i", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "Lmqq/util/WeakReference;", "Lkotlinx/coroutines/Deferred;", "j", "Lmqq/util/WeakReference;", "searchRequest", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "k", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildBaseBindPermissionMemberStrategy extends as {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Deferred<Pair<ri1.a, List<IGProUserInfo>>>> searchRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildMemberSearchResult;", "searchResult", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildMemberSearchResult;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ec {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>> f232925a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cl f232926b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>> cancellableContinuation, cl clVar) {
            this.f232925a = cancellableContinuation;
            this.f232926b = clVar;
        }

        @Override // wh2.ec
        public final void a(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
            List emptyList;
            ArrayList<IGProUserInfo> arrayList;
            if (i3 == 0) {
                if (iGProGuildMemberSearchResult != null) {
                    arrayList = iGProGuildMemberSearchResult.getMembers();
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    Logger logger = Logger.f235387a;
                    cl clVar = this.f232926b;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.rg..GuildBaseBindPermissionMemberStrategy", 1, "searchMemberList Success msg=" + str + " size=" + iGProGuildMemberSearchResult + " " + clVar);
                    }
                    CancellableContinuation<Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>> cancellableContinuation = this.f232925a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new Pair(ri1.a.g(str), iGProGuildMemberSearchResult.getMembers())));
                    return;
                }
            }
            Logger logger2 = Logger.f235387a;
            cl clVar2 = this.f232926b;
            Logger.b bVar = new Logger.b();
            String str2 = "searchMemberList code=" + i3 + " msg=" + str + " size=" + iGProGuildMemberSearchResult + " " + clVar2;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg..GuildBaseBindPermissionMemberStrategy", 1, (String) it.next(), null);
            }
            CancellableContinuation<Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>> cancellableContinuation2 = this.f232925a;
            Result.Companion companion2 = Result.INSTANCE;
            ri1.a b16 = ri1.a.b(i3, str);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new Pair(b16, emptyList)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBaseBindPermissionMemberStrategy(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.searchRequest = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(GuildRoleMemberParamData guildRoleMemberParamData, String str, int i3, Continuation<? super Pair<? extends ri1.a, ? extends List<? extends IGProUserInfo>>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        cl b16 = an.b(guildRoleMemberParamData, str, i3);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IGPSService) ch.R0(IGPSService.class)).searchGuildMembersBySourceId(b16, new b(cancellableContinuationImpl, b16));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy$searchMemberList$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().w("Guild.rg..GuildBaseBindPermissionMemberStrategy", 1, "searchUser cancelled");
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void h(@NotNull String text, boolean isForce) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.viewModel), null, null, new GuildBaseBindPermissionMemberStrategy$searchUserData$1(this, text, null), 3, null);
    }

    public int r() {
        throw null;
    }
}
