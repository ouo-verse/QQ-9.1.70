package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.g;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends d implements ContactsBaseFragment.b {
    static IPatchRedirector $redirector_;
    protected SparseArray<ContactsBaseFragment> D;
    protected ContactsBaseFragment.c E;
    protected QQAppInterface F;
    protected BaseActivity G;
    private boolean H;
    protected ArrayList<f> I;
    protected ArrayList<g> J;
    protected int K;
    protected int L;
    private final boolean M;

    public c(FragmentManager fragmentManager, QQAppInterface qQAppInterface, BaseActivity baseActivity, ArrayList<f> arrayList) {
        super(fragmentManager, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fragmentManager, qQAppInterface, baseActivity, arrayList);
            return;
        }
        this.D = new SparseArray<>();
        this.H = false;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = -1;
        this.L = -1;
        this.M = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();
        this.F = qQAppInterface;
        this.G = baseActivity;
        this.I.clear();
        this.I.addAll(arrayList);
    }

    private boolean f() {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("101639", new byte[0]), StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("recommend_leak", false);
        } catch (JSONException e16) {
            QLog.e("Contacts.ContactsViewPagerAdapter", 1, "[getConfigValue] exception: " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        if (i3 != 1 && i3 != 2) {
            if (QLog.isColorLevel()) {
                QLog.d("Contacts.ContactsViewPagerAdapter", 2, "remove fragment cache :" + i3);
            }
            ContactsBaseFragment j3 = j(i3);
            if (j3 != null) {
                j3.doOnDestroy();
                this.D.delete(i3);
                this.J.remove(j3);
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        QLog.d("Contacts.ContactsViewPagerAdapter", 1, "doOnDestroy  mFragmentsCache.size() = " + this.D.size());
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            ContactsBaseFragment valueAt = this.D.valueAt(i3);
            if (valueAt != null) {
                valueAt.doOnDestroy();
            }
        }
        this.D.clear();
        this.J.clear();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.I.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, obj)).intValue();
        }
        if (this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition " + obj);
        }
        ContactsBaseFragment contactsBaseFragment = (ContactsBaseFragment) obj;
        if (contactsBaseFragment != null && (k3 = k(contactsBaseFragment.sh())) >= 0) {
            if (contactsBaseFragment.th() == k3) {
                if (this.M) {
                    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
                    return -1;
                }
                return -1;
            }
            if (this.M) {
                QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition newPos" + k3 + " oldPos:" + contactsBaseFragment.th());
            }
            contactsBaseFragment.Eh(k3);
            return k3;
        }
        if (this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
            return -2;
        }
        return -2;
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnPause:" + i3);
        }
        ContactsBaseFragment l3 = l(i3, false);
        if (l3 != null) {
            l3.qh(false);
        }
    }

    public void i(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnResume:" + i3 + " tabChange:" + z16);
        }
        ContactsBaseFragment l3 = l(i3, false);
        if (l3 != null) {
            l3.rh(false);
        }
    }

    protected ContactsBaseFragment j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ContactsBaseFragment) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.D.get(i3, null);
    }

    protected int k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        for (int i16 = 0; i16 < this.I.size(); i16++) {
            if (this.I.get(i16).f181554a == i3) {
                return i16;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsBaseFragment l(int i3, boolean z16) {
        ContactsBaseFragment contactsBaseFragment;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ContactsBaseFragment) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        f n3 = n(i3);
        if (n3 != null) {
            ContactsBaseFragment j3 = j(n3.f181554a);
            contactsBaseFragment = j3;
            contactsBaseFragment = j3;
            if (j3 == null && z16) {
                ContactsBaseFragment a16 = a.a(n3.f181554a);
                a16.Bh(this.G);
                a16.setApp(this.F);
                a16.Dh(this);
                a16.Fh(this.E);
                a16.Eh(i3);
                if (a16 instanceof g) {
                    this.J.add((g) a16);
                }
                this.D.put(n3.f181554a, a16);
                contactsBaseFragment = a16;
                if (this.M) {
                    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getFragment ..... create " + i3 + "  " + n3.f181554a);
                    contactsBaseFragment = a16;
                }
            }
        } else {
            contactsBaseFragment = null;
        }
        if (contactsBaseFragment == null && this.M) {
            QLog.e("Contacts.ContactsViewPagerAdapter", 1, "getFragment null pos:" + i3 + "  tab:" + n3);
        }
        if (contactsBaseFragment != null && this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getFragment ..... pos:" + i3 + "  id:" + contactsBaseFragment.sh() + "  isDetached: " + contactsBaseFragment.isDetached() + "  isAdd: " + contactsBaseFragment.isAdded() + " " + contactsBaseFragment);
        }
        if (contactsBaseFragment != null && (contactsBaseFragment instanceof g) && (i16 = this.L) > 0) {
            ((g) contactsBaseFragment).a(this.K, i16);
        }
        return contactsBaseFragment;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public BaseFragment getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseFragment) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItem:" + i3);
        }
        return l(i3, true);
    }

    protected f n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.I.size()) {
            return this.I.get(i3);
        }
        return null;
    }

    public void o(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.M) {
            QLog.i("Contacts.ContactsViewPagerAdapter", 2, "headViewScrollChanged currentY:" + i3 + "  maxY:" + i16);
        }
        for (int i17 = 0; i17 < this.J.size(); i17++) {
            this.J.get(i17).a(i3, i16);
        }
        this.K = i3;
        this.L = i16;
    }

    public void p() {
        ContactsBaseFragment j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        boolean f16 = f();
        int i3 = 0;
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onBeforeAccountChanged leakBugSwitchOn:", Boolean.valueOf(f16));
        if (f16) {
            while (i3 < this.D.size()) {
                ContactsBaseFragment j16 = j(this.D.keyAt(i3));
                if (j16 != null) {
                    j16.wh();
                }
                i3++;
            }
            return;
        }
        while (i3 < this.I.size()) {
            f n3 = n(i3);
            if (n3 != null && (j3 = j(n3.f181554a)) != null) {
                j3.wh();
            }
            i3++;
        }
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onFrameTabClick:" + i3);
        }
        ContactsBaseFragment l3 = l(i3, false);
        if (l3 != null) {
            l3.xh();
        }
    }

    public void r(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onPageSelected. curPos:" + i3 + " prePos:" + i16);
        }
        ContactsBaseFragment l3 = l(i3, false);
        if (l3 != null) {
            l3.yh(true);
        }
        ContactsBaseFragment l16 = l(i16, false);
        if (l16 != null) {
            l16.yh(false);
        }
    }

    public void s(boolean z16, int i3) {
        ContactsBaseFragment j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (this.M) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onThemeChange:" + z16);
        }
        for (int i16 = 0; i16 < this.I.size(); i16++) {
            f n3 = n(i16);
            if (n3 != null && (j3 = j(n3.f181554a)) != null) {
                j3.zh(z16, i3);
            }
        }
    }

    public void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "refresh:" + i3);
        }
        ContactsBaseFragment l3 = l(i3, false);
        if (l3 != null) {
            l3.refresh();
        }
    }

    public void u(QQAppInterface qQAppInterface) {
        ContactsBaseFragment j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (this.F != qQAppInterface) {
            this.F = qQAppInterface;
            boolean f16 = f();
            int i3 = 0;
            QLog.d("Contacts.ContactsViewPagerAdapter", 2, "resetData leakBugSwitchOn:", Boolean.valueOf(f16));
            if (f16) {
                while (i3 < this.D.size()) {
                    ContactsBaseFragment j16 = j(this.D.keyAt(i3));
                    if (j16 != null) {
                        j16.setApp(qQAppInterface);
                        j16.resetData();
                    }
                    i3++;
                }
                return;
            }
            while (i3 < this.I.size()) {
                f n3 = n(i3);
                if (n3 != null && (j3 = j(n3.f181554a)) != null) {
                    j3.setApp(qQAppInterface);
                    j3.resetData();
                }
                i3++;
            }
        }
    }

    public void v(ContactsBaseFragment.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
        } else {
            this.E = cVar;
        }
    }

    public void w(ArrayList<f> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) arrayList);
            return;
        }
        this.I.clear();
        this.I.addAll(arrayList);
        d();
        if (this.M) {
            QLog.i("Contacts.ContactsViewPagerAdapter", 2, "tabDatasUpdated. size:" + this.I.size());
        }
        notifyDataSetChanged();
    }
}
