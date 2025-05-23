package com.tencent.biz.richframework.video.rfw.drive;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes5.dex */
public interface IRFWViewPager2AdapterDrive {
    RecyclerView.ViewHolder finViewHolderByPos(int i3);

    List getDataList();

    String getDataSingleKey(int i3);

    Fragment getHostFragment();

    int getSceneId();

    String getSourceType();

    String getUniquePageId();

    boolean isSimpleFeed(int i3);

    boolean mayPreloadPreVideo();

    boolean showReNotify(RecyclerView.ViewHolder viewHolder);
}
