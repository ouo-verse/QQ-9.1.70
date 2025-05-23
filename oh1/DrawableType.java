package oh1;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Loh1/b;", "", "Landroid/view/View;", "view", "", "a", "Landroid/widget/ImageView;", "imageView", "b", "", "toString", "", "hashCode", "other", "", "equals", "I", "getDrawableRes", "()I", "drawableRes", "Ljava/lang/Integer;", "getFilterColor", "()Ljava/lang/Integer;", "filterColor", "<init>", "(ILjava/lang/Integer;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: oh1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class DrawableType {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int drawableRes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer filterColor;

    public DrawableType(@DrawableRes int i3, @ColorRes @Nullable Integer num) {
        this.drawableRes = i3;
        this.filterColor = num;
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        view.setBackground(GuildUIUtils.w(context, this.drawableRes, this.filterColor));
    }

    public final void b(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        imageView.setImageDrawable(GuildUIUtils.w(context, this.drawableRes, this.filterColor));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawableType)) {
            return false;
        }
        DrawableType drawableType = (DrawableType) other;
        if (this.drawableRes == drawableType.drawableRes && Intrinsics.areEqual(this.filterColor, drawableType.filterColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.drawableRes * 31;
        Integer num = this.filterColor;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "DrawableType(drawableRes=" + this.drawableRes + ", filterColor=" + this.filterColor + ")";
    }
}
