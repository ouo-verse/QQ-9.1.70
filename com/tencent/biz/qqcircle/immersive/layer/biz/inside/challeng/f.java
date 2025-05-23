package com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSTagChallengeSelectEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSTagChallengeSwitchEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTagChallengeInfoEvent;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends QFSLayerBaseMiddleListPart {
    private static final List<e30.b> D = new ArrayList();
    private QCircleLoadingDialog C;

    /* renamed from: d, reason: collision with root package name */
    private QFSLayerTagChallengeViewModel f86585d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleLayerBean f86586e;

    /* renamed from: h, reason: collision with root package name */
    private QCircleTagChallengeInfo f86588h;

    /* renamed from: f, reason: collision with root package name */
    private boolean f86587f = true;

    /* renamed from: i, reason: collision with root package name */
    private final LinkedHashMap<String, e30.b> f86589i = new LinkedHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private List<QCircleTagChallengeInfo> f86590m = new ArrayList();

    public f(QCircleLayerBean qCircleLayerBean) {
        this.f86586e = qCircleLayerBean;
        this.f86588h = qCircleLayerBean.getTagChallengeInfo();
    }

    private int O9(List<e30.b> list) {
        if (this.f86586e != null && list != null && list.size() != 0) {
            if (list.size() > this.f86586e.getDataPosInList() && TextUtils.equals(this.f86586e.getFeed().f398449id.get(), list.get(this.f86586e.getDataPosInList()).g().f398449id.get())) {
                QLog.i(getTAG(), 1, "checkFindRealPosition return mInitBean.getFeedPosition() = " + this.f86586e.getDataPosInList());
                return this.f86586e.getDataPosInList();
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                e30.b bVar = list.get(i3);
                if (TextUtils.equals(bVar.g().f398449id.get(), this.f86586e.getFeed().f398449id.get())) {
                    QLog.i(getTAG(), 1, "checkFindRealPosition return position = " + i3 + " , feedId = " + bVar.g().f398449id.get());
                    return i3;
                }
            }
            QLog.i(getTAG(), 1, "checkFindRealPosition return default position = 0");
            return 0;
        }
        QLog.e(getTAG(), 1, "checkFindRealPosition return unusual position = -1 UIStateData dataList is null");
        return -1;
    }

    private void P9() {
        this.f86589i.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(List<QCircleTagChallengeInfo> list) {
        List<QCircleTagChallengeInfo> list2 = this.f86590m;
        if (list2 != null) {
            list2.clear();
            this.f86590m.addAll(list);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSTagChallengeInfoEvent(list));
    }

    private void R9(UIStateData<List<e30.b>> uIStateData) {
        int state = uIStateData.getState();
        QLog.i(getTAG(), 1, "[firstEnterSelectPosition] state: " + state + ", mIsFirstEnter: " + this.f86587f);
        if (state == 1 || state == 4 || state == 0 || !this.f86587f) {
            return;
        }
        this.f86587f = false;
        if (uIStateData.getData() == null) {
            return;
        }
        int O9 = O9(uIStateData.getData());
        if (O9 >= 0 && uIStateData.getData().size() > O9) {
            X9(O9, false, 15L);
            return;
        }
        QLog.i(getTAG(), 1, "firstEnterSelectPosition return, list.size = " + uIStateData.getData().size() + " , position = " + O9);
    }

    private QCircleTagChallengeInfo S9() {
        List<QCircleTagChallengeInfo> list = this.f86590m;
        if (list != null && list.size() != 0) {
            return this.f86590m.get(0);
        }
        return null;
    }

    private QCircleTagChallengeInfo T9() {
        QCircleTagChallengeInfo S9;
        QLog.i("QFSLayerTagChallengeListPart", 1, "[getNextTagChallengeInfo] curTagChallengeInfo: " + this.f86588h);
        Iterator<QCircleTagChallengeInfo> it = this.f86590m.iterator();
        while (it.hasNext() && !it.next().mTagId.equals(this.f86588h.mTagId)) {
        }
        if (it.hasNext()) {
            S9 = it.next();
        } else {
            S9 = S9();
        }
        QLog.i("QFSLayerTagChallengeListPart", 1, "[getNextTagChallengeInfo] nextTagChallengeInfo: " + S9);
        return S9;
    }

    private void U9(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setTagChallengeInfo(qCircleTagChallengeInfo);
        this.f86585d.s2();
        this.f86585d.r2(qCircleLayerBean, false, false);
        QCircleLoadingDialog qCircleLoadingDialog = this.C;
        if (qCircleLoadingDialog != null) {
            qCircleLoadingDialog.showDialog();
        }
    }

    private void V9() {
        if (this.f86588h == null) {
            QLog.i("QFSLayerTagChallengeListPart", 1, "[handleForwardTag] mCurTagChallengeInfo == null.");
            return;
        }
        List<QCircleTagChallengeInfo> list = this.f86590m;
        if (list != null && list.size() != 0) {
            QCircleTagChallengeInfo T9 = T9();
            if (T9 == null) {
                QLog.e("QFSLayerTagChallengeListPart", 1, "[handleForwardTag] nextTagChallengeInfo == nul.");
                return;
            } else {
                if (ia(T9)) {
                    U9(T9);
                    return;
                }
                return;
            }
        }
        QLog.d("QFSLayerTagChallengeListPart", 1, "[handleForwardTag] mCurTagChallengeInfoList == null || mCurTagChallengeInfoList.size() == 0");
    }

    private void W9(int i3, boolean z16) {
        X9(i3, z16, 0L);
    }

    private void X9(final int i3, final boolean z16, long j3) {
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.ea(i3, z16);
            }
        }, j3);
    }

    private void Y9(QFSTagChallengeSelectEvent qFSTagChallengeSelectEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSTagChallengeSelectEvent.mStFeed;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSLayerTagChallengeListPart", 1, "[handleForwardTag] event.mStFeed == null.");
            return;
        }
        int b16 = c40.d.b(D, feedCloudMeta$StFeed);
        QLog.d("QFSLayerTagChallengeListPart", 1, "[handleForwardTag] getFeedIndex: ", Integer.valueOf(b16));
        if (b16 != -1) {
            W9(b16, false);
            return;
        }
        this.f86587f = true;
        this.f86586e.setFeed(qFSTagChallengeSelectEvent.mStFeed);
        this.f86586e.setTagChallengeInfo(qFSTagChallengeSelectEvent.mTagChallengeInfo);
        this.f86585d.s2();
        this.f86585d.q2(this.f86586e, false);
    }

    private void Z9(QFSTagChallengeSwitchEvent qFSTagChallengeSwitchEvent) {
        if (!QFSLayerTagChallengeViewModel.H && qFSTagChallengeSwitchEvent.getSwitchDirection() == 0) {
            V9();
        }
    }

    private void aa(e30.b bVar) {
        QCircleTagChallengeInfo c16 = c40.d.c(bVar);
        this.f86588h = c16;
        this.f86585d.t2(c16);
    }

    private void ba() {
        if (this.C == null) {
            QCircleLoadingDialog qCircleLoadingDialog = new QCircleLoadingDialog(getContext());
            this.C = qCircleLoadingDialog;
            qCircleLoadingDialog.S(getContext().getResources().getString(R.string.f185393og));
        }
    }

    private void ca() {
        QFSLayerTagChallengeViewModel qFSLayerTagChallengeViewModel = this.f86585d;
        if (qFSLayerTagChallengeViewModel == null) {
            return;
        }
        qFSLayerTagChallengeViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.this.ga((UIStateData) obj);
            }
        });
        this.f86585d.k2().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.this.Q9((List) obj);
            }
        });
    }

    private IDataDisplaySurface<e30.b> da() {
        QFSLayerTagChallengeViewModel qFSLayerTagChallengeViewModel = (QFSLayerTagChallengeViewModel) getHostFragment().getViewModel(QFSLayerTagChallengeViewModel.class);
        this.f86585d = qFSLayerTagChallengeViewModel;
        qFSLayerTagChallengeViewModel.p2(this.f86586e);
        return this.f86585d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea(int i3, boolean z16) {
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer == null) {
            return;
        }
        ViewPager2 B = qFSPageTurnContainer.B();
        B.setAnimation(null);
        QLog.d(getTAG(), 1, "[handlePageIndex] itemCount: ", Integer.valueOf(this.mLayerPageAdapter.getNUM_BACKGOURND_ICON()), ", pageIndex: ", Integer.valueOf(i3), ", smoothScroll: ", Boolean.valueOf(z16));
        if (i3 >= 0 && i3 < this.mLayerPageAdapter.getNUM_BACKGOURND_ICON()) {
            B.setCurrentItem(i3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(UIStateData uIStateData) {
        ja(uIStateData);
        UIStateData<List<e30.b>> dataList = uIStateData.copy().setDataList(D);
        Z9(dataList);
        R9(dataList);
        la(dataList.getData());
        if (uIStateData.getState() != 1) {
            if (this.C == null) {
                ba();
            }
            this.C.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha() {
        QLog.i("QFSLayerTagChallengeListPart", 1, "[onPartCreate] WinkPublish, preload wink.");
        QCirclePluginInitHelper.PreloadWink(getActivity());
    }

    private boolean ia(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        int i3;
        QCircleTagChallengeInfo qCircleTagChallengeInfo2 = this.f86588h;
        if (qCircleTagChallengeInfo2 != null && qCircleTagChallengeInfo != null) {
            QLog.d("QFSLayerTagChallengeListPart", 1, "[moveToTagChallenge] mCurTagChallengeInfo: ", qCircleTagChallengeInfo2, ", nextTagChallengeInfo: ", qCircleTagChallengeInfo);
            if (this.f86588h.mTagId.equals(qCircleTagChallengeInfo.mTagId)) {
                QLog.d("QFSLayerTagChallengeListPart", 1, "[moveToTagChallenge] mCurTagChallengeInfo.mTagId.equals(nextTagChallengeInfo.mTagId).");
                return false;
            }
            String str = qCircleTagChallengeInfo.mTagId;
            if (this.f86590m != null) {
                i3 = 0;
                while (i3 < this.f86590m.size()) {
                    QCircleTagChallengeInfo qCircleTagChallengeInfo3 = this.f86590m.get(i3);
                    if (qCircleTagChallengeInfo3 != null && qCircleTagChallengeInfo3.mTagId.equals(str)) {
                        break;
                    }
                    i3++;
                }
            }
            i3 = -1;
            QLog.i("QFSLayerTagChallengeListPart", 1, "[moveToTagChallenge] targetTagIndex: " + i3);
            if (i3 == -1) {
                return false;
            }
            this.f86588h = qCircleTagChallengeInfo;
            return true;
        }
        QLog.d("QFSLayerTagChallengeListPart", 1, "[moveToTagChallenge] mCurTagChallengeInfo == null || nextTagChallengeInfo == null.");
        return false;
    }

    private void ja(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData != null && uIStateData.getData() != null) {
            List<e30.b> list = D;
            list.clear();
            list.addAll(uIStateData.getData());
        }
    }

    private void la(List<e30.b> list) {
        if (list != null && list.size() != 0) {
            for (e30.b bVar : list) {
                QCircleTagChallengeInfo c16 = c40.d.c(bVar);
                if (c16 != null && !this.f86589i.containsKey(c16.mTagId)) {
                    QLog.d("QFSLayerTagChallengeListPart", 1, "[updateTagToFirstFeedMap] tagChallengeInfo.mTagId: ", c16.mTagId);
                    this.f86589i.put(c16.mTagId, bVar);
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSTagChallengeSelectEvent.class);
        eventClass.add(QFSTagChallengeSwitchEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f86586e;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return da();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str) && (obj instanceof e30.b)) {
            aa((e30.b) obj);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null) {
            return getHostFragment().isResumed();
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ca();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng.b
            @Override // java.lang.Runnable
            public final void run() {
                f.this.ha();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        P9();
        D.clear();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        QCircleLoadingDialog qCircleLoadingDialog = this.C;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            this.C.dismiss();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSTagChallengeSelectEvent) {
            Y9((QFSTagChallengeSelectEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSTagChallengeSwitchEvent) {
            Z9((QFSTagChallengeSwitchEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        super.requestData(z16, z17);
        if (this.f86585d == null) {
            return;
        }
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setTagChallengeInfo(this.f86588h);
        this.f86585d.q2(qCircleLayerBean, z16);
    }
}
