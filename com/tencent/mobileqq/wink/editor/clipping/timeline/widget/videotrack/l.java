package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.AttractPoint;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.t;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.y;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\u0003?HL\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u000202\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J&\u0010\u000f\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\bJ\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0003J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0016J\u001f\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\u0003H\u0016J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0016H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160-H\u0016J\u0016\u00100\u001a\u00020\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160-H\u0016J\u0006\u00101\u001a\u00020\u0013R\u0017\u00106\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b*\u00103\u001a\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\t078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\r078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00108R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020<078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00108R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR$\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00160Cj\b\u0012\u0004\u0012\u00020\u0016`D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "Lf63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "", "E", "", "uuid", "w", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "clipList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "videoTransitionList", "K", "y", "", "px", "", "I", "timeUs", "", "J", UserInfo.SEX_FEMALE, "", "isLeft", "D", "(Ljava/lang/String;Z)V", "f", "position", "d", BdhLogUtil.LogTag.Tag_Conn, "id", "selectedStatus", "G", "(Ljava/lang/String;I)V", "H", "()V", "o", "v", HippyTKDListViewAdapter.X, "c", NodeProps.MIN_WIDTH, "a", "", "b", "set", "e", "B", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "", "Ljava/util/List;", "initialClipList", "initialTransitionList", "totalDurationUs", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/n;", "g", "videoTrackModelList", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$c", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$c;", "thumbListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "attractPoint", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$a", "j", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$a;", "dragScrollViewProxy", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$b", "k", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$b;", "positionChangedHandler", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l extends f63.a<VideoTrackContainerView> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d thumbnailProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ClipModel> initialClipList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> initialTransitionList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long totalDurationUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<VideoTrackModel> videoTrackModelList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c thumbListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> attractPoint;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a dragScrollViewProxy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b positionChangedHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t;", "", "a", "", "moveX", "", "left", "g", "", "positionOffset", "isUp", "Landroid/view/View;", "view", "isLeft", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends t {
        b(a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.t, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
        public void a() {
            super.a();
            l.this.k().a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a(true));
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.t, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
        public void d(int positionOffset, boolean isUp, @NotNull View view, boolean isLeft) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.d(positionOffset, isUp, view, isLeft);
            if (isUp) {
                List list = l.this.videoTrackModelList;
                l lVar = l.this;
                int i3 = 0;
                for (Object obj : list) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    lVar.k().a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.c(VideoTrackDataTransHelperKt.b((VideoTrackModel) obj, lVar.m(), true), isLeft, 2));
                    i3 = i16;
                }
                l.this.k().a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a(false));
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.t, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
        public void g(float moveX, boolean left) {
            List list = l.this.videoTrackModelList;
            l lVar = l.this;
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                lVar.k().a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.c(VideoTrackDataTransHelperKt.b((VideoTrackModel) obj, lVar.m(), true), left, 1));
                i3 = i16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements f {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            if (tag instanceof String) {
                QLog.d("VideoThumbAssetProvider", 4, "[onThumbnailGenerated] startMs " + startTimeMs);
                VideoTrackContainerView n3 = l.this.n();
                if (n3 != null) {
                    n3.h0((String) tag);
                }
            }
        }
    }

    public l(@NotNull d thumbnailProvider) {
        Intrinsics.checkNotNullParameter(thumbnailProvider, "thumbnailProvider");
        this.thumbnailProvider = thumbnailProvider;
        this.initialClipList = new ArrayList();
        this.initialTransitionList = new ArrayList();
        this.videoTrackModelList = new ArrayList();
        this.thumbListener = new c();
        this.attractPoint = new ArrayList<>();
        a aVar = new a();
        this.dragScrollViewProxy = aVar;
        this.positionChangedHandler = new b(aVar);
    }

    private final void E() {
        this.thumbnailProvider.b(this.thumbListener);
    }

    private final void w(String uuid) {
        int collectionSizeOrDefault;
        List<ClipModel> list = this.initialClipList;
        list.clear();
        List<VideoTrackModel> list2 = this.videoTrackModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (VideoTrackModel videoTrackModel : list2) {
            arrayList.add(VideoTrackDataTransHelperKt.b(videoTrackModel, m(), Intrinsics.areEqual(videoTrackModel.getUuid(), uuid)));
        }
        list.addAll(arrayList);
        VideoTrackContainerView n3 = n();
        if (n3 != null) {
            n3.f0(this.videoTrackModelList, this.initialTransitionList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<VariableClipModel> z(List<ClipModel> clipList) {
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

    @NotNull
    /* renamed from: A, reason: from getter */
    public final d getThumbnailProvider() {
        return this.thumbnailProvider;
    }

    /* renamed from: B, reason: from getter */
    public final long getTotalDurationUs() {
        return this.totalDurationUs;
    }

    public final void C(int position) {
        getPanelViewController().v(position, this);
    }

    public final void D(@NotNull String uuid, boolean isLeft) {
        Object obj;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        w(uuid);
        PanelEventHandler k3 = k();
        Iterator<T> it = this.initialClipList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((ClipModel) obj).getUuid(), uuid)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n((ClipModel) obj, isLeft));
    }

    public final void F() {
        this.thumbnailProvider.c(this.thumbListener);
    }

    public final void G(@NotNull String id5, int selectedStatus) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        PanelEventHandler k3 = k();
        Iterator<T> it = this.initialClipList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((ClipModel) obj).getUuid(), id5)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        k3.a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.m(id5, selectedStatus, (ClipModel) obj));
    }

    public final void H() {
        k().a(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.p());
    }

    public final long I(float px5) {
        return m().x(px5);
    }

    public final int J(long timeUs) {
        return m().y(timeUs);
    }

    public final void K(@NotNull List<ClipModel> clipList, @NotNull List<Object> videoTransitionList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(clipList, "clipList");
        Intrinsics.checkNotNullParameter(videoTransitionList, "videoTransitionList");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(clipList);
        List<ClipModel> list = this.initialClipList;
        List<Object> list2 = null;
        if (!(!Intrinsics.areEqual(arrayList, list))) {
            list = null;
        }
        if (list != null) {
            list.clear();
            list.addAll(arrayList);
        }
        List<Object> list3 = this.initialTransitionList;
        if (!Intrinsics.areEqual(videoTransitionList, list3)) {
            list2 = list3;
        }
        if (list2 != null) {
            list2.clear();
            list2.addAll(videoTransitionList);
        }
        E();
        List<VideoTrackModel> list4 = this.videoTrackModelList;
        list4.clear();
        List<VariableClipModel> z16 = z(arrayList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(z16, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = z16.iterator();
        while (it.hasNext()) {
            arrayList2.add(VideoTrackDataTransHelperKt.a((VariableClipModel) it.next(), m()));
        }
        list4.addAll(arrayList2);
        this.totalDurationUs = 0L;
        Iterator<T> it5 = this.videoTrackModelList.iterator();
        while (it5.hasNext()) {
            this.totalDurationUs += ((VideoTrackModel) it5.next()).getDuration();
        }
        VideoTrackContainerView videoTrackContainerView = (VideoTrackContainerView) n();
        if (videoTrackContainerView != null) {
            videoTrackContainerView.f0(this.videoTrackModelList, this.initialTransitionList);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
        VideoTrackContainerView n3 = n();
        if (n3 != null) {
            n3.d0(minWidth);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    @NotNull
    public Set<Integer> b() {
        Set<Integer> emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a
    public int c() {
        Object obj;
        int i3;
        Iterator<T> it = this.videoTrackModelList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int f16 = ((VideoTrackModel) next).f();
                do {
                    Object next2 = it.next();
                    int f17 = ((VideoTrackModel) next2).f();
                    if (f16 < f17) {
                        next = next2;
                        f16 = f17;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        VideoTrackModel videoTrackModel = (VideoTrackModel) obj;
        if (videoTrackModel != null) {
            i3 = videoTrackModel.f();
        } else {
            i3 = 0;
        }
        return i3 + (getPanelViewController().getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().getLayoutConfig().getPanelStartOffset() << 1);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.a
    public void d(int position) {
        VideoTrackContainerView n3 = n();
        if (n3 != null) {
            n3.scrollTo(position, n3.getScrollY());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.attractPoint.clear();
        this.attractPoint.addAll(set);
    }

    @Override // i63.a
    public void f() {
        o();
    }

    @Override // f63.a
    public void o() {
        int collectionSizeOrDefault;
        List list;
        List<VideoTrackModel> list2 = this.videoTrackModelList;
        list2.clear();
        List<VariableClipModel> z16 = z(this.initialClipList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(z16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = z16.iterator();
        while (it.hasNext()) {
            arrayList.add(VideoTrackDataTransHelperKt.a((VariableClipModel) it.next(), m()));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        list2.addAll(list);
        VideoTrackContainerView n3 = n();
        if (n3 != null) {
            n3.f0(this.videoTrackModelList, this.initialTransitionList);
        }
    }

    public void x(@NotNull VideoTrackContainerView v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        super.g(v3);
        v3.setPositionChangedHandler(this.positionChangedHandler);
    }

    public final void y() {
        this.initialClipList.clear();
        this.videoTrackModelList.clear();
        this.totalDurationUs = 0L;
        VideoTrackContainerView n3 = n();
        if (n3 != null) {
            n3.q();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00142\b\u0010$\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010'\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010&R*\u0010.\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u00a8\u00062"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l$a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/l;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "iDragView", "", "k", "", "leftMargin", "d", "rightMargin", "j", "i", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "y", "l", "", "id", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "b", "", "e", "dragView", "", "isSelected", "r", "c", "a", "f", "positionOffset", "Landroid/view/View;", "view", "g", "startPoint", "endPoint", "setAdsorbedPoint", UserInfo.SEX_FEMALE, "DEFAULT_ATTRACT_DISTANCE_DP", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", tl.h.F, "()Ljava/util/ArrayList;", "trackModels", "o", "()I", "scrollX", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float DEFAULT_ATTRACT_DISTANCE_DP = 5.0f;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<y> trackModels;

        a() {
            List listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new y());
            this.trackModels = new ArrayList<>(listOf);
        }

        private final int o() {
            VideoTrackContainerView n3 = l.this.n();
            if (n3 != null) {
                return n3.getScrollX();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        @NotNull
        public List<AttractPoint> b(@NotNull String id5) {
            VideoTrackModel videoTrackModel;
            Object obj;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(id5, "id");
            l lVar = l.this;
            Iterator it = lVar.z(lVar.initialClipList).iterator();
            while (true) {
                videoTrackModel = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(id5, ((VariableClipModel) obj).getUuid())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            VariableClipModel variableClipModel = (VariableClipModel) obj;
            if (variableClipModel != null) {
                videoTrackModel = VideoTrackDataTransHelperKt.a(variableClipModel, l.this.m());
            }
            ArrayList arrayList = new ArrayList();
            if (videoTrackModel != null) {
                l lVar2 = l.this;
                ArrayList arrayList2 = lVar2.attractPoint;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    int intValue = ((Number) it5.next()).intValue();
                    arrayList3.add(new AttractPoint(lVar2.m().x(intValue), intValue, "", false));
                }
                arrayList.addAll(arrayList3);
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int c() {
            return Integer.MAX_VALUE;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int d(int leftMargin) {
            return (o() - m()) + com.tencent.videocut.utils.e.f384236a.a(leftMargin);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public float e() {
            return com.tencent.videocut.utils.e.f384236a.a(this.DEFAULT_ATTRACT_DISTANCE_DP);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int f() {
            return l.this.m().d();
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public void g(int positionOffset, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        @NotNull
        public ArrayList<y> h() {
            return this.trackModels;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int i() {
            return l.this.c();
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int j(int rightMargin) {
            return (o() + m()) - com.tencent.videocut.utils.e.f384236a.a(rightMargin);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public void k(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m iDragView) {
            Object orNull;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(iDragView, "iDragView");
            String F1 = ((VideoTrackTimelineView) iDragView).F1();
            Iterator it = l.this.videoTrackModelList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(F1, ((VideoTrackModel) it.next()).getUuid())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(l.this.videoTrackModelList, i3);
            VideoTrackModel videoTrackModel = (VideoTrackModel) orNull;
            if (videoTrackModel == null) {
                return;
            }
            int n3 = iDragView.n() - videoTrackModel.getLeftMargin();
            if (n3 != 0) {
                List list = l.this.videoTrackModelList;
                ArrayList<VideoTrackModel> arrayList = new ArrayList();
                int i16 = 0;
                for (Object obj : list) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (i16 < i3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList.add(obj);
                    }
                    i16 = i17;
                }
                for (VideoTrackModel videoTrackModel2 : arrayList) {
                    videoTrackModel2.s(videoTrackModel2.getLeftMargin() + n3);
                }
                ((VideoTrackTimelineView) iDragView).I1();
            }
            int h16 = iDragView.h() - videoTrackModel.f();
            if (h16 != 0) {
                List list2 = l.this.videoTrackModelList;
                ArrayList<VideoTrackModel> arrayList2 = new ArrayList();
                int i18 = 0;
                for (Object obj2 : list2) {
                    int i19 = i18 + 1;
                    if (i18 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (i18 > i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj2);
                    }
                    i18 = i19;
                }
                for (VideoTrackModel videoTrackModel3 : arrayList2) {
                    videoTrackModel3.s(videoTrackModel3.getLeftMargin() + h16);
                }
            }
            videoTrackModel.s(iDragView.n());
            videoTrackModel.t(videoTrackModel.getLeftMargin() - videoTrackModel.getMinLeftMargin());
            videoTrackModel.u(iDragView.h() - iDragView.n());
            videoTrackModel.r(l.this.m().x(videoTrackModel.getWidth()));
            VideoTrackContainerView n16 = l.this.n();
            if (n16 != null) {
                n16.f0(l.this.videoTrackModelList, l.this.initialTransitionList);
            }
            l.this.getPanelViewController().s();
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public void l(int x16, int y16) {
            l.this.getPanelViewController().v(x16, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int m() {
            return com.tencent.videocut.utils.o.g() / 2;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public int n() {
            return o();
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public void a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public void r(@Nullable com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m dragView, boolean isSelected) {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.l
        public void setAdsorbedPoint(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint) {
        }
    }
}
