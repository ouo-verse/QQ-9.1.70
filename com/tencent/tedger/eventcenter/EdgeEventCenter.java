package com.tencent.tedger.eventcenter;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedgecontext.a;
import com.tencent.tedgecontext.b;
import com.tencent.tedger.outapi.api.f;
import com.tencent.tedger.outapi.api.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import ve4.i;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeEventCenter extends b implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<g>>> f375158a;

    public EdgeEventCenter(a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375158a = new ConcurrentHashMap<>();
        }
    }

    private void I(String str, g gVar) {
        ConcurrentHashMap<Integer, WeakReference<g>> concurrentHashMap = this.f375158a.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        concurrentHashMap.put(Integer.valueOf(gVar.hashCode()), new WeakReference<>(gVar));
        this.f375158a.put(str, concurrentHashMap);
    }

    private void J(String str, g gVar) {
        ConcurrentHashMap<Integer, WeakReference<g>> concurrentHashMap = this.f375158a.get(str);
        if (concurrentHashMap == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(gVar.hashCode()));
        if (concurrentHashMap.size() == 0) {
            this.f375158a.remove(str);
        }
        Log.d("EdgeEventCenter", "unRegisterReceiver event Name:" + str + ",key\uff1a[" + gVar.getClass().getSimpleName() + ":" + gVar.hashCode() + "], subscribers size:" + concurrentHashMap.size());
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void F(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
        } else if (gVar != null && gVar.getEventClass() != null) {
            Iterator it = gVar.getEventClass().iterator();
            while (it.hasNext()) {
                J(((Class) it.next()).getName(), gVar);
            }
        }
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void k(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
            return;
        }
        if (getRouter().a()) {
            return;
        }
        if (fVar == null) {
            Log.e("EdgeEventCenter", "dispatchEvent event is null!");
        } else if (getRouter().f375305c == null) {
            Log.e("EdgeEventCenter", "dispatchEvent mResourceManager is null!");
        } else {
            getRouter().f375305c.l(new Runnable(fVar) { // from class: com.tencent.tedger.eventcenter.EdgeEventCenter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ f f375159d;

                {
                    this.f375159d = fVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EdgeEventCenter.this, (Object) fVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) EdgeEventCenter.this.f375158a.get(this.f375159d.getClass().getName());
                        if (concurrentHashMap == null) {
                            Log.e("EdgeEventCenter", "dispatchEvent subscribers is null!");
                            return;
                        }
                        for (WeakReference weakReference : concurrentHashMap.values()) {
                            if (weakReference != null && weakReference.get() != null) {
                                if (this.f375159d.getEventType() != 0) {
                                    if (((g) weakReference.get()).getActionType().contains(Integer.valueOf(this.f375159d.getEventType()))) {
                                        ((g) weakReference.get()).v(this.f375159d);
                                    } else {
                                        ArrayList<Integer> actionType = ((g) weakReference.get()).getActionType();
                                        if (actionType.size() > 0 && actionType.get(0).intValue() == -1) {
                                            ((g) weakReference.get()).v(this.f375159d);
                                        }
                                    }
                                } else {
                                    ((g) weakReference.get()).v(this.f375159d);
                                }
                            } else {
                                Log.e("EdgeEventCenter", "dispatchEvent subscriber is null!");
                            }
                        }
                    } catch (Exception e16) {
                        EdgeEventCenter.this.getRouter().f375318p.e("EdgeEventCenter", -888, e16 + "");
                    }
                }
            });
        }
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f375158a.clear();
        }
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void q(g gVar) {
        ArrayList eventClass;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else if (gVar != null && (eventClass = gVar.getEventClass()) != null) {
            Iterator it = eventClass.iterator();
            while (it.hasNext()) {
                I(((Class) it.next()).getName(), gVar);
            }
        }
    }
}
