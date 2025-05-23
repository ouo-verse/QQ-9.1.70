package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J$\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/c;", "", "", "url", "", "size", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "t", "Landroid/content/Context;", "context", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextURLContent;", "b", "I", "ICON_SIZE_PX", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a */
    @NotNull
    public static final c f221632a = new c();

    /* renamed from: b, reason: from kotlin metadata */
    private static final int ICON_SIZE_PX = com.tencent.guild.aio.util.c.b(20);

    c() {
    }

    public static /* synthetic */ Drawable c(c cVar, GProStRichTextContent gProStRichTextContent, Context context, Drawable drawable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_default);
        }
        return cVar.a(gProStRichTextContent, context, drawable);
    }

    public static /* synthetic */ Drawable d(c cVar, GProStRichTextURLContent gProStRichTextURLContent, Context context, Drawable drawable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_default);
        }
        return cVar.b(gProStRichTextURLContent, context, drawable);
    }

    private final Drawable e(String url, int size, Drawable defaultDrawable) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            return defaultDrawable;
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = defaultDrawable;
            obtain.mFailedDrawable = defaultDrawable;
            obtain.mRequestWidth = size;
            obtain.mRequestHeight = size;
            return URLDrawable.getDrawable(new URL(url), obtain);
        } catch (Exception e16) {
            QLog.e("GuildFeedTencentDocUI", 1, "loadDrawable error: " + e16);
            return defaultDrawable;
        }
    }

    @Nullable
    public final Drawable a(@NotNull GProStRichTextContent t16, @NotNull Context context, @Nullable Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(t16, "t");
        Intrinsics.checkNotNullParameter(context, "context");
        GProStRichTextURLContent gProStRichTextURLContent = t16.urlContent;
        Intrinsics.checkNotNullExpressionValue(gProStRichTextURLContent, "t.urlContent");
        return b(gProStRichTextURLContent, context, defaultDrawable);
    }

    @Nullable
    public final Drawable b(@NotNull GProStRichTextURLContent t16, @NotNull Context context, @Nullable Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(t16, "t");
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = t16.type;
        if (i3 != 3) {
            if (i3 == 10) {
                return sk1.a.f433915a.a(t16.iconType, context, defaultDrawable);
            }
            return defaultDrawable;
        }
        String docIcon = t16.tencentDocsContent.icon;
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.guild_feed_url_icon_tencentdocs_doc);
        Intrinsics.checkNotNullExpressionValue(docIcon, "docIcon");
        return e(docIcon, ICON_SIZE_PX, drawable);
    }
}
