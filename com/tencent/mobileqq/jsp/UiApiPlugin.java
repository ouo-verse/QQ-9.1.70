package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ark.ark;
import com.tencent.av.utils.ba;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.webviewplugin.z;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.cw;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.feed.api.IFeedStandardDialogApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.api.IQQGiftUtil;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.widget.k;
import com.tencent.mobileqq.troopmanage.activity.TroopSetJoinTypeActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.ec;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.d;
import com.tencent.mobileqq.webview.nightmask.NightMaskConfProcessor;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.base.MD5Utils;
import com.tencent.protofile.getopenid.GetOpenidProto$GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto$GetOpenidReq;
import com.tencent.protofile.getopenid.GetOpenidProto$GetOpenidResp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.webview.HalfTranslucentBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.LiuHaiUtils;
import com.tencent.webbundle.sdk.WebBundleConstants;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzoneJumpQBrowserInterface;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import okhttp3.HttpUrl;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes15.dex */
public class UiApiPlugin extends WebViewPlugin implements View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, ActionSheet.WatchDismissActions, DialogInterface.OnCancelListener {
    static IPatchRedirector $redirector_;
    public static AtomicLong A0;
    public static ResultReceiver B0;

    /* renamed from: q0, reason: collision with root package name */
    static AtomicInteger f238697q0;

    /* renamed from: r0, reason: collision with root package name */
    public static volatile BroadcastReceiver f238698r0;

    /* renamed from: s0, reason: collision with root package name */
    public static AtomicBoolean f238699s0;

    /* renamed from: t0, reason: collision with root package name */
    public static CopyOnWriteArrayList<WeakReference<UiApiPlugin>> f238700t0;

    /* renamed from: u0, reason: collision with root package name */
    public static volatile BroadcastReceiver f238701u0;

    /* renamed from: v0, reason: collision with root package name */
    public static AtomicBoolean f238702v0;

    /* renamed from: w0, reason: collision with root package name */
    public static AtomicBoolean f238703w0;

    /* renamed from: x0, reason: collision with root package name */
    public static volatile BroadcastReceiver f238704x0;

    /* renamed from: y0, reason: collision with root package name */
    private static volatile byte f238705y0;

    /* renamed from: z0, reason: collision with root package name */
    private static Handler f238706z0;
    public String C;
    protected String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public boolean K;
    public ImageView L;
    public ImageView M;
    public String N;
    public boolean P;
    public String Q;
    com.tencent.biz.troop.b R;
    public ProgressDialog S;
    protected QQCustomDialog T;
    PopupMenuDialog U;
    int V;
    public boolean W;
    protected ProgressDialog X;
    public com.tencent.mobileqq.emosm.t Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f238707a0;

    /* renamed from: b0, reason: collision with root package name */
    public com.tencent.mobileqq.widget.p f238708b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f238709c0;

    /* renamed from: d, reason: collision with root package name */
    public String f238710d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f238711d0;

    /* renamed from: e, reason: collision with root package name */
    public ActionSheet f238712e;

    /* renamed from: e0, reason: collision with root package name */
    public View f238713e0;

    /* renamed from: f, reason: collision with root package name */
    public String f238714f;

    /* renamed from: f0, reason: collision with root package name */
    public RefreshView f238715f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f238716g0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f238717h;

    /* renamed from: h0, reason: collision with root package name */
    public View f238718h0;

    /* renamed from: i, reason: collision with root package name */
    public int f238719i;

    /* renamed from: i0, reason: collision with root package name */
    public AtomicBoolean f238720i0;

    /* renamed from: j0, reason: collision with root package name */
    WeakReference<UiApiPlugin> f238721j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f238722k0;

    /* renamed from: l0, reason: collision with root package name */
    MiniMsgUser f238723l0;

    /* renamed from: m, reason: collision with root package name */
    public String f238724m;

    /* renamed from: m0, reason: collision with root package name */
    public ImageView f238725m0;

    /* renamed from: n0, reason: collision with root package name */
    public ImageView f238726n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f238727o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f238728p0;

    /* renamed from: com.tencent.mobileqq.jsp.UiApiPlugin$9, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass9 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f238747d;

        AnonymousClass9(JSONObject jSONObject) {
            this.f238747d = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) jSONObject);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            UiApiPlugin.this.H = this.f238747d.optString("callback");
            ScreenShotUtil.e(UiApiPlugin.this.mRuntime.e(), new ScreenShotUtil.f() { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.9.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                    }
                }

                @Override // com.tencent.mobileqq.util.ScreenShotUtil.f
                public void a(Bitmap bitmap) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bitmap);
                    } else {
                        ThreadManagerV2.post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.9.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Bitmap f238749d;

                            {
                                this.f238749d = bitmap;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                String optString = AnonymousClass9.this.f238747d.optString("briefMsg");
                                String optString2 = AnonymousClass9.this.f238747d.optString("appName");
                                String optString3 = AnonymousClass9.this.f238747d.optString("iconUrl");
                                String optString4 = AnonymousClass9.this.f238747d.optString("actionUrl");
                                if (this.f238749d != null) {
                                    String c16 = ScreenShotUtil.c(this.f238749d, new File(BaseApplicationImpl.getApplication().getCacheDir(), "ShareScreenShots"), "ShareScreenShot_" + System.currentTimeMillis() + ".jpg");
                                    Intent intent = new Intent(UiApiPlugin.this.mRuntime.a(), (Class<?>) ForwardRecentActivity.class);
                                    intent.putExtra("key_flag_from_plugin", true);
                                    intent.putExtra("image_url", c16);
                                    intent.putExtra("forward_type", -3);
                                    intent.putExtra("pkg_name", "com.tencent.mobileqq");
                                    intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 5);
                                    intent.putExtra("k_back", true);
                                    intent.putExtra(AppConstants.Key.SHARE_BRIEF, optString);
                                    intent.putExtra("app_name", optString2);
                                    if (!TextUtils.isEmpty(optString3)) {
                                        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, optString3);
                                    }
                                    intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
                                    intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, optString4);
                                    intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, com.tencent.mobileqq.structmsg.i.e(intent.getExtras()).getBytes());
                                    UiApiPlugin.this.startActivityForResult(intent, RegisterType.DOUBLE_HI);
                                }
                            }
                        }, 8, null, true);
                    }
                }
            });
        }
    }

    /* loaded from: classes15.dex */
    class a implements k.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238751a;

        a(String str) {
            this.f238751a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.troop.widget.k.d
        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                UiApiPlugin.this.callJs(this.f238751a, String.valueOf(j3));
            }
        }
    }

    /* loaded from: classes15.dex */
    class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f238753d;

        b(Activity activity) {
            this.f238753d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] byteArray;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "onReceive get_openid:" + z16);
            }
            if (this.f238753d.isFinishing()) {
                return;
            }
            if (z16 && (byteArray = bundle.getByteArray("data")) != null) {
                GetOpenidProto$GetOpenidResp getOpenidProto$GetOpenidResp = new GetOpenidProto$GetOpenidResp();
                try {
                    getOpenidProto$GetOpenidResp.mergeFrom(byteArray);
                    if (getOpenidProto$GetOpenidResp.retcode.get() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "get_openid retcode:" + getOpenidProto$GetOpenidResp.retcode.get());
                        }
                        this.f238753d.setResult(-1, new Intent().putExtra("ret", 2).putExtra("errMsg", "server error, unexpected retcode"));
                        this.f238753d.finish();
                        return;
                    }
                    int size = getOpenidProto$GetOpenidResp.list.size();
                    String[] strArr = new String[size];
                    int[] iArr = new int[size];
                    for (int i17 = 0; i17 < size; i17++) {
                        GetOpenidProto$GetOpenidEntry getOpenidProto$GetOpenidEntry = getOpenidProto$GetOpenidResp.list.get(i17);
                        strArr[i17] = getOpenidProto$GetOpenidEntry.openid.get();
                        int i18 = getOpenidProto$GetOpenidEntry.type.get();
                        if (i18 == 0) {
                            i16 = 1;
                        } else if (i18 == 1) {
                            i16 = 4;
                        } else if (i18 == 2) {
                            i16 = 8;
                        } else {
                            i16 = 0;
                        }
                        iArr[i17] = i16;
                    }
                    this.f238753d.setResult(-1, new Intent().putExtra("ret", 0).putExtra(GetCMShowInfoServlet.EXTRA_OPENID, strArr).putExtra("types", iArr));
                    this.f238753d.finish();
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    this.f238753d.setResult(-1, new Intent().putExtra("ret", 2).putExtra("errMsg", "server error, unexpected pbdata"));
                    this.f238753d.finish();
                    return;
                }
            }
            this.f238753d.setResult(-1, new Intent().putExtra("ret", 2));
            this.f238753d.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements RefreshView.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this);
            }
        }

        @Override // com.tencent.biz.ui.RefreshView.d
        public void onRefresh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                UiApiPlugin.this.dispatchJsEvent("qbrowserPullDown", null, null);
                UiApiPlugin.this.f238716g0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238755d;

        d(String str) {
            this.f238755d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!TextUtils.isEmpty(this.f238755d)) {
                UiApiPlugin.this.callJs(this.f238755d, "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f238757d;

        e(JSONObject jSONObject) {
            this.f238757d = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) jSONObject);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                UiApiPlugin.this.E0(this.f238757d);
                String optString = this.f238757d.optString("callback");
                if (!TextUtils.isEmpty(optString)) {
                    UiApiPlugin.this.callJs(optString, String.valueOf(0));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class f implements PopupMenuDialog.OnClickActionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f238759a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f238760b;

        f(JSONObject jSONObject, Activity activity) {
            this.f238759a = jSONObject;
            this.f238760b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, jSONObject, activity);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
        @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClickAction(PopupMenuDialog.MenuItem menuItem) {
            int i3;
            String optString;
            JSONArray optJSONArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) menuItem);
                return;
            }
            int i16 = menuItem.f384641id - 1;
            String str = null;
            try {
                optString = this.f238759a.optString("callback");
                optJSONArray = this.f238759a.optJSONArray("list");
            } catch (Exception e16) {
                e = e16;
                i3 = 0;
            }
            if (optJSONArray != null && i16 < optJSONArray.length()) {
                if (!TextUtils.isEmpty(optString)) {
                    UiApiPlugin.this.callJs(optString, String.valueOf(i16 + 1));
                    return;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                i3 = optJSONObject.optInt("target");
                try {
                    str = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + e.getMessage());
                    }
                    if (i3 == 0) {
                    }
                }
                if (i3 == 0) {
                    if (i3 == 1) {
                        Bundle bundle = new Bundle();
                        if (this.f238760b instanceof BasePluginActivity) {
                            Intent intent = new Intent(((BasePluginActivity) this.f238760b).getOutActivity(), (Class<?>) QQBrowserActivity.class);
                            intent.putExtras(bundle);
                            intent.putExtra("url", str);
                            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                            intent.setFlags(0);
                            this.f238760b.startActivity(intent);
                            return;
                        }
                        Activity activity = this.f238760b;
                        Intent intent2 = new Intent(activity, activity.getClass());
                        intent2.putExtras(bundle);
                        intent2.putExtra("url", str);
                        intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                        intent2.setFlags(0);
                        this.f238760b.startActivity(intent2);
                        return;
                    }
                    return;
                }
                UiApiPlugin.this.mRuntime.e().loadUrl(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class g implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f238762d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f238763e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f238764f;

        g(View view, int i3, int i16) {
            this.f238762d = view;
            this.f238763e = i3;
            this.f238764f = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            this.f238762d.clearAnimation();
            View view = this.f238762d;
            view.layout(view.getLeft(), this.f238763e, this.f238762d.getRight(), this.f238764f);
            this.f238762d.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class h implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f238766d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f238767e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f238768f;

        h(View view, int i3, int i16) {
            this.f238766d = view;
            this.f238767e = i3;
            this.f238768f = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            this.f238766d.clearAnimation();
            View view = this.f238766d;
            view.layout(view.getLeft(), this.f238767e, this.f238766d.getRight(), this.f238768f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* loaded from: classes15.dex */
    class i extends com.tencent.mobileqq.emosm.t {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:71:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01d5  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01e0  */
        @Override // com.tencent.mobileqq.emosm.t
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Bundle bundle) {
            int i3;
            Intent intent;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            if (bundle != null && bundle.getInt("respkey", 0) == UiApiPlugin.this.Y.key) {
                String string = bundle.getString("cmd");
                String string2 = bundle.getString("callbackid");
                Bundle bundle2 = bundle.getBundle("response");
                Bundle bundle3 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                if (bundle3 == null) {
                    QLog.e("UiApiPlugin", 1, "reqBundle is null, cmd is : " + string);
                    return;
                }
                String string3 = bundle3.getString("uin");
                String string4 = bundle3.getString("action");
                int[] iArr = {1, 41, 75, 21, 58};
                WebViewPlugin.b bVar = UiApiPlugin.this.mRuntime;
                if (bVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "mRuntime == null");
                        return;
                    }
                    return;
                }
                Context a16 = bVar.a();
                if ("checkRelation".equals(string) && a16 != null && string3 != null) {
                    String str = "{\"result\": 0}";
                    if ("openSocialCard".equals(string4)) {
                        int i16 = bundle3.getInt("source");
                        String string5 = bundle3.getString("sign");
                        int i17 = bundle3.getInt("nProfileEntryType");
                        if (i17 == 0) {
                            i17 = 999;
                        }
                        AppInterface b16 = UiApiPlugin.this.mRuntime.b();
                        if (bundle2.getBoolean("result", false) && b16 != null && !b16.getCurrentAccountUin().equals(string3)) {
                            AllInOne allInOne = new AllInOne(string3, iArr[i16]);
                            allInOne.profileEntryType = i17;
                            intent = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(a16, allInOne);
                            z16 = false;
                        } else {
                            AllInOne allInOne2 = new AllInOne(string3, iArr[i16]);
                            if (!TextUtils.isEmpty(string5)) {
                                allInOne2.chatCookie = ChatActivityUtils.H(string5);
                            }
                            allInOne2.profileEntryType = i17;
                            intent = new Intent();
                            intent.putExtra("param_mode", 3);
                            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne2);
                            z16 = true;
                        }
                        if (z16) {
                            RouteUtils.startActivity(BaseApplication.getContext(), intent, "/nearby/people/profile");
                        } else {
                            a16.startActivity(intent);
                        }
                    } else if ("openStrangerAIO".equals(string4)) {
                        if (bundle2.getBoolean("result", false)) {
                            Intent intent2 = new Intent(a16, (Class<?>) ChatActivity.class);
                            intent2.putExtra("uin", string3);
                            intent2.putExtra("uintype", 0);
                            a16.startActivity(intent2);
                        } else {
                            int i18 = bundle3.getInt("sourceType");
                            String string6 = bundle3.getString("sign");
                            boolean z17 = bundle3.getBoolean("isGroup");
                            String string7 = bundle3.getString("strangerchat_ext");
                            Intent intent3 = new Intent();
                            intent3.putExtra("uin", string3);
                            if (!TextUtils.isEmpty(string7)) {
                                intent3.putExtra("strangerchat_ext", string7);
                            }
                            if (!z17 && TextUtils.isEmpty(string6) && i18 != 6) {
                                str = "{\"result\": -2, \"message\":\"Can't send message to a stranger without sign!\"}";
                            } else {
                                if (z17) {
                                    intent3.putExtra("open_chatfragment", true);
                                    intent3.setComponent(SplashActivity.getAliasComponent(a16));
                                } else {
                                    intent3.setClass(a16, ChatActivity.class);
                                    if (i18 != 0) {
                                        if (i18 != 1) {
                                            if (i18 != 2) {
                                                if (i18 != 3) {
                                                    if (i18 != 4) {
                                                        if (i18 != 6) {
                                                            if (i18 == 8) {
                                                                i3 = 10004;
                                                            }
                                                        } else {
                                                            i3 = 10002;
                                                        }
                                                    } else {
                                                        i3 = 1020;
                                                    }
                                                }
                                            } else {
                                                i3 = 1010;
                                            }
                                        }
                                        i3 = 1001;
                                    } else {
                                        i3 = 0;
                                    }
                                    if (bundle3.getInt(EmotionConstants.FROM_AIO) >= 1) {
                                        intent3.addFlags(67108864);
                                    }
                                    intent3.putExtra("uintype", i3);
                                    if (i3 != 1001) {
                                        intent3.putExtra(AppConstants.Key.KYE_RICH_ACCOST_SIG, ChatActivityUtils.H(string6));
                                    } else if (i3 == 1010) {
                                        intent3.putExtra(AppConstants.Key.KYE_RICH_DATE_SIG, ChatActivityUtils.H(string6));
                                    } else if (i3 == 10004) {
                                        intent3.putExtra(AppConstants.Key.KYE_RICH_MOVIE_SIG, ChatActivityUtils.H(string6));
                                    }
                                    a16.startActivity(intent3);
                                }
                                i3 = 1;
                                if (bundle3.getInt(EmotionConstants.FROM_AIO) >= 1) {
                                }
                                intent3.putExtra("uintype", i3);
                                if (i3 != 1001) {
                                }
                                a16.startActivity(intent3);
                            }
                        }
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(string2) && str != null) {
                        UiApiPlugin.this.callJs(string2, str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class j extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238771a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f238772b;

        j(String str, JSONObject jSONObject) {
            this.f238771a = str;
            this.f238772b = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, str, jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            Activity a16 = UiApiPlugin.this.mRuntime.a();
            if (a16 != null && !a16.isFinishing()) {
                if (gVar.f313006d == 0) {
                    String filePath = AbsDownloader.getFilePath(this.f238771a);
                    if (new File(filePath).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.f238771a);
                        }
                        UiApiPlugin.this.c0(this.f238772b, filePath, 0);
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile failed: " + this.f238771a);
                }
                UiApiPlugin.this.c0(this.f238772b, null, -2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class k implements SearchUtils.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238774a;

        k(String str) {
            this.f238774a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.search.util.SearchUtils.a
        public void a(String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (str == null) {
                UiApiPlugin.this.callJs(this.f238774a, "{\"code\":-4}");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                byte[] readFile = FileUtils.readFile(str);
                if (readFile != null) {
                    jSONObject.put("code", 0);
                    StringBuilder sb5 = new StringBuilder("data:");
                    if (BaseImageUtil.isGifFile(str)) {
                        str2 = "image/gif;";
                    } else {
                        str2 = "image/jpg;";
                    }
                    sb5.append(str2);
                    sb5.append("base64,");
                    sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(readFile, 0));
                    jSONObject.put("imgData", sb5);
                    jSONObject.put("md5", MD5.toMD5(readFile));
                    jSONObject.put("imagePath", str);
                    UiApiPlugin.this.callJs(this.f238774a, jSONObject.toString());
                } else {
                    UiApiPlugin.this.callJs(this.f238774a, "{\"code\":-3}");
                }
            } catch (Exception unused) {
                UiApiPlugin.this.callJs(this.f238774a, "{\"code\":-3}");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class l implements IMiniMsgUnreadCallback {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void hide() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void hideUnread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("unReadHide", true);
                UiApiPlugin.this.w("UnRead", jSONObject);
            } catch (Exception e16) {
                QLog.d("UiApiPlugin", 1, e16, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public boolean show(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void updateOnBackFromMiniAIO(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
                return;
            }
            try {
                UiApiPlugin.this.w("backFromMiniAIO", new JSONObject());
            } catch (Exception e16) {
                QLog.d("UiApiPlugin", 1, e16, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
        public void updateUnreadCount(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("unReadC", i3);
                jSONObject.put("unReadHide", z16);
                UiApiPlugin.this.w("updateUnreadCount", jSONObject);
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin undateUnreadCount = " + i3);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class m implements MiniMsgUser.IMiniMsgActionCallback {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
        public void onFromMiniAIOToAIO() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "onFromMiniAIOToAIO ");
            }
            UiApiPlugin.this.w("fromMiniAIOToAIO", new JSONObject());
        }

        @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
        public void onGoToConversation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "onGoToConversation ");
                }
                UiApiPlugin.this.w("returnMsgList", new JSONObject());
            } catch (Exception e16) {
                QLog.d("UiApiPlugin", 1, e16, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
        public void onOpenMiniAIOCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WebViewProvider f16 = UiApiPlugin.this.mRuntime.f();
            String g16 = ((com.tencent.mobileqq.webview.swift.component.z) f16.getComponentProvider().a(256)).g();
            if (TextUtils.isEmpty(g16)) {
                g16 = f16.getWebView().getTitle();
            }
            if (TextUtils.isEmpty(g16) || "\u200e".equals(g16)) {
                g16 = HardCodeUtil.qqStr(R.string.usp);
            }
            Bundle bundle = new Bundle();
            bundle.putString("banner_wording", g16);
            MiniMsgUserParam param = UiApiPlugin.this.f238723l0.getParam();
            Intent b16 = com.tencent.mobileqq.webview.swift.utils.s.b(bundle, f16);
            param.backConversationIntent = b16;
            com.tencent.mobileqq.webview.swift.utils.s.a(b16);
            try {
                UiApiPlugin.this.w("entryClicked", new JSONObject());
            } catch (Exception e16) {
                QLog.d("UiApiPlugin", 1, e16, new Object[0]);
            }
        }
    }

    /* loaded from: classes15.dex */
    class n implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238778d;

        n(String str) {
            this.f238778d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 0) {
                if (!TextUtils.isEmpty(this.f238778d)) {
                    UiApiPlugin.this.callJs(this.f238778d + "({button: 1})");
                    return;
                }
                UiApiPlugin.this.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 1})");
                return;
            }
            if (i3 == 1) {
                if (!TextUtils.isEmpty(this.f238778d)) {
                    UiApiPlugin.this.callJs(this.f238778d + "({button: 0})");
                    return;
                }
                UiApiPlugin.this.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 0})");
            }
        }
    }

    /* loaded from: classes15.dex */
    class o implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238780d;

        o(String str) {
            this.f238780d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            UiApiPlugin.this.callJs(this.f238780d + "({button: -1})");
        }
    }

    /* loaded from: classes15.dex */
    class p implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238782d;

        p(String str) {
            this.f238782d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            QLog.i("UiApiPlugin", 1, "dialog dismiss");
            if (!TextUtils.isEmpty(this.f238782d)) {
                UiApiPlugin.this.callJs(this.f238782d + "({})");
            }
        }
    }

    /* loaded from: classes15.dex */
    class q implements ITroopMemberApiClientApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238784d;

        q(String str) {
            this.f238784d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            if (bundle != null) {
                if (bundle.getBoolean("isSuccess")) {
                    Intent intent = new Intent();
                    intent.putExtra("troop_uin", this.f238784d);
                    int i3 = 12;
                    if (UiApiPlugin.this.mRuntime.f() != null) {
                        i3 = UiApiPlugin.this.mRuntime.f().switchRequestCode(UiApiPlugin.this, (byte) 12);
                    }
                    if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106087", true)) {
                        QPublicFragmentActivity.startForResult(UiApiPlugin.this.mRuntime.a(), intent, (Class<? extends QPublicBaseFragment>) TroopJoinTypeFragment.class, i3);
                        return;
                    } else {
                        QPublicFragmentActivity.startForResult(UiApiPlugin.this.mRuntime.a(), intent, (Class<? extends QPublicBaseFragment>) TroopSetJoinTypeActivity.class, i3);
                        return;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("gc", this.f238784d);
                    jSONObject.put("ret", 1);
                    UiApiPlugin uiApiPlugin = UiApiPlugin.this;
                    uiApiPlugin.callJs(uiApiPlugin.Q, jSONObject.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    class r implements BusinessObserver {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16) {
                byte[] byteArray = bundle.getByteArray("data");
                bundle.getString("openId");
                if (byteArray != null) {
                    try {
                        oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(byteArray);
                        int i16 = mergeFrom.uint32_result.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x716_48Rsp, resultCode:" + i16);
                        }
                        byte[] byteArray2 = mergeFrom.bytes_bodybuffer.get().toByteArray();
                        if (i16 == 0) {
                            byte[] bArr = new byte[4];
                            System.arraycopy(byteArray2, 0, bArr, 0, 4);
                            TroopUtils.I(UiApiPlugin.this.getCurrentContext(), aq.d(String.valueOf(ByteBuffer.wrap(bArr).getInt() + ""), "", 32), -1);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + e16.toString());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    class s implements ITroopMemberApiClientApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Integer f238787d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f238788e;

        s(Integer num, String str) {
            this.f238787d = num;
            this.f238788e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, num, str);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            AllInOne allInOne;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            if (bundle.getBoolean("isSuccess", false)) {
                int i3 = bundle.getInt("appid");
                String string = bundle.getString("openId");
                if (i3 == this.f238787d.intValue() && string.equals(this.f238788e)) {
                    String string2 = bundle.getString("uin");
                    boolean z16 = bundle.getBoolean(IProfileProtocolConst.PARAM_IS_FRIEND, false);
                    String string3 = bundle.getString("nickName");
                    String string4 = bundle.getString("remark");
                    if (!TextUtils.isEmpty(string2)) {
                        if (z16) {
                            allInOne = new AllInOne(string2, 1);
                            allInOne.nickname = string3;
                            allInOne.remark = string4;
                        } else {
                            allInOne = new AllInOne(string2, 105);
                        }
                        Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(UiApiPlugin.this.getCurrentContext(), allInOne);
                        profileCardIntentOnly.addFlags(536870912);
                        UiApiPlugin.this.getCurrentContext().startActivity(profileCardIntentOnly);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    class t implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Integer f238790d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f238791e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f238792f;

        /* loaded from: classes15.dex */
        class a implements ITroopMemberApiClientApi.a {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f238794d;

            a(String str) {
                this.f238794d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this, (Object) str);
                }
            }

            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public void callback(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                    return;
                }
                if (bundle.getBoolean("isSuccess", false)) {
                    int i3 = bundle.getInt("appid");
                    String string = bundle.getString("openId");
                    if (i3 == t.this.f238790d.intValue() && string.equals(t.this.f238791e)) {
                        String string2 = bundle.getString("uin");
                        if (!TextUtils.isEmpty(string2)) {
                            Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(UiApiPlugin.this.getCurrentContext(), null);
                            profileCardIntentOnly.putExtra("troopUin", this.f238794d);
                            profileCardIntentOnly.putExtra("memberUin", string2);
                            UiApiPlugin.this.getCurrentContext().startActivity(profileCardIntentOnly);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
                    }
                }
            }
        }

        t(Integer num, String str, String str2) {
            this.f238790d = num;
            this.f238791e = str;
            this.f238792f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, num, str, str2);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] byteArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16 && (byteArray = bundle.getByteArray("data")) != null) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(byteArray);
                    int i16 = mergeFrom.uint32_result.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x716_48Rsp, resultCode:" + i16);
                    }
                    byte[] byteArray2 = mergeFrom.bytes_bodybuffer.get().toByteArray();
                    if (i16 == 0) {
                        byte[] bArr = new byte[4];
                        System.arraycopy(byteArray2, 0, bArr, 0, 4);
                        String str = ByteBuffer.wrap(bArr).getInt() + "";
                        UiApiPlugin uiApiPlugin = UiApiPlugin.this;
                        if (uiApiPlugin.R == null) {
                            uiApiPlugin.R = com.tencent.biz.troop.b.A();
                            UiApiPlugin.this.R.p();
                        }
                        UiApiPlugin.this.R.L(this.f238790d, this.f238791e, this.f238792f, new a(str));
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + e16.toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class u extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            Iterator<WeakReference<UiApiPlugin>> it = UiApiPlugin.f238700t0.iterator();
            while (it.hasNext()) {
                UiApiPlugin uiApiPlugin = it.next().get();
                if (uiApiPlugin != null) {
                    uiApiPlugin.d0(context, intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class v extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            Iterator<WeakReference<UiApiPlugin>> it = UiApiPlugin.f238700t0.iterator();
            while (it.hasNext()) {
                UiApiPlugin uiApiPlugin = it.next().get();
                if (uiApiPlugin != null) {
                    uiApiPlugin.e0(context, intent);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
            return;
        }
        f238697q0 = new AtomicInteger(0);
        f238698r0 = null;
        f238699s0 = new AtomicBoolean(false);
        f238700t0 = new CopyOnWriteArrayList<>();
        f238701u0 = null;
        f238702v0 = new AtomicBoolean(false);
        f238703w0 = new AtomicBoolean(false);
        f238704x0 = null;
        f238705y0 = (byte) -1;
        A0 = new AtomicLong(-1L);
    }

    public UiApiPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f238717h = false;
        this.f238719i = 0;
        this.D = null;
        this.K = false;
        this.L = null;
        this.M = null;
        this.R = null;
        this.T = null;
        this.U = null;
        this.W = false;
        this.X = null;
        this.Y = new i();
        this.Z = false;
        this.f238707a0 = false;
        this.f238709c0 = -1;
        this.f238711d0 = false;
        this.f238720i0 = new AtomicBoolean(false);
        this.f238721j0 = null;
        this.f238722k0 = false;
    }

    private static void A(final BroadcastReceiver broadcastReceiver, final IntentFilter intentFilter) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.jsp.ah
            @Override // java.lang.Runnable
            public final void run() {
                UiApiPlugin.V(broadcastReceiver, intentFilter);
            }
        };
        if (D()) {
            f238706z0.post(runnable);
        } else {
            runnable.run();
        }
    }

    private static void B(final BroadcastReceiver broadcastReceiver, final IntentFilter intentFilter, final String str, final Handler handler) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.jsp.ag
            @Override // java.lang.Runnable
            public final void run() {
                UiApiPlugin.W(broadcastReceiver, intentFilter, str, handler);
            }
        };
        if (D()) {
            f238706z0.post(runnable);
        } else {
            runnable.run();
        }
    }

    private static void C(final BroadcastReceiver broadcastReceiver) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.jsp.ae
            @Override // java.lang.Runnable
            public final void run() {
                UiApiPlugin.X(broadcastReceiver);
            }
        };
        if (D()) {
            f238706z0.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void C0(Activity activity, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("text");
                    boolean optBoolean = jSONObject.optBoolean("needOkBtn", true);
                    boolean optBoolean2 = jSONObject.optBoolean("needCancelBtn", true);
                    String optString3 = jSONObject.optString("okBtnText");
                    String optString4 = jSONObject.optString("cancelBtnText");
                    String optString5 = jSONObject.optString("callback");
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0);
                    createCustomDialog.setTitle(optString);
                    createCustomDialog.setMessage(optString2);
                    ViewGroup.LayoutParams layoutParams = createCustomDialog.getMessageTextView().getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dip2px(12.0f);
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dip2px(12.0f);
                        createCustomDialog.getMessageTextView().setLayoutParams(layoutParams);
                    }
                    if (optBoolean2) {
                        if (TextUtils.isEmpty(optString4)) {
                            optString4 = activity.getString(R.string.cancel);
                        }
                        createCustomDialog.setNegativeButton(optString4, onClickListener);
                    }
                    if (optBoolean) {
                        if (TextUtils.isEmpty(optString3)) {
                            optString3 = activity.getString(R.string.f171151ok);
                        }
                        createCustomDialog.setPositiveButton(optString3, onClickListener2);
                    }
                    if (!TextUtils.isEmpty(optString5)) {
                        createCustomDialog.setOnCancelListener(onCancelListener);
                    }
                    try {
                        createCustomDialog.show();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private static boolean D() {
        int i3;
        boolean z16;
        if (f238705y0 < 0) {
            synchronized (UiApiPlugin.class) {
                if (f238705y0 < 0) {
                    if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("wv_async_receiver_switch", true)) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    f238705y0 = (byte) i3;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ensuresAsyncReceiverOn: ");
                    if (f238705y0 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.d("UiApiPlugin", 1, sb5.toString());
                    if (f238705y0 == 1) {
                        f238706z0 = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
                    }
                }
            }
        }
        if (f238705y0 != 1) {
            return false;
        }
        return true;
    }

    private static void D0(Activity activity) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.20
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f238739d;

            /* renamed from: com.tencent.mobileqq.jsp.UiApiPlugin$20$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass20.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    dialogInterface.dismiss();
                    QLog.w("UiApiPlugin", 1, "showPermissionNormalDialog.gotoSetting");
                    ba.openPermissionActivity(AnonymousClass20.this.f238739d);
                }
            }

            /* renamed from: com.tencent.mobileqq.jsp.UiApiPlugin$20$b */
            /* loaded from: classes15.dex */
            class b implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass20.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        QLog.w("UiApiPlugin", 1, "showPermissionNormalDialog.Cancel");
                    }
                }
            }

            {
                this.f238739d = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.f238739d, 230).setTitle("\u65e0\u6cd5\u6dfb\u52a0\u5feb\u6377\u65b9\u5f0f").setNegativeButton(R.string.cancel, new b());
                if (ba.gotoSetting(this.f238739d)) {
                    str = "\u7acb\u5373\u8bbe\u7f6e";
                } else {
                    str = "\u67e5\u770b\u5982\u4f55\u6253\u5f00";
                }
                negativeButton.setPositiveButton(str, new a()).show();
            }
        });
    }

    public static String F(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", str);
            if (str2 != null) {
                jSONObject.put("resultData", str2);
            }
            if (str3 != null) {
                jSONObject.put("message", str3);
            }
            if (str4 != null) {
                jSONObject.put("extras", str4);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "getCallBackResult json error!");
            }
            return "{\"result\":\"-1\",\"message\":\"getCallBackResult json error!\"}";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r0 != 6) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void F0(Context context, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.i("UiApiPlugin", 2, "showTips param:" + str);
        }
        if (context == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("text");
            int optInt = jSONObject.optInt("type");
            int i3 = 1;
            if (optInt != 0) {
                if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                    Toast create = QQToast.makeText(context, 0, optString, 0).create(0);
                    create.setGravity(23, 0, 0);
                    create.show();
                }
            } else {
                int optInt2 = jSONObject.optInt("iconMode", 1);
                if (!TextUtils.isEmpty(optString)) {
                    if (optInt2 != 0) {
                        if (optInt2 != 1) {
                            if (optInt2 != 2) {
                                i3 = 6;
                                if (optInt2 != 3) {
                                }
                            }
                            QQToast.makeText(context, i3, optString, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                        i3 = 2;
                        QQToast.makeText(context, i3, optString, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                    i3 = 0;
                    QQToast.makeText(context, i3, optString, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "showTips error:" + e16);
            }
        }
    }

    private int G(int i3) {
        if (i3 != 6) {
            if (i3 != 13) {
                return -1;
            }
            return R.drawable.skin_tips_dot;
        }
        return R.drawable.e2o;
    }

    public static void G0() {
        if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, "unRegisterReceiver");
        }
        f238700t0.clear();
        if (f238698r0 != null && f238699s0.compareAndSet(true, false)) {
            C(f238698r0);
        }
        f238698r0 = null;
        if (f238704x0 != null && f238703w0.compareAndSet(true, false)) {
            C(f238704x0);
        }
        f238704x0 = null;
        if (f238701u0 != null && f238702v0.compareAndSet(true, false)) {
            C(f238701u0);
        }
        f238701u0 = null;
    }

    private MiniMsgUser.IMiniMsgActionCallback H() {
        return new m();
    }

    private IMiniMsgUnreadCallback I() {
        return new l();
    }

    public static void J(Activity activity, AppInterface appInterface, long j3, String[] strArr, int[] iArr) {
        int length = strArr.length;
        if (length != 0 && length == iArr.length && j3 != -1) {
            GetOpenidProto$GetOpenidReq getOpenidProto$GetOpenidReq = new GetOpenidProto$GetOpenidReq();
            getOpenidProto$GetOpenidReq.appid.set(j3);
            for (int i3 = 0; i3 < length; i3++) {
                GetOpenidProto$GetOpenidEntry getOpenidProto$GetOpenidEntry = new GetOpenidProto$GetOpenidEntry();
                try {
                    getOpenidProto$GetOpenidEntry.f342198id.set(Long.parseLong(strArr[i3], 10));
                    int i16 = iArr[i3];
                    if (i16 == 0) {
                        getOpenidProto$GetOpenidEntry.type.set(0);
                    } else if (i16 == 1) {
                        getOpenidProto$GetOpenidEntry.type.set(1);
                    } else if (i16 == 3000) {
                        getOpenidProto$GetOpenidEntry.type.set(2);
                    } else {
                        activity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
                        activity.finish();
                        return;
                    }
                    getOpenidProto$GetOpenidReq.list.add(getOpenidProto$GetOpenidEntry);
                } catch (NumberFormatException unused) {
                    activity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
                    activity.finish();
                    return;
                }
            }
            NewIntent newIntent = new NewIntent(BaseApplication.getContext(), com.tencent.biz.m.class);
            newIntent.setWithouLogin(true);
            newIntent.putExtra("cmd", "CommCompSvr.get_openid");
            newIntent.putExtra("data", getOpenidProto$GetOpenidReq.toByteArray());
            newIntent.setObserver(new b(activity));
            appInterface.startServlet(newIntent);
            return;
        }
        activity.setResult(-1, new Intent().putExtra("ret", 4));
        activity.finish();
    }

    public static String K(com.tencent.biz.webviewplugin.z zVar) {
        if (zVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "init");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isShowBottomBar", zVar.f97657f);
                jSONObject2.put("barHeight", zVar.f97660m);
                jSONObject.put("data", jSONObject2);
                return jSONObject.toString();
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "getSetBottomBarCallBackResult json error!");
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.tencent.share.a L() {
        if (this.mRuntime.e() != null) {
            CustomWebView e16 = this.mRuntime.e();
            ViewParent parent = e16.getParent();
            if (parent instanceof com.tencent.comic.api.a) {
                com.tencent.comic.api.a aVar = (com.tencent.comic.api.a) parent;
                if (aVar.getShareHelper() instanceof com.tencent.share.a) {
                    return (com.tencent.share.a) aVar.getShareHelper();
                }
            }
            if (e16 instanceof com.tencent.comic.api.a) {
                Object shareHelper = ((com.tencent.comic.api.a) e16).getShareHelper();
                if (shareHelper instanceof com.tencent.share.a) {
                    return (com.tencent.share.a) shareHelper;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static Intent M(Context context, Map<String, Object> map, String str, String str2) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName(context, ShortcutGuideActivity.class.getName());
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtra("from", str2);
        intent.putExtra("url", str);
        return intent;
    }

    private com.tencent.share.b N() {
        com.tencent.share.a L = L();
        if (L != null) {
            if (L.j() == null) {
                L.m(new com.tencent.share.b(this.mRuntime.a(), this.mRuntime.e(), this.mRuntime.c()));
            }
            return L.j();
        }
        return null;
    }

    private void T() {
        f238704x0 = new v();
        if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, "initX5LogUploadReceiver!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("upload_x5_log");
        A(f238704x0, intentFilter);
    }

    public static boolean U(int i3) {
        boolean z16;
        float[] fArr = new float[3];
        xy2.b.d(i3, fArr);
        float f16 = fArr[2];
        if (f16 < 0.5f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UiApiPlugin", 2, "isColorDarkElseLight: " + z16 + ", brightness: " + f16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            BaseApplicationImpl.getApplication().registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e("UiApiPlugin", 1, "doRegisterReceiver exception:" + broadcastReceiver + ", " + e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        try {
            BaseApplicationImpl.getApplication().registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Exception e16) {
            QLog.e("UiApiPlugin", 1, "doRegisterReceiver exception:" + broadcastReceiver + ", " + e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(BroadcastReceiver broadcastReceiver) {
        try {
            BaseApplicationImpl.getApplication().unregisterReceiver(broadcastReceiver);
        } catch (Exception e16) {
            QLog.e("UiApiPlugin", 1, "doUnregisterReceiver exception:" + broadcastReceiver + ", " + e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Y(Activity activity, Intent intent) {
        activity.startActivityForResult(intent, 100);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Activity activity, String str, String str2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        O(activity, str, str2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Activity activity, String str, String str2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        O(activity, str, str2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(Context context, Intent intent) {
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("receiver");
        long longExtra = intent.getLongExtra("seq", 0L);
        Bundle bundle = new Bundle();
        bundle.putLong("seq", longExtra);
        if (A0.get() != -1) {
            resultReceiver.send(-1, bundle);
        }
        String stringExtra = intent.getStringExtra("date");
        String stringExtra2 = intent.getStringExtra("id");
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            CustomWebView e16 = this.mRuntime.e();
            if (e16 != null && e16.getX5WebViewExtension() != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("date", stringExtra);
                bundle2.putString("id", stringExtra2);
                A0.set(longExtra);
                B0 = resultReceiver;
                e16.getX5WebViewExtension().invokeMiscMethod("uploadX5CoreLiveLog", bundle2);
                return;
            }
            resultReceiver.send(-2, bundle);
            return;
        }
        resultReceiver.send(-2, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x06d8 A[Catch: Exception -> 0x085a, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x06f2 A[Catch: Exception -> 0x085a, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x070a A[Catch: Exception -> 0x085a, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0763 A[Catch: Exception -> 0x085a, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0777 A[Catch: Exception -> 0x085a, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x078d A[Catch: Exception -> 0x085a, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070 A[Catch: Exception -> 0x085c, TRY_ENTER, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0281 A[Catch: Exception -> 0x085c, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x026f A[Catch: Exception -> 0x085c, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x01c3 A[Catch: Exception -> 0x085c, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0184 A[Catch: Exception -> 0x01a9, TryCatch #2 {Exception -> 0x01a9, blocks: (B:294:0x0147, B:260:0x0171, B:261:0x017e, B:263:0x0184, B:265:0x018c, B:266:0x018f, B:268:0x0192), top: B:293:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094 A[Catch: Exception -> 0x085c, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b9 A[Catch: Exception -> 0x085c, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e7 A[Catch: Exception -> 0x085c, TRY_ENTER, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0205 A[Catch: Exception -> 0x085c, TRY_LEAVE, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02ae A[Catch: Exception -> 0x085c, TRY_ENTER, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0855 A[Catch: Exception -> 0x085a, TRY_LEAVE, TryCatch #1 {Exception -> 0x085a, blocks: (B:88:0x083d, B:94:0x084b, B:96:0x0855, B:102:0x02f6, B:104:0x0305, B:105:0x0321, B:107:0x0332, B:110:0x0344, B:112:0x0357, B:113:0x0373, B:115:0x0384, B:116:0x03ac, B:118:0x03bc, B:120:0x03cf, B:121:0x03da, B:122:0x03ed, B:124:0x03fe, B:125:0x0416, B:127:0x0427, B:128:0x043f, B:130:0x0450, B:131:0x0468, B:133:0x0476, B:135:0x04b4, B:136:0x04bc, B:138:0x04cd, B:139:0x04e7, B:141:0x0500, B:144:0x050c, B:146:0x0510, B:148:0x06ca, B:150:0x06d8, B:151:0x06e4, B:153:0x06f2, B:154:0x0702, B:156:0x070a, B:158:0x0727, B:159:0x073e, B:161:0x0763, B:162:0x0769, B:164:0x0777, B:165:0x078d, B:167:0x0793, B:169:0x0799, B:171:0x07a9, B:173:0x07b2, B:174:0x07c5, B:176:0x07cb, B:178:0x07d9, B:179:0x07ee, B:181:0x07f4, B:183:0x07f9, B:184:0x080e, B:185:0x0525, B:187:0x0529, B:188:0x052f, B:190:0x0540, B:191:0x0546, B:193:0x0557, B:194:0x055d, B:196:0x0561, B:197:0x0567, B:199:0x056b, B:200:0x0571, B:202:0x057b, B:203:0x0590, B:205:0x059b, B:207:0x05a6, B:208:0x05b0, B:210:0x05c3, B:211:0x05ea, B:213:0x05f7, B:214:0x0601, B:216:0x0612, B:217:0x0619, B:219:0x061d, B:220:0x0627, B:222:0x0635, B:223:0x063c, B:225:0x064a, B:226:0x0658, B:228:0x0666, B:230:0x0671, B:232:0x067b, B:233:0x0684, B:235:0x068f, B:236:0x0698, B:238:0x06a0, B:239:0x06a9, B:240:0x06b6, B:241:0x0814), top: B:101:0x02f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ea A[Catch: Exception -> 0x085c, TRY_LEAVE, TryCatch #0 {Exception -> 0x085c, blocks: (B:10:0x002a, B:16:0x0043, B:23:0x0070, B:25:0x007a, B:26:0x0081, B:30:0x0094, B:31:0x00a0, B:34:0x00ac, B:36:0x00b2, B:39:0x00cd, B:41:0x00db, B:43:0x00e4, B:45:0x00f2, B:46:0x00f5, B:49:0x0103, B:50:0x01b3, B:52:0x01b9, B:53:0x01d5, B:56:0x01e7, B:58:0x01f0, B:59:0x01f3, B:61:0x0205, B:75:0x0277, B:78:0x0284, B:81:0x02ae, B:83:0x02b2, B:84:0x02c4, B:86:0x02dd, B:87:0x02e3, B:98:0x02bf, B:99:0x02ea, B:245:0x0281, B:246:0x023a, B:247:0x0244, B:249:0x0255, B:250:0x0266, B:251:0x026f, B:252:0x01c3, B:254:0x01ce, B:255:0x0110, B:277:0x01ab, B:307:0x0062, B:310:0x003a), top: B:9:0x002a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g0(final Activity activity, CustomWebView customWebView, AppInterface appInterface, String str, boolean z16, boolean z17) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intent intent;
        String str8;
        String str9;
        Bundle bundle;
        String str10;
        String str11;
        Uri parse;
        boolean equals;
        boolean equals2;
        Bundle bundle2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int optInt;
        boolean z18;
        String str12;
        String str13;
        String str14;
        String str15;
        boolean z19;
        Class cls;
        final Intent intent2;
        String str16;
        Intent intent3;
        int optInt2;
        Intent intent4;
        if (activity == null) {
            return;
        }
        Intent intent5 = activity.getIntent();
        if (customWebView == null && !z17) {
            return;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            String optString = jSONObject3.optString("url");
            JSONObject optJSONObject = z16 ? jSONObject3 : jSONObject3.optJSONObject("options");
            if (optJSONObject != null) {
                str3 = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
                str4 = optJSONObject.optString("businessId", null);
            } else {
                str3 = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
                str4 = null;
            }
            if (str4 != null) {
                str5 = str4;
            } else if (intent5 != null) {
                str5 = str4;
                str4 = intent5.getStringExtra("big_brother_source_key");
            } else {
                str5 = str4;
                str6 = "url";
                str4 = null;
                if (intent5 == null) {
                    str7 = intent5.getStringExtra(LaunchParam.KEY_REF_ID);
                    if (TextUtils.isEmpty(str7)) {
                        str7 = intent5.getStringExtra("big_brother_source_key");
                    }
                } else {
                    str7 = null;
                }
                if (TextUtils.isEmpty(str7)) {
                    intent = intent5;
                    str8 = str7;
                } else {
                    String str17 = str5;
                    intent = intent5;
                    str8 = str17;
                }
                if (customWebView == null) {
                    str9 = str8;
                    m0(customWebView.getUrl(), optString);
                } else {
                    str9 = str8;
                }
                boolean optBoolean = jSONObject3.optBoolean("force_no_reload");
                if (TextUtils.isEmpty(optString) && optJSONObject != null && optJSONObject.has("style")) {
                    if (activity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity") || activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity") || optJSONObject.optBoolean("useNewConfig", false)) {
                        bundle = null;
                    } else {
                        Intent intent6 = activity.getIntent();
                        if (!TextUtils.isEmpty(intent6.getStringExtra("fragment_class"))) {
                            intent6.removeExtra("fragment_class");
                        }
                        bundle = intent6.getExtras();
                    }
                    if (bundle == null) {
                        bundle2 = new Bundle();
                        str10 = "com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity";
                        str11 = QQBrowserActivity.IS_OPENING_QUN_APP;
                    } else {
                        str10 = "com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity";
                        bundle.remove("title");
                        bundle.remove(AppConstants.LeftViewText.LEFTVIEWTEXT);
                        bundle.remove("post_data");
                        bundle.remove("options");
                        bundle.remove(QQBrowserActivity.IS_OPENING_QUN_APP);
                        bundle.remove("isTransparentTitleAndClickable");
                        k0(bundle);
                        if (customWebView != null) {
                            try {
                                parse = Uri.parse(customWebView.getUrl());
                            } catch (Exception e16) {
                                e = e16;
                                str11 = QQBrowserActivity.IS_OPENING_QUN_APP;
                                QLog.e("UiApiPlugin", 1, "open url exception", e);
                                bundle2 = bundle;
                                if (!bundle2.containsKey("startOpenPageTime")) {
                                }
                                jSONObject2 = jSONObject;
                                optInt = jSONObject2.optInt("style");
                                if (optString.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html")) {
                                }
                                if (Boolean.valueOf(jSONObject3.optBoolean("is_native", true)).booleanValue()) {
                                }
                                if (optInt == 0) {
                                }
                                if (jSONObject2.optInt("navigationBarStyle") != z18) {
                                }
                                bundle2.putBoolean("hide_title_left_arrow", jSONObject2.optBoolean("hideLeftArrow", false));
                                int optInt3 = jSONObject2.optInt("target");
                                if (!activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
                                }
                                optInt2 = jSONObject2.optInt("animation");
                                if (optInt2 == 1) {
                                }
                            }
                            if (parse != null) {
                                if (parse.isHierarchical()) {
                                    str11 = QQBrowserActivity.IS_OPENING_QUN_APP;
                                    try {
                                        equals = "1".equals(parse.getQueryParameter("__iscomic"));
                                        equals2 = "1".equals(parse.getQueryParameter("__useCampusNotice"));
                                        if (equals && !equals2) {
                                            bundle.remove("uintype");
                                            QLog.d("UiApiPlugin", 1, "remove campus notice");
                                        }
                                        if (bundle.containsKey("insertPluginsArray")) {
                                            Object obj = bundle.get("insertPluginsArray");
                                            if (obj instanceof String[]) {
                                                String[] strArr = (String[]) obj;
                                                for (int i3 = 0; i3 < strArr.length; i3++) {
                                                    if ("gdtReportPlugin".equals(strArr[i3])) {
                                                        try {
                                                            strArr[i3] = null;
                                                        } catch (Exception e17) {
                                                            e = e17;
                                                            QLog.e("UiApiPlugin", 1, "open url exception", e);
                                                            bundle2 = bundle;
                                                            if (!bundle2.containsKey("startOpenPageTime")) {
                                                            }
                                                            jSONObject2 = jSONObject;
                                                            optInt = jSONObject2.optInt("style");
                                                            if (optString.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html")) {
                                                            }
                                                            if (Boolean.valueOf(jSONObject3.optBoolean("is_native", true)).booleanValue()) {
                                                            }
                                                            if (optInt == 0) {
                                                            }
                                                            if (jSONObject2.optInt("navigationBarStyle") != z18) {
                                                            }
                                                            bundle2.putBoolean("hide_title_left_arrow", jSONObject2.optBoolean("hideLeftArrow", false));
                                                            int optInt32 = jSONObject2.optInt("target");
                                                            if (!activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
                                                            }
                                                            optInt2 = jSONObject2.optInt("animation");
                                                            if (optInt2 == 1) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        QLog.e("UiApiPlugin", 1, "open url exception", e);
                                        bundle2 = bundle;
                                        if (!bundle2.containsKey("startOpenPageTime")) {
                                        }
                                        jSONObject2 = jSONObject;
                                        optInt = jSONObject2.optInt("style");
                                        if (optString.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html")) {
                                            bundle2.remove(IPCConst.KEY_HIDE_LEFT_BUTTON);
                                        }
                                        if (Boolean.valueOf(jSONObject3.optBoolean("is_native", true)).booleanValue()) {
                                        }
                                        if (optInt == 0) {
                                        }
                                        if (jSONObject2.optInt("navigationBarStyle") != z18) {
                                        }
                                        bundle2.putBoolean("hide_title_left_arrow", jSONObject2.optBoolean("hideLeftArrow", false));
                                        int optInt322 = jSONObject2.optInt("target");
                                        if (!activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
                                        }
                                        optInt2 = jSONObject2.optInt("animation");
                                        if (optInt2 == 1) {
                                        }
                                    }
                                    bundle2 = bundle;
                                }
                            }
                        }
                        str11 = QQBrowserActivity.IS_OPENING_QUN_APP;
                        equals2 = false;
                        equals = false;
                        if (equals) {
                            bundle.remove("uintype");
                            QLog.d("UiApiPlugin", 1, "remove campus notice");
                        }
                        if (bundle.containsKey("insertPluginsArray")) {
                        }
                        bundle2 = bundle;
                    }
                    if (!bundle2.containsKey("startOpenPageTime")) {
                        jSONObject = optJSONObject;
                        bundle2.putLong("startOpenPageTime", System.currentTimeMillis());
                    } else {
                        jSONObject = optJSONObject;
                        if (VasNormalToggle.BUG_WEBVIEW_TIME.isEnable(true)) {
                            bundle2.putLong("startOpenPageTime", System.currentTimeMillis());
                        }
                    }
                    jSONObject2 = jSONObject;
                    optInt = jSONObject2.optInt("style");
                    if (optString.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html") && optString.contains("entry=aio")) {
                        bundle2.remove(IPCConst.KEY_HIDE_LEFT_BUTTON);
                    }
                    if (Boolean.valueOf(jSONObject3.optBoolean("is_native", true)).booleanValue()) {
                        PluginJumpManager.getInstance().updateConfig(appInterface);
                        PluginJumpManager.getInstance().loadConfig();
                        if (PluginJumpManager.getInstance().openView(activity, optString, String.valueOf(optInt))) {
                            return;
                        }
                    }
                    if (optInt == 0) {
                        if (optInt == 1) {
                            bundle2.putBoolean("hide_more_button", true);
                            bundle2.putBoolean("hide_operation_bar", true);
                        } else if (optInt == 2) {
                            bundle2.putBoolean("hide_more_button", false);
                            bundle2.putBoolean("hide_operation_bar", false);
                            bundle2.putString("webStyle", "");
                        } else if (optInt != 3) {
                            if (optInt == 4) {
                                bundle2.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                                bundle2.putBoolean("show_right_close_button", true);
                            }
                            z18 = true;
                        } else {
                            bundle2.putBoolean("hide_more_button", true);
                            bundle2.putBoolean("hide_operation_bar", false);
                            bundle2.putString("webStyle", "");
                        }
                        z18 = true;
                    } else {
                        bundle2.putBoolean("hide_more_button", false);
                        z18 = true;
                        bundle2.putBoolean("hide_operation_bar", true);
                    }
                    if (jSONObject2.optInt("navigationBarStyle") != z18) {
                        bundle2.putBoolean("isTransparentTitleAndClickable", z18);
                    }
                    bundle2.putBoolean("hide_title_left_arrow", jSONObject2.optBoolean("hideLeftArrow", false));
                    int optInt3222 = jSONObject2.optInt("target");
                    if (!activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
                        if (activity instanceof BasePluginActivity) {
                            intent4 = new Intent(((BasePluginActivity) activity).getOutActivity(), (Class<?>) QQBrowserActivity.class);
                        } else {
                            intent4 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                        }
                        intent4.putExtra("big_brother_source_key", str4);
                        intent4.putExtra(LaunchParam.KEY_REF_ID, str9);
                        intent4.putExtras(bundle2);
                        intent4.putExtra(str6, optString);
                        intent4.setFlags(0);
                        if (optInt3222 == 1) {
                            intent4.putExtra("articalChannelId", 0);
                        }
                        activity.startActivityForResult(intent4, 100);
                    } else {
                        String str18 = str6;
                        String str19 = str9;
                        String str20 = LaunchParam.KEY_REF_ID;
                        str2 = "UiApiPlugin";
                        try {
                            if (activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity")) {
                                Intent intent7 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                intent7.putExtra("big_brother_source_key", str4);
                                intent7.putExtra(str20, str19);
                                intent7.putExtras(bundle2);
                                intent7.putExtra(str18, optString);
                                intent7.setFlags(0);
                                activity.startActivityForResult(intent7, 100);
                            } else {
                                if (!activity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicWebFragmentActivity")) {
                                    String str21 = str3;
                                    if (!activity.getClass().getName().equalsIgnoreCase(str21)) {
                                        if (activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQH5BrowserActivity")) {
                                            Intent intent8 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            intent8.putExtra("big_brother_source_key", str4);
                                            intent8.putExtra(str20, str19);
                                            intent8.putExtras(bundle2);
                                            intent8.putExtra(str18, optString);
                                            intent8.setFlags(0);
                                            activity.startActivityForResult(intent8, 100);
                                        } else if (activity.getClass().getName().equalsIgnoreCase("com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity")) {
                                            Intent intent9 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            intent9.putExtra("big_brother_source_key", str4);
                                            intent9.putExtra(str20, str19);
                                            bundle2.remove(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN);
                                            bundle2.remove("isTransparentTitle");
                                            intent9.putExtras(bundle2);
                                            intent9.putExtra(str18, optString);
                                            intent9.setFlags(0);
                                            activity.startActivityForResult(intent9, 100);
                                        } else if (activity.getClass().getName().equalsIgnoreCase(str10)) {
                                            Intent intent10 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(optString)) {
                                                intent10 = TeamWorkDocEditBrowserActivity.getOpenTeamWorkIntent(new Intent(activity, (Class<?>) TeamWorkDocEditBrowserActivity.class), optString, activity);
                                            }
                                            intent10.putExtra("big_brother_source_key", str4);
                                            intent10.putExtra(str20, str19);
                                            intent10.putExtras(bundle2);
                                            intent10.putExtra(str18, optString);
                                            activity.startActivityForResult(intent10, 100);
                                        } else if (activity.getClass().getName().equalsIgnoreCase("cooperation.qwallet.plugin.QWalletPluginProxyActivity")) {
                                            Intent intent11 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            intent11.putExtra("big_brother_source_key", str4);
                                            intent11.putExtra(str20, str19);
                                            intent11.putExtras(bundle2);
                                            intent11.putExtra(str18, optString);
                                            activity.startActivityForResult(intent11, 100);
                                        } else if (activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI")) {
                                            Intent intent12 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            intent12.putExtra("big_brother_source_key", str4);
                                            intent12.putExtra(str20, str19);
                                            intent12.putExtras(bundle2);
                                            intent12.putExtra(str18, optString);
                                            activity.startActivityForResult(intent12, 100);
                                        } else if (activity.getClass().getName().equalsIgnoreCase("cooperation.liveroom.LiveRoomProxyActivity")) {
                                            Intent intent13 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            intent13.putExtra("big_brother_source_key", str4);
                                            intent13.putExtra(str20, str19);
                                            intent13.putExtras(bundle2);
                                            intent13.putExtra(str18, optString);
                                            activity.startActivityForResult(intent13, 100);
                                        } else if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniGamePay(activity, optString)) {
                                            Intent intent14 = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
                                            intent14.putExtra(str18, optString);
                                            intent14.putExtra("big_brother_source_key", str4);
                                            intent14.putExtra(str20, str19);
                                            bundle2.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                                            bundle2.putBoolean("hide_more_button", true);
                                            intent14.putExtras(bundle2);
                                            QLog.d("PayForFriendView", 1, "checkPayForFriendLogic startActivityForResult at " + System.currentTimeMillis());
                                            activity.startActivityForResult(intent14, 3004);
                                            if (customWebView != null) {
                                                customWebView.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
                                            }
                                        } else if (activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI")) {
                                            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                                            Intent intent15 = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                                            intent15.putExtra("big_brother_source_key", str4);
                                            intent15.putExtra(str20, str19);
                                            intent15.putExtras(bundle2);
                                            intent15.putExtra(str18, optString);
                                            qBaseActivity.startActivityForResult(intent15, 100);
                                        } else {
                                            bundle2.remove(BusinessFeedData.TAG);
                                            if (!activity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.apollo.store.ApolloFloatActivity") && !jSONObject2.optBoolean("useQQBrowser", false)) {
                                                if (activity instanceof QzoneJumpQBrowserInterface) {
                                                    intent3 = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                                                } else if (activity instanceof EcshopWebActivity) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                } else if (activity.getClass().getName().equalsIgnoreCase("com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity")) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                } else if (activity.getClass().getName().equalsIgnoreCase("com.tencent.ilive.audiencepages.room.AudienceRoomActivity")) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                } else if (activity instanceof PublicFragmentActivityForTool) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                } else if (activity instanceof QPublicFragmentActivityForTool) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                } else if (jSONObject2.optBoolean("QzoneUseQQBrowser", false)) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                    intent3.putExtra("big_brother_source_key", str4);
                                                    bundle2.remove("isTransparentTitle");
                                                    bundle2.remove("hide_more_button");
                                                    bundle2.remove(IPCConst.KEY_HIDE_LEFT_BUTTON);
                                                } else if (jSONObject2.optInt("transparent", 0) == 1) {
                                                    intent3 = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
                                                } else if (z17) {
                                                    intent3 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                                    intent3.putExtra("big_brother_source_key", str4);
                                                } else {
                                                    Intent intent16 = intent;
                                                    if (((IQQGiftUtil) QRoute.api(IQQGiftUtil.class)).checkIsQQGiftUrl(optString, str, intent16)) {
                                                        str13 = "big_brother_source_key";
                                                        str12 = str19;
                                                        z19 = optBoolean;
                                                        str15 = "startOpenPageTime";
                                                        cls = QQBrowserActivity.class;
                                                        Intent openQQGiftUrlIntent = ((IQQGiftUtil) QRoute.api(IQQGiftUtil.class)).getOpenQQGiftUrlIntent(activity, optString, str, intent16, bundle2);
                                                        openQQGiftUrlIntent.putExtra(str13, str4);
                                                        intent2 = openQQGiftUrlIntent;
                                                        str14 = str18;
                                                        str20 = str20;
                                                    } else {
                                                        str12 = str19;
                                                        str13 = "big_brother_source_key";
                                                        str14 = str18;
                                                        str15 = "startOpenPageTime";
                                                        z19 = optBoolean;
                                                        cls = QQBrowserActivity.class;
                                                        if (activity instanceof HalfTranslucentBrowserActivity) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                            bundle2.remove(IPCConst.KEY_HIDE_LEFT_BUTTON);
                                                        } else if (activity.getClass().getName().equalsIgnoreCase("com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorActivity")) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                        } else if (activity instanceof SpringHbTranslucentBrowserActivity) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                            intent2.putExtra(str13, str4);
                                                        } else if (((INewQWalletApi) QRoute.api(INewQWalletApi.class)).isFromQWalletPage(activity, bundle2)) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                        } else if (((INewQWalletApi) QRoute.api(INewQWalletApi.class)).isFromHalfWebPage(activity, bundle2)) {
                                                            intent2 = new Intent(activity, activity.getClass());
                                                            intent2.putExtra(str13, str4);
                                                        } else if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isLaunchByMiniApp(activity)) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                            intent2.putExtra(str13, str4);
                                                        } else if (intent16 != null && intent16.getBooleanExtra("gdtMotiveBrowsing", false)) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                            intent2.putExtra(str13, str4);
                                                        } else if (jSONObject2.optInt("useQQBrowser", 0) == 1) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                            intent2.putExtra(str13, str4);
                                                        } else if (r30.c.f430661a.g(activity)) {
                                                            intent2 = new Intent(activity, (Class<?>) cls);
                                                            intent2.putExtra(str13, str4);
                                                        } else {
                                                            intent2 = new Intent(activity, activity.getClass());
                                                            intent2.putExtra(str13, str4);
                                                        }
                                                    }
                                                    if (((IQQShopApi) QRoute.api(IQQShopApi.class)).isFromQQShopPage(activity)) {
                                                        optString = ((IQQShopApi) QRoute.api(IQQShopApi.class)).changeDefaultWV(optString);
                                                    }
                                                    if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(optString)) {
                                                        Intent intent17 = new Intent(activity, (Class<?>) TeamWorkDocEditBrowserActivity.class);
                                                        intent17.addFlags(603979776);
                                                        intent2 = TeamWorkDocEditBrowserActivity.getOpenTeamWorkIntent(intent17, optString, activity);
                                                    }
                                                    str16 = str11;
                                                    if (jSONObject2.optBoolean(str16)) {
                                                        bundle2.putBoolean(str16, jSONObject2.optBoolean(str16));
                                                        bundle2.putInt("appid", jSONObject2.optInt("appid"));
                                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject(QQBrowserActivity.APP_PARAM);
                                                        if (optJSONObject2 != null) {
                                                            bundle2.putString(QQBrowserActivity.APP_PARAM, optJSONObject2.toString());
                                                            bundle2.putInt(QQBrowserActivity.TROOP_ID, optJSONObject2.optInt("gc"));
                                                        }
                                                    }
                                                    intent2.putExtra("force_no_reload", z19);
                                                    intent2.putExtra(str15, System.currentTimeMillis());
                                                    intent2.putExtras(bundle2);
                                                    intent2.putExtra(str13, str4);
                                                    String str22 = str12;
                                                    intent2.putExtra(str20, str22);
                                                    intent2.putExtra(str14, optString);
                                                    intent2.setFlags(0);
                                                    if (optInt3222 == 1) {
                                                        intent2.putExtra("articalChannelId", 0);
                                                    }
                                                    if (((IQQComicUtil) QRoute.api(IQQComicUtil.class)).isVideoUrl(optString, intent2)) {
                                                        intent2.setClassName("com.qqcomic", str21);
                                                        ((IQQComicPluginUtil) QRoute.api(IQQComicPluginUtil.class)).launchPlugin(activity, intent2, str21, null);
                                                    } else if (com.tencent.mobileqq.zplan.utils.ab.c(optString) && com.tencent.mobileqq.zplan.utils.ab.d(optString)) {
                                                        com.tencent.mobileqq.zplan.utils.ab.a(activity, com.tencent.mobileqq.zplan.utils.ab.b(optString), new Function0() { // from class: com.tencent.mobileqq.jsp.af
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                Unit Y;
                                                                Y = UiApiPlugin.Y(activity, intent2);
                                                                return Y;
                                                            }
                                                        });
                                                    } else if (optString != null && optString.startsWith("mqqapi://")) {
                                                        Intent intent18 = new Intent(activity, (Class<?>) JumpActivity.class);
                                                        intent18.setData(Uri.parse(optString));
                                                        activity.startActivity(intent18);
                                                    } else if (activity.getIntent() != null && activity.getIntent().getBooleanExtra("key_enable_remote_web_render", false)) {
                                                        Intent intent19 = new Intent(activity, (Class<?>) cls);
                                                        intent19.putExtra(str13, str4);
                                                        intent19.putExtra(str20, str22);
                                                        intent19.putExtras(bundle2);
                                                        intent19.putExtra(str14, optString);
                                                        activity.startActivity(intent19);
                                                    } else if (activity.getIntent() != null && MobileQQ.sProcessId == 1) {
                                                        Intent intent20 = new Intent(activity, (Class<?>) cls);
                                                        intent20.putExtra(str13, str4);
                                                        intent20.putExtra(str20, str22);
                                                        intent20.putExtras(bundle2);
                                                        intent20.putExtra(str14, optString);
                                                        activity.startActivity(intent20);
                                                    } else {
                                                        activity.startActivityForResult(intent2, 100);
                                                    }
                                                }
                                                str12 = str19;
                                                str13 = "big_brother_source_key";
                                                str15 = "startOpenPageTime";
                                                z19 = optBoolean;
                                                intent2 = intent3;
                                                cls = QQBrowserActivity.class;
                                                str14 = str18;
                                                if (((IQQShopApi) QRoute.api(IQQShopApi.class)).isFromQQShopPage(activity)) {
                                                }
                                                if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(optString)) {
                                                }
                                                str16 = str11;
                                                if (jSONObject2.optBoolean(str16)) {
                                                }
                                                intent2.putExtra("force_no_reload", z19);
                                                intent2.putExtra(str15, System.currentTimeMillis());
                                                intent2.putExtras(bundle2);
                                                intent2.putExtra(str13, str4);
                                                String str222 = str12;
                                                intent2.putExtra(str20, str222);
                                                intent2.putExtra(str14, optString);
                                                intent2.setFlags(0);
                                                if (optInt3222 == 1) {
                                                }
                                                if (((IQQComicUtil) QRoute.api(IQQComicUtil.class)).isVideoUrl(optString, intent2)) {
                                                }
                                            }
                                            str12 = str19;
                                            str13 = "big_brother_source_key";
                                            str14 = str18;
                                            str15 = "startOpenPageTime";
                                            z19 = optBoolean;
                                            cls = QQBrowserActivity.class;
                                            intent2 = new Intent(activity, (Class<?>) cls);
                                            intent2.putExtra(str13, "biz_src_zf_lmx");
                                            if (((IQQShopApi) QRoute.api(IQQShopApi.class)).isFromQQShopPage(activity)) {
                                            }
                                            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(optString)) {
                                            }
                                            str16 = str11;
                                            if (jSONObject2.optBoolean(str16)) {
                                            }
                                            intent2.putExtra("force_no_reload", z19);
                                            intent2.putExtra(str15, System.currentTimeMillis());
                                            intent2.putExtras(bundle2);
                                            intent2.putExtra(str13, str4);
                                            String str2222 = str12;
                                            intent2.putExtra(str20, str2222);
                                            intent2.putExtra(str14, optString);
                                            intent2.setFlags(0);
                                            if (optInt3222 == 1) {
                                            }
                                            if (((IQQComicUtil) QRoute.api(IQQComicUtil.class)).isVideoUrl(optString, intent2)) {
                                            }
                                        }
                                    }
                                }
                                Intent intent21 = new Intent();
                                intent21.putExtra("big_brother_source_key", str4);
                                intent21.putExtra(str20, str19);
                                bundle2.remove("activityNoTitle");
                                intent21.putExtras(bundle2);
                                intent21.putExtra(str18, optString);
                                intent21.setFlags(0);
                                ((IQQComicWebViewApi) QRoute.api(IQQComicWebViewApi.class)).openComicWebView(activity, optString, intent21);
                            }
                        } catch (Exception e19) {
                            e = e19;
                            QLog.e(str2, 1, "convert json exception", e);
                            return;
                        }
                    }
                    optInt2 = jSONObject2.optInt("animation");
                    if (optInt2 == 1) {
                        if (optInt2 != 2) {
                            return;
                        }
                        activity.overridePendingTransition(R.anim.f155030h6, R.anim.f154740cc);
                        return;
                    }
                    activity.overridePendingTransition(0, 0);
                    return;
                }
                return;
            }
            str6 = "url";
            if (intent5 == null) {
            }
            if (TextUtils.isEmpty(str7)) {
            }
            if (customWebView == null) {
            }
            boolean optBoolean2 = jSONObject3.optBoolean("force_no_reload");
            if (TextUtils.isEmpty(optString)) {
            }
        } catch (Exception e26) {
            e = e26;
            str2 = "UiApiPlugin";
        }
    }

    static int getColorFromJSON(JSONObject jSONObject, String str) {
        try {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
                return Color.parseColor(jSONObject.getString(str));
            }
        } catch (Exception unused2) {
            return 0;
        }
    }

    private static void k0(Bundle bundle) {
        if (bundle != null) {
            bundle.remove(WebBundleConstants.OPEN_WITH_WEBBUNDLE);
            bundle.remove(WebBundleConstants.WEBBUNDLE_REAL_URL);
            bundle.remove(WebBundleConstants.WEBBUNDLE_PRELOAD_URL);
            bundle.remove(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA);
        }
    }

    private static void m0(String str, String str2) {
        if ((!TextUtils.isEmpty(str2) && str2.startsWith("http:")) || (str2.startsWith("https:") && !TextUtils.isEmpty(str) && str.contains(MobileReportManager.sTraceKey))) {
            ThreadManager.getSubThreadHandler().post(new Runnable(str, str2) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f238729d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f238730e;

                {
                    this.f238729d = str;
                    this.f238730e = str2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        MobileReportManager.getInstance().reportH5DomainClick(this.f238729d, this.f238730e);
                    }
                }
            });
        }
    }

    private void p0(ImageView imageView, ImageView imageView2, int i3) {
        if (i3 != 0) {
            if (imageView2 == null) {
                imageView2 = new ImageView(BaseApplicationImpl.getApplication());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(7, imageView.getId());
                layoutParams.addRule(6, imageView.getId());
                layoutParams.setMargins(0, 0, 0, 0);
                imageView2.setLayoutParams(layoutParams);
                if (imageView.getParent() instanceof RelativeLayout) {
                    ((RelativeLayout) imageView.getParent()).addView(imageView2);
                }
            }
            int G = G(i3);
            if (G > 0) {
                imageView2.setImageResource(G);
                imageView2.setVisibility(0);
                return;
            } else {
                imageView2.setVisibility(8);
                return;
            }
        }
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private void s0(JSONObject jSONObject) {
        if (this.mRuntime == null || jSONObject == null || NightMaskConfProcessor.a().a()) {
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("nightModeMaskViewHide", false);
        WebViewProvider f16 = this.mRuntime.f();
        CustomWebView e16 = this.mRuntime.e();
        if (f16 != null && e16 != null && f16.isNightMode()) {
            e16.setMask(!optBoolean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean y(Context context, Intent intent, String str, String str2) {
        byte[] bArr;
        Bitmap decodeByteArray;
        ShortcutManager shortcutManager;
        boolean isRequestPinShortcutSupported;
        ShortcutInfo.Builder icon;
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder intent2;
        ShortcutInfo build;
        int e16;
        if (TextUtils.isEmpty(str2)) {
            try {
                decodeByteArray = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon);
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(e17));
                }
                decodeByteArray = null;
                if (decodeByteArray != null) {
                }
                if (decodeByteArray == null) {
                }
            }
        } else {
            try {
                bArr = HttpUtil.openUrlForByte(context, str2, "GET", null, null);
            } catch (IOException e18) {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(e18));
                }
                bArr = null;
            }
            if (bArr == null) {
                return false;
            }
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            } catch (OutOfMemoryError e19) {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(e19));
                }
                decodeByteArray = null;
                if (decodeByteArray != null) {
                    if (wy2.d.f446753c) {
                    }
                }
                if (decodeByteArray == null) {
                }
            }
        }
        if (decodeByteArray != null && (e16 = com.tencent.mobileqq.utils.al.e(context)) != decodeByteArray.getWidth()) {
            if (wy2.d.f446753c) {
                decodeByteArray = wy2.c.d().a(decodeByteArray, e16);
            } else {
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, e16, e16, false);
            }
        }
        if (decodeByteArray == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "createShortcut.failed, icon is null.");
            }
            return false;
        }
        wy2.c.d().k(intent);
        if (Build.VERSION.SDK_INT >= 26 && (shortcutManager = (ShortcutManager) context.getSystemService("shortcut")) != null) {
            isRequestPinShortcutSupported = shortcutManager.isRequestPinShortcutSupported();
            if (isRequestPinShortcutSupported) {
                icon = new ShortcutInfo.Builder(context, "QQ" + str).setIcon(Icon.createWithBitmap(decodeByteArray));
                shortLabel = icon.setShortLabel(str);
                intent2 = shortLabel.setIntent(intent);
                build = intent2.build();
                try {
                    shortcutManager.requestPinShortcut(build, null);
                    return true;
                } catch (Exception e26) {
                    QLog.i("UiApiPlugin", 1, "requestPinShortcut exception", e26);
                    return false;
                }
            }
        }
        Intent intent3 = new Intent();
        intent3.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent3.putExtra("android.intent.extra.shortcut.NAME", str);
        intent3.putExtra("android.intent.extra.shortcut.ICON", decodeByteArray);
        intent3.putExtra("duplicate", false);
        intent3.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendOrderedBroadcast(intent3, null);
        if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, "createShortcut.finish.");
        }
        return true;
    }

    private void z(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (QQUtils.j(activity, new String[]{str})) {
            QQToast.makeText(activity, R.string.b1c, 0).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            String F = F("-4", null, "createShortcut exsit!", str3);
            ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
            callJs(str5, F);
            return;
        }
        if (ec.d(activity) == 1) {
            callJs(str5, F("-5", null, "no permission to create shortcut", str3));
            D0(activity);
        } else {
            ThreadManagerV2.excute(new Runnable(activity, str4, str, str2, str3, str5) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.19
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f238731d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f238732e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f238733f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f238734h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f238735i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f238736m;

                {
                    this.f238731d = activity;
                    this.f238732e = str4;
                    this.f238733f = str;
                    this.f238734h = str2;
                    this.f238735i = str3;
                    this.f238736m = str5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, UiApiPlugin.this, activity, str4, str, str2, str3, str5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity2 = this.f238731d;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(UiApiPlugin.y(activity2, UiApiPlugin.M(activity2, null, this.f238732e, QQBrowserActivity.WEB_FLOAT_SHORTCUT_FROM), this.f238733f, this.f238734h)) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.19.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f238737d;

                        {
                            this.f238737d = r6;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass19.this, Boolean.valueOf(r6));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String F2;
                            int i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f238737d) {
                                F2 = UiApiPlugin.F("0", null, null, AnonymousClass19.this.f238735i);
                                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
                                i3 = R.string.exk;
                            } else {
                                F2 = UiApiPlugin.F("-3", null, "createShortcut failed, iconUrl is invalide: " + AnonymousClass19.this.f238734h, AnonymousClass19.this.f238735i);
                                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
                                i3 = R.string.exj;
                            }
                            QQToast.makeText(AnonymousClass19.this.f238731d, i3, 0).show(AnonymousClass19.this.f238731d.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
                            AnonymousClass19 anonymousClass19 = AnonymousClass19.this;
                            UiApiPlugin.this.callJs(anonymousClass19.f238736m, F2);
                        }
                    });
                }
            }, 128, null, true);
        }
    }

    public void A0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.n)) {
            Share share = (Share) ((com.tencent.mobileqq.webviewplugin.n) d16).getShare();
            Bundle bundle = new Bundle();
            bundle.putString("title", share.B());
            bundle.putString("desc", share.x());
            bundle.putString("detail_url", share.getShareUrl());
            bundle.putString("cover_url", share.v());
            bundle.putInt(AppConstants.Key.SHARE_REQ_ARTICLE_ID, share.u());
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(share.A());
            bundle.putStringArrayList("image_url", arrayList);
            bundle.putString("source_name", share.z());
            if (getCurrentContext() != null) {
                if (!TextUtils.isEmpty(str)) {
                    callJs(str, "false");
                }
                com.tencent.biz.qrcode.util.h.T(1, R.string.f169964ab);
            }
        }
    }

    public void B0(String str) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ActionSheet actionSheet = this.f238712e;
        if (actionSheet != null) {
            if (actionSheet.isShowing()) {
                this.f238712e.dismiss();
            }
            if (str.equals(this.f238710d)) {
                this.f238712e.show();
                return;
            }
        }
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ActionSheet create = ActionSheet.create(a16);
            String optString = jSONObject.optString("title");
            if (!TextUtils.isEmpty(optString)) {
                create.setMainTitle(optString);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            int optInt = jSONObject.optInt("selected", -1);
            this.f238717h = false;
            String optString2 = jSONObject.optString("close");
            if (!TextUtils.isEmpty(optString2)) {
                this.f238717h = true;
                create.addButton(optString2, 3);
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                if (optInt >= 0 && optInt < length) {
                    for (int i16 = 0; i16 < length; i16++) {
                        String string = optJSONArray.getString(i16);
                        if (i16 == optInt) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        create.addRadioButton(string, z16);
                    }
                } else {
                    for (int i17 = 0; i17 < length; i17++) {
                        create.addButton(optJSONArray.getString(i17));
                    }
                }
                i3 += length;
            }
            String optString3 = jSONObject.optString("cancel");
            if (!TextUtils.isEmpty(optString3)) {
                create.addCancelButton(optString3);
            }
            create.setOnButtonClickListener(this);
            create.setOnDismissListener(this);
            create.setOnCancelListener(this);
            create.registerWatchDisMissActionListener(this);
            this.f238712e = create;
            this.f238714f = jSONObject.optString("onclick");
            this.f238719i = i3;
            this.f238710d = str;
            this.f238712e.show();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "showActionSheet error:" + e16.getMessage());
            }
        }
    }

    public int E(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str)).intValue();
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e("UiApiPlugin", 1, "parse String to int error. ", e16);
            i3 = -1;
        }
        Pair<Integer, Integer> pair = com.tencent.mobileqq.webview.swift.utils.n.f314764a.a().get(i3);
        if (pair != null) {
            return pair.getFirst().intValue();
        }
        if (14 == i3) {
            return R.drawable.skin_listen_together_header_custom;
        }
        if (15 == i3) {
            return R.drawable.skin_listen_together_header_settings;
        }
        if (16 != i3) {
            return -1;
        }
        return R.drawable.mini_game_hb_record;
    }

    public void E0(JSONObject jSONObject) {
        View ge5;
        JSONArray optJSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) jSONObject);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "showPopupMenu: context is null");
                return;
            }
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        com.tencent.mobileqq.webviewplugin.s g16 = this.mRuntime.g();
        if (g16 != null && g16.getWebTitleBarInterface() != null) {
            ge5 = g16.getWebTitleBarInterface().getTitleBarView();
        } else if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.g)) {
            ge5 = ((com.tencent.mobileqq.webviewplugin.g) d16).getTitleBarView();
        } else if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.k)) {
            ge5 = ((com.tencent.mobileqq.webviewplugin.k) d16).ge(this.mRuntime.e().hashCode());
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "showPopupMenu: activity has not implement WebUiMethodInterface");
                return;
            }
            return;
        }
        View view = ge5;
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "showPopupMenu: Can not get TitleBar");
                return;
            }
            return;
        }
        float f16 = a16.getResources().getDisplayMetrics().density;
        PopupMenuDialog popupMenuDialog = this.U;
        if (popupMenuDialog != null) {
            if (!popupMenuDialog.isShowing()) {
                this.U.showAsDropDown(view, (view.getWidth() - a16.getResources().getDimensionPixelSize(R.dimen.aua)) - a16.getResources().getDimensionPixelSize(R.dimen.au7), a16.getResources().getDimensionPixelSize(R.dimen.au8));
                return;
            }
            return;
        }
        Drawable drawable = a16.getResources().getDrawable(R.drawable.cj9);
        try {
            optJSONArray = jSONObject.optJSONArray("list");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + e16.getMessage());
            }
        }
        if (optJSONArray == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "showPopupMenu: list is null");
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
            menuItem.f384641id = Integer.parseInt(optJSONObject.optString("id"));
            String optString = optJSONObject.optString("itemContent");
            menuItem.title = optString;
            menuItem.contentDescription = optString;
            menuItem.iconId = R.drawable.h89;
            String optString2 = optJSONObject.optString(QZoneJsConstants.KEY_HIGH_FIVE_URL);
            if (!TextUtils.isEmpty(optString2)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = (int) (f16 * 71.0f);
                obtain.mRequestHeight = (int) (94.0f * f16);
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                menuItem.netDrawable = URLDrawable.getDrawable(optString2, obtain);
            }
            arrayList.add(menuItem);
        }
        PopupMenuDialog build = PopupMenuDialog.build(a16, arrayList, new f(jSONObject, a16));
        this.U = build;
        build.showAsDropDown(view, (view.getWidth() - a16.getResources().getDimensionPixelSize(R.dimen.aua)) - a16.getResources().getDimensionPixelSize(R.dimen.au7), a16.getResources().getDimensionPixelSize(R.dimen.au8));
    }

    void H0() {
        if (this.Z) {
            View view = this.f238718h0;
            if (view != null) {
                view.setVisibility(0);
            }
            RefreshView refreshView = this.f238715f0;
            if (refreshView != null) {
                refreshView.setOnRefreshListener(null);
            }
        }
    }

    public void O(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, activity, str, str2);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("my_emoji_clk".equals(str2)) {
                if ("11".equals(str) && activity != null) {
                    Intent intent = activity.getIntent();
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
                    activityURIRequest.extra().putInt(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, intent.getIntExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, -1));
                    activityURIRequest.extra().putString(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, intent.getStringExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN));
                    activityURIRequest.extra().putInt("emojimall_src", intent.getIntExtra("emojimall_src", 1));
                    QRoute.startUri(activityURIRequest);
                } else {
                    QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, my_emoji_clk, activity = null or iconid != my dressup");
                }
            } else {
                callJs(str2, "");
            }
        } else {
            QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, callback null, iconId=" + str);
        }
        if ("10".equals(str)) {
            ReportController.o(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
        }
    }

    public void P(boolean z16, int i3) {
        View findViewById;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing() && (findViewById = a16.findViewById(R.id.rlCommenTitle)) != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i16 = ImmersiveUtils.getStatusBarHeight(a16) + 0;
            } else {
                i16 = 0;
            }
            findViewById.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = i16 + findViewById.getMeasuredHeight();
            boolean z17 = this.W;
            if (!z17 && z16) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -measuredHeight);
                translateAnimation.setDuration(i3);
                translateAnimation.setInterpolator(new LinearInterpolator());
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new g(findViewById, findViewById.getTop() - measuredHeight, findViewById.getBottom() - measuredHeight));
                findViewById.startAnimation(translateAnimation);
                this.W = true;
                return;
            }
            if (z17 && !z16) {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, -measuredHeight, 0.0f);
                translateAnimation2.setDuration(i3);
                translateAnimation2.setInterpolator(new LinearInterpolator());
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new h(findViewById, findViewById.getTop() + measuredHeight, findViewById.getBottom() + measuredHeight));
                findViewById.setVisibility(0);
                findViewById.startAnimation(translateAnimation2);
                this.W = false;
            }
        }
    }

    void Q() {
        f238698r0 = new u();
        if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, "initExitWebViewReceiver!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
        B(f238698r0, intentFilter, "com.tencent.msg.permission.pushnotify", null);
    }

    void R(boolean z16, int i3, int i16) {
        CustomWebView e16 = this.mRuntime.e();
        Activity a16 = this.mRuntime.a();
        if (e16 != null && a16 != null && !a16.isFinishing()) {
            View view = (View) e16.getParent();
            if (!(view instanceof RefreshView)) {
                return;
            }
            this.f238715f0 = (RefreshView) view;
            this.f238716g0 = false;
            if (!this.Z) {
                View findViewById = a16.findViewById(R.id.aea);
                this.f238718h0 = findViewById;
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                this.Z = true;
                com.tencent.mobileqq.widget.p pVar = this.f238715f0.f97003i;
                this.f238708b0 = pVar;
                if (z16) {
                    pVar.setHeaderBgColor(-16777216);
                    this.f238715f0.setBackgroundColor(-16777216);
                } else {
                    pVar.setHeaderBgColor(i3);
                    this.f238715f0.setBackgroundColor(i16);
                }
                this.f238715f0.setOnRefreshListener(new c());
                callJs4OpenApiIfNeeded("setPullDown", 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
            callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
            return;
        }
        callJs4OpenApiIfNeeded("setPullDown", -100, "recode_failed_native_error");
    }

    public void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
            return;
        }
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = i3;
        miniMsgUserParam.accessType = 3;
        miniMsgUserParam.filterMsgType = 1;
        miniMsgUserParam.isNeedBackConversation = true;
        miniMsgUserParam.unreadCallback = I();
        miniMsgUserParam.actionCallback = H();
        if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin initMiniMsgUser = ");
        }
        MiniMsgUser miniMsgUser = new MiniMsgUser(this.mRuntime.a(), miniMsgUserParam);
        this.f238723l0 = miniMsgUser;
        miniMsgUser.onForeground();
    }

    protected void b0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("imageData");
            if (!TextUtils.isEmpty(optString)) {
                String str2 = AppConstants.SDCARD_PATH + "diskcache/Image_" + MD5Utils.toMD5(optString);
                FileUtils.writeFile(PluginBaseInfoHelper.Base64Helper.decode(optString, 0), str2);
                c0(jSONObject, str2, 0);
                return;
            }
            String optString2 = jSONObject.optString("imageUrl");
            Activity a16 = this.mRuntime.a();
            if (a16 != null && !a16.isFinishing()) {
                if (!AppNetConnInfo.isNetSupport()) {
                    c0(jSONObject, null, -2);
                    return;
                }
                File file = new File(AbsDownloader.getFilePath(optString2));
                if (file.exists()) {
                    c0(jSONObject, AbsDownloader.getFilePath(optString2), 0);
                    return;
                }
                Bundle bundle = new Bundle();
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(optString2, file);
                gVar.A = 60L;
                ((DownloaderFactory) this.mRuntime.b().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(gVar, new j(optString2, jSONObject), bundle);
            }
        } catch (Exception e16) {
            QLog.e("UiApiPlugin", 1, "mergeTextToImage exception e = ", e16);
        }
    }

    protected void c0(JSONObject jSONObject, String str, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, jSONObject, str, Integer.valueOf(i3));
            return;
        }
        String optString = jSONObject.optString("callback");
        if (str == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("code", i3);
                callJs(optString, jSONObject2.toString());
                return;
            } catch (JSONException unused) {
                callJs(optString, "{\"code\":" + i3 + "}");
                return;
            }
        }
        String optString2 = jSONObject.optString("text");
        String optString3 = jSONObject.optString("textColor");
        int optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
        int optInt2 = jSONObject.optInt("y");
        Rect rect = new Rect(optInt, optInt2, jSONObject.optInt("width") + optInt, jSONObject.optInt("height") + optInt2);
        if (TextUtils.isEmpty(optString3)) {
            str2 = "#FF000000";
        } else {
            str2 = optString3;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(optString2);
        SearchUtil.i(this.mRuntime.b(), str, optString2, arrayList, str2, rect, new k(optString));
    }

    public void d0(Context context, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("mode", 0);
        boolean booleanExtra = intent.getBooleanExtra("exclude", false);
        int intExtra2 = intent.getIntExtra("number", 0);
        int intExtra3 = intent.getIntExtra("sender", 0);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[6];
            WeakReference<UiApiPlugin> weakReference = this.f238721j0;
            if (weakReference != null) {
                str = weakReference.toString();
            } else {
                str = "null";
            }
            objArr[0] = str;
            objArr[1] = Integer.valueOf(this.V);
            objArr[2] = Integer.valueOf(intExtra);
            objArr[3] = Boolean.valueOf(booleanExtra);
            objArr[4] = Integer.valueOf(intExtra2);
            objArr[5] = Integer.valueOf(intExtra3);
            QLog.d("UiApiPlugin", 2, String.format("plugin %s (mSequence: %d): onReceive , mode: %d, exclude: %b, number: %d, sender: %d", objArr));
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            if (intExtra2 > 0) {
                int i3 = this.V;
                if (intExtra3 == i3) {
                    if (!booleanExtra) {
                        a16.finish();
                        return;
                    }
                    return;
                } else {
                    if (i3 >= intExtra3 - intExtra2 && i3 < intExtra3) {
                        if (intExtra == 0 || intExtra == 2) {
                            a16.finish();
                            return;
                        }
                        return;
                    }
                    if (i3 > intExtra3 && i3 <= intExtra3 + intExtra2) {
                        if (intExtra == 0 || intExtra == 1) {
                            a16.finish();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            int i16 = this.V;
            if (intExtra3 == i16) {
                if (!booleanExtra) {
                    a16.finish();
                }
            } else {
                if (intExtra3 > i16) {
                    if (intExtra == 0 || intExtra == 2) {
                        a16.finish();
                        return;
                    }
                    return;
                }
                if (intExtra == 0 || intExtra == 1) {
                    a16.finish();
                }
            }
        }
    }

    public boolean f0(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, str, str2, str3)).booleanValue();
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals("g_appstore_myapp")) {
            QLog.d("UiApiPlugin", 1, "open troopApp manager error,TroopProxyActivity\u5df2\u5728725\u4e0b\u67b6");
            return true;
        }
        if (!TextUtils.isEmpty(str) && str.matches("\\d+")) {
            if (str2.equals("g_flower")) {
                startActivityForResult(com.tencent.mobileqq.troop.utils.am.j(this.mRuntime.a(), str, "web"), (byte) 10);
                l0(str, "exp");
                return true;
            }
            if (str2.equals("g_proceeding")) {
                return true;
            }
            if (str2.equals("g_homework")) {
                if (this.R == null) {
                    com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                    this.R = A;
                    A.p();
                }
                this.R.c0(str, str2);
                return true;
            }
            if (str2.equals("g_org")) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("mqqapi://group/openOrg?troopUin=" + str));
                intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                this.mRuntime.a().startActivity(intent);
                return true;
            }
            if (str2.equals("g_troop_reward")) {
                if (this.R == null) {
                    com.tencent.biz.troop.b A2 = com.tencent.biz.troop.b.A();
                    this.R = A2;
                    A2.p();
                }
                this.R.c0(str, str2);
                return true;
            }
            if (str2.equals("g_background")) {
                if (ea.G1(this.mRuntime.a(), this.mRuntime.b().getCurrentAccountUin())) {
                    TroopPicEffectsEditActivity.K2(this.mRuntime.a(), str, str);
                } else {
                    ea.d5(this.mRuntime.a(), this.mRuntime.b().getCurrentAccountUin());
                    Intent intent2 = new Intent(this.mRuntime.a(), (Class<?>) TroopPicEffectGuidePicActivity.class);
                    intent2.putExtra("friendUin", str);
                    intent2.putExtra("troopUin", str);
                    intent2.putExtra("isFromTroopApp", true);
                    this.mRuntime.a().startActivity(intent2);
                }
                return true;
            }
            if (!TextUtils.isEmpty(str3) && str3.startsWith("mqqapi://groupopenapp/openapp")) {
                if ("group_album".equals(str2)) {
                    str3 = str3.replace("$UNREADNUM$", "1");
                }
                Intent intent3 = new Intent(this.mRuntime.a(), (Class<?>) JumpActivity.class);
                intent3.setData(Uri.parse(str3));
                this.mRuntime.a().startActivity(intent3);
                return true;
            }
        }
        return false;
    }

    public Context getCurrentContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Context) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return SensorJsPlugin.SENSOR_INTERVAL_UI;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Long) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str)).longValue();
        }
        return 8589935390L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        CustomWebView e16;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        if (j3 == 8589934593L) {
            this.D = null;
        } else if (j3 == 8589934597L || j3 == 512) {
            callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
        } else if (j3 == 2 || j3 == 256) {
            callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
        } else if (j3 == 16) {
            this.D = null;
        } else if (j3 == 8589934601L || j3 == 8589934602L) {
            if (!TextUtils.isEmpty(this.D)) {
                callJs(this.D, "");
                return true;
            }
            HashMap<String, JsBridgeListener> hashMap = this.mOpenApiListeners;
            if (hashMap != null && hashMap.containsKey("setLeftButton")) {
                callJs4OpenApiIfNeeded("setLeftButton", 0, "");
                return true;
            }
            if (j3 == 8589934601L) {
                if (this.f238709c0 == -1) {
                    this.f238709c0 = 0;
                    Activity a16 = this.mRuntime.a();
                    if (a16 != null && (a16 instanceof QQBrowserActivity)) {
                        Intent intent = a16.getIntent();
                        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) super.getBrowserComponent(2);
                        if (vVar != null && (vVar.f314512m.f314620c & 2097152) == 0 && !intent.getBooleanExtra("show_right_close_button", false) && (((textView = (TextView) a16.findViewById(R.id.ivTitleBtnRightText)) == null || textView.getVisibility() != 0 || !a16.getString(R.string.close).equals(textView.getText())) && (vVar.f314512m.f314620c & 4) == 0)) {
                            this.f238709c0 = 1;
                        }
                    }
                }
                if (this.f238709c0 == 0) {
                    return false;
                }
                Object obj = map.get("target");
                if (!(obj instanceof Integer)) {
                    return false;
                }
                int intValue = ((Integer) obj).intValue();
                if ((intValue == 1 || intValue == 3) && (e16 = this.mRuntime.e()) != null) {
                    int currentIndex = e16.copyBackForwardList().getCurrentIndex();
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "web history current index:" + currentIndex);
                    }
                    if (currentIndex > 1) {
                        o0(true);
                    } else {
                        o0(false);
                    }
                }
            }
        } else if (j3 == 8589934600L) {
            int intValue2 = ((Integer) map.get("requestCode")).intValue();
            int intValue3 = ((Integer) map.get(QzoneIPCModule.RESULT_CODE)).intValue();
            if (intValue2 == 14) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String stringExtra = intValue3 == -1 ? ((Intent) map.get("data")).getStringExtra("data") : "";
                    if (TextUtils.isEmpty(stringExtra)) {
                        jSONObject.put("result", -2);
                        jSONObject.put("data", "");
                    } else {
                        jSONObject.put("result", 0);
                        jSONObject.put("data", stringExtra);
                    }
                    callJs(this.G, jSONObject.toString());
                } catch (Exception e17) {
                    callJs(this.G, "");
                    QLog.e("UiApiPlugin", 1, "mOpenCustomWebViewCallback call back exception e = ", e17);
                }
            } else if (intValue2 == 18) {
                Activity a17 = this.mRuntime.a();
                if (intValue3 == -1 && a17 != null && !a17.isFinishing()) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a17), null);
                    Intent intent2 = (Intent) map.get("data");
                    if (intent2 != null) {
                        m3.putExtras(new Bundle(intent2.getExtras()));
                        a17.startActivity(m3);
                    }
                    return true;
                }
            }
        } else if (j3 == 8589934615L) {
            if (!TextUtils.isEmpty(this.D)) {
                callJs(this.D, "");
                return true;
            }
        } else if (j3 == 8589934604L) {
            QLog.d("UiApiPlugin", 1, "onPostThemeChanged dispatchEvent to web");
            callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('mqqThemeChanged',true,true);d.dispatchEvent(e)}catch(err){}}(document);");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1003:0x18ee  */
    /* JADX WARN: Removed duplicated region for block: B:1202:0x1f95  */
    /* JADX WARN: Removed duplicated region for block: B:1655:0x3044 A[Catch: JSONException -> 0x12c0, TRY_LEAVE, TryCatch #58 {JSONException -> 0x12c0, blocks: (B:1653:0x303e, B:1655:0x3044), top: B:1652:0x303e }] */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0cb8  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0ccc  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        Exception exc;
        String str5;
        Exception exc2;
        String str6;
        JSONObject jSONObject;
        boolean z16;
        boolean z17;
        JSONObject jSONObject2;
        Exception exc3;
        int i3;
        JSONException jSONException;
        String str7;
        int i16;
        JSONObject jSONObject3;
        int i17;
        int i18;
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment;
        boolean z18;
        boolean z19;
        String str8;
        char c16;
        char c17;
        String str9;
        String str10;
        Exception exc4;
        String str11;
        String str12;
        String F;
        JSONObject jSONObject4;
        String optString;
        JSONObject optJSONObject;
        Exception exc5;
        int i19;
        String str13;
        char c18;
        String str14;
        String str15;
        JSONObject jSONObject5;
        Exception exc6;
        int i26;
        String str16;
        char c19;
        String str17;
        String str18;
        Exception exc7;
        String str19;
        Throwable th5;
        JSONException jSONException2;
        String str20;
        String optString2;
        String optString3;
        int i27;
        Intent troopMemberListActivityLaunchIntent;
        WebViewPluginEngine pluginEngine;
        WebViewPlugin m3;
        WebViewPluginEngine pluginEngine2;
        WebViewPlugin m16;
        String K;
        WebViewPluginEngine pluginEngine3;
        WebViewPlugin m17;
        boolean optBoolean;
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment2;
        int colorFromJSON;
        WebViewProgressBar webViewProgressBar;
        boolean z26;
        boolean optBoolean2;
        JSONObject jSONObject6;
        Exception exc8;
        JSONObject jSONObject7;
        com.tencent.mobileqq.webview.swift.component.v vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z27 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (!SensorJsPlugin.SENSOR_INTERVAL_UI.equals(str2)) {
            return false;
        }
        addOpenApiListenerIfNeeded(str3, jsBridgeListener);
        if ("openTroopMemCard".equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject8 = new JSONObject(strArr[0]);
                Activity a16 = this.mRuntime.a();
                String optString4 = jSONObject8.optString("groupUin");
                String optString5 = jSONObject8.optString("memberUin");
                String optString6 = jSONObject8.optString("from");
                String optString7 = jSONObject8.optString("callback");
                if (a16 != null && Friends.isValidUin(optString4) && Friends.isValidUin(optString5)) {
                    Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(a16, null);
                    profileCardIntentOnly.putExtra("troopUin", optString4);
                    profileCardIntentOnly.putExtra("memberUin", optString5);
                    if ("qunfee".equals(optString6)) {
                        profileCardIntentOnly.putExtra("fromFlag", 8);
                        profileCardIntentOnly.putExtra("callback", optString7);
                    }
                    startActivityForResult(profileCardIntentOnly, (byte) 9);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin.troop.troop_fee", 2, "openTroopMemCard JSONException:" + e16);
                }
            }
        } else {
            str4 = "";
            if ("openTroopFee".equals(str3) && strArr.length > 0) {
                try {
                    JSONObject jSONObject9 = new JSONObject(strArr[0]);
                    long j3 = jSONObject9.getLong("gc");
                    int i28 = jSONObject9.getInt("entranceType");
                    String string = jSONObject9.getString("feeId");
                    String optString8 = jSONObject9.optString("callback");
                    Intent troopMemberListActivityLaunchIntent2 = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(this.mRuntime.a(), j3 + "", 9);
                    troopMemberListActivityLaunchIntent2.putExtra("param_troop_fee_project_id", string);
                    troopMemberListActivityLaunchIntent2.putExtra("param_troop_fee_entrance_type", i28);
                    troopMemberListActivityLaunchIntent2.putExtra("callback", optString8);
                    startActivityForResult(troopMemberListActivityLaunchIntent2, (byte) 8);
                } catch (JSONException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin.troop.troop_fee", 2, "openTroopFee JSONException:" + e17);
                    }
                }
            } else {
                if ("showTips".equals(str3) && strArr.length > 0) {
                    F0(this.mRuntime.e().getContext(), strArr[0]);
                    return true;
                }
                if ("openGroupGiftSelectionView".equals(str3)) {
                    try {
                        String optString9 = new JSONObject(strArr[0]).optString("groupCode");
                        if (TextUtils.isEmpty(optString9)) {
                            return true;
                        }
                        Activity a17 = this.mRuntime.a();
                        Intent m18 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a17), null);
                        m18.putExtra("uin", optString9);
                        m18.putExtra("uintype", 1);
                        m18.putExtra("sendGift", true);
                        a17.startActivity(m18);
                    } catch (JSONException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "openGroupGiftSelectionView error", e18);
                        }
                    }
                } else if ("openGroupCalendarWishesView".equals(str3)) {
                    try {
                        JSONObject jSONObject10 = new JSONObject(strArr[0]);
                        String optString10 = jSONObject10.optString("groupCode");
                        if (TextUtils.isEmpty(optString10)) {
                            return true;
                        }
                        String optString11 = jSONObject10.optString("greetingsTitle", HardCodeUtil.qqStr(R.string.usr));
                        String optString12 = jSONObject10.optString("greetingsContent", " ");
                        Activity a18 = this.mRuntime.a();
                        Intent m19 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a18), null);
                        m19.putExtra("uin", optString10);
                        m19.putExtra("uintype", 1);
                        m19.putExtra("greetingsTitle", optString11);
                        m19.putExtra("greetingsContent", optString12);
                        int optInt = jSONObject10.optInt("type", 0);
                        if (optInt == 1) {
                            JSONArray optJSONArray = jSONObject10.optJSONArray("params");
                            if (optJSONArray != null) {
                                m19.putExtra("greetingsMembers", optJSONArray.toString());
                            }
                        } else if (optInt == 2) {
                            m19.putExtra("greetingsName", jSONObject10.optString("params", HardCodeUtil.qqStr(R.string.uso)));
                        }
                        m19.putExtra("types", optInt);
                        a18.startActivity(m19);
                    } catch (JSONException e19) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "openGroupCalendarWishesView error", e19);
                        }
                    }
                } else if ("showLoadingTips".equals(str3)) {
                    try {
                        String optString13 = new JSONObject(strArr[0]).optString("text");
                        if (!TextUtils.isEmpty(optString13)) {
                            this.S = com.tencent.mobileqq.maproam.a.a(this.mRuntime.a(), optString13);
                        }
                    } catch (JSONException unused) {
                    }
                } else if ("hideLoadingTips".equals(str3)) {
                    ProgressDialog progressDialog = this.S;
                    if (progressDialog != null && progressDialog.isShowing()) {
                        try {
                            this.S.dismiss();
                        } catch (Exception unused2) {
                        } catch (Throwable th6) {
                            this.S = null;
                            throw th6;
                        }
                        this.S = null;
                    }
                } else if ("openUrl".equals(str3)) {
                    if (strArr.length == 1) {
                        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).interceptUrl(this.mRuntime.a(), strArr[0])) {
                            QLog.i("UiApiPlugin", 1, "oepnUrl intercept by VasHybrid, url = " + strArr[0]);
                        } else if (jsBridgeListener.f314008c) {
                            g0(this.mRuntime.a(), this.mRuntime.e(), this.mRuntime.b(), strArr[0], true, false);
                        } else {
                            g0(this.mRuntime.a(), this.mRuntime.e(), this.mRuntime.b(), strArr[0], false, false);
                        }
                    }
                } else if ("pageVisibility".equals(str3)) {
                    if (this.mRuntime.a() instanceof AppActivity) {
                        jsBridgeListener.c(Boolean.valueOf(((AppActivity) this.mRuntime.a()).isResume()));
                    } else if (this.mRuntime.a() instanceof IActivity) {
                        jsBridgeListener.c(Boolean.valueOf(((IActivity) this.mRuntime.a()).isResume()));
                    } else if (this.mRuntime.a() == null && !com.tencent.mobileqq.intervideo.yiqikan.f.f()) {
                        jsBridgeListener.c(Boolean.valueOf(com.tencent.mobileqq.intervideo.yiqikan.g.k().m()));
                    } else {
                        jsBridgeListener.c(Boolean.FALSE);
                    }
                } else if ("setActionButton".equals(str3) && strArr.length == 1) {
                    try {
                        n0(new JSONObject(strArr[0]), jsBridgeListener, null);
                    } catch (JSONException e26) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "setActionButton error", e26);
                        }
                    }
                } else if ("setTitleButtons".equals(str3) && strArr.length == 1) {
                    try {
                        Activity a19 = this.mRuntime.a();
                        if (a19 != null && !a19.isFinishing()) {
                            JSONObject jSONObject11 = new JSONObject(strArr[0]);
                            r0(jSONObject11.optJSONObject("left"));
                            u0(jSONObject11.optJSONObject("right"), jsBridgeListener);
                            if (QLog.isColorLevel()) {
                                QLog.d("UiApiPlugin", 2, "setTitleButtons", jSONObject11.toString());
                            }
                        }
                        return true;
                    } catch (JSONException e27) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "setTitleButtons error", e27);
                        }
                    }
                } else if (IndividuationPlugin.Method_setRightButton.equals(str3) && strArr.length == 1) {
                    try {
                        Activity a26 = this.mRuntime.a();
                        if (a26 != null && !a26.isFinishing()) {
                            u0(new JSONObject(strArr[0]), jsBridgeListener);
                        }
                        return true;
                    } catch (JSONException e28) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "setRightButton error", e28);
                        }
                    }
                } else if ("setRightSecondButton".equals(str3) && strArr.length == 1) {
                    try {
                        Activity a27 = this.mRuntime.a();
                        if (a27 != null && !a27.isFinishing()) {
                            JSONObject jSONObject12 = new JSONObject(strArr[0]);
                            v0(jSONObject12.optInt("bussinessId"), jSONObject12.optBoolean("redDotShow"), jSONObject12.optBoolean(NodeProps.VISIBLE), jSONObject12.optString("callback"));
                        }
                        return true;
                    } catch (JSONException e29) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "setRightButton error", e29);
                        }
                    }
                } else if ("setLeftButton".equals(str3) && strArr.length == 1) {
                    try {
                        Activity a28 = this.mRuntime.a();
                        if (a28 != null && !a28.isFinishing()) {
                            r0(new JSONObject(strArr[0]));
                        }
                        return true;
                    } catch (JSONException e36) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "setLeftButton error", e36);
                        }
                    }
                } else if ("setDoubleRightButton".equals(str3) && strArr.length == 1) {
                    try {
                        Activity a29 = this.mRuntime.a();
                        if (a29 != null && !a29.isFinishing()) {
                            q0(new JSONObject(strArr[0]));
                        }
                        return true;
                    } catch (Exception e37) {
                        QLog.e("UiApiPlugin", 1, "setDoubleRightButton exception=" + MsfSdkUtils.getStackTraceString(e37));
                    }
                } else if ("showActionSheet".equals(str3) && strArr.length == 1) {
                    B0(strArr[0]);
                } else if ("scanQRcode".equals(str3) && strArr.length == 1) {
                    JSONObject jSONObject13 = new JSONObject(strArr[0]);
                    String optString14 = jSONObject13.optString("name");
                    this.f238724m = jSONObject13.optString("callback");
                    if (this.mRuntime.e() == null) {
                        return true;
                    }
                    String url = this.mRuntime.e().getUrl();
                    Intent putExtra = new Intent().putExtra("from", "web");
                    if (TextUtils.isEmpty(optString14) && TextUtils.isEmpty(this.f238724m)) {
                        if (this.mRuntime.a() == null) {
                            return true;
                        }
                        RouteUtils.startActivity(this.mRuntime.a(), putExtra, "/qrscan/scanner");
                    } else {
                        putExtra.putExtra("name", optString14).putExtra("callback_url", url).putExtra("scanForResult", true);
                        putExtra.setClass(this.mRuntime.a(), ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).getScannerActivityCls());
                        startActivityForResult(putExtra, (byte) 3);
                    }
                } else if ("scanForOCR".equals(str3) && strArr.length == 1) {
                    try {
                        JSONObject jSONObject14 = new JSONObject(strArr[0]);
                        String optString15 = jSONObject14.optString("name");
                        String optString16 = jSONObject14.optString("src");
                        String optString17 = jSONObject14.optString("type");
                        this.C = jSONObject14.optString("callback");
                        if (this.mRuntime.e() == null) {
                            return true;
                        }
                        String url2 = this.mRuntime.e().getUrl();
                        Intent addFlags = new Intent(this.mRuntime.a(), (Class<?>) ScanOcrActivity.class).putExtra("ocr_from_where", 4).addFlags(67108864);
                        if (TextUtils.isEmpty(optString15) && TextUtils.isEmpty(this.C)) {
                            if (this.mRuntime.a() == null) {
                                return true;
                            }
                            this.mRuntime.a().startActivity(addFlags);
                        } else {
                            addFlags.putExtra("name", optString15).putExtra("type", optString17).putExtra("src", optString16).putExtra("callback_url", url2).putExtra("scanForResult", true);
                            startActivityForResult(addFlags, (byte) 17);
                        }
                    } catch (JSONException e38) {
                        QLog.e("UiApiPlugin", 1, "scanForOCR error: " + e38.getMessage());
                    }
                } else if ("setOnAddShortcutHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString18 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
                        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d16).getShare()).f97470w0 = optString18;
                        }
                        if (!TextUtils.isEmpty(optString18) && (vVar = (com.tencent.mobileqq.webview.swift.component.v) getBrowserComponent(2)) != null) {
                            vVar.P();
                        }
                    } catch (JSONException e39) {
                        e39.printStackTrace();
                    }
                } else if ("setOnCloseHandler".equals(str3) && strArr.length == 1) {
                    try {
                        this.D = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar2 = this.mRuntime;
                        CustomWebView e46 = bVar2 != null ? bVar2.e() : null;
                        if (e46 != null) {
                            SwiftBrowserStatistics.P("ui.setOnCloseHandler", e46.getUrl());
                        }
                    } catch (JSONException e47) {
                        e47.printStackTrace();
                    }
                } else if ("setOnShareHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString19 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar3 = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d17 = bVar3.d(bVar3.a());
                        if (d17 != null && (d17 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d17).getShare()).b0(optString19);
                        } else {
                            N().i(optString19);
                        }
                    } catch (JSONException e48) {
                        e48.printStackTrace();
                    }
                } else if ("setOnShareQQFriendHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString20 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar4 = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d18 = bVar4.d(bVar4.a());
                        if (d18 != null && (d18 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d18).getShare()).f97465r0 = optString20;
                        } else {
                            N().j(optString20);
                        }
                    } catch (JSONException e49) {
                        e49.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005866", "0X8005866", 0, 0, "", "", "", "");
                } else if ("setOnShareQQSpecifiedFriendHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString21 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar5 = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d19 = bVar5.d(bVar5.a());
                        if (d19 != null && (d19 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d19).getShare()).f97466s0 = optString21;
                        } else {
                            N().k(optString21);
                        }
                    } catch (JSONException e56) {
                        e56.printStackTrace();
                    }
                } else if ("setOnShareQZoneHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString22 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar6 = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d26 = bVar6.d(bVar6.a());
                        if (d26 != null && (d26 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d26).getShare()).f97467t0 = optString22;
                        } else {
                            N().l(optString22);
                        }
                    } catch (JSONException e57) {
                        e57.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005867", "0X8005867", 0, 0, "", "", "", "");
                } else if ("setOnShareWXFriendHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString23 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar7 = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d27 = bVar7.d(bVar7.a());
                        if (d27 != null && (d27 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d27).getShare()).f97468u0 = optString23;
                        } else {
                            N().m(optString23);
                        }
                    } catch (JSONException e58) {
                        e58.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005865", "0X8005865", 0, 0, "", "", "", "");
                } else if ("setOnShareWXTimelineHandler".equals(str3) && strArr.length == 1) {
                    try {
                        String optString24 = new JSONObject(strArr[0]).optString("callback");
                        WebViewPlugin.b bVar8 = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d28 = bVar8.d(bVar8.a());
                        if (d28 != null && (d28 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                            ((Share) ((com.tencent.mobileqq.webviewplugin.n) d28).getShare()).f97469v0 = optString24;
                        } else {
                            N().n(optString24);
                        }
                    } catch (JSONException e59) {
                        e59.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005864", "0X8005864", 0, 0, "", "", "", "");
                } else if ("showDialog".equals(str3) && strArr.length == 1) {
                    try {
                        JSONObject jSONObject15 = new JSONObject(strArr[0]);
                        String optString25 = jSONObject15.optString("callback");
                        n nVar = new n(optString25);
                        C0(this.mRuntime.a(), jSONObject15, nVar, nVar, new o(optString25));
                        return true;
                    } catch (JSONException e65) {
                        e65.printStackTrace();
                    }
                } else if ("showHalfScreenNotice".equals(str3) && strArr.length == 1) {
                    QLog.i("UiApiPlugin", 1, "invoke showHalfScreenNotice");
                    try {
                        JSONObject jSONObject16 = new JSONObject(strArr[0]);
                        ((IFeedStandardDialogApi) QRoute.api(IFeedStandardDialogApi.class)).showFeedStandardDialog(this.mRuntime.a(), jSONObject16.optString("text"), jSONObject16.optString("title"), new p(jSONObject16.optString("callback")));
                        return true;
                    } catch (JSONException e66) {
                        QLog.i("UiApiPlugin", 1, "showHalfScreenNotice exception:" + e66);
                    }
                } else if ("openSpecialView".equals(str3) && strArr.length == 1) {
                    try {
                        JSONObject jSONObject17 = new JSONObject(strArr[0]);
                        String optString26 = jSONObject17.optString("viewName");
                        JSONObject optJSONObject2 = jSONObject17.optJSONObject("param");
                        if ("groupFile".equals(optString26)) {
                            String optString27 = optJSONObject2.optString("groupUin");
                            if (Friends.isValidUin(optString27)) {
                                Intent intent = new Intent();
                                intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, optString27);
                                ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(this.mRuntime.a(), intent, 0);
                                jsBridgeListener.c(" { retcode: 0, msg: 'ok' }");
                            } else {
                                jsBridgeListener.c(" { retcode: -1, msg: 'error' }");
                            }
                        } else if ("groupPhoto".equals(optString26)) {
                            String optString28 = optJSONObject2.optString("groupUin");
                            if (Friends.isValidUin(optString28)) {
                                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                                userInfo.qzone_uin = this.mRuntime.b().getCurrentAccountUin();
                                QZoneHelper.forwardToQunFeed(this.mRuntime.a(), userInfo, optString28, null, false, 0);
                                jsBridgeListener.c(" { retcode: 0, msg: 'ok' }");
                            } else {
                                jsBridgeListener.c(" { retcode: -1, msg: 'error' }");
                            }
                        } else if ("troopLowCreditNotify".equals(optString26)) {
                            Activity a36 = this.mRuntime.a();
                            String optString29 = optJSONObject2.optString("groupUin");
                            if (a36 != null && Friends.isValidUin(optString29)) {
                                Intent intent2 = new Intent(a36, (Class<?>) TroopLowCreditLevelNotifyActivity.class);
                                intent2.putExtra("troopUin", optString29);
                                a36.startActivity(intent2);
                                a36.finish();
                            }
                        } else if ("troopMemberCard".equals(optString26)) {
                            Activity a37 = this.mRuntime.a();
                            String optString30 = optJSONObject2.optString("groupUin");
                            String optString31 = optJSONObject2.optString("memberUin");
                            if (a37 != null && Friends.isValidUin(optString30) && Friends.isValidUin(optString31)) {
                                Intent profileCardIntentOnly2 = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(a37, null);
                                profileCardIntentOnly2.putExtra("troopUin", optString30);
                                profileCardIntentOnly2.putExtra("memberUin", optString31);
                                a37.startActivity(profileCardIntentOnly2);
                            }
                        }
                    } catch (JSONException e67) {
                        e67.printStackTrace();
                        jsBridgeListener.c(" { retcode: -1, msg: 'error' }");
                    } catch (Exception e68) {
                        e68.printStackTrace();
                        jsBridgeListener.c(" { retcode: -1, msg: 'error' }");
                    }
                } else {
                    if ("openView".equals(str3) && strArr.length == 1) {
                        this.E = "";
                        try {
                            jSONObject6 = new JSONObject(strArr[0]);
                        } catch (JSONException unused3) {
                            jSONObject6 = null;
                        }
                        if (jSONObject6 != null) {
                            try {
                                Activity a38 = this.mRuntime.a();
                                String optString32 = jSONObject6.optString("viewType", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                                String optString33 = jSONObject6.optString("name");
                                String optString34 = jSONObject6.optString("options");
                                String optString35 = jSONObject6.optString("onclose");
                                String optString36 = jSONObject6.optString("callback");
                                int optInt2 = jSONObject6.optInt("animation", -1);
                                try {
                                    jSONObject7 = new JSONObject(optString34);
                                } catch (JSONException unused4) {
                                    jSONObject7 = new JSONObject();
                                }
                                try {
                                    CustomWebView e69 = this.mRuntime.e();
                                    if (e69 != null) {
                                        jSONObject7.put(ISchemeApi.KEY_REFERER, e69.getUrl());
                                    }
                                } catch (JSONException unused5) {
                                }
                                if ("popWindow".equals(optString32)) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("options", jSONObject7.toString());
                                    bundle.putString("onclose", optString35);
                                    if ("com.tencent.mobileqq.troop.activity.PublicCommentActivity".equals(optString33)) {
                                        new PublicCommentWindow((QBaseActivity) a38, bundle).U(a38);
                                    } else if ("com.tencent.mobileqq.troop.activity.TroopBarCommentActivity".equals(optString33)) {
                                        new com.tencent.mobileqq.troop.activity.j((QBaseActivity) a38, bundle).U(a38);
                                    }
                                } else if (WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY.equals(optString32)) {
                                    Intent intent3 = new Intent();
                                    if ("cooperation.comic.VipComicJumpActivity".equals(optString33)) {
                                        intent3.setComponent(new ComponentName(getCurrentContext(), "com.tencent.comic.VipComicJumpActivity"));
                                        intent3.putExtra("click_start_time", System.currentTimeMillis());
                                    } else if ("cooperation.qqindividuality.QQIndividualityBridgeActivity".equals(optString33)) {
                                        intent3.setComponent(new ComponentName(a38, optString33));
                                        intent3.putExtra("k_source", 0);
                                        intent3.putExtra("startOpenPageTime", System.currentTimeMillis());
                                        intent3.putExtra(cooperation.qqindividuality.b.f390742j, 1);
                                        intent3.putExtra(cooperation.qqindividuality.b.f390735c, "path");
                                        intent3.putExtra(cooperation.qqindividuality.b.f390736d, "name");
                                    } else if ("com.tencent.mobileqq.activity.AuthDevOpenUgActivity".equals(optString33)) {
                                        intent3.setComponent(new ComponentName(a38, optString33));
                                        intent3.putExtra(AuthDevOpenUgActivity.H5_CALL_ME, "true");
                                    } else {
                                        intent3.setComponent(new ComponentName(a38, optString33));
                                    }
                                    intent3.putExtra("options", jSONObject7.toString());
                                    this.E = optString35;
                                    try {
                                        if (TextUtils.isEmpty(optString35)) {
                                            a38.startActivity(intent3);
                                        } else {
                                            startActivityForResult(intent3, (byte) 4);
                                            if (!TextUtils.isEmpty(optString36)) {
                                                callJs(optString36, "0");
                                            }
                                        }
                                        if (optInt2 == 1) {
                                            a38.overridePendingTransition(0, 0);
                                        } else if (optInt2 == 1001) {
                                            a38.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
                                        }
                                        if (PoiMapActivity.class.getName().equals(optString33)) {
                                            if (this.R == null) {
                                                com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                                                this.R = A;
                                                A.p();
                                            }
                                            this.R.j0();
                                        }
                                    } catch (Exception e75) {
                                        exc8 = e75;
                                        str4 = optString36;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (!TextUtils.isEmpty(str4)) {
                                        }
                                        return true;
                                    }
                                } else if ("activityWrapper".equals(optString32) && optString33.equals("com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity")) {
                                    jSONObject7.optInt("openSource", 0);
                                }
                            } catch (Exception e76) {
                                exc8 = e76;
                                if (QLog.isColorLevel()) {
                                    QLog.d("UiApiPlugin", 2, " openView startActivity failed");
                                    QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(exc8));
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    callJs(str4, "-1");
                                }
                                return true;
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "UiApiPlugin openView error, json is NULL-----");
                        }
                    } else if ("setWebViewBehavior".equals(str3) && strArr.length == 1) {
                        try {
                            JSONObject jSONObject18 = new JSONObject(strArr[0]);
                            Activity a39 = this.mRuntime.a();
                            if (!(a39 instanceof QQBrowserActivity)) {
                                return true;
                            }
                            WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
                            com.tencent.mobileqq.webview.swift.component.v vVar2 = (com.tencent.mobileqq.webview.swift.component.v) super.getBrowserComponent(2);
                            if (webViewFragment != null && vVar2 != null) {
                                if (jSONObject18.has("nightModeMaskViewHide")) {
                                    s0(jSONObject18);
                                }
                                if (jSONObject18.has("webPageBackgroundColor") && jSONObject18.has("webPageBackgroundColorOpen") && jSONObject18.optBoolean("webPageBackgroundColorOpen")) {
                                    int colorFromJSON2 = jSONObject18.has("webPageBackgroundAlpha") ? getColorFromJSON(jSONObject18, "webPageBackgroundAlpha") << 24 : -16777216;
                                    int colorFromJSON3 = getColorFromJSON(jSONObject18, "webPageBackgroundColor");
                                    vVar2.f314502d0 = colorFromJSON2 | colorFromJSON3;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "setWebViewBehavior [webPageBackground] mergedColor=#" + Integer.toHexString(colorFromJSON3));
                                    }
                                }
                                if (jSONObject18.has("progressBar") && !(optBoolean2 = jSONObject18.optBoolean("progressBar"))) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("UiApiPlugin", 2, "setWebViewBehavior progressBar visible: " + optBoolean2);
                                    }
                                    vVar2.U.l(false);
                                }
                                if (jSONObject18.has("actionButton")) {
                                    int i29 = jSONObject18.getInt("actionButton");
                                    TextView textView = (TextView) a39.findViewById(R.id.ivTitleBtnRightText);
                                    ImageView imageView = (ImageView) a39.findViewById(R.id.ivTitleBtnRightImage);
                                    if (textView != null && imageView != null) {
                                        if (i29 == 1) {
                                            if (imageView.getDrawable() != null) {
                                                imageView.setVisibility(0);
                                                textView.setVisibility(8);
                                            } else {
                                                imageView.setVisibility(8);
                                                textView.setVisibility(0);
                                            }
                                        } else {
                                            textView.setVisibility(8);
                                            imageView.setVisibility(8);
                                        }
                                    }
                                }
                                if (jSONObject18.has("swipeBack")) {
                                    jSONObject18.getInt("swipeBack");
                                }
                                if (jSONObject18.has("disable_elem_name") && jSONObject18.has("disable_elem_left") && jSONObject18.has("disable_elem_top") && jSONObject18.has("disable_elem_right") && jSONObject18.has("disable_elem_bottom")) {
                                    jSONObject18.getString("disable_elem_name");
                                    jSONObject18.getInt("disable_elem_left");
                                    jSONObject18.getInt("disable_elem_top");
                                    jSONObject18.getInt("disable_elem_right");
                                    jSONObject18.getInt("disable_elem_bottom");
                                }
                                if (jSONObject18.has("enable_elem_name")) {
                                    jSONObject18.getString("enable_elem_name");
                                }
                                if (!vVar2.f314512m.f314618a && jSONObject18.has("navBgColor")) {
                                    int colorFromJSON4 = getColorFromJSON(jSONObject18, "navBgColor");
                                    View findViewById = a39.findViewById(R.id.rlCommenTitle);
                                    if (findViewById != null) {
                                        if (i0() != null) {
                                            webViewProgressBar = i0().t9();
                                        } else {
                                            webViewProgressBar = vVar2.T;
                                        }
                                        if (colorFromJSON4 == -1) {
                                            int paddingTop = findViewById.getPaddingTop();
                                            int paddingBottom = findViewById.getPaddingBottom();
                                            int paddingLeft = findViewById.getPaddingLeft();
                                            int paddingRight = findViewById.getPaddingRight();
                                            findViewById.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
                                            findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                            if (webViewProgressBar != null) {
                                                webViewProgressBar.a();
                                            }
                                            if (webViewFragment.getWebTitleBarInterface().a3() != null) {
                                                if (vVar2.f314512m.f314618a) {
                                                    webViewFragment.getWebTitleBarInterface().a3().setVisibility(4);
                                                    z26 = false;
                                                } else {
                                                    webViewFragment.getWebTitleBarInterface().a3().setBackgroundResource(R.drawable.qui_bg_nav_secondary);
                                                    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
                                                        SimpleUIUtil.adjustColorForQQBrowserActivity(false, BaseApplicationImpl.getApplication().getResources().getColor(R.color.skin_color_title_immersive_bar), this.mRuntime.a().getWindow());
                                                    }
                                                    z26 = false;
                                                    webViewFragment.getWebTitleBarInterface().a3().setVisibility(0);
                                                }
                                                vVar2.f314512m.f314637t = z26;
                                            }
                                        } else {
                                            int colorFromJSON5 = jSONObject18.has("navBgColorAlpha") ? getColorFromJSON(jSONObject18, "navBgColorAlpha") << 24 : -16777216;
                                            int i36 = colorFromJSON4 | colorFromJSON5;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("UiApiPlugin", 2, "setWebViewBehavior, navBgColorAlpha=" + Integer.toHexString(colorFromJSON5) + ", navBgColor=" + Integer.toHexString(colorFromJSON4) + ", mergedColor=" + Integer.toHexString(i36));
                                            }
                                            findViewById.setBackgroundColor(i36);
                                            if (webViewProgressBar != null) {
                                                webViewProgressBar.setCustomColor(colorFromJSON4 | (-16777216));
                                            }
                                            if (!vVar2.f314512m.f314618a) {
                                                if (webViewFragment.getWebTitleBarInterface().a3() == null) {
                                                    webViewFragment.getWebTitleBarInterface().u6(true);
                                                    webViewFragment.getWebTitleBarInterface().Pg(true);
                                                    webViewFragment.getWebTitleBarInterface().Ad(false);
                                                } else {
                                                    webViewFragment.getWebTitleBarInterface().a3().setVisibility(0);
                                                }
                                            }
                                            if (webViewFragment.getWebTitleBarInterface().a3() != null) {
                                                if (jSONObject18.has("statusBarColor")) {
                                                    i36 = getColorFromJSON(jSONObject18, "statusBarColor");
                                                    if (i36 != 0 && ((i36 >>> 24) & 255) == 0) {
                                                        i36 |= -16777216;
                                                    }
                                                } else {
                                                    vVar2.f314512m.f314637t = true;
                                                }
                                                webViewFragment.getWebTitleBarInterface().a3().setBackgroundColor(i36);
                                                if (jSONObject18.has("statusTextColorLight")) {
                                                    SimpleUIUtil.adjustColorForQQBrowserActivity(jSONObject18.optInt("statusTextColorLight") == 1, this.mRuntime.a().getWindow());
                                                } else {
                                                    SimpleUIUtil.adjustColorForQQBrowserActivity(U(i36), this.mRuntime.a().getWindow());
                                                }
                                            }
                                        }
                                    }
                                }
                                boolean z28 = 1 == jSONObject18.optInt("navIconUseDefault", -1);
                                if (vVar2.f314512m.O != z28) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("UiApiPlugin", 2, "setWebViewBehavior useDefaultTheme changed to: " + z28);
                                    }
                                    vVar2.f314512m.O = z28;
                                    int i37 = this.f238728p0;
                                    if (i37 != 0) {
                                        com.tencent.mobileqq.webview.swift.utils.o.d(vVar2.C.E, 1, i37, z28);
                                    }
                                    int i38 = this.f238727o0;
                                    if (i38 != 0) {
                                        com.tencent.mobileqq.webview.swift.utils.o.d(this.f238725m0, 1, i38, z28);
                                    }
                                    com.tencent.mobileqq.webview.swift.utils.o.d(vVar2.C.f314054i, 2, com.tencent.mobileqq.webview.swift.utils.n.token_icon_navLeftBack, z28);
                                }
                                if (jSONObject18.has("navTextColor")) {
                                    int colorFromJSON6 = getColorFromJSON(jSONObject18, "navTextColor");
                                    if (colorFromJSON6 == -1) {
                                        vVar2.C.w();
                                    } else {
                                        int i39 = colorFromJSON6 | (-16777216);
                                        vVar2.C.W(i39);
                                        if (jSONObject18.has("navButtonColor") && (colorFromJSON = getColorFromJSON(jSONObject18, "navButtonColor")) != -1) {
                                            i39 = colorFromJSON | (-16777216);
                                        }
                                        vVar2.C.S(i39);
                                        w0(i39);
                                    }
                                }
                                if (jSONObject18.has("bottomBar")) {
                                    jSONObject18.getBoolean("bottomBar");
                                }
                                if (jSONObject18.has("historyBack")) {
                                    if (jSONObject18.getBoolean("historyBack")) {
                                        vVar2.f314512m.f314620c &= -5;
                                    } else {
                                        vVar2.f314512m.f314620c |= 4;
                                    }
                                }
                                if (jSONObject18.has("titleText")) {
                                    ((QQBrowserActivity) a39).setTitle(jSONObject18.optString("titleText"));
                                }
                                if (jSONObject18.has("titleBarHide")) {
                                    P(jSONObject18.optBoolean("titleBarHide"), jSONObject18.has("titleBarHideDuration") ? (int) (jSONObject18.optDouble("titleBarHideDuration") * 1000.0d) : 800);
                                }
                                if (jSONObject18.has("orientation")) {
                                    int optInt3 = jSONObject18.optInt("orientation");
                                    boolean z29 = jSONObject18.optInt("disablePadCompact", 0) == 1;
                                    if (!AppSetting.o(BaseApplication.getContext()) || z29) {
                                        if (optInt3 == 0) {
                                            com.tencent.mobileqq.webview.swift.r rVar = vVar2.f314512m;
                                            rVar.f314629l = false;
                                            rVar.f314634q = Boolean.TRUE;
                                        } else if (optInt3 == 1) {
                                            com.tencent.mobileqq.webview.swift.r rVar2 = vVar2.f314512m;
                                            rVar2.f314629l = true;
                                            rVar2.f314634q = Boolean.FALSE;
                                        }
                                        vVar2.f0();
                                    }
                                }
                                if (jSONObject18.has("restoreOrientation") && jSONObject18.optInt("restoreOrientation") == 1) {
                                    vVar2.N();
                                }
                                if (jSONObject18.has("supportOrientation") && jSONObject18.optInt("supportOrientation") == 1) {
                                    vVar2.c0();
                                }
                                if (jSONObject18.has("docNavBarHide")) {
                                    int optInt4 = jSONObject18.optInt("docNavBarHide");
                                    Activity a46 = this.mRuntime.a();
                                    if (a46 != null && (a46 instanceof TeamWorkDocEditBrowserActivity) && (teamWorkDocEditBrowserFragment2 = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) ((TeamWorkDocEditBrowserActivity) a39).getCurrentWebViewFragment()) != null) {
                                        if (optInt4 == 1) {
                                            teamWorkDocEditBrowserFragment2.Sh();
                                        } else if (optInt4 == 0) {
                                            teamWorkDocEditBrowserFragment2.wi();
                                        }
                                    }
                                }
                                if (jSONObject18.has("hideFloatingShare")) {
                                    vVar2.V(jSONObject18.optBoolean("hideFloatingShare", false));
                                }
                                if (jSONObject18.has("showCloseButton") && vVar2.C.f314047e.f314640w != (optBoolean = jSONObject18.optBoolean("showCloseButton", false))) {
                                    vVar2.Y(optBoolean);
                                }
                                if (jSONObject18.has(ReportConst.ACTION.FULLSCREEN)) {
                                    if (jSONObject18.optBoolean(ReportConst.ACTION.FULLSCREEN, false)) {
                                        if (!vVar2.f314512m.f314618a) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("UiApiPlugin", 4, "enter fullscreen");
                                            }
                                            vVar2.f314512m.f314618a = true;
                                            this.mRuntime.a().getWindow().setFlags(1024, 1024);
                                            com.tencent.mobileqq.webview.swift.an.e(webViewFragment.getActivity());
                                            webViewFragment.getWebTitleBarInterface().u5(false);
                                        }
                                    } else if (vVar2.f314512m.f314618a) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("UiApiPlugin", 4, "exit fullscreen");
                                        }
                                        vVar2.f314512m.f314618a = false;
                                        this.mRuntime.a().getWindow().clearFlags(1024);
                                        com.tencent.mobileqq.webview.swift.an.f(webViewFragment.getActivity());
                                        webViewFragment.getWebTitleBarInterface().u5(true);
                                    }
                                }
                            }
                            return true;
                        } catch (JSONException e77) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("UiApiPlugin", 4, "setWebViewBehavior failed:" + e77);
                            }
                        } catch (Exception e78) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("UiApiPlugin", 4, "setWebViewBehavior failed:" + e78);
                            }
                        }
                    } else {
                        String str21 = "url";
                        if ("setBottomBarInit".equals(str3) && strArr.length <= 1) {
                            try {
                                JSONObject jSONObject19 = new JSONObject(strArr[0]);
                                if (!(this.mRuntime.a() instanceof QQBrowserActivity)) {
                                    return true;
                                }
                                z.h hVar = new z.h();
                                if (jSONObject19.has("backColor")) {
                                    hVar.f97682a = getColorFromJSON(jSONObject19, "backColor") | (-16777216);
                                }
                                if (jSONObject19.has("callback")) {
                                    hVar.f97683b = jSONObject19.getString("callback");
                                }
                                if (jSONObject19.has("buttons")) {
                                    hVar.f97684c = new ArrayList();
                                    JSONArray optJSONArray2 = jSONObject19.optJSONArray("buttons");
                                    int length = optJSONArray2.length();
                                    for (int i46 = 0; i46 < length; i46++) {
                                        JSONObject jSONObject20 = optJSONArray2.getJSONObject(i46);
                                        z.g gVar = new z.g();
                                        if (jSONObject20.has("text")) {
                                            gVar.f97680c = jSONObject20.getString("text");
                                        }
                                        if (jSONObject20.has("id")) {
                                            gVar.f97678a = jSONObject20.getInt("id");
                                        }
                                        if (jSONObject20.has("icon")) {
                                            gVar.f97679b = jSONObject20.getString("icon");
                                        }
                                        if (jSONObject20.has("textColor")) {
                                            gVar.f97681d = getColorFromJSON(jSONObject20, "textColor") | (-16777216);
                                        }
                                        hVar.f97684c.add(gVar);
                                    }
                                }
                                if (jSONObject19.has("preIcons")) {
                                    hVar.f97685d = new ArrayList();
                                    JSONArray optJSONArray3 = jSONObject19.optJSONArray("preIcons");
                                    int length2 = optJSONArray3.length();
                                    for (int i47 = 0; i47 < length2; i47++) {
                                        if (optJSONArray3.getJSONObject(i47).has("url")) {
                                            hVar.f97685d.add(optJSONArray3.getJSONObject(i47).getString("url"));
                                        }
                                    }
                                }
                                CustomWebView e79 = this.mRuntime.e();
                                com.tencent.biz.webviewplugin.z zVar = (e79 == null || (pluginEngine3 = e79.getPluginEngine()) == null || (m17 = pluginEngine3.m("pubAccountUI")) == null || !(m17 instanceof com.tencent.biz.webviewplugin.z)) ? null : (com.tencent.biz.webviewplugin.z) m17;
                                if (zVar != null) {
                                    zVar.x(hVar);
                                    if (hVar.f97683b != null && (K = K(zVar)) != null) {
                                        callJs(hVar.f97683b, K);
                                    }
                                }
                            } catch (JSONException e85) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "setBottomBarInit failed:" + e85);
                                }
                            }
                        } else if ("setBottomBarShow".equals(str3) && strArr.length <= 1) {
                            try {
                                JSONObject jSONObject21 = new JSONObject(strArr[0]);
                                if ((this.mRuntime.a() instanceof QQBrowserActivity) && jSONObject21.has("show")) {
                                    boolean optBoolean3 = jSONObject21.optBoolean("show");
                                    int optDouble = jSONObject21.has("transition") ? (int) (jSONObject21.optDouble("transition") * 1000.0d) : 0;
                                    CustomWebView e86 = this.mRuntime.e();
                                    com.tencent.biz.webviewplugin.z zVar2 = (e86 == null || (pluginEngine2 = e86.getPluginEngine()) == null || (m16 = pluginEngine2.m("pubAccountUI")) == null || !(m16 instanceof com.tencent.biz.webviewplugin.z)) ? null : (com.tencent.biz.webviewplugin.z) m16;
                                    if (zVar2 != null) {
                                        zVar2.y(optBoolean3, optDouble);
                                    }
                                }
                            } catch (JSONException e87) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "setBottomBarShow failed:" + e87);
                                }
                            }
                        } else if ("setBottomBarChangeButton".equals(str3) && strArr.length <= 1) {
                            try {
                                JSONObject jSONObject22 = new JSONObject(strArr[0]);
                                if (!(this.mRuntime.a() instanceof QQBrowserActivity)) {
                                    return true;
                                }
                                z.g gVar2 = new z.g();
                                if (jSONObject22.has("text")) {
                                    gVar2.f97680c = jSONObject22.getString("text");
                                }
                                if (jSONObject22.has("id")) {
                                    gVar2.f97678a = jSONObject22.getInt("id");
                                }
                                if (jSONObject22.has("icon")) {
                                    gVar2.f97679b = jSONObject22.getString("icon");
                                }
                                if (jSONObject22.has("textColor")) {
                                    gVar2.f97681d = getColorFromJSON(jSONObject22, "textColor") | (-16777216);
                                }
                                CustomWebView e88 = this.mRuntime.e();
                                com.tencent.biz.webviewplugin.z zVar3 = (e88 == null || (pluginEngine = e88.getPluginEngine()) == null || (m3 = pluginEngine.m("pubAccountUI")) == null || !(m3 instanceof com.tencent.biz.webviewplugin.z)) ? null : (com.tencent.biz.webviewplugin.z) m3;
                                if (zVar3 != null) {
                                    zVar3.z(gVar2);
                                }
                            } catch (JSONException e89) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "setBottomBarChangeButton failed:" + e89);
                                }
                            }
                        } else if (com.tencent.luggage.wxa.gg.c.NAME.equals(str3) && strArr.length <= 1) {
                            try {
                                if (strArr.length == 1) {
                                    new JSONObject(strArr[0]).optInt("hiddenItems", 0);
                                }
                                WebViewPlugin.b bVar9 = this.mRuntime;
                                com.tencent.mobileqq.webview.swift.y d29 = bVar9.d(bVar9.a());
                                if (d29 != null && (d29 instanceof com.tencent.mobileqq.webviewplugin.r)) {
                                    ((com.tencent.mobileqq.webviewplugin.r) d29).showActionSheet();
                                } else if (L() != null) {
                                    L().p();
                                }
                            } catch (JSONException e95) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "showShareMenu failed:" + e95);
                                }
                            }
                        } else if ("closeWebViews".equals(str3) && strArr.length == 1) {
                            try {
                                JSONObject jSONObject23 = new JSONObject(strArr[0]);
                                int optInt5 = jSONObject23.optInt("mode", 0);
                                int optInt6 = jSONObject23.optInt("number", 0);
                                boolean optBoolean4 = jSONObject23.optBoolean("exclude", false);
                                if (QLog.isColorLevel()) {
                                    QLog.d("UiApiPlugin", 2, "sendBroadcast, data: " + jSONObject23.toString() + ", from reference: " + this.f238721j0.toString());
                                }
                                BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE").putExtra("mode", optInt5).putExtra("exclude", optBoolean4).putExtra("number", optInt6).putExtra("sender", this.V), "com.tencent.msg.permission.pushnotify");
                            } catch (JSONException e96) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "closeWebViews failed:" + e96);
                                }
                            }
                        } else if ("selectContact".equals(str3) && strArr.length == 1) {
                            try {
                                this.F = null;
                                JSONObject jSONObject24 = new JSONObject(strArr[0]);
                                long j16 = jSONObject24.getLong("appid");
                                int optInt7 = jSONObject24.optInt("acceptType", 13);
                                int optInt8 = jSONObject24.optInt("openAIOForPtt", 0);
                                String string2 = jSONObject24.getString("callback");
                                AppInterface b16 = this.mRuntime.b();
                                if (b16 != null && b16.isLogin()) {
                                    String optString37 = jSONObject24.optString("uin");
                                    if (!TextUtils.isEmpty(optString37) && !optString37.equals(b16.getAccount())) {
                                        callJs(string2, "{\"ret\":1}");
                                        return true;
                                    }
                                    Activity a47 = this.mRuntime.a();
                                    if (a47 != null) {
                                        this.F = string2;
                                        Intent intent4 = new Intent(a47, (Class<?>) ForwardRecentActivity.class);
                                        intent4.putExtra("forward_type", 16);
                                        intent4.putExtra("acceptType", optInt7);
                                        intent4.putExtra("appid", j16);
                                        intent4.putExtra("openAIOForPtt", optInt8);
                                        startActivityForResult(intent4, (byte) 5);
                                    }
                                }
                                callJs(string2, "{\"ret\":1, \"errMsg\":\"not login\"}");
                                return true;
                            } catch (JSONException e97) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "selectContact failed:" + e97);
                                }
                            }
                        } else if ("getMemberList".equals(str3) && strArr.length == 1) {
                            try {
                                this.E = null;
                                JSONObject jSONObject25 = new JSONObject(strArr[0]);
                                this.J = jSONObject25.getString("uin");
                                int optInt9 = jSONObject25.optInt("uinType", 0);
                                this.K = jSONObject25.optBoolean("selectMore", false);
                                String string3 = jSONObject25.getString("callback");
                                AppInterface b17 = this.mRuntime.b();
                                if (b17 != null && b17.isLogin()) {
                                    Activity a48 = this.mRuntime.a();
                                    if (a48 != null && optInt9 == 0) {
                                        String optString38 = jSONObject25.optString("title", a48.getString(R.string.erb));
                                        this.E = string3;
                                        if (this.K) {
                                            troopMemberListActivityLaunchIntent = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(a48);
                                            troopMemberListActivityLaunchIntent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
                                            troopMemberListActivityLaunchIntent.putExtra("group_uin", this.J);
                                            troopMemberListActivityLaunchIntent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, optString38);
                                            startActivityForResult(troopMemberListActivityLaunchIntent, (byte) 7);
                                            a48.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
                                        } else {
                                            troopMemberListActivityLaunchIntent = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(a48, this.J, 14);
                                            troopMemberListActivityLaunchIntent.putExtra("custom_title_name", optString38);
                                        }
                                        startActivityForResult(troopMemberListActivityLaunchIntent, (byte) 7);
                                        a48.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
                                    }
                                }
                                callJs(string3, "{\"ret\":2, \"errMsg\":\"not login\"}");
                                return true;
                            } catch (JSONException e98) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "selectMember failed:" + e98);
                                }
                            }
                        } else if ("webviewCanScroll".equals(str3) && strArr.length == 1) {
                            try {
                                JSONObject jSONObject26 = new JSONObject(strArr[0]);
                                if (jSONObject26.has("enable")) {
                                    boolean z36 = jSONObject26.getBoolean("enable");
                                    View view = (View) this.mRuntime.e().getParent();
                                    if (view == null || !(view instanceof RefreshView)) {
                                        return true;
                                    }
                                    RefreshView refreshView = (RefreshView) view;
                                    this.f238715f0 = refreshView;
                                    refreshView.a(z36);
                                }
                            } catch (JSONException e99) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("UiApiPlugin", 4, "setPullDown failed:" + e99);
                                }
                            }
                        } else {
                            if ("switchToMsgList".equals(str3)) {
                                try {
                                    if (strArr.length == 1) {
                                        try {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("UiApiPlugin", 1, "WebViewSwitchAio js switchToMsgList is called :" + strArr[0]);
                                            }
                                            JSONObject jSONObject27 = new JSONObject(strArr[0]);
                                            optString2 = jSONObject27.optString("title");
                                            optString3 = jSONObject27.optString("icon");
                                            str20 = jSONObject27.optString("callback");
                                        } catch (JSONException e100) {
                                            jSONException2 = e100;
                                            str20 = null;
                                        } catch (Throwable th7) {
                                            th5 = th7;
                                            str21 = null;
                                            if (!TextUtils.isEmpty(str21)) {
                                                callJs(str21, "{'retcode' : 1}");
                                                throw th5;
                                            }
                                            throw th5;
                                        }
                                        try {
                                            if (optString2.length() > 0) {
                                                WebViewFragment webViewFragment2 = (WebViewFragment) this.mRuntime.f();
                                                if (webViewFragment2 != null && webViewFragment2.getUIStyle() != null) {
                                                    if (webViewFragment2.getUIStyle().V) {
                                                        com.tencent.mobileqq.webview.swift.utils.s.f(optString2, -1, optString3, SingleTaskQQBrowser.class.getName(), webViewFragment2);
                                                    } else if (webViewFragment2.getUIStyle().U) {
                                                        Bundle bundle2 = new Bundle();
                                                        bundle2.putString("banner_wording", optString2);
                                                        com.tencent.mobileqq.webview.swift.utils.s.d(bundle2, webViewFragment2);
                                                    }
                                                    i27 = 0;
                                                    if (!TextUtils.isEmpty(str20)) {
                                                        callJs(str20, "{'retcode' : " + i27 + "}");
                                                    }
                                                } else {
                                                    QLog.e("UiApiPlugin", 1, "WebViewSwitchAio switchToMsgList failed because null fragment");
                                                }
                                            }
                                            i27 = 1;
                                            if (!TextUtils.isEmpty(str20)) {
                                            }
                                        } catch (JSONException e101) {
                                            jSONException2 = e101;
                                            QLog.e("UiApiPlugin", 1, "WebViewSwitchAio failed:", jSONException2);
                                            if (!TextUtils.isEmpty(str20)) {
                                                callJs(str20, "{'retcode' : 1}");
                                            }
                                            return true;
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th5 = th8;
                                }
                            }
                            if ("setPullDown".equals(str3) && strArr.length == 1) {
                                try {
                                    JSONObject jSONObject28 = new JSONObject(strArr[0]);
                                    if (jSONObject28.has("enable")) {
                                        boolean z37 = jSONObject28.getBoolean("enable");
                                        String optString39 = jSONObject28.optString("from");
                                        int optInt10 = jSONObject28.optInt("headerBgColor", -16777216);
                                        int optInt11 = jSONObject28.optInt("refreshBgColor", -16777216);
                                        boolean equals = TabPreloadItem.TAB_NAME_KANDIAN.equals(optString39);
                                        if (z37 != this.f238707a0) {
                                            if (z37) {
                                                R(equals, optInt10, optInt11);
                                            } else {
                                                H0();
                                            }
                                            this.f238707a0 = z37;
                                        }
                                    } else if (jSONObject28.has("success") && this.f238716g0) {
                                        this.f238716g0 = false;
                                        boolean z38 = jSONObject28.getBoolean("success");
                                        Resources resources = BaseApplication.getContext().getResources();
                                        if (this.f238708b0 != null) {
                                            this.f238708b0.c(!z38 ? 1 : 0, jSONObject28.optString("text", z38 ? resources.getString(R.string.hqk) : resources.getString(R.string.hqe)));
                                        }
                                        RefreshView refreshView2 = this.f238715f0;
                                        if (refreshView2 != null) {
                                            refreshView2.n();
                                        }
                                    }
                                } catch (JSONException e102) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("UiApiPlugin", 4, "setPullDown failed:" + e102);
                                    }
                                }
                            } else if ("showRedEnvelope".equals(str3) && strArr.length == 1) {
                                try {
                                    JSONObject jSONObject29 = new JSONObject(strArr[0]);
                                    int optInt12 = jSONObject29.optInt("redId");
                                    String optString40 = jSONObject29.optString("url");
                                    int optInt13 = jSONObject29.optInt("result");
                                    this.E = jSONObject29.optString("callback");
                                    Intent intent5 = new Intent(BaseApplicationImpl.sApplication, (Class<?>) HongbaoShowerActivity.class);
                                    intent5.putExtra("a_hb_task_id", optInt12);
                                    intent5.putExtra("a_hg_url", optString40);
                                    intent5.putExtra("a_hb_type", optInt13);
                                    intent5.putExtra("a_hb_from", (byte) 6);
                                    startActivityForResult(intent5, (byte) 6);
                                } catch (JSONException e103) {
                                    e103.printStackTrace();
                                    if (!TextUtils.isEmpty(this.E)) {
                                        callJs(this.E, "{'retcode' : 1}");
                                    }
                                } catch (Exception e104) {
                                    e104.printStackTrace();
                                    if (!TextUtils.isEmpty(this.E)) {
                                        callJs(this.E, "{'retcode' : 1}");
                                    }
                                }
                            } else if ("openSocialCard".equals(str3)) {
                                Activity a49 = this.mRuntime.a();
                                AppInterface b18 = this.mRuntime.b();
                                if (a49 != null && b18 != null) {
                                    try {
                                        JSONObject jSONObject30 = new JSONObject(strArr[0]);
                                        str19 = jSONObject30.optString("callback");
                                        try {
                                            String a56 = com.tencent.mobileqq.nearby.k.a(jSONObject30.getString("uin"));
                                            String optString41 = jSONObject30.optString("sign");
                                            int i48 = jSONObject30.getInt("sourceType");
                                            int i49 = jSONObject30.has("nProfileEntryType") ? jSONObject30.getInt("nProfileEntryType") : 0;
                                            Bundle bundle3 = new Bundle();
                                            bundle3.putString("uin", a56);
                                            if (optString41 != null) {
                                                bundle3.putString("sign", optString41);
                                            }
                                            bundle3.putInt("source", i48);
                                            bundle3.putString("action", "openSocialCard");
                                            bundle3.putInt("nProfileEntryType", i49);
                                            Bundle a57 = com.tencent.mobileqq.emosm.a.a("checkRelation", str19, this.Y.key, bundle3);
                                            if (!this.f238722k0) {
                                                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.Y);
                                                this.f238722k0 = true;
                                            }
                                            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(a57);
                                        } catch (Exception e105) {
                                            exc7 = e105;
                                            if (str19 != null) {
                                                callJs(str19, String.format("{\"result\": -2, \"message\":\"%s\"}", exc7));
                                            }
                                            return true;
                                        }
                                    } catch (Exception e106) {
                                        exc7 = e106;
                                        str19 = null;
                                    }
                                }
                            } else if ("openStrangerAIO".equals(str3)) {
                                Activity a58 = this.mRuntime.a();
                                AppInterface b19 = this.mRuntime.b();
                                if (a58 != null && b19 != null) {
                                    try {
                                        JSONObject jSONObject31 = new JSONObject(strArr[0]);
                                        String optString42 = jSONObject31.optString("callback");
                                        try {
                                            String a59 = com.tencent.mobileqq.nearby.k.a(jSONObject31.optString("uin"));
                                            String optString43 = jSONObject31.optString("groupCode");
                                            String optString44 = jSONObject31.optString("strangerchat_ext");
                                            boolean isEmpty = TextUtils.isEmpty(optString43);
                                            if (!isEmpty) {
                                                a59 = optString43;
                                            }
                                            boolean z39 = !isEmpty;
                                            String optString45 = jSONObject31.optString("sign");
                                            int optInt14 = jSONObject31.optInt("sourceType");
                                            int optInt15 = jSONObject31.optInt(EmotionConstants.FROM_AIO);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("UiApiPlugin", 2, "openStrangerAIO ,json:" + jSONObject31.toString());
                                            }
                                            if (TextUtils.isEmpty(a59)) {
                                                str18 = "{\"result\": -1, \"message\":\"Invalid params!\"}";
                                            } else {
                                                Bundle bundle4 = new Bundle();
                                                bundle4.putInt("sourceType", optInt14);
                                                bundle4.putString("uin", a59);
                                                bundle4.putBoolean("isGroup", z39);
                                                bundle4.putString("action", "openStrangerAIO");
                                                bundle4.putInt(EmotionConstants.FROM_AIO, optInt15);
                                                if (!TextUtils.isEmpty(optString45)) {
                                                    bundle4.putString("sign", optString45);
                                                }
                                                if (!TextUtils.isEmpty(optString44)) {
                                                    bundle4.putString("strangerchat_ext", optString44);
                                                }
                                                Bundle a65 = com.tencent.mobileqq.emosm.a.a("checkRelation", optString42, this.Y.key, bundle4);
                                                if (!this.f238722k0) {
                                                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.Y);
                                                    try {
                                                        this.f238722k0 = true;
                                                    } catch (Exception e107) {
                                                        exc6 = e107;
                                                        str16 = optString42;
                                                        i26 = 1;
                                                        Object[] objArr = new Object[i26];
                                                        c19 = 0;
                                                        objArr[0] = exc6;
                                                        str17 = String.format("{\"result\": -2, \"message\":\"%s\"}", objArr);
                                                        if (str17 != null) {
                                                            String[] strArr2 = new String[i26];
                                                            strArr2[c19] = str17;
                                                            callJs(str16, strArr2);
                                                        }
                                                        return true;
                                                    }
                                                }
                                                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(a65);
                                                str18 = null;
                                            }
                                            str17 = str18;
                                            c19 = 0;
                                            str16 = optString42;
                                            i26 = 1;
                                        } catch (Exception e108) {
                                            exc6 = e108;
                                            str16 = optString42;
                                            i26 = 1;
                                        }
                                    } catch (Exception e109) {
                                        exc6 = e109;
                                        i26 = 1;
                                        str16 = null;
                                    }
                                    if (str17 != null && !TextUtils.isEmpty(str16)) {
                                        String[] strArr22 = new String[i26];
                                        strArr22[c19] = str17;
                                        callJs(str16, strArr22);
                                    }
                                }
                            } else if ("disableLongPress".equals(str3)) {
                                try {
                                    JSONObject jSONObject32 = new JSONObject(strArr[0]);
                                    str5 = jSONObject32.optString("callback");
                                    try {
                                        if (jSONObject32.has("enable")) {
                                            boolean optBoolean5 = jSONObject32.optBoolean("enable");
                                            WebViewPlugin.b bVar10 = this.mRuntime;
                                            com.tencent.mobileqq.webview.swift.y d36 = bVar10.d(bVar10.a());
                                            if (d36 != null && (d36 instanceof com.tencent.mobileqq.webviewplugin.l)) {
                                                ((com.tencent.mobileqq.webviewplugin.l) d36).O3(!optBoolean5);
                                            } else {
                                                com.tencent.mobileqq.webview.swift.component.f fVar = (com.tencent.mobileqq.webview.swift.component.f) super.getBrowserComponent(-1);
                                                if (fVar != null) {
                                                    fVar.h("image_long_click", !optBoolean5);
                                                }
                                            }
                                        }
                                    } catch (Exception e110) {
                                        exc = e110;
                                        if (!TextUtils.isEmpty(str5)) {
                                            callJs(str5, String.format("{\"result\": -2, \"message\":\"%s\"}", exc));
                                        }
                                        return true;
                                    }
                                } catch (Exception e111) {
                                    exc = e111;
                                    str5 = null;
                                }
                            } else if ("disableWebviewLongPress".equals(str3)) {
                                try {
                                    jSONObject = new JSONObject(strArr[0]);
                                    str6 = jSONObject.optString("callback");
                                } catch (Exception e112) {
                                    exc2 = e112;
                                    str6 = null;
                                }
                                try {
                                    if (jSONObject.has("enable")) {
                                        boolean optBoolean6 = jSONObject.optBoolean("enable");
                                        WebViewPlugin.b bVar11 = this.mRuntime;
                                        com.tencent.mobileqq.webview.swift.y d37 = bVar11.d(bVar11.a());
                                        if (d37 != null && (d37 instanceof com.tencent.mobileqq.webviewplugin.l)) {
                                            ((com.tencent.mobileqq.webviewplugin.l) d37).L6(!optBoolean6);
                                        } else {
                                            com.tencent.mobileqq.webview.swift.component.f fVar2 = (com.tencent.mobileqq.webview.swift.component.f) super.getBrowserComponent(-1);
                                            if (fVar2 != null) {
                                                fVar2.h("web_view_long_click", !optBoolean6);
                                            }
                                        }
                                    }
                                } catch (Exception e113) {
                                    exc2 = e113;
                                    if (!TextUtils.isEmpty(str6)) {
                                        callJs(str6, String.format("{\"result\": -2, \"message\":\"%s\"}", exc2));
                                    }
                                    return true;
                                }
                            } else if ("addUniteSearchRecord".equals(str3)) {
                                try {
                                    new cw().a(new JSONObject(strArr[0]).optJSONArray("searchRecordList"));
                                } catch (JSONException unused6) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "shareToReadInJoy JSONException ,args:" + strArr[0]);
                                    }
                                }
                            } else if ("getUniteSearchRecord".equals(str3)) {
                                try {
                                    String optString46 = new JSONObject(strArr[0]).optString("callback");
                                    cw cwVar = new cw();
                                    JSONObject jSONObject33 = new JSONObject();
                                    JSONArray jSONArray = new JSONArray();
                                    ArrayList<String> g16 = cwVar.g();
                                    for (int i56 = 0; i56 < g16.size(); i56++) {
                                        jSONArray.mo162put(g16.get(i56));
                                    }
                                    jSONObject33.put("searchRecordList", jSONArray);
                                    callJs(optString46, jSONObject33.toString());
                                } catch (JSONException unused7) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "getUniteSearchRecord JSONException ,args:" + strArr[0]);
                                    }
                                }
                            } else if ("showReadInJoyAccount".equals(str3)) {
                                Activity a66 = this.mRuntime.a();
                                AppInterface b26 = this.mRuntime.b();
                                if (a66 != null && b26 != null) {
                                    try {
                                        jSONObject5 = new JSONObject(strArr[0]);
                                        str14 = jSONObject5.optString("callback");
                                    } catch (Exception e114) {
                                        exc5 = e114;
                                        i19 = 1;
                                        str13 = null;
                                    }
                                    try {
                                        Bundle bundle5 = new Bundle();
                                        bundle5.putString("argument", jSONObject5.toString());
                                        if (a66.getClass().getName().equalsIgnoreCase(((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountBrowser.class))) {
                                            try {
                                                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).openPublicAccountProfile(null, a66, com.tencent.biz.pubaccount.subscript.f.a(new JSONObject(bundle5.getString("argument")).optString("subscribeid", "")));
                                            } catch (Exception e115) {
                                                QLog.d("UiApiPlugin", 2, "Open doShowReadInJoyAccount fail", e115);
                                            }
                                        }
                                        i19 = 1;
                                        c18 = 0;
                                        str15 = null;
                                    } catch (Exception e116) {
                                        exc5 = e116;
                                        str13 = str14;
                                        i19 = 1;
                                        Object[] objArr2 = new Object[i19];
                                        c18 = 0;
                                        objArr2[0] = exc5;
                                        String format = String.format("{\"result\": -2, \"message\":\"%s\"}", objArr2);
                                        str14 = str13;
                                        str15 = format;
                                        if (str15 != null) {
                                            String[] strArr3 = new String[i19];
                                            strArr3[c18] = str15;
                                            callJs(str14, strArr3);
                                        }
                                        return true;
                                    }
                                    if (str15 != null && !TextUtils.isEmpty(str14)) {
                                        String[] strArr32 = new String[i19];
                                        strArr32[c18] = str15;
                                        callJs(str14, strArr32);
                                    }
                                }
                            } else if (MiniChatConstants.MINI_APP_ADD_SHORTCUT.equals(str3)) {
                                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_call", 0, 1, 0, strArr[0], "", "", "");
                                Activity a67 = this.mRuntime.a();
                                AppInterface b27 = this.mRuntime.b();
                                if (a67 != null && b27 != null) {
                                    try {
                                        jSONObject4 = new JSONObject(strArr[0]);
                                        str11 = jSONObject4.optString("callback");
                                    } catch (Exception e117) {
                                        exc4 = e117;
                                        str11 = null;
                                    }
                                    try {
                                        str12 = jSONObject4.optString("extras");
                                        try {
                                            optString = jSONObject4.optString("action");
                                            optJSONObject = jSONObject4.optJSONObject("data");
                                        } catch (Exception e118) {
                                            exc4 = e118;
                                            F = F("-2", null, exc4.toString(), str12);
                                            if (F != null) {
                                            }
                                            return true;
                                        }
                                    } catch (Exception e119) {
                                        exc4 = e119;
                                        str12 = null;
                                        F = F("-2", null, exc4.toString(), str12);
                                        if (F != null) {
                                        }
                                        return true;
                                    }
                                    if ("web".equals(optString) && optJSONObject != null) {
                                        String optString47 = optJSONObject.optString("title");
                                        String optString48 = optJSONObject.optString("icon");
                                        String optString49 = optJSONObject.optString("url");
                                        if (!TextUtils.isEmpty(optString47) && !TextUtils.isEmpty(optString49)) {
                                            z(a67, optString47, optString48, str12, optString49, str11);
                                        } else {
                                            F = F("-1", null, "Invalid params!", str12);
                                            if (F != null && !TextUtils.isEmpty(str11)) {
                                                callJs(str11, F);
                                            }
                                        }
                                    }
                                    F = null;
                                    if (F != null) {
                                        callJs(str11, F);
                                    }
                                }
                            } else if ("openActionURL".equals(str3) && strArr.length > 0) {
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("openActionURL ,args:");
                                    c17 = 0;
                                    sb5.append(strArr[0]);
                                    QLog.d("UiApiPlugin.troop.troop_app", 2, sb5.toString());
                                } else {
                                    c17 = 0;
                                }
                                try {
                                    String optString50 = new JSONObject(strArr[c17]).optString("url");
                                    if (!TextUtils.isEmpty(optString50)) {
                                        String[] split = optString50.split("\\?");
                                        HashMap hashMap = new HashMap();
                                        if (split.length > 1) {
                                            String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
                                            int length3 = split2.length;
                                            for (int i57 = 0; i57 < length3; i57++) {
                                                int indexOf = split2[i57].indexOf(61);
                                                if (indexOf != -1) {
                                                    hashMap.put(split2[i57].substring(0, indexOf), split2[i57].substring(indexOf + 1));
                                                }
                                            }
                                            if (optString50.startsWith("mqqapi://groupopenapp/openapp")) {
                                                str9 = (String) hashMap.get("gc");
                                                str10 = (String) hashMap.get("type");
                                            } else {
                                                str9 = (String) hashMap.get("group_uin");
                                                str10 = (String) hashMap.get("_opn");
                                            }
                                            if (!f0(str9, str10, optString50)) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("UiApiPlugin.troop.troop_app", 2, "openUrl");
                                                }
                                                g0(this.mRuntime.a(), this.mRuntime.e(), this.mRuntime.b(), strArr[0], false, false);
                                            }
                                        }
                                    }
                                } catch (JSONException unused8) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin.troop.troop_app", 2, "JSONException ,args:" + strArr[0]);
                                    }
                                }
                            } else if ("setPopupMenu".equals(str3) && strArr.length > 0) {
                                try {
                                    t0(new JSONObject(strArr[0]));
                                } catch (JSONException unused9) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "setPopupMenu JSONException ,args:" + strArr[0]);
                                    }
                                }
                            } else if ("closePopupMenu".equals(str3)) {
                                x();
                            } else if ("shareToReadInJoy".equals(str3) && strArr.length > 0) {
                                try {
                                    A0(new JSONObject(strArr[0]).optString("callback"));
                                } catch (JSONException unused10) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "shareToReadInJoy JSONException ,args:" + strArr[0]);
                                    }
                                }
                            } else if ("setTransparentTitleBar".equals(str3)) {
                                try {
                                    JSONObject jSONObject34 = new JSONObject(strArr[0]);
                                    com.tencent.mobileqq.webviewplugin.s g17 = this.mRuntime.g();
                                    if (g17 != null && g17.getWebTitleBarInterface() != null) {
                                        g17.getWebTitleBarInterface().sc(jSONObject34);
                                    }
                                } catch (JSONException e120) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "setTransparentTitleBar error:" + e120.toString());
                                    }
                                } catch (Exception e121) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "setTransparentTitleBar error:" + e121.toString());
                                    }
                                }
                            } else if ("getTitleBarHeight".equals(str3) && strArr.length > 0) {
                                try {
                                    String optString51 = new JSONObject(strArr[0]).optString("callback");
                                    if (TextUtils.isEmpty(optString51)) {
                                        QLog.e("UiApiPlugin", 1, "getTitleBarHeight, callbackId null");
                                        return true;
                                    }
                                    JSONObject jSONObject35 = new JSONObject();
                                    JSONObject jSONObject36 = new JSONObject();
                                    int dimensionPixelSize = this.mRuntime.a().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                                    if (ImmersiveUtils.isSupporImmersive() == 1) {
                                        dimensionPixelSize += ImmersiveUtils.getStatusBarHeight(this.mRuntime.a());
                                    }
                                    jSONObject36.put("height", dimensionPixelSize);
                                    jSONObject35.put("code", 0);
                                    jSONObject35.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                    jSONObject35.put("data", jSONObject36);
                                    callJs(optString51, jSONObject35.toString());
                                } catch (Exception e122) {
                                    QLog.e("UiApiPlugin", 1, "getTitleBarHeight, exception=" + MsfSdkUtils.getStackTraceString(e122));
                                    return true;
                                }
                            } else if ("openSetJoinType".equals(str3)) {
                                try {
                                    JSONObject jSONObject37 = new JSONObject(strArr[0]);
                                    String optString52 = jSONObject37.optString("gc");
                                    this.Q = jSONObject37.optString("callback");
                                    if (this.R == null) {
                                        com.tencent.biz.troop.b A2 = com.tencent.biz.troop.b.A();
                                        this.R = A2;
                                        A2.p();
                                    }
                                    this.R.e0(optString52, new q(optString52));
                                } catch (Exception unused11) {
                                    return true;
                                }
                            } else if ("showProfile".equals(str3) && strArr.length == 1) {
                                try {
                                    JSONObject jSONObject38 = new JSONObject(strArr[0]);
                                    String optString53 = jSONObject38.optString(com.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN);
                                    String optString54 = jSONObject38.optString("openId");
                                    if (TextUtils.isEmpty(optString54)) {
                                        if (!QLog.isColorLevel()) {
                                            return true;
                                        }
                                        QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "openId is empty");
                                        return true;
                                    }
                                    CustomWebView e123 = this.mRuntime.e();
                                    if (e123 != null && e123.getOpenApiTokenInfo() != null) {
                                        Integer valueOf = Integer.valueOf(e123.getOpenApiTokenInfo().f78796a);
                                        int optInt16 = jSONObject38.optInt("uinType");
                                        if (optInt16 == 1) {
                                            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                                            oidb_sso_oidbssopkg.uint32_command.set(1814);
                                            oidb_sso_oidbssopkg.uint32_service_type.set(48);
                                            ByteBuffer allocate = ByteBuffer.allocate(optString54.getBytes().length + 6);
                                            allocate.putInt(valueOf.intValue());
                                            allocate.putShort((short) optString54.getBytes().length);
                                            allocate.put(optString54.getBytes());
                                            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
                                            NewIntent newIntent = new NewIntent(getCurrentContext(), com.tencent.biz.m.class);
                                            Bundle bundle6 = new Bundle();
                                            bundle6.putString("openId", optString54);
                                            newIntent.putExtras(bundle6);
                                            newIntent.putExtra("cmd", "OidbSvc.0x716_48");
                                            newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
                                            newIntent.putExtra("DataType", 1);
                                            newIntent.setObserver(new r());
                                            this.mRuntime.b().startServlet(newIntent);
                                        } else if (optInt16 == 0) {
                                            if (this.R == null) {
                                                com.tencent.biz.troop.b A3 = com.tencent.biz.troop.b.A();
                                                this.R = A3;
                                                A3.p();
                                            }
                                            this.R.L(valueOf, optString54, optString53, new s(valueOf, optString54));
                                        }
                                    }
                                    if (!QLog.isColorLevel()) {
                                        return true;
                                    }
                                    QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "webView == null || webView.getOpenApiTokenInfo() == null");
                                    return true;
                                } catch (JSONException unused12) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "JSONException, args:" + strArr[0]);
                                    }
                                } catch (Exception unused13) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "Exception, args:" + strArr[0]);
                                    }
                                }
                            } else if ("openGroupCard".equals(str3) && strArr.length == 1) {
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("openGroupMemberCard, args:");
                                    c16 = 0;
                                    sb6.append(strArr[0]);
                                    QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, sb6.toString());
                                } else {
                                    c16 = 0;
                                }
                                try {
                                    JSONObject jSONObject39 = new JSONObject(strArr[c16]);
                                    String optString55 = jSONObject39.optString(com.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN);
                                    String optString56 = jSONObject39.optString("openId");
                                    String optString57 = jSONObject39.optString("groupOpenId");
                                    if (!TextUtils.isEmpty(optString56) && !TextUtils.isEmpty(optString57)) {
                                        CustomWebView e124 = this.mRuntime.e();
                                        if (e124 != null && e124.getOpenApiTokenInfo() != null) {
                                            Integer valueOf2 = Integer.valueOf(e124.getOpenApiTokenInfo().f78796a);
                                            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
                                            oidb_sso_oidbssopkg2.uint32_command.set(1814);
                                            oidb_sso_oidbssopkg2.uint32_service_type.set(48);
                                            ByteBuffer allocate2 = ByteBuffer.allocate(optString57.getBytes().length + 6);
                                            allocate2.putInt(valueOf2.intValue());
                                            allocate2.putShort((short) optString57.getBytes().length);
                                            allocate2.put(optString57.getBytes());
                                            oidb_sso_oidbssopkg2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate2.array()));
                                            NewIntent newIntent2 = new NewIntent(getCurrentContext(), com.tencent.biz.m.class);
                                            newIntent2.putExtras(new Bundle());
                                            newIntent2.putExtra("cmd", "OidbSvc.0x716_48");
                                            newIntent2.putExtra("data", oidb_sso_oidbssopkg2.toByteArray());
                                            newIntent2.putExtra("DataType", 1);
                                            newIntent2.setObserver(new t(valueOf2, optString56, optString55));
                                            this.mRuntime.b().startServlet(newIntent2);
                                        }
                                        if (!QLog.isColorLevel()) {
                                            return true;
                                        }
                                        QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "openGroupMemberCard, webView == null || webView.getOpenApiTokenInfo() == null");
                                        return true;
                                    }
                                    if (!QLog.isColorLevel()) {
                                        return true;
                                    }
                                    QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "openGroupMemberCard, openID == null || groupOpenId == null, groupOpenId" + optString57 + ",openID:" + optString56);
                                    return true;
                                } catch (JSONException unused14) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "JSONException, args:" + strArr[0]);
                                    }
                                } catch (Exception unused15) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "Exception, args:" + strArr[0]);
                                    }
                                }
                            } else if ("getTitleBarAlpha".equals(str3)) {
                                try {
                                    this.E = new JSONObject(strArr[0]).getString("callback");
                                    com.tencent.mobileqq.webview.swift.component.v vVar3 = (com.tencent.mobileqq.webview.swift.component.v) super.getBrowserComponent(2);
                                    if (vVar3 != null) {
                                        int i58 = vVar3.f314512m.J;
                                        callJs(this.E, "{\"ret\":\"0\",\"alpha\":" + i58 + "}");
                                    }
                                } catch (JSONException e125) {
                                    if (QLog.isColorLevel()) {
                                        callJs(this.E, "{\"ret\":\"-1\"}");
                                        QLog.d("UiApiPlugin", 2, "getTitleBarAlpha error:" + e125.toString());
                                    }
                                } catch (Exception e126) {
                                    if (QLog.isColorLevel()) {
                                        callJs(this.E, "{\"ret\":\"-1\"}");
                                        QLog.d("UiApiPlugin", 2, "getTitleBarAlpha error:" + e126.toString());
                                    }
                                }
                            } else if ("setWebviewNaviTitle".equals(str3) && strArr.length <= 1) {
                                try {
                                    if (strArr.length == 1) {
                                        JSONObject jSONObject40 = new JSONObject(strArr[0]);
                                        String string4 = jSONObject40.getString("title");
                                        str8 = jSONObject40.has("color") ? jSONObject40.getString("color") : "";
                                        str4 = string4;
                                    } else {
                                        str8 = "";
                                    }
                                    Activity a68 = this.mRuntime.a();
                                    if (a68 != null && (a68 instanceof TeamWorkDocEditBrowserActivity)) {
                                        ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) ((TeamWorkDocEditBrowserActivity) a68).getCurrentWebViewFragment()).si(false, str4, str8);
                                    }
                                } catch (JSONException e127) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("UiApiPlugin", 4, "setWebviewNaviTitle failed:" + e127);
                                    }
                                }
                            } else if ("setSharedDocNativeKeyboardEnable".equals(str3) && strArr.length <= 1) {
                                try {
                                    if (strArr.length == 1) {
                                        JSONObject jSONObject41 = new JSONObject(strArr[0]);
                                        try {
                                            i17 = jSONObject41.optInt("enable", -1);
                                        } catch (Exception e128) {
                                            QLog.d("UiApiPlugin", 1, "setSharedDocNativeKeyboardEnable enable failed:" + e128);
                                            i17 = -1;
                                        }
                                        try {
                                            i18 = jSONObject41.optInt("source", -1);
                                        } catch (Exception e129) {
                                            QLog.d("UiApiPlugin", 1, "setSharedDocNativeKeyboardEnable source failed:" + e129);
                                            i18 = -1;
                                        }
                                        Activity a69 = this.mRuntime.a();
                                        if (a69 != null && (a69 instanceof TeamWorkDocEditBrowserActivity) && (teamWorkDocEditBrowserFragment = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) ((TeamWorkDocEditBrowserActivity) a69).getCurrentWebViewFragment()) != null) {
                                            if (i18 == 1) {
                                                teamWorkDocEditBrowserFragment.S = false;
                                                teamWorkDocEditBrowserFragment.li(true);
                                                z19 = true;
                                                z18 = false;
                                            } else {
                                                if (i18 == 0) {
                                                    teamWorkDocEditBrowserFragment.S = true;
                                                    z18 = false;
                                                    teamWorkDocEditBrowserFragment.li(false);
                                                } else {
                                                    z18 = false;
                                                }
                                                z19 = true;
                                            }
                                            if (i17 == z19) {
                                                teamWorkDocEditBrowserFragment.S = z18;
                                                teamWorkDocEditBrowserFragment.pi(z19);
                                            } else if (i17 == 0) {
                                                teamWorkDocEditBrowserFragment.S = z19;
                                                teamWorkDocEditBrowserFragment.pi(false);
                                            }
                                        }
                                    }
                                } catch (JSONException e130) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("UiApiPlugin", 4, "setSharedDocNativeKeyboardEnable failed:" + e130);
                                    }
                                }
                            } else if ("setSharedDocNativeKeyboardActive".equals(str3) && strArr.length <= 1) {
                                try {
                                    if (strArr.length == 1 && strArr.length == 1) {
                                        String string5 = new JSONObject(strArr[0]).getString("active");
                                        Activity a75 = this.mRuntime.a();
                                        if (a75 != null && (a75 instanceof TeamWorkDocEditBrowserActivity)) {
                                            TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment3 = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) ((TeamWorkDocEditBrowserActivity) a75).getCurrentWebViewFragment();
                                            if ("1".equals(string5)) {
                                                ((InputMethodManager) a75.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(teamWorkDocEditBrowserFragment3.getWebView(), 0);
                                            } else {
                                                ((InputMethodManager) a75.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(a75.getWindow().getDecorView().getWindowToken(), 0);
                                            }
                                        }
                                    }
                                } catch (JSONException e131) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("UiApiPlugin", 4, "setSharedDocNativeKeyboardActive failed:" + e131);
                                    }
                                }
                            } else {
                                if ("detectSharedDocAdvancedFeature".equals(str3)) {
                                    z27 = true;
                                    if (strArr.length <= 1) {
                                        if (strArr.length == 1) {
                                            try {
                                                String optString58 = new JSONObject(strArr[0]).optString("callback");
                                                if (!TextUtils.isEmpty(optString58)) {
                                                    callJs(optString58, "{\"setWebviewNaviTitle\":1, \"sheetnativekeyboard\":1, \"setSharedDocNativeKeyboardEnable\":1, \"setSharedDocNativeKeyboardActive\":1, \"sharedDocSheetCommitCellValue\":1,\"setSharedDocInputBarCellValue\":1}");
                                                }
                                            } catch (JSONException e132) {
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.d("UiApiPlugin", 4, "detectSharedDocAdvancedFeature failed:" + e132);
                                                }
                                            }
                                        }
                                    }
                                }
                                if ("openUserSummaryView".equals(str3) && strArr.length > 0) {
                                    try {
                                        JSONObject jSONObject42 = new JSONObject(strArr[0]);
                                        Activity a76 = this.mRuntime.a();
                                        AppInterface b28 = this.mRuntime.b();
                                        String optString59 = jSONObject42.optString("uin");
                                        if (!TextUtils.isEmpty(optString59) && a76 != null && b28 != null) {
                                            ProfileUtils.openProfileCard(a76, new AllInOne(optString59, 90));
                                        }
                                    } catch (JSONException e133) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("UiApiPlugin.troop.troop_fee", 2, "openUserSummaryView JSONException:" + e133);
                                        }
                                    }
                                } else if ("setTeamWorkEditType".equals(str3) && strArr.length > 0) {
                                    try {
                                        int optInt17 = new JSONObject(strArr[0]).optInt("editType");
                                        Activity a77 = this.mRuntime.a();
                                        if (a77 != null && (a77 instanceof TeamWorkDocEditBrowserActivity)) {
                                            ((TeamWorkDocEditBrowserActivity) a77).N2(optInt17);
                                        }
                                    } catch (JSONException e134) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("UiApiPlugin.troop.troop_fee", 2, "setTeamWorkEditType JSONException:" + e134);
                                        }
                                    }
                                } else if ("setTitleBarScrollChange".equals(str3) && strArr.length > 0) {
                                    try {
                                        JSONObject jSONObject43 = new JSONObject(strArr[0]);
                                        boolean z46 = jSONObject43.optInt("isAuto", 0) == 1;
                                        int optInt18 = jSONObject43.optInt("dividePosition");
                                        int optInt19 = jSONObject43.optInt("beforeDivideAlpha");
                                        int optInt20 = jSONObject43.optInt("afterDivideAlpha");
                                        boolean z47 = jSONObject43.optInt("isShade", 1) == 1;
                                        String optString60 = jSONObject43.optString("beforeTitle", null);
                                        String optString61 = jSONObject43.optString("afterTitle", null);
                                        String optString62 = jSONObject43.optString("callback");
                                        Activity a78 = this.mRuntime.a();
                                        WebViewFragment webViewFragment3 = (WebViewFragment) this.mRuntime.f();
                                        com.tencent.mobileqq.webview.swift.y d38 = this.mRuntime.d(a78);
                                        if (webViewFragment3 != null && webViewFragment3.getUIStyleHandler() != null) {
                                            webViewFragment3.getUIStyleHandler().a0(z46, optInt18, optInt19, optInt20, z47, optString60, optString61, optString62);
                                        } else if (d38 != null && (d38 instanceof com.tencent.mobileqq.webviewplugin.k)) {
                                            ((com.tencent.mobileqq.webviewplugin.k) d38).Nf(z46, optInt18, optInt19, optInt20, z47, optString60, optString61, optString62, this.mRuntime.e().hashCode());
                                        }
                                    } catch (JSONException e135) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("UiApiPlugin", 2, "setTitleBarScrollChange JSONException:" + e135);
                                        }
                                    }
                                } else if ("invokeClientAction".equals(str3) && strArr.length > 0) {
                                    try {
                                        int optInt21 = new JSONObject(strArr[0]).optInt("action");
                                        CustomWebView e136 = this.mRuntime.e();
                                        if (e136 != null) {
                                            if (optInt21 == 0) {
                                                e136.reload();
                                            } else {
                                                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) getBrowserComponent(4);
                                                if (swiftBrowserShareMenuHandler != null) {
                                                    String originalUrl = e136.getOriginalUrl();
                                                    if (swiftBrowserShareMenuHandler.f314302i == null) {
                                                        swiftBrowserShareMenuHandler.f314302i = new Share(this.mRuntime.b(), this.mRuntime.a());
                                                    }
                                                    if (optInt21 == 1) {
                                                        swiftBrowserShareMenuHandler.n(6, originalUrl, new Bundle());
                                                    } else if (optInt21 == 2) {
                                                        swiftBrowserShareMenuHandler.n(11, originalUrl, new Bundle());
                                                    }
                                                }
                                            }
                                        }
                                    } catch (JSONException e137) {
                                        QLog.e("UiApiPlugin", 2, "invokeClientAction JSONException", e137);
                                    }
                                } else if ("showRobotPickerView".equals(str3)) {
                                    Intent intent6 = new Intent(this.mRuntime.a(), (Class<?>) TroopRobotPickerActivity.class);
                                    intent6.putExtra(ark.ARKMETADATA_JSON, strArr[0]);
                                    this.mRuntime.a().startActivityForResult(intent6, (com.tencent.mobileqq.webview.swift.ao.a(this) << 8) + 13);
                                    this.mRuntime.a().overridePendingTransition(0, 0);
                                } else if ("openCustomWebView".equals(str3)) {
                                    try {
                                        JSONObject jSONObject44 = new JSONObject(strArr[0]);
                                        String optString63 = jSONObject44.optString("url", "");
                                        this.G = jSONObject44.optString("callback");
                                        if (TextUtils.isEmpty(optString63)) {
                                            JSONObject jSONObject45 = new JSONObject();
                                            jSONObject45.put("result", -1);
                                            jSONObject45.put("data", "");
                                            callJs(this.G, jSONObject45.toString());
                                        } else {
                                            int optInt22 = jSONObject44.optInt("transparent", 0);
                                            Intent intent7 = new Intent();
                                            if (optInt22 == 0) {
                                                intent7.setClass(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
                                            } else {
                                                intent7.setClass(BaseApplicationImpl.getApplication(), QQTranslucentBrowserActivity.class);
                                            }
                                            intent7.putExtra("url", optString63);
                                            this.mRuntime.a().startActivityForResult(intent7, 14);
                                        }
                                    } catch (Exception e138) {
                                        z16 = true;
                                        QLog.e("UiApiPlugin", 1, "openCustomWebView exception e = ", e138);
                                        return z16;
                                    }
                                } else if ("setCustomWebCallbackData".equals(str3)) {
                                    try {
                                        this.mRuntime.a().setResult(-1, new Intent().putExtra("data", new JSONObject(strArr[0]).optString("data")));
                                    } catch (Exception e139) {
                                        z16 = true;
                                        QLog.e("UiApiPlugin", 1, "setCustomWebCallbackData exception e = ", e139);
                                        return z16;
                                    }
                                } else if (!"getCUKingCardPopupStyle".equals(str3)) {
                                    if ("getPopupType".equals(str3)) {
                                        try {
                                            JSONObject jSONObject46 = new JSONObject(strArr[0]);
                                            String optString64 = jSONObject46.optString("callback");
                                            d.a e140 = com.tencent.mobileqq.vip.d.e(jSONObject46.optString("source"), false, false);
                                            JSONObject jSONObject47 = new JSONObject();
                                            jSONObject47.put("result", e140.f312930a);
                                            jSONObject47.put("url", e140.f312931b);
                                            callJs(optString64, jSONObject47.toString());
                                        } catch (Exception e141) {
                                            z16 = true;
                                            QLog.e("UiApiPlugin", 1, "getPopupType error e = ", e141);
                                            return z16;
                                        }
                                    } else if ("mobileDataDialog".equals(str3)) {
                                        try {
                                            JSONObject jSONObject48 = new JSONObject(strArr[0]);
                                            String optString65 = jSONObject48.optString("callback");
                                            int optInt23 = jSONObject48.optInt("type");
                                            String optString66 = jSONObject48.optString("source");
                                            if (QLog.isColorLevel()) {
                                                QLog.i("UiApiPlugin", 2, "mobileDataDialog, sceneId: " + optInt23 + ", srcFrom: " + optString66);
                                            }
                                            d.a e142 = com.tencent.mobileqq.vip.d.e(optString66, false, true);
                                            JSONObject jSONObject49 = new JSONObject();
                                            int i59 = e142.f312930a;
                                            if (i59 == 1) {
                                                jSONObject49.put("result", 2);
                                                callJs(optString65, jSONObject49.toString());
                                            } else if (i59 == 4) {
                                                jSONObject49.put("result", 0);
                                                callJs(optString65, jSONObject49.toString());
                                            } else {
                                                new com.tencent.mobileqq.vip.c(this.mRuntime.a(), this.mRuntime.e(), optString65, optInt23, optString66, e142.f312930a).show();
                                            }
                                        } catch (Exception e143) {
                                            z16 = true;
                                            QLog.e("UiApiPlugin", 1, "mobileDataDialog error e = ", e143);
                                            return z16;
                                        }
                                    } else if ("getCUKingStatus".equals(str3)) {
                                        try {
                                            JSONObject jSONObject50 = new JSONObject(strArr[0]);
                                            String optString67 = jSONObject50.optString("callback");
                                            String optString68 = jSONObject50.optString("source");
                                            JSONObject jSONObject51 = new JSONObject();
                                            jSONObject51.put("result", com.tencent.mobileqq.vip.e.a());
                                            jSONObject51.put("url", com.tencent.mobileqq.vip.d.c(optString68));
                                            callJs(optString67, jSONObject51.toString());
                                        } catch (Exception e144) {
                                            z16 = true;
                                            QLog.e("UiApiPlugin", 1, "getPopupType error e = ", e144);
                                            return z16;
                                        }
                                    } else if ("setRightDragToGoBackParams".equals(str3)) {
                                        try {
                                            JSONObject jSONObject52 = new JSONObject(strArr[0]);
                                            boolean z48 = jSONObject52.getBoolean("enable");
                                            JSONObject optJSONObject3 = jSONObject52.optJSONObject(CanvasView.ACTION_RECT);
                                            if (optJSONObject3 != null) {
                                                int i65 = optJSONObject3.getInt(HippyTKDListViewAdapter.X);
                                                int i66 = optJSONObject3.getInt("y");
                                                Rect rect = new Rect(i65, i66, optJSONObject3.getInt("width") + i65, optJSONObject3.getInt("height") + i66);
                                                Activity a79 = this.mRuntime.a();
                                                if (a79 instanceof EcshopWebActivity) {
                                                    ((EcshopWebActivity) a79).G2(rect, z48);
                                                }
                                            }
                                        } catch (Exception e145) {
                                            z16 = true;
                                            QLog.e("UiApiPlugin", 1, "setRightDragToGoBackParams exception e = ", e145);
                                            return z16;
                                        }
                                    } else if ("shareScreenshot".equals(str3)) {
                                        try {
                                            jSONObject2 = new JSONObject(strArr[0]);
                                            z17 = true;
                                        } catch (Exception e146) {
                                            z17 = true;
                                            QLog.e("UiApiPlugin", 1, "shareScreenshot exception e = ", e146);
                                            jSONObject2 = null;
                                        }
                                        if (jSONObject2 == null) {
                                            return z17;
                                        }
                                        ThreadManager.getUIHandler().post(new AnonymousClass9(jSONObject2));
                                    } else if (QQFriendJsPlugin.API_ADD_FRIEND.equals(str3)) {
                                        try {
                                            JSONObject jSONObject53 = new JSONObject(strArr[0]);
                                            this.I = jSONObject53.optString("callback");
                                            String optString69 = jSONObject53.optString("openId");
                                            String optString70 = jSONObject53.optString("appId");
                                            String optString71 = jSONObject53.optString("nickName");
                                            String optString72 = jSONObject53.optString("msg");
                                            int optInt24 = jSONObject53.optInt("sourceId");
                                            Activity a85 = this.mRuntime.a();
                                            int optInt25 = jSONObject53.optInt("subsourceId");
                                            int i67 = 101 == optInt25 ? optInt25 : optInt24;
                                            WebViewPlugin.b bVar12 = this.mRuntime;
                                            com.tencent.mobileqq.webview.swift.y d39 = bVar12.d(bVar12.a());
                                            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(a85, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(a85, 3, optString69, optString70, 3016, i67, optString71, optString72, null, null, null), d39 instanceof com.tencent.mobileqq.webview.swift.af ? ((com.tencent.mobileqq.webview.swift.af) d39).switchRequestCode(this, RegisterType.UNINIT_REF) : 16);
                                        } catch (Exception e147) {
                                            z16 = true;
                                            QLog.e("UiApiPlugin", 1, "addFriend exception e = ", e147);
                                            return z16;
                                        }
                                    } else if ("sharePicMessage".equals(str3)) {
                                        try {
                                            JSONObject jSONObject54 = new JSONObject(strArr[0]);
                                            String optString73 = jSONObject54.optString("imagePath");
                                            String optString74 = jSONObject54.optString("imageData");
                                            String optString75 = jSONObject54.optString("imageUrl");
                                            if (!TextUtils.isEmpty(optString73)) {
                                                File file = new File(optString73);
                                                if (!file.exists()) {
                                                    QQToast.makeText(this.mRuntime.b().getApplication(), 1, HardCodeUtil.qqStr(R.string.usn), 0).show();
                                                } else {
                                                    z0(file);
                                                }
                                            } else if (!TextUtils.isEmpty(optString74)) {
                                                y0(PluginBaseInfoHelper.Base64Helper.decode(optString74, 0), MD5Utils.toMD5(optString74));
                                            } else if (!TextUtils.isEmpty(optString75)) {
                                                x0(optString75);
                                            } else {
                                                QQToast.makeText(this.mRuntime.b().getApplication(), 1, HardCodeUtil.qqStr(R.string.ust), 0).show();
                                            }
                                        } catch (Exception e148) {
                                            z16 = true;
                                            QLog.e("UiApiPlugin", 1, "sharePicMessage exception e = ", e148);
                                            return z16;
                                        }
                                    } else if ("setTopicLabel".equals(str3)) {
                                        this.mRuntime.a().setResult(-1, new Intent().putExtra("topic", strArr[0]));
                                        this.mRuntime.a().finish();
                                    } else {
                                        if ("mergeTextToImage".equals(str3)) {
                                            b0(strArr[0]);
                                            return true;
                                        }
                                        if ("customDatePicker".equals(str3) && strArr.length == 1) {
                                            try {
                                                JSONObject jSONObject55 = new JSONObject(strArr[0]);
                                                new com.tencent.mobileqq.troop.widget.k(jSONObject55.getInt("minute_Interval"), jSONObject55.getInt("hour_Start"), jSONObject55.getInt("hour_end"), jSONObject55.getInt("max_display_days"), jSONObject55.getLong("defaultTime")).j(this.mRuntime.a(), new a(jSONObject55.optString("callback")));
                                            } catch (JSONException e149) {
                                                e149.printStackTrace();
                                            }
                                        } else if ("getNotchInfo".equals(str3)) {
                                            try {
                                                String optString76 = new JSONObject(strArr[0]).optString("callback");
                                                JSONObject jSONObject56 = new JSONObject();
                                                Activity a86 = this.mRuntime.a();
                                                if (a86 == null) {
                                                    return true;
                                                }
                                                LiuHaiUtils.initLiuHaiProperty(a86);
                                                jSONObject56.put("isNotch", LiuHaiUtils.isLiuHaiUseValid());
                                                jSONObject56.put("notchHeight", LiuHaiUtils.sNotchHeight);
                                                callJs(optString76, jSONObject56.toString());
                                            } catch (Exception e150) {
                                                z16 = true;
                                                QLog.e("UiApiPlugin", 1, "getNotchInfo Exception:", e150);
                                                return z16;
                                            }
                                        } else if ("setIsOpenTribePicWatermark".equals(str3)) {
                                            try {
                                                JSONObject jSONObject57 = new JSONObject(strArr[0]);
                                                Integer valueOf3 = Integer.valueOf(jSONObject57.optInt("open"));
                                                String optString77 = jSONObject57.optString("callback");
                                                if (valueOf3.intValue() == 1) {
                                                    TroopBarPublishUtils.g(true);
                                                } else if (valueOf3.intValue() == 2) {
                                                    TroopBarPublishUtils.g(false);
                                                }
                                                JSONObject jSONObject58 = new JSONObject();
                                                jSONObject58.put("result", "success");
                                                jSONObject58.put("open", TroopBarPublishUtils.e() ? 1 : 2);
                                                callJs(optString77, jSONObject58.toString());
                                            } catch (JSONException e151) {
                                                z16 = true;
                                                QLog.e("UiApiPlugin", 1, "setIsOpenTribePicWatermark Exception:", e151);
                                                return z16;
                                            }
                                        } else if ("miniAIO".equals(str3)) {
                                            try {
                                                i3 = 0;
                                                try {
                                                    JSONObject jSONObject59 = new JSONObject(strArr[0]);
                                                    String string6 = jSONObject59.getString("action");
                                                    com.tencent.mobileqq.webview.swift.component.z zVar4 = (com.tencent.mobileqq.webview.swift.component.z) this.mRuntime.f().getComponentProvider().a(256);
                                                    int optInt26 = jSONObject59.optInt("busiID");
                                                    String optString78 = jSONObject59.optString("title");
                                                    String optString79 = jSONObject59.optString("style");
                                                    int optInt27 = jSONObject59.optInt("where");
                                                    if ("show".equals(string6)) {
                                                        zVar4.k(optString78);
                                                        zVar4.j(optInt26, optInt27, optString79);
                                                        if (optInt27 == 1) {
                                                            S(optInt26);
                                                        } else {
                                                            zVar4.a();
                                                            zVar4.b(true);
                                                        }
                                                    } else if ("hide".equals(string6)) {
                                                        try {
                                                            zVar4.b(false);
                                                        } catch (Exception e152) {
                                                            exc3 = e152;
                                                            i3 = 0;
                                                            z16 = true;
                                                            QLog.d("UiApiPlugin", 1, exc3, new Object[i3]);
                                                            return z16;
                                                        }
                                                    } else if ("open".equals(string6)) {
                                                        zVar4.k(optString78);
                                                        MiniMsgUser miniMsgUser = this.f238723l0;
                                                        if (miniMsgUser != null) {
                                                            miniMsgUser.onClick(null);
                                                        }
                                                    } else if ("exit".equals(string6)) {
                                                        MiniMsgIPCClient.getInstance().clearBusiness(optInt26);
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("UiApiPlugin", 2, "mini_msg receive jsapi call miniAIO from web action = " + jSONObject59.toString());
                                                    }
                                                } catch (Exception e153) {
                                                    exc3 = e153;
                                                }
                                            } catch (Exception e154) {
                                                exc3 = e154;
                                                i3 = 0;
                                            }
                                        } else if (str3.equals("showKeyboard")) {
                                            showKeyboard();
                                        } else if ("openHippy".equals(str3)) {
                                            try {
                                                jSONObject3 = new JSONObject(strArr[0]);
                                                str7 = jSONObject3.optString("callback");
                                            } catch (JSONException e155) {
                                                jSONException = e155;
                                                str7 = null;
                                            }
                                            try {
                                            } catch (JSONException e156) {
                                                jSONException = e156;
                                                QLog.e("UiApiPlugin", 1, "openHippy error " + jSONException.getMessage());
                                                i16 = -1;
                                                if (!TextUtils.isEmpty(str7)) {
                                                }
                                                return true;
                                            }
                                            try {
                                                if (new OpenHippyInfo(jSONObject3).openHippy(this.mRuntime.a())) {
                                                    i16 = 0;
                                                    if (!TextUtils.isEmpty(str7)) {
                                                        JSONObject jSONObject60 = new JSONObject();
                                                        jSONObject60.put("retCode", i16);
                                                        callJs(str7, jSONObject60.toString());
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(str7)) {
                                                }
                                            } catch (JSONException unused16) {
                                            }
                                            i16 = -1;
                                        } else if (str3.equals("getTokens") && strArr.length > 0) {
                                            try {
                                                str4 = al.c(new JSONObject(strArr[0]).optString("keys"));
                                            } catch (JSONException e157) {
                                                QLog.e("UiApiPlugin", 1, "getTokens error " + e157.getMessage());
                                            }
                                            if (jsBridgeListener != null) {
                                                jsBridgeListener.c(str4);
                                            }
                                        } else {
                                            if (str3.equals("closeHalfWebView")) {
                                                QLog.i("UiApiPlugin", 1, "receive closeHalfWebView");
                                                com.tencent.mobileqq.webview.util.e.f314868a.b();
                                                return true;
                                            }
                                            if (!str3.equals("openHalfWebView") || strArr.length <= 0) {
                                                return true;
                                            }
                                            QLog.i("UiApiPlugin", 1, "receive openHalfWebView");
                                            try {
                                                JSONObject jSONObject61 = new JSONObject(strArr[0]);
                                                String optString80 = jSONObject61.optString("url");
                                                String optString81 = jSONObject61.optString("height");
                                                String optString82 = jSONObject61.optString("nextUrl");
                                                String optString83 = jSONObject61.optString("bgColor");
                                                String optString84 = jSONObject61.optString("closeBefore");
                                                String optString85 = jSONObject61.optString("id");
                                                QLog.i("UiApiPlugin", 1, "schemaBeforeClose is " + optString82);
                                                if (!TextUtils.isEmpty(optString82)) {
                                                    optString82 = URLDecoder.decode(optString82);
                                                }
                                                QLog.i("UiApiPlugin", 1, "schemaBeforeClose after decode is " + optString82);
                                                try {
                                                    Bundle bundle7 = new Bundle();
                                                    float parseFloat = Float.parseFloat(optString81);
                                                    if (!TextUtils.isEmpty(optString82)) {
                                                        float parseFloat2 = Float.parseFloat(cy.k(optString82, "height"));
                                                        bundle7.putString("webViewUrlBeforeClose", cy.k(optString82, "url"));
                                                        bundle7.putFloat("webViewRatioBeforeClose", parseFloat2);
                                                    }
                                                    if (parseFloat != 0.0f) {
                                                        bundle7.putString("webViewBgColor", optString83);
                                                        bundle7.putString("isNeedCloseBefore", optString84);
                                                        com.tencent.mobileqq.webview.util.e.f314868a.i(getCurrentContext(), optString80, bundle7, parseFloat, true);
                                                    } else {
                                                        QLog.e("UiApiPlugin", 1, "height ratio is invalid");
                                                    }
                                                    if (!TextUtils.isEmpty(optString85)) {
                                                        bundle7.putString("businessId", optString85);
                                                    }
                                                } catch (Exception e158) {
                                                    QLog.e("UiApiPlugin", 1, "openHalfWebView parseFloat errot " + e158.getMessage());
                                                }
                                            } catch (Exception e159) {
                                                QLog.e("UiApiPlugin", 1, "openHalfWebView error " + e159.getMessage());
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return z27;
    }

    public com.tencent.mobileqq.webviewplugin.m i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.webviewplugin.m) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.m)) {
            return (com.tencent.mobileqq.webviewplugin.m) d16;
        }
        return null;
    }

    protected final void l0(String str, String str2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, (Object) str2);
            return;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache != null) {
            if (troopInfoFromCache.isTroopOwner(this.mRuntime.b().getAccount())) {
                i3 = 0;
            } else if (troopInfoFromCache.isOwnerOrAdmin()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(null, "P_CliOper", "Grp_flower", "", "mber", str2, 0, 0, str, i3 + "", "", "");
        }
    }

    public void n0(JSONObject jSONObject, JsBridgeListener jsBridgeListener, View.OnClickListener onClickListener) {
        com.tencent.mobileqq.webview.swift.component.v vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, jSONObject, jsBridgeListener, onClickListener);
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        int optInt = jSONObject.optInt("iconID");
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("callback");
        String optString3 = jSONObject.optString("color");
        boolean optBoolean = jSONObject.optBoolean("hidden");
        int optInt2 = jSONObject.optInt("cornerID");
        if (a16 instanceof AbsBaseWebViewActivity) {
            int optInt3 = jSONObject.optInt("navIconUseDefault", -1);
            if (optInt3 >= 0 && (vVar = (com.tencent.mobileqq.webview.swift.component.v) super.getBrowserComponent(2)) != null) {
                com.tencent.mobileqq.webview.swift.r rVar = vVar.f314512m;
                boolean z16 = true;
                if (1 != optInt3) {
                    z16 = false;
                }
                rVar.O = z16;
            }
            ((AbsBaseWebViewActivity) a16).setRightButton(optString2, optString, optString3, optBoolean, optInt, optInt2, jsBridgeListener, onClickListener);
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        com.tencent.mobileqq.webviewplugin.s g16 = this.mRuntime.g();
        if (g16 != null && g16.getWebTitleBarInterface() != null) {
            g16.getWebTitleBarInterface().jg(optString2, optString, optString3, optBoolean, optInt, optInt2, onClickListener, null);
            return;
        }
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.g)) {
            ((com.tencent.mobileqq.webviewplugin.g) d16).h1(optString2, optString, optString3, optBoolean, optInt, optInt2, onClickListener);
            return;
        }
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.h)) {
            ((com.tencent.mobileqq.webviewplugin.h) d16).h1(optString2, optString, optString3, optBoolean, optInt, optInt2, onClickListener);
        } else if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.k)) {
            ((com.tencent.mobileqq.webviewplugin.k) d16).Ja(optString2, optString, optString3, optBoolean, optInt, optInt2, onClickListener, this.mRuntime.e().hashCode());
        }
    }

    public void o0(boolean z16) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        if (z16 == this.f238711d0) {
            return;
        }
        if (z16) {
            View view = this.f238713e0;
            if (view == null) {
                BaseApplication context = BaseApplication.getContext();
                Activity a16 = this.mRuntime.a();
                if (a16 == null || a16.isFinishing() || (relativeLayout = (RelativeLayout) a16.findViewById(R.id.rlCommenTitle)) == null) {
                    return;
                }
                TextView textView = new TextView(a16);
                textView.setId(R.id.az_);
                textView.setText(R.string.close);
                textView.setBackgroundResource(R.drawable.top_button_right_selector);
                textView.setGravity(17);
                textView.setIncludeFontPadding(false);
                textView.setMaxWidth(com.tencent.mobileqq.util.x.c(context, 100.0f));
                textView.setMinWidth(com.tencent.mobileqq.util.x.c(context, 52.0f));
                textView.setSingleLine();
                TextView textView2 = (TextView) relativeLayout.findViewById(R.id.ivTitleBtnLeft);
                if (textView2 != null) {
                    textView.setTextColor(textView2.getTextColors());
                } else {
                    textView.setTextColor(com.tencent.mobileqq.webview.swift.utils.n.token_color_navText_values);
                }
                textView.setTextSize(1, 17.0f);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.tencent.mobileqq.util.x.c(context, 36.0f));
                layoutParams.addRule(0, R.id.f166811ie3);
                layoutParams.addRule(15, -1);
                textView.setOnClickListener(this);
                relativeLayout.addView(textView, layoutParams);
                this.f238713e0 = textView;
            } else {
                view.setVisibility(0);
            }
            this.f238711d0 = true;
        } else {
            View view2 = this.f238713e0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f238711d0 = false;
        }
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment != null && webViewFragment.getSwiftTitleUI() != null) {
            webViewFragment.getSwiftTitleUI().A(z16);
            webViewFragment.getSwiftTitleUI().f314064q0 = z16;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (f238699s0.compareAndSet(false, true)) {
            try {
                Q();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "error:" + e16.toString());
                }
            }
        }
        j0();
        if (f238698r0 != null) {
            this.V = f238697q0.incrementAndGet();
        }
        WeakReference<UiApiPlugin> weakReference = new WeakReference<>(this);
        this.f238721j0 = weakReference;
        f238700t0.add(weakReference);
        if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, "put current UiApiPlugin into sUiApiPluginReferences: " + this.f238721j0.toString());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String str;
        String str2;
        int i16;
        boolean z16;
        String str3;
        String l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        super.onActivityResult(intent, b16, i3);
        if (b16 == 13) {
            if (intent == null) {
                return;
            }
            callJs(intent.getStringExtra("callback"), intent.getStringExtra("result"));
            return;
        }
        String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (b16 == 3) {
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("scanResult");
            if (TextUtils.isEmpty(this.f238724m)) {
                String stringExtra2 = intent.getStringExtra("callback_url");
                String stringExtra3 = intent.getStringExtra("name");
                if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
                    String[] split = stringExtra2.split("#");
                    StringBuilder sb5 = new StringBuilder(split[0]);
                    if (split[0].contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str4 = ContainerUtils.FIELD_DELIMITER;
                    }
                    sb5.append(str4);
                    sb5.append(stringExtra3);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(URLEncoder.encode(stringExtra));
                    if (split.length > 1) {
                        sb5.append("#");
                        sb5.append(split[1]);
                    }
                    if (this.mRuntime.e() == null) {
                        return;
                    }
                    this.mRuntime.e().loadUrl(sb5.toString());
                    return;
                }
                return;
            }
            String str5 = this.f238724m;
            String[] strArr = new String[1];
            if (stringExtra == null) {
                l3 = "''";
            } else {
                l3 = com.tencent.mobileqq.webview.util.s.l(stringExtra);
            }
            strArr[0] = l3;
            callJs(str5, strArr);
            return;
        }
        String str6 = "";
        int i18 = -1;
        if (b16 == 17) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("ret_code", -1);
            String stringExtra4 = intent.getStringExtra("ocr_result");
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(stringExtra4)) {
                    i18 = intExtra;
                }
                jSONObject.put("retCode", i18);
                if (TextUtils.isEmpty(stringExtra4)) {
                    stringExtra4 = "";
                }
                jSONObject.put("result", stringExtra4);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.i("UiApiPlugin", 2, "scanForOCR CODE_OCRCODE result: " + jSONObject.toString());
            }
            if (TextUtils.isEmpty(this.C)) {
                String stringExtra5 = intent.getStringExtra("callback_url");
                String stringExtra6 = intent.getStringExtra("name");
                if (!TextUtils.isEmpty(stringExtra5) && !TextUtils.isEmpty(stringExtra6)) {
                    String[] split2 = stringExtra5.split("#");
                    StringBuilder sb6 = new StringBuilder(split2[0]);
                    if (split2[0].contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str4 = ContainerUtils.FIELD_DELIMITER;
                    }
                    sb6.append(str4);
                    sb6.append(stringExtra6);
                    sb6.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb6.append(URLEncoder.encode(jSONObject.toString()));
                    if (split2.length > 1) {
                        sb6.append("#");
                        sb6.append(split2[1]);
                    }
                    if (this.mRuntime.e() == null) {
                        return;
                    }
                    this.mRuntime.e().loadUrl(sb6.toString());
                    return;
                }
                return;
            }
            callJs(this.C, jSONObject.toString());
            return;
        }
        if (b16 == 4) {
            if (!TextUtils.isEmpty(this.E)) {
                if (i3 == -1) {
                    if (intent != null) {
                        str6 = intent.getStringExtra("result");
                    }
                    callJs(this.E, "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + str6 + "}}");
                    return;
                }
                callJs(this.E, "{\"code\":-1}");
                return;
            }
            return;
        }
        if (b16 == 5) {
            if (!TextUtils.isEmpty(this.F)) {
                if (i3 == -1 && intent != null) {
                    int intExtra2 = intent.getIntExtra("ret", 4);
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "select contact ret:" + intExtra2);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ret", intExtra2);
                        if (intExtra2 == 0) {
                            String[] stringArrayExtra = intent.getStringArrayExtra(GetCMShowInfoServlet.EXTRA_OPENID);
                            int[] intArrayExtra = intent.getIntArrayExtra("types");
                            if (stringArrayExtra != null && intArrayExtra != null && stringArrayExtra.length == intArrayExtra.length) {
                                int length = stringArrayExtra.length;
                                JSONArray jSONArray = new JSONArray();
                                for (int i19 = 0; i19 < length; i19++) {
                                    jSONArray.mo162put(new JSONObject().put("type", intArrayExtra[i19]).put("openID", stringArrayExtra[i19]));
                                }
                                jSONObject2.put("contacts", jSONArray);
                            }
                        } else {
                            jSONObject2.put("errMsg", intent.getStringExtra("errMsg"));
                        }
                        callJs(this.F, jSONObject2.toString());
                        return;
                    } catch (JSONException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "select contact result json exception", e17);
                        }
                        callJs(this.F, "{\"ret\":4}");
                        return;
                    }
                }
                callJs(this.F, "{\"ret\":3}");
                return;
            }
            return;
        }
        if (b16 == 7) {
            if (!TextUtils.isEmpty(this.E)) {
                if (i3 == -1 && intent != null) {
                    int intExtra3 = intent.getIntExtra("ret", 0);
                    if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "select Member ret:" + intExtra3);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("ret", intExtra3);
                        if (intExtra3 == 0) {
                            jSONObject3.put("selectMore", this.K);
                            jSONObject3.put("uin", this.J);
                            jSONObject3.put("uinType", "0");
                            JSONArray jSONArray2 = new JSONArray();
                            if (this.K) {
                                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                                for (int i26 = 0; i26 < parcelableArrayListExtra.size(); i26++) {
                                    ResultRecord resultRecord = (ResultRecord) parcelableArrayListExtra.get(i26);
                                    jSONArray2.mo162put(new JSONObject().put("memUin", resultRecord.uin).put("nick", resultRecord.name));
                                }
                            } else {
                                jSONArray2.mo162put(new JSONObject().put("memUin", intent.getStringExtra("member_uin")).put("nick", intent.getStringExtra("member_display_name")));
                            }
                            jSONObject3.put("selectUins", jSONArray2);
                        } else {
                            jSONObject3.put("errMsg", intent.getStringExtra("errMsg"));
                        }
                        callJs(this.E, jSONObject3.toString());
                        return;
                    } catch (JSONException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "select contact result json exception", e18);
                        }
                        callJs(this.E, "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}");
                        return;
                    }
                }
                callJs(this.E, "{\"ret\":1,\"errMsg\":\"User cancle\"}");
                return;
            }
            return;
        }
        if (b16 == 6) {
            if (!TextUtils.isEmpty(this.E)) {
                if (i3 == -1 && intent != null) {
                    callJs(this.E, "{'retcode' : 0}");
                    return;
                }
                if (intent != null) {
                    i18 = intent.getIntExtra("retCode", -1);
                }
                callJs(this.E, "{'retcode' : " + i18 + "}");
                return;
            }
            return;
        }
        if (b16 != 8 && b16 != 9) {
            if (b16 == 10) {
                if (i3 == -1 && intent != null) {
                    com.tencent.mobileqq.troop.utils.am.s(this.mRuntime.a(), intent, null);
                    l0(intent.getStringExtra("troop_uin"), "send_page");
                    return;
                }
                return;
            }
            if (b16 == 11) {
                if (intent != null) {
                    str3 = intent.getStringExtra("callback");
                    z16 = intent.getBooleanExtra("isOpenApi", false);
                } else {
                    z16 = false;
                    str3 = null;
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = this.N;
                    z16 = this.P;
                    if (TextUtils.isEmpty(str3) && !z16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("UiApiPlugin", 2, "groupOrganizationView no callback");
                            return;
                        }
                        return;
                    }
                }
                boolean z17 = z16;
                String str7 = str3;
                this.N = null;
                this.P = false;
                if (intent == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("UiApiPlugin", 2, "groupOrganization result intent=null");
                    }
                    if (z17) {
                        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
                        return;
                    } else {
                        callJs(str7, "{ret:4}");
                        return;
                    }
                }
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    int intExtra4 = intent.getIntExtra("ret", 5);
                    jSONObject4.put("ret", intExtra4);
                    String stringExtra7 = intent.getStringExtra("errMsg");
                    if (!TextUtils.isEmpty(stringExtra7)) {
                        jSONObject4.put("errMsg", stringExtra7);
                    }
                    if (intExtra4 == 0) {
                        String[] stringArrayExtra2 = intent.getStringArrayExtra("result");
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str8 : stringArrayExtra2) {
                            jSONArray3.mo162put(str8);
                        }
                        jSONObject4.put("openIDArr", jSONArray3);
                    }
                    if (z17) {
                        if (intExtra4 != 0) {
                            i17 = -100;
                        }
                        callJs4OpenApiIfNeeded("groupOrganizationView", i17, jSONObject4.toString());
                        return;
                    }
                    callJs(str7, jSONObject4.toString());
                    return;
                } catch (JSONException e19) {
                    if (QLog.isColorLevel()) {
                        QLog.w("UiApiPlugin", 2, "groupOrganization error", e19);
                    }
                    if (z17) {
                        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
                        return;
                    } else {
                        callJs(str7, "{ret:4}");
                        return;
                    }
                }
            }
            if (b16 == 12) {
                if (intent != null) {
                    int intExtra5 = intent.getIntExtra("cGroupOption", -1);
                    String stringExtra8 = intent.getStringExtra("troop_uin");
                    if (intent.getBooleanExtra("isSetFee", false)) {
                        i16 = 4;
                    } else if (intExtra5 != 1) {
                        if (intExtra5 != 2) {
                            if (intExtra5 != 3) {
                                if (intExtra5 != 4) {
                                    if (intExtra5 != 5) {
                                        i16 = -1;
                                    } else {
                                        i16 = 2;
                                    }
                                } else {
                                    i16 = 3;
                                }
                            } else {
                                i16 = 5;
                            }
                        } else {
                            i16 = 1;
                        }
                    } else {
                        i16 = 0;
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("gc", stringExtra8);
                        jSONObject5.put("ret", 0);
                        jSONObject5.put("joinType", i16);
                    } catch (JSONException e26) {
                        e26.printStackTrace();
                    }
                    callJs(this.Q, jSONObject5.toString());
                    return;
                }
                return;
            }
            if (b16 == 15) {
                if (!TextUtils.isEmpty(this.H)) {
                    String str9 = this.H;
                    String[] strArr2 = new String[1];
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("{'result' : ");
                    if (i3 == -1) {
                        str2 = "true";
                    } else {
                        str2 = "false";
                    }
                    sb7.append(str2);
                    sb7.append("}");
                    strArr2[0] = sb7.toString();
                    callJs(str9, strArr2);
                    return;
                }
                return;
            }
            if (b16 == 16 && !TextUtils.isEmpty(this.I)) {
                String str10 = this.I;
                String[] strArr3 = new String[1];
                StringBuilder sb8 = new StringBuilder();
                sb8.append("{'result' : ");
                if (i3 == -1) {
                    str = "true";
                } else {
                    str = "false";
                }
                sb8.append(str);
                sb8.append("}");
                strArr3[0] = sb8.toString();
                callJs(str10, strArr3);
                return;
            }
            return;
        }
        if (i3 == -1 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("key_troop_fee_notify_js_data_changed", false);
            String stringExtra9 = intent.getStringExtra("callback");
            if (booleanExtra) {
                callJs(stringExtra9, "{}");
            }
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) dialogInterface);
        } else if (!TextUtils.isEmpty(this.f238714f)) {
            callJs(this.f238714f, "1", Integer.toString(this.f238719i));
        } else {
            callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.f238719i));
        }
    }

    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
    public void onClick(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, i3);
            return;
        }
        if (!TextUtils.isEmpty(this.f238714f)) {
            if (this.f238717h && i3 == 0) {
                callJs(this.f238714f, "2", Integer.toString(i3));
            } else {
                callJs(this.f238714f, "0", Integer.toString(i3));
            }
        } else {
            callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(i3));
        }
        this.f238712e.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.f238721j0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, "remove current UiApiPlugin from sUiApiPluginReferences: " + this.f238721j0.toString());
            }
            f238700t0.remove(this.f238721j0);
            this.f238721j0 = null;
        }
        H0();
        this.f238715f0 = null;
        this.f238718h0 = null;
        this.f238708b0 = null;
        ActionSheet actionSheet = this.f238712e;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.f238712e.dismiss();
        }
        com.tencent.biz.troop.b bVar = this.R;
        if (bVar != null) {
            bVar.q();
        }
        if (this.f238722k0) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.Y);
        }
        MiniMsgUser miniMsgUser = this.f238723l0;
        if (miniMsgUser != null) {
            miniMsgUser.onBackground();
            this.f238723l0.destroy();
            this.f238723l0 = null;
        }
        I0();
        super.onDestroy();
    }

    @Override // com.tencent.widget.ActionSheet.OnDismissListener
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (!TextUtils.isEmpty(this.f238714f)) {
            callJs(this.f238714f, "1", Integer.toString(this.f238719i));
        } else {
            callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.f238719i));
        }
    }

    @Override // com.tencent.widget.ActionSheet.WatchDismissActions
    public void onDismissOperations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 instanceof PublicFragmentActivity) {
            ((PublicFragmentActivity) a16).G2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) customWebView);
            return;
        }
        super.onWebViewCreated(customWebView);
        if (f238703w0.compareAndSet(false, true) && QbSdk.getTbsVersion(this.mRuntime.a()) >= 44001) {
            T();
        }
    }

    public void q0(JSONObject jSONObject) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject != null) {
            final Activity a16 = this.mRuntime.a();
            WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
            if (webViewFragment != null) {
                final String optString = jSONObject.optString("iconID1");
                jSONObject.optString("schemeType1");
                final String optString2 = jSONObject.optString("_sharedCallbackID1");
                String optString3 = jSONObject.optString("voiceStr1");
                int optInt = jSONObject.optInt("cornerID1");
                final String optString4 = jSONObject.optString("iconID2");
                jSONObject.optString("schemeType2");
                final String optString5 = jSONObject.optString("_sharedCallbackID2");
                String optString6 = jSONObject.optString("voiceStr2");
                int optInt2 = jSONObject.optInt("cornerID2");
                webViewFragment.getSwiftTitleUI().E.setVisibility(0);
                com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) super.getBrowserComponent(2);
                if (vVar != null && vVar.F()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f238728p0 = E(optString4);
                com.tencent.mobileqq.webview.swift.utils.o.d(webViewFragment.getSwiftTitleUI().E, 1, this.f238728p0, z16);
                webViewFragment.getSwiftTitleUI().E.setContentDescription(optString6);
                webViewFragment.getSwiftTitleUI().E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.jsp.ai
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UiApiPlugin.this.Z(a16, optString4, optString5, view);
                    }
                });
                p0(webViewFragment.getSwiftTitleUI().E, webViewFragment.getSwiftTitleUI().F, optInt2);
                ViewGroup viewGroup = webViewFragment.getSwiftTitleUI().M;
                ImageView imageView = this.f238725m0;
                if (imageView != null) {
                    viewGroup.removeView(imageView);
                } else {
                    ImageView imageView2 = new ImageView(a16);
                    this.f238725m0 = imageView2;
                    imageView2.setId(R.id.f98245mk);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(0, R.id.f166811ie3);
                    layoutParams.addRule(15);
                    layoutParams.rightMargin = com.tencent.mobileqq.util.x.c(a16.getApplicationContext(), 10.0f);
                    this.f238725m0.setLayoutParams(layoutParams);
                }
                int E = E(optString);
                this.f238727o0 = E;
                com.tencent.mobileqq.webview.swift.utils.o.d(this.f238725m0, 1, E, z16);
                this.f238725m0.setContentDescription(optString3);
                this.f238725m0.setVisibility(0);
                this.f238725m0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.jsp.aj
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UiApiPlugin.this.a0(a16, optString, optString2, view);
                    }
                });
                webViewFragment.getSwiftTitleUI().A(false);
                viewGroup.addView(this.f238725m0);
                p0(this.f238725m0, this.f238726n0, optInt);
                return;
            }
            QLog.e("UiApiPlugin", 1, "setDoubleRightButton, not support " + a16);
        }
    }

    public void r0(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) jSONObject);
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing() && jSONObject != null) {
            String optString = jSONObject.optString("title");
            if (!TextUtils.isEmpty(optString)) {
                WebViewPlugin.b bVar = this.mRuntime;
                com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
                if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.k)) {
                    ((com.tencent.mobileqq.webviewplugin.k) d16).Eg(optString, this.mRuntime.e().hashCode());
                } else if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.g)) {
                    ((com.tencent.mobileqq.webviewplugin.g) d16).R8(optString);
                } else {
                    TextView textView = (TextView) a16.findViewById(R.id.ivTitleBtnLeft);
                    if (textView != null) {
                        textView.setText(optString);
                    }
                }
            }
            String optString2 = jSONObject.optString("callback");
            try {
                CustomWebView e16 = this.mRuntime.e();
                if (e16 != null) {
                    WebViewPluginEngine pluginEngine = e16.getPluginEngine();
                    String url = e16.getUrl();
                    if (pluginEngine != null && !TextUtils.isEmpty(url)) {
                        boolean F = pluginEngine.i().F(url, "ui.setLeftCloseHandler");
                        if (F) {
                            this.D = optString2;
                            SwiftBrowserStatistics.P("ui.setLeftCloseHandler", url);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("UiApiPlugin", 2, "setLeftCloseHandler url:", url, " hasRight:", Boolean.valueOf(F));
                        }
                    }
                }
            } catch (Exception e17) {
                QLog.e("UiApiPlugin", 1, "e:", e17.toString());
            }
        }
    }

    public void showKeyboard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            Activity a16 = this.mRuntime.a();
            WebViewProvider f16 = this.mRuntime.f();
            if (a16 != null && f16 != null) {
                ((InputMethodManager) a16.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(2, 0);
            }
        } catch (Exception e16) {
            QLog.d("UiApiPlugin", 1, e16, new Object[0]);
        }
    }

    public void t0(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) jSONObject);
        } else if (jSONObject != null) {
            n0(jSONObject, null, new e(jSONObject));
        }
    }

    public void u0(JSONObject jSONObject, JsBridgeListener jsBridgeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) jSONObject, (Object) jsBridgeListener);
        } else if (jSONObject != null) {
            n0(jSONObject, jsBridgeListener, null);
        }
    }

    public void v0(int i3, boolean z16, boolean z17, String str) {
        Drawable drawable;
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), str);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            RelativeLayout relativeLayout = (RelativeLayout) a16.findViewById(R.id.rlCommenTitle);
            if (i3 != 1) {
                drawable = null;
                dVar = null;
            } else {
                drawable = a16.getResources().getDrawable(R.drawable.elq);
                if (!TextUtils.isEmpty(str)) {
                    dVar = new d(str);
                } else {
                    dVar = null;
                }
            }
            View view = this.L;
            if (view != null) {
                if (!z17) {
                    relativeLayout.removeView(view);
                    this.L = null;
                    this.M = null;
                    return;
                }
                ImageView imageView = this.M;
                if (imageView != null) {
                    if (z16) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                    }
                    this.L.setImageDrawable(drawable);
                    this.L.setOnClickListener(dVar);
                    this.L.invalidate();
                    return;
                }
                return;
            }
            ImageView imageView2 = new ImageView(a16);
            this.M = imageView2;
            imageView2.setImageDrawable(a16.getResources().getDrawable(R.drawable.skin_tips_dot));
            ImageView imageView3 = new ImageView(a16);
            this.L = imageView3;
            imageView3.setImageDrawable(drawable);
            this.L.setOnClickListener(dVar);
            RelativeLayout relativeLayout2 = new RelativeLayout(a16);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            relativeLayout2.addView(this.L, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.tencent.mobileqq.util.x.c(context, 8.0f), com.tencent.mobileqq.util.x.c(context, 8.0f));
            layoutParams2.addRule(10, -1);
            layoutParams2.addRule(11, -1);
            layoutParams2.setMargins(0, com.tencent.mobileqq.util.x.c(context, 4.0f), com.tencent.mobileqq.util.x.c(context, 4.0f), 0);
            relativeLayout2.addView(this.M, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.tencent.mobileqq.util.x.c(context, 36.0f), com.tencent.mobileqq.util.x.c(context, 36.0f));
            layoutParams3.addRule(0, R.id.f166811ie3);
            layoutParams3.addRule(15, -1);
            layoutParams3.setMargins(0, 0, com.tencent.mobileqq.util.x.c(context, 4.0f), 0);
            if (relativeLayout != null) {
                relativeLayout.addView(relativeLayout2, layoutParams3);
            }
        }
    }

    public void w(String str, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str, (Object) jSONObject);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("action", str);
            jSONObject2.put("options", jSONObject);
            callJs("javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + jSONObject2.toString() + ");");
        } catch (Exception e16) {
            QLog.d("UiApiPlugin", 1, e16, new Object[0]);
        }
    }

    public void w0(int i3) {
        Drawable drawable;
        Drawable maskDrawableByColor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
            return;
        }
        ImageView imageView = this.f238725m0;
        if (imageView != null && (drawable = imageView.getDrawable()) != null && (maskDrawableByColor = BaseImageUtil.maskDrawableByColor(drawable, i3)) != null) {
            this.f238725m0.setImageDrawable(maskDrawableByColor);
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else if (this.U.isShowing()) {
            this.U.dismiss();
        }
    }

    protected void x0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            if (!AppNetConnInfo.isNetSupport()) {
                QQToast.makeText(this.mRuntime.b().getApplication(), 1, HardCodeUtil.qqStr(R.string.uss), 0).show();
                return;
            }
            ProgressDialog progressDialog = this.X;
            if (progressDialog == null) {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(a16, R.style.qZoneInputDialog);
                this.X = reportProgressDialog;
                reportProgressDialog.setCancelable(true);
                this.X.show();
                this.X.setContentView(R.layout.f168383uh);
                ((TextView) this.X.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(HardCodeUtil.qqStr(R.string.usu));
            } else {
                progressDialog.show();
            }
            File file = new File(AbsDownloader.getFilePath(str));
            if (file.exists()) {
                this.X.dismiss();
                z0(file);
            } else {
                Bundle bundle = new Bundle();
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, file);
                gVar.A = 60L;
                ((DownloaderFactory) this.mRuntime.b().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(gVar, new com.tencent.mobileqq.vip.f(str) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.21
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ String f238742a;

                    {
                        this.f238742a = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UiApiPlugin.this, (Object) str);
                        }
                    }

                    @Override // com.tencent.mobileqq.vip.f
                    public void onDone(com.tencent.mobileqq.vip.g gVar2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) gVar2);
                            return;
                        }
                        Activity a17 = UiApiPlugin.this.mRuntime.a();
                        if (a17 != null && !a17.isFinishing()) {
                            if (gVar2.f313006d == 0) {
                                File file2 = new File(AbsDownloader.getFilePath(this.f238742a));
                                if (file2.exists()) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile success: " + this.f238742a);
                                    }
                                    a17.runOnUiThread(new Runnable(file2) { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.21.1
                                        static IPatchRedirector $redirector_;

                                        /* renamed from: d, reason: collision with root package name */
                                        final /* synthetic */ File f238744d;

                                        {
                                            this.f238744d = file2;
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass21.this, (Object) file2);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                            } else {
                                                UiApiPlugin.this.X.dismiss();
                                                UiApiPlugin.this.z0(this.f238744d);
                                            }
                                        }
                                    });
                                    return;
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile failed: " + this.f238742a);
                            }
                            a17.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.jsp.UiApiPlugin.21.2
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass21.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        UiApiPlugin.this.X.dismiss();
                                        QQToast.makeText(UiApiPlugin.this.mRuntime.b().getApplication(), 1, HardCodeUtil.qqStr(R.string.usq), 0).show();
                                    }
                                }
                            });
                        }
                    }
                }, bundle);
            }
        }
    }

    protected void y0(byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) bArr, (Object) str);
            return;
        }
        String str2 = AppConstants.SDCARD_PATH + "diskcache/Image_" + str;
        FileUtils.writeFile(bArr, str2);
        z0(new File(str2));
    }

    protected void z0(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) file);
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            String absolutePath = file.getAbsolutePath();
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, absolutePath);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, absolutePath);
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, absolutePath);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(a16, intent, 18);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity a16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        } else if (view == this.f238713e0 && (a16 = this.mRuntime.a()) != null) {
            a16.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    void I0() {
    }

    void j0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        WebResourceResponse webResourceResponse;
        Exception e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3));
        }
        if (j3 == 8 && str.equalsIgnoreCase("https://qq-web.cdn-go.cn/qui/latest/qui/token.css")) {
            int i3 = -1;
            try {
                String b16 = al.b();
                i3 = b16.length();
                webResourceResponse = new WebResourceResponse("text/css", Charset.defaultCharset().name(), new ByteArrayInputStream(b16.getBytes(Charset.defaultCharset())));
                try {
                    Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
                    if (responseHeaders == null) {
                        responseHeaders = new HashMap<>();
                    }
                    responseHeaders.put("cache-control", "no-store, must-revalidate");
                    webResourceResponse.setResponseHeaders(responseHeaders);
                } catch (Exception e17) {
                    e16 = e17;
                    QLog.e("UiApiPlugin", 1, "handleEvent[KEY_EVENT_LOAD_RESOURCE] exception. ", e16);
                    QLog.d("UiApiPlugin", 1, "handleEvent[KEY_EVENT_LOAD_RESOURCE] token css length: " + i3 + ", res: " + webResourceResponse);
                    return webResourceResponse;
                }
            } catch (Exception e18) {
                webResourceResponse = null;
                e16 = e18;
            }
            QLog.d("UiApiPlugin", 1, "handleEvent[KEY_EVENT_LOAD_RESOURCE] token css length: " + i3 + ", res: " + webResourceResponse);
            return webResourceResponse;
        }
        return super.handleEvent(str, j3);
    }
}
