package com.qzone.preview.photodanmaku.entity;

import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends AbsDanmaku {
    public e(PhotoDanmakuConfig photoDanmakuConfig, a aVar, b bVar) {
        super(photoDanmakuConfig, aVar, bVar);
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getBottom() {
        return 0.0f;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getLeft() {
        return 0.0f;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getRight() {
        return 0.0f;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getSpeedX() {
        return 0.0f;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float getTop() {
        return 0.0f;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public int getType() {
        return 0;
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float[] getCollisionRectAtTime(long j3) {
        return new float[4];
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public float[] getRectAtTime(long j3) {
        return new float[4];
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public void onReLayout() {
    }

    @Override // com.qzone.preview.photodanmaku.entity.AbsDanmaku
    public void onLayout(PhotoDanmakuDrawer photoDanmakuDrawer, float f16, float f17) {
    }
}
