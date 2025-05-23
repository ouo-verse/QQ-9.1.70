package com.tencent.mobileqq.emoticonview;

import android.widget.ListAdapter;
import java.util.List;

/* loaded from: classes12.dex */
public interface IEmotionHotPicSearchAdapter extends ListAdapter {
    int getWidthPixels();

    void setCurrentListView(EmotionPanelListView emotionPanelListView);

    void setData(List<EmotionPanelData> list);

    void setWidthPixels(int i3);
}
