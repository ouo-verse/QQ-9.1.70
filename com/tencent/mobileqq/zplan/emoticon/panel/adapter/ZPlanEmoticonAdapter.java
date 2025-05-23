package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.utils.n;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.panel.view.ZPlanEmoticonLineView;
import com.tencent.mobileqq.zplan.emoticon.panel.view.ZPlanEmoticonMaintainingView;
import com.tencent.mobileqq.zplan.emoticon.report.ZPlanEmoticonReport;
import com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.mobileqq.zplan.message.ZPlanSessionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.servlet.m;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.activity.ZplanHostActivity;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.h;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import cooperation.qzone.QZoneClickReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import lh3.ZPlanEmotionItemInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes34.dex */
public class ZPlanEmoticonAdapter extends BaseEmotionAdapter {
    private static final int T = ZPlanFeatureSwitch.Q1();
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private ZPlanEmoticonMaintainingView G;
    private mh3.b H;
    private CoroutineScope I;
    private DeviceType J;
    private boolean K;
    public int L;
    private Function0<Unit> M;
    private final View.OnClickListener N;
    private final View.OnClickListener P;
    private final m Q;
    private n R;
    private boolean S;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f333125d;

    /* renamed from: e, reason: collision with root package name */
    private int f333126e;

    /* renamed from: f, reason: collision with root package name */
    private SessionInfo f333127f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f333128h;

    /* renamed from: i, reason: collision with root package name */
    private final List<List<ZPlanEmotionItemInfo>> f333129i;

    /* renamed from: m, reason: collision with root package name */
    private final List<ZPlanEmotionItemInfo> f333130m;

    /* loaded from: classes34.dex */
    class a implements Function0<Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            ZPlanEmoticonAdapter.this.v();
            return null;
        }
    }

    /* loaded from: classes34.dex */
    private static class b extends m {

        /* renamed from: e, reason: collision with root package name */
        WeakReference<ZPlanEmoticonAdapter> f333132e;

        b(ZPlanEmoticonAdapter zPlanEmoticonAdapter) {
            this.f333132e = new WeakReference<>(zPlanEmoticonAdapter);
        }

        @Override // com.tencent.mobileqq.zplan.servlet.m
        public void a(boolean z16, List<String> list) {
            AppRuntime peekAppRuntime;
            super.a(z16, list);
            WeakReference<ZPlanEmoticonAdapter> weakReference = this.f333132e;
            ZPlanEmoticonAdapter zPlanEmoticonAdapter = weakReference != null ? weakReference.get() : null;
            if (zPlanEmoticonAdapter == null) {
                return;
            }
            boolean z17 = zPlanEmoticonAdapter.C;
            QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onUserAppearanceKeyChange, success:" + z16 + ", uinList:" + list + ", isTabShowing:" + z17);
            if (!z16 || list.isEmpty() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || !list.contains(peekAppRuntime.getCurrentUin())) {
                return;
            }
            if (!z17) {
                zPlanEmoticonAdapter.D = true;
                zPlanEmoticonAdapter.E = true;
                QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onUserAppearanceKeyChange notifyDataSetChanged on next resume");
            } else {
                QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onUserAppearanceKeyChange notifyDataSetChanged immediately");
                zPlanEmoticonAdapter.notifyDataSetChanged();
                zPlanEmoticonAdapter.F();
            }
        }
    }

    /* loaded from: classes34.dex */
    public static class c extends BaseEmotionAdapter.ViewHolder {
    }

    public ZPlanEmoticonAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback, ViewGroup viewGroup, SessionInfo sessionInfo, CoroutineScope coroutineScope) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        this.f333129i = new ArrayList();
        this.f333130m = new ArrayList();
        this.K = ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableMemeResetPriority();
        this.L = ViewUtils.dip2px(13.0f);
        this.M = new a();
        this.N = new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanEmoticonAdapter.this.y(view);
            }
        };
        this.P = new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanEmoticonAdapter.this.z(view);
            }
        };
        b bVar = new b(this);
        this.Q = bVar;
        this.S = false;
        this.f333125d = viewGroup;
        this.f333127f = sessionInfo;
        this.f333126e = i3;
        this.f333128h = new Handler(Looper.getMainLooper());
        this.F = ZPlanEmoticonMaintainingView.INSTANCE.a();
        this.I = coroutineScope;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).addObserver(bVar);
        }
        kh3.d dVar = kh3.d.f412402a;
        dVar.d();
        yh3.c.f450357a.h(dVar);
        ZPlanEmoticonReport zPlanEmoticonReport = ZPlanEmoticonReport.f333324a;
        zPlanEmoticonReport.r(new WeakReference<>(this.M));
        zPlanEmoticonReport.q("onPanelCreate", true);
        this.J = PadUtil.a(this.mContext);
        this.H = new mh3.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ArrayList arrayList = new ArrayList();
        for (ZPlanEmotionItemInfo zPlanEmotionItemInfo : this.f333130m) {
            if (zPlanEmotionItemInfo.getType() == 0) {
                arrayList.add(zPlanEmotionItemInfo.getZPlanActionInfo());
            }
        }
        G(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_emote_page_from", ZPlanEmoticonUtil.f333176e.E());
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    private void I(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        hashMap.put("zplan_action_type", "imp");
        hashMap.put("zplan_emote_page_from", ZPlanEmoticonUtil.f333176e.E());
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    private void J(int i3, int i16) {
        ZPlanEmoticonReport zPlanEmoticonReport;
        ZPlanEmoticonReport zPlanEmoticonReport2;
        ZPlanEmoticonReport zPlanEmoticonReport3 = ZPlanEmoticonReport.f333324a;
        if (i3 < zPlanEmoticonReport3.i()) {
            zPlanEmoticonReport3.v(i3);
            int t16 = t(i3, true);
            int i17 = t16;
            while (true) {
                zPlanEmoticonReport2 = ZPlanEmoticonReport.f333324a;
                if (i17 >= zPlanEmoticonReport2.h()) {
                    break;
                }
                K(i17);
                i17++;
            }
            zPlanEmoticonReport2.u(t16);
        }
        ZPlanEmoticonReport zPlanEmoticonReport4 = ZPlanEmoticonReport.f333324a;
        if (i16 > zPlanEmoticonReport4.g()) {
            zPlanEmoticonReport4.t(i3);
            int t17 = t(i16, false);
            int i18 = t17;
            while (true) {
                zPlanEmoticonReport = ZPlanEmoticonReport.f333324a;
                if (i18 <= zPlanEmoticonReport.f() || i18 < 0) {
                    break;
                }
                K(i18);
                i18--;
            }
            zPlanEmoticonReport.s(t17);
        }
    }

    private void N() {
        int p16 = p(this.f333130m);
        this.f333129i.clear();
        for (int i3 = 0; i3 < p16; i3++) {
            this.f333129i.add(q(i3, this.f333130m));
        }
    }

    private void m() {
        n nVar = this.R;
        if (nVar != null) {
            nVar.c();
            this.R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        EmotionPanelListView currentListView = getCurrentListView();
        if (currentListView == null) {
            return 0;
        }
        return currentListView.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        View childAt;
        EmotionPanelListView currentListView = getCurrentListView();
        if (currentListView == null || (childAt = currentListView.getChildAt(0)) == null) {
            return 0;
        }
        return (childAt.getTop() * (-1)) + (currentListView.getFirstVisiblePosition() * childAt.getMeasuredHeight());
    }

    private int p(List<ZPlanEmotionItemInfo> list) {
        int size = list.size();
        return ((size + r0) - 1) / this.f333126e;
    }

    private List<ZPlanEmotionItemInfo> q(int i3, List<ZPlanEmotionItemInfo> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i16 = 0;
        while (true) {
            int i17 = this.f333126e;
            if (i16 >= i17) {
                return arrayList;
            }
            int i18 = (i17 * i3) + i16;
            if (i18 < size) {
                arrayList.add(list.get(i18));
            }
            i16++;
        }
    }

    private int r() {
        View childAt;
        int measuredHeight;
        EmotionPanelListView currentListView = getCurrentListView();
        if (currentListView == null || (childAt = currentListView.getChildAt(0)) == null || (measuredHeight = childAt.getMeasuredHeight()) <= 0) {
            return 0;
        }
        return n() / measuredHeight;
    }

    private int s() {
        EmotionPanelListView currentListView = getCurrentListView();
        if (currentListView == null) {
            return 0;
        }
        return currentListView.getFirstVisiblePosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t(int i3, boolean z16) {
        View childAt;
        int measuredHeight;
        EmotionPanelListView currentListView = getCurrentListView();
        if (currentListView == null || (childAt = currentListView.getChildAt(0)) == null || (measuredHeight = childAt.getMeasuredHeight()) == 0) {
            return 0;
        }
        int i16 = i3 / measuredHeight;
        int i17 = i3 % measuredHeight > measuredHeight / 2 ? 1 : 0;
        if (!z16) {
            i17--;
        }
        return Math.max(i16 + i17, 0);
    }

    private View u() {
        if (this.G == null) {
            this.G = new ZPlanEmoticonMaintainingView(this.mContext);
        }
        this.G.setLayoutParams(new AbsListView.LayoutParams(-1, n()));
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f333128h.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                int o16 = ZPlanEmoticonAdapter.this.o();
                int n3 = ZPlanEmoticonAdapter.this.n() + o16;
                int t16 = ZPlanEmoticonAdapter.this.t(o16, true);
                int t17 = ZPlanEmoticonAdapter.this.t(n3, false);
                for (int i3 = t16; i3 <= t17; i3++) {
                    ZPlanEmoticonAdapter.this.K(i3);
                }
                ZPlanEmoticonReport zPlanEmoticonReport = ZPlanEmoticonReport.f333324a;
                zPlanEmoticonReport.v(o16);
                zPlanEmoticonReport.u(t16);
                zPlanEmoticonReport.t(n3);
                zPlanEmoticonReport.s(t17);
            }
        });
    }

    private void w() {
        if (this.R == null) {
            this.R = new n(20);
        }
    }

    private boolean x(List<ZPlanEmotionItemInfo> list) {
        int size = this.f333130m.size();
        if (size != list.size()) {
            return true;
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (!this.f333130m.get(i3).equals(list.get(i3))) {
                return true;
            }
        }
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "Not Need Update Data");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        boolean b16 = h.b("ZPlanEmoticonAdapter");
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onStoreClick isDoubleClick:" + b16);
        if (b16) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                boolean a16 = ZPlanFeatureSwitch.f369852a.a();
                QLog.d("[zplan]ZPlanEmoticonAdapter", 1, "jumpMakeUp=" + a16);
                if (a16) {
                    ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startMakeUpActivity(BaseApplication.getContext(), ZootopiaSource.create(Source.ZootopiaActivity, ZootopiaSource.SUB_SOURCE_ENTRANCE_EMOTICON), null);
                } else {
                    ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(BaseApplication.getContext(), ZootopiaSource.create(Source.Emoticon, ZootopiaSource.SUB_SOURCE_ENTRANCE_EMOTICON), null);
                }
                ZPlanEmoticonAdapter.this.H(ZootopiaSource.SUB_SOURCE_ENTRANCE_EMOTICON);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onEditClick");
        if (!((IZootopiaApi) QRoute.api(IZootopiaApi.class)).enableZPlanAIOMakeGifEntrance()) {
            QQToast.makeText(this.mContext, R.string.xoa, 0).show();
            return;
        }
        H("em_zplan_entrance_qq_makegif");
        Bundle bundle = new Bundle();
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.create(Source.Emoticon, ZootopiaSource.SUB_SOURCE_MAKE_GIF));
        this.S = true;
        w();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(null, "emoticon");
        ZplanHostActivity.G2(BaseApplication.getContext(), com.tencent.sqshow.zootopia.samestyle.a.class, bundle);
    }

    public void D(boolean z16) {
        mh3.b bVar;
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onSelected: " + z16);
        ZPlanEmoticonReport.f333324a.q("onSelected", z16);
        if (o() == 0 && (bVar = this.H) != null) {
            bVar.t(true);
        }
        if (z16) {
            ZPlanEmoticonTabAvatarManager.f333345a.G();
            I(ZootopiaSource.SUB_SOURCE_ENTRANCE_EMOTICON);
            I("em_zplan_entrance_qq_makegif");
        }
    }

    public void E(boolean z16) {
        mh3.b bVar;
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "panel onShow: " + z16);
        if (z16) {
            ZPlanEmoticonReport.f333324a.q("onSelected", true);
            if (o() != 0 || (bVar = this.H) == null) {
                return;
            }
            bVar.t(true);
        }
    }

    public void L() {
        int s16 = s();
        ZPlanEmoticonUtil.f333176e.a0(s16, r() + s16);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void destory() {
        super.destory();
        m();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).removeObserver(this.Q);
        }
        yh3.c.f450357a.l(kh3.d.f412402a);
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "destroy");
        ZPlanEmoticonReport zPlanEmoticonReport = ZPlanEmoticonReport.f333324a;
        zPlanEmoticonReport.q("onPanelCreate", false);
        zPlanEmoticonReport.r(null);
        this.H = null;
        this.app = null;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        if (this.F) {
            return 1;
        }
        return this.f333129i.size();
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        if (getItemViewType(i3) != 101) {
            if (!(view instanceof ZPlanEmoticonLineView)) {
                view = new ZPlanEmoticonLineView(this.f333125d, getCurrentListView().getWidth(), this.f333126e, ZPlanSessionInfo.INSTANCE.a(this.f333127f), this.H, this.callback);
            }
            ZPlanEmoticonLineView zPlanEmoticonLineView = (ZPlanEmoticonLineView) view;
            if (i3 == 0) {
                view.setPadding(0, this.L, 0, 0);
            } else {
                view.setPadding(0, 0, 0, 0);
            }
            List<ZPlanEmotionItemInfo> list = this.f333129i.get(i3);
            for (int i16 = 0; i16 < list.size(); i16++) {
                ZPlanActionInfo zPlanActionInfo = list.get(i16).getZPlanActionInfo();
                if (zPlanActionInfo != null) {
                    zPlanActionInfo.F((this.f333126e * i3) + i16);
                    zPlanActionInfo.z(i3);
                }
            }
            zPlanEmoticonLineView.b(list, this.P, this.N);
            return view;
        }
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "getEmotionView: MAINTAINING_VIEW_TYPE");
        return u();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return this.F ? 101 : 100;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        return new c();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (t74.h.f435542a.d()) {
            super.notifyDataSetChanged();
        } else {
            this.f333128h.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEmoticonAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void onScrollStateChange(int i3) {
        super.onScrollStateChange(i3);
        if (i3 == 0) {
            int o16 = o();
            J(o16, n() + o16);
            if (this.K) {
                L();
            }
        }
        QLog.d("[zplan]ZPlanEmoticonAdapter", 1, "onScrollStateChange " + i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void setCurrentListView(EmotionPanelListView emotionPanelListView) {
        super.setCurrentListView(emotionPanelListView);
    }

    public void A() {
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "panel onHide");
        ZPlanEmoticonReport zPlanEmoticonReport = ZPlanEmoticonReport.f333324a;
        zPlanEmoticonReport.v(0);
        zPlanEmoticonReport.u(0);
        zPlanEmoticonReport.t(0);
        zPlanEmoticonReport.s(0);
        zPlanEmoticonReport.e().put("needResetReport", Boolean.TRUE);
        mh3.b bVar = this.H;
        if (bVar != null) {
            bVar.r();
            this.H.e();
        }
    }

    public void B() {
        this.C = false;
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "onPause, isJumpingToEmoMake:" + this.S);
        if (!this.S) {
            m();
        } else {
            this.S = false;
        }
    }

    public void C() {
        CoroutineScope coroutineScope;
        this.C = true;
        if (this.D) {
            notifyDataSetChanged();
        }
        this.D = false;
        if (this.E && (coroutineScope = this.I) != null) {
            ZPlanEmoticonUtil.f333176e.J(coroutineScope);
            F();
            this.E = false;
        }
        MemeHelper.INSTANCE.toggleQueuePauseState(false, "ZPlanEmoticonAdapterResume");
    }

    private void G(List<ZPlanActionInfo> list) {
        List<ZPlanActionInfo> arrayList;
        if (list == null || list.isEmpty()) {
            return;
        }
        QLog.i("[zplan]ZPlanEmoticonAdapter", 1, "start record emoticon");
        int size = list.size();
        int i3 = T;
        if (size > i3) {
            arrayList = list.subList(0, i3);
        } else {
            arrayList = new ArrayList(list);
        }
        ZPlanEmoticonUtil.f333176e.P(arrayList, Priority.MIDDLE, Priority.LOW, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i3) {
        ZPlanActionInfo zPlanActionInfo;
        String str;
        String valueOf;
        String str2;
        String str3;
        Object obj;
        if (i3 < 0 || i3 >= this.f333129i.size()) {
            return;
        }
        int i16 = this.f333126e * i3;
        List<ZPlanEmotionItemInfo> list = this.f333129i.get(i3);
        for (int i17 = 0; i17 < this.f333126e && i17 < list.size(); i17++) {
            ZPlanEmotionItemInfo zPlanEmotionItemInfo = list.get(i17);
            if (zPlanEmotionItemInfo != null && (zPlanActionInfo = zPlanEmotionItemInfo.getZPlanActionInfo()) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                hashMap.put("zplan_action_type", "imp");
                hashMap.put("zplan_emote_id", String.valueOf(zPlanActionInfo.getId()));
                hashMap.put("zplan_emote_name", zPlanActionInfo.getName());
                if (zPlanActionInfo.getPic2DMode() == MODE.GIF) {
                    str = "gif";
                } else {
                    str = "sharpp";
                }
                hashMap.put("zplan_emote_type", str);
                hashMap.put("zplan_emote_position", String.valueOf(i16 + i17));
                if (this.J == DeviceType.TABLET) {
                    valueOf = String.valueOf(3);
                } else {
                    valueOf = String.valueOf(bb.f335811a.p() ? 2 : 1);
                }
                hashMap.put("zplan_user_screen_type", valueOf);
                hashMap.put("zplan_click_emote_situation", "1");
                hashMap.put("zplan_emote_record_type", "1");
                mh3.b bVar = this.H;
                if (bVar != null) {
                    str2 = bVar.getIsFirstEnter();
                } else {
                    str2 = "2";
                }
                hashMap.put("zplan_is_the_first_time_enter", str2);
                mh3.b bVar2 = this.H;
                if (bVar2 == null) {
                    str3 = "0";
                } else {
                    str3 = bVar2.getAppearanceKey();
                }
                hashMap.put("zplan_dress_up_key", str3);
                mh3.b bVar3 = this.H;
                if (bVar3 != null && bVar3.getUserInfo() != null && this.H.getUserInfo().hasCustomDressUp()) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                hashMap.put("zplan_is_dress_up_user", obj);
                hashMap.put("zplan_emote_source", "1");
                hashMap.put("plan_emote_single_emote_loading_time", "0");
                hashMap.put("zplan_emote_page_from", ZPlanEmoticonUtil.f333176e.E());
                hashMap.put("zplan_emote_scene_type", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
                VideoReport.reportEvent("ev_zplan_emote_click", hashMap);
            }
        }
    }

    public void M(List<ZPlanActionInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f333130m);
        this.f333130m.clear();
        this.f333130m.add(new ZPlanEmotionItemInfo(null, 1));
        if (((IZootopiaApi) QRoute.api(IZootopiaApi.class)).enableZPlanAIOMakeGifEntrance()) {
            this.f333130m.add(new ZPlanEmotionItemInfo(null, 2));
        }
        Iterator<ZPlanActionInfo> it = list.iterator();
        while (it.hasNext()) {
            this.f333130m.add(new ZPlanEmotionItemInfo(it.next(), 0));
        }
        if (x(arrayList)) {
            N();
            notifyDataSetChanged();
            G(list);
        }
        mh3.b bVar = this.H;
        if (bVar != null) {
            bVar.n(list, T);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void refreshPanelData() {
    }
}
