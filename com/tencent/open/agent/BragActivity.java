package com.tencent.open.agent;

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
import gp3.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BragActivity extends ChallengeBragBase implements com.tencent.open.widget.a {

    /* renamed from: u0, reason: collision with root package name */
    protected ScrollView f339696u0;

    /* renamed from: v0, reason: collision with root package name */
    protected ImageView f339697v0;

    /* renamed from: w0, reason: collision with root package name */
    protected InputFilter[] f339698w0;

    /* renamed from: x0, reason: collision with root package name */
    protected KeyboardDetectorRelativeLayout f339699x0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements e.b {
        a() {
        }

        @Override // gp3.e.b
        public void onImageLoaded(String str, Bitmap bitmap, String str2) {
            BragActivity.this.f339697v0.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.open.widget.a
    public void K0() {
        ImageView imageView = this.f339697v0;
        if (imageView != null) {
            imageView.getLayoutParams().height = x.c(this, 90.0f);
            this.f339697v0.setVerticalFadingEdgeEnabled(false);
            this.f339697v0.setVisibility(0);
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
        ScrollView scrollView = this.f339696u0;
        if (scrollView != null && h16 < 255) {
            int i16 = (h16 - 20) - 145;
            if (i16 > 0 && i16 < 90) {
                scrollView.setVisibility(0);
                this.f339696u0.getLayoutParams().height = x.c(this, i16);
                this.f339696u0.setVerticalFadingEdgeEnabled(true);
                return;
            }
            if (i16 <= 0) {
                scrollView.getLayoutParams().height = 0;
                this.f339696u0.setVisibility(8);
            }
        }
    }

    protected void initUI() {
        this.f339696u0 = (ScrollView) super.findViewById(R.id.adx);
        KeyboardDetectorRelativeLayout keyboardDetectorRelativeLayout = (KeyboardDetectorRelativeLayout) super.findViewById(R.id.ibu);
        this.f339699x0 = keyboardDetectorRelativeLayout;
        keyboardDetectorRelativeLayout.a(this);
        this.f339697v0 = (ImageView) super.findViewById(R.id.adw);
        this.f339748s0 = (EditText) super.findViewById(R.id.byq);
        this.f339746q0 = (TextView) super.findViewById(R.id.dialogRightBtn);
        this.f339747r0 = (TextView) super.findViewById(R.id.dialogLeftBtn);
        this.f339745p0 = (TextView) super.findViewById(R.id.k5y);
        InputFilter[] inputFilterArr = {new com.tencent.open.base.e(this.f339748s0, 100)};
        this.f339698w0 = inputFilterArr;
        this.f339748s0.setFilters(inputFilterArr);
        this.f339748s0.setText(this.f339736g0);
        this.f339746q0.setOnClickListener(this);
        this.f339747r0.setOnClickListener(this);
        try {
            G2(this.f339735f0);
            Bitmap b16 = gp3.e.a().b(this.f339737h0);
            if (b16 != null) {
                this.f339697v0.setImageBitmap(b16);
            } else {
                this.f339697v0.setImageResource(R.drawable.f160830com);
                gp3.e.a().c(this.f339737h0, new a());
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("BragActivity", "getNickName error. " + e16.getMessage(), e16);
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
        super.setContentView(R.layout.f168461ws);
        super.H2();
        initUI();
        com.tencent.open.business.base.e.g("100", "ANDROIDQQ.BRAG.FS", this.f339730a0, true);
    }
}
