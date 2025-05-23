package com.tencent.aio.helper;

import android.util.Log;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/main/businesshelper/e;", "T", "", TencentLocation.RUN_MODE, "()V", "com/tencent/aio/helper/CoreHelperFetcher$handleCreateHelper$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class CoreHelperFetcher$handleCreateHelper$$inlined$forEach$lambda$3 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Map.Entry f69332d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function2 f69333e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f69334f;
    final /* synthetic */ CoreHelperFetcher this$0;

    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.aio.base.mvvm.recycler.b f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            f16 = this.this$0.f();
            e a16 = f16.a((String) this.f69332d.getKey());
            Intrinsics.reifiedOperationMarker(3, "T");
            if (a16 instanceof e) {
                this.this$0.i(a16);
            } else {
                String str = ((String) this.f69332d.getKey()) + "Helper#new";
                com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
                if (!aVar.g()) {
                    a16 = (e) this.f69333e.invoke(this.f69332d.getKey(), (e) ((Function0) this.f69332d.getValue()).invoke());
                } else {
                    aVar.b(str);
                    String str2 = "AIO#" + str;
                    if (!aVar.h()) {
                        a16 = (e) this.f69333e.invoke(this.f69332d.getKey(), (e) ((Function0) this.f69332d.getValue()).invoke());
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        e eVar = (e) this.f69333e.invoke(this.f69332d.getKey(), (e) ((Function0) this.f69332d.getValue()).invoke());
                        Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                        a16 = eVar;
                    }
                    aVar.e();
                }
            }
            if (a16 != null) {
                this.f69334f.invoke(a16);
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
