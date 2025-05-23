package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.hotpic.NTHotPicPageView;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.OneViewPagerAdapter;
import java.util.ArrayList;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class p extends OneViewPagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    NTHotPicMainPanel f237029d;

    /* renamed from: e, reason: collision with root package name */
    Context f237030e;

    /* renamed from: f, reason: collision with root package name */
    e f237031f;

    /* renamed from: h, reason: collision with root package name */
    SparseArray<NTHotPicPageView> f237032h;

    /* renamed from: i, reason: collision with root package name */
    protected a f237033i;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void onPageSelected(int i3);
    }

    public p(NTHotPicMainPanel nTHotPicMainPanel, ViewPager viewPager) {
        super(viewPager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTHotPicMainPanel, (Object) viewPager);
            return;
        }
        this.f237032h = new SparseArray<>();
        this.f237029d = nTHotPicMainPanel;
        this.f237030e = nTHotPicMainPanel.f236965h;
        this.f237031f = nTHotPicMainPanel.f236966i;
        this.f237033i = nTHotPicMainPanel;
    }

    public void d(int i3) {
        NTHotPicPageView valueAt;
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        for (int i16 = 0; i16 < this.f237032h.size() && (jVar = (valueAt = this.f237032h.valueAt(i16)).K) != null; i16++) {
            if (valueAt.I == i3) {
                jVar.c(true);
                valueAt.p();
            } else {
                jVar.c(false);
            }
        }
    }

    @Override // com.tencent.widget.OneViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
        } else {
            super.destroyItem(viewGroup, i3, obj);
            ((NTHotPicPageView) obj).r();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f237029d = null;
        }
    }

    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Manager hotPicManager = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicManager();
        NTHotPicPageView nTHotPicPageView = this.f237032h.get(i3);
        if (nTHotPicPageView != null && nTHotPicPageView.V) {
            nTHotPicPageView.E.c(false);
            if (i16 != 3) {
                if (i16 != 6) {
                    if (i16 != 7) {
                        if (i16 == 8) {
                            nTHotPicPageView.s();
                            return;
                        }
                        return;
                    } else {
                        nTHotPicPageView.s();
                        this.f237029d.u();
                        return;
                    }
                }
                if (!((IHotPicApi) QRoute.api(IHotPicApi.class)).checkIsNoMoreIndex(hotPicManager, i3)) {
                    i17 = 1;
                }
                nTHotPicPageView.E.d(i17);
                nTHotPicPageView.E.c(false);
                NTHotPicPageView.c cVar = nTHotPicPageView.D;
                cVar.notifyItemChanged(cVar.getItemCount());
                return;
            }
            synchronized (this) {
                nTHotPicPageView.f236981m.mClearSpanOnItemsChanged = false;
                int size = nTHotPicPageView.D.f236992d.size();
                ArrayList<HotPicData> hotPics = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPics(hotPicManager, i3);
                nTHotPicPageView.D.w(hotPics);
                int size2 = hotPics.size() - size;
                for (int i18 = size; i18 < size2; i18++) {
                    nTHotPicPageView.D.notifyItemInserted(i18);
                }
                nTHotPicPageView.D.notifyItemRangeChanged(size, hotPics.size());
            }
            nTHotPicPageView.n();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f237031f.f();
    }

    @Override // com.tencent.widget.OneViewPagerAdapter
    public View getView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        HotPicTagInfo d16 = this.f237031f.d(i3);
        NTHotPicPageView nTHotPicPageView = (NTHotPicPageView) LayoutInflater.from(this.f237030e).inflate(R.layout.fpz, (ViewGroup) null);
        nTHotPicPageView.setOnHotPicItemClickListener(null);
        if (d16 != null) {
            nTHotPicPageView.i(this.f237029d, d16);
            this.f237032h.put(d16.tagId, nTHotPicPageView);
        }
        return nTHotPicPageView;
    }

    @Override // com.tencent.widget.OneViewPagerAdapter
    public void initView(Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj, i3);
        } else if (obj != null && (obj instanceof NTHotPicPageView)) {
            ((NTHotPicPageView) obj).k();
        }
    }

    @Override // com.tencent.widget.OneViewPagerAdapter, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        super.onPageSelected(i3);
        a aVar = this.f237033i;
        if (aVar != null) {
            aVar.onPageSelected(i3);
        }
    }

    @Override // com.tencent.widget.OneViewPagerAdapter
    public void unInitView(Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj, i3);
        } else if (obj != null && (obj instanceof NTHotPicPageView)) {
            ((NTHotPicPageView) obj).g();
        }
    }
}
