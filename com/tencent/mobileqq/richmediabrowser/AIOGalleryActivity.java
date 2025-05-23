package com.tencent.mobileqq.richmediabrowser;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.aio.photo.h;
import com.tencent.mobileqq.activity.aio.photo.i;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.util.BinderWarpper;
import com.tencent.util.LiuHaiUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOGalleryActivity extends PeakActivity {
    private IBrowserManager P;
    private MainBrowserPresenter Q;
    com.tencent.mobileqq.activity.aio.photo.h R;
    private com.tencent.biz.troop.b U;
    BroadcastReceiver S = null;
    BroadcastReceiver T = null;
    public String V = null;
    private volatile boolean W = false;
    private com.tencent.mobileqq.activity.aio.photo.i X = new AIOImageProviderCallBack(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(intent.getAction())) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryActivity", 2, "receive videochat in aiogallery");
                }
                AIOGalleryActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        private static Object a(Object obj) throws Exception {
            return obj.getClass().getDeclaredMethod("getFeature", Class.forName("android.common.IOplusCommonFeature"), Object[].class).invoke(obj, b(), new Object[0]);
        }

        private static Object b() throws Exception {
            Class<?> cls = Class.forName("android.view.IOplusBurmeseZgHooks");
            return cls.getDeclaredField("DEFAULT").get(cls);
        }

        private static Object c() throws Exception {
            Class<?> cls = Class.forName("android.common.OplusFrameworkFactory");
            return cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
        }

        private static void d(Object obj, Context context) throws Exception {
            obj.getClass().getDeclaredMethod("initBurmeseZgFlag", Context.class).invoke(obj, context);
        }

        public static void e(Context context) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                d(a(c()), context);
                QLog.i("FixOppoCompatibleIssue", 1, "[initZgFlag] complete, time=" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e16) {
                QLog.i("FixOppoCompatibleIssue", 1, "exception: " + e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class c implements com.tencent.mobileqq.videoplatform.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f281776a;

        c(Context context) {
            this.f281776a = context;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.a
        public void a(SDKInitListener sDKInitListener) {
            QQVideoPlaySDKManager.initSDKAsync(this.f281776a, sDKInitListener);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class d extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        Activity f281777a;

        /* renamed from: b, reason: collision with root package name */
        boolean f281778b = true;

        d(Activity activity) {
            this.f281777a = activity;
        }

        public boolean a(Context context) {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                this.f281778b = !a(context);
            } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                this.f281778b = false;
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                this.f281778b = true;
            }
            if (!this.f281778b) {
                this.f281777a.unregisterReceiver(this);
                this.f281777a.finish();
            }
        }
    }

    private void A0(i iVar) {
        if (this.R == null) {
            BinderWarpper binderWarpper = (BinderWarpper) getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
            if (binderWarpper != null) {
                com.tencent.mobileqq.activity.aio.photo.h j3 = h.a.j(binderWarpper.binder);
                this.R = j3;
                if (j3 != null) {
                    j3.D1(this.X);
                    iVar.o(this.R);
                    if (!h.a().u() && !h.a().p()) {
                        this.R.D(h.a().b());
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryActivity", 2, "binder is null!");
                }
                finish();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.R);
            }
        }
    }

    private void B0() {
        this.T = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        try {
            if (!this.W) {
                this.W = true;
                registerReceiver(this.T, intentFilter);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private List<RichMediaBrowserInfo> C0(Parcelable[] parcelableArr) {
        if (parcelableArr != null && parcelableArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < parcelableArr.length; i3++) {
                if (parcelableArr[i3] instanceof RichMediaBaseData) {
                    RichMediaBrowserInfo richMediaBrowserInfo = new RichMediaBrowserInfo();
                    richMediaBrowserInfo.baseData = (RichMediaBaseData) parcelableArr[i3];
                    arrayList.add(richMediaBrowserInfo);
                }
            }
            return arrayList;
        }
        return null;
    }

    private void x0(Context context) {
        try {
            QLog.i("AIOGalleryActivity", 1, "getSystemSettings, value=" + DeviceInfoMonitor.getStringSystem(context.getContentResolver(), "date_format"));
        } catch (Exception e16) {
            QLog.i("AIOGalleryActivity", 1, "getSystemSettings, exception=" + e16);
        }
    }

    private void y0(Bundle bundle) {
        if (bundle.getBoolean("extra.GUILD_NEED_REPORT", false)) {
            VideoReport.addToDetectionWhitelist(this);
            VideoReport.setPageId(this, "pg_sgrp_aio_viewer");
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_channel_id", bundle.getString(IGuildForwardUtilsApi.EXTRA_GUILD_ID));
            hashMap.put("sgrp_sub_channel_id", bundle.getString("uin"));
            hashMap.put("sgrp_subchannel_type", bundle.getString("extra.GUILD_CHANNEL_TYPE", "1"));
            hashMap.put("sgrp_author_uin", bundle.getString("extra.GUILD_AUTHOR_UIN"));
            hashMap.put("sgrp_user_type", bundle.getString("extra.GUILD_USER_TYPE"));
            hashMap.put("aio_disappear_type", "0");
            hashMap.put("sgrp_duration_flag", "1");
            hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
            VideoReport.setPageParams(this, new PageParams(hashMap));
        }
    }

    private void z0(i iVar) {
        A0(iVar);
        B0();
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        QLog.i("AIOGalleryActivity", 1, "[finish] stack=" + QLog.getStackTraceString(new RuntimeException()));
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2
    public void initNavigationBarColor() {
        com.tencent.mobileqq.theme.a.e(getWindow(), -16777216);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, android.app.Activity
    public void onBackPressed() {
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null && !mainBrowserPresenter.onBackEvent()) {
            super.onBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onConfigurationChanged(configuration);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00d6 A[Catch: Exception -> 0x00a0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a0, blocks: (B:27:0x0099, B:8:0x00a5, B:12:0x00b0, B:14:0x00d6), top: B:26:0x0099 }] */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        List<RichMediaBrowserInfo> list;
        int i3;
        int i16;
        MainBrowserPresenter mainBrowserPresenter;
        QLog.i("AIOGalleryActivity", 1, "onCreate()[" + hashCode() + "]");
        Choreographer.getInstance();
        b.e(this);
        x0(this);
        this.F = true;
        this.G = false;
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.enableNotch(this);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.U = A;
        A.p();
        VideoPlayerProxy.setVideoPlaySDKInit(new c(getApplicationContext()));
        com.tencent.mobileqq.activity.aio.photo.a.f179715a = getResources().getDisplayMetrics().density;
        ShortVideoUtils.loadShortVideoSo(((IAECaptureContext) QRoute.api(IAECaptureContext.class)).getAppInterface());
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.V = extras.getString("extra.GROUP_UIN");
            list = C0(extras.getParcelableArray(RichMediaBrowserConstants.INTERNAL_EXTRA_CURRENT_IMAGE_LIST));
            y0(extras);
        } else {
            list = null;
        }
        List<RichMediaBrowserInfo> list2 = list;
        if (extras != null) {
            try {
                i3 = extras.getInt(r05.a.f430454c, 0);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryActivity", 2, "onCreate exception = " + e16.getMessage());
                }
                finish();
            }
        } else {
            i3 = 0;
        }
        if (list2 != null && i3 <= list2.size() - 1) {
            i16 = i3;
            i iVar = new i();
            IBrowserManager launchRichMediaBrowser = ((IBrowserManager) QRoute.api(IBrowserManager.class)).launchRichMediaBrowser(this, intent, iVar, "KEY_THUMBNAL_BOUND", list2, i16);
            this.P = launchRichMediaBrowser;
            this.Q = launchRichMediaBrowser.getPresenter();
            z0(iVar);
            mainBrowserPresenter = this.Q;
            if (mainBrowserPresenter != null) {
                mainBrowserPresenter.onCreate(bundle);
            }
            QLog.i("AIOGalleryActivity", 1, "onCreate() end[" + hashCode() + "]");
        }
        i16 = 0;
        i iVar2 = new i();
        IBrowserManager launchRichMediaBrowser2 = ((IBrowserManager) QRoute.api(IBrowserManager.class)).launchRichMediaBrowser(this, intent, iVar2, "KEY_THUMBNAL_BOUND", list2, i16);
        this.P = launchRichMediaBrowser2;
        this.Q = launchRichMediaBrowser2.getPresenter();
        z0(iVar2);
        mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
        }
        QLog.i("AIOGalleryActivity", 1, "onCreate() end[" + hashCode() + "]");
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryActivity", 2, "onDestroy()[" + hashCode() + "]");
        }
        super.onDestroy();
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onDestroy();
        }
        if (this.R != null) {
            try {
                if (!getIntent().getBooleanExtra(RichMediaBrowserConstants.EXTRA_IS_FROM_CHAT_FILE_HISTORY, false) && !getIntent().getBooleanExtra(RichMediaBrowserConstants.EXTRA_IS_STARTING_CHAT_FILE_HISTORY, false)) {
                    this.R.T3();
                    this.R.destory();
                    this.X = null;
                } else {
                    this.R.T3();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryActivity", 2, "onDestroy() exception = " + e16.getMessage());
                }
            }
        }
        if (this.T != null && this.W) {
            unregisterReceiver(this.T);
            this.T = null;
        }
        this.U.q();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null && !mainBrowserPresenter.onKeyDown(i3, keyEvent)) {
            return super.onKeyDown(i3, keyEvent);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        BroadcastReceiver broadcastReceiver;
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 52);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
        super.onPause();
        if (DeviceInfoMonitor.getModel().equals("Coolpad 5930") && (broadcastReceiver = this.S) != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryActivity", 2, "onPause exception = " + e16.getMessage());
                }
            }
        }
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onPause();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        QLog.i("AIOGalleryActivity", 1, "onResume()[" + hashCode() + "]");
        super.onResume();
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 52);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
        if (DeviceInfoMonitor.getModel().equals("Coolpad 5930")) {
            this.S = new d(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            registerReceiver(this.S, intentFilter);
        }
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryActivity", 2, "onStop()");
        }
        super.onStop();
        ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        MainBrowserPresenter mainBrowserPresenter;
        super.onWindowFocusChanged(z16);
        if (z16 && (mainBrowserPresenter = this.Q) != null) {
            mainBrowserPresenter.onWindowFocusChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2
    public boolean q0() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2
    public boolean r0() {
        MainBrowserPresenter mainBrowserPresenter = this.Q;
        if (mainBrowserPresenter != null) {
            return mainBrowserPresenter.onBackEvent();
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class AIOImageProviderCallBack extends i.a {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<AIOGalleryActivity> f281753d;

        public AIOImageProviderCallBack(AIOGalleryActivity aIOGalleryActivity) {
            this.f281753d = new WeakReference<>(aIOGalleryActivity);
        }

        @Override // com.tencent.mobileqq.activity.aio.photo.i
        public void e5(final AIORichMediaData[] aIORichMediaDataArr, final int i3) {
            final AIOGalleryActivity aIOGalleryActivity = this.f281753d.get();
            if (aIOGalleryActivity == null) {
                QLog.d("IAIOImageProviderCallBack", 1, "notifyImageListChanged() weak reference activity is recycle");
            } else {
                aIOGalleryActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.AIOImageProviderCallBack.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aIORichMediaDataArr != null && aIOGalleryActivity.P != null) {
                            try {
                                aIOGalleryActivity.P.notifyImageListChanged(com.tencent.mobileqq.richmediabrowser.utils.d.b(aIORichMediaDataArr), i3);
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("IAIOImageProviderCallBack", 2, "notifyImageListChanged exception = " + e16.getMessage());
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.photo.i
        public void j0(final long j3, final int i3, final int i16, final String str, final String[] strArr, final String str2, final MessageForShortVideo messageForShortVideo, final int i17, final Bundle bundle) {
            final AIOGalleryActivity aIOGalleryActivity = this.f281753d.get();
            if (aIOGalleryActivity == null) {
                QLog.d("IAIOImageProviderCallBack", 1, "notifyVideoUrl() weak reference activity is recycle");
            } else {
                aIOGalleryActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.AIOImageProviderCallBack.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aIOGalleryActivity.P != null) {
                            aIOGalleryActivity.P.notifyVideoUrl(j3, i3, i16, str, strArr, str2, messageForShortVideo, i17, bundle);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.photo.i
        public void notifyImageProgress(final long j3, final int i3, final int i16, final int i17, final long j16, final boolean z16) {
            final AIOGalleryActivity aIOGalleryActivity = this.f281753d.get();
            if (aIOGalleryActivity == null) {
                QLog.d("IAIOImageProviderCallBack", 1, "notifyImageProgress() weak reference activity is recycle");
            } else {
                aIOGalleryActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.AIOImageProviderCallBack.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aIOGalleryActivity.P != null) {
                            aIOGalleryActivity.P.notifyImageProgress(j3, i3, i16, i17, j16, z16);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.photo.i
        public void notifyImageResult(final long j3, final int i3, final int i16, final int i17, final String str, final boolean z16) {
            final AIOGalleryActivity aIOGalleryActivity = this.f281753d.get();
            if (aIOGalleryActivity == null) {
                QLog.d("IAIOImageProviderCallBack", 1, "notifyImageResult() weak reference activity is recycle");
            } else {
                aIOGalleryActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.AIOImageProviderCallBack.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aIOGalleryActivity.P != null) {
                            aIOGalleryActivity.P.notifyImageResult(j3, i3, i16, i17, str, z16);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.photo.i
        public void a1() {
        }
    }
}
