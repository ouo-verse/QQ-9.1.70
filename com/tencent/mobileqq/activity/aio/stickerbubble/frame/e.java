package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private int f179901a;

    public e(int i3) {
        this.f179901a = i3;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public Bitmap a() {
        return BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), this.f179901a);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getCurrentFrameIndex() {
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getFrameCount() {
        return 1;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getFrameDelay() {
        return 1000000;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public void b() {
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public void complete() {
    }
}
