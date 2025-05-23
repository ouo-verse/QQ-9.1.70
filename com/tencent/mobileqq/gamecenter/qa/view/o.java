package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.o;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ud1.g;

/* compiled from: P */
/* loaded from: classes12.dex */
public class o extends PagerAdapter {

    /* renamed from: e, reason: collision with root package name */
    private View f213169e;

    /* renamed from: f, reason: collision with root package name */
    private long f213170f;

    /* renamed from: h, reason: collision with root package name */
    private int f213171h;

    /* renamed from: m, reason: collision with root package name */
    private c f213173m;

    /* renamed from: d, reason: collision with root package name */
    private final List<g.a> f213168d = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private List<View> f213172i = new ArrayList();
    private c C = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.o.c
        public void Hc(GameArticleListAdapter gameArticleListAdapter, int i3) {
            for (View view : o.this.f213172i) {
                if (view.getTag() instanceof b) {
                    b bVar = (b) view.getTag();
                    if (gameArticleListAdapter != bVar.m()) {
                        bVar.m().j(-1);
                    }
                }
            }
            if (o.this.f213173m != null) {
                o.this.f213173m.Hc(gameArticleListAdapter, i3);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.o.c
        public void dc(boolean z16, List<GameQALinkCardData> list) {
            if (o.this.f213173m != null) {
                o.this.f213173m.dc(z16, list);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.o.c
        public void sb(g.a aVar) {
            if (o.this.f213173m != null) {
                o.this.f213173m.sb(aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void Hc(GameArticleListAdapter gameArticleListAdapter, int i3);

        void dc(boolean z16, List<GameQALinkCardData> list);

        void sb(g.a aVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.f213172i.remove(view);
    }

    public View f() {
        return this.f213169e;
    }

    public void g(c cVar) {
        this.f213173m = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f213168d.size();
    }

    public void h(List<g.a> list) {
        this.f213168d.clear();
        this.f213168d.addAll(list);
        notifyDataSetChanged();
    }

    public void i(int i3, long j3) {
        this.f213171h = i3;
        this.f213170f = j3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        if (this.f213168d.size() <= i3) {
            return null;
        }
        b bVar = new b(viewGroup.getContext(), this.f213168d.get(i3));
        bVar.s(this.C);
        bVar.u(this.f213171h, this.f213170f);
        View j3 = bVar.j();
        j3.setTag(bVar);
        viewGroup.addView(j3);
        this.f213172i.add(j3);
        return j3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void onDestroy() {
        for (View view : this.f213172i) {
            if (view.getTag() instanceof b) {
                ((b) view.getTag()).p();
                QLog.i("GameStrategyArticlePagerAdapter", 1, "onDestroy remove itemView");
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        boolean z16;
        super.setPrimaryItem(viewGroup, i3, obj);
        this.f213169e = (View) obj;
        for (View view : this.f213172i) {
            if (view.getTag() instanceof b) {
                b bVar = (b) view.getTag();
                if (this.f213169e == view) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.t(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b implements OverScrollViewListener, Handler.Callback {
        private View C;
        private GameArticleListAdapter D;
        private XListView E;
        private volatile boolean F;
        private View I;
        private ImageView J;
        private fe1.a L;
        private c M;
        private View N;
        private boolean P;
        private View Q;
        private long R;
        private int S;
        private View T;

        /* renamed from: h, reason: collision with root package name */
        private QBaseActivity f213178h;

        /* renamed from: i, reason: collision with root package name */
        private g.a f213179i;

        /* renamed from: m, reason: collision with root package name */
        private View f213180m;

        /* renamed from: d, reason: collision with root package name */
        private final HashMap<Integer, List<GameQALinkCardData>> f213175d = new HashMap<>();

        /* renamed from: e, reason: collision with root package name */
        private final SparseArray<Integer> f213176e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        private final SparseArray<Boolean> f213177f = new SparseArray<>();
        private fe1.c G = new fe1.c();
        private int H = -1;
        private WeakReferenceHandler K = new WeakReferenceHandler(Looper.getMainLooper(), this);

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends fe1.a {
            a() {
            }

            @Override // fe1.a, fe1.d
            public void onGetMyRefMaterials(long j3, List<GameQALinkCardData> list, int i3, int i16, int i17, boolean z16) {
                List list2;
                super.onGetMyRefMaterials(j3, list, i3, i16, i17, z16);
                if (QLog.isColorLevel()) {
                    QLog.d("GameStrategyArticlePagerAdapter", 2, "this:", b.this);
                }
                if (i16 == b.this.f213179i.f438843a && i17 == b.this.H) {
                    b.this.F = false;
                    if (QLog.isColorLevel()) {
                        b bVar = b.this;
                        QLog.d("GameStrategyArticlePagerAdapter", 2, "this:", bVar, " updateListUI typeId:", Integer.valueOf(bVar.f213179i.f438843a), "mCurrentSourceType", Integer.valueOf(b.this.H));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GameStrategyArticlePagerAdapter", 2, "data:" + list);
                    }
                    if (j3 == 0) {
                        if (i3 == 0) {
                            b.this.f213175d.remove(Integer.valueOf(b.this.H));
                            if (list != null && !list.isEmpty()) {
                                b.this.f213175d.put(Integer.valueOf(b.this.H), list);
                            }
                        } else if (list != null && !list.isEmpty() && (list2 = (List) b.this.f213175d.get(Integer.valueOf(b.this.H))) != null) {
                            list2.addAll(list);
                            b.this.f213175d.put(Integer.valueOf(b.this.H), list2);
                        }
                        b.this.f213177f.put(i17, Boolean.valueOf(z16));
                        b.this.f213176e.put(i17, Integer.valueOf(i3));
                        b.this.K.obtainMessage(15, list).sendToTarget();
                    } else {
                        b.this.K.obtainMessage(16, Long.valueOf(j3)).sendToTarget();
                    }
                    b.this.K.sendEmptyMessage(17);
                    return;
                }
                QLog.i("GameStrategyArticlePagerAdapter", 1, "onGetMyRefMaterials tab or sourceType changed, refType:" + i16 + "sourceType:" + i17);
            }

            @Override // fe1.a, fe1.d
            public void onGetRecommendMaterials(long j3, int i3, List<GameQALinkCardData> list) {
                super.onGetRecommendMaterials(j3, i3, list);
                if (QLog.isColorLevel()) {
                    QLog.d("GameStrategyArticlePagerAdapter", 2, "this:", b.this);
                }
                if (i3 == b.this.f213179i.f438843a) {
                    b.this.F = false;
                    if (QLog.isColorLevel()) {
                        b bVar = b.this;
                        QLog.d("GameStrategyArticlePagerAdapter", 2, "this:", bVar, " updateListUI typeId:", Integer.valueOf(bVar.f213179i.f438843a), "mCurrentSourceType", Integer.valueOf(b.this.H));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GameStrategyArticlePagerAdapter", 2, "data:" + list);
                    }
                    if (j3 == 0) {
                        b.this.f213175d.remove(Integer.valueOf(b.this.H));
                        if (list != null && !list.isEmpty()) {
                            b.this.f213175d.put(Integer.valueOf(b.this.H), list);
                        }
                        b.this.f213177f.put(b.this.H, Boolean.TRUE);
                        b.this.f213176e.put(b.this.H, 0);
                        b.this.K.obtainMessage(15, list).sendToTarget();
                    } else {
                        b.this.K.obtainMessage(16, Long.valueOf(j3)).sendToTarget();
                    }
                    b.this.K.sendEmptyMessage(17);
                    return;
                }
                QLog.i("GameStrategyArticlePagerAdapter", 1, "onGetRecommendMaterials tab or sourceType changed, refType:" + i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.gamecenter.qa.view.o$b$b, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class ViewOnClickListenerC7654b implements View.OnClickListener {
            ViewOnClickListenerC7654b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.this.M != null) {
                    b.this.M.sb(b.this.f213179i);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(Context context, g.a aVar) {
            a aVar2 = new a();
            this.L = aVar2;
            this.f213179i = aVar;
            this.f213178h = (QBaseActivity) context;
            this.G.Z0(aVar2);
        }

        private void k() {
            if (this.E == null) {
                return;
            }
            for (int i3 = 0; i3 < this.E.getChildCount(); i3++) {
                View childAt = this.E.getChildAt(i3);
                if (childAt != null) {
                    childAt.setTag(childAt.getId(), -1);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(AdapterView adapterView, View view, int i3, long j3) {
            this.D.j(i3);
            c cVar = this.M;
            if (cVar != null) {
                cVar.Hc(this.D, i3);
            }
        }

        private void q() {
            XListView xListView;
            if (this.D != null && (xListView = this.E) != null) {
                for (int firstVisiblePosition = xListView.getFirstVisiblePosition(); firstVisiblePosition < this.E.getLastVisiblePosition(); firstVisiblePosition++) {
                    GameQAUtil.D(this.S, this.R, this.D.getItem(firstVisiblePosition));
                }
            }
        }

        private void r(int i3) {
            QLog.i("GameStrategyArticlePagerAdapter", 1, "requestRefMaterials this:" + this);
            int i16 = this.f213179i.f438843a;
            if (i16 == 100) {
                this.G.S(i16);
            } else {
                this.G.T(i16, this.H, i3, 10);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            switch (message.what) {
                case 15:
                    w();
                    return false;
                case 16:
                    QLog.e("GameStrategyArticlePagerAdapter", 1, "MSG_CODE_QUERY_FAIL:" + message.obj);
                    w();
                    return false;
                case 17:
                    this.E.springBackOverScrollHeaderView();
                    this.E.springBackOverScrollFooterView();
                    return false;
                default:
                    return false;
            }
        }

        public View j() {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f213178h).inflate(R.layout.ebl, (ViewGroup) null);
            this.E = (XListView) relativeLayout.findViewById(R.id.sw6);
            View findViewById = relativeLayout.findViewById(R.id.f164494sw3);
            this.I = findViewById;
            View findViewById2 = findViewById.findViewById(R.id.f165980yb0);
            this.T = findViewById2;
            findViewById2.setOnClickListener(new ViewOnClickListenerC7654b());
            this.J = (ImageView) relativeLayout.findViewById(R.id.f164492sw1);
            if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                this.J.setImageResource(R.drawable.ogw);
            }
            this.N = relativeLayout.findViewById(R.id.efs);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            this.E.setVerticalScrollBarEnabled(false);
            View inflate = LayoutInflater.from(this.f213178h).inflate(R.layout.f167990ec0, (ViewGroup) this.E, false);
            this.f213180m = inflate;
            this.E.setOverScrollFooter(inflate);
            View inflate2 = LayoutInflater.from(this.f213178h).inflate(R.layout.eay, (ViewGroup) null);
            this.E.addFooterView(inflate2);
            View findViewById3 = inflate2.findViewById(R.id.f164493sw2);
            this.Q = findViewById3;
            findViewById3.setVisibility(8);
            View inflate3 = LayoutInflater.from(this.f213178h).inflate(R.layout.f167990ec0, (ViewGroup) null);
            this.C = inflate3;
            this.E.setOverScrollHeader(inflate3);
            this.E.setOverScrollListener(this);
            this.E.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.p
                @Override // com.tencent.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                    o.b.this.o(adapterView, view, i3, j3);
                }
            });
            GameArticleListAdapter gameArticleListAdapter = new GameArticleListAdapter(this.f213178h);
            this.D = gameArticleListAdapter;
            this.E.setAdapter((ListAdapter) gameArticleListAdapter);
            List<g.b> b16 = this.f213179i.b();
            if (!b16.isEmpty()) {
                v(b16.get(0).f438847a);
            } else {
                v(0);
            }
            return relativeLayout;
        }

        int l() {
            Integer num = this.f213176e.get(this.H);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public GameArticleListAdapter m() {
            return this.D;
        }

        public boolean n() {
            if (this.E.isShown() && this.P) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            QLog.d("GameStrategyArticlePagerAdapter", 1, "onViewCompleteVisableAndReleased, overScrollPosition=", Integer.valueOf(i3), ", overScrollerView=", view);
            if (view == this.C) {
                if (this.F) {
                    this.E.springBackOverScrollHeaderView();
                    QLog.i("GameStrategyArticlePagerAdapter", 1, "onViewCompleteVisableAndReleased headerView is running");
                    return true;
                }
                r(0);
            } else if (view == this.f213180m) {
                if (this.F) {
                    this.E.springBackOverScrollFooterView();
                    QLog.i("GameStrategyArticlePagerAdapter", 1, "onViewCompleteVisableAndReleased footerView is running");
                } else {
                    r(l() + 1);
                }
            }
            return true;
        }

        public void p() {
            this.G.N0();
            this.K.removeCallbacksAndMessages(null);
            QLog.i("GameStrategyArticlePagerAdapter", 1, "onDestroy remove itemView data");
        }

        public void s(c cVar) {
            this.M = cVar;
        }

        public void t(boolean z16) {
            if (!this.P && z16) {
                q();
            }
            this.P = z16;
            GameArticleListAdapter gameArticleListAdapter = this.D;
            if (gameArticleListAdapter != null) {
                gameArticleListAdapter.f(z16);
            }
        }

        public void u(int i3, long j3) {
            this.S = i3;
            this.R = j3;
        }

        public void v(int i3) {
            if (this.H != i3) {
                this.D.j(-1);
                this.H = i3;
                k();
                if (this.f213175d.get(Integer.valueOf(this.H)) != null) {
                    w();
                    return;
                }
                this.E.setVisibility(4);
                this.N.setVisibility(0);
                r(0);
            }
        }

        void w() {
            List<GameQALinkCardData> list = this.f213175d.get(Integer.valueOf(this.H));
            int i3 = 0;
            if (list != null && !list.isEmpty()) {
                this.I.setVisibility(8);
                this.E.setVisibility(0);
            } else {
                this.I.setVisibility(0);
                this.E.setVisibility(4);
            }
            this.N.setVisibility(8);
            this.D.d(this.f213179i.f438843a, this.H);
            this.D.g(list);
            this.D.i(this.S, this.R);
            this.D.notifyDataSetChanged();
            c cVar = this.M;
            if (cVar != null) {
                cVar.dc(this.P, list);
            }
            Boolean bool = this.f213177f.get(this.H);
            if (bool != null && bool.booleanValue()) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[8];
                objArr[0] = " updateListUI this:";
                objArr[1] = this;
                objArr[2] = " typeId:";
                objArr[3] = Integer.valueOf(this.f213179i.f438843a);
                objArr[4] = "mCurrentSourceType";
                objArr[5] = Integer.valueOf(this.H);
                objArr[6] = " cards.size:";
                if (list != null) {
                    i3 = list.size();
                }
                objArr[7] = Integer.valueOf(i3);
                QLog.d("GameStrategyArticlePagerAdapter", 2, objArr);
            }
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        }
    }
}
