package com.tencent.image;

import android.graphics.Rect;
import com.tencent.image.RegionBitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RegionDrawDataList extends LinkedList<RegionBitmap.DrawData> {
    static IPatchRedirector $redirector_;
    HashMap<Rect, RegionBitmap.DrawData> mRegionDatas;

    public RegionDrawDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRegionDatas = new HashMap<>();
        }
    }

    public RegionBitmap.DrawData getRegionData(RegionBitmap.DrawData drawData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RegionBitmap.DrawData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawData);
        }
        Rect rect = drawData.mDrawRect;
        if (rect != null) {
            return this.mRegionDatas.get(rect);
        }
        return null;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(RegionBitmap.DrawData drawData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawData)).booleanValue();
        }
        this.mRegionDatas.put(drawData.mDrawRect, drawData);
        return super.add((RegionDrawDataList) drawData);
    }
}
