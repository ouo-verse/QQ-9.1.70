package com.tencent.mobileqq.activity.aio.item;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class DetectableAnimationDrawable extends AnimationDrawable {

    /* renamed from: d, reason: collision with root package name */
    Handler f179357d;

    public DetectableAnimationDrawable(AnimationDrawable animationDrawable) {
        for (int i3 = 0; i3 < animationDrawable.getNumberOfFrames(); i3++) {
            addFrame(animationDrawable.getFrame(i3), animationDrawable.getDuration(i3));
        }
        setOneShot(animationDrawable.isOneShot());
    }

    private int e() {
        int i3 = 0;
        for (int i16 = 0; i16 < getNumberOfFrames(); i16++) {
            i3 += getDuration(i16);
        }
        return i3;
    }

    public abstract void f();

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        Handler handler = new Handler();
        this.f179357d = handler;
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                DetectableAnimationDrawable.this.f();
            }
        }, e());
    }
}
