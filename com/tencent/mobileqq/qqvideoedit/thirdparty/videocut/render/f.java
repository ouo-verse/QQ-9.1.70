package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundFillMode;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/f;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/d;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "model", "", "p", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "o", "data", "", "l", TemplateParser.KEY_ENTITY_ID, "a", "originalEntityId", "oldData", "newData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f extends d<BackgroundModel, RenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    public f(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
    }

    private final void p(BackgroundModel model) {
        int i3;
        int i16;
        int i17;
        SizeF sizeF = model.renderSize;
        if (sizeF != null) {
            i3 = (int) sizeF.width;
        } else {
            i3 = 720;
        }
        if (sizeF != null) {
            i16 = (int) sizeF.height;
        } else {
            i16 = 1280;
        }
        com.tencent.tavcut.session.a aVar = this.tavCutSession;
        BackgroundFillMode backgroundFillMode = model.bgFillMode;
        if (backgroundFillMode != null) {
            i17 = backgroundFillMode.getValue();
        } else {
            i17 = 1;
        }
        aVar.updateBackground(i17, com.tencent.videocut.utils.d.f384234a.a(model.bgColor), model.bgPagPath);
        this.tavCutSession.n(new Size(Integer.valueOf(i3), Integer.valueOf(i16), null, 4, null), model.fillScale);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Object firstOrNull;
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data.getEntity().getComponents());
        IdentifyComponent identifyComponent = (IdentifyComponent) firstOrNull;
        if (identifyComponent != null) {
            obj = identifyComponent.getData();
        } else {
            obj = null;
        }
        if (obj instanceof BackgroundModel) {
            p((BackgroundModel) obj);
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.d
    @Nullable
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public String f(@Nullable BackgroundModel model) {
        if (model != null) {
            return model.id;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.d
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public RenderData i(@NotNull BackgroundModel model) {
        List listOf;
        Intrinsics.checkNotNullParameter(model, "model");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new IdentifyComponent(model));
        return new RenderData(new Entity(0, "background", null, listOf, false, 0, 53, null), new InputSource(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null), null, 4, null);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.d
    @Nullable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public BackgroundModel k(@NotNull MediaModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return model.backgroundModel;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable RenderData oldData, @NotNull RenderData newData) {
        Object firstOrNull;
        Object obj;
        Intrinsics.checkNotNullParameter(newData, "newData");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) newData.getEntity().getComponents());
        IdentifyComponent identifyComponent = (IdentifyComponent) firstOrNull;
        if (identifyComponent != null) {
            obj = identifyComponent.getData();
        } else {
            obj = null;
        }
        if (obj instanceof BackgroundModel) {
            p((BackgroundModel) obj);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
    }
}
