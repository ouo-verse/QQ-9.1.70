package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerTipsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/a;", "d", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/a;", "mediaPickerTipsViewModel", "<init>", "()V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerTipsPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a mediaPickerTipsViewModel;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerTipsPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a aVar = QCircleMediaPickerTipsPart.this.mediaPickerTipsViewModel;
            if (aVar != null) {
                aVar.P1(newState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleMediaPickerTipsPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        QCircleMediaPickerFragment a16;
        Map<MediaType, RecyclerView> Th;
        MediaType mediaType;
        com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a aVar = this.mediaPickerTipsViewModel;
        boolean z16 = false;
        if (aVar != null && !aVar.getInspirationTipsBubbleHasEverShown()) {
            z16 = true;
        }
        if (z16 && Intrinsics.areEqual(action, "MSG_ADD_MEDIA_LIST") && (a16 = f93.a.a(this)) != null && (Th = a16.Th()) != null) {
            if (args instanceof MediaType) {
                mediaType = (MediaType) args;
            } else {
                mediaType = null;
            }
            RecyclerView recyclerView = Th.get(mediaType);
            if (recyclerView != null) {
                recyclerView.addOnScrollListener(new b());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        QCircleMediaPickerFragment a16 = f93.a.a(this);
        if (a16 != null) {
            FragmentActivity it = a16.getActivity();
            if (it != null) {
                com.tencent.mobileqq.wink.picker.qcircle.c cVar = com.tencent.mobileqq.wink.picker.qcircle.c.f324971a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.mediaPickerTipsViewModel = cVar.a(it);
            }
            final WinkSelectedMediaViewModel j3 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(a16);
            LiveData<e93.a> Z1 = j3.Z1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTipsPart$onInitView$1$2
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
                    com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a aVar2 = QCircleMediaPickerTipsPart.this.mediaPickerTipsViewModel;
                    if (aVar2 == null) {
                        return;
                    }
                    aVar2.R1(j3.getSelectedMedia());
                }
            };
            Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaPickerTipsPart.A9(Function1.this, obj);
                }
            });
        }
    }
}
