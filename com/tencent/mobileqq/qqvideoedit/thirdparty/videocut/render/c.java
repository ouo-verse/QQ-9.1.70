package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0019\u001a\u00020\u00148\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/c;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/h;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", HippyTKDListViewAdapter.X, "model", "", "t", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "v", "w", "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "u", "()Lcom/tencent/tavcut/session/a;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class c extends b<FilterRenderData, RenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    public c(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        this.tavCutSession.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull FilterRenderData model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return model.getFilterModel().id;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: u, reason: from getter */
    public final com.tencent.tavcut.session.a getTavCutSession() {
        return this.tavCutSession;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull FilterRenderData newModel, @NotNull FilterRenderData oldModel) {
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (Intrinsics.areEqual(newModel.getFilterModel().lut, oldModel.getFilterModel().lut) && Intrinsics.areEqual(newModel.getParentId(), oldModel.getParentId()) && newModel.getIndex() == oldModel.getIndex()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: w */
    public RenderData q(@NotNull FilterRenderData model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.c.b(model.getFilterModel(), true);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: x */
    public void e(int originalEntityId, @Nullable RenderData oldData, @NotNull RenderData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        com.tencent.tavcut.session.a aVar = this.tavCutSession;
        String str = newData.getInputSource().key;
        if (str == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(newData.getInputSource(), aVar.accessInputSource(str))) {
            this.tavCutSession.j(newData.getInputSource());
        }
        Iterator<T> it = newData.getEntity().getComponents().iterator();
        while (it.hasNext()) {
            this.tavCutSession.c(originalEntityId, (IdentifyComponent) it.next());
        }
    }
}
