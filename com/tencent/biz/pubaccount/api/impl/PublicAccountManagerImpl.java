package com.tencent.biz.pubaccount.api.impl;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp$ActionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountMenuRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountMenuResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$SendMenuEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$SendMenuEventResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$SendOrderPayEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$SendOrderPayEventResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$SendPublicAccountMessageReceiptRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$SendPublicAccountMessageReceiptResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$SetRefuseFollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$SetRefuseFollowResponse;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountManagerImpl implements IPublicAccountManager {
    public static final boolean DEBUG = false;
    public static final long DEBUG_UIN = 350749526;
    static final long MENU_SETTING_MAX_CACHE_TIME = 21600000;
    public static final String PA_HISTORY_MSG_PARAMS = "history_msg_params";
    public static final int PA_PICSOURCE_ALBUM = 2;
    public static final int PA_PICSOURCE_CAMERA = 1;
    public static final int PA_PICSOURCE_NONE = 0;
    public static final String SSO_COMMAND_POST_PUNCHCARD_INFO = "post_punchcard_info";
    public static final String SSO_COMMAND_PULL_BIT_APP_MSG = "lola_update_req";
    public static final int TypeGetAccountMenuSetting = 0;
    private String mCurrentUin;
    private long lastPreloadWebProcessorTime = 0;
    public boolean hasPreloadWebProcessor = false;
    public WeakReference<AppInterface> mApp = new WeakReference<>(null);
    String mTempUin = null;
    String mTempKey = null;
    boolean mIsNewMenu = false;
    WeakReference<Context> mTempContext = new WeakReference<>(null);
    private WeakReference<BusinessObserver> mPublicAccountMenuEventObserver = new WeakReference<>(null);
    BroadcastReceiver scanResultReceiver = null;
    BroadcastReceiver picResultReceiver = null;
    int mPicSource = 0;
    BroadcastReceiver locationResultReceiver = null;
    Map<String, Long> menuSettingLastSaveDateTimeMap = new HashMap();
    Map<String, Integer> menuSettingSeqnoMap = new HashMap();
    Map<String, List<mobileqq_mp$ButtonInfo>> mPublicAccountMenuButtonLists = new HashMap();
    Map<String, Integer> mPublicAccountMenuType = new HashMap();
    private boolean mKeepOldPublicAccountData = false;
    protected Runnable getLocationThread = new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.4
        @Override // java.lang.Runnable
        public void run() {
            AppInterface appInterface = PublicAccountManagerImpl.this.mApp.get();
            PublicAccountManagerImpl publicAccountManagerImpl = PublicAccountManagerImpl.this;
            String str = publicAccountManagerImpl.mTempKey;
            boolean z16 = publicAccountManagerImpl.mIsNewMenu;
            WeakReference<Context> weakReference = publicAccountManagerImpl.mTempContext;
            if (weakReference == null || weakReference.get() == null || appInterface == null) {
                return;
            }
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a(1, true, true, 0L, true, false, IPublicAccountManager.TAG, str, z16));
        }

        /* renamed from: com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl$4$a */
        /* loaded from: classes32.dex */
        class a extends SosoInterfaceOnLocationListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f79483a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f79484b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str, String str2, boolean z26) {
                super(i3, z16, z17, j3, z18, z19, str);
                this.f79483a = str2;
                this.f79484b = z26;
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                String str;
                if (i3 != 0 || sosoLbsInfo == null) {
                    return;
                }
                try {
                    SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                    if (sosoLocation != null) {
                        double d16 = sosoLocation.mLat02;
                        double d17 = sosoLocation.mLon02;
                        String str2 = "";
                        if (sosoLocation.address != null) {
                            str2 = "" + sosoLbsInfo.mLocation.address;
                        }
                        if (sosoLbsInfo.mLocation.name != null) {
                            str = str2 + sosoLbsInfo.mLocation.name;
                        } else {
                            str = str2;
                        }
                        PublicAccountManagerImpl.this.reportClickTypeMenuEvent(true, d16, d17, str, null, this.f79483a, this.f79484b);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    PublicAccountManagerImpl.this.reportClickTypeMenuEvent(false, 0.0d, 0.0d, null, null, this.f79483a, this.f79484b);
                }
            }
        }
    };
    private long mLastReportTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (PublicAccountManagerImpl.this.mPicSource == 1) {
                PublicAccountManagerImpl.this.reportEventTypeMenuEvent(null, 0, 13, intent.getIntExtra(IPublicAccountManager.PA_DATA_PIC_RESULT, -1), intent.getStringArrayListExtra(IPublicAccountManager.PA_DATA_PIC_RESULT_FILEMD5S));
                try {
                    context.unregisterReceiver(PublicAccountManagerImpl.this.picResultReceiver);
                } catch (Exception unused) {
                }
                PublicAccountManagerImpl publicAccountManagerImpl = PublicAccountManagerImpl.this;
                publicAccountManagerImpl.picResultReceiver = null;
                publicAccountManagerImpl.mPicSource = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (PublicAccountManagerImpl.this.mPicSource == 2) {
                PublicAccountManagerImpl.this.reportEventTypeMenuEvent(null, 0, 14, intent.getIntExtra(IPublicAccountManager.PA_DATA_PIC_RESULT, -1), intent.getStringArrayListExtra(IPublicAccountManager.PA_DATA_PIC_RESULT_FILEMD5S));
                try {
                    context.unregisterReceiver(PublicAccountManagerImpl.this.picResultReceiver);
                } catch (Exception unused) {
                }
                PublicAccountManagerImpl publicAccountManagerImpl = PublicAccountManagerImpl.this;
                publicAccountManagerImpl.picResultReceiver = null;
                publicAccountManagerImpl.mPicSource = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f79494a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f79495b;

        d(String str, boolean z16) {
            this.f79494a = str;
            this.f79495b = z16;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PublicAccountManagerImpl.this.reportEventTypeMenuEventLocation(Double.parseDouble(intent.getStringExtra("latitude")), Double.parseDouble(intent.getStringExtra("longitude")), intent.getStringExtra("name"), this.f79494a, this.f79495b);
            try {
                context.unregisterReceiver(PublicAccountManagerImpl.this.locationResultReceiver);
            } catch (Exception unused) {
            }
            PublicAccountManagerImpl.this.locationResultReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewIntent f79497d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79498e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f79499f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f79500h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AppInterface f79501i;

        e(NewIntent newIntent, Context context, String str, BusinessObserver businessObserver, AppInterface appInterface) {
            this.f79497d = newIntent;
            this.f79498e = context;
            this.f79499f = str;
            this.f79500h = businessObserver;
            this.f79501i = appInterface;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            this.f79497d.setObserver(null);
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    mobileqq_mp$SendMenuEventResponse mobileqq_mp_sendmenueventresponse = new mobileqq_mp$SendMenuEventResponse();
                    mobileqq_mp_sendmenueventresponse.mergeFrom(byteArray);
                    SharedPreferences sharedPreferences = this.f79498e.getSharedPreferences(IPublicAccountManager.MENU_EVENT_SHAREPRE, 0);
                    if (sharedPreferences.contains(this.f79499f) && mobileqq_mp_sendmenueventresponse.seqno.has() && mobileqq_mp_sendmenueventresponse.seqno.get() != sharedPreferences.getInt(this.f79499f, 0)) {
                        BusinessObserver businessObserver = this.f79500h;
                        if (businessObserver != null) {
                            PublicAccountManagerImpl.this.getMenuSetting(this.f79498e, this.f79501i, this.f79499f, businessObserver, true);
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putInt(this.f79499f, mobileqq_mp_sendmenueventresponse.seqno.get());
                        edit.commit();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes32.dex */
    class f implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewIntent f79503d;

        f(NewIntent newIntent) {
            this.f79503d = newIntent;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            this.f79503d.setObserver(null);
            if (z16) {
                try {
                    mobileqq_mp$SendOrderPayEventResponse mobileqq_mp_sendorderpayeventresponse = new mobileqq_mp$SendOrderPayEventResponse();
                    mobileqq_mp_sendorderpayeventresponse.mergeFrom(bundle.getByteArray("data"));
                    if (mobileqq_mp_sendorderpayeventresponse.ret_info.has()) {
                        mobileqq_mp_sendorderpayeventresponse.ret_info.ret_code.get();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewIntent f79504d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79505e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f79506f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f79507h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AppInterface f79508i;

        g(NewIntent newIntent, Context context, String str, BusinessObserver businessObserver, AppInterface appInterface) {
            this.f79504d = newIntent;
            this.f79505e = context;
            this.f79506f = str;
            this.f79507h = businessObserver;
            this.f79508i = appInterface;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            this.f79504d.setObserver(null);
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    mobileqq_mp$SendMenuEventResponse mobileqq_mp_sendmenueventresponse = new mobileqq_mp$SendMenuEventResponse();
                    mobileqq_mp_sendmenueventresponse.mergeFrom(byteArray);
                    SharedPreferences sharedPreferences = this.f79505e.getSharedPreferences(IPublicAccountManager.MENU_EVENT_SHAREPRE, 0);
                    if (sharedPreferences.contains(this.f79506f) && mobileqq_mp_sendmenueventresponse.seqno.has() && mobileqq_mp_sendmenueventresponse.seqno.get() != sharedPreferences.getInt(this.f79506f, 0)) {
                        BusinessObserver businessObserver = this.f79507h;
                        if (businessObserver != null) {
                            PublicAccountManagerImpl.this.getMenuSetting(this.f79505e, this.f79508i, this.f79506f, businessObserver, true);
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putInt(this.f79506f, mobileqq_mp_sendmenueventresponse.seqno.get());
                        edit.commit();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes32.dex */
    class h implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewIntent f79510d;

        h(NewIntent newIntent, IPublicAccountManager.b bVar) {
            this.f79510d = newIntent;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            this.f79510d.setObserver(null);
            if (QLog.isColorLevel()) {
                QLog.i(IPublicAccountManager.TAG, 2, "success:" + String.valueOf(z16));
            }
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    mobileqq_mp$SetRefuseFollowResponse mobileqq_mp_setrefusefollowresponse = new mobileqq_mp$SetRefuseFollowResponse();
                    mobileqq_mp_setrefusefollowresponse.mergeFrom(byteArray);
                    if (mobileqq_mp_setrefusefollowresponse.ret_info.has() && mobileqq_mp_setrefusefollowresponse.ret_info.ret_code.has()) {
                        mobileqq_mp_setrefusefollowresponse.ret_info.ret_code.get();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes32.dex */
    class i implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewIntent f79512d;

        i(NewIntent newIntent) {
            this.f79512d = newIntent;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            this.f79512d.setObserver(null);
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    mobileqq_mp$SendPublicAccountMessageReceiptResponse mobileqq_mp_sendpublicaccountmessagereceiptresponse = new mobileqq_mp$SendPublicAccountMessageReceiptResponse();
                    mobileqq_mp_sendpublicaccountmessagereceiptresponse.mergeFrom(byteArray);
                    if (mobileqq_mp_sendpublicaccountmessagereceiptresponse.ret_info.has() && mobileqq_mp_sendpublicaccountmessagereceiptresponse.ret_info.ret_code.has()) {
                        if (mobileqq_mp_sendpublicaccountmessagereceiptresponse.ret_info.ret_code.get() != 0) {
                            z16 = false;
                        }
                    }
                } catch (Exception unused) {
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    str = "sendMsgArriveReceipt response :" + String.valueOf(false);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i(IPublicAccountManager.TAG, 2, "sendMsgArriveReceipt response :" + String.valueOf(z16));
                    }
                    throw th5;
                }
                if (QLog.isColorLevel()) {
                    str = "sendMsgArriveReceipt response :" + String.valueOf(z16);
                    QLog.i(IPublicAccountManager.TAG, 2, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f79514a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MqqHandler f79515b;

        j(boolean z16, MqqHandler mqqHandler) {
            this.f79514a = z16;
            this.f79515b = mqqHandler;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(IPublicAccountManager.PA_DATA_SCAN_RESULT);
            int intExtra = intent.getIntExtra(IPublicAccountManager.PA_DATA_SCAN_RESULT_TYPE, 0);
            if (this.f79514a) {
                PublicAccountManagerImpl.this.reportEventTypeMenuEvent(stringExtra, intExtra, 12, -1, null);
                MqqHandler mqqHandler = this.f79515b;
                if (mqqHandler != null) {
                    mqqHandler.sendEmptyMessage(19);
                }
            } else {
                PublicAccountManagerImpl.this.reportEventTypeMenuEvent(stringExtra, intExtra, 11, -1, null);
            }
            try {
                context.unregisterReceiver(PublicAccountManagerImpl.this.scanResultReceiver);
            } catch (Exception unused) {
            }
            PublicAccountManagerImpl.this.scanResultReceiver = null;
        }
    }

    public static String createSendPayInfoBody(long j3, long j16, String str, int i3, String str2, int i16, int i17, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("luin", j3);
            jSONObject.put("msg_id", j16);
            if (str == null) {
                str = "";
            }
            jSONObject.put("order_id", str);
            jSONObject.put("ret_code", i3);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("ret_str", str2);
            jSONObject.put(QQHealthReportApiImpl.MSG_TYPE_KEY, i16);
            jSONObject.put("pay_time", i17);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("reserve_1", str3);
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("reserve_2", str4);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    private static void handleUrlEvent(Context context, AppInterface appInterface, String str, mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo) {
        ChatFragment chatFragment;
        if ((context instanceof BaseActivity) && (chatFragment = ((BaseActivity) context).getChatFragment()) != null) {
            a61.c qh5 = chatFragment.qh();
            if (qh5 instanceof com.tencent.mobileqq.activity.aio.rebuild.c) {
                ((com.tencent.mobileqq.activity.aio.rebuild.c) qh5).f179835w++;
            }
        }
        StringBuilder sb5 = new StringBuilder(mobileqq_mp_buttoninfo.url.has() ? mobileqq_mp_buttoninfo.url.get() : "");
        if (sb5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) < 0) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        } else if (sb5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) < sb5.length() - 1) {
            if (sb5.indexOf(ContainerUtils.FIELD_DELIMITER) < 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            } else if (sb5.lastIndexOf(ContainerUtils.FIELD_DELIMITER) < sb5.length() - 1) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        Intent intent = new Intent(context, (Class<?>) PublicAccountBrowserImpl.class);
        intent.putExtra("from", QQBrowserActivity.class);
        intent.putExtra("url", sb5.toString());
        intent.putExtra("uin", appInterface.getCurrentAccountUin());
        intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, str);
        intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, context.getResources().getString(R.string.button_back));
        intent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
        intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(str));
        if (str.equalsIgnoreCase(IPublicAccountBrowser.PUB_COUPON_UIN)) {
            intent.putExtra("hide_operation_bar", true);
        }
        context.startActivity(intent);
    }

    private mobileqq_mp$SendMenuEventRequest initSendMenuEventRequest(int i3, String str, boolean z16) {
        String str2 = this.mTempUin;
        try {
            long longValue = Long.valueOf(str2).longValue();
            mobileqq_mp$SendMenuEventRequest mobileqq_mp_sendmenueventrequest = new mobileqq_mp$SendMenuEventRequest();
            mobileqq_mp_sendmenueventrequest.uin.set((int) longValue);
            mobileqq_mp_sendmenueventrequest.type.set(i3);
            mobileqq_mp_sendmenueventrequest.key.set(str);
            mobileqq_mp_sendmenueventrequest.msg_id.set(0L);
            mobileqq_mp_sendmenueventrequest.s_type.set(1);
            mobileqq_mp_sendmenueventrequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
            mobileqq_mp_sendmenueventrequest.menu_type.set(getPublicAccountMenuType(str2));
            if (z16) {
                mobileqq_mp_sendmenueventrequest.is_new_menu.set(z16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountManager-init:", 2, "type:" + mobileqq_mp_sendmenueventrequest.type.get() + " uin:" + mobileqq_mp_sendmenueventrequest.uin.get() + " key:" + mobileqq_mp_sendmenueventrequest.key.get() + " msg_id:" + mobileqq_mp_sendmenueventrequest.msg_id.get() + " s_type:" + mobileqq_mp_sendmenueventrequest.s_type.get() + " versionInfo:" + mobileqq_mp_sendmenueventrequest.versionInfo.get() + " is_new_menu:" + mobileqq_mp_sendmenueventrequest.is_new_menu.get());
            }
            return mobileqq_mp_sendmenueventrequest;
        } catch (NumberFormatException unused) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e(IPublicAccountManager.TAG, 2, "puin is invalid format:" + str2);
            return null;
        }
    }

    public static boolean isFuWuHaoType(AppInterface appInterface, String str) {
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str.toString());
        if (publicAccountInfo != null) {
            return (publicAccountInfo.accountFlag & (-1902116864)) == 0;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(str);
        return publicAccountDetailImpl != null && (publicAccountDetailImpl.accountFlag & (-1902116864)) == 0;
    }

    private boolean isMenuSettingOutDate(String str, Context context) {
        if (!this.menuSettingLastSaveDateTimeMap.containsKey(str)) {
            return true;
        }
        long longValue = this.menuSettingLastSaveDateTimeMap.get(str).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = context.getSharedPreferences(IPublicAccountManager.MENU_EVENT_SHAREPRE, 0).getLong(IPublicAccountManager.MENU_CACHE_TIME, -1L);
        if (j3 <= 0) {
            j3 = 21600000;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountManager-Menu", 2, "cacheTime(ms):" + j3);
        }
        return currentTimeMillis - longValue >= j3;
    }

    private static void oldUrEventHandle(AppInterface appInterface, Context context, String str, mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo) {
        if (mobileqq_mp_buttoninfo.item_id.has() && mobileqq_mp_buttoninfo.item_id.get() == 5) {
            Intent intent = new Intent(context, (Class<?>) CouponActivity.class);
            intent.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
            intent.putExtra("source", "1");
            intent.putExtra("from", 5);
            context.startActivity(intent);
            return;
        }
        if (mobileqq_mp_buttoninfo.item_id.has() && mobileqq_mp_buttoninfo.item_id.get() == 6) {
            Intent intent2 = new Intent(context, (Class<?>) CouponActivity.class);
            if (mobileqq_mp_buttoninfo.url.has()) {
                intent2.putExtra("url", mobileqq_mp_buttoninfo.url.get());
            }
            intent2.putExtra("webStyle", "noBottomBar");
            context.startActivity(intent2);
            return;
        }
        if (mobileqq_mp_buttoninfo.url.has() && MiniAppLauncher.isMiniAppScheme(mobileqq_mp_buttoninfo.url.get())) {
            MiniAppLauncher.launchMiniAppByScheme(context, mobileqq_mp_buttoninfo.url.get(), 1209);
            return;
        }
        if (mobileqq_mp_buttoninfo.url.has() && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(mobileqq_mp_buttoninfo.url.get())) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, mobileqq_mp_buttoninfo.url.get(), 1035, null);
            return;
        }
        if (mobileqq_mp_buttoninfo.url.has() && com.tencent.mobileqq.activity.qcircle.utils.c.g().canJumpBySchema(mobileqq_mp_buttoninfo.url.get())) {
            com.tencent.mobileqq.activity.qcircle.utils.c.g().enterByScheme(context, com.tencent.mobileqq.activity.qcircle.utils.c.g().fetchSchemaFromUrl(mobileqq_mp_buttoninfo.url.get()));
        } else if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isHealthUin(str) && mobileqq_mp_buttoninfo.f247282id.get() == 1) {
            ((IQQHealthService) appInterface.getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI)).redirectAIOToMainPage(context, 161);
        } else {
            handleUrlEvent(context, appInterface, str, mobileqq_mp_buttoninfo);
        }
    }

    private void openAlbum(Context context, AppInterface appInterface, SessionInfo sessionInfo) {
        Uri a16 = com.tencent.mobileqq.util.o.a();
        if (a16 != null) {
            ActionSheet create = ActionSheet.create((BaseActivity) context);
            for (String str : context.getResources().getStringArray(R.array.f155241br)) {
                create.addButton(str);
            }
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new b(appInterface, context, a16, sessionInfo, create));
            create.show();
        } else {
            PlusPanelUtils.a((QQAppInterface) appInterface, (Activity) context, sessionInfo, null, null);
            com.tencent.mobileqq.troop.troopphoto.api.a aVar = (com.tencent.mobileqq.troop.troopphoto.api.a) appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
            if (!TextUtils.isEmpty(sessionInfo.f179557e) && sessionInfo.f179555d == 1) {
                aVar.t(sessionInfo.f179557e, true);
            }
            ((BaseActivity) context).setCanLock(false);
        }
        BroadcastReceiver broadcastReceiver = this.picResultReceiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.picResultReceiver = null;
        }
        this.picResultReceiver = new c();
        context.registerReceiver(this.picResultReceiver, new IntentFilter(IPublicAccountManager.PA_ACTION_PIC_RESULT), "com.tencent.msg.permission.pushnotify", null);
        this.mPicSource = 2;
    }

    private void openInfoCard(AppInterface appInterface, Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra(IPublicAccountUtil.NEED_FINISH, true);
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent, appInterface, context, str, -1);
    }

    private void openLocation(Context context, AppInterface appInterface, SessionInfo sessionInfo) {
        String str = this.mTempKey;
        boolean z16 = this.mIsNewMenu;
        try {
            ((BaseActivity) context).getChatFragment().qh().a();
            Intent intent = new Intent(context, (Class<?>) PoiMapActivity.class);
            intent.putExtra("uintype", sessionInfo.f179555d);
            ((BaseActivity) context).startActivityForResult(intent, 18);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ((BaseActivity) context).setCanLock(false);
        BroadcastReceiver broadcastReceiver = this.locationResultReceiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.locationResultReceiver = null;
        }
        this.locationResultReceiver = new d(str, z16);
        context.registerReceiver(this.locationResultReceiver, new IntentFilter(IPublicAccountManager.PA_ACTION_LOCATION_RESULT), "com.tencent.msg.permission.pushnotify", null);
    }

    private void openOtherCity(Context context, AppInterface appInterface) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://ti.qq.com/v2/city-selector/index?_wv=5127&redirect_url=%2F%2Fweather.mp.qq.com%2F&from=aio");
        intent.putExtra("fromAio", true);
        intent.putExtra("big_brother_source_key", "biz_src_gzh_weather");
        context.startActivity(intent);
        ((IWeatherReportApi) QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface) appInterface, "aio_othercity_click");
    }

    private void openScanner(Context context, MqqHandler mqqHandler, boolean z16) {
        Intent intent = new Intent();
        intent.putExtra("from", PublicAccountManagerImpl.class.getName());
        intent.putExtra("scanForResult", z16);
        BroadcastReceiver broadcastReceiver = this.scanResultReceiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.scanResultReceiver = null;
        }
        this.scanResultReceiver = new j(z16, mqqHandler);
        context.registerReceiver(this.scanResultReceiver, new IntentFilter(IPublicAccountManager.PA_ACTION_SCAN_RESULT), "com.tencent.msg.permission.pushnotify", null);
        RouteUtils.startActivity(context, intent, "/qrscan/scanner");
    }

    private void sendReportRequest(mobileqq_mp$SendMenuEventRequest mobileqq_mp_sendmenueventrequest) {
        BusinessObserver businessObserver = this.mPublicAccountMenuEventObserver.get();
        Context context = this.mTempContext.get();
        AppInterface appInterface = this.mApp.get();
        String str = this.mTempUin;
        NewIntent newIntent = new NewIntent(context, PublicAccountStQWebServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SEND_MENU_EVENT_NEW);
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(-1L);
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(mobileqq_mp_sendmenueventrequest.toByteArray()));
        String traceId = ze0.a.getTraceId();
        if (!TextUtils.isEmpty(traceId)) {
            stQWebReq.traceid.set(traceId);
        }
        byte[] byteArray = stQWebReq.toByteArray();
        if (byteArray == null) {
            byteArray = new byte[4];
        }
        newIntent.putExtra("traceid", traceId);
        newIntent.putExtra("data", byteArray);
        newIntent.setObserver(new e(newIntent, context, str, businessObserver, appInterface));
        if (appInterface != null) {
            appInterface.startServlet(newIntent);
        }
    }

    private static void tryHandleOpenApp(AppInterface appInterface, Context context, String str, mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo, String str2) {
        long j3 = mobileqq_mp_buttoninfo.actionInfo.appid.get();
        Uri parse = Uri.parse(str2);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (!TextUtils.isEmpty(scheme) && com.tencent.open.business.base.a.a(scheme)) {
            eq2.a aVar = new eq2.a();
            boolean z16 = true;
            boolean z17 = eq2.a.h(host) != 0;
            Bundle g16 = eq2.a.g(host);
            int i3 = g16.getInt("a_launch_mode", 268435456);
            if (z17) {
                aVar.d(appInterface, context, String.valueOf(j3), host, scheme, i3);
            } else {
                z16 = com.tencent.open.business.base.a.t(context, scheme, g16, i3);
            }
            if (z16) {
                return;
            }
            oldUrEventHandle(appInterface, context, str, mobileqq_mp_buttoninfo);
            return;
        }
        oldUrEventHandle(appInterface, context, str, mobileqq_mp_buttoninfo);
    }

    private void updateMenuSettingLocalDateTime(String str, long j3) {
        this.menuSettingLastSaveDateTimeMap.put(str, Long.valueOf(j3));
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void clearBroadcastReceiver(Context context) {
        BroadcastReceiver broadcastReceiver = this.scanResultReceiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.scanResultReceiver = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.picResultReceiver;
        if (broadcastReceiver2 != null) {
            try {
                context.unregisterReceiver(broadcastReceiver2);
            } catch (Exception unused2) {
            }
            this.picResultReceiver = null;
        }
        BroadcastReceiver broadcastReceiver3 = this.locationResultReceiver;
        if (broadcastReceiver3 != null) {
            try {
                context.unregisterReceiver(broadcastReceiver3);
            } catch (Exception unused3) {
            }
            this.locationResultReceiver = null;
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void clearOldPublicAccountData(String str) {
        if (!this.mKeepOldPublicAccountData) {
            this.menuSettingLastSaveDateTimeMap.remove(str);
            this.menuSettingSeqnoMap.remove(str);
            this.mPublicAccountMenuButtonLists.remove(str);
            this.mPublicAccountMenuType.remove(str);
            this.mLastReportTime = 0L;
        }
        if (QLog.isColorLevel()) {
            QLog.e(IPublicAccountManager.TAG, 2, "left menu size:" + this.mPublicAccountMenuButtonLists.size() + ", " + this.mKeepOldPublicAccountData);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public mobileqq_mp$ButtonInfo getButtonInfoByMenuId(AppInterface appInterface, String str, int i3) {
        List<mobileqq_mp$ButtonInfo> localPublicAccountMenuSetting = getLocalPublicAccountMenuSetting(appInterface, str);
        if (localPublicAccountMenuSetting != null && !localPublicAccountMenuSetting.isEmpty()) {
            for (int i16 = 0; i16 < localPublicAccountMenuSetting.size(); i16++) {
                mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo = localPublicAccountMenuSetting.get(i16);
                if (mobileqq_mp_buttoninfo.f247282id.has() && mobileqq_mp_buttoninfo.f247282id.get() == i3) {
                    return mobileqq_mp_buttoninfo;
                }
                if (mobileqq_mp_buttoninfo.sub_button.has()) {
                    List<mobileqq_mp$ButtonInfo> list = mobileqq_mp_buttoninfo.sub_button.get();
                    if (list.size() > 0) {
                        for (int i17 = 0; i17 < list.size(); i17++) {
                            if (list.get(i17).f247282id.has() && list.get(i17).f247282id.get() == i3) {
                                return list.get(i17);
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public String getCurrentUin() {
        return this.mCurrentUin;
    }

    List<mobileqq_mp$ButtonInfo> getLocalPublicAccountMenuSetting(AppInterface appInterface, String str) {
        return this.mPublicAccountMenuButtonLists.get(str);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public NewIntent getMenuSetting(final Context context, final AppInterface appInterface, final String str, final BusinessObserver businessObserver, boolean z16) {
        int i3;
        try {
            long longValue = Long.valueOf(str).longValue();
            if (!z16) {
                if (!isMenuSettingOutDate("" + longValue, context)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(IPublicAccountManager.TAG, 2, "menu setting not outdate yet--");
                    }
                    return null;
                }
            }
            if (this.menuSettingSeqnoMap.containsKey("" + longValue)) {
                i3 = this.menuSettingSeqnoMap.get("" + longValue).intValue();
            } else {
                i3 = 0;
            }
            mobileqq_mp$GetPublicAccountMenuRequest mobileqq_mp_getpublicaccountmenurequest = new mobileqq_mp$GetPublicAccountMenuRequest();
            mobileqq_mp_getpublicaccountmenurequest.seqno.set(i3);
            mobileqq_mp_getpublicaccountmenurequest.uin.set((int) longValue);
            final NewIntent newIntent = new NewIntent(context, PublicAccountStQWebServletImpl.class);
            newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_ACCOUNT_MENU_NEW);
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(-1L);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(mobileqq_mp_getpublicaccountmenurequest.toByteArray()));
            String traceId = ze0.a.getTraceId();
            if (!TextUtils.isEmpty(traceId)) {
                stQWebReq.traceid.set(traceId);
            }
            byte[] byteArray = stQWebReq.toByteArray();
            if (byteArray == null) {
                byteArray = new byte[4];
            }
            newIntent.putExtra("traceid", traceId);
            newIntent.putExtra("data", byteArray);
            newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.2
                /* JADX WARN: Removed duplicated region for block: B:45:0x016f A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:46:0x0170  */
                /* JADX WARN: Removed duplicated region for block: B:48:0x0176 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0177  */
                @Override // mqq.observer.BusinessObserver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onReceive(final int i16, final boolean z17, final Bundle bundle) {
                    final mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse;
                    mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse2;
                    long j3;
                    int i17;
                    List<mobileqq_mp$ButtonInfo> localPublicAccountMenuSetting;
                    List<mobileqq_mp$ButtonInfo> list;
                    mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse3 = null;
                    newIntent.setObserver(null);
                    if (QLog.isColorLevel()) {
                        QLog.i(IPublicAccountManager.TAG, 2, "success:" + String.valueOf(z17));
                    }
                    if (!z17) {
                        return;
                    }
                    try {
                        byte[] byteArray2 = bundle.getByteArray("data");
                        mobileqq_mp_getpublicaccountmenuresponse2 = new mobileqq_mp$GetPublicAccountMenuResponse();
                        try {
                            mobileqq_mp_getpublicaccountmenuresponse2.mergeFrom(byteArray2);
                            j3 = mobileqq_mp_getpublicaccountmenuresponse2.uin.has() ? mobileqq_mp_getpublicaccountmenuresponse2.uin.get() & 4294967295L : 0L;
                            i17 = mobileqq_mp_getpublicaccountmenuresponse2.seqno.has() ? mobileqq_mp_getpublicaccountmenuresponse2.seqno.get() : 0;
                            if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).isWeatherPA(String.valueOf(j3)) && ((list = mobileqq_mp_getpublicaccountmenuresponse2.button_info.get()) == null || list.size() == 0)) {
                                if (list == null) {
                                    list = new ArrayList<>();
                                }
                                mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo = new mobileqq_mp$ButtonInfo();
                                mobileqq_mp_buttoninfo.f247282id.set(1);
                                mobileqq_mp_buttoninfo.name.set(HardCodeUtil.qqStr(R.string.pml));
                                mobileqq_mp_buttoninfo.event_id.set(1000001);
                                mobileqq_mp_buttoninfo.type.set(3);
                                mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo2 = new mobileqq_mp$ButtonInfo();
                                mobileqq_mp_buttoninfo2.f247282id.set(2);
                                mobileqq_mp_buttoninfo2.name.set(HardCodeUtil.qqStr(R.string.plx));
                                mobileqq_mp_buttoninfo2.event_id.set(1000002);
                                mobileqq_mp_buttoninfo2.type.set(3);
                                list.add(mobileqq_mp_buttoninfo);
                                list.add(mobileqq_mp_buttoninfo2);
                                mobileqq_mp_getpublicaccountmenuresponse2.button_info.set(list);
                            }
                            localPublicAccountMenuSetting = PublicAccountManagerImpl.this.getLocalPublicAccountMenuSetting(appInterface, str);
                            int i18 = mobileqq_mp_getpublicaccountmenuresponse2.update_internal.has() ? mobileqq_mp_getpublicaccountmenuresponse2.update_internal.get() : -1;
                            if (QLog.isColorLevel()) {
                                QLog.d("PublicAccountManager-Menu", 2, "update_internal(s):" + i18);
                            }
                            if (i18 > 0) {
                                SharedPreferences.Editor edit = context.getSharedPreferences(IPublicAccountManager.MENU_EVENT_SHAREPRE, 0).edit();
                                edit.putLong(IPublicAccountManager.MENU_CACHE_TIME, i18 * 1000);
                                edit.commit();
                            }
                        } catch (Exception unused) {
                            mobileqq_mp_getpublicaccountmenuresponse3 = mobileqq_mp_getpublicaccountmenuresponse2;
                            mobileqq_mp_getpublicaccountmenuresponse = mobileqq_mp_getpublicaccountmenuresponse3;
                            if (mobileqq_mp_getpublicaccountmenuresponse != null) {
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    if (localPublicAccountMenuSetting != null && !localPublicAccountMenuSetting.isEmpty()) {
                        bundle.putInt("update_type", mobileqq_mp_getpublicaccountmenuresponse2.update_type.has() ? mobileqq_mp_getpublicaccountmenuresponse2.update_type.get() : 2);
                        if (i17 != PublicAccountManagerImpl.this.getMenusettingLocalSeqno("" + j3)) {
                            return;
                        }
                        mobileqq_mp_getpublicaccountmenuresponse = mobileqq_mp_getpublicaccountmenuresponse2;
                        if (mobileqq_mp_getpublicaccountmenuresponse != null) {
                            return;
                        }
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                PublicAccountManagerImpl.this.savePublicAccountMenuSetting(appInterface, str, mobileqq_mp_getpublicaccountmenuresponse);
                                BusinessObserver businessObserver2 = businessObserver;
                                if (businessObserver2 != null) {
                                    businessObserver2.onReceive(i16, z17, bundle);
                                }
                            }
                        });
                        return;
                    }
                    bundle.putInt("update_type", 1);
                    if (i17 != PublicAccountManagerImpl.this.getMenusettingLocalSeqno("" + j3)) {
                    }
                }
            });
            if (appInterface != null) {
                appInterface.startServlet(newIntent);
            }
            return newIntent;
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountManager.TAG, 2, "puin is invalid format:" + str);
            }
            return null;
        }
    }

    public int getMenusettingLocalSeqno(String str) {
        if (this.menuSettingSeqnoMap.containsKey(str)) {
            return this.menuSettingSeqnoMap.get(str).intValue();
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public long getMsgID(AppInterface appInterface, String str) {
        return appInterface.getApp().getSharedPreferences("history_msg_params_" + appInterface.getAccount(), 0).getLong(str + "_msgid", 0L);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public int getPublicAccountAioClass(String str, AppInterface appInterface) {
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(str + "");
        return (publicAccountInfo == null || publicAccountInfo.extendType != 2) ? 2 : 1;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public List<mobileqq_mp$ButtonInfo> getPublicAccountMenuButtonList(AppInterface appInterface, String str) {
        return getLocalPublicAccountMenuSetting(appInterface, str);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public int getPublicAccountMenuType(String str) {
        if (this.mPublicAccountMenuType.containsKey(str)) {
            return this.mPublicAccountMenuType.get(str).intValue();
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void handleButtonEvent(String str, Context context, AppInterface appInterface, String str2, int i3, BusinessObserver businessObserver, MqqHandler mqqHandler, int i16, Object obj) {
        SessionInfo sessionInfo = (SessionInfo) obj;
        mobileqq_mp$ButtonInfo buttonInfoByMenuId = getButtonInfoByMenuId(appInterface, str2, i3);
        if (buttonInfoByMenuId == null) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountManager.TAG, 2, "Can't find menu via menu id:" + i3 + ".");
                return;
            }
            return;
        }
        if (sessionInfo.f179555d == 1008 && ((i16 == 1 && !buttonInfoByMenuId.sub_button.has()) || i16 == 2)) {
            addPublicAccountToRu(appInterface, str2);
        }
        int i17 = buttonInfoByMenuId.type.has() ? buttonInfoByMenuId.type.get() : 0;
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str2, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(i16), String.valueOf(i3), buttonInfoByMenuId.name.has() ? buttonInfoByMenuId.name.get() : "", String.valueOf(i17), false);
        ((IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class)).reportPubAioMenuAction(str2, i3, i16, buttonInfoByMenuId);
        StringBuilder sb5 = new StringBuilder();
        String e16 = (i17 == 2 && buttonInfoByMenuId.url.has()) ? AbsStructMsgElement.e(buttonInfoByMenuId.url.get()) : "";
        sb5.append("MENUID=");
        sb5.append(String.valueOf(i3));
        sb5.append(";LEVELID=");
        sb5.append(String.valueOf(i16));
        sb5.append(";NAME=");
        sb5.append(buttonInfoByMenuId.name.has() ? buttonInfoByMenuId.name.get() : "");
        sb5.append(";REFERRER=");
        sb5.append(e16);
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str2, "0X8005D4B", "0X8005D4B", 0, 0, sb5.toString(), "", "", "", false);
        this.mPublicAccountMenuEventObserver = new WeakReference<>(businessObserver);
        this.mApp = new WeakReference<>(appInterface);
        this.mTempContext = new WeakReference<>(context);
        this.mTempUin = str2;
        this.mTempKey = buttonInfoByMenuId.key.has() ? buttonInfoByMenuId.key.get() : "";
        this.mIsNewMenu = buttonInfoByMenuId.is_new_menu.has() ? buttonInfoByMenuId.is_new_menu.get() : false;
        if (i17 == 1) {
            if (mqqHandler != null) {
                mqqHandler.sendEmptyMessage(1001);
            }
            if (buttonInfoByMenuId.is_need_lbs.has() && buttonInfoByMenuId.is_need_lbs.get()) {
                new BaseThread(this.getLocationThread).start();
                return;
            }
            if (mqqHandler != null) {
                mqqHandler.sendEmptyMessage(19);
            }
            reportClickTypeMenuEvent(false, 0.0d, 0.0d, null, buttonInfoByMenuId.media_id.has() ? buttonInfoByMenuId.media_id.get() : null, this.mTempKey, this.mIsNewMenu);
            return;
        }
        if (i17 != 2) {
            if (i17 != 3) {
                return;
            }
            int i18 = buttonInfoByMenuId.event_id.has() ? buttonInfoByMenuId.event_id.get() : 0;
            if (i18 != 1) {
                switch (i18) {
                    case 11:
                        openScanner(context, mqqHandler, false);
                        return;
                    case 12:
                        openScanner(context, mqqHandler, true);
                        return;
                    case 13:
                        openCamera(context, appInterface, sessionInfo);
                        return;
                    case 14:
                        openAlbum(context, appInterface, sessionInfo);
                        return;
                    case 15:
                        openLocation(context, appInterface, sessionInfo);
                        return;
                    default:
                        switch (i18) {
                            case 1000001:
                                openNewCityWeather(appInterface, mqqHandler);
                                return;
                            case 1000002:
                                openOtherCity(context, appInterface);
                                return;
                            default:
                                return;
                        }
                }
            }
            openInfoCard(appInterface, context, str2);
            reportEventTypeMenuEvent(null, 0, 1, -1, null);
            return;
        }
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(1001);
        }
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(1001);
        }
        String str3 = buttonInfoByMenuId.actionInfo.a_actionData.get();
        String str4 = buttonInfoByMenuId.actionInfo.actionData.get();
        if (TextUtils.isEmpty(str3)) {
            str3 = str4;
        }
        String str5 = buttonInfoByMenuId.url.has() ? buttonInfoByMenuId.url.get() : "";
        String str6 = buttonInfoByMenuId.media_id.has() ? buttonInfoByMenuId.media_id.get() : null;
        if (TextUtils.isEmpty(str3)) {
            oldUrEventHandle(appInterface, context, str2, buttonInfoByMenuId);
            return;
        }
        ax c16 = bi.c((QQAppInterface) appInterface, context, str3);
        if (c16 == null) {
            if (buttonInfoByMenuId.actionInfo.appid.has()) {
                tryHandleOpenApp(appInterface, context, str2, buttonInfoByMenuId, str3);
                return;
            } else {
                oldUrEventHandle(appInterface, context, str2, buttonInfoByMenuId);
                reportUrlTypeMenuEvent(str5, buttonInfoByMenuId.actionInfo.get(), str6);
                return;
            }
        }
        if (TextUtils.isEmpty(c16.h())) {
            tryHandleOpenApp(appInterface, context, str2, buttonInfoByMenuId, str3);
        } else {
            if (c16.b()) {
                return;
            }
            oldUrEventHandle(appInterface, context, str2, buttonInfoByMenuId);
            reportUrlTypeMenuEvent(str5, buttonInfoByMenuId.actionInfo.get(), str6);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public boolean preloadWebProcess(AppInterface appInterface) {
        if (NetConnInfoCenter.getServerTimeMillis() < this.lastPreloadWebProcessorTime + 35000) {
            return false;
        }
        this.lastPreloadWebProcessorTime = NetConnInfoCenter.getServerTimeMillis();
        if (ah.k0() || FileUtils.getAvailableInnernalMemorySize() <= 1.048576E8f) {
            return false;
        }
        IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) appInterface.getRuntimeService(IWebProcessManagerService.class, "");
        if (iWebProcessManagerService != null) {
            iWebProcessManagerService.startWebProcess(22, null);
        }
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d(IPublicAccountManager.TAG, 2, "startWebProcess  startWebProcess by userlist ad");
        return true;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public NewIntent refuseFollowAccount(String str, int i3, boolean z16, Context context, AppInterface appInterface, IPublicAccountManager.b bVar) {
        NewIntent newIntent = new NewIntent(context, PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SEND_REFUSE_CMD);
        mobileqq_mp$SetRefuseFollowRequest mobileqq_mp_setrefusefollowrequest = new mobileqq_mp$SetRefuseFollowRequest();
        mobileqq_mp_setrefusefollowrequest.luin.set(Long.parseLong(str));
        mobileqq_mp_setrefusefollowrequest.account_type.set(1);
        mobileqq_mp_setrefusefollowrequest.refuse_forever.set(z16);
        if (!z16) {
            mobileqq_mp_setrefusefollowrequest.refuse_period.set(i3);
        }
        newIntent.putExtra("data", mobileqq_mp_setrefusefollowrequest.toByteArray());
        newIntent.setObserver(new h(newIntent, bVar));
        if (appInterface != null) {
            appInterface.startServlet(newIntent);
        }
        return newIntent;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void removeMsgID(AppInterface appInterface, String str) {
        appInterface.getApp().getSharedPreferences("history_msg_params_" + appInterface.getAccount(), 0).edit().remove(str + "_msgid").commit();
    }

    public void reportEventTypeMenuEvent(String str, int i3, int i16, int i17, List<String> list) {
        mobileqq_mp$SendMenuEventRequest initSendMenuEventRequest = initSendMenuEventRequest(3, this.mTempKey, this.mIsNewMenu);
        if (initSendMenuEventRequest != null) {
            initSendMenuEventRequest.event_id.set(i16);
            if (str != null) {
                initSendMenuEventRequest.scan_result.set(str);
                initSendMenuEventRequest.scanType.set(i3);
            }
            if (i17 >= 0) {
                initSendMenuEventRequest.pictureCount.set(i17);
            }
            if (list != null) {
                initSendMenuEventRequest.picture_Md5s.set(list);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountManager-Event:", 2, "event_id:" + initSendMenuEventRequest.event_id.get() + " scan_result:" + initSendMenuEventRequest.scan_result.get() + " pictureCount:" + initSendMenuEventRequest.pictureCount.get());
            }
            sendReportRequest(initSendMenuEventRequest);
        }
    }

    public void reportUrlTypeMenuEvent(String str, mobileqq_mp$ActionInfo mobileqq_mp_actioninfo, String str2) {
        mobileqq_mp$SendMenuEventRequest initSendMenuEventRequest = initSendMenuEventRequest(2, this.mTempKey, this.mIsNewMenu);
        if (initSendMenuEventRequest != null) {
            initSendMenuEventRequest.url.set(str);
            initSendMenuEventRequest.actionInfo.set(mobileqq_mp_actioninfo);
            if (str2 != null) {
                initSendMenuEventRequest.media_id.set(str2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountManager-Url:", 2, "url:" + initSendMenuEventRequest.url.get() + " actionInfo:" + initSendMenuEventRequest.actionInfo.get() + " media_id:" + initSendMenuEventRequest.media_id.get());
            }
            sendReportRequest(initSendMenuEventRequest);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void requestQidiKefu(Activity activity, String str, String str2, String str3, String str4, BusinessObserver businessObserver) {
        boolean z16;
        String str5 = "QD";
        BaseActivity baseActivity = (BaseActivity) activity;
        this.mTempUin = str;
        this.mTempContext = new WeakReference<>(baseActivity);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app", "QD");
            if (str2 != null) {
                jSONObject.put("assignType", Long.parseLong(str2));
            }
            if (str3 != null) {
                jSONObject.put("assignKey", Long.parseLong(str3));
            }
            if (str4 != null) {
                jSONObject.put("ext", str4);
            }
            z16 = false;
        } catch (Exception unused) {
            z16 = true;
        }
        if (!z16) {
            str5 = jSONObject.toString();
        }
        mobileqq_mp$SendMenuEventRequest initSendMenuEventRequest = initSendMenuEventRequest(1, str5, false);
        if (initSendMenuEventRequest == null) {
            return;
        }
        initSendMenuEventRequest.menu_type.set(1001);
        this.mApp.get();
        NewIntent newIntent = new NewIntent(baseActivity, PublicAccountStQWebServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SEND_MENU_EVENT_NEW);
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(-1L);
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(initSendMenuEventRequest.toByteArray()));
        String traceId = ze0.a.getTraceId();
        if (!TextUtils.isEmpty(traceId)) {
            stQWebReq.traceid.set(traceId);
        }
        byte[] byteArray = stQWebReq.toByteArray();
        if (byteArray == null) {
            byteArray = new byte[4];
        }
        newIntent.putExtra("traceid", traceId);
        newIntent.putExtra("data", byteArray);
        newIntent.setObserver(businessObserver);
        QQAppInterface qQAppInterface = baseActivity.app;
        if (qQAppInterface != null) {
            qQAppInterface.startServlet(newIntent);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void sendMenuEventequest(Context context, AppInterface appInterface, String str, String str2, boolean z16, double d16, double d17, BusinessObserver businessObserver) {
        sendMenuEventequest(context, appInterface, str, str2, z16, d16, d17, businessObserver, 1, 0L, 0);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void setHasPreloadWebProcessor(boolean z16) {
        this.hasPreloadWebProcessor = z16;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void setKeepOldPublicAccountData(boolean z16) {
        this.mKeepOldPublicAccountData = z16;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void setMsgID(AppInterface appInterface, String str, long j3) {
        appInterface.getApp().getSharedPreferences("history_msg_params_" + appInterface.getAccount(), 0).edit().putLong(str + "_msgid", j3).commit();
    }

    public void updateMenuSettingLocalSeqno(String str, int i3) {
        this.menuSettingSeqnoMap.put(str, Integer.valueOf(i3));
    }

    private void openCamera(Context context, AppInterface appInterface, SessionInfo sessionInfo) {
        if (AudioUtil.h(0)) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f6e), context.getString(R.string.f6f), new k(), null).show();
            return;
        }
        if (QQAudioHelper.g(0)) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f6e), context.getString(R.string.f6g), new l(), null).show();
            return;
        }
        BaseActivity baseActivity = (BaseActivity) context;
        PlusPanelUtils.b(appInterface, baseActivity, 1, 0);
        baseActivity.setCanLock(false);
        BroadcastReceiver broadcastReceiver = this.picResultReceiver;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.picResultReceiver = null;
        }
        this.picResultReceiver = new a();
        context.registerReceiver(this.picResultReceiver, new IntentFilter(IPublicAccountManager.PA_ACTION_PIC_RESULT), "com.tencent.msg.permission.pushnotify", null);
        this.mPicSource = 1;
    }

    public void reportClickTypeMenuEvent(boolean z16, double d16, double d17, String str, String str2, String str3, boolean z17) {
        mobileqq_mp$SendMenuEventRequest initSendMenuEventRequest = initSendMenuEventRequest(1, str3, z17);
        if (initSendMenuEventRequest != null) {
            if (z16) {
                initSendMenuEventRequest.is_need_lbs.set(true);
                initSendMenuEventRequest.latitude.set(d16);
                initSendMenuEventRequest.longitude.set(d17);
            }
            if (str != null) {
                initSendMenuEventRequest.lbsAddressLabel.set(str);
            }
            if (str2 != null) {
                initSendMenuEventRequest.media_id.set(str2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountManager-Click:", 2, "is_need_lbs:" + initSendMenuEventRequest.is_need_lbs.get() + " latitude:" + initSendMenuEventRequest.latitude.get() + " longitude:" + initSendMenuEventRequest.longitude.get() + " lbsAddressLabel:" + initSendMenuEventRequest.lbsAddressLabel.get() + " media_id:" + initSendMenuEventRequest.media_id.get());
            }
            sendReportRequest(initSendMenuEventRequest);
        }
    }

    public void reportEventTypeMenuEventLocation(double d16, double d17, String str, String str2, boolean z16) {
        mobileqq_mp$SendMenuEventRequest initSendMenuEventRequest = initSendMenuEventRequest(3, str2, z16);
        if (initSendMenuEventRequest != null) {
            initSendMenuEventRequest.is_need_lbs.set(true);
            initSendMenuEventRequest.latitude.set(d16);
            initSendMenuEventRequest.longitude.set(d17);
            initSendMenuEventRequest.event_id.set(15);
            if (str != null) {
                initSendMenuEventRequest.lbsAddressLabel.set(str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountManager-Location:", 2, "event_id:" + initSendMenuEventRequest.event_id.get() + " is_need_lbs:" + initSendMenuEventRequest.is_need_lbs.get() + " latitude:" + initSendMenuEventRequest.latitude.get() + " longitude:" + initSendMenuEventRequest.longitude.get() + " lbsAddressLabel:" + initSendMenuEventRequest.lbsAddressLabel.get());
            }
            sendReportRequest(initSendMenuEventRequest);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void sendMenuEventequest(Context context, AppInterface appInterface, String str, String str2, boolean z16, double d16, double d17, BusinessObserver businessObserver, int i3, long j3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("reportsendMenuEventequest", 2, "key:" + str2 + "uin:" + str + "type:" + i3 + "msg_id:" + j3 + "s_type" + i16);
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            mobileqq_mp$SendMenuEventRequest mobileqq_mp_sendmenueventrequest = new mobileqq_mp$SendMenuEventRequest();
            mobileqq_mp_sendmenueventrequest.key.set(str2);
            mobileqq_mp_sendmenueventrequest.uin.set((int) longValue);
            mobileqq_mp_sendmenueventrequest.type.set(i3);
            mobileqq_mp_sendmenueventrequest.msg_id.set(j3);
            mobileqq_mp_sendmenueventrequest.s_type.set(i16);
            mobileqq_mp_sendmenueventrequest.menu_type.set(getPublicAccountMenuType(str));
            if (z16) {
                mobileqq_mp_sendmenueventrequest.is_need_lbs.set(true);
                mobileqq_mp_sendmenueventrequest.latitude.set(d16);
                mobileqq_mp_sendmenueventrequest.longitude.set(d17);
            }
            NewIntent newIntent = new NewIntent(context, PublicAccountStQWebServletImpl.class);
            newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SEND_MENU_EVENT_NEW);
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(-1L);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(mobileqq_mp_sendmenueventrequest.toByteArray()));
            String traceId = ze0.a.getTraceId();
            if (!TextUtils.isEmpty(traceId)) {
                stQWebReq.traceid.set(traceId);
            }
            byte[] byteArray = stQWebReq.toByteArray();
            if (byteArray == null) {
                byteArray = new byte[4];
            }
            newIntent.putExtra("traceid", traceId);
            newIntent.putExtra("data", byteArray);
            newIntent.setObserver(new g(newIntent, context, str, businessObserver, appInterface));
            if (appInterface != null) {
                appInterface.startServlet(newIntent);
            }
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e(IPublicAccountManager.TAG, 2, "puin is invalid format:" + str);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void init(Context context, AppInterface appInterface, String str, String str2, IPublicAccountManager.a aVar) {
        if (str != null && !str.equals(this.mCurrentUin)) {
            clearOldPublicAccountData(str);
        }
        this.mCurrentUin = str;
        ThreadManagerV2.executeOnSubThread(new Runnable(str2, appInterface, aVar, context) { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.1

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f79468d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AppInterface f79469e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f79470f;

            /* renamed from: com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl$1$a */
            /* loaded from: classes32.dex */
            class a implements BusinessObserver {
                a() {
                }

                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z16, Bundle bundle) {
                    getClass();
                    throw null;
                }
            }

            {
                this.f79470f = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse;
                if (!PublicAccountManagerImpl.this.mPublicAccountMenuButtonLists.containsKey(this.f79468d)) {
                    PublicAccountMenuEntity publicAccountMenuEntity = (PublicAccountMenuEntity) DBMethodProxy.find(this.f79469e.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) PublicAccountMenuEntity.class, this.f79468d);
                    if (publicAccountMenuEntity != null) {
                        try {
                            mobileqq_mp_getpublicaccountmenuresponse = new mobileqq_mp$GetPublicAccountMenuResponse();
                            try {
                                mobileqq_mp_getpublicaccountmenuresponse.mergeFrom(publicAccountMenuEntity.data);
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            mobileqq_mp_getpublicaccountmenuresponse = null;
                        }
                        if (mobileqq_mp_getpublicaccountmenuresponse != null) {
                            if (mobileqq_mp_getpublicaccountmenuresponse.button_info.has()) {
                                List<mobileqq_mp$ButtonInfo> list = mobileqq_mp_getpublicaccountmenuresponse.button_info.get();
                                if (QLog.isColorLevel()) {
                                    QLog.i(IPublicAccountManager.TAG, 2, "Got cached buttonInfos " + list.size());
                                }
                                long j3 = publicAccountMenuEntity.savedDateTime;
                                int i3 = publicAccountMenuEntity.seqno;
                                PublicAccountManagerImpl.this.menuSettingLastSaveDateTimeMap.put(this.f79468d, Long.valueOf(j3));
                                PublicAccountManagerImpl.this.updateMenuSettingLocalSeqno(this.f79468d, i3);
                                PublicAccountManagerImpl.this.mPublicAccountMenuButtonLists.put(this.f79468d, list);
                                PublicAccountManagerImpl.this.mPublicAccountMenuType.put(this.f79468d, Integer.valueOf(mobileqq_mp_getpublicaccountmenuresponse.menu_type.has() ? mobileqq_mp_getpublicaccountmenuresponse.menu_type.get() : 0));
                                throw null;
                            }
                            throw null;
                        }
                        throw null;
                    }
                    PublicAccountManagerImpl.this.getMenuSetting(this.f79470f, this.f79469e, this.f79468d, new a(), false);
                    return;
                }
                throw null;
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void addPublicAccountToRu(AppInterface appInterface, String str) {
        if (appInterface != null && isFuWuHaoType(appInterface, str)) {
            long serverTime = NetConnInfoCenter.getServerTime();
            RecentUserProxy m3 = ((QQAppInterface) appInterface).getProxyManager().m();
            RecentUser findRecentUserByUin = m3.findRecentUserByUin(str, 1008);
            if (findRecentUserByUin.lastmsgtime < serverTime) {
                findRecentUserByUin.lastmsgtime = serverTime;
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountManager.TAG, 2, "addPublicAccountToRu->pUin:" + str + ", currentTime:" + serverTime);
                }
            }
            m3.saveRecentUser(findRecentUserByUin);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void refuseFollowAccountCancelCallback(NewIntent newIntent) {
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public NewIntent sendMsgArriveReceipt(Context context, AppInterface appInterface, long j3, long j16, long j17, long j18, int i3, List<Long> list) {
        if (QLog.isColorLevel()) {
            QLog.i(IPublicAccountManager.TAG, 2, String.format("sendMsgArriveReceipt request: msgId:%d msgOp:%d pcuin:%d cuin:%d type:%d", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Integer.valueOf(i3)));
        }
        NewIntent newIntent = new NewIntent(context, PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SEND_MSG_RECEIPT);
        mobileqq_mp$SendPublicAccountMessageReceiptRequest mobileqq_mp_sendpublicaccountmessagereceiptrequest = new mobileqq_mp$SendPublicAccountMessageReceiptRequest();
        if (i3 == 1) {
            mobileqq_mp_sendpublicaccountmessagereceiptrequest.uint64_unique_id.set(j3);
            mobileqq_mp_sendpublicaccountmessagereceiptrequest.uint32_op.set(j16);
        } else if (i3 == 2) {
            mobileqq_mp_sendpublicaccountmessagereceiptrequest.unique_ids.set(list);
        }
        mobileqq_mp_sendpublicaccountmessagereceiptrequest.receipt_type.set(i3);
        mobileqq_mp_sendpublicaccountmessagereceiptrequest.pcuin.set(j17);
        mobileqq_mp_sendpublicaccountmessagereceiptrequest.cuin.set(j18);
        newIntent.putExtra("data", mobileqq_mp_sendpublicaccountmessagereceiptrequest.toByteArray());
        newIntent.setObserver(new i(newIntent));
        if (appInterface != null) {
            appInterface.startServlet(newIntent);
        }
        return newIntent;
    }

    private void openNewCityWeather(AppInterface appInterface, MqqHandler mqqHandler) {
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(19);
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(appInterface.getCurrentAccountUin(), 0);
        float f16 = sharedPreferences.getFloat(com.tencent.biz.lebasearch.b.f78642c, 0.0f);
        ((PublicAccountHandlerImpl) appInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).sendLocRequest(0, (int) (sharedPreferences.getFloat(com.tencent.biz.lebasearch.b.f78641b, 0.0f) * 1000000.0f), (int) (f16 * 1000000.0f), 0);
        ((IWeatherReportApi) QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface) appInterface, "aio_news_click");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f79487d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79488e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Uri f79489f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SessionInfo f79490h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ActionSheet f79491i;

        b(AppInterface appInterface, Context context, Uri uri, SessionInfo sessionInfo, ActionSheet actionSheet) {
            this.f79487d = appInterface;
            this.f79488e = context;
            this.f79489f = uri;
            this.f79490h = sessionInfo;
            this.f79491i = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    this.f79491i.dismiss();
                    return;
                } else {
                    PlusPanelUtils.a((QQAppInterface) this.f79487d, (Activity) this.f79488e, this.f79490h, null, null);
                    this.f79491i.dismiss();
                    return;
                }
            }
            PlusPanelUtils.w((QQAppInterface) this.f79487d, (BaseActivity) this.f79488e, this.f79489f, this.f79490h);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
            if (edit != null) {
                edit.putString(AppConstants.Preferences.LAST_SCREEN_SHOT_URI, null).apply();
            }
            this.f79491i.dismiss();
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void savePublicAccountMenuSetting(AppInterface appInterface, String str, mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse) {
        String str2;
        if (QLog.isDevelopLevel()) {
            QLog.d(IPublicAccountManager.TAG, 4, "savePublicAccountMenuSetting");
        }
        if (mobileqq_mp_getpublicaccountmenuresponse == null || appInterface == null) {
            return;
        }
        updateMenuSettingLocalSeqno(str, mobileqq_mp_getpublicaccountmenuresponse.seqno.has() ? mobileqq_mp_getpublicaccountmenuresponse.seqno.get() : 0);
        long currentTimeMillis = System.currentTimeMillis();
        updateMenuSettingLocalDateTime(str, currentTimeMillis);
        if (mobileqq_mp_getpublicaccountmenuresponse.toByteArray() == null) {
            return;
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        PublicAccountMenuEntity publicAccountMenuEntity = new PublicAccountMenuEntity(str, mobileqq_mp_getpublicaccountmenuresponse, currentTimeMillis);
        if (DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PublicAccountMenuEntity.class, str) != null) {
            PublicAccountMenuEntity publicAccountMenuEntity2 = (PublicAccountMenuEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PublicAccountMenuEntity.class, str);
            if (publicAccountMenuEntity2 != null) {
                publicAccountMenuEntity2.clone(publicAccountMenuEntity);
                createEntityManager.update(publicAccountMenuEntity2);
            } else {
                createEntityManager.persist(publicAccountMenuEntity);
            }
        } else {
            createEntityManager.persist(publicAccountMenuEntity);
        }
        createEntityManager.close();
        List<mobileqq_mp$ButtonInfo> list = mobileqq_mp_getpublicaccountmenuresponse.button_info.get();
        this.menuSettingLastSaveDateTimeMap.put(str, Long.valueOf(publicAccountMenuEntity.savedDateTime));
        this.mPublicAccountMenuButtonLists.put(str, list);
        int i3 = mobileqq_mp_getpublicaccountmenuresponse.menu_type.has() ? mobileqq_mp_getpublicaccountmenuresponse.menu_type.get() : 0;
        this.mPublicAccountMenuType.put(str, Integer.valueOf(i3));
        if (i3 != 0) {
            if (i3 == 1) {
                str2 = "icon";
            } else {
                str2 = "text";
            }
            ReportController.r(appInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005EC2", "0X8005EC2", 0, 0, str, str2, "", "");
            if (list.size() <= 0 || list.get(0) == null || !list.get(0).sub_button.has() || list.get(0).sub_button.get() == null) {
                return;
            }
            ReportController.r(appInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005EC3", "0X8005EC3", 0, 0, str, String.valueOf(list.get(0).sub_button.get().size()), "", "");
        }
    }

    public static void sendPayInfoRequest(Context context, AppInterface appInterface, String str) {
        if (appInterface == null || context == null || str == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(context, PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SEND_PAY_INFO);
        mobileqq_mp$SendOrderPayEventRequest mobileqq_mp_sendorderpayeventrequest = new mobileqq_mp$SendOrderPayEventRequest();
        mobileqq_mp_sendorderpayeventrequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_sendorderpayeventrequest.cmd.set(1);
        mobileqq_mp_sendorderpayeventrequest.body.set(str);
        newIntent.putExtra("data", mobileqq_mp_sendorderpayeventrequest.toByteArray());
        newIntent.setObserver(new f(newIntent));
        appInterface.startServlet(newIntent);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountManager
    public void handleUrlEvent(Context context, AppInterface appInterface, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) PublicAccountBrowserImpl.class);
        intent.putExtra("from", QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("click_from", str3);
        intent.putExtra("uin", appInterface.getCurrentAccountUin());
        intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, str2);
        intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, context.getResources().getString(R.string.button_back));
        intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(str2));
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class l implements DialogInterface.OnClickListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
