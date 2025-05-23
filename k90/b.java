package k90;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.bizparts.c;
import com.tencent.biz.qqcircle.immersive.views.search.mixuser.QFSSearchMixUserResultView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudRead$StSearchMixPageUserInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends c {
    private QFSSearchMixUserResultView C;
    private i60.a D;

    public b(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchMixUserResultView qFSSearchMixUserResultView = new QFSSearchMixUserResultView(viewGroup.getContext());
        this.C = qFSSearchMixUserResultView;
        qFSSearchMixUserResultView.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setOnClickMoreListener(this.D);
        this.C.setFragment(getParentFragment());
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchMixUserResultBlock";
    }

    public void i0(i60.a aVar) {
        this.D = aVar;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list == 0 || this.C == null || !(list.get(i3) instanceof FeedCloudRead$StSearchMixPageUserInfo)) {
            return;
        }
        this.C.setData((FeedCloudRead$StSearchMixPageUserInfo) this.mDataList.get(i3));
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.D = null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
