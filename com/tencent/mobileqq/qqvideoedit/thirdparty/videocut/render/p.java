package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import android.util.SparseArray;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PipModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Transform;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import gk2.PipRenderTargetData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b%\u0010&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/p;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "Lgk2/g;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "w", "", "u", "data", "", "t", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", HippyTKDListViewAdapter.X, com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "v", "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "Landroid/util/SparseArray;", "d", "Landroid/util/SparseArray;", "rtIds", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "e", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class p extends b<PipModel, PipRenderTargetData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<Integer> rtIds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SizeF renderSize;

    public p(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
        this.rtIds = new SparseArray<>();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        Integer num = this.rtIds.get(entityId);
        if (num != null) {
            this.tavCutSession.a(num.intValue());
            num.intValue();
            return;
        }
        this.tavCutSession.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<PipModel> s(@NotNull MediaModel model) {
        SizeF sizeF;
        List<PipModel> list;
        Intrinsics.checkNotNullParameter(model, "model");
        BackgroundModel backgroundModel = model.backgroundModel;
        if (backgroundModel != null) {
            sizeF = backgroundModel.renderSize;
        } else {
            sizeF = null;
        }
        this.renderSize = sizeF;
        list = CollectionsKt___CollectionsKt.toList(model.pips.values());
        return list;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull PipRenderTargetData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = data.b().iterator();
        while (it.hasNext()) {
            this.tavCutSession.j((InputSource) it.next());
        }
        Entity h16 = this.tavCutSession.h(data.getRenderTargetEntity(), 0);
        Entity e16 = this.tavCutSession.e(h16.getId(), data.getImageEntity());
        this.rtIds.put(e16.getId(), Integer.valueOf(h16.getId()));
        return e16.getId();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull PipModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.e.c(model);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull PipModel newModel, @NotNull PipModel oldModel) {
        ResourceModel resourceModel;
        ResourceModel resourceModel2;
        Transform transform;
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        MediaClip mediaClip = newModel.mediaClip;
        Transform transform2 = null;
        if (mediaClip != null) {
            resourceModel = mediaClip.resource;
        } else {
            resourceModel = null;
        }
        MediaClip mediaClip2 = oldModel.mediaClip;
        if (mediaClip2 != null) {
            resourceModel2 = mediaClip2.resource;
        } else {
            resourceModel2 = null;
        }
        if (Intrinsics.areEqual(resourceModel, resourceModel2)) {
            MediaClip mediaClip3 = newModel.mediaClip;
            if (mediaClip3 != null) {
                transform = mediaClip3.transform;
            } else {
                transform = null;
            }
            MediaClip mediaClip4 = oldModel.mediaClip;
            if (mediaClip4 != null) {
                transform2 = mediaClip4.transform;
            }
            if (Intrinsics.areEqual(transform, transform2) && newModel.startOffset == oldModel.startOffset) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public PipRenderTargetData q(@NotNull PipModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.e.n(model, this.renderSize);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable PipRenderTargetData oldData, @NotNull PipRenderTargetData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        for (InputSource inputSource : newData.b()) {
            com.tencent.tavcut.session.a aVar = this.tavCutSession;
            String str = inputSource.key;
            if (str == null) {
                str = "";
            }
            if (!Intrinsics.areEqual(inputSource, aVar.accessInputSource(str))) {
                this.tavCutSession.j(inputSource);
            }
        }
        Iterator<T> it = newData.getImageEntity().getComponents().iterator();
        while (it.hasNext()) {
            this.tavCutSession.c(originalEntityId, (IdentifyComponent) it.next());
        }
    }
}
