package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.tabs.d;
import com.tencent.mobileqq.activity.contacts.base.tabs.f;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.findTroop.AddContactViewPagerTroopFragmentV2;
import com.tencent.mobileqq.troop.findTroop.util.a;
import com.tencent.mobileqq.troop.findTroop.util.c;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends d {
    static IPatchRedirector $redirector_;
    ArrayList<RecommendTroopItem> D;
    private ArrayList<f> E;
    QQAppInterface F;
    c G;

    public a(FragmentManager fragmentManager, QQAppInterface qQAppInterface, ArrayList<f> arrayList) {
        super(fragmentManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fragmentManager, qQAppInterface, arrayList);
            return;
        }
        this.D = new ArrayList<>();
        this.G = null;
        this.F = qQAppInterface;
        this.E = arrayList;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.d, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, viewGroup, Integer.valueOf(i3), obj);
            return;
        }
        super.destroyItem(viewGroup, i3, obj);
        if (obj instanceof com.tencent.mobileqq.troop.findTroop.util.b) {
            this.G.e((com.tencent.mobileqq.troop.findTroop.util.b) obj);
        }
    }

    public void g(ArrayList<RecommendTroopItem> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        } else {
            this.D.addAll(arrayList);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.E.size();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.d
    public Fragment getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Fragment) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        f fVar = this.E.get(i3);
        AddContactViewPagerTroopFragmentV2 addContactViewPagerTroopFragmentV2 = new AddContactViewPagerTroopFragmentV2();
        Bundle bundle = new Bundle();
        bundle.putString("tabKeyword", fVar.f181556c);
        bundle.putBoolean("isFromFindTroop", true);
        addContactViewPagerTroopFragmentV2.setArguments(bundle);
        this.G.a(addContactViewPagerTroopFragmentV2);
        if (i3 == 0 && this.D.size() > 0) {
            this.G.c(addContactViewPagerTroopFragmentV2.af(), new a.C8696a(this.D));
            this.D.clear();
        }
        return addContactViewPagerTroopFragmentV2;
    }

    public void h(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.G = cVar;
        }
    }

    public void i(ArrayList<f> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else {
            this.E = arrayList;
            notifyDataSetChanged();
        }
    }
}
