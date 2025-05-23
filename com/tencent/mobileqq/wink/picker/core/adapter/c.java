package com.tencent.mobileqq.wink.picker.core.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/picker/core/b;", "", "getItemCount", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", BdhLogUtil.LogTag.Tag_Conn, "I", "mediaViewHolderSize", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class c extends RecyclerView.Adapter<com.tencent.mobileqq.wink.picker.core.b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int mediaViewHolderSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkMediaListPart mediaListPart;

    public c(@NotNull WinkMediaListPart mediaListPart, int i3) {
        Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
        this.mediaListPart = mediaListPart;
        this.mediaViewHolderSize = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getNUM_BACKGOURND_ICON() {
        return 1;
    }
}
