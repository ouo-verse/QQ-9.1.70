package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
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
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.room.floatview.QQLiveGameRoomService;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveAnchorActivity;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareLabelsPart;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareOperatePart;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareStartLivePart;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.ac;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.g;
import com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.List;
import kl4.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0004Z[\\]B\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010DR\u0016\u0010L\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010@R\u0018\u0010N\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010GR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment;", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment;", "Lsi2/a;", "", "initView", "initViewModel", "Lh", "Landroid/os/Bundle;", "arguments", "Qh", "Fh", "Kh", "Mh", "Ph", "Gh", "Jh", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/content/Intent;", "intent", "onNewIntent", "", "errorCode", "", "errorMsg", "rh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Xe", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "D", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "Hh", "()Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "setPrepareViewModel", "(Lcom/tencent/mobileqq/qqlive/room/prepare/k;)V", "prepareViewModel", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareWrapper;", "E", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareWrapper;", "Ih", "()Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareWrapper;", "setPrepareWrapper", "(Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareWrapper;)V", "prepareWrapper", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareObs;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareObs;", "obsPrepareModule", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "G", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "currentPushInfo", "H", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "I", "authToastTips", "", "J", "Z", "isDestroy", "K", "Ljava/lang/String;", "paramGameOpenId", "L", "paramFromOneKeyLive", "M", "paramGameId", "N", "paramJumpCmd", "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "P", "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "liveEntryGoodsData", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$c;", "thirdPushBaseCallback", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "c", "d", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRtmpPrepareFragment extends QQLiveBaseFragment implements si2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k prepareViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private IQQLiveAnchorPrepareWrapper prepareWrapper;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IQQLiveAnchorPrepareObs obsPrepareModule;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QQLiveAnchorDataPushInfo currentPushInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View authToastTips;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String paramGameOpenId;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean paramFromOneKeyLive;

    /* renamed from: M, reason: from kotlin metadata */
    private int paramGameId;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String paramJumpCmd;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private QQECLiveEntryGoodsData liveEntryGoodsData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private c thirdPushBaseCallback;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "traceId", "", "a", "", "AUTH_TOAST_DURATION", "J", "DELAY_FINISH_DURATION", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Context context, @Nullable Intent intent, @NotNull String traceId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, intent, traceId);
                return;
            }
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            com.tencent.mobileqq.qqlive.anchor.live.utils.b.b().e(2);
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("moduleId", "qq_live");
            intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, traceId);
            intent.putExtra("key_intent_app_id", QQLiveBusinessConfig.QQLIVE_APP_ID);
            intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QQLIVE_SKIN");
            if (TextUtils.isEmpty(intent.getStringExtra("clear_top"))) {
                intent.addFlags(67108864);
            }
            QPublicFragmentActivity.b.b(context, intent, QQLiveAnchorActivity.class, QQLiveRtmpPrepareFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$b;", "", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0014H\u0016R \u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$c;", "Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomThirdPushBaseCallback;", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment;", "d", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "info", "", "onGetPushInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataThirdPushCheck;", "result", "onThirdPushChecked", "Lcom/tencent/mobileqq/qqlive/data/common/QQLiveErrorMsg;", "errorMsg", "onError", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPrepare;", "data", "onPrepare", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "onAnchorLiveNetStatus", "onStartFaceAuth", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataAuth;", "onFaceAuth", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "fragmentRef", "fragment", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<QQLiveRtmpPrepareFragment> fragmentRef;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$c$a", "Lcom/tencent/mobileqq/qqlive/callback/auth/IQQLiveGetRealNameAuthCallback;", "Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRealNameAuthData;", "authData", "", "onSuccess", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends IQQLiveGetRealNameAuthCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQLiveRtmpPrepareFragment f271992a;

            a(QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
                this.f271992a = qQLiveRtmpPrepareFragment;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveRtmpPrepareFragment);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback
            public void onSuccess(@NotNull QQLiveRealNameAuthData authData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) authData);
                    return;
                }
                Intrinsics.checkNotNullParameter(authData, "authData");
                super.onSuccess(authData);
                if (authData.getAuthState() == 1) {
                    this.f271992a.Fh();
                }
            }
        }

        public c(@NotNull QQLiveRtmpPrepareFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment);
            } else {
                this.fragmentRef = new WeakReference<>(fragment);
            }
        }

        private final QQLiveRtmpPrepareFragment d() {
            WeakReference<QQLiveRtmpPrepareFragment> weakReference = this.fragmentRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, DialogInterface dialogInterface, int i3) {
            qQLiveRtmpPrepareFragment.Ph();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, DialogInterface dialogInterface, int i3) {
            qQLiveRtmpPrepareFragment.Gh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
            View view = qQLiveRtmpPrepareFragment.authToastTips;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
        public void onAnchorLiveNetStatus(@NotNull AnchorLiveSystemInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) info);
            } else {
                Intrinsics.checkNotNullParameter(info, "info");
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onError(@NotNull QQLiveErrorMsg errorMsg) {
            com.tencent.mobileqq.qqlive.room.prepare.k Hh;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            super.onError(errorMsg);
            final QQLiveRtmpPrepareFragment d16 = d();
            if (d16 == null || d16.isDestroy) {
                return;
            }
            AegisLogger.INSTANCE.e("Open_Live|QQLiveRtmpPrepareFragment", "onError", "errorMsg: " + errorMsg);
            int i3 = errorMsg.originErrCode;
            if (i3 == 10110010) {
                QQToast.makeText(d16.getContext(), "\u5173\u64ad\u5931\u8d25\u4e86\uff0c\u8bf7\u91cd\u8bd5", 0).show();
                m.d(d16);
            } else if (i3 == 2003) {
                qg4.e.INSTANCE.e("\u76d1\u6d4b\u5230\u4f60\u5f53\u524d\u6b63\u5728\u76f4\u64ad\u4e2d\uff0c\u70b9\u51fb\u3010\u7acb\u5373\u524d\u5f80\u3011\u53ef\u8fdb\u5165\u76f4\u64ad\u7ba1\u7406\u9875", "\u7acb\u5373\u524d\u5f80", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.j
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        QQLiveRtmpPrepareFragment.c.e(QQLiveRtmpPrepareFragment.this, dialogInterface, i16);
                    }
                }, "\u5173\u95ed\u76f4\u64ad", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        QQLiveRtmpPrepareFragment.c.f(QQLiveRtmpPrepareFragment.this, dialogInterface, i16);
                    }
                });
            } else if (d16.getActivity() != null && (Hh = d16.Hh()) != null) {
                Hh.d2(d16.getActivity(), errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onFaceAuth(@NotNull QQLiveAnchorDataAuth result) {
            QQLiveErrorMsg qQLiveErrorMsg;
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            super.onFaceAuth(result);
            final QQLiveRtmpPrepareFragment d16 = d();
            if (d16 == null || d16.isDestroy) {
                return;
            }
            nf4.f g16 = m.g(d16);
            if (g16 != null) {
                boolean z16 = result.isSuccess;
                if (z16) {
                    i3 = 0;
                } else {
                    QQLiveErrorMsg qQLiveErrorMsg2 = result.errorMsg;
                    if (qQLiveErrorMsg2 != null) {
                        i3 = qQLiveErrorMsg2.originErrCode;
                    } else {
                        i3 = -111;
                    }
                }
                if (z16) {
                    str = "";
                } else {
                    QQLiveErrorMsg qQLiveErrorMsg3 = result.errorMsg;
                    if (qQLiveErrorMsg3 != null) {
                        str = qQLiveErrorMsg3.originErrMsg;
                    } else {
                        str = GlobalUtil.DEF_STRING;
                    }
                }
                g16.d(z16, i3, str);
            }
            if (!result.isSuccess && (qQLiveErrorMsg = result.errorMsg) != null && qQLiveErrorMsg.originErrCode == 999) {
                AegisLogger.INSTANCE.e("Open_Live|QQLiveRtmpPrepareFragment", "onFaceAuth", "\u7528\u6237\u4e3b\u52a8\u53d6\u6d88\u4e86\u5b9e\u540d\u8ba4\u8bc1");
                View view = d16.authToastTips;
                if (view != null) {
                    view.setVisibility(0);
                }
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveRtmpPrepareFragment.c.g(QQLiveRtmpPrepareFragment.this);
                    }
                }, 5000L);
            }
            com.tencent.mobileqq.qqlive.room.prepare.k Hh = d16.Hh();
            if (Hh != null) {
                Hh.O1(1, new a(d16));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
        public void onGetPushInfo(@NotNull QQLiveAnchorDataPushInfo info) {
            MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData;
            MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            super.onGetPushInfo(info);
            QQLiveRtmpPrepareFragment d16 = d();
            if (d16 == null || d16.isDestroy) {
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onGetPushInfo", "isSuccess:" + info.isSuccess);
            if (info.isSuccess) {
                com.tencent.mobileqq.qqlive.room.prepare.x xVar = new com.tencent.mobileqq.qqlive.room.prepare.x();
                xVar.f272085a = info.serverPart;
                xVar.f272086b = info.streamParam;
                com.tencent.mobileqq.qqlive.room.prepare.k Hh = d16.Hh();
                if (Hh != null && (mutableLiveData2 = Hh.K) != null) {
                    mutableLiveData2.setValue(xVar);
                }
            } else {
                com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = d16.Hh();
                if (Hh2 != null && (mutableLiveData = Hh2.K) != null) {
                    mutableLiveData.setValue(null);
                }
            }
            IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs = d16.obsPrepareModule;
            if (iQQLiveAnchorPrepareObs != null) {
                iQQLiveAnchorPrepareObs.startCheck();
            }
            d16.currentPushInfo = info;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(@NotNull QQLiveAnchorDataPrepare data) {
            MutableLiveData<Integer> mutableLiveData;
            com.tencent.mobileqq.qqlive.room.prepare.k Hh;
            int i3;
            String str;
            QQLiveAnchorRoomGameInfo Q1;
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QQLiveRtmpPrepareFragment d16 = d();
            if (d16 == null) {
                return;
            }
            super.onPrepare(data);
            if (d16.isDestroy) {
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onPrepare", "isSuccess:" + data.isSuccess);
            com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = d16.Hh();
            if (Hh2 != null) {
                Hh2.o2(data);
            }
            com.tencent.mobileqq.qqlive.room.prepare.k Hh3 = d16.Hh();
            if (Hh3 != null && (Q1 = Hh3.Q1()) != null && (qQLiveAnchorDataRoomAttr = data.roomAttr) != null) {
                qQLiveAnchorDataRoomAttr.gameInfo = Q1;
            }
            com.tencent.mobileqq.qqlive.room.prepare.k Hh4 = d16.Hh();
            if (Hh4 != null) {
                Hh4.f271955m = data.isSuccess;
            }
            com.tencent.mobileqq.qqlive.room.prepare.k Hh5 = d16.Hh();
            MutableLiveData<LabelModel> mutableLiveData2 = null;
            if (Hh5 != null) {
                mutableLiveData = Hh5.G;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(2);
            }
            com.tencent.mobileqq.qqlive.room.prepare.k Hh6 = d16.Hh();
            if (Hh6 != null) {
                mutableLiveData2 = Hh6.Q;
            }
            if (mutableLiveData2 != null) {
                mutableLiveData2.setValue(com.tencent.mobileqq.qqlive.room.livelabel.e.a());
            }
            d16.Jh();
            QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = new QQLiveAnchorAutoCheckPullPlayParams();
            qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay = false;
            qQLiveAnchorAutoCheckPullPlayParams.isMute = true;
            IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs = d16.obsPrepareModule;
            if (iQQLiveAnchorPrepareObs != null) {
                iQQLiveAnchorPrepareObs.getPushInfo(m.b(d16, data), qQLiveAnchorAutoCheckPullPlayParams, this);
            }
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr2 = data.roomAttr;
            if ((qQLiveAnchorDataRoomAttr2 == null || qQLiveAnchorDataRoomAttr2.gameInfo == null) && (Hh = d16.Hh()) != null) {
                Hh.P1(true);
            }
            EventCenter.post(new b());
            m.m(d16);
            nf4.f g16 = m.g(d16);
            if (g16 != null) {
                boolean z16 = data.isSuccess;
                if (z16) {
                    i3 = 0;
                } else {
                    QQLiveErrorMsg qQLiveErrorMsg = data.errorMsg;
                    if (qQLiveErrorMsg != null) {
                        i3 = qQLiveErrorMsg.originErrCode;
                    } else {
                        i3 = -111;
                    }
                }
                if (z16) {
                    str = "";
                } else {
                    QQLiveErrorMsg qQLiveErrorMsg2 = data.errorMsg;
                    if (qQLiveErrorMsg2 != null) {
                        str = qQLiveErrorMsg2.originErrMsg;
                    } else {
                        str = GlobalUtil.DEF_STRING;
                    }
                }
                g16.a(z16, i3, str, false);
            }
            if (d16.getActivity() != null) {
                s.Companion companion = kl4.s.INSTANCE;
                FragmentActivity activity = d16.getActivity();
                Intrinsics.checkNotNull(activity);
                companion.i(activity, data.popupDialogUrl);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onStartFaceAuth() {
            nf4.f g16;
            String str;
            Resources resources;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            super.onStartFaceAuth();
            QQLiveRtmpPrepareFragment d16 = d();
            if (d16 != null && !d16.isDestroy && (g16 = m.g(d16)) != null) {
                FragmentActivity activity = d16.getActivity();
                if (activity == null || (resources = activity.getResources()) == null || (str = resources.getString(R.string.f210205hh)) == null) {
                    str = "\u672a\u5b9e\u540d";
                }
                g16.a(false, 1004, str, true);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(@NotNull QQLiveAnchorDataThirdPushCheck result) {
            com.tencent.mobileqq.qqlive.room.prepare.x xVar;
            MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData;
            MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            super.onThirdPushChecked(result);
            QQLiveRtmpPrepareFragment d16 = d();
            if (d16 == null || d16.isDestroy) {
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onThirdPushChecked", "isSuccess:" + result.isSuccess);
            com.tencent.mobileqq.qqlive.room.prepare.k Hh = d16.Hh();
            if (Hh != null && (mutableLiveData2 = Hh.K) != null) {
                xVar = mutableLiveData2.getValue();
            } else {
                xVar = null;
            }
            if (xVar != null) {
                xVar.f272087c = result.isSuccess;
                com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = d16.Hh();
                if (Hh2 != null && (mutableLiveData = Hh2.K) != null) {
                    mutableLiveData.setValue(xVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$d;", "Lnf4/b;", "", "onSuccess", "", "errCode", "", "msg", "onFailed", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment;", "a", "Lmqq/util/WeakReference;", "fragmentRef", "fragment", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements nf4.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QQLiveRtmpPrepareFragment> fragmentRef;

        public d(@NotNull QQLiveRtmpPrepareFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment);
            } else {
                this.fragmentRef = new WeakReference<>(fragment);
            }
        }

        @Override // nf4.b
        public void onFailed(int errCode, @Nullable String msg2) {
            Context context;
            Resources resources;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) msg2);
                return;
            }
            QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment = this.fragmentRef.get();
            if (qQLiveRtmpPrepareFragment != null) {
                m.h(qQLiveRtmpPrepareFragment, String.valueOf(errCode), "[reConnectObsRoom]" + msg2);
            }
            QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment2 = this.fragmentRef.get();
            if (qQLiveRtmpPrepareFragment2 != null) {
                context = qQLiveRtmpPrepareFragment2.getContext();
            } else {
                context = null;
            }
            if (TextUtils.isEmpty(msg2)) {
                QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment3 = this.fragmentRef.get();
                if (qQLiveRtmpPrepareFragment3 != null && (resources = qQLiveRtmpPrepareFragment3.getResources()) != null) {
                    msg2 = resources.getString(R.string.f210185hf);
                } else {
                    msg2 = null;
                }
            }
            QQToast.makeText(context, msg2, 0).show();
            QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment4 = this.fragmentRef.get();
            if (qQLiveRtmpPrepareFragment4 != null) {
                m.d(qQLiveRtmpPrepareFragment4);
            }
        }

        @Override // nf4.b
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment = this.fragmentRef.get();
            if (qQLiveRtmpPrepareFragment != null) {
                m.i(qQLiveRtmpPrepareFragment);
            }
            QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment2 = this.fragmentRef.get();
            if (qQLiveRtmpPrepareFragment2 != null) {
                m.d(qQLiveRtmpPrepareFragment2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$e", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/ac$b;", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareWrapper;", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements ac.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.rtmp.ac.b
        @Nullable
        public IQQLiveAnchorPrepareWrapper a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IQQLiveAnchorPrepareWrapper) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return QQLiveRtmpPrepareFragment.this.Ih();
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$f", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/g$b;", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements g.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$g", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart$b;", "", "c", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class g implements QQLiveRtmpPrepareLabelsPart.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareLabelsPart.b
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return m.f(QQLiveRtmpPrepareFragment.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$h", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$a;", "", "c", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class h implements QQLiveRtmpPrepareOperatePart.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareOperatePart.a
        public long a() {
            QQLiveAnchorRoomInfo roomInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            IQQLiveAnchorPrepareWrapper Ih = QQLiveRtmpPrepareFragment.this.Ih();
            if (Ih != null && (roomInfo = Ih.getRoomInfo()) != null) {
                return roomInfo.uid;
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareOperatePart.a
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return m.f(QQLiveRtmpPrepareFragment.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$i", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareStartLivePart$a;", "Landroid/view/View;", "v", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class i implements QQLiveRtmpPrepareStartLivePart.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareStartLivePart.a
        public void a(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            if (com.tencent.timi.game.utils.o.a()) {
                AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onStartLiveClicked", "isDoubleClick, return.");
                return;
            }
            m.o(QQLiveRtmpPrepareFragment.this, QQLiveReportConstants.Event.E_BEGIN_START_LIVE);
            QQLiveRtmpPrepareFragment.this.Kh();
            m.j(QQLiveRtmpPrepareFragment.this, v3);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$j", "Lcom/tencent/mobileqq/qqlive/callback/auth/IQQLiveGetRoomSettingCallback;", "Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRoomSetting;", "roomSetting", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class j extends IQQLiveGetRoomSettingCallback {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            AegisLogger.INSTANCE.e("Open_Live|QQLiveRtmpPrepareFragment", "getRoomSettings", "onFailed: errorCode:" + errorCode + " errorMsg:" + errorMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback
        public void onSuccess(@NotNull QQLiveRoomSetting roomSetting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) roomSetting);
                return;
            }
            Intrinsics.checkNotNullParameter(roomSetting, "roomSetting");
            AegisLogger.INSTANCE.d("Open_Live|QQLiveRtmpPrepareFragment", "getRoomSettings", "onSuccess: isHiddenUserinfo:" + roomSetting.isHiddenUserinfo());
            com.tencent.mobileqq.qqlive.room.prepare.k Hh = QQLiveRtmpPrepareFragment.this.Hh();
            Intrinsics.checkNotNull(Hh);
            ct3.a.n("MMKV_KEY_HIDE_ROOM_NICKNAME", Hh.f271954i.roomAttr.roomId, roomSetting.isHiddenUserinfo());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$k", "Lcom/tencent/mobileqq/qqlive/callback/login/IQQLiveLoginCallback;", "", "errorCode", "", "errorMsg", "", "onFailed", "Lcom/tencent/mobileqq/qqlive/data/login/LoginInfo;", "loginInfo", "onSuccess", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class k implements IQQLiveLoginCallback {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            IQQLiveModuleLogin loginModule;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "registerLoginStateCallback", "the user login action is fail errorCode " + errorCode);
            IQQLiveSDK iQQLiveSDK = ((QQLiveBaseFragment) QQLiveRtmpPrepareFragment.this).C;
            if (iQQLiveSDK != null && (loginModule = iQQLiveSDK.getLoginModule()) != null) {
                loginModule.unregisterLoginStateCallback(this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(@Nullable LoginInfo loginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) loginInfo);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "registerLoginStateCallback", "the user login action onSuccess ");
            IQQLiveSDK iQQLiveSDK = ((QQLiveBaseFragment) QQLiveRtmpPrepareFragment.this).C;
            Intrinsics.checkNotNull(iQQLiveSDK);
            iQQLiveSDK.getLoginModule().unregisterLoginStateCallback(this);
            QQLiveRtmpPrepareFragment.this.Fh();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$l", "Lnf4/b;", "", "onSuccess", "", "errCode", "", "msg", "onFailed", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class l implements nf4.b {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
            }
        }

        @Override // nf4.b
        public void onFailed(int errCode, @Nullable String msg2) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) msg2);
                return;
            }
            m.n(QQLiveRtmpPrepareFragment.this, String.valueOf(errCode), "[jumpToObsRoom]" + msg2);
            Context context = QQLiveRtmpPrepareFragment.this.getContext();
            if (!TextUtils.isEmpty(msg2)) {
                string = msg2;
            } else {
                string = QQLiveRtmpPrepareFragment.this.getResources().getString(R.string.f210185hf);
            }
            QQToast.makeText(context, string, 0).show();
            QQLiveAnchorDataSet qQLiveAnchorDataSet = new QQLiveAnchorDataSet();
            qQLiveAnchorDataSet.isSuccess = true;
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6250;
            qQLiveErrorMsg.bizErrMsg = msg2;
            qQLiveErrorMsg.originErrCode = errCode;
            qQLiveErrorMsg.originErrMsg = msg2;
            qQLiveAnchorDataSet.errorMsg = qQLiveErrorMsg;
            QQLiveGameRoomService.INSTANCE.c();
            m.k(QQLiveRtmpPrepareFragment.this, qQLiveAnchorDataSet);
        }

        @Override // nf4.b
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            m.o(QQLiveRtmpPrepareFragment.this, QQLiveReportConstants.Event.E_SUCCESS_START_LIVE);
            m.d(QQLiveRtmpPrepareFragment.this);
            QQLiveAnchorDataSet qQLiveAnchorDataSet = new QQLiveAnchorDataSet();
            qQLiveAnchorDataSet.isSuccess = true;
            qQLiveAnchorDataSet.errorMsg = null;
            m.k(QQLiveRtmpPrepareFragment.this, qQLiveAnchorDataSet);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveRtmpPrepareFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.thirdPushBaseCallback = new c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh() {
        IQQLiveModuleAnchor iQQLiveModuleAnchor;
        IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs;
        long j3;
        String str;
        IQQLiveModuleLogin loginModule;
        LoginInfo loginInfo;
        if (this.isDestroy) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
        IQQLiveSDK iQQLiveSDK = this.C;
        if (iQQLiveSDK == null) {
            String str2 = "doPrepareAction while sdk is null!";
            if (TextUtils.isEmpty("doPrepareAction while sdk is null!")) {
                str2 = com.tencent.mobileqq.qqlive.base.room.b.a(iQQLiveSDK);
            }
            QLog.w("CheckNull", 1, IQQLiveSDK.class.getSimpleName() + ',' + str2);
        }
        byte[] bArr = null;
        if (iQQLiveSDK != null) {
            iQQLiveModuleAnchor = iQQLiveSDK.getAnchorModule();
        } else {
            iQQLiveModuleAnchor = null;
        }
        if (iQQLiveModuleAnchor == null) {
            String str3 = "doPrepareAction while anchorModule is null!";
            if (TextUtils.isEmpty("doPrepareAction while anchorModule is null!")) {
                str3 = com.tencent.mobileqq.qqlive.base.room.b.a(iQQLiveModuleAnchor);
            }
            QLog.w("CheckNull", 1, IQQLiveModuleAnchor.class.getSimpleName() + ',' + str3);
        }
        if (iQQLiveModuleAnchor == null) {
            return;
        }
        IQQLiveAnchorPrepareWrapper createPrepareWrapper = iQQLiveModuleAnchor.createPrepareWrapper();
        this.prepareWrapper = createPrepareWrapper;
        if (createPrepareWrapper != null) {
            iQQLiveAnchorPrepareObs = createPrepareWrapper.getObsModule();
        } else {
            iQQLiveAnchorPrepareObs = null;
        }
        this.obsPrepareModule = iQQLiveAnchorPrepareObs;
        if (iQQLiveAnchorPrepareObs != null) {
            iQQLiveAnchorPrepareObs.init(this.C);
        }
        IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs2 = this.obsPrepareModule;
        if (iQQLiveAnchorPrepareObs2 != null) {
            iQQLiveAnchorPrepareObs2.updateLiveStatCallback(this.thirdPushBaseCallback);
        }
        IQQLiveSDK iQQLiveSDK2 = this.C;
        if (iQQLiveSDK2 != null && (loginModule = iQQLiveSDK2.getLoginModule()) != null && (loginInfo = loginModule.getLoginInfo()) != null) {
            j3 = loginInfo.uid;
        } else {
            j3 = 0;
        }
        Bundle arguments = getArguments();
        String str4 = "0";
        if (arguments != null) {
            str = arguments.getString("source", "0");
        } else {
            str = null;
        }
        if (str != null) {
            str4 = str;
        }
        IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper = this.prepareWrapper;
        if (iQQLiveAnchorPrepareWrapper != null) {
            iQQLiveAnchorPrepareWrapper.init(this.C, j3, str4);
        }
        IQQLiveAnchorPrepareWrapper iQQLiveAnchorPrepareWrapper2 = this.prepareWrapper;
        if (iQQLiveAnchorPrepareWrapper2 != null) {
            if (iQQLiveAnchorPrepareWrapper2 != null) {
                bArr = iQQLiveAnchorPrepareWrapper2.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID);
            }
            iQQLiveAnchorPrepareWrapper2.prepare(activity, bArr, this.thirdPushBaseCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        String str;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        if (this.isDestroy) {
            return;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.prepareViewModel;
        if (kVar != null && (qQLiveAnchorDataPrepare = kVar.f271954i) != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorDataPrepare.roomInfo) != null) {
            str = qQLiveAnchorDataRoomInfo.programId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs = this.obsPrepareModule;
        if (iQQLiveAnchorPrepareObs != null) {
            iQQLiveAnchorPrepareObs.exitObsRoom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.prepareViewModel;
        if (kVar == null) {
            AegisLogger.INSTANCE.w("Open_Live|QQLiveRtmpPrepareFragment", "getRoomSettings", "prepareViewModel == null");
            return;
        }
        Intrinsics.checkNotNull(kVar);
        long j3 = kVar.f271954i.roomAttr.roomId;
        if (j3 <= 0) {
            AegisLogger.INSTANCE.w("Open_Live|QQLiveRtmpPrepareFragment", "getRoomSettings", "invalid room id");
            return;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.prepareViewModel;
        if (kVar2 != null) {
            kVar2.a2(j3, new j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh() {
        MutableLiveData<LabelModel> mutableLiveData;
        if (this.isDestroy) {
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "handleStartLive");
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.prepareViewModel;
        Unit unit = null;
        r1 = null;
        LabelModel labelModel = null;
        if (kVar != null) {
            if (m.c(this)) {
                com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.prepareViewModel;
                if (kVar2 != null && (mutableLiveData = kVar2.Q) != null) {
                    labelModel = mutableLiveData.getValue();
                }
                boolean z16 = false;
                QQLiveAnchorDataPrepare X1 = kVar.X1(0, labelModel);
                QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = X1.roomAttr;
                Boolean i26 = kVar.i2();
                if (i26 != null) {
                    Intrinsics.checkNotNullExpressionValue(i26, "it.isGoodsLiveEnable ?: false");
                    z16 = i26.booleanValue();
                }
                qQLiveAnchorDataRoomAttr.isECGoodsLive = z16;
                X1.roomAttr.openTabLevel = kVar.U1();
                IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs = this.obsPrepareModule;
                if (iQQLiveAnchorPrepareObs != null) {
                    iQQLiveAnchorPrepareObs.stopCheck();
                }
                Mh();
                cj4.c.f31003a.l(X1.roomAttr.isECGoodsLive);
                EventCenter.post(new QQLiveRtmpPrepareOperatePart.b());
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m.n(this, "-1", "prepareViewModel is null");
        }
    }

    private final void Lh() {
        IQQLiveModuleLogin iQQLiveModuleLogin;
        boolean z16;
        String str;
        String str2;
        IQQLiveSDK iQQLiveSDK = this.C;
        String str3 = "initData sdk is null!";
        if (iQQLiveSDK == null) {
            if (!TextUtils.isEmpty("initData sdk is null!")) {
                str2 = "initData sdk is null!";
            } else {
                str2 = com.tencent.mobileqq.qqlive.base.room.b.a(iQQLiveSDK);
            }
            QLog.w("CheckNull", 1, IQQLiveSDK.class.getSimpleName() + ',' + str2);
        }
        IQQLiveModuleLogin iQQLiveModuleLogin2 = null;
        if (iQQLiveSDK != null) {
            iQQLiveModuleLogin = iQQLiveSDK.getLoginModule();
        } else {
            iQQLiveModuleLogin = null;
        }
        String str4 = "initData loginModel is null";
        if (iQQLiveModuleLogin == null) {
            if (!TextUtils.isEmpty("initData loginModel is null")) {
                str = "initData loginModel is null";
            } else {
                str = com.tencent.mobileqq.qqlive.base.room.b.a(iQQLiveModuleLogin);
            }
            QLog.w("CheckNull", 1, IQQLiveModuleLogin.class.getSimpleName() + ',' + str);
        }
        if (iQQLiveModuleLogin != null) {
            z16 = iQQLiveModuleLogin.isLogined();
        } else {
            z16 = false;
        }
        if (!z16) {
            IQQLiveSDK iQQLiveSDK2 = this.C;
            if (iQQLiveSDK2 == null) {
                if (TextUtils.isEmpty("initData sdk is null!")) {
                    str3 = com.tencent.mobileqq.qqlive.base.room.b.a(iQQLiveSDK2);
                }
                QLog.w("CheckNull", 1, IQQLiveSDK.class.getSimpleName() + ',' + str3);
            }
            if (iQQLiveSDK2 != null) {
                iQQLiveModuleLogin2 = iQQLiveSDK2.getLoginModule();
            }
            if (iQQLiveModuleLogin2 == null) {
                if (TextUtils.isEmpty("initData loginModel is null")) {
                    str4 = com.tencent.mobileqq.qqlive.base.room.b.a(iQQLiveModuleLogin2);
                }
                QLog.w("CheckNull", 1, IQQLiveModuleLogin.class.getSimpleName() + ',' + str4);
            }
            if (iQQLiveModuleLogin2 != null) {
                iQQLiveModuleLogin2.registerLoginStateCallback(new k());
                return;
            }
            return;
        }
        Fh();
    }

    private final void Mh() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom;
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo;
        IQQLiveModuleAnchor anchorModule;
        if (this.isDestroy) {
            return;
        }
        if (this.prepareViewModel == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveRtmpPrepareFragment", "jumpToGameLiveRoom", "invoke fail! prepareViewModel is null");
            return;
        }
        QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
        qQLiveAnchorRoomConfig.bizData.setMuteAllUser(true);
        qQLiveAnchorRoomConfig.streamRecordType = QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST;
        PlayerConfig playerConfig = new PlayerConfig();
        qQLiveAnchorRoomConfig.playerConfig = playerConfig;
        playerConfig.playerSceneID = 129;
        IQQLiveSDK iQQLiveSDK = this.C;
        String str = null;
        if (iQQLiveSDK != null && (anchorModule = iQQLiveSDK.getAnchorModule()) != null) {
            Context context = getContext();
            if (context == null) {
                context = BaseApplication.getContext().getApplicationContext();
            }
            iQQLiveAnchorRoom = anchorModule.createRoom(context, qQLiveAnchorRoomConfig, this.thirdPushBaseCallback);
        } else {
            iQQLiveAnchorRoom = null;
        }
        if (iQQLiveAnchorRoom != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.prepareViewModel;
            Intrinsics.checkNotNull(kVar);
            QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = kVar.f271954i;
            Intrinsics.checkNotNullExpressionValue(qQLiveAnchorDataPrepare, "prepareViewModel!!.prepareLiveData");
            iQQLiveAnchorRoom.setAnchorRoomInfo(m.b(this, qQLiveAnchorDataPrepare));
        }
        com.tencent.mobileqq.qqlive.anchor.live.a a16 = com.tencent.mobileqq.qqlive.anchor.live.a.a();
        if (iQQLiveAnchorRoom != null) {
            qQLiveAnchorRoomInfo = iQQLiveAnchorRoom.getAnchorRoomInfo();
        } else {
            qQLiveAnchorRoomInfo = null;
        }
        a16.c(qQLiveAnchorRoomInfo);
        IQQLiveAnchorObsRoom iQQLiveAnchorObsRoom = (IQQLiveAnchorObsRoom) iQQLiveAnchorRoom;
        if (iQQLiveAnchorObsRoom != null) {
            iQQLiveAnchorObsRoom.setPushInfo(this.currentPushInfo);
        }
        QQLiveGameRoomService.Companion companion = QQLiveGameRoomService.INSTANCE;
        int i3 = QQLiveGameRoomService.C;
        if (iQQLiveAnchorObsRoom != null && (anchorRoomInfo = iQQLiveAnchorObsRoom.getAnchorRoomInfo()) != null && (qQLiveAnchorDataUserInfo = anchorRoomInfo.userDta) != null) {
            str = qQLiveAnchorDataUserInfo.nickName;
        }
        companion.b(i3, str);
        ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = qQLiveAnchorRoomConfig.streamRecordType;
        Intrinsics.checkNotNullExpressionValue(qQLiveAnchorStreamRecordType, "config.streamRecordType");
        iTimiGameApi.startGameLive(qQLiveAnchorStreamRecordType, new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(QQLiveRtmpPrepareFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m.d(this$0);
        AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "delayToFinish", "close self page");
        this$0.isDestroy = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(int i3, String str, QQLiveRtmpPrepareFragment this$0, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onInitLiveSdkFailure", "errorCode:" + i3 + ", errorMsg:" + str);
        m.d(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        long j3;
        IQQLiveModuleLogin loginModule;
        LoginInfo loginInfo;
        if (this.isDestroy) {
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "reConnectObsRoom");
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.prepareViewModel;
        if (kVar != null) {
            com.tencent.mobileqq.qqlive.anchor.live.a a16 = com.tencent.mobileqq.qqlive.anchor.live.a.a();
            QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = kVar.f271954i;
            Intrinsics.checkNotNullExpressionValue(qQLiveAnchorDataPrepare, "it.prepareLiveData");
            a16.c(m.b(this, qQLiveAnchorDataPrepare));
        }
        cj4.c cVar = cj4.c.f31003a;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.prepareViewModel;
        Intrinsics.checkNotNull(kVar2);
        long j16 = kVar2.f271954i.roomAttr.roomId;
        IQQLiveSDK ph5 = ph();
        if (ph5 != null && (loginModule = ph5.getLoginModule()) != null && (loginInfo = loginModule.getLoginInfo()) != null) {
            j3 = loginInfo.uid;
        } else {
            j3 = 0;
        }
        cVar.m(j16, j3, new Function1<QQECLiveEntryGoodsData, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment$reConnectObsRoom$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQECLiveEntryGoodsData qQECLiveEntryGoodsData) {
                invoke2(qQECLiveEntryGoodsData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQECLiveEntryGoodsData it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.qqlive.room.prepare.k Hh = QQLiveRtmpPrepareFragment.this.Hh();
                if (Hh != null) {
                    Hh.S = it;
                }
                ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
                QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment = QQLiveRtmpPrepareFragment.this;
                com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = qQLiveRtmpPrepareFragment.Hh();
                Intrinsics.checkNotNull(Hh2);
                QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare2 = Hh2.f271954i;
                Intrinsics.checkNotNullExpressionValue(qQLiveAnchorDataPrepare2, "prepareViewModel!!.prepareLiveData");
                iTimiGameApi.reConnectObsPushRoom(m.b(qQLiveRtmpPrepareFragment, qQLiveAnchorDataPrepare2), new QQLiveRtmpPrepareFragment.d(QQLiveRtmpPrepareFragment.this));
            }
        });
    }

    private final void Qh(Bundle arguments) {
        if (!this.isDestroy && arguments != null) {
            this.paramGameOpenId = arguments.getString("game_openid");
            this.paramFromOneKeyLive = arguments.getBoolean("from_onekey", false);
            this.paramGameId = arguments.getInt(RoomServiceConstants.PARAMS_GAME_ID, 0);
            this.paramJumpCmd = arguments.getString("jumpcmd");
            this.liveEntryGoodsData = (QQECLiveEntryGoodsData) arguments.getParcelable("KEY_LIVE_ENTRY_GOODS_DATA");
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "readArguments", "readArguments### gameOpenId: " + this.paramGameOpenId + ", fromOneKeyLive = " + this.paramFromOneKeyLive + ", gameId = " + this.paramGameId + ", jumpCmd = " + this.paramJumpCmd);
        }
    }

    private final void initView() {
        View view = this.rootView;
        if (view != null) {
            this.authToastTips = view.findViewById(R.id.f639134t);
            m.l(this, view);
        }
    }

    private final void initViewModel() {
        MutableLiveData<Integer> mutableLiveData;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(this, com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.prepareViewModel = kVar;
        if (kVar != null) {
            kVar.S = this.liveEntryGoodsData;
        }
        if (kVar != null) {
            mutableLiveData = kVar.G;
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(2);
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.prepareViewModel;
        if (kVar2 != null) {
            Bundle arguments = getArguments();
            int i3 = 0;
            if (arguments != null) {
                i3 = arguments.getInt("source", 0);
            }
            kVar2.s2(i3);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.room.prepare.k Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.room.prepare.k) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.prepareViewModel;
    }

    @Nullable
    public final IQQLiveAnchorPrepareWrapper Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IQQLiveAnchorPrepareWrapper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.prepareWrapper;
    }

    @Override // si2.a
    public void Xe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.prepareViewModel;
        if (kVar != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            new QQLiveSettingDialog(requireContext, kVar, kVar.f271954i.roomAttr.roomId, null, 8, null).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ac(new e()));
        arrayList.add(new com.tencent.mobileqq.qqlive.room.prepare.rtmp.g(new f()));
        arrayList.add(new QQLiveRtmpPrepareLabelsPart(this, new g()));
        arrayList.add(new x());
        arrayList.add(new QQLiveRtmpPrepareOperatePart(new h()));
        arrayList.add(new QQLiveRtmpPrepareStartLivePart(new i()));
        arrayList.add(new com.tencent.mobileqq.qqlive.room.prepare.part.c());
        arrayList.add(new com.tencent.mobileqq.qqlive.room.prepare.part.b());
        arrayList.add(new com.tencent.mobileqq.qqlive.room.prepare.part.d(this));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (m.a(this)) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveRtmpPrepareFragment.Nh(QQLiveRtmpPrepareFragment.this);
                }
            }, 400L);
        }
        ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
        Context context = getContext();
        if (context == null) {
            context = BaseApplication.getContext().getApplicationContext();
        }
        Intrinsics.checkNotNullExpressionValue(context, "context\n                \u2026).getApplicationContext()");
        iTimiGameApi.initLiveModule(context);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view = (View) iPatchRedirector.redirect((short) 7, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            super.onCreateView(inflater, container, savedInstanceState);
            setStatusBarImmersive();
            View inflate = inflater.inflate(R.layout.hbm, container, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.rootView = (ViewGroup) inflate;
            Qh(getArguments());
            initView();
            initViewModel();
            Lh();
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onCreateView", "createView end.");
            view = this.rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        this.isDestroy = true;
        IQQLiveAnchorPrepareObs iQQLiveAnchorPrepareObs = this.obsPrepareModule;
        if (iQQLiveAnchorPrepareObs != null) {
            iQQLiveAnchorPrepareObs.destroy();
        }
        kl4.s.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        } else {
            super.onNewIntent(intent);
            getPartManager().onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment
    public void rh(final int errorCode, @Nullable final String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, errorCode, (Object) errorMsg);
        } else {
            super.rh(errorCode, errorMsg);
            qg4.e.INSTANCE.d(getResources().getString(R.string.f210115h9), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQLiveRtmpPrepareFragment.Oh(errorCode, errorMsg, this, dialogInterface, i3);
                }
            });
        }
    }
}
