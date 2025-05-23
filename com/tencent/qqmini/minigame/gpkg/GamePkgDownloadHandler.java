package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.ipc.GamePkgIPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001e2\u00020\u0001:\u0003\"/\u0012B\u000f\u0012\u0006\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u000f\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R<\u0010$\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0 j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010%R\u0014\u0010(\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler;", "", "Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler$MethodID;", "methodID", "", "errorMsg", "", "c", "", "Lkotlin/Pair;", "", "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback;", "copyCallbackList", "Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler$b;", "result", "e", "ignoreProgress", "cmdCallback", "b", "d", "f", "", "progress", "", "totalSize", h.F, "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "gameConfig", "i", "k", "g", "j", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "cmdCallbackList", "Z", "isDownloading", "Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler$b;", "pkgDownloadResult", "J", "beginDownloadTime", "Ljava/lang/String;", "appId", "<init>", "(Ljava/lang/String;)V", "MethodID", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GamePkgDownloadHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Pair<Boolean, MiniCmdCallback>> cmdCallbackList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDownloading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final b pkgDownloadResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long beginDownloadTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String appId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, GamePkgDownloadHandler> f346403f = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler$MethodID;", "", "(Ljava/lang/String;I)V", "PLUGIN_FAIL", "PLUGIN_SUCCESS", "PKG_FAIL", "PKG_SUCCESS", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public enum MethodID {
        PLUGIN_FAIL,
        PLUGIN_SUCCESS,
        PKG_FAIL,
        PKG_SUCCESS
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler$a;", "", "", "appId", "", "c", "Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler;", "b", "", "STATE_FAIL", "I", "STATE_INIT", "STATE_SUCCESS", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "appId2PkgHandlerMap", "Ljava/util/HashMap;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.gpkg.GamePkgDownloadHandler$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(String appId) {
            synchronized (GamePkgDownloadHandler.f346403f) {
            }
        }

        @NotNull
        public final GamePkgDownloadHandler b(@NotNull String appId) {
            GamePkgDownloadHandler gamePkgDownloadHandler;
            Intrinsics.checkParameterIsNotNull(appId, "appId");
            synchronized (GamePkgDownloadHandler.f346403f) {
                gamePkgDownloadHandler = (GamePkgDownloadHandler) GamePkgDownloadHandler.f346403f.get(appId);
                if (gamePkgDownloadHandler == null) {
                    gamePkgDownloadHandler = new GamePkgDownloadHandler(appId);
                    GamePkgDownloadHandler.f346403f.put(appId, gamePkgDownloadHandler);
                }
            }
            return gamePkgDownloadHandler;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0000R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\"\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler$b;", "", "", "f", "g", "a", "", "I", "b", "()I", h.F, "(I)V", "pkgDownloadState", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "pkgErrorMsg", "d", "j", "pluginDownloadSate", "e", "k", "pluginErrorMsg", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int pkgDownloadState;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int pluginDownloadSate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String pkgErrorMsg = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String pluginErrorMsg = "";

        @NotNull
        public final b a() {
            b bVar = new b();
            bVar.pkgDownloadState = this.pkgDownloadState;
            bVar.pkgErrorMsg = this.pkgErrorMsg;
            bVar.pluginDownloadSate = this.pluginDownloadSate;
            bVar.pluginErrorMsg = this.pluginErrorMsg;
            return bVar;
        }

        /* renamed from: b, reason: from getter */
        public final int getPkgDownloadState() {
            return this.pkgDownloadState;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getPkgErrorMsg() {
            return this.pkgErrorMsg;
        }

        /* renamed from: d, reason: from getter */
        public final int getPluginDownloadSate() {
            return this.pluginDownloadSate;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getPluginErrorMsg() {
            return this.pluginErrorMsg;
        }

        public final boolean f() {
            if (this.pkgDownloadState != 0 && this.pluginDownloadSate != 0) {
                return true;
            }
            return false;
        }

        public final boolean g() {
            if (this.pkgDownloadState == 2 && this.pluginDownloadSate == 2) {
                return true;
            }
            return false;
        }

        public final void h(int i3) {
            this.pkgDownloadState = i3;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.pkgErrorMsg = str;
        }

        public final void j(int i3) {
            this.pluginDownloadSate = i3;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.pluginErrorMsg = str;
        }
    }

    public GamePkgDownloadHandler(@NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        this.appId = appId;
        this.cmdCallbackList = new ArrayList<>();
        this.pkgDownloadResult = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.tencent.qqmini.minigame.gpkg.GamePkgDownloadHandler$b, T] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, java.util.ArrayList] */
    private final void c(MethodID methodID, String errorMsg) {
        QMLog.i("GamePkgDownloadHandler", "handleDownloadResult: methodId=" + methodID + ", errorMsg=" + errorMsg + ", cost=" + (System.currentTimeMillis() - this.beginDownloadTime));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        synchronized (this) {
            int i3 = com.tencent.qqmini.minigame.gpkg.b.f346450a[methodID.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.pkgDownloadResult.h(2);
                        }
                    } else {
                        this.pkgDownloadResult.h(1);
                        b bVar = this.pkgDownloadResult;
                        if (errorMsg == null) {
                            errorMsg = "";
                        }
                        bVar.i(errorMsg);
                    }
                } else {
                    this.pkgDownloadResult.j(2);
                }
            } else {
                this.pkgDownloadResult.j(1);
                b bVar2 = this.pkgDownloadResult;
                if (errorMsg == null) {
                    errorMsg = "";
                }
                bVar2.k(errorMsg);
            }
            if (!this.pkgDownloadResult.f()) {
                return;
            }
            objectRef.element = new ArrayList(this.cmdCallbackList);
            this.cmdCallbackList.clear();
            this.isDownloading = false;
            ?? a16 = this.pkgDownloadResult.a();
            objectRef2.element = a16;
            Unit unit = Unit.INSTANCE;
            e((List) objectRef.element, a16);
        }
    }

    private final void e(List<? extends Pair<Boolean, ? extends MiniCmdCallback>> copyCallbackList, b result) {
        INSTANCE.c(this.appId);
        if (result.g()) {
            Bundle bundle = new Bundle();
            bundle.putInt(GamePkgIPCConst.KEY_CMD, 3);
            Iterator<T> it = copyCallbackList.iterator();
            while (it.hasNext()) {
                c.i((MiniCmdCallback) ((Pair) it.next()).getSecond(), true, bundle);
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (result.getPkgDownloadState() == 1) {
            sb5.append("pkgDownloadErrorMsg=[" + result.getPkgErrorMsg() + ']');
        }
        if (result.getPluginDownloadSate() == 1) {
            sb5.append("pluginDownloadErrorMsg=[" + result.getPluginErrorMsg() + ']');
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(GamePkgIPCConst.KEY_CMD, 2);
        bundle2.putString(GamePkgIPCConst.KEY_ERROR_MSG, sb5.toString());
        Iterator<T> it5 = copyCallbackList.iterator();
        while (it5.hasNext()) {
            c.i((MiniCmdCallback) ((Pair) it5.next()).getSecond(), true, bundle2);
        }
    }

    public final synchronized void b(boolean ignoreProgress, @NotNull MiniCmdCallback cmdCallback) {
        Intrinsics.checkParameterIsNotNull(cmdCallback, "cmdCallback");
        this.cmdCallbackList.add(new Pair<>(Boolean.valueOf(ignoreProgress), cmdCallback));
    }

    public final synchronized boolean d() {
        return this.isDownloading;
    }

    public final synchronized void f() {
        this.isDownloading = true;
        this.beginDownloadTime = System.currentTimeMillis();
    }

    public final void g(@NotNull String errorMsg) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        c(MethodID.PKG_FAIL, errorMsg);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
    public final void h(float progress, long totalSize) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            objectRef.element = new ArrayList(this.cmdCallbackList);
            Unit unit = Unit.INSTANCE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(GamePkgIPCConst.KEY_CMD, 1);
        bundle.putFloat(GamePkgIPCConst.KEY_PROGRESS, progress);
        bundle.putLong(GamePkgIPCConst.KEY_TOTAL_FILE_SIZE, totalSize);
        for (Pair pair : (List) objectRef.element) {
            if (!((Boolean) pair.getFirst()).booleanValue()) {
                c.i((MiniCmdCallback) pair.getSecond(), true, bundle);
            }
        }
    }

    public final void i(@NotNull final MiniAppInfo gameConfig) {
        Intrinsics.checkParameterIsNotNull(gameConfig, "gameConfig");
        c(MethodID.PKG_SUCCESS, null);
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.gpkg.GamePkgDownloadHandler$onPkgDownloadSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                GameSubPkgDownloader.f346428a.e(MiniAppInfo.this);
            }
        });
    }

    public final void j(@NotNull String errorMsg) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        c(MethodID.PLUGIN_FAIL, errorMsg);
    }

    public final void k() {
        c(MethodID.PLUGIN_SUCCESS, null);
    }
}
