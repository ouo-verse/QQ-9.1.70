package com.tencent.mobileqq.app.message.messageclean;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheDeleteInfo;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ak extends com.tencent.mobileqq.mvvm.c<aj> {
    static IPatchRedirector $redirector_;
    public static ViewModelProvider.Factory J;
    private final MutableLiveData<Boolean> C;
    private final MutableLiveData<Pair<Long, Integer>> D;
    private final MutableLiveData<Boolean> E;
    private final MutableLiveData<Boolean> F;
    private final MutableLiveData<e> G;
    private final MutableLiveData<Boolean> H;
    private NTScanSpaceManager.i I;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Boolean> f196129i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f196130m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            return new ak(new aj());
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements aa {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f196131a;

        b(ArrayList arrayList) {
            this.f196131a = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ak.this, (Object) arrayList);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.aa
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ak.this.g2(z16, this.f196131a);
                ak.this.h2();
                ak.this.i2();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements ac {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ak.this);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ac
        public void onLoadFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                ak.this.E.postValue(Boolean.FALSE);
                ak.this.h2();
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ac
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ak.this.E.postValue(Boolean.TRUE);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements NTScanSpaceManager.i {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ak.this);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.i
        public void onUpdate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("MsgCleanViewModel", 1, "data reload success, update ui");
            ak.this.F.postValue(Boolean.FALSE);
            ak.this.h2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f196135a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f196136b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f196137c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f196138d;

        public e(boolean z16, boolean z17, boolean z18, boolean z19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ak.this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
                return;
            }
            this.f196138d = z16;
            this.f196135a = z17;
            this.f196136b = z18;
            this.f196137c = z19;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "DeleteResultInfo{isDeleteGuild=" + this.f196135a + ", isDeleteC2c=" + this.f196136b + ", isDeleteGroup=" + this.f196137c + ", isSuccess=" + this.f196138d + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            J = new a();
        }
    }

    public ak(aj ajVar) {
        super(ajVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ajVar);
            return;
        }
        this.f196129i = new MutableLiveData<>();
        this.f196130m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        this.I = new d();
    }

    private void c2() {
        if (((aj) this.mRepository).r()) {
            this.F.postValue(Boolean.TRUE);
            ((aj) this.mRepository).j(this.I);
        } else {
            QLog.d("MsgCleanViewModel", 1, "data exist, just update ui");
            this.F.postValue(Boolean.FALSE);
            h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2(boolean z16, ArrayList<ChatCacheDeleteInfo> arrayList) {
        Iterator<ChatCacheDeleteInfo> it = arrayList.iterator();
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (it.hasNext()) {
            int chatType = it.next().getChatType();
            if (chatType != 1) {
                if (chatType != 2 && chatType != 3) {
                    if (chatType != 4) {
                        QLog.e("MsgCleanViewModel", 1, "processDeleteItemType chaType invalid");
                    } else {
                        z17 = true;
                    }
                } else {
                    z19 = true;
                }
            } else {
                z18 = true;
            }
        }
        this.G.postValue(new e(z16, z17, z18, z19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2() {
        if (((aj) this.mRepository).o().size() == 0) {
            this.H.postValue(Boolean.TRUE);
        } else {
            this.H.postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2() {
        Iterator<g> it = ((aj) this.mRepository).o().iterator();
        long j3 = 0;
        boolean z16 = false;
        int i3 = 0;
        boolean z17 = true;
        while (it.hasNext()) {
            g next = it.next();
            if (next.f196216a == 10003) {
                ArrayList<g> arrayList = ((aj) this.mRepository).m().get(Long.valueOf(((w) next).f196253g));
                if (arrayList != null) {
                    Iterator<g> it5 = arrayList.iterator();
                    boolean z18 = true;
                    while (it5.hasNext()) {
                        g next2 = it5.next();
                        if (next2.f196216a != 10002) {
                            if (next2.f196220e) {
                                i3++;
                                j3 += next2.f196221f;
                                z16 = true;
                            } else {
                                z17 = false;
                                z18 = false;
                            }
                        }
                    }
                    next.f196220e = z18;
                }
            } else if (next.f196220e) {
                i3++;
                j3 += next.f196221f;
                z16 = true;
            } else {
                z17 = false;
            }
        }
        this.f196130m.postValue(Boolean.valueOf(z17));
        this.C.postValue(Boolean.valueOf(z16));
        this.D.postValue(new Pair<>(Long.valueOf(j3), Integer.valueOf(i3)));
        this.f196129i.postValue(Boolean.TRUE);
    }

    private void l2(v vVar, ArrayList<g> arrayList) {
        Pair<g, ArrayList<Long>> pair = ((aj) this.mRepository).l().get(Long.valueOf(vVar.f196252k));
        if (pair == null) {
            return;
        }
        if (!vVar.f196220e) {
            QLog.d("MsgCleanViewModel", 1, "updateCategoryStatus currentItem is Not Check category name : " + pair.first.f196218c);
            pair.first.f196220e = false;
            return;
        }
        Iterator<Long> it = pair.second.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            Iterator<g> it5 = arrayList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    g next = it5.next();
                    if (next.f196216a != 10002) {
                        v vVar2 = (v) next;
                        if (vVar2.f196250i == longValue && !vVar2.f196220e) {
                            z16 = false;
                            break;
                        }
                    }
                }
            }
        }
        QLog.d("MsgCleanViewModel", 1, "updateCategoryStatus category name : " + pair.first.f196218c + " isCheck: " + z16);
        pair.first.f196220e = z16;
    }

    private void m2(g gVar) {
        gVar.f196220e = !gVar.f196220e;
    }

    private void n2(g gVar, boolean z16) {
        ArrayList<g> arrayList;
        int i3 = gVar.f196216a;
        gVar.f196220e = z16;
        if (i3 != 10003 || (arrayList = ((aj) this.mRepository).m().get(Long.valueOf(((w) gVar).f196253g))) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f196220e = z16;
        }
    }

    private void o2(g gVar) {
        v vVar = (v) gVar;
        ArrayList<g> arrayList = ((aj) this.mRepository).m().get(Long.valueOf(vVar.f196251j));
        if (arrayList == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.f196216a != 10002) {
                v vVar2 = (v) next;
                if (vVar2.f196250i == vVar.f196250i) {
                    vVar2.f196220e = !vVar2.f196220e;
                    l2(vVar2, arrayList);
                    return;
                }
            }
        }
    }

    private void p2(g gVar) {
        w wVar;
        w wVar2 = (w) gVar;
        Iterator<g> it = ((aj) this.mRepository).o().iterator();
        while (true) {
            if (it.hasNext()) {
                g next = it.next();
                if (next.f196216a == 10003) {
                    wVar = (w) next;
                    if (wVar.f196253g == wVar2.f196253g) {
                        break;
                    }
                }
            } else {
                wVar = null;
                break;
            }
        }
        if (wVar == null) {
            return;
        }
        wVar.f196220e = !wVar.f196220e;
        ArrayList<g> arrayList = ((aj) this.mRepository).m().get(Long.valueOf(wVar.f196253g));
        if (arrayList == null) {
            return;
        }
        Iterator<g> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            it5.next().f196220e = wVar.f196220e;
        }
    }

    public void Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ArrayList<ChatCacheDeleteInfo> p16 = ((aj) this.mRepository).p();
        if (p16.size() == 0) {
            return;
        }
        this.F.postValue(Boolean.TRUE);
        ((aj) this.mRepository).k(p16, new b(p16));
    }

    public MutableLiveData<Boolean> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f196129i;
    }

    public MutableLiveData<Pair<Long, Integer>> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.D;
    }

    public MutableLiveData<e> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.G;
    }

    public long U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return ((aj) this.mRepository).n();
    }

    public MutableLiveData<Boolean> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f196130m;
    }

    public MutableLiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.C;
    }

    public MutableLiveData<Boolean> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.H;
    }

    public MutableLiveData<Boolean> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.E;
    }

    public MutableLiveData<Boolean> b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.F;
    }

    public void d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (((aj) this.mRepository).s()) {
            c2();
        } else {
            ((aj) this.mRepository).v(new c());
        }
    }

    public void e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ((aj) this.mRepository).t();
        }
    }

    public void f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ((aj) this.mRepository).w(this.I);
        Iterator<g> it = ((aj) this.mRepository).o().iterator();
        while (it.hasNext()) {
            n2(it.next(), false);
        }
        ((aj) this.mRepository).u();
    }

    public void j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<g> it = ((aj) this.mRepository).o().iterator();
        while (it.hasNext()) {
            n2(it.next(), true);
        }
        i2();
    }

    public void k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Iterator<g> it = ((aj) this.mRepository).o().iterator();
        while (it.hasNext()) {
            n2(it.next(), false);
        }
        i2();
    }

    public void q2(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) gVar);
            return;
        }
        int i3 = gVar.f196216a;
        if (i3 == 10002) {
            QLog.e("MsgCleanViewModel", 1, "itemType == CLEAN_GUILD_CATEGORY_TYPE ignore");
            return;
        }
        if (i3 != 10001) {
            if (i3 != 10003) {
                if (i3 != 10004) {
                    QLog.e("MsgCleanViewModel", 1, "updateSelectItem itemType invalid");
                } else {
                    m2(gVar);
                }
            } else {
                p2(gVar);
            }
        } else {
            o2(gVar);
        }
        i2();
    }
}
