package com.tencent.gamecenter.wadl.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.gamecenter.wadl.api.IQQGameFullScreenNoticeService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.i;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.util.WeakReference;
import nl0.h;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameFullScreenRemind$FullScreenMessage;
import tencent.im.qqgame.QQGameFullScreenRemind$SsoShowResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameFullScreenNoticeServiceImpl implements IQQGameFullScreenNoticeService, h {
    private static final String AD_TAG_HOUTAI_HENGFU = "houtai_hengfu";
    private static final String AD_TAG_HOUTAI_PAILIAN = "houtai_pailian";
    private static final String AD_TAG_QIANTAI_HENGFU = "qiantai_hengfu";
    private static final String AD_TAG_QIANTAI_PAILIAN = "qiantai_pailian";
    private static final String CACHE_KEY_PREF = "fullscreen_game_appointment_";
    private static final int SCENE_DEFAULT = -1;
    private static final int SCENE_LOCK = 2;
    private static final int SCENE_UNLOCK = 1;
    private static final String TAG = "QQGameFullScreenNoticeServiceImpl";
    private static final String TOGGLE_SWITCH_NAME = "gamecenter_fullscreen_game_appointment_switch";
    private static final int VIEW_TYPE_FLOAT = 1;
    private static final int VIEW_TYPE_POP = 0;
    private static WindowManager mWindowManager;
    private AppRuntime appRuntime;
    private TextView btnClickJump;
    private Button btnClickSee;
    private final HashSet<String> filterCmds;
    private TextView gameAppointmentDesc;
    private ImageView gameBg;
    private ImageView gameClose;
    private TextView gameTitle;
    private p03.a mmkv;
    private PopupWindow popupWindow;
    private int scene;
    private static WeakReference<View> flowViewRef = new WeakReference<>(null);
    private static WeakReference<PopupWindow> popupViewRef = new WeakReference<>(null);
    private static boolean isShow = false;
    private static final Runnable cancelFloatWindowRunnable = new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.8
        @Override // java.lang.Runnable
        public void run() {
            QQGameFullScreenNoticeServiceImpl.autoCancelFloatWindow();
        }
    };
    private static final Runnable cancelPopupWindowRunnable = new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.9
        @Override // java.lang.Runnable
        public void run() {
            QQGameFullScreenNoticeServiceImpl.autoCancelPopupWindow();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f106607d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f106608e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f106609f;

        a(String str, String str2, boolean z16) {
            this.f106607d = str;
            this.f106608e = str2;
            this.f106609f = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i.l("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9385", "938503", "914123", "20", this.f106607d, "3", "", this.f106608e, "", "");
            if (this.f106609f) {
                QQGameFullScreenNoticeServiceImpl.autoCancelPopupWindow();
            } else {
                QQGameFullScreenNoticeServiceImpl.autoCancelFloatWindow();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f106611d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f106612e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f106613f;

        b(String str, String str2, boolean z16) {
            this.f106611d = str;
            this.f106612e = str2;
            this.f106613f = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i.l("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9385", "938503", "914123", "20", this.f106611d, "2", "", this.f106612e, "", "");
            if (this.f106613f) {
                QQGameFullScreenNoticeServiceImpl.autoCancelPopupWindow();
            } else {
                QQGameFullScreenNoticeServiceImpl.autoCancelFloatWindow();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f106615d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f106616e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f106617f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f106618h;

        c(String str, String str2, String str3, int i3) {
            this.f106615d = str;
            this.f106616e = str2;
            this.f106617f = str3;
            this.f106618h = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i.l("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9385", "938503", "914123", "20", this.f106615d, "1", "", this.f106616e, "", "");
            GameCenterUtil.jumpUrlOrSchema(QQGameFullScreenNoticeServiceImpl.this.btnClickSee.getContext(), this.f106617f);
            if (this.f106618h == 0) {
                QQGameFullScreenNoticeServiceImpl.autoCancelPopupWindow();
            } else {
                QQGameFullScreenNoticeServiceImpl.autoCancelFloatWindow();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QQGameFullScreenNoticeServiceImpl() {
        HashSet<String> hashSet = new HashSet<>();
        this.filterCmds = hashSet;
        hashSet.add(WadlProxyConsts.CMD_TRPC_GET_REMIND_FULLSCREEN);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String appendAdTag(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str3 = "&ADTAG=";
            } else {
                str3 = "?ADTAG=";
            }
            sb5.append(str3);
            sb5.append(str2);
            return sb5.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void autoCancelFloatWindow(long j3) {
        if (j3 == 0) {
            j3 = 7;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(cancelFloatWindowRunnable, j3 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void autoCancelPopupWindow(long j3) {
        if (j3 == 0) {
            j3 = 7;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(cancelPopupWindowRunnable, j3 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 2, "---clear---");
                    QQGameFullScreenNoticeServiceImpl.autoCancelPopupWindow();
                    QQGameFullScreenNoticeServiceImpl.autoCancelFloatWindow();
                } catch (Throwable th5) {
                    QLog.e(QQGameFullScreenNoticeServiceImpl.TAG, 1, th5, new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow createPopWindow(String str, String str2) {
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setWidth(-1);
        popupWindow.setHeight(-1);
        popupWindow.setClippingEnabled(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setContentView(createPopWindowView(true, str, str2));
        return popupWindow;
    }

    private View createPopWindowView(boolean z16, String str, String str2) {
        int color;
        int color2;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        View inflate = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.eb6, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.y3j);
        this.gameBg = imageView;
        imageView.getLayoutParams().height = ViewUtils.getScreenWidth();
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.y3k);
        this.gameClose = imageView2;
        imageView2.setOnClickListener(new a(str, str2, z16));
        TextView textView = (TextView) inflate.findViewById(R.id.tdh);
        this.btnClickJump = textView;
        textView.setOnClickListener(new b(str, str2, z16));
        TextView textView2 = (TextView) inflate.findViewById(R.id.f108206ch);
        this.gameTitle = textView2;
        if (isNowThemeIsNight) {
            color = inflate.getContext().getColor(R.color.f158017al3);
        } else {
            color = inflate.getContext().getColor(R.color.black);
        }
        textView2.setTextColor(color);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f108156cc);
        this.gameAppointmentDesc = textView3;
        if (isNowThemeIsNight) {
            color2 = inflate.getContext().getColor(R.color.f158017al3);
        } else {
            color2 = inflate.getContext().getColor(R.color.black);
        }
        textView3.setTextColor(color2);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.vip);
        if (isNowThemeIsNight) {
            relativeLayout.setBackgroundColor(inflate.getContext().getColor(R.color.black));
        }
        this.btnClickSee = (Button) inflate.findViewById(R.id.tdj);
        return inflate;
    }

    private String formatTs(long j3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j3 * 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getBackgroundFullscreenSwitch() {
        JSONObject jSONObject;
        IFeatureRuntimeService featureRuntimeService = getFeatureRuntimeService();
        if (featureRuntimeService != null) {
            jSONObject = featureRuntimeService.getJSONObject(TOGGLE_SWITCH_NAME, "");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[getBackgroundFullscreenSwitch] " + jSONObject);
        }
        return jSONObject.optBoolean("isShowBackground");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheKey(String str) {
        return CACHE_KEY_PREF + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getCurrentContent() {
        JSONArray pushContents = getPushContents();
        if (pushContents.length() > 0) {
            for (int i3 = 0; i3 < pushContents.length(); i3++) {
                JSONObject optJSONObject = pushContents.optJSONObject(i3);
                if (!isTimeInvalid(optJSONObject.optLong(QCircleLpReportDc05502.KEY_BEGIN_TIME), optJSONObject.optLong("end_time"))) {
                    return optJSONObject;
                }
            }
            return null;
        }
        return null;
    }

    private IFeatureRuntimeService getFeatureRuntimeService() {
        try {
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime == null) {
                QLog.e(TAG, 1, "AppRuntime is null");
                return null;
            }
            return (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    private JSONArray getPushContents() {
        JSONArray jSONArray = new JSONArray();
        try {
            String[] a16 = this.mmkv.a();
            if (a16 != null && a16.length > 0) {
                for (String str : a16) {
                    if (str.contains(CACHE_KEY_PREF)) {
                        String g16 = this.mmkv.g(str.substring(this.mmkv.getKeyPrefix().length() + 1), "");
                        if (!TextUtils.isEmpty(g16)) {
                            jSONArray.mo162put(new JSONObject(g16));
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 2, th5, new Object[0]);
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShowDuration(QQGameFullScreenRemind$FullScreenMessage qQGameFullScreenRemind$FullScreenMessage) {
        JSONObject jSONObject;
        if (qQGameFullScreenRemind$FullScreenMessage != null && qQGameFullScreenRemind$FullScreenMessage.show_seconds.get() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[getShowDuration] use rsp:" + qQGameFullScreenRemind$FullScreenMessage.show_seconds.get());
            }
            return qQGameFullScreenRemind$FullScreenMessage.show_seconds.get();
        }
        IFeatureRuntimeService featureRuntimeService = getFeatureRuntimeService();
        if (featureRuntimeService != null) {
            jSONObject = featureRuntimeService.getJSONObject(TOGGLE_SWITCH_NAME, "");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[getShowDuration] " + jSONObject);
        }
        return jSONObject.optInt("showDuration");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void hideFloatWindow(View view) {
        try {
            QLog.i(TAG, 1, "hideFloatWindow isShow: " + isShow);
            if (view != null && isShow) {
                mWindowManager.removeView(view);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void hidePopupWindow(PopupWindow popupWindow) {
        if (popupWindow != null) {
            try {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPopupViewData(QQGameFullScreenRemind$FullScreenMessage qQGameFullScreenRemind$FullScreenMessage, String str, String str2, int i3) {
        String str3;
        if (qQGameFullScreenRemind$FullScreenMessage == null) {
            QLog.e(TAG, 1, "initPopupViewData no page data");
            return;
        }
        this.gameTitle.setText(qQGameFullScreenRemind$FullScreenMessage.title.get());
        this.gameAppointmentDesc.setText(qQGameFullScreenRemind$FullScreenMessage.content.get());
        this.btnClickSee.setText(qQGameFullScreenRemind$FullScreenMessage.button_text.get());
        String str4 = qQGameFullScreenRemind$FullScreenMessage.button_link.get();
        if (i3 == 0) {
            str3 = AD_TAG_QIANTAI_PAILIAN;
        } else {
            str3 = AD_TAG_HOUTAI_PAILIAN;
        }
        String appendAdTag = appendAdTag(str4, str3);
        if (TextUtils.isEmpty(appendAdTag)) {
            this.btnClickSee.setVisibility(8);
        } else {
            this.btnClickSee.setOnClickListener(new c(str, str2, appendAdTag, i3));
        }
        if (!TextUtils.isEmpty(qQGameFullScreenRemind$FullScreenMessage.head.get())) {
            URLDrawable drawable = URLDrawable.getDrawable(qQGameFullScreenRemind$FullScreenMessage.head.get(), URLDrawable.URLDrawableOptions.obtain());
            if (drawable.getStatus() == 1) {
                this.gameBg.setBackground(drawable);
            } else {
                drawable.setURLDrawableListener(new d());
                drawable.startDownload();
            }
        }
    }

    private boolean isActivityEnable() {
        try {
            IFeatureRuntimeService featureRuntimeService = getFeatureRuntimeService();
            if (featureRuntimeService == null) {
                QLog.e(TAG, 1, "IFeatureRuntimeService is null");
                return false;
            }
            boolean isFeatureSwitchEnable = featureRuntimeService.isFeatureSwitchEnable(TOGGLE_SWITCH_NAME, false);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "game appointment isEnable: " + isFeatureSwitchEnable);
            }
            return isFeatureSwitchEnable;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return false;
        }
    }

    private boolean isTimeInvalid(long j3, long j16) {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "curMilSecond: " + formatTs(serverTime) + ", startTimeStamp: " + formatTs(j3) + ", endTimeStamp: " + formatTs(j16));
        }
        if (j3 != 0 && j16 != 0) {
            if (serverTime < j3 || serverTime > j16) {
                return true;
            }
            return false;
        }
        if (j3 != 0) {
            if (serverTime > j16) {
                return true;
            }
            return false;
        }
        if (j16 != 0 && serverTime < j3) {
            return true;
        }
        return false;
    }

    private void savePushContent(JSONObject jSONObject) {
        String optString = jSONObject.optString(WadlProxyConsts.KEY_MATERIAL);
        if (StringUtil.isEmpty(optString)) {
            clear();
            QLog.i(TAG, 1, "material is empty by push");
        } else if (this.mmkv.c(optString, false)) {
            clear();
            QLog.i(TAG, 1, "has already shown");
        } else {
            this.mmkv.l(getCacheKey(optString), jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScene(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QQGameFullScreenNoticeServiceImpl.this.scene = i3;
            }
        });
    }

    private void showFullscreenReally(final QQGameFullScreenRemind$SsoShowResponse qQGameFullScreenRemind$SsoShowResponse) {
        if (qQGameFullScreenRemind$SsoShowResponse == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.10
            @Override // java.lang.Runnable
            public void run() {
                IQQReminderMsgService iQQReminderMsgService;
                try {
                    QQGameFullScreenRemind$FullScreenMessage qQGameFullScreenRemind$FullScreenMessage = qQGameFullScreenRemind$SsoShowResponse.message.get();
                    int showDuration = QQGameFullScreenNoticeServiceImpl.this.getShowDuration(qQGameFullScreenRemind$FullScreenMessage);
                    if (QQGameFullScreenNoticeServiceImpl.this.scene == 1) {
                        if (com.tencent.gamecenter.wadl.util.c.a(QQGameFullScreenNoticeServiceImpl.this.appRuntime)) {
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "---showRemindDialog---");
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            if (peekAppRuntime != null && (iQQReminderMsgService = (IQQReminderMsgService) peekAppRuntime.getRuntimeService(IQQReminderMsgService.class, ProcessConstant.MULTI)) != null) {
                                Wallet.a aVar = new Wallet.a();
                                aVar.f25154m = 1;
                                aVar.f25143b = qQGameFullScreenRemind$FullScreenMessage.title.get();
                                aVar.f25144c = qQGameFullScreenRemind$FullScreenMessage.content.get();
                                aVar.f25148g = R.drawable.qzone_icon_action_sheet_qq;
                                aVar.f25149h = QQGameFullScreenNoticeServiceImpl.this.appendAdTag(qQGameFullScreenRemind$FullScreenMessage.button_link.get(), QQGameFullScreenNoticeServiceImpl.AD_TAG_QIANTAI_HENGFU);
                                aVar.f25151j = showDuration;
                                aVar.f25155n.putString(WadlProxyConsts.KEY_MATERIAL, qQGameFullScreenRemind$SsoShowResponse.material.get());
                                aVar.f25155n.putString(WadlReportBuilder.TableElem.GAME_APPID, qQGameFullScreenRemind$SsoShowResponse.appid.get());
                                iQQReminderMsgService.showRemindDialog(aVar);
                            }
                        } else {
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "---showNotification---");
                            com.tencent.gamecenter.wadl.notification.c.k().n(qQGameFullScreenRemind$SsoShowResponse.material.get(), qQGameFullScreenRemind$SsoShowResponse.appid.get(), qQGameFullScreenRemind$FullScreenMessage.title.get(), qQGameFullScreenRemind$FullScreenMessage.content.get(), "", QQGameFullScreenNoticeServiceImpl.this.appendAdTag(qQGameFullScreenRemind$FullScreenMessage.button_link.get(), QQGameFullScreenNoticeServiceImpl.AD_TAG_HOUTAI_HENGFU));
                        }
                    } else if (QQGameFullScreenNoticeServiceImpl.this.scene == 2) {
                        String urlParameter = GameCenterUtil.getUrlParameter(qQGameFullScreenRemind$FullScreenMessage.button_link.get(), WinkDaTongReportConstant.ElementParamKey.ADID);
                        String urlParameter2 = GameCenterUtil.getUrlParameter(qQGameFullScreenRemind$FullScreenMessage.button_link.get(), Utils.KEY_BUSINESS_ID);
                        String str = qQGameFullScreenRemind$SsoShowResponse.material.get();
                        String str2 = qQGameFullScreenRemind$SsoShowResponse.appid.get();
                        if (com.tencent.gamecenter.wadl.util.c.a(QQGameFullScreenNoticeServiceImpl.this.appRuntime)) {
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "---showPopupWindow---");
                            QQGameFullScreenNoticeServiceImpl qQGameFullScreenNoticeServiceImpl = QQGameFullScreenNoticeServiceImpl.this;
                            qQGameFullScreenNoticeServiceImpl.popupWindow = qQGameFullScreenNoticeServiceImpl.createPopWindow(str, str2);
                            QQGameFullScreenNoticeServiceImpl qQGameFullScreenNoticeServiceImpl2 = QQGameFullScreenNoticeServiceImpl.this;
                            qQGameFullScreenNoticeServiceImpl2.showPopupWindow(qQGameFullScreenNoticeServiceImpl2.popupWindow, str, str2, urlParameter, urlParameter2);
                            QQGameFullScreenNoticeServiceImpl.this.initPopupViewData(qQGameFullScreenRemind$FullScreenMessage, qQGameFullScreenRemind$SsoShowResponse.material.get(), qQGameFullScreenRemind$SsoShowResponse.appid.get(), 0);
                            QQGameFullScreenNoticeServiceImpl.autoCancelPopupWindow(showDuration);
                        } else {
                            if (!QQGameFullScreenNoticeServiceImpl.this.getBackgroundFullscreenSwitch()) {
                                QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "showFloatWindow switch off");
                            } else {
                                if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext()) && !QQGameFullScreenNoticeServiceImpl.isShow) {
                                    QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "---showFloatWindow---");
                                    QQGameFullScreenNoticeServiceImpl.this.showFloatWindow(BaseApplication.getContext(), str, str2, urlParameter, urlParameter2);
                                    QQGameFullScreenNoticeServiceImpl.this.initPopupViewData(qQGameFullScreenRemind$FullScreenMessage, str, str2, 1);
                                    QQGameFullScreenNoticeServiceImpl.autoCancelFloatWindow(showDuration);
                                }
                                QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "check float permission not allowed : " + QQGameFullScreenNoticeServiceImpl.isShow);
                            }
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow(PopupWindow popupWindow, String str, String str2, String str3, String str4) {
        QBaseActivity qBaseActivity;
        if (popupWindow != null) {
            try {
                if (!popupWindow.isShowing() && (qBaseActivity = QBaseActivity.sTopActivity) != null) {
                    popupWindow.showAtLocation(qBaseActivity.getWindow().getDecorView(), 48, 0, 0);
                    popupViewRef = new WeakReference<>(popupWindow);
                    i.l("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9385", "938503", "914122", "8", str, "", str4, str2, str3, "1294");
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return;
            }
        }
        QLog.e(TAG, 1, "showPopupWindow fail: " + QBaseActivity.sTopActivity);
    }

    @Override // nl0.h
    public HashSet<String> getFilterCmds() {
        return this.filterCmds;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.appRuntime = appRuntime;
        this.mmkv = p03.a.q(appRuntime.getCurrentAccountUin());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 2, "---onDestroy---");
        clear();
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).removeListener(this);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameFullScreenNoticeService
    public void onFullScreenPushReceived(final JSONObject jSONObject) {
        if (!isActivityEnable()) {
            clear();
            QLog.i(TAG, 1, "[onFullScreenPushReceived] switch off");
            return;
        }
        QLog.i(TAG, 1, "[onFullScreenPushReceived] jsonObject: " + jSONObject);
        if (jSONObject != null && jSONObject.optLong("end_time") >= NetConnInfoCenter.getServerTime() && jSONObject.optLong("end_time") >= jSONObject.optLong(QCircleLpReportDc05502.KEY_BEGIN_TIME)) {
            if (i.j(BaseApplication.getContext())) {
                savePushContent(jSONObject);
                return;
            } else if (isTimeInvalid(jSONObject.optLong(QCircleLpReportDc05502.KEY_BEGIN_TIME), jSONObject.optLong("end_time"))) {
                QLog.i(TAG, 2, "[showGameAppointmentFullScreen] is time invalid");
                clear();
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject2 = jSONObject;
                        if (jSONObject2 == null) {
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 2, "[onFullScreenPushReceived] is not time invalid");
                            QQGameFullScreenNoticeServiceImpl.this.clear();
                            return;
                        }
                        String optString = jSONObject2.optString(WadlProxyConsts.KEY_MATERIAL);
                        if (StringUtil.isEmpty(optString)) {
                            QQGameFullScreenNoticeServiceImpl.this.clear();
                        } else {
                            QQGameFullScreenNoticeServiceImpl.this.setScene(1);
                            ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).reqRemindFullScreenInfo(optString);
                        }
                    }
                }, 16, null, true);
                return;
            }
        }
        QLog.i(TAG, 1, "push content invalid");
        clear();
    }

    @Override // nl0.h
    public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        boolean z17;
        QLog.i(TAG, 1, "onTrpcRsp\uff1a cmd: " + str + ", isSucc: " + z16);
        if (!WadlProxyConsts.CMD_TRPC_GET_REMIND_FULLSCREEN.equals(str)) {
            return;
        }
        clear();
        if (!z16) {
            QLog.w(TAG, 1, "onTrpcRsp remind fail");
            return;
        }
        if (obj instanceof QQGameFullScreenRemind$SsoShowResponse) {
            QQGameFullScreenRemind$SsoShowResponse qQGameFullScreenRemind$SsoShowResponse = (QQGameFullScreenRemind$SsoShowResponse) obj;
            if (!qQGameFullScreenRemind$SsoShowResponse.show.get()) {
                QLog.i(TAG, 1, "show switch from server is off");
                return;
            }
            if (qQGameFullScreenRemind$SsoShowResponse.message.has()) {
                if (qQGameFullScreenRemind$SsoShowResponse.message.show_platform.get() == 2) {
                    QLog.i(TAG, 1, "show platform is ios, so not show");
                    return;
                }
                String str2 = qQGameFullScreenRemind$SsoShowResponse.appid.get();
                String str3 = qQGameFullScreenRemind$SsoShowResponse.package_name.get();
                if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(str3)) {
                    boolean z18 = false;
                    try {
                        z17 = ((IQQGameNoticeService) this.appRuntime.getRuntimeService(IQQGameNoticeService.class, "")).hasApkDownloadComplete(str2);
                    } catch (Throwable th5) {
                        QLog.e(TAG, 1, th5, new Object[0]);
                        z17 = false;
                    }
                    PackageInfo packageInfo = GameCenterUtil.getPackageInfo(str3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("hasDownloadComplete: ");
                    sb5.append(z17);
                    sb5.append(", hasInstall: ");
                    if (packageInfo != null) {
                        z18 = true;
                    }
                    sb5.append(z18);
                    QLog.i(TAG, 1, sb5.toString());
                    int i17 = qQGameFullScreenRemind$SsoShowResponse.message.filter.get();
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 != 3) {
                                showFullscreenReally(qQGameFullScreenRemind$SsoShowResponse);
                                return;
                            } else {
                                if (!z17 && packageInfo == null) {
                                    showFullscreenReally(qQGameFullScreenRemind$SsoShowResponse);
                                    return;
                                }
                                return;
                            }
                        }
                        if (packageInfo == null) {
                            showFullscreenReally(qQGameFullScreenRemind$SsoShowResponse);
                            return;
                        }
                        return;
                    }
                    if (!z17) {
                        showFullscreenReally(qQGameFullScreenRemind$SsoShowResponse);
                        return;
                    }
                    return;
                }
                QLog.i(TAG, 1, "appid: " + str2 + ",packageName: " + str3);
                showFullscreenReally(qQGameFullScreenRemind$SsoShowResponse);
            }
        }
    }

    public void showFloatWindow(Context context, String str, String str2, String str3, String str4) {
        if (context == null) {
            QLog.e(TAG, 1, "showFloatWindow context is null");
            return;
        }
        mWindowManager = (WindowManager) context.getSystemService("window");
        View createPopWindowView = createPopWindowView(false, str, str2);
        if (createPopWindowView == null) {
            QLog.e(TAG, 1, "createPopWindowView exception");
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2003;
            }
            layoutParams.flags = 16910088;
            layoutParams.systemUiVisibility = 4102;
            layoutParams.format = -3;
            layoutParams.width = -1;
            layoutParams.height = ViewUtils.getScreenHeight() + ViewUtils.getStatusBarHeight(context);
            layoutParams.gravity = 17;
            mWindowManager.addView(createPopWindowView, layoutParams);
            flowViewRef = new WeakReference<>(createPopWindowView);
            isShow = true;
            i.l("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9385", "938503", "914122", "8", str, "", str4, str2, str3, "1294");
            return;
        }
        clear();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameFullScreenNoticeService
    public void showGameAppointmentFullScreen() {
        if (!isActivityEnable()) {
            clear();
            QLog.i(TAG, 1, "[showGameAppointmentFullScreen] switch off");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameFullScreenNoticeServiceImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject currentContent = QQGameFullScreenNoticeServiceImpl.this.getCurrentContent();
                        if (currentContent == null) {
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 2, "[showGameAppointmentFullScreen] is not time invalid");
                            QQGameFullScreenNoticeServiceImpl.this.clear();
                            return;
                        }
                        String optString = currentContent.optString(WadlProxyConsts.KEY_MATERIAL);
                        if (StringUtil.isEmpty(optString)) {
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "[showGameAppointmentFullScreen] material is empty by push");
                            QQGameFullScreenNoticeServiceImpl.this.clear();
                        } else {
                            if (!QQGameFullScreenNoticeServiceImpl.this.mmkv.c(optString, false)) {
                                QQGameFullScreenNoticeServiceImpl.this.setScene(2);
                                QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "[showGameAppointmentFullScreen] reqRemindFullScreenInfo");
                                ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).reqRemindFullScreenInfo(optString);
                                QQGameFullScreenNoticeServiceImpl.this.mmkv.r(QQGameFullScreenNoticeServiceImpl.this.getCacheKey(optString));
                                return;
                            }
                            QLog.i(QQGameFullScreenNoticeServiceImpl.TAG, 1, "[showGameAppointmentFullScreen] has already shown");
                            QQGameFullScreenNoticeServiceImpl.this.clear();
                        }
                    } catch (Throwable th5) {
                        QLog.e(QQGameFullScreenNoticeServiceImpl.TAG, 1, th5, new Object[0]);
                    }
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void autoCancelFloatWindow() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(cancelFloatWindowRunnable);
        hideFloatWindow(flowViewRef.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void autoCancelPopupWindow() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(cancelPopupWindowRunnable);
        hidePopupWindow(popupViewRef.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements URLDrawable.URLDrawableListener {
        d() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.d(QQGameFullScreenNoticeServiceImpl.TAG, 1, "onLoadCanceled...");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.d(QQGameFullScreenNoticeServiceImpl.TAG, 1, "onLoadFialed...");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.d(QQGameFullScreenNoticeServiceImpl.TAG, 1, "onLoadSuccessed urlDrawable=" + uRLDrawable);
            QQGameFullScreenNoticeServiceImpl.this.gameBg.setBackground(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
