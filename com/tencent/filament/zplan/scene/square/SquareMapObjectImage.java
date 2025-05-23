package com.tencent.filament.zplan.scene.square;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.d;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u0001\u000bBG\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\u0006\u0010'\u001a\u00020%\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010+\u001a\u00020)\u0012\u0006\u0010.\u001a\u00020,\u0012\b\u00102\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J&\u0010\u001b\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u001e\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010(R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapObjectImage;", "Lcom/tencent/filament/zplan/scene/square/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "renderObjectId", "", "g", "destroy", "frameId", "a", NodeProps.VISIBLE, "setVisibility", "", "resource", "f", "e", "Lcom/tencent/filament/zplan/scene/square/Location;", "location", "durationMs", "d", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "hostAnim", "guestAnim", "", "extraAnimGltf", "b", "Ljava/lang/Long;", "imageObjectId", "Ljava/lang/String;", "id", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/scene/square/e;", "c", "Ljava/lang/ref/WeakReference;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "data", "Lcom/tencent/filament/zplan/scene/square/Location;", "Lcom/tencent/filament/zplan/scene/square/Size;", "Lcom/tencent/filament/zplan/scene/square/Size;", "size", "", UserInfo.SEX_FEMALE, "depth", "Lcom/tencent/zplan/zplantracing/c;", tl.h.F, "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "<init>", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Lcom/tencent/filament/zplan/scene/square/SquareImageData;Lcom/tencent/filament/zplan/scene/square/Location;Lcom/tencent/filament/zplan/scene/square/Size;FLcom/tencent/zplan/zplantracing/c;)V", "i", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareMapObjectImage implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Long imageObjectId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<e> parent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SquareImageData data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Location location;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Size size;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final float depth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.zplan.zplantracing.c spanContext;

    public SquareMapObjectImage(@NotNull String id5, @NotNull WeakReference<e> parent, @NotNull SquareImageData data, @NotNull Location location, @NotNull Size size, float f16, @Nullable com.tencent.zplan.zplantracing.c cVar) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        this.id = id5;
        this.parent = parent;
        this.data = data;
        this.location = location;
        this.size = size;
        this.depth = f16;
        this.spanContext = cVar;
        q();
    }

    private final void q() {
        FilamentThreadHandler c16;
        e eVar = this.parent.get();
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.d("SquareMapObjectImage.reloadRenderObjects", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectImage$reloadRenderObjects$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WeakReference weakReference;
                    FilamentViewerV2305 b16;
                    WeakReference weakReference2;
                    n squareMapSceneHelper;
                    Long l3;
                    com.tencent.zplan.zplantracing.c cVar;
                    com.tencent.zplan.zplantracing.c cVar2;
                    SquareImageData squareImageData;
                    SquareImageData squareImageData2;
                    Location location;
                    Size size;
                    float f16;
                    String str;
                    WeakReference weakReference3;
                    String str2;
                    weakReference = SquareMapObjectImage.this.parent;
                    e eVar2 = (e) weakReference.get();
                    if (eVar2 == null || (b16 = eVar2.b()) == null) {
                        return;
                    }
                    weakReference2 = SquareMapObjectImage.this.parent;
                    e eVar3 = (e) weakReference2.get();
                    if (eVar3 == null || (squareMapSceneHelper = eVar3.getSquareMapSceneHelper()) == null) {
                        return;
                    }
                    l3 = SquareMapObjectImage.this.imageObjectId;
                    if (l3 != null) {
                        b16.deleteRenderObject(null, l3.longValue());
                    }
                    long createGltfRenderObject = b16.createGltfRenderObject(null);
                    SquareMapObjectImage.this.imageObjectId = Long.valueOf(createGltfRenderObject);
                    SquareMapResourceHelper squareMapResourceHelper = SquareMapResourceHelper.f106088j;
                    cVar = SquareMapObjectImage.this.spanContext;
                    squareMapResourceHelper.i(cVar, b16, createGltfRenderObject);
                    cVar2 = SquareMapObjectImage.this.spanContext;
                    squareImageData = SquareMapObjectImage.this.data;
                    String imagePath = squareImageData.getImagePath();
                    squareImageData2 = SquareMapObjectImage.this.data;
                    b16.setRenderObjectParameter(cVar2, createGltfRenderObject, "BaseColor", imagePath, squareImageData2.getImagePath(), 1);
                    location = SquareMapObjectImage.this.location;
                    size = SquareMapObjectImage.this.size;
                    f16 = SquareMapObjectImage.this.depth;
                    try {
                        str = squareMapSceneHelper.d(b16, location, size, f16).toString();
                    } catch (Exception e16) {
                        FLog.INSTANCE.e("SquareMapObjectImage", "reloadRenderObjects error", e16);
                        str = "{}";
                    }
                    b16.setRenderObjectTransform(createGltfRenderObject, str);
                    b16.rotateRenderObject(createGltfRenderObject, new RotateParam(1.0f, 0.0f, 0.0f, (float) 0.7853981633974483d));
                    b16.setRenderObjectHittable(createGltfRenderObject, true);
                    weakReference3 = SquareMapObjectImage.this.parent;
                    e eVar4 = (e) weakReference3.get();
                    if (eVar4 != null) {
                        str2 = SquareMapObjectImage.this.id;
                        eVar4.e(new OnObjectStateChangedEvent(str2, ObjectState.LOADED, null, 4, null));
                    }
                    FLog.INSTANCE.d("SquareMapObjectImage", "reloadRenderObjects done");
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void c(long j3) {
        d.a.a(this, j3);
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void d(@NotNull Location location, long durationMs) {
        Intrinsics.checkNotNullParameter(location, "location");
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void destroy() {
        FilamentViewerV2305 b16;
        Long l3;
        e eVar = this.parent.get();
        if (eVar != null && (b16 = eVar.b()) != null && (l3 = this.imageObjectId) != null) {
            b16.deleteRenderObject(null, l3.longValue());
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void e() {
        FilamentThreadHandler c16;
        e eVar = this.parent.get();
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapObjectImage$resetLocation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WeakReference weakReference;
                    FilamentViewerV2305 b16;
                    WeakReference weakReference2;
                    n squareMapSceneHelper;
                    Long l3;
                    Location location;
                    Size size;
                    float f16;
                    String str;
                    Long l16;
                    Long l17;
                    weakReference = SquareMapObjectImage.this.parent;
                    e eVar2 = (e) weakReference.get();
                    if (eVar2 == null || (b16 = eVar2.b()) == null) {
                        return;
                    }
                    weakReference2 = SquareMapObjectImage.this.parent;
                    e eVar3 = (e) weakReference2.get();
                    if (eVar3 == null || (squareMapSceneHelper = eVar3.getSquareMapSceneHelper()) == null) {
                        return;
                    }
                    l3 = SquareMapObjectImage.this.imageObjectId;
                    if (l3 == null) {
                        return;
                    }
                    location = SquareMapObjectImage.this.location;
                    size = SquareMapObjectImage.this.size;
                    f16 = SquareMapObjectImage.this.depth;
                    try {
                        str = squareMapSceneHelper.d(b16, location, size, f16).toString();
                    } catch (Exception e16) {
                        FLog.INSTANCE.e("SquareMapObjectImage", "reloadRenderObjects error", e16);
                        str = "{}";
                    }
                    l16 = SquareMapObjectImage.this.imageObjectId;
                    Intrinsics.checkNotNull(l16);
                    b16.setRenderObjectTransform(l16.longValue(), str);
                    RotateParam rotateParam = new RotateParam(1.0f, 0.0f, 0.0f, 1.134464f);
                    l17 = SquareMapObjectImage.this.imageObjectId;
                    Intrinsics.checkNotNull(l17);
                    b16.rotateRenderObject(l17.longValue(), rotateParam);
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void f(@NotNull Object resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        if (!(resource instanceof SquareImageData)) {
            resource = null;
        }
        SquareImageData squareImageData = (SquareImageData) resource;
        if (squareImageData != null) {
            this.data = squareImageData;
            q();
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public boolean g(long renderObjectId) {
        Long l3 = this.imageObjectId;
        if (l3 != null && l3.longValue() == renderObjectId) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void play() {
        d.a.b(this);
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void reset() {
        d.a.c(this);
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void stop() {
        d.a.d(this);
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void a(long frameId) {
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void setVisibility(boolean visible) {
    }

    @Override // com.tencent.filament.zplan.scene.square.d
    public void b(@Nullable SquareAvatarData.AvatarAnim hostAnim, @Nullable SquareAvatarData.AvatarAnim guestAnim, @Nullable String extraAnimGltf) {
    }
}
