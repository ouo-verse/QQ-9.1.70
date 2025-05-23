package com.qzone.preview;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.media.QZoneQCircleMediaImpl;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.JarReflectUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import ho.i;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class LocalPictureViewer extends BasePictureViewer implements View.OnClickListener {
    public static final String J1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Composing", "\u6b63\u5728\u5408\u6210...");
    protected HashMap<String, int[]> A1;
    protected int B1;
    private int D1;
    private RelativeLayout E1;
    private TextView F1;
    private TextView G1;
    protected LocalPhotoLinearGradientView H1;
    private boolean I1;

    /* renamed from: a1, reason: collision with root package name */
    private int f49562a1;

    /* renamed from: b1, reason: collision with root package name */
    private View f49563b1;

    /* renamed from: c1, reason: collision with root package name */
    private View f49564c1;

    /* renamed from: d1, reason: collision with root package name */
    private TextView f49565d1;

    /* renamed from: e1, reason: collision with root package name */
    private CheckBox f49566e1;

    /* renamed from: f1, reason: collision with root package name */
    private ImageView f49567f1;

    /* renamed from: g1, reason: collision with root package name */
    private TextView f49568g1;

    /* renamed from: h1, reason: collision with root package name */
    private View f49569h1;

    /* renamed from: i1, reason: collision with root package name */
    private RelativeLayout f49570i1;

    /* renamed from: j1, reason: collision with root package name */
    private TextView f49571j1;

    /* renamed from: k1, reason: collision with root package name */
    private TextView f49572k1;

    /* renamed from: l1, reason: collision with root package name */
    private ImageView f49573l1;

    /* renamed from: m1, reason: collision with root package name */
    private LinearLayout f49574m1;

    /* renamed from: n1, reason: collision with root package name */
    private ImageView f49575n1;

    /* renamed from: o1, reason: collision with root package name */
    private RelativeLayout f49576o1;

    /* renamed from: p1, reason: collision with root package name */
    private TextView f49577p1;

    /* renamed from: q1, reason: collision with root package name */
    private ImageView f49578q1;

    /* renamed from: r1, reason: collision with root package name */
    private TextView f49579r1;

    /* renamed from: s1, reason: collision with root package name */
    private RelativeLayout f49580s1;

    /* renamed from: t1, reason: collision with root package name */
    private TextView f49581t1;

    /* renamed from: u1, reason: collision with root package name */
    private ImageView f49582u1;

    /* renamed from: v1, reason: collision with root package name */
    private TextView f49583v1;

    /* renamed from: w1, reason: collision with root package name */
    private RelativeLayout f49584w1;

    /* renamed from: x1, reason: collision with root package name */
    private TextView f49585x1;

    /* renamed from: y1, reason: collision with root package name */
    private ImageView f49586y1;

    /* renamed from: z1, reason: collision with root package name */
    private TextView f49587z1;
    private final String Z0 = "[PhotoAlbum]LocalPictureViewer";
    private String C1 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LocalPictureViewer.this.onBackPressed();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (LocalPictureViewer.this.s5()) {
                if (LocalPictureViewer.this.f49566e1.isChecked()) {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 3);
                } else {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 2);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QZLog.d("[PhotoAlbum]LocalPictureViewer", 2, "onCheckedChanged", Boolean.valueOf(z16));
            LocalPictureViewer.this.f49483l0.b().isSelected = z16;
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 999976) {
                LocalPictureViewer.this.f49480i0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f49592d;

        e(PhotoInfo photoInfo) {
            this.f49592d = photoInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LocalPictureViewer.this.z5(this.f49592d);
            LocalPictureViewer localPictureViewer = LocalPictureViewer.this;
            localPictureViewer.f49480i0 = false;
            if (localPictureViewer.f49483l0.getCount() == 0) {
                LocalPictureViewer.this.w4();
            } else {
                LocalPictureViewer.this.notifyDataSetChanged();
            }
        }
    }

    private void B5(PhotoInfo photoInfo, String str) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064("1000", str);
        lpReportInfo_pf00064.reserves = l5(photoInfo);
        lpReportInfo_pf00064.reserves2 = k5(getIntent()) + "";
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void E5(PhotoInfo photoInfo) {
        if ((URLUtil.isNetworkUrl(photoInfo.bigUrl) || photoInfo.videodata != null || photoInfo.photoType == 2 || this.f49483l0.A == 0) && !photoInfo.needShowFaceIcon) {
            this.f49575n1.setVisibility(8);
        } else {
            this.f49575n1.setVisibility(0);
        }
    }

    private void F5() {
        ArrayList<String> arrayList = new ArrayList<>();
        PhotoInfo[] P = this.f49483l0.P();
        if (P == null || P.length <= 0) {
            return;
        }
        PhotoInfo photoInfo = P[0];
        for (PhotoInfo photoInfo2 : P) {
            if (photoInfo.date < photoInfo2.date) {
                photoInfo = photoInfo2;
            }
            arrayList.add(photoInfo2.bigUrl);
        }
        Intent D = ak.D(this, 0, null, null, 14);
        D.putStringArrayListExtra("QZoneUploadPhotoActivity.key_selected_image_path", arrayList);
        D.putExtra("QZoneUploadPhotoActivity.key_gps_info", photoInfo.gpsInfo);
        D.putExtra("IsBack", false);
        D.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 6);
        if (lc.b.d()) {
            i.x().l(this, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, false, null, 0), D);
        } else {
            i.w().h(this, new QZonePublishMoodInitBean(System.currentTimeMillis()), D);
        }
        setResult(-1);
        finish();
    }

    private void G5() {
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 == null || TextUtils.isEmpty(b16.bigUrl)) {
            return;
        }
        if (b16.bigUrl.equals(b16.orgUrl)) {
            this.f49567f1.setImageDrawable(getResources().getDrawable(R.drawable.fxw));
        } else {
            this.f49567f1.setImageDrawable(getResources().getDrawable(R.drawable.fxx));
        }
    }

    private void H5() {
        if (this.f49483l0.getCount() > 1) {
            this.f49572k1.setVisibility(0);
            this.f49572k1.setText((this.f49483l0.getSelectedIndex() + 1) + "/" + this.f49483l0.getCount());
            return;
        }
        this.f49572k1.setVisibility(8);
    }

    private void I5() {
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 != null) {
            this.f49566e1.setChecked(b16.isSelected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f5() {
        RelativeLayout relativeLayout;
        if (Build.VERSION.SDK_INT > 23 || (relativeLayout = this.f49570i1) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        QLog.d("[PhotoAlbum]LocalPictureViewer", 1, "status_height = " + ImmersiveUtils.getStatusBarHeight(getActivity()));
    }

    private void g5(PhotoInfo photoInfo) {
        com.qzone.component.e eVar = new com.qzone.component.e();
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleDeleteVideo", "\u8981\u5220\u9664\u8fd9\u4e2a\u89c6\u9891\u5417\uff1f");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleDeleteVideo", "\u8981\u5220\u9664\u8fd9\u5f20\u7167\u7247\u5417\uff1f");
        if (photoInfo != null && photoInfo.videodata != null) {
            config2 = config;
        }
        eVar.g(this, config2, null, new e(photoInfo), null);
    }

    private TopGestureLayout h5() {
        View childAt;
        if (getWindow() == null || getWindow().getDecorView() == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        if (viewGroup.getChildCount() == 0 || (childAt = viewGroup.getChildAt(0)) == null || !(childAt instanceof TopGestureLayout)) {
            return null;
        }
        return (TopGestureLayout) childAt;
    }

    public static QZoneMediaBusiness j5(Intent intent) {
        QZoneMediaBusiness qZoneMediaBusiness = QZoneMediaBusiness.QZONE_SHUOSHUO_PERVIEW;
        return (intent != null && k5(intent) == 2) ? QZoneMediaBusiness.QZONE_ALBUM_PERVIEW : qZoneMediaBusiness;
    }

    private int l5(PhotoInfo photoInfo) {
        return photoInfo.videodata != null ? 2 : 1;
    }

    private boolean p5(PhotoInfo photoInfo) {
        if (photoInfo.isVideo()) {
            return false;
        }
        float f16 = photoInfo.heightWeightProportion;
        return f16 < 0.4f || f16 > 2.6666667f;
    }

    private boolean r5() {
        int i56 = i5();
        if (i56 != -1) {
            if (i56 != 1) {
                return true;
            }
            return QZoneQCircleMediaImpl.w();
        }
        if (QZonePublishConfig.isUseQCirclePublish()) {
            return QZoneQCircleMediaImpl.w();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s5() {
        return getIntent() != null && getIntent().getIntExtra("source_from", 0) == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t5() {
        Window window = getWindow();
        if (window != null) {
            com.tencent.biz.qui.quicommon.b.b(window);
        }
    }

    private void x5() {
        if (this.f49483l0.f49896z) {
            this.f49575n1.setImageDrawable(getResources().getDrawable(R.drawable.fwd));
            this.f49483l0.f49896z = false;
            this.G0.l().K();
            this.G0.l().h();
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 2, 2);
            return;
        }
        this.f49575n1.setImageDrawable(getResources().getDrawable(R.drawable.fwc));
        this.f49483l0.f49896z = true;
        this.G0.l().K();
        this.G0.l().h();
        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 2, 1);
    }

    private void y5() {
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 != null) {
            if (b16.bigUrl.equals(b16.orgUrl)) {
                b16.bigUrl = b16.currentUrl;
                this.f49567f1.setImageDrawable(getResources().getDrawable(R.drawable.fxx));
                QZLog.d("[PhotoAlbum]LocalPictureViewer", 2, "performToggleOriginalImage", " use beautified image");
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 5);
            } else {
                b16.bigUrl = b16.orgUrl;
                QZLog.d("[PhotoAlbum]LocalPictureViewer", 2, "performToggleOriginalImage", " use original image");
                this.f49567f1.setImageDrawable(getResources().getDrawable(R.drawable.fxw));
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 4);
            }
            this.G0.l().K();
            notifyDataSetChanged();
        }
    }

    @Override // com.qzone.preview.BasePictureViewer
    protected void C4() {
        String str;
        if (this.f49563b1 == null) {
            n5();
        }
        if (this.f49564c1 == null && (BasePictureViewer.X0 == 7 || s5())) {
            m5();
            if (this.f49564c1 != null && s5()) {
                this.f49564c1.setBackgroundColor(0);
            }
        }
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 != null) {
            if (s5()) {
                G5();
            } else {
                D5(b16, b16.isSelected);
                E5(b16);
                VideoInfo videoInfo = b16.videodata;
                if (videoInfo != null && (str = videoInfo.toast) != null && str.equals(J1)) {
                    this.f49569h1.setVisibility(0);
                } else {
                    this.f49569h1.setVisibility(8);
                }
            }
            B5(b16, "1");
        }
        I5();
        H5();
        String str2 = b16.bigUrl;
        if (this.D1 != this.f49483l0.getSelectedIndex() && s5()) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 1);
        }
        this.D1 = this.f49483l0.getSelectedIndex();
        TopGestureLayout h56 = h5();
        if (h56 != null) {
            h56.setInterceptScrollLRFlag(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer
    public void D4(Bundle bundle) {
        super.D4(bundle);
        if (BasePictureViewer.X0 == 7) {
            this.f49480i0 = false;
            this.f49481j0 = false;
        }
        this.f49562a1 = bundle.getInt(PictureConst.KEY_DEL_TYPE, 0);
        if (bundle.getInt(PictureConst.KEY_EDIT_BTN_TYPE, 0) == 1) {
            this.I1 = true;
        } else {
            this.I1 = false;
        }
        HashMap<String, int[]> hashMap = (HashMap) bundle.getSerializable(PictureConst.KEY_MARKER_RESULT);
        this.A1 = hashMap;
        if (hashMap == null) {
            this.A1 = new HashMap<>();
        }
        this.B1 = bundle.getInt(PictureConst.KEY_SELECT_PICTURE_NUM);
        String string = bundle.getString(PictureConst.KEY_CLASSNAME);
        this.C1 = string;
        this.H0 = true;
        if (QZoneHelper.UPLOAD_PHOTO.equals(string)) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 1, 2);
        } else if (!((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName().equals(this.C1) && !"com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(this.C1)) {
            if ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(this.C1)) {
                this.I1 = true;
            }
        } else {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 1, 1);
        }
        this.D1 = this.f49483l0.getSelectedIndex();
        if (s5()) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 0);
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void d1(boolean z16) {
        if (this.f49575n1 == null || this.f49574m1 == null) {
            return;
        }
        boolean isPanorama = this.f49483l0.b() != null ? this.f49483l0.b().isPanorama() : false;
        boolean s56 = s5();
        this.f49575n1.setVisibility((!z16 || isPanorama || s56) ? 8 : 0);
        this.f49574m1.setVisibility((!z16 || isPanorama || s56) ? 8 : 0);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null) {
            basePicureViewController.R0(intent);
        }
        setResult(-1, intent);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.preview.c
            @Override // java.lang.Runnable
            public final void run() {
                LocalPictureViewer.this.t5();
            }
        });
        super.finish();
        if (PlatformUtil.version() >= 7) {
            if (BasePictureViewer.X0 != 7 && this.f49480i0) {
                overridePendingTransition(R.anim.f155024h1, R.anim.f155023h0);
            } else {
                overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
            }
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public boolean h9() {
        return false;
    }

    public int i5() {
        Intent intent = getIntent();
        if (intent == null) {
            return 0;
        }
        return intent.getIntExtra("KEY_MEDIA_PLATFORM_TYPE", -1);
    }

    protected void m5() {
        View inflate = this.f49472a0.inflate(R.layout.boy, (ViewGroup) null);
        this.f49564c1 = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.k6q);
        this.f49565d1 = textView;
        textView.setOnClickListener(this);
        this.f49564c1.setVisibility(0);
        l3(this.f49564c1);
    }

    protected void n5() {
        View inflate = this.f49472a0.inflate(R.layout.box, (ViewGroup) null);
        this.f49563b1 = inflate;
        this.f49570i1 = (RelativeLayout) inflate.findViewById(R.id.f166717hk4);
        runOnUiThread(new Runnable() { // from class: com.qzone.preview.LocalPictureViewer.1
            @Override // java.lang.Runnable
            public void run() {
                int notchHeight = SystemUtil.getNotchHeight(LocalPictureViewer.this.getOutActivity(), LocalPictureViewer.this.getActivity());
                LocalPictureViewer.this.f49570i1.getLayoutParams().height = LocalPictureViewer.this.f49570i1.getLayoutParams().height + notchHeight + ViewUtils.dip2px(10.0f);
                LocalPictureViewer.this.f5();
                LocalPictureViewer.this.f49570i1.setPadding(LocalPictureViewer.this.f49570i1.getPaddingLeft(), LocalPictureViewer.this.f49570i1.getPaddingTop() + notchHeight, LocalPictureViewer.this.f49570i1.getPaddingRight(), LocalPictureViewer.this.f49570i1.getPaddingBottom());
                QZLog.d("[PhotoAlbum]LocalPictureViewer", 2, "notchHeight = ", Integer.valueOf(notchHeight));
            }
        });
        TextView textView = (TextView) this.f49563b1.findViewById(R.id.f166714hk1);
        this.f49571j1 = textView;
        textView.setOnClickListener(new a());
        this.f49572k1 = (TextView) this.f49563b1.findViewById(R.id.f166716hk3);
        if (Build.VERSION.SDK_INT >= 27) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            Field field = JarReflectUtil.getField(attributes, "layoutInDisplayCutoutMode");
            if (field != null) {
                try {
                    if (getResources().getConfiguration().orientation == 1) {
                        field.setInt(attributes, 1);
                    } else {
                        field.setInt(attributes, 2);
                    }
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                }
            }
            getWindow().setAttributes(attributes);
        }
        this.f49576o1 = (RelativeLayout) this.f49563b1.findViewById(R.id.emu);
        this.f49577p1 = (TextView) this.f49563b1.findViewById(R.id.f166187en2);
        this.f49578q1 = (ImageView) this.f49563b1.findViewById(R.id.emq);
        this.f49579r1 = (TextView) this.f49563b1.findViewById(R.id.emy);
        this.f49577p1.setOnClickListener(this);
        this.f49579r1.setOnClickListener(this);
        this.f49579r1.setVisibility(8);
        this.f49578q1.setOnClickListener(this);
        this.f49580s1 = (RelativeLayout) this.f49563b1.findViewById(R.id.emv);
        this.f49581t1 = (TextView) this.f49563b1.findViewById(R.id.f166188en3);
        this.f49582u1 = (ImageView) this.f49563b1.findViewById(R.id.emr);
        this.f49583v1 = (TextView) this.f49563b1.findViewById(R.id.emz);
        this.f49581t1.setOnClickListener(this);
        this.f49583v1.setOnClickListener(this);
        this.f49583v1.setVisibility(8);
        this.f49582u1.setOnClickListener(this);
        this.f49584w1 = (RelativeLayout) this.f49563b1.findViewById(R.id.emw);
        this.f49585x1 = (TextView) this.f49563b1.findViewById(R.id.f166189en4);
        this.f49586y1 = (ImageView) this.f49563b1.findViewById(R.id.ems);
        this.f49587z1 = (TextView) this.f49563b1.findViewById(R.id.f166185en0);
        this.f49585x1.setOnClickListener(this);
        this.f49587z1.setOnClickListener(this);
        this.f49587z1.setVisibility(8);
        this.f49586y1.setOnClickListener(this);
        ImageView imageView = (ImageView) this.f49563b1.findViewById(R.id.bf5);
        this.f49573l1 = imageView;
        imageView.setContentDescription(l.a(R.string.ajx));
        this.f49568g1 = (TextView) this.f49563b1.findViewById(R.id.f165047bs3);
        if (!r5()) {
            QZLog.e("[PhotoAlbum]LocalPictureViewer", "IAECameraLauncher.isCameraResReady is false");
            this.f49568g1.setVisibility(8);
        }
        CheckBox checkBox = (CheckBox) this.f49563b1.findViewById(R.id.imr);
        this.f49566e1 = checkBox;
        checkBox.setOnClickListener(new b());
        this.f49566e1.setOnCheckedChangeListener(new c());
        ImageView imageView2 = (ImageView) this.f49563b1.findViewById(R.id.jsl);
        this.f49567f1 = imageView2;
        imageView2.setOnClickListener(this);
        View findViewById = this.f49563b1.findViewById(R.id.fuz);
        this.f49569h1 = findViewById;
        findViewById.setOnClickListener(this);
        this.f49573l1.setOnClickListener(this);
        this.f49574m1 = (LinearLayout) this.f49563b1.findViewById(R.id.c0z);
        ImageView imageView3 = (ImageView) this.f49563b1.findViewById(R.id.c0y);
        this.f49575n1 = imageView3;
        if (this.f49483l0.f49896z) {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.fwc));
        } else {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.fwd));
        }
        PhotoInfo F = this.f49483l0.F();
        if (F != null) {
            this.f49575n1.setVisibility((!F.needShowFaceIcon || F.isPanorama()) ? 8 : 0);
            this.f49574m1.setVisibility((!F.needShowFaceIcon || F.isPanorama()) ? 8 : 0);
        }
        this.f49575n1.setOnClickListener(this);
        this.f49574m1.setOnClickListener(this);
        this.E1 = (RelativeLayout) this.f49563b1.findViewById(R.id.her);
        this.F1 = (TextView) this.f49563b1.findViewById(R.id.heq);
        this.G1 = (TextView) this.f49563b1.findViewById(R.id.hep);
        this.H1 = (LocalPhotoLinearGradientView) this.f49563b1.findViewById(R.id.htr);
        this.H1.setShader(new LinearGradient(0.0f, ViewUtils.dip2px(79.0f), 0.0f, 0.0f, -14869219, 0, Shader.TileMode.CLAMP));
        this.F1.setOnClickListener(this);
        this.G1.setOnClickListener(this);
        int i3 = this.f49562a1;
        if (i3 == 0) {
            this.f49573l1.setVisibility(8);
            this.f49570i1.setVisibility(8);
        } else if (i3 == 1) {
            this.f49573l1.setVisibility(0);
            this.f49570i1.setVisibility(0);
        } else if (i3 != 2) {
            if (i3 == 4) {
                this.f49570i1.setVisibility(8);
                this.f49563b1.findViewById(R.id.f166715hk2).setVisibility(8);
                this.E1.setVisibility(0);
            }
        } else if (s5()) {
            this.f49568g1.setVisibility(8);
            this.f49573l1.setVisibility(8);
            this.f49566e1.setVisibility(0);
            this.f49567f1.setVisibility(0);
            this.f49574m1.setVisibility(8);
        }
        n3(this.f49563b1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        PhotoInfo b16 = this.f49483l0.b();
        int id5 = view.getId();
        if (id5 == R.id.jsl) {
            y5();
        } else if (id5 == R.id.bf5) {
            g5(b16);
        } else if (id5 == R.id.k6q) {
            if (s5()) {
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 6);
                setResult(-1);
                finish();
            } else {
                F5();
            }
        } else if (id5 == R.id.f165047bs3) {
            w5(b16);
        } else if (id5 == R.id.fuz) {
            ToastUtil.r(J1);
        } else if (id5 == R.id.f166187en2) {
            this.f49576o1.setBackgroundDrawable(null);
            this.f49576o1.setPadding(0, 0, 0, 0);
            this.f49577p1.setVisibility(8);
            this.f49578q1.setVisibility(8);
        } else if (id5 == R.id.emy) {
            this.f49579r1.setVisibility(8);
            this.f49576o1.setBackgroundResource(R.drawable.g8m);
            this.f49577p1.setVisibility(0);
            this.f49578q1.setVisibility(0);
        } else if (id5 == R.id.emq) {
            this.f49576o1.setVisibility(8);
            A5(b16, this.f49577p1.getText().toString());
        } else if (id5 == R.id.f166188en3) {
            this.f49580s1.setBackgroundDrawable(null);
            this.f49580s1.setPadding(0, 0, 0, 0);
            this.f49581t1.setVisibility(8);
            this.f49582u1.setVisibility(8);
        } else if (id5 == R.id.emz) {
            this.f49583v1.setVisibility(8);
            this.f49580s1.setBackgroundResource(R.drawable.g8m);
            this.f49581t1.setVisibility(0);
            this.f49582u1.setVisibility(0);
        } else if (id5 == R.id.emr) {
            this.f49580s1.setVisibility(8);
            A5(b16, this.f49581t1.getText().toString());
        } else if (id5 == R.id.f166189en4) {
            this.f49584w1.setBackgroundDrawable(null);
            this.f49584w1.setPadding(0, 0, 0, 0);
            this.f49585x1.setVisibility(8);
            this.f49586y1.setVisibility(8);
        } else if (id5 == R.id.f166185en0) {
            this.f49587z1.setVisibility(8);
            this.f49584w1.setBackgroundResource(R.drawable.g8m);
            this.f49585x1.setVisibility(0);
            this.f49586y1.setVisibility(0);
        } else if (id5 == R.id.ems) {
            this.f49584w1.setVisibility(8);
            A5(b16, this.f49585x1.getText().toString());
        } else if (id5 == R.id.c0z || id5 == R.id.c0y) {
            x5();
        } else if (id5 == R.id.hep) {
            Intent intent = getIntent();
            intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 0);
            setResult(2, intent);
            super.finish();
            LpReportInfo_pf00064.allReport(586, 47, 4);
        } else if (id5 == R.id.heq) {
            setResult(3);
            super.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 27) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            Field field = JarReflectUtil.getField(attributes, "layoutInDisplayCutoutMode");
            if (field != null) {
                try {
                    if (configuration.orientation == 1) {
                        field.setInt(attributes, 1);
                    } else {
                        field.setInt(attributes, 2);
                    }
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                }
            }
            getWindow().setAttributes(attributes);
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        Bundle bundle = unpack.getBundle();
        if (message.what != 1000191) {
            return;
        }
        ArrayList<FaceData> arrayList = (ArrayList) bundle.getSerializable("data");
        String string = bundle.getString(PictureConst.PARAM_FACE_PIC_LLOC);
        if (arrayList != null) {
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "lloc:", string, " faceDatas size:", Integer.valueOf(arrayList.size()), " faceData:", arrayList.toString());
            this.f49483l0.S0(arrayList, string, true);
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void w1() {
        super.w1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer
    public boolean w4() {
        if (BasePictureViewer.X0 != 7 && this.f49480i0) {
            return super.w4();
        }
        finish();
        return true;
    }

    private void D5(PhotoInfo photoInfo, boolean z16) {
        VideoInfo videoInfo;
        String str;
        if (z16 && !URLUtil.isNetworkUrl(photoInfo.bigUrl) && r5() && (((videoInfo = photoInfo.videodata) == null || (str = videoInfo.toast) == null || !str.equals(J1)) && photoInfo.photoType != 2 && !this.I1 && !p5(photoInfo))) {
            this.f49568g1.setEnabled(true);
            this.f49568g1.setVisibility(0);
            this.f49568g1.setOnClickListener(this);
        } else {
            this.f49568g1.setEnabled(false);
            this.f49568g1.setVisibility(8);
            this.f49568g1.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z5(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        String str = photoInfo.bigUrl;
        this.f49483l0.v();
        B5(photoInfo, "3");
        PictureManager.getInstance().getSender().delLocalPhoto(new d(), str);
    }

    private static int k5(Intent intent) {
        if (intent == null) {
            return 1;
        }
        return intent.getIntExtra(WinkPreviewFragment.ENTRY_FROM, 1);
    }

    private void w5(PhotoInfo photoInfo) {
        long j3;
        long j16;
        String[] split;
        LpReportInfo_pf00064.allReport(603, 4, 2);
        B5(photoInfo, "2");
        int i56 = i5();
        if (i56 != 0 && i56 != -1) {
            com.qzone.common.business.service.b.f().k(getOutActivity(), photoInfo, j5(getIntent()), i56);
            return;
        }
        Intent intent = getIntent();
        if (photoInfo.photoType == 2 && intent.getIntExtra("source_from", 0) == 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(photoInfo.bigUrl);
            QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
            Boolean bool = Boolean.TRUE;
            qZonePublishMoodInitBean.u0(bool);
            qZonePublishMoodInitBean.v0(bool);
            qZonePublishMoodInitBean.y0(arrayList);
            i.w().c(this, qZonePublishMoodInitBean);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.C1) && photoInfo.videodata == null) {
            Intent newPictureEditIntentWithoutPublish = ((IEditPicForQzone) QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this, this.f49483l0.b().bigUrl);
            newPictureEditIntentWithoutPublish.setClass(BaseApplication.getContext(), ((IAEClassManager) QRoute.api(IAEClassManager.class)).getArtFilterBridgeActivityClass());
            newPictureEditIntentWithoutPublish.putExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, this.C1);
            newPictureEditIntentWithoutPublish.putExtra("onClickPhotoPlus", this.f49483l0.getSelectedIndex());
            newPictureEditIntentWithoutPublish.putExtra("isEnterPhotoPlus", true);
            QzonePluginProxyActivity.setActivityNameToIntent(newPictureEditIntentWithoutPublish, this.C1);
            newPictureEditIntentWithoutPublish.putExtra("cleartop", true);
            newPictureEditIntentWithoutPublish.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
            newPictureEditIntentWithoutPublish.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
            newPictureEditIntentWithoutPublish.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
            newPictureEditIntentWithoutPublish.putExtra(PeakConstants.DIRECT_BACK_TO_QZONE, true);
            newPictureEditIntentWithoutPublish.putExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 8);
            startActivityForResult(newPictureEditIntentWithoutPublish, 1001);
            return;
        }
        VideoInfo videoInfo = photoInfo.videodata;
        if (videoInfo != null && videoInfo.videoUrl != null) {
            Intent intent2 = new Intent(BaseApplication.getContext(), (Class<?>) EditLocalVideoActivity.class);
            intent2.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
            intent2.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
            intent2.putExtra(PeakConstants.DIRECT_BACK_TO_QZONE, true);
            intent2.putExtra("qzone_plugin_activity_name", this.C1);
            intent2.putExtra("short_video_refer", getClass().getName());
            intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_ENTRY, 1);
            intent2.putExtra("file_send_path", photoInfo.videodata.videoUrl.url);
            intent2.putExtra(PeakConstants.VIDEO_SIZE, photoInfo.videodata.originVideoSize);
            intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, photoInfo.videodata.videoTime);
            intent2.putExtra(ShortVideoConstants.FILE_WIDTH, photoInfo.videodata.width);
            intent2.putExtra(ShortVideoConstants.FILE_HEIGHT, photoInfo.videodata.height);
            if (!TextUtils.isEmpty(photoInfo.videodata.videoId) && photoInfo.videodata.videoId.contains("local")) {
                long j17 = 0;
                try {
                    split = photoInfo.videodata.videoId.split("[#]");
                } catch (Exception e16) {
                    e = e16;
                    j3 = 0;
                }
                if (split.length == 3) {
                    j3 = Long.parseLong(split[1]);
                    try {
                        j16 = Long.parseLong(split[2]);
                    } catch (Exception e17) {
                        e = e17;
                        if (QZLog.isColorLevel()) {
                            QZLog.d("[PhotoAlbum]LocalPictureViewer", 2, "localpicviewer goto editlocalvideo " + e);
                        }
                        j16 = 0;
                        j17 = j3;
                        intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_START_TIME, j17);
                        intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_END_TIME, j17 + j16);
                        intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_DURATION, j16);
                        startActivityForResult(intent2, 1001);
                        return;
                    }
                    j17 = j3;
                    intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_START_TIME, j17);
                    intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_END_TIME, j17 + j16);
                    intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_DURATION, j16);
                } else {
                    j16 = 0;
                    intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_START_TIME, j17);
                    intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_END_TIME, j17 + j16);
                    intent2.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_DURATION, j16);
                }
            }
            startActivityForResult(intent2, 1001);
            return;
        }
        intent.putExtra(PeakConstants.SELECT_INDEX, this.f49483l0.getSelectedIndex());
        setResult(1, intent);
        finish();
    }

    private void A5(PhotoInfo photoInfo, String str) {
    }
}
