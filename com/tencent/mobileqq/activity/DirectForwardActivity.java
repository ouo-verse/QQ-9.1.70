package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DirectForwardActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    String f175542a0;

    /* renamed from: b0, reason: collision with root package name */
    BroadcastReceiver f175543b0;

    /* renamed from: c0, reason: collision with root package name */
    ForwardBaseOption f175544c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.feed.api.g f175545d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.DirectForwardActivity$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f175546d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f175547e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f175548f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f175549h;

        AnonymousClass1(String str, String str2, String str3, int i3) {
            this.f175546d = str;
            this.f175547e = str2;
            this.f175548f = str3;
            this.f175549h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DirectForwardActivity.this, str, str2, str3, Integer.valueOf(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str) {
            DirectForwardActivity.this.I2(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3, Object obj) {
            if (obj instanceof String) {
                final String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    DirectForwardActivity.this.getIntent().putExtra("uinname", com.tencent.mobileqq.utils.ac.Q(DirectForwardActivity.this.app, str, i3));
                    DirectForwardActivity.this.getIntent().putExtra("uin", str);
                    DirectForwardActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.bs
                        @Override // java.lang.Runnable
                        public final void run() {
                            DirectForwardActivity.AnonymousClass1.this.c(str);
                        }
                    });
                    return;
                }
            }
            DirectForwardActivity.this.finish();
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ITeamWorkHandler iTeamWorkHandler = (ITeamWorkHandler) DirectForwardActivity.this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
            String str = this.f175546d;
            String str2 = this.f175547e;
            String str3 = this.f175548f;
            final int i3 = this.f175549h;
            iTeamWorkHandler.convertCryptoUinToTrueUin(str, str2, str3, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.activity.br
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    DirectForwardActivity.AnonymousClass1.this.d(i3, obj);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DirectForwardActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
                String string = extras.getString("verify");
                if (stringArrayList != null && stringArrayList.size() != 0 && DirectForwardActivity.this.f175542a0 != null && com.tencent.mobileqq.util.o.e(string, stringArrayList)) {
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        if (DirectForwardActivity.this.f175542a0.equals(stringArrayList.get(i3))) {
                            DirectForwardActivity.this.finish();
                            return;
                        }
                    }
                }
            }
        }
    }

    public DirectForwardActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f175543b0 = null;
        }
    }

    private void H2(Intent intent) {
        IGPSService d16;
        IGProChannelInfo channelInfo;
        if (intent == null || intent.getIntExtra("uintype", 0) != 10014) {
            return;
        }
        String stringExtra = intent.getStringExtra("guild_id");
        String stringExtra2 = intent.getStringExtra("uin");
        if (!TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || (d16 = com.tencent.mobileqq.guild.util.at.d()) == null || (channelInfo = d16.getChannelInfo(stringExtra2)) == null) {
            return;
        }
        String guildId = channelInfo.getGuildId();
        if (!TextUtils.isEmpty(guildId)) {
            intent.putExtra("guild_id", guildId);
            QLog.i("forward", 1, "fillGuildExtras guildId:" + stringExtra + " uin:" + stringExtra2 + " guildIdInInfo:" + guildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(String str) {
        this.f175544c0 = com.tencent.mobileqq.forward.k.d(getIntent(), this.app, this);
        int intValue = com.tencent.mobileqq.forward.e.O3.intValue();
        if (AppConstants.FAVORITES_UIN.equals(str)) {
            intValue = com.tencent.mobileqq.forward.e.T3.intValue();
        } else if (AppConstants.DATALINE_PC_UIN.equals(str)) {
            intValue = com.tencent.mobileqq.forward.e.S3.intValue();
        } else if (AppConstants.DATALINE_IPAD_UIN.equals(str)) {
            intValue = com.tencent.mobileqq.forward.e.X3.intValue();
        } else if (AppConstants.DATALINE_PHONE_UIN.equals(str)) {
            intValue = com.tencent.mobileqq.forward.e.f211017e4.intValue();
        } else if ("-1010".equals(str)) {
            intValue = com.tencent.mobileqq.forward.e.R3.intValue();
        }
        this.f175544c0.buildForwardDialog(intValue, getIntent().getExtras());
    }

    private boolean forwardToGuildFeeds(String str) {
        this.f175544c0 = com.tencent.mobileqq.forward.k.d(getIntent(), this.app, this);
        if (((IGPSService) this.app.getRuntimeService(IGPSService.class)).getGuildInfo(str) == null) {
            QLog.e("qqBaseActivity", 1, "guildInfo is null for " + str);
            return false;
        }
        QLog.i("qqBaseActivity", 1, "forward to guildId " + str);
        if ((this.f175544c0 instanceof com.tencent.mobileqq.forward.al) && !TextUtils.isEmpty(str) && ((com.tencent.mobileqq.forward.al) this.f175544c0).b()) {
            this.f175545d0 = new com.tencent.mobileqq.guild.feed.api.g() { // from class: com.tencent.mobileqq.activity.bq
                @Override // com.tencent.mobileqq.guild.feed.api.g
                public final void a(boolean z16) {
                    DirectForwardActivity.this.lambda$forwardToGuildFeeds$0(z16);
                }
            };
            ((com.tencent.mobileqq.forward.al) this.f175544c0).a(this, str, GuildSharePageSource.UNKNOWN.ordinal(), this.f175545d0);
            return true;
        }
        QQToast.makeText(BaseApplication.getContext(), 0, ForwardRecentActivity.NOT_SUPPORT_SHARE_TO_GUILD, 1).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forwardToGuildFeeds$0(boolean z16) {
        finish();
    }

    private void startChatAndSendMsg() {
        Bundle bundle;
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        if (this.f175544c0 != null) {
            bundle = new Bundle(this.f175544c0.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
        bundle.putBoolean(PeakConstants.IS_FORWARD, true);
        bundle.putInt(PeakConstants.SEND_BUSINESS_TYPE, 1031);
        bundle.putBoolean("PicContants.NEED_COMPRESS", false);
        m3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        m3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        m3.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        m3.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        m3.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
        m3.putExtra("isBack2Root", false);
        m3.putExtras(bundle);
        String string = bundle.getString("GALLERY.FORWORD_LOCAL_PATH");
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        PhotoUtils.sendPhoto(this, m3, arrayList, 0, true);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "forward form,DirectForwardActivity doOnCreate()");
        }
        Intent intent = getIntent();
        if (intent != null && this.app.isLogin()) {
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(intent.getStringExtra("toUin"))) {
                intent.putExtra("toUin", AppConstants.DATALINE_NEW_VERSION_UIN);
                intent.putExtra("uinType", 0);
                intent.putExtra("nickName", getString(R.string.f187533u9));
            }
            this.f175542a0 = intent.getStringExtra("openerProc");
            String stringExtra = intent.getStringExtra("toUin");
            String stringExtra2 = intent.getStringExtra("troopUin");
            String stringExtra3 = intent.getStringExtra("nickName");
            int intExtra = intent.getIntExtra("uinType", 0);
            int intExtra2 = intent.getIntExtra("isEncryptUin", 0);
            String stringExtra4 = intent.getStringExtra("vfwebqq");
            String stringExtra5 = intent.getStringExtra("tok");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!extras.containsKey("uin")) {
                    intent.putExtra("uin", stringExtra);
                }
                if (!extras.containsKey("troop_uin")) {
                    intent.putExtra("troop_uin", stringExtra2);
                }
                if (!extras.containsKey("uintype")) {
                    intent.putExtra("uintype", intExtra);
                }
                if (!extras.containsKey("uinname")) {
                    intent.putExtra("uinname", stringExtra3);
                }
                H2(intent);
            }
            if (intent.getBooleanExtra("qqfav_extra_from_sdk_share", false) || intent.getBooleanExtra("qqfav_extra_from_system_share", false)) {
                overridePendingTransition(0, 0);
            }
            if (intExtra == 10027) {
                if (!forwardToGuildFeeds(stringExtra)) {
                    setResult(0);
                    finish();
                }
                return false;
            }
            if (intent.getIntExtra("forward_type", -1) == 30) {
                if (extras != null && extras.containsKey("toUin")) {
                    SessionInfo sessionInfo = new SessionInfo();
                    String string = extras.getString("toUin");
                    sessionInfo.f179557e = string;
                    sessionInfo.f179559f = string;
                    ChatActivityFacade.N0(this.app, getApplicationContext(), sessionInfo);
                    setResult(-1);
                } else {
                    setResult(0);
                }
                finish();
            } else if (intExtra2 == 1 && !TextUtils.isEmpty(stringExtra4) && !TextUtils.isEmpty(stringExtra5)) {
                ThreadManagerV2.excute(new AnonymousClass1(stringExtra, stringExtra4, stringExtra5, intExtra), 128, null, false);
            } else {
                I2(stringExtra);
            }
            if (this.f175543b0 == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.process.exit");
                a aVar = new a();
                this.f175543b0 = aVar;
                registerReceiver(aVar, intentFilter);
            }
            if (com.tencent.mobileqq.startup.a.f289664e > 0) {
                Log.d("AutoMonitor", "actStartFav, cost=" + (SystemClock.uptimeMillis() - com.tencent.mobileqq.startup.a.f289664e));
            }
            return true;
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ForwardBaseOption forwardBaseOption = this.f175544c0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        try {
            BroadcastReceiver broadcastReceiver = this.f175543b0;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
                this.f175543b0 = null;
            }
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "qqBaseActivity onNewIntent()");
        }
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.SEND_FLAG, false);
        boolean booleanExtra2 = intent.getBooleanExtra("isFromFavorites", false);
        if (booleanExtra && booleanExtra2 && this.f175544c0 != null) {
            String str = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
            this.f175544c0.getExtras().putBoolean(AppConstants.Key.FORWARD_IS_EDITED, true);
            this.f175544c0.getExtras().putString(AppConstants.Key.FORWARD_FILEPATH, str);
            this.f175544c0.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", str);
            startChatAndSendMsg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnPause();
        ForwardBaseOption forwardBaseOption = this.f175544c0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        ForwardBaseOption forwardBaseOption = this.f175544c0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
