package com.tencent.mobileqq.teamwork.menu;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes18.dex */
public class FilePanelMenuView extends RelativeLayout {
    private Handler C;

    /* renamed from: d, reason: collision with root package name */
    private TabLayoutCompat f292153d;

    /* renamed from: e, reason: collision with root package name */
    private ViewPagerCompat f292154e;

    /* renamed from: f, reason: collision with root package name */
    private a f292155f;

    /* renamed from: h, reason: collision with root package name */
    private View f292156h;

    /* renamed from: i, reason: collision with root package name */
    private List<MenuConfig$ToolBoxPageConfig> f292157i;

    /* renamed from: m, reason: collision with root package name */
    private MenuTabViewBase.a f292158m;

    /* loaded from: classes18.dex */
    public class a extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<MenuConfig$ToolBoxPageConfig> f292159d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private List<FilePanelMenuPage> f292160e = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.mobileqq.teamwork.menu.FilePanelMenuView$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public class C8640a implements MenuTabViewBase.a {
            C8640a() {
            }

            @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase.a
            public boolean a(au auVar) {
                if (FilePanelMenuView.this.f292158m != null) {
                    return FilePanelMenuView.this.f292158m.a(auVar);
                }
                return false;
            }
        }

        public a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
            viewGroup.removeView(this.f292160e.get(i3));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f292159d.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i3) {
            return this.f292159d.get(i3).f292177d;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
            viewGroup.addView(this.f292160e.get(i3));
            return this.f292160e.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        void setData(List<MenuConfig$ToolBoxPageConfig> list) {
            this.f292159d = list;
            this.f292160e.clear();
            for (MenuConfig$ToolBoxPageConfig menuConfig$ToolBoxPageConfig : this.f292159d) {
                FilePanelMenuPage filePanelMenuPage = new FilePanelMenuPage(FilePanelMenuView.this.getContext());
                filePanelMenuPage.setData(menuConfig$ToolBoxPageConfig.f292178e);
                filePanelMenuPage.setMenuClickListener(new C8640a());
                this.f292160e.add(filePanelMenuPage);
            }
            notifyDataSetChanged();
        }
    }

    public FilePanelMenuView(Context context) {
        this(context, null);
    }

    private int d(float f16) {
        return (int) com.tencent.mobileqq.utils.al.a(getContext(), f16);
    }

    private void e() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.g6w, this);
        this.f292153d = (TabLayoutCompat) findViewById(R.id.f33080vh);
        this.f292154e = (ViewPagerCompat) findViewById(R.id.f33090vi);
        View findViewById = findViewById(R.id.xdi);
        this.f292156h = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePanelMenuView.this.g(view);
            }
        });
        a aVar = new a();
        this.f292155f = aVar;
        this.f292154e.setAdapter(aVar);
        this.f292153d.setupWithViewPager(this.f292154e, true);
        f(this.f292153d);
    }

    private void f(TabLayoutCompat tabLayoutCompat) {
        tabLayoutCompat.setTabGravity(1);
        tabLayoutCompat.setTabMode(0);
        tabLayoutCompat.setSelectedTabIndicatorHeight(d(2.0f));
        tabLayoutCompat.setSelectedTabIndicatorColor(-536870912);
        tabLayoutCompat.setSelectedTabIndicatorPaddingLeft(d(18.0f));
        tabLayoutCompat.setSelectedTabIndicatorPaddingRight(d(18.0f));
        tabLayoutCompat.setTabTextColors(2046820352, -536870912);
        tabLayoutCompat.setTabTextSize(j(16.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        MenuTabViewBase.a aVar = this.f292158m;
        if (aVar != null) {
            aVar.a(new au(18));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f292153d.z(1).j();
    }

    public void i() {
        this.C.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.am
            @Override // java.lang.Runnable
            public final void run() {
                FilePanelMenuView.this.h();
            }
        }, 100L);
    }

    public int j(float f16) {
        return (int) ((f16 * getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void setConfigData(List<MenuConfig$ToolBoxPageConfig> list) {
        this.f292157i = list;
        this.f292155f.setData(list);
    }

    public void setMenuClickListener(MenuTabViewBase.a aVar) {
        this.f292158m = aVar;
    }

    public FilePanelMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilePanelMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new Handler(Looper.getMainLooper());
        e();
    }
}
