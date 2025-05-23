package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.EnterTrtcRoomReq;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\B\t\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0004H&J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0012J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0004H\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0018\u0010*\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0004H\u0016J(\u00103\u001a\u00020\b2\u0006\u0010%\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\"\u0010:\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u0001062\u000e\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u000108H\u0016J\u0012\u0010;\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010=\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010<\u001a\u00020\u0004H\u0016J\u0018\u0010?\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\nH\u0016J\b\u0010>\u001a\u00020\bH\u0016J\u0018\u0010B\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\nH\u0016J\u001a\u0010D\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010C\u001a\u00020\u0006H\u0016J0\u0010I\u001a\u00020\b2\u001e\u0010G\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010E\u0018\u000108j\f\u0012\u0006\u0012\u0004\u0018\u00010E\u0018\u0001`F2\u0006\u0010H\u001a\u00020\u0004H\u0016J\b\u0010J\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020\bH\u0016J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0004H\u0016J\u0010\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0004H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\u0012\u0010S\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010QH\u0016J\u0018\u0010T\u001a\u00020\b2\u0006\u0010%\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u0004H\u0016J\b\u0010U\u001a\u00020\bH\u0016J\b\u0010V\u001a\u00020\bH\u0016J\u0012\u0010X\u001a\u00020\b2\b\u0010W\u001a\u0004\u0018\u00010\nH\u0016J$\u0010[\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016R\"\u0010b\u001a\u00020\r8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020\u00068\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010`R\u0016\u0010e\u001a\u00020\u00068\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010`R\u0018\u0010g\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010fR\u0016\u0010i\u001a\u00020\u00048\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010 R\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010oR\u0016\u0010s\u001a\u00020\u00068\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010`R\u0018\u0010v\u001a\u0004\u0018\u00010Q8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020\u00068\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010`R\u0018\u0010y\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010fR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020\n8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010fR\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0004X\u0085\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010 \u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/t;", "Lcom/tencent/trtc/TRTCCloudListener;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;", "Lcom/tencent/mobileqq/guild/api/IGuildTRTCFocusApi$a;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "enable", "", "N", "", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/trtc/TRTCCloud;", "T", "U", "V", "W", "Lcom/tencent/mobileqq/guild/media/core/data/g;", "X", "O", "L", "status", "c0", "enableTRTCPublish", "isInactive", "d0", "Lcom/tencent/mobileqq/guild/media/core/logic/l;", "req", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$a;", "callback", "k", "I", "audioIsOpen", "i", WidgetCacheConstellationData.INTERVAL, "M", "userId", "mute", "muteRemoteAudio", "newRoute", "oldRoute", "onAudioRouteChanged", "K", "", "code", "onEnterRoom", "onSendFirstLocalVideoFrame", "streamType", "width", "height", "onFirstVideoFrame", "onSendFirstLocalAudioFrame", "onMicDidReady", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "localQuality", "Ljava/util/ArrayList;", "remoteQuality", "onNetworkQuality", "onRemoteUserEnterRoom", "reason", "onRemoteUserLeaveRoom", ReportConstant.COSTREPORT_PREFIX, "onSetMixTranscodingConfig", "errCode", "errMsg", "onSwitchRole", "available", "onUserAudioAvailable", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "Lkotlin/collections/ArrayList;", "trtcVolumes", "totalVolume", "onUserVoiceVolume", "B", "d", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "Y", "mode", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "listener", UserInfo.SEX_FEMALE, "setRemoteAudioVolume", "a0", "b0", "privateMapKey", "E", "Landroid/os/Bundle;", "extraInfo", "onError", "a", "Lcom/tencent/trtc/TRTCCloud;", "P", "()Lcom/tencent/trtc/TRTCCloud;", "Z", "(Lcom/tencent/trtc/TRTCCloud;)V", "mTRTCCloud", "isMicReady", "c", "mMicEnable", "Ljava/lang/String;", "mUserId", "e", "captureVolume", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/v;", "f", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/v;", "mAudioQualityAdapter", "g", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$a;", "mEnterRoomCallback", tl.h.F, "mExitRoomCallback", "mIsInRoom", "j", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "mListener", "mEnableTRTCPublish", "l", "mPrivateMapKey", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "mTRTCParams", DomainData.DOMAIN_NAME, "sTAG", "Landroid/os/Handler;", "o", "Landroid/os/Handler;", "mMainHandler", "p", "originalVolume", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class t extends TRTCCloudListener implements ITRTCAudioRoom, IGuildTRTCFocusApi.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    protected volatile TRTCCloud mTRTCCloud;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected boolean isMicReady;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected boolean mMicEnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected v mAudioQualityAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected ITRTCAudioRoom.a mEnterRoomCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected ITRTCAudioRoom.a mExitRoomCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected boolean mIsInRoom;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected ITRTCAudioRoom.b mListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected volatile boolean mEnableTRTCPublish;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected String mPrivateMapKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected TRTCCloudDef.TRTCParams mTRTCParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected String mUserId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected volatile int captureVolume = -1;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    protected String sTAG = "QGMC.MediaTRTCRoom";

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    protected final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int originalVolume = -1;

    private final void N(boolean enable) {
        if (enable) {
            P().startSystemAudioLoopback();
        } else {
            P().stopSystemAudioLoopback();
        }
    }

    private final int Q() {
        boolean z16;
        String R = R();
        if (R.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            R = com.tencent.mobileqq.guild.media.core.j.a().E();
        }
        try {
            return Integer.parseInt(R);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            String str = this.sTAG;
            logger.d().d(str, 1, "[roomStatus] getNumRoomId error " + th5);
            return 0;
        }
    }

    public /* synthetic */ void A() {
        i.a(this);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void B() {
        P().setAudioRoute(1);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ long C(String str) {
        return k.b(this, str);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ int D(int i3, int i16) {
        return k.f(this, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void E(@Nullable String privateMapKey) {
        if (TextUtils.isEmpty(privateMapKey)) {
            QLog.e(this.sTAG, 1, "updatePrivateMapKey empty\uff0cplease check!");
        } else {
            this.mPrivateMapKey = privateMapKey;
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void F(@Nullable ITRTCAudioRoom.b listener) {
        this.mListener = listener;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ int G(int i3, int i16) {
        return k.e(this, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public /* synthetic */ void H(int i3) {
        e.a(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ int J(int i3) {
        return k.i(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void K() {
        QLog.i(this.sTAG, 1, "roomId[" + R() + "] startMicrophone.");
        if (!this.isMicReady) {
            P().startLocalAudio();
        }
        a0();
        if (this.captureVolume == -1) {
            this.captureVolume = bw.h0();
        }
        P().setAudioCaptureVolume(this.captureVolume);
        P().muteLocalAudio(false);
        onUserAudioAvailable(this.mUserId, true);
        this.mMicEnable = true;
    }

    public final void L() {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[disableTRTCPublish] roomId[" + R() + "] mEnableTRTCPublish " + this.mEnableTRTCPublish);
        if (this.mEnableTRTCPublish) {
            a();
            this.isMicReady = false;
            P().stopLocalAudio();
        }
        this.mEnableTRTCPublish = false;
    }

    public void M(int interval) {
        P().enableAudioVolumeEvaluation(interval, true);
    }

    public final void O() {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[enableTRTCPublish] roomId[" + R() + "] mEnableTRTCPublish " + this.mEnableTRTCPublish);
        if (!this.mEnableTRTCPublish) {
            this.isMicReady = false;
        }
        this.mEnableTRTCPublish = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TRTCCloud P() {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            return tRTCCloud;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTRTCCloud");
        return null;
    }

    @NotNull
    public abstract String R();

    public abstract int S();

    @NotNull
    public final TRTCCloud T() {
        W();
        return P();
    }

    /* renamed from: U, reason: from getter */
    public final boolean getMEnableTRTCPublish() {
        return this.mEnableTRTCPublish;
    }

    public final boolean V() {
        if (this.captureVolume == 0) {
            return true;
        }
        return false;
    }

    public final boolean W() {
        if (this.mTRTCCloud != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MediaRoomStatus X() {
        int i3;
        if (S() == 0) {
            i3 = Q();
        } else {
            i3 = 0;
        }
        return new MediaRoomStatus(R(), i3, null, getMEnableTRTCPublish(), V(), 4, null);
    }

    public boolean Y(int volume) {
        if (!getMEnableTRTCPublish()) {
            return false;
        }
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[setAudioCaptureVolume] roomId[" + R() + "] volume " + volume);
        this.captureVolume = volume;
        P().setAudioCaptureVolume(volume);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(@NotNull TRTCCloud tRTCCloud) {
        Intrinsics.checkNotNullParameter(tRTCCloud, "<set-?>");
        this.mTRTCCloud = tRTCCloud;
    }

    public void a0() {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[switchRoleToAnchor] roomId[" + R() + "] mPrivateMapKey " + this.mPrivateMapKey);
        }
        P().switchRole(20, this.mPrivateMapKey);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void b(int mode) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[setAudioMode] roomId[" + R() + "] mode " + mode);
        v vVar = this.mAudioQualityAdapter;
        if (vVar != null) {
            vVar.d(mode);
        }
    }

    public void b0() {
        P().switchRole(21);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public /* synthetic */ void c(List list) {
        m.e(this, list);
    }

    public final void c0(@NotNull MediaRoomStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        boolean z16 = true;
        logger.d().d(str, 1, "[updateRoomStatus] update status: " + status);
        if (status.getPrivateMapKey().length() <= 0) {
            z16 = false;
        }
        if (z16) {
            E(status.getPrivateMapKey());
        }
        d0(status.getEnableTRTCPublish(), status.getIsMicInactive());
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void d() {
        P().setAudioRoute(0);
    }

    public final void d0(boolean enableTRTCPublish, boolean isInactive) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[updateTRTCPublish] roomId[" + R() + "], mEnableTRTCPublish " + this.mEnableTRTCPublish + ", enableTRTCPublish " + enableTRTCPublish + ", isInactive " + isInactive);
        if (enableTRTCPublish) {
            O();
        } else {
            L();
        }
        if (isInactive && this.mEnableTRTCPublish) {
            Y(0);
            return;
        }
        if (this.originalVolume == -1) {
            this.originalVolume = bw.h0();
        }
        Y(this.originalVolume);
    }

    public /* synthetic */ void e(String str) {
        i.d(this, str);
    }

    public /* synthetic */ void f(String str, ITRTCAudioRoom.a aVar) {
        m.b(this, str, aVar);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ int g(int i3) {
        return k.d(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ void h() {
        k.h(this);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void i(boolean audioIsOpen) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[enableAudioRecord] roomId[" + R() + "] audioIsOpen " + audioIsOpen);
        if (!this.isMicReady && audioIsOpen) {
            P().startLocalAudio();
        }
        N(audioIsOpen);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    /* renamed from: isInited */
    public /* synthetic */ boolean getIsInited() {
        return g.a(this);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public /* synthetic */ ArrayList j() {
        return m.c(this);
    }

    public void k(@NotNull EnterTrtcRoomReq req, @Nullable ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(req, "req");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public /* synthetic */ void l(String str) {
        m.d(this, str);
    }

    public /* synthetic */ void m(EnterTrtcRoomReq enterTrtcRoomReq, ITRTCAudioRoom.a aVar) {
        m.a(this, enterTrtcRoomReq, aVar);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[muteRemoteAudio] roomId[" + R() + "] user id:" + userId + " mute:" + mute);
        P().muteRemoteAudio(userId, mute);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public /* synthetic */ void n(com.tencent.mobileqq.guild.media.core.logic.i iVar) {
        e.b(this, iVar);
    }

    public /* synthetic */ void o() {
        i.c(this);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioRouteChanged(int newRoute, int oldRoute) {
        QLog.i(this.sTAG, 1, "roomId[" + R() + "] onAudioRouteChanged new:" + newRoute);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long code) {
        QLog.i(this.sTAG, 1, "roomId[" + R() + "] onEnterRoom: code:" + code + " ");
        if (code > 0) {
            QLog.i(this.sTAG, 1, "on enter room success, time cost:" + code);
            this.mIsInRoom = true;
            v vVar = this.mAudioQualityAdapter;
            if (vVar != null) {
                vVar.d(bw.k());
            }
            P().muteLocalAudio(true);
            ITRTCAudioRoom.a aVar = this.mEnterRoomCallback;
            if (aVar != null) {
                aVar.onCallback(0, "enter trtc room success.");
            }
            M(600);
        } else {
            QLog.e(this.sTAG, 1, "on enter room fail, code:" + code);
            this.mIsInRoom = false;
            ITRTCAudioRoom.a aVar2 = this.mEnterRoomCallback;
            if (aVar2 != null) {
                aVar2.onCallback((int) code, "enter trtc room fail");
            }
        }
        this.mEnterRoomCallback = null;
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int errCode, @Nullable String errMsg, @Nullable Bundle extraInfo) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[onError] roomId[" + R() + "] onError: errorCode:" + errCode + " errmsg:" + errMsg);
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.e(R(), S(), errCode, errMsg);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(@NotNull String userId, int streamType, int width, int height) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        QLog.i(this.sTAG, 1, "onFirstVideoFrame userId:" + userId + ",w:" + width + ",h:" + height);
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.h(R(), S(), userId, width, height);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMicDidReady() {
        QLog.i(this.sTAG, 1, "roomId[" + R() + "] onMicDidReady");
        this.isMicReady = true;
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(@Nullable TRTCCloudDef.TRTCQuality localQuality, @Nullable ArrayList<TRTCCloudDef.TRTCQuality> remoteQuality) {
        int i3;
        Collection emptyList;
        int collectionSizeOrDefault;
        TRTCQuality tRTCQuality = new TRTCQuality();
        String str = this.mUserId;
        if (str == null) {
            str = "";
        }
        tRTCQuality.e(str);
        if (localQuality != null) {
            i3 = localQuality.quality;
        } else {
            i3 = 0;
        }
        tRTCQuality.c(i3);
        if (remoteQuality != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(remoteQuality, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            for (TRTCCloudDef.TRTCQuality tRTCQuality2 : remoteQuality) {
                TRTCQuality tRTCQuality3 = new TRTCQuality();
                String str2 = tRTCQuality2.userId;
                Intrinsics.checkNotNullExpressionValue(str2, "it.userId");
                tRTCQuality3.e(str2);
                tRTCQuality3.c(tRTCQuality2.quality);
                emptyList.add(tRTCQuality3);
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.i(R(), S(), tRTCQuality, new ArrayList<>(emptyList));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(@Nullable String userId) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[onRemoteUserEnterRoom] roomId[" + R() + "] on user enter, user id:" + userId + ", tid:" + Thread.currentThread().getId());
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.a(R(), S(), userId);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(@Nullable String userId, int reason) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[onRemoteUserLeaveRoom] roomId[" + R() + "] on user exit, user id:" + userId + ", tid:" + Thread.currentThread().getId());
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.g(R(), S(), userId);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalAudioFrame() {
        QLog.i(this.sTAG, 1, "onSendFirstLocalAudioFrame");
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalVideoFrame(int i3) {
        QLog.i(this.sTAG, 1, "onSendFirstLocalVideoFrame :" + i3);
        super.onSendFirstLocalVideoFrame(i3);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSetMixTranscodingConfig(int i3, @NotNull String s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        super.onSetMixTranscodingConfig(i3, s16);
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[onSetMixTranscodingConfig] roomId[" + R() + "] on set mix transcoding, code:" + i3 + " msg:" + s16);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRole(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[onSwitchRole] roomId[" + R() + "] onSwitchRole, errCode:" + errCode + ", errMsg:" + errMsg);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(@Nullable String userId, boolean available) {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[onUserAudioAvailable] roomId[" + R() + "] on user audio available, user id:" + userId + ", tid:" + Thread.currentThread().getId() + ", available: " + available);
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.b(R(), S(), userId, available);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(@Nullable ArrayList<TRTCCloudDef.TRTCVolumeInfo> trtcVolumes, int totalVolume) {
        ITRTCAudioRoom.b bVar = this.mListener;
        if (bVar != null) {
            bVar.c(R(), S(), ITRTCAudioRoom.TRTCVolumeInfo.e(trtcVolumes), totalVolume);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public /* synthetic */ void p(int i3) {
        e.e(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public int q() {
        v vVar = this.mAudioQualityAdapter;
        if (vVar != null) {
            return vVar.a();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public /* synthetic */ void r(Context context, String str, ITRTCAudioRoom.a aVar) {
        g.b(this, context, str, aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.a
    public void s() {
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        Logger.b bVar = new Logger.b();
        bVar.a().add("onShouldExitTRTCRoom.");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(str, 1, (String) it.next(), null);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public /* synthetic */ void setMusicPlayoutVolume(int i3, int i16) {
        e.c(this, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void setRemoteAudioVolume(@NotNull String userId, int volume) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Logger logger = Logger.f235387a;
        String str = this.sTAG;
        logger.d().d(str, 1, "[setRemoteAudioVolume] roomId[" + R() + "] userId:" + userId + ", volume:" + volume);
        P().setRemoteAudioVolume(userId, volume);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ int t(int i3) {
        return k.c(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ long u(int i3) {
        return k.a(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public /* synthetic */ int v(int i3, String str, int i16, long j3, u uVar) {
        return k.g(this, i3, str, i16, j3, uVar);
    }

    public /* synthetic */ void w(String str, Surface surface) {
        i.b(this, str, surface);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public /* synthetic */ void x(int i3, boolean z16, String str, long j3) {
        e.d(this, i3, z16, str, j3);
    }

    public /* synthetic */ void y(Context context) {
        g.c(this, context);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public /* synthetic */ boolean z(String str, int i3) {
        return c.a(this, str, i3);
    }

    public void I(@Nullable ITRTCAudioRoom.a callback) {
    }
}
