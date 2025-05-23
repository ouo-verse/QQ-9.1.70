package com.tencent.image;

import android.graphics.Rect;
import com.tencent.image.RegionBitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RegionBitmapBlockHelper {
    static IPatchRedirector $redirector_ = null;
    static final int REGION_BLOCK_SIZE = 1000;
    private Rect mImageRect;
    private Rect mRegionRect;

    public RegionBitmapBlockHelper(Rect rect, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rect, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mImageRect = rect;
            this.mRegionRect = RegionBitmap.decodeToRegion(i3, i16, rect);
        }
    }

    public LinkedList<Rect> getBlocks(Rect rect, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LinkedList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rect, i3);
        }
        if (rect != null && !rect.isEmpty()) {
            int i16 = rect.left / 1000;
            int i17 = (rect.right / 1000) + 1;
            int i18 = (rect.bottom / 1000) + 1;
            LinkedList<Rect> linkedList = new LinkedList<>();
            for (int i19 = rect.top / 1000; i19 < i18; i19++) {
                int i26 = i16;
                while (i26 < i17) {
                    Rect rect2 = new Rect();
                    int i27 = i26 * 1000;
                    rect2.left = i27;
                    rect2.right = i27 + 1000;
                    int i28 = i19 * 1000;
                    rect2.top = i28;
                    rect2.bottom = i28 + 1000;
                    i26++;
                    if (i26 == i17 || i19 + 1 == i18) {
                        rect2.intersect(this.mImageRect);
                    }
                    linkedList.add(rect2);
                }
            }
            return linkedList;
        }
        return null;
    }

    public LinkedList<Rect> getBlocksExceptRegion(Rect rect, LinkedList<Rect> linkedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LinkedList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) rect, (Object) linkedList);
        }
        if (rect != null && !rect.isEmpty()) {
            LinkedList<Rect> linkedList2 = new LinkedList<>();
            Iterator<Rect> it = linkedList.iterator();
            while (it.hasNext()) {
                Rect next = it.next();
                if (!Rect.intersects(rect, next)) {
                    linkedList2.add(next);
                }
            }
            return linkedList2;
        }
        return null;
    }

    public LinkedList<RegionBitmap.DrawData> getDrawDatas(RegionDrawableData regionDrawableData, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LinkedList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) regionDrawableData, i3);
        }
        Rect rect = regionDrawableData.mShowArea;
        if (rect != null && !rect.isEmpty()) {
            int i16 = ((i3 * 1000) * regionDrawableData.mTargetDensity) / regionDrawableData.mSourceDensity;
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
            LinkedList<RegionBitmap.DrawData> linkedList = new LinkedList<>();
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
                        rect2.intersect(this.mRegionRect);
                    }
                    RegionBitmap.DrawData drawData = new RegionBitmap.DrawData();
                    drawData.mDrawRect = rect2;
                    drawData.mDecodeSample = i3;
                    linkedList.add(drawData);
                }
            }
            return linkedList;
        }
        return null;
    }
}
