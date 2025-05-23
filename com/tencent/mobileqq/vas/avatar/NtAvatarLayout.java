package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NtAvatarLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<View> f308726d;

    /* renamed from: e, reason: collision with root package name */
    public int f308727e;

    public NtAvatarLayout(@NonNull Context context) {
        super(context);
        this.f308726d = new SparseArray<>();
        this.f308727e = 0;
    }

    private void k() {
        removeAllViews();
        for (int i3 = 0; i3 < 2; i3++) {
            View view = this.f308726d.get(i3);
            if (view != null) {
                addView(view, -1, -1);
            }
        }
    }

    public void h(String str, int i3, int i16, String str2, ImageView.ScaleType scaleType) {
        boolean z16 = true;
        NtVasAvatar ntVasAvatar = (NtVasAvatar) i(1);
        if (ntVasAvatar == null) {
            ntVasAvatar = new NtVasAvatar(getContext());
            j(1, ntVasAvatar, true);
        }
        if (this.f308727e != 1) {
            z16 = false;
        }
        ntVasAvatar.f308728d = z16;
        ntVasAvatar.setLoader(this, new NtVasAvatarLoader(str, i3, i16, str2, true));
        ntVasAvatar.setScaleType(scaleType);
        ntVasAvatar.setVisibility(0);
    }

    public View i(int i3) {
        return this.f308726d.get(i3);
    }

    public void j(int i3, View view, boolean z16) {
        this.f308726d.put(i3, view);
        if (z16) {
            k();
        }
    }

    public void setGoneBelow(int i3) {
        int size = this.f308726d.size();
        for (int i16 = 0; i16 < size; i16++) {
            int keyAt = this.f308726d.keyAt(i16);
            if (keyAt < i3) {
                View valueAt = this.f308726d.valueAt(i16);
                if (valueAt != null) {
                    valueAt.setVisibility(8);
                } else if (com.tencent.mobileqq.vas.api.g.f308459b.isPublicVersion()) {
                    QLog.e("AvatarLayout", 1, "null avatar at " + keyAt);
                } else {
                    throw new RuntimeException("null avatar at " + keyAt);
                }
            }
        }
    }

    public NtAvatarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f308726d = new SparseArray<>();
        this.f308727e = 0;
    }

    public NtAvatarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f308726d = new SparseArray<>();
        this.f308727e = 0;
    }
}
