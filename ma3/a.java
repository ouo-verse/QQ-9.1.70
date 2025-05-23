package ma3;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u0010"}, d2 = {"Lma3/a;", "Lma3/b;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "data", "", BdhLogUtil.LogTag.Tag_Req, "N", "", "spanCount", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "itemView", "Lia3/b;", "clickListener", "<init>", "(Landroid/view/View;Lia3/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class a extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView, bVar);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder, ja3.b
    /* renamed from: N */
    public void q(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.q(data);
        TextView date = getDate();
        if (date != null) {
            date.setTextSize(17.0f);
            date.setTypeface(Typeface.create(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_REGULAR, 0));
            date.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ma3.b, com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder, ja3.b
    /* renamed from: Q */
    public void s(@NotNull WinkNewMemoryAlbumResult data, int spanCount) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.s(data, spanCount);
        int screenWidth = ImmersiveUtils.getScreenWidth() - x.a(17.0f);
        D(getImageView(), screenWidth, (int) (screenWidth * 0.5f));
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder, ja3.b
    /* renamed from: R */
    public void u(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.u(data);
        TextView name = getName();
        if (name != null) {
            name.setTextSize(40.0f);
        }
        TextView name2 = getName();
        if (name2 != null) {
            name2.requestLayout();
        }
    }
}
