package com.tencent.mobileqq.guild.media.core.logic;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.data.GuildMediaMemberShowRule;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVMemberGroupListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGroupTypeMember;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.Job;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b0\u00101J\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u001c\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelUserListRequestHelper;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/media/core/logic/q;", "Lcom/tencent/mobileqq/guild/media/core/logic/m;", "W", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/m;", "T", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;", "rsp", "", "X", "a0", "Y", "", "nextIntervalInSeconds", "b0", "n0", "E0", "p", "u", "from", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", "Z", "", "N0", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "f", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "fetchListJob", tl.h.F, "listFetched", "i", "J", "lastFetchInterval", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "fetchListRunnable", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelUserListRequestHelper extends h implements q {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b fetchListJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean listFetched;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastFetchInterval;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable fetchListRunnable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;", "groupListRsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVMemberGroupListRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements wh2.ac {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FetchUserGroupListResult> f228271a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f228272b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super FetchUserGroupListResult> cancellableContinuation, long j3) {
            this.f228271a = cancellableContinuation;
            this.f228272b = j3;
        }

        @Override // wh2.ac
        public final void a(int i3, String errMsg, IGProAVMemberGroupListRsp groupListRsp) {
            Logger logger = Logger.f235387a;
            CancellableContinuation<FetchUserGroupListResult> cancellableContinuation = this.f228271a;
            long j3 = this.f228272b;
            logger.d().i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "fetchUserListByGroup , result:" + i3 + ",errMsg:" + errMsg + "," + cancellableContinuation.isActive() + ", cost:" + (System.currentTimeMillis() - j3) + "ms");
            if (this.f228271a.isActive()) {
                CancellableContinuation<FetchUserGroupListResult> cancellableContinuation2 = this.f228271a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                Intrinsics.checkNotNullExpressionValue(groupListRsp, "groupListRsp");
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(new FetchUserGroupListResult(i3, errMsg, groupListRsp)));
            }
        }
    }

    public MediaChannelUserListRequestHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.lastFetchInterval = 10L;
        this.fetchListRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.bx
            @Override // java.lang.Runnable
            public final void run() {
                MediaChannelUserListRequestHelper.U(MediaChannelUserListRequestHelper.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqguildsdk.data.genc.m T() {
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.cc> arrayListOf;
        com.tencent.mobileqq.qqguildsdk.data.genc.m mVar = new com.tencent.mobileqq.qqguildsdk.data.genc.m();
        mVar.f(Long.parseLong(this.core.getGuildID()));
        mVar.d(Long.parseLong(this.core.E()));
        GuildMediaMemberShowRule maxPlayerShowRule = this.core.v0().getMaxPlayerShowRule();
        GuildMediaMemberShowRule maxViewerShowRule = this.core.v0().getMaxViewerShowRule();
        com.tencent.mobileqq.qqguildsdk.data.genc.cc ccVar = new com.tencent.mobileqq.qqguildsdk.data.genc.cc();
        ccVar.c(1);
        ccVar.d(maxPlayerShowRule.getMaxDetailShowNum() + maxPlayerShowRule.getMaxThumbnailShowNum());
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.qqguildsdk.data.genc.cc ccVar2 = new com.tencent.mobileqq.qqguildsdk.data.genc.cc();
        ccVar2.c(2);
        ccVar2.d(maxViewerShowRule.getMaxDetailShowNum() + maxViewerShowRule.getMaxThumbnailShowNum());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ccVar, ccVar2);
        mVar.e(arrayListOf);
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(MediaChannelUserListRequestHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "timer: fetch user list start");
        this$0.n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object W(Continuation<? super FetchUserGroupListResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        long currentTimeMillis = System.currentTimeMillis();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelUserListRequestHelper", "fetchUserListByGroup req start.");
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelUserListRequestHelper$fetchUserListByGroup$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "fetchUserListByGroup cancel.");
            }
        });
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).fetchAudioLiveChannelGroupListAndCallbackDirect(T(), new b(cancellableContinuationImpl, currentTimeMillis));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int result, String errMsg, IGProAVMemberGroupListRsp rsp) {
        Object obj = null;
        if (result != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "in room handleFetchUserGroupList failed result:" + result + ", errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelUserListRequestHelper", 1, (String) it.next(), null);
            }
            a.b(this.core.m0(), "audio_room_error", this.core.getGuildID(), this.core.E(), 1, com.tencent.mobileqq.guild.media.core.data.b.a(1, result, errMsg, this.core.getGuildID()), 0, null, null, 224, null);
            AudioNotifyHelper l06 = this.core.l0();
            String guildID = this.core.getGuildID();
            String E = this.core.E();
            String a16 = com.tencent.mobileqq.guild.media.core.data.b.a(1, result, errMsg, this.core.getGuildID());
            Intrinsics.checkNotNullExpressionValue(a16, "getErrorTypeMsg(AudioRoo\u2026rrMsg, core.getGuildID())");
            l06.f(guildID, E, 1, a16, result, errMsg);
            b0(rsp.getNextReadInterval() > 0 ? rsp.getNextReadInterval() : this.lastFetchInterval);
            return;
        }
        IGProGroupTypeList groupTypeList = rsp.getGroupTypeList();
        if (!groupTypeList.getGroupTypeMembers().isEmpty() && groupTypeList.getGroupTypeMembers().get(0).getChannelId() == Long.parseLong(this.core.E())) {
            ArrayList<IGProUserInfo> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<IGProGroupTypeMember> groupTypeMembers = groupTypeList.getGroupTypeMembers();
            Intrinsics.checkNotNullExpressionValue(groupTypeMembers, "groupList.groupTypeMembers");
            for (IGProGroupTypeMember iGProGroupTypeMember : groupTypeMembers) {
                int groupType = iGProGroupTypeMember.getGroupType();
                if (groupType == 1) {
                    arrayList.addAll(iGProGroupTypeMember.getMemberList());
                } else if (groupType == 2) {
                    arrayList2.addAll(iGProGroupTypeMember.getMemberList());
                }
            }
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("handleFetchUserGroupList userList isEmpty!\uff01");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("QGMC.Core.MediaChannelUserListRequestHelper", 1, (String) it5.next(), null);
                }
                a0();
                b0(rsp.getNextReadInterval());
                return;
            }
            Integer value = this.core.v0().T().getValue();
            if (value != null && value.intValue() == 2 && this.core.o0().a()) {
                for (IGProUserInfo iGProUserInfo : arrayList) {
                    if (iGProUserInfo.getBusinessInfo().getMemberInfoInGame().getGameIdentity() != 0) {
                        this.core.o0().n().b().add(Long.valueOf(NumberUtil.stringToLong(iGProUserInfo.getTinyId())));
                    }
                }
            }
            this.core.o0().Q0(rsp.getChannelUserNum().getUserNum());
            this.core.o0().T0(rsp.getChannelUserNum().getViewersNum());
            this.core.o0().R0(rsp.getChannelUserNum().getShowThreshold());
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            com.tencent.mobileqq.guild.media.core.data.p.i(arrayList, arrayList2, this.core.D0().f228125a);
            QLog.i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[handleFetchUserGroupList] " + arrayList3.size());
            boolean F0 = com.tencent.mobileqq.guild.media.core.j.c().F0() ^ true;
            boolean z16 = this.core.getSelfUserInfo().f228101i;
            this.core.D0().e(this.core.A0());
            this.core.getSelfUserInfo().g(arrayList3);
            com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(this.core.getSelfUserInfo().f228093a);
            if (g16 != null) {
                g16.e(this.core.getSelfUserInfo());
            }
            Y();
            List<com.tencent.mobileqq.guild.media.core.data.p> anchors = this.core.D0().f228125a;
            Intrinsics.checkNotNullExpressionValue(anchors, "anchors");
            List<com.tencent.mobileqq.guild.media.core.data.p> list = anchors;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : list) {
                if (this.core.o0().r().contains(Long.valueOf(NumberUtil.stringToLong(((com.tencent.mobileqq.guild.media.core.data.p) obj2).f228093a)))) {
                    arrayList4.add(obj2);
                }
            }
            Iterator it6 = arrayList4.iterator();
            while (it6.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.data.p) it6.next()).f228112t = true;
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : list) {
                if (((com.tencent.mobileqq.guild.media.core.data.p) obj3).f228112t) {
                    arrayList5.add(obj3);
                }
            }
            Iterator it7 = arrayList5.iterator();
            while (it7.hasNext()) {
                this.core.y0().muteRemoteAudio(((com.tencent.mobileqq.guild.media.core.data.p) it7.next()).f228093a, true);
            }
            Logger logger3 = Logger.f235387a;
            logger3.d().i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "handleFetchUserList  anchor.size:" + anchors.size());
            logger3.d().d("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[handleFetchUserGroupList] needResetMicState " + F0 + ", currentMicOn " + z16 + ", mainRoomMicOn: " + this.core.getSelfUserInfo().f228101i);
            if (F0) {
                this.core.getSelfUserInfo().f228101i = z16;
                List<com.tencent.mobileqq.guild.media.core.data.p> list2 = this.core.D0().f228125a;
                Intrinsics.checkNotNullExpressionValue(list2, "core.getUserInfoList().anchors");
                Iterator<T> it8 = list2.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        break;
                    }
                    Object next = it8.next();
                    if (Intrinsics.areEqual(((com.tencent.mobileqq.guild.media.core.data.p) next).f228093a, this.core.getSelfUserInfo().f228093a)) {
                        obj = next;
                        break;
                    }
                }
                com.tencent.mobileqq.guild.media.core.data.p pVar = (com.tencent.mobileqq.guild.media.core.data.p) obj;
                if (pVar != null) {
                    pVar.f228101i = z16;
                }
            }
            this.core.l0().m("onFetchAudioChannelUserList", this.core.getSelfUserInfo());
            Z("handleFetchUserGroupList", rsp.getChannelUserNum());
            a0();
            b0(rsp.getNextReadInterval());
            return;
        }
        QLog.i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[handleFetchUserGroupList] groupTypeMembers is Empty or channelId not match.");
        b0(rsp.getNextReadInterval());
    }

    private final void a0() {
        if (!this.listFetched) {
            QLog.i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[notifyIfUserListFirstFetched] ");
            this.listFetched = true;
            this.core.l0().w();
        }
    }

    private final void b0(long nextIntervalInSeconds) {
        QLog.i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[tryFetchUserListOnNextInterval] will start in next " + nextIntervalInSeconds + " seconds");
        if (nextIntervalInSeconds <= 0) {
            QLog.w("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[tryFetchUserListOnNextInterval] invalid value. ignore");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.fetchListRunnable, 1000 * nextIntervalInSeconds);
        this.lastFetchInterval = nextIntervalInSeconds;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.q
    /* renamed from: N0, reason: from getter */
    public boolean getListFetched() {
        return this.listFetched;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.q
    public void Z(@Nullable String from, @Nullable IGProChannelUserNum channelNumber) {
        if (channelNumber == null) {
            QLog.w("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[updateAndNotifyChannelNumberChanged] data is null, ignore");
            return;
        }
        long dataVersion = channelNumber.getDataVersion();
        if (dataVersion < this.core.o0().getUserNumDataVersion()) {
            QLog.i("QGMC.Core.MediaChannelUserListRequestHelper", 1, "[updateAndNotifyChannelNumberChanged] dataVersion is smaller than last push, ignore");
            return;
        }
        this.core.o0().S0(dataVersion);
        this.core.o0().Q0(channelNumber.getUserNum());
        this.core.o0().T0(channelNumber.getViewersNum());
        this.core.o0().R0(channelNumber.getShowThreshold());
        this.core.l0().x(from, channelNumber);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.q
    public void n0() {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchListJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.fetchListRunnable);
        this.fetchListJob = CorountineFunKt.e(this.core.getCoroutineScope(), "updateUserInfoList", null, null, Boolean.TRUE, new MediaChannelUserListRequestHelper$updateUserInfoList$1(this, null), 6, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        super.p();
        E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        Job f16;
        super.u();
        this.listFetched = false;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.fetchListJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.fetchListRunnable);
    }

    private final void Y() {
    }
}
