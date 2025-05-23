package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhoneFrameActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private int f183884a0;

    /* renamed from: b0, reason: collision with root package name */
    PhoneFrame f183885b0;

    /* renamed from: c0, reason: collision with root package name */
    View f183886c0;

    /* renamed from: d0, reason: collision with root package name */
    View f183887d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f183888e0;

    /* renamed from: f0, reason: collision with root package name */
    ImageView f183889f0;

    /* renamed from: g0, reason: collision with root package name */
    Bundle f183890g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneFrameActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardBaseOption p16 = PhoneFrameActivity.this.f183885b0.p();
                if (p16 != null) {
                    p16.endForwardCallback(false);
                }
                com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
                PhoneFrameActivity.this.setResult(1);
                PhoneFrameActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements BaseActivityView.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneFrameActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public TextView a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return PhoneFrameActivity.this.f183888e0;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return PhoneFrameActivity.this.f183886c0;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public TextView c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (TextView) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return PhoneFrameActivity.this.rightViewText;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public QQAppInterface getApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (QQAppInterface) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return PhoneFrameActivity.this.app;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public View getRootView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return PhoneFrameActivity.this.f183887d0;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public ImageView u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return PhoneFrameActivity.this.f183889f0;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public TextView v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (TextView) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return PhoneFrameActivity.this.centerView;
        }

        @Override // com.tencent.mobileqq.activity.phone.BaseActivityView.e
        public TextView x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (TextView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return PhoneFrameActivity.this.leftView;
        }
    }

    public PhoneFrameActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183884a0 = 0;
            this.f183885b0 = null;
        }
    }

    private void initViews() {
        View findViewById = findViewById(R.id.rlCommenTitle);
        this.f183886c0 = findViewById;
        this.f183887d0 = (View) findViewById.getParent();
        this.f183888e0 = (TextView) this.f183886c0.findViewById(R.id.ivTitleBtnLeft);
        this.leftView = (TextView) this.f183886c0.findViewById(R.id.ivTitleBtnLeftButton);
        TextView textView = (TextView) this.f183886c0.findViewById(R.id.ivTitleBtnRightText);
        this.rightViewText = textView;
        textView.setText(R.string.f171163ct0);
        this.rightViewText.setOnClickListener(new a());
        ImageView imageView = (ImageView) this.f183886c0.findViewById(R.id.ivTitleBtnRightImage);
        this.f183889f0 = imageView;
        if (AppSetting.f99565y) {
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.p2m));
        }
        IphoneTitleBarActivity.setLayerType(this.f183886c0);
        IphoneTitleBarActivity.setLayerType(this.f183888e0);
        IphoneTitleBarActivity.setLayerType(this.leftView);
        IphoneTitleBarActivity.setLayerType(this.rightViewText);
        IphoneTitleBarActivity.setLayerType(this.f183889f0);
        PhoneFrame phoneFrame = (PhoneFrame) findViewById(R.id.fmn);
        this.f183885b0 = phoneFrame;
        phoneFrame.setActivity(this);
        this.f183885b0.setPhoneContext(new b());
        this.f183885b0.j(null);
        Bundle bundle = new Bundle();
        bundle.putInt("key_req_type", this.f183884a0);
        this.f183885b0.m(bundle);
    }

    private void startChatAndSendMsg() {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        Bundle bundle = new Bundle(this.f183890g0);
        bundle.putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, false);
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
        m3.putExtra("uin", getIntent().getStringExtra("uin"));
        m3.putExtra("uinname", getIntent().getStringExtra("uinname"));
        m3.putExtra("uintype", getIntent().getIntExtra("uintype", 0));
        m3.putExtra("troop_uin", getIntent().getStringExtra("uin"));
        String string = bundle.getString("GALLERY.FORWORD_LOCAL_PATH");
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        PhotoUtils.sendPhoto(this, m3, arrayList, 0, false);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 20001) {
            if (i16 == -1) {
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        this.f183885b0.i(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.f168368u5);
        this.f183884a0 = getIntent().getIntExtra("key_req_type", 0);
        initViews();
        this.f183890g0 = getIntent().getExtras();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f183885b0.onStop();
        this.f183885b0.onDestroy();
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (intent.getBooleanExtra(PeakConstants.SEND_FLAG, false) && (stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS")) != null && !stringArrayListExtra.isEmpty()) {
            this.f183890g0.putString("GALLERY.FORWORD_LOCAL_PATH", stringArrayListExtra.get(0));
            this.f183890g0.putBoolean(AppConstants.Key.FORWARD_IS_EDITED, true);
            startChatAndSendMsg();
            ReportController.o(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f183885b0.k();
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnResume();
            this.f183885b0.l();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.app.isLogin() && this.f183884a0 == 0) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.setFlags(67108864);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183040c);
            startActivity(aliasIntent);
        }
        super.finish();
        overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
