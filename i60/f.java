package i60;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultMoreTagListBlock;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends g {
    private final QFSSearchResultMoreTagListBlock D;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    public f() {
        super(R.id.f52532a2, null, 1, 1);
        QFSSearchResultMoreTagListBlock qFSSearchResultMoreTagListBlock = new QFSSearchResultMoreTagListBlock(null);
        this.D = qFSSearchResultMoreTagListBlock;
        this.mPeerBlocks.add(qFSSearchResultMoreTagListBlock);
        initListener();
    }

    private void C9(QFSSearchInfo qFSSearchInfo) {
        HashMap hashMap = new HashMap();
        if (qFSSearchInfo != null) {
            hashMap.put("xsj_query_text", qFSSearchInfo.f());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QUERY_SOURCE, Integer.valueOf(qFSSearchInfo.e()));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.SEARCH_QUERY_ID, qFSSearchInfo.c());
        }
        ua0.i.i(getActivity(), getHostFragment().getView(), QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_VERTICAL_SEARCH_PAGE, hashMap);
    }

    private void D9(QFSSearchInfo qFSSearchInfo) {
        String f16 = qFSSearchInfo.f();
        this.f407299i = f16;
        this.D.setSearchKey(f16);
        this.D.setCurrentSearchInfo(qFSSearchInfo);
        LoadInfo loadInfo = new LoadInfo();
        loadInfo.setCurrentState(2);
        this.D.loadData(loadInfo);
        C9(qFSSearchInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(QFSSearchInfo qFSSearchInfo) {
        NestScrollRecyclerView recyclerView;
        this.C = true;
        this.D.resetStatus();
        this.D.disableRequestCorrection();
        D9(qFSSearchInfo);
        this.C = false;
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer != null && (recyclerView = blockContainer.getRecyclerView()) != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private void initListener() {
        this.D.setQueryFixClickListener(new com.tencent.biz.qqcircle.immersive.search.a() { // from class: i60.e
            @Override // com.tencent.biz.qqcircle.immersive.search.a
            public final void a(QFSSearchInfo qFSSearchInfo) {
                f.this.E9(qFSSearchInfo);
            }
        });
    }

    public void F9() {
        this.C = false;
        this.D.reset();
        x9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_search_action_with_keyword".equals(str) && (obj instanceof QFSSearchInfo)) {
            this.f407300m = (QFSSearchInfo) obj;
            this.D.resetStatus();
            D9(this.f407300m);
        }
    }

    @Override // i60.d, com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D.setOnGetDataListener(this);
        this.D.addOnScrollListener(new a());
    }
}
