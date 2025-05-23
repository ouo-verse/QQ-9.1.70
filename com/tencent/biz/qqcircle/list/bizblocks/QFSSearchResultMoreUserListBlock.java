package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchQueryFixResultItemView;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StCorrectionInfo;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import feedcloud.FeedCloudRead$StRecReasonInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultMoreUserListBlock extends QFSSearchResultBaseTabBlock {
    private static final int MORE_USER_TYPE = 1;
    private static final int QUERY_FIX_TYPE = 0;
    private static final String TAG = "QFSSearchResultMoreUserListBlock";
    private final Map<String, FeedCloudRead$StRecReasonInfo> mRecReasonInfoMap;
    private String mTransferInfo;
    private com.tencent.biz.qqcircle.immersive.search.a queryFixClickListener;

    public QFSSearchResultMoreUserListBlock(Bundle bundle) {
        super(bundle);
        this.mRecReasonInfoMap = new ConcurrentHashMap();
    }

    private void bindRecInfo(RecyclerView.ViewHolder viewHolder, int i3) {
        View view = viewHolder.itemView;
        Object obj = this.mDataList.get(i3);
        if ((view instanceof QFSSearchUserResultItemView) && (obj instanceof FeedCloudMeta$StUser)) {
            ((QFSSearchUserResultItemView) view).setRecReasonInfo(this.mRecReasonInfoMap.get(((FeedCloudMeta$StUser) obj).f398463id.get()));
        }
    }

    private boolean checkDataIsQueryFixType(int i3) {
        List<E> list = this.mDataList;
        if (list == 0 || i3 < 0 || list.size() <= i3 || !(this.mDataList.get(i3) instanceof FeedCloudRead$StCorrectionInfo)) {
            return false;
        }
        return !TextUtils.isEmpty(((FeedCloudRead$StCorrectionInfo) this.mDataList.get(i3)).correction_word.get());
    }

    private boolean checkQueryFixDataExistence(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp.searchUserInfo.correction_info.get().has()) {
            return !TextUtils.isEmpty(feedCloudRead$StGetSearchPageRsp.searchUserInfo.correction_info.correction_word.get());
        }
        return false;
    }

    private RecyclerView.ViewHolder createMoreUserViewHolder(ViewGroup viewGroup) {
        QFSSearchUserResultItemView qFSSearchUserResultItemView = new QFSSearchUserResultItemView(viewGroup.getContext());
        qFSSearchUserResultItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchUserResultItemView.setTransferInfo(this.mTransferInfo);
        return new BaseListBlock.BaseListVH(qFSSearchUserResultItemView);
    }

    private RecyclerView.ViewHolder createQueryFixViewHolder(@NonNull ViewGroup viewGroup) {
        QFSSearchQueryFixResultItemView qFSSearchQueryFixResultItemView = new QFSSearchQueryFixResultItemView(viewGroup.getContext());
        qFSSearchQueryFixResultItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchQueryFixResultItemView.setQueryFixClickListener(this.queryFixClickListener);
        qFSSearchQueryFixResultItemView.setSearchInfo(this.currentSearchInfo);
        qFSSearchQueryFixResultItemView.v0();
        return new BaseListBlock.BaseListVH(qFSSearchQueryFixResultItemView);
    }

    private void getRecReasonInfoFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp != null && feedCloudRead$StGetSearchPageRsp.searchUserInfo.reason.get().size() != 0) {
            for (FeedCloudRead$StRecReasonInfo feedCloudRead$StRecReasonInfo : new ArrayList(feedCloudRead$StGetSearchPageRsp.searchUserInfo.reason.get())) {
                this.mRecReasonInfoMap.put(feedCloudRead$StRecReasonInfo.uid.get(), feedCloudRead$StRecReasonInfo);
            }
        }
    }

    public void disableRequestCorrection() {
        this.requestWrapper.f(false);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_USER_VERTICAL_SEARCH_PAGE;
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
        arrayList.add(2);
        if (canSearchCorrection()) {
            arrayList.add(15);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        bindRecInfo(viewHolder, i3);
        super.onBindViewHolder(viewHolder, i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return createMoreUserViewHolder(viewGroup);
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
        this.mRecReasonInfoMap.clear();
    }

    public void setQueryFixClickListener(com.tencent.biz.qqcircle.immersive.search.a aVar) {
        this.queryFixClickListener = aVar;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        return feedCloudRead$StGetSearchPageRsp.searchUserInfo.attachInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        return feedCloudRead$StGetSearchPageRsp.searchUserInfo.isOver.get() == 1;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSSearchResultBaseTabBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Object> getListDataFromRsp(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z16) {
        if (feedCloudRead$StGetSearchPageRsp == null) {
            QLog.e(TAG, 1, "[getListDataFromRsp] rsp is null");
            return new ArrayList();
        }
        printSearchPageData(feedCloudRead$StGetSearchPageRsp);
        if (checkQueryFixDataExistence(feedCloudRead$StGetSearchPageRsp)) {
            this.currentStCorrectionInfo = feedCloudRead$StGetSearchPageRsp.searchUserInfo.correction_info.get();
        }
        this.mTransferInfo = feedCloudRead$StGetSearchPageRsp.searchReportData.get();
        getRecReasonInfoFromRsp(feedCloudRead$StGetSearchPageRsp);
        return new ArrayList(feedCloudRead$StGetSearchPageRsp.searchUserInfo.userList.get());
    }
}
