package com.tencent.mobileqq.guild.media.core.viewpool;

import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ViewPoolEngine$runInThread$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f228755d;

    @Override // java.lang.Runnable
    public final void run() {
        Function0<Unit> function0 = this.f228755d;
        Looper myLooper = Looper.myLooper();
        ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
        viewPoolEngine.o(Looper.getMainLooper());
        try {
            try {
                function0.invoke();
                viewPoolEngine.o(myLooper);
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "runInThread error:" + e16.getMessage();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("ViewPoolEngine.", 1, (String) it.next(), null);
                }
                ViewPoolEngine.f228744a.o(myLooper);
            }
            ViewPoolEngine.isRunningInThread.set(false);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th5) {
            ViewPoolEngine.f228744a.o(myLooper);
            ViewPoolEngine.isRunningInThread.set(false);
            throw th5;
        }
    }
}
