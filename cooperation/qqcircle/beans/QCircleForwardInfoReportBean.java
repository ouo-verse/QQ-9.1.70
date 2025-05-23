package cooperation.qqcircle.beans;

import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleForwardInfoReportBean implements Serializable {
    public static final long serialVersionUID = 1;
    private HostForwardUtils.ForwardInfoEntity mForwardEntity;
    private final List<HostForwardUtils.ForwardInfoEntity> mMultiShareEntityList = new ArrayList();
    private int mPageId;
    private int mParentPageId;
    private QCircleForwardExtraTypeInfo mReportExtra;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QCircleForwardExtraTypeInfo implements Serializable {
        public static final long serialVersionUID = 1;
        public FeedCloudMeta$StFeed feed;
        public boolean isMultiSelect;
        public boolean isMutualShare = false;
        public String mCurrentPersonalUin;
        public int mDataPosition;
        public String mDtCustomPgId;
        public Map<String, Object> mExtMap;
        public String mGlobalViewModelKey;
        public int mPlayScene;
        public int pageType;
        public int sourceType;
        public String title;
    }

    public HostForwardUtils.ForwardInfoEntity getForwardEntity() {
        return this.mForwardEntity;
    }

    public List<HostForwardUtils.ForwardInfoEntity> getMultiShareEntityList() {
        return this.mMultiShareEntityList;
    }

    public int getPageId() {
        return this.mPageId;
    }

    public int getParentPageId() {
        return this.mParentPageId;
    }

    public QCircleForwardExtraTypeInfo getReportExtra() {
        return this.mReportExtra;
    }

    public void setForwardEntity(HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        this.mForwardEntity = forwardInfoEntity;
    }

    public void setMultiShareEntityList(List<HostForwardUtils.ForwardInfoEntity> list) {
        if (list != null && !list.isEmpty()) {
            this.mMultiShareEntityList.addAll(list);
        }
    }

    public void setPageId(int i3) {
        this.mPageId = i3;
    }

    public void setParentPageId(int i3) {
        this.mParentPageId = i3;
    }

    public void setReportExtra(QCircleForwardExtraTypeInfo qCircleForwardExtraTypeInfo) {
        this.mReportExtra = qCircleForwardExtraTypeInfo;
    }
}
