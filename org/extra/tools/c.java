package org.extra.tools;

import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class c extends ReportFragment {

    /* renamed from: a, reason: collision with root package name */
    private final Set f423599a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final Object f423600b = new Object();

    public void a(d dVar) {
        synchronized (this.f423600b) {
            this.f423599a.add(dVar);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this.f423600b) {
            for (d dVar : this.f423599a) {
                if (dVar != null) {
                    dVar.onResume();
                }
            }
        }
    }
}
