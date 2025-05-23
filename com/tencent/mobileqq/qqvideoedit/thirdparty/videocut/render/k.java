package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.session.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/k;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "data", "", "t", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", "w", "v", "", "u", "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k extends b<FilterModel, RenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    public k(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        Logger.f275870a.b("LutFilterModelRender", "remove lut " + entityId);
        this.tavCutSession.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<FilterModel> s(@NotNull MediaModel model) {
        boolean z16;
        Intrinsics.checkNotNullParameter(model, "model");
        Collection<FilterModel> values = model.filterModels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((FilterModel) obj).lut != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.tavCutSession.j(data.getInputSource());
        Entity a16 = a.C9882a.a(this.tavCutSession, data.getEntity(), 0, 2, null);
        Logger.f275870a.b("LutFilterModelRender", "add lut " + a16.getId());
        return a16.getId();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull FilterModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public RenderData q(@NotNull FilterModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        RenderData b16 = gk2.c.b(model, false);
        Intrinsics.checkNotNull(b16);
        return b16;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable RenderData oldData, @NotNull RenderData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        Logger.f275870a.b("LutFilterModelRender", "update lut " + originalEntityId);
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
