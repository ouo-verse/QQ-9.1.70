package com.tencent.biz.qqcircle.richframework.part.block.base;

import android.view.View;
import com.tencent.biz.richframework.part.block.base.GalleryLayoutManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements GalleryLayoutManager.ItemTransformer {
    @Override // com.tencent.biz.richframework.part.block.base.GalleryLayoutManager.ItemTransformer
    public void transformItem(GalleryLayoutManager galleryLayoutManager, View view, float f16) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float abs = 1.0f - (Math.abs(f16) * 0.05f);
        view.setScaleX(abs);
        view.setScaleY(abs);
    }
}
