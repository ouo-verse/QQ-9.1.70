package gx2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u001a\u0010\u0007\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lgx2/d;", "", "key", "Lgx2/c;", "listener", "", "b", "c", "Lgx2/e;", "event", "a", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/playerEvent/c;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/playerEvent/c;", "mgr", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final d f403713b = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.c<c, e> mgr = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.c<>();

    d() {
    }

    public final void a(@Nullable Object key, @NotNull e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        mgr.a(key, event);
    }

    public final void b(@Nullable Object key, @Nullable c listener) {
        mgr.b(key, listener);
    }

    public final void c(@Nullable Object key, @Nullable c listener) {
        mgr.c(key, listener);
    }
}
