package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.session.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/t;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/t$b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "data", "", "t", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", HippyTKDListViewAdapter.X, "w", "", "u", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "v", "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "d", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class t extends b<StickerModel, RenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    public t(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        this.tavCutSession.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<StickerModel> s(@NotNull MediaModel model) {
        List<StickerModel> list;
        Intrinsics.checkNotNullParameter(model, "model");
        list = CollectionsKt___CollectionsKt.toList(model.stickers.values());
        return list;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.tavCutSession.j(data.getInputSource());
        InputSource bgInputSource = data.getBgInputSource();
        if (bgInputSource != null) {
            this.tavCutSession.j(bgInputSource);
        }
        return a.C9882a.a(this.tavCutSession, data.getEntity(), 0, 2, null).getId();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull StickerModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull StickerModel newModel, @NotNull StickerModel oldModel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (newModel.centerX == oldModel.centerX) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (newModel.centerY == oldModel.centerY) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (newModel.scale == oldModel.scale) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (newModel.rotate == oldModel.rotate) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19 && newModel.width == oldModel.width && newModel.height == oldModel.height && newModel.startTime == oldModel.startTime && newModel.duration == oldModel.duration && Intrinsics.areEqual(newModel.filePath, oldModel.filePath) && newModel.layerIndex == oldModel.layerIndex && Intrinsics.areEqual(newModel.textItems, oldModel.textItems)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public RenderData q(@NotNull StickerModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        for (TextItem textItem : model.textItems) {
            this.tavCutSession.registerFont(textItem.fontFamily, textItem.fontStyle, textItem.fontPath);
        }
        return gk2.h.e(model);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
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
        InputSource bgInputSource = newData.getBgInputSource();
        if (bgInputSource != null) {
            this.tavCutSession.j(bgInputSource);
        }
        Iterator<T> it = newData.getEntity().getComponents().iterator();
        while (it.hasNext()) {
            this.tavCutSession.c(originalEntityId, (IdentifyComponent) it.next());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/t$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "a", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "b", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "c", "()Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "bgInputSource", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/composition/model/component/InputSource;Lcom/tencent/tavcut/composition/model/component/InputSource;Ljava/lang/String;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.t$b, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class RenderData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Entity entity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final InputSource inputSource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final InputSource bgInputSource;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        public RenderData(@NotNull Entity entity, @NotNull InputSource inputSource, @Nullable InputSource inputSource2, @NotNull String id5) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(inputSource, "inputSource");
            Intrinsics.checkNotNullParameter(id5, "id");
            this.entity = entity;
            this.inputSource = inputSource;
            this.bgInputSource = inputSource2;
            this.id = id5;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final InputSource getBgInputSource() {
            return this.bgInputSource;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Entity getEntity() {
            return this.entity;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final InputSource getInputSource() {
            return this.inputSource;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RenderData)) {
                return false;
            }
            RenderData renderData = (RenderData) other;
            if (Intrinsics.areEqual(this.entity, renderData.entity) && Intrinsics.areEqual(this.inputSource, renderData.inputSource) && Intrinsics.areEqual(this.bgInputSource, renderData.bgInputSource) && Intrinsics.areEqual(this.id, renderData.id)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.entity.hashCode() * 31) + this.inputSource.hashCode()) * 31;
            InputSource inputSource = this.bgInputSource;
            if (inputSource == null) {
                hashCode = 0;
            } else {
                hashCode = inputSource.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "RenderData(entity=" + this.entity + ", inputSource=" + this.inputSource + ", bgInputSource=" + this.bgInputSource + ", id=" + this.id + ")";
        }

        public /* synthetic */ RenderData(Entity entity, InputSource inputSource, InputSource inputSource2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(entity, inputSource, inputSource2, (i3 & 8) != 0 ? "" : str);
        }
    }
}
