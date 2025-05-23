package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.util.w;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lo2.am;
import sa1.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n {

    /* renamed from: d, reason: collision with root package name */
    public static final String f283769d = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";

    /* renamed from: e, reason: collision with root package name */
    private static volatile n f283770e;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, b> f283771a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, i> f283772b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f283773c = true;

    n() {
    }

    private f b(int i3) {
        b bVar;
        synchronized (this.f283771a) {
            bVar = this.f283771a.get(Integer.valueOf(i3));
        }
        if (bVar != null) {
            return new d(bVar);
        }
        return null;
    }

    private f c(int i3) {
        f d16 = d(i3);
        if (d16 == null) {
            return b(i3);
        }
        return d16;
    }

    private f d(int i3) {
        if (i3 == 101) {
            return new k();
        }
        return null;
    }

    private void e() {
        f();
    }

    private void f() {
        ArrayList arrayList;
        sa1.b k3 = w.k();
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RichNodeFactory", 2, "initConfig , config is null");
                return;
            }
            return;
        }
        this.f283773c = k3.d();
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.f283773c);
        }
        ArrayList arrayList2 = null;
        if (!this.f283773c) {
            j(null, null);
            return;
        }
        ArrayList<b.a> b16 = k3.b("ark");
        ArrayList<b.a> b17 = k3.b("native");
        if (b16 != null && b16.size() > 0) {
            arrayList = new ArrayList();
            Iterator<b.a> it = b16.iterator();
            while (it.hasNext()) {
                b.a next = it.next();
                arrayList.add(new b(next.f433567a, next.f433569c, next.f433570d, next.f433571e, "", null, next.f433572f));
            }
        } else {
            arrayList = null;
        }
        if (b17 != null && b17.size() > 0) {
            arrayList2 = new ArrayList();
            Iterator<b.a> it5 = b17.iterator();
            while (it5.hasNext()) {
                arrayList2.add(new i(it5.next().f433567a));
            }
        }
        j(arrayList2, arrayList);
    }

    public static n g() {
        if (f283770e == null) {
            synchronized (n.class) {
                if (f283770e == null) {
                    f283770e = new n();
                    f283770e.e();
                }
            }
        }
        return f283770e;
    }

    private void j(List<i> list, List<b> list2) {
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.d("RichNodeFactory", 2, "updateConfig\uff0c nativesize :" + list.size());
            }
            synchronized (this.f283772b) {
                this.f283772b.clear();
                for (i iVar : list) {
                    this.f283772b.put(Integer.valueOf(iVar.a()), iVar);
                }
            }
        } else {
            synchronized (this.f283772b) {
                this.f283772b.clear();
            }
            if (QLog.isColorLevel()) {
                QLog.d("RichNodeFactory", 2, "updateConfig\uff0c nativesize = 0");
            }
        }
        if (list2 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("RichNodeFactory", 2, "updateConfig\uff0c arksize:" + list2.size());
            }
            synchronized (this.f283771a) {
                this.f283771a.clear();
                for (b bVar : list2) {
                    this.f283771a.put(Integer.valueOf(bVar.e()), bVar);
                }
            }
            return;
        }
        synchronized (this.f283771a) {
            this.f283771a.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeFactory", 2, "updateConfig\uff0c arksize = 0");
        }
    }

    public f a(QQAppInterface qQAppInterface, Context context, v vVar) {
        if (vVar == null || !(vVar instanceof am)) {
            return null;
        }
        am amVar = (am) vVar;
        int a06 = amVar.a0();
        f c16 = c(a06);
        if (c16 != null) {
            String Z = amVar.Z();
            String X = amVar.X();
            String Y = amVar.Y();
            c16.c(qQAppInterface, context, a06, Z, Y, X);
            if (QLog.isColorLevel()) {
                QLog.d("RichNodeFactory", 2, "create, data:" + Z + " config:" + X + " extradata:" + Y);
            }
        }
        return c16;
    }

    public boolean h(int i3) {
        b bVar;
        if (QLog.isColorLevel()) {
            QLog.d("RichNodeFactory", 2, "nodeExist\uff0c id:" + i3);
        }
        if (!this.f283773c) {
            if (QLog.isColorLevel()) {
                QLog.d("RichNodeFactory", 2, "nodeExist\uff0c switch off");
            }
            return false;
        }
        synchronized (this.f283772b) {
            if (this.f283772b.get(Integer.valueOf(i3)) != null) {
                return true;
            }
            synchronized (this.f283771a) {
                bVar = this.f283771a.get(Integer.valueOf(i3));
            }
            if (bVar == null) {
                return false;
            }
            return true;
        }
    }

    public void i() {
        f();
    }
}
