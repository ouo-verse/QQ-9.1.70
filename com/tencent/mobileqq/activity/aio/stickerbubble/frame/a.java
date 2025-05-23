package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements d {

    /* renamed from: e, reason: collision with root package name */
    private int f179892e;

    /* renamed from: g, reason: collision with root package name */
    private long f179894g;

    /* renamed from: a, reason: collision with root package name */
    int[] f179888a = new int[7];

    /* renamed from: b, reason: collision with root package name */
    public int f179889b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f179890c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f179891d = 0;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f179893f = 0;

    /* renamed from: h, reason: collision with root package name */
    int f179895h = -1;

    public a(File file) {
        this.f179892e = 0;
        c(file.getAbsolutePath());
        a();
        int[] iArr = this.f179888a;
        if (iArr[5] == 0) {
            this.f179892e = iArr[4];
            return;
        }
        QLog.e("StickerBubble_ApngDecode", 1, "start decode error, errCode" + this.f179888a[5]);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(this.f179889b, this.f179890c, Bitmap.Config.ARGB_8888);
        this.f179893f = ApngImage.nativeGetNextFrame(this.f179894g, this.f179893f, createBitmap, this.f179888a);
        this.f179895h++;
        return createBitmap;
    }

    public void c(String str) {
        this.f179894g = ApngImage.nativeStartDecode(str, this.f179888a, 0);
        int[] iArr = this.f179888a;
        if (iArr[5] == 0) {
            this.f179889b = iArr[0];
            this.f179890c = iArr[1];
            this.f179891d = iArr[2];
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubble_ApngDecode", 2, "start decode success, width = " + this.f179889b + " height = " + this.f179890c + " frameCount = " + this.f179891d);
                return;
            }
            return;
        }
        QLog.e("StickerBubble_ApngDecode", 1, "start decode error, errCode" + this.f179888a[5]);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public void complete() {
        if (this.f179893f != 0) {
            ApngImage.nativeFreeFrame(this.f179893f);
        }
        long j3 = this.f179894g;
        if (j3 != 0) {
            ApngImage.nativeFreeImage(j3);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getCurrentFrameIndex() {
        return this.f179895h;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getFrameCount() {
        return this.f179891d;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getFrameDelay() {
        return this.f179892e;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public void b() {
    }
}
