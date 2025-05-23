package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PipModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.session.a;
import gk2.PipRenderData;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b(\u0010)J*\u0010\b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\"\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/o;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "Lgk2/f;", "data", "Lkotlin/Triple;", "", "", "u", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "", "v", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "w", "t", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", "y", "Lcom/tencent/tavcut/session/a;", "c", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "", "e", "Ljava/util/Map;", "pips", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class o extends b<PipModel, PipRenderData> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SizeF renderSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, PipModel> pips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((PipModel) t16).timelineIndex), Integer.valueOf(((PipModel) t17).timelineIndex));
            return compareValues;
        }
    }

    public o(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        Map<String, PipModel> emptyMap;
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        this.tavCutSession = tavCutSession;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.pips = emptyMap;
    }

    private final Triple<List<PipModel>, Integer, Integer> u(PipRenderData data) {
        List sortedWith;
        List mutableList;
        Object orNull;
        Integer num;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.pips.values(), new a());
        Iterator it = sortedWith.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(gk2.e.c((PipModel) it.next()), data.getPipId())) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedWith);
        mutableList.remove(i3);
        orNull = CollectionsKt___CollectionsKt.getOrNull(mutableList, i3);
        PipModel pipModel = (PipModel) orNull;
        if (pipModel != null) {
            num = i(gk2.e.c(pipModel));
        } else {
            num = null;
        }
        return new Triple<>(mutableList, num, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
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
        Map<String, PipModel> map = model.pips;
        this.pips = map;
        list = CollectionsKt___CollectionsKt.toList(map.values());
        return list;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull PipRenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = data.b().iterator();
        while (it.hasNext()) {
            this.tavCutSession.j((InputSource) it.next());
        }
        if (u(data).component2() == null) {
            a.C9882a.a(this.tavCutSession, data.getEntity(), 0, 2, null);
        } else {
            Unit unit = Unit.INSTANCE;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull PipModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.e.c(model);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull PipModel newModel, @NotNull PipModel oldModel) {
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        MediaClip mediaClip = newModel.mediaClip;
        ResourceModel resourceModel2 = null;
        if (mediaClip != null) {
            resourceModel = mediaClip.resource;
        } else {
            resourceModel = null;
        }
        MediaClip mediaClip2 = oldModel.mediaClip;
        if (mediaClip2 != null) {
            resourceModel2 = mediaClip2.resource;
        }
        if (Intrinsics.areEqual(resourceModel, resourceModel2) && newModel.startOffset == oldModel.startOffset && newModel.timelineIndex == oldModel.timelineIndex) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public PipRenderData q(@NotNull PipModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return gk2.e.m(model, this.renderSize);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable PipRenderData oldData, @NotNull PipRenderData newData) {
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
        Iterator<T> it = newData.getEntity().getComponents().iterator();
        while (it.hasNext()) {
            this.tavCutSession.c(originalEntityId, (IdentifyComponent) it.next());
        }
    }
}
