package com.tencent.biz.qqcircle.immersive.layer.base;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleFeedBase$StMiddlePageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class e extends QFSLayerBaseViewModel {
    protected static String J = "qq_aio|qzone|qq_gzh|push|qq_contacts";
    protected final MutableLiveData<Integer> E = new MutableLiveData<>(-1);
    protected final MutableLiveData<e30.b> F = new MutableLiveData<>(null);
    private int G;
    private QCircleInitBean H;
    private com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a I;

    private ArrayList<e30.b> X1(ArrayList<e30.b> arrayList) {
        e30.b bVar;
        ArrayList<e30.b> arrayList2 = new ArrayList<>();
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                bVar = arrayList.get(i3);
                if (bVar.b(String.valueOf(bVar.g().dittoFeed.dittoId.get())) instanceof QQCircleDitto$StItemContainer) {
                    break;
                }
                arrayList2.add(bVar);
                i3++;
            } else {
                bVar = null;
                break;
            }
        }
        if (bVar != null) {
            this.F.postValue(bVar);
        }
        return arrayList2;
    }

    private ArrayList<e30.b> Z1(List<FeedCloudMeta$StFeed> list) {
        int i3;
        if (this.E.getValue() != null) {
            i3 = this.E.getValue().intValue();
        } else {
            i3 = -1;
        }
        ArrayList<e30.b> b16 = e30.d.b(list);
        ArrayList<e30.b> arrayList = new ArrayList<>();
        if (i3 == 1) {
            arrayList.addAll(X1(b16));
        } else {
            arrayList.addAll(b16);
        }
        return arrayList;
    }

    private boolean c2() {
        QCircleInitBean qCircleInitBean = this.H;
        if (qCircleInitBean != null && qCircleInitBean.isSingleFeed()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(UIStateData uIStateData) {
        this.D.setValue(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U1(String str, boolean z16, QCircleInitBean qCircleInitBean) {
        if (!VSNetworkHelper.isProtocolCache(str)) {
            QCirclePluginGlobalInfo.Z(z16);
            if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
                QCircleDTLoginReporter.daTongLoginReportMiddlePage(qCircleInitBean.getSchemeAttrs(), QCirclePluginGlobalInfo.H());
            }
        }
    }

    public void W1() {
        this.E.postValue(0);
    }

    public MutableLiveData<Integer> a2() {
        return this.E;
    }

    public MutableLiveData<e30.b> b2() {
        return this.F;
    }

    public void e2(int i3) {
        this.G = i3;
    }

    public void f2(QCircleInitBean qCircleInitBean) {
        this.H = qCircleInitBean;
    }

    public void g2(com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a aVar) {
        this.I = aVar;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerBaseMiddleViewModel";
    }

    public boolean h2() {
        return false;
    }

    public void i2(List<FeedCloudMeta$StFeed> list) {
        if (list == null) {
            QLog.d(getTAG(), 1, "[syncCacheFeedsData] feeds is null. ");
            return;
        }
        this.C.clear();
        this.C.addAll(Z1(list));
        this.D.postValue(UIStateData.obtainSuccess(true).setData(false, this.C).setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged()).setFakeData(true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j2(QQCircleFeedBase$StMiddlePageData qQCircleFeedBase$StMiddlePageData) {
        int i3;
        int i16;
        if (qQCircleFeedBase$StMiddlePageData != null && qQCircleFeedBase$StMiddlePageData.jumpSMShowType != null) {
            if (this.E.getValue() != null) {
                i3 = this.E.getValue().intValue();
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                return;
            }
            if (qQCircleFeedBase$StMiddlePageData.jumpSMShowType.get() == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            this.E.postValue(Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k2(boolean z16, List<FeedCloudMeta$StFeed> list, boolean z17, int i3) {
        int i16;
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a aVar = this.I;
        if (aVar != null) {
            aVar.d(list);
        }
        if (h2() && !c2()) {
            ArrayList arrayList = new ArrayList(list);
            if (z20.f.k().c(this.C, arrayList, this.G, z16)) {
                list = arrayList;
                i3 = 1;
            } else {
                list = arrayList;
            }
        }
        if (!z16) {
            this.C.clear();
        }
        if (list == null) {
            QLog.d(getTAG(), 1, "[syncLayerFeedsData] feeds is null. ");
            return;
        }
        if (this.E.getValue() != null) {
            i16 = this.E.getValue().intValue();
        } else {
            i16 = -1;
        }
        if (i16 == -1) {
            this.E.postValue(0);
        }
        int size = this.C.size();
        ArrayList<e30.b> Z1 = Z1(list);
        if (this.F.getValue() != null) {
            z17 = true;
        }
        this.C.addAll(Z1);
        if (z16) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, Z1.size());
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

    public UIStateData<List<e30.b>> l2(List<FeedCloudMeta$StFeed> list) {
        if (list == null) {
            QLog.d(getTAG(), 1, "[syncSetCacheFeedsData] feeds is null. ");
            return null;
        }
        boolean h26 = h2();
        if (h26 && !c2()) {
            ArrayList arrayList = new ArrayList(list);
            z20.f.k().c(new ArrayList(), arrayList, 0, false);
            list = arrayList;
        }
        QLog.d(getTAG(), 1, "[syncSetCacheFeedsData] feeds size: " + RFSafeListUtils.getSize(list) + " | isSupportLoadMoreBackUp: " + h26);
        this.C.clear();
        this.C.addAll(Z1(list));
        final UIStateData<List<e30.b>> fakeData = UIStateData.obtainSuccess(true).setData(false, this.C).setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged()).setFakeData(true);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.D.setValue(fakeData);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.base.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.d2(fakeData);
                }
            });
        }
        return fakeData;
    }
}
