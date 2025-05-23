package com.tencent.mobileqq.activity.photo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AutoSaveUtils;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class CameraPreviewActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ViewGroup f183945a0;

    /* renamed from: b0, reason: collision with root package name */
    private Gallery f183946b0;

    /* renamed from: c0, reason: collision with root package name */
    private g f183947c0;

    /* renamed from: d0, reason: collision with root package name */
    private Drawable f183948d0;

    /* renamed from: e0, reason: collision with root package name */
    private ArrayList<String> f183949e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f183950f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f183951g0;

    /* renamed from: h0, reason: collision with root package name */
    boolean f183952h0;

    /* renamed from: i0, reason: collision with root package name */
    boolean f183953i0;

    /* renamed from: j0, reason: collision with root package name */
    String f183954j0;

    /* renamed from: k0, reason: collision with root package name */
    protected QQCustomDialog f183955k0;

    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                CameraPreviewActivity cameraPreviewActivity = CameraPreviewActivity.this;
                if (!cameraPreviewActivity.P2((String) cameraPreviewActivity.f183949e0.get(0))) {
                    CameraPreviewActivity cameraPreviewActivity2 = CameraPreviewActivity.this;
                    if (cameraPreviewActivity2.f183953i0) {
                        ReportController.o(cameraPreviewActivity2.app, "CliOper", "", "", "0X8004D96", "0X8004D96", 0, 0, "", "", "", "");
                    }
                    CameraPreviewActivity cameraPreviewActivity3 = CameraPreviewActivity.this;
                    PhotoUtils.sendPhoto(cameraPreviewActivity3, cameraPreviewActivity3.getIntent(), CameraPreviewActivity.this.f183949e0, 2, true);
                    view.setClickable(false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!CameraPreviewActivity.this.N2()) {
                CameraPreviewActivity cameraPreviewActivity = CameraPreviewActivity.this;
                if (cameraPreviewActivity.f183953i0) {
                    ReportController.o(cameraPreviewActivity.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
                }
                if (CameraPreviewActivity.this.f183953i0) {
                    m.l();
                } else {
                    m.m();
                }
                if (CameraPreviewActivity.this.f183949e0 != null && CameraPreviewActivity.this.f183949e0.size() > 0) {
                    AutoSaveUtils.b((String) CameraPreviewActivity.this.f183949e0.get(0), true);
                }
                CameraPreviewActivity cameraPreviewActivity2 = CameraPreviewActivity.this;
                PhotoUtils.sendPhoto(cameraPreviewActivity2, cameraPreviewActivity2.getIntent(), CameraPreviewActivity.this.f183949e0, 0, true);
                view.setClickable(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                CameraPreviewActivity cameraPreviewActivity = CameraPreviewActivity.this;
                if (cameraPreviewActivity.f183953i0) {
                    ReportController.o(cameraPreviewActivity.app, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
                }
                CameraPreviewActivity.this.finish();
                QAlbumUtil.anim(CameraPreviewActivity.this, true, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                CameraPreviewActivity.this.f183955k0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                CameraPreviewActivity.this.f183955k0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                CameraPreviewActivity.this.f183955k0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class g extends BaseAdapter {
        static IPatchRedirector $redirector_;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraPreviewActivity.this);
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (CameraPreviewActivity.this.f183949e0 != null && i3 < CameraPreviewActivity.this.f183949e0.size() && i3 >= 0) {
                return (String) CameraPreviewActivity.this.f183949e0.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (CameraPreviewActivity.this.f183949e0 != null) {
                return CameraPreviewActivity.this.f183949e0.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            h hVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = CameraPreviewActivity.this.getLayoutInflater().inflate(R.layout.f168380ue, (ViewGroup) null);
                    hVar = new h();
                    hVar.f183963a = (URLImageView) view.findViewById(R.id.fyn);
                    view.setTag(hVar);
                } else {
                    hVar = (h) view.getTag();
                }
                String item = getItem(i3);
                if (item != null) {
                    File file = new File(item);
                    if (file.exists()) {
                        try {
                            hVar.f183963a.setImageDrawable(URLDrawable.getDrawable(file.toURL(), CameraPreviewActivity.this.f183950f0, CameraPreviewActivity.this.f183951g0, CameraPreviewActivity.this.f183948d0, (Drawable) null, true));
                        } catch (MalformedURLException e16) {
                            e16.printStackTrace();
                        }
                    }
                } else {
                    hVar.f183963a.setImageDrawable(null);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes10.dex */
    static class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        URLImageView f183963a;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public CameraPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183948d0 = new ColorDrawable(0);
        this.f183949e0 = new ArrayList<>();
        this.f183954j0 = null;
    }

    private void M2() {
        Gallery gallery = new Gallery(this);
        this.f183946b0 = gallery;
        gallery.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.f183945a0.addView(this.f183946b0, -1, -1);
        g gVar = new g();
        this.f183947c0 = gVar;
        this.f183946b0.setAdapter((SpinnerAdapter) gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N2() {
        if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            Q2(7);
            return true;
        }
        if (com.tencent.mobileqq.activity.aio.photo.d.a() < 10) {
            Q2(6);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P2(String str) {
        if (new File(str).length() <= ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
            return false;
        }
        QQToast.makeText(this, getResources().getString(R.string.cui), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return true;
    }

    private void Q2(int i3) {
        String str;
        String str2;
        String string;
        String string2;
        if (i3 == 6) {
            string = getString(R.string.h_2);
            string2 = getString(R.string.h_1);
        } else if (i3 == 7) {
            string = getString(R.string.h_4);
            string2 = getString(R.string.h_3);
        } else {
            QQCustomDialog qQCustomDialog = this.f183955k0;
            if (qQCustomDialog != null) {
                qQCustomDialog.dismiss();
                return;
            }
            str = null;
            str2 = null;
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, str, str2, new d(), null);
            this.f183955k0 = createCustomDialog;
            createCustomDialog.setOnCancelListener(new e());
            this.f183955k0.setOnDismissListener(new f());
            this.f183955k0.show();
        }
        str = string;
        str2 = string2;
        QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this, 230, str, str2, new d(), null);
        this.f183955k0 = createCustomDialog2;
        createCustomDialog2.setOnCancelListener(new e());
        this.f183955k0.setOnDismissListener(new f());
        this.f183955k0.show();
    }

    private void initData() {
        Intent intent = getIntent();
        boolean z16 = false;
        boolean booleanExtra = intent.getBooleanExtra("callFromFastImage", false);
        this.f183953i0 = booleanExtra;
        if (booleanExtra) {
            m.a();
        } else {
            m.b();
        }
        this.f183949e0 = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        int intExtra = intent.getIntExtra("uintype", 1003);
        if (intExtra == 0 || intExtra == 1 || intExtra == 3000 || intExtra == 7) {
            z16 = true;
        }
        this.f183952h0 = z16;
        this.f183954j0 = intent.getStringExtra(QAlbumConstants.CUSTOM_SENDBTN_TEXT);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnDestroy();
        QQCustomDialog qQCustomDialog = this.f183955k0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f183955k0.hide();
        }
        this.f183955k0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.doOnPause();
            AbstractGifImage.pauseAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnResume();
            AbstractGifImage.resumeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (getIntent().getIntExtra("uintype", 1003) == 8000) {
            PhotoUtils.onSendResult(this, i3, i16, intent, getIntent().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", true));
            finish();
        } else {
            PhotoUtils.onSendResult(this, i3, i16, intent, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        initData();
        this.f183945a0 = (ViewGroup) getLayoutInflater().inflate(R.layout.f168379ud, (ViewGroup) null);
        M2();
        getLayoutInflater().inflate(R.layout.f168381uf, this.f183945a0);
        this.f183950f0 = getResources().getDisplayMetrics().widthPixels;
        this.f183951g0 = getResources().getDisplayMetrics().heightPixels;
        super.setContentView(this.f183945a0);
        if (this.f183952h0) {
            setRightButton(R.string.cv9, new a());
        }
        setTitle(R.string.d09);
        this.leftView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.leftViewNotBack = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.f183945a0.findViewById(R.id.photo_preview_right);
        QLog.d("IphoneTitleBarActivity", 2, "BUILD MODEL:" + DeviceInfoMonitor.getModel());
        String str = this.f183954j0;
        if (str != null) {
            textView2.setText(str);
            if (DeviceInfoMonitor.getModel().equals("PAFM00")) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, ViewUtils.dpToPx(12.0f), 0);
                layoutParams.addRule(11);
                textView2.setLayoutParams(layoutParams);
            }
        }
        textView2.setOnClickListener(new b());
        View findViewById = this.f183945a0.findViewById(R.id.photo_preview_left);
        if (DeviceInfoMonitor.getModel().equals("PAFM00")) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(9);
            layoutParams2.setMargins(ViewUtils.dpToPx(12.0f), 0, 0, 0);
            findViewById.setLayoutParams(layoutParams2);
        }
        findViewById.setOnClickListener(new c());
    }
}
