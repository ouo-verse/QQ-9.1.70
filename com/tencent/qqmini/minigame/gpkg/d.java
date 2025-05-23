package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.GamePkgIPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0017j\b\u0012\u0004\u0012\u00020\b`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/d;", "", "", "isSuccess", "", "pathOrError", "", "e", "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback;", "cmdCallback", "b", "c", "d", "subPkgName", "subPkgPath", h.F, "errorMsg", "f", "", "progress", "", "totalFileSize", "g", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "cmdCallbackList", "Z", "isDownloading", "J", "startDownloadTime", "Ljava/lang/String;", "key", "<init>", "(Ljava/lang/String;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<MiniCmdCallback> cmdCallbackList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDownloading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long startDownloadTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String key;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<String, d> f346452e = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/d$a;", "", "", "key", "", "c", "Lcom/tencent/qqmini/minigame/gpkg/d;", "b", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "key2HandlerMap", "Ljava/util/HashMap;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.gpkg.d$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(String key) {
            synchronized (d.f346452e) {
            }
        }

        @NotNull
        public final d b(@NotNull String key) {
            d dVar;
            Intrinsics.checkParameterIsNotNull(key, "key");
            synchronized (d.f346452e) {
                dVar = (d) d.f346452e.get(key);
                if (dVar == null) {
                    dVar = new d(key);
                    d.f346452e.put(key, dVar);
                }
            }
            return dVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.key = key;
        this.cmdCallbackList = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.ArrayList] */
    private final void e(boolean isSuccess, String pathOrError) {
        INSTANCE.c(this.key);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            objectRef.element = new ArrayList(this.cmdCallbackList);
            this.cmdCallbackList.clear();
            this.isDownloading = false;
            Unit unit = Unit.INSTANCE;
        }
        Bundle bundle = new Bundle();
        if (isSuccess) {
            bundle.putInt(GamePkgIPCConst.KEY_CMD, 3);
            bundle.putString(GamePkgIPCConst.KEY_SUB_PKG_PATH, pathOrError);
        } else {
            bundle.putInt(GamePkgIPCConst.KEY_CMD, 2);
            bundle.putString(GamePkgIPCConst.KEY_ERROR_MSG, pathOrError);
        }
        Iterator it = ((ArrayList) objectRef.element).iterator();
        while (it.hasNext()) {
            c.i((MiniCmdCallback) it.next(), true, bundle);
        }
    }

    public final synchronized void b(@NotNull MiniCmdCallback cmdCallback) {
        Intrinsics.checkParameterIsNotNull(cmdCallback, "cmdCallback");
        this.cmdCallbackList.add(cmdCallback);
    }

    public final synchronized boolean c() {
        return this.isDownloading;
    }

    public final synchronized void d() {
        this.isDownloading = true;
        this.startDownloadTime = System.currentTimeMillis();
    }

    public final void f(@NotNull String errorMsg) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        e(false, errorMsg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
    public final void g(float progress, long totalFileSize) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            objectRef.element = new ArrayList(this.cmdCallbackList);
            Unit unit = Unit.INSTANCE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(GamePkgIPCConst.KEY_CMD, 1);
        bundle.putFloat(GamePkgIPCConst.KEY_PROGRESS, progress);
        bundle.putLong(GamePkgIPCConst.KEY_TOTAL_FILE_SIZE, totalFileSize);
        Iterator it = ((ArrayList) objectRef.element).iterator();
        while (it.hasNext()) {
            c.i((MiniCmdCallback) it.next(), true, bundle);
        }
    }

    public final void h(@NotNull String subPkgName, @NotNull String subPkgPath) {
        Intrinsics.checkParameterIsNotNull(subPkgName, "subPkgName");
        Intrinsics.checkParameterIsNotNull(subPkgPath, "subPkgPath");
        QMLog.i("GameSubPkgDownloadHandler", subPkgName + " download success cost=" + (System.currentTimeMillis() - this.startDownloadTime));
        e(true, subPkgPath);
    }
}
