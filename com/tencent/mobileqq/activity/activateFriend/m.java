package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m extends PagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<ActivateBasePage> f177978d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<ViewPager> f177979e;

    public m(ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewPager);
            return;
        }
        this.f177978d = new ArrayList<>();
        this.f177979e = null;
        this.f177979e = new WeakReference<>(viewPager);
    }

    public void d(ActivateBasePage activateBasePage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activateBasePage);
        } else {
            this.f177978d.add(activateBasePage);
            notifyDataSetChanged();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<ActivateBasePage> it = this.f177978d.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, viewGroup, Integer.valueOf(i3), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivatePageAdapter", 4, "destroy item");
        }
        if (this.f177978d.size() > i3) {
            ActivateBasePage activateBasePage = this.f177978d.get(i3);
            if (activateBasePage instanceof ReminderCardItemPage) {
                activateBasePage.destroy();
            }
        }
        viewGroup.removeView((View) obj);
    }

    public void e(ActivateBasePage activateBasePage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activateBasePage, i3);
        } else {
            this.f177978d.add(i3, activateBasePage);
            notifyDataSetChanged();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        WeakReference<ViewPager> weakReference = this.f177979e;
        if (weakReference != null && weakReference.get() != null) {
            this.f177979e.get().setAdapter(null);
            this.f177978d.clear();
            this.f177979e.get().setAdapter(this);
        }
    }

    public ArrayList<ActivateBasePage> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ArrayList) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f177978d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f177978d.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, obj)).intValue();
        }
        return -2;
    }

    public void h(int i3) {
        ActivateBasePage activateBasePage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        ArrayList<ActivateBasePage> arrayList = this.f177978d;
        if (arrayList != null && !arrayList.isEmpty() && i3 >= 0 && i3 < this.f177978d.size() && (activateBasePage = this.f177978d.get(i3)) != null) {
            activateBasePage.c();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup, i3);
        }
        ActivateBasePage activateBasePage = this.f177978d.get(i3);
        if (activateBasePage.getParent() != null) {
            ((ViewGroup) activateBasePage.getParent()).removeView(activateBasePage);
            if (QLog.isColorLevel()) {
                QLog.i("ActivatePageAdapter", 2, "instantiateItem page already has parent pos:" + i3);
            }
        }
        try {
            viewGroup.addView(activateBasePage);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ActivatePageAdapter", 2, e16.getMessage(), e16);
            }
        }
        return activateBasePage;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<ActivateBasePage> it = this.f177978d.iterator();
        while (it.hasNext()) {
            it.next().refresh();
        }
    }
}
