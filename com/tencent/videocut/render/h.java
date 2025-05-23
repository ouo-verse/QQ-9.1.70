package com.tencent.videocut.render;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.AITextureComponent;
import org.light.lightAssetKit.components.Component;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u000f\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J#\u0010\u0019\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J)\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010#\u001a\u00020\t2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040 H\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/videocut/render/h;", "Lcom/tencent/videocut/render/b;", "", "Lcom/tencent/videocut/render/l;", "Lorg/light/lightAssetKit/Entity;", "originalEntity", "Lorg/light/lightAssetKit/components/AITextureComponent;", "l", "openHDR", "", ReportConstant.COSTREPORT_PREFIX, "entity", DomainData.DOMAIN_NAME, "Lcom/tencent/videocut/model/MediaModel;", "model", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/videocut/model/MediaModel;)Ljava/lang/Boolean;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Boolean;)Ljava/lang/String;", "p", "data", "k", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "o", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Z", "removeEntity", "oldData", "newData", "r", "(Lorg/light/lightAssetKit/Entity;Ljava/lang/Boolean;Z)V", "", "", "entityMap", "c", "Lcom/tencent/tavcut/core/session/ICutSession;", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "d", "Lorg/light/lightAssetKit/Entity;", "hdrEntity", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class h extends b<Boolean, l> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Entity hdrEntity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/render/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.h$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
        }
    }

    private final AITextureComponent l(Entity originalEntity) {
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof AITextureComponent) {
                return (AITextureComponent) component;
            }
        }
        return null;
    }

    private final boolean n(Entity entity) {
        Object obj;
        if (entity == null) {
            return true;
        }
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "entity.components");
        Iterator<T> it = components.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Component) obj) instanceof AITextureComponent) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final void s(boolean openHDR) {
        List<? extends Component> listOf;
        if (openHDR) {
            Entity entity = this.hdrEntity;
            if (entity == null) {
                rd4.c cVar = rd4.c.f431135f;
                AITextureComponent g16 = cVar.o().g();
                g16.setAiType(com.tencent.mobileqq.wink.editor.hdr.g.f320477a.a());
                td4.f q16 = cVar.q();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(g16);
                Entity a16 = q16.a("PicEnhance", listOf);
                this.tavCutSession.addHDR(a16, 0);
                this.hdrEntity = a16;
                return;
            }
            ICutSession iCutSession = this.tavCutSession;
            Intrinsics.checkNotNull(entity);
            iCutSession.switchEntity(entity, true);
            return;
        }
        Entity entity2 = this.hdrEntity;
        if (entity2 != null) {
            ICutSession iCutSession2 = this.tavCutSession;
            Intrinsics.checkNotNull(entity2);
            iCutSession2.switchEntity(entity2, false);
        }
    }

    @Override // com.tencent.videocut.render.m
    public /* bridge */ /* synthetic */ void a(Entity entity, Object obj, Object obj2) {
        r(entity, (Boolean) obj, ((Boolean) obj2).booleanValue());
    }

    @Override // com.tencent.videocut.render.b, com.tencent.videocut.render.m
    public void c(@NotNull Map<Integer, Entity> entityMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) entityMap);
            return;
        }
        Intrinsics.checkNotNullParameter(entityMap, "entityMap");
        w53.b.a("HDRProcessor", "updateEntityByReload");
        Entity entity = this.hdrEntity;
        if (entity != null) {
            if (entityMap.containsKey(Integer.valueOf(entity.getId())) && n(entityMap.get(Integer.valueOf(entity.getId())))) {
                this.hdrEntity = entityMap.get(Integer.valueOf(entity.getId()));
                return;
            }
            w53.b.a("HDRProcessor", "updateEntityByReload not contain hdrEntity " + entity.getId());
        }
    }

    @Override // com.tencent.videocut.render.b
    public /* bridge */ /* synthetic */ l h(Boolean bool) {
        return p(bool.booleanValue());
    }

    @Override // com.tencent.videocut.render.m
    @Nullable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull l data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Entity) iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        AITextureComponent l3 = l(data.a());
        if (l3 != null) {
            s(l3.getEnabled());
        }
        return data.a();
    }

    @Override // com.tencent.videocut.render.b
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public String e(@Nullable Boolean model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
        }
        if (Intrinsics.areEqual(Boolean.TRUE, model)) {
            return "openHDR";
        }
        return "unopenHDR";
    }

    @Override // com.tencent.videocut.render.b
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean g(@Nullable Boolean newModel, @Nullable Boolean oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        if (this.hdrEntity != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public l p(boolean model) {
        List<? extends Component> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (l) iPatchRedirector.redirect((short) 4, (Object) this, model);
        }
        rd4.c cVar = rd4.c.f431135f;
        AITextureComponent g16 = cVar.o().g();
        g16.setEnabled(model);
        td4.f q16 = cVar.q();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(g16);
        return new l(q16.a(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, listOf), new InputSource(null, null, null, null, null, null, null, null, null, null, null, 2047, null), null, 4, null);
    }

    @Override // com.tencent.videocut.render.b
    @Nullable
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Boolean j(@NotNull MediaModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.openHDR;
    }

    public void r(@NotNull Entity entity, @Nullable Boolean oldData, boolean newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, entity, oldData, Boolean.valueOf(newData));
        } else {
            Intrinsics.checkNotNullParameter(entity, "entity");
            s(newData);
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.tavCutSession.removeEntity(entity);
        this.hdrEntity = null;
    }
}
