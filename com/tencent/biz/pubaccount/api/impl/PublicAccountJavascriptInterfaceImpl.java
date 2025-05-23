package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.mobileqq.webviewplugin.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.util.ThreeDes;
import com.tenpay.realname.RealNameSource;
import cooperation.plugin.PluginBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.util.LogUtil;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountJavascriptInterfaceImpl extends com.tencent.mobileqq.webview.swift.k implements IPublicAccountJavascriptInterface {
    public static final int ANIM_STYLE_SHOW_UP_CLOSE_DOWN = 1001;
    public static final int ERROR_DATA_NOT_EXIST = -11;
    public static final int ERROR_EMPTY_DATA = -8;
    public static final int ERROR_EMPTY_KEY = -7;
    public static final int ERROR_EMPTY_PARAMS = -3;
    public static final int ERROR_EMPTY_PATH = -6;
    public static final int ERROR_EMPTY_URL = -4;
    public static final int ERROR_NO_PERMISSION_TO_DOMAIN = -5;
    public static final int ERROR_NO_SPACE_OR_NO_SDCARD = -9;
    public static final int ERROR_TOO_MANY_DATA = -12;
    public static final int ERROR_WRONG_IMAGE_DATA = -10;
    public static final int ERROR_WRONG_JSON = -2;
    protected static final String LBSDES_KEY = "nbyvie";
    protected static final String LBS_CALLER = "webview";
    public static final int LOCATION_TYPE_COARSE = 0;
    public static final int LOCATION_TYPE_FINE = 1;

    @Deprecated
    public static final int LOCATION_TYPE_FINE_ACCEPT_COARSE = 2;
    public static final int LOCATION_TYPE_INVALID = -1;
    private static final String METHOD_SET_NAVIGATION_BAR_STYLE = "setNavigationBarStyle";
    protected static final String SOSO_JSONEN_CRYPT_PUBKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
    protected static final String TAG = "PAjs";
    protected static final String TAG_LOCATION = "PAjs.location";
    protected Activity context;
    QQCustomDialog mDialog;
    protected List<k> taskList;
    public static final String PUBACCOUNT_DATA_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pubaccount/");
    private static int s_defaultLocationType = -1;
    protected static HashMap<String, String> storage = new HashMap<>();
    private static long sH5DataUsage = 0;
    private r uiMethodInterface = null;
    private u reportSpeedInterface = null;
    boolean hasAsked = false;
    boolean isRegisteredBroadCast = false;
    private BroadcastReceiver mBroadcastReceiver = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f79422a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f79423b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f79424c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79425d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f79426e;

        a(boolean z16, int i3, boolean z17, String str, long j3) {
            this.f79422a = z16;
            this.f79423b = i3;
            this.f79424c = z17;
            this.f79425d = str;
            this.f79426e = j3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new l(PublicAccountJavascriptInterfaceImpl.this, 0, this.f79422a, this.f79423b, this.f79424c, this.f79425d, this.f79426e));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79425d, "-3", "{}");
        }
    }

    /* loaded from: classes32.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79428d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f79429e;

        b(String str, String str2) {
            this.f79428d = str;
            this.f79429e = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            CustomWebView e16 = PublicAccountJavascriptInterfaceImpl.this.mRuntime.e();
            if (e16 == null) {
                return;
            }
            if (i3 == 0) {
                e16.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f79428d);
                return;
            }
            if (i3 == 1) {
                e16.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f79429e);
            }
        }
    }

    /* loaded from: classes32.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PublicAccountJavascriptInterfaceImpl.this.context.finish();
        }
    }

    /* loaded from: classes32.dex */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79432d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f79433e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f79434f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f79435h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f79436i;

        d(String str, long j3, int i3, String str2, String str3) {
            this.f79432d = str;
            this.f79433e = j3;
            this.f79434f = i3;
            this.f79435h = str2;
            this.f79436i = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            PublicAccountJavascriptInterfaceImpl.this.getLocationImpl(this.f79432d, this.f79433e, this.f79434f);
            PublicAccountJavascriptInterfaceImpl.setLocationPermissionGrant(this.f79435h, this.f79436i, 1);
        }
    }

    /* loaded from: classes32.dex */
    class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79438d;

        e(String str) {
            this.f79438d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79438d, "-3", "{}");
            PublicAccountJavascriptInterfaceImpl.this.hasAsked = true;
        }
    }

    /* loaded from: classes32.dex */
    class f implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79440d;

        f(String str) {
            this.f79440d = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79440d, "-3", "{}");
            PublicAccountJavascriptInterfaceImpl.this.hasAsked = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f79442a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f79443b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f79444c;

        g(String str, long j3, int i3) {
            this.f79442a = str;
            this.f79443b = j3;
            this.f79444c = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new l(PublicAccountJavascriptInterfaceImpl.this, 0, this.f79442a, this.f79443b));
            QLog.d(PublicAccountJavascriptInterfaceImpl.TAG_LOCATION, 2, "onAllGranted SosoInterface.startLocation reqLocType:", Integer.valueOf(this.f79444c));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.d(PublicAccountJavascriptInterfaceImpl.TAG_LOCATION, 2, "onDenied reqLocType:", Integer.valueOf(this.f79444c));
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79442a, "-3", "{}");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f79446d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f79447e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f79448f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f79449h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f79450i;

        h(boolean z16, String str, String str2, String str3, String str4) {
            this.f79446d = z16;
            this.f79447e = str;
            this.f79448f = str2;
            this.f79449h = str3;
            this.f79450i = str4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            PublicAccountJavascriptInterfaceImpl.this.getRealLocationImpl(this.f79446d, this.f79447e, this.f79448f);
            PublicAccountJavascriptInterfaceImpl.setLocationPermissionGrant(this.f79449h, this.f79450i, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79452d;

        i(String str) {
            this.f79452d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79452d, "-3", "{}");
            PublicAccountJavascriptInterfaceImpl.this.hasAsked = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79454d;

        j(String str) {
            this.f79454d = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79454d, "-3", "{}");
            PublicAccountJavascriptInterfaceImpl.this.hasAsked = true;
        }
    }

    /* loaded from: classes32.dex */
    protected class l extends SosoInterfaceOnLocationListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f79458a;

        /* renamed from: b, reason: collision with root package name */
        String f79459b;

        /* renamed from: c, reason: collision with root package name */
        boolean f79460c;

        /* renamed from: d, reason: collision with root package name */
        boolean f79461d;

        /* renamed from: e, reason: collision with root package name */
        boolean f79462e;

        /* renamed from: f, reason: collision with root package name */
        int f79463f;

        /* renamed from: g, reason: collision with root package name */
        long f79464g;

        /* renamed from: h, reason: collision with root package name */
        long f79465h;

        /* renamed from: i, reason: collision with root package name */
        long f79466i;

        public l(PublicAccountJavascriptInterfaceImpl publicAccountJavascriptInterfaceImpl, int i3, String str, long j3) {
            this(i3, -1L, j3, false, false, 0, false, str);
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onConsecutiveFailure(int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountJavascriptInterfaceImpl.TAG_LOCATION, 2, "onConsecutiveFailure: errCode=" + i3 + ", failCount=" + i16);
            }
            if (i16 * 2000 < this.f79465h || !this.f79458a) {
                return;
            }
            this.f79458a = false;
            PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, "-2", "{type:1, data:null}");
            ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, PublicAccountJavascriptInterfaceImpl.this.getNetworkType(), Long.toString(System.currentTimeMillis() - this.f79464g), "", "");
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x019e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x025b  */
        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            String str;
            boolean z16;
            WebViewPlugin.b bVar;
            CustomWebView e16;
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountJavascriptInterfaceImpl.TAG_LOCATION, 2, "onLocationFinish: errCode=" + i3 + ", info=" + sosoLbsInfo + ", isActive=" + this.f79458a + ", reqRawData=" + this.f79461d);
            }
            if (!this.f79458a) {
                return;
            }
            if (!this.f79461d) {
                if (i3 == 0) {
                    SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                    double d16 = sosoLocation.mLat02;
                    double d17 = sosoLocation.mLon02;
                    if (this.f79460c) {
                        PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, "0", PublicAccountJavascriptInterfaceImpl.concatResult("type", 2, QCircleSchemeAttr.Polymerize.LAT, Double.valueOf(d16), "lon", Double.valueOf(d17)));
                    } else {
                        PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, String.format("'%1$f,%2$f'", Double.valueOf(d17), Double.valueOf(d16)));
                    }
                    ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 0, PublicAccountJavascriptInterfaceImpl.this.getNetworkType(), Long.toString(System.currentTimeMillis() - this.f79464g), "", "");
                    return;
                }
                PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, "-1", "{}");
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, PublicAccountJavascriptInterfaceImpl.this.getNetworkType(), Long.toString(System.currentTimeMillis() - this.f79464g), "", "");
                return;
            }
            byte[] bArr = sosoLbsInfo != null ? sosoLbsInfo.rawData : null;
            if (bArr != null) {
                if (this.f79462e) {
                    try {
                        str = ThreeDes.encode(PublicAccountJavascriptInterfaceImpl.this.formatLocData(bArr), PublicAccountJavascriptInterfaceImpl.LBSDES_KEY);
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                } else {
                    try {
                        str = PluginBaseInfoHelper.Base64Helper.encodeToString(com.tencent.biz.pubaccount.util.b.b(this.f79463f == 1, com.tencent.biz.pubaccount.util.b.a(bArr), PublicAccountJavascriptInterfaceImpl.SOSO_JSONEN_CRYPT_PUBKEY), 2);
                    } catch (Exception e18) {
                        WebViewPlugin.b bVar2 = PublicAccountJavascriptInterfaceImpl.this.mRuntime;
                        AppInterface b16 = bVar2 != null ? bVar2.b() : null;
                        if (b16 != null) {
                            ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, b16.getAccount(), e18.getMessage(), "", "");
                        }
                    }
                }
                z16 = !TextUtils.isEmpty(str);
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountJavascriptInterfaceImpl.TAG_LOCATION, 2, "onLocationFinish: success=" + z16 + ", mUseFallback=" + this.f79460c);
                }
                if (!z16) {
                    this.f79458a = false;
                    PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, "0", PublicAccountJavascriptInterfaceImpl.concatResult("type", 1, "decrypt_padding", Integer.valueOf(this.f79463f), "data", str));
                    ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, PublicAccountJavascriptInterfaceImpl.this.getNetworkType(), Long.toString(System.currentTimeMillis() - this.f79464g), "", "");
                    if (bArr == null || (bVar = PublicAccountJavascriptInterfaceImpl.this.mRuntime) == null || (e16 = bVar.e()) == null) {
                        return;
                    }
                    String url = e16.getUrl();
                    if (TextUtils.isEmpty(url) || !url.contains("_bid=108")) {
                        return;
                    }
                    qx.a.k(null, 81, "", 0, 0, PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2), "", "", "");
                    return;
                }
                if (this.f79460c && i3 != -10000 && i3 != 2) {
                    this.f79458a = false;
                    long currentTimeMillis = System.currentTimeMillis() - this.f79464g;
                    long j3 = this.f79465h - currentTimeMillis;
                    if (j3 > 0) {
                        long j16 = this.f79466i - currentTimeMillis;
                        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new l(0, j3, j16 < 0 ? 0L : j16, false, false, 0, true, this.f79459b));
                    } else {
                        PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, "-1", "{}");
                    }
                    ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 2, PublicAccountJavascriptInterfaceImpl.this.getNetworkType(), Long.toString(System.currentTimeMillis() - this.f79464g), "", "");
                    return;
                }
                this.f79458a = false;
                PublicAccountJavascriptInterfaceImpl.this.callJs(this.f79459b, "-1", "{}");
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 1, PublicAccountJavascriptInterfaceImpl.this.getNetworkType(), Long.toString(System.currentTimeMillis() - this.f79464g), "", "");
                return;
            }
            str = "";
            z16 = !TextUtils.isEmpty(str);
            if (QLog.isColorLevel()) {
            }
            if (!z16) {
            }
        }

        public l(PublicAccountJavascriptInterfaceImpl publicAccountJavascriptInterfaceImpl, int i3, boolean z16, int i16, boolean z17, String str, long j3) {
            this(i3, 10000L, j3, true, z16, i16, z17, str);
        }

        l(int i3, long j3, long j16, boolean z16, boolean z17, int i16, boolean z18, String str) {
            super(i3, !z16, true, j16, true, false, "webview");
            this.f79459b = str;
            this.f79460c = z18;
            this.f79461d = z16;
            this.f79462e = z17;
            this.f79463f = i16;
            this.f79465h = j3;
            this.f79464g = System.currentTimeMillis();
            this.f79458a = true;
            this.f79466i = j16;
        }
    }

    private String decrypt(String str, String str2) {
        return ThreeDes.decode(str, str2);
    }

    private void deleteHash(String str, String str2, String str3) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return;
        }
        EntityManager createEntityManager = b16.getEntityManagerFactory(b16.getAccount()).createEntityManager();
        CouponH5Data couponH5Data = (CouponH5Data) DBMethodProxy.find(createEntityManager, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{str, str2, str3});
        if (couponH5Data != null) {
            createEntityManager.remove(couponH5Data);
        }
        createEntityManager.close();
    }

    private String encrypt(String str, String str2) {
        return ThreeDes.encode(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int ensureDefaultLocationType() {
        if (s_defaultLocationType == -1) {
            boolean z16 = (AppSetting.s() && ((Boolean) t.j().b("debug_location_target31", Boolean.TRUE)).booleanValue()) ? 1 : 0;
            QLog.i(TAG, 1, "ensureDefaultLocationType upgrade: " + z16);
            s_defaultLocationType = z16 ^ 1;
        }
        return s_defaultLocationType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatLocData(byte[] bArr) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused2) {
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6 = jSONObject.getJSONObject("attribute");
            jSONArray4 = jSONObject.getJSONArray("cells");
            jSONArray3 = jSONObject.getJSONArray("wifis");
            jSONObject5 = jSONObject.getJSONObject("location");
        } catch (JSONException unused3) {
        }
        try {
            jSONObject4.put("strImei", jSONObject6.getString("imei"));
            jSONObject4.put("strImsi", jSONObject6.getString(MobileInfoUtil.IMSI));
            jSONObject4.put("strPhonenum", jSONObject6.getString(AppConstants.Key.PHONENUM));
        } catch (JSONException unused4) {
        }
        for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
            try {
                JSONObject jSONObject7 = new JSONObject();
                JSONObject jSONObject8 = (JSONObject) jSONArray4.get(i3);
                jSONObject7.put("shMcc", String.valueOf(jSONObject8.getInt("mcc")));
                jSONObject7.put("shMnc", String.valueOf(jSONObject8.getInt("mnc")));
                jSONObject7.put("iLac", String.valueOf(jSONObject8.getInt("lac")));
                jSONObject7.put("iCellId", String.valueOf(jSONObject8.getInt(s4.c.CELLID)));
                jSONObject7.put("shRssi", String.valueOf(jSONObject8.getInt("rss")));
                jSONArray2.mo162put(jSONObject7);
            } catch (JSONException unused5) {
            }
        }
        for (int i16 = 0; i16 < jSONArray3.length(); i16++) {
            try {
                JSONObject jSONObject9 = new JSONObject();
                JSONObject jSONObject10 = (JSONObject) jSONArray3.get(i16);
                jSONObject9.put("lMac", jSONObject10.getString("mac"));
                jSONObject9.put("shRssi", String.valueOf(jSONObject10.getInt("rssi")));
                jSONArray.mo162put(jSONObject9);
            } catch (JSONException unused6) {
            }
        }
        try {
            jSONObject3.put("iLat", String.valueOf(jSONObject5.getInt(QCircleSchemeAttr.Polymerize.LAT)));
            jSONObject3.put("iLon", String.valueOf(jSONObject5.getInt("lon")));
            jSONObject3.put("iAlt", String.valueOf(jSONObject5.getInt(QCircleSchemeAttr.Polymerize.ALT)));
            jSONObject3.put("eType", String.valueOf(jSONObject5.getInt("type")));
        } catch (JSONException unused7) {
        }
        try {
            jSONObject2.put("stAttr", jSONObject4);
        } catch (JSONException unused8) {
        }
        try {
            jSONObject2.put("stGps", jSONObject3);
        } catch (JSONException unused9) {
        }
        try {
            jSONObject2.put("vCells", jSONArray2);
        } catch (JSONException unused10) {
        }
        try {
            jSONObject2.put("vWifis", jSONArray);
        } catch (JSONException unused11) {
        }
        return jSONObject2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapBase64String(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length) == null) {
                return null;
            }
            String str2 = "data:image;base64,";
            byte b16 = byteArray[0];
            if ((b16 & 255) == 255 && (byteArray[1] & 255) == 216) {
                str2 = "data:image/jpeg;base64,";
            } else if ((b16 & 255) == 66 && (byteArray[1] & 255) == 77) {
                str2 = "data:image/bmp;base64,";
            } else if ((b16 & 255) == 137 && (byteArray[1] & 255) == 80) {
                str2 = "data:image/png;base64,";
            } else if ((b16 & 255) == 71 && (byteArray[1] & 255) == 73) {
                str2 = "data:image/gif;base64,";
            }
            return str2 + PluginBaseInfoHelper.Base64Helper.encodeToString(byteArray, 2);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private static long getH5DataUsage() {
        File file = new File(PUBACCOUNT_DATA_PATH);
        long j3 = 0;
        if (!file.exists()) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        while (!arrayList.isEmpty()) {
            File file2 = (File) arrayList.remove(0);
            if (file2.isFile()) {
                j3 += file2.length();
            } else {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        arrayList.add(file3);
                    }
                }
            }
        }
        return j3;
    }

    private void getRealLocationPrivate(boolean z16, String str, String str2) {
        String str3;
        if (this.mRuntime.e() == null) {
            return;
        }
        Activity a16 = this.mRuntime.a();
        this.context = a16;
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        if (this.context instanceof AppActivity) {
            QQCustomDialog qQCustomDialog = this.mDialog;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            AppInterface b16 = this.mRuntime.b();
            String str4 = "";
            if (b16 == null) {
                str3 = "";
            } else {
                str3 = b16.getAccount();
            }
            if (this.mRuntime.e() != null) {
                str4 = s.i(this.mRuntime.e().getUrl());
            }
            String str5 = str4;
            if (getLocationPermissionGrant(str3, str5)) {
                getRealLocationImpl(z16, str, str2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "already grant");
                    return;
                }
                return;
            }
            if (this.hasAsked) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "already ask");
                    return;
                }
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.context, 0);
            this.mDialog = createCustomDialog;
            createCustomDialog.setMessage(this.context.getString(R.string.vtz, str5));
            this.mDialog.setPositiveButton(R.string.igg, new h(z16, str, str2, str3, str5));
            this.mDialog.setNegativeButton(this.context.getString(R.string.igj), new i(str2));
            this.mDialog.setOnCancelListener(new j(str2));
            this.mDialog.show();
            return;
        }
        callJs(str2, "-4", "{}");
    }

    private String hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes("UTF-8"));
            String bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
            messageDigest.reset();
            return bytes2HexStr;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "wronghash";
        }
    }

    private String readHash(String str, String str2, String str3) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return null;
        }
        EntityManager createEntityManager = b16.getEntityManagerFactory(b16.getAccount()).createEntityManager();
        CouponH5Data couponH5Data = (CouponH5Data) DBMethodProxy.find(createEntityManager, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{str, str2, str3});
        createEntityManager.close();
        if (couponH5Data != null) {
            return couponH5Data.mData;
        }
        return null;
    }

    public static void setLocationPermissionGrant(String str, String str2, int i3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            BaseApplicationImpl.getApplication().getSharedPreferences(str + "LocationPermissionPref", 0).edit().putInt(str2 + "-location", i3).commit();
            return;
        }
        QLog.e(TAG, 1, "uin:", LogUtil.wrapLogUin(str), " host:", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeDataInMainThread(final String str, final String str2, final JSONObject jSONObject) {
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null) {
            return;
        }
        try {
            final URL url = new URL(e16.getUrl());
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.15
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountJavascriptInterfaceImpl.this.writeDataWithURL(url, str, str2, jSONObject);
                }
            }, 5, null, false);
        } catch (MalformedURLException unused) {
        }
    }

    private void writeHash(String str, String str2, String str3, String str4) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return;
        }
        EntityManager createEntityManager = b16.getEntityManagerFactory(b16.getAccount()).createEntityManager();
        CouponH5Data couponH5Data = (CouponH5Data) DBMethodProxy.find(createEntityManager, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{str, str2, str3});
        if (couponH5Data == null) {
            createEntityManager.persist(new CouponH5Data(str, str2, str3, str4));
        } else {
            couponH5Data.mData = str4;
            createEntityManager.update(couponH5Data);
        }
        createEntityManager.close();
    }

    static /* bridge */ /* synthetic */ long y() {
        return getH5DataUsage();
    }

    public void actionSheetAdditionalItems(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "actionSheetAdditionalItems->paramStr:" + str);
        }
        try {
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            if (parseString2Json != null) {
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) super.getBrowserComponent(4);
                if (parseString2Json.has("pageType")) {
                    int i3 = parseString2Json.getInt("pageType");
                    JSONArray jSONArray = parseString2Json.getJSONArray(VideoTemplateParser.ITEM_LIST);
                    ArrayList<IPublicAccountJavascriptInterface.a> arrayList = new ArrayList<>();
                    if (jSONArray != null) {
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i16);
                            IPublicAccountJavascriptInterface.a aVar = new IPublicAccountJavascriptInterface.a();
                            aVar.f79347a = jSONObject.optInt("itemType");
                            aVar.f79348b = jSONObject.optString("itemName");
                            aVar.f79349c = jSONObject.optString("itemActionData");
                            arrayList.add(aVar);
                        }
                    }
                    if (swiftBrowserShareMenuHandler != null) {
                        if (i3 == 1) {
                            swiftBrowserShareMenuHandler.f314292b0 = true;
                        } else {
                            swiftBrowserShareMenuHandler.f314293c0 = true;
                        }
                        swiftBrowserShareMenuHandler.f314294d0 = arrayList;
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "actionSheetAdditionalItems->error:" + e16);
            }
        }
    }

    public void close() {
        this.context.finish();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface
    public void deleteAllH5Data(AppInterface appInterface) {
        EntityManager createEntityManager = appInterface.getEntityManagerFactory(appInterface.getAccount()).createEntityManager();
        List<? extends Entity> query = createEntityManager.query(CouponH5Data.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                File file = new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(appInterface.getAccount()) + "/" + ((CouponH5Data) it.next()).mHost);
                if (file.exists()) {
                    q.c(file);
                }
            }
        }
        createEntityManager.drop(CouponH5Data.class);
        createEntityManager.close();
    }

    public void deleteH5Data(String str, String str2) {
        AppInterface b16;
        String str3;
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null || (b16 = this.mRuntime.b()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            callJs(str2, "{ret:-3, response:" + jSONObject.toString() + "}");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("callid");
            if (!TextUtils.isEmpty(optString)) {
                optString = optString.replace("\\", "\\\\").replace("'", "\\'");
            }
            jSONObject.put("callid", optString);
            String optString2 = jSONObject2.optString("path");
            if (TextUtils.isEmpty(optString2)) {
                callJs(str2, "{ret:-6, response:" + jSONObject.toString() + "}");
                return;
            }
            String optString3 = jSONObject2.optString("key");
            try {
                str3 = new URL(e16.getUrl()).getHost();
            } catch (MalformedURLException unused) {
                str3 = null;
            }
            String optString4 = jSONObject2.optString("host");
            if (!TextUtils.isEmpty(optString4)) {
                if (!isParentDomain(optString4, str3)) {
                    callJs(str2, "{ret:-5, response:" + jSONObject.toString() + "}");
                    return;
                }
                str3 = optString4;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "defaulthost";
            }
            if (TextUtils.isEmpty(optString3)) {
                deleteHash(str3, optString2);
                q.c(new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(b16.getAccount()) + "/" + str3 + "/" + HexUtil.string2HexString(optString2)));
            } else {
                deleteHash(str3, optString2, optString3);
                q.c(new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(b16.getAccount()) + "/" + str3 + "/" + HexUtil.string2HexString(optString2) + "/" + HexUtil.string2HexString(optString3)));
            }
            callJs(str2, "{ret:0, response:" + jSONObject.toString() + "}");
        } catch (JSONException unused2) {
            callJs(str2, "{ret:-2, response:" + jSONObject.toString() + "}");
        }
    }

    public void deleteH5DataByHost(String str, String str2) {
        AppInterface b16;
        String str3;
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null || (b16 = this.mRuntime.b()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            callJs(str2, "{ret:-3, response:" + jSONObject.toString() + "}");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("callid");
            if (!TextUtils.isEmpty(optString)) {
                optString = optString.replace("\\", "\\\\").replace("'", "\\'");
            }
            jSONObject.put("callid", optString);
            try {
                str3 = new URL(e16.getUrl()).getHost();
            } catch (MalformedURLException unused) {
                str3 = null;
            }
            String optString2 = jSONObject2.optString("host");
            if (!TextUtils.isEmpty(optString2)) {
                if (!isParentDomain(optString2, str3)) {
                    callJs(str2, "{ret:-5, response:" + jSONObject.toString() + "}");
                    return;
                }
                str3 = optString2;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "defaulthost";
            }
            deleteHash(str3);
            q.c(new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(b16.getAccount()) + "/" + str3));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("{ret:0, response:");
            sb5.append(jSONObject.toString());
            sb5.append("}");
            callJs(str2, sb5.toString());
        } catch (JSONException unused2) {
            callJs(str2, "{ret:-2, response:" + jSONObject.toString() + "}");
        }
    }

    public void enableNotCare(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enable share dian dian->paramStr:" + str);
        }
        try {
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            if (parseString2Json != null) {
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) super.getBrowserComponent(4);
                if (parseString2Json.has("enable")) {
                    String string = parseString2Json.getString("enable");
                    if (swiftBrowserShareMenuHandler != null) {
                        if ("1".equals(string)) {
                            swiftBrowserShareMenuHandler.G(true);
                        } else {
                            swiftBrowserShareMenuHandler.G(false);
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "enable Share dian dian->error:" + e16);
            }
        }
    }

    public void enableScreenshot(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enableScreenshot->enable:" + str);
        }
        SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) super.getBrowserComponent(64);
        if (swiftBrowserScreenShotHandler != null) {
            if ("1".equals(str)) {
                swiftBrowserScreenShotHandler.o("");
            } else {
                swiftBrowserScreenShotHandler.v();
            }
        }
    }

    public void enableShareDianDian(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enable share dian dian->paramStr:" + str);
        }
        try {
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            if (parseString2Json != null) {
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) super.getBrowserComponent(4);
                if (parseString2Json.has("enable")) {
                    String string = parseString2Json.getString("enable");
                    if (swiftBrowserShareMenuHandler != null) {
                        if ("1".equals(string)) {
                            swiftBrowserShareMenuHandler.F(true);
                        } else {
                            swiftBrowserShareMenuHandler.F(false);
                        }
                    }
                }
                if (parseString2Json.has("enableShortLink")) {
                    String string2 = parseString2Json.getString("enableShortLink");
                    if (swiftBrowserShareMenuHandler != null) {
                        if ("1".equals(string2)) {
                            swiftBrowserShareMenuHandler.H(true);
                        } else {
                            swiftBrowserShareMenuHandler.H(false);
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "enable Share dian dian->error:" + e16);
            }
        }
    }

    public void enableShareSinaWeibo(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enableShareSinaWeibo->paramStr:" + str);
        }
        try {
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            if (parseString2Json == null || !parseString2Json.has("enable")) {
                return;
            }
            String string = parseString2Json.getString("enable");
            SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) super.getBrowserComponent(4);
            if (swiftBrowserShareMenuHandler != null) {
                if ("1".equals(string)) {
                    swiftBrowserShareMenuHandler.I(true);
                } else {
                    swiftBrowserShareMenuHandler.I(false);
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "enableShareSinaWeibo->error:" + e16);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface
    public String getDataPath() {
        return PUBACCOUNT_DATA_PATH;
    }

    public void getLocation(String str) {
        boolean optBoolean;
        int i3;
        String str2;
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG_LOCATION, 2, "getLocation:" + str);
        }
        if (this.mRuntime.e() == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG_LOCATION, 2, "getWebView()==null, return");
                return;
            }
            return;
        }
        Activity a16 = this.mRuntime.a();
        this.context = a16;
        if (a16 != null && !a16.isFinishing()) {
            int ensureDefaultLocationType = ensureDefaultLocationType();
            long j3 = 0;
            if (str.charAt(0) == '{') {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    str = jSONObject.getString("callback");
                    j3 = 1000 * jSONObject.optLong("allowCacheTime", 0L);
                    int optInt = jSONObject.optInt("locType", ensureDefaultLocationType());
                    optBoolean = jSONObject.optBoolean("is_for_ecshop_map");
                    i3 = optInt;
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG_LOCATION, 2, "getLocation exception:", e16);
                        return;
                    }
                    return;
                }
            } else {
                i3 = ensureDefaultLocationType;
                optBoolean = false;
            }
            AppInterface b16 = this.mRuntime.b();
            if (b16 == null) {
                str2 = "";
            } else {
                str2 = b16.getAccount();
            }
            if (optBoolean && !TextUtils.isEmpty(str2) && b16 != null) {
                SharedPreferences sharedPreferences = b16.getApp().getSharedPreferences(str2, 0);
                double d16 = sharedPreferences.getFloat(com.tencent.biz.lebasearch.b.f78642c, 0.0f);
                double d17 = sharedPreferences.getFloat(com.tencent.biz.lebasearch.b.f78641b, 0.0f);
                if (QLog.isColorLevel()) {
                    QLog.i("EcShopAssistantActivity", 2, String.format("'longitude:%1$1.15f,latitude:%2$1.15f'", Double.valueOf(d16), Double.valueOf(d17)));
                }
                callJs(str, String.format("'%1$1.15f,%2$1.15f'", Double.valueOf(d16), Double.valueOf(d17)));
                return;
            }
            if (this.mRuntime.e() == null) {
                str3 = "";
            } else {
                str3 = s.h(this.mRuntime.e().getUrl(), 2);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.context instanceof AppActivity) {
                QQCustomDialog qQCustomDialog = this.mDialog;
                if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                    this.mDialog.dismiss();
                }
                if (getLocationPermissionGrant(str2, str3)) {
                    getLocationImpl(str, j3, i3);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "already grant");
                        return;
                    }
                    return;
                }
                if (this.hasAsked) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "already ask");
                        return;
                    }
                    return;
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.context, 0);
                this.mDialog = createCustomDialog;
                createCustomDialog.setMessage(this.context.getString(R.string.vtz, str3));
                this.mDialog.setPositiveButton(R.string.igg, new d(str, j3, i3, str2, str3));
                this.mDialog.setNegativeButton(this.context.getString(R.string.igj), new e(str));
                this.mDialog.setOnCancelListener(new f(str));
                this.mDialog.show();
                return;
            }
            callJs(str, "-4", "{}");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG_LOCATION, 2, "context==null || isFinishing, return");
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface
    public boolean getLocationPermissionGrant(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.contains("qq.com")) {
                QLog.d(TAG, 1, "qq.com can grant");
                return true;
            }
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(str + "LocationPermissionPref", 0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append("-location");
            return sharedPreferences.getInt(sb5.toString(), 0) == 1;
        }
        QLog.e(TAG, 1, "uin:", LogUtil.wrapLogUin(str), " host:", str2);
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return IPublicAccountJavascriptInterface.NAME_SPACE;
    }

    public int getNetworkState() {
        return NetworkUtil.getNetworkType(BaseApplication.getContext());
    }

    public String getNetworkType() {
        String str;
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo != null) {
            int type = NetworkMonitor.getType(recentNetworkInfo);
            if (type != 0) {
                if (type != 1) {
                    return "other";
                }
                return "WiFi";
            }
            switch (NetworkMonitor.getSubtype(recentNetworkInfo)) {
                case 1:
                    str = "GPRS";
                    break;
                case 2:
                    str = "EDGE_";
                    break;
                case 3:
                    str = "UMTS_";
                    break;
                case 4:
                    str = "CDMA_";
                    break;
                case 5:
                    str = "EVDO_0_";
                    break;
                case 6:
                    str = "EVDO_A_";
                    break;
                case 7:
                case 10:
                case 11:
                default:
                    str = "other_";
                    break;
                case 8:
                    str = "HSDPA_";
                    break;
                case 9:
                    str = "HSUPA_";
                    break;
                case 12:
                    str = "EVDO_B_";
                    break;
            }
            return str + NetworkMonitor.netGetExInfo(recentNetworkInfo);
        }
        return GlobalUtil.DEF_STRING;
    }

    public void getPageLoadStamp(String str) {
        String str2;
        r rVar = this.uiMethodInterface;
        if (rVar != null) {
            if (!TextUtils.isEmpty(rVar.getCurrentUrl())) {
                str2 = this.uiMethodInterface.getCurrentUrl();
            } else {
                str2 = "";
            }
            if (this.reportSpeedInterface != null) {
                callJs(str, "{ret:0, onCreateTime:" + this.reportSpeedInterface.getmOnCreateMilliTimeStamp() + ", startLoadUrlTime:" + this.reportSpeedInterface.getmStartLoadUrlMilliTimeStamp() + ", url:'" + str2 + "'}");
                return;
            }
            return;
        }
        callJs(str, "{ret: -1}");
    }

    public void getUrlImage(final String str, final String str2) {
        final JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            new BaseThread() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.12
                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        String optString = jSONObject2.optString("callid");
                        if (!TextUtils.isEmpty(optString)) {
                            optString = optString.replace("\\", "\\\\").replace("'", "\\'");
                        }
                        jSONObject.put("callid", optString);
                        String optString2 = jSONObject2.optString("url");
                        if (!TextUtils.isEmpty(optString2)) {
                            PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:1, response:" + jSONObject.toString() + "}");
                            String bitmapBase64String = PublicAccountJavascriptInterfaceImpl.getBitmapBase64String(optString2);
                            if (bitmapBase64String != null) {
                                jSONObject.put("data", bitmapBase64String.replace("\\", "\\\\").replace("'", "\\'"));
                                PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:0, response:" + jSONObject.toString() + "}");
                                return;
                            }
                            PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:-10, response:" + jSONObject.toString() + "}");
                            return;
                        }
                        PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:-4, response:" + jSONObject.toString() + "}");
                    } catch (JSONException unused) {
                        PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:-2, response:" + jSONObject.toString() + "}");
                    }
                }
            }.start();
            return;
        }
        callJs(str2, "{ret:-3, response:" + jSONObject.toString() + "}");
    }

    public void hideLoading() {
        ProgressBar progressBar;
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.m)) {
            ((com.tencent.mobileqq.webviewplugin.m) d16).hideLoading();
            return;
        }
        v vVar = (v) super.getBrowserComponent(2);
        if (vVar == null || (progressBar = vVar.Z) == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String httpRequest(String str, String str2) {
        JSONObject jSONObject;
        Bundle bundle;
        String str3;
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return "";
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
        }
        try {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, " httpRequest strParams:" + str2);
                }
            } catch (JSONException unused2) {
                jSONObject2 = jSONObject;
                jSONObject = jSONObject2;
                bundle = new Bundle();
                bundle.putString("from", "native");
                str3 = "GET";
                if (jSONObject != null) {
                }
                if (jSONObject != null) {
                }
                String str4 = "uin=" + b16.getAccount();
                Bundle bundle2 = new Bundle();
                bundle2.putString("Cookie", str4);
                return HttpUtil.openUrl(this.context.getApplicationContext(), str, str3, bundle, bundle2);
            }
            return HttpUtil.openUrl(this.context.getApplicationContext(), str, str3, bundle, bundle2);
        } catch (ClientProtocolException e16) {
            e16.printStackTrace();
            return "{'r': -104, 'msg' : 'httpRequest:ClientProtocolException'}";
        } catch (IOException e17) {
            e17.printStackTrace();
            return "{'r': -105, 'msg' : 'httpRequest:IOException'}";
        }
        bundle = new Bundle();
        bundle.putString("from", "native");
        str3 = "GET";
        if (jSONObject != null) {
            try {
                if (jSONObject.has("method")) {
                    str3 = jSONObject.getString("method").toUpperCase();
                }
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        }
        if (jSONObject != null) {
            try {
                if (jSONObject.has("param")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("param");
                    Iterator keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        bundle.putString(obj, jSONObject3.getString(obj));
                    }
                }
            } catch (JSONException e19) {
                e19.printStackTrace();
            }
        }
        String str42 = "uin=" + b16.getAccount();
        Bundle bundle22 = new Bundle();
        bundle22.putString("Cookie", str42);
    }

    public void isFollowUin(String str, final String str2) {
        final JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            callJs(str2, "{ret:-3, response:" + jSONObject.toString() + "}");
            return;
        }
        final AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return;
        }
        try {
            final String optString = new JSONObject(str).optString("uin");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (!(b16 instanceof BrowserAppInterface) && !b16.getClass().getSimpleName().equalsIgnoreCase("ReadInJoyInterfaceProxy") && !b16.getClass().getSimpleName().equalsIgnoreCase("QWalletAppInterface")) {
                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) b16.getRuntimeService(IPublicAccountDataManager.class, "all");
                jSONObject.put("follow", iPublicAccountDataManager != null ? iPublicAccountDataManager.isFollowedUin(Long.valueOf(optString)) : false);
                callJs(str2, "{ret:0, response:" + jSONObject.toString() + "}");
                return;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.18
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        jSONObject.put("follow", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(b16, optString));
                        PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:0, response:" + jSONObject.toString() + "}");
                    } catch (JSONException unused) {
                        PublicAccountJavascriptInterfaceImpl.this.callJs(str2, "{ret:-2, response:" + jSONObject.toString() + "}");
                    }
                }
            });
        } catch (JSONException unused) {
            callJs(str2, "{ret:-2, response:" + jSONObject.toString() + "}");
        }
    }

    public void officalAccountShareRichMsg2QQ(String str) {
        String string;
        String string2;
        String string3;
        String string4;
        String str2;
        String str3;
        String str4;
        PublicAccountJavascriptInterfaceImpl publicAccountJavascriptInterfaceImpl;
        String str5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            string = jSONObject.getString("oaUin");
            string2 = jSONObject.getString("title");
            string3 = jSONObject.getString("summary");
            string4 = jSONObject.getString("targetUrl");
            if (!jSONObject.has("imageUrl")) {
                str2 = "";
            } else {
                str2 = jSONObject.getString("imageUrl");
            }
            if (!jSONObject.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
                str3 = "";
            } else {
                str3 = jSONObject.getString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
            }
            if (!jSONObject.has("needback")) {
                str4 = "false";
            } else {
                str4 = jSONObject.getString("needback");
            }
            if (!jSONObject.has("callback")) {
                publicAccountJavascriptInterfaceImpl = this;
                str5 = "";
            } else {
                publicAccountJavascriptInterfaceImpl = this;
                str5 = jSONObject.getString("callback");
            }
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            WebViewPlugin.b bVar = publicAccountJavascriptInterfaceImpl.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                ((com.tencent.mobileqq.webviewplugin.n) d16).shareStructMsgForH5(string, string2, string3, string4, str2, str3, str4, str5);
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_sys_30", "share_click", 0, 0, string, "", "", "");
        } catch (JSONException e17) {
            e = e17;
            if (QLog.isColorLevel()) {
                QLog.d(getClass().getSimpleName(), 2, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.context = this.mRuntime.a();
        this.taskList = new ArrayList();
        if (sH5DataUsage == 0) {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    long y16 = PublicAccountJavascriptInterfaceImpl.y();
                    synchronized (this) {
                        PublicAccountJavascriptInterfaceImpl.sH5DataUsage = y16;
                    }
                }
            });
        }
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof r)) {
            this.uiMethodInterface = (r) d16;
        }
        WebViewPlugin.b bVar2 = this.mRuntime;
        y d17 = bVar2.d(bVar2.a());
        if (d17 == null || !(d17 instanceof u)) {
            return;
        }
        this.reportSpeedInterface = (u) d17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        for (k kVar : this.taskList) {
            if (!kVar.isCancelled()) {
                kVar.cancel(true);
            }
        }
        this.taskList.clear();
        this.taskList = null;
        if (this.isRegisteredBroadCast) {
            this.context.unregisterReceiver(this.mBroadcastReceiver);
        }
        QQCustomDialog qQCustomDialog = this.mDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        super.onDestroy();
    }

    public void open(String str) {
        if ("com.tencent.mobileqq.activity.ChatBubbleSettingActivity".equals(str)) {
            Activity activity = this.context;
            VasWebviewUtil.openQQBrowserWithoutAD(activity, IndividuationUrlHelper.getMarketUrl(activity, "bubble", ""), 64L, null, false, -1);
        } else {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this.context, str));
            this.context.startActivity(intent);
        }
    }

    public void openAccountPageMore(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "openAccountPageMore->paramStr:" + str);
        }
        try {
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            if (parseString2Json != null) {
                long j3 = parseString2Json.getLong(IPublicAccountBrowser.KEY_PUB_UIN);
                Activity activity = this.context;
                if (activity != null) {
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPublicAccountDetailActivity.ROUTE_NAME);
                    activityURIRequest.extra().putString("uin", "" + j3);
                    activityURIRequest.extra().putBoolean(IPublicAccountDetailActivity.FROM_JS, true);
                    QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "openAccountPageMore->error:" + e16);
            }
        }
    }

    public void openEmoji() {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return;
        }
        EmojiHomeUiPlugin.openEmojiHomePage(this.context, b16.getAccount(), 2);
    }

    public void openInExternalBrowser(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "openInExternalBrowser:" + str);
        }
        if (str != null) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            try {
                LockMethodProxy.sleep(200L);
                this.context.startActivity(intent);
            } catch (ActivityNotFoundException | Exception unused) {
            }
        }
    }

    public void readH5Data(final String str, final String str2) {
        final JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            callJs(str2, "{ret:-3, response:" + jSONObject.toString() + "}");
            return;
        }
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null) {
            return;
        }
        final String url = e16.getUrl();
        new BaseThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.17
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountJavascriptInterfaceImpl.this.readData(str, str2, jSONObject, url);
            }
        }).start();
    }

    public void setNavigationBarStyle(String str) {
        WebViewFragment webViewFragment;
        if (TextUtils.isEmpty(str) || (webViewFragment = (WebViewFragment) this.mRuntime.f()) == null) {
            return;
        }
        try {
            int optInt = new JSONObject(str).optInt("style");
            if (optInt == 0) {
                webViewFragment.getUIStyleHandler().W(false);
            } else if (optInt == 1) {
                webViewFragment.getUIStyleHandler().W(true);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void setRightButton(String str, String str2, String str3) {
        ((AbsBaseWebViewActivity) this.context).setRightButton(str3, str, str2, false, 0, 0, null, null);
    }

    public void setScreenshotAttr(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setScreenshotAttr->paramStr:" + str);
        }
        try {
            SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) super.getBrowserComponent(64);
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            if (parseString2Json != null && parseString2Json.has("title")) {
                String string = parseString2Json.getString("title");
                if (swiftBrowserScreenShotHandler != null) {
                    swiftBrowserScreenShotHandler.r(string);
                }
            }
            if (parseString2Json != null && parseString2Json.has("shareUrl")) {
                String string2 = parseString2Json.getString("shareUrl");
                if (swiftBrowserScreenShotHandler != null) {
                    swiftBrowserScreenShotHandler.q(string2);
                }
            }
            if (parseString2Json != null && parseString2Json.has("sinaShareTitle")) {
                String string3 = parseString2Json.getString("sinaShareTitle");
                if (swiftBrowserScreenShotHandler != null) {
                    swiftBrowserScreenShotHandler.t(string3);
                }
            }
            if (parseString2Json == null || !parseString2Json.has("shareActionSheetTitle")) {
                return;
            }
            JSONArray optJSONArray = parseString2Json.optJSONArray("shareActionSheetTitle");
            if (swiftBrowserScreenShotHandler != null) {
                swiftBrowserScreenShotHandler.s(optJSONArray);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setScreenshotAttr->error:" + e16);
            }
        }
    }

    @Deprecated
    public void showDialog(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean equals = "true".equals(str3);
        boolean equals2 = "true".equals(str4);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.context, 0);
        createCustomDialog.setTitle(str);
        createCustomDialog.setMessage(str2);
        b bVar = new b(str6, str5);
        if (equals2) {
            createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), bVar);
        }
        if (equals) {
            createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.ket), bVar);
        }
        try {
            createCustomDialog.show();
        } catch (Exception unused) {
        }
    }

    public void showLoading() {
        ProgressBar progressBar;
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.m)) {
            ((com.tencent.mobileqq.webviewplugin.m) d16).showLoading();
            return;
        }
        v vVar = (v) super.getBrowserComponent(2);
        if (vVar == null || (progressBar = vVar.Z) == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    public void showProfile(String str) {
        if (excuteShowProfile(this.mRuntime.b(), this.context, str) == 1) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("start_recomend_page");
            this.context.registerReceiver(this.mBroadcastReceiver, intentFilter);
            this.isRegisteredBroadCast = true;
        }
    }

    public void startMultiShare(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startMultiShare->paramStr:" + str);
        }
        try {
            JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(str);
            String str2 = "";
            if (parseString2Json != null && parseString2Json.has("image_url")) {
                str2 = parseString2Json.getString("image_url");
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            boolean z16 = (parseString2Json == null || !parseString2Json.has(NodeProps.CUSTOM_PROP_ISGIF)) ? false : parseString2Json.getBoolean(NodeProps.CUSTOM_PROP_ISGIF);
            SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) super.getBrowserComponent(64);
            if (swiftBrowserScreenShotHandler != null) {
                swiftBrowserScreenShotHandler.h(str2, z16);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startMultiShare->error:" + e16);
            }
        }
    }

    public void viewAccount(String str) {
        viewAccount(str, "false");
    }

    public void viewTroopBarAccount(String str) {
        viewAccount(str);
    }

    protected void writeData(final String str, final String str2, final JSONObject jSONObject) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.14
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountJavascriptInterfaceImpl.this.writeDataInMainThread(str, str2, jSONObject);
                }
            });
        } else {
            writeDataInMainThread(str, str2, jSONObject);
        }
    }

    public void writeH5Data(final String str, final String str2) {
        final JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            callJs(str2, "{ret:-3, response:" + jSONObject.toString() + "}");
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.13
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountJavascriptInterfaceImpl.this.writeData(str, str2, jSONObject);
            }
        }, 5, null, false);
    }

    /* loaded from: classes32.dex */
    protected class k extends AsyncTask<String, Integer, String> {

        /* renamed from: a, reason: collision with root package name */
        String f79456a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PublicAccountJavascriptInterfaceImpl f79457b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            if (super.isCancelled()) {
                return null;
            }
            return this.f79457b.httpRequest(strArr[0], strArr[1]);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (str == null) {
                str = "{\"r\" : \"-100\"}";
            }
            this.f79457b.callJs("clientCallback", s.l(str), s.l(this.f79456a));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }
    }

    public void getJson(String str, String str2, String str3, String str4) {
        callJs("clientCallback", s.l("{'r': -102, 'msg': 'no such method'}"), s.l(str4));
    }

    @Deprecated
    public void getRealLocation(String str, String str2) {
        getRealLocationPrivate(false, str, str2);
    }

    public void getRealLocationDes(String str, String str2) {
        getRealLocationPrivate(true, str, str2);
    }

    public void viewAccount(String str, String str2) {
        AppInterface b16;
        PublicAccountInfo publicAccountInfo;
        if (TextUtils.isEmpty(str) || (b16 = this.mRuntime.b()) == null) {
            return;
        }
        if (b16 instanceof BrowserAppInterface) {
            EntityManager createEntityManager = ((BrowserAppInterface) b16).getEntityManagerFactory(null).createEntityManager();
            if (createEntityManager != null) {
                publicAccountInfo = (PublicAccountInfo) DBMethodProxy.find(createEntityManager, PublicAccountInfo.class, "uin = ?", new String[]{str});
            }
            publicAccountInfo = null;
        } else {
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) b16.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str);
            }
            publicAccountInfo = null;
        }
        if (this.context == null) {
            this.context = this.mRuntime.a();
        }
        Activity activity = this.context;
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin(TAG, Long.valueOf(str).longValue()) != null) {
            Intent intent = new Intent();
            intent.putExtra("uin", str);
            intent.putExtra("chatPage", true);
            ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(activity, intent);
            return;
        }
        if (publicAccountInfo != null && "true".equals(str2)) {
            if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(str)) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse(((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).getJumpUrl(null, false)));
                JumpActivity.processIntent(intent2);
                JumpActivity.handleIntentForQQBrowser(activity, intent2);
                activity.startActivity(intent2);
                com.tencent.biz.troop.b.A().w0();
            } else {
                Intent intent3 = new Intent(activity, (Class<?>) ChatActivity.class);
                intent3.putExtra("uin", str);
                intent3.putExtra("uintype", 1008);
                intent3.putExtra("uinname", publicAccountInfo.name);
                activity.startActivity(intent3);
            }
        } else {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", str);
            activityURIRequest.extra().putString(IPublicAccountDetailActivity.REPORT_SRC_PARAM_TYPE, "");
            activityURIRequest.extra().putString(IPublicAccountDetailActivity.REPORT_SRC_PARAM_NAME, "");
            activityURIRequest.extra().putBoolean(PublicAccountDetailActivityImpl.FROM_BROWSER, true);
            activityURIRequest.setFlags(67108864);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(b16, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_5", "addpage_hot");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String concatResult(Object... objArr) {
        if (objArr != null && objArr.length >= 2 && objArr.length % 2 == 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < objArr.length; i3 += 2) {
                if (i3 > 0) {
                    sb5.append(", ");
                }
                String obj = objArr[i3].toString();
                String obj2 = objArr[i3 + 1].toString();
                sb5.append(obj);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(obj2);
            }
            return "{" + sb5.toString() + "}";
        }
        QLog.d(TAG, 1, "getResultString params not valid return.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLocationImpl(String str, long j3, int i3) {
        String[] strArr;
        if (i3 == 0) {
            strArr = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
        } else {
            strArr = i3 == 1 ? new String[]{"android.permission.ACCESS_FINE_LOCATION"} : null;
        }
        QQPermissionFactory.getQQPermission(this.context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PUBLIC_ACCOUNT, QQPermissionConstants.Business.SCENE.JS_BRIDGE_GET_LOCATION)).requestPermissions(strArr, 2, new g(str, j3, i3));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:89:0x020e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public void writeDataWithURL(java.net.URL r10, final java.lang.String r11, final java.lang.String r12, final org.json.JSONObject r13) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.writeDataWithURL(java.net.URL, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    public void openUrl(String str) {
        if (str != null) {
            Intent intent = this.context.getIntent();
            Activity activity = this.context;
            Intent intent2 = new Intent(activity, activity.getClass());
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            } else {
                extras.remove("title");
                extras.remove(AppConstants.LeftViewText.LEFTVIEWTEXT);
                extras.remove("post_data");
                extras.remove("options");
            }
            intent2.putExtras(extras);
            intent2.putExtra("url", str);
            intent2.setFlags(0);
            this.context.startActivityForResult(intent2, 100);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:84:0x021d
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    protected void readData(java.lang.String r10, java.lang.String r11, org.json.JSONObject r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.readData(java.lang.String, java.lang.String, org.json.JSONObject, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRealLocationImpl(boolean z16, String str, String str2) {
        boolean z17;
        int i3 = 0;
        long j3 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            z17 = jSONObject.optBoolean(AdMetricTag.FALLBACK, false);
            try {
                i3 = jSONObject.optInt("decrypt_padding", 0);
                j3 = jSONObject.optLong("allowCacheTime", 0L) * 1000;
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            z17 = false;
        }
        QQPermissionFactory.getQQPermission(this.context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PUBLIC_ACCOUNT, QQPermissionConstants.Business.SCENE.JS_BRIDGE_GET_LOCATION)).requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new a(z16, i3, z17, str2, j3));
    }

    private static boolean isParentDomain(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        if (!str2.equals(str)) {
            if (str.indexOf(".") <= 0) {
                return false;
            }
            if (!str2.endsWith("." + str)) {
                return false;
            }
        }
        return true;
    }

    private void deleteHash(String str, String str2) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return;
        }
        EntityManager createEntityManager = b16.getEntityManagerFactory(b16.getAccount()).createEntityManager();
        List<? extends Entity> query = createEntityManager.query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[]{str, str2}, null, null, null, null);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                createEntityManager.remove((CouponH5Data) it.next());
            }
        }
        createEntityManager.close();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface
    public int excuteShowProfile(AppInterface appInterface, Context context, String str) {
        int optInt;
        String str2;
        int i3;
        Intent profileCardIntentOnly;
        String str3;
        String optString;
        String optString2;
        String str4;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "showProfile: " + str);
        }
        if (str == null) {
            return -1;
        }
        String trim = str.trim();
        String str5 = "";
        Intent intent = null;
        if (!trim.startsWith("{")) {
            str3 = "";
            optString2 = str3;
            optString = optString2;
            str2 = optString;
            i3 = 0;
            optInt = 0;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(trim);
                trim = jSONObject.getString("uin");
                int optInt2 = jSONObject.optInt("uinType", 0);
                optInt = jSONObject.optInt("isFinish", 0);
                boolean equals = "groupSearchOther".equals(jSONObject.optString("jump_from"));
                str2 = VipFunCallConstants.KEY_GROUP;
                if (equals) {
                    i3 = jSONObject.optInt("subSourceID");
                } else if (optInt2 != 1) {
                    if (optInt2 == 0) {
                        String optString3 = jSONObject.optString("from");
                        String optString4 = jSONObject.optString("troopuin");
                        if ("groupActivity".equals(optString3) && !TextUtils.isEmpty(optString4)) {
                            AllInOne allInOne = new AllInOne(trim, 120);
                            allInOne.troopCode = optString4;
                            profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.a(), allInOne);
                            profileCardIntentOnly.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
                            Bundle bundle = new Bundle();
                            bundle.putString("troop_uin", optString4);
                            profileCardIntentOnly.putExtra("flc_extra_param", bundle);
                        } else if ("groupMembers".equals(optString3) && !TextUtils.isEmpty(optString4)) {
                            AllInOne allInOne2 = new AllInOne(trim, 120);
                            allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 1);
                            allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 15);
                            profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.a(), allInOne2);
                            profileCardIntentOnly.putExtra("troopUin", optString4);
                            profileCardIntentOnly.putExtra("memberUin", trim);
                        }
                        intent = profileCardIntentOnly;
                    }
                    str2 = "";
                    i3 = 0;
                } else {
                    i3 = jSONObject.optInt("wSourceSubID");
                }
                if (jSONObject.optInt(ColorScreenJsPlugin.BUSINESS_NAME) == 0) {
                    str3 = "";
                } else {
                    str3 = "&colorScreen=" + jSONObject.optInt(ColorScreenJsPlugin.BUSINESS_NAME);
                }
                optString = jSONObject.optString("authKey");
                optString2 = jSONObject.optString("authSig");
            } catch (JSONException unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "showProfile param error");
                }
                return -1;
            }
        }
        if (trim == null || trim.length() < 5) {
            return -1;
        }
        if (intent != null) {
            context.startActivity(intent);
        } else {
            StringBuilder sb5 = new StringBuilder();
            if (TextUtils.isEmpty(optString)) {
                str4 = "";
            } else {
                str4 = "&authKey=" + optString;
            }
            sb5.append(str4);
            if (!TextUtils.isEmpty(optString2)) {
                str5 = "&authSig=" + optString2;
            }
            sb5.append(str5);
            String str6 = "mqq://card/show_pslcard/?uin=" + trim + "&card_type=" + str2 + "&wSourceSubID=" + i3 + sb5.toString() + str3;
            if (appInterface instanceof QQAppInterface) {
                bi.c((QQAppInterface) appInterface, context, str6).b();
            } else {
                context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(str6)));
            }
        }
        return optInt;
    }

    private void deleteHash(String str) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            return;
        }
        EntityManager createEntityManager = b16.getEntityManagerFactory(b16.getAccount()).createEntityManager();
        List<? extends Entity> query = createEntityManager.query(CouponH5Data.class, false, "mHost = ?", new String[]{str}, null, null, null, null);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                createEntityManager.remove((CouponH5Data) it.next());
            }
        }
        createEntityManager.close();
    }

    public void viewAccount(String str, String str2, String str3, String str4) {
        AppInterface b16;
        PublicAccountInfo publicAccountInfo;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "func viewAccount(****), sopType:" + str3 + ",sopName:" + str4);
        }
        if (TextUtils.isEmpty(str) || (b16 = this.mRuntime.b()) == null) {
            return;
        }
        if (b16 instanceof BrowserAppInterface) {
            EntityManager createEntityManager = ((BrowserAppInterface) b16).getEntityManagerFactory(null).createEntityManager();
            if (createEntityManager != null) {
                publicAccountInfo = (PublicAccountInfo) DBMethodProxy.find(createEntityManager, PublicAccountInfo.class, "uin = ?", new String[]{str});
            }
            publicAccountInfo = null;
        } else {
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) b16.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str);
            }
            publicAccountInfo = null;
        }
        Activity activity = this.context;
        if (activity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
            activity = ((PluginBaseActivity) this.context).getOutActivity();
        }
        if (publicAccountInfo != null && "true".equals(str2)) {
            Intent intent = new Intent(activity, (Class<?>) ChatActivity.class);
            intent.putExtra("uin", str);
            intent.putExtra("uintype", 1008);
            intent.putExtra("uinname", publicAccountInfo.name);
            activity.startActivity(intent);
        } else {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", str);
            activityURIRequest.extra().putString(IPublicAccountDetailActivity.REPORT_SRC_PARAM_TYPE, str3);
            activityURIRequest.extra().putString(IPublicAccountDetailActivity.REPORT_SRC_PARAM_NAME, str4);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(b16, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_5", "addpage_hot");
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface
    public WebViewPlugin getWebViewPlugin() {
        return this;
    }
}
