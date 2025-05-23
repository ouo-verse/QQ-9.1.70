package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", WadlProxyConsts.FLAGS, "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class HtmlKt {
    @NotNull
    public static final Spanned parseAsHtml(@NotNull String parseAsHtml, int i3, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        Intrinsics.checkNotNullParameter(parseAsHtml, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(parseAsHtml, i3, imageGetter, tagHandler);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "HtmlCompat.fromHtml(this\u2026 imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String parseAsHtml, int i3, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        if ((i16 & 2) != 0) {
            imageGetter = null;
        }
        if ((i16 & 4) != 0) {
            tagHandler = null;
        }
        Intrinsics.checkNotNullParameter(parseAsHtml, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(parseAsHtml, i3, imageGetter, tagHandler);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "HtmlCompat.fromHtml(this\u2026 imageGetter, tagHandler)");
        return fromHtml;
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned toHtml, int i3) {
        Intrinsics.checkNotNullParameter(toHtml, "$this$toHtml");
        String html = HtmlCompat.toHtml(toHtml, i3);
        Intrinsics.checkNotNullExpressionValue(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned toHtml, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        Intrinsics.checkNotNullParameter(toHtml, "$this$toHtml");
        String html = HtmlCompat.toHtml(toHtml, i3);
        Intrinsics.checkNotNullExpressionValue(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
