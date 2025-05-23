package com.tencent.aelight.camera.filament.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class BaseZShowFilamentPreviewView extends FrameLayout {

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i3);

        void b(int i3, String str);

        void c(int i3, int i16);

        void d(int i3, String str, @Nullable Bitmap bitmap);
    }

    public BaseZShowFilamentPreviewView(@NonNull Context context) {
        super(context);
    }

    public abstract void a();

    public abstract void setMoodType(String str);

    public abstract void setOnStatusListener(a aVar);

    public abstract void setupBaseTemplate(String str, String str2, int i3);

    public BaseZShowFilamentPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseZShowFilamentPreviewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
