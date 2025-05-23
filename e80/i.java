package e80;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import g80.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends i60.d implements a.InterfaceC10363a {
    private QCircleExtraTypeInfo C;
    private com.tencent.biz.qqcircle.scrollers.b D;
    private boolean E;

    public i(int i3, List<MultiViewBlock> list, int i16, int i17) {
        super(i3, list, i16, i17);
    }

    private void C9(RecyclerView recyclerView) {
        BaseListViewAdapter baseListViewAdapter;
        if (this.D == null && recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter instanceof BaseListViewAdapter) {
                baseListViewAdapter = (BaseListViewAdapter) adapter;
            } else {
                baseListViewAdapter = null;
            }
            com.tencent.biz.qqcircle.scrollers.b bVar = new com.tencent.biz.qqcircle.scrollers.b(recyclerView.getContext(), recyclerView, baseListViewAdapter);
            this.D = bVar;
            bVar.d(new r90.c());
            this.D.l(this.C);
            recyclerView.addOnScrollListener(this.D);
            this.D.h(recyclerView);
            if (this.E) {
                B9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B9() {
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            this.E = false;
            bVar.i();
        } else {
            this.E = true;
        }
    }

    @Override // g80.a.InterfaceC10363a
    public void C(RecyclerView.ViewHolder viewHolder) {
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            bVar.j(viewHolder);
        }
    }

    @Override // g80.a.InterfaceC10363a
    public void L(@NonNull RecyclerView recyclerView) {
        C9(recyclerView);
    }

    @Override // g80.a.InterfaceC10363a
    public void a0(RecyclerView.ViewHolder viewHolder) {
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            bVar.k(viewHolder);
        }
    }

    @Override // i60.d, com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        BlockMerger blockMerger = this.mBlockContainer.getBlockMerger();
        if (blockMerger instanceof g80.a) {
            ((g80.a) blockMerger).i0(this);
            C9(this.mBlockContainer.getRecyclerView());
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            bVar.onDestroy();
        }
        QFSSearchPrerenderManager.E(getContext()).q();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            bVar.onStop();
        }
    }

    @Override // g80.a.InterfaceC10363a
    public void q2(@NonNull RecyclerView recyclerView) {
        com.tencent.biz.qqcircle.scrollers.b bVar = this.D;
        if (bVar != null) {
            recyclerView.removeOnScrollListener(bVar);
            this.D.onDestroy();
        }
    }
}
