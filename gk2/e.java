package gk2;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PipModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Transform;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.u;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xd4.e;
import xd4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010\u001f\u001a\u00020\u0016H\u0002\u001a\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000bH\u0002\u001a\u0010\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000bH\u0002\"\u0015\u0010'\u001a\u00020\u000b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\"\u0015\u0010#\u001a\u00020\u000b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b(\u0010&\"\u0015\u0010,\u001a\u00020)*\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "Lgk2/g;", DomainData.DOMAIN_NAME, "Lgk2/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxd4/f;", "creator", "b", "a", "", "key", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "resource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "l", "Lcom/tencent/tavcut/composition/model/component/Rect;", "clipRect", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "inputSourceKey", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "k", "", "startOffset", "scaleDuration", "p", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "clip", "o", "i", "g", "name", "j", "renderTargetKey", tl.h.F, "c", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;)Ljava/lang/String;", "id", "d", "", "e", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;)F", "speed", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e {
    private static final PipRenderData a(xd4.f fVar) {
        List<IdentifyComponent> emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Entity a16 = fVar.a("pip", emptyList);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        return new PipRenderData(a16, emptyList2, 0, "");
    }

    private static final PipRenderTargetData b(xd4.f fVar) {
        List<IdentifyComponent> emptyList;
        List<IdentifyComponent> emptyList2;
        List emptyList3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Entity a16 = fVar.a("pipRenderTarget", emptyList);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        Entity a17 = fVar.a("pipRenderTargetImg", emptyList2);
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        return new PipRenderTargetData(a16, a17, emptyList3);
    }

    @NotNull
    public static final String c(@NotNull PipModel pipModel) {
        String a16;
        Intrinsics.checkNotNullParameter(pipModel, "<this>");
        MediaClip mediaClip = pipModel.mediaClip;
        if (mediaClip == null || (a16 = d.a(mediaClip)) == null) {
            return "";
        }
        return a16;
    }

    @NotNull
    public static final String d(@NotNull PipModel pipModel) {
        Intrinsics.checkNotNullParameter(pipModel, "<this>");
        return c(pipModel) + "-rt";
    }

    public static final float e(@NotNull ResourceModel resourceModel) {
        Intrinsics.checkNotNullParameter(resourceModel, "<this>");
        long j3 = resourceModel.scaleDuration;
        if (j3 == 0) {
            return 1.0f;
        }
        return ((float) resourceModel.selectDuration) / ((float) j3);
    }

    private static final InputSource f(String str, ResourceModel resourceModel) {
        return od4.b.f422509e.q().f(resourceModel.path, new TimeRange(resourceModel.selectStart, resourceModel.selectDuration, null, 4, null), str);
    }

    private static final IdentifyComponent g(String str, ResourceModel resourceModel) {
        return new IdentifyComponent(od4.b.f422509e.n().c(str, resourceModel.volume, e(resourceModel)));
    }

    private static final IdentifyComponent h(String str) {
        return new IdentifyComponent(od4.b.f422509e.n().s(str));
    }

    private static final IdentifyComponent i() {
        return new IdentifyComponent(od4.b.f422509e.n().m());
    }

    private static final IdentifyComponent j(String str) {
        return new IdentifyComponent(od4.b.f422509e.n().a(str));
    }

    private static final IdentifyComponent k(String str) {
        return new IdentifyComponent(e.a.a(od4.b.f422509e.n(), str, 0L, null, 6, null));
    }

    private static final InputSource l(String str, ResourceModel resourceModel) {
        return g.a.a(od4.b.f422509e.q(), str, resourceModel.path, null, 4, null);
    }

    @NotNull
    public static final PipRenderData m(@NotNull PipModel pipModel, @Nullable SizeF sizeF) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pipModel, "<this>");
        xd4.f p16 = od4.b.f422509e.p();
        MediaClip mediaClip = pipModel.mediaClip;
        if (mediaClip == null) {
            return a(p16);
        }
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null) {
            return a(p16);
        }
        String str = c(pipModel) + "-audio";
        if (MediaType.VIDEO == resourceModel.type) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList arrayList = new ArrayList();
        if (z16) {
            arrayList.add(f(str, resourceModel));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(j("pip"));
        arrayList2.add(k(d(pipModel)));
        arrayList2.add(p(pipModel.startOffset, resourceModel.scaleDuration));
        arrayList2.add(i());
        if (z16) {
            arrayList2.add(g(str, resourceModel));
        }
        return new PipRenderData(p16.a("pip", arrayList2), arrayList, pipModel.timelineIndex, c(pipModel));
    }

    @NotNull
    public static final PipRenderTargetData n(@NotNull PipModel pipModel, @Nullable SizeF sizeF) {
        boolean z16;
        Rect rect;
        Intrinsics.checkNotNullParameter(pipModel, "<this>");
        od4.b bVar = od4.b.f422509e;
        xd4.f p16 = bVar.p();
        MediaClip mediaClip = pipModel.mediaClip;
        if (mediaClip == null) {
            return b(p16);
        }
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null) {
            return b(p16);
        }
        xd4.g q16 = bVar.q();
        String c16 = c(pipModel);
        String d16 = d(pipModel);
        String str = c16 + "-video";
        String str2 = c16 + "-img";
        if (MediaType.VIDEO == resourceModel.type) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(q16.d("EmptyTexture", "EmptyTexture.tex"));
        arrayList.add(q16.e(d16, d16 + ".rdt", "EmptyTexture"));
        if (z16) {
            ClipSource c17 = d.c(mediaClip);
            if (c17 == null || (rect = c17.clipRect) == null) {
                rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null);
            }
            arrayList.add(q(str, resourceModel, rect));
        } else {
            arrayList.add(l(str2, resourceModel));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(j("pipRenderTarget"));
        arrayList2.add(i());
        arrayList2.add(h(d16));
        Entity a16 = p16.a("pipRenderTarget", arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(j("pipRenderTargetImg"));
        arrayList3.add(o(mediaClip, sizeF));
        if (!z16) {
            str = str2;
        }
        arrayList3.add(k(str));
        arrayList3.add(p(pipModel.startOffset, resourceModel.scaleDuration));
        return new PipRenderTargetData(a16, p16.a("pipRenderTargetImg", arrayList3), arrayList);
    }

    private static final IdentifyComponent o(MediaClip mediaClip, SizeF sizeF) {
        SizeF b16;
        Transform transform = mediaClip.transform;
        if (transform == null) {
            transform = u.a();
        }
        if (sizeF == null || (b16 = com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.i.a(sizeF, d.b(mediaClip))) == null) {
            b16 = d.b(mediaClip);
        }
        return new IdentifyComponent(i.b(transform, sizeF, b16));
    }

    private static final IdentifyComponent p(long j3, long j16) {
        return new IdentifyComponent(od4.b.f422509e.n().e(j3, j16));
    }

    private static final InputSource q(String str, ResourceModel resourceModel, Rect rect) {
        return od4.b.f422509e.q().c(str, resourceModel.path, new TimeRange(resourceModel.selectStart, resourceModel.selectDuration, null, 4, null), rect);
    }
}
