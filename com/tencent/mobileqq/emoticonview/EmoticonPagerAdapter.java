package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonPagerAdapter extends PagerAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPagerAdapter";
    private List<EmoticonViewBinder> viewBinderList;
    private boolean viewRecycleable;

    public EmoticonPagerAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewRecycleable = true;
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        List<EmoticonViewBinder> list = this.viewBinderList;
        if (list != null) {
            Iterator<EmoticonViewBinder> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.viewBinderList = null;
        }
        EmoticonPanelViewBinder.destroyViewPool();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i3, Object obj) {
        EmoticonPanelViewBinder emoticonPanelViewBinder;
        int panelPageCount;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Integer.valueOf(i3), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[RecycleView] destroyItem, position=" + i3 + ", viewRecycleable=" + this.viewRecycleable);
        }
        ((ViewGroup) view).removeView((View) obj);
        if (!this.viewRecycleable) {
            return;
        }
        for (EmoticonViewBinder emoticonViewBinder : this.viewBinderList) {
            if (emoticonViewBinder != null && (emoticonViewBinder instanceof EmoticonPanelViewBinder) && i3 + 1 <= (i16 = i16 + (panelPageCount = (emoticonPanelViewBinder = (EmoticonPanelViewBinder) emoticonViewBinder).getPanelPageCount()))) {
                int i17 = panelPageCount - (i16 - i3);
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "[RecycleView] destroyItem, position=" + i3 + ", viewBinder=" + emoticonPanelViewBinder + ", innerIndex=" + i17);
                }
                emoticonPanelViewBinder.destroyEmoticonPanelView(i17);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        List<EmoticonViewBinder> list = this.viewBinderList;
        int i3 = 0;
        if (list != null && list.size() != 0) {
            for (EmoticonViewBinder emoticonViewBinder : this.viewBinderList) {
                if (emoticonViewBinder != null && (emoticonViewBinder instanceof EmoticonPanelViewBinder)) {
                    i3 += ((EmoticonPanelViewBinder) emoticonViewBinder).getPanelPageCount();
                }
            }
        }
        return i3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, obj)).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View view, int i3) {
        View view2;
        EmoticonPanelViewBinder emoticonPanelViewBinder;
        int panelPageCount;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<EmoticonViewBinder> it = this.viewBinderList.iterator();
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                EmoticonViewBinder next = it.next();
                if (next != null && (next instanceof EmoticonPanelViewBinder) && i3 + 1 <= (i16 = i16 + (panelPageCount = (emoticonPanelViewBinder = (EmoticonPanelViewBinder) next).getPanelPageCount()))) {
                    view2 = emoticonPanelViewBinder.getEmoticonPanelView(panelPageCount - (i16 - i3));
                    break;
                }
            } else {
                view2 = null;
                break;
            }
        }
        if (view2 != null && view2.getParent() != view && i3 < getF373114d()) {
            ((ViewGroup) view).addView(view2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[Performance] instantiateItem, position=" + i3 + ", duration=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return view2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void setViewBinderList(List<EmoticonViewBinder> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setViewBinderList(list, true);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
    }

    public void setViewRecycleable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.viewRecycleable = z16;
        }
    }

    public void setViewBinderList(List<EmoticonViewBinder> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, Boolean.valueOf(z16));
            return;
        }
        this.viewRecycleable = false;
        this.viewBinderList = list;
        if (z16) {
            super.notifyDataSetChanged();
        }
    }
}
