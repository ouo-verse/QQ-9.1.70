package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QFSUpdateFeedListEvent;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.immersive.utils.ab;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFullScreenFeedListRequest;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o extends QFSLayerBaseViewModel {
    private int E = -1;
    private String F;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void d2(final BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final QCircleInitBean qCircleInitBean) {
        S1(z16, baseRequest, j3, str, "requestFullScreenFeeds");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.n
            @Override // java.lang.Runnable
            public final void run() {
                o.this.c2(baseRequest, z16, j3, str, feedCloudRead$StGetFeedListRsp, qCircleInitBean);
            }
        });
    }

    private ArrayList<FeedCloudMeta$StFeed> X1(ArrayList<FeedCloudMeta$StFeed> arrayList, String str) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<FeedCloudMeta$StFeed> arrayList2 = new ArrayList<>();
            Iterator<FeedCloudMeta$StFeed> it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                FeedCloudMeta$StFeed next = it.next();
                int b16 = bj.b(arrayList2, next);
                if (next != null && b16 == -1) {
                    arrayList2.add(next);
                } else if (b16 > -1) {
                    z16 = true;
                }
            }
            if (z16) {
                QLog.d("GFF-QFSFullScreenViewModel", 1, "[filterRepeatFeed] traceId: " + str + " | repeat feed array.");
            }
            return arrayList2;
        }
        return arrayList;
    }

    private List<e30.b> Z1(List<e30.b> list, List<e30.b> list2) {
        if (list != null && !list.isEmpty()) {
            if (list2 != null && !list2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (e30.b bVar : list2) {
                    int b16 = bj.b(list, bVar);
                    if (bVar != null && b16 == -1) {
                        arrayList.add(bVar);
                    }
                }
                return arrayList;
            }
            if (list2 == null) {
                return new ArrayList();
            }
            return list2;
        }
        if (list2 == null) {
            return new ArrayList();
        }
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2, reason: merged with bridge method [inline-methods] */
    public void c2(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, QCircleInitBean qCircleInitBean) {
        Integer num;
        String traceId;
        FeedCloudMeta$StFeed feed;
        boolean z17;
        boolean z18;
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = null;
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null) {
            num = Integer.valueOf(qCircleInitBean.getExtraTypeInfo().sourceType);
        } else {
            num = null;
        }
        int intValue = num.intValue();
        String str2 = "null";
        if (baseRequest == null) {
            traceId = "null";
        } else {
            traceId = baseRequest.getTraceId();
        }
        if (qCircleInitBean == null) {
            feed = null;
        } else {
            feed = qCircleInitBean.getFeed();
        }
        if (feed != null) {
            str2 = feed.f398449id.get();
        }
        QLog.e("GFF-QFSFullScreenViewModel", 1, "[handleFeedListResponse] retCode: " + j3 + " | errMsg: " + str + " | traceId: " + traceId + " | feedId: " + str2 + " | sourceType: " + intValue);
        if (z16 && feedCloudRead$StGetFeedListRsp != null && j3 == 0) {
            boolean z19 = !TextUtils.isEmpty(this.f86506m.getStringAttachInfo());
            this.f86506m.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
            this.f86506m.setAdAttachInfo(feedCloudRead$StGetFeedListRsp.adAttchInfo.get());
            LoadInfo loadInfo = this.f86506m;
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            loadInfo.setFinish(z17);
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt2 = feedCloudRead$StGetFeedListRsp.extInfo;
            if (feedCloudCommon$StCommonExt2 != null) {
                feedCloudCommon$StCommonExt = feedCloudCommon$StCommonExt2.get();
            }
            updateSession(feedCloudCommon$StCommonExt);
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                try {
                    qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("GFF-QFSFullScreenViewModel", 1, "[handleFeedListResponse] error: ", e16);
                }
            }
            ArrayList<FeedCloudMeta$StFeed> X1 = X1((ArrayList) feedCloudRead$StGetFeedListRsp.vecFeed.get(), traceId);
            f2(X1, feed);
            w20.a.j().initOrUpdateGlobalState((List) e30.d.b(X1), true);
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            i2(traceId, z19, X1, z18, 0);
            w20.a.j().initOrUpdateGlobalState((List) this.C, true);
            this.f86506m.setCurrentState(4);
            return;
        }
        this.f86506m.setCurrentState(4);
        this.D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
    }

    private boolean b2(List<FeedCloudMeta$StFeed> list, List<e30.b> list2) {
        FeedCloudMeta$StFeed g16;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) RFSafeListUtils.get(list, 0);
        e30.b bVar = (e30.b) RFSafeListUtils.get(list2, 0);
        String str2 = null;
        if (bVar == null) {
            g16 = null;
        } else {
            g16 = bVar.g();
        }
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (g16 != null) {
            str2 = g16.f398449id.get();
        }
        return TextUtils.equals(str, str2);
    }

    private void f2(List<FeedCloudMeta$StFeed> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102085", true) && list != null && feedCloudMeta$StFeed != null) {
            if (list.size() == 0) {
                QLog.d("GFF-QFSFullScreenViewModel", 1, "rps feeds is empty. ");
                list.add(feedCloudMeta$StFeed);
                return;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = list.get(0);
            if (TextUtils.equals(feedCloudMeta$StFeed2.f398449id.get(), feedCloudMeta$StFeed.f398449id.get())) {
                QLog.d("GFF-QFSFullScreenViewModel", 4, "replace same feed. ");
                list.add(0, feedCloudMeta$StFeed);
                list.remove(feedCloudMeta$StFeed2);
            } else {
                QLog.d("GFF-QFSFullScreenViewModel", 4, "insert outside feed. ");
                list.add(0, feedCloudMeta$StFeed);
            }
        }
    }

    private void i2(String str, boolean z16, List<FeedCloudMeta$StFeed> list, boolean z17, int i3) {
        int size;
        boolean z18;
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (list == null) {
            QLog.d(getTAG(), 1, "[setFeedListValue] feeds should not is null.");
            return;
        }
        if (!z16) {
            z18 = b2(list, this.C);
            if (!z18) {
                this.C.clear();
                size = this.C.size();
            } else {
                if (z18 && list.size() >= 2) {
                    list = list.subList(1, list.size());
                }
                z16 = true;
                size = 1;
            }
        } else {
            size = this.C.size();
            z18 = false;
        }
        ArrayList<e30.b> b16 = e30.d.b(list);
        QLog.d("GFF-QFSFullScreenViewModel", 1, "[setFeedListValue] blockSources size: " + b16.size() + " | feeds size: " + list.size() + " | isFinish:" + z17 + " | traceId: " + str + " | isLoadMore: " + z16 + " | startPosition: " + size + " | isFirstFeedEquals: " + z18);
        this.C.addAll(Z1(this.C, b16));
        if (z16) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, b16.size());
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        UIStateData<List<e30.b>> pos = UIStateData.obtainSuccess(false).setData(z16, this.C).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(z17).setPos(i3);
        if (this.C.size() <= 0 && uq3.c.I()) {
            pos = UIStateData.obtainEmpty().setLoadMore(z16).setFinish(z17);
        }
        this.D.postValue(pos);
        QCirclePushInfoManager.e().j(list);
    }

    public void e2(int i3) {
        if (!uq3.c.M5()) {
            return;
        }
        if (i3 < 0) {
            this.E = i3;
            return;
        }
        e30.b bVar = (e30.b) RFSafeListUtils.get(this.C, this.E);
        SimpleEventBus.getInstance().dispatchEvent(new QFSUpdateFeedListEvent(bj.g(bVar), (e30.b) RFSafeListUtils.get(this.C, i3), 1));
        this.E = i3;
    }

    public void g2(final QCircleInitBean qCircleInitBean, boolean z16, boolean z17) {
        QCircleGetFeedListRequest qCircleGetFeedListRequest;
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null) {
            int i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
            if (i3 == 0) {
                qCircleInitBean.getExtraTypeInfo().sourceType = ab.x(qCircleInitBean);
            }
            if (ab.p()) {
                qCircleGetFeedListRequest = new QCircleGetFullScreenFeedListRequest(qCircleInitBean, this.f86506m.getStringAttachInfo(), (String) null, (String) null);
            } else {
                qCircleGetFeedListRequest = new QCircleGetFeedListRequest(qCircleInitBean, this.f86506m.getStringAttachInfo(), (String) null, (String) null);
                qCircleGetFeedListRequest.setLoadFullScreenFeed(ab.r(qCircleInitBean));
            }
            qCircleGetFeedListRequest.setIsLoadMore(z16);
            qCircleGetFeedListRequest.setDtPageId(this.F);
            qCircleGetFeedListRequest.mRequest.extInfo.set(getSession(!z16));
            qCircleGetFeedListRequest.mRequest.adres.set(com.tencent.biz.qqcircle.immersive.utils.j.f90213a.l("", 88));
            qCircleGetFeedListRequest.setEnableCache(z17);
            this.D.setValue(UIStateData.obtainLoading());
            QLog.d("GFF-QFSFullScreenViewModel", 1, "[requestFullScreenFeeds] isLoadMore: " + z16 + " | enableCache: " + z17 + " | sourceType: " + i3);
            sendRequest(qCircleGetFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.m
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                    o.this.d2(qCircleInitBean, baseRequest, z18, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
                }
            });
            return;
        }
        QLog.e("GFF-QFSFullScreenViewModel", 1, "[requestFullScreenFeeds] bean should not be null or extra type empty.");
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GFF-QFSFullScreenViewModel";
    }

    public void h2(String str) {
        this.F = str;
    }

    public void j2(List<FeedCloudMeta$StFeed> list) {
        if (list == null) {
            QLog.d(getTAG(), 1, "[syncCacheFeedsData] feeds is null. ");
            return;
        }
        this.C.clear();
        ArrayList<e30.b> b16 = e30.d.b(list);
        this.C.addAll(b16);
        this.D.postValue(UIStateData.obtainSuccess(true).setData(false, this.C).setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged()).setFakeData(true));
        w20.a.j().initOrUpdateGlobalState((List) b16, true);
    }
}
