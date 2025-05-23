package com.tencent.filament.zplan.engine;

import android.graphics.Point;
import androidx.annotation.Keep;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.avatar.model.Float3;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import com.tencent.zplan.common.utils.GsonUtil;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 n2\u00020\u0001:\u0001oB\u0011\u0012\b\b\u0002\u0010k\u001a\u00020j\u00a2\u0006\u0004\bl\u0010mJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\u000e\u001a\u00060\tj\u0002`\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0082 J5\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0082 J%\u0010\u0012\u001a\u00060\tj\u0002`\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0082 J5\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0082 J%\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010\u0015\u001a\u00020\u0002H\u0082 J\u001d\u0010\u0017\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\tj\u0002`\rH\u0082 J=\u0010\u001d\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0082 J-\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\rH\u0082 J!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0082 J5\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010 \u001a\u00020\u0002H\u0082 J-\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\rH\u0082 J%\u0010%\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010$\u001a\u00020#H\u0082 J%\u0010'\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010&\u001a\u00020\u0006H\u0082 J%\u0010+\u001a\u00060\tj\u0002`\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0082 J%\u0010.\u001a\u00020-2\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010,\u001a\u00020\u0002H\u0082 J-\u00101\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020/H\u0082 J)\u00105\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u0006H\u0082 J!\u00106\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020(H\u0082 J\u0011\u00107\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0082 J1\u0010;\u001a\u0002082\u0006\u0010\n\u001a\u00020\t2\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020(2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0082 J\u0019\u0010=\u001a\u00020-2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010<\u001a\u000208H\u0082 JM\u0010B\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020(H\u0082 J\u0011\u0010C\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0082 J\u0019\u0010E\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0002H\u0082 J<\u0010H\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020(J\u0014\u0010I\u001a\u00060\tj\u0002`\r2\b\u0010G\u001a\u0004\u0018\u00010FJ$\u0010J\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u0002J\u0014\u0010K\u001a\u00060\tj\u0002`\r2\b\u0010G\u001a\u0004\u0018\u00010FJ$\u0010N\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010M\u001a\u00020LJ\u001a\u0010O\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010\u0015\u001a\u00020\u0002J\u0014\u0010P\u001a\u0004\u0018\u00010\u00022\n\u0010\u000f\u001a\u00060\tj\u0002`\rJ\u001a\u0010S\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010R\u001a\u00020QJ\u001c\u0010T\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\n\u0010\u000f\u001a\u00060\tj\u0002`\rJ\u0010\u0010U\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010FJ$\u0010W\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010 \u001a\u00020VJ\u001c\u0010X\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\n\u0010\u000f\u001a\u00060\tj\u0002`\rJ\u001a\u0010Z\u001a\u00020\u00042\n\u0010Y\u001a\u00060\tj\u0002`\r2\u0006\u0010$\u001a\u00020#J\u001a\u0010[\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010&\u001a\u00020\u0006J\u0012\u0010^\u001a\u00060\tj\u0002`\r2\u0006\u0010]\u001a\u00020\\J\u001c\u0010_\u001a\u0004\u0018\u00010\\2\n\u0010\u000f\u001a\u00060\tj\u0002`\r2\u0006\u0010,\u001a\u00020\u0002J\u0018\u0010`\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u00100\u001a\u00020/J\u0006\u0010a\u001a\u00020\u0004J\u000e\u0010b\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002J\u001e\u0010c\u001a\u00020\u00042\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u0006J\u0016\u0010d\u001a\u00020\u00042\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020(J\u0006\u0010e\u001a\u00020\u0004J \u0010h\u001a\u0004\u0018\u00010g2\u0006\u0010f\u001a\u00020\\2\u0006\u00109\u001a\u00020g2\u0006\u0010:\u001a\u00020gJ\u0010\u0010i\u001a\u0004\u0018\u00010\\2\u0006\u0010<\u001a\u00020g\u00a8\u0006p"}, d2 = {"Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "", "funcName", "", "assertRunningThread", "", "isRunningOnViewerThread", "genViewerThreadAssertMessage", "", "nativeViewer", "traceId", TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "nCreateGltfRenderObject", "renderObjectId", "gltfPath", "nUpdateRenderObjectGltf", "nCreateAvatarRenderObject", "avatarContent", "nUpdateRenderObjectAvatar", "transform", "nSetRenderObjectTransform", "nGetRenderObjectTransform", "", "axisX", "axisY", "axisZ", "angle", "nRotateRenderObject", "nDeleteRenderObject", "nDeleteAllRenderObjects", "track", "nBindAnimationTrack", "nCleanAnimationTracks", "", "now", "nApplyAnimation", "hittable", "nSetRenderObjectHittable", "", "viewportX", "viewportY", "nGetHitRenderObjectIDAt", "nodeName", "", "nGetNodeCoordinateForRenderObject", "Lcom/tencent/filament/zplan/engine/RenderCallback;", "callback", "nRender", HippyTKDListViewAdapter.X, "y", "strafe", "nGrabCameraManipulatorBegin", "nGrabCameraManipulatorUpdate", "nGrabCameraManipulatorEnd", "", "planePoint", "planeNormal", "nProjectPointOntoPlane", "worldLocation", "nWorldLocationToViewportPoint", "parameterName", "texture", "path", "colorSpace", "nSetRenderObjectParameterSampler2D", "nGarbageCollect", "jsonString", "nSetShadowPlane", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "setRenderObjectParameter", "createGltfRenderObject", "updateRenderObjectGltf", "createAvatarRenderObject", "Lorg/json/JSONObject;", "avatar", "updateRenderObjectAvatar", "setRenderObjectTransform", "getRenderObjectTransform", "Lcom/tencent/filament/zplan/view/event/a;", "rotateParam", "rotateRenderObject", "deleteRenderObject", "deleteAllRenderObject", "Lcom/tencent/filament/zplan/animation/sequencer/Track;", "bindAnimationTrack", "cleanAnimationTracks", "objectId", "applyAnimation", "setRenderObjectHittable", "Landroid/graphics/Point;", "viewportPoint", "getHitRenderObjectIDAt", "getNodeCoordinateForRenderObject", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "garbageCollect", "setShadowPlane", "grabCameraManipulatorBegin", "grabCameraManipulatorUpdate", "grabCameraManipulatorEnd", "point", "Lcom/tencent/filament/zplan/avatar/model/Float3;", "projectPointOntoPlane", "worldLocationToViewportPoint", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentViewerV2305 extends FilamentViewerV2 {

    @NotNull
    public static final String TAG = "FilamentViewerV2New";

    public FilamentViewerV2305() {
        this(null, 1, 0 == true ? 1 : 0);
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
        if (currentThread.getId() == getViewerThreadId()) {
            return true;
        }
        return false;
    }

    private final native void nApplyAnimation(long nativeViewer, long renderObjectId, double now);

    private final native void nBindAnimationTrack(long nativeViewer, String traceId, String spanId, long renderObjectId, String track);

    private final native void nCleanAnimationTracks(long nativeViewer, String traceId, String spanId, long renderObjectId);

    private final native long nCreateAvatarRenderObject(long nativeViewer, String traceId, String spanId);

    private final native long nCreateGltfRenderObject(long nativeViewer, String traceId, String spanId);

    private final native void nDeleteAllRenderObjects(long nativeViewer, String traceId, String spanId);

    private final native void nDeleteRenderObject(long nativeViewer, String traceId, String spanId, long renderObjectId);

    private final native void nGarbageCollect(long nativeViewer);

    private final native long nGetHitRenderObjectIDAt(long nativeViewer, int viewportX, int viewportY);

    private final native int[] nGetNodeCoordinateForRenderObject(long nativeViewer, long renderObjectId, String nodeName);

    private final native String nGetRenderObjectTransform(long nativeViewer, long renderObjectId);

    private final native void nGrabCameraManipulatorBegin(long nativeViewer, int x16, int y16, boolean strafe);

    private final native void nGrabCameraManipulatorEnd(long nativeViewer);

    private final native void nGrabCameraManipulatorUpdate(long nativeViewer, int x16, int y16);

    private final native float[] nProjectPointOntoPlane(long nativeViewer, int x16, int y16, float[] planePoint, float[] planeNormal);

    private final native boolean nRender(long nativeViewer, String traceId, String spanId, RenderCallback callback);

    private final native void nRotateRenderObject(long nativeViewer, long renderObjectId, float axisX, float axisY, float axisZ, float angle);

    private final native void nSetRenderObjectHittable(long nativeViewer, long renderObjectId, boolean hittable);

    private final native void nSetRenderObjectParameterSampler2D(long nativeViewer, String traceId, String spanId, long renderObjectId, String parameterName, String texture, String path, int colorSpace);

    private final native void nSetRenderObjectTransform(long nativeViewer, long renderObjectId, String transform);

    private final native void nSetShadowPlane(long nativeViewer, String jsonString);

    private final native void nUpdateRenderObjectAvatar(long nativeViewer, String traceId, String spanId, long renderObjectId, String avatarContent);

    private final native void nUpdateRenderObjectGltf(long nativeViewer, String traceId, String spanId, long renderObjectId, String gltfPath);

    private final native int[] nWorldLocationToViewportPoint(long nativeViewer, float[] worldLocation);

    public final void applyAnimation(long objectId, double now) {
        assertRunningThread("applyAnimation");
        if (getNativeObject() != 0 && getBooted().get()) {
            nApplyAnimation(getNativeObject(), objectId, now);
        }
    }

    public final void bindAnimationTrack(@Nullable c spanContext, long renderObjectId, @NotNull Track track) {
        String str;
        String str2;
        String str3;
        String traceId;
        Intrinsics.checkNotNullParameter(track, "track");
        assertRunningThread("bindAnimationTrack");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext == null || (traceId = spanContext.getTraceId()) == null) {
                str = "";
            } else {
                str = traceId;
            }
            if (spanContext == null || (str3 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            String json = GsonUtil.f385283b.a().toJson(track);
            Intrinsics.checkNotNullExpressionValue(json, "GsonUtil.gson.toJson(track)");
            nBindAnimationTrack(nativeObject, str, str2, renderObjectId, json);
        }
    }

    public final void cleanAnimationTracks(@Nullable c spanContext, long renderObjectId) {
        String str;
        String str2;
        String str3;
        String traceId;
        assertRunningThread("cleanAnimationTracks");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext == null || (traceId = spanContext.getTraceId()) == null) {
                str = "";
            } else {
                str = traceId;
            }
            if (spanContext == null || (str3 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            nCleanAnimationTracks(nativeObject, str, str2, renderObjectId);
        }
    }

    public final long createAvatarRenderObject(@Nullable c spanContext) {
        String str;
        String str2;
        assertRunningThread("createAvatarRenderObject");
        if (getNativeObject() == 0 || !getBooted().get()) {
            return 0L;
        }
        long nativeObject = getNativeObject();
        String str3 = "";
        if (spanContext == null || (str = spanContext.getTraceId()) == null) {
            str = "";
        }
        if (spanContext != null && (str2 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) != null) {
            str3 = str2;
        }
        return nCreateAvatarRenderObject(nativeObject, str, str3);
    }

    public final long createGltfRenderObject(@Nullable c spanContext) {
        String str;
        String str2;
        assertRunningThread("createGltfRenderObject");
        if (getNativeObject() == 0 || !getBooted().get()) {
            return 0L;
        }
        long nativeObject = getNativeObject();
        String str3 = "";
        if (spanContext == null || (str = spanContext.getTraceId()) == null) {
            str = "";
        }
        if (spanContext != null && (str2 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) != null) {
            str3 = str2;
        }
        return nCreateGltfRenderObject(nativeObject, str, str3);
    }

    public final void deleteAllRenderObject(@Nullable c spanContext) {
        String str;
        String str2;
        assertRunningThread("deleteAllRenderObject");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            String str3 = "";
            if (spanContext == null || (str = spanContext.getTraceId()) == null) {
                str = "";
            }
            if (spanContext != null && (str2 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) != null) {
                str3 = str2;
            }
            nDeleteAllRenderObjects(nativeObject, str, str3);
        }
    }

    public final void deleteRenderObject(@Nullable c spanContext, long renderObjectId) {
        String str;
        String str2;
        String str3;
        String traceId;
        assertRunningThread("deleteRenderObject");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext == null || (traceId = spanContext.getTraceId()) == null) {
                str = "";
            } else {
                str = traceId;
            }
            if (spanContext == null || (str3 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            nDeleteRenderObject(nativeObject, str, str2, renderObjectId);
        }
    }

    public final void garbageCollect() {
        assertRunningThread("garbageCollect");
        if (getNativeObject() != 0 && getBooted().get()) {
            nGarbageCollect(getNativeObject());
        }
    }

    public final long getHitRenderObjectIDAt(@NotNull Point viewportPoint) {
        Intrinsics.checkNotNullParameter(viewportPoint, "viewportPoint");
        assertRunningThread("getHitRenderObjectIDAt");
        if (getNativeObject() == 0 || !getBooted().get()) {
            return 0L;
        }
        return nGetHitRenderObjectIDAt(getNativeObject(), viewportPoint.x, viewportPoint.y);
    }

    @Nullable
    public final Point getNodeCoordinateForRenderObject(long renderObjectId, @NotNull String nodeName) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        if (getNativeObject() == 0 || !getBooted().get()) {
            return null;
        }
        int[] nGetNodeCoordinateForRenderObject = nGetNodeCoordinateForRenderObject(getNativeObject(), renderObjectId, nodeName);
        if (nGetNodeCoordinateForRenderObject.length != 2) {
            return null;
        }
        return new Point(nGetNodeCoordinateForRenderObject[0], nGetNodeCoordinateForRenderObject[1]);
    }

    @Nullable
    public final String getRenderObjectTransform(long renderObjectId) {
        assertRunningThread("getRenderObjectTransform");
        if (getNativeObject() != 0 && getBooted().get()) {
            return nGetRenderObjectTransform(getNativeObject(), renderObjectId);
        }
        return null;
    }

    public final void grabCameraManipulatorBegin(int x16, int y16, boolean strafe) {
        assertRunningThread("grabCameraManipulatorBegin");
        if (getNativeObject() != 0 && getBooted().get()) {
            nGrabCameraManipulatorBegin(getNativeObject(), x16, y16, strafe);
        }
    }

    public final void grabCameraManipulatorEnd() {
        assertRunningThread("grabCameraManipulatorEnd");
        if (getNativeObject() != 0 && getBooted().get()) {
            nGrabCameraManipulatorEnd(getNativeObject());
        }
    }

    public final void grabCameraManipulatorUpdate(int x16, int y16) {
        assertRunningThread("grabCameraManipulatorUpdate");
        if (getNativeObject() != 0 && getBooted().get()) {
            nGrabCameraManipulatorUpdate(getNativeObject(), x16, y16);
        }
    }

    @Nullable
    public final Float3 projectPointOntoPlane(@NotNull Point point, @NotNull Float3 planePoint, @NotNull Float3 planeNormal) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(planePoint, "planePoint");
        Intrinsics.checkNotNullParameter(planeNormal, "planeNormal");
        assertRunningThread("projectPointOntoPlane");
        if (getNativeObject() == 0 || !getBooted().get()) {
            return null;
        }
        float[] nProjectPointOntoPlane = nProjectPointOntoPlane(getNativeObject(), point.x, point.y, planePoint.e(), planeNormal.e());
        if (nProjectPointOntoPlane.length != 3) {
            return null;
        }
        return new Float3(nProjectPointOntoPlane[0], nProjectPointOntoPlane[1], nProjectPointOntoPlane[2]);
    }

    public final boolean render(@Nullable c spanContext, @NotNull RenderCallback callback) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        assertRunningThread("renderWithCallback");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext != null) {
                str = spanContext.getTraceId();
            } else {
                str = null;
            }
            if (spanContext != null) {
                str2 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String();
            } else {
                str2 = null;
            }
            return nRender(nativeObject, str, str2, callback);
        }
        return false;
    }

    public final void rotateRenderObject(long renderObjectId, @NotNull RotateParam rotateParam) {
        Intrinsics.checkNotNullParameter(rotateParam, "rotateParam");
        assertRunningThread("rotateRenderObject");
        if (getNativeObject() != 0 && getBooted().get()) {
            nRotateRenderObject(getNativeObject(), renderObjectId, rotateParam.getAxisX(), rotateParam.getAxisY(), rotateParam.getAxisZ(), rotateParam.getAngle());
        }
    }

    public final void setRenderObjectHittable(long renderObjectId, boolean hittable) {
        assertRunningThread("setRenderObjectHittable");
        if (getNativeObject() != 0 && getBooted().get()) {
            nSetRenderObjectHittable(getNativeObject(), renderObjectId, hittable);
        }
    }

    public final void setRenderObjectParameter(@Nullable c spanContext, long renderObjectId, @NotNull String parameterName, @NotNull String texture, @NotNull String path, int colorSpace) {
        String str;
        String str2;
        String str3;
        String traceId;
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        Intrinsics.checkNotNullParameter(texture, "texture");
        Intrinsics.checkNotNullParameter(path, "path");
        assertRunningThread("setRenderObjectParameter");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext == null || (traceId = spanContext.getTraceId()) == null) {
                str = "";
            } else {
                str = traceId;
            }
            if (spanContext == null || (str3 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            nSetRenderObjectParameterSampler2D(nativeObject, str, str2, renderObjectId, parameterName, texture, path, colorSpace);
        }
    }

    public final void setRenderObjectTransform(long renderObjectId, @NotNull String transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        assertRunningThread("setRenderObjectTransform");
        if (getNativeObject() != 0 && getBooted().get()) {
            nSetRenderObjectTransform(getNativeObject(), renderObjectId, transform);
        }
    }

    public final void setShadowPlane(@NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        checkAndLogRunningThread();
        if (getNativeObject() != 0 && getBooted().get()) {
            nSetShadowPlane(getNativeObject(), jsonString);
        }
    }

    public final void updateRenderObjectAvatar(@Nullable c spanContext, long renderObjectId, @NotNull JSONObject avatar) {
        String str;
        String str2;
        String str3;
        String traceId;
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        assertRunningThread("updateRenderObjectAvatar");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext == null || (traceId = spanContext.getTraceId()) == null) {
                str = "";
            } else {
                str = traceId;
            }
            if (spanContext == null || (str3 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            String jSONObject = avatar.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "avatar.toString()");
            nUpdateRenderObjectAvatar(nativeObject, str, str2, renderObjectId, jSONObject);
        }
    }

    public final void updateRenderObjectGltf(@Nullable c spanContext, long renderObjectId, @NotNull String gltfPath) {
        String str;
        String str2;
        String str3;
        String traceId;
        Intrinsics.checkNotNullParameter(gltfPath, "gltfPath");
        assertRunningThread("updateRenderObjectGltf");
        if (getNativeObject() != 0 && getBooted().get()) {
            long nativeObject = getNativeObject();
            if (spanContext == null || (traceId = spanContext.getTraceId()) == null) {
                str = "";
            } else {
                str = traceId;
            }
            if (spanContext == null || (str3 = spanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            nUpdateRenderObjectGltf(nativeObject, str, str2, renderObjectId, gltfPath);
        }
    }

    @Nullable
    public final Point worldLocationToViewportPoint(@NotNull Float3 worldLocation) {
        Intrinsics.checkNotNullParameter(worldLocation, "worldLocation");
        assertRunningThread("wordToViewport");
        if (getNativeObject() == 0 || !getBooted().get()) {
            return null;
        }
        int[] nWorldLocationToViewportPoint = nWorldLocationToViewportPoint(getNativeObject(), worldLocation.e());
        if (nWorldLocationToViewportPoint.length != 2) {
            return null;
        }
        return new Point(nWorldLocationToViewportPoint[0], nWorldLocationToViewportPoint[1]);
    }

    public /* synthetic */ FilamentViewerV2305(CoroutineContext coroutineContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.getDefault() : coroutineContext);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FilamentViewerV2305(@NotNull CoroutineContext context) {
        super(r0.getId(), context);
        Intrinsics.checkNotNullParameter(context, "context");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
    }
}
