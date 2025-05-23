package com.tencent.mobileqq.zootopia;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00048F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00048F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00048F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0019\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/g;", "", "", "type", "", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "switchMap", "Z", "isVideoOn", "()Z", "setVideoOn", "(Z)V", "d", "I", "()I", "setSmallHomePermissionMaxCount", "(I)V", "smallHomePermissionMaxCount", "skipMapStatus", "a", "setSkipMapStatus", "isGuideNewUser", "setGuideNewUser", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f328305a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Boolean> switchMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isVideoOn = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int smallHomePermissionMaxCount = 100;

    g() {
    }

    public final boolean a() {
        return false;
    }

    public final int b() {
        return 100;
    }

    public final boolean c(int type) {
        return false;
    }

    public final boolean d() {
        return false;
    }
}
