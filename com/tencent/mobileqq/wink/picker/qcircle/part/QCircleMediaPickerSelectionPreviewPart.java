package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerPreviewFragment;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionPreviewPart;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0014J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$c;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$b;", "F9", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "S9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "QCircleMediaItemViewHolder", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerSelectionPreviewPart extends UniversalMediaSelectionPreviewPart {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaPreviewViewModel;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart$QCircleMediaItemViewHolder;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$b;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart$b;", "I", "Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart$b;", "selectedMediaAdapter", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "J", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "K", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "", "L", "Z", "isAssembledInPreviewFragment", "Landroid/graphics/drawable/Drawable;", "M", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/graphics/drawable/Drawable;", "selectedIndicator", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "N", "Landroid/widget/ImageView;", "selectedThumbImg", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart$b;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class QCircleMediaItemViewHolder extends UniversalMediaSelectionPreviewPart.b {

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final b selectedMediaAdapter;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private final WinkSelectedMediaViewModel selectedMediaViewModel;

        /* renamed from: K, reason: from kotlin metadata */
        @Nullable
        private final WinkMediaPreviewViewModel mediaPreviewViewModel;

        /* renamed from: L, reason: from kotlin metadata */
        private final boolean isAssembledInPreviewFragment;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final Lazy selectedIndicator;

        /* renamed from: N, reason: from kotlin metadata */
        private final ImageView selectedThumbImg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QCircleMediaItemViewHolder(@NotNull final View itemView, @NotNull b selectedMediaAdapter, @Nullable WinkSelectedMediaViewModel winkSelectedMediaViewModel, @Nullable WinkMediaPreviewViewModel winkMediaPreviewViewModel, boolean z16) {
            super(itemView, winkSelectedMediaViewModel);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(selectedMediaAdapter, "selectedMediaAdapter");
            this.selectedMediaAdapter = selectedMediaAdapter;
            this.selectedMediaViewModel = winkSelectedMediaViewModel;
            this.mediaPreviewViewModel = winkMediaPreviewViewModel;
            this.isAssembledInPreviewFragment = z16;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionPreviewPart$QCircleMediaItemViewHolder$selectedIndicator$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Drawable invoke() {
                    return ContextCompat.getDrawable(itemView.getContext(), R.drawable.l6a);
                }
            });
            this.selectedIndicator = lazy;
            this.selectedThumbImg = (ImageView) itemView.findViewById(R.id.f82594ha);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(QCircleMediaItemViewHolder this$0, LocalMediaInfo info, View view) {
            List<LocalMediaInfo> selectedMedia;
            List<LocalMediaInfo> T1;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            if (this$0.isAssembledInPreviewFragment) {
                WinkMediaPreviewViewModel winkMediaPreviewViewModel = this$0.mediaPreviewViewModel;
                if (winkMediaPreviewViewModel != null && (T1 = winkMediaPreviewViewModel.T1()) != null) {
                    Iterator<LocalMediaInfo> it = T1.iterator();
                    int i3 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(it.next(), info)) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 != -1) {
                        this$0.mediaPreviewViewModel.N1(i3, info);
                    }
                }
            } else {
                WinkSelectedMediaViewModel winkSelectedMediaViewModel = this$0.selectedMediaViewModel;
                if (winkSelectedMediaViewModel != null && (selectedMedia = winkSelectedMediaViewModel.getSelectedMedia()) != null) {
                    com.tencent.mobileqq.wink.picker.core.c.f324480a.i(QCircleMediaPickerPreviewFragment.INSTANCE.a(selectedMedia, this$0.getLayoutPosition()));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final Drawable s() {
            return (Drawable) this.selectedIndicator.getValue();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart.b
        public void n(@NotNull final LocalMediaInfo info) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(info, "info");
            super.n(info);
            if (this.isAssembledInPreviewFragment) {
                ImageView imageView = this.selectedThumbImg;
                if (this.selectedMediaAdapter.getCurPreviewMediaId() == info._id) {
                    drawable = s();
                } else {
                    drawable = null;
                }
                imageView.setForeground(drawable);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleMediaPickerSelectionPreviewPart.QCircleMediaItemViewHolder.r(QCircleMediaPickerSelectionPreviewPart.QCircleMediaItemViewHolder.this, info, view);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart$b;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$c;", "Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerSelectionPreviewPart$QCircleMediaItemViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "D", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "E", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "", UserInfo.SEX_FEMALE, "Z", "isAssembledInPreviewFragment", "", "G", "J", "m0", "()J", "o0", "(J)V", "curPreviewMediaId", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends UniversalMediaSelectionPreviewPart.c<QCircleMediaItemViewHolder> {

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private final WinkSelectedMediaViewModel selectedMediaViewModel;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final WinkMediaPreviewViewModel mediaPreviewViewModel;

        /* renamed from: F, reason: from kotlin metadata */
        private final boolean isAssembledInPreviewFragment;

        /* renamed from: G, reason: from kotlin metadata */
        private long curPreviewMediaId;

        public b(@Nullable WinkSelectedMediaViewModel winkSelectedMediaViewModel, @Nullable WinkMediaPreviewViewModel winkMediaPreviewViewModel, boolean z16) {
            super(winkSelectedMediaViewModel);
            this.selectedMediaViewModel = winkSelectedMediaViewModel;
            this.mediaPreviewViewModel = winkMediaPreviewViewModel;
            this.isAssembledInPreviewFragment = z16;
            this.curPreviewMediaId = -1L;
        }

        /* renamed from: m0, reason: from getter */
        public final long getCurPreviewMediaId() {
            return this.curPreviewMediaId;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart.c, androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public QCircleMediaItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.g4g, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026list_item, parent, false)");
            return new QCircleMediaItemViewHolder(inflate, this, this.selectedMediaViewModel, this.mediaPreviewViewModel, this.isAssembledInPreviewFragment);
        }

        public final void o0(long j3) {
            this.curPreviewMediaId = j3;
        }
    }

    public QCircleMediaPickerSelectionPreviewPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPreviewViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionPreviewPart$mediaPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkMediaPreviewViewModel invoke() {
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(com.tencent.mobileqq.wink.picker.core.ktx.a.a(QCircleMediaPickerSelectionPreviewPart.this));
            }
        });
        this.mediaPreviewViewModel = lazy;
    }

    private final WinkMediaPreviewViewModel S9() {
        return (WinkMediaPreviewViewModel) this.mediaPreviewViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart
    @NotNull
    public UniversalMediaSelectionPreviewPart.c<? extends UniversalMediaSelectionPreviewPart.b> F9() {
        return new b(E9(), S9(), f93.a.b(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if ((!r2.isEmpty()) == true) goto L16;
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        boolean z16;
        if (Intrinsics.areEqual(action, "MSG_MEDIA_PREVIEW_OVERLAY_VISIBLE_CHANGED") && (args instanceof Boolean)) {
            if (((Boolean) args).booleanValue()) {
                WinkSelectedMediaViewModel E9 = E9();
                if (E9 != null && (r2 = E9.getSelectedMedia()) != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    D9().setVisibility(0);
                    return;
                }
                return;
            }
            D9().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        WinkMediaPreviewViewModel S9;
        LiveData<LocalMediaInfo> S1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (f93.a.b(this) && (S9 = S9()) != null && (S1 = S9.S1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<LocalMediaInfo, Unit> function1 = new Function1<LocalMediaInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerSelectionPreviewPart$onInitView$1
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
                    UniversalMediaSelectionPreviewPart.c C9;
                    List emptyList;
                    C9 = QCircleMediaPickerSelectionPreviewPart.this.C9();
                    QCircleMediaPickerSelectionPreviewPart.b bVar = C9 instanceof QCircleMediaPickerSelectionPreviewPart.b ? (QCircleMediaPickerSelectionPreviewPart.b) C9 : null;
                    if (bVar != null) {
                        bVar.o0(localMediaInfo._id);
                    }
                    QCircleMediaPickerSelectionPreviewPart qCircleMediaPickerSelectionPreviewPart = QCircleMediaPickerSelectionPreviewPart.this;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    qCircleMediaPickerSelectionPreviewPart.L9(new e93.h(emptyList));
                }
            };
            S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaPickerSelectionPreviewPart.T9(Function1.this, obj);
                }
            });
        }
    }
}
