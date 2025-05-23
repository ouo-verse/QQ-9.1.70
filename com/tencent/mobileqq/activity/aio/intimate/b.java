package com.tencent.mobileqq.activity.aio.intimate;

import com.tencent.mobileqq.activity.aio.intimate.header.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/b;", "", "", "g", "d", "c", "b", "e", "", "a", "Z", "onExpoTime", "isUpdateCountWhenExpo", "", "I", "count", "", "Ljava/lang/String;", "getFriendUin", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "friendUin", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean onExpoTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isUpdateCountWhenExpo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int count;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f178912a = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String friendUin = "";

    b() {
    }

    private final void g() {
        if (count < 3) {
            l.f179061a.o(count + 1);
        }
    }

    public final boolean a() {
        if (onExpoTime && count < 3) {
            return true;
        }
        return false;
    }

    public final void b() {
        onExpoTime = false;
    }

    public final void c() {
        onExpoTime = false;
        QLog.d("InitmateRelateEntryHelper", 1, "[onDrawerClose]");
    }

    public final void d() {
        onExpoTime = true;
        isUpdateCountWhenExpo = false;
        int h16 = l.f179061a.h();
        count = h16;
        QLog.d("InitmateRelateEntryHelper", 1, "[onDrawerOpen] count=" + h16);
    }

    public final void e() {
        if (!isUpdateCountWhenExpo) {
            g();
            isUpdateCountWhenExpo = true;
        }
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        friendUin = str;
    }
}
