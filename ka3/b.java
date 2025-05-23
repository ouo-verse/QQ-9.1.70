package ka3;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemType;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0004J\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0004J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0005\u00a8\u0006\u0016"}, d2 = {"Lka3/b;", "Lka3/a;", "", "data", "M", "(Lkotlin/Unit;)V", "K", "", "spanCount", "L", "(Lkotlin/Unit;I)V", "N", "Landroid/widget/ImageView;", "imageView", "", "path", "J", "I", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // ja3.b
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull Unit data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(@Nullable ImageView imageView, @NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (imageView == null) {
            return;
        }
        int screenWidth = ImmersiveUtils.getScreenWidth() - x.a(16.0f);
        ja3.b.p(this, path, imageView, screenWidth, (int) (screenWidth * 0.5f), new ColorDrawable(0), false, false, 96, null);
    }

    @Override // ja3.b
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void q(@NotNull Unit data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView date = getDate();
        if (date != null) {
            date.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ja3.b
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void s(@NotNull Unit data, int spanCount) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.s(data, spanCount);
        J(getImageView(), "https://downv6.qq.com/shadow_qqcamera/memoryalbum/no_content_cover.png");
        N();
    }

    @Override // ja3.b
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull Unit data) {
        TextView name;
        Intrinsics.checkNotNullParameter(data, "data");
        if (getItemViewType() == WinkAlbumItemType.UI_TYPE_TOPIC_LOADING.getViewType() && (name = getName()) != null) {
            name.setText(R.string.f240167of);
        }
        TextView name2 = getName();
        if (name2 != null) {
            name2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N() {
        int screenWidth = ImmersiveUtils.getScreenWidth() - x.a(17.0f);
        D(getImageView(), screenWidth, (int) (screenWidth * 0.5f));
    }
}
