package com.tencent.mobileqq.zootopia;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/k;", "", "Lcom/tencent/mobileqq/zootopia/a;", "callback", "", "g", "", "mapId", "", "mapName", "c", "e", "b", "Lcom/tencent/mobileqq/zootopia/a;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f328365a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static a callback;

    k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "$mapName");
        a aVar = callback;
        if (aVar != null) {
            aVar.doEnterUEMap(i3, mapName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "$mapName");
        a aVar = callback;
        if (aVar != null) {
            aVar.doExitUEMap(i3, mapName);
        }
    }

    public final void c(final int mapId, final String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.j
            @Override // java.lang.Runnable
            public final void run() {
                k.d(mapId, mapName);
            }
        }, 16, null, true);
    }

    public final void e(final int mapId, final String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.i
            @Override // java.lang.Runnable
            public final void run() {
                k.f(mapId, mapName);
            }
        }, 16, null, true);
    }

    public final void g(a callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        callback = callback2;
    }
}
