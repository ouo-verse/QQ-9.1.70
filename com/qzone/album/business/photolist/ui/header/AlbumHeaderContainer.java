package com.qzone.album.business.photolist.ui.header;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumHeaderContainer extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f43341d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f43342e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f43343f;

    public AlbumHeaderContainer(Context context) {
        super(context);
        this.f43343f = false;
        b(context);
    }

    private void b(Context context) {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(context);
        this.f43341d = imageView;
        imageView.setBackgroundColor(getResources().getColor(R.color.f156972gi));
        this.f43341d.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f43342e = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f43342e, new LinearLayout.LayoutParams(-1, -2));
        addView(this.f43341d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f43343f;
    }

    public void a(View view) {
        if (view != null) {
            this.f43342e.addView(view);
        }
    }

    public void c(View view) {
        if (view != null) {
            this.f43342e.removeView(view);
        }
    }

    public void setLayerStatus(boolean z16) {
        if (z16) {
            this.f43341d.setVisibility(0);
            this.f43343f = true;
        } else {
            this.f43341d.setVisibility(8);
            this.f43343f = false;
        }
    }
}
