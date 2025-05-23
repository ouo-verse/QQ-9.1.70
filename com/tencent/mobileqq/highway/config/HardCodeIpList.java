package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HardCodeIpList {
    static IPatchRedirector $redirector_;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaMobile;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaTelecom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaUnicom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListOverseas;
    private CopyOnWriteArrayList<String> mHcIpCandicateListWifi;
    private ArrayList<Integer> mPort4HardCode;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class Candiate {
        static IPatchRedirector $redirector_;
        public int index;

        /* renamed from: ip, reason: collision with root package name */
        public String f236829ip;

        public Candiate(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HardCodeIpList.this, (Object) str);
            } else {
                this.f236829ip = str;
                this.index = HardCodeIpList.rand(100);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class CustomComparator implements Comparator<Candiate> {
        static IPatchRedirector $redirector_;

        public CustomComparator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HardCodeIpList.this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Candiate candiate, Candiate candiate2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) candiate, (Object) candiate2)).intValue();
            }
            int i3 = candiate.index;
            int i16 = candiate2.index;
            if (i3 < i16) {
                return -1;
            }
            return i3 == i16 ? 0 : 1;
        }
    }

    public HardCodeIpList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.mPort4HardCode = arrayList;
        arrayList.add(80);
        this.mPort4HardCode.add(8080);
        this.mPort4HardCode.add(Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("120.232.27.150");
        arrayList2.add("120.232.27.38");
        arrayList2.add("36.155.202.199");
        arrayList2.add("36.155.202.140");
        arrayList2.add("111.30.187.192");
        arrayList2.add("111.30.187.252");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("220.194.81.125");
        arrayList3.add("220.194.118.247");
        arrayList3.add("122.96.96.144");
        arrayList3.add("122.96.96.252");
        arrayList3.add("157.148.45.90");
        arrayList3.add("157.148.42.182");
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("14.22.9.55");
        arrayList4.add("183.2.143.16");
        arrayList4.add("117.62.242.202");
        arrayList4.add("180.102.111.81");
        arrayList4.add("42.81.184.140");
        arrayList4.add("42.81.193.228");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("129.226.107.115");
        arrayList5.add("129.226.107.191");
        if (this.mHcIpCandicateListWifi == null) {
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList8.add(new Candiate((String) it.next()));
            }
            Collections.sort(arrayList8, new CustomComparator());
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                arrayList7.add(new Candiate((String) it5.next()));
            }
            Collections.sort(arrayList7, new CustomComparator());
            Iterator it6 = arrayList4.iterator();
            while (it6.hasNext()) {
                arrayList6.add(new Candiate((String) it6.next()));
            }
            Collections.sort(arrayList6, new CustomComparator());
            Iterator it7 = arrayList5.iterator();
            while (it7.hasNext()) {
                arrayList9.add(new Candiate((String) it7.next()));
            }
            Collections.sort(arrayList9, new CustomComparator());
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.mHcIpCandicateListWifi = copyOnWriteArrayList;
            copyOnWriteArrayList.add(((Candiate) arrayList6.get(0)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList7.get(0)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList8.get(0)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList9.get(0)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList6.get(1)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList7.get(1)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList8.get(1)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList9.get(1)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList6.get(2)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList7.get(2)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList8.get(2)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList6.get(3)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList7.get(3)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList8.get(3)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList6.get(4)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList7.get(4)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList8.get(4)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList6.get(5)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList7.get(5)).f236829ip);
            this.mHcIpCandicateListWifi.add(((Candiate) arrayList8.get(5)).f236829ip);
        }
        if (this.mHcIpCandicateListChinaMobile == null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            this.mHcIpCandicateListChinaMobile = copyOnWriteArrayList2;
            copyOnWriteArrayList2.addAll(arrayList2);
        }
        if (this.mHcIpCandicateListChinaUnicom == null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
            this.mHcIpCandicateListChinaUnicom = copyOnWriteArrayList3;
            copyOnWriteArrayList3.addAll(arrayList3);
        }
        if (this.mHcIpCandicateListChinaTelecom == null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList4 = new CopyOnWriteArrayList<>();
            this.mHcIpCandicateListChinaTelecom = copyOnWriteArrayList4;
            copyOnWriteArrayList4.addAll(arrayList4);
        }
        if (this.mHcIpCandicateListOverseas == null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList5 = new CopyOnWriteArrayList<>();
            this.mHcIpCandicateListOverseas = copyOnWriteArrayList5;
            copyOnWriteArrayList5.addAll(arrayList5);
        }
    }

    public static boolean foundNRemoveIP(CopyOnWriteArrayList<String> copyOnWriteArrayList, String str) {
        boolean z16;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            return false;
        }
        copyOnWriteArrayList.remove(str);
        return true;
    }

    private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            return new EndPoint(copyOnWriteArrayList.get(0), this.mPort4HardCode.get(rand(r0.size() - 1)).intValue());
        }
        return null;
    }

    public static int rand(int i3) {
        return (int) (Math.random() * (i3 + 1));
    }

    public boolean foundNRemove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (foundNRemoveIP(this.mHcIpCandicateListWifi, str) || foundNRemoveIP(this.mHcIpCandicateListChinaMobile, str) || foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, str) || foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, str)) {
            return true;
        }
        return false;
    }

    public EndPoint getNextIp(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EndPoint) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        if (HwNetworkUtil.isWifiEnabled(context)) {
            return getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
        }
        int carrierOperatorType = HwNetworkUtil.getCarrierOperatorType(context);
        if (carrierOperatorType != 2) {
            if (carrierOperatorType != 3) {
                if (carrierOperatorType != 4) {
                    return getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
                }
                return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
            }
            return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
        }
        return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
    }

    public EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> copyOnWriteArrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EndPoint) iPatchRedirector.redirect((short) 3, (Object) this, (Object) copyOnWriteArrayList);
        }
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            return new EndPoint(copyOnWriteArrayList.get(rand(copyOnWriteArrayList.size() - 1)), this.mPort4HardCode.get(rand(r0.size() - 1)).intValue());
        }
        return null;
    }

    public boolean isEmpty(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        if (HwNetworkUtil.isWifiEnabled(context)) {
            return this.mHcIpCandicateListWifi.isEmpty();
        }
        int carrierOperatorType = HwNetworkUtil.getCarrierOperatorType(context);
        if (carrierOperatorType != 2) {
            if (carrierOperatorType != 3) {
                if (carrierOperatorType != 4) {
                    return this.mHcIpCandicateListOverseas.isEmpty();
                }
                return this.mHcIpCandicateListChinaTelecom.isEmpty();
            }
            return this.mHcIpCandicateListChinaUnicom.isEmpty();
        }
        return this.mHcIpCandicateListChinaMobile.isEmpty();
    }
}
