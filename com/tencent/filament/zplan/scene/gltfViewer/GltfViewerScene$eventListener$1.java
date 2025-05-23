package com.tencent.filament.zplan.scene.gltfViewer;

import com.google.gson.Gson;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/gltfViewer/GltfViewerScene$eventListener$1", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GltfViewerScene$eventListener$1 implements b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ GltfViewerScene f105960d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GltfViewerScene$eventListener$1(GltfViewerScene gltfViewerScene) {
        this.f105960d = gltfViewerScene;
    }

    @Override // sk0.b
    public void handleEvent(@Nullable c spanContext, @NotNull String type, @Nullable String data) {
        JSONObject jSONObject;
        String optString;
        Intrinsics.checkNotNullParameter(type, "type");
        FLog.INSTANCE.i("GltfViewerScene", "handleEvent : " + type);
        if (data != null) {
            jSONObject = h.f385294a.b(data);
        } else {
            jSONObject = null;
        }
        int hashCode = type.hashCode();
        if (hashCode != 601150621) {
            if (hashCode != 1389201872) {
                if (hashCode == 1719579098 && type.equals("onTouchEvent")) {
                    try {
                        TouchEvent event = (TouchEvent) new Gson().fromJson(data, TouchEvent.class);
                        if (event.getType() == TouchEventType.Pan) {
                            GltfViewerScene gltfViewerScene = this.f105960d;
                            Intrinsics.checkNotNullExpressionValue(event, "event");
                            gltfViewerScene.b0(event);
                        } else if (event.getType() == TouchEventType.Pinch) {
                            GltfViewerScene gltfViewerScene2 = this.f105960d;
                            Intrinsics.checkNotNullExpressionValue(event, "event");
                            gltfViewerScene2.c0(event);
                        }
                        return;
                    } catch (Throwable th5) {
                        FLog.INSTANCE.e("GltfViewerScene", "ON_TOUCH_EVENT error, " + th5);
                        return;
                    }
                }
                return;
            }
            if (type.equals("load_gltf")) {
                this.f105960d.e0(spanContext);
                String str = "";
                if (jSONObject != null && (optString = jSONObject.optString("gltf_path", "")) != null) {
                    str = optString;
                }
                this.f105960d.d0(spanContext, str);
                return;
            }
            return;
        }
        if (type.equals("init_scene")) {
            BuildersKt__Builders_commonKt.launch$default(this.f105960d, null, null, new GltfViewerScene$eventListener$1$handleEvent$1(this, jSONObject, spanContext, null), 3, null);
        }
    }
}
