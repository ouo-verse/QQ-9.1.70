package com.tencent.ad.tangram.widget.carouselcard;

import com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManager;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class TGCarouselCardLayoutManagerParams implements Cloneable {
    public int horizontalOffsetPx = 0;
    public int verticalOffsetPx = 20;
    public int maxVisibleItemCount = Integer.MAX_VALUE;
    public float scrollThreshold = 0.5f;
    public boolean canScrollByDragging = true;
    public boolean canScrollOverStartPosition = true;
    public int startPosition = 0;
    public WeakReference<TGCarouselCardLayoutManager.ILog> logger = null;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean isValid() {
        if (this.maxVisibleItemCount > 0 && this.scrollThreshold > 0.0f && this.startPosition >= 0) {
            return true;
        }
        return false;
    }
}
