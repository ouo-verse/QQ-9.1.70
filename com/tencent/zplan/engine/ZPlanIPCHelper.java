package com.tencent.zplan.engine;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.IZPlanWorldCallback;
import com.tencent.zplan.buffer.GraphicBufferZplan;
import com.tencent.zplan.common.utils.g;
import com.tencent.zplan.d;
import com.tencent.zplan.h;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.model.ZPlanWorld;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lx4.f;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b`\u0010aJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J1\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0012\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0015\u001a\u00020\tJ\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001c\u0010\u001e\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\tJ(\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010%\u001a\u00020\t2\u0006\u0010!\u001a\u00020 J\u000e\u0010&\u001a\u00020\t2\u0006\u0010!\u001a\u00020 J\u0016\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020 J7\u0010,\u001a\u00020\t2\u0006\u0010'\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010+\u001a\u00020*H\u0000\u00a2\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0000\u00a2\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u00104\u001a\u00020\t2\u0006\u00101\u001a\u00020 2\u0006\u00103\u001a\u000202J\u000e\u00106\u001a\u00020\t2\u0006\u00103\u001a\u000205J\u000e\u00107\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u00108\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u00109\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010J\u000e\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0003J\u000e\u0010>\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0003R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001d\u0010O\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR$\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010W0V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010^\u00a8\u0006b"}, d2 = {"Lcom/tencent/zplan/engine/ZPlanIPCHelper;", "", "", "Lcom/tencent/zplan/engine/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/reflect/Method;", "method", "", "args", "", "o", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "Lcom/tencent/zplan/luabridge/a;", "k", "", "InPakFileName", "", "bCheckCustomVersion", "p", "MapName", "t", "u", AdMetricTag.EVENT_NAME, "Lcom/tencent/zplan/c;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/Surface;", "surface", "Lcom/tencent/zplan/d;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "", "worldID", "width", "height", "j", "v", "B", "renderHashcode", "i", "sceneType", "Lcom/tencent/zplan/IZPlanWorldCallback;", "zplanWorldCallback", DomainData.DOMAIN_NAME, "(IIIILcom/tencent/zplan/IZPlanWorldCallback;)V", "y", "(III)V", UserInfo.SEX_FEMALE, "keyCode", "Landroid/view/KeyEvent;", "event", "r", "Landroid/view/MotionEvent;", ReportConstant.COSTREPORT_PREFIX, "E", HippyTKDListViewAdapter.X, h.F, "using", "D", "statusUpdateListener", "w", "G", "Lcom/tencent/zplan/h;", "a", "Lcom/tencent/zplan/h;", "zPlanServiceInterface", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", "zPlanEngineStatusLock", "", "c", "Ljava/util/List;", "zPlanEngineStatusUpdateListenerList", "d", "Lkotlin/Lazy;", "l", "()Ljava/lang/reflect/Method;", "METHOD_SERVICE_CONNECTED", "e", "Lcom/tencent/zplan/luabridge/a;", "remoteLuaCaller", "f", "Z", "isConnected", "", "Lcom/tencent/zplan/buffer/GraphicBufferZplan;", "g", "Ljava/util/Map;", "inBuffers", "Ljava/lang/String;", "currentLevel", "Landroid/content/ServiceConnection;", "Landroid/content/ServiceConnection;", "zServiceConnection", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanIPCHelper {

    /* renamed from: a, reason: from kotlin metadata */
    private static com.tencent.zplan.h zPlanServiceInterface;

    /* renamed from: d, reason: from kotlin metadata */
    private static final Lazy METHOD_SERVICE_CONNECTED;

    /* renamed from: e, reason: from kotlin metadata */
    private static com.tencent.zplan.luabridge.a remoteLuaCaller;

    /* renamed from: f, reason: from kotlin metadata */
    private static boolean isConnected;

    /* renamed from: g, reason: from kotlin metadata */
    private static Map<Integer, GraphicBufferZplan> inBuffers;

    /* renamed from: h */
    private static String currentLevel;

    /* renamed from: i, reason: from kotlin metadata */
    private static final ServiceConnection zServiceConnection;

    /* renamed from: j */
    @NotNull
    public static final ZPlanIPCHelper f385519j = new ZPlanIPCHelper();

    /* renamed from: b, reason: from kotlin metadata */
    private static final ReentrantLock zPlanEngineStatusLock = new ReentrantLock();

    /* renamed from: c, reason: from kotlin metadata */
    private static final List<b> zPlanEngineStatusUpdateListenerList = new ArrayList();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/engine/ZPlanIPCHelper$a", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "", "onServiceConnected", "onServiceDisconnected", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements ServiceConnection {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "binderDied"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.tencent.zplan.engine.ZPlanIPCHelper$a$a */
        /* loaded from: classes27.dex */
        static final class C10058a implements IBinder.DeathRecipient {

            /* renamed from: d */
            public static final C10058a f385520d = new C10058a();

            C10058a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                ZLog.f386189b.f("[zplan]_ZPlanIPCHelper", "ZPlanIPCHelper has dead");
                ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
                ZPlanIPCHelper.zPlanServiceInterface = null;
                ZPlanIPCHelper.remoteLuaCaller = null;
                ZPlanIPCHelper.isConnected = false;
            }
        }

        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName name, @Nullable IBinder service) {
            com.tencent.zplan.luabridge.c cVar;
            ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "ZPlanIPCHelper onServiceConnected name : " + name);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            ZPlanIPCHelper.zPlanServiceInterface = h.a.j(service);
            com.tencent.zplan.h c16 = ZPlanIPCHelper.c(zPlanIPCHelper);
            if (c16 != null) {
                cVar = new com.tencent.zplan.luabridge.c(c16);
            } else {
                cVar = null;
            }
            ZPlanIPCHelper.remoteLuaCaller = cVar;
            ZPlanIPCHelper.isConnected = true;
            zPlanIPCHelper.o(zPlanIPCHelper.l(), Boolean.TRUE);
            if (service != null) {
                service.linkToDeath(C10058a.f385520d, 0);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName name) {
            ZLog.f386189b.f("[zplan]_ZPlanIPCHelper", "ZPlanIPCHelper onServiceDisconnected name : " + name);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            ZPlanIPCHelper.zPlanServiceInterface = null;
            ZPlanIPCHelper.remoteLuaCaller = null;
            ZPlanIPCHelper.isConnected = false;
            zPlanIPCHelper.o(zPlanIPCHelper.l(), Boolean.FALSE);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanIPCHelper$METHOD_SERVICE_CONNECTED$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(b.class, "onBindServiceStatus", Boolean.TYPE);
            }
        });
        METHOD_SERVICE_CONNECTED = lazy;
        inBuffers = new LinkedHashMap();
        zServiceConnection = new a();
    }

    ZPlanIPCHelper() {
    }

    public static /* synthetic */ void A(ZPlanIPCHelper zPlanIPCHelper, Surface surface, d dVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dVar = null;
        }
        zPlanIPCHelper.z(surface, dVar);
    }

    public static final /* synthetic */ com.tencent.zplan.h c(ZPlanIPCHelper zPlanIPCHelper) {
        return zPlanServiceInterface;
    }

    public final Method l() {
        return (Method) METHOD_SERVICE_CONNECTED.getValue();
    }

    public final List<b> m() {
        List<b> list;
        ReentrantLock reentrantLock = zPlanEngineStatusLock;
        reentrantLock.lock();
        try {
            list = CollectionsKt___CollectionsKt.toList(zPlanEngineStatusUpdateListenerList);
            return list;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void o(final Method method, final Object... args) {
        f fVar = (f) mx4.a.f417748a.a(f.class);
        if (fVar != null) {
            f.a.a(fVar, new Runnable() { // from class: com.tencent.zplan.engine.ZPlanIPCHelper$handleZPlanEngineStatusUpdate$1
                @Override // java.lang.Runnable
                public final void run() {
                    List<b> m3;
                    long currentTimeMillis = System.currentTimeMillis();
                    m3 = ZPlanIPCHelper.f385519j.m();
                    for (b bVar : m3) {
                        ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "handleZPlanEngineStatusUpdate " + method + ", " + bVar);
                        try {
                            Method method2 = method;
                            if (method2 != null) {
                                Object[] objArr = args;
                                method2.invoke(bVar, Arrays.copyOf(objArr, objArr.length));
                            }
                        } catch (IllegalAccessException e16) {
                            ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "handleZPlanEngineStatusUpdate, " + e16);
                        } catch (IllegalArgumentException e17) {
                            ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "handleZPlanEngineStatusUpdate, " + e17);
                        } catch (InvocationTargetException e18) {
                            ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "handleZPlanEngineStatusUpdate, " + e18);
                        }
                    }
                    ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "handleZPlanEngineStatusUpdate const: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            }, 0L, 2, null);
        }
    }

    public final void B(int worldID) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.m4(worldID);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "resumeWorld", e16);
        }
    }

    public final void C() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.I2();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "setContext", e16);
        }
    }

    public final boolean D(boolean using) {
        String str;
        ZLog.f386189b.l("[zplan]_ZPlanIPCHelper", "setIsUsing using: " + using + ", ", new StackPrinter("setIsUsing"));
        com.tencent.zplan.h hVar = zPlanServiceInterface;
        if (hVar != null) {
            try {
                StringBuilder sb5 = new StringBuilder();
                Object a16 = mx4.a.f417748a.a(lx4.a.class);
                Intrinsics.checkNotNull(a16);
                Context context = ((lx4.a) a16).getContext();
                if (context != null) {
                    str = context.getPackageName();
                } else {
                    str = null;
                }
                sb5.append(str);
                sb5.append(":peak");
                hVar.g3(sb5.toString(), using);
                return true;
            } catch (Exception e16) {
                ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "getIsUsing", e16);
                return false;
            }
        }
        return false;
    }

    public final void E(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "setSurface : " + surface + ", zPlanServiceInterface : " + zPlanServiceInterface + TokenParser.SP);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.setSurface(surface);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, e16);
        }
    }

    public final void F(int i3, @NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.z3(i3, surface);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "setWorldWindow", e16);
        }
    }

    public final synchronized void G(@NotNull b statusUpdateListener) {
        Intrinsics.checkNotNullParameter(statusUpdateListener, "statusUpdateListener");
        ReentrantLock reentrantLock = zPlanEngineStatusLock;
        reentrantLock.lock();
        try {
            ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "unRegisterZPlanEngineStatusUpdateListener " + statusUpdateListener);
            zPlanEngineStatusUpdateListenerList.remove(statusUpdateListener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void h(@Nullable Surface surface) {
        ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "destroySurface : " + surface + ", zPlanServiceInterface : " + zPlanServiceInterface + TokenParser.SP);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.Z1(surface);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "destroySurface", e16);
        }
    }

    public final void i(int renderHashcode, int worldID) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.Y4(renderHashcode, worldID);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "destroyWorld", e16);
        }
    }

    public final void j(int worldID, int width, int height, @Nullable Surface surface) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.Y3(worldID, width, height, surface);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "focusWorld", e16);
        }
    }

    @Nullable
    public final com.tencent.zplan.luabridge.a k() {
        return remoteLuaCaller;
    }

    public final void n(int i3, int i16, int i17, int i18, @NotNull final IZPlanWorldCallback zplanWorldCallback) {
        Intrinsics.checkNotNullParameter(zplanWorldCallback, "zplanWorldCallback");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.l3(i3, i16, i17, i18, new IZPlanWorldCallback.Stub() { // from class: com.tencent.zplan.engine.ZPlanIPCHelper$getZPlanWorld$1
                    @Override // com.tencent.zplan.IZPlanWorldCallback
                    public void onGetZPlanWorld(@Nullable ZPlanWorld zplanWorld) {
                        IZPlanWorldCallback.this.onGetZPlanWorld(zplanWorld);
                    }
                });
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "getZPlanWorld", e16);
        }
    }

    public final void p(@Nullable String InPakFileName, boolean bCheckCustomVersion) {
        ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "mountPak, InPakFilename: " + InPakFileName + ", bCheckCustomVersion: " + bCheckCustomVersion);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.g1(InPakFileName, 0, "", true, bCheckCustomVersion);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "mountPak", e16);
        }
    }

    public final void q(@NotNull String eventName, @Nullable com.tencent.zplan.c cVar) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.d1(eventName, cVar);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "observeLuaEvent", e16);
        }
    }

    public final void r(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.T(keyCode, event);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "onKeyEvent", e16);
        }
    }

    public final void s(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.onTouchEvent(event);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "onTouchEvent", e16);
        }
    }

    public final void t(@Nullable String MapName) {
        ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "openLevelAsync, MapName: " + MapName);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                currentLevel = MapName;
                if (hVar != null) {
                    hVar.B4(MapName);
                }
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "openLevelAsync", e16);
        }
    }

    public final void u() {
        ZLog.f386189b.l("[zplan]_ZPlanIPCHelper", "pauseEngine, ", new StackPrinter("pauseEngine"));
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.pauseEngine();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "pauseEngine", e16);
        }
    }

    public final void v(int worldID) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.y3(worldID);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "pauseWorld", e16);
        }
    }

    public final synchronized void w(@NotNull b statusUpdateListener) {
        Intrinsics.checkNotNullParameter(statusUpdateListener, "statusUpdateListener");
        ReentrantLock reentrantLock = zPlanEngineStatusLock;
        reentrantLock.lock();
        try {
            ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "registerZPlanEngineStatusUpdateListener " + statusUpdateListener);
            List<b> list = zPlanEngineStatusUpdateListenerList;
            if (!list.contains(statusUpdateListener)) {
                list.add(statusUpdateListener);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (isConnected) {
                statusUpdateListener.a(true);
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    public final void x(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ZLog.f386189b.k("[zplan]_ZPlanIPCHelper", "resizeSurface : " + surface + ", zPlanServiceInterface : " + zPlanServiceInterface + TokenParser.SP);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.G1(surface);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "resizeSurface", e16);
        }
    }

    public final void y(int worldID, int width, int height) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.r2(worldID, width, height);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "resizeZPlanWorld", e16);
        }
    }

    public final void z(@Nullable Surface surface, @Nullable d dVar) {
        ZLog.f386189b.l("[zplan]_ZPlanIPCHelper", "resumeEngine,", new StackPrinter("resumeEngine"));
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.V0(surface, dVar);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanIPCHelper", "resumeEngine", e16);
        }
    }
}
