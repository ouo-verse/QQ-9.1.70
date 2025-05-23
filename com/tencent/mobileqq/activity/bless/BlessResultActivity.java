package com.tencent.mobileqq.activity.bless;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BlessResultActivity extends BlessTypeActivity implements WXShareHelper.a, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    private int f180536g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f180537h0;

    /* renamed from: i0, reason: collision with root package name */
    MqqWeakReferenceHandler f180538i0;

    /* renamed from: j0, reason: collision with root package name */
    String f180539j0;

    /* renamed from: k0, reason: collision with root package name */
    String f180540k0;

    /* renamed from: l0, reason: collision with root package name */
    int f180541l0;

    /* renamed from: m0, reason: collision with root package name */
    String f180542m0;

    /* renamed from: n0, reason: collision with root package name */
    String f180543n0;

    /* renamed from: o0, reason: collision with root package name */
    String f180544o0;

    /* renamed from: p0, reason: collision with root package name */
    String f180545p0;

    /* renamed from: q0, reason: collision with root package name */
    ProgressDialog f180546q0;

    /* renamed from: r0, reason: collision with root package name */
    VideoUploadTask f180547r0;

    /* renamed from: s0, reason: collision with root package name */
    boolean f180548s0;

    /* renamed from: t0, reason: collision with root package name */
    String f180549t0;

    /* renamed from: u0, reason: collision with root package name */
    int f180550u0;

    /* renamed from: v0, reason: collision with root package name */
    String f180551v0;

    /* renamed from: w0, reason: collision with root package name */
    String f180552w0;

    /* renamed from: x0, reason: collision with root package name */
    String f180553x0;

    /* renamed from: y0, reason: collision with root package name */
    com.tencent.mobileqq.troop.data.l f180554y0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class VideoUploadTask implements Runnable {
        static IPatchRedirector $redirector_;
        private long C;

        /* renamed from: d, reason: collision with root package name */
        private String f180556d;

        /* renamed from: e, reason: collision with root package name */
        private String f180557e;

        /* renamed from: f, reason: collision with root package name */
        private String f180558f;

        /* renamed from: h, reason: collision with root package name */
        private String f180559h;

        /* renamed from: i, reason: collision with root package name */
        private com.tencent.mobileqq.troop.data.l f180560i;

        /* renamed from: m, reason: collision with root package name */
        private AtomicBoolean f180561m;

        public VideoUploadTask(String str, String str2, b bVar, com.tencent.mobileqq.troop.data.l lVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BlessResultActivity.this, str, str2, bVar, lVar);
                return;
            }
            this.f180556d = null;
            this.f180557e = null;
            this.f180561m = new AtomicBoolean(true);
            this.C = -1L;
            this.f180558f = str;
            this.f180559h = str2;
            this.f180560i = lVar;
            if (this.f180556d == null) {
                this.f180556d = BlessResultActivity.this.getString(R.string.dkk);
            }
            if (this.f180557e == null) {
                this.f180557e = BlessResultActivity.this.getString(R.string.f170631wh);
            }
        }

        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            boolean z16 = !f();
            if (QLog.isColorLevel()) {
                QLog.d("BlessResultActivity", 2, "VideoUploadTask isRunning(),result = " + z16);
            }
            return z16;
        }

        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.f180561m.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("BlessResultActivity", 2, "VideoUploadTask start! ");
            }
            this.f180561m.set(false);
            if (this.f180560i == null) {
                this.f180561m.set(true);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopBar", 2, "VideoUploadTask mCallback is null!!!");
                    return;
                }
                return;
            }
            this.f180561m.set(true);
            this.f180560i.a(-1L);
            if (QLog.isColorLevel()) {
                QLog.d("TroopBar", 2, "VideoUploadTask mVInfo is null !!!");
            }
        }

        public void stop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessResultActivity", 2, "VideoUploadTask stop()");
            }
            this.f180561m.set(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements com.tencent.mobileqq.troop.data.l {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessResultActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.l
        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadFail!");
            }
            if (BlessResultActivity.this.f180538i0.hasMessages(1003)) {
                BlessResultActivity.this.f180538i0.removeMessages(1003);
            }
            BlessResultActivity.this.f180538i0.sendEmptyMessage(1003);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b implements Cloneable {
        static IPatchRedirector $redirector_;
    }

    public BlessResultActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180548s0 = false;
        this.f180550u0 = 0;
        this.f180554y0 = new a();
    }

    public static String H2(String str) {
        String str2 = AppConstants.SDCARD_PATH + "bless/thumb/";
        File file = new File(str2);
        if (file.exists() && file.isDirectory() && file.listFiles().length > 0) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
        return str2 + str.substring(str.lastIndexOf("/"));
    }

    private void initUI() {
        String string;
        ((ImmersiveTitleBar2) findViewById(R.id.jq6)).setVisibility(4);
        findViewById(R.id.ivTitleBtnRightText).setVisibility(8);
        findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.k6u);
        int i3 = this.f180536g0;
        if (i3 != 1) {
            if (i3 != 2) {
                string = "";
            } else {
                string = getString(R.string.f170609vq);
            }
        } else {
            string = getString(R.string.f170624w9);
        }
        textView.setText(String.format(getString(R.string.f170623w7), Integer.valueOf(this.f180537h0)));
        if (this.f180537h0 > 10) {
            ((TextView) findViewById(R.id.f164614ab1)).setText(String.format(getString(R.string.f170616vz), 10));
        }
        if (this.f180536g0 == 2) {
            findViewById(R.id.idn).setVisibility(0);
            ((TextView) findViewById(R.id.kao)).setText(String.format(getString(R.string.f170620w4), string));
            findViewById(R.id.k_l).setOnClickListener(this);
            findViewById(R.id.k89).setOnClickListener(this);
        }
    }

    void G2() {
        if (QLog.isColorLevel()) {
            QLog.e("BlessResultActivity", 2, "cancelProgressDialog");
        }
        try {
            ProgressDialog progressDialog = this.f180546q0;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    void I2(int i3) {
        showProgressDialog();
        this.f180550u0 = i3;
        if (this.f180540k0 != null && this.f180539j0 != null && this.f180544o0 != null && this.f180545p0 != null) {
            File file = new File(this.f180540k0);
            File file2 = new File(this.f180539j0);
            if (file.exists() && file2.exists()) {
                if (file.isFile() && file2.isFile()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessResultActivity", 2, "share last uploaded ptv. mPtvPath=" + this.f180539j0 + " ,mSnapImagePath=" + this.f180540k0 + " ,mPtvUuid=" + this.f180544o0 + " ,mPtvMd5=" + this.f180545p0);
                    }
                    this.f180549t0 = this.f180578c0.R(this.f180544o0, this.f180545p0);
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessResultActivity", 2, "share url :" + this.f180549t0);
                    }
                    if (this.f180550u0 == 1) {
                        J2();
                        return;
                    } else {
                        ThreadManagerV2.post(new Runnable(this.f180540k0) { // from class: com.tencent.mobileqq.activity.bless.BlessResultActivity.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f180555d;

                            {
                                this.f180555d = r5;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessResultActivity.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                try {
                                    long fileSizes = FileUtils.getFileSizes(this.f180555d);
                                    if (fileSizes < 25600) {
                                        BlessResultActivity.this.f180538i0.sendMessage(BlessResultActivity.this.f180538i0.obtainMessage(1004));
                                        return;
                                    }
                                    String H2 = BlessResultActivity.H2(this.f180555d);
                                    BaseImageUtil.compressImagetoSize(BaseApplication.getContext(), this.f180555d, H2, 160, 160);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("BlessResultActivity", 2, "share ptv to FC. srcLen:" + fileSizes + " ,objLen:" + FileUtils.getFileSizes(H2) + " , thumbPath:" + H2);
                                    }
                                    Message obtainMessage = BlessResultActivity.this.f180538i0.obtainMessage(1004);
                                    obtainMessage.obj = H2;
                                    BlessResultActivity.this.f180538i0.sendMessage(obtainMessage);
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                        }, 8, null, false);
                        return;
                    }
                }
                QQToast.makeText(this, R.string.b8j, 0).show();
                G2();
                return;
            }
            QQToast.makeText(this, R.string.b8h, 0).show();
            G2();
            return;
        }
        QQToast.makeText(this, R.string.b8h, 0).show();
        G2();
    }

    void J2() {
        G2();
        if (this.f180550u0 == 1) {
            L2();
        } else {
            K2();
        }
    }

    void K2() {
        int i3;
        Bitmap bitmap;
        if (!WXShareHelper.b0().e0()) {
            i3 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i3 = R.string.f173258ih2;
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            QQToast.makeText(this, getString(i3), 0).show();
            return;
        }
        this.f180551v0 = String.valueOf(System.currentTimeMillis());
        try {
            bitmap = BitmapFactory.decodeFile(this.f180540k0);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("BlessResultActivity", 2, "getBitmapByPath OOM, fileName: " + this.f180540k0, e16);
            }
            bitmap = null;
        }
        Bitmap bitmap2 = bitmap;
        String str = this.f180542m0;
        if (TextUtils.isEmpty(str)) {
            str = this.f180578c0.T(false);
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.w3);
            }
        }
        WXShareHelper.b0().N0(this.f180551v0, str, bitmap2, String.format(getString(R.string.f170619w2), this.app.getCurrentNickname()), this.f180549t0);
        if (QLog.isColorLevel()) {
            QLog.i("BlessResultActivity", 2, "shareToFriendCircle.transaction: " + this.f180551v0 + ", shareLink:" + this.f180549t0);
        }
    }

    void L2() {
        String str = this.f180540k0;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        String str2 = this.f180542m0;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f180578c0.T(true);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.w3);
            }
        }
        String format = String.format(getString(R.string.f170619w2), this.app.getCurrentNickname());
        Bundle bundle = new Bundle();
        bundle.putString("title", str2);
        bundle.putString("desc", format);
        bundle.putLong("req_share_id", 0L);
        bundle.putString("detail_url", this.f180549t0);
        bundle.putString("url", this.f180549t0);
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putString(AppConstants.Key.SHARE_REQ_TROOP_WORDING, str2);
        bundle.putString(AppConstants.Key.SHARE_REQ_BIZNAME, AppConstants.SHARE_REQ_BIZNAME_STAR_BLESS_LINK);
        QZoneShareManager.jumpToQzoneShare(this.app, this, bundle, null);
        if (QLog.isColorLevel()) {
            QLog.i("BlessResultActivity", 2, "shareToQzone: shareLink:" + this.f180549t0);
        }
    }

    void M2() {
        VideoUploadTask videoUploadTask = this.f180547r0;
        if (videoUploadTask != null && (videoUploadTask.e() || this.f180548s0)) {
            J2();
            return;
        }
        this.f180547r0 = new VideoUploadTask(this.app.getCurrentUin(), null, null, this.f180554y0);
        this.f180538i0.sendEmptyMessageDelayed(1003, 120000L);
        ThreadManagerV2.post(this.f180547r0, 8, null, false);
    }

    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            onBackEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f167677e4);
        this.f180578c0.t();
        this.f180578c0.N0(false);
        Intent intent = getIntent();
        this.f180536g0 = intent.getIntExtra("param_method", 1);
        this.f180537h0 = intent.getIntExtra("param_count", 0);
        if (this.f180536g0 == 2) {
            this.f180538i0 = new MqqWeakReferenceHandler(this);
            this.f180539j0 = intent.getStringExtra("param_ptv_path");
            this.f180540k0 = intent.getStringExtra("param_snap_path");
            this.f180541l0 = intent.getIntExtra("param_ptv_id", -1);
            this.f180542m0 = intent.getStringExtra("param_share_title");
            this.f180544o0 = intent.getStringExtra("param_ptv_uuid");
            this.f180545p0 = intent.getStringExtra("param_ptv_md5");
            if (QLog.isColorLevel()) {
                QLog.d("BlessResultActivity", 2, "mp4: " + this.f180539j0 + ", image:" + this.f180540k0);
            }
            WXShareHelper.b0().A(this);
        }
        this.f180579d0 = 0.48f;
        this.f180580e0 = 2;
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (this.f180536g0 == 2) {
            WXShareHelper.b0().q0(this);
            VideoUploadTask videoUploadTask = this.f180547r0;
            if (videoUploadTask != null && videoUploadTask.e()) {
                this.f180547r0.stop();
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x003c. Please report as an issue. */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessResultActivity", 2, "handleMessage,msg.what = " + message.what);
        }
        switch (message.what) {
            case 1000:
                M2();
                return true;
            case 1001:
                this.f180552w0 = this.f180539j0;
                this.f180553x0 = this.f180543n0;
                SharedPreferences.Editor edit = getSharedPreferences("bless_ptv_upload", 0).edit();
                String currentAccountUin = getCurrentAccountUin();
                edit.putString("bless_ptv_path" + currentAccountUin, this.f180552w0);
                edit.putString("bless_vid" + currentAccountUin, this.f180553x0);
                edit.commit();
                J2();
                return true;
            case 1003:
                VideoUploadTask videoUploadTask = this.f180547r0;
                if (videoUploadTask != null && videoUploadTask.e()) {
                    this.f180547r0.stop();
                }
                G2();
                QQToast.makeText(this, 1, R.string.hit, 0).show();
                break;
            case 1002:
                return true;
            case 1004:
                Object obj = message.obj;
                if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                    this.f180540k0 = (String) message.obj;
                }
                J2();
                break;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Intent intent = new Intent(this, (Class<?>) BlessActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                Intent aliasIntent = SplashActivity.getAliasIntent(this);
                aliasIntent.setFlags(67108864);
                startActivity(aliasIntent);
            } else {
                if (id5 == R.id.k_l) {
                    I2(1);
                } else if (id5 == R.id.k89) {
                    I2(2);
                }
                super.onClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.bless.BlessTypeActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
    public void onWXShareResp(BaseResp baseResp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseResp);
            return;
        }
        String str = this.f180551v0;
        if (str != null && str.equals(baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
            if (i3 != 0) {
                QQToast.makeText(this, 1, getString(R.string.hit), 0).show();
            } else {
                QQToast.makeText(this, 2, getString(R.string.hj9), 0).show();
            }
        }
    }

    void showProgressDialog() {
        if (QLog.isColorLevel()) {
            QLog.e("BlessResultActivity", 2, "showProgressDialog");
        }
        try {
            if (this.f180546q0 != null) {
                G2();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this, R.style.qZoneInputDialog);
                this.f180546q0 = reportProgressDialog;
                reportProgressDialog.setCancelable(false);
                this.f180546q0.show();
                this.f180546q0.setContentView(R.layout.f168383uh);
                ((TextView) this.f180546q0.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.g1x);
            }
            if (!this.f180546q0.isShowing()) {
                this.f180546q0.show();
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("BlessResultActivity", 2, "showProgressDialog", th5);
            }
        }
    }
}
