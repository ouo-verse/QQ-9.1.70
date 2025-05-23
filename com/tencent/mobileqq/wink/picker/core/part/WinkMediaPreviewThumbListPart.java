package com.tencent.mobileqq.wink.picker.core.part;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewThumbListAdapter;
import com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.richframework.data.base.UIStateData;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00011B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPreviewThumbListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "K9", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "I", "startPosition", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "e", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "f", "Z", "showAllMedia", tl.h.F, "Landroid/view/View;", "thumbListRootView", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "thumbRecyclerView", "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewThumbListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewThumbListAdapter;", "thumbListAdapter", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "D", "F9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "baseWinkMediaViewModel", "<init>", "(ILcom/tencent/mobileqq/wink/picker/MediaType;Z)V", "E", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaPreviewThumbListPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPreviewViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy baseWinkMediaViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int startPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaType mediaType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean showAllMedia;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View thumbListRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView thumbRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkMediaPreviewThumbListAdapter thumbListAdapter;

    public WinkMediaPreviewThumbListPart(int i3, @NotNull MediaType mediaType, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.startPosition = i3;
        this.mediaType = mediaType;
        this.showAllMedia = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPreviewViewModel>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewThumbListPart$mediaPreviewViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkMediaPreviewViewModel invoke() {
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(com.tencent.mobileqq.wink.picker.core.ktx.a.a(WinkMediaPreviewThumbListPart.this));
            }
        });
        this.mediaPreviewViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BaseWinkMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewThumbListPart$baseWinkMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BaseWinkMediaViewModel invoke() {
                MediaType mediaType2;
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(WinkMediaPreviewThumbListPart.this);
                mediaType2 = WinkMediaPreviewThumbListPart.this.mediaType;
                return com.tencent.mobileqq.wink.picker.core.viewmodel.q.h(b16, mediaType2);
            }
        });
        this.baseWinkMediaViewModel = lazy2;
    }

    private final BaseWinkMediaViewModel F9() {
        return (BaseWinkMediaViewModel) this.baseWinkMediaViewModel.getValue();
    }

    private final WinkMediaPreviewViewModel G9() {
        return (WinkMediaPreviewViewModel) this.mediaPreviewViewModel.getValue();
    }

    private final void H9() {
        LiveData<e93.a> Z1;
        final WinkMediaPreviewViewModel G9 = G9();
        if (G9 != null) {
            LiveData<WinkMediaPreviewViewModel.SeqNumberTextAttrs> X1 = G9.X1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<WinkMediaPreviewViewModel.SeqNumberTextAttrs, Unit> function1 = new Function1<WinkMediaPreviewViewModel.SeqNumberTextAttrs, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewThumbListPart$observerData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
                    invoke2(seqNumberTextAttrs);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
                    WinkMediaPreviewThumbListPart.this.K9(seqNumberTextAttrs.getMedia());
                }
            };
            X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.af
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaPreviewThumbListPart.I9(Function1.this, obj);
                }
            });
            WinkSelectedMediaViewModel selectedMediaViewModel = G9.getSelectedMediaViewModel();
            if (selectedMediaViewModel != null && (Z1 = selectedMediaViewModel.Z1()) != null) {
                LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
                final Function1<e93.a, Unit> function12 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewThumbListPart$observerData$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(e93.a aVar) {
                        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter;
                        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter2;
                        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter3;
                        View view;
                        List<LocalMediaInfo> selectedMedia;
                        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter4;
                        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter5;
                        if (aVar instanceof e93.b) {
                            winkMediaPreviewThumbListAdapter4 = WinkMediaPreviewThumbListPart.this.thumbListAdapter;
                            if (winkMediaPreviewThumbListAdapter4 != null) {
                                winkMediaPreviewThumbListAdapter4.updateData(((e93.b) aVar).c());
                            }
                            winkMediaPreviewThumbListAdapter5 = WinkMediaPreviewThumbListPart.this.thumbListAdapter;
                            if (winkMediaPreviewThumbListAdapter5 != null) {
                                winkMediaPreviewThumbListAdapter5.q0(((e93.b) aVar).getIndexInSelectedMedia());
                            }
                        } else if (aVar instanceof e93.f) {
                            winkMediaPreviewThumbListAdapter = WinkMediaPreviewThumbListPart.this.thumbListAdapter;
                            if (winkMediaPreviewThumbListAdapter != null) {
                                winkMediaPreviewThumbListAdapter.updateData(((e93.f) aVar).c());
                            }
                            winkMediaPreviewThumbListAdapter2 = WinkMediaPreviewThumbListPart.this.thumbListAdapter;
                            if (winkMediaPreviewThumbListAdapter2 != null) {
                                winkMediaPreviewThumbListAdapter2.q0(((e93.f) aVar).getIndexInSelectedMedia());
                            }
                        }
                        winkMediaPreviewThumbListAdapter3 = WinkMediaPreviewThumbListPart.this.thumbListAdapter;
                        if (winkMediaPreviewThumbListAdapter3 != null) {
                            winkMediaPreviewThumbListAdapter3.notifyDataSetChanged();
                        }
                        view = WinkMediaPreviewThumbListPart.this.thumbListRootView;
                        if (view == null) {
                            return;
                        }
                        WinkSelectedMediaViewModel selectedMediaViewModel2 = G9.getSelectedMediaViewModel();
                        view.setVisibility(((selectedMediaViewModel2 == null || (selectedMedia = selectedMediaViewModel2.getSelectedMedia()) == null) ? 0 : selectedMedia.size()) <= 0 ? 8 : 0);
                    }
                };
                Z1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.ag
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkMediaPreviewThumbListPart.J9(Function1.this, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if ((!r0.isEmpty()) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K9(LocalMediaInfo localMediaInfo) {
        boolean z16;
        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter;
        List<LocalMediaInfo> l06;
        RecyclerView recyclerView;
        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter2 = this.thumbListAdapter;
        final int i3 = 0;
        if (winkMediaPreviewThumbListAdapter2 != null && (r0 = winkMediaPreviewThumbListAdapter2.l0()) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && (winkMediaPreviewThumbListAdapter = this.thumbListAdapter) != null && (l06 = winkMediaPreviewThumbListAdapter.l0()) != null) {
            Iterator<LocalMediaInfo> it = l06.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next(), localMediaInfo)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter3 = this.thumbListAdapter;
            if (winkMediaPreviewThumbListAdapter3 != null) {
                winkMediaPreviewThumbListAdapter3.q0(i3);
            }
            if (i3 != -1 && (recyclerView = this.thumbRecyclerView) != null) {
                recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.part.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkMediaPreviewThumbListPart.L9(WinkMediaPreviewThumbListPart.this, i3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(WinkMediaPreviewThumbListPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.thumbRecyclerView;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMediaPreviewThumbListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        List list;
        WinkSelectedMediaViewModel selectedMediaViewModel;
        List<LocalMediaInfo> selectedMedia;
        Object orNull;
        LiveData<UIStateData<List<LocalMediaInfo>>> mediaUIState;
        UIStateData<List<LocalMediaInfo>> value;
        List<LocalMediaInfo> data;
        Object orNull2;
        LiveData<UIStateData<List<LocalMediaInfo>>> mediaUIState2;
        UIStateData<List<LocalMediaInfo>> value2;
        List<LocalMediaInfo> data2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.thumbListRootView = rootView.findViewById(R.id.f123467gq);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f27410g6);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WinkMediaPreviewViewModel G9 = G9();
        boolean z16 = this.showAllMedia;
        BaseWinkMediaViewModel F9 = F9();
        LocalMediaInfo localMediaInfo = null;
        if (F9 != null && (mediaUIState2 = F9.getMediaUIState(this.mediaType)) != null && (value2 = mediaUIState2.getValue()) != null && (data2 = value2.getData()) != null) {
            Intrinsics.checkNotNullExpressionValue(data2, "data");
            list = CollectionsKt___CollectionsKt.toList(data2);
        } else {
            list = null;
        }
        WinkMediaPreviewThumbListAdapter winkMediaPreviewThumbListAdapter = new WinkMediaPreviewThumbListAdapter(context, G9, z16, list);
        this.thumbListAdapter = winkMediaPreviewThumbListAdapter;
        recyclerView.setAdapter(winkMediaPreviewThumbListAdapter);
        if (this.showAllMedia) {
            BaseWinkMediaViewModel F92 = F9();
            if (F92 != null && (mediaUIState = F92.getMediaUIState(this.mediaType)) != null && (value = mediaUIState.getValue()) != null && (data = value.getData()) != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(data, this.startPosition);
                localMediaInfo = (LocalMediaInfo) orNull2;
            }
            K9(localMediaInfo);
        } else {
            WinkMediaPreviewViewModel G92 = G9();
            if (G92 != null && (selectedMediaViewModel = G92.getSelectedMediaViewModel()) != null && (selectedMedia = selectedMediaViewModel.getSelectedMedia()) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(selectedMedia, this.startPosition);
                localMediaInfo = (LocalMediaInfo) orNull;
            }
            K9(localMediaInfo);
        }
        this.thumbRecyclerView = recyclerView;
        H9();
    }
}
