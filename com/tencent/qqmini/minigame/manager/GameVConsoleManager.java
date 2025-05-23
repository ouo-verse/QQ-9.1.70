package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.manager.GameVConsoleManager;
import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.ui.VConsoleView;
import com.tencent.qqmini.minigame.utils.ConsoleLogRecorder;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u000201B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\u0005R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager;", "Lcom/tencent/qqmini/minigame/ui/VConsoleDragView$Listener;", "Landroid/os/Handler$Callback;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "k", "g", "", "level", "msg", "logContent", DomainData.DOMAIN_NAME, "Ljava/io/File;", "j", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "appContext", h.F, "onVConsoleMoveUp", "Landroid/os/Message;", "", "handleMessage", "l", "Lcom/tencent/qqmini/minigame/utils/ConsoleLogRecorder;", "d", "Lcom/tencent/qqmini/minigame/utils/ConsoleLogRecorder;", "logRecorder", "e", "Landroid/view/ViewGroup;", "gameRootView", "Lcom/tencent/qqmini/minigame/ui/VConsoleDragView;", "f", "Lcom/tencent/qqmini/minigame/ui/VConsoleDragView;", "vConsoleDragView", "Lcom/tencent/qqmini/minigame/ui/VConsoleView;", "Lcom/tencent/qqmini/minigame/ui/VConsoleView;", "vConsoleView", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "logHandler", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "mConsoleParent", "<init>", "()V", "E", "a", "ReadDebugEnableTask", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameVConsoleManager implements VConsoleDragView.Listener, Handler.Callback {
    private static final Lazy C;
    private static GameVConsoleManager D;

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConsoleLogRecorder logRecorder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup gameRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private VConsoleDragView vConsoleDragView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private VConsoleView vConsoleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Handler logHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mConsoleParent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager$ReadDebugEnableTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager;", "d", "Ljava/lang/ref/WeakReference;", "managerRef", "Landroid/view/ViewGroup;", "e", "rootViewRef", "", "f", "Ljava/lang/String;", "appId", "manager", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager;Landroid/view/ViewGroup;Ljava/lang/String;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    private static final class ReadDebugEnableTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<GameVConsoleManager> managerRef;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ViewGroup> rootViewRef;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final String appId;

        public ReadDebugEnableTask(@NotNull GameVConsoleManager manager, @NotNull ViewGroup rootView, @NotNull String appId) {
            Intrinsics.checkParameterIsNotNull(manager, "manager");
            Intrinsics.checkParameterIsNotNull(rootView, "rootView");
            Intrinsics.checkParameterIsNotNull(appId, "appId");
            this.appId = appId;
            this.managerRef = new WeakReference<>(manager);
            this.rootViewRef = new WeakReference<>(rootView);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!DebugUtil.getDebugEnabled(this.appId)) {
                QMLog.i("GameVConsoleManager", "ReadDebugEnableTask: " + this.appId + " debug not enable.");
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.GameVConsoleManager$ReadDebugEnableTask$run$1
                @Override // java.lang.Runnable
                public final void run() {
                    WeakReference weakReference;
                    WeakReference weakReference2;
                    weakReference = GameVConsoleManager.ReadDebugEnableTask.this.managerRef;
                    GameVConsoleManager gameVConsoleManager = (GameVConsoleManager) weakReference.get();
                    weakReference2 = GameVConsoleManager.ReadDebugEnableTask.this.rootViewRef;
                    ViewGroup viewGroup = (ViewGroup) weakReference2.get();
                    if (gameVConsoleManager != null && viewGroup != null) {
                        gameVConsoleManager.k(viewGroup);
                    } else {
                        QMLog.e("GameVConsoleManager", "ReadDebugEnableTask: manager or rootView has been recycle");
                    }
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager$a;", "", "", "level", "", "message", "", "f", "a", "logContent", "e", "logMsg", "d", "Ljava/io/File;", "b", "", "isDebug$delegate", "Lkotlin/Lazy;", "c", "()Z", "isDebug", "JS_LOG_PREFIX_TAG", "Ljava/lang/String;", "KEY_COMPOSE_LOG", "KEY_CONTENT", "KEY_LEVEL", "LEVEL_DEBUG", "I", "LEVEL_ERROR", "LEVEL_ERROR_STR", "LEVEL_INFO", "LEVEL_INFO_STR", "LEVEL_LOG", "LEVEL_LOG_STR", "LEVEL_WARN", "LEVEL_WARN_STR", "MSG_PRINT_LOG", "TAG", "Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager;", "sInstance", "Lcom/tencent/qqmini/minigame/manager/GameVConsoleManager;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.manager.GameVConsoleManager$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        private final String a(int level) {
            if (level != 2) {
                if (level != 3) {
                    if (level != 4) {
                        return "log";
                    }
                    return "error";
                }
                return "warn";
            }
            return "info";
        }

        private final boolean c() {
            return ((Boolean) GameVConsoleManager.C.getValue()).booleanValue();
        }

        private final void f(int level, String message) {
            if (level != 0 && level != 1) {
                if (level != 2) {
                    if (level != 3) {
                        if (level == 4) {
                            QMLog.e("[minigame][js-console]", message);
                            return;
                        }
                        return;
                    }
                    QMLog.w("[minigame][js-console]", message);
                    return;
                }
                if (QMLog.isColorLevel()) {
                    QMLog.i("[minigame][js-console]", message);
                    return;
                }
                return;
            }
            if (c()) {
                QMLog.d("[minigame][js-console]", message);
            }
        }

        @JvmStatic
        @Nullable
        public final File b() {
            GameVConsoleManager gameVConsoleManager = GameVConsoleManager.D;
            if (gameVConsoleManager != null) {
                return gameVConsoleManager.j();
            }
            return null;
        }

        @JvmStatic
        public final void d(@NotNull String logMsg) {
            Intrinsics.checkParameterIsNotNull(logMsg, "logMsg");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", 4);
                jSONObject.put("logs", logMsg);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "logJson.toString()");
                e(jSONObject2);
            } catch (Exception e16) {
                QMLog.e("GameVConsoleManager", "printErrorJsConsoleLog: logMsg=" + logMsg, e16);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:3:0x0006, B:6:0x001e, B:14:0x002b, B:16:0x0034), top: B:2:0x0006 }] */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(@NotNull String logContent) {
            boolean z16;
            Intrinsics.checkParameterIsNotNull(logContent, "logContent");
            try {
                JSONObject jSONObject = new JSONObject(logContent);
                int optInt = jSONObject.optInt("level", -1);
                String optString = jSONObject.optString("logs");
                if (optInt != -1) {
                    if (optString != null && optString.length() != 0) {
                        z16 = false;
                        if (z16) {
                            f(optInt, optString);
                            GameVConsoleManager gameVConsoleManager = GameVConsoleManager.D;
                            if (gameVConsoleManager != null) {
                                gameVConsoleManager.n(a(optInt), optString, logContent);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
            } catch (Exception e16) {
                QMLog.e("GameVConsoleManager", "printJsConsoleLog: parse log failed, log=" + logContent, e16);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VConsoleView f346528e;

        b(VConsoleView vConsoleView) {
            this.f346528e = vConsoleView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f346528e.setVisibility(8);
            VConsoleDragView vConsoleDragView = GameVConsoleManager.this.vConsoleDragView;
            if (vConsoleDragView != null) {
                vConsoleDragView.bringToFront();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqmini.minigame.manager.GameVConsoleManager$Companion$isDebug$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                Object obj = ProxyManager.get(MiniAppProxy.class);
                Intrinsics.checkExpressionValueIsNotNull(obj, "ProxyManager.get(MiniAppProxy::class.java)");
                return ((MiniAppProxy) obj).isDebugVersion();
            }
        });
        C = lazy;
    }

    private final void g() {
        QMLog.i("GameVConsoleManager", "addConsoleView");
        ViewGroup viewGroup = this.gameRootView;
        if (viewGroup != null) {
            VConsoleView vConsoleView = new VConsoleView(viewGroup.getContext());
            vConsoleView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            viewGroup.addView(vConsoleView);
            vConsoleView.setVisibility(8);
            vConsoleView.setOnGapAreaClickListener(new b(vConsoleView));
            vConsoleView.bringToFront();
            this.vConsoleView = vConsoleView;
            VConsoleDragView vConsoleDragView = this.vConsoleDragView;
            if (vConsoleDragView != null) {
                vConsoleDragView.bringToFront();
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final File i() {
        return INSTANCE.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File j() {
        ConsoleLogRecorder consoleLogRecorder = this.logRecorder;
        if (consoleLogRecorder != null) {
            consoleLogRecorder.f();
            return consoleLogRecorder.getMLogFile();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(ViewGroup rootView) {
        QMLog.i("GameVConsoleManager", "initVConsoleManager: enable");
        GameVConsoleManager gameVConsoleManager = D;
        if (gameVConsoleManager != null) {
            gameVConsoleManager.l();
        }
        D = this;
        this.logRecorder = new ConsoleLogRecorder();
        this.gameRootView = rootView;
        VConsoleDragView vConsoleDragView = new VConsoleDragView(rootView.getContext());
        vConsoleDragView.setImageResource(R.drawable.mini_sdk_game_vconsole);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(rootView.getContext(), 90.0f), -2);
        layoutParams.gravity = 85;
        layoutParams.setMargins(0, 0, DisplayUtil.dip2px(rootView.getContext(), 12.0f), DisplayUtil.dip2px(rootView.getContext(), 12.0f));
        vConsoleDragView.setLayoutParams(layoutParams);
        vConsoleDragView.setListener(this);
        rootView.setVisibility(0);
        rootView.addView(vConsoleDragView);
        vConsoleDragView.setVisibility(0);
        vConsoleDragView.bringToFront();
        this.vConsoleDragView = vConsoleDragView;
        g();
    }

    @JvmStatic
    public static final void m(@NotNull String str) {
        INSTANCE.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String level, String msg2, String logContent) {
        Handler handler = this.logHandler;
        if (handler == null) {
            HandlerThread subThread = ThreadManager.getSubThread();
            Intrinsics.checkExpressionValueIsNotNull(subThread, "ThreadManager.getSubThread()");
            handler = new Handler(subThread.getLooper(), this);
            this.logHandler = handler;
        }
        Message message = handler.obtainMessage();
        message.what = 1;
        Intrinsics.checkExpressionValueIsNotNull(message, "message");
        Bundle bundle = new Bundle();
        bundle.putString("level", level);
        bundle.putString("logs", msg2);
        bundle.putString("composeLog", logContent);
        message.setData(bundle);
        message.sendToTarget();
    }

    public final void h(@Nullable ViewGroup rootView, @Nullable IMiniAppContext appContext) {
        String str;
        boolean z16;
        MiniAppInfo miniAppInfo;
        if (appContext != null && (miniAppInfo = appContext.getMiniAppInfo()) != null) {
            str = miniAppInfo.appId;
        } else {
            str = null;
        }
        if (rootView != null) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                FrameLayout frameLayout = this.mConsoleParent;
                if (frameLayout != null) {
                    rootView.removeView(frameLayout);
                }
                FrameLayout frameLayout2 = new FrameLayout(rootView.getContext());
                this.mConsoleParent = frameLayout2;
                frameLayout2.setVisibility(8);
                rootView.addView(this.mConsoleParent);
                FrameLayout frameLayout3 = this.mConsoleParent;
                if (frameLayout3 == null) {
                    Intrinsics.throwNpe();
                }
                ThreadManager.runIOTask(new ReadDebugEnableTask(this, frameLayout3, str));
                return;
            }
        }
        QMLog.e("GameVConsoleManager", "attachWindow: appId or rootView is empty.");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        if (msg2.what == 1) {
            Bundle data = msg2.getData();
            if (data != null) {
                String string = data.getString("level");
                String string2 = data.getString("logs");
                String string3 = data.getString("composeLog");
                if (string != null && string.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (string2 != null && string2.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        if (string3 != null && string3.length() != 0) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (!z18) {
                            ConsoleLogRecorder consoleLogRecorder = this.logRecorder;
                            if (consoleLogRecorder != null) {
                                consoleLogRecorder.h(string, string2);
                            }
                            VConsoleView vConsoleView = this.vConsoleView;
                            if (vConsoleView != null) {
                                vConsoleView.printLogToVConsole(string3);
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void l() {
        if (Intrinsics.areEqual(D, this)) {
            D = null;
        }
        Handler handler = this.logHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VConsoleView vConsoleView = this.vConsoleView;
        if (vConsoleView != null) {
            vConsoleView.onDestroy();
        }
    }

    @Override // com.tencent.qqmini.minigame.ui.VConsoleDragView.Listener
    public void onVConsoleMoveUp() {
        VConsoleView vConsoleView = this.vConsoleView;
        if (vConsoleView != null && vConsoleView.getVisibility() == 8) {
            VConsoleView vConsoleView2 = this.vConsoleView;
            if (vConsoleView2 != null) {
                vConsoleView2.setVisibility(0);
            }
            VConsoleView vConsoleView3 = this.vConsoleView;
            if (vConsoleView3 != null) {
                vConsoleView3.bringToFront();
            }
        } else {
            VConsoleView vConsoleView4 = this.vConsoleView;
            if (vConsoleView4 != null) {
                vConsoleView4.setVisibility(8);
            }
        }
        VConsoleDragView vConsoleDragView = this.vConsoleDragView;
        if (vConsoleDragView != null) {
            vConsoleDragView.bringToFront();
        }
    }
}
