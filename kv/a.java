package kv;

import android.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lkv/a;", "", "", "a", "k", "d", "", "elementId", "e", "", "params", "f", "b", "c", "g", h.F, "i", "j", "Lcom/tencent/mobileqq/aio/utils/a;", "Lcom/tencent/mobileqq/aio/utils/a;", "paramBuilder", "Landroid/util/ArrayMap;", "", "Landroid/util/ArrayMap;", "exploreMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f413301a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.aio.utils.a paramBuilder = new com.tencent.mobileqq.aio.utils.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayMap<String, Long> exploreMap = new ArrayMap<>();

    a() {
    }

    public final void a() {
        e("em_bas_voice_call_button");
    }

    public final void b() {
        g("em_bas_audio_video_panel");
    }

    public final void c() {
        i("em_bas_audio_video_panel");
    }

    public final void d() {
        e("em_bas_audio_video_panel_cancel");
    }

    public final void e(@NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        f(elementId, null);
    }

    public final void f(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_click", a16);
    }

    public final void g(@NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        h(elementId, null);
    }

    public final void h(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        exploreMap.put(elementId, Long.valueOf(System.currentTimeMillis()));
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_imp", a16);
    }

    public final void i(@NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        j(elementId, null);
    }

    public final void j(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        ArrayMap<String, Long> arrayMap = exploreMap;
        if (arrayMap.containsKey(elementId)) {
            Long l3 = arrayMap.get(elementId);
            Intrinsics.checkNotNull(l3);
            a16.put("qq_element_lvtm", Long.valueOf(l3.longValue() - System.currentTimeMillis()));
            arrayMap.remove(elementId);
        } else {
            a16.put("qq_element_lvtm", 0);
        }
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_imp_end", a16);
    }

    public final void k() {
        e("em_bas_video_call_button");
    }
}
