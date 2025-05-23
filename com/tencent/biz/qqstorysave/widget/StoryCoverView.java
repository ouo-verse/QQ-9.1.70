package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryCoverView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public ImageView f94539d;

    /* renamed from: e, reason: collision with root package name */
    public PollContainerLayout f94540e;

    public StoryCoverView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        c.c("StoryCoverView", "onLayout wh(%d, %d)", Integer.valueOf(i17 - i3), Integer.valueOf(i18 - i16));
    }

    public void setCoverUrl(String str, int i3, int i16, int i17) {
        UIUtils.q(this.f94539d, str, i3, i16, i17, null, "Qim_Profile_Story" + i3 + "_" + i16 + "_" + i17);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f94539d.setImageDrawable(drawable);
    }

    public StoryCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        ImageView imageView = new ImageView(context);
        this.f94539d = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        new FrameLayout.LayoutParams(-1, -1);
        addView(this.f94539d, layoutParams);
        PollContainerLayout pollContainerLayout = new PollContainerLayout(context);
        this.f94540e = pollContainerLayout;
        pollContainerLayout.b(true);
        this.f94540e.setClickable(false);
        addView(this.f94540e, layoutParams2);
        int i3 = R.styleable.StoryCoverView_android_scaleType;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{i3});
        int i16 = obtainStyledAttributes.getInt(i3, -1);
        if (i16 >= 0) {
            ImageView.ScaleType[] values = ImageView.ScaleType.values();
            if (values.length > i16) {
                this.f94539d.setScaleType(values[i16]);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
