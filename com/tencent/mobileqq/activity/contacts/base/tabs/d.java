package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.af;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class d extends PagerAdapter {
    static IPatchRedirector $redirector_;
    private static Boolean C;

    /* renamed from: d, reason: collision with root package name */
    private final FragmentManager f181548d;

    /* renamed from: e, reason: collision with root package name */
    private FragmentTransaction f181549e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f181550f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Fragment> f181551h;

    /* renamed from: i, reason: collision with root package name */
    private Fragment f181552i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f181553m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            C = null;
        }
    }

    public d(FragmentManager fragmentManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentManager);
            return;
        }
        this.f181549e = null;
        this.f181550f = new ArrayList<>();
        this.f181551h = new ArrayList<>();
        this.f181552i = null;
        this.f181548d = fragmentManager;
    }

    private boolean e() {
        if (C == null) {
            C = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("contact_9070_124851941", true));
        }
        return C.booleanValue();
    }

    private boolean f() {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("101639", new byte[0]), StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("recommend_empty", false);
        } catch (JSONException e16) {
            QLog.e("FragmentStatePagerAdapter", 1, "[getConfigValue] exception: " + e16);
            return false;
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f181550f.clear();
            this.f181551h.clear();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        Fragment.SavedState savedState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
            return;
        }
        Fragment fragment = (Fragment) obj;
        if (this.f181549e == null) {
            this.f181549e = this.f181548d.beginTransaction();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FragmentStatePagerAdapter", 2, "Removing item #" + i3 + ": f=" + obj + " v=" + fragment.getView());
        }
        while (this.f181550f.size() <= i3) {
            this.f181550f.add(null);
        }
        ArrayList<Fragment.SavedState> arrayList = this.f181550f;
        if (fragment.isAdded()) {
            savedState = this.f181548d.saveFragmentInstanceState(fragment);
        } else {
            savedState = null;
        }
        arrayList.set(i3, savedState);
        if (i3 >= 0 && i3 < this.f181551h.size()) {
            this.f181551h.set(i3, null);
        }
        this.f181549e.hide(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup);
            return;
        }
        if (this.f181549e != null) {
            if (this.f181553m && af.d() && e()) {
                this.f181549e.commitNowAllowingStateLoss();
            } else {
                this.f181549e.commitAllowingStateLoss();
            }
            this.f181549e = null;
        }
    }

    public abstract Fragment getItem(int i3);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        Fragment.SavedState savedState;
        Fragment fragment;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
        }
        if (this.f181551h.size() > i3 && (fragment = this.f181551h.get(i3)) != null && fragment.isAdded()) {
            Bundle arguments = fragment.getArguments();
            if (arguments != null) {
                z16 = arguments.getBoolean("isFromFindTroop", false);
            } else {
                z16 = false;
            }
            if (!z16 && viewGroup.isAttachedToWindow()) {
                return fragment;
            }
            QLog.e("FragmentStatePagerAdapter", 1, "container state is wrong");
        }
        if (this.f181549e == null) {
            this.f181549e = this.f181548d.beginTransaction();
        }
        Fragment item = getItem(i3);
        if (QLog.isColorLevel()) {
            QLog.d("FragmentStatePagerAdapter", 2, "Adding item #" + i3 + ": f=" + item);
        }
        if (item != null) {
            if (this.f181550f.size() > i3 && (savedState = this.f181550f.get(i3)) != null && !com.tencent.relation.common.config.toggle.c.U.g(false) && item.getFragmentManager() == null && !item.isAdded()) {
                item.setInitialSavedState(savedState);
            }
            while (this.f181551h.size() <= i3) {
                this.f181551h.add(null);
            }
            item.setMenuVisibility(false);
            item.setUserVisibleHint(false);
            this.f181551h.set(i3, item);
            String valueOf = String.valueOf(item.hashCode());
            if (!item.isAdded() && this.f181548d.findFragmentByTag(valueOf) == null) {
                this.f181549e.add(viewGroup.getId(), item, valueOf);
                this.f181548d.findFragmentByTag(valueOf);
            } else {
                boolean f16 = f();
                QLog.d("FragmentStatePagerAdapter", 2, "emptyBugSwitchOn:", Boolean.valueOf(f16));
                if (f16) {
                    this.f181549e.show(item);
                }
            }
        }
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (((Fragment) obj).getView() == view) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[SYNTHETIC] */
    @Override // androidx.viewpager.widget.PagerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Fragment fragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcelable, (Object) classLoader);
            return;
        }
        if (parcelable != null) {
            QLog.d("FragmentStatePagerAdapter", 2, "restoreState");
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f181550f.clear();
            this.f181551h.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f181550f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    try {
                    } catch (Exception e16) {
                        QLog.e("FragmentStatePagerAdapter", 1, "restoreState error: " + e16.getMessage());
                    }
                    if (this.f181548d.getFragments() != null) {
                        fragment = this.f181548d.getFragment(bundle, str);
                        if (fragment == null) {
                            while (this.f181551h.size() <= parseInt) {
                                this.f181551h.add(null);
                            }
                            fragment.setMenuVisibility(false);
                            this.f181551h.set(parseInt, fragment);
                            QLog.d("FragmentStatePagerAdapter", 2, "restoreState key: " + str + "  " + fragment);
                        } else {
                            QLog.d("FragmentStatePagerAdapter", 2, "Bad fragment at key " + str);
                        }
                    }
                    fragment = null;
                    if (fragment == null) {
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Parcelable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.f181550f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f181550f.size()];
            this.f181550f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i3 = 0; i3 < this.f181551h.size(); i3++) {
            Fragment fragment = this.f181551h.get(i3);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                String str = "f" + i3;
                QLog.d("FragmentStatePagerAdapter", 2, "saveState key: " + str + "  " + fragment);
                try {
                    this.f181548d.putFragment(bundle, str, fragment);
                } catch (Exception e16) {
                    QLog.e("FragmentStatePagerAdapter", 1, "saveState error: " + e16.getMessage());
                }
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, viewGroup, Integer.valueOf(i3), obj);
            return;
        }
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f181552i;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f181552i.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f181552i = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
        } else {
            if (viewGroup.getId() != -1) {
                return;
            }
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public d(FragmentManager fragmentManager, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fragmentManager, Boolean.valueOf(z16));
            return;
        }
        this.f181549e = null;
        this.f181550f = new ArrayList<>();
        this.f181551h = new ArrayList<>();
        this.f181552i = null;
        this.f181548d = fragmentManager;
        this.f181553m = z16;
    }
}
