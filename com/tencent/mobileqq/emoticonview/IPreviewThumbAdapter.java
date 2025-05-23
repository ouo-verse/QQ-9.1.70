package com.tencent.mobileqq.emoticonview;

import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public interface IPreviewThumbAdapter extends AdapterView.OnItemClickListener, ListAdapter {

    /* loaded from: classes12.dex */
    public interface IThumbItemClickListener {
        void onThumbClick(int i3);
    }

    String getCurrentPath();

    ArrayList<String> getDataList();

    void notifyDataSetChanged();

    void setCurrentPath(String str);

    void setData(ArrayList<String> arrayList);
}
