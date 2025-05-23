package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchQueryFixResultItemView;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchResultMoreTagView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StCorrectionInfo;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultMoreTagListBlock extends QFSSearchResultBaseTabBlock {
    private static final int MORE_TAG_TYPE = 1;
    private static final int QUERY_FIX_TYPE = 0;
    private static final String TAG = "QFSSearchResultMoreTagListBlock";
    private String mTransferInfo;
    private com.tencent.biz.qqcircle.immersive.search.a queryFixClickListener;

    public QFSSearchResultMoreTagListBlock(Bundle bundle) {
        super(bundle);
    }

    private boolean checkDataIsQueryFixType(int i3) {
        List<E> list = this.mDataList;
        if (list == 0 || i3 < 0 || list.size() <= i3 || !(this.mDataList.get(i3) instanceof FeedCloudRead$StCorrectionInfo)) {
            return false;
        }
        return !TextUtils.isEmpty(((FeedCloudRead$StCorrectionInfo) this.mDataList.get(i3)).correction_word.get());
    }

    private boolean checkQueryFixDataExistence(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp.searchTagInfo.correction_info.get().has()) {
            return !TextUtils.isEmpty(feedCloudRead$StGetSearchPageRsp.searchTagInfo.correction_info.correction_word.get());
        }
        return false;
    }

    private RecyclerView.ViewHolder createMoreTagViewHolder(@NonNull ViewGroup viewGroup) {
        QFSSearchResultMoreTagView qFSSearchResultMoreTagView = new QFSSearchResultMoreTagView(viewGroup.getContext());
        qFSSearchResultMoreTagView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchResultMoreTagView.setTransferInfo(this.mTransferInfo);
        return new BaseListBlock.BaseListVH(qFSSearchResultMoreTagView);
    }

    private RecyclerView.ViewHolder createQueryFixViewHolder(@NonNull ViewGroup viewGroup) {
        QFSSearchQueryFixResultItemView qFSSearchQueryFixResultItemView = new QFSSearchQueryFixResultItemView(viewGroup.getContext());
        qFSSearchQueryFixResultItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchQueryFixResultItemView.setQueryFixClickListener(this.queryFixClickListener);
        qFSSearchQueryFixResultItemView.setSearchInfo(this.currentSearchInfo);
        qFSSearchQueryFixResultItemView.v0();
        return new BaseListBlock.BaseListVH(qFSSearchQueryFixResultItemView);
    }

    public void disableRequestCorrection() {
        this.requestWrapper.f(false);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_VERTICAL_SEARCH_PAGE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (checkDataIsQueryFixType(i3)) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock
    protected List<Integer> getRequestList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        if (canSearchCorrection()) {
            arrayList.add(15);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return createMoreTagViewHolder(viewGroup);
        }
        return createQueryFixViewHolder(viewGroup);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock
    public void reset() {
        super.reset();
        resetStatus();
    }

    public void resetStatus() {
        this.currentStCorrectionInfo = null;
        clearData();
        this.requestWrapper.f(true);
    }

    public void setQueryFixClickListener(com.tencent.biz.qqcircle.immersive.search.a aVar) {
        this.queryFixClickListener = aVar;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        return feedCloudRead$StGetSearchPageRsp.searchTagInfo.attachInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        return feedCloudRead$StGetSearchPageRsp.searchTagInfo.isOver.get() == 1;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Object> getListDataFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z16) {
        if (feedCloudRead$StGetSearchPageRsp == null) {
            return new ArrayList();
        }
        printSearchPageData(feedCloudRead$StGetSearchPageRsp);
        if (checkQueryFixDataExistence(feedCloudRead$StGetSearchPageRsp)) {
            this.currentStCorrectionInfo = feedCloudRead$StGetSearchPageRsp.searchTagInfo.correction_info.get();
        }
        this.mTransferInfo = feedCloudRead$StGetSearchPageRsp.searchReportData.get();
        return new ArrayList(feedCloudRead$StGetSearchPageRsp.searchTagInfo.tagList.get());
    }
}
