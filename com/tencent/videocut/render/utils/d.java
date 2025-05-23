package com.tencent.videocut.render.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import com.tencent.videocut.render.extension.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.datasource.LightBaseDataSourceValue;
import org.light.datasource.LightDataSource;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.DataSourceComponent;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.Vec3;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u00020\f*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u000f\u001a\u00020\b*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u0010\u001a\u00020\f*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u0013\u001a\u00020\b*\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0014\u0010\u0014\u001a\u00020\f*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u0017\u001a\u00020\b*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u001d\u001a\u00020\b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/videocut/render/utils/d;", "", "Lorg/light/lightAssetKit/Entity;", "entity", "Lcom/tencent/videocut/model/AnimationMode;", "animationMode", "", "duration", "", "i", "Lcom/tencent/videocut/model/StickerModel;", com.tencent.mobileqq.msf.service.b.f250813p, "", "a", "stickerEntity", "f", "b", "Lorg/light/lightAssetKit/components/ScreenTransform;", "screenTransform", "g", "c", "Lorg/light/lightAssetKit/components/TimeOffset;", "timeOffset", h.F, "d", "", "", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "watermarkModel", "e", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f384214a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f384215a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59890);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AnimationMode.values().length];
            try {
                iArr[AnimationMode.LOOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f384215a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f384214a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(StickerModel stickerModel, StickerModel stickerModel2) {
        if (stickerModel2 != null && Intrinsics.areEqual(stickerModel.watermarkModel, stickerModel2.watermarkModel)) {
            return false;
        }
        return true;
    }

    private final void i(Entity entity, AnimationMode animationMode, long duration) {
        int i3;
        TimeOffset timeOffset = (TimeOffset) entity.getComponent(TimeOffset.class);
        if (timeOffset != null) {
            timeOffset.setStartOffset(0L);
            timeOffset.setDuration(duration);
            if (a.f384215a[animationMode.ordinal()] == 1) {
                i3 = -1;
            } else {
                i3 = 0;
            }
            timeOffset.setLoopCount(i3);
        }
    }

    public final boolean b(@NotNull StickerModel stickerModel, @Nullable StickerModel stickerModel2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) stickerModel, (Object) stickerModel2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        if (stickerModel2 == null) {
            return true;
        }
        if (stickerModel.centerX == stickerModel2.centerX) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        if (stickerModel.centerY == stickerModel2.centerY) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return true;
        }
        if (stickerModel.rotate == stickerModel2.rotate) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return true;
        }
        if (stickerModel.scaleX == stickerModel2.scaleX) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            return true;
        }
        if (stickerModel.scaleY == stickerModel2.scaleY) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (!z26) {
            return true;
        }
        return false;
    }

    public final boolean c(@NotNull StickerModel stickerModel, @Nullable StickerModel stickerModel2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) stickerModel, (Object) stickerModel2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        if (stickerModel2 != null && stickerModel.startTime == stickerModel2.startTime && stickerModel.duration == stickerModel2.duration) {
            return false;
        }
        return true;
    }

    public final void d(@NotNull Entity entity, @NotNull AnimationMode animationMode, long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, entity, animationMode, Long.valueOf(duration));
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(animationMode, "animationMode");
        i(entity, animationMode, duration);
        List<Entity> children = entity.getChildren();
        Intrinsics.checkNotNullExpressionValue(children, "entity.children");
        for (Entity entity2 : children) {
            d dVar = f384214a;
            Intrinsics.checkNotNullExpressionValue(entity2, "entity");
            dVar.d(entity2, animationMode, duration);
        }
    }

    public final void e(@NotNull Entity entity, @NotNull Map<String, WatermarkDataSourceModel> watermarkModel) {
        LightBaseDataSourceValue lightBaseDataSourceValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) entity, (Object) watermarkModel);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "<this>");
        Intrinsics.checkNotNullParameter(watermarkModel, "watermarkModel");
        DataSourceComponent dataSourceComponent = (DataSourceComponent) entity.getComponent(DataSourceComponent.class);
        if (dataSourceComponent != null) {
            HashMap<String, LightDataSource> data = dataSourceComponent.getData();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            for (Map.Entry<String, LightDataSource> entry : data.entrySet()) {
                String key = entry.getKey();
                LightDataSource value = entry.getValue();
                WatermarkDataSourceModel watermarkDataSourceModel = watermarkModel.get(key);
                if (watermarkDataSourceModel != null) {
                    lightBaseDataSourceValue = i.j(watermarkDataSourceModel);
                } else {
                    lightBaseDataSourceValue = null;
                }
                value.setValue(lightBaseDataSourceValue);
            }
            dataSourceComponent.setData(dataSourceComponent.getData());
        }
        List<Entity> children = entity.getChildren();
        if (children != null) {
            for (Entity entity2 : children) {
                d dVar = f384214a;
                Intrinsics.checkNotNullExpressionValue(entity2, "entity");
                dVar.e(entity2, watermarkModel);
            }
        }
    }

    public final void f(@NotNull StickerModel stickerModel, @NotNull Entity stickerEntity, @Nullable StickerModel stickerModel2) {
        List<Entity> children;
        ScreenTransform screenTransform;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, stickerModel, stickerEntity, stickerModel2);
            return;
        }
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Intrinsics.checkNotNullParameter(stickerEntity, "stickerEntity");
        if (a(stickerModel, stickerModel2)) {
            e(stickerEntity, stickerModel.watermarkModel);
        }
        if (b(stickerModel, stickerModel2)) {
            Entity e16 = c.f384212a.e(stickerEntity);
            if (e16 != null) {
                screenTransform = (ScreenTransform) e16.getComponent(ScreenTransform.class);
            } else {
                screenTransform = null;
            }
            g(stickerModel, screenTransform);
        }
        if (c(stickerModel, stickerModel2) && (children = stickerEntity.getChildren()) != null) {
            for (Entity childEntity : children) {
                d dVar = f384214a;
                Intrinsics.checkNotNullExpressionValue(childEntity, "childEntity");
                dVar.d(childEntity, stickerModel.animationMode, stickerModel.duration);
            }
        }
    }

    public final void g(@NotNull StickerModel stickerModel, @Nullable ScreenTransform screenTransform) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) stickerModel, (Object) screenTransform);
            return;
        }
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        if (screenTransform != null) {
            if (stickerModel.type == StickerModel.Type.MASK) {
                int i3 = stickerModel.height;
                float f16 = stickerModel.scaleY;
                float f17 = 2;
                int i16 = stickerModel.width;
                float f18 = stickerModel.scaleX;
                screenTransform.setOffset(new Rect(((-i3) * f16) / f17, ((-i16) * f18) / f17, (i16 * f18) / f17, (i3 * f16) / f17));
            } else {
                int i17 = stickerModel.height;
                float f19 = 2;
                int i18 = stickerModel.width;
                screenTransform.setOffset(new Rect((-i17) / f19, (-i18) / f19, i18 / f19, i17 / f19));
                screenTransform.setScale(new Vec3(stickerModel.scaleX, stickerModel.scaleY, 1.0f));
            }
            float f26 = stickerModel.centerY;
            float f27 = stickerModel.centerX;
            screenTransform.setAnchor(new Rect(f26, f27, f27, f26));
            screenTransform.setRotation(com.tencent.tavcut.core.utils.b.f374339a.d(stickerModel.rotate));
            ms.a.a("wink_sticker", "updateScreenTransform height:" + stickerModel.height + ", width:" + stickerModel.width + ", scaleX:" + stickerModel.scaleX + ", scaleY:" + stickerModel.scaleY + ", centerX:" + stickerModel.centerX + ", centerY:" + stickerModel.centerY + ", rotation:" + screenTransform.getRotation());
        }
    }

    public final void h(@NotNull StickerModel stickerModel, @NotNull TimeOffset timeOffset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) stickerModel, (Object) timeOffset);
            return;
        }
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Intrinsics.checkNotNullParameter(timeOffset, "timeOffset");
        timeOffset.setStartOffset(stickerModel.startTime);
        timeOffset.setDuration(stickerModel.duration);
    }
}
