package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aw extends BitmapDrawable {

    /* renamed from: a, reason: collision with root package name */
    private ColorStateList f77064a;

    public aw(Resources resources, InputStream inputStream, int i3) {
        super(resources, inputStream);
        this.f77064a = resources.getColorStateList(i3);
        onStateChange(getState());
    }

    public static aw a(Resources resources, int i3, int i16) {
        InputStream openRawResource = resources.openRawResource(i3);
        aw awVar = new aw(resources, openRawResource, i16);
        try {
            openRawResource.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return awVar;
    }

    public static aw b(Resources resources, Bitmap bitmap, int i3) {
        return new aw(resources, bitmap, i3);
    }

    @TargetApi(16)
    public static void c(View view, int i3, int i16) {
        if (view == null) {
            return;
        }
        view.setBackground(a(view.getResources(), i3, i16));
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f77064a.getColorForState(iArr, 0);
        if (colorForState != 0) {
            setColorFilter(colorForState, PorterDuff.Mode.MULTIPLY);
        } else {
            clearColorFilter();
        }
        invalidateSelf();
        return super.onStateChange(iArr);
    }

    public aw(Resources resources, Bitmap bitmap, int i3) {
        super(resources, bitmap);
        this.f77064a = resources.getColorStateList(i3);
        onStateChange(getState());
    }
}
