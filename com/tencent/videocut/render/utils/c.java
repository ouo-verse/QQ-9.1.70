package com.tencent.videocut.render.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.render.extension.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.LightAssetDataType;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.LightAssetFragment;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.ScreenTransform;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J4\u0010\f\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J*\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\tJ2\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/videocut/render/utils/c;", "", "", "materialDirPath", "Lorg/light/lightAssetKit/Entity;", h.F, "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "Lkotlin/Triple;", "", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "Lorg/light/LightAsset;", "g", "entity", "e", "folderPath", "Lorg/light/lightAssetKit/components/ScreenTransform;", "f", "", "startTimeUs", "durationUs", "entityName", "a", "nestedEntity", "Lorg/light/lightAssetKit/components/Component;", "components", "c", "entityList", "templatePath", "", "renderWidth", "renderHeight", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "d", "Lcom/google/gson/Gson;", "b", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f384212a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Gson gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/videocut/render/utils/c$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class a extends TypeToken<InputSource> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f384212a = new c();
            gson = new Gson();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Entity b(c cVar, Entity entity, long j3, long j16, String str, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str = null;
        }
        return cVar.a(entity, j3, j16, str);
    }

    @NotNull
    public final Entity a(@NotNull Entity entity, long startTimeUs, long durationUs, @Nullable String entityName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Entity) iPatchRedirector.redirect((short) 6, this, entity, Long.valueOf(startTimeUs), Long.valueOf(durationUs), entityName);
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        ArrayList arrayList = new ArrayList();
        rd4.c cVar = rd4.c.f431135f;
        arrayList.add(cVar.o().e(startTimeUs, durationUs));
        if (entityName != null) {
            EntityIdentifier a16 = cVar.o().a(entityName);
            a16.setName(entityName);
            arrayList.add(a16);
        }
        return c(entity, arrayList);
    }

    @NotNull
    public final Entity c(@NotNull Entity nestedEntity, @NotNull List<? extends Component> components) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Entity) iPatchRedirector.redirect((short) 7, (Object) this, (Object) nestedEntity, (Object) components);
        }
        Intrinsics.checkNotNullParameter(nestedEntity, "nestedEntity");
        Intrinsics.checkNotNullParameter(components, "components");
        Entity entity = new Entity(nestedEntity.getType());
        entity.reset();
        entity.addChild(nestedEntity);
        for (Component component : components) {
            entity.removeComponent(entity.getComponent(component.type()));
            entity.addComponent(component);
        }
        return entity;
    }

    @NotNull
    public final List<WinkStickerModel> d(@NotNull List<? extends Entity> entityList, @NotNull String templatePath, int renderWidth, int renderHeight) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, entityList, templatePath, Integer.valueOf(renderWidth), Integer.valueOf(renderHeight));
        }
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        List<? extends Entity> list = entityList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            WinkStickerModel w3 = f.w((Entity) it.next(), templatePath);
            w3.updatePositionInView(renderWidth, renderHeight, w3.scaleX, w3.scaleY, w3.centerX, w3.centerY);
            arrayList.add(w3);
        }
        return arrayList;
    }

    @Nullable
    public final Entity e(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Entity) iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity);
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        long currentTimeMillis = System.currentTimeMillis();
        LightAssetFragment lightAssetFragment = (LightAssetFragment) com.tencent.videocut.render.extension.d.d(entity, Reflection.getOrCreateKotlinClass(LightAssetFragment.class));
        Entity entity2 = null;
        if (lightAssetFragment != null && lightAssetFragment.getMainEditableEntityId() >= 0) {
            entity2 = com.tencent.videocut.render.extension.d.c(entity, lightAssetFragment.getMainEditableEntityId());
        }
        if (entity2 == null) {
            entity2 = com.tencent.videocut.render.extension.d.e(entity, Reflection.getOrCreateKotlinClass(PAGAsset.class));
        }
        ms.a.a("WinkLakUtils", "findMainPagFromLakFragment cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return entity2;
    }

    @Nullable
    public final ScreenTransform f(@Nullable String folderPath) {
        Entity e16;
        Collection<Component> components;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ScreenTransform) iPatchRedirector.redirect((short) 5, (Object) this, (Object) folderPath);
        }
        Entity h16 = h(folderPath);
        if (h16 != null && (e16 = f384212a.e(h16)) != null && (components = e16.getComponents()) != null) {
            Intrinsics.checkNotNullExpressionValue(components, "components");
            for (Component component : components) {
                if (component instanceof ScreenTransform) {
                    return (ScreenTransform) component;
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final Triple<Entity, List<InputSource>, LightAsset> g(@NotNull String materialDirPath, @Nullable ICutSession tavCutSession) {
        String str;
        Object firstOrNull;
        String path;
        JsonObject inputSources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Triple) iPatchRedirector.redirect((short) 3, (Object) this, (Object) materialDirPath, (Object) tavCutSession);
        }
        Intrinsics.checkNotNullParameter(materialDirPath, "materialDirPath");
        long currentTimeMillis = System.currentTimeMillis();
        w53.b.a("WinkLakUtils", "parseLightAssetFragmentEntityWithCompare begin " + materialDirPath);
        ArrayList arrayList = new ArrayList();
        LightAsset Load = LightAsset.Load(l73.a.f413927a.f(materialDirPath), 0);
        LightAssetDataContext make = LightAssetDataContext.make(Load, LightAssetDataType.EntityTree);
        Entity entity = null;
        if (make != null) {
            w53.b.a("WinkLakUtils", "parseLightAssetFragmentEntityWithCompare context make cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            if (tavCutSession != null && (inputSources = tavCutSession.getInputSources()) != null) {
                str = inputSources.toString();
            } else {
                str = null;
            }
            w53.b.a("WinkLakUtils", "lightRootInputSources is " + str);
            if (str != null) {
                make.compareAndUpdate(str);
            }
            w53.b.a("WinkLakUtils", "parseLightAssetFragmentEntityWithCompare compareAndUpdate cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Set<Map.Entry<String, JsonElement>> entrySet = make.getInputSources().entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "lightAssetDataContext.inputSources.entrySet()");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Object fromJson = gson.fromJson((JsonElement) ((Map.Entry) it.next()).getValue(), new a().getType());
                Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(it.value, \u2026n<InputSource>() {}.type)");
                InputSource inputSource = (InputSource) fromJson;
                if (str == null) {
                    if (Intrinsics.areEqual(inputSource.getPath(), "./")) {
                        path = "";
                    } else {
                        path = inputSource.getPath();
                    }
                    String path2 = new File(materialDirPath, path).getPath();
                    Intrinsics.checkNotNullExpressionValue(path2, "file.path");
                    inputSource = inputSource.copy((r24 & 1) != 0 ? inputSource.key : null, (r24 & 2) != 0 ? inputSource.type : null, (r24 & 4) != 0 ? inputSource.path : path2, (r24 & 8) != 0 ? inputSource.label : null, (r24 & 16) != 0 ? inputSource.timeRange : null, (r24 & 32) != 0 ? inputSource.loopCount : null, (r24 & 64) != 0 ? inputSource.events : null, (r24 & 128) != 0 ? inputSource.inputKey : null, (r24 & 256) != 0 ? inputSource.timeStretchMode : null, (r24 & 512) != 0 ? inputSource.clipRect : null, (r24 & 1024) != 0 ? inputSource.postEffectOptions : null);
                }
                arrayList.add(inputSource);
            }
            List<Entity> entitiesWithComponent = make.getRootEntity().getEntitiesWithComponent(LightAssetFragment.class);
            if (entitiesWithComponent != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) entitiesWithComponent);
                entity = (Entity) firstOrNull;
            }
            if (entity != null) {
                entity.detach();
            }
            w53.b.a("WinkLakUtils", "parseLightAssetFragmentEntityWithCompare cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        j73.a.f409615a.e(materialDirPath);
        return new Triple<>(entity, arrayList, Load);
    }

    @Nullable
    public final Entity h(@Nullable String materialDirPath) {
        LightAssetDataContext d16;
        Entity rootEntity;
        List<Entity> b16;
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Entity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) materialDirPath);
        }
        if (materialDirPath != null && (d16 = b.f384205a.d(l73.a.f413927a.f(materialDirPath))) != null && (rootEntity = d16.getRootEntity()) != null && (b16 = com.tencent.videocut.render.extension.d.b(rootEntity, "LightAssetFragment")) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) b16);
            return (Entity) firstOrNull;
        }
        return null;
    }
}
