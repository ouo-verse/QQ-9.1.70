package com.tencent.biz.qqcircle.immersive.layer.biz.inside.album;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleFeedAlbumInfoEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSPageIndexEvent;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name */
    private QFSLayerAlbumViewModel f86555d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAlbumBean f86556e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f86557f = true;

    public d(QCircleAlbumBean qCircleAlbumBean) {
        S9();
        this.f86556e = qCircleAlbumBean;
    }

    private int N9(List<e30.b> list) {
        if (this.f86556e != null && list != null && list.size() != 0) {
            if (list.size() > this.f86556e.getDataPosInList() && TextUtils.equals(this.f86556e.getFeed().f398449id.get(), list.get(this.f86556e.getDataPosInList()).g().f398449id.get())) {
                QLog.i(getTAG(), 1, "checkFindRealPosition return mInitBean.getFeedPosition() = " + this.f86556e.getDataPosInList());
                return this.f86556e.getDataPosInList();
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                e30.b bVar = list.get(i3);
                if (TextUtils.equals(bVar.g().f398449id.get(), this.f86556e.getFeed().f398449id.get())) {
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

    private void O9(UIStateData<List<e30.b>> uIStateData) {
        int state = uIStateData.getState();
        QLog.i(getTAG(), 1, "[firstEnterSelectPosition] state: " + state + ", mIsFirstEnter: " + this.f86557f);
        if (state == 1 || state == 4 || state == 0 || !this.f86557f) {
            return;
        }
        this.f86557f = false;
        if (uIStateData.getData() == null) {
            return;
        }
        final int N9 = N9(uIStateData.getData());
        if (N9 >= 0 && uIStateData.getData().size() > N9) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.W9(N9);
                }
            });
            return;
        }
        QLog.i(getTAG(), 1, "firstEnterSelectPosition return, list.size = " + uIStateData.getData().size() + " , position = " + N9);
    }

    private void P9(int i3, boolean z16) {
        ViewPager2 B = this.mLayerPageContainer.B();
        if (i3 >= 0 && i3 < this.mLayerPageAdapter.getItemCount()) {
            B.setCurrentItem(i3, z16);
        }
    }

    private void Q9(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        P9(c40.a.a(this.mLayerPageAdapter.getDataList(), feedCloudMeta$StFeed), z16);
    }

    private void R9(final QFSPageIndexEvent qFSPageIndexEvent) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.X9(qFSPageIndexEvent);
            }
        });
    }

    private void S9() {
        Intent intent;
        if (getActivity() != null && this.f86556e == null && (intent = getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleAlbumBean) {
                this.f86556e = (QCircleAlbumBean) serializableExtra;
            }
        }
    }

    private void T9() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.f86555d;
        if (qFSLayerAlbumViewModel == null) {
            return;
        }
        qFSLayerAlbumViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.Y9((UIStateData) obj);
            }
        });
    }

    private void U9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QCircleAlbumBean qCircleAlbumBean = this.f86556e;
        if (qCircleAlbumBean != null) {
            feedCloudMeta$StFeed = qCircleAlbumBean.getFeed();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        boolean z16 = !feedCloudMeta$StFeed.album_infos.get().isEmpty();
        if (z16) {
            this.f86555d.W2(feedCloudMeta$StFeed);
        }
        this.f86555d.j3(feedCloudMeta$StFeed.f398449id.get());
        this.f86555d.i3(2, z16);
    }

    private IDataDisplaySurface<e30.b> V9() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = (QFSLayerAlbumViewModel) getHostFragment().getViewModel(QFSLayerAlbumViewModel.class);
        this.f86555d = qFSLayerAlbumViewModel;
        qFSLayerAlbumViewModel.k3(this.f86556e);
        T9();
        U9();
        return this.f86555d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W9(int i3) {
        P9(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X9(QFSPageIndexEvent qFSPageIndexEvent) {
        QFSPageTurnContainer qFSPageTurnContainer;
        if (this.mLayerPageAdapter != null && (qFSPageTurnContainer = this.mLayerPageContainer) != null) {
            qFSPageTurnContainer.o(qFSPageIndexEvent.hasMoreData);
            Q9(qFSPageIndexEvent.stFeed, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(UIStateData uIStateData) {
        Z9(uIStateData);
        Q9(uIStateData);
        O9(uIStateData);
    }

    private void Z9(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData != null && uIStateData.getData() != null && uIStateData.getData().size() > 0) {
            FeedCloudMeta$StFeed g16 = uIStateData.getData().get(0).g();
            if (g16.album_infos.get().size() <= 0) {
                QLog.e("QFSLayerAlbumListPart", 1, "[setAlbumInfoUpdateEvent]: album_info size is 0!");
                return;
            }
            if (g16.album_infos.get(0) != null && g16.album_infos.get(0).album != null) {
                FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = g16.album_infos.get(0).album.get();
                QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$FeedAlbum.f398441id.get());
                qCircleFeedAlbumInfo.title = feedCloudMeta$FeedAlbum.title.get();
                qCircleFeedAlbumInfo.mFeedCount = feedCloudMeta$FeedAlbum.feed_count.get();
                SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedAlbumInfoEvent(qCircleFeedAlbumInfo));
                return;
            }
            QLog.e("QFSLayerAlbumListPart", 1, "[setAlbumInfoUpdateEvent]: failed to get album from album_info!");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSPageIndexEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        S9();
        return this.f86556e;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerAlbumListPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return V9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null) {
            return getHostFragment().isResumed();
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSPageIndexEvent) {
            R9((QFSPageIndexEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        int i3;
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.f86555d;
        if (qFSLayerAlbumViewModel == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        qFSLayerAlbumViewModel.h3(i3);
    }
}
