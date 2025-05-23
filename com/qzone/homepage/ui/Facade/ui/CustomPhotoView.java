package com.qzone.homepage.ui.Facade.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes39.dex */
public class CustomPhotoView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f47635d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncImageView f47636e;

    /* renamed from: f, reason: collision with root package name */
    private b f47637f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CustomPhotoView.this.f47637f != null) {
                CustomPhotoView.this.f47637f.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public interface b {
        void a();
    }

    public CustomPhotoView(Context context) {
        this(context, null);
    }

    private void b() {
        this.f47636e = new AsyncImageView(getContext());
        addView(this.f47636e, new FrameLayout.LayoutParams(-1, -1));
        this.f47636e.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView = new ImageView(getContext());
        this.f47635d = imageView;
        imageView.setBackgroundResource(R.drawable.fyd);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f47635d.setLayoutParams(layoutParams);
        addView(this.f47635d);
        this.f47635d.setOnClickListener(new a());
        if (getContext() instanceof b) {
            this.f47637f = (b) getContext();
        }
    }

    public void setOnCameraIconClickListener(b bVar) {
        this.f47637f = bVar;
    }

    public void setPreviewSelectedImageUrl(String str) {
        AsyncImageView asyncImageView = this.f47636e;
        if (asyncImageView != null) {
            asyncImageView.setAsyncImage(str);
        }
    }

    public CustomPhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
    }
}
