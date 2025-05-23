package com.tencent.qqlive.module.videoreport.inject.xrecyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AndroidXRVCollector {
    private static final String TAG = "AndroidXRecyclerCollector";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        private static final AndroidXRVCollector sInstance = new AndroidXRVCollector();

        InstanceHolder() {
        }
    }

    public static AndroidXRVCollector getInstance() {
        return InstanceHolder.sInstance;
    }

    public void onSetXRVAdapter(RecyclerView recyclerView) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onSetXRVAdapter, recyclerView = " + UIUtils.getViewInfo(recyclerView));
        }
        EventCollector.getInstance().onSetXRVAdapter(recyclerView);
    }

    public void onXRVBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onXRVBindViewHolder, holder = " + BaseUtils.getClassSimpleName(viewHolder) + ", position = " + i3);
        }
        EventCollector.getInstance().onAndroidXRVItemReuse(viewHolder, j3);
    }

    public void onXRVBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onXRVBindViewHolder2, holder = " + BaseUtils.getClassSimpleName(viewHolder) + ", position = " + i3);
        }
        EventCollector.getInstance().onAndroidXRVItemReuse(viewHolder, j3);
    }
}
