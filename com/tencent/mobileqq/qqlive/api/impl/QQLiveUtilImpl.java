package com.tencent.mobileqq.qqlive.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.live.utils.b;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.api.room.StartRoomConfig;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule;
import com.tencent.mobileqq.qqlive.base.webview.a;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.room.end.EndAnchorLiveView;
import com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment;
import com.tencent.mobileqq.qqlive.room.prepare.covercrop.QQLiveCoverCropFragment;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment;
import com.tencent.mobileqq.qqlive.sail.model.RemotePlayerInfo;
import com.tencent.mobileqq.qqlive.sail.model.e;
import com.tencent.mobileqq.qqlive.sail.ui.QQLiveCameraAnchorFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveUtilImpl implements IQQLiveUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String JUMP_QQLIVE_PAGE_URI = "mqqapi://vaslive/watch?roomid=%s&room_type=%s&rtmp=%s&is_use_flv=%s&flv_url=%s&cover_url=%s&video_source=%s&translucent_page=%s&rcmd_context=%s&from=%s&qq_live_product_type=1&pip=false&noclearTop=%s&live_traceid=%s&activity_id=%s";
    private static final String PLUGIN_SERVICE_CLASSNAME = "cooperation.ilive.IlivePluginService";
    private static final String RTMP_URL_PREFIX = "rtmp";
    private static final String TAG = "QQLiveUtilImpl";
    private static final String USE_FLV_NO = "0";
    private static final String USE_FLV_YES = "1";
    public static long preloadProcessTimestamp;
    private static final IAegisLogApi sAegisLog;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            sAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
            preloadProcessTimestamp = -1L;
        }
    }

    public QQLiveUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public boolean checkAvEnable(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).booleanValue();
        }
        String checkAVFocus = AVBizModuleFactory.getModuleByName("QQ\u76f4\u64ad").checkAVFocus();
        if ("true".equals(checkAVFocus)) {
            return true;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(context, String.format(context.getResources().getString(R.string.z_k), checkAVFocus)) { // from class: com.tencent.mobileqq.qqlive.api.impl.QQLiveUtilImpl.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$tips;

            {
                this.val$context = context;
                this.val$tips = r9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QQLiveUtilImpl.this, context, r9);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(this.val$context, this.val$tips, 1).show();
                }
            }
        });
        QLog.e(TAG, 1, "preCheckIsUserGamePlaying, res[" + checkAVFocus + "]");
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void enterAnchorPrepareFragment(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) intent);
            return;
        }
        int c16 = b.b().c();
        if (intent != null) {
            c16 = intent.getIntExtra("room_type", c16);
        }
        String generateTraceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
        if (c16 == 1) {
            QQLivePrepareFragment.Pj(context, intent, generateTraceId);
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(generateTraceId).eventId(QQLiveReportConstants.Event.E_JUMP_INTO_QQ_LIVE_PREPARE_ROOM));
        } else if (c16 == 0) {
            QQLiveCameraAnchorFragment.INSTANCE.a(context, intent, generateTraceId);
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(generateTraceId).eventId(QQLiveReportConstants.Event.E_JUMP_INTO_ANCHOR_LIVE_PREPARE_ROOM));
        } else {
            QQLiveRtmpPrepareFragment.INSTANCE.a(context, intent, generateTraceId);
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(generateTraceId).eventId(QQLiveReportConstants.Event.E_JUMP_INTO_RTMP_PREPARE_ROOM));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void enterCropFragment(Activity activity, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, str, str2, Integer.valueOf(i3));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("SINGLE_PHOTO_PATH", str);
        intent.putExtra(AudienceReportConst.ROOM_ID, str2);
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        String str3 = QQLiveBusinessConfig.QQLIVE_APP_ID;
        if (companion.c(str3) != null) {
            intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, companion.c(str3).n());
        }
        QPublicFragmentActivityForTool.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) QQLiveCoverCropFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void enterRoomByUrl(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) str);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            ax c16 = bi.c((BaseQQAppInterface) peekAppRuntime, context, str);
            if (c16 == null) {
                QLog.w(TAG, 1, "startQQLiveAudiencePage, cannot find action");
                return;
            } else {
                c16.b();
                return;
            }
        }
        QLog.e(TAG, 1, "is not BaseQQAppInterface, appRuntime:" + peekAppRuntime);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void fetchFloatWindowStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            TGLiveClientQIPCModule.INSTANCE.c().fetchFloatWindowStatus();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public IQQLiveEndView getAnchorEndLiveView(QBaseActivity qBaseActivity, QQLiveEndPageInfo qQLiveEndPageInfo, EndLiveClickCallback endLiveClickCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IQQLiveEndView) iPatchRedirector.redirect((short) 7, this, qBaseActivity, qQLiveEndPageInfo, endLiveClickCallback);
        }
        return new EndAnchorLiveView(qBaseActivity, qQLiveEndPageInfo, endLiveClickCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void hideFloatingWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            TGLiveClientQIPCModule.INSTANCE.c().hideFloatingWindow();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void notifyChatAudioChange(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQLiveIPCConstants.Param.PARAM_CHAT_AUDIO_IS_CHATTING, z17);
        bundle.putBoolean(QQLiveIPCConstants.Param.PARAM_CHAT_AUDIO_IS_BEING_INVITE, z16);
        QQLiveClientQIPCModule.INSTANCE.a(QQLiveIPCConstants.Action.ACTION_CLIENT_ROOM_CHAT_AV_NOTIFY, bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public boolean notifyOuterHasPlayer(long j3, int i3, int i16, int i17, ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), iSuperPlayer)).booleanValue();
        }
        preloadQQLiveRoomProcess();
        RemotePlayerInfo remotePlayerInfo = new RemotePlayerInfo(j3, new e(j3, iSuperPlayer).asBinder(), i3, i16, i17);
        Bundle bundle = new Bundle();
        bundle.putParcelable(QQLiveIPCConstants.Param.PARAM_REMOTE_PLAYER_INFO, remotePlayerInfo);
        EIPCResult b16 = QQLiveClientQIPCModule.INSTANCE.b(QQLiveIPCConstants.Action.ACTION_QQLIVE_USE_REMOTE_PLAYER, bundle);
        if (b16 != null && b16.isSuccess()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void openCommonWebDialog(Context context, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            a.c(context, str, bundle);
        } else {
            iPatchRedirector.redirect((short) 11, this, context, str, bundle);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void preloadQQLiveRoomProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), PLUGIN_SERVICE_CLASSNAME);
        intent.setAction("action_preload");
        long currentTimeMillis = System.currentTimeMillis();
        preloadProcessTimestamp = currentTimeMillis;
        intent.putExtra("extra_key_timestamp", currentTimeMillis);
        try {
            context.startService(intent);
        } catch (IllegalStateException | SecurityException e16) {
            sAegisLog.e(TAG, "startService fail " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void startQQLiveAudiencePage(Context context, StartRoomConfig startRoomConfig) {
        String valueOf;
        Object obj;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) startRoomConfig);
            return;
        }
        String str2 = "";
        if (startRoomConfig.getFrom() == -1) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(startRoomConfig.getFrom());
        }
        String playUrl = startRoomConfig.getPlayUrl();
        String str3 = "1";
        if (TextUtils.isEmpty(playUrl)) {
            playUrl = "";
            obj = "0";
        } else {
            boolean startsWith = playUrl.startsWith("rtmp");
            QLog.d(TAG, 1, "isRtmp:" + startsWith);
            if (!startsWith) {
                obj = "1";
            } else {
                obj = "0";
                str2 = playUrl;
                playUrl = "";
            }
        }
        Object[] objArr = new Object[13];
        objArr[0] = Long.valueOf(startRoomConfig.getRoomId());
        objArr[1] = Integer.valueOf(startRoomConfig.getRoomType());
        objArr[2] = str2;
        objArr[3] = obj;
        objArr[4] = playUrl;
        objArr[5] = startRoomConfig.getCoverUrl();
        objArr[6] = Long.valueOf(startRoomConfig.getVideoSource());
        if (startRoomConfig.getTranslucentPage()) {
            str = "true";
        } else {
            str = "false";
        }
        objArr[7] = str;
        objArr[8] = startRoomConfig.getAbToken();
        objArr[9] = valueOf;
        if (!startRoomConfig.getNoClearTop()) {
            str3 = "0";
        }
        objArr[10] = str3;
        objArr[11] = startRoomConfig.getBundle().getString("live_traceid");
        objArr[12] = startRoomConfig.getBundle().getString("activity_id");
        String format = String.format(JUMP_QQLIVE_PAGE_URI, objArr);
        IAegisLogApi iAegisLogApi = sAegisLog;
        iAegisLogApi.i(TAG, 1, "startQQLiveAudiencePage, uri = " + format);
        if (MobileQQ.sProcessId == 1) {
            ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context, format);
            if (c16 == null) {
                iAegisLogApi.w(TAG, 1, "startQQLiveAudiencePage, cannot find action");
                return;
            } else {
                c16.b();
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(format));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveUtil
    public void openCommonWebDialog(Context context, String str, Bundle bundle, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            a.e(context, str, bundle, null, drawable);
        } else {
            iPatchRedirector.redirect((short) 12, this, context, str, bundle, drawable);
        }
    }
}
