package com.tencent.mobileqq.guild.media.core.viewpool;

import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vs1.b;
import vs1.c;
import vs1.e;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/guild/media/core/viewpool/ViewPoolEngine$runInThread$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ViewPoolEngine$tryFillViewPool$$inlined$runInThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f228754d;

    @Override // java.lang.Runnable
    public final void run() {
        Looper myLooper = Looper.myLooper();
        ViewPoolEngine.f228744a.o(Looper.getMainLooper());
        try {
            try {
                for (e eVar : this.f228754d) {
                    ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
                    b bVar = c.INSTANCE.a().get(eVar);
                    Intrinsics.checkNotNull(bVar);
                    viewPoolEngine.h(eVar, bVar);
                }
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str = "runInThread error:" + e16.getMessage();
                if (str instanceof String) {
                    bVar2.a().add(str);
                }
                Iterator<T> it = bVar2.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("ViewPoolEngine.", 1, (String) it.next(), null);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            ViewPoolEngine.f228744a.o(myLooper);
            ViewPoolEngine.isRunningInThread.set(false);
        }
    }
}
