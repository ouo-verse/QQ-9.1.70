package com.tencent.videocut.render;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.SuperResolution;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J.\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/videocut/render/q;", "Lcom/tencent/videocut/render/b;", "", "Lcom/tencent/videocut/model/MediaClip;", "Lcom/tencent/videocut/render/l;", "Lcom/tencent/videocut/model/MediaModel;", "model", DomainData.DOMAIN_NAME, "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "Lorg/light/lightAssetKit/Entity;", "k", "entity", "", "removeEntity", "oldData", "newData", "o", "Lcom/tencent/tavcut/core/session/ICutSession;", "c", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "d", "Ljava/lang/String;", "TAG", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class q extends b<List<? extends MediaClip>, l> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    public q(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
            this.TAG = "SuperResolutionRender";
        }
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
        com.tencent.videocut.render.utils.a.f384204a.i(this.tavCutSession, data.a());
        return data.a();
    }

    @Override // com.tencent.videocut.render.b
    @Nullable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String e(@Nullable List<? extends MediaClip> model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
        }
        List<Integer> k3 = WinkHDRPicQualityDetectUtils.f320445a.k(model);
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = k3.iterator();
        while (it.hasNext()) {
            sb5.append(((Number) it.next()).intValue() + ",");
        }
        return sb5.toString();
    }

    @Override // com.tencent.videocut.render.b
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public l h(@NotNull List<? extends MediaClip> model) {
        List<? extends Component> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (l) iPatchRedirector.redirect((short) 4, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        List<Integer> k3 = WinkHDRPicQualityDetectUtils.f320445a.k(model);
        td4.f q16 = rd4.c.f431135f.q();
        SuperResolution superResolution = new SuperResolution();
        superResolution.setIndexes(new ArrayList<>(k3));
        superResolution.setEnabled(!r0.isEmpty());
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(superResolution);
        return new l(q16.a("superResolution", listOf), new InputSource(null, null, null, null, null, null, null, null, null, null, null, 2047, null), null, 4, null);
    }

    @Override // com.tencent.videocut.render.b
    @Nullable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public List<MediaClip> j(@NotNull MediaModel model) {
        List<MediaClip> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        Boolean bool = model.openSuperHDR;
        Boolean bool2 = Boolean.TRUE;
        if (!Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(bool2, model.openHDR)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return model.videos;
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable List<? extends MediaClip> oldData, @NotNull List<? extends MediaClip> newData) {
        SuperResolution superResolution;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        List<Integer> k3 = WinkHDRPicQualityDetectUtils.f320445a.k(newData);
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "entity.components");
        for (Component component : components) {
            if (component instanceof SuperResolution) {
                superResolution = (SuperResolution) component;
            } else {
                superResolution = null;
            }
            if (superResolution != null) {
                SuperResolution superResolution2 = (SuperResolution) component;
                superResolution2.setIndexes(new ArrayList<>(k3));
                superResolution2.setEnabled(!r1.isEmpty());
            }
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) entity);
        } else {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.tavCutSession.removeEntity(entity);
        }
    }
}
