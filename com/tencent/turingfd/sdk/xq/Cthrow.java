package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Gooseberry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.throw, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cthrow extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final k f383440a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Apple> f383441b;

    public Cthrow(Looper looper, k kVar) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) kVar);
        } else {
            this.f383441b = new ArrayList();
            this.f383440a = kVar;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        for (Apple apple : this.f383441b) {
            apple.getClass();
            synchronized (Apple.f382547i) {
                int i3 = Apple.f382548j;
                if (i3 < 200) {
                    Apple.f382548j = i3 + 1;
                    apple.f382550a = Apple.f382549k;
                    Apple.f382549k = apple;
                }
            }
        }
        this.f383441b.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        int i3 = message.what;
        Segment segment = null;
        if (i3 != 1) {
            if (i3 == 2) {
                Object obj = message.obj;
                if (!(obj instanceof Apple)) {
                    return;
                }
                Apple apple = (Apple) obj;
                String str = apple.f382551b;
                if (!TextUtils.isEmpty(str)) {
                    if (!this.f383441b.isEmpty() && !this.f383441b.get(0).f382551b.equals(apple.f382551b)) {
                        a();
                    }
                    int i16 = apple.f382552c;
                    if (i16 != 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 == 3) {
                                    a();
                                    return;
                                }
                                return;
                            } else {
                                this.f383441b.isEmpty();
                                this.f383441b.add(apple);
                                return;
                            }
                        }
                        if (!this.f383441b.isEmpty()) {
                            this.f383441b.add(apple);
                            List<Apple> list = this.f383441b;
                            ArrayList arrayList = new ArrayList();
                            if (list.size() <= 8) {
                                arrayList.addAll(list);
                            } else {
                                Apple apple2 = list.get(0);
                                Apple apple3 = list.get(list.size() - 1);
                                list.remove(apple2);
                                list.remove(apple3);
                                int ceil = (int) Math.ceil(list.size() / 6);
                                arrayList.add(apple2);
                                for (int i17 = 1; i17 < list.size(); i17 += ceil) {
                                    arrayList.add(list.get(i17));
                                }
                                arrayList.add(apple3);
                            }
                            if (!arrayList.isEmpty()) {
                                Apple apple4 = (Apple) arrayList.get(0);
                                Segment segment2 = new Segment();
                                long currentTimeMillis = System.currentTimeMillis();
                                long j3 = apple4.f382557h;
                                segment2.f383064b = (int) (currentTimeMillis - j3);
                                segment2.f383063a = j3;
                                ArrayList<Shaddock> arrayList2 = new ArrayList<>();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    Apple apple5 = (Apple) it.next();
                                    Shaddock shaddock = new Shaddock();
                                    int i18 = apple5.f382552c;
                                    if (i18 != 0) {
                                        if (i18 != 1) {
                                            if (i18 != 2) {
                                                if (i18 != 3) {
                                                    shaddock.f383069a = 0;
                                                } else {
                                                    shaddock.f383069a = 4;
                                                }
                                            } else {
                                                shaddock.f383069a = 2;
                                            }
                                        } else {
                                            shaddock.f383069a = 3;
                                        }
                                    } else {
                                        shaddock.f383069a = 1;
                                    }
                                    shaddock.f383072d = apple5.f382555f;
                                    shaddock.f383073e = apple5.f382556g;
                                    arrayList2.add(shaddock);
                                }
                                segment2.f383065c = arrayList2;
                                segment = segment2;
                            }
                            if (segment != null) {
                                if (apple.f382553d <= 0) {
                                    segment.f383066d |= 1;
                                }
                                if (apple.f382554e == 0) {
                                    segment.f383066d |= 2;
                                }
                                if (segment.f383066d != 0) {
                                    ((Gooseberry.Cdo) this.f383440a).a(new Cwhile(str, 2, segment));
                                } else {
                                    ((Gooseberry.Cdo) this.f383440a).a(new Cwhile(str, 1, segment));
                                }
                                a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    a();
                    this.f383441b.add(apple);
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
        ((Gooseberry.Cdo) this.f383440a).a(new Cwhile((String) obj2, 3, null));
    }
}
