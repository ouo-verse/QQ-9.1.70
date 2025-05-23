package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PipModel;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0005H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/m;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/a;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/h;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "data", "", "y", "w", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/p;", "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/p;", "pipRender", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/p;Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p pipRender;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull p pipRender, @NotNull com.tencent.tavcut.session.a tavCutSession) {
        super(tavCutSession);
        Intrinsics.checkNotNullParameter(pipRender, "pipRender");
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.pipRender = pipRender;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<FilterRenderData> s(@NotNull MediaModel model) {
        int collectionSizeOrDefault;
        FilterModel filterModel;
        Intrinsics.checkNotNullParameter(model, "model");
        Collection<PipModel> values = model.pips.values();
        ArrayList<Pair> arrayList = new ArrayList();
        for (PipModel pipModel : values) {
            MediaClip mediaClip = pipModel.mediaClip;
            Pair pair = null;
            if (mediaClip != null && (filterModel = mediaClip.filter) != null && filterModel.color != null) {
                pair = new Pair(filterModel, gk2.e.c(pipModel));
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (Pair pair2 : arrayList) {
            arrayList2.add(new FilterRenderData(0, (FilterModel) pair2.getFirst(), (String) pair2.getSecond(), 1, null));
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.a, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public RenderData q(@NotNull FilterRenderData model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return RenderData.b(super.q(model), null, null, model.getParentId(), 3, null);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Integer i3 = this.pipRender.i(data.getId());
        if (i3 != null) {
            return getTavCutSession().e(i3.intValue(), data.getEntity()).getId();
        }
        return 0;
    }
}
