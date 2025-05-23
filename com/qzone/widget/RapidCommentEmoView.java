package com.qzone.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qzone.common.account.LoginData;
import com.qzone.feed.business.model.QQEmoCommentDataManager;
import com.qzone.feed.business.model.RapidCommentDataManager;
import com.qzone.feed.business.service.QZoneRapidCommentService;
import com.qzone.widget.l;
import com.qzone.widget.t;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RapidCommentEmoView extends FrameLayout {
    public static final int U = ViewUtils.dip2px(34.0f);
    private static final int V = ViewUtils.dip2px(38.0f);
    private static final int W = Color.parseColor("#ECECEC");
    private int C;
    private int D;
    private EditPositionBag E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public EmoticonCallback J;
    private QQEmoCommentDataManager.b K;
    private boolean L;
    private int M;
    private boolean N;
    private TextView P;
    private ImageView Q;
    public View.OnClickListener R;
    private ViewPager.OnPageChangeListener S;
    private RapidCommentDataManager.b T;

    /* renamed from: d, reason: collision with root package name */
    private ViewPager f60617d;

    /* renamed from: e, reason: collision with root package name */
    private f f60618e;

    /* renamed from: f, reason: collision with root package name */
    public Context f60619f;

    /* renamed from: h, reason: collision with root package name */
    private RapidCommentTabLayout f60620h;

    /* renamed from: i, reason: collision with root package name */
    private BaseAdapter f60621i;

    /* renamed from: m, reason: collision with root package name */
    private View f60622m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EmoticonCallback f60624d;

        a(EmoticonCallback emoticonCallback) {
            this.f60624d = emoticonCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EmoticonCallback emoticonCallback = this.f60624d;
            if (emoticonCallback != null) {
                emoticonCallback.delete();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class d implements QQEmoCommentDataManager.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<RapidCommentEmoView> f60628a;

        public d(RapidCommentEmoView rapidCommentEmoView) {
            this.f60628a = new WeakReference<>(rapidCommentEmoView);
        }

        @Override // com.qzone.feed.business.model.QQEmoCommentDataManager.b
        public void a() {
            RapidCommentEmoView rapidCommentEmoView = this.f60628a.get();
            if (rapidCommentEmoView == null || !rapidCommentEmoView.H || rapidCommentEmoView.f60620h == null || rapidCommentEmoView.f60621i == null || rapidCommentEmoView.f60618e == null) {
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(RapidCommentDataManager.D, 2, "RapidCommentEmoView notifyDataSetChanged");
            }
            List<m> E = QQEmoCommentDataManager.C().E();
            if (E == null) {
                if (rapidCommentEmoView.F) {
                    rapidCommentEmoView.f60618e.i(true, false, true);
                    rapidCommentEmoView.f60617d.setAdapter(rapidCommentEmoView.f60618e);
                    rapidCommentEmoView.f60618e.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (rapidCommentEmoView.f60617d.getAdapter() == null) {
                rapidCommentEmoView.f60617d.setAdapter(rapidCommentEmoView.f60618e);
            }
            rapidCommentEmoView.f60618e.notifyDataSetChanged();
            ((l) rapidCommentEmoView.f60621i).a(E);
            rapidCommentEmoView.f60620h.d();
            rapidCommentEmoView.f60620h.setTabFocus(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static final class e implements RapidCommentDataManager.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<RapidCommentEmoView> f60629a;

        public e(RapidCommentEmoView rapidCommentEmoView) {
            this.f60629a = new WeakReference<>(rapidCommentEmoView);
        }

        @Override // com.qzone.feed.business.model.RapidCommentDataManager.b
        public void a() {
            RapidCommentEmoView rapidCommentEmoView = this.f60629a.get();
            if (rapidCommentEmoView == null || !rapidCommentEmoView.G || rapidCommentEmoView.f60620h == null || rapidCommentEmoView.f60621i == null || rapidCommentEmoView.f60618e == null) {
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(RapidCommentDataManager.D, 2, "RapidCommentEmoView notifyDataSetChanged");
            }
            ArrayList<u> o16 = RapidCommentDataManager.n().o();
            if (o16 == null) {
                if (rapidCommentEmoView.F) {
                    rapidCommentEmoView.P.setVisibility(8);
                    rapidCommentEmoView.Q.setVisibility(8);
                    rapidCommentEmoView.f60618e.i(true, false, true);
                    rapidCommentEmoView.f60617d.setAdapter(rapidCommentEmoView.f60618e);
                    rapidCommentEmoView.f60618e.notifyDataSetChanged();
                    rapidCommentEmoView.f60620h.setVisibility(8);
                    return;
                }
                rapidCommentEmoView.Q.setVisibility(8);
                rapidCommentEmoView.P.setVisibility(0);
                rapidCommentEmoView.P.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkTooSlow", "\u5f53\u524d\u7f51\u901f\u592a\u6162\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
                return;
            }
            rapidCommentEmoView.P.setVisibility(8);
            rapidCommentEmoView.Q.setVisibility(8);
            if (rapidCommentEmoView.f60617d.getAdapter() == null) {
                rapidCommentEmoView.f60617d.setAdapter(rapidCommentEmoView.f60618e);
            }
            rapidCommentEmoView.f60618e.notifyDataSetChanged();
            if (QZoneRapidCommentService.M == 1) {
                int G = u5.b.G("hasLoadRapidCommentNum", 0);
                if (G < o16.size()) {
                    int i3 = QZoneRapidCommentService.N;
                    if (G <= i3) {
                        o16 = new ArrayList<>(o16.subList(0, i3));
                    } else {
                        o16 = new ArrayList<>(o16.subList(0, G));
                    }
                }
                ((t) rapidCommentEmoView.f60621i).a(o16);
            } else {
                ((t) rapidCommentEmoView.f60621i).a(o16);
            }
            rapidCommentEmoView.f60620h.d();
            rapidCommentEmoView.f60620h.setTabFocus(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class f extends PagerAdapter {
        private int C;

        /* renamed from: d, reason: collision with root package name */
        private Context f60630d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f60631e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f60632f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f60633h;

        /* renamed from: i, reason: collision with root package name */
        private EmoticonCallback f60634i;

        /* renamed from: m, reason: collision with root package name */
        private View.OnClickListener f60635m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f60636d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.qzone.widget.d f60637e;

            a(int i3, com.qzone.widget.d dVar) {
                this.f60636d = i3;
                this.f60637e = dVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
                if (this.f60636d == 0) {
                    if (f.this.f60634i != null) {
                        SystemEmoticonInfo systemEmoticonInfo = new SystemEmoticonInfo();
                        systemEmoticonInfo.code = this.f60637e.f60756d.get(i3).intValue();
                        systemEmoticonInfo.type = 1;
                        f.this.f60634i.send(systemEmoticonInfo);
                    }
                } else if (f.this.f60634i != null) {
                    SystemEmoticonInfo systemEmoticonInfo2 = new SystemEmoticonInfo();
                    systemEmoticonInfo2.code = this.f60637e.f60757e.get(i3).intValue();
                    systemEmoticonInfo2.type = 0;
                    f.this.f60634i.send(systemEmoticonInfo2);
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
            }
        }

        public f(Context context, boolean z16, EmoticonCallback emoticonCallback, boolean z17, View.OnClickListener onClickListener, boolean z18) {
            this.f60630d = context;
            this.f60631e = z16;
            this.f60634i = emoticonCallback;
            this.f60632f = z17;
            this.f60635m = onClickListener;
            this.f60633h = z18;
            if (z16) {
                if (z18) {
                    QQEmoCommentDataManager.C().Z(2, 2);
                } else {
                    RapidCommentDataManager.n().H(2, 2);
                }
            } else if (z18) {
                QQEmoCommentDataManager.C().Z(0, 0);
            } else {
                RapidCommentDataManager.n().H(0, 0);
            }
            if (z16 && z17) {
                this.C = RapidCommentDataManager.n().x();
                return;
            }
            if (z16 && z18) {
                this.C = QQEmoCommentDataManager.C().N();
                return;
            }
            if (z18) {
                this.C = QQEmoCommentDataManager.C().O();
            } else if (z17) {
                this.C = RapidCommentDataManager.n().y();
            } else {
                this.C = RapidCommentDataManager.F;
            }
        }

        private View h(int i3) {
            boolean z16 = this.f60631e;
            if (z16 && this.f60632f) {
                if (i3 < RapidCommentDataManager.F) {
                    return e(i3);
                }
                return g(i3);
            }
            if (z16 && this.f60633h) {
                if (i3 < QQEmoCommentDataManager.H) {
                    return e(i3);
                }
                return f(i3);
            }
            if (this.f60632f) {
                return g(i3);
            }
            if (this.f60633h) {
                return f(i3);
            }
            return e(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public WrapContentGridView e(int i3) {
            int i16 = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
            WrapContentGridView wrapContentGridView = new WrapContentGridView(RapidCommentEmoView.this.getContext(), RapidCommentEmoView.this.L);
            wrapContentGridView.setSelector(new ColorDrawable(0));
            wrapContentGridView.setNumColumns(i16);
            com.qzone.widget.d dVar = new com.qzone.widget.d(this.f60630d, i3);
            dVar.a(i16);
            wrapContentGridView.setAdapter((ListAdapter) dVar);
            ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
            ((ViewGroup.LayoutParams) layoutParams).width = -1;
            ((ViewGroup.LayoutParams) layoutParams).height = -2;
            layoutParams.gravity = 17;
            wrapContentGridView.setLayoutParams(layoutParams);
            wrapContentGridView.setOnItemClickListener(new a(i3, dVar));
            return wrapContentGridView;
        }

        public WrapContentGridView f(int i3) {
            QQEmoCommentDataManager C = QQEmoCommentDataManager.C();
            WrapContentGridView wrapContentGridView = new WrapContentGridView(RapidCommentEmoView.this.getContext());
            wrapContentGridView.setBackgroundColor(0);
            wrapContentGridView.setNumColumns(4);
            ArrayList<Long> t16 = C.t(i3);
            k kVar = new k(this.f60630d);
            kVar.b(i3, t16);
            kVar.c(this.f60635m);
            wrapContentGridView.setAdapter((ListAdapter) kVar);
            wrapContentGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return wrapContentGridView;
        }

        public WrapContentGridView g(int i3) {
            RapidCommentDataManager n3 = RapidCommentDataManager.n();
            WrapContentGridView wrapContentGridView = new WrapContentGridView(RapidCommentEmoView.this.getContext());
            wrapContentGridView.setBackgroundColor(0);
            wrapContentGridView.setNumColumns(4);
            ArrayList<Long> i16 = n3.i(i3);
            w wVar = new w(this.f60630d);
            wVar.a(i3, i16);
            wVar.b(this.f60635m);
            wrapContentGridView.setAdapter((ListAdapter) wVar);
            wrapContentGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return wrapContentGridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.C;
        }

        public void i(boolean z16, boolean z17, boolean z18) {
            this.f60631e = z16;
            this.f60632f = z17;
            this.f60633h = z18;
            if (z16) {
                if (z18) {
                    QQEmoCommentDataManager.C().Z(2, 2);
                } else {
                    RapidCommentDataManager.n().H(2, 2);
                }
            } else if (z18) {
                QQEmoCommentDataManager.C().Z(0, 0);
            } else {
                RapidCommentDataManager.n().H(0, 0);
            }
            if (z16 && z17) {
                this.C = RapidCommentDataManager.n().x();
                return;
            }
            if (z16 && z18) {
                this.C = QQEmoCommentDataManager.C().N();
                return;
            }
            if (z18) {
                this.C = QQEmoCommentDataManager.C().O();
            } else if (z17) {
                this.C = RapidCommentDataManager.n().y();
            } else {
                this.C = RapidCommentDataManager.F;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            View h16 = h(i3);
            viewGroup.addView(h16);
            return h16;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            boolean z16 = this.f60631e;
            if (z16 && this.f60632f) {
                this.C = RapidCommentDataManager.n().x();
            } else if (z16 && this.f60633h) {
                this.C = QQEmoCommentDataManager.C().N();
            } else if (this.f60632f) {
                this.C = RapidCommentDataManager.n().y();
            } else if (this.f60633h) {
                this.C = QQEmoCommentDataManager.C().O();
            } else {
                this.C = RapidCommentDataManager.F;
            }
            super.notifyDataSetChanged();
        }
    }

    public RapidCommentEmoView(Context context) {
        this(context, null);
    }

    private void k() {
        if (this.P == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            TextView textView = new TextView(getContext());
            this.P = textView;
            textView.setTextSize(16.0f);
            this.P.setGravity(17);
            this.P.setTextColor(Color.parseColor("#888888"));
            this.P.setBackgroundColor(W);
            this.P.setVisibility(8);
            this.P.setMinHeight(ViewUtils.dip2px(240.0f));
            addView(this.P, layoutParams);
        }
        if (this.Q == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            ImageView imageView = new ImageView(getContext());
            this.Q = imageView;
            imageView.setImageResource(R.drawable.b08);
            this.Q.setScaleType(ImageView.ScaleType.CENTER);
            this.Q.setBackgroundColor(W);
            this.Q.setMinimumHeight(ViewUtils.dip2px(240.0f));
            addView(this.Q, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3) {
        RapidCommentTabLayout rapidCommentTabLayout = this.f60620h;
        if (rapidCommentTabLayout != null) {
            rapidCommentTabLayout.setTabUnFocus(this.C);
            this.f60620h.setTabFocus(i3);
            this.C = i3;
            SharedPreferences.Editor O = u5.b.O();
            if (!this.F) {
                O.putBoolean("is_qqemoj_click", false);
                O.putInt("select_tab_index_emoji", -1);
                O.putInt("select_tab_index_rapid", i3);
            } else if (i3 < 2) {
                O.putBoolean("is_qqemoj_click", true);
                O.putInt("select_tab_index_emoji", i3);
                O.putInt("select_tab_index_rapid", -1);
            } else {
                O.putBoolean("is_qqemoj_click", false);
                O.putInt("select_tab_index_emoji", -1);
                O.putInt("select_tab_index_rapid", i3 - 2);
            }
            if (this.G || this.H) {
                O.putLong("recom_tab_id", -1L);
            }
            O.commit();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        if (r3 < 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l() {
        int M;
        int M2;
        boolean z16 = this.G;
        final int i3 = -1;
        if ((z16 || this.H) && this.F) {
            if (!QQEmoCommentDataManager.I) {
                QQEmoCommentDataManager.I = true;
            } else if (u5.b.I("recom_tab_id", -1L) != -1) {
                int I = (int) u5.b.I("recom_tab_id", -1L);
                if (I != -1) {
                    if (this.G) {
                        M = RapidCommentDataManager.n().w(I);
                    } else if (this.H) {
                        M = QQEmoCommentDataManager.C().M(I);
                    }
                    i3 = M;
                }
                i3 = 0;
            } else if (u5.b.D("is_qqemoj_click", false)) {
                i3 = u5.b.G("select_tab_index_emoji", 0);
            } else {
                i3 = u5.b.G("select_tab_index_rapid", -2) + 2;
            }
        } else if (this.F) {
            i3 = u5.b.G("select_tab_index_emoji", 0);
        } else {
            if (z16 || this.H) {
                int I2 = (int) u5.b.I("recom_tab_id", -1L);
                if (I2 != -1) {
                    if (this.G) {
                        M2 = RapidCommentDataManager.n().w(I2);
                    } else {
                        M2 = QQEmoCommentDataManager.C().M(I2);
                    }
                    i3 = M2;
                } else {
                    i3 = u5.b.G("select_tab_index_rapid", 0);
                }
            }
            i3 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        RapidCommentTabLayout rapidCommentTabLayout = this.f60620h;
        if (rapidCommentTabLayout != null) {
            rapidCommentTabLayout.setTabFocus(i3);
        }
        if (this.f60620h != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.qzone.widget.RapidCommentEmoView.2
                @Override // java.lang.Runnable
                public void run() {
                    RapidCommentEmoView.this.f60620h.a(i3);
                }
            }, 300L);
        }
        this.f60617d.setCurrentItem(i3, false);
    }

    public void m() {
        if (this.T != null) {
            RapidCommentDataManager.n().I(this.T);
            this.T = null;
        }
        if (this.K != null) {
            QQEmoCommentDataManager.C().o();
            this.K = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.M == getHeight() || this.N) {
            return;
        }
        EditPositionBag editPositionBag = this.E;
        if (editPositionBag != null) {
            editPositionBag.a(getTop());
        }
        this.M = getHeight();
        this.N = true;
    }

    public void setIsActionPanel(boolean z16) {
        this.I = z16;
    }

    public void setStateChangeCallback(EditPositionBag editPositionBag) {
        this.E = editPositionBag;
    }

    public RapidCommentEmoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 0;
        this.D = 0;
        this.K = new d(this);
        this.R = new b();
        this.S = new c();
        this.T = new e(this);
        this.f60619f = context;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag() instanceof t.b) {
                RapidCommentEmoView.this.f60617d.setCurrentItem(((t.b) view.getTag()).f61081b, false);
            } else if (view.getTag() instanceof l.a) {
                l.a aVar = (l.a) view.getTag();
                RapidCommentEmoView.this.f60617d.setCurrentItem(aVar.f60898b, false);
                if (aVar.f60900d) {
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(431, 12, 1), false, true);
                    com.tencent.mobileqq.webview.util.y.a(LoginData.getInstance().getUinString(), null, null, null, 0, 0L, "ep_mall", "clk_collection", "0", 0, 0, 1, null, "", "1", null, null);
                } else {
                    com.tencent.mobileqq.webview.util.y.a(LoginData.getInstance().getUinString(), null, null, null, 0, 0L, "ep_mall", "clk_emoticon", "0", 0, 0, 1, null, aVar.f60901e, "1", null, null);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public void i(Context context, boolean z16, EmoticonCallback emoticonCallback, boolean z17, View.OnClickListener onClickListener, boolean z18, boolean z19) {
        j(context, z16, emoticonCallback, z17, onClickListener, z18, z19, false);
    }

    public void j(Context context, boolean z16, EmoticonCallback emoticonCallback, boolean z17, View.OnClickListener onClickListener, boolean z18, boolean z19, boolean z26) {
        this.F = z16;
        this.G = z17;
        this.H = z18;
        this.J = emoticonCallback;
        this.L = z26;
        if (z17) {
            k();
        }
        setBackgroundColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        addView(linearLayout);
        if (!this.I) {
            View view = new View(this.f60619f);
            this.f60622m = view;
            view.setBackgroundColor(getResources().getColor(R.color.qzone_skin_comment_divide_color));
            this.f60622m.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            linearLayout.addView(this.f60622m);
        }
        WrapContentHeightViewPager wrapContentHeightViewPager = new WrapContentHeightViewPager(getContext(), this.L);
        this.f60617d = wrapContentHeightViewPager;
        wrapContentHeightViewPager.setOnPageChangeListener(this.S);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f60617d.setLayoutParams(layoutParams);
        f fVar = new f(context, z16, emoticonCallback, z17, onClickListener, z18);
        this.f60618e = fVar;
        this.f60617d.setAdapter(fVar);
        linearLayout.addView(this.f60617d);
        View view2 = new View(this.f60619f);
        this.f60622m = view2;
        if (!this.I) {
            view2.setBackgroundColor(getResources().getColor(R.color.qzone_skin_comment_divide_color));
        } else {
            view2.setBackgroundColor(getResources().getColor(R.color.qui_common_border_light));
        }
        this.f60622m.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        linearLayout.addView(this.f60622m);
        if (z18) {
            l lVar = new l(this.f60619f, this.I);
            this.f60621i = lVar;
            lVar.b(this.R);
        } else {
            t tVar = new t(this.f60619f, this.I);
            this.f60621i = tVar;
            tVar.b(this.R);
        }
        RapidCommentTabLayout rapidCommentTabLayout = new RapidCommentTabLayout(this.f60619f, this.I);
        this.f60620h = rapidCommentTabLayout;
        rapidCommentTabLayout.setAdapter(this.f60621i);
        if (z16) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            relativeLayout.setLayoutParams(layoutParams2);
            ImageView imageView = new ImageView(getContext());
            int i3 = V;
            int i16 = U;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i3, i16);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            imageView.setLayoutParams(layoutParams3);
            imageView.setId(R.id.hgn);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(R.drawable.qzone_skin_emoji_delete);
            imageView.setContentDescription(getResources().getString(R.string.ajx));
            if (this.I) {
                imageView.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg);
            } else if (!QQTheme.isNowThemeIsNightForQzone()) {
                imageView.setBackgroundResource(R.drawable.f162214at0);
            }
            imageView.setOnClickListener(new a(emoticonCallback));
            relativeLayout.addView(imageView);
            View view3 = new View(this.f60619f);
            this.f60622m = view3;
            view3.setId(R.id.hgo);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(1, i16);
            if (!this.I) {
                this.f60622m.setBackgroundColor(getResources().getColor(R.color.qzone_skin_comment_divide_color));
            } else {
                this.f60622m.setBackgroundColor(getResources().getColor(R.color.qui_common_border_light));
            }
            layoutParams4.addRule(0, imageView.getId());
            this.f60622m.setLayoutParams(layoutParams4);
            relativeLayout.addView(this.f60622m);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(0, this.f60622m.getId());
            layoutParams5.addRule(9);
            this.f60620h.setLayoutParams(layoutParams5);
            relativeLayout.addView(this.f60620h);
            linearLayout.addView(relativeLayout);
        } else {
            this.f60620h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.f60620h);
        }
        if (z17) {
            RapidCommentDataManager n3 = RapidCommentDataManager.n();
            n3.h(this.T);
            n3.E();
        } else if (z18) {
            QQEmoCommentDataManager C = QQEmoCommentDataManager.C();
            C.n(this.K);
            C.Y(z19);
        } else {
            this.f60617d.setAdapter(this.f60618e);
            this.f60618e.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            RapidCommentEmoView.this.n(i3);
            if (RapidCommentEmoView.this.f60620h != null) {
                RapidCommentEmoView.this.f60620h.a(i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
