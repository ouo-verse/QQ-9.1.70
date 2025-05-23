package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.arengine.b;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.widget.mapview.QMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

/* loaded from: classes11.dex */
public class ARLBSPOIDialog extends ReportDialog {
    Activity C;
    QMapView D;
    RelativeLayout E;
    RelativeLayout F;
    URLImageView G;
    TextView H;
    TextView I;
    URLImageView J;
    ImageView K;
    TextView L;
    Button M;
    ProgressBar N;
    View P;
    View Q;
    RelativeLayout R;
    View S;
    View T;
    int U;
    int V;
    Context W;
    boolean X;
    b.a Y;
    private ARScanEntryView Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ARLBSPOIDialog.this.O();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ARLBSPOIDialog.this.dismiss();
            ARLBSPOIDialog.this.C.startActivity(new Intent(view.getContext(), (Class<?>) PoiMapActivity.class).putExtra(QCircleSchemeAttr.Polymerize.LAT, Double.toString((ARLBSPOIDialog.this.Y.f198150a * 1.0d) / 1000000.0d)).putExtra("lon", Double.toString((ARLBSPOIDialog.this.Y.f198151b * 1.0d) / 1000000.0d)));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ARLBSPOIDialog(Activity activity, QMapView qMapView, ARScanEntryView aRScanEntryView) {
        super(activity, R.style.qZoneInputDialog);
        this.C = activity;
        this.W = activity;
        this.Z = aRScanEntryView;
        initView();
        this.D = qMapView;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = activity.getResources().getDisplayMetrics().widthPixels;
        attributes.height = activity.getResources().getDisplayMetrics().heightPixels;
        window.setAttributes(attributes);
        this.N.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.ARLBSPOIDialog.1
            @Override // java.lang.Runnable
            public void run() {
                ARLBSPOIDialog aRLBSPOIDialog = ARLBSPOIDialog.this;
                if (!aRLBSPOIDialog.X) {
                    aRLBSPOIDialog.N.setVisibility(0);
                }
            }
        }, 1500L);
    }

    private void Q(b.a aVar) {
        String str;
        ARScanEntryView aRScanEntryView;
        Projection projection;
        QMapView qMapView = this.D;
        if (qMapView != null && qMapView.getMap() != null) {
            if (this.D.getParent() != null) {
                ((ViewGroup) this.D.getParent()).removeView(this.D);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(210.0f, this.W.getResources()));
            layoutParams.addRule(3, R.id.dls);
            this.R.addView(this.D, layoutParams);
            View inflate = getLayoutInflater().inflate(R.layout.art, (ViewGroup) null);
            this.T = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.fw5);
            TextView textView2 = (TextView) this.T.findViewById(R.id.bmp);
            TextView textView3 = (TextView) this.T.findViewById(R.id.f166530fw4);
            textView.setText(HardCodeUtil.qqStr(R.string.jqs));
            int i3 = aVar.f198154e;
            if (i3 < 1000) {
                textView2.setText(this.W.getString(R.string.f_0, String.valueOf(i3)));
            } else {
                textView2.setText(this.W.getString(R.string.f9y, String.valueOf(Math.round((i3 / 1000.0f) * 100.0f) / 100.0f)));
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(aVar.f198152c);
            sb5.append("|");
            if (TextUtils.isEmpty(aVar.f198153d)) {
                str = "";
            } else {
                str = aVar.f198153d;
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(aVar.f198152c)) {
                SpannableString spannableString = new SpannableString(sb6);
                spannableString.setSpan(new StyleSpan(1), 0, aVar.f198152c.length(), 17);
                textView3.setText(spannableString);
            } else {
                textView3.setText(sb6);
            }
            this.T.setOnClickListener(new b());
            TencentMap map = this.D.getMap();
            map.moveCamera(CameraUpdateFactory.zoomTo(16.0f));
            LatLng latLng = new LatLng((aVar.f198150a * 1.0d) / 1000000.0d, (aVar.f198151b * 1.0d) / 1000000.0d);
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            this.D.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.T)).position(latLng));
            if (this.C != null && (aRScanEntryView = this.Z) != null && aRScanEntryView.U && (projection = this.D.getMap().getProjection()) != null && map.getCameraPosition() != null) {
                Point screenLocation = projection.toScreenLocation(map.getCameraPosition().target);
                screenLocation.offset(0, BaseAIOUtils.f(60.0f, this.W.getResources()) * (-1));
                map.moveCamera(CameraUpdateFactory.newLatLng(projection.fromScreenLocation(screenLocation)));
            }
            this.D.onResume();
            this.S.setVisibility(8);
            this.Q.setVisibility(8);
            this.P.setVisibility(8);
            this.R.setVisibility(0);
            return;
        }
        QLog.e("ARLBSPOIDialog", 1, "showMapView, but map is null.");
    }

    private void initView() {
        setContentView(R.layout.aro);
        this.F = (RelativeLayout) findViewById(R.id.dls);
        this.G = (URLImageView) findViewById(R.id.fw6);
        this.H = (TextView) findViewById(R.id.fwe);
        this.I = (TextView) findViewById(R.id.jbu);
        this.K = (ImageView) findViewById(R.id.c9f);
        this.J = (URLImageView) findViewById(R.id.fzl);
        this.L = (TextView) findViewById(R.id.fzm);
        this.N = (ProgressBar) findViewById(R.id.g1o);
        Button button = (Button) findViewById(R.id.az7);
        this.M = button;
        button.setOnClickListener(new a());
        this.E = (RelativeLayout) findViewById(R.id.b_7);
        this.P = findViewById(R.id.fw8);
        this.Q = findViewById(R.id.adf);
        this.S = findViewById(R.id.emd);
        this.R = (RelativeLayout) findViewById(R.id.emc);
        this.K.setVisibility(8);
    }

    public void N(b.a aVar, ArLBSActivity arLBSActivity) {
        if (QLog.isColorLevel()) {
            QLog.d("ARLBSPOIDialog", 2, "bindView");
        }
        this.Y = aVar;
        this.X = true;
        this.N.setVisibility(8);
        if (!TextUtils.isEmpty(arLBSActivity.f198417h)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = BaseAIOUtils.f(140.0f, this.W.getResources());
            obtain.mRequestWidth = BaseAIOUtils.f(170.0f, this.W.getResources());
            obtain.mLoadingDrawable = this.W.getResources().getDrawable(R.drawable.trans);
            obtain.mFailedDrawable = this.W.getResources().getDrawable(R.drawable.trans);
            this.J.setImageDrawable(URLDrawable.getDrawable(arLBSActivity.f198417h, obtain));
        }
        if (!TextUtils.isEmpty(arLBSActivity.f198415e)) {
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            int f16 = BaseAIOUtils.f(31.0f, this.W.getResources());
            obtain2.mRequestHeight = f16;
            obtain2.mRequestWidth = f16;
            obtain2.mLoadingDrawable = this.W.getResources().getDrawable(R.drawable.trans);
            obtain2.mFailedDrawable = this.W.getResources().getDrawable(R.drawable.trans);
            this.G.setImageDrawable(URLDrawable.getDrawable(arLBSActivity.f198415e, obtain2));
        }
        if (!TextUtils.isEmpty(arLBSActivity.f198416f)) {
            URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
            obtain3.mLoadingDrawable = this.W.getResources().getDrawable(R.drawable.trans);
            obtain3.mFailedDrawable = this.W.getResources().getDrawable(R.drawable.trans);
            this.F.setBackgroundDrawable(URLDrawable.getDrawable(arLBSActivity.f198416f, obtain3));
        }
        this.H.setText(arLBSActivity.f198414d);
        if (!TextUtils.isEmpty(arLBSActivity.f198418i)) {
            this.L.setText(arLBSActivity.f198418i);
        }
        this.I.setText(HardCodeUtil.qqStr(R.string.jqt));
        Q(aVar);
    }

    public void O() {
        int i3 = getWindow().getAttributes().width;
        int i16 = getWindow().getAttributes().height;
        int f16 = (i3 - BaseAIOUtils.f(320.0f, this.W.getResources())) / 2;
        int f17 = (i16 - BaseAIOUtils.f(420.0f, this.W.getResources())) / 2;
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 0, this.U - f16, 0, this.V - f17);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setDuration(350L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        this.E.startAnimation(animationSet);
        animationSet.setAnimationListener(new c());
    }

    public void P() {
        super.show();
        int i3 = getWindow().getAttributes().width;
        int i16 = getWindow().getAttributes().height;
        int f16 = (i3 - BaseAIOUtils.f(320.0f, this.W.getResources())) / 2;
        int f17 = (i16 - BaseAIOUtils.f(420.0f, this.W.getResources())) / 2;
        this.U = i3 / 2;
        this.V = i16 / 2;
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 0, this.U - f16, 0, this.V - f17);
        scaleAnimation.setInterpolator(new AccelerateInterpolator(1.5f));
        scaleAnimation.setDuration(350L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        this.E.startAnimation(animationSet);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (!this.C.isFinishing()) {
            super.dismiss();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        QMapView qMapView = this.D;
        if (qMapView != null && qMapView.getParent() != null) {
            View view = this.T;
            if (view != null) {
                this.D.removeView(view);
            }
            this.R.removeView(this.D);
            this.D.onPause();
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (!this.C.isFinishing()) {
            super.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ARLBSPOIDialog.this.E.setVisibility(8);
            ARLBSPOIDialog.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
