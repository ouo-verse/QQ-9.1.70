package com.tencent.localedit;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.Keep;
import com.tencent.localedit.fakenative.convert.FileConvertDelegate;
import com.tencent.localedit.fakenative.core.BaseManager;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x11.d;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u001c\u0010\u0015\u001a\u00020\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006,"}, d2 = {"Lcom/tencent/localedit/LocalEditSDK;", "Lu11/a;", "", "whenIdleClearCache", "Landroid/content/Context;", "context", "Lcom/tencent/localedit/c;", DownloadInfo.spKey_Config, "Lx11/c;", "logger", "Lx11/d;", "reporter", "init", "", "url", "Lt11/a;", "createController", "dispose", "", "", "map", "updateUserInfo", "updateReporter", "(Lx11/d;)Lkotlin/Unit;", "TAG", "Ljava/lang/String;", "sdkConfig", "Lcom/tencent/localedit/c;", "getSdkConfig", "()Lcom/tencent/localedit/c;", "setSdkConfig", "(Lcom/tencent/localedit/c;)V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "managers", "Ljava/util/Map;", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class LocalEditSDK extends u11.a {

    @NotNull
    private static final String TAG = "LocalEditSDK";
    public static Context applicationContext;

    @Nullable
    private static c sdkConfig;

    @NotNull
    public static final LocalEditSDK INSTANCE = new LocalEditSDK();

    @NotNull
    private static final Map<String, BaseManager> managers = new ConcurrentHashMap();

    LocalEditSDK() {
    }

    public static /* synthetic */ void init$default(LocalEditSDK localEditSDK, Context context, c cVar, x11.c cVar2, d dVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            dVar = null;
        }
        localEditSDK.init(context, cVar, cVar2, dVar);
    }

    private final void whenIdleClearCache() {
        Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.localedit.b
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean m160whenIdleClearCache$lambda4;
                m160whenIdleClearCache$lambda4 = LocalEditSDK.m160whenIdleClearCache$lambda4();
                return m160whenIdleClearCache$lambda4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: whenIdleClearCache$lambda-4, reason: not valid java name */
    public static final boolean m160whenIdleClearCache$lambda4() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new LocalEditSDK$whenIdleClearCache$1$1(null), 3, null);
        return false;
    }

    @NotNull
    public final t11.a createController(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return t11.a.INSTANCE.a(url);
    }

    @Override // u11.a, u11.b
    public void dispose() {
        super.dispose();
        managers.clear();
    }

    @NotNull
    public final Context getApplicationContext() {
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        return null;
    }

    @Nullable
    public final c getSdkConfig() {
        return sdkConfig;
    }

    public final void init(@NotNull Context context, @Nullable c config, @Nullable x11.c logger, @Nullable d reporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        setApplicationContext(context);
        if (config != null) {
            setSdkConfig(config);
        }
        if (logger != null) {
            setLogger(logger);
        }
        if (reporter != null) {
            setReporter(reporter);
        }
        super.init();
        INSTANCE.getConvert().f(new FileConvertDelegate());
        whenIdleClearCache();
    }

    public final void setApplicationContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        applicationContext = context;
    }

    public final void setSdkConfig(@Nullable c cVar) {
        sdkConfig = cVar;
    }

    @Nullable
    public final Unit updateReporter(@Nullable d reporter) {
        if (reporter == null) {
            return null;
        }
        setReporter(reporter);
        return Unit.INSTANCE;
    }

    public final void updateUserInfo(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        c cVar = sdkConfig;
        if (cVar != null) {
            cVar.b().clear();
        }
        c cVar2 = sdkConfig;
        if (cVar2 != null) {
            cVar2.b().putAll(map);
        }
    }
}
