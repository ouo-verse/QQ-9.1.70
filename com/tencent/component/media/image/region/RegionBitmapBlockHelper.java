package com.tencent.component.media.image.region;

import android.graphics.Rect;
import com.tencent.component.media.image.region.RegionBitmapDecoder;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RegionBitmapBlockHelper {
    public static final int REGION_BLOCK_SIZE = 1000;
    private Rect mImageRect;

    public RegionBitmapBlockHelper(Rect rect) {
        this.mImageRect = rect;
    }

    public LinkedList<RegionBitmapDecoder.DrawData> getDrawDatas(Rect rect, int i3) {
        if (rect != null && !rect.isEmpty()) {
            int i16 = i3 * 1000;
            int i17 = rect.left / i16;
            int i18 = rect.right;
            int i19 = i18 / i16;
            if (i18 % i16 != 0) {
                i19++;
            }
            int i26 = rect.bottom;
            int i27 = i26 / i16;
            if (i26 % i16 != 0) {
                i27++;
            }
            LinkedList<RegionBitmapDecoder.DrawData> linkedList = new LinkedList<>();
            for (int i28 = rect.top / i16; i28 < i27; i28++) {
                int i29 = i17;
                while (i29 < i19) {
                    Rect rect2 = new Rect();
                    int i36 = i29 * i16;
                    rect2.left = i36;
                    rect2.right = i36 + i16;
                    int i37 = i28 * i16;
                    rect2.top = i37;
                    rect2.bottom = i37 + i16;
                    i29++;
                    if (i29 == i19 || i28 + 1 == i27) {
                        rect2.intersect(this.mImageRect);
                    }
                    RegionBitmapDecoder.DrawData drawData = new RegionBitmapDecoder.DrawData();
                    drawData.mShowRect = rect2;
                    drawData.mDecodeSample = i3;
                    linkedList.add(drawData);
                }
            }
            return linkedList;
        }
        return null;
    }
}
