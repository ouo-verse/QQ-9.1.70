package com.tencent.filament.zplan.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import com.tencent.filament.zplan.c;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplanservice.util.log.FLog;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 m2\u00020\u0001:\u0002noB\u0017\u0012\u0006\u0010j\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\bk\u0010lJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0082 J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0011\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J\u0011\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0082 J\u0011\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u0010\u001b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0082 J\u0011\u0010\u001c\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u0010\u001e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006H\u0082 J!\u0010!\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0082 J)\u0010%\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019H\u0082 J#\u0010)\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0082 J#\u0010+\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0082 J+\u0010/\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010.H\u0082 J!\u00100\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020.H\u0082 J+\u00103\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010.H\u0082 J\u0011\u00104\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J#\u00105\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010.H\u0082 J#\u00106\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010.H\u0082 J\u0019\u00108\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u00107\u001a\u00020\u000fH\u0082 J!\u0010:\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.H\u0082 J\u0019\u0010;\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010(\u001a\u00020.H\u0082 J\u0011\u0010<\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0011\u0010=\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0006\u0010>\u001a\u00020\u0004J\u001e\u0010?\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010A\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010B\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u0004J\u001a\u0010D\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'J\u001a\u0010E\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'J\u0006\u0010F\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006J\u0016\u0010H\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019J\u001e\u0010I\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019J\"\u0010J\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010.J\u0016\u0010K\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020.J\u001e\u0010L\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020.J\u0006\u0010M\u001a\u00020\u0004J\u0016\u0010N\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020.J\u0016\u0010O\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020.J\u000e\u0010P\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u000fJ\u0016\u0010Q\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.J\u000e\u0010R\u001a\u00020\u00042\u0006\u0010(\u001a\u00020.J\u0014\u0010T\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040SJ\u0006\u0010U\u001a\u00020\u0004J\u0006\u0010V\u001a\u00020\u0004J\u000e\u0010X\u001a\u00020\u00042\u0006\u0010(\u001a\u00020WJ\u000e\u0010C\u001a\u00020\u00042\u0006\u0010(\u001a\u00020YJ \u0010^\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000fH\u0007J\b\u0010_\u001a\u00020\u0004H\u0007J\u0012\u0010a\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010c\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u0002H\u0007R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010dR\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR$\u0010h\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040S\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010gR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010gR\u0014\u0010j\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010d\u00a8\u0006p"}, d2 = {"Lcom/tencent/filament/zplan/engine/FilamentMiniHome;", "", "", "funcName", "", "assertRunningThread", "", "isRunningOnViewerThread", "genViewerThreadAssertMessage", "urlTemplate", "", "nCreateMiniHome", "nativeObject", "nInitV2", "nSetErrorCallback", "", "viewWidth", "viewHeight", "Landroid/view/Surface;", "surface", "nAttach", "nReset", "readPixelsType", "nSetReadPixelsCallback", "nSetStartUpTimeStatCallback", "", "deltaTime", "nUpdate", "nResetRoomAndAvatar", "night", "nToggleNight", "pitchDegree", "yawDegree", "nSetGyroAngleLimit", "roll", "pitch", "yaw", "nSetGyroEuler", "avatarInfo", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "callback", "nSetControlledAvatar", "roomJson", "nLoadUserRoom", "slot", "decorateJson", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeMessageCallback;", "nReplaceDecorate", "nSelectDecorate", "viewportX", "viewportY", "nSelectDecorateRaycast", "nCancelSelectDecorate", "nDeleteDecorate", "nRotateDecorate", "mode", "nSetCameraMode", "needRoomJSONData", "nGetRoomConfig", "nGetDecorateScreenPosition", "nFlushAndWait", "nDestroy", "initV2", "attach", "update", "setReadPixelsCallback", "setStartUpTimeStatCallback", "setErrorCallback", "loadUserRoom", "setControlledAvatar", "resetRoomAndAvatar", "toggleNight", "setGyroAngleLimit", "setGyroEuler", "replaceDecorate", "selectDecorate", "selectDecorateRaycast", "cancelSelectDecorate", "deleteDecorate", "rotateDecorate", "setCameraMode", "getRoomConfig", "getDecorateScreenPosition", "Lkotlin/Function0;", "flushAndWait", "reset", "destroy", "Lcom/tencent/filament/zplan/c;", "setMiniHomeEventUpdateCallback", "Lcom/tencent/filament/zplan/engine/FilamentMiniHome$b;", "", "pixels", "width", "height", "onPixelsUpdated", "onFlushAndWaitCallback", "errMsg", "onMiniHomeErrorCallback", "timeCostStatJSONString", "onStartUpTimeStatCallback", "J", "Ljava/lang/ref/WeakReference;", "miniHomeCallbackWeakReference", "Ljava/lang/ref/WeakReference;", "flushAndWaitCallbackWeakReference", "miniHomeErrorCallbackWeakReference", "viewerThreadId", "<init>", "(JLjava/lang/String;)V", "Companion", "a", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentMiniHome {

    @NotNull
    public static final String TAG = "FilamentMiniHome";
    private WeakReference<Function0<Unit>> flushAndWaitCallbackWeakReference;
    private WeakReference<c> miniHomeCallbackWeakReference;
    private WeakReference<b> miniHomeErrorCallbackWeakReference;
    private long nativeObject;
    private final long viewerThreadId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/engine/FilamentMiniHome$b;", "", "", "errMsg", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface b {
        void a(@Nullable String errMsg);
    }

    public FilamentMiniHome(long j3, @NotNull String urlTemplate) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        this.viewerThreadId = j3;
        this.nativeObject = nCreateMiniHome(urlTemplate);
    }

    private final void assertRunningThread(String funcName) {
        isRunningOnViewerThread();
    }

    private final String genViewerThreadAssertMessage(String funcName) {
        return "Assertion failed. " + funcName + " must run on which thread the instance has been created";
    }

    private final boolean isRunningOnViewerThread() {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        if (currentThread.getId() == this.viewerThreadId) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void loadUserRoom$default(FilamentMiniHome filamentMiniHome, String str, IMiniHomeLoadCallback iMiniHomeLoadCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iMiniHomeLoadCallback = null;
        }
        filamentMiniHome.loadUserRoom(str, iMiniHomeLoadCallback);
    }

    private final native void nAttach(long nativeObject, int viewWidth, int viewHeight, Surface surface);

    private final native void nCancelSelectDecorate(long nativeObject);

    private final native long nCreateMiniHome(String urlTemplate);

    private final native void nDeleteDecorate(long nativeObject, String slot, IMiniHomeMessageCallback callback);

    private final native void nDestroy(long nativeObject);

    private final native void nFlushAndWait(long nativeObject);

    private final native void nGetDecorateScreenPosition(long nativeObject, IMiniHomeMessageCallback callback);

    private final native void nGetRoomConfig(long nativeObject, boolean needRoomJSONData, IMiniHomeMessageCallback callback);

    private final native void nInitV2(long nativeObject);

    private final native void nLoadUserRoom(long nativeObject, String roomJson, IMiniHomeLoadCallback callback);

    private final native void nReplaceDecorate(long nativeObject, String slot, String decorateJson, IMiniHomeMessageCallback callback);

    private final native void nReset(long nativeObject);

    private final native void nResetRoomAndAvatar(long nativeObject);

    private final native void nRotateDecorate(long nativeObject, String slot, IMiniHomeMessageCallback callback);

    private final native void nSelectDecorate(long nativeObject, String slot, IMiniHomeMessageCallback callback);

    private final native void nSelectDecorateRaycast(long nativeObject, int viewportX, int viewportY, IMiniHomeMessageCallback callback);

    private final native void nSetCameraMode(long nativeObject, int mode);

    private final native void nSetControlledAvatar(long nativeObject, String avatarInfo, IMiniHomeLoadCallback callback);

    private final native void nSetErrorCallback(long nativeObject);

    private final native void nSetGyroAngleLimit(long nativeObject, float pitchDegree, float yawDegree);

    private final native void nSetGyroEuler(long nativeObject, float roll, float pitch, float yaw);

    private final native void nSetReadPixelsCallback(long nativeObject, int readPixelsType);

    private final native void nSetStartUpTimeStatCallback(long nativeObject);

    private final native void nToggleNight(long nativeObject, boolean night);

    private final native void nUpdate(long nativeObject, float deltaTime);

    public static /* synthetic */ void replaceDecorate$default(FilamentMiniHome filamentMiniHome, String str, String str2, IMiniHomeMessageCallback iMiniHomeMessageCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            iMiniHomeMessageCallback = null;
        }
        filamentMiniHome.replaceDecorate(str, str2, iMiniHomeMessageCallback);
    }

    public static /* synthetic */ void setControlledAvatar$default(FilamentMiniHome filamentMiniHome, String str, IMiniHomeLoadCallback iMiniHomeLoadCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iMiniHomeLoadCallback = null;
        }
        filamentMiniHome.setControlledAvatar(str, iMiniHomeLoadCallback);
    }

    public static /* synthetic */ void setReadPixelsCallback$default(FilamentMiniHome filamentMiniHome, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        filamentMiniHome.setReadPixelsCallback(i3);
    }

    public final void attach(int viewWidth, int viewHeight, @NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        assertRunningThread("attach");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nAttach");
        nAttach(this.nativeObject, viewWidth, viewHeight, surface);
    }

    public final void cancelSelectDecorate() {
        assertRunningThread("cancelSelectDecorate");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "cancelSelectDecorate");
        nCancelSelectDecorate(this.nativeObject);
    }

    public final void deleteDecorate(@NotNull String slot, @NotNull IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("deleteDecorate");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "deleteDecorate");
        nDeleteDecorate(this.nativeObject, slot, callback);
    }

    public final void destroy() {
        assertRunningThread("destroy");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nDestroy");
        nDestroy(this.nativeObject);
        this.nativeObject = 0L;
    }

    public final void flushAndWait(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("flushAndWait");
        if (this.nativeObject == 0) {
            return;
        }
        this.flushAndWaitCallbackWeakReference = new WeakReference<>(callback);
        nFlushAndWait(this.nativeObject);
    }

    public final void getDecorateScreenPosition(@NotNull IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("getDecorateScreenPosition");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "getDecorateScreenPosition");
        nGetDecorateScreenPosition(this.nativeObject, callback);
    }

    public final void getRoomConfig(boolean needRoomJSONData, @NotNull IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("getRoomConfig");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "getRoomConfig");
        nGetRoomConfig(this.nativeObject, needRoomJSONData, callback);
    }

    public final void initV2() {
        assertRunningThread("initV2");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nInitV2");
        nInitV2(this.nativeObject);
    }

    public final void loadUserRoom(@NotNull String roomJson, @Nullable IMiniHomeLoadCallback callback) {
        Intrinsics.checkNotNullParameter(roomJson, "roomJson");
        assertRunningThread("loadUserRoom");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nLoadUserRoom");
        nLoadUserRoom(this.nativeObject, roomJson, callback);
    }

    @NativeMethodProxy
    public final void onFlushAndWaitCallback() {
        Function0<Unit> function0;
        FLog.INSTANCE.i(TAG, "onFlushAndWaitCallback");
        WeakReference<Function0<Unit>> weakReference = this.flushAndWaitCallbackWeakReference;
        if (weakReference != null && (function0 = weakReference.get()) != null) {
            function0.invoke();
        }
    }

    @NativeMethodProxy
    public final void onMiniHomeErrorCallback(@Nullable String errMsg) {
        b bVar;
        FLog.INSTANCE.e(TAG, "onMiniHomeErrorCallback " + errMsg);
        WeakReference<b> weakReference = this.miniHomeErrorCallbackWeakReference;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.a(errMsg);
        }
    }

    @NativeMethodProxy
    public final void onPixelsUpdated(@NotNull byte[] pixels, int width, int height) {
        c cVar;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        FLog.INSTANCE.i(TAG, "onPixelsUpdated, pixels: " + pixels.length + ", " + width + ", " + height);
        WeakReference<c> weakReference = this.miniHomeCallbackWeakReference;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            cVar.b(pixels, width, height);
        }
    }

    @NativeMethodProxy
    public final void onStartUpTimeStatCallback(@NotNull String timeCostStatJSONString) {
        c cVar;
        Intrinsics.checkNotNullParameter(timeCostStatJSONString, "timeCostStatJSONString");
        FLog.INSTANCE.e(TAG, "onStartUpTimeStatCallback " + timeCostStatJSONString);
        WeakReference<c> weakReference = this.miniHomeCallbackWeakReference;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            cVar.a(timeCostStatJSONString);
        }
    }

    public final void replaceDecorate(@NotNull String slot, @NotNull String decorateJson, @Nullable IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(decorateJson, "decorateJson");
        assertRunningThread("replaceDecorate");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "replaceDecorate slot: " + slot);
        nReplaceDecorate(this.nativeObject, slot, decorateJson, callback);
    }

    public final void reset() {
        assertRunningThread("reset");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nReset");
        nReset(this.nativeObject);
    }

    public final void resetRoomAndAvatar() {
        assertRunningThread("resetRoomAndAvatar");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nResetRoomAndAvatar");
        nResetRoomAndAvatar(this.nativeObject);
    }

    public final void rotateDecorate(@NotNull String slot, @NotNull IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("rotateDecorate");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "rotateDecorate");
        nRotateDecorate(this.nativeObject, slot, callback);
    }

    public final void selectDecorate(@NotNull String slot, @NotNull IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("selectDecorate");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "selectDecorate");
        nSelectDecorate(this.nativeObject, slot, callback);
    }

    public final void selectDecorateRaycast(int viewportX, int viewportY, @NotNull IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("selectDecorateRaycast");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "selectDecorateRaycast");
        nSelectDecorateRaycast(this.nativeObject, viewportX, viewportY, callback);
    }

    public final void setCameraMode(int mode) {
        assertRunningThread("setCameraMode");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setCameraMode " + mode);
        nSetCameraMode(this.nativeObject, mode);
    }

    public final void setControlledAvatar(@NotNull String avatarInfo, @Nullable IMiniHomeLoadCallback callback) {
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        assertRunningThread("setControlledAvatar");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nSetControlledAvatar");
        nSetControlledAvatar(this.nativeObject, avatarInfo, callback);
    }

    public final void setErrorCallback() {
        assertRunningThread("setErrorCallback");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nSetErrorCallback");
        nSetErrorCallback(this.nativeObject);
    }

    public final void setGyroAngleLimit(float pitchDegree, float yawDegree) {
        assertRunningThread("setGyroAngleLimit");
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nSetGyroAngleLimit(j3, pitchDegree, yawDegree);
    }

    public final void setGyroEuler(float roll, float pitch, float yaw) {
        assertRunningThread("setGyroEuler");
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nSetGyroEuler(j3, roll, pitch, yaw);
    }

    public final void setMiniHomeEventUpdateCallback(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.miniHomeCallbackWeakReference = new WeakReference<>(callback);
    }

    public final void setReadPixelsCallback(int readPixelsType) {
        assertRunningThread("setReadPixelsCallback");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nSetReadPixelsCallback");
        nSetReadPixelsCallback(this.nativeObject, readPixelsType);
    }

    public final void setStartUpTimeStatCallback() {
        assertRunningThread("setStartUpTimeStatCallback");
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nSetStartUpTimeStatCallback");
        nSetStartUpTimeStatCallback(this.nativeObject);
    }

    public final void toggleNight(boolean night) {
        assertRunningThread("toggleNight");
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nToggleNight(j3, night);
    }

    public final void update(float deltaTime) {
        assertRunningThread("update");
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nUpdate(j3, deltaTime);
    }

    public final void setErrorCallback(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.miniHomeErrorCallbackWeakReference = new WeakReference<>(callback);
    }
}
