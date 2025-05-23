package com.tencent.qmethod.base;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.dextransform.InjectAction;
import com.tencent.mobileqq.dextransform.b;
import com.tencent.mobileqq.dextransform.d;
import com.tencent.mobileqq.dextransform.e;
import com.tencent.mobileqq.dextransform.h;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TransformTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public Context f343441d;

    /* renamed from: e, reason: collision with root package name */
    public String f343442e;

    /* renamed from: f, reason: collision with root package name */
    private a f343443f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(String str, File file);

        void onError(Exception exc);

        void onStart();
    }

    public TransformTask(Context context, String str, a aVar) {
        this.f343441d = context;
        this.f343442e = str;
        this.f343443f = aVar;
    }

    private static b e() {
        b bVar = new b();
        ArrayList<xr3.b> arrayList = xr3.a.f448436b;
        int size = arrayList.size();
        o.a("TransformTask", "getConfigs STUB_STRATEGIES size:" + size);
        bVar.f203539b = new d[]{new d(InjectAction.GET_STATIC_FIELD_REPLACE, "Landroid/os/Build;", "MODEL", "Ljava/lang/String;", "Lcom/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor;", "getModel", "()Ljava/lang/String;")};
        bVar.f203538a = new e[size];
        Iterator<xr3.b> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            xr3.b next = it.next();
            InjectAction injectAction = InjectAction.METHOD_REPLACE;
            if (!next.f448442f.equals("getString") && !next.f448442f.equals("getLong") && !next.f448442f.equals("open") && !next.f448442f.equals("getNetworkInterfaces") && !next.f448442f.equals("getSerialByMethod")) {
                int i16 = next.f448440d;
                if (i16 == 4) {
                    injectAction = InjectAction.STATIC_METHOD_ENTER;
                } else if (i16 == 5) {
                    injectAction = InjectAction.METHOD_EXIT;
                }
            } else {
                injectAction = InjectAction.STATIC_METHOD_REPLACE;
            }
            bVar.f203538a[i3] = new e(injectAction, "L" + zr3.a.a(next.f448437a) + ";", zr3.a.a(next.f448438b), next.f448439c, "L" + zr3.a.a(next.f448441e) + ";", zr3.a.a(next.f448442f), next.f448443g);
            i3++;
        }
        for (e eVar : bVar.f203538a) {
            if (!eVar.c()) {
                o.a("TransformTask", "method is not validate, action: " + eVar.f203532a + " srcClassName:" + eVar.f203546h + " srcMethod:" + eVar.f203547i + " srcMethodDesc:" + eVar.f203548j + " destClass:" + eVar.f203533b + " destMethod:" + eVar.f203534c + " destMethodDesc:" + eVar.f203535d);
            }
        }
        return bVar;
    }

    private void f() {
        List f16;
        File file = new File(this.f343442e);
        File file2 = new File(this.f343441d.getDir("dex_transformed", 0), file.getName());
        this.f343443f.onStart();
        long uptimeMillis = SystemClock.uptimeMillis();
        b e16 = e();
        try {
            o.a("TransformTask", file.getName() + " dex transform start");
            Context context = this.f343441d;
            String str = "status." + this.f343442e;
            Boolean bool = Boolean.TRUE;
            r.m(context, str, bool);
            h.d(new File(this.f343442e), e16, file2);
            o.a("TransformTask", file.getName() + " dex transform end");
            r.m(this.f343441d, this.f343442e, bool);
            r.o(this.f343441d, "length." + this.f343442e, Long.valueOf(file.length()));
            r.o(this.f343441d, "lastModified." + this.f343442e, Long.valueOf(file.lastModified()));
            if (r.c(this.f343441d, "key_transform_list").booleanValue() && (f16 = r.f(this.f343441d, "key_transform_list", String.class)) != null && f16.contains(this.f343442e)) {
                f16.remove(this.f343442e);
                r.q(this.f343441d, "key_transform_list", f16);
            }
            List arrayList = new ArrayList();
            if (r.c(this.f343441d, "key_transformed_list").booleanValue()) {
                arrayList = r.f(this.f343441d, "key_transformed_list", String.class);
            }
            if (!arrayList.contains(this.f343442e)) {
                arrayList.add(this.f343442e);
                r.q(this.f343441d, "key_transformed_list", arrayList);
            }
            o.a("TransformTask", "Dex path:" + file.getAbsolutePath());
            o.a("TransformTask", "Dex length:" + file.length() + " lastModified:" + file.lastModified());
            Context context2 = this.f343441d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("status.");
            sb5.append(this.f343442e);
            r.k(context2, sb5.toString());
        } catch (Exception e17) {
            o.d("TransformTask", "transform error", e17);
            this.f343443f.onError(e17);
        }
        o.a("TransformTask", "transform dex cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
        this.f343443f.a(this.f343442e, file2);
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof TransformTask) || (str = this.f343442e) == null) {
            return false;
        }
        return str.equals(((TransformTask) obj).f343442e);
    }

    @Override // java.lang.Runnable
    public void run() {
        f();
    }
}
