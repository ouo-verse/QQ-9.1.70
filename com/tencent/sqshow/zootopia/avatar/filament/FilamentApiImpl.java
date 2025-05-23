package com.tencent.sqshow.zootopia.avatar.filament;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.f;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J#\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019R \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR(\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130 0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentApiImpl;", "Lcom/tencent/sqshow/zootopia/avatar/filament/f;", "Lcom/tencent/mobileqq/zplan/api/a;", "configData", "", "loadConfig", "f", "", "d", "", "e", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "La84/a;", "a", "nativeAppId", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleAvatarComponent;", "b", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/Integer;)Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleAvatarComponent;", "", "event", "data", "c", "Z", "enableFilament", "I", "fps", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/avatar/filament/g;", "Ljava/util/List;", "eventDispatchers", "Lkotlin/Pair;", "waitingEvents", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FilamentApiImpl implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final FilamentApiImpl f369933a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enableFilament;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int fps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<WeakReference<g>> eventDispatchers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final List<Pair<String, String>> waitingEvents;

    static {
        FilamentApiImpl filamentApiImpl = new FilamentApiImpl();
        f369933a = filamentApiImpl;
        enableFilament = true;
        fps = 30;
        eventDispatchers = new ArrayList();
        waitingEvents = new ArrayList();
        f.a.b(filamentApiImpl, null, 1, null);
    }

    FilamentApiImpl() {
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.f
    public a84.a a(com.tencent.zplan.zplantracing.c zplanSpanContext) {
        FilamentNativeComponent filamentNativeComponent = new FilamentNativeComponent(zplanSpanContext);
        eventDispatchers.add(new WeakReference<>(filamentNativeComponent));
        List<Pair<String, String>> list = waitingEvents;
        synchronized (list) {
            QLog.i("FilamentApiImpl_", 1, "buildFilamentComponent waitingEvents.size=" + list.size());
            if (list.size() > 0) {
                for (Pair<String, String> pair : list) {
                    filamentNativeComponent.l(pair.getFirst(), pair.getSecond());
                }
                waitingEvents.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
        return filamentNativeComponent;
    }

    public ZPlanRoleAvatarComponent b(com.tencent.zplan.zplantracing.c zplanSpanContext, Integer nativeAppId) {
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = new ZPlanRoleAvatarComponent(zplanSpanContext, nativeAppId);
        eventDispatchers.add(new WeakReference<>(zPlanRoleAvatarComponent));
        List<Pair<String, String>> list = waitingEvents;
        synchronized (list) {
            QLog.i("FilamentApiImpl_", 1, "buildFilamentComponent waitingEvents.size=" + list.size());
            if (list.size() > 0) {
                for (Pair<String, String> pair : list) {
                    zPlanRoleAvatarComponent.l(pair.getFirst(), pair.getSecond());
                }
                waitingEvents.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
        return zPlanRoleAvatarComponent;
    }

    public void c(String event, String data) {
        Object lastOrNull;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(event, "event");
        List<WeakReference<g>> list = eventDispatchers;
        CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<WeakReference<g>, Boolean>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl$dispatch$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<g> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null);
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g gVar = (g) ((WeakReference) it.next()).get();
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
        g gVar2 = (g) lastOrNull;
        if (gVar2 != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                QLog.i("FilamentApiImpl_", 1, "dispatch:" + event + ", data:" + data);
                gVar2.l(event, data);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.e("FilamentApiImpl_", 1, "dispatch:" + event + ", data:" + data + ", failed:", m479exceptionOrNullimpl);
                return;
            }
            return;
        }
        waitingEvents.add(TuplesKt.to(event, data));
    }

    public boolean d() {
        return enableFilament;
    }

    public int e() {
        return fps;
    }

    public void f() {
        QLog.i("FilamentApiImpl_", 1, "refreshConfig start");
        f.a.b(this, null, 1, null);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.f
    public void loadConfig(com.tencent.mobileqq.zplan.api.a configData) {
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase();
        enableFilament = enableZPlanFilamentBase;
        QLog.i("FilamentApiImpl_", 1, "enableFilament:" + enableZPlanFilamentBase + ", filamentEnable:" + enableZPlanFilamentBase);
    }
}
