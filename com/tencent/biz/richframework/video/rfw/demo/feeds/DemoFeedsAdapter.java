package com.tencent.biz.richframework.video.rfw.demo.feeds;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.video.rfw.demo.view.DemoItemView;
import com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.superplayer.utils.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DemoFeedsAdapter extends RFWBaseVideoAdapter {
    public DemoFeedsAdapter(DemoFeedsVideoFragment demoFeedsVideoFragment) {
        super(demoFeedsVideoFragment);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 100;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public int getSceneId() {
        return -100;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter
    protected boolean isFeedScrollType() {
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter
    protected boolean needScrollManger() {
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        DemoItemView demoItemView = new DemoItemView(viewGroup.getContext());
        demoItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, (b.b() * 9) / 16));
        return new BaseListViewAdapter.BaseVH(demoItemView);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
    }
}
