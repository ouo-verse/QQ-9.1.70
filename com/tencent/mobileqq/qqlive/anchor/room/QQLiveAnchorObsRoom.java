package com.tencent.mobileqq.qqlive.anchor.room;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.report.QQLiveRoomBizReportHelper;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveAnchorClosePushPullBroadcastRequest;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveAnchorPushPullBroadcastRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.raft.raftframework.sla.SLAReporter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B)\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u0012\b\u0010\u0014\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/room/QQLiveAnchorObsRoom;", "Lcom/tencent/mobileqq/qqlive/anchor/room/QQLiveAnchorRoom;", "Lcom/tencent/mobileqq/qqlive/api/anchor/room/IQQLiveAnchorObsRoom;", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataUserInfo;", "N", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "ext", "", "prepare", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataRoomAttr;", "attr", "startSet", "Lcom/tencent/mobileqq/qqlive/data/anchor/params/QQLiveAnchorAutoCheckPullPlayParams;", "params", "getRtmpPushUrl", "enterRoom", "startPublishStream", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/ExitRoomCallback;", "callback", "exitRoom", "", "", HippyTKDListViewAdapter.X, "()[Ljava/lang/String;", "", "pushInfoReady", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "currentPushInfo", "setPushInfo", "reconnectObsRoom", "Lcom/tencent/mobileqq/qqlive/anchor/room/helper/q;", "P", "Lkotlin/Lazy;", "O", "()Lcom/tencent/mobileqq/qqlive/anchor/room/helper/q;", "rtmpPushInfoHelper", "Lcom/tencent/mobileqq/qqlive/anchor/room/helper/s;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getAnchorLiveStatChecker", "()Lcom/tencent/mobileqq/qqlive/anchor/room/helper/s;", "anchorLiveStatChecker", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "pushInfo", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdkImpl", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveAnchorRoomCallback;", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomConfig;Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveAnchorRoomCallback;)V", ExifInterface.LATITUDE_SOUTH, "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorObsRoom extends QQLiveAnchorRoom implements IQQLiveAnchorObsRoom {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String[] T;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy rtmpPushInfoHelper;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy anchorLiveStatChecker;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private QQLiveAnchorDataPushInfo pushInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/room/QQLiveAnchorObsRoom$a;", "", "", "TAG", "Ljava/lang/String;", "", "THIRDPUSH_REQUEST_PERMISSIONS", "[Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorObsRoom$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/room/QQLiveAnchorObsRoom$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lgr4/q;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ILiveNetRequest.Callback<gr4.q> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorObsRoom.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<gr4.q> response) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            if (!((BaseLiveRoom) QQLiveAnchorObsRoom.this).isDestroy && QQLiveAnchorObsRoom.this.f270783i == QQLiveAnchorRoomState.STATE_ENTER_ING) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "enterRoom onResponse, isSuccess:" + response.isSuccess());
                if (response.isSuccess() && response.getRetCode() == 0) {
                    gr4.q rsp = response.getRsp();
                    Unit unit = null;
                    String str = null;
                    if (rsp != null) {
                        QQLiveAnchorObsRoom qQLiveAnchorObsRoom = QQLiveAnchorObsRoom.this;
                        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                        qQLiveErrorMsg.bizModule = 2;
                        qQLiveErrorMsg.bizErrCode = 6255;
                        String str2 = rsp.f403188b;
                        qQLiveErrorMsg.bizErrMsg = str2;
                        qQLiveErrorMsg.originErrCode = rsp.f403187a;
                        qQLiveErrorMsg.originErrMsg = str2;
                        QQLiveAnchorDataEnter qQLiveAnchorDataEnter = new QQLiveAnchorDataEnter();
                        if (rsp.f403187a == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        qQLiveAnchorDataEnter.isSuccess = z16;
                        qQLiveAnchorDataEnter.errorMsg = qQLiveErrorMsg;
                        qQLiveAnchorDataEnter.roomInfo = qQLiveAnchorObsRoom.f270781f.roomData;
                        qQLiveAnchorDataEnter.configInfo = null;
                        qQLiveAnchorDataEnter.mediaInfo = null;
                        qQLiveAnchorDataEnter.trtcInfo = null;
                        QQLiveAnchorDataUserInfo N = qQLiveAnchorObsRoom.N();
                        qQLiveAnchorDataEnter.userInfo = N;
                        qQLiveAnchorObsRoom.f270781f.userDta = new QQLiveAnchorDataUserInfo(N);
                        qQLiveAnchorObsRoom.t(QQLiveAnchorRoomState.STATE_ENTER_READY);
                        qQLiveAnchorObsRoom.f270782h.onEnter(qQLiveAnchorDataEnter);
                        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
                        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                        if (c16 != null) {
                            str = c16.n();
                        }
                        iQQLiveReportApi.qualityReport(builder.traceId(str).eventId(QQLiveReportConstants.Event.E_ANCHOR_PUBLISH_STREAM).roomId(String.valueOf(qQLiveAnchorObsRoom.f270781f.roomData.f271212id)).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE));
                        qQLiveAnchorObsRoom.onEnterRoom();
                        companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", " enter liveSDK Room success");
                        qQLiveAnchorObsRoom.K = true;
                        qQLiveAnchorObsRoom.f270782h.onEnterRoom();
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        QQLiveAnchorObsRoom qQLiveAnchorObsRoom2 = QQLiveAnchorObsRoom.this;
                        companion.e("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "enterRoom while response.rsp is null! errorCode:" + response.getRetCode() + ", errorMsg:" + response.getErrMsg());
                        QQLiveErrorMsg qQLiveErrorMsg2 = new QQLiveErrorMsg();
                        qQLiveErrorMsg2.bizModule = 2;
                        qQLiveErrorMsg2.bizErrCode = 6255;
                        qQLiveErrorMsg2.bizErrMsg = "enter rsp is null!";
                        qQLiveErrorMsg2.originErrCode = (int) response.getRetCode();
                        qQLiveErrorMsg2.originErrMsg = response.getErrMsg();
                        qQLiveAnchorObsRoom2.f270782h.onError(qQLiveErrorMsg2);
                        return;
                    }
                    return;
                }
                companion.e("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "enterRoom fail, errorCode:" + response.getRetCode() + ", errorMsg:" + response.getErrMsg());
                QQLiveErrorMsg qQLiveErrorMsg3 = new QQLiveErrorMsg();
                qQLiveErrorMsg3.bizModule = 2;
                qQLiveErrorMsg3.bizErrCode = 6255;
                qQLiveErrorMsg3.bizErrMsg = response.getErrMsg();
                qQLiveErrorMsg3.originErrCode = (int) response.getRetCode();
                qQLiveErrorMsg3.originErrMsg = response.getErrMsg();
                QQLiveAnchorObsRoom.this.f270782h.onError(qQLiveErrorMsg3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/room/QQLiveAnchorObsRoom$c", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lgr4/c;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements ILiveNetRequest.Callback<gr4.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExitRoomCallback f270777b;

        c(ExitRoomCallback exitRoomCallback) {
            this.f270777b = exitRoomCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorObsRoom.this, (Object) exitRoomCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<gr4.c> response) {
            Unit unit;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorObsRoom", "exitRoom", "exitRoom onResponse, isSuccess:" + response.isSuccess());
            if (response.isSuccess() && response.getRetCode() == 0) {
                gr4.c rsp = response.getRsp();
                if (rsp != null) {
                    QQLiveAnchorObsRoom qQLiveAnchorObsRoom = QQLiveAnchorObsRoom.this;
                    ExitRoomCallback exitRoomCallback = this.f270777b;
                    QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                    qQLiveErrorMsg.bizModule = 2;
                    qQLiveErrorMsg.bizErrCode = 6255;
                    qQLiveErrorMsg.bizErrMsg = response.getErrMsg();
                    int i3 = rsp.f403101a;
                    qQLiveErrorMsg.originErrCode = i3;
                    qQLiveErrorMsg.originErrMsg = rsp.f403102b;
                    com.tencent.mobileqq.qqlive.anchor.report.a aVar = qQLiveAnchorObsRoom.G;
                    boolean z17 = true;
                    if (aVar != null) {
                        if (i3 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        aVar.C(z16, qQLiveErrorMsg);
                    }
                    com.tencent.mobileqq.qqlive.anchor.report.a aVar2 = qQLiveAnchorObsRoom.G;
                    if (aVar2 != null) {
                        if (rsp.f403101a != 0) {
                            z17 = false;
                        }
                        aVar2.h(z17, qQLiveErrorMsg);
                    }
                    if (exitRoomCallback != null) {
                        exitRoomCallback.onComplete(rsp.f403101a, rsp.f403102b);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
                QQLiveAnchorObsRoom qQLiveAnchorObsRoom2 = QQLiveAnchorObsRoom.this;
                ExitRoomCallback exitRoomCallback2 = this.f270777b;
                QQLiveErrorMsg qQLiveErrorMsg2 = new QQLiveErrorMsg();
                qQLiveErrorMsg2.bizModule = 2;
                qQLiveErrorMsg2.bizErrCode = 6255;
                qQLiveErrorMsg2.bizErrMsg = response.getErrMsg();
                qQLiveErrorMsg2.originErrCode = (int) response.getRetCode();
                qQLiveErrorMsg2.originErrMsg = response.getErrMsg();
                com.tencent.mobileqq.qqlive.anchor.report.a aVar3 = qQLiveAnchorObsRoom2.G;
                if (aVar3 != null) {
                    aVar3.C(false, qQLiveErrorMsg2);
                }
                com.tencent.mobileqq.qqlive.anchor.report.a aVar4 = qQLiveAnchorObsRoom2.G;
                if (aVar4 != null) {
                    aVar4.h(false, qQLiveErrorMsg2);
                }
                if (exitRoomCallback2 != null) {
                    exitRoomCallback2.onComplete((int) response.getRetCode(), response.getErrMsg());
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
                return;
            }
            QQLiveErrorMsg qQLiveErrorMsg3 = new QQLiveErrorMsg();
            qQLiveErrorMsg3.bizModule = 2;
            qQLiveErrorMsg3.bizErrCode = 6255;
            qQLiveErrorMsg3.bizErrMsg = response.getErrMsg();
            qQLiveErrorMsg3.originErrCode = (int) response.getRetCode();
            qQLiveErrorMsg3.originErrMsg = response.getErrMsg();
            com.tencent.mobileqq.qqlive.anchor.report.a aVar5 = QQLiveAnchorObsRoom.this.G;
            if (aVar5 != null) {
                aVar5.C(false, qQLiveErrorMsg3);
            }
            com.tencent.mobileqq.qqlive.anchor.report.a aVar6 = QQLiveAnchorObsRoom.this.G;
            if (aVar6 != null) {
                aVar6.h(false, qQLiveErrorMsg3);
            }
            ExitRoomCallback exitRoomCallback3 = this.f270777b;
            if (exitRoomCallback3 != null) {
                exitRoomCallback3.onComplete((int) response.getRetCode(), response.getErrMsg());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/room/QQLiveAnchorObsRoom$d", "Lcom/tencent/mobileqq/qqlive/anchor/room/al;", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "info", "", "onGetPushInfo", "Lcom/tencent/mobileqq/qqlive/data/common/QQLiveErrorMsg;", "errorMsg", "onError", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends al {
        static IPatchRedirector $redirector_;

        d(ak akVar) {
            super(akVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorObsRoom.this, (Object) akVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onError(@Nullable QQLiveErrorMsg errorMsg) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorMsg);
                return;
            }
            super.onError(errorMsg);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (errorMsg != null) {
                str = errorMsg.toString();
            } else {
                str = null;
            }
            companion.e("Open_Live|QQLiveAnchorObsRoom", "getRtmpPushUrl", "onGetPushInfo error, errorMsg:" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
        public void onGetPushInfo(@Nullable QQLiveAnchorDataPushInfo info) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            super.onGetPushInfo(info);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (info != null) {
                str = info.rtmpUrl;
            } else {
                str = null;
            }
            if (str == null) {
                str = "null";
            }
            if (info != null) {
                i3 = info.expireTs;
            } else {
                i3 = 0;
            }
            companion.i("Open_Live|QQLiveAnchorObsRoom", "getRtmpPushUrl", "onGetPushInfo success, pushUrl:" + str + ", expireTs:" + i3);
            QQLiveAnchorObsRoom.this.pushInfo = info;
            QQLiveAnchorObsRoom.this.enterRoom();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
            T = new String[]{SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAnchorObsRoom(@NotNull Context context, @NotNull IQQLiveSDK sdkImpl, @NotNull QQLiveAnchorRoomConfig config, @Nullable IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        super(context, sdkImpl, config, iQQLiveAnchorRoomCallback);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkImpl, "sdkImpl");
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(QQLiveAnchorObsRoom$rtmpPushInfoHelper$2.INSTANCE);
            this.rtmpPushInfoHelper = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.anchor.room.helper.s>() { // from class: com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorObsRoom$anchorLiveStatChecker$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAnchorObsRoom.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.qqlive.anchor.room.helper.s invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.qqlive.anchor.room.helper.s) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = QQLiveAnchorObsRoom.this.f270781f;
                    return new com.tencent.mobileqq.qqlive.anchor.room.helper.s(qQLiveAnchorRoomInfo != null ? qQLiveAnchorRoomInfo.uid : 0L);
                }
            });
            this.anchorLiveStatChecker = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, sdkImpl, config, iQQLiveAnchorRoomCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLiveAnchorDataUserInfo N() {
        long j3;
        String str;
        String str2;
        IQQLiveModuleLogin loginModule;
        LoginInfo loginInfo;
        IQQLiveModuleLogin loginModule2;
        LoginInfo loginInfo2;
        String str3;
        IQQLiveModuleLogin loginModule3;
        LoginInfo loginInfo3;
        LiveUserInfo liveUserInfo;
        IQQLiveModuleLogin loginModule4;
        LoginInfo loginInfo4;
        LiveUserInfo liveUserInfo2;
        IQQLiveModuleLogin loginModule5;
        LoginInfo loginInfo5;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo = new QQLiveAnchorDataUserInfo();
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        long j16 = 0;
        if (iQQLiveSDK != null && (loginModule5 = iQQLiveSDK.getLoginModule()) != null && (loginInfo5 = loginModule5.getLoginInfo()) != null) {
            j3 = loginInfo5.uid;
        } else {
            j3 = 0;
        }
        qQLiveAnchorDataUserInfo.f271213id = j3;
        qQLiveAnchorDataUserInfo.explicitId = 0L;
        IQQLiveSDK iQQLiveSDK2 = this.liveSDK;
        String str4 = "";
        if (iQQLiveSDK2 == null || (loginModule4 = iQQLiveSDK2.getLoginModule()) == null || (loginInfo4 = loginModule4.getLoginInfo()) == null || (liveUserInfo2 = loginInfo4.userInfo) == null || (str = liveUserInfo2.nick) == null) {
            str = "";
        }
        qQLiveAnchorDataUserInfo.nickName = str;
        IQQLiveSDK iQQLiveSDK3 = this.liveSDK;
        if (iQQLiveSDK3 == null || (loginModule3 = iQQLiveSDK3.getLoginModule()) == null || (loginInfo3 = loginModule3.getLoginInfo()) == null || (liveUserInfo = loginInfo3.userInfo) == null || (str2 = liveUserInfo.headUrl) == null) {
            str2 = "";
        }
        qQLiveAnchorDataUserInfo.avatarUrl = str2;
        qQLiveAnchorDataUserInfo.initialClientType = QQLiveConfigConst.CLIENT_TYPE;
        IQQLiveSDK iQQLiveSDK4 = this.liveSDK;
        if (iQQLiveSDK4 != null && (loginModule2 = iQQLiveSDK4.getLoginModule()) != null && (loginInfo2 = loginModule2.getLoginInfo()) != null && (str3 = loginInfo2.businessUid) != null) {
            str4 = str3;
        }
        qQLiveAnchorDataUserInfo.businessUid = str4;
        IQQLiveSDK iQQLiveSDK5 = this.liveSDK;
        if (iQQLiveSDK5 != null && (loginModule = iQQLiveSDK5.getLoginModule()) != null && (loginInfo = loginModule.getLoginInfo()) != null) {
            j16 = loginInfo.tinyid;
        }
        qQLiveAnchorDataUserInfo.tinyId = j16;
        return qQLiveAnchorDataUserInfo;
    }

    private final com.tencent.mobileqq.qqlive.anchor.room.helper.q O() {
        return (com.tencent.mobileqq.qqlive.anchor.room.helper.q) this.rtmpPushInfoHelper.getValue();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void enterRoom() {
        QQLiveAnchorRoomState qQLiveAnchorRoomState;
        QQLiveAnchorRoomState qQLiveAnchorRoomState2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "start enterRoom");
        if (isDestroyed() || (qQLiveAnchorRoomState = this.f270783i) == (qQLiveAnchorRoomState2 = QQLiveAnchorRoomState.STATE_ENTER_ING)) {
            return;
        }
        if (this.K) {
            companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "already entered room, curState:" + qQLiveAnchorRoomState);
            if (QLog.isDevelopLevel()) {
                throw new IllegalArgumentException("enterRoom state illegal");
            }
        }
        this.f270782h.onStartEnter();
        t(qQLiveAnchorRoomState2);
        companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "start enter MiniSDK Room");
        QQLiveAnchorRoomInfo roomInfo = this.f270781f;
        Intrinsics.checkNotNullExpressionValue(roomInfo, "roomInfo");
        byte[] authExt = getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID);
        Intrinsics.checkNotNullExpressionValue(authExt, "getAuthExt(IQQLiveAnchor\u2026pareWrapper.QQLIVE_BIZID)");
        QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo = this.pushInfo;
        if (qQLiveAnchorDataPushInfo != null) {
            str = qQLiveAnchorDataPushInfo.rtmpUrl;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveAnchorPushPullBroadcastRequest(roomInfo, authExt, str), new b());
        recordRoomInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(@Nullable ExitRoomCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorObsRoom", "exitRoom", "start exitRoom&stopPush");
        if (this.isExitRoom || isDestroyed()) {
            return;
        }
        if (this.liveSDK.getAppRuntime() != null) {
            QQLiveAnchorHelperFastResume.p(this.f270779d, this.liveSDK.getAppId(), this.liveSDK.getAppRuntime().getCurrentUin());
        }
        com.tencent.mobileqq.qqlive.anchor.report.a aVar = this.G;
        if (aVar != null) {
            aVar.i();
        }
        com.tencent.mobileqq.qqlive.anchor.report.a aVar2 = this.G;
        if (aVar2 != null) {
            aVar2.D();
        }
        if (this.f270783i.ordinal() >= QQLiveAnchorRoomState.STATE_PUBLISH_ING.ordinal()) {
            String str = this.f270781f.roomData.programId;
            Intrinsics.checkNotNullExpressionValue(str, "roomInfo.roomData.programId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveAnchorClosePushPullBroadcastRequest(str), new c(callback));
        } else {
            if (callback != null) {
                callback.onComplete(0, "");
            }
            if (this.G != null) {
                QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 6255;
                qQLiveErrorMsg.bizErrMsg = "obsRoom state error";
                com.tencent.mobileqq.qqlive.anchor.report.a aVar3 = this.G;
                if (aVar3 != null) {
                    aVar3.C(true, qQLiveErrorMsg);
                }
                com.tencent.mobileqq.qqlive.anchor.report.a aVar4 = this.G;
                if (aVar4 != null) {
                    aVar4.h(true, qQLiveErrorMsg);
                }
            }
        }
        t(QQLiveAnchorRoomState.STATE_LIVE_EXIT);
        this.f270782h.onExit();
        I();
        this.isExitRoom = true;
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.onExitRoom();
        }
        reset();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom
    public void getRtmpPushUrl(@Nullable QQLiveAnchorAutoCheckPullPlayParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorObsRoom", "getRtmpPushUrl", "start request rtmp push url");
        if (isDestroyed()) {
            return;
        }
        O().d(this.liveSDK, this.f270781f, params, new d(this.f270782h));
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void prepare(@Nullable Activity activity, @Nullable byte[] ext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) ext);
        } else {
            super.prepare(activity, ext);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom
    public boolean pushInfoReady() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo = this.pushInfo;
        if (qQLiveAnchorDataPushInfo != null) {
            if (qQLiveAnchorDataPushInfo != null) {
                str = qQLiveAnchorDataPushInfo.rtmpUrl;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom
    public void reconnectObsRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLiveAnchorObsRoom", "reconnectObsRoom", "start reconnectObsRoom");
        if (isDestroyed()) {
            return;
        }
        onEnterRoom();
        companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", " enter liveSDK Room success");
        this.K = true;
        this.f270782h.onEnterRoom();
        t(QQLiveAnchorRoomState.STATE_PUBLISH_ING);
        companion.i("Open_Live|QQLiveAnchorObsRoom", "reconnectObsRoom", "reconnect thirdPush push, auto start publishStream");
        t(QQLiveAnchorRoomState.STATE_PUBLISH_READY);
        this.f270782h.onPublishStream(new QQLiveAnchorDataPublishStream(true, null));
        t(QQLiveAnchorRoomState.STATE_LIVE_ING);
        this.F.n(this.f270779d, this.liveSDK.getAppId(), this);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom
    public void setPushInfo(@Nullable QQLiveAnchorDataPushInfo currentPushInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) currentPushInfo);
        } else {
            this.pushInfo = currentPushInfo;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void startPublishStream() {
        QQLiveAnchorRoomState qQLiveAnchorRoomState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "start enterRoom");
        if (isDestroyed()) {
            return;
        }
        QQLiveAnchorRoomState qQLiveAnchorRoomState2 = this.f270783i;
        if (qQLiveAnchorRoomState2 != QQLiveAnchorRoomState.STATE_ENTER_READY && qQLiveAnchorRoomState2 != (qQLiveAnchorRoomState = QQLiveAnchorRoomState.STATE_PUBLISH_FAILED)) {
            t(qQLiveAnchorRoomState);
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6255;
            qQLiveErrorMsg.bizErrMsg = "check publish error, curState=" + this.f270783i.name();
            this.f270782h.onPublishStream(new QQLiveAnchorDataPublishStream(false, qQLiveErrorMsg));
            this.f270782h.onError(qQLiveErrorMsg);
            return;
        }
        companion.i("Open_Live|QQLiveAnchorObsRoom", "enterRoom", "new thirdPush term, auto start publishStream");
        t(QQLiveAnchorRoomState.STATE_PUBLISH_READY);
        this.f270782h.onPublishStream(new QQLiveAnchorDataPublishStream(true, null));
        t(QQLiveAnchorRoomState.STATE_LIVE_ING);
        this.F.n(this.f270779d, this.liveSDK.getAppId(), this);
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom, com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void startSet(@Nullable QQLiveAnchorDataRoomAttr attr, @Nullable byte[] ext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) attr, (Object) ext);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom
    @NotNull
    protected String[] x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return T;
    }
}
