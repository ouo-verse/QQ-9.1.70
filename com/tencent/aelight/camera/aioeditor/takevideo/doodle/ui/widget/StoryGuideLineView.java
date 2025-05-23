package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.mobileqq.R;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class StoryGuideLineView extends LinearLayout {
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    private View C;
    private View D;

    /* renamed from: d, reason: collision with root package name */
    private PressDarkImageView f68691d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f68692e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f68693f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f68694h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f68695i;

    /* renamed from: m, reason: collision with root package name */
    private View f68696m;

    public StoryGuideLineView(Context context) {
        super(context);
        e(context);
    }

    private void e(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bzb, (ViewGroup) this, true);
        this.f68691d = (PressDarkImageView) findViewById(R.id.gvj);
        this.f68692e = (TextView) findViewById(R.id.gyl);
        this.f68693f = (LinearLayout) findViewById(R.id.jaq);
        this.f68694h = (LinearLayout) findViewById(R.id.dj9);
        this.f68695i = (LinearLayout) findViewById(R.id.gws);
        this.f68696m = findViewById(R.id.gwt);
        this.D = findViewById(R.id.f166647gx1);
        this.C = findViewById(R.id.gwy);
        setViewAlpha(this.f68695i);
    }

    public void a() {
        d();
        c();
        b();
    }

    public void b() {
        View view;
        if (this.f68695i == null || (view = this.f68696m) == null) {
            return;
        }
        view.setVisibility(8);
        this.f68695i.setVisibility(8);
    }

    public void c() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void d() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void f(boolean z16) {
        View view;
        if (this.f68695i == null || (view = this.f68696m) == null) {
            return;
        }
        view.setVisibility(0);
        if (z16) {
            this.f68695i.setVisibility(0);
        }
    }

    public void g() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void h() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        measureChild(this.f68695i, i3, i16);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        E = this.C.getMeasuredWidth();
        F = displayMetrics.widthPixels - this.D.getMeasuredWidth();
        G = 0;
        H = displayMetrics.heightPixels - this.f68695i.getMeasuredHeight();
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            H = ((displayMetrics.heightPixels - this.f68695i.getMeasuredHeight()) - LiuHaiUtils.BOTTOM_HEIGHT) - LiuHaiUtils.sNotchHeight;
        }
    }

    public void setUserHead(Bitmap bitmap) {
        PressDarkImageView pressDarkImageView = this.f68691d;
        if (pressDarkImageView != null) {
            pressDarkImageView.setImageBitmap(bitmap);
        }
    }

    public void setUserName(String str) {
        if (this.f68692e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68692e.setText(str);
    }

    public void setViewAlpha(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                setViewAlpha((ViewGroup) childAt);
            }
            if (childAt.getBackground() != null) {
                childAt.getBackground().mutate().setAlpha(60);
            }
            childAt.setAlpha(0.6f);
        }
    }

    public StoryGuideLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public StoryGuideLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e(context);
    }
}
