package e90;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.bizparts.c;
import com.tencent.biz.qqcircle.immersive.views.search.mixtag.QFSSearchMixTagResultView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudRead$StSearchMixPageTagInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends c {
    private QFSSearchMixTagResultView C;

    public b(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchMixTagResultView qFSSearchMixTagResultView = new QFSSearchMixTagResultView(viewGroup.getContext());
        this.C = qFSSearchMixTagResultView;
        qFSSearchMixTagResultView.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setFragment(getParentFragment());
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchMixTagResultBlock";
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list == 0 || this.C == null || !(list.get(i3) instanceof FeedCloudRead$StSearchMixPageTagInfo)) {
            return;
        }
        this.C.setData((FeedCloudRead$StSearchMixPageTagInfo) this.mDataList.get(i3));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
