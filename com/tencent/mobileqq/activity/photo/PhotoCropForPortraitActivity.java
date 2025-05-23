package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.CommonMMKVUtils;
import cooperation.peak.PeakConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class PhotoCropForPortraitActivity extends PhotoCropActivity {
    static IPatchRedirector $redirector_;
    URLImageView V0;
    boolean W0;
    Button X0;
    CheckBox Y0;

    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropForPortraitActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = PhotoCropForPortraitActivity.this.getIntent();
                String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                int intExtra = intent.getIntExtra(PeakConstants.CLIP_WIDTH, 0);
                PhotoUtils.startPhotoListEdit(intent, PhotoCropForPortraitActivity.this, stringExtra, intExtra, intExtra, 1080, 1080, FaceUtil.getUploadAvatarTempPath());
                ReportController.o(PhotoCropForPortraitActivity.this.app, "dc00898", "", "", "0X800723F", "0X800723F", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropForPortraitActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoCropForPortraitActivity.this.Y0.setChecked(!r0.isChecked());
                PhotoCropForPortraitActivity photoCropForPortraitActivity = PhotoCropForPortraitActivity.this;
                photoCropForPortraitActivity.O0 = photoCropForPortraitActivity.Y0.isChecked();
                PhotoCropForPortraitActivity photoCropForPortraitActivity2 = PhotoCropForPortraitActivity.this;
                photoCropForPortraitActivity2.P0 = 2;
                ea.d4(photoCropForPortraitActivity2, photoCropForPortraitActivity2.getCurrentAccountUin(), PhotoCropForPortraitActivity.this.O0 ? 1 : 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropForPortraitActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoCropForPortraitActivity.this.f183992j0.setChecked(!r0.isChecked());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropForPortraitActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                CommonMMKVUtils.putBoolean("sp_key_portrait_photo_crop_is_sync_wink", z16, true);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class e implements IDynamicParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<PhotoCropForPortraitActivity> f184035a;

        public e(PhotoCropForPortraitActivity photoCropForPortraitActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoCropForPortraitActivity);
            } else {
                this.f184035a = new WeakReference<>(photoCropForPortraitActivity);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            HashMap hashMap = new HashMap();
            PhotoCropForPortraitActivity photoCropForPortraitActivity = this.f184035a.get();
            if (photoCropForPortraitActivity != null) {
                CheckBox s36 = photoCropForPortraitActivity.s3();
                CheckBox r36 = photoCropForPortraitActivity.r3();
                int i16 = 1;
                if (s36 != null && s36.isChecked()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (r36 == null || !r36.isChecked()) {
                    i16 = 0;
                }
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SYNC_QZONE, Integer.valueOf(i3));
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SYNC_XSJ, Integer.valueOf(i16));
                return hashMap;
            }
            return hashMap;
        }
    }

    public PhotoCropForPortraitActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.W0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CheckBox r3() {
        return this.f183992j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CheckBox s3() {
        return this.Y0;
    }

    private void t3() {
        RelativeLayout relativeLayout;
        if (!sa0.b.e() || (relativeLayout = (RelativeLayout) findViewById(R.id.f164624ac1)) == null) {
            return;
        }
        Button button = this.f183989g0;
        if (button != null) {
            button.setVisibility(8);
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.fr5, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BaseAIOUtils.f(20.0f, getResources());
        layoutParams.leftMargin = BaseAIOUtils.f(10.0f, getResources());
        layoutParams.rightMargin = BaseAIOUtils.f(10.0f, getResources());
        relativeLayout.addView(viewGroup, layoutParams);
        QUIButton qUIButton = (QUIButton) viewGroup.findViewById(R.id.uc8);
        this.f183992j0 = (CheckBox) viewGroup.findViewById(R.id.ubz);
        TextView textView = (TextView) viewGroup.findViewById(R.id.f164932uc0);
        textView.setText(com.dataline.util.j.d(getString(R.string.f199554pq)));
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.f164934uc2);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.f164933uc1);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams2.gravity = 8388613;
        linearLayout.setLayoutParams(layoutParams2);
        qUIButton.setOnClickListener(this);
        this.f183992j0.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView.setOnClickListener(new c());
        this.f183992j0.setOnCheckedChangeListener(new d());
        this.f183992j0.setChecked(CommonMMKVUtils.getBoolean("sp_key_portrait_photo_crop_is_sync_wink", false, true));
        VideoReport.setElementId(qUIButton, "em_photo_finish_button");
        VideoReport.setEventDynamicParams(qUIButton, new e(this));
        VideoReport.setElementClickPolicy(qUIButton, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(textView2, WinkDaTongReportConstant.ElementId.EM_BAS_PREVIEW);
        VideoReport.setElementClickPolicy(textView2, ClickPolicy.REPORT_ALL);
    }

    private void u3() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f164624ac1);
        if (relativeLayout == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.f168377ub, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BaseAIOUtils.f(20.0f, getResources());
        relativeLayout.addView(viewGroup, layoutParams);
        int f06 = ea.f0(this, getCurrentAccountUin());
        boolean z16 = true;
        if (f06 == -1) {
            try {
                this.P0 = 1;
                String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), IDPCApiConstant.HEAD_CONFIG_DEFAULT);
                if (QLog.isColorLevel()) {
                    QLog.i("PhotoCropActivity", 2, "initSyncQZoneUI, " + featureValueWithoutAccountManager);
                }
                String[] split = featureValueWithoutAccountManager.split("\\|");
                if (split.length > 2) {
                    f06 = Integer.parseInt(split[2]);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PhotoCropActivity", 2, "initSyncQZoneUI error", e16);
                }
                f06 = 1;
            }
        } else {
            this.P0 = 3;
        }
        if (f06 < 0) {
            f06 = 1;
        }
        CheckBox checkBox = (CheckBox) findViewById(R.id.j9q);
        this.Y0 = checkBox;
        if (f06 == 0) {
            z16 = false;
        }
        this.O0 = z16;
        checkBox.setChecked(z16);
        viewGroup.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.photo.PhotoCropActivity
    public void c3(String str, int i3, int i16, int i17, int i18, int i19) {
        String currentAccountUin = this.app.getCurrentAccountUin();
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(currentAccountUin), "PhotoCropActivity", new hx3.b<kx3.a>(currentAccountUin) { // from class: com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity.2
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f184024a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity$2$a */
            /* loaded from: classes10.dex */
            public class a extends Handler {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                boolean f184028a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ kx3.a f184029b;

                a(kx3.a aVar) {
                    this.f184029b = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) aVar);
                    }
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                        return;
                    }
                    if (1000 == message.what) {
                        this.f184028a = true;
                    } else if (!this.f184028a) {
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (PhotoCropForPortraitActivity.this.f183986d0.c() * 1.257d), (int) (PhotoCropForPortraitActivity.this.f183986d0.b() * 1.481d));
                    layoutParams.addRule(14);
                    layoutParams.topMargin = (int) ((PhotoCropForPortraitActivity.this.f183985c0.getHeight() * 0.5f) - ((r0 * 0.5f) * 1.705d));
                    PhotoCropForPortraitActivity photoCropForPortraitActivity = PhotoCropForPortraitActivity.this;
                    URLImageView uRLImageView = photoCropForPortraitActivity.V0;
                    if (uRLImageView == null) {
                        photoCropForPortraitActivity.V0 = new URLImageView(PhotoCropForPortraitActivity.this);
                        PhotoCropForPortraitActivity photoCropForPortraitActivity2 = PhotoCropForPortraitActivity.this;
                        photoCropForPortraitActivity2.f183985c0.addView(photoCropForPortraitActivity2.V0, layoutParams);
                    } else {
                        uRLImageView.setLayoutParams(layoutParams);
                    }
                    IPendantInfo pendantInfo = ((com.tencent.mobileqq.vas.b) PhotoCropForPortraitActivity.this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).getPendantInfo(this.f184029b.getPendantId());
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    pendantInfo.setDrawable(PhotoCropForPortraitActivity.this.V0, 1, PendantConstant.PENDANT_TARGET_ID_PHOTOCROP, anonymousClass2.f184024a, this.f184029b.getPendantDiyId());
                    PhotoCropForPortraitActivity.this.V0.setVisibility(0);
                }
            }

            {
                this.f184024a = currentAccountUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropForPortraitActivity.this, (Object) currentAccountUin);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b(kx3.a aVar) {
                PhotoCropForPortraitActivity.this.T0 = new a(aVar);
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<kx3.a> eVar) {
                kx3.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty() && (aVar = eVar.b().get(0)) != null && aVar.getPendantId() != 0 && PhotoCropForPortraitActivity.this.W0) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ kx3.a f184026d;

                        {
                            this.f184026d = aVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) aVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                b(this.f184026d);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        });
        super.c3(str, i3, i16, i17, i18, i19);
        if ((!sa0.b.c() || (!this.G0 && !this.H0)) && 100 == this.f184000r0) {
            u3();
            t3();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.PhotoCropActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.photo.PhotoCropActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.W0 = getIntent().getBooleanExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, true);
        boolean doOnCreate = super.doOnCreate(bundle);
        DeviceInfoMonitor.getModel().equals("M040");
        getWindow().setFlags(16777216, 16777216);
        if (getIntent().getBooleanExtra("open_chat_from_avator", false)) {
            Button button = (Button) super.findViewById(R.id.cqm);
            this.X0 = button;
            button.setVisibility(0);
            this.X0.setOnClickListener(new a());
        }
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.activity.photo.PhotoCropActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
