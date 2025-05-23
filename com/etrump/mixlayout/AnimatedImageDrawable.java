package com.etrump.mixlayout;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AnimatedImageDrawable extends AnimationDrawable {

    /* renamed from: d, reason: collision with root package name */
    private int f32599d;

    public int e() {
        return getDuration(this.f32599d);
    }

    public void f() {
        this.f32599d = (this.f32599d + 1) % getNumberOfFrames();
    }

    public Drawable getDrawable() {
        return getFrame(this.f32599d);
    }
}
