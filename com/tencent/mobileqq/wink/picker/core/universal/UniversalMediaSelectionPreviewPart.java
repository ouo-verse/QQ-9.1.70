package com.tencent.mobileqq.wink.picker.core.universal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import d93.d;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 *2\u00020\u0001:\u0003+,-B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0004J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "I9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$c;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$b;", "F9", "Le93/a;", "action", "L9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "e", "C9", "()Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$c;", "selectedMediaAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "D9", "()Landroidx/recyclerview/widget/RecyclerView;", "K9", "(Landroidx/recyclerview/widget/RecyclerView;)V", "selectedMediaRV", "Ld93/d;", tl.h.F, "Ld93/d;", "mediaThumbDragHelper", "<init>", "()V", "i", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class UniversalMediaSelectionPreviewPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView selectedMediaRV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d93.d mediaThumbDragHelper;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "E", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "selectedThumbImg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "selectedVideoDurationText", "H", "deleteBtn", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final WinkSelectedMediaViewModel selectedMediaViewModel;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView selectedThumbImg;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView selectedVideoDurationText;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView deleteBtn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, @Nullable WinkSelectedMediaViewModel winkSelectedMediaViewModel) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.selectedMediaViewModel = winkSelectedMediaViewModel;
            this.selectedThumbImg = (ImageView) itemView.findViewById(R.id.f82594ha);
            this.selectedVideoDurationText = (TextView) itemView.findViewById(R.id.f82604hb);
            this.deleteBtn = (ImageView) itemView.findViewById(R.id.ufy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(b this$0, LocalMediaInfo info, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            WinkSelectedMediaViewModel winkSelectedMediaViewModel = this$0.selectedMediaViewModel;
            if (winkSelectedMediaViewModel != null) {
                winkSelectedMediaViewModel.d2(this$0.getLayoutPosition(), info);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b this$0, View view) {
            List<LocalMediaInfo> selectedMedia;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WinkSelectedMediaViewModel winkSelectedMediaViewModel = this$0.selectedMediaViewModel;
            if (winkSelectedMediaViewModel != null && (selectedMedia = winkSelectedMediaViewModel.getSelectedMedia()) != null) {
                com.tencent.mobileqq.wink.picker.core.c.f324480a.i(WinkMediaPreviewFragment.INSTANCE.a(selectedMedia, this$0.getLayoutPosition()));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void n(@NotNull final LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            ImageView selectedThumbImg = this.selectedThumbImg;
            Intrinsics.checkNotNullExpressionValue(selectedThumbImg, "selectedThumbImg");
            ViewExKt.n(selectedThumbImg, info);
            if (e93.i.I(info)) {
                if (!e93.i.E(info) && (!info.isSystemMeidaStore || info.mDuration < 0)) {
                    this.selectedVideoDurationText.setVisibility(4);
                } else {
                    this.selectedVideoDurationText.setVisibility(0);
                    this.selectedVideoDurationText.setText(QAlbumUtil.formatTimeToString(info.mDuration));
                }
            } else {
                this.selectedVideoDurationText.setVisibility(4);
            }
            this.deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UniversalMediaSelectionPreviewPart.b.o(UniversalMediaSelectionPreviewPart.b.this, info, view);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UniversalMediaSelectionPreviewPart.b.p(UniversalMediaSelectionPreviewPart.b.this, view);
                }
            });
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$c;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "i0", "()Ljava/util/List;", "l0", "(Ljava/util/List;)V", "selectedMedia", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static class c<T> extends RecyclerView.Adapter<b> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private List<? extends LocalMediaInfo> selectedMedia;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WinkSelectedMediaViewModel selectedMediaViewModel;

        public c(@Nullable WinkSelectedMediaViewModel winkSelectedMediaViewModel) {
            List<? extends LocalMediaInfo> emptyList;
            this.selectedMediaViewModel = winkSelectedMediaViewModel;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.selectedMedia = emptyList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.selectedMedia.size();
        }

        @NotNull
        public final List<LocalMediaInfo> i0() {
            return this.selectedMedia;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.n(this.selectedMedia.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6k, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026list_item, parent, false)");
            return new b(inflate, this.selectedMediaViewModel);
        }

        public final void l0(@NotNull List<? extends LocalMediaInfo> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.selectedMedia = list;
        }
    }

    public UniversalMediaSelectionPreviewPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart$selectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkSelectedMediaViewModel invoke() {
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(UniversalMediaSelectionPreviewPart.this);
                if (b16 != null) {
                    return com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
                }
                return null;
            }
        });
        this.selectedMediaViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c<? extends b>>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart$selectedMediaAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UniversalMediaSelectionPreviewPart.c<? extends UniversalMediaSelectionPreviewPart.b> invoke() {
                return UniversalMediaSelectionPreviewPart.this.F9();
            }
        });
        this.selectedMediaAdapter = lazy2;
    }

    private final void G9() {
        d93.d dVar = new d93.d();
        this.mediaThumbDragHelper = dVar;
        dVar.d(1.2f);
        d93.d dVar2 = this.mediaThumbDragHelper;
        d93.d dVar3 = null;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaThumbDragHelper");
            dVar2 = null;
        }
        dVar2.b(0.9f);
        d93.d dVar4 = this.mediaThumbDragHelper;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaThumbDragHelper");
            dVar4 = null;
        }
        dVar4.c(new d());
        d93.d dVar5 = this.mediaThumbDragHelper;
        if (dVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaThumbDragHelper");
        } else {
            dVar3 = dVar5;
        }
        new ItemTouchHelper(dVar3).attachToRecyclerView(D9());
    }

    private final void H9() {
        View findViewById = getPartRootView().findViewById(R.id.f82554h7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.selectedMediaRV)");
        K9((RecyclerView) findViewById);
        D9().setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        D9().addItemDecoration(new com.tencent.mobileqq.wink.view.f(com.tencent.mobileqq.webview.view.b.e(8)));
        D9().setAdapter(C9());
        G9();
    }

    private final void I9() {
        WinkSelectedMediaViewModel E9 = E9();
        if (E9 != null) {
            C9().l0(E9.getSelectedMedia());
            C9().notifyDataSetChanged();
            LiveData<e93.a> Z1 = E9.Z1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionPreviewPart$observeData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(e93.a it) {
                    UniversalMediaSelectionPreviewPart universalMediaSelectionPreviewPart = UniversalMediaSelectionPreviewPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    universalMediaSelectionPreviewPart.L9(it);
                }
            };
            Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.universal.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionPreviewPart.J9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(UniversalMediaSelectionPreviewPart this$0, e93.a action) {
        Object last;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        RecyclerView D9 = this$0.D9();
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) ((e93.d) action).a());
        D9.smoothScrollToPosition(e93.i.p((LocalMediaInfo) last));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(UniversalMediaSelectionPreviewPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(UniversalMediaSelectionPreviewPart this$0, e93.a action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.D9().smoothScrollToPosition(((e93.b) action).getIndexInSelectedMedia());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final c<? extends b> C9() {
        return (c) this.selectedMediaAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RecyclerView D9() {
        RecyclerView recyclerView = this.selectedMediaRV;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectedMediaRV");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WinkSelectedMediaViewModel E9() {
        return (WinkSelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public c<? extends b> F9() {
        return new c<>(E9());
    }

    protected final void K9(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.selectedMediaRV = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((!r0.isEmpty()) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L9(@NotNull final e93.a action) {
        boolean z16;
        Intrinsics.checkNotNullParameter(action, "action");
        WinkSelectedMediaViewModel E9 = E9();
        if (E9 != null && (r0 = E9.getSelectedMedia()) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            D9().setVisibility(0);
        } else {
            D9().setVisibility(8);
        }
        if (action instanceof e93.d) {
            if (((e93.d) action).a().isEmpty()) {
                return;
            }
            C9().notifyDataSetChanged();
            D9().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.universal.i
                @Override // java.lang.Runnable
                public final void run() {
                    UniversalMediaSelectionPreviewPart.M9(UniversalMediaSelectionPreviewPart.this, action);
                }
            }, 100L);
            D9().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.universal.j
                @Override // java.lang.Runnable
                public final void run() {
                    UniversalMediaSelectionPreviewPart.N9(UniversalMediaSelectionPreviewPart.this);
                }
            }, 200L);
            return;
        }
        if (action instanceof e93.h) {
            C9().notifyDataSetChanged();
            return;
        }
        if (action instanceof e93.b) {
            C9().notifyDataSetChanged();
            D9().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.universal.k
                @Override // java.lang.Runnable
                public final void run() {
                    UniversalMediaSelectionPreviewPart.O9(UniversalMediaSelectionPreviewPart.this, action);
                }
            }, 100L);
        } else if (action instanceof e93.e) {
            e93.e eVar = (e93.e) action;
            C9().notifyItemMoved(eVar.getIndexInSelectedMediaFrom(), eVar.getIndexInSelectedMediaTo());
            D9().invalidateItemDecorations();
        } else if (action instanceof e93.f) {
            C9().notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        H9();
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        if (this.selectedMediaRV != null) {
            D9().setAdapter(null);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionPreviewPart$d", "Ld93/d$a;", "", "getSize", "fromPosition", "toPosition", "", "onItemMoved", "position", "c", "a", "", "isInside", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements d.a {
        d() {
        }

        @Override // d93.d.a
        public int getSize() {
            return UniversalMediaSelectionPreviewPart.this.C9().i0().size();
        }

        @Override // d93.d.a
        public void onItemMoved(int fromPosition, int toPosition) {
            WinkSelectedMediaViewModel E9 = UniversalMediaSelectionPreviewPart.this.E9();
            if (E9 != null) {
                E9.c2(fromPosition, toPosition);
            }
        }

        @Override // d93.d.a
        public void a() {
        }

        @Override // d93.d.a
        public void b(boolean isInside) {
        }

        @Override // d93.d.a
        public void c(int position) {
        }
    }
}
