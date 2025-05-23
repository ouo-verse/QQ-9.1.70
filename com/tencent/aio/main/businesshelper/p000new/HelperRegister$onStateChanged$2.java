package com.tencent.aio.main.businesshelper.p000new;

import android.util.Log;
import androidx.collection.SparseArrayCompat;
import com.tencent.aio.main.businesshelper.g;
import com.tencent.aio.pref.a;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
final class HelperRegister$onStateChanged$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f69360d;
    final /* synthetic */ HelperRegister this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HelperRegister$onStateChanged$2(HelperRegister helperRegister, int i3) {
        this.this$0 = helperRegister;
        this.f69360d = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) helperRegister, i3);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArrayCompat sparseArrayCompat;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            sparseArrayCompat = this.this$0.mLifecycleObservers;
            final SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) sparseArrayCompat.get(this.f69360d);
            if (sparseArrayCompat2 != null) {
                Intrinsics.checkNotNullExpressionValue(sparseArrayCompat2, "mLifecycleObservers.get(state) ?: return@enqueue");
                int size = sparseArrayCompat2.size();
                for (final int i3 = 0; i3 < size; i3++) {
                    String str = "distributeHelperStateChange" + this.f69360d;
                    a aVar = a.f69788j;
                    if (!aVar.g()) {
                        HelperRegister.a(this.this$0).a().f(new Runnable(sparseArrayCompat2, i3) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$onStateChanged$2$$special$$inlined$trace$lambda$1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ SparseArrayCompat f69351d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ int f69352e;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f69351d = sparseArrayCompat2;
                                this.f69352e = i3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, HelperRegister$onStateChanged$2.this, sparseArrayCompat2, Integer.valueOf(i3));
                                }
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Object valueAt = this.f69351d.valueAt(this.f69352e);
                                Intrinsics.checkNotNullExpressionValue(valueAt, "observers.valueAt(i)");
                                g gVar = (g) valueAt;
                                String str2 = gVar + " moveTo" + HelperRegister$onStateChanged$2.this.f69360d;
                                a aVar2 = a.f69788j;
                                if (!aVar2.g()) {
                                    gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                    return;
                                }
                                aVar2.b(str2);
                                String str3 = "AIO#" + str2;
                                if (!aVar2.h()) {
                                    gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                    Unit unit2 = Unit.INSTANCE;
                                    Log.w("AIO#", str3 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                                }
                                aVar2.e();
                            }
                        });
                    } else {
                        aVar.b(str);
                        String str2 = "AIO#" + str;
                        if (!aVar.h()) {
                            HelperRegister.a(this.this$0).a().f(new Runnable(sparseArrayCompat2, i3) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$onStateChanged$2$$special$$inlined$trace$lambda$2
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ SparseArrayCompat f69353d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f69354e;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f69353d = sparseArrayCompat2;
                                    this.f69354e = i3;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, HelperRegister$onStateChanged$2.this, sparseArrayCompat2, Integer.valueOf(i3));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    Object valueAt = this.f69353d.valueAt(this.f69354e);
                                    Intrinsics.checkNotNullExpressionValue(valueAt, "observers.valueAt(i)");
                                    g gVar = (g) valueAt;
                                    String str3 = gVar + " moveTo" + HelperRegister$onStateChanged$2.this.f69360d;
                                    a aVar2 = a.f69788j;
                                    if (!aVar2.g()) {
                                        gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                        return;
                                    }
                                    aVar2.b(str3);
                                    String str4 = "AIO#" + str3;
                                    if (!aVar2.h()) {
                                        gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                        Unit unit2 = Unit.INSTANCE;
                                        Log.w("AIO#", str4 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                                    }
                                    aVar2.e();
                                }
                            });
                            Unit unit = Unit.INSTANCE;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            HelperRegister.a(this.this$0).a().f(new Runnable(sparseArrayCompat2, i3) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$onStateChanged$2$$special$$inlined$trace$lambda$3
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ SparseArrayCompat f69355d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f69356e;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f69355d = sparseArrayCompat2;
                                    this.f69356e = i3;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, HelperRegister$onStateChanged$2.this, sparseArrayCompat2, Integer.valueOf(i3));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    Object valueAt = this.f69355d.valueAt(this.f69356e);
                                    Intrinsics.checkNotNullExpressionValue(valueAt, "observers.valueAt(i)");
                                    g gVar = (g) valueAt;
                                    String str3 = gVar + " moveTo" + HelperRegister$onStateChanged$2.this.f69360d;
                                    a aVar2 = a.f69788j;
                                    if (!aVar2.g()) {
                                        gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                        return;
                                    }
                                    aVar2.b(str3);
                                    String str4 = "AIO#" + str3;
                                    if (!aVar2.h()) {
                                        gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                        Unit unit2 = Unit.INSTANCE;
                                    } else {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        gVar.onMoveToState(HelperRegister$onStateChanged$2.this.f69360d);
                                        Unit unit3 = Unit.INSTANCE;
                                        Log.w("AIO#", str4 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    aVar2.e();
                                }
                            });
                            Unit unit2 = Unit.INSTANCE;
                            Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        aVar.e();
                    }
                }
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
