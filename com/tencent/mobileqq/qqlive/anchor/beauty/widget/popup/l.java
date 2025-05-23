package com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.CategoryItem;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.BeautyGroupEventor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class l implements SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    private View C;
    private TextView D;
    private int E;
    private HashMap<Integer, Integer> F;
    protected View.OnClickListener G;
    protected ViewPager.OnPageChangeListener H;

    /* renamed from: d, reason: collision with root package name */
    private DataModel f270619d;

    /* renamed from: e, reason: collision with root package name */
    private ViewPager f270620e;

    /* renamed from: f, reason: collision with root package name */
    private d f270621f;

    /* renamed from: h, reason: collision with root package name */
    private final List<EffectPageView> f270622h;

    /* renamed from: i, reason: collision with root package name */
    private View f270623i;

    /* renamed from: m, reason: collision with root package name */
    private List<TextView> f270624m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (l.this.E >= 0) {
                l.this.f270620e.setCurrentItem(l.this.E);
            } else {
                l.this.f270620e.setCurrentItem(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                l.this.f270620e.setCurrentItem(((Integer) view.getTag()).intValue());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 >= l.this.f270624m.size()) {
                l.this.D.setText(((EffectPageView) l.this.f270622h.get(i3)).k());
                l.this.f270623i.setVisibility(8);
                l.this.C.setVisibility(0);
            } else {
                ((TextView) l.this.f270624m.get(i3)).setTextColor(-1);
                for (int i16 = 0; i16 < l.this.f270624m.size(); i16++) {
                    if (i16 != i3) {
                        ((TextView) l.this.f270624m.get(i16)).setTextColor(-1929379841);
                    }
                }
                l.this.E = i3;
                l.this.f270623i.setVisibility(0);
                l.this.C.setVisibility(8);
            }
            ((EffectPageView) l.this.f270622h.get(i3)).setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d extends PagerAdapter {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
            } else {
                viewGroup.removeView((View) l.this.f270622h.get(i3));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return l.this.f270622h.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
            }
            viewGroup.addView((View) l.this.f270622h.get(i3));
            return l.this.f270622h.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270622h = new ArrayList();
        this.f270624m = new ArrayList();
        this.E = -1;
        this.F = new HashMap<>();
        this.G = new b();
        this.H = new c();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(BeautyGroupEventor.class);
        return arrayList;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    protected void j(Activity activity, View view) {
        CategoryItem.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) view);
            return;
        }
        List<CategoryItem> n3 = this.f270619d.n();
        if (n3 == null) {
            return;
        }
        for (CategoryItem categoryItem : n3) {
            EffectPageView effectPageView = new EffectPageView(activity);
            Iterator<CategoryItem.a> it = categoryItem.f270411e.iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    if (aVar.j()) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar == null && categoryItem.f270408b == 1 && categoryItem.f270411e.size() > 1) {
                aVar = categoryItem.f270411e.get(1);
            }
            if (aVar == null && categoryItem.f270408b != 1 && categoryItem.f270411e.size() > 0) {
                aVar = categoryItem.f270411e.get(0);
            }
            if (aVar != null) {
                aVar.m(true);
            }
            effectPageView.setData(categoryItem, aVar);
            effectPageView.setRootContainer(view);
            if (!this.F.containsKey(Integer.valueOf(categoryItem.f270408b))) {
                this.F.put(Integer.valueOf(categoryItem.f270408b), Integer.valueOf(this.f270622h.size()));
            }
            this.f270622h.add(effectPageView);
        }
        this.f270621f = new d();
    }

    protected void k(View view) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        this.f270623i = view.findViewById(R.id.urm);
        this.C = view.findViewById(R.id.urj);
        this.D = (TextView) view.findViewById(R.id.url);
        view.findViewById(R.id.urk).setOnClickListener(new a());
        this.f270624m.add((TextView) view.findViewById(R.id.urn));
        this.f270624m.add((TextView) view.findViewById(R.id.uro));
        this.f270624m.add((TextView) view.findViewById(R.id.urp));
        for (int i3 = 0; i3 < this.f270624m.size(); i3++) {
            this.f270624m.get(i3).setTag(Integer.valueOf(i3));
            this.f270624m.get(i3).setOnClickListener(this.G);
        }
        if (this.f270624m.size() > 0) {
            textView = this.f270624m.get(0);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setTextColor(-1);
        }
    }

    public void l(Activity activity, View view) {
        EffectPageView effectPageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) view);
            return;
        }
        this.f270619d = DataModel.i();
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.urf);
        this.f270620e = viewPager;
        viewPager.addOnPageChangeListener(this.H);
        k(view);
        j(activity, view);
        this.f270620e.setAdapter(this.f270621f);
        this.f270621f.notifyDataSetChanged();
        this.f270620e.setCurrentItem(0);
        if (this.f270622h.size() > 0) {
            effectPageView = this.f270622h.get(0);
        } else {
            effectPageView = null;
        }
        if (effectPageView != null) {
            effectPageView.setSelected(true);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f270619d = null;
        this.f270620e = null;
        this.f270621f = null;
        this.f270623i = null;
        List<EffectPageView> list = this.f270622h;
        if (list != null) {
            list.clear();
        }
        List<TextView> list2 = this.f270624m;
        if (list2 != null) {
            list2.clear();
            this.f270624m = null;
        }
        HashMap<Integer, Integer> hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
            this.F = null;
        }
        this.C = null;
        this.D = null;
        this.E = -1;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof BeautyGroupEventor) {
            int k3 = DataModel.k(((BeautyGroupEventor) simpleBaseEvent).data.f270414b);
            if (this.F.containsKey(Integer.valueOf(k3))) {
                this.f270620e.setCurrentItem(this.F.get(Integer.valueOf(k3)).intValue());
            }
        }
    }
}
