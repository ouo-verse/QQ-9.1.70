package com.tencent.mobileqq.fragment.blacklist;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.blacklist.e;
import com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager;
import com.tencent.mobileqq.fragment.blacklist.userdb.UserDisplayManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BlackListViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;
    private MutableLiveData<UserDisplayManager.a> C;
    private MutableLiveData<ShieldUserDisplayManager.a> D;
    private MutableLiveData<Integer> E;
    private MutableLiveData<Integer> F;
    private d G;
    private Comparator<e.a> H;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<e> f211279i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<List<e.a>> f211280m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Comparator<e.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListViewModel.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e.a aVar, e.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar == null && aVar2 != null) {
                return -1;
            }
            if (aVar != null && aVar2 == null) {
                return 1;
            }
            int b16 = b(aVar, aVar2);
            if (b16 != 0) {
                return b16;
            }
            String str = aVar.f211318b;
            String str2 = aVar2.f211318b;
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null && str2 != null) {
                return -1;
            }
            if (str != null && str2 == null) {
                return 1;
            }
            int length = str.length();
            int length2 = str2.length();
            int min = Math.min(length, length2);
            for (int i3 = 0; i3 < min; i3++) {
                char charAt = str.charAt(i3);
                char charAt2 = str2.charAt(i3);
                if (charAt != charAt2) {
                    ChnToSpell.a g16 = ChnToSpell.g(charAt);
                    ChnToSpell.a g17 = ChnToSpell.g(charAt2);
                    int i16 = g16.f306904a;
                    int i17 = g17.f306904a;
                    if (i16 == i17) {
                        return g16.f306905b.compareTo(g17.f306905b);
                    }
                    return i16 - i17;
                }
            }
            if (length < length2) {
                return -1;
            }
            if (length <= length2) {
                return 0;
            }
            return 1;
        }

        public int b(e.a aVar, e.a aVar2) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            String str3 = aVar.f211320d;
            if (str3 == null || str3.length() == 0) {
                str = "#";
            } else {
                str = aVar.f211320d.substring(0, 1);
            }
            String str4 = aVar2.f211320d;
            if (str4 == null || str4.length() == 0) {
                str2 = "#";
            } else {
                str2 = aVar2.f211320d.substring(0, 1);
            }
            if (str2 == "#" && str != "#") {
                return 1;
            }
            if (str == "#" && str2 != "#") {
                return -1;
            }
            if (str == "#" && str2 == "#") {
                return 0;
            }
            char charAt = str.charAt(0);
            char charAt2 = str2.charAt(0);
            if (charAt > charAt2) {
                return 1;
            }
            if (charAt >= charAt2) {
                return 0;
            }
            return -1;
        }
    }

    public BlackListViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f211279i = new MutableLiveData<>();
        this.f211280m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>(-1);
        this.F = new MutableLiveData<>(-1);
        this.H = new a();
    }

    private void M1(e.a aVar, LinkedHashMap<String, List<e.a>> linkedHashMap) {
        String str;
        String str2 = aVar.f211320d;
        String str3 = "#";
        if (str2 == null || str2.length() == 0) {
            str = "#";
        } else {
            str = aVar.f211320d.substring(0, 1);
        }
        char charAt = str.charAt(0);
        if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
            str3 = str.toUpperCase();
        }
        if (linkedHashMap.get(str3) == null) {
            linkedHashMap.put(str3, new ArrayList());
        }
        linkedHashMap.get(str3).add(aVar);
    }

    private e N1(List<e.a> list, Comparator<e.a> comparator) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        e eVar = new e();
        LinkedHashMap<String, List<e.a>> linkedHashMap = new LinkedHashMap<>();
        Iterator<e.a> it = list.iterator();
        while (it.hasNext()) {
            M1(it.next(), linkedHashMap);
        }
        for (char c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
            if (linkedHashMap.get(String.valueOf(c16)) != null) {
                List<e.a> list2 = linkedHashMap.get(String.valueOf(c16));
                try {
                    Collections.sort(list2, comparator);
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(getTAG(), 2, "A Z sort error " + e16.toString());
                    }
                }
                eVar.f211316c.put(String.valueOf(c16), list2);
            }
        }
        if (linkedHashMap.get("#") != null) {
            List<e.a> list3 = linkedHashMap.get("#");
            try {
                Collections.sort(list3, comparator);
            } catch (IllegalArgumentException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(getTAG(), 2, "# sort error " + e17.toString() + ",list = " + list3);
                }
            }
            eVar.f211316c.put("#", list3);
        }
        linkedHashMap.clear();
        int[] iArr = new int[eVar.f211316c.keySet().size()];
        eVar.f211315b = iArr;
        eVar.f211314a = new String[iArr.length];
        Iterator<String> it5 = eVar.f211316c.keySet().iterator();
        int[] iArr2 = eVar.f211315b;
        if (iArr2.length == 0) {
            return null;
        }
        int i3 = 0;
        iArr2[0] = 0;
        int i16 = 1;
        while (true) {
            int[] iArr3 = eVar.f211315b;
            if (i16 >= iArr3.length) {
                break;
            }
            iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + eVar.f211316c.get(it5.next()).size() + 1;
            i16++;
        }
        Iterator<String> it6 = eVar.f211316c.keySet().iterator();
        while (it6.hasNext()) {
            eVar.f211314a[i3] = it6.next();
            i3++;
        }
        return eVar;
    }

    public void O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListViewModel.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlackListViewModel.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (BlackListViewModel.this.G != null) {
                        BlackListViewModel.this.G.b();
                    }
                }
            }, 160, null, false);
        }
    }

    public void P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListViewModel.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlackListViewModel.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (BlackListViewModel.this.G != null) {
                        BlackListViewModel.this.G.c();
                    }
                }
            }, 160, null, false);
        }
    }

    public void Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListViewModel.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlackListViewModel.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (BlackListViewModel.this.G != null) {
                        BlackListViewModel.this.G.e();
                    }
                }
            }, 160, null, false);
        }
    }

    public void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        d dVar = this.G;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListViewModel.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlackListViewModel.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (BlackListViewModel.this.G != null) {
                        BlackListViewModel.this.G.d();
                    }
                }
            }, 160, null, false);
        }
    }

    public MutableLiveData<e> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f211279i;
    }

    public MutableLiveData<Integer> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.F;
    }

    public MutableLiveData<List<e.a>> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f211280m;
    }

    public MutableLiveData<UserDisplayManager.a> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.C;
    }

    public MutableLiveData<ShieldUserDisplayManager.a> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.D;
    }

    public void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof AppInterface)) {
            this.G = new d((AppInterface) peekAppRuntime, this);
        }
    }

    public e b2(List<e.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (e) iPatchRedirector.redirect((short) 16, (Object) this, (Object) list);
        }
        return N1(list, this.H);
    }

    public void c2(List<e.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        } else {
            Collections.sort(list, this.H);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BlackListViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCleared();
        d dVar = this.G;
        if (dVar != null) {
            dVar.f();
        }
        this.G = null;
    }
}
