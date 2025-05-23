package com.tencent.biz.qqcircle.immersive.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptRanking;
import circlesearch.CircleSearchExhibition$PromptRankingInfo;
import circlesearch.CircleSearchExhibition$RankingPageData;
import circlesearch.CircleSearchExhibition$StPromptResp;
import circlesearch.CircleSearchExhibition$TextIconStyleData;
import com.tencent.biz.qqcircle.immersive.events.QFSShowSearchHotPanelEvent;
import com.tencent.biz.qqcircle.immersive.request.search.QFSGetSearchPromptRequest;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import e40.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private QFSHalfScreenFloatingView f89862d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89863e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f89864f;

    /* renamed from: h, reason: collision with root package name */
    private z80.a f89865h;

    /* renamed from: i, reason: collision with root package name */
    private final l f89866i = new l();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            return e.this.f89864f.canScrollVertically(-1);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            if (e.this.f89865h != null && e.this.f89865h.getNUM_BACKGOURND_ICON() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            return LayoutInflater.from(e.this.getContext()).inflate(R.layout.gr6, (ViewGroup) null, false);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return e.this.K9();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            e.this.I9();
            VideoReport.traversePage(e.this.f89862d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements OnTaskListener<Object> {
        d() {
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            if (objArr != null && objArr.length >= 4) {
                Object obj = objArr[3];
                if (obj instanceof CircleSearchExhibition$StPromptResp) {
                    e.this.M9(((CircleSearchExhibition$StPromptResp) obj).ranking.get());
                }
                e.this.Q9();
                e eVar = e.this;
                eVar.T9(eVar.f89866i.b());
                e.this.U9();
                return;
            }
            QLog.d("QFSSearchHotRankPanelPart", 1, "[isPreloadedPageData] args error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.search.e$e, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0908e implements VSDispatchObserver.OnVSRspCallBack<CircleSearchExhibition$StPromptResp> {
        C0908e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp) {
            if (j3 == 0 && circleSearchExhibition$StPromptResp != null) {
                e.this.M9(circleSearchExhibition$StPromptResp.ranking.get());
                e eVar = e.this;
                eVar.T9(eVar.f89866i.b());
                QLog.d("QFSSearchHotRankPanelPart", 1, "[checkPageData] get rank from request, success.");
                return;
            }
            QLog.d("QFSSearchHotRankPanelPart", 1, "[checkPageData] get rank from request, fail.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9() {
        if (this.f89866i.b() != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        VSNetworkHelper.getInstance().sendRequest(new QFSGetSearchPromptRequest.a().g(arrayList).b(), new C0908e());
    }

    private List<ba0.b> J9(List<ByteStringMicro> list) {
        ArrayList arrayList = new ArrayList(list.size());
        try {
            Iterator<ByteStringMicro> it = list.iterator();
            while (it.hasNext()) {
                byte[] byteArray = it.next().toByteArray();
                CircleSearchExhibition$TextIconStyleData circleSearchExhibition$TextIconStyleData = new CircleSearchExhibition$TextIconStyleData();
                circleSearchExhibition$TextIconStyleData.mergeFrom(byteArray);
                arrayList.add(new ba0.b(circleSearchExhibition$TextIconStyleData));
            }
        } catch (Exception e16) {
            QLog.e("QFSSearchHotRankPanelPart", 1, "[createTextItemDataList] ", e16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K9() {
        return (int) (Math.max(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth()) * 0.73f);
    }

    private void L9(Object obj) {
        if (!(obj instanceof u60.b)) {
            return;
        }
        u60.b bVar = (u60.b) obj;
        if (bVar.f438467a == 2) {
            String f16 = bVar.f438468b.f();
            QLog.d("QFSSearchHotRankPanelPart", 1, "[handleChangePageState] keyword: " + f16);
            this.f89866i.d(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M9(Object obj) {
        if (!(obj instanceof CircleSearchExhibition$PromptRanking)) {
            return;
        }
        for (CircleSearchExhibition$PromptRankingInfo circleSearchExhibition$PromptRankingInfo : ((CircleSearchExhibition$PromptRanking) obj).rankings.get()) {
            QLog.d("QFSSearchHotRankPanelPart", 1, "[handleHotRankData] ID:" + circleSearchExhibition$PromptRankingInfo.ID.get() + "title:" + circleSearchExhibition$PromptRankingInfo.tab.text.get());
            if (circleSearchExhibition$PromptRankingInfo.ID.get().equals(HippyQQConstants.HIPPY_CHANNEL)) {
                this.f89866i.e(circleSearchExhibition$PromptRankingInfo.page.get());
                this.f89866i.f(circleSearchExhibition$PromptRankingInfo.tab.text.get());
                return;
            }
        }
    }

    private void N9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89862d;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.t();
    }

    private void O9() {
        CircleSearchExhibition$RankingPageData b16 = this.f89866i.b();
        if (b16 == null && S9()) {
            return;
        }
        Q9();
        T9(b16);
        U9();
    }

    private void P9(@NonNull QFSShowSearchHotPanelEvent qFSShowSearchHotPanelEvent) {
        if (qFSShowSearchHotPanelEvent.isShow()) {
            O9();
        } else {
            N9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9() {
        if (this.f89862d != null) {
            return;
        }
        this.f89862d = (QFSHalfScreenFloatingView) ((ViewStub) getPartRootView().findViewById(R.id.f53472cl)).inflate();
        initHalfScreenView();
        this.f89864f = (RecyclerView) this.f89862d.findViewById(R.id.f43921ns);
        this.f89863e = (TextView) this.f89862d.findViewById(R.id.f48111z4);
        this.f89862d.findViewById(R.id.f41911ic).setOnClickListener(this);
        R9();
    }

    private void R9() {
        this.f89864f.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
        z80.a aVar = new z80.a();
        this.f89865h = aVar;
        this.f89864f.setAdapter(aVar);
        this.f89864f.addOnScrollListener(new c());
    }

    private boolean S9() {
        if (!PreLoader.exists("2015")) {
            return false;
        }
        PreLoader.addListener("2015", new d());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9(CircleSearchExhibition$RankingPageData circleSearchExhibition$RankingPageData) {
        if (circleSearchExhibition$RankingPageData == null) {
            return;
        }
        List<ba0.b> J9 = J9(circleSearchExhibition$RankingPageData.data.get());
        Iterator<ba0.b> it = J9.iterator();
        while (it.hasNext()) {
            it.next().f(this.f89866i.a());
        }
        z80.a aVar = this.f89865h;
        if (aVar != null) {
            aVar.setDatas(J9);
        }
        TextView textView = this.f89863e;
        if (textView != null) {
            textView.setText(this.f89866i.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        this.f89862d.P(0);
    }

    private void initHalfScreenView() {
        this.f89862d.q();
        this.f89862d.setQUSDragFloatController(new a());
        this.f89862d.j(new b());
        if (this.f89862d.x() instanceof ViewGroup) {
            ((ViewGroup) this.f89862d.x()).setClipToPadding(false);
            ((ViewGroup) this.f89862d.x()).setClipChildren(false);
        }
        com.tencent.mobileqq.qui.b.f276860a.a(this.f89862d, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSShowSearchHotPanelEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        str.hashCode();
        if (!str.equals("changePageState")) {
            if (str.equals("qfs_search_hot_rank_data")) {
                M9(obj);
                return;
            }
            return;
        }
        L9(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89862d;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            N9();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f41911ic) {
            N9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSShowSearchHotPanelEvent) {
            P9((QFSShowSearchHotPanelEvent) simpleBaseEvent);
        }
    }
}
