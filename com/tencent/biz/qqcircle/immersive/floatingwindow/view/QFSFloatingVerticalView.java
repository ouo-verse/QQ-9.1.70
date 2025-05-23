package com.tencent.biz.qqcircle.immersive.floatingwindow.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.immersive.floatingwindow.event.QFSFloatingMuteIconEvent;
import com.tencent.biz.qqcircle.immersive.floatingwindow.event.QFSFloatingPlayPauseEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.QFSLayerPolymerizeDetailViewModel;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.launcher.parser.f;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFloatingVerticalView extends FrameLayout implements Observer<UIStateData<List<e30.b>>> {
    private boolean C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private QFSPageTurnContainer f86407d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.floatingwindow.view.a f86408e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f86409f;

    /* renamed from: h, reason: collision with root package name */
    private QFSLayerPolymerizeDetailViewModel f86410h;

    /* renamed from: i, reason: collision with root package name */
    private QCirclePolymerizeDetailBean f86411i;

    /* renamed from: m, reason: collision with root package name */
    private List<p40.a> f86412m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSPageTurnContainer.h {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.h
        public void onLoadData(boolean z16, int i3) {
            QFSFloatingVerticalView.this.K(z16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QFSFloatingVerticalView.this.D(i3);
            QFSFloatingVerticalView.this.l(i3);
        }
    }

    public QFSFloatingVerticalView(@NonNull Context context) {
        super(context);
        this.f86412m = new ArrayList();
        this.C = false;
        this.D = -1;
        A();
    }

    private void A() {
        try {
            LayoutInflater.from(getContext()).inflate(u(), this);
        } catch (Throwable th5) {
            QLog.d("QFP-QFSFloatingVerticalView", 1, "initView error:" + th5.toString());
        }
        QFSPageTurnContainer qFSPageTurnContainer = (QFSPageTurnContainer) findViewById(R.id.f165301vg1);
        this.f86407d = qFSPageTurnContainer;
        qFSPageTurnContainer.setTag(TagData.TAG_DATA_ID, new QCircleReportBean());
        i();
        this.f86407d.setRefreshEnable(false);
        this.f86409f = (ImageView) findViewById(R.id.uyy);
        com.tencent.biz.qqcircle.immersive.floatingwindow.view.a aVar = new com.tencent.biz.qqcircle.immersive.floatingwindow.view.a();
        this.f86408e = aVar;
        aVar.setHostFragment(new Fragment());
        this.f86407d.B().setAdapter(this.f86408e);
        this.f86410h = new QFSLayerPolymerizeDetailViewModel();
        this.f86407d.setOnLoadDataCallback(new a());
        this.f86407d.B().registerOnPageChangeCallback(new b());
        this.f86407d.B().setUserInputEnabled(false);
        QFSLayerPolymerizeDetailViewModel qFSLayerPolymerizeDetailViewModel = new QFSLayerPolymerizeDetailViewModel();
        this.f86410h = qFSLayerPolymerizeDetailViewModel;
        qFSLayerPolymerizeDetailViewModel.j().observeForever(this);
        J();
    }

    private void B() {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.floatingwindow.view.QFSFloatingVerticalView.3
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerPolymerizeDetailViewModel qFSLayerPolymerizeDetailViewModel = QFSFloatingVerticalView.this.f86410h;
                FeedCloudMeta$StFeed feed = QFSFloatingVerticalView.this.f86411i.getFeed();
                if (qFSLayerPolymerizeDetailViewModel != null && feed != null) {
                    ArrayList arrayList = new ArrayList();
                    if (QFSFloatingVerticalView.this.f86411i.getFeedByteArray() == null) {
                        return;
                    }
                    FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                    try {
                        feedCloudMeta$StFeed.mergeFrom(QFSFloatingVerticalView.this.f86411i.getFeedByteArray());
                        arrayList.add(feedCloudMeta$StFeed);
                        qFSLayerPolymerizeDetailViewModel.i2(arrayList);
                    } catch (InvalidProtocolBufferMicroException unused) {
                    }
                }
            }
        });
    }

    @NonNull
    private static HashMap<String, String> I() {
        String S1 = uq3.c.S1();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key_scheme", S1);
        try {
            Uri parse = Uri.parse(S1);
            for (String str : parse.getQueryParameterNames()) {
                if (!TextUtils.isEmpty(str)) {
                    String queryParameter = parse.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        hashMap.put(str.toLowerCase(), queryParameter);
                    }
                }
            }
        } catch (Exception unused) {
            QLog.d("QFP-QFSFloatingVerticalView", 1, "parse attrs error");
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z16, boolean z17) {
        this.f86410h.s2(this.f86411i, true, !z16);
    }

    private void i() {
        this.f86407d.removeView(this.f86407d.findViewById(R.id.f54652fs));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f86407d.y().getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.f86407d.y().setLayoutParams(layoutParams);
    }

    private void j(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.f86409f != null) {
            Option targetView = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.f86409f);
            targetView.setSupportRecycler(true);
            targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            this.f86409f.setVisibility(0);
            if (bi.l(this.f86409f, targetView, feedCloudMeta$StFeed)) {
                return;
            }
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3) {
        boolean z16;
        if (this.f86412m.size() == 0) {
            return;
        }
        e30.b p16 = p();
        QLog.d("QFP-QFSFloatingVerticalView", 1, "onPageSelected:island:" + gb0.b.z(p16.g()) + ",currentPos:" + i3);
        for (p40.a aVar : this.f86412m) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.q(p16, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(List<e30.b> list) {
        QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean = this.f86411i;
        if (qCirclePolymerizeDetailBean != null && qCirclePolymerizeDetailBean.getFeed() != null && this.f86411i.getFeed().f398449id.get().startsWith("share_fake_") && this.f86408e != null && list != null && list.size() >= 1 && !list.get(0).g().f398449id.get().startsWith("share_fake_")) {
            this.f86408e.notifyDataSetChanged();
        }
    }

    private List<e30.b> n(List<e30.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (e30.b bVar : list) {
                if (n.e(bVar.g()) == 1003) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private RFWPlayer r() {
        QFSPageTurnContainer qFSPageTurnContainer = this.f86407d;
        if (qFSPageTurnContainer != null && this.f86408e != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f86408e.getRecyclerView().findViewHolderForAdapterPosition(qFSPageTurnContainer.B().getCurrentItem());
            if (findViewHolderForAdapterPosition == null) {
                QLog.d("QFP-QFSFloatingVerticalView", 1, "cant find target holder");
                return null;
            }
            RFWVideoView rFWVideoView = (RFWVideoView) findViewHolderForAdapterPosition.itemView.findViewById(R.id.f74163vi);
            if (rFWVideoView != null && rFWVideoView.getQCirclePlayer() != null) {
                return rFWVideoView.getQCirclePlayer();
            }
            QLog.d("QFP-QFSFloatingVerticalView", 1, "cant find target videoView");
            return null;
        }
        QLog.d("QFP-QFSFloatingVerticalView", 1, "may be not init");
        return null;
    }

    private int u() {
        return R.layout.gc5;
    }

    private String v() {
        return "QFP-QFSFloatingVerticalView";
    }

    private void y(final UIStateData<List<e30.b>> uIStateData) {
        this.f86408e.I0(uIStateData.getData(), false, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.floatingwindow.view.QFSFloatingVerticalView.5
            @Override // java.lang.Runnable
            public void run() {
                if (QFSFloatingVerticalView.this.f86408e != null && QFSFloatingVerticalView.this.f86407d != null) {
                    QFSFloatingVerticalView.this.f86408e.onFeedSelected(new RFWFeedSelectInfo(QFSFloatingVerticalView.this.f86407d.B().getCurrentItem()).setSelectedType("TYPE_SELECT_ADAPTER_MODIFY"));
                    QFSFloatingVerticalView.this.D(uIStateData.getPos());
                }
            }
        });
    }

    protected void C(final int i3, final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.floatingwindow.view.QFSFloatingVerticalView.6
            @Override // java.lang.Runnable
            public void run() {
                if (QFSFloatingVerticalView.this.f86408e == null) {
                    return;
                }
                QFSFloatingVerticalView.this.f86408e.onFeedSelected(new RFWFeedSelectInfo(i3).setSelectedType(str));
            }
        });
    }

    protected void D(int i3) {
        QFSPageTurnContainer qFSPageTurnContainer = this.f86407d;
        if (qFSPageTurnContainer == null) {
            return;
        }
        int q16 = qFSPageTurnContainer.q();
        this.f86407d.k(i3, q16);
        this.f86407d.i(i3, q16);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onChanged(UIStateData<List<e30.b>> uIStateData) {
        x(uIStateData);
    }

    public void F(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCirclePolymerizeDetailBean s16 = new f().s(new QCircleSchemeBean().setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_POLYMERIZE_DETAIL).setAttrs(I()).setByteAttrs(null));
        this.f86411i = s16;
        s16.setFeed(feedCloudMeta$StFeed);
        j(feedCloudMeta$StFeed);
        B();
        K(true, false);
    }

    public void G(int i3) {
        e30.b p16 = p();
        if (p16 == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSFloatingPlayPauseEvent(p16.g().f398449id.get(), i3));
    }

    public void H(boolean z16) {
        e30.b p16 = p();
        if (p16 == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSFloatingMuteIconEvent(p16.g().f398449id.get(), z16));
    }

    public void J() {
        w20.a.j().registerDisplaySurface(w(), this.f86410h);
    }

    public void h(p40.a aVar) {
        if (this.f86412m.contains(aVar)) {
            return;
        }
        this.f86412m.add(aVar);
    }

    public void k() {
        QFSLayerPolymerizeDetailViewModel qFSLayerPolymerizeDetailViewModel = this.f86410h;
        if (qFSLayerPolymerizeDetailViewModel != null) {
            qFSLayerPolymerizeDetailViewModel.j().removeObserver(this);
        }
        com.tencent.biz.qqcircle.immersive.floatingwindow.view.a aVar = this.f86408e;
        if (aVar != null) {
            aVar.onDestroy();
        }
        com.tencent.biz.qqcircle.immersive.floatingwindow.view.a aVar2 = this.f86408e;
        if (aVar2 != null && aVar2.getScrollManger() != null) {
            this.f86408e.getScrollManger().onDestroy();
        }
        this.f86412m.clear();
    }

    public ImageView o() {
        QFSPageTurnContainer qFSPageTurnContainer = this.f86407d;
        if (qFSPageTurnContainer != null && this.f86408e != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f86408e.getRecyclerView().findViewHolderForAdapterPosition(qFSPageTurnContainer.B().getCurrentItem());
            if (findViewHolderForAdapterPosition == null) {
                QLog.d("QFP-QFSFloatingVerticalView", 1, "cant find target holder");
                return null;
            }
            return (ImageView) findViewHolderForAdapterPosition.itemView.findViewById(R.id.f363714d);
        }
        QLog.d("QFP-QFSFloatingVerticalView", 1, "may be not init");
        return null;
    }

    public e30.b p() {
        com.tencent.biz.qqcircle.immersive.floatingwindow.view.a aVar = this.f86408e;
        if (aVar != null && this.f86407d != null) {
            if (aVar.getItemCount() <= this.f86407d.B().getCurrentItem()) {
                QLog.d("QFP-QFSFloatingVerticalView", 1, "error size");
                return null;
            }
            boolean z16 = gb0.b.z(this.f86408e.getItem(this.f86407d.B().getCurrentItem()).g());
            int currentItem = this.f86407d.B().getCurrentItem();
            if (currentItem != this.D || this.C != z16) {
                QLog.d("QFP-QFSFloatingVerticalView", 1, "getCurrentFeed,island:" + z16 + ",currentPos:" + currentItem);
                this.D = currentItem;
                this.C = z16;
            }
            return this.f86408e.getItem(currentItem);
        }
        QLog.d("QFP-QFSFloatingVerticalView", 1, "error params");
        return null;
    }

    public QFSVideoView q() {
        QFSPageTurnContainer qFSPageTurnContainer = this.f86407d;
        if (qFSPageTurnContainer != null && this.f86408e != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f86408e.getRecyclerView().findViewHolderForAdapterPosition(qFSPageTurnContainer.B().getCurrentItem());
            if (findViewHolderForAdapterPosition == null) {
                QLog.d("QFP-QFSFloatingVerticalView", 1, "cant find target holder");
                return null;
            }
            return (QFSVideoView) findViewHolderForAdapterPosition.itemView.findViewById(R.id.f74163vi);
        }
        QLog.d("QFP-QFSFloatingVerticalView", 1, "may be not init");
        return null;
    }

    public int s() {
        QFSPageTurnContainer qFSPageTurnContainer = this.f86407d;
        if (qFSPageTurnContainer != null) {
            return qFSPageTurnContainer.B().getCurrentItem();
        }
        return -1;
    }

    public void setEnterImgVisible(int i3) {
        ImageView imageView = this.f86409f;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public long t() {
        RFWPlayer r16 = r();
        if (r16 == null) {
            return 0L;
        }
        return r16.getCurrentPositionMs();
    }

    public String w() {
        return String.valueOf(hashCode());
    }

    protected void x(UIStateData<List<e30.b>> uIStateData) {
        QLog.d(v(), 1, "FeedLine_ listUIStateData = " + uIStateData.getState());
        ba.e(uIStateData.getData(), s());
        if (this.f86407d != null && this.f86408e != null) {
            int state = uIStateData.getState();
            uIStateData.setDataList(n(uIStateData.getData()));
            if (state != 2 && state != 3) {
                if (state == 7) {
                    y(uIStateData);
                }
            } else {
                QLog.i(v(), 1, "handleFeedsRsp() return success  , size = " + uIStateData.getData().size() + " , isLoadMore = " + uIStateData.getIsLoadMore() + " , isFinish = " + uIStateData.getIsFinish() + " , isUpTurning = " + uIStateData.getIsUpTurning());
                z(uIStateData);
            }
            if (state != 1) {
                this.f86407d.p(!uIStateData.getIsFinish());
                this.f86407d.o(!uIStateData.getIsFinish());
            }
        }
    }

    protected void z(final UIStateData<List<e30.b>> uIStateData) {
        final int pos = uIStateData.getPos();
        if (uIStateData.isFakeData()) {
            this.f86407d.setFakeLoadingMoreAnim();
        } else if (this.f86407d.I()) {
            this.f86407d.l();
        }
        if (uIStateData.getIsLoadMore()) {
            y(uIStateData);
        } else {
            this.f86408e.I0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.floatingwindow.view.QFSFloatingVerticalView.4
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("QFP-QFSFloatingVerticalView", 1, "[handleSuccessState] setDataList call, pos: " + pos);
                    if (QFSFloatingVerticalView.this.f86408e != null && QFSFloatingVerticalView.this.f86408e.getDataList().size() != 0 && QFSFloatingVerticalView.this.f86407d != null) {
                        QFSFloatingVerticalView.this.m((List) uIStateData.getData());
                        int currentItem = QFSFloatingVerticalView.this.f86407d.B().getCurrentItem();
                        int i3 = pos;
                        if (currentItem != i3) {
                            QLog.d("QFP-QFSFloatingVerticalView", 1, "[handleSuccessState] setDataList setCurrentItem: " + pos);
                            QFSFloatingVerticalView.this.f86407d.B().setCurrentItem(pos, false);
                            return;
                        }
                        QFSFloatingVerticalView.this.D(i3);
                        if (!uq3.c.e0()) {
                            QLog.d("QFP-QFSFloatingVerticalView", 1, "[handleSuccessState] setDataList notify selected return");
                            return;
                        }
                        QLog.d("QFP-QFSFloatingVerticalView", 1, "[handleSuccessState] setDataList notify selected: " + pos);
                        QFSFloatingVerticalView.this.C(pos, "TYPE_SELECT_REFRESH");
                    }
                }
            });
            this.f86408e.onDataRefresh();
        }
    }

    public QFSFloatingVerticalView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f86412m = new ArrayList();
        this.C = false;
        this.D = -1;
        A();
    }

    public QFSFloatingVerticalView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f86412m = new ArrayList();
        this.C = false;
        this.D = -1;
        A();
    }
}
