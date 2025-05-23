package com.tencent.mobileqq.guild.util;

import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.LruCache;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.api.IGuildDebugApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0007J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0007J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/util/s;", "", "T", "", "tag", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "message", "", "throwable", "", "f", "e", "g", "", "d", "b", "c", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "messageWithTimestamp", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f235620a = new s();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Long> messageWithTimestamp = new LruCache<>(16);

    s() {
    }

    @JvmStatic
    @Nullable
    public static final <T> T a(@NotNull String tag, @Nullable T item) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (item == null) {
            try {
                throw new IllegalStateException("Required value was null.".toString());
            } catch (Exception e16) {
                f(tag, "checkNotNull() fail".toString(), e16);
                return null;
            }
        }
        return item;
    }

    private final boolean d(String tag, String message, Throwable throwable) {
        String str = tag + ':' + message;
        LruCache<String, Long> lruCache = messageWithTimestamp;
        Long l3 = lruCache.get(str);
        if (l3 != null && l3.longValue() + 1000 >= SystemClock.uptimeMillis()) {
            return false;
        }
        lruCache.put(str, Long.valueOf(SystemClock.uptimeMillis()));
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = tag + MsgSummary.STR_COLON + message;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.comm.GuildGrayUtils", 1, (String) it.next(), throwable);
        }
        return true;
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String message, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (f235620a.d(tag, message, throwable)) {
            ((IGuildDebugApi) QRoute.api(IGuildDebugApi.class)).reportCaughtException(tag, message, throwable);
        }
    }

    @JvmStatic
    public static final void f(@NotNull String tag, @NotNull String message, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (f235620a.d(tag, message, throwable)) {
            ((IGuildDebugApi) QRoute.api(IGuildDebugApi.class)).reportCaughtException(tag, message, throwable);
        }
    }

    @JvmStatic
    public static final void g(@NotNull String tag, @NotNull String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (f235620a.d(tag, message, null)) {
            ((IGuildDebugApi) QRoute.api(IGuildDebugApi.class)).reportCaughtException(tag + "-ToastError", message, new RuntimeException(message));
        }
    }

    public final void b() {
        c("Guild.comm.GuildGrayUtils");
    }

    public final void c(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            f(tag, "\u5fc5\u987b\u5728\u4e3b\u7ebf\u7a0b\u6267\u884c", new IllegalStateException("\u5fc5\u987b\u5728\u4e3b\u7ebf\u7a0b\u6267\u884c"));
        }
    }
}
