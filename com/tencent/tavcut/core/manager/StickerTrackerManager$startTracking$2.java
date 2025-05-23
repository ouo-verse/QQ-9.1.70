package com.tencent.tavcut.core.manager;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.utils.c;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.light.bean.Texture;
import org.light.callback.ExternalRenderCallback;
import org.light.gles.SimpleGLThread;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/tavcut/core/manager/StickerTrackerManager$startTracking$2", "Lorg/light/callback/ExternalRenderCallback;", "onRender", "", "input", "Lorg/light/bean/Texture;", "key", "", "data", "output", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class StickerTrackerManager$startTracking$2 implements ExternalRenderCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StickerTrackerManager f374317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerTrackerManager$startTracking$2(StickerTrackerManager stickerTrackerManager) {
        this.f374317a = stickerTrackerManager;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.graphics.Bitmap] */
    @Override // org.light.callback.ExternalRenderCallback
    public void onRender(@NotNull Texture input, @NotNull String key, @NotNull final String data, @NotNull Texture output) {
        String str;
        StickerTrackerManager.StickerTrackerManagerState stickerTrackerManagerState;
        SimpleGLThread simpleGLThread;
        SimpleGLThread simpleGLThread2;
        Intrinsics.checkParameterIsNotNull(input, "input");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(output, "output");
        str = this.f374317a.EXTERNAL_RENDER_KEY;
        if (Intrinsics.areEqual(key, str)) {
            stickerTrackerManagerState = this.f374317a.status;
            if (stickerTrackerManagerState == StickerTrackerManager.StickerTrackerManagerState.Working) {
                if (this.f374317a.isFirstFrame) {
                    if (this.f374317a.keyFrameTimeUs.size() > 0) {
                        this.f374317a.isFirstFrame = false;
                        this.f374317a.Y(Long.parseLong(data));
                    } else {
                        return;
                    }
                }
                simpleGLThread = this.f374317a.glThread;
                if (simpleGLThread == null) {
                    this.f374317a.glThread = new SimpleGLThread(EGL14.eglGetCurrentContext(), "StickerTrackerDetect");
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = c.h(input);
                simpleGLThread2 = this.f374317a.glThread;
                if (simpleGLThread2 != null) {
                    simpleGLThread2.postJob(new Runnable() { // from class: com.tencent.tavcut.core.manager.StickerTrackerManager$startTracking$2$onRender$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean z16;
                            Set set;
                            List list;
                            Set set2;
                            long j3;
                            Set set3;
                            Set set4;
                            long parseLong = Long.parseLong(data);
                            if (parseLong <= StickerTrackerManager$startTracking$2.this.f374317a.detectTime) {
                                j3 = StickerTrackerManager$startTracking$2.this.f374317a.lastDetectTimaStamp;
                                if (parseLong < j3) {
                                    StickerTrackerManager$startTracking$2.this.f374317a.S();
                                    StickerTrackerManager$startTracking$2.this.f374317a.lastDetectTimaStamp = parseLong;
                                }
                                set3 = StickerTrackerManager$startTracking$2.this.f374317a.trackerTimeStampRecord;
                                if (!set3.contains(Long.valueOf(parseLong))) {
                                    StickerTrackerManager$startTracking$2.this.f374317a.R(c.d((Bitmap) objectRef.element), parseLong);
                                    set4 = StickerTrackerManager$startTracking$2.this.f374317a.trackerTimeStampRecord;
                                    set4.add(Long.valueOf(parseLong));
                                    StickerTrackerManager$startTracking$2.this.f374317a.lastDetectTimaStamp = parseLong;
                                }
                                if (Math.abs(parseLong - StickerTrackerManager$startTracking$2.this.f374317a.X().getStickerStartTime()) < 100000) {
                                    StickerTrackerManager$startTracking$2.this.f374317a.isDetectReversing = false;
                                    return;
                                }
                                return;
                            }
                            z16 = StickerTrackerManager$startTracking$2.this.f374317a.isDetectReversing;
                            if (!z16) {
                                StickerTrackerManager$startTracking$2.this.f374317a.S();
                                set = StickerTrackerManager$startTracking$2.this.f374317a.trackerTimeStampRecord;
                                if (!set.contains(Long.valueOf(parseLong))) {
                                    list = StickerTrackerManager$startTracking$2.this.f374317a.totalFrameStack;
                                    list.add(new StickerTrackerManager.a(c.d((Bitmap) objectRef.element), parseLong, null, false, 12, null));
                                    set2 = StickerTrackerManager$startTracking$2.this.f374317a.trackerTimeStampRecord;
                                    set2.add(Long.valueOf(parseLong));
                                    StickerTrackerManager$startTracking$2.this.f374317a.lastDetectTimaStamp = parseLong;
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
