package com.tencent.mobileqq.wink.picker.qzone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaFirstItemAdapter;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/wink/picker/core/b;", "j0", "holder", com.tencent.luggage.wxa.c8.c.G, "", "i0", "D", "I", "mediaViewHolderSize", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaFirstItemAdapter extends com.tencent.mobileqq.wink.picker.core.adapter.c {

    /* renamed from: D, reason: from kotlin metadata */
    private final int mediaViewHolderSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneMediaFirstItemAdapter(@NotNull WinkMediaListPart mediaListPart, int i3) {
        super(mediaListPart, i3);
        Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
        this.mediaViewHolderSize = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.wink.picker.core.b holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(new LocalMediaInfo(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaFirstItemAdapter$onBindViewHolder$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaFirstItemAdapter$onBindViewHolder$2
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
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.wink.picker.core.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i67, parent, false);
        int i3 = this.mediaViewHolderSize;
        itemView.setLayoutParams(new ViewGroup.MarginLayoutParams(i3, i3));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new p(itemView);
    }
}
