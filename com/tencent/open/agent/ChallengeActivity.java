package com.tencent.open.agent;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import gp3.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ChallengeActivity extends ChallengeBragBase implements com.tencent.open.widget.a, e.b {
    protected String A0;
    protected String B0;

    /* renamed from: u0, reason: collision with root package name */
    protected KeyboardDetectorRelativeLayout f339724u0;

    /* renamed from: v0, reason: collision with root package name */
    protected ScrollView f339725v0;

    /* renamed from: w0, reason: collision with root package name */
    protected ScrollView f339726w0;

    /* renamed from: x0, reason: collision with root package name */
    protected ImageView f339727x0;

    /* renamed from: y0, reason: collision with root package name */
    protected ImageView f339728y0;

    /* renamed from: z0, reason: collision with root package name */
    protected InputFilter[] f339729z0;

    @Override // com.tencent.open.widget.a
    public void K0() {
        ScrollView scrollView = this.f339725v0;
        if (scrollView != null) {
            scrollView.getLayoutParams().height = x.c(this, 55.0f);
            this.f339725v0.setVerticalFadingEdgeEnabled(false);
            this.f339725v0.setVisibility(0);
            this.f339726w0.getLayoutParams().height = x.c(this, 30.0f);
            this.f339726w0.setVerticalFadingEdgeEnabled(false);
            this.f339726w0.setVisibility(0);
        }
    }

    @Override // com.tencent.open.agent.ChallengeBragBase, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.open.widget.a
    public void f0(int i3) {
        int h16 = (x.h(this, i3) - 10) - 10;
        ScrollView scrollView = this.f339725v0;
        if (scrollView != null && h16 < 255) {
            int i16 = ((r6 - 30) - 5) - 145;
            int i17 = ((h16 - 20) - 5) - 145;
            if (i16 > 0 && i16 < 55) {
                scrollView.setVisibility(0);
                this.f339725v0.getLayoutParams().height = x.c(this, i16);
                this.f339725v0.setVerticalFadingEdgeEnabled(true);
                this.f339726w0.getLayoutParams().height = x.c(this, 30.0f);
                this.f339726w0.setVerticalFadingEdgeEnabled(false);
                this.f339726w0.setVisibility(0);
                return;
            }
            if (i16 <= 0 && i17 > 0 && i17 < 30) {
                scrollView.getLayoutParams().height = 0;
                this.f339725v0.setVisibility(8);
                this.f339745p0.getLayoutParams().height = x.c(this, i17);
                this.f339726w0.setVerticalFadingEdgeEnabled(true);
                return;
            }
            scrollView.getLayoutParams().height = 0;
            this.f339725v0.setVisibility(8);
            this.f339726w0.getLayoutParams().height = 0;
            this.f339726w0.setVisibility(8);
        }
    }

    @TargetApi(14)
    protected void initUI() {
        this.f339724u0 = (KeyboardDetectorRelativeLayout) super.findViewById(R.id.id6);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f339724u0.setFitsSystemWindows(true);
            this.f339724u0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        this.f339726w0 = (ScrollView) super.findViewById(R.id.j8p);
        this.f339745p0 = (TextView) super.findViewById(R.id.k_4);
        this.f339748s0 = (EditText) super.findViewById(R.id.byq);
        this.f339725v0 = (ScrollView) super.findViewById(R.id.j8o);
        this.f339746q0 = (TextView) super.findViewById(R.id.aeg);
        this.f339747r0 = (TextView) super.findViewById(R.id.aed);
        this.f339727x0 = (ImageView) super.findViewById(R.id.a3e);
        this.f339728y0 = (ImageView) super.findViewById(R.id.a3f);
        this.f339724u0.a(this);
        this.f339726w0.setVerticalFadingEdgeEnabled(false);
        InputFilter[] inputFilterArr = {new com.tencent.open.base.e(this.f339748s0, 100)};
        this.f339729z0 = inputFilterArr;
        this.f339748s0.setFilters(inputFilterArr);
        this.f339748s0.setText(this.f339736g0);
        ScrollView scrollView = this.f339725v0;
        if (scrollView != null) {
            scrollView.setVerticalFadingEdgeEnabled(false);
        }
        this.f339746q0.setOnClickListener(this);
        this.f339747r0.setOnClickListener(this);
        try {
            G2(this.f339735f0);
            this.A0 = gp3.f.a(this.f339730a0, this.f339731b0);
            this.B0 = gp3.f.a(this.f339730a0, this.f339735f0);
            Bitmap b16 = gp3.e.a().b(this.A0);
            Bitmap b17 = gp3.e.a().b(this.B0);
            if (b16 != null) {
                this.f339727x0.setImageBitmap(b16);
            } else {
                this.f339727x0.setImageResource(R.drawable.f160830com);
                gp3.e.a().c(this.A0, this);
            }
            if (b17 != null) {
                this.f339728y0.setImageBitmap(b17);
            } else {
                this.f339728y0.setImageResource(R.drawable.f160830com);
                gp3.e.a().c(this.B0, this);
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("ChallengeActivity", "getNickName error. " + e16.getMessage(), e16);
            F2();
        }
    }

    @Override // com.tencent.open.agent.ChallengeBragBase, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.getWindow().requestFeature(1);
        super.onCreate(bundle);
        super.setContentView(R.layout.f168462wt);
        super.H2();
        initUI();
        com.tencent.open.business.base.e.g("100", "ANDROIDQQ.PK.FS", this.f339730a0, true);
    }

    @Override // gp3.e.b
    public void onImageLoaded(String str, Bitmap bitmap, String str2) {
        if (this.A0.equals(str)) {
            this.f339727x0.setImageBitmap(bitmap);
        } else if (this.B0.equals(str)) {
            this.f339728y0.setImageBitmap(bitmap);
        }
    }
}
