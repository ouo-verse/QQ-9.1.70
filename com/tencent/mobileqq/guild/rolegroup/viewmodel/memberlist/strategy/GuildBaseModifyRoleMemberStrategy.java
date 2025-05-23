package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jy1.a;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;
import wh2.ec;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001f\u0010 J,\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseModifyRoleMemberStrategy;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/as;", "", "", "userListToAdd", "userListToRemove", "Ljy1/a$a;", "callback", "", "g", "text", "", "isForce", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljy1/a;", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "i", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "Lmqq/util/WeakReference;", "Lkotlinx/coroutines/Deferred;", "j", "Lmqq/util/WeakReference;", "searchRequest", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "k", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildBaseModifyRoleMemberStrategy extends as {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Deferred<List<IGProUserInfo>>> searchRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildMemberSearchResult;", "searchResult", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildMemberSearchResult;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ec {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<? extends IGProUserInfo>> f232932b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ cl f232933c;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super List<? extends IGProUserInfo>> cancellableContinuation, cl clVar) {
            this.f232932b = cancellableContinuation;
            this.f232933c = clVar;
        }

        @Override // wh2.ec
        public final void a(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
            List emptyList;
            ArrayList<IGProUserInfo> arrayList;
            Integer num;
            Integer num2 = null;
            if (i3 == 0) {
                if (iGProGuildMemberSearchResult != null) {
                    arrayList = iGProGuildMemberSearchResult.getMembers();
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    Logger logger = Logger.f235387a;
                    cl clVar = this.f232933c;
                    if (QLog.isColorLevel()) {
                        Logger.a d16 = logger.d();
                        ArrayList<IGProUserInfo> members = iGProGuildMemberSearchResult.getMembers();
                        if (members != null) {
                            num = Integer.valueOf(members.size());
                        } else {
                            num = null;
                        }
                        ArrayList<IGProGuildRoleInfo> roles = iGProGuildMemberSearchResult.getRoles();
                        if (roles != null) {
                            num2 = Integer.valueOf(roles.size());
                        }
                        d16.d("Guild.rg..ModifyRoleMemberStrategy", 1, "searchUserData searchParam:" + clVar + " members:" + num + " roles:" + num2);
                    }
                    CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation = this.f232932b;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(iGProGuildMemberSearchResult.getMembers()));
                    return;
                }
            }
            Logger logger2 = Logger.f235387a;
            cl clVar2 = this.f232933c;
            Logger.b bVar = new Logger.b();
            String str2 = "searchUserData " + i3 + " " + str + " " + iGProGuildMemberSearchResult + " searchParam:" + clVar2;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg..ModifyRoleMemberStrategy", 1, (String) it.next(), null);
            }
            GuildBaseModifyRoleMemberStrategy.this.viewModel.y2(i3, str);
            CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation2 = this.f232932b;
            Result.Companion companion2 = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(emptyList));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBaseModifyRoleMemberStrategy(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.searchRequest = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(a.InterfaceC10621a callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            callback.onSuccess();
        } else {
            callback.a(ri1.a.c(i3, str, iGProSecurityResult));
        }
    }

    static /* synthetic */ Object t(GuildBaseModifyRoleMemberStrategy guildBaseModifyRoleMemberStrategy, String str, Continuation<? super List<? extends IGProUserInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        final cl c16 = an.c(guildBaseModifyRoleMemberStrategy.param, str, guildBaseModifyRoleMemberStrategy.q());
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IGPSService) ch.R0(IGPSService.class)).searchGuildMembersBySourceId(c16, new b(cancellableContinuationImpl, c16));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseModifyRoleMemberStrategy$searchUser$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger logger = Logger.f235387a;
                cl clVar = cl.this;
                logger.d().w("Guild.rg..ModifyRoleMemberStrategy", 1, "searchUser cancelled " + clVar);
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
    public void g(@NotNull List<String> userListToAdd, @NotNull List<String> userListToRemove, @NotNull final a.InterfaceC10621a callback) {
        Intrinsics.checkNotNullParameter(userListToAdd, "userListToAdd");
        Intrinsics.checkNotNullParameter(userListToRemove, "userListToRemove");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IGPSService) ch.R0(IGPSService.class)).setRoleMembers(this.param.getGuildId(), this.param.getRoleGroupId(), this.param.getSubChannelId(), this.param.getCategoryId(), userListToAdd, userListToRemove, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.m
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildBaseModifyRoleMemberStrategy.r(a.InterfaceC10621a.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void h(@NotNull String text, boolean isForce) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.viewModel), null, null, new GuildBaseModifyRoleMemberStrategy$searchUserData$1(this, text, null), 3, null);
    }

    public int q() {
        return GProGuildMemberSearchSourceId.DEFAULT.ordinal();
    }

    @Nullable
    public Object s(@NotNull String str, @NotNull Continuation<? super List<? extends IGProUserInfo>> continuation) {
        return t(this, str, continuation);
    }
}
