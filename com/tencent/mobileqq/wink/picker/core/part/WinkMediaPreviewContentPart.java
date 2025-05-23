package com.tencent.mobileqq.wink.picker.core.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.view.WinkBasePreviewVideoView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 F2\u00020\u0001:\u0002GHB5\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R(\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u0004\u0018\u00010 8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010\"\u001a\u0004\b<\u0010=R\"\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001060@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "E9", "", NodeProps.VISIBLE, "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "previewMedia", "", "e", "I", "previewStartPos", "f", "Z", "isVideoAutoPlay", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", tl.h.F, "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "i", "C9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "titleBar", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "G9", "()Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;", "setWinkMediaPreviewAdapter", "(Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewAdapter;)V", "winkMediaPreviewAdapter", "Lcom/tencent/mobileqq/wink/picker/core/view/WinkBasePreviewVideoView;", "D", "Lcom/tencent/mobileqq/wink/picker/core/view/WinkBasePreviewVideoView;", "curVideoView", "Landroidx/viewpager2/widget/ViewPager2;", "E", "D9", "()Landroidx/viewpager2/widget/ViewPager2;", "mediaPreviewViewPager", "", "Lmqq/util/WeakReference;", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "videoViewRefs", "<init>", "(Ljava/util/ArrayList;IZ)V", "G", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkMediaPreviewContentPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkMediaPreviewAdapter winkMediaPreviewAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WinkBasePreviewVideoView curVideoView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPreviewViewPager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<WeakReference<WinkBasePreviewVideoView>> videoViewRefs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<LocalMediaInfo> previewMedia;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int previewStartPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isVideoAutoPlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaPreviewViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View titleBar;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$b;", "", "", NodeProps.ON_CLICK, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void onClick();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<LocalMediaInfo> f324552c;

        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends LocalMediaInfo> list) {
            this.f324552c = list;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            Object orNull;
            WinkMediaPreviewViewModel C9 = WinkMediaPreviewContentPart.this.C9();
            if (C9 != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.f324552c, position);
                C9.N1(position, (LocalMediaInfo) orNull);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$d", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$b;", "", NodeProps.ON_CLICK, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements b {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart.b
        public void onClick() {
            WinkMediaPreviewContentPart winkMediaPreviewContentPart = WinkMediaPreviewContentPart.this;
            View view = winkMediaPreviewContentPart.titleBar;
            boolean z16 = false;
            if (view != null && view.getVisibility() == 0) {
                z16 = true;
            }
            winkMediaPreviewContentPart.J9(!z16);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart$e", "Lcom/tencent/mobileqq/wink/picker/core/view/c;", "Lcom/tencent/mobileqq/wink/picker/core/view/WinkBasePreviewVideoView;", "view", "", "a", "", "id", "", "state", "onStateChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements com.tencent.mobileqq.wink.picker.core.view.c {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.c
        public void a(@NotNull WinkBasePreviewVideoView view) {
            Object obj;
            Intrinsics.checkNotNullParameter(view, "view");
            WinkMediaPreviewContentPart.this.curVideoView = view;
            View view2 = WinkMediaPreviewContentPart.this.titleBar;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            Iterator it = WinkMediaPreviewContentPart.this.videoViewRefs.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((WeakReference) obj).get(), view)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                WinkMediaPreviewContentPart.this.videoViewRefs.add(new WeakReference(view));
            }
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.c
        public void onStateChange(long id5, int state) {
            if (state != 4) {
                if (state == 6) {
                    WinkMediaPreviewContentPart.this.J9(true);
                    return;
                }
                return;
            }
            WinkMediaPreviewContentPart.this.J9(false);
        }
    }

    public /* synthetic */ WinkMediaPreviewContentPart(ArrayList arrayList, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, i3, (i16 & 4) != 0 ? false : z16);
    }

    private final void H9() {
        D9().setOrientation(0);
        e eVar = new e();
        d dVar = new d();
        List<LocalMediaInfo> E9 = E9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.winkMediaPreviewAdapter = new WinkMediaPreviewAdapter(context, E9, eVar, dVar, C9(), this.isVideoAutoPlay);
        D9().setAdapter(this.winkMediaPreviewAdapter);
        D9().registerOnPageChangeCallback(new c(E9));
        D9().setCurrentItem(this.previewStartPos, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WinkMediaPreviewViewModel C9() {
        return (WinkMediaPreviewViewModel) this.mediaPreviewViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ViewPager2 D9() {
        Object value = this.mediaPreviewViewPager.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mediaPreviewViewPager>(...)");
        return (ViewPager2) value;
    }

    @NotNull
    protected List<LocalMediaInfo> E9() {
        List<LocalMediaInfo> emptyList;
        ArrayList<LocalMediaInfo> arrayList = this.previewMedia;
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WinkSelectedMediaViewModel F9() {
        return (WinkSelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: G9, reason: from getter */
    public final WinkMediaPreviewAdapter getWinkMediaPreviewAdapter() {
        return this.winkMediaPreviewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J9(boolean visible) {
        int i3;
        broadcastMessage("MSG_MEDIA_PREVIEW_OVERLAY_VISIBLE_CHANGED", Boolean.valueOf(visible));
        View view = this.titleBar;
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMediaPreviewContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        LiveData<LocalMediaInfo> S1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (this.previewMedia == null) {
            return;
        }
        this.titleBar = rootView.findViewById(R.id.f123477gr);
        H9();
        WinkMediaPreviewViewModel C9 = C9();
        if (C9 != null) {
            C9.Z1(F9(), E9());
        }
        WinkMediaPreviewViewModel C92 = C9();
        if (C92 != null && (S1 = C92.S1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<LocalMediaInfo, Unit> function1 = new Function1<LocalMediaInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LocalMediaInfo localMediaInfo) {
                    invoke2(localMediaInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LocalMediaInfo localMediaInfo) {
                    WinkMediaPreviewViewModel C93 = WinkMediaPreviewContentPart.this.C9();
                    int curPreviewMediaLayoutPosition = C93 != null ? C93.getCurPreviewMediaLayoutPosition() : 0;
                    if (WinkMediaPreviewContentPart.this.D9().getCurrentItem() != curPreviewMediaLayoutPosition) {
                        WinkMediaPreviewContentPart.this.D9().setCurrentItem(curPreviewMediaLayoutPosition, false);
                    }
                }
            };
            S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.ad
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaPreviewContentPart.I9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        WinkMediaPreviewAdapter winkMediaPreviewAdapter = this.winkMediaPreviewAdapter;
        if (winkMediaPreviewAdapter != null) {
            winkMediaPreviewAdapter.l0();
        }
        WinkBasePreviewVideoView winkBasePreviewVideoView = this.curVideoView;
        if (winkBasePreviewVideoView != null) {
            winkBasePreviewVideoView.c();
        }
        this.winkMediaPreviewAdapter = null;
        int size = this.videoViewRefs.size();
        Iterator<T> it = this.videoViewRefs.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            WinkBasePreviewVideoView winkBasePreviewVideoView2 = (WinkBasePreviewVideoView) ((WeakReference) it.next()).get();
            if (winkBasePreviewVideoView2 != null) {
                i3++;
                if (winkBasePreviewVideoView2.c()) {
                    i16++;
                }
            }
        }
        w53.b.f("WinkMediaPreviewContentPart", "[onPartDestroy] refsCount=" + size + ", videoViewCount=" + i3 + ", releaseCount=" + i16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        WinkBasePreviewVideoView winkBasePreviewVideoView = this.curVideoView;
        if (winkBasePreviewVideoView != null) {
            winkBasePreviewVideoView.b(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        WinkBasePreviewVideoView winkBasePreviewVideoView = this.curVideoView;
        if (winkBasePreviewVideoView != null) {
            winkBasePreviewVideoView.b(!this.isVideoAutoPlay);
        }
    }

    public WinkMediaPreviewContentPart(@Nullable ArrayList<LocalMediaInfo> arrayList, int i3, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.previewMedia = arrayList;
        this.previewStartPos = i3;
        this.isVideoAutoPlay = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart$selectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkSelectedMediaViewModel invoke() {
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(WinkMediaPreviewContentPart.this);
                if (b16 != null) {
                    return com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
                }
                return null;
            }
        });
        this.selectedMediaViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPreviewViewModel>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart$mediaPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkMediaPreviewViewModel invoke() {
                WinkMediaPickerChildFragment a16 = com.tencent.mobileqq.wink.picker.core.ktx.a.a(WinkMediaPreviewContentPart.this);
                if (a16 != null) {
                    return com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(a16);
                }
                return null;
            }
        });
        this.mediaPreviewViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart$mediaPreviewViewPager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewPager2 invoke() {
                return (ViewPager2) WinkMediaPreviewContentPart.this.getPartRootView().findViewById(R.id.yzf);
            }
        });
        this.mediaPreviewViewPager = lazy3;
        this.videoViewRefs = new LinkedHashSet();
    }
}
