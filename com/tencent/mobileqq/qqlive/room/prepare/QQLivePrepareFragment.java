package com.tencent.mobileqq.qqlive.room.prepare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.LabelOriginInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRoomSetting;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.room.anchorcenter.QQLiveAnchorCenterFragment;
import com.tencent.mobileqq.qqlive.room.dialog.a;
import com.tencent.mobileqq.qqlive.room.floatview.QQLiveGameRoomService;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveAnchorActivity;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.room.livelabel.SelectLabelDialog;
import com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment;
import com.tencent.mobileqq.qqlive.room.prepare.event.DelMessageCenterRedPointEvent;
import com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment;
import com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog;
import com.tencent.mobileqq.qqlive.sail.ui.QQLiveCameraAnchorFragment;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveSetAnchorLabelRequest;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes17.dex */
public class QQLivePrepareFragment extends QQLiveBaseFragment implements View.OnClickListener, com.tencent.mobileqq.qqlive.room.prepare.d, si2.a, SimpleEventReceiver, QQLivePreparePlayTogetherPart.b {
    static IPatchRedirector $redirector_;
    private ViewGroup D;
    protected IQQLiveModuleAnchor E;
    private IQQLiveAnchorPrepareWrapper F;
    private com.tencent.mobileqq.mvvm.d G;
    private com.tencent.mobileqq.qqlive.room.prepare.k H;
    private View I;
    private View J;
    private RelativeLayout K;
    private TextView L;
    private ImageView M;
    private URLImageView N;
    private URLImageView P;
    private EditText Q;
    private ImageView R;
    private LinearLayout S;
    private TextView T;
    private CheckBox U;
    private TextView V;
    private Button W;
    private QQCustomDialog X;
    private QQECLiveEntryGoodsData Y;
    private FrameLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f271869a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f271870b0;

    /* renamed from: c0, reason: collision with root package name */
    private final com.tencent.mobileqq.qqlive.base.permission.a f271871c0;

    /* renamed from: d0, reason: collision with root package name */
    private Uri f271872d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f271873e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f271874f0;

    /* renamed from: g0, reason: collision with root package name */
    private t f271875g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f271876h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f271877i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f271878j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f271879k0;

    /* renamed from: l0, reason: collision with root package name */
    private LabelModel f271880l0;

    /* renamed from: m0, reason: collision with root package name */
    private TextView f271881m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f271882n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f271883o0;

    /* renamed from: p0, reason: collision with root package name */
    private long f271884p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f271885q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f271886r0;

    /* renamed from: s0, reason: collision with root package name */
    private nf4.b f271887s0;

    /* renamed from: t0, reason: collision with root package name */
    private final QQLiveAnchorRoomThirdPushBaseCallback f271888t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        class C8377a extends IQQLiveGetRealNameAuthCallback {
            static IPatchRedirector $redirector_;

            C8377a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback
            public void onSuccess(@NonNull QQLiveRealNameAuthData qQLiveRealNameAuthData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveRealNameAuthData);
                    return;
                }
                super.onSuccess(qQLiveRealNameAuthData);
                if (qQLiveRealNameAuthData != null && qQLiveRealNameAuthData.getAuthState() == 1) {
                    QQLivePrepareFragment.this.Ai();
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(DialogInterface dialogInterface, int i3) {
            QQLivePrepareFragment.this.yj();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(DialogInterface dialogInterface, int i3) {
            QQLivePrepareFragment.this.Ci();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onError(QQLiveErrorMsg qQLiveErrorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveErrorMsg);
                return;
            }
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "onError", "errorCode:" + qQLiveErrorMsg.originErrCode + ", errorMsg:" + qQLiveErrorMsg.originErrMsg);
            int i3 = qQLiveErrorMsg.originErrCode;
            if (i3 == 10110010) {
                QQLiveGameRoomService.f();
                QQLivePrepareFragment.this.Nj("\u5173\u64ad\u5931\u8d25\u4e86\uff0c\u8bf7\u91cd\u8bd5");
                QQLivePrepareFragment.this.Di();
            } else if (i3 == 2003) {
                qg4.e.b("\u76d1\u6d4b\u5230\u4f60\u5f53\u524d\u6b63\u5728\u76f4\u64ad\u4e2d\uff0c\u70b9\u51fb\u3010\u7acb\u5373\u524d\u5f80\u3011\u53ef\u8fdb\u5165\u76f4\u64ad\u7ba1\u7406\u9875", "\u7acb\u5373\u524d\u5f80", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.v
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        QQLivePrepareFragment.a.this.c(dialogInterface, i16);
                    }
                }, "\u5173\u95ed\u76f4\u64ad", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.w
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        QQLivePrepareFragment.a.this.d(dialogInterface, i16);
                    }
                });
            } else if (QQLivePrepareFragment.this.H != null) {
                QQLivePrepareFragment.this.H.d2(QQLivePrepareFragment.this.getActivity(), qQLiveErrorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onEvent(QQLiveEventMsg qQLiveEventMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQLiveEventMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onFaceAuth(QQLiveAnchorDataAuth qQLiveAnchorDataAuth) {
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQLiveAnchorDataAuth);
                return;
            }
            super.onFaceAuth(qQLiveAnchorDataAuth);
            if (qQLiveAnchorDataAuth == null || qQLiveAnchorDataAuth.errorMsg == null) {
                AegisLogger.e("Open_Live|QQLivePrepareFragment", "onFaceAuth", "onFaceAuth \u5b9e\u540d\u8ba4\u8bc1\u4fe1\u606f\u4e3a\u7a7a");
            }
            if (qQLiveAnchorDataAuth != null) {
                nf4.f Oi = QQLivePrepareFragment.this.Oi();
                boolean z16 = qQLiveAnchorDataAuth.isSuccess;
                if (z16) {
                    i3 = 0;
                } else {
                    QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataAuth.errorMsg;
                    if (qQLiveErrorMsg != null) {
                        i3 = qQLiveErrorMsg.originErrCode;
                    } else {
                        i3 = -111;
                    }
                }
                if (z16) {
                    str = "";
                } else {
                    QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataAuth.errorMsg;
                    if (qQLiveErrorMsg2 != null) {
                        str = qQLiveErrorMsg2.originErrMsg;
                    } else {
                        str = GlobalUtil.DEF_STRING;
                    }
                }
                Oi.d(z16, i3, str);
                if (qQLiveAnchorDataAuth.errorMsg.originErrCode == 999) {
                    AegisLogger.e("Open_Live|QQLivePrepareFragment", "onFaceAuth", "onFaceAuth \u7528\u6237\u4e3b\u52a8\u53d6\u6d88\u4e86\u5b9e\u540d\u8ba4\u8bc1");
                    QQLivePrepareFragment.this.Mj();
                }
            }
            if (QQLivePrepareFragment.this.H != null) {
                QQLivePrepareFragment.this.H.O1(1, new C8377a());
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
        public void onGetPushInfo(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPushInfo);
            } else {
                super.onGetPushInfo(qQLiveAnchorDataPushInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(@NonNull QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQLiveAnchorDataPrepare);
                return;
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "onPrepare", "isSuccess:" + qQLiveAnchorDataPrepare.isSuccess);
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 != null) {
                ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(c16.n()).eventId(QQLiveReportConstants.Event.E_QQ_LIVE_ROOM_PREPARED));
            }
            QQLivePrepareFragment.this.H.o2(qQLiveAnchorDataPrepare);
            QQLivePrepareFragment qQLivePrepareFragment = QQLivePrepareFragment.this;
            qQLivePrepareFragment.Fj(qQLivePrepareFragment.D);
            QQLivePrepareFragment.this.H.f271955m = qQLiveAnchorDataPrepare.isSuccess;
            QQLivePrepareFragment.this.H.G.setValue(1);
            QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = new QQLiveAnchorAutoCheckPullPlayParams();
            qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay = true;
            qQLiveAnchorAutoCheckPullPlayParams.isMute = true;
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr;
            if (qQLiveAnchorDataRoomAttr == null || qQLiveAnchorDataRoomAttr.gameInfo == null || QQLivePrepareFragment.this.f271877i0) {
                QQLivePrepareFragment.this.H.P1(true);
            }
            QQLivePrepareFragment.this.Gj();
            nf4.f Oi = QQLivePrepareFragment.this.Oi();
            boolean z16 = qQLiveAnchorDataPrepare.isSuccess;
            if (z16) {
                i3 = 0;
            } else {
                QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataPrepare.errorMsg;
                if (qQLiveErrorMsg != null) {
                    i3 = qQLiveErrorMsg.originErrCode;
                } else {
                    i3 = -111;
                }
            }
            if (z16) {
                str = "";
            } else {
                QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataPrepare.errorMsg;
                if (qQLiveErrorMsg2 != null) {
                    str = qQLiveErrorMsg2.originErrMsg;
                } else {
                    str = GlobalUtil.DEF_STRING;
                }
            }
            Oi.a(z16, i3, str, false);
            QQLivePrepareFragment.this.Ej();
            QQLivePrepareFragment.this.Hj();
            QQLivePrepareFragment.this.Ui(qQLiveAnchorDataPrepare);
            QQLivePrepareFragment.this.Ni();
            kl4.s.l(QQLivePrepareFragment.this.getActivity(), qQLiveAnchorDataPrepare.popupDialogUrl);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                QQLivePrepareFragment.this.wj(qQLiveAnchorDataSet);
            } else {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQLiveAnchorDataSet);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onStartFaceAuth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                super.onStartFaceAuth();
                QQLivePrepareFragment.this.Oi().a(false, 1004, "\u672a\u5b9e\u540d", true);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onStateChange(QQLiveAnchorRoomState qQLiveAnchorRoomState, QQLiveAnchorRoomState qQLiveAnchorRoomState2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQLiveAnchorRoomState, (Object) qQLiveAnchorRoomState2);
                return;
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "onStateChange", "oldState: " + qQLiveAnchorRoomState.name() + ", newState" + qQLiveAnchorRoomState2.name());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
            } else {
                super.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                QQLivePrepareFragment.this.Bi();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                QQLivePrepareFragment.this.Qj("-1", "the initial permission was been denied");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class c implements nf4.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoom f271892a;

        c(IQQLiveAnchorRoom iQQLiveAnchorRoom) {
            this.f271892a = iQQLiveAnchorRoom;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this, (Object) iQQLiveAnchorRoom);
            }
        }

        @Override // nf4.b
        public void onFailed(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QQLiveGameRoomService.f();
            QQLivePrepareFragment.this.Qj(String.valueOf(i3), "[jumpToGameLiveRoom]" + str);
            QQLivePrepareFragment qQLivePrepareFragment = QQLivePrepareFragment.this;
            if (TextUtils.isEmpty(str)) {
                str = "\u5f00\u64ad\u5931\u8d25";
            }
            qQLivePrepareFragment.Nj(str);
        }

        @Override // nf4.b
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f271892a;
            if (iQQLiveAnchorRoom != null && (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom)) {
                tk4.a.a(((IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom).getVideoQuality(), QQLiveReportConstants.Event.E_ANCHOR_START_PUSH_ENCODE_PARAMS);
            }
            QQLivePrepareFragment.this.Uj(this.f271892a);
            QQLivePrepareFragment.this.Rj(QQLiveReportConstants.Event.E_SUCCESS_START_LIVE);
            QQLivePrepareFragment.this.Di();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class d extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataSet);
            } else {
                super.onSet(qQLiveAnchorDataSet);
                QQLivePrepareFragment.this.ej();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class e extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataSet);
            } else {
                super.onSet(qQLiveAnchorDataSet);
                QQLivePrepareFragment.this.kj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class f extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                QQLivePrepareFragment.this.showActionSheet();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            QQLivePrepareFragment qQLivePrepareFragment = QQLivePrepareFragment.this;
            qQLivePrepareFragment.Nj(qQLivePrepareFragment.getResources().getString(R.string.f210375hy));
            AegisLogger.d("Open_Live|QQLivePrepareFragment", "checkPermissionAndChoosePic", "the initial permission read write storage was been denied");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class g implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f271897d;

        g(ActionSheet actionSheet) {
            this.f271897d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                QQLivePrepareFragment.this.Sj();
            } else if (i3 == 1) {
                QQLivePrepareFragment.this.Tj();
            }
            this.f271897d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class h extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QQLivePrepareFragment.this.f271872d0 = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(QQLivePrepareFragment.this.getActivity(), 1);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "takePhotoFromCamera", "permission denied");
            QQLivePrepareFragment.this.Nj("\u6388\u6743\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class i implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f271900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRecord f271901b;

        i(String str, QQLiveAnchorRecord qQLiveAnchorRecord) {
            this.f271900a = str;
            this.f271901b = qQLiveAnchorRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLivePrepareFragment.this, str, qQLiveAnchorRecord);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.dialog.a.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QQLivePrepareFragment qQLivePrepareFragment = QQLivePrepareFragment.this;
            QQLiveAnchorRecord qQLiveAnchorRecord = this.f271901b;
            qQLivePrepareFragment.gj(qQLiveAnchorRecord.roomId, qQLiveAnchorRecord.programId);
        }

        @Override // com.tencent.mobileqq.qqlive.room.dialog.a.b
        public void onCancelClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "checkValidAnchorRecord", "cancel the anchor record uin " + this.f271900a);
            ((QQLiveBaseFragment) QQLivePrepareFragment.this).C.getAnchorModule().removeAnchorRecord(this.f271900a);
            QQLivePrepareFragment.this.Ai();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class j implements nf4.b {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // nf4.b
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QQLivePrepareFragment.this.Qj(String.valueOf(i3), "[jumpToFastResumeRoom]" + str);
            QQLivePrepareFragment qQLivePrepareFragment = QQLivePrepareFragment.this;
            if (TextUtils.isEmpty(str)) {
                str = QQLivePrepareFragment.this.getResources().getString(R.string.f210165hd);
            }
            qQLivePrepareFragment.Nj(str);
        }

        @Override // nf4.b
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLivePrepareFragment.this.Rj(QQLiveReportConstants.Event.E_SUCCESS_START_LIVE);
                QQLivePrepareFragment.this.getQBaseActivity().finish();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* loaded from: classes17.dex */
    class k implements QQLiveSettingDialog.b {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog.b
        @NonNull
        public List<ResolutionLevelType> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ResolutionLevelType.INSTANCE.getSupportResLevelsForCapture(QQLivePrepareFragment.this.getContext());
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog.b
        public void b(@NonNull ResolutionLevelType resolutionLevelType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) resolutionLevelType);
            } else {
                LiveMediaConfigManager.INSTANCE.setResolutionLevelTypeCache(resolutionLevelType);
            }
        }
    }

    /* loaded from: classes17.dex */
    class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f271905d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f271906e;

        l(int i3, String str) {
            this.f271905d = i3;
            this.f271906e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLivePrepareFragment.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QBaseActivity qBaseActivity = QQLivePrepareFragment.this.getQBaseActivity();
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                AegisLogger.i("Open_Live|QQLivePrepareFragment", "onInitLiveSdkFailure", "errorCode:" + this.f271905d + ",errorMsg:" + this.f271906e);
                qBaseActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                kl4.s.INSTANCE.d(false, Long.valueOf(QQLivePrepareFragment.this.H.f271954i.roomAttr.roomId), Long.valueOf(QQLivePrepareFragment.this.F.getRoomInfo().uid));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class n implements nf4.b {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // nf4.b
        public void onFailed(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QQLivePrepareFragment.this.zj(String.valueOf(i3), "[reConnectObsRoom]" + str);
            QQLivePrepareFragment.this.Nj(str);
            QQLivePrepareFragment.this.Di();
        }

        @Override // nf4.b
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLivePrepareFragment.this.Aj();
                QQLivePrepareFragment.this.Di();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class o extends IQQLiveGetRoomSettingCallback {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, @org.jetbrains.annotations.Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "getRoomSettings", "onFailed: errorCode:" + i3 + " errorMsg:" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback
        public void onSuccess(@NotNull QQLiveRoomSetting qQLiveRoomSetting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveRoomSetting);
                return;
            }
            AegisLogger.d("Open_Live|QQLivePrepareFragment", "getRoomSettings", "onSuccess: isHiddenUserinfo:" + qQLiveRoomSetting.isHiddenUserinfo());
            ct3.a.n("MMKV_KEY_HIDE_ROOM_NICKNAME", QQLivePrepareFragment.this.H.f271954i.roomAttr.roomId, qQLiveRoomSetting.isHiddenUserinfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class p implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                return;
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "getRedPoint", "show:" + bool + " taskId:" + QQLivePrepareFragment.this.H.M);
            if (bool != null && bool.booleanValue()) {
                QQLivePrepareFragment.this.f271870b0.setVisibility(0);
            } else {
                QQLivePrepareFragment.this.f271870b0.setVisibility(8);
            }
            QQLivePrepareFragment qQLivePrepareFragment = QQLivePrepareFragment.this;
            qQLivePrepareFragment.Cj(qQLivePrepareFragment.H.M);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class q implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                QQLivePrepareFragment.this.H.H.setValue(Boolean.valueOf(z16));
                QQLivePrepareFragment.this.H.getRepository().o(z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class r implements TextWatcher {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            } else if (!TextUtils.isEmpty(editable.toString())) {
                QQLivePrepareFragment.this.R.setVisibility(8);
            } else {
                QQLivePrepareFragment.this.R.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            Editable text = QQLivePrepareFragment.this.Q.getText();
            if (QQLivePrepareFragment.this.H != null) {
                QQLivePrepareFragment.this.H.p2(text.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class s implements IQQLiveLoginCallback {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "initData", "the user login action is fail errorCode " + i3);
            ((QQLiveBaseFragment) QQLivePrepareFragment.this).C.getLoginModule().unregisterLoginStateCallback(this);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo);
                return;
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "initData", "the user login action onSuccess ");
            ((QQLiveBaseFragment) QQLivePrepareFragment.this).C.getLoginModule().unregisterLoginStateCallback(this);
            QQLivePrepareFragment.this.ti();
        }
    }

    /* loaded from: classes17.dex */
    private static class t extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private QQLivePrepareFragment f271915a;

        public t(QQLivePrepareFragment qQLivePrepareFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLivePrepareFragment);
            } else {
                this.f271915a = qQLivePrepareFragment;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            try {
                String action = intent.getAction();
                long longExtra = intent.getLongExtra("broadcast_send_time", 0L);
                AegisLogger.i("Open_Live|QQLivePrepareFragment", "ClosePreparePageBroadcastReceiver", "close receiver, action:" + action);
                if (TextUtils.equals("qqlive_anchor_prepare_fragment", intent.getAction()) && System.currentTimeMillis() - longExtra <= 1000) {
                    this.f271915a.getQBaseActivity().finish();
                }
            } catch (Throwable th5) {
                AegisLogger.e("Open_Live|QQLivePrepareFragment", "ClosePreparePageBroadcastReceiver", String.valueOf(th5));
            }
        }
    }

    public QQLivePrepareFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271871c0 = new com.tencent.mobileqq.qqlive.base.permission.a();
        this.f271873e0 = false;
        this.f271874f0 = false;
        this.f271875g0 = new t(this);
        this.f271886r0 = false;
        this.f271887s0 = null;
        this.f271888t0 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai() {
        IQQLiveModuleAnchor iQQLiveModuleAnchor;
        long j3;
        this.E = this.C.getAnchorModule();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && (iQQLiveModuleAnchor = this.E) != null) {
            this.F = iQQLiveModuleAnchor.createPrepareWrapper();
            if (this.C.getLoginModule().getLoginInfo() != null) {
                j3 = this.C.getLoginModule().getLoginInfo().uid;
            } else {
                j3 = 0;
            }
            Bundle arguments = getArguments();
            String str = "0";
            if (arguments != null) {
                str = arguments.getString("source", "0");
            }
            this.F.init(this.C, j3, str);
            IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
            iQQLiveAnchorPrepareWrapper.prepare(qBaseActivity, iQQLiveAnchorPrepareWrapper.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID), this.f271888t0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj() {
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID).n()).eventId(QQLiveReportConstants.Event.E_ANCHOR_RECONNECT_OBS_ROOM).retCode(String.valueOf(0)).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi() {
        String str;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar == null) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "doWhenClickStartLive", "invoke fail, prepareViewModel is null");
            return;
        }
        QQLiveAnchorDataPrepare X1 = kVar.X1(1, this.f271880l0);
        Kj(X1);
        HashMap hashMap = new HashMap();
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = X1.roomAttr.gameInfo;
        if (qQLiveAnchorRoomGameInfo != null) {
            hashMap.put("qqlive_zhibo_content", String.valueOf(qQLiveAnchorRoomGameInfo.f271211id));
        }
        hashMap.put("qqlive_title_content", X1.roomAttr.roomName);
        if (TextUtils.isEmpty(X1.roomAttr.city)) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("qqlive_is_located", str);
        hashMap.put("qqlive_start_type", String.valueOf(this.H.G.getValue()));
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("clck", this.W, hashMap);
    }

    private void Bj(Bundle bundle) {
        if (bundle != null) {
            this.f271876h0 = bundle.getString("game_openid");
            this.f271877i0 = bundle.getBoolean("from_onekey", false);
            this.f271878j0 = bundle.getInt(RoomServiceConstants.PARAMS_GAME_ID, 0);
            this.f271879k0 = bundle.getString("jumpcmd");
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "readArguments", "readArguments### gameOpenId: " + this.f271876h0 + ", fromOneKeyLive = " + this.f271877i0 + ", gameId = " + this.f271878j0 + ", jumpCmd = " + this.f271879k0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        if (this.f271874f0) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "exitCurrentObsRoom", "exit while QQLivePrepareFragment is destroyed!");
            return;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar != null && (qQLiveAnchorDataPrepare = kVar.f271954i) != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorDataPrepare.roomInfo) != null) {
            String str = qQLiveAnchorDataRoomInfo.programId;
            IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
            if (iQQLiveAnchorPrepareWrapper != null) {
                iQQLiveAnchorPrepareWrapper.getObsModule().exitObsRoom(str);
                return;
            } else {
                AegisLogger.e("Open_Live|QQLivePrepareFragment", "exitCurrentObsRoom", "exit while prepareData is null!");
                return;
            }
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "exitCurrentObsRoom", "exit while prepareData is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    private void Dj() {
        ResolutionLevelType resolutionLevelTypeCache = LiveMediaConfigManager.INSTANCE.getResolutionLevelTypeCache(null);
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_clarity_success", String.valueOf(resolutionLevelTypeCache.getCode()));
        VideoReport.reportEvent("ev_qqlive_clarity_live", hashMap);
    }

    private QQLiveAnchorDataUserInfo Ei() {
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo = new QQLiveAnchorDataUserInfo();
        qQLiveAnchorDataUserInfo.f271213id = this.C.getLoginModule().getLoginInfo().uid;
        qQLiveAnchorDataUserInfo.explicitId = 0L;
        qQLiveAnchorDataUserInfo.nickName = this.C.getLoginModule().getLoginInfo().userInfo.nick;
        qQLiveAnchorDataUserInfo.avatarUrl = this.C.getLoginModule().getLoginInfo().userInfo.headUrl;
        qQLiveAnchorDataUserInfo.initialClientType = QQLiveConfigConst.CLIENT_TYPE;
        qQLiveAnchorDataUserInfo.businessUid = this.C.getLoginModule().getLoginInfo().businessUid;
        qQLiveAnchorDataUserInfo.tinyId = this.C.getLoginModule().getLoginInfo().tinyid;
        return qQLiveAnchorDataUserInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar != null && (iQQLiveAnchorPrepareWrapper = this.F) != null) {
            if (this.Y == null) {
                if (kVar.f271955m) {
                    cj4.c.f31003a.m(kVar.f271954i.roomAttr.roomId, iQQLiveAnchorPrepareWrapper.getRoomInfo().uid, new Function1() { // from class: com.tencent.mobileqq.qqlive.room.prepare.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit sj5;
                            sj5 = QQLivePrepareFragment.this.sj((QQECLiveEntryGoodsData) obj);
                            return sj5;
                        }
                    });
                    return;
                }
                return;
            } else {
                if (aj()) {
                    Vj(Yi(), this.Y.getLiveGoodsNumber(), this.Y.getLiveShopGoodsNumber());
                }
                AegisLogger.d("Open_Live|QQLivePrepareFragment", "requestLiveData", "respData:" + this.Y.toString());
                return;
            }
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "requestLiveData", "while prepareViewModel or prepareWrapper is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public Intent Fi() {
        Intent intent = new Intent();
        intent.putExtra("source", this.H.b2());
        if (getArguments() != null && !TextUtils.isEmpty(getArguments().getString("clear_top"))) {
            intent.putExtra("clear_top", getArguments().getString("clear_top"));
        }
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null) {
            intent.putExtra("KEY_LIVE_ENTRY_GOODS_DATA", qQECLiveEntryGoodsData);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj(View view) {
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().i(this, view, "pg_qqlive_gamelive_start", com.tencent.mobileqq.qqlive.room.prepare.f.c(this.H, this.C));
    }

    private int Gi() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getLiveShopGoodsNumber();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj() {
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.K, "em_qqlive_content_choice", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.P, "em_qqlive_cover_edit", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.Q, "em_qqlive_title_edit", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.S, "em_qqlive_mylocation", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.W, "em_qqlive_live_start", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.U, "em_qqlive_protocol", hashMap);
    }

    private int Hi() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getLiveGokGoodsNumber();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hj() {
        Bundle bundle = new Bundle();
        bundle.putString("qqlive_zhibo_type", String.valueOf(0));
        bundle.putString("qqlive_anchor_id", String.valueOf(this.C.getLoginModule().getLoginInfo().uid));
        bundle.putString("qqlive_room_id", String.valueOf(this.H.f271954i.roomAttr.roomId));
        bundle.putString("qqlive_user_id", String.valueOf(this.C.getLoginModule().getLoginInfo().uid));
        bundle.putString("qqlive_program_id", this.H.f271954i.roomInfo.programId);
        cj4.c.f31003a.c("ACTION_SETUP_LIVE_REPORT_INFO", bundle, null);
    }

    private int Ii() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getLiveGoodsNumber();
        }
        return 0;
    }

    private void Ij() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar != null && this.F != null) {
            QQLiveAnchorDataPrepare X1 = kVar.X1(1, this.f271880l0);
            IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
            iQQLiveAnchorPrepareWrapper.set(X1.roomAttr, iQQLiveAnchorPrepareWrapper.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID), new d());
            return;
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "setPrepareDataBeforeJumpLivePreparePage", "while prepareViewModel or prepareWrapper is null");
    }

    private String Ji() {
        return ht3.a.d("qqlive_open_live_protocol_url", "https://qlive.qq.com/cos/live/h5/policys/index.html?_wv=2");
    }

    private void Jj() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar != null && this.F != null) {
            QQLiveAnchorDataPrepare X1 = kVar.X1(1, this.f271880l0);
            IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
            iQQLiveAnchorPrepareWrapper.set(X1.roomAttr, iQQLiveAnchorPrepareWrapper.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID), new e());
            return;
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "setPrepareDataBeforeJumpThirdpushPreparePage", "while prepareViewModel or prepareWrapper is null");
    }

    private int Ki() {
        int i3;
        int i16;
        int i17 = 0;
        if (Gi() > 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (Ii() > 0) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int i18 = i3 | i16;
        if (Hi() > 0 && Yi()) {
            i17 = 1;
        }
        return i18 | i17;
    }

    private void Kj(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        if (this.E != null && this.F != null) {
            this.f271884p0 = System.currentTimeMillis();
            qQLiveAnchorDataPrepare.roomAttr.isECGoodsLive = aj();
            qQLiveAnchorDataPrepare.roomAttr.openTabLevel = Ki();
            IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
            iQQLiveAnchorPrepareWrapper.set(qQLiveAnchorDataPrepare.roomAttr, iQQLiveAnchorPrepareWrapper.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID), this.f271888t0);
            cj4.c.f31003a.l(qQLiveAnchorDataPrepare.roomAttr.isECGoodsLive);
            return;
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "setRoomInfoBeforeJumpLiveRoom", "while anchorModule or prepareWrapper is null");
    }

    private QQLiveAnchorStreamRecordType Li(com.tencent.mobileqq.qqlive.room.prepare.k kVar) {
        if (kVar == null) {
            return QQLiveAnchorStreamRecordType.SCREEN;
        }
        Integer value = kVar.G.getValue();
        if (value == null) {
            return QQLiveAnchorStreamRecordType.SCREEN;
        }
        if (value.intValue() == 2) {
            return QQLiveAnchorStreamRecordType.THIRD_PUSH;
        }
        return QQLiveAnchorStreamRecordType.SCREEN;
    }

    private void Lj(boolean z16) {
        AegisLogger.i("Open_Live|QQLivePrepareFragment", "setSelectGameLabelView", "mLastSelectLabel=" + this.f271880l0);
        if (this.f271880l0 == null) {
            this.L.setText("\u76f4\u64ad\u6e38\u620f");
            this.f271881m0.setText("\u672a\u9009\u62e9");
            this.N.setVisibility(8);
            return;
        }
        this.N.setVisibility(0);
        if (!TextUtils.isEmpty(this.f271880l0.title)) {
            this.L.setText(this.f271880l0.title);
        }
        this.f271881m0.setText("\u66f4\u6362\u76f4\u64ad\u6e38\u620f");
        if (!TextUtils.isEmpty(this.f271880l0.iconUrl)) {
            uj(this.N, 60, 60, this.f271880l0.iconUrl, R.drawable.nmk);
        }
        if (z16) {
            this.mPartManager.broadcastMessage("MSG_NOTIFY_LIVE_GAME_CHANGE", this.f271880l0);
        }
    }

    private void Mi() {
        AegisLogger.d("Open_Live|QQLivePrepareFragment", "getRedPoint", "getRedPoint...");
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar == null) {
            return;
        }
        kVar.L.observe(getViewLifecycleOwner(), new p());
        this.H.Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj() {
        View view = this.f271882n0;
        if (view != null) {
            view.setVisibility(0);
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (QQLivePrepareFragment.this.f271882n0 != null) {
                    QQLivePrepareFragment.this.f271882n0.setVisibility(4);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ni() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar == null) {
            AegisLogger.w("Open_Live|QQLivePrepareFragment", "getRoomSettings", "prepareViewModel == null");
            return;
        }
        long j3 = kVar.f271954i.roomAttr.roomId;
        if (j3 <= 0) {
            AegisLogger.w("Open_Live|QQLivePrepareFragment", "getRoomSettings", "invalid room id");
        } else {
            kVar.a2(j3, new o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context activity = getActivity();
            if (activity == null) {
                activity = BaseApplication.getContext();
            }
            if (activity != null) {
                QQToast.makeText(activity, 1, str, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nf4.f Oi() {
        return ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).oneKeyLiveHandler().h();
    }

    private void Oj(int i3, int i16, final DialogInterface.OnClickListener onClickListener) {
        DialogInterface.OnClickListener onClickListener2;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (this.X == null) {
                String string = activity.getResources().getString(i3);
                String string2 = activity.getResources().getString(i16);
                if (onClickListener != null) {
                    onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.u
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i17) {
                            QQLivePrepareFragment.tj(onClickListener, dialogInterface, i17);
                        }
                    };
                } else {
                    onClickListener2 = null;
                }
                this.X = DialogUtil.createCustomDialog(activity, 230, (String) null, string, (String) null, string2, onClickListener2, (DialogInterface.OnClickListener) null);
            }
            if (!this.X.isShowing()) {
                this.X.setMessage(activity.getResources().getString(i3));
                this.X.show();
                return;
            }
            return;
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "showTipDialog", "the activity is null or is finished");
    }

    private String Pi(String str) {
        if (this.H != null && this.F != null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("live_user_id", String.valueOf(this.F.getRoomInfo().uid));
            buildUpon.appendQueryParameter("live_room_id", String.valueOf(this.H.f271954i.roomAttr.roomId));
            return buildUpon.build().toString();
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "getWindowSchemeWithParams", "while prepareViewModel or prepareWrapper is null");
        return "";
    }

    public static void Pj(Context context, Intent intent, String str) {
        com.tencent.mobileqq.qqlive.anchor.live.utils.b.b().e(1);
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("moduleId", "qq_live");
        intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, str);
        intent.putExtra("key_intent_app_id", QQLiveBusinessConfig.QQLIVE_APP_ID);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QQLIVE_SKIN");
        if (TextUtils.isEmpty(intent.getStringExtra("clear_top"))) {
            intent.addFlags(67108864);
        }
        QPublicFragmentActivity.b.b(context, intent, QQLiveAnchorActivity.class, QQLivePrepareFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
        IQQLiveAnchorRoom curRoom;
        IQQLiveModuleAnchor iQQLiveModuleAnchor = this.E;
        if (iQQLiveModuleAnchor == null) {
            curRoom = null;
        } else {
            curRoom = iQQLiveModuleAnchor.getCurRoom();
        }
        if (curRoom != null) {
            curRoom.destroy();
        }
        Di();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj(String str, String str2) {
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "startLiveFailReportReason", str2);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(c16.n()).retCode(str).desc(str2).eventId(QQLiveReportConstants.Event.E_BEFORE_START_LIVE_FAIL_REASON).ext6(QQLiveReportConstants.Scene.SCENE_START_QQ_LIVE));
        }
    }

    private void Ri() {
        Rj(QQLiveReportConstants.Event.E_BEGIN_START_LIVE);
        if (this.H == null) {
            Qj("-1", "prepareViewModel == null");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            Nj("\u7f51\u7edc\u5df2\u65ad\u5f00\uff0c\u8bf7\u8fde\u63a5\u540e\u91cd\u8bd5\u3002");
            Qj("-1", RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
            return;
        }
        QQLiveRealNameAuthData qQLiveRealNameAuthData = this.H.C;
        if (qQLiveRealNameAuthData != null && (qQLiveRealNameAuthData.getAuthState() == 2 || this.H.C.getAuthState() == 0)) {
            Oj(R.string.f210545ie, R.string.f169272hw, null);
            Qj(String.valueOf(this.H.C.getAuthState()), "auth fail");
            return;
        }
        QQLiveRealNameAuthData qQLiveRealNameAuthData2 = this.H.C;
        if (qQLiveRealNameAuthData2 != null && qQLiveRealNameAuthData2.getAuthState() == 3) {
            Oj(R.string.f210295hq, R.string.f169272hw, null);
            Qj(String.valueOf(this.H.C.getAuthState()), "auth_under_age");
            return;
        }
        if (this.f271880l0 == null) {
            Nj(getResources().getString(R.string.f210875ja));
            Qj("-1", "mLastSelectLabel == null");
            return;
        }
        if (Boolean.FALSE.equals(this.H.H.getValue())) {
            Oj(R.string.f210895jc, R.string.f210885jb, null);
            Qj("-1", "no select Protocol");
            return;
        }
        if (TextUtils.isEmpty(this.H.W1().roomAttr.roomName)) {
            Qj("-1", "the room name is null");
            Nj(getResources().getString(R.string.f210195hg));
            return;
        }
        if (TextUtils.isEmpty(this.H.W1().roomAttr.poster16v9)) {
            Qj("-1", "the room cover is null");
            Nj(getResources().getString(R.string.f210105h8));
            return;
        }
        Object messageFromPart = this.mPartManager.getMessageFromPart("MSG_CAN_JUMP_PLAY_TOGETHER", null);
        if ((messageFromPart instanceof Boolean) && ((Boolean) messageFromPart).booleanValue()) {
            this.mPartManager.broadcastMessage("MSG_HANDLE_JUMP_PLAY_TOGETHER", null);
        } else {
            wi();
        }
        if (this.F != null && this.f271880l0 != null) {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetAnchorLabelRequest(this.F.getRoomInfo().uid, this.f271880l0.thirdLabelId), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj(String str) {
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(c16.n()).eventId(str).ext6(QQLiveReportConstants.Scene.SCENE_START_QQ_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
        }
    }

    private void Si() {
        if (Wi()) {
            return;
        }
        this.I.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj() {
        this.f271871c0.b(this, new h());
    }

    private void Ti() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.Y = (QQECLiveEntryGoodsData) getActivity().getIntent().getParcelableExtra("KEY_LIVE_ENTRY_GOODS_DATA");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", qBaseActivity.getClass().getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        qBaseActivity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoList(qBaseActivity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorDataPrepare.roomInfo;
        if (qQLiveAnchorDataRoomInfo != null) {
            List<LabelOriginInfo> list = qQLiveAnchorDataRoomInfo.labelOriginInfos;
            if (list == null) {
                AegisLogger.i("Open_Live|QQLivePrepareFragment", "initLiveLabelInfo", "labelOriginInfos = null");
                return;
            }
            for (LabelOriginInfo labelOriginInfo : list) {
                if (labelOriginInfo.getLabelType() == 2) {
                    LabelModel labelModel = new LabelModel();
                    this.f271880l0 = labelModel;
                    labelModel.thirdLabelId = labelOriginInfo.getId();
                    this.f271880l0.gameId = labelOriginInfo.getGameId();
                    this.f271880l0.secondId = labelOriginInfo.getSecondId();
                    LabelModel labelModel2 = this.f271880l0;
                    labelModel2.isSelected = true;
                    labelModel2.title = labelOriginInfo.getName();
                    this.f271880l0.iconUrl = labelOriginInfo.getLogo();
                    this.f271880l0.isGame = true;
                }
            }
        }
        Lj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uj(IQQLiveAnchorRoom iQQLiveAnchorRoom) {
        IQQLiveAnchorTRTCRoom iQQLiveAnchorTRTCRoom;
        if (iQQLiveAnchorRoom != null && (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom)) {
            iQQLiveAnchorTRTCRoom = (IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom;
        } else {
            iQQLiveAnchorTRTCRoom = null;
        }
        if (iQQLiveAnchorTRTCRoom == null) {
            AegisLogger.w("Open_Live|QQLivePrepareFragment", "updateCustomTrtcConfig", "trtcRoom is null!");
        } else if (ht3.a.e("qqlive_trtc_qos_smooth_mode", false)) {
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "updateCustomTrtcConfig", "set qos preference to QQLIVE_TRTC_QOS_SMOOTH_MODE");
            iQQLiveAnchorTRTCRoom.setNetworkQosPreferenceParam(new com.tencent.mobileqq.qqlive.trtc.encoder.a(1));
        }
    }

    private void Vi() {
        kl4.s.INSTANCE.g();
        View findViewById = this.D.findViewById(R.id.f60962wu);
        this.f271885q0 = findViewById;
        findViewById.setOnClickListener(new m());
    }

    private void Vj(boolean z16, int i3, int i16) {
        this.Z.setVisibility(0);
        int i17 = i3 + i16;
        if (z16) {
            i17 += this.Y.getLiveGokGoodsNumber();
        }
        this.Y.k(z16);
        if (i17 > 999) {
            ViewGroup.LayoutParams layoutParams = this.Z.getLayoutParams();
            layoutParams.width = -2;
            this.Z.setLayoutParams(layoutParams);
        } else if (i17 >= 100) {
            ViewGroup.LayoutParams layoutParams2 = this.Z.getLayoutParams();
            layoutParams2.width = ViewUtils.dip2px(24.0f);
            layoutParams2.height = ViewUtils.dip2px(14.0f);
            this.Z.setLayoutParams(layoutParams2);
        } else {
            ViewGroup.LayoutParams layoutParams3 = this.Z.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            this.Z.setLayoutParams(layoutParams3);
        }
        this.Y.l(i3);
        this.Y.m(i16);
        this.f271869a0.setText(String.valueOf(i17));
    }

    private boolean Wi() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public static boolean Xi(com.tencent.mobileqq.qqlive.room.prepare.a aVar) {
        if (aVar != null && (aVar.a() == 1 || "\u738b\u8005\u8363\u8000".equals(aVar.b()))) {
            return true;
        }
        return false;
    }

    private boolean Yi() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null && qQECLiveEntryGoodsData.getIsGokSelect()) {
            return true;
        }
        return false;
    }

    private boolean Zi() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null && qQECLiveEntryGoodsData.getIsGokWhiteListUser() && this.Y.getLiveGokGoodsNumber() > 0) {
            return true;
        }
        return false;
    }

    private boolean aj() {
        if ((!Yi() || Hi() <= 0) && Ii() <= 0 && Gi() <= 0) {
            return false;
        }
        return true;
    }

    private boolean bj() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.Y;
        if (qQECLiveEntryGoodsData != null && qQECLiveEntryGoodsData.getIsQShopWhiteListUser()) {
            return true;
        }
        return false;
    }

    private void cj() {
        String str;
        IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
        String str2 = "";
        if (iQQLiveAnchorPrepareWrapper == null || iQQLiveAnchorPrepareWrapper.getRoomInfo() == null || this.F.getRoomInfo().roomAttr == null) {
            str = "";
        } else {
            str = String.valueOf(this.F.getRoomInfo().roomAttr.roomId);
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar != null) {
            str2 = kVar.c2();
        }
        Intent intent = new Intent();
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.H;
        if (kVar2 != null) {
            intent.putExtra("param_message_red_point", kVar2.L.getValue());
            intent.putExtra("param_red_point_taskid", this.H.M);
        }
        QQLiveAnchorCenterFragment.INSTANCE.a(getQBaseActivity(), intent, str2, str);
    }

    private void dj() {
        SelectLabelDialog selectLabelDialog = new SelectLabelDialog(2L);
        selectLabelDialog.Ch(new SelectLabelDialog.b() { // from class: com.tencent.mobileqq.qqlive.room.prepare.p
            @Override // com.tencent.mobileqq.qqlive.room.livelabel.SelectLabelDialog.b
            public final void a(LabelModel labelModel) {
                QQLivePrepareFragment.this.lj(labelModel);
            }
        });
        selectLabelDialog.Bh(this.f271880l0);
        selectLabelDialog.show(getParentFragmentManager(), "SelectLabelDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment.14
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QQLivePrepareFragment.this.getQBaseActivity() != null) {
                    QQLivePrepareFragment.this.I.setClickable(false);
                    QQLivePrepareFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
                    QQLivePrepareFragment.this.Qi();
                    QQLiveCameraAnchorFragment.INSTANCE.a(QQLivePrepareFragment.this.getQBaseActivity(), QQLivePrepareFragment.this.Fi(), QQLivePrepareFragment.this.H.c2());
                }
            }
        });
        vj();
    }

    private void fj() {
        long j3;
        boolean z16;
        if (this.Y == null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.m
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePrepareFragment.this.mj();
                }
            });
            return;
        }
        EIPCResultCallback eIPCResultCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqlive.room.prepare.n
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQLivePrepareFragment.this.pj(eIPCResult);
            }
        };
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_LIVE_ROOM_ID", this.H.f271954i.roomAttr.roomId);
        IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
        if (iQQLiveAnchorPrepareWrapper != null) {
            j3 = iQQLiveAnchorPrepareWrapper.getRoomInfo().uid;
        } else {
            j3 = 0;
        }
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(j3));
        bundle.putBoolean("is_xiaodian_user", bj());
        bundle.putInt("live_product_counts", Ii());
        bundle.putInt("live_shop_product_counts", Gi());
        bundle.putBoolean("is_wangzhe_user", Zi());
        bundle.putBoolean("is_ecommerce_authenticated", this.Y.getIsEcomAuthenticated());
        if (Zi() && (com.tencent.mobileqq.qqlive.room.prepare.k.T || Yi())) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("is_wangzhe_select", z16);
        if (!this.Y.getIsEcomAuthenticated() && !bj()) {
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme("mqqapi://ecommerce/open?target=1&channel=8&src_type=internal&version=1&jump_scheme=" + Base64.encodeToString(Pi("mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1").getBytes(StandardCharsets.UTF_8), 0), null);
            return;
        }
        cj4.c.f31003a.c("ACTION_CLICK_LIVE_ENTRY", bundle, eIPCResultCallback);
        com.tencent.mobileqq.qqlive.room.prepare.k.T = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(long j3, String str) {
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).resumeGameLive(j3, str, new j());
    }

    private void hj() {
        String str;
        int i3;
        String str2;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
        if (kVar == null) {
            Qj("-1", "prepareViewModel == null");
            return;
        }
        LabelModel labelModel = this.f271880l0;
        QQLiveAnchorStreamRecordType Li = Li(kVar);
        if (!((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).checkAvEnable(getQBaseActivity())) {
            Qj("-1", "the audio is not enable");
            return;
        }
        if (!com.tencent.mobileqq.qqlive.base.permission.a.c(getActivity())) {
            Qj("-1", "FloatingBallPermission is not enable");
            return;
        }
        QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
        qQLiveAnchorRoomConfig.bizData.setMuteAllUser(true);
        qQLiveAnchorRoomConfig.streamRecordType = Li;
        PlayerConfig playerConfig = new PlayerConfig();
        qQLiveAnchorRoomConfig.playerConfig = playerConfig;
        playerConfig.playerSceneID = 129;
        IQQLiveAnchorRoom createRoom = this.C.getAnchorModule().createRoom(this.D.getContext(), qQLiveAnchorRoomConfig, null);
        createRoom.setAnchorRoomInfo(yi(this.H.f271954i));
        QQLiveGameRoomService.e(QQLiveGameRoomService.f271544m, createRoom.getAnchorRoomInfo().userDta.nickName);
        this.f271887s0 = new c(createRoom);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).startGameLive(qQLiveAnchorRoomConfig.streamRecordType, this.f271887s0);
        vj();
        nf4.f Oi = Oi();
        if (Li != null) {
            str = Li.name();
        } else {
            str = "null";
        }
        String str3 = str;
        if (labelModel != null) {
            i3 = labelModel.gameId;
        } else {
            i3 = -1;
        }
        int i16 = i3;
        if (labelModel != null) {
            str2 = labelModel.title;
        } else {
            str2 = "";
        }
        Oi.e(0, false, str3, i16, str2);
    }

    private void ij() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).openAnchorRoomPage(qBaseActivity);
        }
    }

    private void initData() {
        if (this.C.getLoginModule().isLogined()) {
            ti();
        } else {
            this.C.getLoginModule().registerLoginStateCallback(new s());
        }
    }

    private void initView() {
        this.I = this.D.findViewById(R.id.f61402y1);
        this.J = this.D.findViewById(R.id.f61392y0);
        this.K = (RelativeLayout) this.D.findViewById(R.id.f60912wp);
        this.L = (TextView) this.D.findViewById(R.id.f60892wn);
        this.f271881m0 = (TextView) this.D.findViewById(R.id.tri);
        this.M = (ImageView) this.D.findViewById(R.id.f60732w8);
        this.N = (URLImageView) this.D.findViewById(R.id.f60772wb);
        this.P = (URLImageView) this.D.findViewById(R.id.f60752w_);
        this.R = (ImageView) this.D.findViewById(R.id.f61362xx);
        this.Q = (EditText) this.D.findViewById(R.id.f60932wr);
        LinearLayout linearLayout = (LinearLayout) this.D.findViewById(R.id.f60812wf);
        this.S = linearLayout;
        linearLayout.setVisibility(8);
        this.T = (TextView) this.D.findViewById(R.id.f60792wd);
        this.U = (CheckBox) this.D.findViewById(R.id.f60852wj);
        this.V = (TextView) this.D.findViewById(R.id.f60872wl);
        this.W = (Button) this.D.findViewById(R.id.f60922wq);
        this.Z = (FrameLayout) this.D.findViewById(R.id.f60332v5);
        this.f271869a0 = (TextView) this.D.findViewById(R.id.f60342v6);
        this.D.findViewById(R.id.f60322v4).setOnClickListener(this);
        this.f271870b0 = this.D.findViewById(R.id.f61332xu);
        View findViewById = this.D.findViewById(R.id.f61322xt);
        this.f271883o0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f271882n0 = this.D.findViewById(R.id.f639134t);
        this.J.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.U.setOnCheckedChangeListener(new q());
        this.Q.addTextChangedListener(new r());
        Si();
        Vi();
    }

    private void initViewModel() {
        com.tencent.mobileqq.mvvm.d checkAndAddLifeCycleFragment = ((ILifeCycleFragmentInjectApi) QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getQBaseActivity());
        this.G = checkAndAddLifeCycleFragment;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = (com.tencent.mobileqq.qqlive.room.prepare.k) com.tencent.mobileqq.mvvm.h.b(checkAndAddLifeCycleFragment, com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.H = kVar;
        com.tencent.mobileqq.qqlive.room.prepare.l.g(this, kVar, this, getArguments());
    }

    private void jj() {
        Intent intent = new Intent(getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", Ji());
        getQBaseActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kj() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QQLivePrepareFragment.this.getQBaseActivity() != null) {
                    QQLivePrepareFragment.this.J.setClickable(false);
                    QQLivePrepareFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
                    QQLivePrepareFragment.this.Qi();
                    QQLiveRtmpPrepareFragment.INSTANCE.a(QQLivePrepareFragment.this.getQBaseActivity(), QQLivePrepareFragment.this.Fi(), QQLivePrepareFragment.this.H.c2());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lj(LabelModel labelModel) {
        if (labelModel == null) {
            return;
        }
        this.f271880l0 = labelModel;
        Lj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mj() {
        Nj("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void nj(boolean z16, int i3, int i16) {
        Vj(z16, i3, i16);
        if (!aj()) {
            this.Z.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oj() {
        Nj("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pj(EIPCResult eIPCResult) {
        if (eIPCResult == null) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "jumpToECLiveFloatPage", "ACTION_CLICK_LIVE_ENTRY error, result is null");
            return;
        }
        int i3 = eIPCResult.code;
        if (i3 == 0) {
            AegisLogger.d("Open_Live|QQLivePrepareFragment", "jumpToECLiveFloatPage", "ACTION_CLICK_LIVE_ENTRY onCallback result\uff1a" + eIPCResult.data);
            final int i16 = eIPCResult.data.getInt("live_product_counts");
            final int i17 = eIPCResult.data.getInt("live_shop_product_counts");
            final boolean z16 = eIPCResult.data.getBoolean("GOK_LIVE_SELECT_WANGZHE");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.q
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePrepareFragment.this.nj(z16, i16, i17);
                }
            });
            return;
        }
        if (i3 == -102) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.r
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePrepareFragment.this.oj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit qj(QQECLiveEntryGoodsData qQECLiveEntryGoodsData) {
        this.Y = qQECLiveEntryGoodsData;
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).reConnectObsPushRoom(yi(this.H.f271954i), new n());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rj(QQECLiveEntryGoodsData qQECLiveEntryGoodsData) {
        this.Y = qQECLiveEntryGoodsData;
        if (aj()) {
            Vj(Yi(), this.Y.getLiveGoodsNumber(), this.Y.getLiveShopGoodsNumber());
        }
        AegisLogger.d("Open_Live|QQLivePrepareFragment", "requestLiveData", "LIVE_SCHEME_TYPE_ENTRY respData:" + this.Y.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActionSheet() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getQBaseActivity(), null);
        actionSheet.addButton(R.string.f199844qi, 5);
        actionSheet.addButton(R.string.f199834qh, 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new g(actionSheet));
        if (!actionSheet.isShowing()) {
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit sj(final QQECLiveEntryGoodsData qQECLiveEntryGoodsData) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.s
            @Override // java.lang.Runnable
            public final void run() {
                QQLivePrepareFragment.this.rj(qQECLiveEntryGoodsData);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        if (xi()) {
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "checkActionAtFirst", "the user has the valid anchor record");
        } else {
            Ai();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void tj(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i3);
        }
    }

    private boolean ui() {
        if (this.C.getCurRoomInfo() != null) {
            if (this.C.getCurRoomInfo().roomType == 1) {
                ij();
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "checkIsLiving", "has anchor room");
            return true;
        }
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.m().c()) {
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "checkIsLiving", "has audience room");
            return true;
        }
        return false;
    }

    private void uj(URLImageView uRLImageView, int i3, int i16, String str, int i17) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (i17 != 0 && getQBaseActivity().getResources() != null) {
                obtain.mFailedDrawable = getQBaseActivity().getResources().getDrawable(i17);
            }
            int dip2px = ViewUtils.dip2px(i3);
            int dip2px2 = ViewUtils.dip2px(i16);
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            drawable.setTag(new int[]{dip2px, dip2px2});
            drawable.setDecodeHandler(com.tencent.mobileqq.qqlive.room.prepare.b.f271920m);
            uRLImageView.setImageDrawable(drawable);
        } catch (Exception e16) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "loadRoundImg", String.valueOf(e16));
        }
    }

    private void vi() {
        if (getActivity() != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
            if (kVar != null && kVar.k2()) {
                Oj(R.string.f210545ie, R.string.f169272hw, null);
                return;
            }
            com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.H;
            if (kVar2 != null && kVar2.l2()) {
                Oj(R.string.f210295hq, R.string.f169272hw, null);
                return;
            }
        }
        this.f271871c0.h(this, new f());
    }

    private void vj() {
        if (this.H != null && this.F != null) {
            try {
                if (aj()) {
                    cj4.c cVar = cj4.c.f31003a;
                    String valueOf = String.valueOf(this.F.getRoomInfo().uid);
                    com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
                    QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = kVar.f271954i.roomAttr;
                    cVar.i(valueOf, qQLiveAnchorDataRoomAttr.roomId, 8, qQLiveAnchorDataRoomAttr.openTabLevel, qQLiveAnchorDataRoomAttr.roomName, kVar.W1().roomInfo.getProgramId(), 2);
                    return;
                }
                return;
            } catch (Exception e16) {
                AegisLogger.e("Open_Live|QQLivePrepareFragment", "notifyGoodsLiveOpen", "onSetCallback notifyLiveOpen error:" + e16.getMessage());
                return;
            }
        }
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "notifyGoodsLiveOpen", "while prepareViewModel or prepareWrapper is null");
    }

    private void wi() {
        this.f271871c0.d(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
        String str;
        int i3;
        String str2;
        Object obj;
        String str3;
        QQLiveErrorMsg qQLiveErrorMsg;
        AegisLogger.i("Open_Live|QQLivePrepareFragment", "onSetCallback", "onSet, isSuccess:" + qQLiveAnchorDataSet.isSuccess);
        Map<String, String> c16 = com.tencent.mobileqq.qqlive.room.prepare.f.c(this.H, this.C);
        if (!qQLiveAnchorDataSet.isSuccess && (qQLiveErrorMsg = qQLiveAnchorDataSet.errorMsg) != null) {
            c16.put("qqlive_fail_reason", qQLiveErrorMsg.bizErrMsg);
        }
        c16.put("dt_pgid", "pg_qqlive_gamelive_start");
        if (this.H.W1() != null && this.H.W1().roomInfo != null) {
            c16.put("qqlive_program_id", this.H.W1().roomInfo.getProgramId());
        }
        nf4.d liveReportUtil = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
        if (qQLiveAnchorDataSet.isSuccess) {
            str = "ev_qqlive_start_success";
        } else {
            str = "ev_qqlive_start_failure";
        }
        liveReportUtil.reportEvent(str, c16);
        nf4.f Oi = Oi();
        boolean z16 = qQLiveAnchorDataSet.isSuccess;
        if (z16) {
            i3 = 0;
        } else {
            QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataSet.errorMsg;
            if (qQLiveErrorMsg2 != null) {
                i3 = qQLiveErrorMsg2.originErrCode;
            } else {
                i3 = -111;
            }
        }
        if (z16) {
            str2 = "";
        } else {
            QQLiveErrorMsg qQLiveErrorMsg3 = qQLiveAnchorDataSet.errorMsg;
            if (qQLiveErrorMsg3 != null) {
                str2 = qQLiveErrorMsg3.originErrMsg;
            } else {
                str2 = GlobalUtil.DEF_STRING;
            }
        }
        Oi.b(z16, i3, str2);
        if (qQLiveAnchorDataSet.isSuccess) {
            hj();
            Dj();
            return;
        }
        QQLiveErrorMsg qQLiveErrorMsg4 = qQLiveAnchorDataSet.errorMsg;
        if (qQLiveErrorMsg4 != null) {
            obj = Integer.valueOf(qQLiveErrorMsg4.originErrCode);
        } else {
            obj = "-1";
        }
        Qj(String.valueOf(obj), "[onSetCallback]fail");
        AegisLogger.e("Open_Live|QQLivePrepareFragment", "onSetCallback", "set roomInfo fail!");
        QQLiveErrorMsg qQLiveErrorMsg5 = qQLiveAnchorDataSet.errorMsg;
        if (qQLiveErrorMsg5 == null) {
            str3 = getResources().getString(R.string.f210175he);
        } else {
            str3 = qQLiveErrorMsg5.originErrMsg;
        }
        Nj(str3);
    }

    private boolean xi() {
        String currentUin = this.C.getAppRuntime().getCurrentUin();
        QQLiveAnchorRecord validAnchorRecord = this.C.getAnchorModule().getValidAnchorRecord(currentUin);
        if (validAnchorRecord != null && this.f271871c0.j(this) && this.f271871c0.i(this)) {
            if (validAnchorRecord.roomInfo.roomData.liveRoomType == 0) {
                return false;
            }
            com.tencent.mobileqq.qqlive.room.dialog.a aVar = new com.tencent.mobileqq.qqlive.room.dialog.a(getQBaseActivity(), R.style.b0j);
            aVar.N(new i(currentUin, validAnchorRecord));
            aVar.show();
        }
        if (validAnchorRecord == null) {
            return false;
        }
        return true;
    }

    private void xj() {
        Uri uri = this.f271872d0;
        if (uri != null) {
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(getContext(), uri);
            String valueOf = String.valueOf(this.H.f271954i.roomAttr.roomId);
            if (!TextUtils.isEmpty(realPathFromContentURI) && !TextUtils.isEmpty(valueOf)) {
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterCropFragment(getQBaseActivity(), realPathFromContentURI, valueOf, 2);
            }
        }
    }

    private QQLiveAnchorRoomInfo yi(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo;
        IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.F;
        if (iQQLiveAnchorPrepareWrapper != null) {
            qQLiveAnchorRoomInfo = iQQLiveAnchorPrepareWrapper.getRoomInfo();
        } else {
            qQLiveAnchorRoomInfo = null;
        }
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo2 = new QQLiveAnchorRoomInfo(qQLiveAnchorRoomInfo);
        qQLiveAnchorRoomInfo2.roomAttr = qQLiveAnchorDataPrepare.roomAttr;
        qQLiveAnchorRoomInfo2.roomData = qQLiveAnchorDataPrepare.roomInfo;
        qQLiveAnchorRoomInfo2.userDta = Ei();
        if (this.H != null) {
            qQLiveAnchorRoomInfo2.roomAttr.isECGoodsLive = aj();
            qQLiveAnchorRoomInfo2.roomAttr.openTabLevel = Ki();
        }
        return qQLiveAnchorRoomInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar;
        if (!this.f271874f0 && (kVar = this.H) != null && kVar.f271954i != null) {
            com.tencent.mobileqq.qqlive.anchor.live.a.a().c(yi(this.H.f271954i));
            cj4.c.f31003a.m(this.H.f271954i.roomAttr.roomId, this.C.getLoginModule().getLoginInfo().uid, new Function1() { // from class: com.tencent.mobileqq.qqlive.room.prepare.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit qj5;
                    qj5 = QQLivePrepareFragment.this.qj((QQECLiveEntryGoodsData) obj);
                    return qj5;
                }
            });
        }
    }

    private void zi() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QBaseActivity qBaseActivity = QQLivePrepareFragment.this.getQBaseActivity();
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    AegisLogger.i("Open_Live|QQLivePrepareFragment", "delayToFinish", "the activity should finish now");
                    qBaseActivity.finish();
                }
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(String str, String str2) {
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID).n()).eventId(QQLiveReportConstants.Event.E_ANCHOR_RECONNECT_OBS_ROOM).retCode(str).desc(str2).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
    }

    public void Cj(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (j3 != 0) {
            concurrentHashMap.put("qqlive_taskid", String.valueOf(j3));
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.f271883o0, false, null, "em_qqlive_anchorcenter", concurrentHashMap);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", this.f271883o0, concurrentHashMap);
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.d
    public void Ma(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.W.setEnabled(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.d
    public void W3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.U.setChecked(z16);
        }
    }

    @Override // si2.a
    public void Xe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (this.H != null) {
            Context context = getContext();
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.H;
            new QQLiveSettingDialog(context, kVar, kVar.f271954i.roomAttr.roomId, new k()).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        List<Part> assembleParts = super.assembleParts();
        if (assembleParts == null) {
            assembleParts = new ArrayList<>();
        }
        assembleParts.add(new QQLivePreparePlayTogetherPart(this));
        assembleParts.add(new com.tencent.mobileqq.qqlive.room.prepare.part.c());
        assembleParts.add(new com.tencent.mobileqq.qqlive.room.prepare.part.b());
        assembleParts.add(new com.tencent.mobileqq.qqlive.room.prepare.part.d(this));
        return assembleParts;
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.d
    public void b3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "setRoomCover", "coverUrl is empty");
            return;
        }
        AegisLogger.i("Open_Live|QQLivePrepareFragment", "setRoomCover", "upload success cover url is " + str);
        uj(this.P, 85, 120, str, R.drawable.nmi);
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart.b
    public long getAnchorUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        return this.F.getRoomInfo().uid;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ArrayList) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(DelMessageCenterRedPointEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart.b
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.H.f271954i.roomAttr.roomId;
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.d
    public void ie(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.Q.setText("");
            this.Q.setHint("\t\t\t\t\u8f93\u5165\u6807\u9898\u66f4\u5438\u5f15\u4eba\u54e6");
            this.Q.clearFocus();
            this.P.requestFocus();
            this.R.setVisibility(0);
            return;
        }
        this.R.setVisibility(8);
        this.Q.setText(str);
        this.Q.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    Editable text = QQLivePrepareFragment.this.Q.getText();
                    Selection.setSelection(text, text.length());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            xj();
            return;
        }
        if (i3 == 2) {
            this.f271873e0 = false;
            if (intent == null) {
                return;
            }
            CoverInfo coverInfo = (CoverInfo) intent.getSerializableExtra(IQQLiveUtil.COVER_INFO_KEY);
            if (coverInfo != null) {
                this.H.E.setValue(coverInfo);
                return;
            }
            int intExtra = intent.getIntExtra(IQQLiveUtil.UPLOAD_ERROR_CODE, 0);
            if (intExtra != 0) {
                Nj("\u4e0a\u4f20\u5931\u8d25");
            }
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "onActivityResult", "[REQUEST_CODE_EDIT_PHOTO] error code " + intExtra + " errorMsg " + intent.getStringExtra(IQQLiveUtil.UPLOAD_ERROR_MESSAGE));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Qi();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f61402y1) {
                Ij();
            } else if (id5 == R.id.f61392y0) {
                Jj();
            } else if (id5 == R.id.f60732w8) {
                Qi();
            } else if (id5 == R.id.f60912wp) {
                dj();
            } else if (id5 == R.id.f60752w_) {
                vi();
            } else if (id5 != R.id.f60812wf) {
                if (id5 == R.id.f61362xx) {
                    this.R.setVisibility(8);
                } else if (id5 == R.id.f60922wq) {
                    Ri();
                } else if (id5 == R.id.f60872wl) {
                    jj();
                } else if (id5 == R.id.f60322v4) {
                    fj();
                } else if (id5 == R.id.f61322xt) {
                    cj();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (ui()) {
            zi();
            this.f271886r0 = true;
            return;
        }
        this.f271886r0 = false;
        try {
            getContext().registerReceiver(this.f271875g0, new IntentFilter("qqlive_anchor_prepare_fragment"));
        } catch (Throwable th5) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "onCreate", String.valueOf(th5));
        }
        Ti();
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).initLiveModule(getContext());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            view = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            setStatusBarImmersive();
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "onCreateView", "isOpeningLive=" + this.f271886r0 + " , " + getClass().getSimpleName());
            if (this.f271886r0) {
                view = null;
            } else {
                this.D = (ViewGroup) layoutInflater.inflate(R.layout.f168919hb2, viewGroup, false);
                Bj(getArguments());
                initView();
                initViewModel();
                initData();
                Mi();
                view = this.D;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        this.f271874f0 = true;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        try {
            getContext().unregisterReceiver(this.f271875g0);
        } catch (Throwable th5) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY, String.valueOf(th5));
        }
        this.f271875g0 = null;
        this.f271887s0 = null;
        kl4.s.j();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        AegisLogger.i("Open_Live|QQLivePrepareFragment", "onNewIntent", "invoke success");
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            stringExtra = stringArrayListExtra.get(0);
        } else if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        if (TextUtils.isEmpty(stringExtra)) {
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "onNewIntent", "the path is empty");
            return;
        }
        if (!this.f271873e0) {
            this.f271873e0 = true;
            if (this.H == null) {
                initViewModel();
            }
            String valueOf = String.valueOf(this.H.f271954i.roomAttr.roomId);
            if (!TextUtils.isEmpty(valueOf)) {
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterCropFragment(getQBaseActivity(), stringExtra, valueOf, 2);
            } else {
                AegisLogger.i("Open_Live|QQLivePrepareFragment", "onNewIntent", "the roomId is empty");
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof DelMessageCenterRedPointEvent) && this.H != null) {
            AegisLogger.i("Open_Live|QQLivePrepareFragment", "onReceiveEvent", "DelMessageCenterRedPointEvent");
            this.H.L.postValue(Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onResume();
        if (this.f271880l0 != null) {
            Lj(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) bundle);
        } else {
            super.onViewCreated(view, bundle);
            Bj(getArguments());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.prepare.d
    public void p5(com.tencent.mobileqq.qqlive.room.prepare.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment
    protected void rh(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) str);
            return;
        }
        AegisLogger.d("Open_Live|QQLivePrepareFragment", "onInitLiveSdkFailure", "code:" + i3 + " msg:" + str);
        qg4.e.a(getResources().getString(R.string.f210115h9), new l(i3, str));
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment
    protected void setStatusBarImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            AegisLogger.e("Open_Live|QQLivePrepareFragment", "setStatusBarImmersive", "qBaseActivity is null");
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
        }
    }
}
