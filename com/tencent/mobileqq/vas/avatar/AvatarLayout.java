package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AvatarLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<View> f308658d;

    /* renamed from: e, reason: collision with root package name */
    public int f308659e;

    public AvatarLayout(@NonNull Context context) {
        super(context);
        this.f308658d = new SparseArray<>();
        this.f308659e = 0;
    }

    private void e() {
        removeAllViews();
        for (int i3 = 0; i3 < 2; i3++) {
            View view = this.f308658d.get(i3);
            if (view != null) {
                addView(view, -1, -1);
            }
        }
    }

    public void a(String str, int i3, int i16, String str2, ImageView.ScaleType scaleType) {
        boolean z16 = true;
        VasAvatar vasAvatar = (VasAvatar) c(1);
        if (vasAvatar == null) {
            vasAvatar = new VasAvatar(getContext());
            d(1, vasAvatar, true);
        }
        if (this.f308659e != 1) {
            z16 = false;
        }
        vasAvatar.f308760d = z16;
        vasAvatar.setLoader(this, new VasAvatarLoader(str, i3, i16, this.f308659e, str2, 0L));
        vasAvatar.setScaleType(scaleType);
        vasAvatar.setVisibility(0);
    }

    public void b(String str, int i3, String str2, ImageView.ScaleType scaleType) {
        boolean z16 = true;
        VasAvatar vasAvatar = (VasAvatar) c(1);
        if (vasAvatar == null) {
            vasAvatar = new VasAvatar(getContext());
            d(1, vasAvatar, true);
        }
        if (this.f308659e != 1) {
            z16 = false;
        }
        vasAvatar.f308760d = z16;
        vasAvatar.setLoader(this, new VasAvatarLoader(str, i3, this.f308659e, str2, 0L));
        vasAvatar.setScaleType(scaleType);
        vasAvatar.setVisibility(0);
    }

    public View c(int i3) {
        return this.f308658d.get(i3);
    }

    public void d(int i3, View view, boolean z16) {
        this.f308658d.put(i3, view);
        if (z16) {
            e();
        }
    }

    public void f(int i3) {
        if (this.f308658d.get(i3) != null) {
            this.f308658d.remove(i3);
            e();
        }
    }

    public void setFaceDrawable(AppInterface appInterface, Drawable drawable, int i3, int i16, String str, int i17, boolean z16, DynamicAvatar dynamicAvatar, boolean z17, boolean z18, boolean z19, boolean z26, int i18) {
        DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) c(0);
        dynamicAvatarView.setFaceDrawable(appInterface, drawable, i3, i16, str, i17, z16, dynamicAvatar, z17, z18, z19, z26, d.a(i18));
        f(1);
        if (VasAvatar.c(i3, i16)) {
            b(str, i18, VasAvatar.i(i17), dynamicAvatarView.getScaleType());
        }
        dynamicAvatarView.setVisibility(0);
    }

    public void setGoneBelow(int i3) {
        int size = this.f308658d.size();
        for (int i16 = 0; i16 < size; i16++) {
            int keyAt = this.f308658d.keyAt(i16);
            if (keyAt < i3) {
                View valueAt = this.f308658d.valueAt(i16);
                if (valueAt != null) {
                    valueAt.setVisibility(8);
                } else {
                    QLog.e("AvatarLayout", 1, "null avatar at " + keyAt);
                }
            }
        }
    }

    public void setStaticAvatar(Bitmap bitmap) {
        ImageView imageView = (ImageView) c(0);
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(0);
        f(1);
    }

    public AvatarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f308658d = new SparseArray<>();
        this.f308659e = 0;
    }

    public AvatarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f308658d = new SparseArray<>();
        this.f308659e = 0;
    }

    public void setFaceDrawable(AppInterface appInterface, Drawable drawable, int i3, int i16, String str, int i17, int i18, boolean z16, DynamicAvatar dynamicAvatar, boolean z17, boolean z18, boolean z19, boolean z26, int i19) {
        DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) c(0);
        dynamicAvatarView.setFaceDrawable(appInterface, drawable, i3, i16, str, i18, z16, dynamicAvatar, z17, z18, z19, z26, d.a(i19));
        f(1);
        if (VasAvatar.c(i3, i16)) {
            a(str, i17, i19, VasAvatar.i(i18), dynamicAvatarView.getScaleType());
        }
        dynamicAvatarView.setVisibility(0);
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, int i18, boolean z17, boolean z18, boolean z19, boolean z26, int i19) {
        setFaceDrawable(appInterface, i3, i16, str, b16, i17, z16, drawable, drawable2, onLoadingStateChangeListener, i18, z17, z18, z19, z26, i19, false, 0);
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, int i18, boolean z17, boolean z18, boolean z19, boolean z26, int i19, boolean z27, int i26) {
        DynamicAvatarView dynamicAvatarView;
        DynamicAvatarView dynamicAvatarView2 = (DynamicAvatarView) c(0);
        dynamicAvatarView2.setFaceDrawable(appInterface, i3, i16, str, b16, i17, z16, drawable, drawable2, onLoadingStateChangeListener, i18, z17, z18, z19, z26, d.a(i19), z27, i26);
        if (VasAvatar.c(i3, i16)) {
            dynamicAvatarView = dynamicAvatarView2;
            b(str, i19, VasAvatar.i(i18), dynamicAvatarView2.getScaleType());
        } else {
            dynamicAvatarView = dynamicAvatarView2;
            f(1);
        }
        dynamicAvatarView.setVisibility(0);
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, String str, int i16, boolean z16, boolean z17, boolean z18, boolean z19, int i17) {
        setFaceDrawable(appInterface, i3, str, i16, z16, z17, z18, z19, i17, false, 0);
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, String str, int i16, boolean z16, boolean z17, boolean z18, boolean z19, int i17, boolean z26, int i18) {
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(i3, 3);
        setFaceDrawable(appInterface, i3, 200, str, (byte) 0, 3, false, defaultDrawable, defaultDrawable, null, i16, z16, z17, z18, z19, i17, z26, i18);
    }

    public void setFaceDrawable(AppInterface appInterface, Drawable drawable, int i3, String str, int i16, boolean z16, boolean z17, int i17) {
        setFaceDrawable(appInterface, drawable, i3, 200, str, i16, z16, null, false, z17, false, false, i17);
    }
}
