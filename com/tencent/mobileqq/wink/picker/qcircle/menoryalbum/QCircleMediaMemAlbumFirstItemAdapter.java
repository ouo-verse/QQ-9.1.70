package com.tencent.mobileqq.wink.picker.qcircle.menoryalbum;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumPreviewFragment;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkAlbumDataViewModel;
import com.tencent.mobileqq.wink.view.u;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\r\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/menoryalbum/QCircleMediaMemAlbumFirstItemAdapter;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "", "t0", "y0", "", "eventId", "r0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/wink/picker/core/b;", "x0", "holder", com.tencent.luggage.wxa.c8.c.G, "w0", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "D", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", "E", "I", "mediaViewHolderSize", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "s0", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "albumDataViewModel", "G", "Landroidx/recyclerview/widget/RecyclerView;", "attachedRv", "", "H", "Z", "hasNotified", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;I)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaMemAlbumFirstItemAdapter extends com.tencent.mobileqq.wink.picker.core.adapter.c {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final WinkMediaListPart mediaListPart;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mediaViewHolderSize;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy albumDataViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RecyclerView attachedRv;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean hasNotified;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleMediaMemAlbumFirstItemAdapter(@NotNull WinkMediaListPart mediaListPart, int i3) {
        super(mediaListPart, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
        this.mediaListPart = mediaListPart;
        this.mediaViewHolderSize = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAlbumDataViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.QCircleMediaMemAlbumFirstItemAdapter$albumDataViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkAlbumDataViewModel invoke() {
                WinkMediaListPart winkMediaListPart;
                winkMediaListPart = QCircleMediaMemAlbumFirstItemAdapter.this.mediaListPart;
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(winkMediaListPart);
                if (b16 != null) {
                    return (WinkAlbumDataViewModel) b16.getViewModel(WinkAlbumDataViewModel.class);
                }
                return null;
            }
        });
        this.albumDataViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0() {
        v83.b.f441239a.i();
    }

    private final void r0(String eventId) {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("dt_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_GUIDE_POP);
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_GUIDE_POP);
        map.put("dt_pgid", "pg_xsj_choose_media_new_page");
        map.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        VideoReport.reportEvent(eventId, map);
    }

    private final WinkAlbumDataViewModel s0() {
        return (WinkAlbumDataViewModel) this.albumDataViewModel.getValue();
    }

    private final void t0() {
        WinkAlbumDataViewModel s06 = s0();
        if (s06 != null) {
            LiveData<List<WinkAlbumItemWrapper>> Q1 = s06.Q1();
            LifecycleOwner lifecycleOwner = this.mediaListPart.getPartHost().getLifecycleOwner();
            final QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1 qCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1 = new QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$1(this);
            Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaMemAlbumFirstItemAdapter.u0(Function1.this, obj);
                }
            });
            LiveData<Boolean> P1 = s06.P1();
            LifecycleOwner lifecycleOwner2 = this.mediaListPart.getPartHost().getLifecycleOwner();
            final QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$2 qCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$2 = new QCircleMediaMemAlbumFirstItemAdapter$observeMemoryAlbumViewModel$1$2(this);
            P1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaMemAlbumFirstItemAdapter.v0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        if (v83.e.f441245a.f()) {
            MemoryAlbumPreviewFragment.Companion companion = MemoryAlbumPreviewFragment.INSTANCE;
            Activity activity = this.mediaListPart.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "mediaListPart.activity");
            companion.a(activity);
            return;
        }
        QQCustomDialog e16 = u.f327143a.e(this.mediaListPart.getContext(), "https://qq-video.cdn-go.cn/android/latest/defaultmode/9055/qvideo_img_dialog_memoryalbum.jpg", this.mediaListPart.getContext().getString(R.string.f239087li), this.mediaListPart.getContext().getString(R.string.f239077lh), new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaMemAlbumFirstItemAdapter.z0(QCircleMediaMemAlbumFirstItemAdapter.this, view);
            }
        });
        r0("dt_imp");
        e16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(QCircleMediaMemAlbumFirstItemAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r0("dt_clck");
        v83.e.f441245a.m(true);
        WinkAlbumDataViewModel s06 = this$0.s0();
        if (s06 != null) {
            s06.T1();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.f
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMediaMemAlbumFirstItemAdapter.A0();
            }
        }, 128, null, false);
        if (w83.b.f445025a.N()) {
            MemoryAlbumPreviewFragment.Companion companion = MemoryAlbumPreviewFragment.INSTANCE;
            Activity activity = this$0.mediaListPart.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "mediaListPart.activity");
            companion.a(activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.attachedRv = recyclerView;
        t0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.wink.picker.core.b holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(new LocalMediaInfo(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.QCircleMediaMemAlbumFirstItemAdapter$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (FastClickUtils.isFastDoubleClick("QCircleMediaMemAlbumItemAdapter")) {
                    return;
                }
                QCircleMediaMemAlbumFirstItemAdapter.this.y0();
            }
        }, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.QCircleMediaMemAlbumFirstItemAdapter$onBindViewHolder$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.wink.picker.core.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i66, parent, false);
        int i3 = this.mediaViewHolderSize;
        itemView.setLayoutParams(new ViewGroup.MarginLayoutParams(i3, i3));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(itemView, s0());
    }
}
