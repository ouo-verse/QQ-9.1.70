package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.AttractPoint;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.t;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.y;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\b*\u00036AE\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010.\u001a\u00020*\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J(\u0010\u000f\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0007J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0003J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019J\u001f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0003H\u0017J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0019H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190&H\u0016J\u0016\u0010)\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190&H\u0016R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b#\u0010+\u001a\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\t0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\r0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010@\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n;", "Lpj2/a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "uuid", "t", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "clipList", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;", "v", "", "videoTransitionList", UserInfo.SEX_FEMALE, "", "px", "", "E", "B", "", "isLeft", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;Z)V", "", "position", "d", "y", "id", "selectedStatus", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;I)V", DomainData.DOMAIN_NAME, "u", "c", NodeProps.MIN_WIDTH, "a", "", "b", "set", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "", "Ljava/util/List;", "initialClipList", "initialTransitionList", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/p;", "f", "videoTrackModelList", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$d", "g", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$d;", "thumbListener", tl.h.F, "Z", "w", "()Z", "D", "(Z)V", "ignoreAttract", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$b", "i", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$b;", "dragScrollViewProxy", "com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$c", "j", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$c;", "positionChangedHandler", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;)V", "k", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class n extends pj2.a<VideoTrackContainerView> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ClipModel> initialClipList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> initialTransitionList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<VideoTrackModel> videoTrackModelList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d thumbListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean ignoreAttract;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b dragScrollViewProxy;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c positionChangedHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/t;", "", "a", "", "positionOffset", "", "isUp", "Landroid/view/View;", "v", "isLeft", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends t {
        c(b bVar) {
            super(bVar);
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.t, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
        public void a() {
            super.a();
            VideoTrackContainerView m3 = n.this.m();
            if (m3 != null) {
                m3.N();
            }
            n.this.j().a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.a(true));
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.t, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
        public void d(int positionOffset, boolean isUp, @NotNull View v3, boolean isLeft) {
            Intrinsics.checkNotNullParameter(v3, "v");
            super.d(positionOffset, isUp, v3, isLeft);
            if (isUp) {
                n.this.j().a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.a(false));
                VideoTrackContainerView m3 = n.this.m();
                if (m3 != null) {
                    m3.W();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$d", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/f;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements f {
        d() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.f
        @RequiresApi(17)
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            VideoTrackContainerView m3;
            if ((tag instanceof String) && (m3 = n.this.m()) != null) {
                m3.U((String) tag);
            }
        }
    }

    public n(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d thumbnailProvider) {
        Intrinsics.checkNotNullParameter(thumbnailProvider, "thumbnailProvider");
        this.thumbnailProvider = thumbnailProvider;
        this.initialClipList = new ArrayList();
        this.initialTransitionList = new ArrayList();
        this.videoTrackModelList = new ArrayList();
        this.thumbListener = new d();
        b bVar = new b();
        this.dragScrollViewProxy = bVar;
        this.positionChangedHandler = new c(bVar);
    }

    private final void A() {
        this.thumbnailProvider.c(this.thumbListener);
    }

    @RequiresApi(17)
    private final void t(String uuid) {
        int collectionSizeOrDefault;
        Object first;
        List<ClipModel> list = this.initialClipList;
        list.clear();
        List<VideoTrackModel> list2 = this.videoTrackModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (VideoTrackModel videoTrackModel : list2) {
            arrayList.add(VideoTrackDataTransHelperKt.b(videoTrackModel, l(), Intrinsics.areEqual(videoTrackModel.getUuid(), uuid)));
        }
        list.addAll(arrayList);
        if (!this.videoTrackModelList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.videoTrackModelList);
            int leftMargin = ((VideoTrackModel) first).getLeftMargin();
            Iterator<T> it = this.videoTrackModelList.iterator();
            while (it.hasNext()) {
                ((VideoTrackModel) it.next()).r(leftMargin);
            }
        }
        VideoTrackContainerView m3 = m();
        if (m3 != null) {
            m3.R(this.videoTrackModelList, this.initialTransitionList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<VariableClipModel> v(List<ClipModel> clipList) {
        int collectionSizeOrDefault;
        List<ClipModel> list = clipList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ClipModel) it.next()).d());
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
                long h16 = variableClipModel2.getTimeData().h() - variableClipModel.getTimeData().getTimelineStartTimeUs();
                variableClipModel2.h(h16);
                variableClipModel.i(h16);
                arrayList2.add(Unit.INSTANCE);
                next = next2;
            }
        }
        return arrayList;
    }

    public final void B() {
        this.thumbnailProvider.b(this.thumbListener);
    }

    public final void C(@NotNull String id5, int selectedStatus) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        PanelEventHandler j3 = j();
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
        j3.a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.i(id5, selectedStatus, (ClipModel) obj));
    }

    public final void D(boolean z16) {
        this.ignoreAttract = z16;
    }

    public final long E(float px5) {
        return l().t(px5);
    }

    @RequiresApi(17)
    public final void F(@NotNull List<ClipModel> clipList, @NotNull List<Object> videoTransitionList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(clipList, "clipList");
        Intrinsics.checkNotNullParameter(videoTransitionList, "videoTransitionList");
        List<ClipModel> list = this.initialClipList;
        List<Object> list2 = null;
        if (!(!Intrinsics.areEqual(clipList, list))) {
            list = null;
        }
        if (list != null) {
            list.clear();
            list.addAll(clipList);
        }
        List<Object> list3 = this.initialTransitionList;
        if (!Intrinsics.areEqual(videoTransitionList, list3)) {
            list2 = list3;
        }
        if (list2 != null) {
            list2.clear();
            list2.addAll(videoTransitionList);
        }
        A();
        List<VideoTrackModel> list4 = this.videoTrackModelList;
        list4.clear();
        List<VariableClipModel> v3 = v(clipList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(v3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = v3.iterator();
        while (it.hasNext()) {
            arrayList.add(VideoTrackDataTransHelperKt.a((VariableClipModel) it.next(), l()));
        }
        list4.addAll(arrayList);
        VideoTrackContainerView m3 = m();
        if (m3 != null) {
            m3.R(this.videoTrackModelList, this.initialTransitionList);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a
    public void a(int minWidth) {
        VideoTrackContainerView m3 = m();
        if (m3 != null) {
            m3.Q(minWidth);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l
    @NotNull
    public Set<Integer> b() {
        HashSet hashSet = new HashSet();
        for (VideoTrackModel videoTrackModel : this.videoTrackModelList) {
            hashSet.add(Integer.valueOf(videoTrackModel.getLeftMargin()));
            hashSet.add(Integer.valueOf(videoTrackModel.e()));
        }
        return hashSet;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a
    public int c() {
        Object obj;
        int i3;
        Iterator<T> it = this.videoTrackModelList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int e16 = ((VideoTrackModel) next).e();
                do {
                    Object next2 = it.next();
                    int e17 = ((VideoTrackModel) next2).e();
                    if (e16 < e17) {
                        next = next2;
                        e16 = e17;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        VideoTrackModel videoTrackModel = (VideoTrackModel) obj;
        if (videoTrackModel != null) {
            i3 = videoTrackModel.e();
        } else {
            i3 = 0;
        }
        return i3 + (getPanelViewController().getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().getLayoutConfig().getPanelStartOffset() << 1);
    }

    @Override // tj2.b
    public void d(int position) {
        m();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l
    public void e(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
    }

    @Override // pj2.a
    @RequiresApi(17)
    public void n() {
        int collectionSizeOrDefault;
        List list;
        List<VideoTrackModel> list2 = this.videoTrackModelList;
        list2.clear();
        List<VariableClipModel> v3 = v(this.initialClipList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(v3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = v3.iterator();
        while (it.hasNext()) {
            arrayList.add(VideoTrackDataTransHelperKt.a((VariableClipModel) it.next(), l()));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        list2.addAll(list);
        VideoTrackContainerView m3 = m();
        if (m3 != null) {
            m3.R(this.videoTrackModelList, this.initialTransitionList);
        }
    }

    public void u(@NotNull VideoTrackContainerView v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        super.f(v3);
        v3.setPositionChangedHandler(this.positionChangedHandler);
    }

    /* renamed from: w, reason: from getter */
    public final boolean getIgnoreAttract() {
        return this.ignoreAttract;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d getThumbnailProvider() {
        return this.thumbnailProvider;
    }

    public final void y(int position) {
        getPanelViewController().n(position, this);
    }

    @RequiresApi(17)
    public final void z(@NotNull String uuid, boolean isLeft) {
        Object obj;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        t(uuid);
        PanelEventHandler j3 = j();
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
        j3.a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.j((ClipModel) obj, isLeft));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001c\u0010!\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010#\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u0006."}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n$b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/n;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "iDragView", "", "p", "", "leftMargin", "d", "rightMargin", "j", "i", "k", "", "id", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;", "b", "", "e", "dragView", "", "isSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "a", "f", "positionOffset", "Landroid/view/View;", "view", "g", "startPoint", "endPoint", "setAdsorbedPoint", UserInfo.SEX_FEMALE, "DEFAULT_ATTRACT_DISTANCE_DP", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/y;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", tl.h.F, "()Ljava/util/ArrayList;", "trackModels", "l", "()I", "scrollX", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float DEFAULT_ATTRACT_DISTANCE_DP = 5.0f;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<y> trackModels;

        b() {
            List listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new y());
            this.trackModels = new ArrayList<>(listOf);
        }

        private final int l() {
            VideoTrackContainerView m3 = n.this.m();
            if (m3 != null) {
                return m3.getScrollX();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        @NotNull
        public List<AttractPoint> b(@NotNull String id5) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            List<AttractPoint> mutableList;
            List<AttractPoint> emptyList;
            Intrinsics.checkNotNullParameter(id5, "id");
            if (n.this.getIgnoreAttract()) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            n nVar = n.this;
            List v3 = nVar.v(nVar.initialClipList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : v3) {
                if (Intrinsics.areEqual(id5, ((VariableClipModel) obj).getUuid())) {
                    arrayList.add(obj);
                }
            }
            n nVar2 = n.this;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList<VideoTrackModel> arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(VideoTrackDataTransHelperKt.a((VariableClipModel) it.next(), nVar2.l()));
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (VideoTrackModel videoTrackModel : arrayList2) {
                arrayList3.add(new AttractPoint(videoTrackModel.getSourceData().getTimeData().h(), videoTrackModel.e(), videoTrackModel.getUuid(), false));
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
            n nVar3 = n.this;
            mutableList.add(new AttractPoint(nVar3.l().e(), nVar3.getPanelViewController().getCurrentScrollX(), "", false));
            return mutableList;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public int c() {
            return Integer.MAX_VALUE;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public int d(int leftMargin) {
            return (l() - k()) + com.tencent.videocut.utils.e.f384236a.a(leftMargin);
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public float e() {
            return com.tencent.videocut.utils.e.f384236a.a(this.DEFAULT_ATTRACT_DISTANCE_DP);
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public int f() {
            return n.this.l().c();
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public void g(int positionOffset, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        @NotNull
        public ArrayList<y> h() {
            return this.trackModels;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public int i() {
            return n.this.c();
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public int j(int rightMargin) {
            return (l() + k()) - com.tencent.videocut.utils.e.f384236a.a(rightMargin);
        }

        public int k() {
            return com.tencent.videocut.utils.o.g() / 2;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        @RequiresApi(17)
        public void p(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o iDragView) {
            Object orNull;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(iDragView, "iDragView");
            String K1 = ((VideoTrackTimelineView) iDragView).K1();
            Iterator it = n.this.videoTrackModelList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(K1, ((VideoTrackModel) it.next()).getUuid())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(n.this.videoTrackModelList, i3);
            VideoTrackModel videoTrackModel = (VideoTrackModel) orNull;
            if (videoTrackModel == null) {
                return;
            }
            int n3 = iDragView.n() - videoTrackModel.getLeftMargin();
            if (n3 != 0) {
                List list = n.this.videoTrackModelList;
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
                    videoTrackModel2.r(videoTrackModel2.getLeftMargin() + n3);
                }
                ((VideoTrackTimelineView) iDragView).M1();
            }
            int h16 = iDragView.h() - videoTrackModel.e();
            if (h16 != 0) {
                List list2 = n.this.videoTrackModelList;
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
                    videoTrackModel3.r(videoTrackModel3.getLeftMargin() + h16);
                }
            }
            videoTrackModel.r(iDragView.n());
            videoTrackModel.s(videoTrackModel.getLeftMargin() - videoTrackModel.getMinLeftMargin());
            videoTrackModel.t(iDragView.h() - iDragView.n());
            videoTrackModel.q(n.this.l().t(videoTrackModel.getWidth()));
            VideoTrackContainerView m3 = n.this.m();
            if (m3 != null) {
                m3.R(n.this.videoTrackModelList, n.this.initialTransitionList);
            }
            VideoTrackContainerView m16 = n.this.m();
            if (m16 != null) {
                m16.X(videoTrackModel.getLeftOffset());
            }
            n.this.getPanelViewController().m();
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public void a() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public void q(@Nullable com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o dragView, boolean isSelected) {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.n
        public void setAdsorbedPoint(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint) {
        }
    }
}
