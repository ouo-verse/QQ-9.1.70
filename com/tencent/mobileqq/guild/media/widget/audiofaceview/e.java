package com.tencent.mobileqq.guild.media.widget.audiofaceview;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends LinearLayoutManager {
    public e(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            QLog.e("QGMC.SafeLinearLayoutManager", 1, e16, new Object[0]);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public e(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }
}
