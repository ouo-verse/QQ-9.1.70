package com.tencent.gamecenter.common.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoViewController;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyWebView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GameCenterAPIJavaScript extends VasWebviewJsPlugin {
    public static final String APPKEY_PLAYER = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
    public static final String CLOSE_SWITCH = "closeSwitch";
    public static final String DEL_IMG = "delImg";
    public static String EVENT_PUSH_MSG = "gameCenter_pushMsg";
    public static String EVENT_UPDATE_SESSION_INFO = "gameCenter_sessionChanged";
    public static String EVENT_UPDATE_UNREAD_CNT = "gameCenter_newMsgCountChanged";
    private static final int FRIEND_TYPE_GAME = 3;
    private static final SparseArray<Integer> FRIEND_TYPE_MAP = new a();
    private static final int FRIEND_TYPE_NORMAL = 1;
    private static final int FRIEND_TYPE_TROOP = 2;
    public static String METHOD_CHOOSE_FRIEND = "getFriendInfo";
    public static String METHOD_CREATE_WIDGET = "createWidget";
    public static String METHOD_GET_REQUEST_INFO = "getRequestData";
    public static String METHOD_GET_SESSION_INFO = "getSessionData";
    public static String METHOD_GET_UNREAD_TOTAL = "getNewMsgCount";
    public static String METHOD_LISTEN_PUSH_MSG = "listenPushMsg";
    public static String METHOD_OPEN_AIO = "clickCommonSession";
    public static String METHOD_OPEN_QQPLAYER_AIO = "openQQPlayerAio";
    public static String METHOD_QUERY_WIDGET = "queryWidget";
    public static String METHOD_REPORT_ATTA = "reportAtta";
    public static String METHOD_REQUEST_SPRING_HB_PRELOAD_SOURCE = "requestSpringHBPreloadSource";
    public static String METHOD_SEND_RED_PACK_ARK_FROM_AIO = "sendRedPackArkFromAio";
    public static String METHOD_SEND_RED_PACK_ARK_FROM_FRIEND_CHOOSER = "sendRedPackArkFromFriendChooser";
    public static String METHOD_TOGGLE_CHANGE = "setSwitch";
    public static final String OPEN_SWITCH = "openSwitch";
    public static String PARAMS_KEY_RED_PACK_PAY = "red_pack_pay_params";
    public static final String QUERY_INFO = "queryInfo";
    public static final String REMOVE_MASK = "removeMask";
    private static final byte REQ_CODE_CHOOSE_FRIEND = 16;
    public static final String SET_AUTO_DUAL_SWITCH = "setDualSwitchExt";
    public static final String SHOT_SCREEN = "shotScreen";
    public static final String TAG = "GCApi";
    private static boolean mIsInited;

    /* renamed from: dm, reason: collision with root package name */
    private DisplayMetrics f106491dm;
    private Context mContext;
    public Bundle mReqBundle;
    private TouchWebView.OnScrollChangedListener mScrollChangedListener;
    private FrameLayout mVideoContainer;
    private String uin = "";
    private Map<Integer, k> mVideoViewMap = new HashMap();
    private j mMsgReceiver = new j();

    /* loaded from: classes6.dex */
    class a extends SparseArray<Integer> {
        a() {
            put(0, 1);
            put(1, 2);
            put(10018, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements ScreenshotManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f106492a;

        b(String str) {
            this.f106492a = str;
        }

        @Override // com.tencent.gamecenter.common.util.ScreenshotManager.b
        public void a(int i3, String str) {
            GameCenterAPIJavaScript.this.callbackJS(this.f106492a, i3, str);
        }
    }

    /* loaded from: classes6.dex */
    class c extends FrameLayout {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CustomWebView f106494d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, CustomWebView customWebView) {
            super(context);
            this.f106494d = customWebView;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            CustomWebView customWebView = this.f106494d;
            if (customWebView instanceof View) {
                customWebView.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes6.dex */
    class d implements TouchWebView.OnScrollChangedListener {
        d() {
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            if (GameCenterAPIJavaScript.this.mVideoContainer != null) {
                GameCenterAPIJavaScript.this.mVideoContainer.scrollBy(0, i16 - i18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e extends ViewOutlineProvider {
        e() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), BaseAIOUtils.f(5.0f, view.getResources()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements GameCenterVideoViewController.h {
        f() {
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.h
        public void onAudioMute(boolean z16, int i3, boolean z17) {
            k kVar = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i3));
            if (kVar != null) {
                kVar.f106513k = z16;
                GameCenterAPIJavaScript.this.callJs(kVar.f106519q + "(" + kVar.a() + ");");
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.h
        public void onSrceenModeChanged(boolean z16, int i3) {
            k kVar = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i3));
            if (kVar != null) {
                kVar.f106515m = z16;
                GameCenterAPIJavaScript.this.callJs(kVar.f106518p + "(" + kVar.a() + ");");
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.h
        public void onVideoStatusChanged(int i3, int i16) {
            k kVar;
            if (i3 == 3) {
                k kVar2 = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i16));
                if (kVar2 != null) {
                    GameCenterAPIJavaScript.this.callJs(kVar2.f106521s + "(" + kVar2.a() + ");");
                    return;
                }
                return;
            }
            if (i3 == 5) {
                k kVar3 = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i16));
                if (kVar3 != null) {
                    GameCenterAPIJavaScript.this.callJs(kVar3.f106520r + "(" + kVar3.a() + ");");
                    return;
                }
                return;
            }
            if (i3 == 7) {
                k kVar4 = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i16));
                if (kVar4 != null) {
                    GameCenterAPIJavaScript.this.callJs(kVar4.f106522t + "(" + kVar4.a() + ");");
                    return;
                }
                return;
            }
            if (i3 == 0 && (kVar = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i16))) != null) {
                GameCenterAPIJavaScript.this.callJs(kVar.f106523u + "(" + kVar.a() + ");");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class g implements GameCenterVideoViewController.f {
        g() {
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.f
        public void onProgressChanged(int i3, int i16) {
            k kVar = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i16));
            if (kVar != null) {
                kVar.f106516n = i3 / 1000;
                GameCenterAPIJavaScript.this.callJs(kVar.f106524v + "(" + kVar.a() + ");");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements GameCenterVideoViewController.g {
        h() {
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.g
        public void a(int i3, int i16) {
            k kVar = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i16));
            if (kVar != null) {
                kVar.f106516n = i3 / 1000;
                GameCenterAPIJavaScript.this.callJs(kVar.f106525w + "(" + kVar.a() + ");");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements GameCenterVideoViewController.e {
        i() {
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.e
        public void a(boolean z16, int i3) {
            k kVar = (k) GameCenterAPIJavaScript.this.mVideoViewMap.get(Integer.valueOf(i3));
            if (kVar != null) {
                kVar.f106517o = z16;
                GameCenterAPIJavaScript.this.callJs(kVar.f106526x + "(" + kVar.a() + ");");
            }
        }
    }

    /* loaded from: classes6.dex */
    private class j extends BroadcastReceiver {
        j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                if (("[onRecevier] action:" + action + ",data:" + intent.getExtras()) != null) {
                    str = intent.getExtras().toString();
                } else {
                    str = null;
                }
                QLog.d(GameCenterAPIJavaScript.TAG, 2, str);
            }
            if (action == null) {
                return;
            }
            if ("action_qgame_messgae_change".equals(action)) {
                JSONObject parseGameMessageChange = GameCenterAPIJavaScript.parseGameMessageChange(intent.getExtras());
                if (parseGameMessageChange != null) {
                    GameCenterAPIJavaScript.this.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_SESSION_INFO, parseGameMessageChange, null);
                    return;
                }
                return;
            }
            if ("action_qgame_unread_change".equals(action)) {
                JSONObject parseGameMessageUnreadCount = GameCenterAPIJavaScript.parseGameMessageUnreadCount(intent.getExtras());
                if (parseGameMessageUnreadCount != null) {
                    GameCenterAPIJavaScript.this.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_UNREAD_CNT, parseGameMessageUnreadCount, null);
                    return;
                }
                return;
            }
            if (IGameMsgManagerService.ACTION_GAME_CENTER_PUSH.equals(action)) {
                try {
                    String string = intent.getExtras().getString("key_push_msg");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pushMsg", string);
                    GameCenterAPIJavaScript.this.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_PUSH_MSG, jSONObject, null);
                } catch (Exception e16) {
                    QLog.e(GameCenterAPIJavaScript.TAG, 1, e16, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public GameCenterVideoViewController f106503a;

        /* renamed from: b, reason: collision with root package name */
        public FrameLayout f106504b;

        /* renamed from: c, reason: collision with root package name */
        public Map<Integer, View> f106505c;

        /* renamed from: d, reason: collision with root package name */
        public int f106506d;

        /* renamed from: e, reason: collision with root package name */
        public int f106507e;

        /* renamed from: f, reason: collision with root package name */
        public int f106508f;

        /* renamed from: g, reason: collision with root package name */
        public String f106509g;

        /* renamed from: h, reason: collision with root package name */
        public String f106510h;

        /* renamed from: i, reason: collision with root package name */
        public int f106511i;

        /* renamed from: j, reason: collision with root package name */
        public String f106512j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f106513k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f106514l;

        /* renamed from: n, reason: collision with root package name */
        public int f106516n;

        /* renamed from: p, reason: collision with root package name */
        public String f106518p;

        /* renamed from: q, reason: collision with root package name */
        public String f106519q;

        /* renamed from: r, reason: collision with root package name */
        public String f106520r;

        /* renamed from: s, reason: collision with root package name */
        public String f106521s;

        /* renamed from: t, reason: collision with root package name */
        public String f106522t;

        /* renamed from: u, reason: collision with root package name */
        public String f106523u;

        /* renamed from: v, reason: collision with root package name */
        public String f106524v;

        /* renamed from: w, reason: collision with root package name */
        public String f106525w;

        /* renamed from: x, reason: collision with root package name */
        public String f106526x;

        /* renamed from: m, reason: collision with root package name */
        public boolean f106515m = false;

        /* renamed from: o, reason: collision with root package name */
        public boolean f106517o = false;

        public k(GameCenterVideoViewController gameCenterVideoViewController, FrameLayout frameLayout, Map<Integer, View> map) {
            this.f106503a = gameCenterVideoViewController;
            this.f106504b = frameLayout;
            this.f106505c = map;
        }

        public String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f106506d);
                jSONObject.put(HippyTKDListViewAdapter.X, this.f106508f);
                jSONObject.put("y", this.f106507e);
                jSONObject.put("vid", this.f106509g);
                jSONObject.put("url", this.f106510h);
                jSONObject.put("streamType", this.f106511i);
                jSONObject.put(AudienceReportConst.PROTOCOL, this.f106512j);
                jSONObject.put("mute", this.f106503a.getOutputMute());
                jSONObject.put("total", this.f106503a.getDuration());
                jSONObject.put("current", this.f106503a.getCurrentPostion());
                jSONObject.put("autoPlay", this.f106514l);
                jSONObject.put(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, this.f106515m);
                jSONObject.put("progress", this.f106516n);
                jSONObject.put("danmakuOn", this.f106517o);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    private void handleChooseFriend(JSONObject jSONObject, final String str) {
        final String optString = jSONObject.optString("appid");
        final boolean optBoolean = jSONObject.optBoolean("withGroup");
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).getGameFriendEnableStatus(optString, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.gamecenter.common.util.e
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                GameCenterAPIJavaScript.this.lambda$handleChooseFriend$4(optString, optBoolean, str, (Boolean) obj);
            }
        });
    }

    private void handleChooseFriendResult(Intent intent, int i3) {
        if (i3 != -1) {
            return;
        }
        final String stringExtra = intent.getStringExtra(AppConstants.Key.KEY_GC_JSAPI_CALLBACKID);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        IGameCenterFriendApi iGameCenterFriendApi = (IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class);
        final int intValue = FRIEND_TYPE_MAP.get(intent.getIntExtra("uintype", -1), 1).intValue();
        final String stringExtra2 = intent.getStringExtra("uinname");
        final String stringExtra3 = intent.getStringExtra("uin");
        String stringExtra4 = intent.getStringExtra(AppConstants.Key.KEY_GC_SENDER_ID);
        if (TextUtils.isEmpty(stringExtra4)) {
            stringExtra4 = this.uin;
        }
        final String str = stringExtra4;
        iGameCenterFriendApi.reportFriendChooseResult(intent.getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID), intValue, "0");
        iGameCenterFriendApi.getTokenForFriendChosen(str, stringExtra3, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.gamecenter.common.util.d
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                GameCenterAPIJavaScript.this.lambda$handleChooseFriendResult$5(stringExtra2, intValue, stringExtra3, str, stringExtra, (String) obj);
            }
        });
    }

    private void handleCreateWidget(JSONObject jSONObject) {
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).createWidget(jSONObject.optInt("busId"));
    }

    private void handleQueryWidget(JSONObject jSONObject, final String str) {
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).queryWidget(jSONObject.optInt("busId"), new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.gamecenter.common.util.b
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                GameCenterAPIJavaScript.this.lambda$handleQueryWidget$3(str, (Boolean) obj);
            }
        });
    }

    private void handleReprtAtta(JSONObject jSONObject, final String str) {
        QLog.i(TAG, 1, "[handleReprtAtta]");
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).reportAtta(jSONObject.optString("attainfo"), new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.gamecenter.common.util.c
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                GameCenterAPIJavaScript.this.lambda$handleReprtAtta$2(str, (Integer) obj);
            }
        });
    }

    private void handleSetSwitchStatus(JSONObject jSONObject, final String str) {
        ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).setSwitchStatus(jSONObject.optInt("status"), jSONObject.optInt("switchId"), new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.gamecenter.common.util.g
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                GameCenterAPIJavaScript.this.lambda$handleSetSwitchStatus$1(str, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChooseFriend$4(String str, boolean z16, String str2, Boolean bool) {
        startChooseFriendPage(str, bool.booleanValue(), z16, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChooseFriendResult$5(String str, int i3, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str5)) {
                jSONObject2.put("name", str);
                jSONObject2.put("type", i3);
                jSONObject2.put("friendId", str2);
                jSONObject2.put("senderId", str3);
                jSONObject2.put("token", str5);
                jSONObject.put(GuildMsgItem.NICK_FRIEND, jSONObject2);
                jSONObject.put("ret", 0);
            } else {
                jSONObject.put("ret", 1);
            }
        } catch (JSONException unused) {
        }
        callback(str4, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleQueryWidget$3(String str, Boolean bool) {
        onCheckAddWidgetResult(bool.booleanValue(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleReprtAtta$2(String str, Integer num) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", num);
            super.callJs(str + "(" + jSONObject.toString() + ");");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[handleReprtAtta], error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSetSwitchStatus$1(String str, Integer num) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", num);
            jSONObject.put("ret", num);
            super.callJs(str + "(" + jSONObject.toString() + ");");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[handleSetSwitchStatus], error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportMiniAppOpen$0(String str, boolean z16, JSONObject jSONObject) {
        String str2;
        if (z16) {
            callbackJS(str, 0, "success");
        } else {
            callbackJS(str, jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1), jSONObject.optString("resultMessage", ""));
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        hashMap.put("ext7", str2);
        hashMap.put("ext2", "appid");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9410", "941001", "914450", "", hashMap);
    }

    private void onCheckAddWidgetResult(boolean z16, String str) {
        try {
            int i3 = 1;
            QLog.i(TAG, 1, "[onCheckAddWidgetResult], isAdd:" + z16);
            JSONObject jSONObject = new JSONObject();
            if (z16) {
                i3 = 0;
            }
            jSONObject.put("ret", i3);
            super.callJs(str + "(" + jSONObject.toString() + ");");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onCheckAddWidgetResult->" + jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
    }

    public static JSONObject parseGameMessageChange(Bundle bundle) {
        if (bundle != null) {
            GameCenterSessionInfo gameCenterSessionInfo = (GameCenterSessionInfo) bundle.getParcelable("key_game_msg");
            int i3 = bundle.getInt("key_msg_change_type");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[onReceive] type:" + i3 + ",info:" + gameCenterSessionInfo);
            }
            JSONArray jSONArray = new JSONArray();
            if (gameCenterSessionInfo != null) {
                jSONArray.mo162put(gameCenterSessionInfo.o());
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SessionDbHelper.SESSION_ID, jSONArray);
                jSONObject.put("eventType", i3);
                jSONObject.put("ret", 0);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[onReceive] gameCenterMsg: " + jSONObject.toString());
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static JSONObject parseGameMessageUnreadCount(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt("key_msg_unread_cnt");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[onReceive] cnt:" + i3);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("newMsgCount", i3);
                jSONObject.put("ret", 0);
                String string = bundle.getString("key_msg_single_unread_cnt", "");
                QLog.i(TAG, 1, "[parseGameMessageUnreadCount] ----unreadStr---:" + string);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("tabMsgCount", new JSONObject(string));
                }
                return jSONObject;
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return null;
            }
        }
        return null;
    }

    private void requestSpringHBPreloadSource() {
        ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).requestSpringHBPreloadSource();
    }

    private void startChooseFriendPage(String str, boolean z16, boolean z17, String str2) {
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        Intent intent = new Intent(a16, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1058);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(AppConstants.Key.KEY_GC_GAME_APPID, str);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_GAME_FRIEND_ENTRANCE, z16);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_TROOP_ENTRANCE, z17);
        intent.putExtra(AppConstants.Key.KEY_GC_JSAPI_CALLBACKID, str2);
        intent.putExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC, "0");
        startActivityForResult(intent, (byte) 16);
    }

    void callback(String str, JSONObject jSONObject) {
        try {
            super.callJs(str + "&&" + str + "(" + jSONObject.toString() + ");");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "callback id=" + str + ", ret=" + jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
    }

    void callbackError(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 1);
            jSONObject.put("msg", str2);
            super.callJs(str + "&&" + str + "(" + jSONObject.toString() + ");");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "callbackId->" + str + " errorMsg: " + str2);
        }
    }

    void callbackJS(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i3);
            jSONObject.put("ret", i3);
            jSONObject.put("msg", str2);
            super.callJs(str + "(" + jSONObject.toString() + ");");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "callbackId->" + str + " callbackOk" + jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
    }

    void callbackOk(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", 0);
            jSONObject.put("msg", "");
            super.callJs(str + "&&" + str + "(" + jSONObject.toString() + ");");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "callbackId->" + str + " callbackOk" + jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
    }

    public int clearDanmu(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                int optInt2 = jSONObject.optInt("mask");
                GameCenterVideoViewController gameCenterVideoViewController = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a;
                if ((optInt2 & 1) == 1) {
                    gameCenterVideoViewController.getDanmakuLayout().l();
                }
                if ((optInt2 & 2) == 2) {
                    gameCenterVideoViewController.getDanmakuLayout().m();
                    return 0;
                }
                return 0;
            }
            QLog.e(TAG, 1, "[clearDanmuData] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "clearDanmuData Err:" + e16.toString());
            return -1;
        }
    }

    public int createVideo(JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        float f16;
        boolean z18;
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar == null || bVar.b() == null || this.mRuntime.b().getApplication() == null) {
                return -1;
            }
            QQVideoPlaySDKManager.initSDKAsync(this.mRuntime.b().getApplication(), null);
        }
        if (this.mRuntime == null) {
            return -1;
        }
        try {
            int optInt = jSONObject.optInt("y");
            int optInt2 = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt3 = jSONObject.optInt("width");
            int optInt4 = jSONObject.optInt("height");
            String optString = jSONObject.optString("vid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString(AudienceReportConst.PROTOCOL);
            int optInt5 = jSONObject.optInt("steamType");
            if (jSONObject.optInt("isMute") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (jSONObject.optInt("autoPlay") == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            String optString4 = jSONObject.optString("fullScreenCallBack");
            int optInt6 = jSONObject.optInt("danmakuSwitch");
            int optInt7 = jSONObject.optInt("duration");
            int optInt8 = jSONObject.optInt("uiStyle");
            String optString5 = jSONObject.optString("muteCallBack");
            String optString6 = jSONObject.optString("onPauseCallBack");
            String optString7 = jSONObject.optString("onPlayCallBack");
            String optString8 = jSONObject.optString("onEndCallBack");
            String optString9 = jSONObject.optString("onStopCallBack");
            String optString10 = jSONObject.optString("onProgressCallBack", null);
            String optString11 = jSONObject.optString("onDanmakuCallBack", null);
            String optString12 = jSONObject.optString("onSeekCallBack", null);
            int optInt9 = jSONObject.optInt("tabHeight", 0);
            boolean z19 = z16;
            int optInt10 = jSONObject.optInt("bottomHeight", 0);
            boolean optBoolean = jSONObject.optBoolean("isFillet", false);
            try {
                URLDrawable.getDrawable(jSONObject.optString(QAdVrReport.ElementID.AD_POSTER, ""));
            } catch (Exception unused) {
            }
            float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
            if (fontLevel != 0.0f) {
                f16 = ah.q() / fontLevel;
            } else {
                f16 = 0.0f;
            }
            if (f16 == 0.0f) {
                f16 = ah.q();
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoContainer.getLayoutParams();
            layoutParams.topMargin = (int) (optInt9 * f16);
            layoutParams.bottomMargin = (int) (optInt10 * f16);
            this.mVideoContainer.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (optInt3 * f16), (int) (optInt4 * f16));
            layoutParams2.topMargin = (int) ((optInt - optInt9) * f16);
            layoutParams2.leftMargin = (int) (optInt2 * f16);
            GameCenterVideoViewController gameCenterVideoViewController = new GameCenterVideoViewController(this.mRuntime.a());
            gameCenterVideoViewController.setBackgroundColor(-16777216);
            if (optBoolean) {
                gameCenterVideoViewController.setOutlineProvider(new e());
                gameCenterVideoViewController.setClipToOutline(true);
            }
            gameCenterVideoViewController.enableFullScreenSwitch();
            gameCenterVideoViewController.enableVolumeSwitch();
            gameCenterVideoViewController.setDanmakuSwitch(optInt6);
            gameCenterVideoViewController.setLoadingIconStyle(optInt8);
            FrameLayout frameLayout = new FrameLayout(this.mRuntime.a());
            gameCenterVideoViewController.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            this.mVideoContainer.addView(gameCenterVideoViewController, layoutParams2);
            ((TouchWebView) this.mRuntime.e()).setOnScrollChangedListener(this.mScrollChangedListener);
            int abs = Math.abs((optString + optString2).hashCode());
            gameCenterVideoViewController.setVideoId(abs);
            k kVar = new k(gameCenterVideoViewController, frameLayout, new HashMap());
            kVar.f106509g = optString;
            kVar.f106514l = z17;
            kVar.f106508f = optInt2;
            kVar.f106507e = optInt;
            kVar.f106506d = abs;
            kVar.f106511i = optInt5;
            kVar.f106512j = optString3;
            kVar.f106513k = z19;
            if (optInt6 == 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            kVar.f106517o = z18;
            kVar.f106518p = optString4;
            kVar.f106519q = optString5;
            kVar.f106521s = optString7;
            kVar.f106520r = optString6;
            kVar.f106522t = optString8;
            kVar.f106523u = optString9;
            kVar.f106524v = optString10;
            kVar.f106525w = optString12;
            kVar.f106526x = optString11;
            this.mVideoViewMap.put(Integer.valueOf(abs), kVar);
            FeedsItemData feedsItemData = new FeedsItemData();
            feedsItemData.videoVid = optString;
            if (optInt5 == 1) {
                feedsItemData.type = 2;
            } else {
                feedsItemData.type = 1;
            }
            feedsItemData.videoDuration = optInt7;
            feedsItemData.videoUrl = optString2;
            gameCenterVideoViewController.setData(feedsItemData, 1, false);
            if (z17) {
                gameCenterVideoViewController.autoPlay();
            }
            if (z19) {
                gameCenterVideoViewController.setMute(true);
            }
            gameCenterVideoViewController.setVideoStatusChangerListener(new f());
            if (optString10 != null) {
                gameCenterVideoViewController.setOnProgressChangeListener(new g());
            }
            if (optString12 != null) {
                gameCenterVideoViewController.setOnSeekListener(new h());
            }
            if (optString11 != null) {
                gameCenterVideoViewController.setOnDanmakuChangeListener(new i());
            }
            return abs;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "AddView Err:" + e16);
            return -1;
        }
    }

    public int delFlag(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            int optInt2 = jSONObject.optInt("pid");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                k kVar = this.mVideoViewMap.get(Integer.valueOf(optInt));
                kVar.f106504b.removeView(kVar.f106505c.get(Integer.valueOf(optInt2)));
                kVar.f106505c.remove(Integer.valueOf(optInt2));
                return 0;
            }
            QLog.e(TAG, 1, "[setText] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setText Err:" + e16.toString());
            return -1;
        }
    }

    public int delText(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            int optInt2 = jSONObject.optInt("pid");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                k kVar = this.mVideoViewMap.get(Integer.valueOf(optInt));
                kVar.f106504b.removeView(kVar.f106505c.get(Integer.valueOf(optInt2)));
                kVar.f106505c.remove(Integer.valueOf(optInt2));
                return 0;
            }
            QLog.e(TAG, 1, "[setText] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setText Err:" + e16.toString());
            return -1;
        }
    }

    public int destoryVideo(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                GameCenterVideoViewController gameCenterVideoViewController = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a;
                gameCenterVideoViewController.stop();
                gameCenterVideoViewController.release();
                this.mVideoContainer.removeView(gameCenterVideoViewController);
                this.mVideoContainer.removeView(this.mVideoViewMap.get(Integer.valueOf(optInt)).f106504b);
                this.mVideoViewMap.remove(Integer.valueOf(optInt));
                return 0;
            }
            QLog.e(TAG, 1, "[destoryVideo] Err: not find videoPlayer");
            return 0;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "[destoryVideo] Err:" + e16.toString());
            return -1;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return TAG;
    }

    public String getOpenidBatch(String str) {
        Context context = this.mContext;
        if (context instanceof GameCenterActivity) {
            return GameCenterActivity.httpRequest(context, "https://cgi.connect.qq.com/api/get_openids_by_appids", str, this.uin);
        }
        return "";
    }

    public long getProgress(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                return this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.getCurrentPostion();
            }
            QLog.e(TAG, 1, "[getProgress] Err: not find videoPlayer");
            return -1L;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "getProgress Err:" + e16.toString());
            return -1L;
        }
    }

    public String getReportPublicHighData() {
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append("" + com.tencent.gamecenter.common.util.a.I());
            sb5.append("|");
            sb5.append("" + com.tencent.open.base.a.c(this.mContext.getApplicationContext()));
            sb5.append("|");
            sb5.append("" + Build.VERSION.RELEASE);
            sb5.append("|");
            sb5.append("" + com.tencent.open.adapter.a.f().n());
            sb5.append("|");
            sb5.append(AppSetting.f());
            sb5.append("|");
            sb5.append(this.f106491dm.widthPixels + " * " + this.f106491dm.heightPixels);
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public long getTotalDuration(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                return this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.getDuration();
            }
            QLog.e(TAG, 1, "[getProgress] Err: not find videoPlayer");
            return -1L;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "getProgress Err:" + e16.toString());
            return -1L;
        }
    }

    public String getVersionName() {
        try {
            return com.tencent.open.adapter.a.f().n();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "4.3.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:58:0x084a A[ADDED_TO_REGION] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        boolean z16;
        String str5;
        JsBridgeListener jsBridgeListener2;
        char c16;
        int i3;
        char c17;
        int i16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleJsRequest] method:");
            sb5.append(str3);
            sb5.append("params:");
            str4 = "toTinyId";
            sb5.append(strArr[0]);
            QLog.d(TAG, 2, sb5.toString());
        } else {
            str4 = "toTinyId";
        }
        if (!TAG.equals(str2)) {
            return false;
        }
        if (METHOD_GET_SESSION_INFO.equals(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("callback");
                this.mReqBundle.clear();
                this.mReqBundle.putInt("dataType", jSONObject.optInt("dataType", 0));
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_get_session_info", optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            z16 = true;
        } else {
            if (METHOD_GET_REQUEST_INFO.equals(str3)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    String optString2 = jSONObject2.optString("callback");
                    this.mReqBundle.clear();
                    this.mReqBundle.putString(VirtualAppProxy.KEY_GAME_ID, jSONObject2.optString(VirtualAppProxy.KEY_GAME_ID, ""));
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_get_request_info", optString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            } else if (METHOD_OPEN_AIO.equals(str3)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(strArr[0]);
                    String optString3 = jSONObject3.optString("callback");
                    this.mReqBundle.clear();
                    this.mReqBundle.putString("sessionId", jSONObject3.optString("sessionId", ""));
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_open_aio", optString3, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
            } else if (METHOD_GET_UNREAD_TOTAL.equals(str3)) {
                try {
                    String optString4 = new JSONObject(strArr[0]).optString("callback");
                    this.mReqBundle.clear();
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_get_unread_total", optString4, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                } catch (JSONException e19) {
                    e19.printStackTrace();
                }
            } else if (METHOD_LISTEN_PUSH_MSG.equals(str3)) {
                try {
                    String optString5 = new JSONObject(strArr[0]).optString("callback");
                    this.mReqBundle.clear();
                    this.mReqBundle.putBoolean("state", true);
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_set_push_state", optString5, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                } catch (JSONException e26) {
                    e26.printStackTrace();
                }
            } else if (METHOD_TOGGLE_CHANGE.equals(str3)) {
                try {
                    JSONObject jSONObject4 = new JSONObject(strArr[0]);
                    String optString6 = jSONObject4.optString("callback");
                    this.mReqBundle.clear();
                    this.mReqBundle.putString(VirtualAppProxy.KEY_GAME_ID, jSONObject4.optString(VirtualAppProxy.KEY_GAME_ID, ""));
                    this.mReqBundle.putInt("switchType", jSONObject4.optInt("switchType", -1));
                    this.mReqBundle.putInt("value", jSONObject4.optInt("value", -1));
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_toggle_changed", optString6, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                } catch (JSONException e27) {
                    e27.printStackTrace();
                }
            } else if ("createVideo".equals(str3)) {
                try {
                    JSONObject jSONObject5 = new JSONObject(strArr[0]);
                    String optString7 = jSONObject5.optString("callback");
                    int createVideo = createVideo(jSONObject5);
                    int i17 = createVideo > 0 ? 0 : createVideo;
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("ret", i17);
                    jSONObject6.put("id", createVideo);
                    super.callJs(optString7 + "(" + jSONObject6.toString() + ");");
                } catch (JSONException e28) {
                    e28.printStackTrace();
                }
            } else if ("destoryVideo".equals(str3)) {
                try {
                    JSONObject jSONObject7 = new JSONObject(strArr[0]);
                    String optString8 = jSONObject7.optString("callback");
                    int destoryVideo = destoryVideo(jSONObject7);
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("ret", destoryVideo);
                    super.callJs(optString8 + "(" + jSONObject8.toString() + ");");
                } catch (JSONException e29) {
                    e29.printStackTrace();
                }
            } else if ("playVideo".equals(str3)) {
                try {
                    JSONObject jSONObject9 = new JSONObject(strArr[0]);
                    String optString9 = jSONObject9.optString("callback");
                    int playVideo = playVideo(jSONObject9);
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("ret", playVideo);
                    super.callJs(optString9 + "(" + jSONObject10.toString() + ");");
                } catch (JSONException e36) {
                    e36.printStackTrace();
                }
            } else if ("pauseVideo".equals(str3)) {
                try {
                    JSONObject jSONObject11 = new JSONObject(strArr[0]);
                    String optString10 = jSONObject11.optString("callback");
                    int pauseVideo = pauseVideo(jSONObject11);
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("ret", pauseVideo);
                    super.callJs(optString10 + "(" + jSONObject12.toString() + ");");
                } catch (JSONException e37) {
                    e37.printStackTrace();
                }
            } else if ("stopVideo".equals(str3)) {
                try {
                    JSONObject jSONObject13 = new JSONObject(strArr[0]);
                    String optString11 = jSONObject13.optString("callback");
                    int stopVideo = stopVideo(jSONObject13);
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("ret", stopVideo);
                    super.callJs(optString11 + "(" + jSONObject14.toString() + ");");
                } catch (JSONException e38) {
                    e38.printStackTrace();
                }
            } else if ("setPosition".equals(str3)) {
                try {
                    JSONObject jSONObject15 = new JSONObject(strArr[0]);
                    String optString12 = jSONObject15.optString("callback");
                    int position = setPosition(jSONObject15);
                    JSONObject jSONObject16 = new JSONObject();
                    jSONObject16.put("ret", position);
                    super.callJs(optString12 + "(" + jSONObject16.toString() + ");");
                } catch (JSONException e39) {
                    e39.printStackTrace();
                }
            } else if ("setFlag".equals(str3)) {
                try {
                    JSONObject jSONObject17 = new JSONObject(strArr[0]);
                    String optString13 = jSONObject17.optString("callback");
                    int flag = setFlag(jSONObject17);
                    JSONObject jSONObject18 = new JSONObject();
                    jSONObject18.put("ret", 0);
                    jSONObject18.put("pid", flag);
                    super.callJs(optString13 + "(" + jSONObject18.toString() + ");");
                } catch (JSONException e46) {
                    e46.printStackTrace();
                }
            } else if ("delFlag".equals(str3)) {
                try {
                    JSONObject jSONObject19 = new JSONObject(strArr[0]);
                    String optString14 = jSONObject19.optString("callback");
                    int delFlag = delFlag(jSONObject19);
                    JSONObject jSONObject20 = new JSONObject();
                    jSONObject20.put("ret", delFlag);
                    super.callJs(optString14 + "(" + jSONObject20.toString() + ");");
                } catch (JSONException e47) {
                    e47.printStackTrace();
                }
            } else if (IECSearchBar.METHOD_SET_TEXT.equals(str3)) {
                try {
                    JSONObject jSONObject21 = new JSONObject(strArr[0]);
                    String optString15 = jSONObject21.optString("callback");
                    int text = setText(jSONObject21);
                    JSONObject jSONObject22 = new JSONObject();
                    jSONObject22.put("ret", 0);
                    jSONObject22.put("pid", text);
                    super.callJs(optString15 + "(" + jSONObject22.toString() + ");");
                } catch (JSONException e48) {
                    e48.printStackTrace();
                }
            } else if ("delText".equals(str3)) {
                try {
                    JSONObject jSONObject23 = new JSONObject(strArr[0]);
                    String optString16 = jSONObject23.optString("callback");
                    int delText = delText(jSONObject23);
                    JSONObject jSONObject24 = new JSONObject();
                    jSONObject24.put("ret", delText);
                    super.callJs(optString16 + "(" + jSONObject24.toString() + ");");
                } catch (JSONException e49) {
                    e49.printStackTrace();
                }
            } else if ("setFullScreen".equals(str3)) {
                try {
                    JSONObject jSONObject25 = new JSONObject(strArr[0]);
                    String optString17 = jSONObject25.optString("callback");
                    int fullScreen = setFullScreen(jSONObject25);
                    JSONObject jSONObject26 = new JSONObject();
                    jSONObject26.put("ret", fullScreen);
                    super.callJs(optString17 + "(" + jSONObject26.toString() + ");");
                } catch (JSONException e56) {
                    e56.printStackTrace();
                }
            } else if ("setMute".equals(str3)) {
                try {
                    JSONObject jSONObject27 = new JSONObject(strArr[0]);
                    String optString18 = jSONObject27.optString("callback");
                    int mute = setMute(jSONObject27);
                    JSONObject jSONObject28 = new JSONObject();
                    jSONObject28.put("ret", mute);
                    super.callJs(optString18 + "(" + jSONObject28.toString() + ");");
                } catch (JSONException e57) {
                    e57.printStackTrace();
                }
            } else if ("setSpeedRatio".equals(str3)) {
                try {
                    JSONObject jSONObject29 = new JSONObject(strArr[0]);
                    String optString19 = jSONObject29.optString("callback");
                    int videoSpeedRatio = setVideoSpeedRatio(jSONObject29);
                    JSONObject jSONObject30 = new JSONObject();
                    jSONObject30.put("ret", videoSpeedRatio);
                    super.callJs(optString19 + "(" + jSONObject30.toString() + ");");
                } catch (JSONException e58) {
                    e58.printStackTrace();
                }
            } else if (HippyQQPagView.FunctionName.GET_PROGRESS.equals(str3)) {
                try {
                    JSONObject jSONObject31 = new JSONObject(strArr[0]);
                    String optString20 = jSONObject31.optString("callback");
                    long progress = getProgress(jSONObject31);
                    long totalDuration = getTotalDuration(jSONObject31);
                    JSONObject jSONObject32 = new JSONObject();
                    jSONObject32.put("ret", 0);
                    jSONObject32.put("current", progress);
                    jSONObject32.put("total", totalDuration);
                    super.callJs(optString20 + "(" + jSONObject32.toString() + ");");
                } catch (JSONException e59) {
                    e59.printStackTrace();
                }
            } else if ("setDanmuViewProperty".equals(str3)) {
                try {
                    JSONObject jSONObject33 = new JSONObject(strArr[0]);
                    String optString21 = jSONObject33.optString("callback");
                    int danmuViewProperty = setDanmuViewProperty(jSONObject33);
                    JSONObject jSONObject34 = new JSONObject();
                    jSONObject34.put("ret", danmuViewProperty);
                    super.callJs(optString21 + "(" + jSONObject34.toString() + ");");
                } catch (JSONException e65) {
                    e65.printStackTrace();
                }
            } else if (GameCenterVideoViewController.PropName.SET_DANMU_DATA.equals(str3)) {
                try {
                    JSONObject jSONObject35 = new JSONObject(strArr[0]);
                    String optString22 = jSONObject35.optString("callback");
                    int danmuData = setDanmuData(jSONObject35);
                    JSONObject jSONObject36 = new JSONObject();
                    jSONObject36.put("ret", danmuData);
                    super.callJs(optString22 + "(" + jSONObject36.toString() + ");");
                } catch (JSONException e66) {
                    e66.printStackTrace();
                }
            } else if (GameCenterVideoViewController.PropName.CLEAR_DANMU.equals(str3)) {
                try {
                    JSONObject jSONObject37 = new JSONObject(strArr[0]);
                    String optString23 = jSONObject37.optString("callback");
                    int clearDanmu = clearDanmu(jSONObject37);
                    JSONObject jSONObject38 = new JSONObject();
                    jSONObject38.put("ret", clearDanmu);
                    super.callJs(optString23 + "(" + jSONObject38.toString() + ");");
                } catch (JSONException e67) {
                    e67.printStackTrace();
                }
            } else {
                if ("getOpenidBatch".equals(str3)) {
                    i3 = 1;
                    if (strArr.length == 1) {
                        str5 = getOpenidBatch(strArr[0]);
                        jsBridgeListener2 = jsBridgeListener;
                        z16 = true;
                        if (jsBridgeListener2 != null && str5 != null) {
                            jsBridgeListener2.c(str5);
                        }
                        return z16;
                    }
                    c16 = 0;
                } else {
                    c16 = 0;
                    i3 = 1;
                }
                if ("showWarningToast".equals(str3) && strArr.length == i3) {
                    showWarningToast(strArr[c16]);
                } else {
                    if ("getUin".equals(str3)) {
                        str5 = this.uin;
                    } else if ("setTitleLoading".equals(str3) && strArr.length == 1) {
                        setTitleLoading(strArr[0]);
                    } else if ("getReportPublicHighData".equals(str3)) {
                        str5 = getReportPublicHighData();
                    } else if (IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION.equals(str3) && strArr.length == 3) {
                        reportAction(strArr[0], strArr[1], strArr[2]);
                    } else if ("getVersionName".equals(str3)) {
                        str5 = getVersionName();
                    } else {
                        if ("startToAuthorized".equals(str3)) {
                            i16 = 1;
                            if (strArr.length == 1) {
                                startToAuthorized(strArr[0]);
                                z16 = true;
                            } else {
                                c17 = 0;
                            }
                        } else {
                            c17 = 0;
                            i16 = 1;
                        }
                        if ("reportMiniAppOpen".equals(str3) && strArr.length == i16) {
                            reportMiniAppOpen(strArr[c17]);
                        } else if (METHOD_OPEN_QQPLAYER_AIO.equals(str3)) {
                            try {
                                JSONObject jSONObject39 = new JSONObject(strArr[c17]);
                                String optString24 = jSONObject39.optString("callback");
                                this.mReqBundle.clear();
                                this.mReqBundle.putString("fromRoleId", jSONObject39.optString("fromRoleId", ""));
                                this.mReqBundle.putString("fromOpenId", jSONObject39.optString("fromOpenId", ""));
                                this.mReqBundle.putString("toRoleId", jSONObject39.optString("toRoleId", ""));
                                this.mReqBundle.putString("toOpenId", jSONObject39.optString("toOpenId", ""));
                                this.mReqBundle.putString("fromTinyId", jSONObject39.optString("fromTinyId", ""));
                                String str6 = str4;
                                this.mReqBundle.putString(str6, jSONObject39.optString(str6, ""));
                                this.mReqBundle.putLong("gameAppId", jSONObject39.optLong("gameAppId", 0L));
                                this.mReqBundle.putInt("windowFlag", jSONObject39.optInt("windowFlag", 0));
                                this.mReqBundle.putString("topGrayText", jSONObject39.optString("topGrayText", ""));
                                this.mReqBundle.putString(PreloadTRTCPlayerParams.KEY_SIG, jSONObject39.optString(PreloadTRTCPlayerParams.KEY_SIG, ""));
                                this.mReqBundle.putInt("fromPage", jSONObject39.optInt("fromPage"));
                                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_open_qqplayer_aio", optString24, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                            } catch (JSONException e68) {
                                e68.printStackTrace();
                            }
                        } else {
                            try {
                                JSONObject jSONObject40 = new JSONObject(strArr[0]);
                                String optString25 = jSONObject40.optString("callback");
                                if (!handleScreenShotMethod(str3, jSONObject40.optJSONObject("data"), optString25)) {
                                    handleOtherJsApiMethods(str3, jSONObject40, optString25);
                                }
                            } catch (JSONException e69) {
                                z16 = true;
                                QLog.e(TAG, 1, "handleScreenShotMethod e=" + e69.toString());
                            }
                        }
                    }
                    jsBridgeListener2 = jsBridgeListener;
                    z16 = true;
                    if (jsBridgeListener2 != null) {
                        jsBridgeListener2.c(str5);
                    }
                    return z16;
                }
            }
            z16 = true;
        }
        str5 = null;
        jsBridgeListener2 = jsBridgeListener;
        if (jsBridgeListener2 != null) {
        }
        return z16;
    }

    public void handleOtherJsApiMethods(String str, JSONObject jSONObject, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[handleOtherJsApiMethods],method:" + str + ",json:" + jSONObject + ",callbackId" + str2);
        }
        this.mReqBundle.clear();
        if (METHOD_SEND_RED_PACK_ARK_FROM_AIO.equals(str)) {
            this.mReqBundle.putString(PARAMS_KEY_RED_PACK_PAY, jSONObject.toString());
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_send_ark_from_aio", str2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            return;
        }
        if (METHOD_SEND_RED_PACK_ARK_FROM_FRIEND_CHOOSER.equals(str)) {
            this.mReqBundle.putString(PARAMS_KEY_RED_PACK_PAY, jSONObject.toString());
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_send_ark_from_friend_chooser", str2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            return;
        }
        if (METHOD_CHOOSE_FRIEND.equals(str)) {
            handleChooseFriend(jSONObject, str2);
            return;
        }
        if (METHOD_QUERY_WIDGET.equals(str)) {
            handleQueryWidget(jSONObject, str2);
            return;
        }
        if (METHOD_CREATE_WIDGET.equals(str)) {
            handleCreateWidget(jSONObject);
            return;
        }
        if (METHOD_REPORT_ATTA.equals(str)) {
            handleReprtAtta(jSONObject, str2);
        } else if (METHOD_REQUEST_SPRING_HB_PRELOAD_SOURCE.equals(str)) {
            requestSpringHBPreloadSource();
        } else if (SET_AUTO_DUAL_SWITCH.equals(str)) {
            handleSetSwitchStatus(jSONObject, str2);
        }
    }

    public boolean handleScreenShotMethod(String str, JSONObject jSONObject, String str2) {
        b bVar = new b(str2);
        if (SHOT_SCREEN.equals(str)) {
            ScreenshotManager.m().u(this.mRuntime.e(), jSONObject.optString("key"), bVar);
            return true;
        }
        if (REMOVE_MASK.equals(str)) {
            ScreenshotManager.m().s(this.mRuntime.e(), bVar);
            return true;
        }
        if (DEL_IMG.equals(str)) {
            ScreenshotManager.m().j(bVar);
            return true;
        }
        if (CLOSE_SWITCH.equals(str)) {
            ScreenshotManager.m().i(bVar);
            return true;
        }
        if (OPEN_SWITCH.equals(str)) {
            ScreenshotManager.m().q(bVar);
            return true;
        }
        if (QUERY_INFO.equals(str)) {
            ScreenshotManager.m().r(jSONObject.optString("key"), bVar);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (16 == b16) {
            handleChooseFriendResult(intent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mReqBundle = new Bundle();
        this.f106491dm = new DisplayMetrics();
        Activity a16 = this.mRuntime.a();
        this.mContext = a16;
        if (a16 != null) {
            a16.getWindowManager().getDefaultDisplay().getMetrics(this.f106491dm);
        }
        if (this.mRuntime.b() != null) {
            this.uin = this.mRuntime.b().getCurrentAccountUin();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_qgame_messgae_change");
        intentFilter.addAction("action_qgame_unread_change");
        intentFilter.addAction(IGameMsgManagerService.ACTION_GAME_CENTER_PUSH);
        BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        if (this.mMsgReceiver != null) {
            BaseApplicationImpl.getApplication().unregisterReceiver(this.mMsgReceiver);
            this.mReqBundle.putBoolean("state", false);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_set_push_state", "", this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        com.tencent.mobileqq.gamecenter.media.c.b().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        super.onResponse(bundle);
        if (bundle != null) {
            String string = bundle.getString("cmd");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "[onResponse] cmd:" + string);
            }
            int i3 = bundle.getInt("respkey", 0);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "[onResponse] respkey:" + i3 + "\uff0ckey:" + this.mOnRemoteResp.key);
            }
            if (i3 == this.mOnRemoteResp.key) {
                String string2 = bundle.getString("callbackid");
                Bundle bundle2 = bundle.getBundle("response");
                if (string != null && bundle2 != null) {
                    Activity a16 = this.mRuntime.a();
                    if (a16 != null && !this.isDestroy && !a16.isFinishing()) {
                        try {
                            if ("ipc_cmd_gamecenter_get_session_info".equals(string)) {
                                int i16 = bundle2.getInt("result");
                                String string3 = bundle2.getString("data");
                                JSONObject jSONObject = new JSONObject(string3);
                                jSONObject.put("ret", i16);
                                super.callJs(string2 + "&&" + string2 + "(" + jSONObject.toString() + ");");
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "ipc_cmd_gamecenter_get_session_info onResponse dataStr is:" + string3);
                                }
                            } else if ("ipc_cmd_gamecenter_get_request_info".equals(string)) {
                                int i17 = bundle2.getInt("result");
                                String string4 = bundle2.getString("data");
                                JSONObject jSONObject2 = new JSONObject(string4);
                                jSONObject2.put("ret", i17);
                                super.callJs(string2 + "&&" + string2 + "(" + jSONObject2.toString() + ");");
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + string4);
                                }
                            } else if ("ipc_cmd_gamecenter_open_aio".equals(string)) {
                                int i18 = bundle2.getInt("result", -1);
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("ret", i18);
                                super.callJs(string2 + "&&" + string2 + "(" + jSONObject3.toString() + ");");
                            } else if ("ipc_cmd_gamecenter_get_unread_total".equals(string)) {
                                int i19 = bundle2.getInt("result");
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("ret", i19);
                                jSONObject4.put("newMsgCount", bundle2.getInt("cnt"));
                                super.callJs(string2 + "&&" + string2 + "(" + jSONObject4.toString() + ");");
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + jSONObject4.toString());
                                }
                            } else if ("ipc_cmd_gamecenter_toggle_changed".equals(string)) {
                                callbackOk(string2);
                            } else if ("ipc_cmd_gamecenter_open_qqplayer_aio".equals(string)) {
                                int i26 = bundle2.getInt("result", -1);
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("ret", i26);
                                super.callJs(string2 + "&&" + string2 + "(" + jSONObject5.toString() + ");");
                            } else if ("ipc_cmd_gamecenter_send_ark_from_aio".equals(string) || "ipc_cmd_gamecenter_send_ark_from_friend_chooser".equals(string)) {
                                int i27 = bundle2.getInt("result", -1);
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("ret", i27);
                                super.callJs(string2 + "&&" + string2 + "(" + jSONObject6.toString() + ");");
                            }
                            return;
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, th5.getMessage());
                            }
                            callbackError(string2, "-2000");
                            return;
                        }
                    }
                    callbackError(string2, "-1000");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        ViewGroup viewGroup = (RefreshView) this.mRuntime.a().findViewById(R.id.l2a);
        if (viewGroup == null && (customWebView.getParent() instanceof FrameLayout)) {
            viewGroup = (FrameLayout) customWebView.getParent();
        }
        c cVar = new c(this.mRuntime.a(), customWebView);
        this.mVideoContainer = cVar;
        if (viewGroup != null) {
            viewGroup.addView(cVar, layoutParams);
        }
        this.mVideoContainer.scrollBy(0, ((TouchWebView) this.mRuntime.e()).mTotalYoffset);
        this.mScrollChangedListener = new d();
        Activity a16 = this.mRuntime.a();
        if (a16 instanceof GameCenterActivity) {
            ((GameCenterActivity) a16).setOnScrollChangedListener(this.mScrollChangedListener);
        }
    }

    public int pauseVideo(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.pause();
                new JSONObject();
                return 0;
            }
            QLog.e(TAG, 1, "[pauseVideo] Err: not find videoPlayer");
            return 0;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "pauseVideo Err:" + e16.toString());
            return -1;
        }
    }

    public int playVideo(JSONObject jSONObject) {
        QLog.d(TAG, 4, "playVideo JSONObject: " + jSONObject.toString());
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.play();
                return 0;
            }
            QLog.e(TAG, 1, "[playVideo] Err: not find videoPlayer");
            return 0;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "playVideo Err:" + e16.toString());
            return -1;
        }
    }

    public void reportAction(String str, String str2, String str3) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(this.mRuntime.b(), this.uin, str, str2, 0, 1, str3, null, null, null, null);
    }

    public void reportMiniAppOpen(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appId");
            final String optString2 = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                callbackJS(optString2, -1, "parameters error");
            } else {
                ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).reportMiniAppOpen(optString, new MiniAppCmdInterface() { // from class: com.tencent.gamecenter.common.util.f
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public final void onCmdListener(boolean z16, JSONObject jSONObject2) {
                        GameCenterAPIJavaScript.this.lambda$reportMiniAppOpen$0(optString2, z16, jSONObject2);
                    }
                });
            }
        } catch (JSONException unused) {
            QLog.i(TAG, 1, "reportMiniAppOpen parsing parameters failed");
        }
    }

    public int setDanmuData(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController gameCenterVideoViewController = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a;
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    com.tencent.mobileqq.gamecenter.media.a[] aVarArr = new com.tencent.mobileqq.gamecenter.media.a[optJSONArray.length()];
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            aVarArr[i3] = new com.tencent.mobileqq.gamecenter.media.a(optJSONObject.optString("text"), optJSONObject.optDouble("onScreenTime"), optJSONObject.optDouble("screenDuration"), optJSONObject.optString("fontColor"), optJSONObject.optString("backgroundColor"));
                        }
                    }
                    gameCenterVideoViewController.getDanmakuLayout().k(aVarArr);
                }
                return 0;
            }
            QLog.e(TAG, 1, "[setDanmuData] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setDanmuData Err:" + e16.toString());
            return -1;
        }
    }

    public int setDanmuViewProperty(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController gameCenterVideoViewController = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a;
                int optInt2 = jSONObject.optInt("topDist");
                int optInt3 = jSONObject.optInt("bottomDist");
                if (!jSONObject.has("topDist")) {
                    optInt2 = gameCenterVideoViewController.getDanmakuLayout().getPaddingTop();
                }
                if (!jSONObject.has("bottomDist")) {
                    optInt3 = gameCenterVideoViewController.getDanmakuLayout().getPaddingBottom();
                }
                gameCenterVideoViewController.getDanmakuLayout().setPadding(0, optInt2, 0, optInt3);
                if (jSONObject.has("lineSpacing")) {
                    gameCenterVideoViewController.getDanmakuLayout().setLineSpacing(jSONObject.optInt("lineSpacing"));
                }
                if (jSONObject.has("fontSize")) {
                    gameCenterVideoViewController.getDanmakuLayout().setTextSize(jSONObject.optInt("fontSize"));
                }
                return 0;
            }
            QLog.e(TAG, 1, "[setDanmuViewProperty] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setDanmuViewProperty Err:" + e16.toString());
            return -1;
        }
    }

    public int setFlag(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt4 = jSONObject.optInt("width");
            int optInt5 = jSONObject.optInt("height");
            String optString = jSONObject.optString("pic");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                FrameLayout frameLayout = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106504b;
                URLImageView uRLImageView = new URLImageView(this.mContext);
                float f16 = this.mRuntime.a().getResources().getDisplayMetrics().density;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (optInt4 * f16), (int) (optInt5 * f16));
                layoutParams.topMargin = (int) (optInt2 * f16);
                layoutParams.leftMargin = (int) (optInt3 * f16);
                frameLayout.addView(uRLImageView, layoutParams);
                int hashCode = uRLImageView.hashCode();
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106505c.put(Integer.valueOf(hashCode), uRLImageView);
                uRLImageView.setImageURL(optString);
                return hashCode;
            }
            QLog.e(TAG, 1, "[setFlag] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setFlag Err:" + e16.toString());
            return -1;
        }
    }

    public int setFullScreen(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            boolean optBoolean = jSONObject.optBoolean(ReportConst.ACTION.FULLSCREEN);
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController gameCenterVideoViewController = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a;
                if (optBoolean) {
                    gameCenterVideoViewController.enterFullScreen();
                    return 0;
                }
                gameCenterVideoViewController.exitFullScreen();
                return 0;
            }
            QLog.e(TAG, 1, "[setFullScreen] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setFullScreen Err:" + e16.toString());
            return -1;
        }
    }

    public int setMute(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            boolean optBoolean = jSONObject.optBoolean("mute");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.setMute(optBoolean);
                return 0;
            }
            QLog.e(TAG, 1, "[setMute] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setMute Err:" + e16.toString());
            return -1;
        }
    }

    public int setPosition(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt4 = jSONObject.optInt("tabHeight", 0);
            int optInt5 = jSONObject.optInt("bottomHeight", 0);
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController gameCenterVideoViewController = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gameCenterVideoViewController.getLayoutParams();
                float f16 = this.mRuntime.a().getResources().getDisplayMetrics().density;
                layoutParams.topMargin = (int) ((optInt2 - optInt4) * f16);
                layoutParams.leftMargin = (int) (f16 * (optInt3 - optInt5));
                gameCenterVideoViewController.setLayoutParams(layoutParams);
            } else {
                QLog.e(TAG, 1, "[setPostion] Err: not find videoPlayer");
            }
            return 0;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setPostion Err:" + e16.toString());
            return -1;
        }
    }

    public int setText(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt4 = jSONObject.optInt("fontsize", 10);
            String optString = jSONObject.optString("color");
            String optString2 = jSONObject.optString(FileReaderHelper.TXT_EXT);
            boolean optBoolean = jSONObject.optBoolean("border", false);
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                FrameLayout frameLayout = this.mVideoViewMap.get(Integer.valueOf(optInt)).f106504b;
                TextView textView = new TextView(this.mContext);
                if (optBoolean) {
                    textView.setBackgroundResource(R.drawable.f160766n0);
                }
                float f16 = this.mRuntime.a().getResources().getDisplayMetrics().density;
                textView.setPadding(BaseAIOUtils.f(3.0f, this.mContext.getResources()), BaseAIOUtils.f(3.0f, this.mContext.getResources()), BaseAIOUtils.f(3.0f, this.mContext.getResources()), BaseAIOUtils.f(3.0f, this.mContext.getResources()));
                textView.setText(optString2);
                textView.setTextSize(optInt4);
                textView.setTextColor(Color.parseColor(optString));
                int hashCode = textView.hashCode();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = (int) (optInt2 * f16);
                layoutParams.leftMargin = (int) (optInt3 * f16);
                frameLayout.addView(textView, layoutParams);
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106505c.put(Integer.valueOf(hashCode), textView);
                return hashCode;
            }
            QLog.e(TAG, 1, "[setText] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setText Err:" + e16.toString());
            return -1;
        }
    }

    public void setTitleLoading(String str) {
        boolean z16;
        if (this.mContext instanceof GameCenterActivity) {
            try {
                if ("true".equals(str)) {
                    z16 = true;
                } else if ("false".equals(str)) {
                    z16 = false;
                } else {
                    return;
                }
                if (z16) {
                    ((GameCenterActivity) this.mContext).gcHandler.sendEmptyMessage(2003);
                } else {
                    ((GameCenterActivity) this.mContext).gcHandler.sendEmptyMessage(2004);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public int setVideoSpeedRatio(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            float optDouble = (float) jSONObject.optDouble("speedRatio", 1.0d);
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.setSpeedRatio(optDouble);
                return 0;
            }
            QLog.e(TAG, 1, "[setMute] Err: not find videoPlayer");
            return -1;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setSpeedRatio Err:" + e16.toString());
            return -1;
        }
    }

    public void showWarningToast(String str) {
        Context context = this.mContext;
        if (context instanceof GameCenterActivity) {
            try {
                Message obtain = Message.obtain(((GameCenterActivity) context).gcHandler);
                obtain.what = 2006;
                obtain.obj = str;
                ((GameCenterActivity) this.mContext).gcHandler.sendMessage(obtain);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void startActivityForResult(Intent intent, byte b16) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        if (bVar.d(bVar.a()) == null && this.mRuntime.e() != null) {
            Object webUiBaseInterface = ((IQQKuiklyWebView) QRoute.api(IQQKuiklyWebView.class)).getWebUiBaseInterface(this.mRuntime.e().getParent());
            if (webUiBaseInterface instanceof y) {
                this.mRuntime.h((y) webUiBaseInterface);
            }
        }
        super.startActivityForResult(intent, b16);
    }

    public void startToAuthorized(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("uin", this.uin);
            str = jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        MyAppApi.z().o0(str, null, (Activity) this.mContext);
    }

    public int stopVideo(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("id");
            if (this.mVideoViewMap.get(Integer.valueOf(optInt)) != null) {
                this.mVideoViewMap.get(Integer.valueOf(optInt)).f106503a.stop();
                return 0;
            }
            QLog.e(TAG, 1, "[stopVideo] Err: not find videoPlayer");
            return 0;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "stopVideo Err:" + e16.toString());
            return -1;
        }
    }
}
