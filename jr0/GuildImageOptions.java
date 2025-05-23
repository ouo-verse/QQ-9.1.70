package jr0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.libra.request.Option;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u76f4\u63a5\u4f7f\u7528GuildPicLoader\u5427\uff0c\u5df2\u7ecf\u505a\u8fc7\u6865\u63a5\u4e86\uff0c\u6ca1\u5fc5\u8981\u8fc7\u5ea6\u5305\u88c5")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u000b\u0010\u001bR\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010&\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\u00a8\u0006)"}, d2 = {"Ljr0/a;", "", "Lcom/tencent/libra/request/Option;", "e", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "targetView", "Z", "getPreDecode", "()Z", "preDecode", "d", "I", "()I", "width", "height", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "g", "getFailedDrawable", "failedDrawable", "<init>", "(Ljava/lang/String;Landroid/widget/ImageView;ZIILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jr0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildImageOptions {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ImageView targetView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean preDecode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable loadingDrawable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable failedDrawable;

    public GuildImageOptions(@NotNull String url, @NotNull ImageView targetView, boolean z16, int i3, int i16, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.url = url;
        this.targetView = targetView;
        this.preDecode = z16;
        this.width = i3;
        this.height = i16;
        this.loadingDrawable = drawable;
        this.failedDrawable = drawable2;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ImageView getTargetView() {
        return this.targetView;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: d, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public final Option e() {
        Option failDrawable = new Option().setUrl(this.url).setTargetView(this.targetView).setPredecode(true).setRequestHeight(this.height).setRequestWidth(this.width).setLoadingDrawable(this.loadingDrawable).setFailDrawable(this.failedDrawable);
        Intrinsics.checkNotNullExpressionValue(failDrawable, "Option()\n            .se\u2026lDrawable(failedDrawable)");
        return failDrawable;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildImageOptions)) {
            return false;
        }
        GuildImageOptions guildImageOptions = (GuildImageOptions) other;
        if (Intrinsics.areEqual(this.url, guildImageOptions.url) && Intrinsics.areEqual(this.targetView, guildImageOptions.targetView) && this.preDecode == guildImageOptions.preDecode && this.width == guildImageOptions.width && this.height == guildImageOptions.height && Intrinsics.areEqual(this.loadingDrawable, guildImageOptions.loadingDrawable) && Intrinsics.areEqual(this.failedDrawable, guildImageOptions.failedDrawable)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.url.hashCode() * 31) + this.targetView.hashCode()) * 31;
        boolean z16 = this.preDecode;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (((((hashCode2 + i3) * 31) + this.width) * 31) + this.height) * 31;
        Drawable drawable = this.loadingDrawable;
        int i17 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        Drawable drawable2 = this.failedDrawable;
        if (drawable2 != null) {
            i17 = drawable2.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public String toString() {
        return "GuildImageOptions(url=" + this.url + ", targetView=" + this.targetView + ", preDecode=" + this.preDecode + ", width=" + this.width + ", height=" + this.height + ", loadingDrawable=" + this.loadingDrawable + ", failedDrawable=" + this.failedDrawable + ")";
    }
}
