package com.tencent.mobileqq.ocr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SearchResultFragment extends BaseOCRTextSearchFragment {
    static IPatchRedirector $redirector_;
    ViewPager E;
    ScrolledTabHost F;
    e G;
    protected int H;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements ScrolledTabHost.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchResultFragment.this);
            }
        }

        @Override // com.tencent.biz.lebasearch.widget.ScrolledTabHost.b
        public void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                SearchResultFragment.this.E.setCurrentItem(i3);
                SearchResultFragment.this.C.a(false);
            }
        }

        @Override // com.tencent.biz.lebasearch.widget.ScrolledTabHost.b
        public void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchResultFragment.this);
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
            SearchResultFragment.this.F.setCurrentTab(i3);
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            if (searchResultFragment.H != i3) {
                searchResultFragment.G.e(i3);
            }
            SearchResultFragment.this.H = i3;
        }
    }

    public SearchResultFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.H = 0;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            ReportController.o(null, "dc00898", "", "", "0X80082E6", "0X80082E6", 0, 0, "", "", "", "");
            super.onCreate(bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.a07, (ViewGroup) null);
            this.E = (ViewPager) inflate.findViewById(R.id.kxy);
            this.F = (ScrolledTabHost) inflate.findViewById(R.id.tabhost);
            e eVar = new e(this.C, this, this.E);
            this.G = eVar;
            this.E.setAdapter(eVar);
            this.F.setOnTabSelectedListener(new a());
            this.E.setOnPageChangeListener(new b());
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    public void ph(String str, int i3, OCRTextSearchInfo.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), cVar);
            return;
        }
        List<com.tencent.mobileqq.ocr.f> f16 = this.G.f(str, i3, cVar);
        this.F.b();
        for (int i16 = 0; i16 < f16.size(); i16++) {
            this.F.a(f16.get(i16).f254760b);
        }
        if (f16.size() == 1) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
        this.F.setCurrentTab(0);
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ScrolledTabHost scrolledTabHost = this.F;
        if (scrolledTabHost != null) {
            scrolledTabHost.e();
        }
    }
}
