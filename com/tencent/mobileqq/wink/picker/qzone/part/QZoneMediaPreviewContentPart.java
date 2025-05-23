package com.tencent.mobileqq.wink.picker.qzone.part;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewAdapter;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B;\u0012\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/part/QZoneMediaPreviewContentPart;", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewContentPart;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "P9", "", "Q9", "R9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "E9", "", NodeProps.VISIBLE, "J9", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "H", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "I", "Z", "showAllMedia", "J", "Lkotlin/Lazy;", "O9", "()Ljava/util/List;", "_previewMedia", "K", "Landroid/view/View;", "thumbListRootView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "L", "N9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "baseWinkMediaViewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "previewMedia", "", "previewStartPos", "<init>", "(Ljava/util/ArrayList;ILcom/tencent/mobileqq/wink/picker/MediaType;Z)V", "M", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaPreviewContentPart extends WinkMediaPreviewContentPart {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MediaType mediaType;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean showAllMedia;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy _previewMedia;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View thumbListRootView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy baseWinkMediaViewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/picker/qzone/part/QZoneMediaPreviewContentPart$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "position", "onPageSelected", "", "b", "Z", "isUserScrolling", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isUserScrolling;

        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            if (state == 1) {
                this.isUserScrolling = true;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            if (this.isUserScrolling) {
                com.tencent.mobileqq.wink.picker.report.a.i("2");
            }
            this.isUserScrolling = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneMediaPreviewContentPart(@Nullable ArrayList<LocalMediaInfo> arrayList, int i3, @NotNull MediaType mediaType, boolean z16) {
        super(arrayList, i3, false, 4, null);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.mediaType = mediaType;
        this.showAllMedia = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends LocalMediaInfo>>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewContentPart$_previewMedia$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends LocalMediaInfo> invoke() {
                List<? extends LocalMediaInfo> P9;
                P9 = QZoneMediaPreviewContentPart.this.P9();
                return P9;
            }
        });
        this._previewMedia = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BaseWinkMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewContentPart$baseWinkMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BaseWinkMediaViewModel invoke() {
                MediaType mediaType2;
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(QZoneMediaPreviewContentPart.this);
                if (b16 == null) {
                    return null;
                }
                mediaType2 = QZoneMediaPreviewContentPart.this.mediaType;
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.h(b16, mediaType2);
            }
        });
        this.baseWinkMediaViewModel = lazy2;
    }

    private final BaseWinkMediaViewModel N9() {
        return (BaseWinkMediaViewModel) this.baseWinkMediaViewModel.getValue();
    }

    private final List<LocalMediaInfo> O9() {
        return (List) this._previewMedia.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<LocalMediaInfo> P9() {
        List<LocalMediaInfo> emptyList;
        List<LocalMediaInfo> list;
        List<LocalMediaInfo> emptyList2;
        LiveData<UIStateData<List<LocalMediaInfo>>> mediaUIState;
        UIStateData<List<LocalMediaInfo>> value;
        List<LocalMediaInfo> list2;
        if (this.showAllMedia) {
            BaseWinkMediaViewModel N9 = N9();
            if (N9 == null || (mediaUIState = N9.getMediaUIState(this.mediaType)) == null || (value = mediaUIState.getValue()) == null || (r0 = value.getData()) == null || list2 == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            return list2;
        }
        WinkSelectedMediaViewModel F9 = F9();
        if (F9 == null || (r0 = F9.getSelectedMedia()) == null || list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    private final void Q9() {
        D9().registerOnPageChangeCallback(new b());
    }

    private final void R9() {
        LiveData<e93.a> Z1;
        WinkSelectedMediaViewModel F9 = F9();
        if (F9 != null && (Z1 = F9.Z1()) != null) {
            Z1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneMediaPreviewContentPart.S9(QZoneMediaPreviewContentPart.this, (e93.a) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZoneMediaPreviewContentPart this$0, e93.a aVar) {
        WinkMediaPreviewAdapter winkMediaPreviewAdapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((aVar instanceof e93.h) && (winkMediaPreviewAdapter = this$0.getWinkMediaPreviewAdapter()) != null) {
            winkMediaPreviewAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart
    @NotNull
    protected List<LocalMediaInfo> E9() {
        return O9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart
    public void J9(boolean visible) {
        boolean z16;
        WinkSelectedMediaViewModel selectedMediaViewModel;
        List<LocalMediaInfo> selectedMedia;
        super.J9(visible);
        WinkMediaPreviewViewModel C9 = C9();
        int i3 = 0;
        if (C9 != null && (selectedMediaViewModel = C9.getSelectedMediaViewModel()) != null && (selectedMedia = selectedMediaViewModel.getSelectedMedia()) != null && selectedMedia.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            View view = this.thumbListRootView;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.thumbListRootView;
        if (view2 != null) {
            if (!visible) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPreviewContentPart";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Q9();
        this.thumbListRootView = rootView.findViewById(R.id.f123467gq);
        R9();
    }
}
