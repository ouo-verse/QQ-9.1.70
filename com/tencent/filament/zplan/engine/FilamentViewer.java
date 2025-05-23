package com.tencent.filament.zplan.engine;

import android.graphics.PointF;
import android.view.Surface;
import androidx.annotation.Keep;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.d;
import com.tencent.filament.zplan.data.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 x2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bv\u0010wJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0082 J!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0082 J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J!\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0082 J\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J-\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0082 J+\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0082 J9\u0010\"\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0082 J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u0019\u0010%\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0001H\u0082 J&\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002H\u0082 \u00a2\u0006\u0004\b)\u0010*J!\u0010-\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0082 J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 JD\u00104\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u0002000'2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020'2\u0006\u00103\u001a\u00020\u0010H\u0082 \u00a2\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J1\u0010<\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u000209H\u0082 JA\u0010?\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\u0006\u0010=\u001a\u0002092\u0006\u0010>\u001a\u000209H\u0082 J)\u0010C\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010@\u001a\u0002092\u0006\u0010A\u001a\u0002092\u0006\u0010B\u001a\u000209H\u0082 J\u0019\u0010E\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002H\u0082 J\u0019\u0010F\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002H\u0082 J\u0011\u0010G\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u000e\u0010H\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010I\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010J\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010J*\u0010N\u001a\u00020\u00072\"\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020Kj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`LJ\"\u0010O\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002J \u0010Q\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010P\u001a\u00020\u001bJ.\u0010R\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fJ\u0006\u0010S\u001a\u00020\u0007J\u0006\u0010T\u001a\u00020\u0007J\u000e\u0010W\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UJ\u001b\u0010X\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010YJ\u0016\u0010Z\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+J\u0006\u0010[\u001a\u00020\u0007J\u0006\u0010\\\u001a\u00020\u0007J\u0006\u0010]\u001a\u00020\u0007J9\u0010^\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u0002000'2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020'2\u0006\u00103\u001a\u00020\u0010\u00a2\u0006\u0004\b^\u0010_J\u0006\u0010`\u001a\u00020\u0007J\u000e\u0010c\u001a\u00020\u00072\u0006\u0010b\u001a\u00020aJ\u0016\u0010f\u001a\u00020\u00072\u0006\u0010e\u001a\u00020d2\u0006\u0010B\u001a\u000209J\u0006\u0010g\u001a\u00020\u0007J\u000e\u0010i\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0002J\u000e\u0010k\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0002J\"\u0010n\u001a\u00020\u00072\b\u0010m\u001a\u0004\u0018\u00010l2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u000e\u0010q\u001a\u00020\u00072\u0006\u0010p\u001a\u00020oR\u0016\u0010r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010u\u00a8\u0006y"}, d2 = {"Lcom/tencent/filament/zplan/engine/FilamentViewer;", "", "", "filamatRootPath", "", "nCreateViewer", "nativeViewer", "", "nLoadSpotLight", "nLoadSun", "iblPath", "nLoadLight", "", "width", "height", "nUpdateViewport", "", "needRecord", "nRender", "slot", "path", "nUpdateAvatar", "nReloadAvatar", "slotName", "textureAbsPath", "jsonAbsPath", "nUpdateMakeupSlotTexture", "", "asset", "nUpdateMakeupSlotTextureWithOffset", "r", "g", "b", "a", "nUpdateMakeupSlotColor", "nDestroy", "nativeWindow", "nCreateSwapChain", "animationGltfPath", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "nLoadAnimation", "(JLjava/lang/String;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "", "now", "nPlayAnimation", "nCleanAvatar", "pinchFaceConfigPath", "Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;", "pinchFaceModels", "itemIdArray", "isFemale", "nLoadPinchFaceConfig", "(JLjava/lang/String;[Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;[Ljava/lang/String;Z)V", "nApplyPinchFace", "state", "touchCount", "", "locationX", "locationY", "nDidPan", "velocity", "scale", "nDidPinch", "centerLocationX", "centerLocationY", "scrolldelta", "nScrollCamera", "filePath", "nSetLutPath", "nSetPhysicPath", "nResetCamera", "loadLight", "updateViewport", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "resourceModel", "updateAvatar", "updateMakeupSlotTexture", "offset", "updateMakeupSlotTextureWithOffset", "updateMakeupSlotColor", "reloadAvatar", "destroy", "Landroid/view/Surface;", "surface", "createSwapChain", "loadAnimation", "(Ljava/lang/String;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", QZoneJsConstants.METHOD_PLAY, "loadSpotLight", "loadSun", "cleanAvatar", "loadPinchFaceConfig", "(Ljava/lang/String;[Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;[Ljava/lang/String;Z)V", "applyPinchFace", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "receiveTouchEvent", "Landroid/graphics/PointF;", "centerLocation", "scrollCamera", "resetCamera", "lutPath", "loadLut", "physicPath", "loadPhysic", "", "pixels", "onReocrdFrame", "Lcom/tencent/filament/zplan/d;", "listener", "recordFrame", "nativeObject", "J", "recordFrameListener", "Lcom/tencent/filament/zplan/d;", "<init>", "(Ljava/lang/String;)V", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentViewer {
    private static final String TAG = "FilamentViewer";
    private long nativeObject;
    private d recordFrameListener;

    public FilamentViewer(@NotNull String filamatRootPath) {
        Intrinsics.checkNotNullParameter(filamatRootPath, "filamatRootPath");
        this.nativeObject = nCreateViewer(filamatRootPath);
    }

    private final native void nApplyPinchFace(long nativeViewer);

    private final native void nCleanAvatar(long nativeViewer);

    private final native void nCreateSwapChain(long nativeViewer, Object nativeWindow);

    private final native long nCreateViewer(String filamatRootPath);

    private final native void nDestroy(long nativeViewer);

    private final native void nDidPan(long nativeViewer, int state, int touchCount, float locationX, float locationY);

    private final native void nDidPinch(long nativeViewer, int state, int touchCount, float locationX, float locationY, float velocity, float scale);

    private final native FilamentAnimation[] nLoadAnimation(long nativeViewer, String animationGltfPath);

    private final native long nLoadLight(long nativeViewer, String iblPath);

    private final native void nLoadPinchFaceConfig(long nativeViewer, String pinchFaceConfigPath, ZPlanPinchFaceModel[] pinchFaceModels, String[] itemIdArray, boolean isFemale);

    private final native void nLoadSpotLight(long nativeViewer);

    private final native void nLoadSun(long nativeViewer);

    private final native void nPlayAnimation(long nativeViewer, String animationGltfPath, double now);

    private final native void nReloadAvatar(long nativeViewer);

    private final native boolean nRender(long nativeViewer, boolean needRecord);

    private final native void nResetCamera(long nativeViewer);

    private final native void nScrollCamera(long nativeViewer, float centerLocationX, float centerLocationY, float scrolldelta);

    private final native void nSetLutPath(long nativeViewer, String filePath);

    private final native void nSetPhysicPath(long nativeViewer, String filePath);

    private final native void nUpdateAvatar(long nativeViewer, String slot, String path);

    private final native void nUpdateMakeupSlotColor(long nativeViewer, String slotName, int r16, int g16, int b16, int a16);

    private final native void nUpdateMakeupSlotTexture(long nativeViewer, String slotName, String textureAbsPath, String jsonAbsPath);

    private final native void nUpdateMakeupSlotTextureWithOffset(long nativeViewer, String slotName, String textureAbsPath, float[] asset);

    private final native void nUpdateViewport(long nativeViewer, int width, int height);

    public static /* synthetic */ boolean render$default(FilamentViewer filamentViewer, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return filamentViewer.render(z16);
    }

    public final void applyPinchFace() {
        nApplyPinchFace(this.nativeObject);
    }

    public final void cleanAvatar() {
        nCleanAvatar(this.nativeObject);
    }

    public final void createSwapChain(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        nCreateSwapChain(this.nativeObject, surface);
    }

    public final void destroy() {
        long j3 = this.nativeObject;
        if (j3 != 0) {
            nDestroy(j3);
            this.nativeObject = 0L;
        }
    }

    @NotNull
    public final FilamentAnimation[] loadAnimation(@NotNull String animationGltfPath) {
        Intrinsics.checkNotNullParameter(animationGltfPath, "animationGltfPath");
        return nLoadAnimation(this.nativeObject, animationGltfPath);
    }

    public final void loadLight(@NotNull String iblPath) {
        Intrinsics.checkNotNullParameter(iblPath, "iblPath");
        nLoadLight(this.nativeObject, iblPath);
    }

    public final void loadLut(@NotNull String lutPath) {
        Intrinsics.checkNotNullParameter(lutPath, "lutPath");
        FLog.INSTANCE.i(TAG, "Load Lut with file: " + lutPath);
        nSetLutPath(this.nativeObject, lutPath);
    }

    public final void loadPhysic(@NotNull String physicPath) {
        Intrinsics.checkNotNullParameter(physicPath, "physicPath");
        FLog.INSTANCE.i(TAG, "Load Physic with file: " + physicPath);
        nSetPhysicPath(this.nativeObject, physicPath);
    }

    public final void loadPinchFaceConfig(@NotNull String pinchFaceConfigPath, @NotNull ZPlanPinchFaceModel[] pinchFaceModels, @NotNull String[] itemIdArray, boolean isFemale) {
        Intrinsics.checkNotNullParameter(pinchFaceConfigPath, "pinchFaceConfigPath");
        Intrinsics.checkNotNullParameter(pinchFaceModels, "pinchFaceModels");
        Intrinsics.checkNotNullParameter(itemIdArray, "itemIdArray");
        nLoadPinchFaceConfig(this.nativeObject, pinchFaceConfigPath, pinchFaceModels, itemIdArray, isFemale);
    }

    public final void loadSpotLight() {
        nLoadSpotLight(this.nativeObject);
    }

    public final void loadSun() {
        nLoadSun(this.nativeObject);
    }

    @NativeMethodProxy
    public final void onReocrdFrame(@Nullable byte[] pixels, int width, int height) {
        Integer num;
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReocrdFrame, pixels: ");
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
        d dVar = this.recordFrameListener;
        if (dVar != null) {
            dVar.a(pixels, width, height);
        }
    }

    public final void playAnimation(@NotNull String animationGltfPath, double now) {
        Intrinsics.checkNotNullParameter(animationGltfPath, "animationGltfPath");
        nPlayAnimation(this.nativeObject, animationGltfPath, now);
    }

    public final void receiveTouchEvent(@NotNull TouchEvent event) {
        float f16;
        Intrinsics.checkNotNullParameter(event, "event");
        FLog.INSTANCE.i(TAG, "receiveTouchEvent, touchEvent: " + event);
        int touchEventIntState = event.getState().toTouchEventIntState();
        int touchCount = event.getTouchCount();
        float f17 = event.getLocation().x;
        float f18 = event.getLocation().y;
        Float velocity = event.getVelocity();
        Float scale = event.getScale();
        if (event.getType() == TouchEventType.Pan) {
            nDidPan(this.nativeObject, touchEventIntState, touchCount, f17, f18);
            return;
        }
        if (event.getType() != TouchEventType.Pinch || scale == null) {
            return;
        }
        long j3 = this.nativeObject;
        if (velocity != null) {
            f16 = velocity.floatValue();
        } else {
            f16 = 0.0f;
        }
        nDidPinch(j3, touchEventIntState, touchCount, f17, f18, f16, scale.floatValue());
    }

    public final void recordFrame(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.recordFrameListener = listener;
    }

    public final void reloadAvatar() {
        nReloadAvatar(this.nativeObject);
    }

    public final boolean render(boolean needRecord) {
        return nRender(this.nativeObject, needRecord);
    }

    public final void resetCamera() {
        FLog.INSTANCE.i(TAG, "resetCamera.");
        nResetCamera(this.nativeObject);
    }

    public final void scrollCamera(@NotNull PointF centerLocation, float scrolldelta) {
        Intrinsics.checkNotNullParameter(centerLocation, "centerLocation");
        FLog.INSTANCE.i(TAG, "scrollCamera, centerLocation: " + centerLocation + ", scrolldelta: " + scrolldelta);
        nScrollCamera(this.nativeObject, centerLocation.x, centerLocation.y, scrolldelta);
    }

    public final void updateAvatar(@NotNull HashMap<String, String> resourceModel) {
        Intrinsics.checkNotNullParameter(resourceModel, "resourceModel");
        for (Map.Entry<String, String> entry : resourceModel.entrySet()) {
            nUpdateAvatar(this.nativeObject, entry.getKey(), entry.getValue());
        }
    }

    public final void updateMakeupSlotColor(@NotNull String slotName, int r16, int g16, int b16, int a16) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        nUpdateMakeupSlotColor(this.nativeObject, slotName, r16, g16, b16, a16);
    }

    public final void updateMakeupSlotTexture(@NotNull String slotName, @Nullable String textureAbsPath, @Nullable String jsonAbsPath) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        nUpdateMakeupSlotTexture(this.nativeObject, slotName, textureAbsPath, jsonAbsPath);
    }

    public final void updateMakeupSlotTextureWithOffset(@NotNull String slotName, @Nullable String textureAbsPath, @NotNull float[] offset) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        Intrinsics.checkNotNullParameter(offset, "offset");
        nUpdateMakeupSlotTextureWithOffset(this.nativeObject, slotName, textureAbsPath, offset);
    }

    public final void updateViewport(int width, int height) {
        nUpdateViewport(this.nativeObject, width, height);
    }
}
