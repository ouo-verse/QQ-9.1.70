package com.tencent.mobileqq.qcircle.api.global;

import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxBasicDrawInfo;
import feedcloud.FeedCloudWrite$PushBoxDrawAllRsp;
import feedcloud.FeedCloudWrite$PushBoxDrawGiftResult;
import feedcloud.FeedCloudWrite$PushBoxDrawRocketRsp;
import feedcloud.FeedCloudWrite$PushShowOffBtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes16.dex */
public class QFSPushOpenBoxInfo {
    private FeedCloudWrite$PushBoxDrawGiftResult mGiftResult;
    private FeedCloudWrite$PushShowOffBtn mShowOffBtnInfo;
    private Boolean mIsEnableContinueOpen = Boolean.FALSE;
    private List<QFSPushOpenBoxResultBean> mResultList = new ArrayList();
    private String mSource = "";
    private String mDetailUrl = "";

    public static QFSPushOpenBoxInfo convertToOpenMultiBoxInfo(FeedCloudWrite$PushBoxDrawAllRsp feedCloudWrite$PushBoxDrawAllRsp) {
        QFSPushOpenBoxInfo qFSPushOpenBoxInfo = new QFSPushOpenBoxInfo();
        if (feedCloudWrite$PushBoxDrawAllRsp != null && feedCloudWrite$PushBoxDrawAllRsp.drawBoxResult.get() != null && feedCloudWrite$PushBoxDrawAllRsp.drawBoxResult.size() != 0) {
            qFSPushOpenBoxInfo.setIsEnableContinueOpen(!feedCloudWrite$PushBoxDrawAllRsp.isEnd.get());
            qFSPushOpenBoxInfo.setDetailUrl(feedCloudWrite$PushBoxDrawAllRsp.taskCenterJumpUrl.get());
            qFSPushOpenBoxInfo.setGiftResult(feedCloudWrite$PushBoxDrawAllRsp.gift_result.get());
            qFSPushOpenBoxInfo.setShowOffBtnInfo(feedCloudWrite$PushBoxDrawAllRsp.show_off_btn.get());
            ArrayList arrayList = new ArrayList();
            for (FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic : feedCloudWrite$PushBoxDrawAllRsp.drawBoxResult.get()) {
                if (feedCloudWrite$PushBoxBasic.drawBoxInfo.get() != null && feedCloudWrite$PushBoxBasic.drawBoxInfo.size() != 0) {
                    Iterator<FeedCloudWrite$PushBoxBasicDrawInfo> it = feedCloudWrite$PushBoxBasic.drawBoxInfo.get().iterator();
                    while (it.hasNext()) {
                        arrayList.add(convertToResultBean(it.next()));
                    }
                } else {
                    return qFSPushOpenBoxInfo;
                }
            }
            qFSPushOpenBoxInfo.setResultList(arrayList);
        }
        return qFSPushOpenBoxInfo;
    }

    public static QFSPushOpenBoxInfo convertToOpenSingleBoxInfo(FeedCloudWrite$PushBoxDrawRocketRsp feedCloudWrite$PushBoxDrawRocketRsp) {
        QFSPushOpenBoxInfo qFSPushOpenBoxInfo = new QFSPushOpenBoxInfo();
        if (feedCloudWrite$PushBoxDrawRocketRsp != null && feedCloudWrite$PushBoxDrawRocketRsp.drawBoxResult.get() != null && feedCloudWrite$PushBoxDrawRocketRsp.drawBoxResult.get() != null) {
            qFSPushOpenBoxInfo.setDetailUrl(feedCloudWrite$PushBoxDrawRocketRsp.taskCenterJumpUrl.get());
            qFSPushOpenBoxInfo.setGiftResult(feedCloudWrite$PushBoxDrawRocketRsp.gift_result.get());
            qFSPushOpenBoxInfo.setShowOffBtnInfo(feedCloudWrite$PushBoxDrawRocketRsp.show_off_btn.get());
            ArrayList arrayList = new ArrayList();
            Iterator<FeedCloudWrite$PushBoxBasicDrawInfo> it = feedCloudWrite$PushBoxDrawRocketRsp.drawBoxResult.drawBoxInfo.get().iterator();
            while (it.hasNext()) {
                arrayList.add(convertToResultBean(it.next()));
            }
            qFSPushOpenBoxInfo.setResultList(arrayList);
        }
        return qFSPushOpenBoxInfo;
    }

    public static QFSPushOpenBoxResultBean convertToResultBean(FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo) {
        QFSPushOpenBoxResultBean qFSPushOpenBoxResultBean = new QFSPushOpenBoxResultBean();
        qFSPushOpenBoxResultBean.setRocketCount(feedCloudWrite$PushBoxBasicDrawInfo.count.get());
        qFSPushOpenBoxResultBean.setTreasureType(feedCloudWrite$PushBoxBasicDrawInfo.box_type.get());
        qFSPushOpenBoxResultBean.setTreasureMultiple(feedCloudWrite$PushBoxBasicDrawInfo.rate.get());
        return qFSPushOpenBoxResultBean;
    }

    public String getDetailUrl() {
        return this.mDetailUrl;
    }

    public FeedCloudWrite$PushBoxDrawGiftResult getGiftResult() {
        return this.mGiftResult;
    }

    public boolean getIsEnableContinueOpen() {
        return this.mIsEnableContinueOpen.booleanValue();
    }

    public List<QFSPushOpenBoxResultBean> getResultList() {
        return this.mResultList;
    }

    public FeedCloudWrite$PushShowOffBtn getShowOffBtnInfo() {
        return this.mShowOffBtnInfo;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setDetailUrl(String str) {
        this.mDetailUrl = str;
    }

    public void setGiftResult(FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult) {
        this.mGiftResult = feedCloudWrite$PushBoxDrawGiftResult;
    }

    public void setIsEnableContinueOpen(boolean z16) {
        this.mIsEnableContinueOpen = Boolean.valueOf(z16);
    }

    public void setResultList(List<QFSPushOpenBoxResultBean> list) {
        this.mResultList.clear();
        this.mResultList.addAll(list);
    }

    public void setShowOffBtnInfo(FeedCloudWrite$PushShowOffBtn feedCloudWrite$PushShowOffBtn) {
        this.mShowOffBtnInfo = feedCloudWrite$PushShowOffBtn;
    }

    public void setSource(String str) {
        this.mSource = str;
    }
}
