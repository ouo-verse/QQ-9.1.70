package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.aio.base.tool.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.qa.config.QAArticleConfigParser;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.GameArticleListAdapter;
import com.tencent.mobileqq.gamecenter.qa.view.o;
import com.tencent.mobileqq.gamecenter.qa.view.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import ud1.g;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyArticleFragment extends QPublicBaseFragment implements TabLayout.d, View.OnClickListener, o.c, ViewPager.OnPageChangeListener {
    private RelativeLayout C;
    private TabLayout D;
    private ud1.g E;
    private ViewPager F;
    private o G;
    private ImageView H;
    private TextView I;
    private int J;
    private ImageView L;
    private PopupWindow M;
    private ListView N;
    private q P;
    private View Q;
    private View R;
    private GameQALinkCardData S;
    private long T;
    private int U;
    private String W;
    private final HashMap<Integer, Integer> K = new HashMap<>();
    private long V = 0;
    private AdapterView.OnItemClickListener X = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            QQGameStrategyArticleFragment.this.M.dismiss();
            QQGameStrategyArticleFragment.this.Eh(i3);
            QQGameStrategyArticleFragment qQGameStrategyArticleFragment = QQGameStrategyArticleFragment.this;
            if (i3 == qQGameStrategyArticleFragment.Ah(Integer.valueOf(qQGameStrategyArticleFragment.J))) {
                QLog.i("QQGameStrategyArticleFragment", 2, "position == lastSourceTypePosition");
            } else {
                QQGameStrategyArticleFragment.this.K.put(Integer.valueOf(QQGameStrategyArticleFragment.this.J), Integer.valueOf(i3));
                QQGameStrategyArticleFragment.this.Hh();
                View f16 = QQGameStrategyArticleFragment.this.G.f();
                if (f16 != null && f16.getTag() != null) {
                    o.b bVar = (o.b) f16.getTag();
                    if (bVar.m().b() != null) {
                        QQGameStrategyArticleFragment.this.R.setEnabled(false);
                    }
                    g.b zh5 = QQGameStrategyArticleFragment.this.zh();
                    if (zh5 != null) {
                        bVar.v(zh5.f438847a);
                    }
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ah(Integer num) {
        Integer num2;
        if (this.K.containsKey(num) && (num2 = this.K.get(num)) != null) {
            return num2.intValue();
        }
        return 0;
    }

    private List<g.b> Bh() {
        if (this.E.a().size() <= this.J) {
            return null;
        }
        return this.E.a().get(this.J).b();
    }

    private int Ch() {
        g.a aVar;
        if (this.E.a().size() <= this.J || (aVar = this.E.a().get(this.J)) == null || aVar.f438843a == LinkType.REFERENCE_TYPE_QA.getType()) {
            return 6;
        }
        if (aVar.f438843a == LinkType.REFERENCE_TYPE_XWORLD.getType()) {
            return 1;
        }
        if (aVar.f438843a != LinkType.REFERENCE_TYPE_CHANNEL.getType()) {
            return 6;
        }
        return 3;
    }

    private int Dh(g.a aVar) {
        if (aVar == null || aVar.f438843a == LinkType.REFERENCE_TYPE_QA.getType()) {
            return 6;
        }
        if (aVar.f438843a == LinkType.REFERENCE_TYPE_XWORLD.getType()) {
            return 1;
        }
        if (aVar.f438843a != LinkType.REFERENCE_TYPE_CHANNEL.getType()) {
            return 6;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(int i3) {
        String str;
        List<g.b> Bh = Bh();
        if (Bh != null && !Bh.isEmpty()) {
            g.b bVar = Bh.get(i3);
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.T));
            if (bVar.f438847a == 0) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put(9, str);
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912757", "20", String.valueOf(this.U), hashMap);
        }
    }

    private void Fh() {
        String str;
        if (this.S != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("cardData", this.S);
            intent.putExtras(bundle);
            getActivity().setResult(-1, intent);
            HashMap hashMap = new HashMap();
            hashMap.put(6, String.valueOf(this.T));
            if (this.S.getTitle() != null) {
                str = this.S.getTitle();
            } else {
                str = "";
            }
            hashMap.put(3, str);
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912758", "20", String.valueOf(this.U), hashMap);
        } else {
            QLog.e("QQGameStrategyArticleFragment", 1, "selectQuoteArticle exception mSelectedCardData = null");
            getActivity().setResult(0);
        }
        getActivity().finish();
    }

    private void Gh() {
        if (this.M == null) {
            this.M = new PopupWindow();
            View inflate = LayoutInflater.from(this.C.getContext()).inflate(R.layout.eaz, (ViewGroup) null);
            this.N = (ListView) inflate.findViewById(R.id.f87054tb);
            q qVar = new q();
            this.P = qVar;
            this.N.setAdapter((ListAdapter) qVar);
            this.N.setOnItemClickListener(this.X);
            this.M.setContentView(inflate);
            this.M.setOutsideTouchable(true);
            this.M.setFocusable(true);
            this.M.setBackgroundDrawable(new BitmapDrawable());
        }
        List<g.b> Bh = Bh();
        this.P.c(Bh);
        this.P.b(Ah(Integer.valueOf(this.J)));
        a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
        int b16 = companion.b(this.C.getContext(), 15);
        int b17 = companion.b(this.C.getContext(), 114);
        int b18 = companion.b(this.C.getContext(), 45);
        int b19 = companion.b(this.C.getContext(), 10);
        this.M.setWidth(b17 + b16);
        this.M.setHeight((Bh.size() * b18) + (b19 * 2) + b16);
        this.M.showAsDropDown(this.H, 0, 0, 85);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        ud1.g gVar = this.E;
        if (gVar == null) {
            this.I.setVisibility(8);
            this.H.setVisibility(8);
            return;
        }
        if (gVar.a().isEmpty()) {
            this.I.setVisibility(8);
            this.H.setVisibility(8);
        } else {
            if (this.E.a().get(this.J).f438843a == 100) {
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                return;
            }
            g.b zh5 = zh();
            if (zh5 == null) {
                return;
            }
            this.I.setVisibility(0);
            this.H.setVisibility(0);
            this.I.setText(zh5.f438848b);
        }
    }

    private void init() {
        this.D = (TabLayout) this.C.findViewById(R.id.j_o);
        this.Q = this.C.findViewById(R.id.acy);
        View findViewById = this.C.findViewById(R.id.tv9);
        this.R = findViewById;
        findViewById.setOnClickListener(this);
        this.R.setEnabled(false);
        this.F = (ViewPager) this.C.findViewById(R.id.f919156g);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f9182568);
        this.H = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) this.C.findViewById(R.id.f9183569);
        this.I = textView;
        textView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.C.findViewById(R.id.f98945og);
        this.L = imageView2;
        imageView2.setOnClickListener(this);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        if (isNowThemeIsNight) {
            this.L.setImageResource(R.drawable.mww);
            this.H.setImageResource(R.drawable.f160772mv4);
        }
        QAArticleConfigParser.b bVar = (QAArticleConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100492");
        if (bVar != null && bVar.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String() != null && !bVar.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().a().isEmpty()) {
            getActivity().getWindow().setFlags(16777216, 16777216);
            this.J = 0;
            ud1.g gVar = bVar.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            this.E = gVar;
            for (g.a aVar : gVar.a()) {
                TextView textView2 = (TextView) LayoutInflater.from(this.C.getContext()).inflate(R.layout.ebn, (ViewGroup) null);
                TabLayout.g J = this.D.J();
                textView2.setText(aVar.f438844b);
                textView2.setSingleLine();
                J.p(textView2);
                this.D.g(J);
                HashMap hashMap = new HashMap();
                hashMap.put(6, String.valueOf(this.T));
                hashMap.put(9, String.valueOf(Dh(aVar)));
                com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912755", "8", String.valueOf(this.U), hashMap);
            }
            this.D.f(this);
            o oVar = new o();
            this.G = oVar;
            oVar.h(this.E.a());
            this.G.g(this);
            this.G.i(this.U, this.T);
            this.F.setAdapter(this.G);
            this.F.setOffscreenPageLimit(this.E.a().size());
            this.F.addOnPageChangeListener(new TabLayout.h(this.D));
            this.F.addOnPageChangeListener(this);
            Hh();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(6, String.valueOf(this.T));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912751", "7", String.valueOf(this.U), hashMap2);
            return;
        }
        View inflate = LayoutInflater.from(this.C.getContext()).inflate(R.layout.eav, (ViewGroup) null);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.f164492sw1);
        if (isNowThemeIsNight) {
            imageView3.setImageResource(R.drawable.ogw);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.C.addView(inflate, layoutParams);
        this.F.setVisibility(8);
        this.Q.setVisibility(8);
        this.D.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
    }

    public static Intent yh(int i3, long j3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putLong("questionId", j3);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.b zh() {
        if (this.E.a().size() <= this.J) {
            return null;
        }
        List<g.b> b16 = this.E.a().get(this.J).b();
        int Ah = Ah(Integer.valueOf(this.J));
        if (b16.size() <= Ah) {
            return null;
        }
        return b16.get(Ah);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.o.c
    public void Hc(GameArticleListAdapter gameArticleListAdapter, int i3) {
        boolean z16;
        String str;
        GameQALinkCardData b16 = gameArticleListAdapter.b();
        this.S = b16;
        if (b16 != null) {
            this.W = b16.getTitle();
        }
        View view = this.R;
        if (this.S != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        view.setEnabled(z16);
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(this.T));
        if (this.S != null) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put(2, str);
        String str2 = this.W;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put(3, str2);
        hashMap.put(9, String.valueOf(Ch()));
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912754", "20", String.valueOf(this.U), hashMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.o.c
    public void dc(boolean z16, List<GameQALinkCardData> list) {
        int i3;
        if (z16) {
            View view = this.Q;
            if (list != null && !list.isEmpty()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != this.H && view != this.I) {
            if (view == this.R) {
                Fh();
            } else if (view == this.L && getActivity() != null) {
                getActivity().finish();
            }
        } else {
            Gh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.U = arguments.getInt("appId");
            this.T = arguments.getLong("questionId");
        }
        this.C = (RelativeLayout) layoutInflater.inflate(R.layout.eaw, viewGroup, false);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            GameQAUtil.I(this.C, getQBaseActivity(), ThemeUtil.isNowThemeIsNight(null, false, null));
        }
        init();
        RelativeLayout relativeLayout = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, relativeLayout);
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.M;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        o oVar = this.G;
        if (oVar != null) {
            oVar.onDestroy();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        int i16;
        View f16 = this.G.f();
        if (f16 != null && f16.getTag() != null) {
            o.b bVar = (o.b) f16.getTag();
            View view = this.Q;
            if (bVar.n()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            view.setVisibility(i16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(this.T));
        hashMap.put(46, String.valueOf(System.currentTimeMillis() - this.V));
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912752", "", String.valueOf(this.U), hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.V = System.currentTimeMillis();
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.g gVar) {
        this.J = gVar.g();
        ((TextView) gVar.e()).setTextColor(getResources().getColor(R.color.cfg));
        this.F.setCurrentItem(gVar.g());
        Hh();
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(this.T));
        hashMap.put(9, String.valueOf(Ch()));
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912756", "20", String.valueOf(this.U), hashMap);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.g gVar) {
        ((TextView) gVar.e()).setTextColor(getResources().getColor(R.color.qqgame_strategy_article_tab_unselected_text_color));
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.o.c
    public void sb(g.a aVar) {
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= this.E.a().size()) {
                break;
            }
            if (this.E.a().get(i16).f438843a == 100) {
                i3 = i16;
                break;
            }
            i16++;
        }
        this.F.setCurrentItem(i3);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.g gVar) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
