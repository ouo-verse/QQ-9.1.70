package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PhotoClipInfo;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Rect;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Transform;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b%\u0010&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/s;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/s$a;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "w", "", "u", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "v", tl.h.F, "data", "", "t", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", HippyTKDListViewAdapter.X, "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "d", "Ljava/util/List;", "mediaClipList", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "e", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSizeF", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class s extends b<MediaClip, RenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MediaClip> mediaClipList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SizeF renderSizeF;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/s$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "a", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "b", "I", "getIndex", "()I", "index", "<init>", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;I)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.s$a, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class RenderData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Entity entity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        public RenderData(@NotNull Entity entity, int i3) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.entity = entity;
            this.index = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Entity getEntity() {
            return this.entity;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RenderData)) {
                return false;
            }
            RenderData renderData = (RenderData) other;
            if (Intrinsics.areEqual(this.entity, renderData.entity) && this.index == renderData.index) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.entity.hashCode() * 31) + this.index;
        }

        @NotNull
        public String toString() {
            return "RenderData(entity=" + this.entity + ", index=" + this.index + ")";
        }
    }

    public s(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        List<MediaClip> emptyList;
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mediaClipList = emptyList;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        this.tavCutSession.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    public boolean h() {
        return true;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<MediaClip> s(@NotNull MediaModel model) {
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(model, "model");
        BackgroundModel backgroundModel = model.backgroundModel;
        if (backgroundModel != null) {
            sizeF = backgroundModel.renderSize;
        } else {
            sizeF = null;
        }
        this.renderSizeF = sizeF;
        List<MediaClip> list = model.videos;
        this.mediaClipList = list;
        return list;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return this.tavCutSession.b(data.getEntity()).getId();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull MediaClip model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.d.a(model);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull MediaClip newModel, @NotNull MediaClip oldModel) {
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (Intrinsics.areEqual(newModel.transform, oldModel.transform) && Intrinsics.areEqual(gk2.d.b(newModel), gk2.d.b(oldModel))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public RenderData q(@NotNull MediaClip model) {
        Rect rect;
        ArrayList arrayListOf;
        PhotoClipInfo photoClipInfo;
        Rect rect2;
        Intrinsics.checkNotNullParameter(model, "model");
        Transform transform = model.transform;
        if (transform == null) {
            transform = u.a();
        }
        SizeF b16 = gk2.d.b(model);
        Iterator<MediaClip> it = this.mediaClipList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(gk2.d.a(it.next()), gk2.d.a(model))) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        PhotoClipInfo photoClipInfo2 = model.photoClip;
        if (photoClipInfo2 != null) {
            rect = photoClipInfo2.picClipRect;
        } else {
            rect = null;
        }
        if (!Intrinsics.areEqual(rect, new Rect(0, 0, 0, 0, null, 31, null)) && (photoClipInfo = model.photoClip) != null && (rect2 = photoClipInfo.picClipRect) != null) {
            b16 = new SizeF(rect2.right - rect2.left, rect2.bottom - rect2.top, null, 4, null);
        }
        od4.b bVar = od4.b.f422509e;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IdentifyComponent(bVar.n().n(i3, gk2.d.a(model))), new IdentifyComponent(gk2.i.c(transform, this.renderSizeF, b16)), new IdentifyComponent(bVar.n().a("singleMedia")));
        return new RenderData(bVar.p().a("singleMedia", arrayListOf), i3);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable RenderData oldData, @NotNull RenderData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        Iterator<T> it = newData.getEntity().getComponents().iterator();
        while (it.hasNext()) {
            this.tavCutSession.c(originalEntityId, (IdentifyComponent) it.next());
        }
    }
}
