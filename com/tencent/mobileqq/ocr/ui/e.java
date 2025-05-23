package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends PagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public List<com.tencent.mobileqq.ocr.f> f254848d;

    /* renamed from: e, reason: collision with root package name */
    public BaseOCRTextSearchFragment.b f254849e;

    /* renamed from: f, reason: collision with root package name */
    SearchResultFragment f254850f;

    /* renamed from: h, reason: collision with root package name */
    Map<String, SearchResultPageView> f254851h;

    /* renamed from: i, reason: collision with root package name */
    ViewPager f254852i;

    /* renamed from: m, reason: collision with root package name */
    List<OCRTextSearchInfo.a> f254853m;

    public e(BaseOCRTextSearchFragment.b bVar, SearchResultFragment searchResultFragment, ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, searchResultFragment, viewPager);
            return;
        }
        this.f254848d = new ArrayList();
        this.f254851h = new HashMap();
        this.f254849e = bVar;
        this.f254850f = searchResultFragment;
        this.f254852i = viewPager;
    }

    void d(Context context) {
        SearchResultPageView searchResultPageView;
        for (int i3 = 0; i3 < this.f254848d.size(); i3++) {
            com.tencent.mobileqq.ocr.f fVar = this.f254848d.get(i3);
            if (this.f254851h.containsKey(fVar.f254760b)) {
                searchResultPageView = this.f254851h.get(fVar.f254760b);
            } else {
                searchResultPageView = new SearchResultPageView(this.f254849e, this.f254850f);
                this.f254851h.put(fVar.f254760b, searchResultPageView);
            }
            searchResultPageView.d(fVar.f254764f);
            searchResultPageView.c(context, fVar);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, viewGroup, Integer.valueOf(i3), obj);
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f254851h.get(this.f254848d.get(i3).f254760b).f();
        }
    }

    public List<com.tencent.mobileqq.ocr.f> f(String str, int i3, OCRTextSearchInfo.c cVar) {
        List<com.tencent.mobileqq.ocr.f> list;
        List<com.tencent.mobileqq.ocr.f> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), cVar);
        }
        if (cVar != null) {
            this.f254853m = cVar.f254553a;
        } else {
            this.f254853m = null;
        }
        this.f254848d.clear();
        if (cVar != null && (list2 = cVar.f254554b) != null) {
            this.f254848d = list2;
        }
        if (i3 == 0 && cVar != null && (list = cVar.f254554b) != null && list.size() > 0) {
            for (com.tencent.mobileqq.ocr.f fVar : this.f254848d) {
                if (fVar.f254759a == 0) {
                    fVar.f254761c = cVar.f254553a;
                    fVar.f254764f = cVar.f254555c;
                }
            }
        }
        if (this.f254848d.size() == 0) {
            com.tencent.mobileqq.ocr.f fVar2 = new com.tencent.mobileqq.ocr.f();
            fVar2.f254760b = HardCodeUtil.qqStr(R.string.t78);
            fVar2.f254759a = 0;
            List<OCRTextSearchInfo.a> list3 = this.f254853m;
            fVar2.f254761c = list3;
            if (list3 != null && list3.size() > 0) {
                fVar2.f254762d = i3;
            } else {
                fVar2.f254762d = -1;
            }
            fVar2.f254763e = str;
            this.f254848d.add(0, fVar2);
        }
        d(this.f254849e.getActivity());
        super.notifyDataSetChanged();
        return this.f254848d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        List<com.tencent.mobileqq.ocr.f> list = this.f254848d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, obj)).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup, i3);
        }
        com.tencent.mobileqq.ocr.f fVar = this.f254848d.get(i3);
        View c16 = this.f254851h.get(fVar.f254760b).c(this.f254849e.getActivity(), fVar);
        viewGroup.removeView(c16);
        viewGroup.addView(c16);
        return c16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }
}
