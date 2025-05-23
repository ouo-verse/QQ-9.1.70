package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTencentDocs;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.TencentDocsIsDetailPageProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.LoginTicketManager;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper;
import com.tencent.mobileqq.teamwork.WebViewWrapperForDoc;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TeamWorkDocEditBrowserActivity extends QQBrowserActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    public AppInterface f177177a0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class TeamWorkDocEditBrowserFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;
        private int C;
        public int D;
        String E;
        public boolean F;
        public RelativeLayout G;
        ImageView H;
        ImageView I;
        ImageView J;
        SessionInfo K;
        public int L;
        public int M;
        public boolean N;
        public InputLinearLayout P;
        public EditText Q;
        public Button R;
        public boolean S;
        public String T;
        public String U;
        boolean V;
        TextView W;
        private ImageView X;
        public int Y;
        private boolean Z;

        /* renamed from: a0, reason: collision with root package name */
        private boolean f177178a0;

        /* renamed from: b0, reason: collision with root package name */
        private WebViewWrapperForDoc f177179b0;

        /* renamed from: c0, reason: collision with root package name */
        boolean f177180c0;

        /* renamed from: d0, reason: collision with root package name */
        WeakReferenceHandler f177181d0;

        /* renamed from: e0, reason: collision with root package name */
        Handler.Callback f177182e0;

        /* renamed from: f0, reason: collision with root package name */
        private boolean f177183f0;

        /* renamed from: g0, reason: collision with root package name */
        private com.tencent.mobileqq.teamwork.x f177184g0;

        /* renamed from: h0, reason: collision with root package name */
        protected com.tencent.mobileqq.emosm.t f177185h0;

        /* renamed from: i0, reason: collision with root package name */
        private View f177186i0;

        /* renamed from: j0, reason: collision with root package name */
        private boolean f177187j0;

        /* renamed from: k0, reason: collision with root package name */
        private int f177188k0;

        /* renamed from: l0, reason: collision with root package name */
        private boolean f177189l0;

        /* renamed from: m0, reason: collision with root package name */
        private boolean f177190m0;

        /* renamed from: n0, reason: collision with root package name */
        Handler f177191n0;

        /* renamed from: o0, reason: collision with root package name */
        Handler.Callback f177192o0;

        /* renamed from: p0, reason: collision with root package name */
        private boolean f177193p0;

        /* renamed from: q0, reason: collision with root package name */
        boolean f177194q0;

        /* renamed from: r0, reason: collision with root package name */
        boolean f177195r0;

        /* renamed from: s0, reason: collision with root package name */
        private long f177196s0;

        /* renamed from: t0, reason: collision with root package name */
        public int f177197t0;

        /* renamed from: u0, reason: collision with root package name */
        ViewTreeObserver.OnGlobalLayoutListener f177198u0;

        /* renamed from: v0, reason: collision with root package name */
        private boolean f177199v0;

        /* renamed from: w0, reason: collision with root package name */
        private int f177200w0;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$14, reason: invalid class name */
        /* loaded from: classes9.dex */
        class AnonymousClass14 implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Share f177203d;

            AnonymousClass14(Share share) {
                this.f177203d = share;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this, (Object) share);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void c(Share share, int i3, Object obj) {
                share.j(1, i3, 2, ((Boolean) obj).booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(final Share share, final int i3, final Object obj) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.fm
                    @Override // java.lang.Runnable
                    public final void run() {
                        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.AnonymousClass14.c(Share.this, i3, obj);
                    }
                }, 3000L);
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                final int i3 = this.f177203d.y().f292297c;
                String currentAccountUin = TeamWorkDocEditBrowserFragment.this.getAppRuntime().getCurrentAccountUin();
                String str = this.f177203d.y().f292308n;
                String str2 = this.f177203d.y().f292307m;
                final Share share = this.f177203d;
                TeamWorkHandlerUtils.q(currentAccountUin, str, str2, 1, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.activity.fl
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.AnonymousClass14.d(Share.this, i3, obj);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$9, reason: invalid class name */
        /* loaded from: classes9.dex */
        public class AnonymousClass9 implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f177206d;

            AnonymousClass9(String str) {
                this.f177206d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this, (Object) str);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(Object obj) {
                if (!(obj instanceof String)) {
                    return;
                }
                TeamWorkDocEditBrowserFragment.this.Rh((String) obj);
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (TeamWorkDocEditBrowserFragment.this.getAppRuntime() == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e(WebViewFragment.TAG, 2, "saveTempPadFromQQ: prvurl " + this.f177206d);
                    }
                    jSONObject.put("prvurl", this.f177206d);
                    ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(jSONObject, TeamWorkDocEditBrowserFragment.this.getAppRuntime().getCurrentAccountUin(), "https://qqandroid.docs.qq.com/preview/imp/save_to_mylist", ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.activity.fn
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                        public final void a(Object obj) {
                            TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.AnonymousClass9.this.b(obj);
                        }
                    });
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements ViewTreeObserver.OnGlobalLayoutListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Rect rect = new Rect();
                TeamWorkDocEditBrowserFragment.this.getUIStyleHandler().V.getWindowVisibleDisplayFrame(rect);
                int height = TeamWorkDocEditBrowserFragment.this.getUIStyleHandler().V.getRootView().getHeight();
                int i3 = height - rect.bottom;
                TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment = TeamWorkDocEditBrowserFragment.this;
                RelativeLayout relativeLayout = teamWorkDocEditBrowserFragment.G;
                if (relativeLayout != null && teamWorkDocEditBrowserFragment.f177197t0 != i3) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, i3);
                    TeamWorkDocEditBrowserFragment.this.G.setLayoutParams(layoutParams);
                    TeamWorkDocEditBrowserFragment.this.f177197t0 = i3;
                }
                if (i3 > height / 3) {
                    TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment2 = TeamWorkDocEditBrowserFragment.this;
                    if (teamWorkDocEditBrowserFragment2.S) {
                        teamWorkDocEditBrowserFragment2.li(false);
                    } else {
                        teamWorkDocEditBrowserFragment2.li(true);
                    }
                    TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment3 = TeamWorkDocEditBrowserFragment.this;
                    if (teamWorkDocEditBrowserFragment3.D == 2) {
                        teamWorkDocEditBrowserFragment3.R.setVisibility(0);
                    }
                    com.tencent.av.utils.ba.px2dp(BaseApplicationImpl.getApplication(), TeamWorkDocEditBrowserFragment.this.L + i3);
                    return;
                }
                TeamWorkDocEditBrowserFragment.this.li(false);
                TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment4 = TeamWorkDocEditBrowserFragment.this;
                if (teamWorkDocEditBrowserFragment4.D == 2) {
                    teamWorkDocEditBrowserFragment4.R.setVisibility(8);
                }
                if (TeamWorkDocEditBrowserFragment.this.D == 2) {
                    com.tencent.av.utils.ba.px2dp(BaseApplicationImpl.getApplication(), TeamWorkDocEditBrowserFragment.this.L);
                }
                TeamWorkDocEditBrowserFragment.this.V = false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b implements ActionSheet.OnButtonClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ActionSheet f177208d;

            b(ActionSheet actionSheet) {
                this.f177208d = actionSheet;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this, (Object) actionSheet);
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
                    TeamWorkDocEditBrowserFragment.this.Z = true;
                    this.f177208d.dismiss();
                    TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment = TeamWorkDocEditBrowserFragment.this;
                    teamWorkDocEditBrowserFragment.ki(teamWorkDocEditBrowserFragment.getShareUrl());
                    return;
                }
                if (i3 == 1) {
                    this.f177208d.dismiss();
                    TeamWorkDocEditBrowserFragment.this.getQBaseActivity().finish();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class c implements Handler.Callback {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                ArrayList<String> stringArrayListExtra;
                ArrayList<String> stringArrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            TeamWorkDocEditBrowserFragment.this.Qh();
                        }
                    } else {
                        TeamWorkDocEditBrowserFragment.this.Oh(null);
                    }
                } else {
                    Intent intent = (Intent) message.obj;
                    TeamWorkDocEditBrowserFragment.this.M = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0);
                    if (55 == intent.getIntExtra(com.tencent.mobileqq.utils.d.f307603i, -1) && intent.getExtras().containsKey("PhotoConst.PHOTO_PATHS") && (stringArrayList = intent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS")) != null && stringArrayList.size() > 0) {
                        TeamWorkDocEditBrowserFragment.this.Vh(BaseApplicationImpl.getApplication(), stringArrayList);
                        return true;
                    }
                    if (intent.getBooleanExtra("IS_FROM_PREVIEW_ACTIVITY", false) && (stringArrayListExtra = intent.getStringArrayListExtra("key_photo_preview")) != null) {
                        TeamWorkDocEditBrowserFragment.this.Vh(BaseApplicationImpl.getApplication(), stringArrayListExtra);
                    }
                }
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class d implements Handler.Callback {
            static IPatchRedirector $redirector_;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                int i3 = message.what;
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (TeamWorkDocEditBrowserFragment.this.getSwiftTitleUI().C != null && !TeamWorkDocEditBrowserFragment.this.getSwiftTitleUI().C.isEnabled()) {
                            TeamWorkDocEditBrowserFragment.this.getSwiftTitleUI().C.setEnabled(true);
                        }
                        QQToast.makeText(TeamWorkDocEditBrowserFragment.this.getQBaseActivity(), HardCodeUtil.qqStr(R.string.f172755u00), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                } else {
                    if (TeamWorkDocEditBrowserFragment.this.getSwiftTitleUI().C != null && !TeamWorkDocEditBrowserFragment.this.getSwiftTitleUI().C.isEnabled()) {
                        TeamWorkDocEditBrowserFragment.this.getSwiftTitleUI().C.setEnabled(true);
                    }
                    String str = (String) message.obj;
                    if (TeamWorkDocEditBrowserFragment.this.Z) {
                        TeamWorkDocEditBrowserFragment.this.vi(1);
                        TeamWorkDocEditBrowserFragment.this.getQBaseActivity().finish();
                    } else {
                        TeamWorkDocEditBrowserFragment.this.vi(0);
                        TeamWorkDocEditBrowserFragment.this.ji(str);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("savedUrl", str);
                    int i16 = ((TeamWorkFileImportInfo) TeamWorkDocEditBrowserFragment.this.getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO)).R;
                    if (i16 == 3) {
                        bundle.putInt("editType", 1);
                    } else if (i16 == 6) {
                        bundle.putInt("editType", 2);
                    }
                    if (TeamWorkDocEditBrowserFragment.this.getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO) != null) {
                        bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, TeamWorkDocEditBrowserFragment.this.getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO));
                    }
                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_save_team_work", "", -1, bundle));
                }
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class e implements b.d {
            static IPatchRedirector $redirector_;

            e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.component.b.d
            public Object a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                if (i3 != 256) {
                    return null;
                }
                return new com.tencent.mobileqq.teamwork.bm();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class f implements TextView.OnEditorActionListener {
            static IPatchRedirector $redirector_;

            f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                }
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z16 = false;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
                } else if (i3 == 1 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) {
                    TeamWorkDocEditBrowserFragment.super.getWebView().callJs("onTabKeyDown()");
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return z16;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class g extends com.tencent.mobileqq.webview.swift.proxy.b {
            static IPatchRedirector $redirector_;

            g(com.tencent.mobileqq.webviewplugin.q qVar) {
                super(qVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this, (Object) qVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
            public void jg(String str, String str2, String str3, boolean z16, int i3, int i16, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), onClickListener, aVar);
                } else {
                    TeamWorkDocEditBrowserFragment.this.getUIStyle().S = true;
                    super.jg(str, str2, str3, z16, i3, i16, onClickListener, aVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class h extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            h(com.tencent.mobileqq.webview.swift.utils.t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public boolean interceptStartLoadUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                }
                return TeamWorkDocEditBrowserFragment.this.interceptStartLoadUrl();
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    super.onFinalState(bundle);
                    TeamWorkDocEditBrowserFragment.this.ai(bundle);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onPageFinished(WebView webView, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
                } else {
                    TeamWorkDocEditBrowserFragment.this.bi(webView, str, this.webViewKernelCallBack);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onShowPreview(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                } else {
                    super.onShowPreview(bundle);
                    TeamWorkDocEditBrowserFragment.this.ci(bundle);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle, (Object) touchWebView);
                } else {
                    TeamWorkDocEditBrowserFragment.this.ei(bundle, touchWebView, this.webViewKernelCallBack);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class i implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            i() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    int intExtra = ((WebViewFragment) TeamWorkDocEditBrowserFragment.this).intent.getIntExtra(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, -1);
                    if (intExtra != 1 && intExtra != 2) {
                        int i3 = TeamWorkDocEditBrowserFragment.this.D;
                    }
                    String shareUrl = TeamWorkDocEditBrowserFragment.this.getShareUrl();
                    String B = ((Share) TeamWorkDocEditBrowserFragment.this.getShare()).B();
                    Intent intent = new Intent(TeamWorkDocEditBrowserFragment.super.getQBaseActivity(), (Class<?>) TeamWorkAuthorizeSettingFragment.class);
                    if (!TextUtils.isEmpty(B)) {
                        intent.putExtra("team_work_name", B);
                    }
                    intent.putExtra("team_work_pad_url", shareUrl);
                    intent.putExtra("team_work_pad_list_type", TeamWorkDocEditBrowserFragment.this.Y);
                    PublicFragmentActivity.start(TeamWorkDocEditBrowserFragment.this.getQBaseActivity(), intent, TeamWorkAuthorizeSettingFragment.class);
                    TeamWorkDocEditBrowserFragment.this.gi(14);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public TeamWorkDocEditBrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.C = -1;
            this.E = "";
            this.F = true;
            this.K = new SessionInfo();
            this.N = true;
            this.W = null;
            this.Y = -1;
            this.Z = false;
            this.f177180c0 = false;
            this.f177182e0 = new c();
            this.f177187j0 = false;
            this.f177188k0 = -1000;
            this.f177189l0 = true;
            this.f177190m0 = false;
            this.f177192o0 = new d();
            this.f177193p0 = false;
            this.f177194q0 = false;
            this.f177195r0 = false;
            this.f177196s0 = 0L;
            this.f177198u0 = new a();
        }

        private void Uh() {
            this.f177185h0 = new com.tencent.mobileqq.emosm.t() { // from class: com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.emosm.t
                public void onBindedToClient() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(WebViewFragment.TAG, 2, "-->onBindedToClient");
                    }
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                TeamWorkDocEditBrowserFragment.this.Yh();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 30L);
                }

                @Override // com.tencent.mobileqq.emosm.t
                public void onDisconnectWithService() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(WebViewFragment.TAG, 2, "-->onDisconnectWithService");
                    }
                }

                @Override // com.tencent.mobileqq.emosm.t
                public void onPushMsg(Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(WebViewFragment.TAG, 2, "-->onPushMsg");
                    }
                }

                @Override // com.tencent.mobileqq.emosm.t
                public void onResponse(Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(WebViewFragment.TAG, 2, "-->onResponse");
                    }
                    if (bundle == null) {
                        return;
                    }
                    int i3 = bundle.getInt("respkey", 0);
                    TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment = TeamWorkDocEditBrowserFragment.this;
                    if (i3 == teamWorkDocEditBrowserFragment.f177185h0.key) {
                        teamWorkDocEditBrowserFragment.f177189l0 = false;
                        String string = bundle.getString("cmd");
                        bundle.getString("callbackid");
                        Bundle bundle2 = bundle.getBundle("response");
                        Bundle bundle3 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                        long b16 = lr2.a.b("get_url_time");
                        if ("ipc_cmd_get_team_work_url".equals(string) && TeamWorkDocEditBrowserFragment.this.f177184g0 != null) {
                            String string2 = bundle2.getString("url");
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("url", string2);
                            QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", bundle4);
                            if (!TextUtils.isEmpty(string2) && TeamWorkDocEditBrowserFragment.this.f177184g0 != null && TeamWorkDocEditBrowserFragment.this.f177184g0.h()) {
                                TeamWorkDocEditBrowserFragment.this.f177190m0 = bundle2.getBoolean("needRefresh");
                                if (TeamWorkDocEditBrowserFragment.this.getIntent().getStringExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG) != null) {
                                    String stringExtra = TeamWorkDocEditBrowserFragment.this.getIntent().getStringExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG);
                                    String tencentDocSourceAdtagStrUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(string2, stringExtra);
                                    if (TeamWorkDocEditBrowserActivity.M2(((WebViewFragment) TeamWorkDocEditBrowserFragment.this).webView.getContext(), tencentDocSourceAdtagStrUrl, stringExtra, true)) {
                                        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle3, "0X8009ED7");
                                        TeamWorkDocEditBrowserFragment.this.getQBaseActivity().finish();
                                    } else {
                                        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle3, "0X8009ED6");
                                        ((WebViewFragment) TeamWorkDocEditBrowserFragment.this).webView.loadUrl(tencentDocSourceAdtagStrUrl);
                                    }
                                    lr2.a.l(WebViewFragment.TAG, "get_url_time", String.valueOf(b16) + " - url:" + tencentDocSourceAdtagStrUrl);
                                    return;
                                }
                                if (TeamWorkDocEditBrowserActivity.M2(((WebViewFragment) TeamWorkDocEditBrowserFragment.this).webView.getContext(), string2, ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT, true)) {
                                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle3, "0X8009ED7");
                                    TeamWorkDocEditBrowserFragment.this.getQBaseActivity().finish();
                                } else {
                                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle3, "0X8009ED6");
                                    ((WebViewFragment) TeamWorkDocEditBrowserFragment.this).webView.loadUrl(string2);
                                }
                                lr2.a.l(WebViewFragment.TAG, "get_url_time", String.valueOf(b16) + " - url:" + string2);
                                return;
                            }
                            int i16 = bundle2.getInt("retCode");
                            String string3 = bundle2.getString("errorStr");
                            String string4 = bundle2.getString("redirectUrl");
                            if (Math.abs(i16) == 115 && !TextUtils.isEmpty(string4)) {
                                if (TeamWorkDocEditBrowserActivity.M2(((WebViewFragment) TeamWorkDocEditBrowserFragment.this).webView.getContext(), string4, TeamWorkDocEditBrowserFragment.this.getIntent().getStringExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG), true)) {
                                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle3, "0X8009ED7");
                                    TeamWorkDocEditBrowserFragment.this.getQBaseActivity().finish();
                                } else {
                                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle3, "0X8009ED6");
                                    ((WebViewFragment) TeamWorkDocEditBrowserFragment.this).webView.loadUrl(string4);
                                }
                                lr2.a.l(WebViewFragment.TAG, "get_url_time", String.valueOf(b16) + " - redirectUrl:" + string4);
                                return;
                            }
                            TeamWorkDocEditBrowserFragment.this.f177184g0.i(i16, string3);
                            if (TeamWorkDocEditBrowserFragment.this.Xh(null)) {
                                lr2.a.j(null, "0X800A755");
                            }
                            lr2.a.l(WebViewFragment.TAG, "get_url_time", "retCode = " + i16 + " errorStr = " + string3);
                        }
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Xh(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo == null) {
                teamWorkFileImportInfo = (TeamWorkFileImportInfo) getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
            }
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.J == 12) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Yh() {
            Bundle bundle = new Bundle();
            if (getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO) != null) {
                bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO));
            }
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_get_team_work_url", "", this.f177185h0.key, bundle));
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "-->service binded  make ipc request");
            }
            this.f177189l0 = true;
        }

        private String fi() {
            int indexOf;
            String url = getWebView().getUrl();
            if (!TextUtils.isEmpty(url) && (indexOf = url.indexOf("&preview=1")) >= 0) {
                return url.substring(0, indexOf - 1);
            }
            return url;
        }

        private void hi() {
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview((TeamWorkFileImportInfo) getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO), getCurrentUrl(), "0X8009F33");
            ii();
        }

        private void ii() {
            TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
            if (Xh(teamWorkFileImportInfo)) {
                lr2.a.j(null, "0X800A753");
                ReportController.o(null, "dc00898", "", "", "0X800A757", "0X800A757", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - teamWorkFileImportInfo.H), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ji(String str) {
            if (HttpUtil.isValidUrl(str)) {
                this.webView.loadUrl(str);
            }
            this.f177183f0 = false;
            this.X.setVisibility(0);
            getSwiftTitleUI().C.setOnClickListener(null);
            getSwiftTitleUI().C.setVisibility(8);
            getSwiftTitleUI().f314054i.setBackgroundResource(R.drawable.f160834no);
            getSwiftTitleUI().f314054i.setText(R.string.f170549u3);
            this.C = 2;
            ui();
            Th();
            this.f177195r0 = false;
            getSwiftTitleUI().E.setVisibility(8);
            if (this.f177178a0) {
                this.X.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void vi(int i3) {
            int i16;
            String g16;
            String h16;
            String qqStr;
            String str;
            if (getQBaseActivity() == null) {
                return;
            }
            String str2 = "key_team_work_user_click_count";
            if (i3 != 1) {
                if (i3 != 2) {
                    i16 = TencentDocConvertConfigProcessor.a().i();
                    g16 = TencentDocConvertConfigProcessor.a().j();
                    h16 = TencentDocConvertConfigProcessor.a().k();
                    qqStr = HardCodeUtil.qqStr(R.string.u1l);
                } else {
                    i16 = TencentDocConvertConfigProcessor.a().b();
                    g16 = TencentDocConvertConfigProcessor.a().c();
                    h16 = TencentDocConvertConfigProcessor.a().d();
                    qqStr = HardCodeUtil.qqStr(R.string.u09);
                    str2 = "key_team_work_content_edit_click_count";
                }
            } else {
                i16 = TencentDocConvertConfigProcessor.a().i();
                g16 = TencentDocConvertConfigProcessor.a().g();
                h16 = TencentDocConvertConfigProcessor.a().h();
                qqStr = HardCodeUtil.qqStr(R.string.u0_);
            }
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(AppConstants.Preferences.TIM_CONVERT_TEAMWORK_SHARED_PRE + getQBaseActivity().getAppRuntime().getCurrentAccountUin(), 4);
            int i17 = sharedPreferences.getInt(str2, 0);
            if (i17 < i16) {
                if (TextUtils.isEmpty(g16) && TextUtils.isEmpty(h16)) {
                    str = getResources().getString(R.string.f173201hz1);
                } else {
                    str = g16 + "\n" + h16;
                }
                Intent intent = new Intent(getQBaseActivity(), (Class<?>) DialogActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.addFlags(131072);
                intent.putExtra("key_dialog_type", DialogActivity.f175529g0);
                intent.putExtra("key_dialog_title", HardCodeUtil.qqStr(R.string.tzy));
                intent.putExtra("key_dialog_content", str);
                intent.putExtra("key_teamwork_url", fi());
                getQBaseActivity().startActivity(intent);
                gi(20);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(str2, i17 + 1);
                edit.commit();
                return;
            }
            QQToast.makeText(getQBaseActivity(), qqStr, 0).show(getQBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }

        public void Mh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            if (getSwiftTitleUI().f314059m != null) {
                getSwiftTitleUI().f314059m.clearFocus();
            }
            TextView textView = this.W;
            if (textView != null) {
                textView.clearFocus();
            }
        }

        void Nh() {
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            }
            SwiftBrowserStatistics statistics = getStatistics();
            this.isDestroyed = true;
            statistics.f314382z0 = true;
            WebViewWrapperForDoc webViewWrapperForDoc = this.f177179b0;
            if (webViewWrapperForDoc != null) {
                webViewWrapperForDoc.i();
                this.f177179b0 = null;
                this.webView = null;
            }
            this.mApp = null;
        }

        public void Oh(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                iPatchRedirector.redirect((short) 43, (Object) this, (Object) arrayList);
                return;
            }
            Intent intent = new Intent(super.getQBaseActivity(), (Class<?>) NewPhotoListActivity.class);
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 27);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationTencentDocs.F);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
            intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
            intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
            intent.putExtra(com.tencent.mobileqq.utils.d.f307603i, 55);
            intent.putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
            intent.putExtra(PeakConstants.IS_SEND_FILESIZE_LIMIT, true);
            intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
            intent.putExtra("LASTFROM", getSwiftTitleUI().f314054i.getText().toString());
            intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
            intent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
            intent.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, true);
            intent.putExtra(PeakConstants.ALBUM_SHOW_ORI_BUTTON, true);
            intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            if (arrayList != null && !arrayList.isEmpty()) {
                intent.putExtra("PhotoConst.PHOTO_PATHS", arrayList);
            }
            super.startActivity(intent);
            QAlbumUtil.anim(super.getQBaseActivity(), false, true);
        }

        void Ph(Intent intent) {
            Uri uri;
            String string = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
            if (!string.equalsIgnoreCase("")) {
                PlusPanelUtils.f179796a = string;
                uri = Uri.fromFile(new File(string));
            } else {
                uri = null;
            }
            PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().remove(AppConstants.Preferences.CAMERA_PHOTO_PATH).commit();
            if (uri == null) {
                return;
            }
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(BaseApplicationImpl.getApplication(), uri);
            if (realPathFromContentURI != null) {
                BaseImageUtil.savePhotoToSysAlbum(super.getQBaseActivity(), realPathFromContentURI);
                if (!FileUtils.isPicFile(realPathFromContentURI)) {
                    QQToast.makeText(super.getActivity(), super.getString(R.string.b89), 0).show(getWebTitleBarInterface().getTitleBarHeight());
                    return;
                } else if (!new File(realPathFromContentURI).exists()) {
                    QQToast.makeText(super.getActivity(), getString(R.string.cwd), 0).show(getWebTitleBarInterface().getTitleBarHeight());
                    return;
                }
            } else {
                QQToast.makeText(super.getActivity(), getString(R.string.cwd), 0).show(getWebTitleBarInterface().getTitleBarHeight());
            }
            Intent intent2 = new Intent();
            ArrayList<String> arrayList = new ArrayList<>();
            intent2.setClass(super.getQBaseActivity(), CameraPreviewActivity.class);
            arrayList.add(realPathFromContentURI);
            intent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
            intent2.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent2.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, TeamWorkDocEditBrowserActivity.class.getName());
            intent2.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            intent2.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, false);
            intent2.putExtra(com.tencent.mobileqq.utils.d.f307603i, 55);
            intent2.putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
            intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent2.putExtra("LASTFROM", getSwiftTitleUI().f314054i.getText().toString());
            super.getQBaseActivity().startActivity(intent2);
        }

        void Qh() {
            if (QavCameraUsage.a(BaseApplication.getContext())) {
                return;
            }
            QBaseActivity qBaseActivity = super.getQBaseActivity();
            StringBuilder sb5 = new StringBuilder();
            String str = AppConstants.SDCARD_PATH;
            sb5.append(str);
            sb5.append("photo/");
            File file = new File(sb5.toString());
            if (!file.exists() && !file.mkdirs()) {
                QQToast.makeText(qBaseActivity, R.string.h9v, 0).show();
                return;
            }
            String str2 = str + "photo/" + System.currentTimeMillis() + ".jpg";
            PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString(AppConstants.Preferences.CAMERA_PHOTO_PATH, str2).commit();
            Intent intent = new Intent();
            FileProvider7Helper.setSystemCapture(super.getQBaseActivity(), new File(str2), intent);
            super.getQBaseActivity().startActivityForResult(intent, 5);
        }

        public void Rh(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
                return;
            }
            try {
                if (str != null) {
                    QLog.d(WebViewFragment.TAG, 2, str);
                    JSONObject jSONObject = new JSONObject(str);
                    int i3 = jSONObject.getInt("ret");
                    String optString = jSONObject.optString("url");
                    jSONObject.optString("error");
                    if (i3 == 0) {
                        Handler handler = this.f177191n0;
                        handler.sendMessage(handler.obtainMessage(2, optString));
                    } else {
                        Handler handler2 = this.f177191n0;
                        handler2.sendMessage(handler2.obtainMessage(3, optString));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e(WebViewFragment.TAG, 2, "handleSaveTempPadResult: " + str);
                        return;
                    }
                    return;
                }
                Handler handler3 = this.f177191n0;
                handler3.sendMessage(handler3.obtainMessage(3));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(WebViewFragment.TAG, 2, e16, new Object[0]);
                }
                Handler handler4 = this.f177191n0;
                handler4.sendMessage(handler4.obtainMessage(3));
            }
        }

        public void Sh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this);
            } else if (!getUIStyleHandler().f314512m.f314618a) {
                super.getActivity().getWindow().setFlags(1024, 1024);
                getUIStyle().f314618a = true;
                com.tencent.mobileqq.webview.swift.an.e(super.getActivity());
                getWebTitleBarInterface().u5(false);
            }
        }

        public void Th() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                iPatchRedirector.redirect((short) 30, (Object) this);
            } else {
                getSwiftTitleUI().E.setImageResource(R.drawable.b5x);
                getSwiftTitleUI().E.setOnClickListener(new i());
            }
        }

        public void Vh(Context context, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                iPatchRedirector.redirect((short) 38, (Object) this, (Object) context, (Object) arrayList);
            } else {
                Wh(arrayList);
            }
        }

        void Wh(ArrayList<String> arrayList) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = arrayList.get(i3);
                super.getWebView().callJs("readyToInsertImageForNativeJSBridge('" + str + "')");
            }
        }

        public void Zh(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
                iPatchRedirector.redirect((short) 40, (Object) this, i3);
            } else {
                this.f177199v0 = true;
                this.f177200w0 = i3;
            }
        }

        public void ai(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, (Object) bundle);
                return;
            }
            com.tencent.mobileqq.teamwork.x xVar = this.f177184g0;
            if (xVar != null && xVar.h()) {
                getSwiftTitleUI().M.setBackgroundColor(-1);
            }
            if (getIntent().getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_TEMP_SHOW_LOADING, false)) {
                if (QLog.isColorLevel()) {
                    QLog.d(WebViewFragment.TAG, 2, "-->service KEY_TEMP_SHOW_LOADING");
                }
                Uh();
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.f177185h0);
                if (((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                    Yh();
                }
            }
            if (getUIStyleHandler().V == null) {
                getUIStyleHandler().V = (ViewGroup) super.getQBaseActivity().findViewById(R.id.ae8);
            }
            getUIStyleHandler().V.getViewTreeObserver().addOnGlobalLayoutListener(this.f177198u0);
            LayoutInflater.from(super.getQBaseActivity()).inflate(R.layout.c0c, getUIStyleHandler().V);
            SessionInfo sessionInfo = this.K;
            sessionInfo.f179557e = AppConstants.TEAM_WORK_WORD_UIN;
            sessionInfo.f179555d = AppConstants.VALUE.UIN_TYPE_TEAM_WORK_WORD;
            this.G = (RelativeLayout) super.getQBaseActivity().findViewById(R.id.f166948jc0);
            ImageView imageView = (ImageView) super.getQBaseActivity().findViewById(R.id.fse);
            this.H = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) super.getQBaseActivity().findViewById(R.id.iso);
            this.I = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) super.getQBaseActivity().findViewById(R.id.d5o);
            this.J = imageView3;
            imageView3.setOnClickListener(this);
            this.P = (InputLinearLayout) super.getQBaseActivity().findViewById(R.id.jcj);
            EditText editText = (EditText) super.getQBaseActivity().findViewById(R.id.jci);
            this.Q = editText;
            editText.setImeOptions(1);
            this.Q.setOnEditorActionListener(new f());
            Button button = (Button) super.getQBaseActivity().findViewById(R.id.jck);
            this.R = button;
            button.setOnClickListener(this);
            int i3 = this.D;
            if (i3 == 1) {
                super.getWebView().requestFocus();
                this.L = this.G.getLayoutParams().height;
            } else if (i3 == 2) {
                if (this.N) {
                    this.P.setVisibility(0);
                } else {
                    this.P.setVisibility(8);
                }
                this.L = this.P.getLayoutParams().height;
            }
        }

        public void bi(WebView webView, String str, com.tencent.mobileqq.webview.swift.utils.t tVar) {
            ImageView imageView;
            WebViewWrapperForDoc webViewWrapperForDoc;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, this, webView, str, tVar);
                return;
            }
            tVar.onPageFinished(webView, str);
            if (!isDestroyed() && (webViewWrapperForDoc = this.f177179b0) != null && webViewWrapperForDoc.k() != null) {
                tVar.onReceivedTitle(webView, webView.getTitle());
            }
            super.getWebView().callJs("setDocxShareInfo", "");
            if (getSwiftTitleUI().f314059m != null) {
                getSwiftTitleUI().f314059m.clearFocus();
            }
            if (this.D == 1) {
                super.getWebView().requestFocus();
            }
            com.tencent.mobileqq.teamwork.x xVar = this.f177184g0;
            if (xVar != null && xVar.h()) {
                this.f177184g0.f();
                int i3 = this.f177188k0;
                if (i3 != -1000) {
                    ri(this.f177187j0, i3);
                    xi();
                }
                TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
                if (Xh(teamWorkFileImportInfo)) {
                    lr2.a.j(null, "0X800A754");
                    ReportController.o(null, "dc00898", "", "", "0X800A756", "0X800A756", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - teamWorkFileImportInfo.H), "");
                }
            }
            if (str != null && (str.contains("/template") || str.contains("desktop/m/templates_list.html") || str.contains("docs.qq.com/desktop/m/send.html"))) {
                ImageView imageView2 = this.X;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                if (getSwiftTitleUI().E != null) {
                    getSwiftTitleUI().E.setVisibility(8);
                }
            }
            if (this.f177178a0 && (imageView = this.X) != null) {
                imageView.setVisibility(8);
            }
        }

        public void ci(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) bundle);
                return;
            }
            if (getSwiftTitleUI().f314054i != null) {
                getSwiftTitleUI().f314054i.setText(getResources().getString(R.string.button_back));
            }
            if (getSwiftTitleUI().E != null) {
                getSwiftTitleUI().E.setVisibility(8);
            }
            if (getIntent().hasExtra(ITeamWorkDocEditBrowserProxy.KEY_TEMP_SHOW_LOADING) && (getUIStyleHandler().V instanceof RelativeLayout)) {
                com.tencent.mobileqq.teamwork.x xVar = new com.tencent.mobileqq.teamwork.x((RelativeLayout) getUIStyleHandler().V, getActivity(), (AppInterface) getAppRuntime());
                this.f177184g0 = xVar;
                this.f177186i0 = xVar.b(bundle);
                if (Xh(null)) {
                    lr2.a.j(null, "0X800A752");
                }
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.webview.swift.component.b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new e());
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public WebViewWrapper createWebViewWrapper(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (WebViewWrapper) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            WebViewWrapperForDoc webViewWrapperForDoc = new WebViewWrapperForDoc(super.getActivity(), getWebViewKernelCallBack(), this.intent, z16);
            this.f177179b0 = webViewWrapperForDoc;
            return webViewWrapperForDoc;
        }

        public void di() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this);
            } else {
                this.f177195r0 = true;
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public void doOnActivityResult(int i3, int i16, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                iPatchRedirector.redirect((short) 41, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
                return;
            }
            super.doOnActivityResult(i3, i16, intent);
            if (i3 != 5) {
                if (i3 == 1001 && i16 == -1 && intent != null) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("uin");
                    extras.getInt("uintype", 0);
                    Share share = (Share) this.share;
                    if (share.y() != null) {
                        if (share.y().f292297c == 0 || share.y().f292297c == 1) {
                            new ArrayList(1).add(string);
                            ThreadManagerV2.excute(new AnonymousClass14(share), 128, null, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (i16 == -1) {
                Ph(intent);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
        public void doOnBackEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                iPatchRedirector.redirect((short) 34, (Object) this);
                return;
            }
            if (this.f177190m0) {
                this.f177190m0 = false;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.11
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TeamWorkDocEditBrowserFragment.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            TeamWorkDocEditBrowserFragment.this.getQBaseActivity().runOnUiThread(new Runnable(com.tencent.mobileqq.utils.ea.M(TeamWorkDocEditBrowserFragment.this.getQBaseActivity())) { // from class: com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.11.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f177201d;

                                {
                                    this.f177201d = r5;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this, (Object) r5);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    String str;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    Intent intent = new Intent(TeamWorkDocEditBrowserFragment.this.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
                                    ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
                                    if (!TextUtils.isEmpty(this.f177201d)) {
                                        str = this.f177201d;
                                    } else {
                                        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
                                    }
                                    String tencentDocSourceAdtagStrUrl = iTeamWorkUtils.getTencentDocSourceAdtagStrUrl(str, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE);
                                    intent.addFlags(536870912);
                                    intent.addFlags(67108864);
                                    TeamWorkDocEditBrowserFragment.this.startActivity(intent.putExtra("url", tencentDocSourceAdtagStrUrl));
                                    TeamWorkDocEditBrowserFragment.this.getQBaseActivity().overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
                                    TeamWorkDocEditBrowserFragment.this.getQBaseActivity().finish();
                                }
                            });
                        }
                    }
                }, 16, null, true);
                return;
            }
            TouchWebView touchWebView = this.webView;
            if (touchWebView == null) {
                super.doOnBackEvent();
                return;
            }
            if (touchWebView.canGoBack()) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("target", 2);
                if (this.webView.goBack(hashMap)) {
                    reset();
                }
            } else {
                super.doOnBackEvent();
            }
            if (getSwiftTitleUI() != null) {
                getSwiftTitleUI().f314047e.f314629l = false;
                getSwiftTitleUI().f314047e.f314634q = Boolean.TRUE;
                if (getUIStyleHandler() != null) {
                    getUIStyleHandler().f0();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).booleanValue();
            }
            super.doOnCreate(bundle);
            getUIStyleHandler().f314512m.f314620c = 8980L;
            if (getSwiftTitleUI().f314059m != null) {
                getSwiftTitleUI().f314059m.clearFocus();
                getSwiftTitleUI().f314059m.setTextColor(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(getContext(), R.color.qui_common_text_primary));
            }
            getSwiftTitleUI().S(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(getContext(), R.color.qui_common_text_primary));
            this.f177181d0 = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this.f177182e0);
            this.f177191n0 = new WeakReferenceHandler(Looper.getMainLooper(), this.f177192o0);
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
            initData();
            return true;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public void doOnNewIntent(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                iPatchRedirector.redirect((short) 42, (Object) this, (Object) intent);
                return;
            }
            super.doOnNewIntent(intent);
            WeakReferenceHandler weakReferenceHandler = this.f177181d0;
            if (weakReferenceHandler != null) {
                Message obtainMessage = weakReferenceHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = intent;
                this.f177181d0.sendMessage(obtainMessage);
            }
        }

        public void ei(Bundle bundle, TouchWebView touchWebView, com.tencent.mobileqq.webview.swift.utils.t tVar) {
            long j3;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, bundle, touchWebView, tVar);
                return;
            }
            tVar.onWebViewInit(bundle, touchWebView);
            if (touchWebView.getX5WebViewExtension() == null) {
                return;
            }
            if (getStatistics().G0) {
                j3 = 2;
            } else {
                j3 = SwiftBrowserStatistics.f314343h1 ? 1L : 0L;
            }
            long j16 = j3;
            if (touchWebView instanceof SwiftReuseTouchWebView) {
                i3 = ((SwiftReuseTouchWebView) touchWebView).s(1) ? 1 : 0;
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i(WebViewFragment.TAG, 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(SwiftBrowserStatistics.W0)));
            }
            System.currentTimeMillis();
            touchWebView.reportInitPerformance(j16, i3, getStatistics().f314361h, SwiftBrowserStatistics.W0);
            System.currentTimeMillis();
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public com.tencent.mobileqq.webviewplugin.q getWebTitleBarInterface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (com.tencent.mobileqq.webviewplugin.q) iPatchRedirector.redirect((short) 27, (Object) this);
            }
            return new g(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 28, (Object) this);
            }
            return new h(this.webViewSurface);
        }

        public void gi(int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
                return;
            }
            int intExtra = getIntent().getIntExtra(ITeamWorkUtils.TD_SOURCE_TAB, -1);
            if (i3 == 0) {
                if (intExtra == 3) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A074", "0X800A074", 0, 0, "", "", "", "");
                } else if (intExtra == 20) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07C", "0X800A07C", 0, 0, "", "", "", "");
                }
                str = "0X80074D2";
            } else if (i3 == 1) {
                if (intExtra == 3) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A075", "0X800A075", 0, 0, "", "", "", "");
                } else if (intExtra == 20) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07D", "0X800A07D", 0, 0, "", "", "", "");
                }
                str = "0X80074D3";
            } else if (i3 == 2) {
                if (intExtra == 3) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A076", "0X800A076", 0, 0, "", "", "", "");
                } else if (intExtra == 20) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07E", "0X800A07E", 0, 0, "", "", "", "");
                }
                str = "0X80074D4";
            } else if (i3 == 3) {
                str = "0X80075FF";
            } else if (i3 == 4) {
                str = "0X80075FE";
            } else if (i3 == 5) {
                str = "0X8007762";
            } else if (i3 == 6) {
                str = "0X8007764";
            } else if (i3 == 7) {
                str = "0X8007763";
            } else if (i3 == 8) {
                str = "0X8007A29";
            } else if (i3 == 9) {
                str = "0X8007A2A";
            } else if (i3 == 10) {
                str = "0X8007A2B";
            } else if (i3 == 11) {
                str = "0X8007A2C";
            } else if (i3 == 12) {
                str = "0X8007A30";
            } else if (i3 == 13) {
                str = "0X8007A31";
            } else if (i3 == 14) {
                str = "0X8007CE5";
            } else if (i3 == 15) {
                if (intExtra == 3) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A073", "0X800A073", 0, 0, "", "", "", "");
                } else if (intExtra == 20) {
                    ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07B", "0X800A07B", 0, 0, "", "", "", "");
                }
                str = "0X8008A3B";
            } else if (i3 == 17) {
                str = "0X8009068";
            } else if (i3 == 18) {
                str = "0X8008A3A";
            } else if (i3 == 20) {
                str = "0X8009069";
            } else if (i3 == 19) {
                str = "0X8008A3E";
            } else {
                str = "";
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            }
        }

        void initData() {
            String currentUrl = super.getCurrentUrl();
            if (currentUrl != null) {
                String[] split = currentUrl.split("/");
                if (split != null) {
                    this.E = split[split.length - 1];
                }
                try {
                    String queryParameter = Uri.parse(currentUrl).getQueryParameter("type");
                    if (!TextUtils.isEmpty(queryParameter) && TextUtils.isDigitsOnly(queryParameter)) {
                        this.D = Integer.valueOf(queryParameter).intValue();
                    }
                } catch (Exception e16) {
                    QLog.e(WebViewFragment.TAG, 1, "TeamWorkDocEditBrowserFragment initData e = " + e16.toString());
                }
            }
            if (getAppRuntime() == null) {
                this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
            }
            this.T = getAppRuntime().getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentUrl)) {
                if (currentUrl.contains("docx.qq.com")) {
                    this.U = "https://" + getAppRuntime().getCurrentAccountUin() + ".docx.qq.com/ep/api/attach_local?tag=" + this.E;
                } else if (currentUrl.contains(ITeamWorkHandler.DOCS_DOMAIN)) {
                    this.U = "https://" + getAppRuntime().getCurrentAccountUin() + ".docs.qq.com/ep/api/attach_local?tag=" + this.E;
                }
            }
            this.f177178a0 = getQBaseActivity().getIntent().getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_FORWARD_DIALOG, false);
        }

        public boolean interceptStartLoadUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (!TextUtils.isEmpty(this.mUrl)) {
                if (new ta1.n().a() && !TextUtils.isEmpty(TenDocWebPreLoadHelper.f291578a) && this.mUrl.contains(TenDocWebPreLoadHelper.f291578a)) {
                    if (this.f177179b0.f291580j) {
                        com.tencent.mobileqq.teamwork.bo.f(TeamWorkHandlerUtils.j(this.mUrl), this.webView);
                        return true;
                    }
                    this.webView.loadUrl(this.mUrl);
                    return true;
                }
                this.webView.loadUrl(this.mUrl);
                return true;
            }
            return true;
        }

        public void ki(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
            } else {
                gi(17);
                ThreadManagerV2.executeOnNetWorkThread(new AnonymousClass9(str));
            }
        }

        public void li(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, z16);
                return;
            }
            this.F = z16;
            RelativeLayout relativeLayout = this.G;
            if (relativeLayout != null && this.D == 1) {
                if (z16) {
                    relativeLayout.setVisibility(0);
                } else {
                    relativeLayout.setVisibility(8);
                }
            }
        }

        public void mi(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (getSwiftTitleUI().f314059m != null && this.W != null) {
                Mh();
                Share share = (Share) getShare();
                int r16 = share.r();
                boolean K = share.K();
                if (QLog.isColorLevel()) {
                    QLog.i(WebViewFragment.TAG, 1, "setEditTitle policy:" + r16 + ",editable:" + K);
                }
                if (str != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.W.setTextColor(Color.parseColor(str2));
                    }
                    this.W.setText(str);
                    if (TextUtils.isEmpty(str)) {
                        this.W.setVisibility(8);
                    } else {
                        this.W.setVisibility(0);
                    }
                }
            }
        }

        public void ni(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, i3);
                return;
            }
            this.D = i3;
            if (i3 == 2) {
                if (this.N) {
                    this.P.setVisibility(0);
                } else {
                    this.P.setVisibility(8);
                }
                this.L = this.P.getLayoutParams().height;
            } else if (i3 == 1) {
                this.L = this.G.getLayoutParams().height;
            }
            ui();
        }

        public void oi(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, z16);
            } else {
                this.f177193p0 = z16;
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                iPatchRedirector.redirect((short) 37, (Object) this, (Object) view);
            } else {
                if (view.getId() != R.id.ivTitleBtnLeft) {
                    super.onClick(view);
                }
                int id5 = view.getId();
                InputMethodManager inputMethodManager = (InputMethodManager) super.getQBaseActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (id5 == R.id.ivTitleBtnLeft) {
                    int i3 = this.C;
                    if (i3 == 1 && this.f177195r0) {
                        gi(15);
                        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getQBaseActivity(), null);
                        actionSheet.setMainTitle(getResources().getString(R.string.f173202hz2));
                        actionSheet.addButton(getResources().getString(R.string.f173200hz0), 5);
                        actionSheet.addButton(getResources().getString(R.string.hxp), 5);
                        actionSheet.addCancelButton(R.string.cancel);
                        actionSheet.setOnButtonClickListener(new b(actionSheet));
                        actionSheet.show();
                    } else if (i3 == 2 && this.f177195r0) {
                        gi(15);
                        vi(2);
                        getQBaseActivity().finish();
                    } else if (i3 == 3 && this.f177195r0) {
                        gi(15);
                        vi(3);
                        getQBaseActivity().finish();
                    } else {
                        Share share = (Share) this.share;
                        if (share != null && this.f177193p0 && share.J() && getIntent().getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_IS_NEW_PAD_FLAG, false)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("savedUrl", getCurrentUrl());
                            TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
                            if (teamWorkFileImportInfo != null) {
                                if (share.B() == null) {
                                    teamWorkFileImportInfo.f292074f = "";
                                } else {
                                    teamWorkFileImportInfo.f292074f = share.B();
                                }
                                int i16 = teamWorkFileImportInfo.R;
                                if (i16 == 3) {
                                    bundle.putInt("editType", 1);
                                } else if (i16 == 6) {
                                    bundle.putInt("editType", 2);
                                }
                                bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
                            }
                            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_save_team_work", "", -1, bundle));
                        }
                        doOnBackEvent();
                    }
                } else if (id5 == R.id.fse) {
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
                    }
                    super.getWebView().clearFocus();
                    WeakReferenceHandler weakReferenceHandler = this.f177181d0;
                    if (weakReferenceHandler != null) {
                        Message obtainMessage = weakReferenceHandler.obtainMessage();
                        obtainMessage.what = 2;
                        this.f177181d0.sendMessageDelayed(obtainMessage, 500L);
                    }
                    li(false);
                } else if (id5 == R.id.iso) {
                    inputMethodManager.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
                    super.getWebView().clearFocus();
                    WeakReferenceHandler weakReferenceHandler2 = this.f177181d0;
                    if (weakReferenceHandler2 != null) {
                        Message obtainMessage2 = weakReferenceHandler2.obtainMessage();
                        obtainMessage2.what = 3;
                        this.f177181d0.sendMessageDelayed(obtainMessage2, 500L);
                    }
                    li(false);
                } else if (id5 == R.id.d5o) {
                    inputMethodManager.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
                    super.getWebView().clearFocus();
                } else if (id5 == R.id.jck) {
                    String obj = this.Q.getText().toString();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("value", obj);
                        String jSONObject2 = jSONObject.toString();
                        super.getWebView().callJs("setCellValue(" + jSONObject2 + ")");
                        inputMethodManager.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
                    } catch (JSONException e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d(WebViewFragment.TAG, 4, e16, new Object[0]);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        @TargetApi(16)
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                iPatchRedirector.redirect((short) 36, (Object) this);
                return;
            }
            hi();
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(getIntent(), "0X800A16C");
            if (this.f177185h0 != null) {
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.f177185h0);
            }
            super.onDestroy();
            Nh();
            com.tencent.mobileqq.teamwork.x xVar = this.f177184g0;
            if (xVar != null) {
                xVar.c();
            }
            WeakReferenceHandler weakReferenceHandler = this.f177181d0;
            if (weakReferenceHandler != null) {
                weakReferenceHandler.removeCallbacksAndMessages(null);
                this.f177181d0.removeMessages(0);
                this.f177181d0 = null;
            }
            if (getUIStyleHandler() != null && getUIStyleHandler().V != null && this.f177198u0 != null) {
                getUIStyleHandler().V.getViewTreeObserver().removeOnGlobalLayoutListener(this.f177198u0);
            }
            this.f177198u0 = null;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
        public void onResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                iPatchRedirector.redirect((short) 39, (Object) this);
                return;
            }
            super.onResume();
            if (this.f177199v0) {
                this.f177199v0 = false;
                ((Share) this.share).j(1, this.f177200w0, 1, true);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
        public void onStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            if (super.getWebView() != null) {
                super.getWebView().clearFocus();
            }
            super.onStop();
        }

        public void pi(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, z16);
                return;
            }
            this.N = z16;
            InputLinearLayout inputLinearLayout = this.P;
            if (inputLinearLayout != null && this.D == 2) {
                if (z16) {
                    inputLinearLayout.setVisibility(0);
                } else {
                    inputLinearLayout.setVisibility(8);
                }
            }
        }

        public void qi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
                return;
            }
            if (getSwiftTitleUI().f314059m != null && !TextUtils.isEmpty(str)) {
                this.f177194q0 = true;
                getSwiftTitleUI().f314059m.setVisibility(0);
                getSwiftTitleUI().f314059m.setText(str);
                TextView textView = this.W;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.n
        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                iPatchRedirector.redirect((short) 35, (Object) this);
                return;
            }
            super.reset();
            TextView textView = this.W;
            if (textView != null) {
                textView.setVisibility(8);
            }
            getSwiftTitleUI().f314059m.setText("");
        }

        public void ri(boolean z16, int i3) {
            Drawable drawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            this.f177187j0 = z16;
            this.f177188k0 = i3;
            if (getSwiftTitleUI().f314059m == null) {
                return;
            }
            if (z16 && i3 != 0) {
                getSwiftTitleUI().f314059m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (!z16) {
                drawable = getResources().getDrawable(R.drawable.h3h);
            } else if (i3 == 0) {
                drawable = getResources().getDrawable(R.drawable.h3g);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                getSwiftTitleUI().f314059m.setCompoundDrawablePadding(BaseAIOUtils.f(6.0f, getResources()));
                getSwiftTitleUI().f314059m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.r
        public void showActionSheet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
                iPatchRedirector.redirect((short) 44, (Object) this);
                return;
            }
            SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.mComponentsProvider.a(4);
            if (swiftBrowserShareMenuHandler != null) {
                Share share = (Share) getShare();
                if (share != null && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(share.getShareUrl())) {
                    getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
                    TeamWorkShareActionSheetBuilder teamWorkShareActionSheetBuilder = new TeamWorkShareActionSheetBuilder(getHostActivity());
                    teamWorkShareActionSheetBuilder.w((TeamWorkFileImportInfo) getIntent().getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO));
                    swiftBrowserShareMenuHandler.C = teamWorkShareActionSheetBuilder;
                }
                swiftBrowserShareMenuHandler.S(share, getUIStyle().f314620c);
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(getIntent(), "0X800A16D");
            }
        }

        public void si(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            String D = ((Share) getShare()).D();
            if (z16 && !TextUtils.isEmpty(D)) {
                qi(D);
                return;
            }
            if (TextUtils.isEmpty(D)) {
                if (this.f177194q0) {
                    this.f177194q0 = false;
                    ui();
                }
                if (!z16) {
                    mi(str, str2);
                }
            }
        }

        public void ti() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ImageView imageView = this.X;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }

        public void ui() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this);
                return;
            }
            if (getSwiftTitleUI() != null && getSwiftTitleUI().f314059m != null) {
                if (getSwiftTitleUI().f314059m.isFocused()) {
                    getSwiftTitleUI().f314059m.clearFocus();
                }
                boolean z16 = false;
                getSwiftTitleUI().f314059m.setVisibility(0);
                if (this.intent.getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, false) && getCurrentUrl() != null && getCurrentUrl().contains("preview=1")) {
                    z16 = true;
                }
                this.f177183f0 = z16;
                if (z16) {
                    getSwiftTitleUI().f314059m.setText(getResources().getString(R.string.hz8));
                    return;
                }
                int i3 = this.D;
                if (i3 == 2) {
                    getSwiftTitleUI().f314059m.setText(R.string.hz6);
                } else if (i3 == 1) {
                    getSwiftTitleUI().f314059m.setText(R.string.hz6);
                }
            }
        }

        public void wi() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this);
            } else if (getUIStyleHandler().f314512m.f314618a) {
                super.getActivity().getWindow().clearFlags(1024);
                getUIStyle().f314618a = false;
                com.tencent.mobileqq.webview.swift.an.f(super.getActivity());
                getWebTitleBarInterface().u5(true);
            }
        }

        public void xi() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this);
                return;
            }
            com.tencent.mobileqq.teamwork.x xVar = this.f177184g0;
            if (xVar != null && xVar.h()) {
                return;
            }
            if (!this.f177183f0 && !getUIStyle().f314630m) {
                this.X.setVisibility(0);
            }
            if (this.f177178a0) {
                this.X.setVisibility(8);
            }
        }
    }

    public TeamWorkDocEditBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFragmentClass = TeamWorkDocEditBrowserFragment.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(Map map, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, Object obj) {
        map.put("Cookie", "p_skey=" + str + ";p_uin=" + this.f177177a0.getCurrentAccountUin() + ";" + obj);
        P2(str2, str3, str4, str5, map, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(final Map map, String str, final String str2, final String str3, final String str4, final String str5, final ArrayList arrayList, int i3, ArrayList arrayList2, ArrayList arrayList3, IGetExternalInterface.d dVar, final String str6) {
        if (TextUtils.isEmpty(str6)) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                map.put("Cookie", cookieManager.getCookie(str));
            }
            P2(str2, str3, str4, str5, map, arrayList);
        } else {
            LoginTicketManager.g().f(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.activity.fk
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkDocEditBrowserActivity.this.J2(map, str6, str2, str3, str4, str5, arrayList, obj);
                }
            });
        }
        if (i3 == arrayList2.size() - 1) {
            QZoneShareManager.deleteTempFile(arrayList3);
            dVar.a(arrayList);
        }
    }

    static boolean L2(com.tencent.mobileqq.config.business.bg bgVar, String str, Context context, String str2, String str3, boolean z16) {
        try {
            String a16 = bgVar.a();
            String b16 = bgVar.b();
            String str4 = "";
            if (!str.equals(AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TEMPLATELIST)) {
                String str5 = "1";
                if (TextUtils.isEmpty(str2)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(b16);
                    sb5.append("?needSave=");
                    if (!z16) {
                        str5 = "0";
                    }
                    sb5.append(str5);
                    b16 = sb5.toString();
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(b16);
                    sb6.append("?url=");
                    sb6.append(URLEncoder.encode(str2, "utf-8"));
                    sb6.append("&needSave=");
                    if (!z16) {
                        str5 = "0";
                    }
                    sb6.append(str5);
                    b16 = sb6.toString();
                    str4 = "url=" + str2;
                }
            }
            String str6 = b16;
            String str7 = str4;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(context, a16, str6, str7, null, null, 2012, null);
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp:open :scene = 2012miniAppId = " + a16 + "entryPath = " + str6 + "navigateExtData = " + str7);
                return true;
            }
            return true;
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp " + e16.getMessage());
            }
            if (TextUtils.equals(str, ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING)) {
                lr2.a.j(null, "0X800A4B5");
                return false;
            }
            return false;
        }
    }

    public static boolean M2(Context context, String str, String str2, boolean z16) {
        String str3;
        com.tencent.mobileqq.config.business.bg bgVar;
        boolean z17;
        if (str2 == null || context == null || (str3 = ITeamWorkUtils.MINIAPP_CONFIG_TYPE_MAP.get(str2)) == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp:configType " + str3);
        }
        com.tencent.mobileqq.config.business.bf bfVar = (com.tencent.mobileqq.config.business.bf) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_mini_app_config");
        if (bfVar == null || (bgVar = bfVar.a().get(str3)) == null) {
            return false;
        }
        if (str.contains("forceUseMiniApp=1")) {
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkDocEditBrowserActivity", 2, "url\u53c2\u6570forceUseMiniApp=1, \u5f3a\u5236\u8d70\u5c0f\u7a0b\u5e8f");
            }
            return L2(bgVar, str3, context, str, str2, z16);
        }
        if (str.contains("forceUseH5=1")) {
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkDocEditBrowserActivity", 2, "url\u53c2\u6570forceUseH5=1, \u5f3a\u5236\u8d70H5");
            }
            return false;
        }
        if (bgVar.d()) {
            String c16 = bgVar.c();
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("showh5=1")) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TeamWorkDocEditBrowserActivity", 2, "url\u53c2\u6570showh5=1, \u4e0d\u8d70\u5c0f\u7a0b\u5e8f");
                    }
                    return false;
                }
                if (!str.contains("showh5=0") && !TextUtils.isEmpty(c16) && Pattern.matches(c16, str)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TeamWorkDocEditBrowserActivity", 2, "url\u547d\u4e2d\u9ed1\u540d\u5355, \u4e0d\u8d70\u5c0f\u7a0b\u5e8f");
                    }
                    return false;
                }
            }
            com.tencent.mobileqq.config.business.be c17 = TencentDocsIsDetailPageProcessor.c();
            if (c17 == null) {
                return false;
            }
            List<String> a16 = c17.a();
            if (a16.isEmpty()) {
                return false;
            }
            try {
                String path = new URL(str).getPath();
                QLog.d("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp docsTypeList path" + path);
                Iterator<String> it = a16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (path.startsWith("/" + it.next())) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (!z17) {
                    return false;
                }
            } catch (Exception e16) {
                QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp docsTypeList " + e16.getMessage());
            }
            return L2(bgVar, str3, context, str, str2, z16);
        }
        return false;
    }

    private void P2(String str, String str2, String str3, String str4, Map<String, String> map, ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("share_image", str4);
        String uploadImage = HttpUtil.uploadImage(str3, str, hashMap, hashMap2, map);
        if (uploadImage != null) {
            try {
                String string = new JSONObject(uploadImage).getString("url");
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("TeamWorkDocEditBrowserActivity", 4, th5.getMessage());
                }
            }
        }
    }

    public static Intent getOpenTeamWorkIntent(Intent intent, String str, Context context) {
        intent.putExtra("title", " ");
        intent.putExtra("hide_more_button", true);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("isScreenOrientationPortrait", true);
        intent.putExtra("url", str);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("big_brother_source_key", IWeiyunHelper.SOURCE_ID);
        return intent;
    }

    public static boolean openDocsMiniApp(Context context, String str, String str2) {
        return M2(context, str, str2, false);
    }

    public static void openTeamWorkDocEditBrowserActivity(Context context, Bundle bundle, boolean z16) {
        BaseActivity baseActivity;
        ChatFragment chatFragment;
        a61.c qh5;
        BaseActivity baseActivity2;
        ChatFragment chatFragment2;
        a61.c qh6;
        int i3;
        boolean z17 = false;
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            String string = bundle.getString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG);
            if (string != null) {
                String string2 = bundle.getString("url");
                if (!TextUtils.isEmpty(string2) && !string2.contains(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG)) {
                    string2 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(string2, string);
                }
                if (M2(context, string2, string, bundle.getBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ))) {
                    QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp");
                    String string3 = bundle.getString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, "");
                    if ((context instanceof Activity) && (string3.equals(ITeamWorkUtils.TD_SOURCE_QQ_FILE_SHARE_EDIT) || string3.equals(ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT))) {
                        QLog.d("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp in TeamWorkDocEditBrowserActivity");
                        ((Activity) context).finish();
                    }
                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle, "0X8009ED7");
                    return;
                }
            }
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(bundle, "0X8009ED6");
            Intent intent = new Intent(context, (Class<?>) TeamWorkDocEditBrowserActivity.class);
            String string4 = bundle.getString("url");
            int i16 = bundle.getInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE);
            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsFormUrl(string4) && (context instanceof BaseActivity) && (chatFragment2 = (baseActivity2 = (BaseActivity) context).getChatFragment()) != null && (qh6 = chatFragment2.qh()) != null) {
                String str = qh6.f25589n.f179557e;
                if (!TextUtils.isEmpty(string4) && !TextUtils.isEmpty(str) && ((i3 = qh6.f25589n.f179555d) == 0 || i3 == 1)) {
                    String troopFormGrayParameter = ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).getTroopFormGrayParameter(baseActivity2.app, str, qh6.f25589n.f179555d);
                    String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + troopFormGrayParameter;
                    if (string4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str2 = ContainerUtils.FIELD_DELIMITER + troopFormGrayParameter;
                    }
                    string4 = string4 + str2;
                }
            }
            if (bundle.getBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ)) {
                intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
            }
            if (bundle.getParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO) != null) {
                intent.putExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, bundle.getParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO));
                if (((TeamWorkFileImportInfo) bundle.getParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO)).P) {
                    intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_IS_NEW_PAD_FLAG, true);
                }
            }
            if (bundle.getBoolean(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, false)) {
                intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, true);
            } else {
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null && (qBaseActivity instanceof SplashActivity) && SplashActivity.currentFragment == 2) {
                    intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, true);
                }
            }
            if (intent.getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, false) && (context instanceof BaseActivity) && (chatFragment = (baseActivity = (BaseActivity) context).getChatFragment()) != null && (qh5 = chatFragment.qh()) != null) {
                SessionInfo sessionInfo = qh5.f25589n;
                String str3 = sessionInfo.f179557e;
                int i17 = sessionInfo.f179555d;
                if (!TextUtils.isEmpty(str3) && i17 != -1) {
                    intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_UIN, str3);
                    intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_PEERTYPE, i17);
                    intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_NICKNAME, com.tencent.mobileqq.utils.ac.R(baseActivity.app, str3, i17));
                }
            }
            if (bundle.getBoolean(ITeamWorkDocEditBrowserProxy.KEY_FROM_FORWARD_DIALOG, false)) {
                intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_FORWARD_DIALOG, true);
            }
            if (bundle.getString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG) != null) {
                String string5 = bundle.getString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG);
                intent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, string5);
                intent.putExtra("url", ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(string4, string5));
            } else {
                intent.putExtra("url", string4);
            }
            intent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, i16);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra("isScreenOrientationPortrait", true);
            intent.putExtra("title", " ");
            intent.putExtra("big_brother_source_key", "biz_src_jc_file");
            if (TextUtils.isEmpty(intent.getStringExtra("big_brother_source_key"))) {
                intent.putExtra("big_brother_source_key", IWeiyunHelper.SOURCE_ID);
            }
            if (!bundle.getBoolean(ITeamWorkDocEditBrowserProxy.KEY_FROM_FORWARD_DIALOG, false)) {
                intent.addFlags(603979776);
            }
            if (z16 && (context instanceof Activity)) {
                z17 = true;
            }
            if (z17) {
                ((Activity) context).startActivityForResult(intent, ITeamWorkDocEditBrowserProxy.REQUEST_CODE_OPEN_TEAM_WORK_EDIT_BROWSER);
                return;
            } else {
                context.startActivity(intent);
                return;
            }
        }
        QQToast.makeText(BaseApplication.getContext(), context.getResources().getString(R.string.b3j), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x010d, code lost:
    
        if (r3.contains(com.tencent.mobileqq.teamwork.api.ITeamWorkHandler.DOCS_DOMAIN) != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I2(final ArrayList<String> arrayList, final String str, final String str2, final String str3, int i3, final IGetExternalInterface.d dVar) {
        Object obj;
        IGetExternalInterface.d dVar2;
        int i16;
        final ArrayList arrayList2;
        int i17;
        int i18;
        final String str4;
        WebViewFragment currentWebViewFragment;
        final String str5;
        String str6;
        ArrayList<String> arrayList3 = arrayList;
        String str7 = str3;
        IGetExternalInterface.d dVar3 = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 2;
        int i26 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, arrayList3, str, str2, str7, Integer.valueOf(i3), dVar3);
            return;
        }
        if (arrayList3 != null) {
            if (arrayList.isEmpty()) {
                obj = arrayList3;
                dVar2 = dVar3;
            } else {
                final ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                final int i27 = 0;
                while (i27 < arrayList.size()) {
                    String str8 = arrayList3.get(i27);
                    if (com.tencent.mobileqq.filemanager.util.q.p(str8)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TeamWorkDocEditBrowserActivity", i26, "local url:" + str8);
                        }
                        if (com.tencent.mobileqq.filemanager.util.q.m(str8) > 5242880) {
                            if (QLog.isColorLevel()) {
                                QLog.d("TeamWorkDocEditBrowserActivity", i26, "file length:" + com.tencent.mobileqq.filemanager.util.q.m(str8));
                            }
                            if (i3 == 0 && !GifDrawable.isGifFile(new File(str8))) {
                                File compressImages = QZoneShareManager.compressImages(str8, i27);
                                if (compressImages != null) {
                                    String absolutePath = compressImages.getAbsolutePath();
                                    arrayList5.add(compressImages);
                                    str4 = absolutePath;
                                    final HashMap hashMap = new HashMap();
                                    hashMap.put("Connection", "keep-alive");
                                    hashMap.put("Referer", str7);
                                    currentWebViewFragment = getCurrentWebViewFragment();
                                    if (currentWebViewFragment != null) {
                                        str5 = "";
                                    } else {
                                        str5 = currentWebViewFragment.getCurrentUrl();
                                    }
                                    if (!TextUtils.isEmpty(str5)) {
                                        String str9 = "docx.qq.com";
                                        if (!str5.contains("docx.qq.com")) {
                                            str9 = ITeamWorkHandler.DOCS_DOMAIN;
                                        }
                                        str6 = str9;
                                        i16 = i27;
                                        arrayList2 = arrayList5;
                                        i17 = i26;
                                        i18 = i19;
                                        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(str6, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.activity.fj
                                            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                                            public final void a(String str10) {
                                                TeamWorkDocEditBrowserActivity.this.K2(hashMap, str5, str, str2, str3, str4, arrayList4, i27, arrayList, arrayList2, dVar, str10);
                                            }
                                        });
                                    }
                                    str6 = "";
                                    i16 = i27;
                                    arrayList2 = arrayList5;
                                    i17 = i26;
                                    i18 = i19;
                                    ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(str6, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.activity.fj
                                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                                        public final void a(String str10) {
                                            TeamWorkDocEditBrowserActivity.this.K2(hashMap, str5, str, str2, str3, str4, arrayList4, i27, arrayList, arrayList2, dVar, str10);
                                        }
                                    });
                                } else {
                                    dVar3.a(null);
                                    return;
                                }
                            }
                        }
                        str4 = str8;
                        final Map hashMap2 = new HashMap();
                        hashMap2.put("Connection", "keep-alive");
                        hashMap2.put("Referer", str7);
                        currentWebViewFragment = getCurrentWebViewFragment();
                        if (currentWebViewFragment != null) {
                        }
                        if (!TextUtils.isEmpty(str5)) {
                        }
                        str6 = "";
                        i16 = i27;
                        arrayList2 = arrayList5;
                        i17 = i26;
                        i18 = i19;
                        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(str6, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.activity.fj
                            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                            public final void a(String str10) {
                                TeamWorkDocEditBrowserActivity.this.K2(hashMap2, str5, str, str2, str3, str4, arrayList4, i27, arrayList, arrayList2, dVar, str10);
                            }
                        });
                    } else {
                        i16 = i27;
                        arrayList2 = arrayList5;
                        i17 = i26;
                        i18 = i19;
                    }
                    i27 = i16 + 1;
                    arrayList3 = arrayList;
                    str7 = str3;
                    dVar3 = dVar;
                    arrayList5 = arrayList2;
                    i26 = i17;
                    i19 = i18;
                }
                return;
            }
        } else {
            obj = arrayList;
            dVar2 = dVar;
        }
        dVar2.a(obj);
    }

    public void N2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment instanceof TeamWorkDocEditBrowserFragment) {
            ((TeamWorkDocEditBrowserFragment) currentWebViewFragment).ni(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.f177177a0 = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            super.doOnStop();
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
