package com.qzone.preview.photodanmaku.entity;

import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends AbsDanmaku {

    /* renamed from: d, reason: collision with root package name */
    protected float f49975d;

    /* renamed from: e, reason: collision with root package name */
    protected float f49976e;

    /* renamed from: f, reason: collision with root package name */
    protected int f49977f;

    /* renamed from: h, reason: collision with root package name */
    protected float[] f49978h;

    /* renamed from: i, reason: collision with root package name */
    protected float f49979i;

    public c(PhotoDanmakuConfig photoDanmakuConfig, a aVar, b bVar) {
        super(photoDanmakuConfig, aVar, bVar);
        this.f49975d = 0.0f;
        this.f49976e = -1.0f;
        this.f49978h = null;
    }

    protected float c(long j3) {
        return this.mScreenWidth - (((float) (j3 - this.mTime)) * this.f49979i);
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getBottom() {
        return this.f49976e + this.mPaintHeight;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float[] getCollisionRectAtTime(long j3) {
        if (!isMeasured()) {
            return null;
        }
        float c16 = c(j3);
        if (this.f49978h == null) {
            this.f49978h = new float[4];
        }
        float[] fArr = this.f49978h;
        fArr[0] = c16;
        float f16 = this.f49976e;
        fArr[1] = f16;
        fArr[2] = c16 + this.mPaintWidth;
        fArr[3] = f16 + this.mPaintHeight;
        return fArr;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getLeft() {
        return this.f49975d;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float[] getRectAtTime(long j3) {
        if (!isMeasured()) {
            return null;
        }
        float c16 = c(j3);
        if (this.f49978h == null) {
            this.f49978h = new float[4];
        }
        float[] fArr = this.f49978h;
        fArr[0] = c16;
        float f16 = this.f49976e;
        fArr[1] = f16;
        fArr[2] = c16 + this.mPaintWidth;
        fArr[3] = f16 + this.mPaintHeight;
        return fArr;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getRight() {
        return this.f49975d + this.mPaintWidth;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getSpeedX() {
        return -this.f49979i;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getTop() {
        return this.f49976e;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public int getType() {
        return 1;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public void onLayout(PhotoDanmakuDrawer photoDanmakuDrawer, float f16, float f17) {
        if (this.mTimer != null) {
            if (!isTimeOut()) {
                this.f49975d = c(this.mTimer.a());
                if (isShown()) {
                    return;
                }
                this.f49976e = f17;
                setVisibility(true);
                return;
            }
            setVisibility(false);
        }
        this.f49975d = this.mScreenWidth;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public void onMeasure(PhotoDanmakuDrawer photoDanmakuDrawer) {
        super.onMeasure(photoDanmakuDrawer);
        int i3 = (int) (this.mScreenWidth + this.mPaintWidth);
        this.f49977f = i3;
        this.f49979i = i3 / ((float) this.mDuration.c());
        this.f49975d = this.mScreenWidth;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public void onReLayout() {
        this.f49975d = c(this.mTimer.a());
    }
}
