package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes14.dex */
public class BlurBGImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    int f235768d;

    /* renamed from: e, reason: collision with root package name */
    int f235769e;

    public BlurBGImageView(Context context) {
        super(context);
        this.f235768d = 2;
        this.f235769e = 8;
    }

    public void setScaleFactor(int i3) {
        this.f235768d = i3;
    }

    public BlurBGImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f235768d = 2;
        this.f235769e = 8;
    }

    public BlurBGImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f235768d = 2;
        this.f235769e = 8;
    }
}
