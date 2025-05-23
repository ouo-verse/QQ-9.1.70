package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/e;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "v", "", "u", "data", "", "t", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", "w", "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "iCutSession", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e extends b<AudioModel, RenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a iCutSession;

    public e(@NotNull com.tencent.tavcut.session.a iCutSession) {
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        this.iCutSession = iCutSession;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        this.iCutSession.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<AudioModel> s(@NotNull MediaModel model) {
        List<AudioModel> list;
        Intrinsics.checkNotNullParameter(model, "model");
        list = CollectionsKt___CollectionsKt.toList(model.audios.values());
        return list;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.iCutSession.j(data.getInputSource());
        return this.iCutSession.o(data.getEntity()).getId();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull AudioModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public RenderData q(@NotNull AudioModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.a.b(model);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable RenderData oldData, @NotNull RenderData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        com.tencent.tavcut.session.a aVar = this.iCutSession;
        String str = newData.getInputSource().key;
        if (str == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(aVar.accessInputSource(str), newData.getInputSource())) {
            this.iCutSession.j(newData.getInputSource());
        }
        Iterator<T> it = newData.getEntity().getComponents().iterator();
        while (it.hasNext()) {
            this.iCutSession.c(originalEntityId, (IdentifyComponent) it.next());
        }
    }
}
