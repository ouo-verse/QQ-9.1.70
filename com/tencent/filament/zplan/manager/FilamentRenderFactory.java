package com.tencent.filament.zplan.manager;

import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.f;
import com.tencent.filament.zplan.render.impl.FilamentNativeApp;
import com.tencent.filament.zplan.render.impl.ZplanAVChatRender;
import com.tencent.zplan.zplantracing.c;
import dl0.h;
import dl0.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fJ;\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cR3\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190!0 j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190!`\"8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/filament/zplan/manager/FilamentRenderFactory;", "", "", "appType", "", "e", "filamatPath", "bodyResJsonPath", "aiBundlePath", "", "originFps", "targetFps", "maxRenderWidth", "", "delayRenderMs", "", "isRenderLog", "enableInterpolate", "Lcom/tencent/filament/zplan/f;", "d", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "fps", "enableNativeAppReuse", "nativeAppId", "Lwk0/a;", "a", "(Lcom/tencent/zplan/zplantracing/c;ILjava/lang/Boolean;Ljava/lang/Integer;)Lwk0/a;", "Lsk0/a;", "configuration", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "c", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getNativeAppPool", "()Ljava/util/ArrayList;", "nativeAppPool", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentRenderFactory {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final FilamentRenderFactory f105773b = new FilamentRenderFactory();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<WeakReference<a>> nativeAppPool = new ArrayList<>();

    FilamentRenderFactory() {
    }

    public static /* synthetic */ a b(FilamentRenderFactory filamentRenderFactory, c cVar, int i3, Boolean bool, Integer num, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            cVar = null;
        }
        if ((i16 & 2) != 0) {
            i3 = 15;
        }
        if ((i16 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i16 & 8) != 0) {
            num = 0;
        }
        return filamentRenderFactory.a(cVar, i3, bool, num);
    }

    private final void e(final String appType) {
        j jVar = (j) fl0.a.f399763a.a(j.class);
        if (jVar != null) {
            j.a.b(jVar, new Runnable() { // from class: com.tencent.filament.zplan.manager.FilamentRenderFactory$reportCreateNativeApp$1
                @Override // java.lang.Runnable
                public final void run() {
                    Map<String, String> mapOf;
                    h hVar = (h) fl0.a.f399763a.a(h.class);
                    if (hVar != null) {
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("filament_app_tpye", appType));
                        hVar.a("zplan_filament_create_app", mapOf);
                    }
                    if (hVar != null) {
                        hVar.b(appType);
                    }
                }
            }, 0L, 2, null);
        }
    }

    @NotNull
    public final a a(@Nullable c zplanSpanContext, int fps, @Nullable Boolean enableNativeAppReuse, @Nullable Integer nativeAppId) {
        a filamentNativeApp;
        Object obj;
        e("nativeapp");
        if (Intrinsics.areEqual(enableNativeAppReuse, Boolean.FALSE)) {
            return new FilamentNativeApp(zplanSpanContext, fps);
        }
        ArrayList<WeakReference<a>> arrayList = nativeAppPool;
        synchronized (arrayList) {
            if (nativeAppId != null) {
                if (nativeAppId.intValue() == 0) {
                    filamentNativeApp = new FilamentNativeApp(zplanSpanContext, fps);
                    arrayList.add(new WeakReference<>(filamentNativeApp));
                }
            }
            Iterator<T> it = arrayList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                a aVar = (a) ((WeakReference) next).get();
                if (aVar != null) {
                    obj = Integer.valueOf(aVar.A());
                }
                if (Intrinsics.areEqual(obj, nativeAppId)) {
                    obj = next;
                    break;
                }
            }
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference != null && (filamentNativeApp = (a) weakReference.get()) != null) {
                Unit unit = Unit.INSTANCE;
            } else {
                filamentNativeApp = new FilamentNativeApp(zplanSpanContext, fps);
                nativeAppPool.add(new WeakReference<>(filamentNativeApp));
            }
        }
        Intrinsics.checkNotNull(filamentNativeApp);
        return filamentNativeApp;
    }

    @NotNull
    public final IFilamentNativeAppV2305 c(@NotNull sk0.a configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        e("nativeapp_v2305");
        return new FilamentNativeAppV2305(configuration);
    }

    @NotNull
    public final f d(@NotNull String filamatPath, @NotNull String bodyResJsonPath, @NotNull String aiBundlePath, int originFps, int targetFps, int maxRenderWidth, long delayRenderMs, boolean isRenderLog, boolean enableInterpolate) {
        Intrinsics.checkNotNullParameter(filamatPath, "filamatPath");
        Intrinsics.checkNotNullParameter(bodyResJsonPath, "bodyResJsonPath");
        Intrinsics.checkNotNullParameter(aiBundlePath, "aiBundlePath");
        e("avchat");
        return new ZplanAVChatRender(filamatPath, bodyResJsonPath, aiBundlePath, originFps, targetFps, maxRenderWidth, delayRenderMs, isRenderLog, enableInterpolate);
    }
}
