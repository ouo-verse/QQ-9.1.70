package com.tencent.zplan.engine;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.e;
import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.h;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J$\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/zplan/engine/a;", "", "Landroid/os/IBinder;", "iBinder", "", "j", "", "action", "Landroid/os/Bundle;", "data", "Lcom/tencent/zplan/e;", "callback", "i", "Lcom/tencent/zplan/engine/a$a;", "listener", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "l", DomainData.DOMAIN_NAME, "k", "", "a", "Z", "isServiceBind", "b", "isServiceConnected", "c", "isRegister", "Lcom/tencent/zplan/h;", "d", "Lcom/tencent/zplan/h;", "zplanServiceInterface", "", "e", "Ljava/util/List;", "connectListeners", "Landroid/content/ServiceConnection;", "f", "Landroid/content/ServiceConnection;", "serviceConnection", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isServiceBind;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isServiceConnected;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isRegister;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.zplan.h zplanServiceInterface;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f385563g = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final List<InterfaceC10059a> connectListeners = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ServiceConnection serviceConnection = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/zplan/engine/a$a;", "", "", "onConnect", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.engine.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public interface InterfaceC10059a {
        void onConnect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "binderDied"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements IBinder.DeathRecipient {

        /* renamed from: d, reason: collision with root package name */
        public static final b f385564d = new b();

        b() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            a.f385563g.m();
            a.isServiceBind = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/zplan/engine/a$c", "Lcom/tencent/zplan/engine/a$a;", "", "onConnect", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements InterfaceC10059a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f385565a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f385566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f385567c;

        c(String str, Bundle bundle, e eVar) {
            this.f385565a = str;
            this.f385566b = bundle;
            this.f385567c = eVar;
        }

        @Override // com.tencent.zplan.engine.a.InterfaceC10059a
        public void onConnect() {
            a.f385563g.i(this.f385565a, this.f385566b, this.f385567c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/engine/a$d", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "", "onServiceConnected", "onServiceDisconnected", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements ServiceConnection {
        d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName name, @NotNull IBinder service) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(service, "service");
            synchronized (a.class) {
                ZLog.f386189b.c("ZPlanActionIPCHelper", "ZPlanActionIPCHelper Service Connected");
                a aVar = a.f385563g;
                a.zplanServiceInterface = h.a.j(service);
                a.isServiceConnected = true;
                aVar.j(service);
                if (a.b(aVar).size() > 0) {
                    Iterator it = a.b(aVar).iterator();
                    while (it.hasNext()) {
                        ((InterfaceC10059a) it.next()).onConnect();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            synchronized (a.class) {
                ZLog.f386189b.c("ZPlanActionIPCHelper", "ZPlanActionIPCHelper Service Disconnected");
                a.f385563g.m();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    a() {
    }

    public static final /* synthetic */ List b(a aVar) {
        return connectListeners;
    }

    private final void h(InterfaceC10059a listener) {
        connectListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String action, Bundle data, e callback) {
        try {
            ZLog.f386189b.c("ZPlanActionIPCHelper", "ZPlanActionIPCHelper callZPlanAction " + action);
            com.tencent.zplan.h hVar = zplanServiceInterface;
            if (hVar != null) {
                hVar.z(action, data, callback);
            }
        } catch (Throwable th5) {
            ZLog.f386189b.f("ZPlanActionIPCHelper", "ZPlanActionIPCHelper callZPlanAction " + action + " error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(IBinder iBinder) {
        try {
            iBinder.linkToDeath(b.f385564d, 0);
        } catch (RemoteException e16) {
            m();
            ZLog.f386189b.f("ZPlanActionIPCHelper", "ZPlanActionIPCHelper RemoteException:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        isRegister = false;
        isServiceConnected = false;
        zplanServiceInterface = null;
        connectListeners.clear();
    }

    public final void k(@Nullable String action, @Nullable Bundle data, @Nullable e callback) {
        if (!isRegister) {
            ZLog.f386189b.f("ZPlanActionIPCHelper", "Must use registerZPlanActionIPCHelper before call onCallZPlanAction");
        } else if (!isServiceConnected) {
            ZLog.f386189b.c("ZPlanActionIPCHelper", "delay to callZPlanAction");
            h(new c(action, data, callback));
        } else {
            i(action, data, callback);
        }
    }

    public final synchronized void l(@Nullable Context context) {
        if (context != null) {
            if (!isServiceBind) {
                ZLog.f386189b.c("ZPlanActionIPCHelper", "ZPlanActionIPCHelper Register");
                isRegister = true;
                isServiceBind = context.bindService(new Intent(context, (Class<?>) ZPlanEngineService.class), serviceConnection, 1);
            }
        }
    }

    public final synchronized void n(@Nullable Context context) {
        if (context != null) {
            if (isServiceBind) {
                ZLog.f386189b.c("ZPlanActionIPCHelper", "ZPlanActionIPCHelper unRegister");
                context.unbindService(serviceConnection);
                isServiceBind = false;
                m();
            }
        }
    }
}
