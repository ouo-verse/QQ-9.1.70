package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.media.core.logic.EnterTrtcRoomReq;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/s;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/t;", "Lcom/tencent/mobileqq/guild/media/core/logic/l;", "req", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "subRoomId", "f", BdhLogUtil.LogTag.Tag_Req, "", ExifInterface.LATITUDE_SOUTH, "reason", "onExitRoom", "a", "Lcom/tencent/trtc/TRTCCloud;", "r", "Lcom/tencent/trtc/TRTCCloud;", "mainRoomCloud", "<init>", "(Lcom/tencent/trtc/TRTCCloud;)V", ReportConstant.COSTREPORT_PREFIX, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class s extends t {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TRTCCloud mainRoomCloud;

    public s(@NotNull TRTCCloud mainRoomCloud) {
        Intrinsics.checkNotNullParameter(mainRoomCloud, "mainRoomCloud");
        this.mainRoomCloud = mainRoomCloud;
        this.sTAG = "QGMC.MediaGroup.MediaSubTRTCRoom";
        com.tencent.mobileqq.guild.media.core.w.b("QGMC.MediaGroup.MediaSubTRTCRoom", "createSubCloud");
        TRTCCloud createSubCloud = mainRoomCloud.createSubCloud();
        Intrinsics.checkNotNullExpressionValue(createSubCloud, "mainRoomCloud.createSubCloud()");
        Z(createSubCloud);
        com.tencent.mobileqq.guild.media.core.w.a("QGMC.MediaGroup.MediaSubTRTCRoom", "createSubCloud");
        this.mAudioQualityAdapter = new v(P());
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t
    @NotNull
    public String R() {
        String str;
        TRTCCloudDef.TRTCParams tRTCParams = this.mTRTCParams;
        if (tRTCParams != null) {
            str = tRTCParams.strRoomId;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t
    public int S() {
        return 1;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom, com.tencent.mobileqq.guild.media.core.logic.trtc.d
    public void a() {
        QLog.i("QGMC.MediaGroup.MediaSubTRTCRoom", 1, "roomId[" + R() + "] stopMicrophone.");
        P().muteLocalAudio(true);
        b0();
        onUserAudioAvailable(this.mUserId, false);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void f(@NotNull String subRoomId, @NotNull ITRTCAudioRoom.a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(subRoomId, "subRoomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String R = R();
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaSubTRTCRoom", 1, "[exitSubRoom] subRoomId " + subRoomId + ", currentRoomId " + R);
        if (R.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(R, subRoomId)) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("[exitSubRoom] error roomId");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.MediaSubTRTCRoom", 1, (String) it.next(), null);
            }
            return;
        }
        this.mExitRoomCallback = callback;
        P().exitRoom();
        P().stopLocalAudio();
        if (!this.mIsInRoom) {
            ITRTCAudioRoom.a aVar = this.mExitRoomCallback;
            if (aVar != null) {
                aVar.onCallback(-1, "current is not in room.");
            }
            this.mExitRoomCallback = null;
        }
        this.isMicReady = false;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.t, com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void m(@NotNull EnterTrtcRoomReq req, @Nullable ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaSubTRTCRoom", 1, "[enterSubRoom] param " + req);
        if (req.getSdkAppId() != 0 && !TextUtils.isEmpty(req.getRoomId()) && !TextUtils.isEmpty(req.getUserId()) && !TextUtils.isEmpty(req.getUserSign())) {
            this.mPrivateMapKey = req.getPrivateMapKey();
            this.mUserId = req.getUserId();
            this.mEnterRoomCallback = callback;
            TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
            tRTCParams.sdkAppId = req.getSdkAppId();
            tRTCParams.privateMapKey = req.getPrivateMapKey();
            tRTCParams.userId = req.getUserId();
            tRTCParams.userSig = req.getUserSign();
            tRTCParams.role = req.getRole();
            tRTCParams.strRoomId = req.getRoomId();
            this.mTRTCParams = tRTCParams;
            P().setListener(this);
            P().setDefaultStreamRecvMode(req.getAutoReceiveAV(), req.getAutoReceiveAV());
            P().enterRoom(this.mTRTCParams, req.getAppScene());
            return;
        }
        if (callback != null) {
            callback.onCallback(-1, "enter trtc room fail. params invalid. room id:" + req.getRoomId() + " user id:" + req.getUserId() + " sign is empty:" + TextUtils.isEmpty(req.getUserSign()));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int reason) {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaSubTRTCRoom", 1, "[onExitRoom] reason " + reason);
        ITRTCAudioRoom.a aVar = this.mExitRoomCallback;
        if (aVar != null) {
            aVar.onCallback(0, "exit room success.");
        }
        this.mExitRoomCallback = null;
        this.mainRoomCloud.destroySubCloud(P());
        this.isMicReady = false;
        this.mIsInRoom = false;
        this.mListener = null;
    }
}
