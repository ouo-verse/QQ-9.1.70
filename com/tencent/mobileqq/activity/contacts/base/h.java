package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetPinnedHeaderListView;
import com.tencent.mobileqq.activity.contacts.friend.ContactsFPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;
import com.tencent.mobileqq.contact.IContactExtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f181517a;

    /* renamed from: b, reason: collision with root package name */
    private a f181518b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        View getScrollableView();
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f181517a = Build.VERSION.SDK_INT;
        }
    }

    private View a() {
        a aVar = this.f181518b;
        if (aVar == null) {
            return null;
        }
        return aVar.getScrollableView();
    }

    private boolean b(AdapterView adapterView) {
        View childAt;
        if (adapterView == null || adapterView.getFirstVisiblePosition() != 0 || ((childAt = adapterView.getChildAt(0)) != null && childAt.getTop() != 0)) {
            return false;
        }
        return true;
    }

    private boolean c(com.tencent.widget.AdapterView adapterView) {
        View childAt;
        if (adapterView == null || adapterView.getFirstVisiblePosition() != 0 || ((childAt = adapterView.getChildAt(0)) != null && childAt.getTop() != 0)) {
            return false;
        }
        return true;
    }

    private boolean d(ScrollView scrollView) {
        if (scrollView == null || scrollView.getScrollY() <= 0) {
            return true;
        }
        return false;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        View a16 = a();
        if (a16 == null) {
            return true;
        }
        if (a16 instanceof com.tencent.widget.AdapterView) {
            return c((com.tencent.widget.AdapterView) a16);
        }
        if (a16 instanceof AdapterView) {
            return b((AdapterView) a16);
        }
        if (!(a16 instanceof ScrollView)) {
            return true;
        }
        return d((ScrollView) a16);
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        View a16 = a();
        if (a16 != null) {
            if (a16 instanceof ContactsFPSPinnedHeaderExpandableListView) {
                ((ContactsFPSPinnedHeaderExpandableListView) a16).setChildViewCanAction(z16);
                return;
            }
            if (a16 instanceof TroopFragment.ContactsPinnedHeaderExpandableListView) {
                ((TroopFragment.ContactsPinnedHeaderExpandableListView) a16).setChildViewCanAction(z16);
            } else if (a16 instanceof AlphabetPinnedHeaderListView) {
                ((AlphabetPinnedHeaderListView) a16).setChildViewCanAction(z16);
            } else {
                ((IContactExtApi) QRoute.api(IContactExtApi.class)).setChildViewCanAction(a16, z16);
            }
        }
    }

    public void g(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f181518b = aVar;
        }
    }

    @SuppressLint({"NewApi"})
    public void h(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        View a16 = a();
        if (a16 instanceof AbsListView) {
            ((AbsListView) a16).smoothScrollBy(i16, i17);
            return;
        }
        if (a16 instanceof com.tencent.widget.AbsListView) {
            ((com.tencent.widget.AbsListView) a16).smoothScrollBy(i16, i17);
        } else if (a16 instanceof ScrollView) {
            ((ScrollView) a16).fling(i3);
        } else if (a16 instanceof WebView) {
            ((WebView) a16).flingScroll(0, i3);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        View a16 = a();
        if (a16 instanceof AbsListView) {
            ((AbsListView) a16).smoothScrollToPosition(0);
            return;
        }
        if (a16 instanceof com.tencent.widget.AbsListView) {
            ((com.tencent.widget.AbsListView) a16).smoothScrollToPosition(0);
            return;
        }
        if (a16 instanceof ScrollView) {
            ((ScrollView) a16).smoothScrollTo(0, 0);
        } else if (a16 instanceof WebView) {
            a16.scrollTo(0, 0);
        } else if (a16 instanceof RecyclerView) {
            ((RecyclerView) a16).smoothScrollToPosition(0);
        }
    }
}
