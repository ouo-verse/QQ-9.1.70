package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import androidx.lifecycle.ViewModelKt;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.ArrayList;
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
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ec;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b*\u0010+J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000fj\b\u0012\u0004\u0012\u00020\u0005`\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R(\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040&0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildAudioLiveChannelUserListStrategy;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/as;", "", "text", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "y", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "count", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/q;", "t", "list", "", "isExcludeSameUser", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "u", "tinyId", HippyTKDListViewAdapter.X, "isForce", "", "a", tl.h.F, "Ljy1/a;", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "i", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "j", "I", "numIndex", "k", "Z", "mIsHeadUserListAdded", "Lmqq/util/WeakReference;", "Lkotlinx/coroutines/Deferred;", "l", "Lmqq/util/WeakReference;", "searchRequest", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAudioLiveChannelUserListStrategy extends as {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int numIndex;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsHeadUserListAdded;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Deferred<List<IGProUserInfo>>> searchRequest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAudioLiveChannelUserListStrategy(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.searchRequest = new WeakReference<>(null);
    }

    private final com.tencent.mobileqq.qqguildsdk.data.genc.q t(int count) {
        com.tencent.mobileqq.qqguildsdk.data.genc.q qVar = new com.tencent.mobileqq.qqguildsdk.data.genc.q();
        String guildId = this.param.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "param.guildId");
        qVar.j(Long.parseLong(guildId));
        String subChannelId = this.param.getSubChannelId();
        Intrinsics.checkNotNullExpressionValue(subChannelId, "param.subChannelId");
        qVar.i(Long.parseLong(subChannelId));
        qVar.m(this.numIndex);
        qVar.n(count);
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<IGProUserInfo> u(List<? extends IGProUserInfo> list, boolean isExcludeSameUser) {
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>(list.size());
        for (IGProUserInfo iGProUserInfo : list) {
            if (iGProUserInfo.getRobotType() != 1) {
                if (isExcludeSameUser) {
                    String tinyId = iGProUserInfo.getTinyId();
                    Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
                    if (!x(tinyId)) {
                    }
                }
                arrayList.add(iGProUserInfo);
            }
        }
        return arrayList;
    }

    static /* synthetic */ ArrayList v(GuildAudioLiveChannelUserListStrategy guildAudioLiveChannelUserListStrategy, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return guildAudioLiveChannelUserListStrategy.u(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GuildAudioLiveChannelUserListStrategy this$0, int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(false);
        QLog.d("GuildAudioLiveChannelUserListStrategy", 1, "fetchAudioLiveChannelUserList " + i3 + " " + str);
        if (i3 == 0) {
            this$0.j(iGProAudioLiveUserListRsp.getIsEndPage());
            this$0.numIndex += iGProAudioLiveUserListRsp.getChannelMemberInfo().getUserList().size();
            ArrayList<RoleGroupUserUIData> arrayList = new ArrayList<>();
            if (!this$0.mIsHeadUserListAdded && this$0.param.getLayoutType() == 7) {
                this$0.mIsHeadUserListAdded = true;
                arrayList.addAll(this$0.param.getSelectedUIList());
            }
            jy1.a aVar = this$0.viewModel;
            List<IGProUserInfo> userList = iGProAudioLiveUserListRsp.getChannelMemberInfo().getUserList();
            Intrinsics.checkNotNullExpressionValue(userList, "userListRsp.channelMemberInfo.userList");
            arrayList.addAll(aVar.S1(v(this$0, userList, false, 2, null)));
            this$0.viewModel.v2(arrayList);
            return;
        }
        this$0.viewModel.d2(i3, str);
    }

    private final boolean x(String tinyId) {
        boolean equals;
        List<RoleGroupUserUIData> selectedUIList = this.param.getSelectedUIList();
        Intrinsics.checkNotNullExpressionValue(selectedUIList, "param.selectedUIList");
        Iterator<T> it = selectedUIList.iterator();
        while (it.hasNext()) {
            equals = StringsKt__StringsJVMKt.equals(((RoleGroupUserUIData) it.next()).getMTinyId(), tinyId, true);
            if (equals) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y(final String str, Continuation<? super List<? extends IGProUserInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final cl clVar = new cl();
        clVar.p(GProGuildMemberSearchSourceId.AV_CHANNEL_ONLINE_MEMBER.ordinal());
        clVar.m(str);
        String guildId = this.param.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "param.guildId");
        clVar.l(MiscKt.l(guildId));
        String subChannelId = this.param.getSubChannelId();
        Intrinsics.checkNotNullExpressionValue(subChannelId, "param.subChannelId");
        clVar.j(MiscKt.l(subChannelId));
        clVar.k(an.f232959a.a());
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).searchGuildMembersBySourceId(clVar, new ec() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildAudioLiveChannelUserListStrategy$searchUser$2$1
            @Override // wh2.ec
            public final void a(int i3, String str2, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
                jy1.a aVar;
                List emptyList;
                ArrayList<IGProUserInfo> arrayList;
                ArrayList u16;
                if (i3 == 0) {
                    if (iGProGuildMemberSearchResult != null) {
                        arrayList = iGProGuildMemberSearchResult.getMembers();
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        Logger logger = Logger.f235387a;
                        cl clVar2 = clVar;
                        if (QLog.isColorLevel()) {
                            logger.d().d("GuildAudioLiveChannelUserListStrategy", 1, "searchUser size:" + iGProGuildMemberSearchResult.getMembers().size() + " searchParams:" + clVar2);
                        }
                        CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        GuildAudioLiveChannelUserListStrategy guildAudioLiveChannelUserListStrategy = GuildAudioLiveChannelUserListStrategy.this;
                        ArrayList<IGProUserInfo> members = iGProGuildMemberSearchResult.getMembers();
                        Intrinsics.checkNotNullExpressionValue(members, "searchResult.members");
                        u16 = guildAudioLiveChannelUserListStrategy.u(members, false);
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(u16));
                        CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation2 = cancellableContinuationImpl;
                        final String str3 = str;
                        cancellableContinuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildAudioLiveChannelUserListStrategy$searchUser$2$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                Logger logger2 = Logger.f235387a;
                                String str4 = str3;
                                logger2.d().w("GuildAudioLiveChannelUserListStrategy", 1, "searchUser cancelled " + str4);
                            }
                        });
                    }
                }
                Logger logger2 = Logger.f235387a;
                cl clVar3 = clVar;
                Logger.b bVar = new Logger.b();
                String str4 = "searchUser " + i3 + " " + str2 + " searchResult:" + iGProGuildMemberSearchResult + " searchParams:" + clVar3;
                if (str4 instanceof String) {
                    bVar.a().add(str4);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildAudioLiveChannelUserListStrategy", 1, (String) it.next(), null);
                }
                aVar = GuildAudioLiveChannelUserListStrategy.this.viewModel;
                aVar.y2(i3, str2);
                CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation3 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation3.resumeWith(Result.m476constructorimpl(emptyList));
                CancellableContinuation<List<? extends IGProUserInfo>> cancellableContinuation22 = cancellableContinuationImpl;
                final String str32 = str;
                cancellableContinuation22.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildAudioLiveChannelUserListStrategy$searchUser$2$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        Logger logger22 = Logger.f235387a;
                        String str42 = str32;
                        logger22.d().w("GuildAudioLiveChannelUserListStrategy", 1, "searchUser cancelled " + str42);
                    }
                });
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
    public void a(int count, boolean isForce) {
        k(true);
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).fetchAudioLiveChannelUserList(t(count), new wh2.ad() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.l
            @Override // wh2.ad
            public final void a(int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
                GuildAudioLiveChannelUserListStrategy.w(GuildAudioLiveChannelUserListStrategy.this, i3, str, iGProAudioLiveUserListRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void h(@NotNull String text, boolean isForce) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.viewModel), null, null, new GuildAudioLiveChannelUserListStrategy$searchUserData$1(this, text, null), 3, null);
    }
}
