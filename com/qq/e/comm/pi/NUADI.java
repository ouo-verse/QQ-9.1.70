package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NUADI {
    String getAdNetWorkName();

    void loadData(int i3);

    void loadData(int i3, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i3);

    void setMinVideoDuration(int i3);

    void setVideoADContainerRender(int i3);

    void setVideoPlayPolicy(int i3);
}
