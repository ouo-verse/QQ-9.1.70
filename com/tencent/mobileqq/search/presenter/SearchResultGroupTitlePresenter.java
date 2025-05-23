package com.tencent.mobileqq.search.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchPageCloseEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchGuildDaTongApi;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.List;
import lo2.t;

/* loaded from: classes18.dex */
public class SearchResultGroupTitlePresenter implements qn2.d<v, sn2.b>, qn2.b, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private Context f283582d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f283583e = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f283586d;

        b(x xVar) {
            this.f283586d = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f283586d.q(view);
            SearchResultGroupTitlePresenter.this.h(this.f283586d, view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(x xVar, View view) {
        if (xVar == null || xVar.k() != 18) {
            return;
        }
        this.f283582d = view.getContext();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        view.removeOnAttachStateChangeListener(this.f283583e);
        view.addOnAttachStateChangeListener(this.f283583e);
    }

    private long i(com.tencent.mobileqq.search.model.i iVar) {
        if (iVar != null && (iVar.v() instanceof lo2.b)) {
            return ((lo2.b) iVar.v()).D;
        }
        return -1L;
    }

    @Override // qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        List<y> list;
        if (!(vVar instanceof com.tencent.mobileqq.search.model.i)) {
            return;
        }
        View findViewById = view.findViewById(R.id.ezq);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            if (findViewById.getContext() instanceof ActiveEntitySearchActivity) {
                ai.e(findViewById, i((com.tencent.mobileqq.search.model.i) vVar));
            } else {
                am.i(findViewById, com.tencent.mobileqq.search.util.x.h(((com.tencent.mobileqq.search.model.i) vVar).v()));
            }
        }
        x v3 = ((com.tencent.mobileqq.search.model.i) vVar).v();
        if (!(v3 instanceof lo2.b)) {
            return;
        }
        lo2.b bVar = (lo2.b) v3;
        long j3 = bVar.D;
        if (j3 != 1701 && j3 != Constant.FROM_ID_START_ACTIVITY && j3 != 1109 && j3 != 1111 && j3 != 1114 && j3 != 1115 && j3 != 1116) {
            if (j3 == 1108 && (list = bVar.F) != null && !list.isEmpty()) {
                y yVar = list.get(0);
                if (yVar instanceof lo2.m) {
                    am.n(view, i3, com.tencent.mobileqq.search.util.x.d(yVar), com.tencent.mobileqq.search.util.x.h(yVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
                    if ((yVar instanceof t) && ((t) yVar).Y()) {
                        ai.k(view, findViewById, list.size());
                    }
                    ((ISearchGuildDaTongApi) QRoute.api(ISearchGuildDaTongApi.class)).reportGuildSearchTitle(findViewById, yVar);
                    return;
                }
                return;
            }
            return;
        }
        List<y> list2 = bVar.F;
        if (list2 != null && !list2.isEmpty()) {
            y yVar2 = list2.get(0);
            am.m(view, i3, com.tencent.mobileqq.search.util.x.d(yVar2), com.tencent.mobileqq.search.util.x.h(yVar2), String.valueOf(vVar.hashCode()), list2.size(), com.tencent.mobileqq.search.util.x.e(yVar2), vVar.getRecallReason());
        }
    }

    @Override // qn2.d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(v vVar, sn2.b bVar) {
        this.f283582d = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        fo2.d dVar = (fo2.d) bVar;
        if (vVar instanceof com.tencent.mobileqq.search.model.i) {
            com.tencent.mobileqq.search.model.i iVar = (com.tencent.mobileqq.search.model.i) vVar;
            String l3 = iVar.l();
            if (TextUtils.isEmpty(l3)) {
                l3 = "";
            }
            if (iVar.y()) {
                String keyword = iVar.getKeyword();
                if (!TextUtils.isEmpty(keyword)) {
                    String charSequence = SearchUtils.K(dVar.b(), 10.0f * SearchUtils.t0(dVar.b(), HardCodeUtil.qqStr(R.string.t7a)), 1, keyword, keyword, false, false, true).toString();
                    SpannableString spannableString = new SpannableString(charSequence + "-" + l3);
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, charSequence.length(), 34);
                    dVar.b().setText(spannableString);
                } else {
                    dVar.b().setText(l3);
                }
            } else {
                dVar.b().setText(l3);
            }
            if (!QQTheme.isNowThemeIsNight() && SimpleUIUtil.isNowElderMode()) {
                dVar.b().setTextColor(Color.parseColor("#666666"));
            }
            if (iVar.A()) {
                bVar.getMoreView().setText(iVar.z());
                bVar.getMoreView().setVisibility(0);
                if (!QQTheme.isNowThemeIsNight() && SimpleUIUtil.isNowElderMode()) {
                    bVar.getMoreView().setTextColor(Color.parseColor("#666666"));
                }
                if (TextUtils.equals(iVar.l(), HardCodeUtil.qqStr(R.string.f181523e0))) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, UniteSearchActivity.f282684b0, "0X800BA24", 0, 0, null, null);
                }
                if (iVar.w() == 1001) {
                    final TextView moreView = bVar.getMoreView();
                    VideoReport.setElementId(moreView, "em_search_people_result_people_more");
                    VideoReport.setElementExposePolicy(moreView, ExposurePolicy.REPORT_NONE);
                    VideoReport.setElementClickPolicy(moreView, ClickPolicy.REPORT_NONE);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoReport.reportEvent("dt_imp", moreView, null);
                        }
                    });
                }
            } else {
                bVar.getMoreView().setVisibility(8);
            }
        }
        int i3 = -1;
        bVar.getMoreView().setTag(R.id.kxc, -1);
        if (vVar instanceof x) {
            x xVar = (x) vVar;
            bVar.getMoreView().setOnClickListener(new b(xVar));
            xVar.p();
        }
        Object tag = bVar.getView().getTag(R.id.kxc);
        if (tag instanceof Integer) {
            i3 = ((Integer) tag).intValue();
        }
        if (i3 > 0) {
            dVar.a(true);
        } else if (i3 == 0) {
            dVar.a(false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchPageCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!com.tencent.mobileqq.search.util.y.e() && (simpleBaseEvent instanceof QFSSearchPageCloseEvent)) {
            Context context = this.f283582d;
            if (context instanceof Activity) {
                ((Activity) context).onBackPressed();
            }
        }
    }

    /* loaded from: classes18.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            SearchResultGroupTitlePresenter.this.f283582d = null;
            SimpleEventBus.getInstance().unRegisterReceiver(SearchResultGroupTitlePresenter.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
