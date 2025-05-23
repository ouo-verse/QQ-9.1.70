package com.tencent.biz.richframework.video.rfw.demo.feeds;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DemoFeedsVideoFragment extends CompatPublicFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = new RecyclerView(viewGroup.getContext());
        final DemoFeedsAdapter demoFeedsAdapter = new DemoFeedsAdapter(this);
        recyclerView.setAdapter(demoFeedsAdapter);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.biz.richframework.video.rfw.demo.feeds.DemoFeedsVideoFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView2, @NonNull RecyclerView.State state) {
                rect.bottom = ImmersiveUtils.dpToPx(20.0f);
            }
        });
        recyclerView.setBackgroundColor(-1);
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.demo.feeds.DemoFeedsVideoFragment.2
            @Override // java.lang.Runnable
            public void run() {
                demoFeedsAdapter.onDataRefresh();
            }
        }, 500L);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, recyclerView);
        return recyclerView;
    }
}
