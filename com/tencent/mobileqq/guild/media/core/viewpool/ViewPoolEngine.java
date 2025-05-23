package com.tencent.mobileqq.guild.media.core.viewpool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.guild.api.tab.QQGuildTabManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.business.Monitor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import tl.h;
import vs1.b;
import vs1.c;
import vs1.d;
import vs1.e;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0003J\u0006\u0010\u0012\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bR&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/viewpool/ViewPoolEngine;", "", "Landroid/content/Context;", "context", "Lvs1/d;", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "Lvs1/e;", "viewType", "Lvs1/b;", "creator", h.F, "Landroid/os/Looper;", "looper", "o", "j", "Landroid/view/View;", "i", "g", "p", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "Lvs1/a;", "b", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "poolMap", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "c", "Lcom/tencent/qphone/base/util/BaseApplication;", "appCtx", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunningInThread", "e", "hasRegisterTabChange", "f", "Z", "isInGuildTab", "hasFillViewPoolOnInit", "Lnr0/a;", "Lnr0/a;", "onTabChanged", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ViewPoolEngine {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ViewPoolEngine f228744a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QQConcurrentHashMap<e, vs1.a<View>> poolMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final BaseApplication appCtx;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean isRunningInThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasRegisterTabChange;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isInGuildTab;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasFillViewPoolOnInit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final nr0.a onTabChanged;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/viewpool/ViewPoolEngine$a", "Lnr0/a;", "", "guildTab", "", "onTabChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements nr0.a {
        a() {
        }

        @Override // nr0.a
        public void onTabChanged(boolean guildTab) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ViewPoolEngine.", 2, "onTabChanged guildTab==" + guildTab);
            }
            ViewPoolEngine.isInGuildTab = guildTab;
            if (!guildTab) {
                ViewPoolEngine.f228744a.g();
            }
        }
    }

    static {
        ViewPoolEngine viewPoolEngine = new ViewPoolEngine();
        f228744a = viewPoolEngine;
        poolMap = new QQConcurrentHashMap<>(Business.Guild, "ViewPoolEngine.");
        appCtx = BaseApplication.getContext();
        isRunningInThread = new AtomicBoolean(false);
        hasRegisterTabChange = new AtomicBoolean(false);
        isInGuildTab = true;
        hasFillViewPoolOnInit = new AtomicBoolean(false);
        onTabChanged = new a();
        viewPoolEngine.n();
    }

    ViewPoolEngine() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(e viewType, b creator) {
        if (!isInGuildTab) {
            Logger.f235387a.d().d("ViewPoolEngine.", 1, "[createAndFillViewPool] isInGuildTab is false, so return!");
            g();
            return;
        }
        QQConcurrentHashMap<e, vs1.a<View>> qQConcurrentHashMap = poolMap;
        if (!qQConcurrentHashMap.containsKey(viewType)) {
            qQConcurrentHashMap.put(viewType, new vs1.a<>(creator.size()));
        }
        vs1.a<View> aVar = qQConcurrentHashMap.get(viewType);
        Intrinsics.checkNotNull(aVar);
        vs1.a<View> aVar2 = aVar;
        int b16 = aVar2.b();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ViewPoolEngine.", viewType + " cur: " + b16 + ", will create  count: " + (creator.size() - b16));
        }
        int size = creator.size();
        while (b16 < size) {
            aVar2.d(creator.create(l(this, null, 1, null)));
            b16++;
        }
    }

    private final d k(Context context) {
        return new d(context);
    }

    static /* synthetic */ d l(ViewPoolEngine viewPoolEngine, Context appCtx2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            appCtx2 = appCtx;
            Intrinsics.checkNotNullExpressionValue(appCtx2, "appCtx");
        }
        return viewPoolEngine.k(appCtx2);
    }

    private final boolean m() {
        com.tencent.cache.api.d currentPageArgus = Monitor.INSTANCE.getCurrentPageArgus();
        if (currentPageArgus == null || currentPageArgus.b() == Business.Guild) {
            return true;
        }
        return false;
    }

    private final void n() {
        if (hasRegisterTabChange.compareAndSet(false, true)) {
            QQGuildTabManager.c(new WeakReference(onTabChanged));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DiscouragedPrivateApi"})
    public final void o(Looper looper) {
        Field declaredField = Looper.class.getDeclaredField("sThreadLocal");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(Looper.getMainLooper());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.ThreadLocal<android.os.Looper>");
        ((ThreadLocal) obj).set(looper);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ViewPoolEngine.", "setCurThreadLooper result:" + looper);
        }
    }

    public final void g() {
        if (poolMap.isEmpty()) {
            return;
        }
        final String str = "clearAllCache[" + isInGuildTab + "]";
        if (isRunningInThread.get()) {
            Logger.f235387a.d().d("ViewPoolEngine.", 1, "isRunningInThread, runInThread ignore, " + str);
            return;
        }
        isRunningInThread.set(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine$clearAllCache$$inlined$runInThread$1
            @Override // java.lang.Runnable
            public final void run() {
                QQConcurrentHashMap qQConcurrentHashMap;
                Looper myLooper = Looper.myLooper();
                ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
                viewPoolEngine.o(Looper.getMainLooper());
                try {
                    try {
                        qQConcurrentHashMap = ViewPoolEngine.poolMap;
                        qQConcurrentHashMap.clear();
                    } catch (Exception e16) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str2 = "runInThread error:" + e16.getMessage();
                        if (str2 instanceof String) {
                            bVar.a().add(str2);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("ViewPoolEngine.", 1, (String) it.next(), null);
                        }
                        viewPoolEngine = ViewPoolEngine.f228744a;
                    }
                    viewPoolEngine.o(myLooper);
                    ViewPoolEngine.isRunningInThread.set(false);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th5) {
                    ViewPoolEngine.f228744a.o(myLooper);
                    ViewPoolEngine.isRunningInThread.set(false);
                    throw th5;
                }
            }
        }, 16, null, true);
    }

    @NotNull
    public final View i(@NotNull e viewType, @NotNull Context context) {
        View view;
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(context, "context");
        vs1.a<View> aVar = poolMap.get(viewType);
        d dVar = null;
        if (aVar != null) {
            view = aVar.a();
        } else {
            view = null;
        }
        if (view == null) {
            b bVar = c.INSTANCE.a().get(viewType);
            Intrinsics.checkNotNull(bVar);
            view = bVar.create(k(context));
        }
        Context context2 = view.getContext();
        if (context2 instanceof d) {
            dVar = (d) context2;
        }
        if (dVar != null) {
            dVar.setBaseContext(context);
        }
        return view;
    }

    public final void j() {
        Logger.f235387a.d().d("ViewPoolEngine.", 1, "[destroy] " + Monitor.INSTANCE.getCurrentPageArgus());
        if (!m()) {
            g();
        }
    }

    public final void p() {
        Logger logger = Logger.f235387a;
        logger.d().d("ViewPoolEngine.", 1, "[tryFillAllViewPool] isInGuildTab " + isInGuildTab);
        if (!isInGuildTab) {
            return;
        }
        final String str = "tryFillAllViewPool";
        if (isRunningInThread.get()) {
            logger.d().d("ViewPoolEngine.", 1, "isRunningInThread, runInThread ignore, tryFillAllViewPool");
            return;
        }
        isRunningInThread.set(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine$tryFillAllViewPool$$inlined$runInThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Looper myLooper = Looper.myLooper();
                ViewPoolEngine.f228744a.o(Looper.getMainLooper());
                try {
                    try {
                        Set<Map.Entry<e, b>> entrySet = c.INSTANCE.a().entrySet();
                        Intrinsics.checkNotNullExpressionValue(entrySet, "ViewPoolConfig.configMap.entries");
                        Iterator<T> it = entrySet.iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "it.key");
                            Object value = entry.getValue();
                            Intrinsics.checkNotNullExpressionValue(value, "it.value");
                            viewPoolEngine.h((e) key, (b) value);
                        }
                    } catch (Exception e16) {
                        Logger logger2 = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str2 = "runInThread error:" + e16.getMessage();
                        if (str2 instanceof String) {
                            bVar.a().add(str2);
                        }
                        Iterator<T> it5 = bVar.a().iterator();
                        while (it5.hasNext()) {
                            Logger.f235387a.d().e("ViewPoolEngine.", 1, (String) it5.next(), null);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    ViewPoolEngine.f228744a.o(myLooper);
                    ViewPoolEngine.isRunningInThread.set(false);
                }
            }
        }, 16, null, true);
    }
}
