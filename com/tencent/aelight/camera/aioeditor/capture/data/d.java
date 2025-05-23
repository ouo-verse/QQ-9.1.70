package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.gcore.abase.utils.PatternUtils;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends QIMAsyncManager implements Handler.Callback, IEventReceiver {
    public static int P = 4;
    public h J;
    public j K;
    int M;
    private boolean N;

    /* renamed from: i, reason: collision with root package name */
    public Handler f66719i;

    /* renamed from: m, reason: collision with root package name */
    private g f66720m;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, h> f66716e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, j> f66717f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public HashMap<String, com.tencent.aelight.camera.aioeditor.capture.data.c> f66718h = new HashMap<>();
    public Handler C = new Handler(Looper.getMainLooper(), new b());
    public ArrayList<QIMFilterCategoryItem> D = new ArrayList<>();
    public ArrayList<QIMFilterCategoryItem> E = new ArrayList<>();
    public Handler F = new Handler(Looper.getMainLooper(), this);
    public HashMap<String, ArrayList<e>> G = new HashMap<>();
    ArrayList<c> H = new ArrayList<>();
    public m.a I = null;
    public C0577d[] L = new C0577d[5];

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                d.this.f66719i.removeMessages(1);
                if (d.this.K()) {
                    d.this.f66719i.sendEmptyMessageDelayed(1, 50L);
                }
                if (message.arg2 == 7) {
                    Message.obtain(d.this.F, 7, message.arg1, 0, (CaptureSet) message.obj).sendToTarget();
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 2) {
                return false;
            }
            Object obj = message.obj;
            if (!(obj instanceof CaptureSet)) {
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void d(j jVar, boolean z16, int i3, Bundle bundle);

        void e(m.a aVar);

        void f(h hVar);

        void j(h hVar, boolean z16, int i3, Bundle bundle);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.data.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0577d {

        /* renamed from: a, reason: collision with root package name */
        public h f66723a;

        /* renamed from: b, reason: collision with root package name */
        public long f66724b;

        /* renamed from: c, reason: collision with root package name */
        public j f66725c;

        /* renamed from: d, reason: collision with root package name */
        public long f66726d;

        /* renamed from: e, reason: collision with root package name */
        com.tencent.aelight.camera.aioeditor.capture.music.a f66727e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<com.tencent.aelight.camera.aioeditor.capture.data.a> f66728f;

        /* renamed from: g, reason: collision with root package name */
        int f66729g;

        public C0577d(int i3) {
            this.f66729g = i3;
        }

        public boolean a() {
            return this.f66725c == null || this.f66726d <= this.f66724b;
        }

        public void c() {
            m.n().V(null, null, this.f66729g);
            m.n().L(null, this.f66729g);
            this.f66725c = null;
        }

        public void e(Activity activity) {
            h hVar = this.f66723a;
            if (hVar != null && hVar.f66706e == 3) {
                hVar.o(activity, this.f66729g);
                this.f66723a.g(activity, this.f66729g);
            }
            j jVar = this.f66725c;
            if (jVar != null) {
                jVar.o(activity, this.f66729g);
                this.f66725c.g(activity, this.f66729g);
            }
        }

        public void f(Activity activity, boolean z16) {
            m.n().O(this.f66729g);
            m.n().U(null, activity, this.f66729g);
            h[] hVarArr = m.n().f66502i;
            int i3 = this.f66729g;
            h hVar = hVarArr[i3];
            if (hVar != null) {
                hVar.q(activity, i3);
            }
            m.n().M(null, activity, this.f66729g);
            if (z16 && this.f66729g == 3) {
                QLog.d("CaptureComboManager", 1, "\u6ee4\u955c\u7981\u6b62\u6e05\u7a7a");
            } else {
                m.n().V(null, activity, this.f66729g);
            }
        }

        public void g(h hVar) {
            this.f66723a = hVar;
            this.f66724b = System.currentTimeMillis();
        }

        public void h(j jVar) {
            this.f66725c = jVar;
            this.f66726d = System.currentTimeMillis();
        }

        public void b(Activity activity) {
            f(activity, false);
            this.f66723a = null;
            this.f66725c = null;
            this.f66727e = null;
            this.f66728f = null;
        }

        public void d(Activity activity) {
            f(activity, true);
            this.f66723a = null;
            this.f66725c = null;
            this.f66727e = null;
            this.f66728f = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public CaptureSet f66730a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f66731b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<Activity> f66732c;

        public e(CaptureSet captureSet, Bundle bundle, Activity activity) {
            this.f66730a = captureSet;
            this.f66731b = bundle;
            this.f66732c = new WeakReference<>(activity);
        }
    }

    public d() {
        this.f66719i = null;
        int i3 = 0;
        while (true) {
            C0577d[] c0577dArr = this.L;
            if (i3 < c0577dArr.length) {
                c0577dArr[i3] = new C0577d(i3);
                i3++;
            } else {
                this.M = 0;
                this.N = false;
                this.f66719i = new Handler(ThreadManagerV2.getSubThreadLooper(), new a());
                this.f66720m = new g();
                return;
            }
        }
    }

    public void B(h hVar) {
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().f(hVar);
        }
    }

    public void C(CaptureSet captureSet) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "notifyDownloadBegin combo " + captureSet);
        }
        synchronized (this.E) {
            this.E.add((QIMFilterCategoryItem) captureSet.f66709i);
        }
        this.f66719i.sendEmptyMessage(1);
    }

    public boolean D(List<FilterCategory> list) {
        com.tencent.aelight.camera.aioeditor.capture.data.a s16;
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "preInitCombo: " + list.size());
        }
        boolean z16 = false;
        for (FilterCategory filterCategory : list) {
            for (QIMFilterCategoryItem qIMFilterCategoryItem : filterCategory.f66687f) {
                if (filterCategory.f66688h) {
                    s16 = r(qIMFilterCategoryItem);
                } else {
                    s16 = s(qIMFilterCategoryItem);
                }
                int j3 = s16.j();
                s16.f66706e = j3;
                if (j3 == 1) {
                    s16.f66707f = (int) (s16.i() * 10000.0f);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QCombo", 2, "preInitCombo progress: " + qIMFilterCategoryItem.f66698e + ", progress: " + s16.f66707f);
                    }
                    z16 = true;
                } else if (j3 != 2 && j3 == 3) {
                    s16.f66707f = 10000;
                }
            }
        }
        return z16;
    }

    public void E() {
        m.a aVar = this.I;
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "randomliseData " + aVar);
        }
        if (aVar != null) {
            aVar.k();
            L(aVar);
        }
    }

    public void F(QIMFilterCategoryItem qIMFilterCategoryItem) {
        String str;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
        if (!qIMFilterCategoryItem.j() && !qIMFilterCategoryItem.l()) {
            str = "";
        } else {
            str = qIMFilterCategoryItem.f66697d;
        }
        sharedPreferences.edit().putString("select", str != null ? str : "").apply();
    }

    public void G(c cVar) {
        synchronized (this.H) {
            this.H.remove(cVar);
        }
    }

    public boolean H(Message message) {
        int i3;
        QIMFilterCategoryItem t16;
        int i16 = message.what;
        if (i16 == 7) {
            int i17 = message.arg1;
            if (QLog.isDevelopLevel()) {
                QLog.d("QCombo", 2, "MSG_APPLY error " + i17 + " " + message.obj);
            }
            Object obj = message.obj;
            if (obj instanceof j) {
                j jVar = (j) obj;
                if (i17 == 0) {
                    com.tencent.aelight.camera.aioeditor.capture.view.c.c(jVar).i();
                } else {
                    com.tencent.aelight.camera.aioeditor.capture.view.c.c(jVar).h();
                }
                ArrayList<e> arrayList = this.G.get(jVar.t());
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    arrayList.clear();
                    QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) jVar.f66709i;
                    if (i17 == 0) {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            e eVar = (e) it.next();
                            int i18 = eVar.f66731b.getInt("capture_scene", -1);
                            QIMFilterCategoryItem u16 = m.n().u(i18);
                            if (qIMFilterCategoryItem != null && u16 != null && TextUtils.equals(qIMFilterCategoryItem.f66697d, u16.f66697d) && !this.N) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("QCombo", 2, "MSG_APPLY filter " + i18 + " " + u16);
                                }
                                ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).n(u16.f66697d);
                                Activity activity = eVar.f66732c.get();
                                if (activity != null) {
                                    jVar.g(activity, i18);
                                    synchronized (this.H) {
                                        Iterator<c> it5 = this.H.iterator();
                                        while (it5.hasNext()) {
                                            it5.next().d(jVar, true, 0, eVar.f66731b);
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        this.K = jVar;
                    } else {
                        Iterator it6 = arrayList2.iterator();
                        while (it6.hasNext()) {
                            e eVar2 = (e) it6.next();
                            int i19 = eVar2.f66731b.getInt("capture_scene", -1);
                            QIMFilterCategoryItem u17 = m.n().u(i19);
                            if (qIMFilterCategoryItem != null && u17 != null && TextUtils.equals(qIMFilterCategoryItem.f66697d, u17.f66697d)) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("QCombo", 2, "MSG_APPLY filter " + i19 + " " + u17);
                                }
                                ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).n(u17.f66697d);
                                if (eVar2.f66732c.get() != null) {
                                    synchronized (this.H) {
                                        Iterator<c> it7 = this.H.iterator();
                                        while (it7.hasNext()) {
                                            it7.next().d(jVar, false, i17, eVar2.f66731b);
                                        }
                                    }
                                }
                                QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.k7q), 0).show();
                            }
                        }
                    }
                }
            } else if (obj instanceof h) {
                h hVar = (h) obj;
                if (i17 == 0) {
                    com.tencent.aelight.camera.aioeditor.capture.view.c.c(hVar).i();
                } else {
                    com.tencent.aelight.camera.aioeditor.capture.view.c.c(hVar).h();
                }
                QIMFilterCategoryItem qIMFilterCategoryItem2 = (QIMFilterCategoryItem) hVar.f66709i;
                ArrayList<e> arrayList3 = this.G.get(hVar.t());
                if (arrayList3 != null) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    if (i17 == 0) {
                        Iterator it8 = arrayList4.iterator();
                        while (it8.hasNext()) {
                            e eVar3 = (e) it8.next();
                            Activity activity2 = eVar3.f66732c.get();
                            if (activity2 != null && (t16 = m.n().t((i3 = eVar3.f66731b.getInt("capture_scene", -1)))) != null && TextUtils.equals(t16.f66697d, qIMFilterCategoryItem2.f66697d)) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("QCombo", 2, "MSG_APPLY success " + i3 + " " + qIMFilterCategoryItem2);
                                }
                                ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).m(qIMFilterCategoryItem2.f66697d);
                                if (!com.tencent.aelight.camera.aioeditor.capture.data.c.w(hVar, i3)) {
                                    hVar.g(activity2, i3);
                                }
                                synchronized (this.H) {
                                    Iterator<c> it9 = this.H.iterator();
                                    while (it9.hasNext()) {
                                        it9.next().j(hVar, true, 0, eVar3.f66731b);
                                    }
                                }
                            }
                        }
                        this.J = hVar;
                    } else {
                        Iterator it10 = arrayList4.iterator();
                        while (it10.hasNext()) {
                            e eVar4 = (e) it10.next();
                            int i26 = eVar4.f66731b.getInt("capture_scene", -1);
                            QIMFilterCategoryItem t17 = m.n().t(i26);
                            if (t17 != null && TextUtils.equals(t17.f66697d, qIMFilterCategoryItem2.f66697d)) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("QCombo", 2, "MSG_APPLY fail " + i26 + " " + qIMFilterCategoryItem2);
                                }
                                ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).m(qIMFilterCategoryItem2.f66697d);
                                Activity activity3 = eVar4.f66732c.get();
                                if (activity3 != null) {
                                    synchronized (this.H) {
                                        Iterator<c> it11 = this.H.iterator();
                                        while (it11.hasNext()) {
                                            it11.next().j(hVar, false, i17, eVar4.f66731b);
                                        }
                                    }
                                    d dVar = (d) fr.f.c(5);
                                    h hVar2 = dVar.J;
                                    if (hVar2 != null) {
                                        dVar.l((QIMFilterCategoryItem) hVar2.f66709i, activity3, eVar4.f66731b);
                                    }
                                }
                                QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.k7s), 0).show();
                            }
                        }
                    }
                }
            }
        } else if (i16 == 9) {
            m.a aVar = (m.a) message.obj;
            synchronized (this) {
                Iterator<c> it12 = this.H.iterator();
                while (it12.hasNext()) {
                    it12.next().e(aVar);
                }
            }
        }
        return false;
    }

    public void I(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("CaptureComboManager", 2, "yes to do setBeRecording" + z16);
        }
        this.N = z16;
    }

    public void J(int i3, Activity activity) {
        h r16;
        QIMFilterCategoryItem t16 = m.n().t(i3);
        if (t16 == null || (r16 = r(t16)) == null || r16.f66706e != 1) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("capture_scene", i3);
        h hVar = m.n().f66502i[i3];
        if (hVar != null) {
            l((QIMFilterCategoryItem) hVar.f66709i, activity, bundle);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "stopApplyDownload scene " + i3);
        }
    }

    public boolean K() {
        synchronized (this.E) {
            this.D.addAll(this.E);
            this.E.clear();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "syncStateAndProgress " + this.D.size());
        }
        boolean z16 = false;
        for (int size = this.D.size() - 1; size >= 0; size--) {
            QIMFilterCategoryItem qIMFilterCategoryItem = this.D.get(size);
            h r16 = r(qIMFilterCategoryItem);
            int i3 = r16.f66706e;
            if (i3 == 1) {
                int j3 = r16.j();
                if (j3 != r16.f66706e) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QCombo", 2, "buildComboBatch progress: " + qIMFilterCategoryItem.f66698e + ", progress: " + r16.f66707f);
                    }
                    r16.f66706e = j3;
                }
                int i16 = (int) (r16.i() * 10000.0f);
                if (i16 != r16.f66707f) {
                    r16.f66707f = i16;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("QCombo", 2, "buildComboBatch progress: " + i16 + ", progress: " + r16.f66707f);
                    }
                }
            } else if (i3 == 2) {
                r16.j();
                QIMFilterCategoryItem remove = this.D.remove(size);
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "removeComboBatch: " + remove.f66698e + ",  STATE_NEED_DOWNLOAD progress: " + r16.f66707f);
                }
            } else if (i3 == 3) {
                r16.j();
                r16.f66707f = 10000;
                QIMFilterCategoryItem remove2 = this.D.remove(size);
                com.tencent.aelight.camera.aioeditor.capture.view.c.c(r16).i();
                Message.obtain(this.C, 2, r16).sendToTarget();
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "removeComboBatch: " + remove2.f66698e + ", STATE_DOWNLOADED progress: " + r16.f66707f);
                }
            }
            z16 = true;
        }
        return z16;
    }

    public void L(m.a aVar) {
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateData data is null?");
            sb5.append(aVar == null);
            QLog.d("QCombo", 2, sb5.toString());
        }
        if (aVar != null) {
            this.I = aVar;
            this.f66720m.g(aVar);
            Message.obtain(this.F, 9, aVar).sendToTarget();
        }
        n(1);
    }

    @Override // fr.e
    public void d() {
        this.f66720m.d();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return H(message);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager
    public void i() {
        m.n().x(BaseApplication.getContext(), null, false);
        if (QLog.isDevelopLevel()) {
            QLog.d("CaptureComboManager", 4, "initComboConfig");
        }
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return false;
    }

    public void j(e eVar) {
        synchronized (this.G) {
            String t16 = eVar.f66730a.t();
            ArrayList<e> arrayList = this.G.get(t16);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.G.put(t16, arrayList);
            }
            arrayList.add(eVar);
        }
    }

    public void k(c cVar) {
        synchronized (this.H) {
            if (!this.H.contains(cVar)) {
                this.H.add(cVar);
            }
        }
    }

    public void m(QIMFilterCategoryItem qIMFilterCategoryItem, Activity activity, Bundle bundle) {
        int i3 = bundle.getInt("capture_scene", -1);
        QIMFilterCategoryItem u16 = m.n().u(i3);
        boolean z16 = u16 != null && TextUtils.equals(u16.f66697d, qIMFilterCategoryItem.f66697d);
        boolean z17 = u16 == null && A(qIMFilterCategoryItem);
        boolean z18 = bundle.getBoolean("capture_force_enable", false);
        if ((z16 || z17) && !z18) {
            if (QLog.isColorLevel()) {
                QLog.d("CaptureComboManager", 2, "applyFilters repeat, sameItem: ", Boolean.valueOf(z16), " emptyItem:", Boolean.valueOf(z17), " filterItem:", qIMFilterCategoryItem.f66698e, " isForceEnable:", Boolean.valueOf(z18));
                return;
            }
            return;
        }
        j s16 = ((d) fr.f.c(5)).s(qIMFilterCategoryItem);
        s16.o(activity, i3);
        s16.f66684m = new WeakReference<>(activity);
        int i16 = s16.f66706e;
        if (i16 == 1) {
            j(new e(s16, bundle, activity));
        } else if (i16 == 2) {
            j(new e(s16, bundle, activity));
            com.tencent.aelight.camera.aioeditor.capture.view.c.c(s16).g();
            s16.h();
        } else if (i16 == 3) {
            j(new e(s16, bundle, activity));
            Message obtain = Message.obtain(this.F, 7, 0, 0, s16);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                H(obtain);
            } else {
                obtain.sendToTarget();
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "applyFilters state = " + s16.f66706e);
        }
    }

    public void n(int i3) {
        int i16 = this.M;
        if ((i16 & 3) == 3) {
            return;
        }
        int i17 = i3 | i16;
        this.M = i17;
        if ((i17 & 3) == 3) {
            if (QLog.isColorLevel()) {
                QLog.i("CaptureComboManager", 2, "first random");
            }
            E();
        }
    }

    public void o(Activity activity) {
        for (C0577d c0577d : this.L) {
            c0577d.b(activity);
        }
    }

    public void p(Activity activity) {
        for (C0577d c0577d : this.L) {
            c0577d.d(activity);
        }
    }

    public com.tencent.aelight.camera.aioeditor.capture.data.c q(FilterDesc filterDesc) {
        com.tencent.aelight.camera.aioeditor.capture.data.c cVar = this.f66718h.get(filterDesc.name);
        if (cVar != null) {
            return cVar;
        }
        com.tencent.aelight.camera.aioeditor.capture.data.c cVar2 = new com.tencent.aelight.camera.aioeditor.capture.data.c(filterDesc);
        this.f66718h.put(filterDesc.name, cVar2);
        return cVar2;
    }

    public j s(QIMFilterCategoryItem qIMFilterCategoryItem) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = qIMFilterCategoryItem.F.iterator();
        while (it.hasNext()) {
            FilterDesc m3 = m.n().m(it.next());
            if (m3 != null) {
                arrayList.add(m3);
            }
        }
        j jVar = this.f66717f.get(qIMFilterCategoryItem.f66697d);
        if (jVar == null) {
            jVar = new j(qIMFilterCategoryItem);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                jVar.r(q((FilterDesc) it5.next()));
            }
            this.f66717f.put(qIMFilterCategoryItem.f66697d, jVar);
        }
        return jVar;
    }

    public void t(CaptureSet captureSet, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "downloadComboFailed captureset " + captureSet);
        }
        if (captureSet.f66709i instanceof QIMFilterCategoryItem) {
            synchronized (this.E) {
                this.E.add((QIMFilterCategoryItem) captureSet.f66709i);
            }
            Message.obtain(this.F, 1, i3, 7, captureSet).sendToTarget();
        }
    }

    public void u(CaptureSet captureSet) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "downloadComboSuccess captureSet " + captureSet);
        }
        if (captureSet.f66709i instanceof QIMFilterCategoryItem) {
            synchronized (this.E) {
                this.E.add((QIMFilterCategoryItem) captureSet.f66709i);
            }
            Message.obtain(this.f66719i, 1, 0, 7, captureSet).sendToTarget();
        }
    }

    public h v(String str) {
        m.a aVar = this.I;
        h hVar = null;
        if (aVar != null) {
            Iterator<FilterCategory> it = aVar.f66509d.f66515a.iterator();
            while (it.hasNext()) {
                Iterator<QIMFilterCategoryItem> it5 = it.next().f66687f.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        QIMFilterCategoryItem next = it5.next();
                        if (TextUtils.equals(next.f66697d, str)) {
                            hVar = r(next);
                            break;
                        }
                    }
                }
            }
        }
        return hVar;
    }

    public boolean w() {
        return this.N;
    }

    public m.b x() {
        if (this.I == null) {
            return null;
        }
        if (AEDashboardUtil.q()) {
            return this.I.f66510e;
        }
        return this.I.f66509d;
    }

    public g z() {
        return this.f66720m;
    }

    public h l(QIMFilterCategoryItem qIMFilterCategoryItem, Activity activity, Bundle bundle) {
        d dVar = (d) fr.f.c(5);
        h r16 = dVar.r(qIMFilterCategoryItem);
        r16.o(activity, bundle.getInt("capture_scene", -1));
        r16.f66684m = new WeakReference<>(activity);
        dVar.F(qIMFilterCategoryItem);
        int i3 = r16.f66706e;
        if (i3 == 1) {
            j(new e(r16, bundle, activity));
        } else if (i3 == 2) {
            j(new e(r16, bundle, activity));
            r16.h();
        } else if (i3 == 3) {
            j(new e(r16, bundle, activity));
            Message obtain = Message.obtain(this.F, 7, 0, 0, r16);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                H(obtain);
            } else {
                obtain.sendToTarget();
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "applyCombo state = " + r16.f66706e);
        }
        return r16;
    }

    private static boolean A(QIMFilterCategoryItem qIMFilterCategoryItem) {
        ArrayList<String> arrayList;
        if (qIMFilterCategoryItem == null || (arrayList = qIMFilterCategoryItem.F) == null) {
            return false;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (PatternUtils.NO_MATCH.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public QIMFilterCategoryItem y(h hVar, ArrayList<QIMFilterCategoryItem> arrayList) {
        QIMFilterCategoryItem qIMFilterCategoryItem;
        FilterDesc filterDesc = null;
        if (hVar == null) {
            return null;
        }
        Object obj = hVar.f66709i;
        if (!(obj instanceof QIMFilterCategoryItem)) {
            return null;
        }
        QIMFilterCategoryItem qIMFilterCategoryItem2 = (QIMFilterCategoryItem) obj;
        if (qIMFilterCategoryItem2.F.isEmpty()) {
            qIMFilterCategoryItem = null;
        } else {
            Iterator<QIMFilterCategoryItem> it = arrayList.iterator();
            qIMFilterCategoryItem = null;
            while (it.hasNext()) {
                QIMFilterCategoryItem next = it.next();
                if (next.F.size() == qIMFilterCategoryItem2.F.size()) {
                    Iterator<String> it5 = qIMFilterCategoryItem2.F.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            if (next.F.contains(it5.next())) {
                                qIMFilterCategoryItem = next;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (qIMFilterCategoryItem == null) {
            Iterator<String> it6 = qIMFilterCategoryItem2.F.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                FilterDesc m3 = m.n().m(it6.next());
                if (m3 != null) {
                    if (QQAVImageFilterConstants.getFilterType(m3.f281357id) == 2) {
                        filterDesc = m3;
                        break;
                    }
                    filterDesc = m3;
                }
            }
            if (filterDesc != null) {
                Iterator<QIMFilterCategoryItem> it7 = arrayList.iterator();
                while (it7.hasNext()) {
                    QIMFilterCategoryItem next2 = it7.next();
                    if (next2.F.size() == 1 && next2.F.contains(filterDesc.name)) {
                        return next2;
                    }
                }
            }
        }
        return qIMFilterCategoryItem;
    }

    public h r(QIMFilterCategoryItem qIMFilterCategoryItem) {
        boolean z16;
        String str;
        int i3;
        String optString;
        JSONArray optJSONArray;
        StringBuilder sb5;
        h hVar = this.f66716e.get(qIMFilterCategoryItem.f66697d);
        if (hVar == null) {
            h hVar2 = new h(qIMFilterCategoryItem);
            Iterator<String> it = qIMFilterCategoryItem.F.iterator();
            while (it.hasNext()) {
                String next = it.next();
                FilterDesc m3 = m.n().m(next);
                if (m3 != null) {
                    hVar2.r(q(m3));
                } else if (QLog.isDevelopLevel()) {
                    QLog.d("QCombo", 2, "createCombo filter Null " + next);
                }
            }
            JSONArray jSONArray = qIMFilterCategoryItem.G;
            String str2 = "scale";
            if (jSONArray != null) {
                int length = jSONArray.length();
                z16 = false;
                for (int i16 = 0; i16 < length; i16++) {
                    JSONObject optJSONObject = qIMFilterCategoryItem.G.optJSONObject(i16);
                    if (optJSONObject != null) {
                        try {
                            String optString2 = optJSONObject.optString("packet_id");
                            String optString3 = optJSONObject.optString("item_id");
                            float floatValue = Float.valueOf(optJSONObject.optString(LocalPhotoFaceInfo.POSITION_X)).floatValue();
                            float floatValue2 = Float.valueOf(optJSONObject.optString(LocalPhotoFaceInfo.POSITION_Y)).floatValue();
                            float floatValue3 = Float.valueOf(optJSONObject.optString("scale")).floatValue();
                            SegmentKeeper segmentKeeper = new SegmentKeeper();
                            segmentKeeper.fromJSONObject(optJSONObject);
                            com.tencent.aelight.camera.aioeditor.capture.data.a b16 = com.tencent.aelight.camera.aioeditor.capture.paster.b.b(qIMFilterCategoryItem.f66697d, optString2, optString3, floatValue, floatValue2, floatValue3);
                            if (b16 != null) {
                                b16.p(segmentKeeper);
                                hVar2.r(b16);
                            } else {
                                try {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("QCombo", 2, "createCombo pasters Null item_id= " + optString3);
                                    }
                                    z16 = true;
                                } catch (Exception e16) {
                                    e = e16;
                                    z16 = true;
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                        }
                    }
                }
            } else {
                z16 = false;
            }
            JSONArray jSONArray2 = qIMFilterCategoryItem.H;
            if (jSONArray2 != null) {
                int length2 = jSONArray2.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    JSONObject optJSONObject2 = qIMFilterCategoryItem.H.optJSONObject(i17);
                    if (optJSONObject2 != null) {
                        try {
                            String optString4 = optJSONObject2.optString("tagId");
                            String optString5 = optJSONObject2.optString("itemId");
                            com.tencent.aelight.camera.aioeditor.capture.data.a a16 = com.tencent.aelight.camera.aioeditor.capture.paster.b.a(optString5);
                            if (a16 != null) {
                                hVar2.r(a16);
                            } else {
                                try {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("QCombo", 2, "createCombo musicNull " + optString4 + ":" + optString5);
                                    }
                                    z16 = true;
                                } catch (Exception e18) {
                                    e = e18;
                                    z16 = true;
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e19) {
                            e = e19;
                        }
                    }
                }
            }
            JSONArray jSONArray3 = qIMFilterCategoryItem.I;
            if (jSONArray3 != null) {
                int length3 = jSONArray3.length();
                for (int i18 = 0; i18 < length3; i18++) {
                    JSONObject optJSONObject3 = qIMFilterCategoryItem.I.optJSONObject(i18);
                    if (optJSONObject3 != null) {
                        try {
                            String optString6 = optJSONObject3.optString("tagId");
                            String optString7 = optJSONObject3.optString("itemId");
                            if (!StringUtil.isEmpty(optString6)) {
                                com.tencent.aelight.camera.aioeditor.capture.data.a c16 = com.tencent.aelight.camera.aioeditor.capture.paster.b.c(optString7);
                                if (c16 != null) {
                                    hVar2.r(c16);
                                } else {
                                    try {
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("QCombo", 2, "createCombo ptvNull " + optString6 + ":" + optString7);
                                        }
                                        z16 = true;
                                    } catch (Exception e26) {
                                        e = e26;
                                        z16 = true;
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } catch (Exception e27) {
                            e = e27;
                        }
                    }
                }
            }
            if (qIMFilterCategoryItem.J != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QCombo", 2, "createCombo texts " + qIMFilterCategoryItem.J + " size: " + qIMFilterCategoryItem.J.length());
                }
                int i19 = 0;
                for (int length4 = qIMFilterCategoryItem.J.length(); i19 < length4; length4 = i3) {
                    JSONObject optJSONObject4 = qIMFilterCategoryItem.J.optJSONObject(i19);
                    if (optJSONObject4 != null) {
                        try {
                            optString = optJSONObject4.optString("text_id");
                            optJSONArray = optJSONObject4.optJSONArray("texts");
                        } catch (Exception e28) {
                            e = e28;
                            str = str2;
                        }
                        if (optJSONArray != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i26 = 0; i26 < optJSONArray.length(); i26++) {
                                String string = optJSONArray.getString(i26);
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            }
                            float floatValue4 = Float.valueOf(optJSONObject4.optString(LocalPhotoFaceInfo.POSITION_X)).floatValue();
                            float floatValue5 = Float.valueOf(optJSONObject4.optString(LocalPhotoFaceInfo.POSITION_Y)).floatValue();
                            float floatValue6 = Float.valueOf(optJSONObject4.optString(str2)).floatValue();
                            if (QLog.isDevelopLevel()) {
                                str = str2;
                                try {
                                    sb5 = new StringBuilder();
                                    i3 = length4;
                                } catch (Exception e29) {
                                    e = e29;
                                    i3 = length4;
                                    e.printStackTrace();
                                    i19++;
                                    str2 = str;
                                }
                                try {
                                    sb5.append("create  TextCombo ID: ");
                                    sb5.append(optString);
                                    try {
                                        QLog.d("QCombo", 2, sb5.toString());
                                    } catch (Exception e36) {
                                        e = e36;
                                        e.printStackTrace();
                                        i19++;
                                        str2 = str;
                                    }
                                } catch (Exception e37) {
                                    e = e37;
                                    e.printStackTrace();
                                    i19++;
                                    str2 = str;
                                }
                            } else {
                                str = str2;
                                i3 = length4;
                            }
                            SegmentKeeper segmentKeeper2 = new SegmentKeeper();
                            segmentKeeper2.fromJSONObject(optJSONObject4);
                            com.tencent.aelight.camera.aioeditor.capture.data.a d16 = com.tencent.aelight.camera.aioeditor.capture.paster.b.d(optString, arrayList, floatValue4, floatValue5, floatValue6);
                            if (d16 != null) {
                                d16.p(segmentKeeper2);
                                hVar2.r(d16);
                                i19++;
                                str2 = str;
                            } else {
                                try {
                                    if (QLog.isDevelopLevel()) {
                                        try {
                                            QLog.d("QCombo", 2, "createCombo texts Null id=" + optString);
                                        } catch (Exception e38) {
                                            e = e38;
                                            z16 = true;
                                            e.printStackTrace();
                                            i19++;
                                            str2 = str;
                                        }
                                    }
                                    z16 = true;
                                } catch (Exception e39) {
                                    e = e39;
                                }
                                i19++;
                                str2 = str;
                            }
                        }
                    }
                    str = str2;
                    i3 = length4;
                    i19++;
                    str2 = str;
                }
            }
            if (!z16) {
                this.f66716e.put(qIMFilterCategoryItem.f66697d, hVar2);
            }
            hVar = hVar2;
        }
        hVar.f66709i = qIMFilterCategoryItem;
        return hVar;
    }
}
