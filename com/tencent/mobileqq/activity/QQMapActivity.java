package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare$GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare$LocationResp;
import com.tencent.proto.lbsshare.LBSShare$NearByShopsResp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavBuilder;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "QQ\u5730\u56fe", path = RouterConstants.UI_ROUTE_QQMAP)
/* loaded from: classes9.dex */
public class QQMapActivity extends MapActivity implements SkinnableActivityProcesser.Callback {
    static IPatchRedirector $redirector_ = null;
    protected static final int ACTIVITY_RESULT_SEND_SHARE_STRUCT_MESSAGE = 0;
    private static final int LOCATING_FAILED = 1;
    private static final int LOCATING_POS = 0;
    protected static final String ON_GET_STREET_VIEW_URL = "com.tencent.mobileqq.onGetStreetViewUrl";
    public static final String REQUEST_FROM_TROOP_ACTIVITY = "group_activity";
    public static final String TAG = "QQMapActivity";
    protected static final String TAG_FETCH_ADDRESS = "fetch_address";
    protected static final String TAG_GET_LOCATION = "get_location";
    protected static final int TENCENT_MAP_DOWNLOAD_STATUS_DOWNLOADING = 1;
    protected static final int TENCENT_MAP_DOWNLOAD_STATUS_PAUSE = 2;
    protected static final int TENCENT_MAP_DOWNLOAD_STATUS_STOP = 0;
    Drawable defaultMarker;
    protected boolean fetchDataFailed;
    protected View fixedPopView;
    boolean hasLocked;
    boolean hasStoped;
    protected boolean hideJiejingIcon;
    protected boolean isChangeToGoogleMap;
    boolean isRefreshPressed;
    boolean isRightBtnShowShare;
    protected View jiejingIcon;
    protected double latitude;
    protected String loc;
    protected String location;
    protected double longitude;
    public boolean mActNeedImmersive;
    protected ActionSheet mActionSheet;
    protected TextView mAddrTxt;
    private BroadcastReceiver mBroadcastReceiver;
    public String mCurPoiAdr;
    public String mCurPoiName;
    float mDensity;
    protected TextView mDetailAddrTxt;
    protected String mDianpingId;
    protected TextView mDistanceTxt;
    protected String mFrom;
    protected boolean mIsGetMyLocation;
    GeoPoint mLastPoint;
    protected long mLastUpdateSelfPoiTime;
    LbsManagerServiceOnLocationChangeListener mLocationListener;
    public boolean mNeedStatusTrans;
    protected int mPinViewImageHeight;
    protected Polyline mPolyLine;
    protected View mQQMapLayout;
    protected View mRouteBar;
    protected Button mRouteBtn;
    private BroadcastReceiver mScreenReceiver;
    protected String mSelfAddress;
    protected GeoPoint mSelfGeoPoint;
    protected Marker mSelfLocationMarker;
    protected String mSelfPoiName;
    String mStreetViewUrl;
    public SystemBarCompact mSystemBarComp;
    protected LinearLayout mTopLineLay;
    protected QQMapView mapView;
    private Marker myLocMarker;
    protected View.OnClickListener onTitleLeftClickLister;
    protected View.OnClickListener onTitleRightClickShareListener;
    protected View.OnClickListener onTitleRightHouseClickLister;
    protected View.OnClickListener onTitleRightSendClickLister;
    Animation pinAnim;
    Animation pinShadowAnim;
    protected ImageView pinView;
    SkinnableActivityProcesser processer;
    protected View selfFixedPopView;
    protected boolean startWithPos;
    protected TencentMap tencentMap;
    protected TextView tvTitleBtnRight;
    String uin;
    protected String url;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class MapRuntime extends PluginRuntime implements Thread.UncaughtExceptionHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        protected Thread.UncaughtExceptionHandler f176853d;

        /* renamed from: e, reason: collision with root package name */
        private BroadcastReceiver f176854e;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a extends BroadcastReceiver {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapRuntime.this);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
            
                if (com.tencent.mobileqq.util.o.c(r5, com.tencent.qphone.base.util.BaseApplication.getContext()) != false) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
            
                if (r5.equals("mqq.intent.action.EXIT_" + mqq.app.MobileQQ.getMobileQQ().getPackageName()) != false) goto L29;
             */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                String action = intent.getAction();
                if (action == null) {
                    return;
                }
                boolean z16 = true;
                if (action.equals("com.tencent.process.exit")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("mqq", 2, "receive kill map process broadcast");
                    }
                    ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("procNameList");
                    if (QQMapActivity.isLegalBroadcast(intent.getExtras().getString("verify"), stringArrayList)) {
                    }
                    z16 = false;
                } else if (!action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_LOGOUT)) {
                }
                if (z16) {
                    SystemMethodProxy.killProcess(Process.myPid());
                }
            }
        }

        public MapRuntime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f176854e = new a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.pluginsdk.PluginRuntime, mqq.app.AppRuntime
        public void onCreate(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            this.f176853d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            super.onCreate(bundle);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.process.exit");
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            intentFilter.addAction("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName());
            BaseApplication.getContext().registerReceiver(this.f176854e, intentFilter);
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) thread, (Object) th5);
                return;
            }
            PluginRuntime.handleCrash(th5, QQMapActivity.TAG, BaseApplication.getContext());
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f176853d;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f176856a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.QQMapActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class DialogInterfaceOnDismissListenerC7112a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnDismissListenerC7112a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    QQMapActivity qQMapActivity = QQMapActivity.this;
                    qQMapActivity.getMyLocation(qQMapActivity.mIsGetMyLocation);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else if (a.this.f176856a.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    QQMapActivity.this.getActivity().finish();
                }
            }
        }

        a(QQPermission qQPermission) {
            this.f176856a = qQPermission;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this, (Object) qQPermission);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.onAllGranted();
            QQMapActivity qQMapActivity = QQMapActivity.this;
            qQMapActivity.getMyLocation(qQMapActivity.mIsGetMyLocation);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            if (this.f176856a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                QQMapActivity qQMapActivity = QQMapActivity.this;
                qQMapActivity.getMyLocation(qQMapActivity.mIsGetMyLocation);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDeniedWithoutShowDlg(list, list2);
            if (this.f176856a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                QQMapActivity qQMapActivity = QQMapActivity.this;
                qQMapActivity.getMyLocation(qQMapActivity.mIsGetMyLocation);
            } else {
                QQMapActivity.this.getActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissionRequestDialog, (Object) list);
                return;
            }
            super.onDialogShow(permissionRequestDialog, list);
            if (this.f176856a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                permissionRequestDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC7112a());
            } else {
                permissionRequestDialog.setOnDismissListener(new b());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            QQMapActivity qQMapActivity = QQMapActivity.this;
            if (qQMapActivity.fetchDataFailed && !qQMapActivity.isRefreshPressed && !qQMapActivity.startWithPos) {
                qQMapActivity.finish();
            }
            QQMapActivity.this.isRefreshPressed = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f176861d;

        c(Dialog dialog) {
            this.f176861d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this, (Object) dialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Dialog dialog = this.f176861d;
                if (dialog != null && dialog.isShowing()) {
                    this.f176861d.dismiss();
                }
                QQMapActivity qQMapActivity = QQMapActivity.this;
                if (!qQMapActivity.startWithPos) {
                    qQMapActivity.finish();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                QQMapActivity qQMapActivity = QQMapActivity.this;
                if (!qQMapActivity.hasLocked && !qQMapActivity.hasStoped && BaseGesturePWDUtil.getGesturePWDState(qQMapActivity, qQMapActivity.uin) == 2) {
                    QQMapActivity qQMapActivity2 = QQMapActivity.this;
                    if (BaseGesturePWDUtil.getGesturePWDMode(qQMapActivity2, qQMapActivity2.uin) == 21) {
                        if (QLog.isColorLevel()) {
                            QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. receive lock.");
                        }
                        QQMapActivity.super.startActivity(new Intent(QQMapActivity.this, (Class<?>) GesturePWDUnlockActivity.class));
                        QQMapActivity.this.hasStoped = true;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            byte[] byteArrayExtra;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "activiy.receiver.onReceive:" + action);
            }
            if (action.equals(QQMapActivity.ON_GET_STREET_VIEW_URL)) {
                QQMapActivity.this.mStreetViewUrl = intent.getStringExtra("streetViewUrl");
                QQMapActivity.this.refreshStreetViewIcon();
                return;
            }
            LBSShare$LocationResp lBSShare$LocationResp = null;
            if (action.equals("com.tencent.mobileqq.onGetLbsShareSearch")) {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("data");
                LBSShare$LocationResp lBSShare$LocationResp2 = new LBSShare$LocationResp();
                if (byteArrayExtra2 != null) {
                    try {
                        lBSShare$LocationResp = lBSShare$LocationResp2.mergeFrom(byteArrayExtra2);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            e16.printStackTrace();
                        }
                    }
                } else {
                    lBSShare$LocationResp = lBSShare$LocationResp2;
                }
                QQMapActivity.this.onGetLbsShareSearch(lBSShare$LocationResp, intent.getExtras().getBundle("req"));
                return;
            }
            if (action.equals("com.tencent.mobileqq.onGetLbsShareShop")) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("data");
                if (byteArrayExtra3 != null) {
                    try {
                        QQMapActivity.this.onGetLbsShareShop(new LBSShare$NearByShopsResp().mergeFrom(byteArrayExtra3), intent.getExtras().getBundle("req"));
                        return;
                    } catch (InvalidProtocolBufferMicroException e17) {
                        if (QLog.isColorLevel()) {
                            e17.printStackTrace();
                        }
                        QQMapActivity.this.onGetLbsShareShop(null, null);
                        return;
                    }
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.onGetShareShopDetail") && (byteArrayExtra = intent.getByteArrayExtra("data")) != null) {
                try {
                    QQMapActivity.this.onGetShareShopDetail(new LBSShare$GetShopsByIdsResp().mergeFrom(byteArrayExtra));
                } catch (InvalidProtocolBufferMicroException e18) {
                    if (QLog.isColorLevel()) {
                        e18.printStackTrace();
                    }
                    QQMapActivity.this.onGetShareShopDetail(null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int width = QQMapActivity.this.mTopLineLay.getWidth();
            if (width > 0) {
                int c16 = com.tencent.mobileqq.util.x.c(QQMapActivity.this, 10.0f);
                Paint paint = new Paint();
                paint.setTextSize(com.tencent.mobileqq.util.x.c(QQMapActivity.this, 14.0f));
                paint.setAntiAlias(true);
                int measureText = (int) (paint.measureText(QQMapActivity.this.mDistanceTxt.getText().toString()) + 1.0f);
                paint.setTextSize(com.tencent.mobileqq.util.x.c(QQMapActivity.this, 20.0f));
                if (measureText + c16 + ((int) (paint.measureText(QQMapActivity.this.mAddrTxt.getText().toString()) + 1.0f)) > width) {
                    ViewGroup.LayoutParams layoutParams = QQMapActivity.this.mAddrTxt.getLayoutParams();
                    layoutParams.width = (width - c16) - measureText;
                    QQMapActivity.this.mAddrTxt.setLayoutParams(layoutParams);
                }
                QQMapActivity.this.mTopLineLay.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    QQMapActivity.this.jumpToStreetViewMap();
                }
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (!NetworkUtil.isNetSupport(QQMapActivity.this)) {
                    QQMapActivity.this.showInvalidNetworkAlert();
                } else if (NetworkUtil.isWifiEnabled(QQMapActivity.this)) {
                    QQMapActivity.this.jumpToStreetViewMap();
                } else {
                    DialogUtil.createCustomDialog(QQMapActivity.this, 230).setTitle(QQMapActivity.this.getString(R.string.f170313lz)).setMessage(R.string.coy).setPositiveButton(R.string.a8k, new b()).setNegativeButton(R.string.cancel, new a()).show();
                }
                com.tencent.biz.widgets.d.d("see_streetview");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements TencentMap.OnMarkerClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) marker)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQMapActivity.this.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQMapActivity qQMapActivity = QQMapActivity.this;
                if (qQMapActivity.fetchDataFailed) {
                    qQMapActivity.refresh();
                } else if (QQMapActivity.REQUEST_FROM_TROOP_ACTIVITY.equals(qQMapActivity.mFrom)) {
                    QQMapActivity.this.onTroopActivityCallback();
                } else {
                    QQMapActivity qQMapActivity2 = QQMapActivity.this;
                    qQMapActivity2.setResult(-1, qQMapActivity2.getLocationData());
                    QQMapActivity.this.finish();
                    QQMapActivity.this.sendSuccessCall();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQMapActivity.this.Forward();
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "sdk_locate", "click_send", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements ActionSheet.OnButtonClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        QQMapActivity qQMapActivity = QQMapActivity.this;
                        QfavBuilder F = QfavBuilder.b0((float) qQMapActivity.latitude, (float) qQMapActivity.longitude, qQMapActivity.mCurPoiName, qQMapActivity.loc, null).F(QQMapActivity.this.getIntent().getStringExtra("uin"));
                        QQMapActivity qQMapActivity2 = QQMapActivity.this;
                        if (F.e(qQMapActivity2, qQMapActivity2.getIntent().getStringExtra("uin"), 1, null)) {
                            int dimensionPixelSize = QQMapActivity.super.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                            QQMapActivity qQMapActivity3 = QQMapActivity.this;
                            QQToast.makeText(qQMapActivity3, 2, qQMapActivity3.getString(R.string.b3n), 1).show(dimensionPixelSize);
                            com.tencent.biz.widgets.d.d("favorite_success");
                        }
                        cooperation.qqfav.d.e(null, 65, 7);
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
                    }
                } else {
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
                    com.tencent.biz.widgets.d.d("share_success");
                    QQMapActivity.this.Forward();
                }
                QQMapActivity.this.mActionSheet.dismiss();
            }
        }

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQMapActivity qQMapActivity = QQMapActivity.this;
                if (qQMapActivity.mActionSheet == null) {
                    qQMapActivity.mActionSheet = (ActionSheet) ActionSheetHelper.createDialog(qQMapActivity, null);
                    QQMapActivity.this.mActionSheet.addButton(R.string.f171437ez2);
                    QQMapActivity.this.mActionSheet.addButton(R.string.b3m);
                    QQMapActivity.this.mActionSheet.addCancelButton(R.string.cancel);
                    QQMapActivity.this.mActionSheet.setOnButtonClickListener(new a());
                }
                if (!QQMapActivity.this.mActionSheet.isShowing()) {
                    QQMapActivity.this.mActionSheet.show();
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQMapActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n extends AsyncTask<GeoPoint, Void, String> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected GeoPoint f176876a;

        /* renamed from: b, reason: collision with root package name */
        TextView f176877b;

        /* renamed from: c, reason: collision with root package name */
        protected HttpClient f176878c;

        public n(GeoPoint geoPoint, TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, QQMapActivity.this, geoPoint, textView);
                return;
            }
            this.f176876a = geoPoint;
            this.f176877b = textView;
            textView.setTag(geoPoint);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(GeoPoint... geoPointArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) geoPointArr);
            }
            int i3 = 0;
            while (true) {
                String str = "";
                if (i3 >= 3 || isCancelled()) {
                    return "";
                }
                String a16 = com.tencent.mobileqq.utils.dv.a(QQMapActivity.this.getApplicationContext(), this.f176876a.getLatitudeE6() / 1000000.0d, this.f176876a.getLongitudeE6() / 1000000.0d, 3, this.f176878c);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i3);
                    sb5.append(" time: ReverseGeocode.getFromLocation, address: ");
                    if (a16 != null) {
                        str = a16;
                    }
                    sb5.append(str);
                    QLog.i(QQMapActivity.TAG_FETCH_ADDRESS, 2, sb5.toString());
                }
                if (a16 != null && a16.length() > 0) {
                    return a16;
                }
                i3++;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(QQMapActivity.TAG_FETCH_ADDRESS, 2, "get address finish, onPostExecute, result:" + str);
            }
            TextView textView = this.f176877b;
            if (textView != null) {
                GeoPoint geoPoint = (GeoPoint) textView.getTag();
                if (geoPoint.getLatitudeE6() == this.f176876a.getLatitudeE6() && geoPoint.getLongitudeE6() == this.f176876a.getLongitudeE6() && str != null && str.length() > 0) {
                    QQMapActivity qQMapActivity = QQMapActivity.this;
                    if (qQMapActivity.startWithPos) {
                        this.f176877b.setText(str);
                        this.f176877b.setVisibility(0);
                    } else {
                        qQMapActivity.location = str;
                    }
                }
            }
        }
    }

    public QQMapActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.location = "";
        this.startWithPos = false;
        this.fetchDataFailed = false;
        this.isRightBtnShowShare = false;
        this.hideJiejingIcon = false;
        this.hasLocked = false;
        this.hasStoped = true;
        this.isChangeToGoogleMap = false;
        this.mIsGetMyLocation = false;
        this.mFrom = null;
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = true;
        this.onTitleLeftClickLister = new i();
        this.onTitleRightSendClickLister = new j();
        this.onTitleRightClickShareListener = new k();
        this.onTitleRightHouseClickLister = new l();
        this.mLastUpdateSelfPoiTime = 0L;
        this.mLocationListener = new LbsManagerServiceOnLocationChangeListener(TAG, z16) { // from class: com.tencent.mobileqq.activity.QQMapActivity.9
            static IPatchRedirector $redirector_;

            {
                super(r6, z16);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QQMapActivity.this, r6, Boolean.valueOf(z16));
                }
            }

            @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                String str;
                SosoLocation sosoLocation;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                    return;
                }
                if (sosoLbsInfo == null || (sosoLocation = sosoLbsInfo.mLocation) == null || (str = sosoLocation.address) == null) {
                    str = "";
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QQMapActivity.TAG_GET_LOCATION, 2, "onLocationFinish errCode=" + i3);
                }
                if (i3 == 0 && sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                    SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
                    GeoPoint geoPoint = new GeoPoint((int) (sosoLocation2.mLat02 * 1000000.0d), (int) (sosoLocation2.mLon02 * 1000000.0d));
                    QQMapActivity qQMapActivity = QQMapActivity.this;
                    if (qQMapActivity.mIsGetMyLocation) {
                        if (!qQMapActivity.startWithPos) {
                            qQMapActivity.tencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d)));
                            QQMapActivity qQMapActivity2 = QQMapActivity.this;
                            qQMapActivity2.location = str;
                            qQMapActivity2.pinView.setVisibility(0);
                            QQMapActivity.this.updateLocationAddress(geoPoint);
                        }
                        QQMapActivity.this.onFetchDataSuceeded();
                        QQMapActivity.this.mIsGetMyLocation = false;
                    }
                    QQMapActivity qQMapActivity3 = QQMapActivity.this;
                    if (!qQMapActivity3.startWithPos) {
                        qQMapActivity3.addMyPosition(geoPoint, str);
                    } else {
                        qQMapActivity3.addSelfLay();
                        long currentTimeMillis = System.currentTimeMillis();
                        QQMapActivity qQMapActivity4 = QQMapActivity.this;
                        if (currentTimeMillis - qQMapActivity4.mLastUpdateSelfPoiTime > 5000) {
                            if (qQMapActivity4.mDistanceTxt != null && qQMapActivity4.mPolyLine == null) {
                                QQMapActivity qQMapActivity5 = QQMapActivity.this;
                                double c16 = com.tencent.biz.widgets.d.c(geoPoint.getLongitudeE6() / 1000000.0d, geoPoint.getLatitudeE6() / 1000000.0d, qQMapActivity5.longitude, qQMapActivity5.latitude);
                                QQMapActivity.this.listenDistanceChange();
                                QQMapActivity.this.mDistanceTxt.setText(com.tencent.biz.widgets.d.b(c16));
                            }
                            QQMapActivity qQMapActivity6 = QQMapActivity.this;
                            qQMapActivity6.mSelfGeoPoint = geoPoint;
                            qQMapActivity6.mSelfAddress = str;
                            qQMapActivity6.mSelfPoiName = sosoLbsInfo.mLocation.name;
                            Marker marker = qQMapActivity6.mSelfLocationMarker;
                            if (marker != null) {
                                marker.setPosition(new LatLng(QQMapActivity.this.mSelfGeoPoint.getLatitudeE6() / 1000000.0d, QQMapActivity.this.mSelfGeoPoint.getLongitudeE6() / 1000000.0d));
                                QQMapActivity.this.mSelfLocationMarker.setSnippet("");
                                QQMapActivity.showInfoWindow(QQMapActivity.this.mSelfLocationMarker);
                            }
                            QQMapActivity.this.mLastUpdateSelfPoiTime = currentTimeMillis;
                        }
                    }
                } else {
                    QQMapActivity.this.onFetchDataFailed();
                    new Handler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQMapActivity.9.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(QQMapActivity.this.mLocationListener);
                            }
                        }
                    });
                }
                try {
                    QQMapActivity.this.dismissDialog(0);
                } catch (IllegalArgumentException unused) {
                }
            }
        };
        this.mScreenReceiver = new d();
        this.mBroadcastReceiver = new e();
    }

    private void doStartLocation() {
        super.showDialog(0);
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.mLocationListener);
        if (QLog.isColorLevel()) {
            QLog.d(TAG_GET_LOCATION, 2, "start get location");
        }
    }

    protected static boolean isLegalBroadcast(String str, ArrayList<String> arrayList) {
        if (Foreground.getActivityCount() > 0 || str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(BaseApplicationImpl.getLocalVerify(arrayList, false)) && !str.equals(BaseApplicationImpl.getLocalVerify(arrayList, true))) {
            return false;
        }
        return true;
    }

    public static void showInfoWindow(Marker marker) {
        if (marker != null) {
            String title = marker.getTitle();
            String snippet = marker.getSnippet();
            if (TextUtils.isEmpty(title) && TextUtils.isEmpty(snippet)) {
                marker.hideInfoWindow();
            } else {
                marker.showInfoWindow();
            }
        }
    }

    protected void Forward() {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        String f16 = com.tencent.biz.common.util.j.f(this.mCurPoiName, 45, "UTF-8", MiniBoxNoticeInfo.APPNAME_SUFFIX);
        String f17 = com.tencent.biz.common.util.j.f(this.loc, 90, "UTF-8", MiniBoxNoticeInfo.APPNAME_SUFFIX);
        String str = com.tencent.mobileqq.activity.l.f183340a + com.tencent.mobileqq.utils.bo.f307494a.a() + this.latitude + "," + this.longitude + "&iwloc=A&hl=zh-CN (" + f17 + ")";
        if (!getResources().getString(R.string.dq8).equals(f16)) {
            string = getResources().getString(R.string.aei) + " " + f16;
        } else {
            string = getResources().getString(R.string.aei);
        }
        String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + this.latitude + "&lon=" + this.longitude + "&title=" + f16 + "&loc=" + f17;
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(32).d(string).e(str).b("plugin", "", str2, str2, str2).a();
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
        c16.o("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", f16, f17);
        a16.addItem(c16);
        Intent intent = new Intent();
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        ForwardBaseOption.startForwardActivityForResult(this, intent, 0);
    }

    protected void addMyPosition(GeoPoint geoPoint, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) geoPoint, (Object) str);
            return;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.f160347b93, options);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap != null && tencentMap.getProjection() != null) {
            LatLng latLng = new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
            if (this.selfFixedPopView == null) {
                try {
                    View inflate = getLayoutInflater().inflate(R.layout.f168249q2, (ViewGroup) null);
                    this.selfFixedPopView = inflate;
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.cbq);
                    imageView.setImageResource(R.drawable.f160347b93);
                    imageView.setBackgroundDrawable(null);
                    Marker addMarker = this.tencentMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.selfFixedPopView)).position(latLng).snippet(""));
                    this.myLocMarker = addMarker;
                    showInfoWindow(addMarker);
                    return;
                } catch (Resources.NotFoundException e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            if (this.myLocMarker != null) {
                if (latLng.getLatitude() != this.myLocMarker.getPosition().getLatitude() || latLng.getLongitude() != this.myLocMarker.getPosition().getLongitude()) {
                    this.myLocMarker.setPosition(latLng);
                    this.myLocMarker.setSnippet("");
                    showInfoWindow(this.myLocMarker);
                }
            }
        }
    }

    public void addSelfLay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        if (this.mSelfLocationMarker == null) {
            try {
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.dgi);
                if (decodeResource != null && this.mSelfGeoPoint != null) {
                    Marker addMarker = this.tencentMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(decodeResource)).position(new LatLng(this.mSelfGeoPoint.getLatitudeE6() / 1000000.0d, this.mSelfGeoPoint.getLongitudeE6() / 1000000.0d)).title("").snippet(""));
                    this.mSelfLocationMarker = addMarker;
                    showInfoWindow(addMarker);
                }
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.TAG_QQMAP, 2, "addSelfLay:", e16);
                }
            }
        }
    }

    protected void asyncGetLocationName(GeoPoint geoPoint, TextView textView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, geoPoint, textView, Boolean.valueOf(z16));
            return;
        }
        this.location = "";
        try {
            new n(geoPoint, textView).execute(geoPoint);
            if (z16) {
                playPinAnimation();
            }
        } catch (RejectedExecutionException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
        }
    }

    protected void backCall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    protected void changeMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        String id5 = TimeZone.getDefault().getID();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "default timezone:" + id5);
        }
        if ((!"Asia/Shanghai".equals(id5) && !"Asia/Hong_Kong".equals(id5) && !"Asia/Chongqing".equals(id5) && !"Asia/Beijing".equals(id5)) || !OcrConfig.CHINESE.equals(Locale.getDefault().getLanguage())) {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
            this.isChangeToGoogleMap = true;
        }
    }

    boolean compare2LastPoint(GeoPoint geoPoint) {
        if (this.mLastPoint == null) {
            this.mLastPoint = geoPoint;
            return false;
        }
        if (geoPoint == null || Math.abs(geoPoint.getLatitudeE6() - this.mLastPoint.getLatitudeE6()) >= 1 || Math.abs(geoPoint.getLongitudeE6() - this.mLastPoint.getLongitudeE6()) >= 1) {
            return false;
        }
        return true;
    }

    public final <T> T decodePacket(byte[] bArr, String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (T) iPatchRedirector.redirect((short) 44, this, bArr, str, t16);
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getLocationData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Intent) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null && qQMapView.getMap() != null && this.mapView.getMap().getCameraPosition() != null && this.mapView.getMap().getCameraPosition().target != null) {
            LatLng latLng = this.mapView.getMap().getCameraPosition().target;
            bundle.putString("latitude", String.valueOf(latLng.getLatitude()));
            bundle.putString("longitude", String.valueOf(latLng.getLongitude()));
        }
        bundle.putString("description", this.location);
        if (TextUtils.isEmpty(this.mCurPoiName) || this.mCurPoiName.equals(getString(R.string.cxc))) {
            this.mCurPoiName = getString(R.string.f171093c61);
        }
        if (TextUtils.isEmpty(this.mCurPoiAdr)) {
            this.mCurPoiAdr = "Unknown Address";
        }
        bundle.putString("title", this.mCurPoiName);
        bundle.putString("summary", this.mCurPoiAdr);
        bundle.putString("dianping_id", this.mDianpingId);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getMyLocation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        this.mIsGetMyLocation = z16;
        if (!NetworkUtil.isNetSupport(this)) {
            showInvalidNetworkAlert();
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MAP, QQPermissionConstants.Business.SCENE.MAP_SHOW_ENTRY));
        if (vx.a.a(qQPermission)) {
            qQPermission.requestPermissions(vx.a.f443628a, 2, new a(qQPermission));
        } else {
            doStartLocation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void initData() {
        JSONObject jSONObject;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("options");
        String str3 = null;
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (NullPointerException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("get_params", 2, "parse params failed, options : " + string);
                }
            } catch (JSONException unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d("get_params", 2, "parse params failed, options : " + string);
                }
            }
            if (jSONObject == null) {
                String optString = jSONObject.optString(QCircleSchemeAttr.Polymerize.LAT);
                str = jSONObject.optString("lng");
                this.mCurPoiName = jSONObject.optString("title");
                this.loc = jSONObject.optString("desc");
                if (jSONObject.has("from")) {
                    str3 = jSONObject.optString("from");
                }
                this.mFrom = str3;
                this.isRightBtnShowShare = "share".equals(jSONObject.opt("action"));
                this.url = com.tencent.mobileqq.utils.bo.f307494a.a() + optString + "," + str + "&iwloc=A&hl=zh-CN (" + this.loc + ")";
                str3 = optString;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = extras.getString(QCircleSchemeAttr.Polymerize.LAT);
            }
            if (TextUtils.isEmpty(str)) {
                str = extras.getString("lon");
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
                this.startWithPos = true;
                this.latitude = Double.valueOf(str3).doubleValue();
                this.longitude = Double.valueOf(str).doubleValue();
            }
            if (TextUtils.isEmpty(this.mCurPoiName)) {
                this.mCurPoiName = extras.getString("title");
            }
            this.mCurPoiAdr = extras.getString("summary");
            if (TextUtils.isEmpty(this.url)) {
                this.url = extras.getString("url");
            }
            if (TextUtils.isEmpty(this.loc)) {
                this.loc = extras.getString("loc");
            }
            str2 = this.loc;
            if (str2 != null && str2.contains(org.slf4j.Marker.ANY_NON_NULL_MARKER)) {
                this.loc = this.loc.replace(org.slf4j.Marker.ANY_NON_NULL_MARKER, " ");
            }
            this.mDianpingId = extras.getString("dpid");
            this.mDensity = getResources().getDisplayMetrics().density;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.f154681c1);
            this.pinAnim = loadAnimation;
            loadAnimation.setRepeatMode(2);
            this.pinAnim.setRepeatCount(1);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.f154682c2);
            this.pinShadowAnim = loadAnimation2;
            loadAnimation2.setRepeatMode(2);
            this.pinShadowAnim.setRepeatCount(1);
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
        if (TextUtils.isEmpty(str3)) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        if (!TextUtils.isEmpty(str3)) {
            this.startWithPos = true;
            this.latitude = Double.valueOf(str3).doubleValue();
            this.longitude = Double.valueOf(str).doubleValue();
        }
        if (TextUtils.isEmpty(this.mCurPoiName)) {
        }
        this.mCurPoiAdr = extras.getString("summary");
        if (TextUtils.isEmpty(this.url)) {
        }
        if (TextUtils.isEmpty(this.loc)) {
        }
        str2 = this.loc;
        if (str2 != null) {
            this.loc = this.loc.replace(org.slf4j.Marker.ANY_NON_NULL_MARKER, " ");
        }
        this.mDianpingId = extras.getString("dpid");
        this.mDensity = getResources().getDisplayMetrics().density;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.f154681c1);
        this.pinAnim = loadAnimation3;
        loadAnimation3.setRepeatMode(2);
        this.pinAnim.setRepeatCount(1);
        Animation loadAnimation22 = AnimationUtils.loadAnimation(this, R.anim.f154682c2);
        this.pinShadowAnim = loadAnimation22;
        loadAnimation22.setRepeatMode(2);
        this.pinShadowAnim.setRepeatCount(1);
    }

    protected void initImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int color = getResources().getColor(R.color.skin_color_title_immersive_bar);
        if (this.mSystemBarComp == null) {
            this.mSystemBarComp = new SystemBarCompact((Activity) this, true, color);
            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(R.drawable.qq_title_immersive_bar));
            } else {
                this.mSystemBarComp.setStatusDrawable(null);
            }
        }
    }

    protected void initMap() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        findViewById(R.id.iir).setVisibility(8);
        this.mQQMapLayout = findViewById(R.id.grp);
        this.mapView = (QQMapView) findViewById(R.id.emb);
        this.pinView = (ImageView) findViewById(R.id.fua);
        this.jiejingIcon = findViewById(R.id.dz5);
        try {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dgl);
        } catch (OutOfMemoryError unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            this.pinView.setImageBitmap(bitmap);
            this.pinView.setPadding(0, 0, 0, bitmap.getHeight());
        }
        this.mapView.setContentDescription(getString(R.string.cxh));
        this.mapView.getMap().getUiSettings().setLogoPosition(0);
        this.mapView.getMap().getUiSettings().setScaleViewEnabled(false);
        this.mapView.getMap().getUiSettings().setGestureScaleByMapCenter(true);
        if (!this.startWithPos) {
            this.pinView.setVisibility(0);
            this.mapView.setObserver(this);
        } else {
            if ("SMARTISAN".equals(ROMUtil.getRomName())) {
                this.mapView.setLayerType(1, null);
            }
            this.mapView.setObserver(this);
            this.pinView.setVisibility(4);
            try {
                this.fixedPopView = getLayoutInflater().inflate(R.layout.f168249q2, (ViewGroup) null);
                this.mapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.fixedPopView)).position(new LatLng(this.latitude, this.longitude)));
                refreshStreetViewIcon();
            } catch (Resources.NotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, e16.getMessage());
                }
                super.finish();
                return;
            }
        }
        TencentMap map = this.mapView.getMap();
        this.tencentMap = map;
        map.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
        this.tencentMap.setOnMarkerClickListener(new h());
        changeMap();
        setAccSoft();
    }

    protected void initTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        textView.setContentDescription(HardCodeUtil.qqStr(R.string.quo));
        textView.setOnClickListener(this.onTitleLeftClickLister);
        TextView textView2 = (TextView) findViewById(R.id.ivTitleName);
        if (REQUEST_FROM_TROOP_ACTIVITY.equals(this.mFrom)) {
            textView2.setText(R.string.f170749a33);
        } else if (this.startWithPos) {
            textView2.setText(R.string.f173220i45);
        } else {
            textView2.setText(R.string.f170748a32);
        }
        TextView textView3 = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.tvTitleBtnRight = textView3;
        if (this.startWithPos) {
            if (this.isRightBtnShowShare) {
                textView3.setVisibility(0);
                this.tvTitleBtnRight.setText(R.string.cxd);
                this.tvTitleBtnRight.setOnClickListener(this.onTitleRightClickShareListener);
            } else {
                textView3.setVisibility(8);
                ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.header_btn_more);
                imageView.setContentDescription(getString(R.string.cat));
                imageView.setOnClickListener(this.onTitleRightHouseClickLister);
            }
        } else {
            if (REQUEST_FROM_TROOP_ACTIVITY.equals(this.mFrom)) {
                this.tvTitleBtnRight.setText(R.string.cx9);
            } else {
                this.tvTitleBtnRight.setText(R.string.cxd);
            }
            this.tvTitleBtnRight.setOnClickListener(this.onTitleRightSendClickLister);
        }
        TextView textView4 = this.tvTitleBtnRight;
        textView4.setTag(textView4.getText());
        this.tvTitleBtnRight.setTextColor(getResources().getColor(R.color.skin_bar_text));
        TextView textView5 = this.tvTitleBtnRight;
        AccessibilityUtil.c(textView5, textView5.getText(), Button.class.getName());
    }

    protected boolean isNeedDestroyBoradcast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void jumpToStreetViewMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.mStreetViewUrl);
        intent.putExtra("reqType", 4);
        super.startActivity(intent);
        jumpToStreetViewMapReport();
    }

    protected void jumpToStreetViewMapReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    protected void listenDistanceChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mTopLineLay.getViewTreeObserver().addOnGlobalLayoutListener(new f());
        }
    }

    protected void move2Location(double d16, double d17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Double.valueOf(d16), Double.valueOf(d17));
            return;
        }
        if (this.tencentMap != null) {
            GeoPoint geoPoint = new GeoPoint((int) (d16 * 1000000.0d), (int) (d17 * 1000000.0d));
            this.tencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d)));
            String str = this.loc;
            if (str != null && str.length() > 0) {
                this.mDetailAddrTxt.setText(this.loc);
                refreshStreetViewIcon();
            } else {
                asyncGetLocationName(geoPoint, this.mDetailAddrTxt, false);
            }
        }
    }

    public Dialog newCustomDialog(int i3, int i16, DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Dialog) iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Integer.valueOf(i16), onDismissListener);
        }
        return com.tencent.mobileqq.util.t.b(this, getResources().getString(i3), getResources().getString(i16), onDismissListener);
    }

    public Dialog newCustomProgressDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Dialog) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        }
        ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.custom_progress_dialog);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogText);
        if (textView != null) {
            textView.setText(str);
        }
        return reportDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.setResult(-1, new Intent());
        try {
            backCall();
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            super.finish();
        }
    }

    @Override // com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.processer = new SkinnableActivityProcesser(this, this);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
            if (this.mActNeedImmersive) {
                try {
                    initImmersive();
                } catch (IllegalStateException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " getResources() has IllegalStateException e = " + e16);
                    }
                }
            }
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.b4m, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        }
        super.setContentView(inflate);
        this.uin = super.getIntent().getStringExtra("uin");
        sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
        this.mRouteBar = super.findViewById(R.id.ifk);
        this.mRouteBtn = (Button) super.findViewById(R.id.ifj);
        this.mAddrTxt = (TextView) super.findViewById(R.id.f164041i8);
        this.mDetailAddrTxt = (TextView) super.findViewById(R.id.f164970bh2);
        this.mDistanceTxt = (TextView) super.findViewById(R.id.bmq);
        this.mTopLineLay = (LinearLayout) findViewById(R.id.jtl);
        initData();
        initTitleBar();
        initMap();
        if (this.startWithPos) {
            move2Location(this.latitude, this.longitude);
            getMyLocation(true);
        } else {
            getMyLocation(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ON_GET_STREET_VIEW_URL);
        intentFilter.addAction("com.tencent.mobileqq.onGetLbsShareSearch");
        intentFilter.addAction("com.tencent.mobileqq.onGetLbsShareShop");
        intentFilter.addAction("com.tencent.mobileqq.onGetShareShopDetail");
        registerReceiver(this.mBroadcastReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        registerReceiver(this.mScreenReceiver, intentFilter2);
        if (this.startWithPos) {
            sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.latitude).putExtra("longitude", this.longitude));
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Dialog) iPatchRedirector.redirect((short) 36, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            Dialog newCustomDialog = newCustomDialog(R.string.b9k, R.string.b9j, new b());
            View findViewById = newCustomDialog.findViewById(R.id.dialogLeftBtn);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener(newCustomDialog) { // from class: com.tencent.mobileqq.activity.QQMapActivity.12
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Dialog f176848d;

                    {
                        this.f176848d = newCustomDialog;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQMapActivity.this, (Object) newCustomDialog);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                        } else {
                            QQMapActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.QQMapActivity.12.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass12.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    QQMapActivity qQMapActivity = QQMapActivity.this;
                                    qQMapActivity.isRefreshPressed = true;
                                    qQMapActivity.refresh();
                                }
                            });
                            Dialog dialog = this.f176848d;
                            if (dialog != null && dialog.isShowing()) {
                                this.f176848d.dismiss();
                            }
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            }
            View findViewById2 = newCustomDialog.findViewById(R.id.dialogRightBtn);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new c(newCustomDialog));
                return newCustomDialog;
            }
            return newCustomDialog;
        }
        return newCustomProgressDialog(getString(R.string.bj8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        SkinnableActivityProcesser skinnableActivityProcesser = this.processer;
        if (skinnableActivityProcesser != null) {
            skinnableActivityProcesser.destory();
        }
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null) {
            qQMapView.destroy();
        }
        if (isNeedDestroyBoradcast()) {
            sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
            sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
        }
        super.unregisterReceiver(this.mScreenReceiver);
        super.unregisterReceiver(this.mBroadcastReceiver);
    }

    void onFetchDataFailed() {
        this.fetchDataFailed = true;
        if (!isFinishing()) {
            super.showDialog(1);
        }
        if (!this.startWithPos) {
            TextView textView = (TextView) findViewById(R.id.ivTitleBtnRightText);
            textView.setVisibility(0);
            textView.setText(R.string.f170604vb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFetchDataSuceeded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        this.fetchDataFailed = false;
        if (!this.startWithPos) {
            TextView textView = (TextView) findViewById(R.id.ivTitleBtnRightText);
            textView.setVisibility(0);
            textView.setText(textView.getTag().toString());
        }
    }

    protected void onGetLbsShareSearch(LBSShare$LocationResp lBSShare$LocationResp, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) lBSShare$LocationResp, (Object) bundle);
        }
    }

    protected void onGetLbsShareShop(LBSShare$NearByShopsResp lBSShare$NearByShopsResp, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) lBSShare$NearByShopsResp, (Object) bundle);
        }
    }

    protected void onGetShareShopDetail(LBSShare$GetShopsByIdsResp lBSShare$GetShopsByIdsResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) lBSShare$GetShopsByIdsResp);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.widget.QQMapView.b
    public void onMapScrollEnd(GeoPoint geoPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) geoPoint);
        } else if (!this.startWithPos && !compare2LastPoint(geoPoint)) {
            this.mLastPoint = geoPoint;
            updateLocationAddress(geoPoint);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.widget.QQMapView.b
    public void onMapScrollStart(GeoPoint geoPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) geoPoint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null) {
            qQMapView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (i3 == 1) {
            if (iArr[0] == 0) {
                getMyLocation(this.mIsGetMyLocation);
            } else {
                DialogUtil.showPermissionSettingDialog2(this, strArr, iArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null) {
            qQMapView.onResume();
        }
        SystemBarCompact systemBarCompact = this.mSystemBarComp;
        if (systemBarCompact != null) {
            systemBarCompact.init();
        }
        boolean appForground = BaseGesturePWDUtil.getAppForground(this);
        QBaseActivity.mAppForground = appForground;
        if (!appForground && BaseGesturePWDUtil.getGesturePWDState(this, this.uin) == 2 && BaseGesturePWDUtil.getGesturePWDMode(this, this.uin) == 21) {
            if (QLog.isColorLevel()) {
                QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
            }
            super.startActivity(new Intent(this, (Class<?>) GesturePWDUnlockActivity.class));
            this.hasLocked = true;
        } else {
            this.hasLocked = false;
        }
        if (!QBaseActivity.mAppForground) {
            QBaseActivity.mAppForground = true;
            GesturePWDUtils.setAppForground(this, true);
        }
        this.hasStoped = false;
        if (!this.mIsGetMyLocation) {
            getMyLocation(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onStart();
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null) {
            qQMapView.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStop();
        QQMapView qQMapView = this.mapView;
        if (qQMapView != null) {
            qQMapView.onStop();
        }
        this.hasStoped = true;
        QBaseActivity.mAppForground = BaseGesturePWDUtil.getAppForground(this);
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.mLocationListener);
        boolean z16 = QBaseActivity.mAppForground;
        if (!z16) {
            GesturePWDUtils.setAppForground(this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTroopActivityCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, android.app.Activity
    public void onUserLeaveHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            super.onUserLeaveHint();
            sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
        }
    }

    void playPinAnimation() {
        if (this.pinView.getVisibility() == 0) {
            this.pinView.startAnimation(this.pinAnim);
        }
    }

    protected void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            getMyLocation(true);
        }
    }

    protected void refreshStreetViewIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_QQMAP, 2, "refreshStreetViewIcon: hideStreet=" + this.hideJiejingIcon + ", url=" + this.mStreetViewUrl);
        }
        String str = this.mStreetViewUrl;
        if (str != null && str.length() != 0) {
            View view = this.jiejingIcon;
            if (view != null && !this.hideJiejingIcon) {
                view.setVisibility(0);
                this.jiejingIcon.setOnClickListener(new g());
                return;
            }
            return;
        }
        View view2 = this.jiejingIcon;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    protected void sendSuccessCall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    protected void setAccSoft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        if (viewGroup != null) {
            IphoneTitleBarActivity.setLayerType(viewGroup);
        }
        View findViewById = findViewById(R.id.title);
        if (findViewById != null) {
            IphoneTitleBarActivity.setLayerType(findViewById);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            IphoneTitleBarActivity.setLayerType(textView);
        }
    }

    protected void showInvalidNetworkAlert() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.ci7)).setMessage(R.string.b3j).setPositiveButton(getString(R.string.f170648xe), new m()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLocationAddress(GeoPoint geoPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) geoPoint);
        }
    }
}
