package cooperation.qqfav.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.a;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LocationDetailActivity extends PoiMapActivity {
    private IColorNoteController B1;

    /* renamed from: q1, reason: collision with root package name */
    public String f390673q1;

    /* renamed from: r1, reason: collision with root package name */
    public String f390674r1;

    /* renamed from: s1, reason: collision with root package name */
    public String f390675s1;

    /* renamed from: x1, reason: collision with root package name */
    public cooperation.qqfav.widget.a f390680x1;

    /* renamed from: t1, reason: collision with root package name */
    public long f390676t1 = -1;

    /* renamed from: u1, reason: collision with root package name */
    public TextView f390677u1 = null;

    /* renamed from: v1, reason: collision with root package name */
    public String f390678v1 = null;

    /* renamed from: w1, reason: collision with root package name */
    public ImageView f390679w1 = null;

    /* renamed from: y1, reason: collision with root package name */
    public boolean f390681y1 = false;

    /* renamed from: z1, reason: collision with root package name */
    private FadeIconImageView f390682z1 = null;
    private boolean A1 = false;
    private boolean C1 = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LocationDetailActivity.this.onBackPressed();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b extends cooperation.qqfav.widget.a {
        b(Activity activity, a.b bVar, int i3, int i16, AppRuntime appRuntime) {
            super(activity, bVar, i3, i16, appRuntime);
        }

        @Override // cooperation.qqfav.widget.a, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("PoiMapActivity", 4, "mFavActionSheet onClick");
            if (LocationDetailActivity.this.A1) {
                QfavUtil.N(true);
                if (LocationDetailActivity.this.f390682z1 != null) {
                    LocationDetailActivity.this.f390682z1.setVisibility(8);
                }
            }
            super.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LocationDetailActivity.this.Q3();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LocationDetailActivity.this.X3(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e implements ha1.a {
        e() {
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            LocationDetailActivity.this.superFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class f extends com.tencent.mobileqq.colornote.g {
        f() {
        }

        @Override // com.tencent.mobileqq.colornote.g
        public void onAddColorNote(Bundle bundle, boolean z16) {
            super.onAddColorNote(bundle, z16);
            QLog.e("PoiMapActivity", 1, "[ColorNote exit]");
            if (LocationDetailActivity.this.f390681y1) {
                ReportController.o(null, "dc00898", "", "", "0X800A991", "0X800A991", 4, 0, "", "", "", "");
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A990", "0X800A990", 4, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    protected static class g extends a.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<LocationDetailActivity> f390688a;

        public g(LocationDetailActivity locationDetailActivity) {
            this.f390688a = new WeakReference<>(locationDetailActivity);
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void d(Bundle bundle) {
            super.d(bundle);
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity == null) {
                return;
            }
            locationDetailActivity.S3(bundle);
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void e() {
            String str;
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity == null) {
                return;
            }
            if (!cooperation.qqfav.util.a.c()) {
                Intent intentForStartForwardRecentActivity = locationDetailActivity.getIntentForStartForwardRecentActivity();
                if (intentForStartForwardRecentActivity != null) {
                    ForwardBaseOption.startForwardActivityForResult(locationDetailActivity, intentForStartForwardRecentActivity, 103);
                    return;
                } else {
                    QQToast.makeText(locationDetailActivity, R.string.b47, 1, 2000).show(5);
                    return;
                }
            }
            if (locationDetailActivity.getIntent() != null) {
                str = locationDetailActivity.getIntent().getStringExtra("fav_uuid");
            } else {
                str = "";
            }
            cooperation.qqfav.util.a.e(((AppActivity) locationDetailActivity).mRuntime, locationDetailActivity, str, null);
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void h() {
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity != null) {
                locationDetailActivity.V3();
            }
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void j() {
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity == null) {
                return;
            }
            locationDetailActivity.t2();
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public int m() {
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity != null) {
                return locationDetailActivity.getActionTypes();
            }
            return 0;
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void o() {
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity != null) {
                locationDetailActivity.moveToGroup();
            }
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void s() {
            LocationDetailActivity locationDetailActivity = this.f390688a.get();
            if (locationDetailActivity != null && locationDetailActivity.s()) {
                locationDetailActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q3() {
        setResult(-1, super.getLocationData());
        finish();
    }

    private void U3() {
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.B1 = iColorNoteController;
        iColorNoteController.init(this, true, false, true, true, 0);
        this.B1.setServiceInfo(T3(false));
        this.B1.attachToActivity(this);
        this.B1.setOnColorNoteAnimFinishListener(new e());
        this.B1.setOnColorNoteCurdListener(new f());
        boolean R3 = R3();
        if (!R3) {
            this.B1.disablePostTable();
        } else {
            this.B1.enablePostTable();
        }
        if (QLog.isColorLevel()) {
            QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + R3 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V3() {
        cooperation.qqfav.d.c(null, "User_Modify", 7, 0, getIntent().getIntExtra("category", 1));
        QfavHelper.h(this, "", this.f390676t1);
        super.finish();
    }

    @TargetApi(11)
    private void W3() {
        if (this.f390677u1 == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f390678v1)) {
            this.f390677u1.setVisibility(8);
            return;
        }
        this.f390677u1.setVisibility(0);
        if (VersionUtils.isHoneycomb()) {
            this.f390677u1.setAlpha(0.9f);
        }
        this.f390677u1.setText(new QQText(this.f390678v1, 3, 22));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getActionTypes() {
        int i3;
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null && iColorNoteController.isColorNoteExist()) {
            i3 = 256;
        } else {
            i3 = 128;
        }
        return i3 | 80;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getIntentForStartForwardRecentActivity() {
        if (this.f390673q1 != null && this.f390674r1 != null) {
            Intent locationData = getLocationData();
            locationData.putExtra("forward_type", -2).putExtra(AppConstants.Key.FORWARD_LATITUDE, locationData.getStringExtra("latitude")).putExtra(AppConstants.Key.FORWARD_LONGITUDE, locationData.getStringExtra("longitude")).putExtra(AppConstants.Key.FORWARD_LOCATION, this.mCurPoiAdr).putExtra(AppConstants.Key.FORWARD_LOCATION_STRING, this.mCurPoiAdr).putExtra(AppConstants.Key.FORWARD_THUMB, AppConstants.PATH_LOCATION_IMG + this.f390673q1 + "_" + this.f390674r1 + ".png").putExtra("isFromFavorites", true).putExtra("title", this.mCurPoiName).putExtra("summary", this.mCurPoiAdr);
            return locationData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToGroup() {
        QfavHelper.w(this, "", this.f390676t1, 0L);
    }

    protected boolean R3() {
        return true;
    }

    protected void S3(Bundle bundle) {
        String str;
        if (cooperation.qqfav.util.a.c()) {
            if (getIntent() != null) {
                str = getIntent().getStringExtra("fav_uuid");
            } else {
                str = "";
            }
            cooperation.qqfav.util.a.e(this.mRuntime, this, str, bundle);
            return;
        }
        Intent intentForStartForwardRecentActivity = getIntentForStartForwardRecentActivity();
        if (intentForStartForwardRecentActivity != null) {
            intentForStartForwardRecentActivity.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(getActivity(), intentForStartForwardRecentActivity, (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_shoucang");
        } else {
            QQToast.makeText(this, R.string.b47, 1, 2000).show(5);
        }
    }

    public com.tencent.mobileqq.colornote.f T3(boolean z16) {
        return new cooperation.qqfav.widget.b(this, Long.valueOf(this.f390676t1));
    }

    protected void X3(boolean z16) {
        int i3;
        Intent locationData = super.getLocationData();
        Intent intent = new Intent(super.getIntent());
        intent.putExtras(locationData);
        intent.putExtra("modify", z16);
        intent.putExtra("favId", this.f390676t1);
        intent.putExtra("note", this.f390678v1);
        intent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
        String stringExtra = intent.getStringExtra(PluginStatic.PARAM_UIN);
        if (z16) {
            i3 = 13322;
        } else {
            i3 = 13321;
        }
        QfavHelper.D(this, stringExtra, intent, i3);
    }

    @Override // com.tencent.biz.PoiMapActivity, com.tencent.mobileqq.activity.QQMapActivity, com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null) {
            long j3 = this.f390676t1;
            if (j3 != -1 && j3 != 0) {
                iColorNoteController.addHistoryNote();
            }
        }
        super.finish();
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void initImmersive() {
        RFWImmersiveUtils.setTransparentStatusBar(getWindow());
        RFWImmersiveUtils.setImmersiveLayout(getWindow(), false);
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity
    protected void initTitleBar() {
        Bundle extras = super.getIntent().getExtras();
        this.f390675s1 = extras.getString("loc");
        this.f390673q1 = extras.getString(QCircleSchemeAttr.Polymerize.LAT);
        this.f390674r1 = extras.getString("lon");
        this.f390676t1 = extras.getLong("favId");
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_text_nav_secondary_selector);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        textView.setText(R.string.b4t);
        textView.setTextColor(colorStateList);
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) super.findViewById(R.id.ivTitleName);
        textView2.setText(R.string.f171092c60);
        TextView textView3 = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        textView3.setTextColor(colorStateList);
        boolean booleanExtra = super.getIntent().getBooleanExtra("forNoteNewFavorite", false);
        this.C1 = booleanExtra;
        if (!booleanExtra && !extras.getBoolean("forNewFavorite", false)) {
            this.f390680x1 = new b(this, new g(this), getActionTypes(), 7, null);
            textView.setText(extras.getString(AppConstants.LeftViewText.LEFTVIEWTEXT));
            textView3.setVisibility(8);
            ImageView imageView = (ImageView) super.findViewById(R.id.ivTitleBtnRightImage);
            this.f390679w1 = imageView;
            imageView.setVisibility(0);
            this.f390679w1.setImageResource(R.drawable.qui_more_icon_nav_secondary);
            this.f390679w1.setContentDescription(super.getString(R.string.cat));
            this.f390679w1.setOnClickListener(this.f390680x1);
            this.f390682z1 = (FadeIconImageView) findViewById(R.id.dsq);
            if (!QfavUtil.B()) {
                FadeIconImageView fadeIconImageView = this.f390682z1;
                if (fadeIconImageView != null) {
                    fadeIconImageView.setVisibility(0);
                    this.A1 = true;
                }
            } else {
                FadeIconImageView fadeIconImageView2 = this.f390682z1;
                if (fadeIconImageView2 != null) {
                    fadeIconImageView2.setVisibility(8);
                }
            }
        } else if (this.C1) {
            textView3.setText(R.string.f171151ok);
            textView3.setOnClickListener(new c());
        } else {
            textView.setText(R.string.f170549u3);
            textView3.setText(R.string.ciw);
            textView3.setOnClickListener(new d());
        }
        textView3.setTag(textView3.getText());
        Drawable drawable = getResources().getDrawable(R.drawable.qui_chevron_left_icon_navigation_02_selector);
        int dpToPx = ViewUtils.dpToPx(20.0f);
        drawable.setBounds(0, 0, dpToPx, dpToPx);
        textView.setBackground(null);
        textView.setMaxWidth(Integer.MAX_VALUE);
        textView.setPadding(0, 0, 0, 0);
        textView.setGravity(8388627);
        textView.setCompoundDrawables(drawable, null, null, null);
        textView2.setTextColor(colorStateList);
        findViewById(R.id.title).setBackgroundResource(R.drawable.qui_bg_nav_secondary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 != 103 || intent == null) {
                if (13321 == i3) {
                    super.finish();
                } else if (13322 == i3 && intent != null) {
                    this.f390678v1 = intent.getStringExtra("note");
                    W3();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.setResult(0, new Intent());
        finish();
    }

    @Override // com.tencent.biz.PoiMapActivity, com.tencent.mobileqq.activity.QQMapActivity, com.tencent.mobileqq.mini.out.activity.MapActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.PoiMapActivity, com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = super.findViewById(R.id.iir);
        findViewById.setFocusable(false);
        findViewById.setContentDescription(null);
        if (this.C1 && !super.getIntent().getBooleanExtra("forNewFavorite", false)) {
            FrameLayout frameLayout = (FrameLayout) super.findViewById(android.R.id.content);
            float f16 = super.getResources().getDisplayMetrics().density;
            TextView textView = new TextView(frameLayout.getContext());
            this.f390677u1 = textView;
            textView.setId(R.id.far);
            this.f390677u1.setBackgroundResource(R.drawable.common_list_item_background);
            this.f390677u1.setMaxLines(3);
            int i3 = (int) (15.0f * f16);
            this.f390677u1.setPadding(i3, i3, i3, i3);
            this.f390677u1.setTextColor(super.getResources().getColor(R.color.skin_black));
            this.f390677u1.setTextSize(14.0f);
            this.f390677u1.setIncludeFontPadding(false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = ((int) (f16 * 50.0f)) + ImmersiveUtils.getStatusBarHeight(this);
            layoutParams.gravity = 48;
            frameLayout.addView(this.f390677u1, layoutParams);
        }
        this.f390678v1 = super.getIntent().getStringExtra("note");
        this.hideJiejingIcon = true;
        View view = this.jiejingIcon;
        if (view != null) {
            view.setVisibility(8);
        }
        W3();
        if (this.f390676t1 != -1) {
            getIntent().putExtra("big_brother_source_key", "biz_src_jc_shoucang");
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            U3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null) {
            iColorNoteController.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
    }

    @Override // com.tencent.biz.PoiMapActivity, com.tencent.mobileqq.activity.QQMapActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.overridePendingTransition(0, 0);
        super.onStart();
    }

    protected boolean s() {
        this.f390681y1 = true;
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null && !iColorNoteController.isColorNoteExist()) {
            if (this.B1.canAddColorNote()) {
                this.B1.insertColorNote();
                return true;
            }
            this.B1.onCannotAdd();
            return false;
        }
        this.f390681y1 = false;
        return false;
    }

    protected void t2() {
        IColorNoteController iColorNoteController = this.B1;
        if (iColorNoteController != null && iColorNoteController.isColorNoteExist()) {
            this.B1.deleteColorNote();
        }
    }
}
