package com.tencent.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.TransitionModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/render/u;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/TransitionModel;", "Lcom/tencent/videocut/render/v;", "Lcom/tencent/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "data", "Lorg/light/lightAssetKit/Entity;", "v", "entity", "", "removeEntity", "oldData", "newData", "y", HippyTKDListViewAdapter.X, "", "w", "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class u extends a<TransitionModel, v> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    public u(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity);
        } else {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.tavCutSession.removeEntity(entity);
        }
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<TransitionModel> s(@NotNull MediaModel model) {
        List<TransitionModel> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        list = CollectionsKt___CollectionsKt.toList(model.transitions.values());
        return list;
    }

    @Override // com.tencent.videocut.render.m
    @Nullable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull v data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, data.b().b(), false, 2, null);
        this.tavCutSession.setTransition(data.b().a(), data.a());
        return data.b().a();
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull TransitionModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public v q(@NotNull TransitionModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (v) iPatchRedirector.redirect((short) 6, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return com.tencent.videocut.render.extension.h.b(model);
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable TransitionModel oldData, @NotNull TransitionModel newData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        if (oldData != null && oldData.position == newData.position) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            removeEntity(entity);
        }
        v q16 = q(newData);
        ICutSession iCutSession = this.tavCutSession;
        String key = q16.b().b().getKey();
        if (key == null) {
            key = "";
        }
        if (!Intrinsics.areEqual(q16.b().b(), iCutSession.accessInputSource(key))) {
            ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, q16.b().b(), false, 2, null);
        }
        this.tavCutSession.setTransition(q16.b().a(), newData.position);
    }
}
