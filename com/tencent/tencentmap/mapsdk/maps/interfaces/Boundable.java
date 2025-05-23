package com.tencent.tencentmap.mapsdk.maps.interfaces;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface Boundable<T extends Projection> {
    Rect getBound(T t16);

    List<Boundable<T>> getGroupBounds();

    Rect getScreenBound(T t16);
}
