package com.tencent.mobileqq.wink.editor.extractor;

import android.graphics.Rect;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.o;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.DrawData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TagData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VariableClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackDataTransHelperKt;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import g63.VideoTrackConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.light.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/extractor/i;", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "vc", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "Li63/b;", "d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "clipList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/i;", "c", "mediaClip", "Lorg/light/TimeRange;", DownloaderConstant.KEY_RANGE, "", "selectedId", "a", "", "isSelected", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/b;", "b", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "winkVideoTavCut", "", "e", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f320308a = new i();

    i() {
    }

    private final ClipModel a(MediaClip mediaClip, TimeRange range, String selectedId) {
        int i3;
        ResourceModel resourceModel = mediaClip.resource;
        Intrinsics.checkNotNull(resourceModel);
        DrawData b16 = b(Intrinsics.areEqual(resourceModel.id, selectedId), mediaClip);
        String str = resourceModel.id;
        String str2 = resourceModel.path;
        MediaType mediaType = resourceModel.type;
        if (mediaType != null) {
            i3 = mediaType.ordinal();
        } else {
            i3 = 0;
        }
        return new ClipModel(str, i3, str2, new TimeData(range.startTime, range.duration, resourceModel.scaleDuration, resourceModel.selectDuration, resourceModel.selectStart, resourceModel.sourceDuration, resourceModel.sourceStart), b16);
    }

    private final DrawData b(boolean isSelected, MediaClip mediaClip) {
        String format;
        ResourceModel resourceModel = mediaClip.resource;
        Intrinsics.checkNotNull(resourceModel);
        ArrayList arrayList = new ArrayList();
        boolean b16 = com.tencent.mobileqq.wink.editor.clipping.a.b(mediaClip.resource);
        if (isSelected && !b16) {
            long j3 = resourceModel.selectDuration;
            long j16 = resourceModel.scaleDuration;
            if (j3 != j16 && j16 != 0) {
                float f16 = ((float) j3) / ((float) j16);
                if ((f16 > 0.74f && f16 < 0.76f) || (f16 < 1.26f && f16 > 1.24f)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    format = String.format("%.2fx", Arrays.copyOf(new Object[]{Float.valueOf(f16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    format = String.format("%.1fx", Arrays.copyOf(new Object[]{Float.valueOf(f16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
                com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
                arrayList.add(new TagData(format, 0, eVar.a(2.0f), R.drawable.f162068ns4, new Rect(0, 0, eVar.a(9.0f), eVar.a(9.0f)), 0, null, false, 0, 0, 0, 2018, null));
            }
        }
        if (isSelected) {
            return new DrawData(1, true, arrayList);
        }
        return new DrawData(-1, false, arrayList);
    }

    private final List<VariableClipModel> c(List<ClipModel> clipList) {
        int collectionSizeOrDefault;
        List<ClipModel> list = clipList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ClipModel) it.next()).g());
        }
        Iterator it5 = arrayList.iterator();
        if (!it5.hasNext()) {
            CollectionsKt__CollectionsKt.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            Object next = it5.next();
            while (it5.hasNext()) {
                Object next2 = it5.next();
                VariableClipModel variableClipModel = (VariableClipModel) next2;
                VariableClipModel variableClipModel2 = (VariableClipModel) next;
                long l3 = variableClipModel2.getTimeData().l() - variableClipModel.getTimeData().getTimelineStartTimeUs();
                variableClipModel2.h(l3);
                variableClipModel.i(l3);
                arrayList2.add(Unit.INSTANCE);
                next = next2;
            }
        }
        return arrayList;
    }

    private final i63.b d(l vc5, List<? extends MediaClip> mediaClips) {
        Intrinsics.checkNotNull(vc5);
        return vc5.m();
    }

    public final void e(@NotNull WinkVideoTavCut winkVideoTavCut) {
        boolean z16;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        long j3;
        long j16;
        Intrinsics.checkNotNullParameter(winkVideoTavCut, "winkVideoTavCut");
        List<MediaClip> g06 = winkVideoTavCut.g0();
        List<MediaClip> list = g06;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<MediaClip> list2 = g06;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            ThumbAssetModel thumbAssetModel = null;
            if (!it.hasNext()) {
                break;
            }
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                thumbAssetModel = com.tencent.mobileqq.wink.editor.clipping.a.c(resourceModel);
            }
            if (thumbAssetModel != null) {
                arrayList.add(thumbAssetModel);
            }
        }
        ThumbnailProviderManager.f319211a.u(arrayList, "QQWinkEditViewModel", g06);
        l lVar = new l(o.f319264a);
        i63.b d16 = d(lVar, g06);
        int a16 = com.tencent.videocut.utils.e.f384236a.a(new VideoTrackConfig(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 511, null).getSingleShowThumbWidth());
        int screenWidth = ViewUtils.getScreenWidth();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list2) {
            i iVar = f320308a;
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                j3 = resourceModel2.selectStart;
            } else {
                j3 = 0;
            }
            l lVar2 = lVar;
            if (resourceModel2 != null) {
                j16 = resourceModel2.scaleDuration;
            } else {
                j16 = 0;
            }
            arrayList2.add(iVar.a(mediaClip, new TimeRange(j3, j16), ""));
            lVar = lVar2;
        }
        l lVar3 = lVar;
        List<VariableClipModel> c16 = c(arrayList2);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = c16.iterator();
        while (it5.hasNext()) {
            arrayList3.add(VideoTrackDataTransHelperKt.a((VariableClipModel) it5.next(), d16));
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        if (a16 > 0) {
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, screenWidth, a16);
            if (progressionLastElement >= 0) {
                int i3 = 0;
                while (true) {
                    long x16 = d16.x(i3);
                    QLog.d("WinkEditorClippingMenuPart", 4, "Preloading bitmap i = " + i3 + "\uff0cactualTime = " + x16);
                    lVar3.getThumbnailProvider().getBitmapByTime(x16, null, ((VideoTrackModel) arrayList3.get(0)).getPath());
                    if (i3 != progressionLastElement) {
                        i3 += a16;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Step must be positive, was: " + a16 + ".");
        }
    }
}
