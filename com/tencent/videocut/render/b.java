package com.tencent.videocut.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.videocut.model.MediaModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b#\u0010$J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u001c\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/videocut/render/b;", "T", "V", "Lcom/tencent/videocut/render/m;", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "i", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lcom/tencent/videocut/model/MediaModel;", "model", "j", "(Lcom/tencent/videocut/model/MediaModel;)Ljava/lang/Object;", "", "e", "(Ljava/lang/Object;)Ljava/lang/String;", tl.h.F, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "g", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "f", "mediaModel", "d", "", "", "Lorg/light/lightAssetKit/Entity;", "entityMap", "c", "a", "Ljava/lang/Object;", "currentModel", "b", "Lorg/light/lightAssetKit/Entity;", "entity", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public abstract class b<T, V> implements m<T, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T currentModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Entity entity;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void i(T newModel, T oldModel) {
        if (f(newModel, oldModel)) {
            return;
        }
        if (newModel == null) {
            Entity entity = this.entity;
            if (entity != null) {
                removeEntity(entity);
            }
            this.entity = null;
            return;
        }
        V h16 = h(newModel);
        if (oldModel == null) {
            this.entity = b(h16);
            return;
        }
        h(oldModel);
        if (g(newModel, oldModel)) {
            Entity entity2 = this.entity;
            if (entity2 != null) {
                a(entity2, oldModel, newModel);
                return;
            }
            return;
        }
        Entity entity3 = this.entity;
        if (entity3 != null) {
            removeEntity(entity3);
        }
        this.entity = b(h16);
    }

    @Override // com.tencent.videocut.render.m
    public void c(@NotNull Map<Integer, Entity> entityMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) entityMap);
            return;
        }
        Intrinsics.checkNotNullParameter(entityMap, "entityMap");
        Entity entity = this.entity;
        if (entity != null && entityMap.containsKey(Integer.valueOf(entity.getId()))) {
            this.entity = entityMap.get(Integer.valueOf(entity.getId()));
        }
    }

    @Override // com.tencent.videocut.render.i
    public void d(@NotNull MediaModel mediaModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaModel);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        T j3 = j(mediaModel);
        i(j3, this.currentModel);
        this.currentModel = j3;
    }

    @Nullable
    public abstract String e(@Nullable T model);

    public boolean f(@Nullable T newModel, @Nullable T oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        return Intrinsics.areEqual(newModel, oldModel);
    }

    public boolean g(@Nullable T newModel, @Nullable T oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        if (newModel == null && oldModel == null) {
            return true;
        }
        if (newModel != null && oldModel != null) {
            return Intrinsics.areEqual(e(newModel), e(oldModel));
        }
        return false;
    }

    public abstract V h(T model);

    @Nullable
    public abstract T j(@NotNull MediaModel model);
}
