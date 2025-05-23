package com.tencent.ecommerce.biz.hr.adapter;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/image/URLDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "b", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final BitmapDrawable b(URLDrawable uRLDrawable) {
        if (uRLDrawable.getCurrDrawable() == null) {
            return null;
        }
        if (uRLDrawable.getCurrDrawable() instanceof RegionDrawable) {
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            if (currDrawable != null) {
                RegionDrawable regionDrawable = (RegionDrawable) currDrawable;
                if (regionDrawable.getBitmap() != null) {
                    return new BitmapDrawable(regionDrawable.getBitmap());
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.image.RegionDrawable");
            }
        }
        if (!(uRLDrawable.getCurrDrawable() instanceof BitmapDrawable)) {
            return null;
        }
        Drawable currDrawable2 = uRLDrawable.getCurrDrawable();
        if (currDrawable2 != null) {
            return (BitmapDrawable) currDrawable2;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }
}
