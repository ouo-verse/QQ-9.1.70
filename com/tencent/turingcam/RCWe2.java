package com.tencent.turingcam;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.n6fHX;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RCWe2 extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final FE6di f382016a;

    /* renamed from: b, reason: collision with root package name */
    public final List<di6n2> f382017b;

    public RCWe2(Looper looper, FE6di fE6di) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) fE6di);
        } else {
            this.f382017b = new ArrayList();
            this.f382016a = fE6di;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        for (di6n2 di6n2Var : this.f382017b) {
            di6n2Var.getClass();
            synchronized (di6n2.f382189i) {
                int i3 = di6n2.f382190j;
                if (i3 < 200) {
                    di6n2.f382190j = i3 + 1;
                    di6n2Var.f382192a = di6n2.f382191k;
                    di6n2.f382191k = di6n2Var;
                }
            }
        }
        this.f382017b.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        int i3 = message.what;
        FjMaF fjMaF = null;
        if (i3 != 1) {
            if (i3 == 2) {
                Object obj = message.obj;
                if (!(obj instanceof di6n2)) {
                    return;
                }
                di6n2 di6n2Var = (di6n2) obj;
                String str = di6n2Var.f382193b;
                if (!TextUtils.isEmpty(str)) {
                    if (!this.f382017b.isEmpty() && !this.f382017b.get(0).f382193b.equals(di6n2Var.f382193b)) {
                        a();
                    }
                    int i16 = di6n2Var.f382194c;
                    if (i16 != 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 == 3) {
                                    a();
                                    return;
                                }
                                return;
                            } else {
                                this.f382017b.isEmpty();
                                this.f382017b.add(di6n2Var);
                                return;
                            }
                        }
                        if (!this.f382017b.isEmpty()) {
                            this.f382017b.add(di6n2Var);
                            List<di6n2> list = this.f382017b;
                            ArrayList arrayList = new ArrayList();
                            if (list.size() <= 8) {
                                arrayList.addAll(list);
                            } else {
                                di6n2 di6n2Var2 = list.get(0);
                                di6n2 di6n2Var3 = list.get(list.size() - 1);
                                list.remove(di6n2Var2);
                                list.remove(di6n2Var3);
                                int ceil = (int) Math.ceil(list.size() / 6);
                                arrayList.add(di6n2Var2);
                                for (int i17 = 1; i17 < list.size(); i17 += ceil) {
                                    arrayList.add(list.get(i17));
                                }
                                arrayList.add(di6n2Var3);
                            }
                            if (!arrayList.isEmpty()) {
                                di6n2 di6n2Var4 = (di6n2) arrayList.get(0);
                                FjMaF fjMaF2 = new FjMaF();
                                long currentTimeMillis = System.currentTimeMillis();
                                long j3 = di6n2Var4.f382199h;
                                fjMaF2.f381826b = (int) (currentTimeMillis - j3);
                                fjMaF2.f381825a = j3;
                                ArrayList<TUmP8> arrayList2 = new ArrayList<>();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    di6n2 di6n2Var5 = (di6n2) it.next();
                                    TUmP8 tUmP8 = new TUmP8();
                                    int i18 = di6n2Var5.f382194c;
                                    if (i18 != 0) {
                                        if (i18 != 1) {
                                            if (i18 != 2) {
                                                if (i18 != 3) {
                                                    tUmP8.f382063a = 0;
                                                } else {
                                                    tUmP8.f382063a = 4;
                                                }
                                            } else {
                                                tUmP8.f382063a = 2;
                                            }
                                        } else {
                                            tUmP8.f382063a = 3;
                                        }
                                    } else {
                                        tUmP8.f382063a = 1;
                                    }
                                    tUmP8.f382066d = di6n2Var5.f382197f;
                                    tUmP8.f382067e = di6n2Var5.f382198g;
                                    arrayList2.add(tUmP8);
                                }
                                fjMaF2.f381827c = arrayList2;
                                fjMaF = fjMaF2;
                            }
                            if (fjMaF != null) {
                                if (di6n2Var.f382195d <= 0) {
                                    fjMaF.f381828d |= 1;
                                }
                                if (di6n2Var.f382196e == 0) {
                                    fjMaF.f381828d |= 2;
                                }
                                if (fjMaF.f381828d != 0) {
                                    ((n6fHX.spXPg) this.f382016a).a(new wUeOG(str, 2, fjMaF));
                                } else {
                                    ((n6fHX.spXPg) this.f382016a).a(new wUeOG(str, 1, fjMaF));
                                }
                                a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    a();
                    this.f382017b.add(di6n2Var);
                    return;
                }
                return;
            }
            return;
        }
        Object obj2 = message.obj;
        if (!(obj2 instanceof String)) {
            return;
        }
        ((n6fHX.spXPg) this.f382016a).a(new wUeOG((String) obj2, 3, null));
    }
}
