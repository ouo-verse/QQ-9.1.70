package oa3;

import android.view.View;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old.BaseMemoryAlbumViewHolder;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\u000e"}, d2 = {"Loa3/b;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/holder/old/BaseMemoryAlbumViewHolder;", "Ls53/a;", "data", "", "spanCount", "", "N", "Landroid/view/View;", "itemView", "Lia3/b;", "clickListener", "<init>", "(Landroid/view/View;Lia3/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class b extends BaseMemoryAlbumViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView, bVar);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.old.BaseMemoryAlbumViewHolder, ja3.b
    /* renamed from: N */
    public void s(@NotNull s53.a data, int spanCount) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.s(data, spanCount);
        int screenWidth = ImmersiveUtils.getScreenWidth() / spanCount;
        D(getImageView(), screenWidth, (int) (screenWidth * 1.5f));
    }
}
