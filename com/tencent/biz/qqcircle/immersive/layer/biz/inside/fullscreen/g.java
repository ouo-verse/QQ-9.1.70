package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.adapter.QCircleAlbumPanelBlock;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSFullScreenClickAlbumPanelShowEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSFullScreenFeedAlbumChangeEvent;
import com.tencent.biz.qqcircle.immersive.album.view.QCircleAlbumItemView;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenAlbumClickEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenCompletionEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullClearEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.immersive.part.ac;
import com.tencent.biz.qqcircle.immersive.utils.ab;
import com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends ac {
    private View V;
    private QCircleInitBean W;
    private QCircleAlbumItemView.a X;

    public g(QCircleInitBean qCircleInitBean) {
        FeedCloudMeta$StFeed feed;
        if (qCircleInitBean == null) {
            feed = null;
        } else {
            feed = qCircleInitBean.getFeed();
        }
        this.W = qCircleInitBean;
        Z9(ab.a(feed, true));
    }

    private long Ga(b40.a aVar) {
        if (aVar == null) {
            return 0L;
        }
        return aVar.k().longValue();
    }

    private List<b40.a> Ha() {
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.S;
        if (qCircleAlbumPanelBlock == null) {
            return null;
        }
        return qCircleAlbumPanelBlock.getDataList();
    }

    private void Ia(b40.a aVar, String str, List<b40.a> list, boolean z16) {
        if (list != null && !list.isEmpty()) {
            if (aVar == null) {
                QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerAlbumFeedClick] newAlbumInfo == null, end flow.");
                return;
            }
            b40.a aVar2 = (b40.a) RFSafeListUtils.get(list, bj.d(list, str));
            FeedCloudMeta$StFeed f16 = bj.f(aVar2);
            FeedCloudMeta$StFeed e16 = aVar.e();
            Sa(e16);
            boolean m3 = ab.m(this.T, bj.g(e16));
            QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerAlbumFeedClick] click preFeed: " + bj.g(f16) + " | preContent: " + bj.e(f16) + " | preAlbumId: " + Ga(aVar2) + " | currentClickFeedId: " + bj.g(e16) + " | isAlbumListEnd: " + m3 + " | currentClickFeedContent: " + bj.e(e16) + " | currentAlbumId: " + Ga(aVar));
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(22, bj.g(f16), false));
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenAlbumClickEvent(f16, e16, m3, z16));
            return;
        }
        QLog.e("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerAlbumFeedClick] full screen album list is empty.");
    }

    private void Ja(@NonNull QFSFullScreenCompletionEvent qFSFullScreenCompletionEvent) {
        FeedCloudMeta$StFeed e16;
        String g16 = bj.g(qFSFullScreenCompletionEvent.getCurrentFeed());
        String g17 = bj.g(this.M);
        if (!TextUtils.equals(g16, g17)) {
            QLog.e("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerFullScreenCompletionEvent] current feed id not equals,eventFeedId: " + g16 + " | currentFeedId: " + g17);
            return;
        }
        List<b40.a> Ha = Ha();
        int d16 = bj.d(Ha, g17);
        b40.a aVar = (b40.a) RFSafeListUtils.get(Ha, d16);
        b40.a aVar2 = (b40.a) RFSafeListUtils.get(Ha, d16 + 1);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (aVar == null) {
            e16 = null;
        } else {
            e16 = aVar.e();
        }
        if (aVar2 != null) {
            feedCloudMeta$StFeed = aVar2.e();
        }
        Aa(aVar2);
        Ia(aVar2, bj.g(qFSFullScreenCompletionEvent.getCurrentFeed()), Ha, true);
        QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerFullScreenCompletionEvent] position: " + d16 + " | pre feed id: " + bj.g(e16) + " | next feed id: " + bj.g(feedCloudMeta$StFeed));
    }

    private void Ka(@NonNull QFSFullScreenFeedAlbumChangeEvent qFSFullScreenFeedAlbumChangeEvent) {
        FeedCloudMeta$StFeed f16 = bj.f(qFSFullScreenFeedAlbumChangeEvent.getBlockData());
        if (!ab.l(f16, this.W)) {
            QLog.e("VFS-QFSFullScreenRightAlbumPanelPart", 4, "[handlerFullScreenFeedAlbumChangeEvent] feedId: " + bj.g(f16) + " not album end flow.");
            return;
        }
        try {
            QCircleAlbumBean a16 = ab.a(f16, true);
            Z9(a16);
            Sa(f16);
            initViewModel();
            Oa();
            QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerFullScreenFeedAlbumChangeEvent] load album feed id: " + bj.g(this.M) + " | album id: " + a16.getFeedAlbumInfo().mAlbumId + " | album title: " + a16.getFeedAlbumInfo().title);
        } catch (Throwable th5) {
            QLog.e("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerFullScreenFeedAlbumChangeEvent] error: ", th5);
        }
    }

    private void La(@NonNull QFSFullScreenClickAlbumPanelShowEvent qFSFullScreenClickAlbumPanelShowEvent) {
        if (qFSFullScreenClickAlbumPanelShowEvent.isHasShow()) {
            X9();
            Ra(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_COLLECT_BUTTON, null);
            View view = this.V;
            if (view != null) {
                Ra(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CLOSE, null);
            }
        } else {
            W9();
        }
        QLog.i("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[handlerPanelShowState] currentFeedId: " + bj.g(this.M) + " | event feedId: " + qFSFullScreenClickAlbumPanelShowEvent.getFeedId());
    }

    private void Ma(View view) {
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.y19);
        this.V = findViewById;
        if (findViewById != null && this.P != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.this.Pa(view2);
                }
            });
        }
    }

    private void Na() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.P;
        if (qCircleAlbumSlidBottomView == null) {
            return;
        }
        qCircleAlbumSlidBottomView.c(new a());
    }

    private void Oa() {
        boolean z16 = true;
        if (this.T == null) {
            QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[initViewData] album view model should not be null.");
            return;
        }
        if (this.M == null) {
            QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[initViewData] feed should not be null.");
            return;
        }
        QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[initViewData] feed id: " + bj.g(this.M));
        this.T.j3(this.M.f398449id.get());
        this.T.W2(this.M);
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.T;
        if (this.M == null) {
            z16 = false;
        }
        qFSLayerAlbumViewModel.i3(2, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.b("VFS-QFSFullScreenRightAlbumPanelPart", 500L)) {
            this.P.d();
            Qa(this.V, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_CLOSE, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Qa(View view, String str, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, ab.b(this.M));
        buildElementParams.put("xsj_feed_id", bj.g(this.M));
        if (map != null && !map.isEmpty()) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    private void Ra(View view, String str, Map<String, Object> map) {
        if (view == null) {
            QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[reportCustomExposureReport] view == null, end flow.");
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, ab.b(this.M));
        buildElementParams.put("xsj_feed_id", bj.g(this.M));
        if (map != null && !map.isEmpty()) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("dt_imp", view, buildElementParams);
    }

    private void Sa(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[updateCurrentFeed] update feed id: " + bj.g(feedCloudMeta$StFeed));
        this.M = feedCloudMeta$StFeed;
        QCircleAlbumItemView.a aVar = this.X;
        if (aVar != null) {
            aVar.f84831d = feedCloudMeta$StFeed;
        }
    }

    private boolean isShow() {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    protected QCircleAlbumItemView.a M9() {
        Resources resources;
        if (getContext() == null) {
            resources = null;
        } else {
            resources = getContext().getResources();
        }
        if (resources == null) {
            return null;
        }
        if (this.X == null) {
            this.X = new QCircleAlbumItemView.a(true, (int) resources.getDimension(R.dimen.d1_), (int) resources.getDimension(R.dimen.d19), this.M, 2);
        }
        return this.X;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    public void U9() {
        String charSequence;
        super.U9();
        TextView textView = this.C;
        if (textView == null) {
            charSequence = null;
        } else {
            charSequence = textView.getText().toString();
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("xsj_item_name", charSequence);
        Qa(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_COLLECT_BUTTON, concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    public void V9(View view, Object obj) {
        String g16 = bj.g(this.M);
        super.V9(view, obj);
        if (!(obj instanceof b40.a)) {
            return;
        }
        Ia((b40.a) obj, g16, Ha(), false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    protected boolean ea() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    protected boolean ga() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> eventClass = super.getEventClass();
        eventClass.add(QFSFullScreenFeedAlbumChangeEvent.class);
        eventClass.add(QFSFullScreenClickAlbumPanelShowEvent.class);
        eventClass.add(QFSFullScreenCompletionEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    protected boolean ha() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    protected boolean ia() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (isShow()) {
            W9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac, com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        W9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        Oa();
        Ma(view);
        Na();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.ac, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFullScreenFeedAlbumChangeEvent) {
            Ka((QFSFullScreenFeedAlbumChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFullScreenClickAlbumPanelShowEvent) {
            La((QFSFullScreenClickAlbumPanelShowEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFullScreenCompletionEvent) {
            Ja((QFSFullScreenCompletionEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.ac
    public void qa() {
        int max;
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.S;
        if (qCircleAlbumPanelBlock != null && qCircleAlbumPanelBlock.getDataList() != null && !this.S.getDataList().isEmpty()) {
            int size = this.S.getDataList().size();
            int Ba = Ba(this.S.getDataList());
            int P9 = P9();
            int O9 = O9();
            if (P9 != -1 && O9 != -1) {
                int i3 = (P9 - O9) / 2;
                max = Math.max(Ba - i3, 0);
                int min = Math.min(i3 + Ba, size - 1);
                if (O9 > Ba || Ba > P9 ? Ba > P9 : Ba != O9) {
                    max = min;
                }
            } else {
                max = Math.max(Ba - 1, 0);
            }
            B1(max);
            QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[locateTargetFeed]:" + max + " | size: " + size);
            return;
        }
        QLog.d("VFS-QFSFullScreenRightAlbumPanelPart", 1, "[locateTargetFeed] current should not be null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QCircleAlbumSlidBottomView.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onDismiss() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullClearEvent(g.this.N9(), false));
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(22, g.this.N9(), false));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onShow() {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(22, g.this.N9(), true));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }
}
