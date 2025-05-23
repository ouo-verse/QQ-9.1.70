package com.tencent.filament.zplan.view.controller;

import android.view.Surface;
import androidx.annotation.Keep;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.filament.zplan.listener.GYScreenShotListener;
import com.tencent.filament.zplan.listener.IAnimationNativeCallback;
import com.tencent.filament.zplan.listener.LoadAvatarCallback;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008e\u0001BZ\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u0012\u0007\u0010\u0083\u0001\u001a\u00020\n\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0084\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J3\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0082 J\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082 J)\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J1\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J1\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J\u0019\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J\u0019\u0010\u001c\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0082 J\u0019\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0082 J\u0019\u0010!\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020 H\u0082 J\u0019\u0010#\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\bH\u0082 J!\u0010&\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\n2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0082 J!\u0010'\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J!\u0010*\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0082 J!\u0010,\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020+H\u0082 J\u0019\u0010.\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u001aH\u0082 J+\u00101\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010 H\u0082 J\u0011\u00102\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u00103\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u00100\u001a\u00020\u0004H\u0082 J\u0011\u00104\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0082 J1\u00109\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001eH\u0082 J\u0019\u0010;\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010:\u001a\u00020\bH\u0082 J!\u0010>\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010=\u001a\u00020<2\u0006\u0010:\u001a\u00020\bH\u0082 J!\u0010A\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0082 JA\u0010F\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010:\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010E\u001a\u00020D2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0082 J)\u0010J\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u001eH\u0082 J\u0011\u0010K\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u0010L\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010:\u001a\u00020\bH\u0082 J\u0016\u0010M\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010P\u001a\u00020\r2\u0006\u0010O\u001a\u00020NJ\u000e\u0010Q\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\bJ\u0016\u0010R\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u0016\u0010S\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010U\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020 J\u001e\u0010W\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0004J\u000e\u0010W\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u001aJ\u000e\u0010X\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010Y\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010Z\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010[\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004J\b\u0010\\\u001a\u00020\rH\u0004J\u001e\u0010]\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J&\u0010^\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010_\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020+J\u001e\u0010_\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020+J\u000e\u0010`\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020 J\"\u0010a\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0007J\u0010\u0010c\u001a\u00020\r2\b\u0010b\u001a\u0004\u0018\u00010 J&\u0010d\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010e\u001a\u00020\rJ\u0006\u0010f\u001a\u00020\rJ\u000e\u0010g\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0004J&\u0010h\u001a\u00020\r2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001eJ\u000e\u0010i\u001a\u00020\r2\u0006\u0010:\u001a\u00020\bJ\u0016\u0010j\u001a\u00020\r2\u0006\u0010=\u001a\u00020<2\u0006\u0010:\u001a\u00020\bJ\u0016\u0010k\u001a\u00020\r2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bJ6\u0010m\u001a\u00020\r2\u0006\u0010l\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010E\u001a\u00020D2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J\u001e\u0010n\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u001eJ\u0006\u0010o\u001a\u00020\rJ\u0017\u0010L\u001a\u0004\u0018\u00010\u001e2\u0006\u0010:\u001a\u00020\b\u00a2\u0006\u0004\bL\u0010pR*\u0010r\u001a\u00020\u00102\u0006\u0010q\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010x\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0015\u0010\u007f\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0083\u0001\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010yR\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0016X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/filament/zplan/view/controller/GYFZPlanNativeAPI;", "Lkotlinx/coroutines/CoroutineScope;", "", "nativeWindow", "", "isOffScreen", "isLogGpuError", "allowCameraManipulator", "", "bootConfig", "", "nCreateViewer", "nativeViewer", "", "nAttach", "uin", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/filament/zplan/listener/LoadAvatarCallback;", "callback", "nLoadAvatarWithUin", "faceJson", "nLoadAvatarWithUinAndFaceJson", "avatarInfo", "nLoadAvatarWithAvatarInfoAndFaceJson", "nApplyAvatarInfo", "", "time", "nTick", "isAverage", "", "nGetFPS", "Lcom/tencent/filament/zplan/listener/GYScreenShotListener;", "nTakeScreenShot", "path", "nSetTemplatePath", "baseTemplateJson", "iblPath", "nSetTemplateInfo", "nBoot", "width", "height", "nSetViewport", "Lcom/tencent/filament/zplan/listener/IAnimationNativeCallback;", "nSetAnimationWithPath", "now", "nUpdate", "needFence", "waitUntilFinish", "nRender", "nDelloc", "nRenderWarmup", "nFlushAndWait", "axisX", "axisY", "axisZ", "angle", "nRotateAvatar", "slotID", "nOnlyShowSlot", "", "primitiveIndexArr", "nHidePrimitivesInSlot", "configJson", "dirPath", "nSetupConfigJson", "materialName", "parameterName", "", "pixels", "nReplaceMaterialTexture", "centerLocationX", "centerLocationY", "scrollDelta", "nScrollCameraManipulator", "nResetCameraManipulator", "nGetScrollDeltaSumUpperLimit", "setViewPort", "Landroid/view/Surface;", "surface", "attach", "setBaseTemplatePath", "setBaseTemplateInfo", "boot", "frameTime", "tickAndTakeScreenShot", "needFlush", "tick", "applyAvatarInfo", "getFPS", "update", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "checkAndLogRunningThread", "setAvatarWithUin", "setAvatarWithUinAndFaceJson", "setAnimationWithPath", "renderAndTakeScreenShot", "onRecordFrame", "listener", "setScreenShotListener", "setAvatarWithAvatarInfoAndFaceJson", "delloc", "flushAndWait", "renderWarmup", "rotateAvatar", "onlyShowSlot", "hidePrimitivesInSlot", "setupConfigJson", "slot", "replaceMaterialTexture", "scrollCameraManipulator", "resetCameraManipulator", "(Ljava/lang/String;)Ljava/lang/Float;", "value", "fps", "I", "getFps", "()I", "setFps", "(I)V", "nativeObject", "J", "getNativeObject", "()J", "setNativeObject", "(J)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenShotListener", "Lcom/tencent/filament/zplan/listener/GYScreenShotListener;", "threadId", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lcom/tencent/filament/zplan/data/RenderSize;", "size", "context", "<init>", "(Landroid/view/Surface;Lcom/tencent/filament/zplan/data/RenderSize;JZZLkotlin/coroutines/CoroutineContext;ZLjava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class GYFZPlanNativeAPI implements CoroutineScope {

    @NotNull
    public static final String TAG = "GYFZPlanNativeAPI";
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final AtomicBoolean booted;
    private int fps;
    private long nativeObject;
    private GYScreenShotListener screenShotListener;
    private final long threadId;

    public GYFZPlanNativeAPI(@Nullable Surface surface, @NotNull RenderSize size, long j3, boolean z16, boolean z17, @NotNull CoroutineContext context, boolean z18, @NotNull String bootConfig) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bootConfig, "bootConfig");
        this.$$delegate_0 = CoroutineScopeKt.CoroutineScope(context);
        this.threadId = j3;
        this.fps = 30;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.booted = atomicBoolean;
        FLog.INSTANCE.i(TAG, "nCreateViewer, " + z16 + " , " + z17);
        this.nativeObject = nCreateViewer(surface, z16, z17, z18, bootConfig);
        atomicBoolean.set(true);
    }

    private final native void nApplyAvatarInfo(long nativeViewer, int requestId);

    private final native void nAttach(long nativeViewer, Object nativeWindow);

    private final native void nBoot(long nativeViewer, boolean isOffScreen, boolean isLogGpuError);

    private final native long nCreateViewer(Object nativeWindow, boolean isOffScreen, boolean isLogGpuError, boolean allowCameraManipulator, String bootConfig);

    private final native void nDelloc(long nativeViewer);

    private final native void nFlushAndWait(long nativeViewer);

    private final native float nGetFPS(long nativeViewer, boolean isAverage);

    private final native float nGetScrollDeltaSumUpperLimit(long nativeViewer, String slotID);

    private final native void nHidePrimitivesInSlot(long nativeViewer, int[] primitiveIndexArr, String slotID);

    private final native void nLoadAvatarWithAvatarInfoAndFaceJson(long nativeViewer, String avatarInfo, String faceJson, int requestId, LoadAvatarCallback callback);

    private final native void nLoadAvatarWithUin(long nativeViewer, String uin, int requestId, LoadAvatarCallback callback);

    private final native void nLoadAvatarWithUinAndFaceJson(long nativeViewer, String uin, String faceJson, int requestId, LoadAvatarCallback callback);

    private final native void nOnlyShowSlot(long nativeViewer, String slotID);

    private final native boolean nRender(long nativeViewer, boolean needFence, boolean waitUntilFinish, GYScreenShotListener callback);

    private final native void nRenderWarmup(long nativeViewer, boolean waitUntilFinish);

    private final native void nReplaceMaterialTexture(long nativeViewer, String slotID, String materialName, String parameterName, byte[] pixels, int width, int height);

    private final native void nResetCameraManipulator(long nativeViewer);

    private final native void nRotateAvatar(long nativeViewer, float axisX, float axisY, float axisZ, float angle);

    private final native void nScrollCameraManipulator(long nativeViewer, float centerLocationX, float centerLocationY, float scrollDelta);

    private final native void nSetAnimationWithPath(long nativeViewer, String path, IAnimationNativeCallback callback);

    private final native int nSetTemplateInfo(long nativeViewer, String baseTemplateJson, String iblPath);

    private final native int nSetTemplatePath(long nativeViewer, String path);

    private final native void nSetViewport(long nativeViewer, int width, int height);

    private final native void nSetupConfigJson(long nativeViewer, String configJson, String dirPath);

    private final native boolean nTakeScreenShot(long nativeViewer, GYScreenShotListener callback);

    private final native boolean nTick(long nativeViewer, double time);

    private final native void nUpdate(long nativeViewer, double now);

    public final void applyAvatarInfo(int requestId) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "applyAvatarInfo called");
        nApplyAvatarInfo(this.nativeObject, requestId);
    }

    public final void attach(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "attach called");
        nAttach(this.nativeObject, surface);
    }

    public final void boot(boolean isOffScreen, boolean isLogGpuError) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "boot called");
        nBoot(this.nativeObject, isOffScreen, isLogGpuError);
    }

    protected final void checkAndLogRunningThread() {
        boolean z16;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        if (currentThread.getId() == this.threadId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            FLog.INSTANCE.e(TAG, "[\u4e0d\u662f\u5f02\u5e38!] Warning, must invoke GYFZPlanNativeAPI method within Viewer Thread!", new Exception("[\u4e0d\u662f\u5f02\u5e38!] Warning, must invoke GYFZPlanNativeAPI method within Viewer Thread!"));
        }
    }

    public final void delloc() {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        this.screenShotListener = null;
        nDelloc(j3);
        this.nativeObject = 0L;
    }

    public final void flushAndWait() {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "flushAndWait called");
        nFlushAndWait(this.nativeObject);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final float getFPS(boolean isAverage) {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0.0f;
        }
        return nGetFPS(j3, isAverage);
    }

    public final int getFps() {
        return this.fps;
    }

    protected final long getNativeObject() {
        return this.nativeObject;
    }

    public final void hidePrimitivesInSlot(@NotNull int[] primitiveIndexArr, @NotNull String slotID) {
        Intrinsics.checkNotNullParameter(primitiveIndexArr, "primitiveIndexArr");
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nHidePrimitivesInSlot(j3, primitiveIndexArr, slotID);
    }

    @Nullable
    public final Float nGetScrollDeltaSumUpperLimit(@NotNull String slotID) {
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return null;
        }
        return Float.valueOf(nGetScrollDeltaSumUpperLimit(j3, slotID));
    }

    @NativeMethodProxy
    public final void onRecordFrame(@Nullable byte[] pixels, int width, int height) {
        Integer num;
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordFrame, pixels: ");
        if (pixels != null) {
            num = Integer.valueOf(pixels.length);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", ");
        sb5.append(width);
        sb5.append(", ");
        sb5.append(height);
        fLog.i(TAG, sb5.toString());
        GYScreenShotListener gYScreenShotListener = this.screenShotListener;
        if (gYScreenShotListener != null) {
            Intrinsics.checkNotNull(gYScreenShotListener);
            gYScreenShotListener.onScreenShot(pixels, width, height);
        } else {
            fLog.i(TAG, "onRecordFrame callback is null!");
        }
    }

    public final void onlyShowSlot(@NotNull String slotID) {
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nOnlyShowSlot(j3, slotID);
    }

    public final void render(boolean needFence, boolean waitUntilFinish) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "render called");
        nRender(this.nativeObject, needFence, waitUntilFinish, null);
    }

    public final boolean renderAndTakeScreenShot(@NotNull GYScreenShotListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return false;
        }
        FLog.INSTANCE.i(TAG, "takeScreenShot called");
        return nTakeScreenShot(this.nativeObject, callback);
    }

    public final void renderWarmup(boolean waitUntilFinish) {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nRenderWarmup(j3, waitUntilFinish);
    }

    public final void replaceMaterialTexture(@NotNull String slot, @NotNull String materialName, @NotNull String parameterName, @NotNull byte[] pixels, int width, int height) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(materialName, "materialName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nReplaceMaterialTexture(j3, slot, materialName, parameterName, pixels, width, height);
    }

    public final void resetCameraManipulator() {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nResetCameraManipulator(j3);
    }

    public final void rotateAvatar(float axisX, float axisY, float axisZ, float angle) {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nRotateAvatar(j3, axisX, axisY, axisZ, angle);
    }

    public final void scrollCameraManipulator(float centerLocationX, float centerLocationY, float scrollDelta) {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nScrollCameraManipulator(j3, centerLocationX, centerLocationY, scrollDelta);
    }

    public final void setAnimationWithPath(@NotNull String path, @NotNull IAnimationNativeCallback callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setAnimationWithPath called");
        nSetAnimationWithPath(this.nativeObject, path, callback);
    }

    public final void setAvatarWithAvatarInfoAndFaceJson(@NotNull String avatarInfo, @NotNull String faceJson, int requestId, @NotNull LoadAvatarCallback callback) {
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(faceJson, "faceJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setAvatarWithAvatarInfoAndFaceJson called");
        nLoadAvatarWithAvatarInfoAndFaceJson(this.nativeObject, avatarInfo, faceJson, requestId, callback);
    }

    public final void setAvatarWithUin(@NotNull String uin, int requestId, @NotNull LoadAvatarCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setAvatarWithUin called");
        nLoadAvatarWithUin(this.nativeObject, uin, requestId, callback);
    }

    public final void setAvatarWithUinAndFaceJson(@NotNull String uin, @NotNull String avatarInfo, int requestId, @NotNull LoadAvatarCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setAvatarWithUinAndFaceJson called");
        nLoadAvatarWithUinAndFaceJson(this.nativeObject, uin, avatarInfo, requestId, callback);
    }

    public final int setBaseTemplateInfo(@NotNull String baseTemplateJson, @NotNull String iblPath) {
        Intrinsics.checkNotNullParameter(baseTemplateJson, "baseTemplateJson");
        Intrinsics.checkNotNullParameter(iblPath, "iblPath");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return -170;
        }
        FLog.INSTANCE.i(TAG, "setBaseTemplateInfo called");
        return nSetTemplateInfo(this.nativeObject, baseTemplateJson, iblPath);
    }

    public final int setBaseTemplatePath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return -170;
        }
        FLog.INSTANCE.i(TAG, "setBaseTemplatePath called");
        return nSetTemplatePath(this.nativeObject, path);
    }

    public final void setFps(int i3) {
        this.fps = i3;
    }

    protected final void setNativeObject(long j3) {
        this.nativeObject = j3;
    }

    public final void setScreenShotListener(@Nullable GYScreenShotListener listener) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        this.screenShotListener = listener;
    }

    public final void setViewPort(int width, int height) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setViewPort, " + width + " * " + height);
        nSetViewport(this.nativeObject, width, height);
    }

    public final void setupConfigJson(@NotNull String configJson, @NotNull String dirPath) {
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nSetupConfigJson(j3, configJson, dirPath);
    }

    public final boolean tick(double frameTime, boolean needFence, boolean needFlush) {
        if (!this.booted.get()) {
            return false;
        }
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return false;
        }
        nUpdate(j3, frameTime);
        return nRender(this.nativeObject, needFence, needFlush, null);
    }

    public final boolean tickAndTakeScreenShot(double frameTime, @NotNull GYScreenShotListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.booted.get()) {
            return false;
        }
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return false;
        }
        nUpdate(j3, frameTime);
        return nTakeScreenShot(this.nativeObject, callback);
    }

    public final void update(double time) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "update called");
        nUpdate(this.nativeObject, time);
    }

    public final void setAnimationWithPath(int requestId, @NotNull String path, @NotNull IAnimationNativeCallback callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setAnimationWithPath called");
        nSetAnimationWithPath(this.nativeObject, path, callback);
    }

    public final boolean tick(double frameTime) {
        if (!this.booted.get()) {
            return false;
        }
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return false;
        }
        nUpdate(j3, frameTime);
        return nRender(this.nativeObject, false, false, null);
    }

    public /* synthetic */ GYFZPlanNativeAPI(Surface surface, RenderSize renderSize, long j3, boolean z16, boolean z17, CoroutineContext coroutineContext, boolean z18, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(surface, renderSize, j3, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? false : z17, (i3 & 32) != 0 ? Dispatchers.getDefault() : coroutineContext, (i3 & 64) != 0 ? false : z18, (i3 & 128) != 0 ? "{}" : str);
    }
}
