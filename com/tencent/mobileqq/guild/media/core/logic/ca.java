package com.tencent.mobileqq.guild.media.core.logic;

import androidx.lifecycle.MutableLiveData;
import at1.GuildGameCreateBean;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.core.data.GuildMediaUserBarNodePermission;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserBarNodePermission;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ca;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "bizList", "", "c", "i", "j", "d", "e", "f", "g", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;", "rsp", "b", "", "themeType", "k", "Lcom/tencent/mobileqq/guild/media/core/n;", "a", "Lcom/tencent/mobileqq/guild/media/core/n;", "dataModel", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/n;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ca {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.n dataModel;

    public ca(@NotNull com.tencent.mobileqq.guild.media.core.n dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        this.dataModel = dataModel;
    }

    private final void c(ArrayList<IGProBusinessNode> bizList) {
        Iterator<IGProBusinessNode> it = bizList.iterator();
        while (it.hasNext()) {
            IGProBusinessNode next = it.next();
            if (next.getNodeType() == 5) {
                Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "businessNode nodeType is DISPLAY_LISTEN_TOGETHER.");
                this.dataModel.l0(next.getPlayInfo());
                this.dataModel.J0(next.getPlayInfo().getSongInfo());
                this.dataModel.F0((int) next.getPlayInfo().getPlayNodeExInfo().getSourceNum());
                com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.u(true, this.dataModel.getStartParams().getChannelId()));
                return;
            }
        }
    }

    public final void b(@NotNull IGProEnterAudioLiveChannelRsp rsp) {
        List<GuildMediaUserBarNodePermission> emptyList;
        ArrayList<IGProBusinessNode> arrayList;
        ArrayList<IGProBusinessNode> arrayList2;
        boolean z16;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        k(rsp.getAvChannelConfig().getThemeInfo().getThemeType());
        com.tencent.mobileqq.guild.media.core.n nVar = this.dataModel;
        String roomSessionId = rsp.getRoomSessionId();
        Intrinsics.checkNotNullExpressionValue(roomSessionId, "rsp.roomSessionId");
        nVar.H0(roomSessionId);
        com.tencent.mobileqq.guild.media.core.n nVar2 = this.dataModel;
        String authMeta = rsp.getAuthMeta();
        Intrinsics.checkNotNullExpressionValue(authMeta, "rsp.authMeta");
        nVar2.f0(authMeta);
        this.dataModel.S().clear();
        ArrayList<GuildMediaUserBarNodePermission> S = this.dataModel.S();
        ArrayList<IGProUserBarNodePermission> userBarNodePermission = rsp.getUserBarNodePermission();
        if (userBarNodePermission == null || (emptyList = com.tencent.mobileqq.guild.media.core.data.e.b(userBarNodePermission)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        S.addAll(emptyList);
        this.dataModel.J().setValue(rsp.getAvChannelConfig().getThemeInfo());
        this.dataModel.L().setValue(Long.valueOf(rsp.getAvChannelConfig().getOriginatorTinyId()));
        this.dataModel.P0(rsp.getAvChannelConfig().getToolBar());
        MutableLiveData<ArrayList<IGProBusinessNode>> I = this.dataModel.I();
        IGProAVChannelConfig avChannelConfig = rsp.getAvChannelConfig();
        Integer num = null;
        if (avChannelConfig != null) {
            arrayList = avChannelConfig.getBusinessList();
        } else {
            arrayList = null;
        }
        I.setValue(arrayList);
        IGProAVChannelConfig avChannelConfig2 = rsp.getAvChannelConfig();
        if (avChannelConfig2 != null) {
            arrayList2 = avChannelConfig2.getBusinessList();
        } else {
            arrayList2 = null;
        }
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "handleEnterChannelRsp: themeType[" + this.dataModel.J().getValue() + "]");
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Logger.a d16 = logger.d();
            IGProBusinessNode iGProBusinessNode = arrayList2.get(0);
            if (iGProBusinessNode != null) {
                num = Integer.valueOf(iGProBusinessNode.getNodeType());
            }
            d16.i("QGMC.Core.MediaEnterExitRequestHelper", 1, "handleEnterChannelRsp: bizNodeType[" + num + "]");
            IGProVoiceSmobaGameRoomStateInfo roomInfo = arrayList2.get(0).getRoomStateInfo();
            this.dataModel.C().setValue(arrayList2.get(0).getScreenShareInfo());
            this.dataModel.j0(new GuildGameCreateBean(1, roomInfo, 0L, 0L, 0, null, 60, null));
            com.tencent.mobileqq.guild.media.core.notify.p d17 = com.tencent.mobileqq.guild.media.core.j.d();
            Intrinsics.checkNotNullExpressionValue(roomInfo, "roomInfo");
            d17.i(new com.tencent.mobileqq.guild.media.core.notify.am(roomInfo));
            logger.d().i("QMGame.", 1, "handleEnterChannelRsp: id" + this.dataModel.L().getValue() + " roomID " + roomInfo.getRoomId() + ", roomState " + roomInfo.getRoomState());
            c(arrayList2);
        }
    }

    public final void d() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onEnterChannelFailed, EnterChannelState.ENTER_FAILED");
        e12.e<EnterChannelState> k3 = this.dataModel.k();
        EnterChannelState enterChannelState = EnterChannelState.ENTER_FAILED;
        k3.setValue(enterChannelState);
        this.dataModel.l().setValue(enterChannelState);
    }

    public final void e() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onEnterChannelSuc, EnterChannelState.ENTER_SUC");
        this.dataModel.k().setValue(EnterChannelState.ENTER_SUC);
    }

    public final void f() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onEnterTRTCRoomSuc, EnterChannelState.ENTER_SUC");
        this.dataModel.l().setValue(EnterChannelState.ENTER_SUC);
    }

    public final void g() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onExitChannel, EnterChannelState.IDLE");
        e12.e<EnterChannelState> k3 = this.dataModel.k();
        EnterChannelState enterChannelState = EnterChannelState.IDLE;
        k3.setValue(enterChannelState);
        this.dataModel.l().setValue(enterChannelState);
    }

    public final void h() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onExitTRTCRoom, EnterChannelState.IDLE");
        this.dataModel.l().setValue(EnterChannelState.IDLE);
    }

    public final void i() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onStartEnterChannel, EnterChannelState.ENTER_ING");
        this.dataModel.k().setValue(EnterChannelState.ENTER_ING);
    }

    public final void j() {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onStartEnterTRTCRoom, EnterChannelState.ENTER_ING");
        this.dataModel.l().setValue(EnterChannelState.ENTER_ING);
    }

    public final void k(int themeType) {
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "onSwitchTheme:" + themeType);
        this.dataModel.M().setValue(Integer.valueOf(themeType));
    }
}
