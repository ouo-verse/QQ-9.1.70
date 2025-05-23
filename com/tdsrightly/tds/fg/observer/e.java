package com.tdsrightly.tds.fg.observer;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.tdsrightly.tds.fg.observer.d;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tdsrightly/tds/fg/observer/e;", "Lcom/tdsrightly/tds/fg/observer/d;", "", "c", "", "getName", "Landroid/app/Application;", "app", "Lop/e;", "listener", "", "d", "getAppState", "Landroid/app/Application;", "<init>", "()V", "e", "a", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class e implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Application app;

    private final int c() {
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList;
        boolean z16;
        boolean z17;
        Application application = this.app;
        boolean z18 = false;
        if (application != null) {
            try {
                int myPid = Process.myPid();
                Object systemService = application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (systemService != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
                    if (runningAppProcesses != null) {
                        arrayList = new ArrayList();
                        for (Object obj : runningAppProcesses) {
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
                            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                arrayList.add(obj);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        loop1: while (true) {
                            z16 = false;
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : arrayList) {
                                if (runningAppProcessInfo2.importance == 100 && runningAppProcessInfo2.importanceReasonCode == 0) {
                                    z16 = true;
                                }
                            }
                            break loop1;
                        }
                        z18 = z16;
                    }
                    if (z18) {
                        return 1;
                    }
                    return 2;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void a(@NotNull HashMap<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        d.a.a(this, map);
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void b(int i3, @NotNull d from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        d.a.c(this, i3, from);
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void d(@NotNull Application app, @NotNull op.e listener) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.app = app;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public int getAppState() {
        return c();
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    @NotNull
    public String getName() {
        return "ProcessObserver";
    }
}
