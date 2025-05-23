package com.tencent.luggage.wxa.pl;

import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.q0;
import com.tencent.luggage.wxa.pl.i;
import com.tencent.luggage.wxa.xd.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f137662a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f137663b;

        public a(WeakReference weakReference, WeakReference weakReference2) {
            this.f137662a = weakReference;
            this.f137663b = weakReference2;
        }

        @Override // com.tencent.luggage.wxa.pl.i
        public void a(String str, i.a aVar) {
            KeyEvent.Callback callback = (EditText) this.f137662a.get();
            v vVar = (v) this.f137663b.get();
            if (callback != null && vVar != null) {
                int inputId = ((q0) callback).getInputId();
                b bVar = new b();
                HashMap hashMap = new HashMap();
                hashMap.put("id", str);
                hashMap.put("type", aVar.name().toLowerCase());
                hashMap.put("inputId", Integer.valueOf(inputId));
                bVar.setContext(vVar).setData(hashMap).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends p {
        private static final int CTRL_INDEX = 207;
        public static final String NAME = "onKeyboardDropdownOperate";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(v vVar, EditText editText, com.tencent.luggage.wxa.vl.a aVar) {
        g gVar;
        q0 q0Var = (q0) editText;
        if (!q0Var.d()) {
            return;
        }
        a aVar2 = new a(new WeakReference(editText), new WeakReference(vVar));
        com.tencent.luggage.wxa.pl.b autoFillController = q0Var.getAutoFillController();
        autoFillController.a(aVar.f143647d);
        autoFillController.a(aVar2);
        if ("screen".equalsIgnoreCase(aVar.f143646c)) {
            gVar = g.SCREEN;
        } else {
            gVar = g.VIEW;
        }
        autoFillController.a(gVar);
    }
}
