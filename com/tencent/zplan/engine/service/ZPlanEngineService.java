package com.tencent.zplan.engine.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.ue4.GameActivity;
import com.epicgames.ue4.GameActivityBase;
import com.epicgames.ue4.GameActivityNative;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.GraphicBuffer;
import com.epicgames.ue4.IUEAppStatus;
import com.epicgames.ue4.UE4;
import com.epicgames.ue4.UEAppStatusManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.zplan.IZPlanEngineStatusCallback;
import com.tencent.zplan.IZPlanEnterSceneCallback;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.IZPlanWorldCallback;
import com.tencent.zplan.common.soloader.c;
import com.tencent.zplan.common.soloader.p017default.InternalSoLoader;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.ZPlanUsingTrack;
import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.h;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.RemoteRegisterHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.luabridge.plugins.DatongReportPlugin;
import com.tencent.zplan.luabridge.plugins.FirstFramePlugin;
import com.tencent.zplan.luabridge.plugins.FriendPlugin;
import com.tencent.zplan.luabridge.plugins.SharePlugin;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.record.ZPlanMemeHelper;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.utils.ZPlanConstant;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.manager.IZPlanWorldListener;
import com.tencent.zplan.world.manager.ZPlanWorldManager;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.world.model.ZPlanWorld;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import lx4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import zx4.j;
import zx4.k;
import zx4.m;
import zx4.r;
import zx4.s;

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0003=AE\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002KLB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002R\u0018\u0010#\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010+0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u000207028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00105R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020:028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/zplan/engine/service/ZPlanEngineService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "", "onCreate", "", WadlProxyConsts.FLAGS, "startId", "onStartCommand", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onRebind", "", "onUnbind", "onLowMemory", "level", "onTrimMemory", "Y", "Landroid/os/Handler;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "b0", ExifInterface.LATITUDE_SOUTH, "success", "X", BdhLogUtil.LogTag.Tag_Req, "V", "U", "T", "W", "a0", "d", "Landroid/os/Handler;", "uiHandler", "e", "needInitWindow", "Landroid/view/Surface;", "f", "Landroid/view/Surface;", "initSurface", "", "Lcom/epicgames/ue4/GraphicBuffer;", tl.h.F, "Ljava/util/Map;", "mInBuffers", "i", "Lcom/epicgames/ue4/GraphicBuffer;", "mOutBuffer", "Landroid/os/RemoteCallbackList;", "Lcom/tencent/zplan/IZPlanEngineStatusCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/RemoteCallbackList;", "zPlanEngineStatusCallbacks", "Lcom/tencent/zplan/IZPlanWorldCallback;", BdhLogUtil.LogTag.Tag_Conn, "zPlanWorldCallbacks", "Lcom/tencent/zplan/IZPlanEnterSceneCallback;", "D", "zPlanWorldStatusCallbacks", "com/tencent/zplan/engine/service/ZPlanEngineService$d", "E", "Lcom/tencent/zplan/engine/service/ZPlanEngineService$d;", "firstFrameListener", "com/tencent/zplan/engine/service/ZPlanEngineService$c", UserInfo.SEX_FEMALE, "Lcom/tencent/zplan/engine/service/ZPlanEngineService$c;", "engineListener", "com/tencent/zplan/engine/service/ZPlanEngineService$b", "G", "Lcom/tencent/zplan/engine/service/ZPlanEngineService$b;", "engineErrorListener", "<init>", "()V", "a", "ZPlanServiceBinder", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanEngineService extends Service {
    private static volatile boolean I;
    private static volatile boolean J;
    private static volatile boolean K;
    private static volatile boolean L;
    private static volatile boolean M;

    @Nullable
    private static volatile Runnable N;
    private static volatile int Q;

    @Nullable
    private static final Method R;

    @Nullable
    private static final Method S;

    @Nullable
    private static final Method T;

    @Nullable
    private static final Method U;

    @Nullable
    private static final Method V;

    @Nullable
    private static final Method W;

    @Nullable
    private static final Method X;

    @Nullable
    private static final Method Y;

    @Nullable
    private static final Method Z;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private static final Method f385586a0;

    /* renamed from: C, reason: from kotlin metadata */
    private final RemoteCallbackList<IZPlanWorldCallback> zPlanWorldCallbacks;

    /* renamed from: D, reason: from kotlin metadata */
    private final RemoteCallbackList<IZPlanEnterSceneCallback> zPlanWorldStatusCallbacks;

    /* renamed from: E, reason: from kotlin metadata */
    private final d firstFrameListener;

    /* renamed from: F, reason: from kotlin metadata */
    private c engineListener;

    /* renamed from: G, reason: from kotlin metadata */
    private b engineErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needInitWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Surface initSurface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, GraphicBuffer> mInBuffers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GraphicBuffer mOutBuffer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RemoteCallbackList<IZPlanEngineStatusCallback> zPlanEngineStatusCallbacks;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AtomicInteger H = new AtomicInteger(0);
    private static volatile int P = -1;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R$\u0010%\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020+8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001c\u00106\u001a\u0004\u0018\u0001058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u0001058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109R\u001c\u0010<\u001a\u0004\u0018\u0001058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u00109R\u0014\u0010?\u001a\u00020>8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006E"}, d2 = {"Lcom/tencent/zplan/engine/service/ZPlanEngineService$a;", "", "", "Lorg/json/JSONArray;", "y", "", "g", "c", "k", "processName", "isUsing", "", "w", "Ljava/util/concurrent/atomic/AtomicInteger;", "enterAvatarSceneIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "i", "()Ljava/util/concurrent/atomic/AtomicInteger;", "engineInitializing", "Z", "f", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "engineInitDone", "e", "r", "enginePurged", tl.h.F, "t", "engineActive", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isEnginePurging", "p", "u", "Ljava/lang/Runnable;", "destroyRunnable", "Ljava/lang/Runnable;", "b", "()Ljava/lang/Runnable;", "setDestroyRunnable$zplan_debug", "(Ljava/lang/Runnable;)V", "", "firstFrameViewType", "I", "j", "()I", "v", "(I)V", "zplanEngineStatus", "o", HippyTKDListViewAdapter.X, "Ljava/lang/reflect/Method;", "METHOD_GET_WORLD", "Ljava/lang/reflect/Method;", "l", "()Ljava/lang/reflect/Method;", "METHOD_WORLD_ENTER_SCENE_RET", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "METHOD_WORLD_FIRST_FRAME", DomainData.DOMAIN_NAME, "", "DESTROY_ENGINE_DELAY_TIME", "J", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.engine.service.ZPlanEngineService$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JSONArray y(String str) {
            List<String> split$default;
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            JSONArray jSONArray = new JSONArray();
            if (!split$default.isEmpty()) {
                for (String str2 : split$default) {
                    try {
                        jSONArray.mo162put(str2);
                    } catch (Exception e16) {
                        ZLog.f386189b.e("[zplan][ZPlanEngineService]", 1, "uinArray put " + str2 + ", exception", e16);
                    }
                }
            }
            return jSONArray;
        }

        @Nullable
        public final Runnable b() {
            return ZPlanEngineService.N;
        }

        public final boolean c() {
            return d();
        }

        public final boolean d() {
            return ZPlanEngineService.L;
        }

        public final boolean e() {
            return ZPlanEngineService.J;
        }

        public final boolean f() {
            return ZPlanEngineService.I;
        }

        public final boolean g() {
            return h();
        }

        public final boolean h() {
            return ZPlanEngineService.K;
        }

        @NotNull
        public final AtomicInteger i() {
            return ZPlanEngineService.H;
        }

        public final int j() {
            return ZPlanEngineService.P;
        }

        public final boolean k() {
            return ZPlanUsingTrack.f385555c.g();
        }

        @Nullable
        public final Method l() {
            return ZPlanEngineService.Y;
        }

        @Nullable
        public final Method m() {
            return ZPlanEngineService.Z;
        }

        @Nullable
        public final Method n() {
            return ZPlanEngineService.f385586a0;
        }

        public final int o() {
            return ZPlanEngineService.Q;
        }

        public final boolean p() {
            return ZPlanEngineService.M;
        }

        public final void q(boolean z16) {
            ZPlanEngineService.L = z16;
        }

        public final void r(boolean z16) {
            ZPlanEngineService.J = z16;
        }

        public final void s(boolean z16) {
            ZPlanEngineService.I = z16;
        }

        public final void t(boolean z16) {
            ZPlanEngineService.K = z16;
        }

        public final void u(boolean z16) {
            ZPlanEngineService.M = z16;
        }

        public final void v(int i3) {
            ZPlanEngineService.P = i3;
        }

        public final void w(@NotNull String processName, boolean isUsing) {
            Intrinsics.checkNotNullParameter(processName, "processName");
            ZPlanUsingTrack.f385555c.k(processName, isUsing);
        }

        public final void x(int i3) {
            ZPlanEngineService.Q = i3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$b", "Lcom/epicgames/ue4/UE4$ErrorListener;", "", "code", "", "onError", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements UE4.ErrorListener {
        b() {
        }

        @Override // com.epicgames.ue4.UE4.ErrorListener
        public void onError(int code) {
            ZPlanConstant.a.Companion companion = ZPlanConstant.a.INSTANCE;
            Integer num = companion.b().get(Integer.valueOf(code));
            com.tencent.zplan.utils.e.f386205a.a("[zplan][error]", num, companion.a().get(num));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$c", "Lcom/epicgames/ue4/UE4$EngineListener;", "", "success", "", "onEngineInited", "onEngineActivated", "onEngineSuspended", "onEnginePurging", "onEnginePurged", "onEngineRecovering", "onEngineRecovered", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements UE4.EngineListener {
        c() {
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEngineActivated() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onEngineActivated");
            Companion companion = ZPlanEngineService.INSTANCE;
            companion.x(2);
            companion.q(true);
            ZPlanWorldManager.f386245m.E();
            ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEngineInited(boolean success) {
            ZLog zLog = ZLog.f386189b;
            zLog.k("[zplan][ZPlanEngineService]", "onEngineInited " + success);
            EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine_zplan_process", "on_engine_init_zplan", null, 4, null);
            ZPlanEngineService.INSTANCE.x(1);
            Surface surface = ZPlanEngineService.this.initSurface;
            if (surface != null) {
                zLog.k("[zplan][ZPlanEngineService]", "onEngineInited, set main world window.");
                ZPlanWorldManager.f386245m.a0(0, surface);
            }
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEnginePurged() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onEnginePurged");
            Companion companion = ZPlanEngineService.INSTANCE;
            companion.x(5);
            ZPlanEngineService.this.U();
            companion.t(true);
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEnginePurging() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onEnginePurging");
            ZPlanEngineService.INSTANCE.x(4);
            ZPlanEngineService.this.V();
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEngineRecovered() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onEngineRecovered");
            Companion companion = ZPlanEngineService.INSTANCE;
            companion.x(7);
            companion.t(false);
            ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEngineRecovering() {
            ZPlanEngineService.INSTANCE.x(6);
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onEngineRecovering");
        }

        @Override // com.epicgames.ue4.UE4.EngineListener
        public void onEngineSuspended() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onEngineSuspended");
            Companion companion = ZPlanEngineService.INSTANCE;
            companion.x(3);
            companion.q(false);
            ZPlanEngineService.this.W();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$d", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "", "event", "Lorg/json/JSONObject;", "params", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements FirstFramePlugin.b {
        d() {
        }

        @Override // com.tencent.zplan.luabridge.plugins.FirstFramePlugin.b
        public void a(@NotNull String event, @NotNull JSONObject params) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
            ZPlanEngineService.this.T();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$e", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "", "success", "", "onEngineInitFinish", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class e implements GameActivityThunk.CMShowEngineInitFinishListener {
        e() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
        public void onEngineInitFinish(boolean success) {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "UE4 engine init result:" + success);
            Companion companion = ZPlanEngineService.INSTANCE;
            companion.r(success);
            companion.s(false);
            ZPlanEngineService.this.a0();
            ZPlanEngineService.this.X(success);
            ZPlanMonitor.f385621i.c();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$f", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineFirstFrameListener;", "", "onFirstFrame", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class f implements GameActivityThunk.CMShowEngineFirstFrameListener {
        f() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineFirstFrameListener
        public void onFirstFrame() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "UE4 engine onEngineFirstFrame");
            ZPlanEngineService.this.S();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$g", "Lsx4/b;", "", StateEvent.ProcessResult.SUCCEED, "", "onSDKInited", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class g implements sx4.b {
        g() {
        }

        @Override // sx4.b
        public void onSDKInited(boolean succeed) {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onSDKInited " + succeed);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$h", "Lcom/epicgames/ue4/GameActivityBase$SingletonListener;", "Landroid/content/Context;", "context", "Lcom/epicgames/ue4/GameActivityBase;", OperateCustomButton.OPERATE_CREATE, "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class h implements GameActivityBase.SingletonListener {
        h() {
        }

        @Override // com.epicgames.ue4.GameActivityBase.SingletonListener
        @NotNull
        public GameActivityBase create(@Nullable Context context) {
            GameActivityBase CreateSingleton = GameActivity.CreateSingleton(context);
            Intrinsics.checkNotNullExpressionValue(CreateSingleton, "GameActivity.CreateSingleton(context)");
            return CreateSingleton;
        }
    }

    static {
        com.tencent.zplan.common.utils.g gVar = com.tencent.zplan.common.utils.g.f385293a;
        Class<? extends Object> cls = Boolean.TYPE;
        R = gVar.a(IZPlanEngineStatusCallback.class, "onEngineInitFinish", cls);
        S = gVar.a(IZPlanEngineStatusCallback.class, "onEngineFirstFrame", new Class[0]);
        T = gVar.a(IZPlanEngineStatusCallback.class, "onEngineDestroyed", new Class[0]);
        U = gVar.a(IZPlanEngineStatusCallback.class, "onEnginePurging", new Class[0]);
        V = gVar.a(IZPlanEngineStatusCallback.class, "onEnginePurged", new Class[0]);
        W = gVar.a(IZPlanEngineStatusCallback.class, "onEngineInversePurged", new Class[0]);
        X = gVar.a(IZPlanEngineStatusCallback.class, "onEngineSuspended", new Class[0]);
        Y = gVar.a(IZPlanWorldCallback.class, "onGetZPlanWorld", ZPlanWorld.class);
        Z = gVar.a(IZPlanEnterSceneCallback.class, "onEnterSceneResult", cls);
        f385586a0 = gVar.a(IZPlanEnterSceneCallback.class, "onFirstFrame", FirstFrameResult.class);
    }

    public ZPlanEngineService() {
        try {
            System.loadLibrary("c++_shared");
        } catch (Throwable th5) {
            ZLog.f386189b.g("ZPlanEngineService", "load c++_shared error!", th5);
            j jVar = (j) mx4.a.f417748a.a(j.class);
            if (jVar != null) {
                jVar.a("c++_shared");
            }
        }
        this.needInitWindow = true;
        this.mInBuffers = new LinkedHashMap();
        this.zPlanEngineStatusCallbacks = new RemoteCallbackList<>();
        this.zPlanWorldCallbacks = new RemoteCallbackList<>();
        this.zPlanWorldStatusCallbacks = new RemoteCallbackList<>();
        this.firstFrameListener = new d();
        this.engineListener = new c();
        this.engineErrorListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Handler Q() {
        Handler handler;
        if (this.uiHandler == null) {
            this.uiHandler = new Handler(Looper.getMainLooper());
        }
        handler = this.uiHandler;
        Intrinsics.checkNotNull(handler);
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        Method method = T;
        if (method != null) {
            com.tencent.zplan.utils.f.b(com.tencent.zplan.utils.f.f386206a, this.zPlanEngineStatusCallbacks, method, null, new Object[0], 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        Method method = S;
        if (method != null) {
            com.tencent.zplan.utils.f.b(com.tencent.zplan.utils.f.f386206a, this.zPlanEngineStatusCallbacks, method, null, new Object[0], 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        Method method = W;
        if (method != null) {
            com.tencent.zplan.utils.f.b(com.tencent.zplan.utils.f.f386206a, this.zPlanEngineStatusCallbacks, method, null, new Object[0], 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        Method method = V;
        if (method != null) {
            com.tencent.zplan.utils.f.b(com.tencent.zplan.utils.f.f386206a, this.zPlanEngineStatusCallbacks, method, null, new Object[0], 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        Method method = U;
        if (method != null) {
            com.tencent.zplan.utils.f.b(com.tencent.zplan.utils.f.f386206a, this.zPlanEngineStatusCallbacks, method, null, new Object[0], 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        Method method = X;
        if (method != null) {
            com.tencent.zplan.utils.f.b(com.tencent.zplan.utils.f.f386206a, this.zPlanEngineStatusCallbacks, method, null, new Object[0], 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(boolean success) {
        Method method = R;
        if (method != null) {
            com.tencent.zplan.utils.f.f386206a.a(this.zPlanEngineStatusCallbacks, method, null, Boolean.valueOf(success));
        }
    }

    private final void Y() {
        lx4.f fVar = (lx4.f) mx4.a.f417748a.a(lx4.f.class);
        if (fVar != null) {
            f.a.b(fVar, new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$initConfig$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    String m3;
                    try {
                        zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
                        String str2 = "";
                        if (dVar == null || (str = dVar.e()) == null) {
                            str = "";
                        }
                        if (dVar != null && (m3 = dVar.m()) != null) {
                            str2 = m3;
                        }
                        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "initConfig, startUpExtraConfig= " + str + ", ue4SwitchConfig= " + str2);
                        UE4.setStartupConfigureExtra(str);
                        UE4.setEmbeddedStartupConfigure(str2);
                    } catch (Throwable th5) {
                        ZLog.f386189b.l("[zplan][ZPlanEngineService]", "initConfig error", th5);
                    }
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        com.tencent.zplan.engine.service.c.INSTANCE.a(new e());
        com.tencent.zplan.engine.service.b.INSTANCE.a(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        List<LuaBasePlugin> a16;
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "initPluginAfterEngineInitFinish");
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        zPlanLuaBridge.registerPlugin(FirstFramePlugin.f385718f);
        zPlanLuaBridge.registerPlugin(ZPlanMemeHelper.f385999s.q());
        zPlanLuaBridge.registerPlugin(com.tencent.zplan.luabridge.plugins.a.f385727e);
        zPlanLuaBridge.registerPlugin(new FriendPlugin());
        zPlanLuaBridge.registerPlugin(new SharePlugin());
        zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.g());
        zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.h());
        zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.b());
        zPlanLuaBridge.registerPlugin(new DatongReportPlugin());
        zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.e());
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.f(applicationContext));
        mx4.a aVar = mx4.a.f417748a;
        zx4.d dVar = (zx4.d) aVar.a(zx4.d.class);
        if (dVar != null && dVar.a()) {
            zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.c());
        }
        zPlanLuaBridge.registerPlugin(new com.tencent.zplan.luabridge.plugins.d());
        zx4.h hVar = (zx4.h) aVar.a(zx4.h.class);
        if (hVar != null && (a16 = hVar.a()) != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                ZPlanLuaBridge.INSTANCE.registerPlugin((LuaBasePlugin) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        Boolean bool;
        mx4.a aVar = mx4.a.f417748a;
        r rVar = (r) aVar.a(r.class);
        if (rVar != null) {
            bool = Boolean.valueOf(rVar.isSDKReady());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "isSuperPlayerReady " + bool);
            return;
        }
        ZLog.f386189b.f("[zplan][ZPlanEngineService]", "isSuperPlayerReady " + bool);
        r rVar2 = (r) aVar.a(r.class);
        if (rVar2 != null) {
            rVar2.a(new g());
        }
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@Nullable Intent intent) {
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onBind");
        EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine_zplan_process", "service_bnind_zplan", null, 4, null);
        return new ZPlanServiceBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine_zplan_process", "service_create_zplan", null, 4, null);
        c.Companion companion = com.tencent.zplan.common.soloader.c.INSTANCE;
        companion.f("debug", new Function0<com.tencent.zplan.common.soloader.b>() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.zplan.common.soloader.b invoke() {
                Context baseContext = ZPlanEngineService.this.getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
                return new com.tencent.zplan.common.soloader.p017default.a(baseContext);
            }
        });
        companion.e("internal", InternalSoLoader.INSTANCE.a());
        companion.b("UE4");
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine_zplan_process", "service_create_load_ue4_zplan", null, 4, null);
        GameActivityBase.singletonListener = new h();
        UEAppStatusManager.getInstance().setUEAppStatus((IUEAppStatus) mx4.a.f417748a.a(k.class));
        Y();
        ZPlanMonitor.f385621i.d();
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onDestroy executeComputeJob destroyRunable");
        lx4.f fVar = (lx4.f) mx4.a.f417748a.a(lx4.f.class);
        if (fVar != null) {
            runnable = fVar.c(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$onDestroy$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEngineService.Companion companion = ZPlanEngineService.INSTANCE;
                    boolean k3 = companion.k();
                    ZLog zLog = ZLog.f386189b;
                    zLog.k("[zplan][ZPlanEngineService]", "onDestroy, isUsing: " + k3);
                    if (k3) {
                        zLog.k("[zplan][ZPlanEngineService]", "onDestroy, isUsing return");
                        return;
                    }
                    s sVar = (s) mx4.a.f417748a.a(s.class);
                    if (sVar != null) {
                        sVar.c();
                    }
                    ZPlanEngineService.this.R();
                    ZPlanEngineService.this.zPlanWorldCallbacks.kill();
                    ZPlanEngineService.this.zPlanWorldStatusCallbacks.kill();
                    ZPlanEngineService.this.zPlanEngineStatusCallbacks.kill();
                    companion.s(false);
                    companion.r(false);
                    companion.t(false);
                    companion.q(false);
                    companion.u(false);
                    companion.v(-1);
                    ZPlanMonitor.f385621i.e();
                    zLog.f("[zplan][ZPlanEngineService]", "kill zplan process, pid : " + Process.myPid());
                    SystemMethodProxy.killProcess(Process.myPid());
                }
            }, 5000L);
        } else {
            runnable = null;
        }
        N = runnable;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onLowMemory");
    }

    @Override // android.app.Service
    public void onRebind(@Nullable Intent intent) {
        super.onRebind(intent);
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onRebind");
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        int onStartCommand = super.onStartCommand(intent, flags, startId);
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onStartCommand : " + onStartCommand);
        return onStartCommand;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onTrimMemory " + level);
    }

    @Override // android.app.Service
    public boolean onUnbind(@Nullable Intent intent) {
        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onUnbind");
        return super.onUnbind(intent);
    }

    @Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020!H\u0016J\u001a\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010*\u001a\u00020,H\u0016J\u0012\u0010.\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0002H\u0016J\u0012\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0016J.\u00106\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020!H\u0016J$\u00107\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u00105\u001a\u00020!H\u0016J\u001a\u0010:\u001a\u00020\u00022\u0006\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010<\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020!H\u0016J\b\u0010A\u001a\u00020!H\u0016J\b\u0010C\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020BH\u0016J*\u0010H\u001a\u00020\u00022\u0006\u0010D\u001a\u00020B2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$H\u0016J*\u0010I\u001a\u00020\u00022\u0006\u0010D\u001a\u00020B2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$H\u0016J\u0010\u0010J\u001a\u00020\u00022\u0006\u0010D\u001a\u00020BH\u0016J\u0018\u0010L\u001a\u00020\u00022\u0006\u0010D\u001a\u00020B2\u0006\u0010K\u001a\u00020$H\u0016J$\u0010Q\u001a\u00020\u00022\u0006\u0010M\u001a\u00020$2\b\u0010N\u001a\u0004\u0018\u00010\u00132\b\u0010P\u001a\u0004\u0018\u00010OH\u0016J0\u0010U\u001a\u00020\u00022\u0006\u0010R\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010T\u001a\u00020SH\u0016J \u0010V\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$H\u0016J*\u0010W\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\b\u0010N\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020OH\u0016J*\u0010X\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010Y\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$H\u0016J\u0010\u0010Z\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$H\u0016J\u0018\u0010[\u001a\u00020\u00022\u0006\u0010R\u001a\u00020$2\u0006\u0010K\u001a\u00020$H\u0016J\u001a\u0010\\\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010]\u001a\u00020\u00022\u0006\u0010K\u001a\u00020$H\u0016J\b\u0010^\u001a\u00020\u0002H\u0016J \u0010`\u001a\u00020\u00022\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010_\u001a\u00020!H\u0016J\b\u0010a\u001a\u00020!H\u0016J\u0010\u0010c\u001a\u00020\u00022\u0006\u0010b\u001a\u00020!H\u0016J \u0010e\u001a\u00020\u00022\u0006\u0010d\u001a\u00020!2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$H\u0016J\b\u0010f\u001a\u00020\u0002H\u0016J\b\u0010g\u001a\u00020\u0002H\u0016J4\u0010m\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010\u00132\u0006\u0010i\u001a\u00020$2\b\u0010j\u001a\u0004\u0018\u00010\u00132\u0006\u0010k\u001a\u00020!2\u0006\u0010l\u001a\u00020!H\u0016J\u0012\u0010o\u001a\u00020\u00022\b\u0010n\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010p\u001a\u00020\u00022\b\u0010n\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010q\u001a\u00020\u0002H\u0016J\u001a\u0010u\u001a\u00020\u00022\b\u0010s\u001a\u0004\u0018\u00010r2\u0006\u0010t\u001a\u00020$H\u0016J\u001a\u0010v\u001a\u0004\u0018\u00010r2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$H\u0016J\n\u0010x\u001a\u0004\u0018\u00010wH\u0016J\b\u0010y\u001a\u00020\u0002H\u0016J\u0012\u0010{\u001a\u00020\u00022\b\u0010z\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010}\u001a\u00020\u00022\u0006\u0010t\u001a\u00020$2\b\u0010z\u001a\u0004\u0018\u00010\u00132\b\u0010|\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010~\u001a\u00020!H\u0016J*\u0010\u0083\u0001\u001a\u00020\u00022\b\u0010\u007f\u001a\u0004\u0018\u00010\u00132\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\t\u0010\u001c\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J\u001b\u0010\u0086\u0001\u001a\u00020\u00022\u0007\u0010\u0084\u0001\u001a\u00020\u00132\u0007\u0010\u0085\u0001\u001a\u00020!H\u0016R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/tencent/zplan/engine/service/ZPlanEngineService$ZPlanServiceBinder;", "Lcom/tencent/zplan/h$a;", "", "o0", "u0", "Landroid/view/Surface;", "surface", "x0", "Lcom/tencent/zplan/d;", "listener", "V0", "pauseEngine", "I0", "Lcom/tencent/zplan/IZPlanEngineStatusCallback;", "statusCallback", "c3", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, Constants.APK_CERTIFICATE, "Z1", "", AdMetricTag.EVENT_NAME, "", "Lcom/tencent/zplan/engine/service/ReporterEventRecordTime;", "s0", "P2", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "params", "Lcom/tencent/zplan/IZPlanRecordCallback;", "callback", "v1", "uinArray", "notifyAppearanceKeyChange", "processName", "", "isUsing", "g3", "", "W0", "y4", "H2", "keyCode", "Landroid/view/KeyEvent;", "event", "T", "Landroid/view/MotionEvent;", "onTouchEvent", "u2", "onAppBackground", "onAppForeground", "H", ISchemeApi.KEY_SCENE_DATA, "h0", "Lcom/tencent/zplan/b;", "bUseLog", ICustomDataEditor.STRING_PARAM_4, "I", "callbackId", "result", "w1", "Lcom/tencent/zplan/c;", "d1", "Landroid/content/res/Configuration;", DownloadInfo.spKey_Config, "onConfigurationChanged", "Z4", "e1", "", "F3", "nativeHandle", "O0", "width", "height", "O4", "R0", "y1", "worldID", ICustomDataEditor.NUMBER_PARAM_2, "sceneType", "sceneParams", "Lcom/tencent/zplan/IZPlanEnterSceneCallback;", "enterSceneCallback", Constants.EMULATOR_INFO, "renderHashcode", "Lcom/tencent/zplan/IZPlanWorldCallback;", "zplanWorldCallback", "l3", "r2", "l4", "Y3", "y3", "m4", "Y4", "z3", "o3", "I2", "bSync", "o4", "w0", "isPortrait", "V1", "bPortrait", ICustomDataEditor.STRING_ARRAY_PARAM_4, "A3", "H3", "InPakFilename", "PakOrder", "InPath", "bLoadIndex", "bCheckCustomVersion", "g1", "MapName", "R1", "B4", "J3", "Landroid/hardware/HardwareBuffer;", "buffer", "tag", "r0", "E0", "Landroid/os/ParcelFileDescriptor;", "v2", "q1", "path", "a0", "uePath", ICustomDataEditor.STRING_PARAM_2, "L3", "action", "Landroid/os/Bundle;", "data", "Lcom/tencent/zplan/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "dllName", "sync", "f0", "Landroid/graphics/SurfaceTexture;", "d", "Landroid/graphics/SurfaceTexture;", "mPurgeSurfaceTexture", "e", "Landroid/view/Surface;", "mPurgeSurface", "<init>", "(Lcom/tencent/zplan/engine/service/ZPlanEngineService;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public final class ZPlanServiceBinder extends h.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private SurfaceTexture mPurgeSurfaceTexture;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Surface mPurgeSurface;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$ZPlanServiceBinder$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class a implements a.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.zplan.b f385597d;

            a(com.tencent.zplan.b bVar) {
                this.f385597d = bVar;
            }

            @Override // com.tencent.zplan.luabridge.a.b
            public void onExecuteLua() {
                this.f385597d.onExecuteLua();
            }

            @Override // com.tencent.zplan.luabridge.a.b
            public void onLuaResult(boolean success, @Nullable String result) {
                this.f385597d.onLuaResult(success, result);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$ZPlanServiceBinder$b", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class b implements IZPlanWorldStatusListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ IZPlanEnterSceneCallback f385599e;

            b(IZPlanEnterSceneCallback iZPlanEnterSceneCallback) {
                this.f385599e = iZPlanEnterSceneCallback;
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onEnterSceneResult(boolean success) {
                Method m3 = ZPlanEngineService.INSTANCE.m();
                if (m3 != null) {
                    com.tencent.zplan.utils.f.f386206a.a(ZPlanEngineService.this.zPlanWorldStatusCallbacks, m3, this.f385599e, Boolean.valueOf(success));
                }
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onFirstFrame(@NotNull FirstFrameResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Method n3 = ZPlanEngineService.INSTANCE.n();
                if (n3 != null) {
                    com.tencent.zplan.utils.f.f386206a.a(ZPlanEngineService.this.zPlanWorldStatusCallbacks, n3, this.f385599e, result);
                }
                com.tencent.zplan.utils.f.f386206a.d(ZPlanEngineService.this.zPlanWorldStatusCallbacks, this.f385599e);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$ZPlanServiceBinder$c", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class c implements IZPlanWorldStatusListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ IZPlanEnterSceneCallback f385601e;

            c(IZPlanEnterSceneCallback iZPlanEnterSceneCallback) {
                this.f385601e = iZPlanEnterSceneCallback;
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onEnterSceneResult(boolean success) {
                Method m3 = ZPlanEngineService.INSTANCE.m();
                if (m3 != null) {
                    com.tencent.zplan.utils.f.f386206a.a(ZPlanEngineService.this.zPlanWorldStatusCallbacks, m3, this.f385601e, Boolean.valueOf(success));
                }
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onFirstFrame(@NotNull FirstFrameResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Method n3 = ZPlanEngineService.INSTANCE.n();
                if (n3 != null) {
                    com.tencent.zplan.utils.f.f386206a.a(ZPlanEngineService.this.zPlanWorldStatusCallbacks, n3, this.f385601e, result);
                }
                com.tencent.zplan.utils.f.f386206a.d(ZPlanEngineService.this.zPlanWorldStatusCallbacks, this.f385601e);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$ZPlanServiceBinder$d", "Lcom/tencent/zplan/world/manager/IZPlanWorldListener;", "Lcom/tencent/zplan/world/model/ZPlanWorld;", "zPlanWorld", "", "onGetZPlanWorld", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class d implements IZPlanWorldListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ IZPlanWorldCallback f385603b;

            d(IZPlanWorldCallback iZPlanWorldCallback) {
                this.f385603b = iZPlanWorldCallback;
            }

            @Override // com.tencent.zplan.world.manager.IZPlanWorldListener
            public void onGetZPlanWorld(@Nullable ZPlanWorld zPlanWorld) {
                ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onGetZPlanWorld: zPlanWorld=" + zPlanWorld);
                Method l3 = ZPlanEngineService.INSTANCE.l();
                if (l3 != null) {
                    com.tencent.zplan.utils.f.f386206a.a(ZPlanEngineService.this.zPlanWorldCallbacks, l3, this.f385603b, zPlanWorld);
                }
                com.tencent.zplan.utils.f.f386206a.d(ZPlanEngineService.this.zPlanWorldCallbacks, this.f385603b);
            }
        }

        public ZPlanServiceBinder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o0() {
            lx4.f fVar = (lx4.f) mx4.a.f417748a.a(lx4.f.class);
            if (fVar != null) {
                f.a.a(fVar, new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$initBusinessListener$1

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onOpenLightAIPhotoSelector"}, k = 3, mv = {1, 4, 2})
                    /* loaded from: classes27.dex */
                    static final class a implements GameActivityThunk.OpenLightAIPhotoSelectorListener {

                        /* renamed from: a, reason: collision with root package name */
                        public static final a f385605a = new a();

                        a() {
                        }

                        @Override // com.epicgames.ue4.GameActivityThunk.OpenLightAIPhotoSelectorListener
                        public final void onOpenLightAIPhotoSelector() {
                            zx4.b bVar = (zx4.b) mx4.a.f417748a.a(zx4.b.class);
                            if (bVar != null) {
                                bVar.openFaceCamera();
                            }
                        }
                    }

                    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/zplan/engine/service/ZPlanEngineService$ZPlanServiceBinder$initBusinessListener$1$b", "Lcom/epicgames/ue4/GameActivityThunk$DecodeImage2RGBA8Listener;", "", "filePath", "url", "", "width", "height", "Landroid/graphics/Bitmap;", "onDecodeImage2RGBA8", "zplan_debug"}, k = 1, mv = {1, 4, 2})
                    /* loaded from: classes27.dex */
                    public static final class b implements GameActivityThunk.DecodeImage2RGBA8Listener {
                        b() {
                        }

                        @Override // com.epicgames.ue4.GameActivityThunk.DecodeImage2RGBA8Listener
                        @Nullable
                        public Bitmap onDecodeImage2RGBA8(@Nullable String filePath, @Nullable String url, int width, int height) {
                            return com.tencent.qzone.image.api.a.c().b(filePath, url, width, height);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        sx4.a aVar;
                        UE4.setOpenLightAIPhotoSelectorListener(a.f385605a);
                        UE4.setRecordFrameListener(ZPlanMemeHelper.f385999s.s());
                        mx4.a aVar2 = mx4.a.f417748a;
                        m mVar = (m) aVar2.a(m.class);
                        if (mVar != null) {
                            aVar = mVar.a();
                        } else {
                            aVar = null;
                        }
                        UE4.setRecordSameStyleListener(aVar);
                        UE4.setDecodeImage2RGBA8Listener(new b());
                        r rVar = (r) aVar2.a(r.class);
                        if (rVar != null) {
                            rVar.b();
                        }
                        ZPlanEngineService.this.b0();
                        s sVar = (s) aVar2.a(s.class);
                        if (sVar != null) {
                            sVar.b();
                        }
                        boolean isSupport = GraphicBuffer.isSupport();
                        ZLog.f386189b.k("[zplan][ZPlanEngineService]", "ZPlanEngineService: GraphicBuffer Compatibility: " + isSupport + " on this device");
                    }
                }, 0L, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u0() {
            if (this.mPurgeSurfaceTexture == null) {
                this.mPurgeSurfaceTexture = new SurfaceTexture(0);
                this.mPurgeSurface = new Surface(this.mPurgeSurfaceTexture);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ZLog zLog = ZLog.f386189b;
            zLog.k("[zplan][ZPlanEngineService]", "purgeEngineForReleaseMemory UE4.resumeEngine start");
            UE4.resumeEngine(ZPlanEngineService.this.getApplicationContext(), this.mPurgeSurface);
            zLog.k("[zplan][ZPlanEngineService]", "purgeEngineForReleaseMemory UE4.resumeEngine end, cost=" + (System.currentTimeMillis() - currentTimeMillis));
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_purge_engine", "purge_engine", null, 4, null);
            long currentTimeMillis2 = System.currentTimeMillis();
            zLog.k("[zplan][ZPlanEngineService]", "purgeEngineForReleaseMemory UE4.purgeEngine start");
            UE4.purgeEngine();
            zLog.k("[zplan][ZPlanEngineService]", "purgeEngineForReleaseMemory UE4.purgeEngine end, cost=" + (System.currentTimeMillis() - currentTimeMillis2));
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_purge_engine", "purge_engine_end", null, 4, null);
            EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_purge_engine", false, 2, null);
        }

        @Override // com.tencent.zplan.h
        public void A3() {
            com.tencent.zplan.engine.service.d.f385635c.d();
        }

        @Override // com.tencent.zplan.h
        public void B4(@Nullable final String MapName) {
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$openLevelAsync$1
                @Override // java.lang.Runnable
                public final void run() {
                    UE4.openLevel(MapName);
                }
            });
        }

        @Override // com.tencent.zplan.h
        @Nullable
        public HardwareBuffer E0(int width, int height) {
            GraphicBuffer graphicBuffer;
            if (!GraphicBuffer.isSupport()) {
                return null;
            }
            GraphicBuffer fromUERenderTexture = GraphicBuffer.fromUERenderTexture(width, height);
            ZPlanEngineService zPlanEngineService = ZPlanEngineService.this;
            if (zPlanEngineService.mOutBuffer != null && (graphicBuffer = ZPlanEngineService.this.mOutBuffer) != null) {
                graphicBuffer.release();
            }
            zPlanEngineService.mOutBuffer = fromUERenderTexture;
            GraphicBuffer graphicBuffer2 = ZPlanEngineService.this.mOutBuffer;
            if (graphicBuffer2 == null) {
                return null;
            }
            return graphicBuffer2.getHardwareBuffer();
        }

        @Override // com.tencent.zplan.h
        public long F3() {
            return UE4.ParallelWorld.initRender();
        }

        @Override // com.tencent.zplan.h
        public void G1(@Nullable final Surface surface) {
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$resizeSurface$1
                @Override // java.lang.Runnable
                public final void run() {
                    Surface surface2 = surface;
                    if (surface2 != null) {
                        ZLog zLog = ZLog.f386189b;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[zplan][ZPlanEngineService]");
                        ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                        sb5.append(zPlanConstant.b());
                        zLog.k(sb5.toString(), "resizeSurface " + surface + ", Thread  " + Thread.currentThread() + '\"');
                        UE4.resizeWindow(surface2);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("[zplan][ZPlanEngineService]");
                        sb6.append(zPlanConstant.b());
                        zLog.k(sb6.toString(), "resizeSurface end");
                    }
                }
            });
        }

        @Override // com.tencent.zplan.h
        public void G3(int sceneType, @Nullable String sceneParams, @Nullable IZPlanEnterSceneCallback enterSceneCallback) {
            com.tencent.zplan.utils.f.f386206a.c(ZPlanEngineService.this.zPlanWorldStatusCallbacks, enterSceneCallback);
            com.tencent.zplan.world.manager.a.f386318c.c(sceneType, sceneParams, new b(enterSceneCallback));
        }

        @Override // com.tencent.zplan.h
        public void H() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "setViewportFull");
            UE4.setViewportFull();
        }

        @Override // com.tencent.zplan.h
        public boolean H2() {
            return ZPlanEngineService.INSTANCE.k();
        }

        @Override // com.tencent.zplan.h
        public void H3() {
            com.tencent.zplan.engine.service.d.f385635c.e();
        }

        @Override // com.tencent.zplan.h
        public void I(@Nullable String eventName, @Nullable String params, boolean bUseLog) {
            if (eventName != null && params != null) {
                ZPlanLuaBridge.INSTANCE.callLuaRaw(eventName, params, bUseLog);
                return;
            }
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "callLuaRaw Error: eventName is " + eventName + ", params=" + params);
        }

        @Override // com.tencent.zplan.h
        public void I0(@Nullable Surface surface) {
            boolean z16;
            zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
            if (dVar != null) {
                z16 = dVar.o();
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$destroyEngine$1
                @Override // java.lang.Runnable
                public final void run() {
                    Boolean bool;
                    zx4.d dVar2 = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
                    if (dVar2 != null) {
                        bool = Boolean.valueOf(dVar2.b());
                    } else {
                        bool = null;
                    }
                    boolean R = ZPlanServiceHelper.I.R();
                    ZLog zLog = ZLog.f386189b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[zplan][ZPlanEngineService]");
                    ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                    sb5.append(zPlanConstant.b());
                    zLog.o(sb5.toString(), "enablePurge = " + bool + ", isSceneUsing=" + R);
                    if (Intrinsics.areEqual(bool, Boolean.TRUE) && !R) {
                        zLog.o("[zplan][ZPlanEngineService]" + zPlanConstant.b(), "windows is empty, purgeEngine now");
                        ZPlanEngineService.Companion companion = ZPlanEngineService.INSTANCE;
                        companion.u(true);
                        ZPlanEngineService.ZPlanServiceBinder.this.u0();
                        GameActivityNative.OnBackPressed();
                        UE4.pauseEngine(ZPlanEngineService.this.getApplicationContext());
                        UE4.stopEngine(ZPlanEngineService.this.getApplicationContext());
                        UE4.clearContext(ZPlanEngineService.this.getApplicationContext());
                        companion.u(false);
                        return;
                    }
                    zLog.o("[zplan][ZPlanEngineService]" + zPlanConstant.b(), "don't destroyEngine  now");
                }
            });
        }

        @Override // com.tencent.zplan.h
        public void I2() {
            UE4.setContext(ZPlanEngineService.this.getApplicationContext());
        }

        @Override // com.tencent.zplan.h
        public void J3() {
            boolean z16;
            try {
                zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
                if (dVar != null) {
                    z16 = dVar.o();
                } else {
                    z16 = false;
                }
                if (z16 && !UE4.ParallelWorld.isFocusedID(0)) {
                    ZLog.f386189b.l("[zplan][ZPlanEngineService]", "focusMainWorld,", new StackPrinter("focusMainWorld"));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("WorldID", 0);
                    ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "focusObj.toString()");
                    zPlanLuaBridge.callLua("N2L_FocusWorld", jSONObject2, (a.b) null);
                }
            } catch (Exception e16) {
                ZLog.f386189b.l("[zplan][ZPlanEngineService]", "focusMainWorld N2L_FocusWorld exception = ", e16);
            }
        }

        @Override // com.tencent.zplan.h
        public boolean L3() {
            return GraphicBuffer.isSupport();
        }

        @Override // com.tencent.zplan.h
        public void O0(long nativeHandle) {
            UE4.ParallelWorld.releaseRender(nativeHandle);
        }

        @Override // com.tencent.zplan.h
        public void P2() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]" + ZPlanConstant.f386195f.b(), "flushEngine");
            UE4.flushEngine();
        }

        @Override // com.tencent.zplan.h
        public void R1(@Nullable String MapName) {
            UE4.openLevel(MapName);
        }

        @Override // com.tencent.zplan.h
        public void T(int keyCode, @Nullable KeyEvent event) {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onKeyEvent " + KeyEvent.keyCodeToString(keyCode));
            UE4.inputEvent(event);
            GameActivity.Get().onKeyDown(keyCode, event);
        }

        @Override // com.tencent.zplan.h
        public void V0(@Nullable final Surface surface, @Nullable final com.tencent.zplan.d listener) {
            ZLog.f386189b.l("[zplan][ZPlanEngineService]" + ZPlanConstant.f386195f.b(), "before resumeEngine,", new StackPrinter("resumeEngine"));
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$resumeEngine$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZLog zLog = ZLog.f386189b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[zplan][ZPlanEngineService]");
                    ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                    sb5.append(zPlanConstant.b());
                    zLog.k(sb5.toString(), "agindage resumeEngine " + surface);
                    EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_resume_engine", "resume_engine", null, 4, null);
                    UE4.resumeEngine(ZPlanEngineService.this.getApplicationContext(), surface);
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_resume_engine", "resume_engine_end", null, 4, null);
                    EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_resume_engine", false, 2, null);
                    zLog.k("[zplan][ZPlanEngineService]" + zPlanConstant.b(), "resumeEngine end");
                    d dVar = d.f385635c;
                    dVar.d();
                    dVar.e();
                    ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
                    com.tencent.zplan.d dVar2 = listener;
                    if (dVar2 != null) {
                        dVar2.S0(true);
                    }
                }
            });
        }

        @Override // com.tencent.zplan.h
        public void V1(boolean isPortrait) {
            UE4.setPortraitOrientation(isPortrait);
        }

        @Override // com.tencent.zplan.h
        public int W0() {
            return ZPlanEngineService.INSTANCE.o();
        }

        @Override // com.tencent.zplan.h
        public void Y3(int worldID, int width, int height, @Nullable Surface surface) {
            ZPlanWorldManager.f386245m.F(worldID, width, height, surface);
        }

        @Override // com.tencent.zplan.h
        public void Y4(int renderHashcode, int worldID) {
            ZPlanWorldManager.f386245m.U(renderHashcode, worldID);
        }

        @Override // com.tencent.zplan.h
        public void Z1(@Nullable final Surface surface) {
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$destroySurface$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZLog zLog = ZLog.f386189b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[zplan][ZPlanEngineService]");
                    ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                    sb5.append(zPlanConstant.b());
                    zLog.k(sb5.toString(), "destroySurface " + surface + ", Thread  " + Thread.currentThread() + '\"');
                    EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_clear_window", "clear_window", null, 4, null);
                    Surface surface2 = surface;
                    if (surface2 != null) {
                        UE4.terminateWindow(surface2, true);
                    } else {
                        UE4.clearWindow(true);
                    }
                    zLog.k("[zplan][ZPlanEngineService]" + zPlanConstant.b(), "destroySurface end");
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_clear_window", "clear_window_end", null, 4, null);
                    EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_clear_window", false, 2, null);
                }
            });
        }

        @Override // com.tencent.zplan.h
        public boolean Z4() {
            return UE4.hasEnginePause();
        }

        @Override // com.tencent.zplan.h
        public void a0(@Nullable String path) {
            GraphicBuffer graphicBuffer = ZPlanEngineService.this.mOutBuffer;
            if (graphicBuffer != null) {
                graphicBuffer.debugSavePng(path);
            }
        }

        @Override // com.tencent.zplan.h
        public void a4(boolean bPortrait, int width, int height) {
            UE4.setPortraitOrientation(bPortrait, width, height);
        }

        @Override // com.tencent.zplan.h
        public void c3(@Nullable IZPlanEngineStatusCallback statusCallback) {
            com.tencent.zplan.utils.f.f386206a.c(ZPlanEngineService.this.zPlanEngineStatusCallbacks, statusCallback);
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "setZPlanEngineStatusCallback\uff0csize\uff1a" + ZPlanEngineService.this.zPlanEngineStatusCallbacks.getRegisteredCallbackCount());
        }

        @Override // com.tencent.zplan.h
        public void d1(@Nullable String eventName, @Nullable com.tencent.zplan.c callback) {
            if (eventName == null) {
                ZLog.f386189b.k("[zplan][ZPlanEngineService]", "observeLuaEvent: eventName is null!! callback=" + callback);
                return;
            }
            RemoteRegisterHelper.INSTANCE.a().d(eventName, callback);
        }

        @Override // com.tencent.zplan.h
        public boolean e1() {
            if (UE4.getWindow() != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.zplan.h
        public void f0(@NotNull String dllName, boolean sync) {
            boolean z16;
            Intrinsics.checkNotNullParameter(dllName, "dllName");
            if (dllName.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                UE4.loadModulesInDLL(sync);
            } else {
                UE4.loadModulesInDLL(dllName, sync);
            }
        }

        @Override // com.tencent.zplan.h
        public void g1(@Nullable String InPakFilename, int PakOrder, @Nullable String InPath, boolean bLoadIndex, boolean bCheckCustomVersion) {
            UE4.mountPak(InPakFilename, PakOrder, InPath, bLoadIndex, bCheckCustomVersion);
        }

        @Override // com.tencent.zplan.h
        public void g3(@NotNull String processName, boolean isUsing) {
            Intrinsics.checkNotNullParameter(processName, "processName");
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "setZPlanUsing processName:" + processName + ", isUsing: " + isUsing);
            ZPlanEngineService.INSTANCE.w(processName, isUsing);
        }

        @Override // com.tencent.zplan.h
        public void h0(@Nullable String sceneData) {
            ZPlanWorldManager.f386245m.X(sceneData);
        }

        @Override // com.tencent.zplan.h
        public void l3(int renderHashcode, int sceneType, int width, int height, @NotNull IZPlanWorldCallback zplanWorldCallback) {
            Intrinsics.checkNotNullParameter(zplanWorldCallback, "zplanWorldCallback");
            com.tencent.zplan.utils.f.f386206a.c(ZPlanEngineService.this.zPlanWorldCallbacks, zplanWorldCallback);
            ZPlanWorldManager.f386245m.H(renderHashcode, sceneType, width, height, new d(zplanWorldCallback));
        }

        @Override // com.tencent.zplan.h
        public void l4(int worldID, int sceneType, @Nullable String sceneParams, @NotNull IZPlanEnterSceneCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            com.tencent.zplan.utils.f.f386206a.c(ZPlanEngineService.this.zPlanWorldStatusCallbacks, callback);
            ZPlanWorldManager.f386245m.C(worldID, sceneType, sceneParams, new c(callback));
        }

        @Override // com.tencent.zplan.h
        public void m4(int worldID) {
            ZPlanWorldManager.f386245m.W(worldID);
        }

        @Override // com.tencent.zplan.h
        public void notifyAppearanceKeyChange(@Nullable String uinArray) {
            JSONArray y16;
            if (uinArray != null && (y16 = ZPlanEngineService.INSTANCE.y(uinArray)) != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uins", y16);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "params.toString()");
                ZLog.f386189b.i("[zplan][ZPlanEngineService]", 1, "notifyAppearanceKeyChange, params:" + jSONObject2);
                a.C10063a.b(ZPlanLuaBridge.INSTANCE, "N2L_AppearanceKeyChange", jSONObject2, null, 4, null);
            }
        }

        @Override // com.tencent.zplan.h
        public void o3(int worldID) {
            ZPlanWorldManager.f386245m.A(worldID);
        }

        @Override // com.tencent.zplan.h
        public void o4(int width, int height, boolean bSync) {
            UE4.resizeBackbuffer(width, height, bSync);
        }

        @Override // com.tencent.zplan.h
        public void onAppBackground() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onAppBackground");
            UE4.enterBackground();
        }

        @Override // com.tencent.zplan.h
        public void onAppForeground() {
            ZLog.f386189b.k("[zplan][ZPlanEngineService]", "onAppForeground");
            UE4.enterForeground();
        }

        @Override // com.tencent.zplan.h
        public void onConfigurationChanged(@NotNull Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            GameActivity.Get().onConfigurationChanged(config);
        }

        @Override // com.tencent.zplan.h
        public void onTouchEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            UE4.inputEvent(event);
        }

        @Override // com.tencent.zplan.h
        public void pauseEngine() {
            ZLog.f386189b.l("[zplan][ZPlanEngineService]" + ZPlanConstant.f386195f.b(), "before pauseEngine,", new StackPrinter("pauseEngine"));
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$pauseEngine$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z16;
                    zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
                    if (dVar != null) {
                        z16 = dVar.o();
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        e.f385642b.a(ZPlanEngineService.this.getApplicationContext());
                    }
                    if (!UE4.isEnginePause) {
                        ZLog zLog = ZLog.f386189b;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[zplan][ZPlanEngineService]");
                        ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                        sb5.append(zPlanConstant.b());
                        zLog.k(sb5.toString(), "pauseEngine");
                        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_pause_engine", "pause_engine", null, 4, null);
                        UE4.pauseEngine(ZPlanEngineService.this.getApplicationContext());
                        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_pause_engine", "pause_engine_end", null, 4, null);
                        EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_pause_engine", false, 2, null);
                        zLog.k("[zplan][ZPlanEngineService]" + zPlanConstant.b(), "pauseEngine end");
                    }
                }
            });
        }

        @Override // com.tencent.zplan.h
        public void q1() {
            Iterator it = ZPlanEngineService.this.mInBuffers.entrySet().iterator();
            while (it.hasNext()) {
                GraphicBuffer graphicBuffer = (GraphicBuffer) ((Map.Entry) it.next()).getValue();
                if (graphicBuffer != null) {
                    graphicBuffer.release();
                }
            }
            ZPlanEngineService.this.mInBuffers.clear();
            GraphicBuffer graphicBuffer2 = ZPlanEngineService.this.mOutBuffer;
            if (graphicBuffer2 != null) {
                graphicBuffer2.release();
            }
            ZPlanEngineService.this.mOutBuffer = null;
        }

        @Override // com.tencent.zplan.h
        public void r0(@Nullable HardwareBuffer buffer, int tag) {
            if (GraphicBuffer.isSupport() && buffer != null) {
                GraphicBuffer fromHardwareBuffer = GraphicBuffer.fromHardwareBuffer(buffer);
                if (ZPlanEngineService.this.mInBuffers.containsKey(Integer.valueOf(tag))) {
                    GraphicBuffer graphicBuffer = (GraphicBuffer) ZPlanEngineService.this.mInBuffers.get(Integer.valueOf(tag));
                    if (graphicBuffer != null) {
                        graphicBuffer.release();
                    }
                    ZPlanEngineService.this.mInBuffers.put(Integer.valueOf(tag), fromHardwareBuffer);
                } else {
                    ZPlanEngineService.this.mInBuffers.put(Integer.valueOf(tag), fromHardwareBuffer);
                }
                GraphicBuffer graphicBuffer2 = (GraphicBuffer) ZPlanEngineService.this.mInBuffers.get(Integer.valueOf(tag));
                if (graphicBuffer2 != null) {
                    graphicBuffer2.bindUETexture(tag);
                }
            }
        }

        @Override // com.tencent.zplan.h
        public void r2(int worldID, int width, int height) {
            ZPlanWorldManager.f386245m.Y(worldID, width, height);
        }

        @Override // com.tencent.zplan.h
        @NotNull
        public List<ReporterEventRecordTime> s0(@NotNull String eventName) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            return EngineLifeCycleReporter.f385573f.n(eventName);
        }

        @Override // com.tencent.zplan.h
        public void s2(int tag, @Nullable String path, @Nullable String uePath) {
            GraphicBuffer graphicBuffer = (GraphicBuffer) ZPlanEngineService.this.mInBuffers.get(Integer.valueOf(tag));
            if (graphicBuffer != null) {
                graphicBuffer.debugSavePng(path);
            }
            if (uePath != null) {
                UE4.saveExternalTexture(tag, uePath);
            }
        }

        @Override // com.tencent.zplan.h
        public void s4(@Nullable String eventName, @Nullable String params, @Nullable com.tencent.zplan.b callback, boolean bUseLog) {
            a aVar;
            if (eventName == null) {
                ZLog.f386189b.k("[zplan][ZPlanEngineService]", "callLua: eventName is null!! params=" + params + " callback=" + callback);
                return;
            }
            if (callback != null) {
                aVar = new a(callback);
            } else {
                aVar = null;
            }
            if (params == null) {
                ZPlanLuaBridge.INSTANCE.callLua(eventName, aVar, bUseLog);
            } else {
                ZPlanLuaBridge.INSTANCE.callLua(eventName, params, aVar, bUseLog);
            }
        }

        @Override // com.tencent.zplan.h
        public void setSurface(@Nullable final Surface surface) {
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$setSurface$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZLog zLog = ZLog.f386189b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[zplan][ZPlanEngineService]");
                    ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                    sb5.append(zPlanConstant.b());
                    zLog.k(sb5.toString(), "initWindow " + surface + ", surface=" + surface + ", Thread  " + Thread.currentThread());
                    EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_init_window", "init_window", null, 4, null);
                    UE4.initWindow(surface);
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_init_window", "init_window_end", null, 4, null);
                    EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_init_window", false, 2, null);
                    zLog.k("[zplan][ZPlanEngineService]" + zPlanConstant.b(), "setSurface end");
                }
            });
        }

        @Override // com.tencent.zplan.h
        public void v1(@NotNull MemeRecordParams params, @Nullable IZPlanRecordCallback callback) {
            Intrinsics.checkNotNullParameter(params, "params");
            ZPlanMemeHelper.f385999s.u(params, callback);
        }

        @Override // com.tencent.zplan.h
        @Nullable
        public ParcelFileDescriptor v2() {
            GraphicBuffer graphicBuffer = ZPlanEngineService.this.mOutBuffer;
            if (graphicBuffer != null) {
                return graphicBuffer.getFenceForUERender();
            }
            return null;
        }

        @Override // com.tencent.zplan.h
        public boolean w0() {
            return UE4.IsPortraitOrientation();
        }

        @Override // com.tencent.zplan.h
        public void w1(int callbackId, @Nullable String result) {
            GameActivityNative.Callback(callbackId, result);
        }

        @Override // com.tencent.zplan.h
        public void x0(@Nullable final Surface surface) {
            ZPlanEngineService.this.Q().post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanEngineService$ZPlanServiceBinder$initEngine$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEngineService.b bVar;
                    ZPlanEngineService.c cVar;
                    f fVar;
                    ZPlanEngineService.d dVar;
                    boolean z16;
                    ZLog zLog = ZLog.f386189b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[zplan][ZPlanEngineService]");
                    ZPlanConstant zPlanConstant = ZPlanConstant.f386195f;
                    sb5.append(zPlanConstant.b());
                    zLog.k(sb5.toString(), "initEngine");
                    ZPlanEngineService.Companion companion = ZPlanEngineService.INSTANCE;
                    if (companion.f()) {
                        zLog.k("[zplan][ZPlanEngineService]", "initEngine " + companion.f() + ", return.");
                        return;
                    }
                    companion.s(true);
                    ZPlanEngineService.this.Z();
                    d dVar2 = d.f385635c;
                    dVar2.j();
                    bVar = ZPlanEngineService.this.engineErrorListener;
                    UE4.errorListener = bVar;
                    cVar = ZPlanEngineService.this.engineListener;
                    UE4.engineListener = cVar;
                    UE4.setEngineReentryEnabled(false);
                    UE4.initEngine(ZPlanEngineService.this.getApplicationContext(), new Bundle(), false, dVar2.a(), dVar2.b());
                    EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine_zplan_process", "initEngine_init_end_zplan", null, 4, null);
                    if (!UE4.isEnginePause && companion.b() == null) {
                        ZPlanEngineService.this.needInitWindow = false;
                        String str = "[zplan][ZPlanEngineService]" + zPlanConstant.b();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("resumeEngine mNeedInitWindow: ");
                        z16 = ZPlanEngineService.this.needInitWindow;
                        sb6.append(z16);
                        zLog.k(str, sb6.toString());
                    } else {
                        Runnable b16 = companion.b();
                        if (b16 != null && (fVar = (f) mx4.a.f417748a.a(f.class)) != null) {
                            fVar.d(b16);
                        }
                        ZPlanEngineService.this.needInitWindow = true;
                        UE4.resumeEngine(ZPlanEngineService.this.getApplicationContext(), surface);
                    }
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine_zplan_process", "initEngine_resume_end_zplan", null, 4, null);
                    dVar2.d();
                    dVar2.e();
                    FirstFramePlugin firstFramePlugin = FirstFramePlugin.f385718f;
                    dVar = ZPlanEngineService.this.firstFrameListener;
                    firstFramePlugin.b(new FirstFramePlugin.a(-1, dVar, true));
                    ZPlanEngineService.ZPlanServiceBinder.this.o0();
                    EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine_zplan_process", "initEngine_end_zplan", null, 4, null);
                }
            });
        }

        @Override // com.tencent.zplan.h
        public void y3(int worldID) {
            ZPlanWorldManager.f386245m.V(worldID);
        }

        @Override // com.tencent.zplan.h
        public int y4() {
            return ZPlanEngineService.INSTANCE.j();
        }

        @Override // com.tencent.zplan.h
        public void z(@Nullable String action, @Nullable Bundle data, @Nullable com.tencent.zplan.e callback) {
            zx4.a aVar = (zx4.a) mx4.a.f417748a.a(zx4.a.class);
            if (aVar != null) {
                aVar.z(action, data, callback);
            }
        }

        @Override // com.tencent.zplan.h
        public void u2(@Nullable Surface surface) {
        }

        @Override // com.tencent.zplan.h
        public void y1(long nativeHandle) {
        }

        @Override // com.tencent.zplan.h
        public void n2(long nativeHandle, int worldID) {
        }

        @Override // com.tencent.zplan.h
        public void z3(int worldID, @Nullable Surface surface) {
        }

        @Override // com.tencent.zplan.h
        public void O4(long nativeHandle, @Nullable Surface surface, int width, int height) {
        }

        @Override // com.tencent.zplan.h
        public void R0(long nativeHandle, @Nullable Surface surface, int width, int height) {
        }
    }
}
