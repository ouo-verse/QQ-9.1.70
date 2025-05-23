package com.tencent.mobileqq.qqvideoedit.editor.clipping;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.i;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.j;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.DrawData;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.TagData;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.h;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.render.player.IPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0082\u0001B\b\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J6\u0010\u000e\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0016\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eJ(\u0010%\u001a\u00020\u00052\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u001cJ\u0014\u0010'\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020,J\u0006\u0010.\u001a\u00020\u0005J\u0016\u00102\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00101\u001a\u000200J\u000e\u00103\u001a\u0002002\u0006\u0010$\u001a\u00020\u0007J\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\t04j\b\u0012\u0004\u0012\u00020\t`5J\u000e\u00107\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u0005J\u0016\u0010?\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=R\u0016\u0010B\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\"\u0010I\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR&\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\u000304j\b\u0012\u0004\u0012\u00020\u0003`58\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR(\u0010]\u001a\b\u0012\u0004\u0012\u00020V0U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010X\u001a\u0004\b_\u0010Z\"\u0004\b`\u0010\\R(\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00070U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010X\u001a\u0004\bc\u0010Z\"\u0004\bd\u0010\\R,\u0010i\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010X\u001a\u0004\bg\u0010Z\"\u0004\bh\u0010\\R(\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00070U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010X\u001a\u0004\bk\u0010Z\"\u0004\bl\u0010\\R(\u0010r\u001a\b\u0012\u0004\u0012\u00020n0U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010X\u001a\u0004\bp\u0010Z\"\u0004\bq\u0010\\R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010jR\"\u0010z\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010~\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b{\u0010u\u001a\u0004\b|\u0010w\"\u0004\b}\u0010y\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/TimelineViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "list", "", "l2", "", "r2", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "videos", "q2", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/b;", "selectedTimeline", "p2", "mediaClip", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", DownloaderConstant.KEY_RANGE, "", "selectedId", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "M1", "", "isSelected", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/b;", "N1", "o2", "getLogTag", "Lcom/tencent/tavcut/session/a;", "cutSession", "Lcom/tencent/tavcut/render/player/IPlayer;", "player", "f2", "clips", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "backgroundModel", "playerTime", "g2", "X1", "m2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/i;", "event", "d2", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/j;", "e2", "c2", "id", "", "targetIndex", "b2", "P1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "T1", "L1", "Q1", "O1", SemanticAttributes.DbSystemValues.H2, "Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/RectF;", "rectF", "k2", "i", "Lcom/tencent/tavcut/session/a;", "mCutSession", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tavcut/render/player/IPlayer;", "W1", "()Lcom/tencent/tavcut/render/player/IPlayer;", "j2", "(Lcom/tencent/tavcut/render/player/IPlayer;)V", "mPlayer", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "mCurrentMediaModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "D", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "renderLayerHelper", "E", "Ljava/util/ArrayList;", "timelineList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/o;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "setVideoTracksLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "videoTracksLiveData", "G", "getDurationLiveData", "setDurationLiveData", "durationLiveData", "H", "Z1", "setVideoSourceDurationLiveData", "videoSourceDurationLiveData", "I", "getSelectedTimelineLiveData", "setSelectedTimelineLiveData", "selectedTimelineLiveData", "J", "S1", "setCurrentPlayerTimeLiveData", "currentPlayerTimeLiveData", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "K", "R1", "setCurrentPlayerStatus", "currentPlayerStatus", "L", "M", "Z", "U1", "()Z", "i2", "(Z)V", "firstEnter", "N", "getHasChanged", "setHasChanged", "hasChanged", "<init>", "()V", "P", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TimelineViewModel extends BaseViewModel {

    /* renamed from: D, reason: from kotlin metadata */
    private ComposeRenderLayer renderLayerHelper;

    /* renamed from: L, reason: from kotlin metadata */
    private long playerTime;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasChanged;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.session.a mCutSession;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public IPlayer mPlayer;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MediaModel mCurrentMediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Timeline> timelineList = new ArrayList<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<VideoTrackData> videoTracksLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> durationLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> videoSourceDurationLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<SelectItem<?>> selectedTimelineLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> currentPlayerTimeLiveData = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<IPlayer.PlayerStatus> currentPlayerStatus = new MutableLiveData<>();

    /* renamed from: M, reason: from kotlin metadata */
    private boolean firstEnter = true;

    private final ClipModel M1(MediaClip mediaClip, TimeRange range, String selectedId) {
        int i3;
        ResourceModel resourceModel = mediaClip.resource;
        Intrinsics.checkNotNull(resourceModel);
        DrawData N1 = N1(Intrinsics.areEqual(resourceModel.id, selectedId), mediaClip);
        String str = resourceModel.id;
        String str2 = resourceModel.path;
        MediaType mediaType = resourceModel.type;
        if (mediaType != null) {
            i3 = mediaType.ordinal();
        } else {
            i3 = 0;
        }
        long j3 = resourceModel.selectStart;
        long j16 = resourceModel.selectDuration;
        return new ClipModel(str, i3, str2, new h(j3, j16, resourceModel.scaleDuration, j16, j3, resourceModel.sourceDuration, resourceModel.sourceStart), N1);
    }

    private final DrawData N1(boolean isSelected, MediaClip mediaClip) {
        boolean z16;
        String format;
        ResourceModel resourceModel = mediaClip.resource;
        Intrinsics.checkNotNull(resourceModel);
        ArrayList arrayList = new ArrayList();
        long j3 = resourceModel.selectDuration;
        long j16 = resourceModel.scaleDuration;
        if (j3 != j16 && j16 != 0) {
            if (((float) j3) / ((float) j16) == 0.75f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format("%.2fx", Arrays.copyOf(new Object[]{Float.valueOf(((float) j3) / ((float) j16))}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                format = String.format("%.1fx", Arrays.copyOf(new Object[]{Float.valueOf(((float) j3) / ((float) j16))}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            arrayList.add(new TagData(format, 0, 2, null));
        }
        if (isSelected) {
            return new DrawData(1, true, arrayList);
        }
        return new DrawData(-1, false, arrayList);
    }

    private final void l2(List<Timeline> list) {
        long j3;
        long j16;
        Object obj;
        TimeRange timeRange;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(((Timeline) obj2).type, "TimeOffset")) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        long j17 = 0;
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                TimeRange timeRange2 = ((Timeline) next).range;
                if (timeRange2 != null) {
                    j3 = timeRange2.duration;
                } else {
                    j3 = 0;
                }
                do {
                    Object next2 = it.next();
                    TimeRange timeRange3 = ((Timeline) next2).range;
                    if (timeRange3 != null) {
                        j16 = timeRange3.duration;
                    } else {
                        j16 = 0;
                    }
                    if (j3 < j16) {
                        next = next2;
                        j3 = j16;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline != null && (timeRange = timeline.range) != null) {
            j17 = timeRange.duration;
        }
        this.durationLiveData.postValue(Long.valueOf(j17));
    }

    private final void o2() {
        ThumbAssetModel thumbAssetModel;
        ArrayList arrayList = new ArrayList();
        List<MediaClip> list = this.mCurrentMediaModel.videos;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                thumbAssetModel = a.a(resourceModel);
            } else {
                thumbAssetModel = null;
            }
            if (thumbAssetModel != null) {
                arrayList2.add(thumbAssetModel);
            }
        }
        arrayList.addAll(arrayList2);
        ThumbnailProviderManager.f275307a.l(arrayList, "QQVideoEditViewModel");
    }

    private final void p2(List<MediaClip> videos, SelectItem<?> selectedTimeline, List<Timeline> list) {
        String str;
        List zip;
        int collectionSizeOrDefault;
        boolean z16;
        if (list != null && videos != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Intrinsics.areEqual(((Timeline) obj).type, "VideoSource")) {
                    arrayList.add(obj);
                }
            }
            if (videos.size() != arrayList.size()) {
                Logger.f275870a.c("QQVideoEditViewModel", "updateVideoClip size diff!,videos:" + videos + ",videoSources:" + arrayList);
            }
            if (selectedTimeline == null || (str = selectedTimeline.getId()) == null) {
                str = "";
            }
            zip = CollectionsKt___CollectionsKt.zip(videos, arrayList);
            ArrayList<Pair> arrayList2 = new ArrayList();
            for (Object obj2 : zip) {
                Pair pair = (Pair) obj2;
                if (((MediaClip) pair.getFirst()).resource != null && ((Timeline) pair.getSecond()).range != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (Pair pair2 : arrayList2) {
                MediaClip mediaClip = (MediaClip) pair2.component1();
                TimeRange timeRange = ((Timeline) pair2.component2()).range;
                Intrinsics.checkNotNull(timeRange);
                arrayList3.add(M1(mediaClip, timeRange, str));
            }
            this.videoTracksLiveData.postValue(new VideoTrackData(arrayList3, null, 2, null));
        }
    }

    private final void q2(List<MediaClip> videos, List<Timeline> list) {
        Long l3;
        Object first;
        ResourceModel resourceModel;
        boolean z16 = false;
        if (videos != null && videos.isEmpty()) {
            z16 = true;
        }
        if (z16) {
            l3 = Long.valueOf(r2(list));
        } else {
            if (videos != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) videos);
                MediaClip mediaClip = (MediaClip) first;
                if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                    l3 = Long.valueOf(resourceModel.selectDuration);
                }
            }
            l3 = null;
        }
        this.videoSourceDurationLiveData.postValue(l3);
    }

    private final long r2(List<Timeline> list) {
        long j3;
        long j16;
        Object obj;
        TimeRange timeRange;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(((Timeline) obj2).type, "VideoSource")) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                TimeRange timeRange2 = ((Timeline) next).range;
                if (timeRange2 != null) {
                    j3 = timeRange2.duration + timeRange2.startTime;
                } else {
                    j3 = 0;
                }
                do {
                    Object next2 = it.next();
                    TimeRange timeRange3 = ((Timeline) next2).range;
                    if (timeRange3 != null) {
                        j16 = timeRange3.duration + timeRange3.startTime;
                    } else {
                        j16 = 0;
                    }
                    if (j3 < j16) {
                        next = next2;
                        j3 = j16;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline == null || (timeRange = timeline.range) == null) {
            return 0L;
        }
        return timeRange.duration + timeRange.startTime;
    }

    public final void L1(long playerTime) {
        String str;
        if (this.currentPlayerStatus.getValue() == IPlayer.PlayerStatus.PAUSED) {
            return;
        }
        ResourceModel resourceModel = this.mCurrentMediaModel.videos.get(P1(playerTime + 50000)).resource;
        if (resourceModel != null) {
            SelectItem<?> value = this.selectedTimelineLiveData.getValue();
            if (value != null) {
                str = value.getId();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, resourceModel.id)) {
                SelectItem<?> selectItem = new SelectItem<>(resourceModel.id, 1, new TimelineTimeRange(resourceModel.selectStart, resourceModel.selectDuration), 1);
                this.selectedTimelineLiveData.setValue(selectItem);
                p2(this.mCurrentMediaModel.videos, selectItem, this.timelineList);
            }
        }
    }

    public final long O1() {
        long j3;
        long j16;
        Object obj;
        ResourceModel resourceModel;
        Iterator<T> it = this.mCurrentMediaModel.videos.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                ResourceModel resourceModel2 = ((MediaClip) next).resource;
                if (resourceModel2 != null) {
                    j3 = resourceModel2.selectDuration;
                } else {
                    j3 = 0;
                }
                do {
                    Object next2 = it.next();
                    ResourceModel resourceModel3 = ((MediaClip) next2).resource;
                    if (resourceModel3 != null) {
                        j16 = resourceModel3.selectDuration;
                    } else {
                        j16 = 0;
                    }
                    if (j3 > j16) {
                        next = next2;
                        j3 = j16;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        MediaClip mediaClip = (MediaClip) obj;
        if (mediaClip == null || (resourceModel = mediaClip.resource) == null) {
            return 0L;
        }
        return resourceModel.selectDuration;
    }

    public final int P1(long playerTime) {
        long j3;
        long j16 = 0;
        for (MediaClip mediaClip : this.mCurrentMediaModel.videos) {
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                j3 = resourceModel.selectDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
            if (j16 > playerTime) {
                return Math.max(0, this.mCurrentMediaModel.videos.indexOf(mediaClip));
            }
        }
        return 0;
    }

    public final long Q1() {
        Long value = this.videoSourceDurationLiveData.getValue();
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    @NotNull
    public final MutableLiveData<IPlayer.PlayerStatus> R1() {
        return this.currentPlayerStatus;
    }

    @NotNull
    public final MutableLiveData<Long> S1() {
        return this.currentPlayerTimeLiveData;
    }

    @NotNull
    public final ArrayList<MediaClip> T1() {
        ArrayList<MediaClip> arrayList = new ArrayList<>();
        arrayList.addAll(this.mCurrentMediaModel.videos);
        return arrayList;
    }

    /* renamed from: U1, reason: from getter */
    public final boolean getFirstEnter() {
        return this.firstEnter;
    }

    @NotNull
    public final IPlayer W1() {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            return iPlayer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
        return null;
    }

    @NotNull
    public final com.tencent.tavcut.session.a X1() {
        com.tencent.tavcut.session.a aVar = this.mCutSession;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
            return null;
        }
        return aVar;
    }

    @NotNull
    public final MutableLiveData<Long> Z1() {
        return this.videoSourceDurationLiveData;
    }

    @NotNull
    public final MutableLiveData<VideoTrackData> a2() {
        return this.videoTracksLiveData;
    }

    public final void b2(@NotNull String id5, int targetIndex) {
        final List mutableList;
        String str;
        Intrinsics.checkNotNullParameter(id5, "id");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mCurrentMediaModel.videos);
        Iterator it = mutableList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                if (resourceModel != null) {
                    str = resourceModel.id;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, id5)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        Function1<Integer, Boolean> function1 = new Function1<Integer, Boolean>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.TimelineViewModel$handleChangeClipsOrder$checkRange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Boolean invoke(int i16) {
                return Boolean.valueOf(i16 >= 0 && i16 < mutableList.size());
            }
        };
        if (function1.invoke(Integer.valueOf(i3)).booleanValue() && function1.invoke(Integer.valueOf(targetIndex)).booleanValue()) {
            mutableList.add(targetIndex, (MediaClip) mutableList.remove(i3));
            this.mCurrentMediaModel = MediaModel.copy$default(this.mCurrentMediaModel, null, null, null, null, null, null, mutableList, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
            ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
            if (composeRenderLayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer = null;
            }
            composeRenderLayer.d(this.mCurrentMediaModel);
            this.hasChanged = true;
        }
    }

    public final void c2() {
        p2(this.mCurrentMediaModel.videos, null, this.timelineList);
        this.selectedTimelineLiveData.postValue(null);
    }

    public final void d2(@NotNull i event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public final void e2(@NotNull j event) {
        List mutableList;
        Object obj;
        ResourceModel resourceModel;
        ResourceModel resourceModel2;
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        ClipModel data = event.getData();
        if (data != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mCurrentMediaModel.videos);
            Iterator it = mutableList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    ResourceModel resourceModel3 = ((MediaClip) obj).resource;
                    if (resourceModel3 != null) {
                        str = resourceModel3.id;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, data.getUuid())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MediaClip mediaClip = (MediaClip) obj;
            if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                ResourceModel copy$default = ResourceModel.copy$default(resourceModel, null, null, Long.valueOf(data.getTimeData().getScaleDurationUs()), null, null, Long.valueOf(data.getTimeData().getSelectStartTimeUs()), Long.valueOf(data.getTimeData().getSelectDurationUs()), null, null, null, null, null, null, null, null, null, 65435, null);
                if (!Intrinsics.areEqual(copy$default, resourceModel)) {
                    resourceModel2 = copy$default;
                } else {
                    resourceModel2 = null;
                }
                if (resourceModel2 != null) {
                    mutableList.set(mutableList.indexOf(mediaClip), MediaClip.copy$default(mediaClip, resourceModel2, null, null, null, null, null, null, 126, null));
                    this.mCurrentMediaModel = MediaModel.copy$default(this.mCurrentMediaModel, null, null, null, null, null, null, mutableList, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
                    ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
                    if (composeRenderLayer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                        composeRenderLayer = null;
                    }
                    composeRenderLayer.d(this.mCurrentMediaModel);
                    this.hasChanged = true;
                }
            }
        }
    }

    public final void f2(@NotNull com.tencent.tavcut.session.a cutSession, @NotNull IPlayer player) {
        Intrinsics.checkNotNullParameter(cutSession, "cutSession");
        Intrinsics.checkNotNullParameter(player, "player");
        this.mCutSession = cutSession;
        j2(player);
    }

    public final void g2(@Nullable List<MediaClip> clips, @NotNull BackgroundModel backgroundModel, long playerTime) {
        Intrinsics.checkNotNullParameter(backgroundModel, "backgroundModel");
        if (this.renderLayerHelper == null) {
            com.tencent.tavcut.session.a aVar = this.mCutSession;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
                aVar = null;
            }
            this.renderLayerHelper = new ComposeRenderLayer(aVar, new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null), ComposeRenderLayer.RenderScene.VIDEO);
        }
        this.playerTime = playerTime;
        if (clips != null) {
            if (Intrinsics.areEqual(this.mCurrentMediaModel.videos, clips) && Intrinsics.areEqual(this.mCurrentMediaModel.backgroundModel, backgroundModel)) {
                n2();
            } else {
                this.mCurrentMediaModel = MediaModel.copy$default(this.mCurrentMediaModel, null, null, null, null, null, null, clips, null, null, backgroundModel, null, null, null, null, null, null, null, null, null, 523711, null);
                ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
                if (composeRenderLayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                    composeRenderLayer = null;
                }
                composeRenderLayer.d(this.mCurrentMediaModel);
                W1().seek(playerTime);
            }
            W1().play();
        }
        this.hasChanged = false;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQVideoEditViewModel";
    }

    public final void h2() {
        com.tencent.tavcut.session.a aVar = this.mCutSession;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
            aVar = null;
        }
        aVar.release();
    }

    public final void i2(boolean z16) {
        this.firstEnter = z16;
    }

    public final void j2(@NotNull IPlayer iPlayer) {
        Intrinsics.checkNotNullParameter(iPlayer, "<set-?>");
        this.mPlayer = iPlayer;
    }

    public final void k2(@NotNull Matrix matrix, @NotNull RectF rectF) {
        int collectionSizeOrDefault;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        MediaModel mediaModel = this.mCurrentMediaModel;
        List<MediaClip> list = mediaModel.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            List<Float> a16 = com.tencent.mobileqq.qqvideoedit.editor.crop.a.a(matrix);
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = ResourceModel.copy$default(resourceModel2, null, null, null, null, null, null, null, null, null, null, null, new com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF(rectF.left, rectF.top, rectF.right, rectF.bottom, null, 16, null), null, null, null, null, 63487, null);
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, a16, null, 94, null));
        }
        this.mCurrentMediaModel = MediaModel.copy$default(mediaModel, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
    }

    public final void m2(@NotNull List<Timeline> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.timelineList.clear();
        this.timelineList.addAll(list);
        l2(list);
        q2(this.mCurrentMediaModel.videos, list);
        p2(this.mCurrentMediaModel.videos, this.selectedTimelineLiveData.getValue(), list);
        o2();
    }

    public final void n2() {
        int P1 = P1(this.playerTime);
        if (P1 >= this.mCurrentMediaModel.videos.size()) {
            Logger.f275870a.c("QQVideoEditViewModel", "updateSelectItem failed, IndexOutOfBounds!");
            return;
        }
        ResourceModel resourceModel = this.mCurrentMediaModel.videos.get(P1).resource;
        if (resourceModel != null) {
            SelectItem<?> selectItem = new SelectItem<>(resourceModel.id, 1, new TimelineTimeRange(resourceModel.selectStart, resourceModel.selectDuration), 1);
            this.selectedTimelineLiveData.postValue(selectItem);
            p2(this.mCurrentMediaModel.videos, selectItem, this.timelineList);
        }
        W1().seek(this.playerTime);
    }
}
