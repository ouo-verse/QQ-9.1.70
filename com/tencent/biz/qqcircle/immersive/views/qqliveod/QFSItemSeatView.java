package com.tencent.biz.qqcircle.immersive.views.qqliveod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSItemSeatView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private QFSWaveAnimationView f91029d;

    /* renamed from: e, reason: collision with root package name */
    private RoundImageView f91030e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f91031f;

    /* renamed from: h, reason: collision with root package name */
    private AppCompatImageView f91032h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f91033i;

    public QFSItemSeatView(@NonNull Context context) {
        super(context);
        this.f91033i = true;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.gpt, this);
        this.f91029d = (QFSWaveAnimationView) findViewById(R.id.f87134tj);
        this.f91030e = (RoundImageView) findViewById(R.id.f81304dt);
        this.f91031f = (TextView) findViewById(R.id.f81324dv);
        this.f91032h = (AppCompatImageView) findViewById(R.id.f114876ui);
    }

    public void A0() {
        this.f91030e.setVisibility(8);
        this.f91031f.setText("\u672a\u4e0a\u9ea6");
        this.f91031f.setAlpha(0.32f);
    }

    public void B0() {
        this.f91029d.d();
    }

    public void C0() {
        this.f91029d.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0();
    }

    public void setDefaultHeadBg(@DrawableRes int i3) {
        this.f91032h.setImageResource(i3);
    }

    public void setName(String str) {
        this.f91031f.setAlpha(1.0f);
        this.f91031f.setText(str);
    }

    public void z0(String str) {
        this.f91030e.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (this.f91033i) {
            obtain.mLoadingDrawable = ContextCompat.getDrawable(getContext(), R.drawable.c0i);
        } else {
            obtain.mLoadingDrawable = this.f91030e.getDrawable();
        }
        this.f91033i = false;
        this.f91030e.setImageDrawable(URLDrawable.getDrawable(str, obtain));
    }

    public QFSItemSeatView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91033i = true;
        initView();
    }

    public QFSItemSeatView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91033i = true;
        initView();
    }
}
