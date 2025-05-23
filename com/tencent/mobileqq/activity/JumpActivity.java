package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.haoliyou.sso.OnCheckShareListener;
import com.tencent.mobileqq.haoliyou.util.JumpActionViewUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.JumpReportCtr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashMap;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u4e92\u8054\u5bf9\u5916\u66b4\u9732\u7684activity", path = RouterConstants.UI_ROUTER_JUMP)
/* loaded from: classes9.dex */
public class JumpActivity extends QBaseActivity implements DialogInterface.OnDismissListener, OnCheckShareListener, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String BROADCAST_RECEIVER_FINISH_ACTION = "BroadcastReceiverFinishActivity";
    public static final String BROCAST_RECEIVER_ACTION = "ShareToQZoneAndFinishTheLastActivity";
    private static final String KEY_FINISH_JUMP_ACTIVITY = "finish_jump_activity";
    public static final int LBS_REQUEST = 18;
    public static final int MINIAPP_LOGIN_REQUEST = 24;
    public static final int MSG_AFTER_SECURITY_CHECK = 2;
    public static final int MSG_DISMISS_DIALOG = 1;
    public static final int REQUEST_MULTI_VOICE_CALL = 1;
    public static final int REQUEST_SINGLE_VOICE_CALL = 2;
    public static final String SCHEME_MQQ = "mqq";
    public static final int SHARE_LOGIN_REQUEST = 19;
    public static final int SHARE_PICTURE_TO_QZONE_REQUEST = 23;
    private static final String TAG = "JumpAction";
    public static final int THIRD_PARTY_GESTURE_PWD_REQUEST = 27;
    public static final int THIRD_PARTY_LOGIN_REQUEST = 26;
    public static final int TYPE_SHARED = 0;
    private static final int TYPE_VIEW = 1;
    public static final int VIEW_LOGIN_REQUEST = 20;
    public static final int WEB_SECURITY_VERIFY = 25;
    public static final int WPA_GESTURE_PWD_REQUEST = 22;
    public static final int WPA_LOGIN_REQUEST = 21;
    public static boolean sIsStartFromThirdParty;
    public static boolean sIsStartFromWpa;
    public static int sJASwitches;
    public static HashMap<String, Integer> sLegalPrefix;
    public static String[] sLegalPrefixes;
    public static volatile boolean sSwitchInited;
    public String callbackName;
    public String callbackType;
    public boolean doCallBack;
    public Intent gotoQQComic;
    public Intent gotoQReader;
    public boolean isActionPhoto;
    public boolean isActionSelectLocation;
    public MqqHandler mBgHandler;
    public HandlerThread mBgThread;
    private BroadcastReceiver mJumpFinishBroadcastReceiver;
    private JumpReportCtr mJumpReportCtr;
    public String mPackageName;
    public boolean needFinishOnPause;
    private BroadcastReceiver qqBroadcastReceiver;
    private ViewGroup rootView;
    public String srcType;
    public final MqqHandler uiHandler;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (!JumpActivity.this.isFinishing()) {
                JumpActivity.this.finish();
                QLog.i(JumpActivity.TAG, 1, "JumpActivity has finished by broadcastReceiver.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (!JumpActivity.this.isFinishing()) {
                QLog.i(JumpActivity.TAG, 1, "JumpActivity has finished by broadcastReceiver.");
                JumpActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c extends AsyncTask<Object, Void, Uri> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Intent f176348a;

        public c(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpActivity.this, (Object) intent);
            } else {
                this.f176348a = intent;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Uri doInBackground(Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Uri) iPatchRedirector.redirect((short) 2, (Object) this, (Object) objArr);
            }
            return JumpActivityHelper.b0(objArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uri);
                return;
            }
            this.f176348a.setData(uri);
            ((IQJumpApi) QRoute.api(IQJumpApi.class)).startForwardActivity(JumpActivity.this, this.f176348a);
            JumpActivity.this.finish();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        sIsStartFromWpa = false;
        sIsStartFromThirdParty = false;
        sJASwitches = -1;
        sSwitchInited = false;
        sLegalPrefixes = new String[]{"mqq", SchemaUtils.SCHEMA_MQQAPI, "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", ProcessConstant.QQWIFI, "mqqconnect", "qqstory", "mqqconferenceflyticket", "mqqavshare"};
    }

    public JumpActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isActionPhoto = false;
        this.isActionSelectLocation = false;
        this.needFinishOnPause = false;
        this.mPackageName = "";
        this.gotoQReader = null;
        this.gotoQQComic = null;
        this.uiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.mBgThread = null;
        this.mBgHandler = null;
    }

    private boolean dealActionAndScheme(Intent intent) {
        if (JumpActivityHelper.g(this, intent) && JumpActivityHelper.h(this, intent) && JumpActivityHelper.i(this, intent)) {
            return true;
        }
        return false;
    }

    private void dismissDialog() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public static void doJumpToMiniApp(JumpActivity jumpActivity, boolean z16) {
        JumpActivityHelper.F(jumpActivity, z16);
    }

    public static void doThirdPartyCheckLoginAndGesture(JumpActivity jumpActivity, boolean z16, String str, boolean z17) {
        JumpActivityHelper.O(jumpActivity, z16, str, z17);
    }

    public static void dowpa(JumpActivity jumpActivity, boolean z16, String str, boolean z17) {
        JumpActivityHelper.Q(jumpActivity, z16, str, z17);
    }

    public static String getFragmentName(Context context) {
        return JumpActivityHelper.x(context);
    }

    public static void handleIntentForQQBrowser(Context context, Intent intent) {
        JumpActivityHelper.R(context, intent);
    }

    public static synchronized void initJASwitch(String str, boolean z16) {
        synchronized (JumpActivity.class) {
            JumpActivityHelper.y(str, z16);
        }
    }

    private void initRequestedOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    public static boolean isLegalScheme(String str) {
        return JumpActivityHelper.f(str);
    }

    public static boolean needForceSetComponent(String str) {
        HashMap<String, Integer> hashMap = sLegalPrefix;
        if (hashMap == null) {
            return false;
        }
        if (((1 << hashMap.get(str).intValue()) & sJASwitches) == 0) {
            return false;
        }
        return true;
    }

    public static void onWebSecVerifyResult(JumpActivity jumpActivity, boolean z16, Intent intent) {
        JumpActivityHelper.J(jumpActivity, z16, intent);
    }

    public static void processIntent(Intent intent) {
        JumpActivityHelper.q(intent);
    }

    private static void reportJumpArguments(Intent intent) {
        JumpActivityHelper.I(intent);
    }

    public static void sendFinishBroadcast(Context context) {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_RECEIVER_FINISH_ACTION);
        context.sendBroadcast(intent);
    }

    public static void setShouldFinishJumpActivity(Intent intent) {
        intent.putExtra(KEY_FINISH_JUMP_ACTIVITY, true);
    }

    public static boolean shouldFinishJumpActivity(Intent intent) {
        if (intent.getExtras() == null) {
            return false;
        }
        return intent.getExtras().getBoolean(KEY_FINISH_JUMP_ACTIVITY, false);
    }

    public com.tencent.mobileqq.app.parser.jumpcontroller.a createPlugin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.mobileqq.app.parser.jumpcontroller.a) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        QLog.d(TAG, 1, "createPlugin pluginKey: " + i3);
        try {
            return com.tencent.mobileqq.app.parser.jumpcontroller.d.f196485b.get(String.valueOf(i3)).newInstance();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createPlugin pluginKey: " + i3 + " error: " + e16);
            return null;
        }
    }

    protected boolean dealIntentData(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent)).booleanValue();
        }
        if (dealActionAndScheme(intent) && JumpActivityHelper.l(this, intent)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void doJumpDataLine(Intent intent) {
        String str;
        String str2;
        String string;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        String stringExtra = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        if (AppConstants.DATALINE_PC_UIN.equals(stringExtra)) {
            string = getString(R.string.c5f);
            str3 = PeerUid.DATALINE_PC_UID;
        } else if (AppConstants.DATALINE_PHONE_UIN.equals(stringExtra)) {
            string = getString(R.string.f16273218);
            str3 = PeerUid.DATALINE_PHONE_UID;
        } else if (AppConstants.DATALINE_IPAD_UIN.equals(stringExtra)) {
            string = getString(R.string.f16272217);
            str3 = PeerUid.DATALINE_PAD_UID;
        } else {
            str = "";
            str2 = str;
            ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this, 8, str, str2, 0L, null);
        }
        str2 = string;
        str = str3;
        ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this, 8, str, str2, 0L, null);
    }

    public void doJumpQQComic(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        } else {
            JumpActivityHelper.A(this, intent);
        }
    }

    public void doJumpQfile(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        } else {
            JumpActivityHelper.B(this, intent);
        }
    }

    public void doJumpQlink(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) intent);
        } else {
            JumpActivityHelper.C(this, intent);
        }
    }

    public void doJumpReadInjoy(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) intent);
        } else {
            JumpActivityHelper.D(this, intent);
        }
    }

    @Override // mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("JumpActivity onActivityResult,requestCode=");
        sb5.append(i3);
        sb5.append(",resultCode=");
        sb5.append(i16);
        sb5.append(",data=");
        if (intent != null) {
            str = intent.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        QLog.d(TAG, 1, sb5.toString());
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            try {
                com.tencent.mobileqq.app.parser.jumpcontroller.a createPlugin = createPlugin(i3);
                if (createPlugin == null) {
                    QLog.e(TAG, 1, "doOnActivityResult: result plugin not exist");
                    finish();
                } else {
                    createPlugin.a(i3, i16, intent, this);
                }
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "doOnActivityResult error: " + e16.getMessage());
                return;
            }
        }
        if (i3 == 25) {
            onWebSecVerifyResult(this, false, intent);
        } else if (i3 != 23) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        getWindow().addFlags(67108864);
        initRequestedOrientation();
        try {
            super.doOnCreate(bundle);
            Intent intent = getIntent();
            QLog.d(TAG, 1, "JumpActivity doOnCreate() intent=" + intent);
            if (intent == null) {
                QLog.d(TAG, 1, "onCreate intent is null");
                finish();
                return false;
            }
            reportJumpArguments(intent);
            JumpReportCtr jumpReportCtr = new JumpReportCtr();
            this.mJumpReportCtr = jumpReportCtr;
            jumpReportCtr.b(getAppRuntime(), this, intent);
            return dealIntentData(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "doOnCreate|exp:" + e16.getMessage());
            finish();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.doOnDestroy();
        QLog.i(TAG, 1, "[doOnDestroy] intent=" + getIntent());
        sIsStartFromWpa = false;
        sIsStartFromThirdParty = false;
        BroadcastReceiver broadcastReceiver = this.qqBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.mJumpFinishBroadcastReceiver;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        this.uiHandler.removeMessages(2);
        this.uiHandler.removeMessages(1);
        dismissDialog();
        MqqHandler mqqHandler = this.mBgHandler;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
            this.mBgThread.quit();
            this.mBgThread = null;
        }
        JumpReportCtr jumpReportCtr = this.mJumpReportCtr;
        if (jumpReportCtr != null) {
            jumpReportCtr.e(null);
            this.mJumpReportCtr = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnPause();
        if (this.needFinishOnPause) {
            finish();
        }
    }

    public int doQfavShare(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle)).intValue();
        }
        return JumpActivityHelper.H(this, bundle);
    }

    public void doShare(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            JumpActivityHelper.K(this, bundle);
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bundle);
        }
    }

    public void doSumsungCallUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            JumpActivityHelper.N(this);
        }
    }

    public void doView(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            JumpActivityHelper.w(this, intent, bundle);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.finish();
        QLog.i(TAG, 1, "finish. this=" + this);
    }

    public void goToWebSecVerify(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) intent);
        } else {
            JumpActivityHelper.P(this, intent);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                this.uiHandler.removeMessages(2);
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    int i16 = message.arg1;
                    Intent intent = (Intent) obj;
                    dismissDialog();
                    if (i16 == 0) {
                        if (!JumpActivityHelper.p(this)) {
                            doShare(intent.getExtras());
                            return false;
                        }
                        return false;
                    }
                    if (!JumpActivityHelper.p(this)) {
                        Bundle extras = intent.getExtras();
                        if (extras == null) {
                            extras = new Bundle();
                        }
                        doView(intent, extras);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        dismissDialog();
        return false;
    }

    public void initBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.qqBroadcastReceiver == null) {
            this.qqBroadcastReceiver = new a();
            registerReceiver(this.qqBroadcastReceiver, new IntentFilter(BROCAST_RECEIVER_ACTION));
        }
    }

    public void initFinishBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.mJumpFinishBroadcastReceiver == null) {
            this.mJumpFinishBroadcastReceiver = new b();
            registerReceiver(this.mJumpFinishBroadcastReceiver, new IntentFilter(BROADCAST_RECEIVER_FINISH_ACTION));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) dialogInterface);
        } else {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.sso.OnCheckShareListener
    public void onResponse(boolean z16, int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
        } else {
            JumpActivityHelper.k0(this, z16, i3, i16, str, str2);
        }
    }

    public int qqFavDoAction(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) hashMap)).intValue();
        }
        return JumpActivityHelper.t(this, hashMap);
    }

    public int qqFavHandleTypeImage(Bundle bundle, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle, (Object) hashMap)).intValue();
        }
        return JumpActivityHelper.u(this, bundle, hashMap);
    }

    public int qqFavHandleTypeTxt(Bundle bundle, HashMap<String, String> hashMap, Uri uri, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, bundle, hashMap, uri, str)).intValue();
        }
        return JumpActivityHelper.v(this, bundle, hashMap, uri, str);
    }

    @Override // mqq.app.AppActivity
    protected void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    public void showDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        try {
            setContentView(R.layout.avk);
            this.rootView = (RelativeLayout) findViewById(R.id.dzy);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (JumpActivityHelper.M(this)) {
            return true;
        }
        return super.showPreview();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, intent, Integer.valueOf(i3), bundle);
            return;
        }
        super.startActivityForResult(intent, i3, bundle);
        JumpReportCtr jumpReportCtr = this.mJumpReportCtr;
        if (jumpReportCtr != null) {
            jumpReportCtr.e(intent);
            this.mJumpReportCtr = null;
        }
    }

    public static void doShare(JumpActivity jumpActivity, boolean z16) {
        JumpActivityHelper.L(jumpActivity, z16);
    }

    public static void doView(JumpActivity jumpActivity, boolean z16) {
        JumpActionViewUtils.requestStoragePermission(jumpActivity, new Runnable(z16) { // from class: com.tencent.mobileqq.activity.JumpActivity.3
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f176344e;

            {
                this.f176344e = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JumpActivity.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Intent m3 = JumpActivityHelper.m(JumpActivity.this, this.f176344e);
                if (m3 == null) {
                    return;
                }
                JumpActivityHelper.c(JumpActivity.this, m3, 1);
            }
        }, new Runnable() { // from class: com.tencent.mobileqq.activity.JumpActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QLog.i(JumpActivity.TAG, 1, "doView user cancel grant storage permission");
                    JumpActivity.this.finish();
                }
            }
        });
    }

    public static void initJASwitch() {
        initJASwitch(QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(BaseApplication.getContext(), "Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
    }
}
