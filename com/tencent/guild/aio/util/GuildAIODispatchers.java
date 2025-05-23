package com.tencent.guild.aio.util;

import android.os.Handler;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\u000e\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\f\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/util/GuildAIODispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "c", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Normal", "Network", "d", "a", "File", "e", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "Lkotlinx/coroutines/MainCoroutineDispatcher;", "f", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "UI", "Lkotlinx/coroutines/android/HandlerDispatcher;", "g", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "SERIAL", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAIODispatchers {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildAIODispatchers f112358a = new GuildAIODispatchers();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Normal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Network;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy File;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy DB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy UI;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy SERIAL;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.guild.aio.util.GuildAIODispatchers$Normal$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new w(16));
            }
        });
        Normal = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.guild.aio.util.GuildAIODispatchers$Network$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new w(128));
            }
        });
        Network = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.guild.aio.util.GuildAIODispatchers$File$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new w(64));
            }
        });
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.guild.aio.util.GuildAIODispatchers$DB$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new w(32));
            }
        });
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<MainCoroutineDispatcher>() { // from class: com.tencent.guild.aio.util.GuildAIODispatchers$UI$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MainCoroutineDispatcher invoke() {
                return Dispatchers.getMain();
            }
        });
        UI = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<HandlerDispatcher>() { // from class: com.tencent.guild.aio.util.GuildAIODispatchers$SERIAL$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HandlerDispatcher invoke() {
                Handler serialThreadHandler = RFWThreadManager.getInstance().getSerialThreadHandler();
                Intrinsics.checkNotNullExpressionValue(serialThreadHandler, "getInstance().serialThreadHandler");
                return HandlerDispatcherKt.from$default(serialThreadHandler, null, 1, null);
            }
        });
        SERIAL = lazy6;
    }

    GuildAIODispatchers() {
    }

    @NotNull
    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) File.getValue();
    }

    @NotNull
    public final CoroutineDispatcher b() {
        return (CoroutineDispatcher) Network.getValue();
    }

    @NotNull
    public final CoroutineDispatcher c() {
        return (CoroutineDispatcher) Normal.getValue();
    }

    @NotNull
    public final HandlerDispatcher d() {
        return (HandlerDispatcher) SERIAL.getValue();
    }

    @NotNull
    public final MainCoroutineDispatcher e() {
        return (MainCoroutineDispatcher) UI.getValue();
    }
}
