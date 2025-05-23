package com.tencent.richframework.data.idata;

import androidx.lifecycle.MutableLiveData;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IDataDisplaySurface<T> {
    MutableLiveData<UIStateData<List<T>>> getDisplaySurfaceData(Object... objArr);

    int getDisplaySurfaceType();

    void loadMoreForDisplaySurface(Object... objArr);
}
