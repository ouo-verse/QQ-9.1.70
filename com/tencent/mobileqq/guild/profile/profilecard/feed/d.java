package com.tencent.mobileqq.guild.profile.profilecard.feed;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J(\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/d;", "", "Landroid/text/SpannableStringBuilder;", "spannableStringBuilder", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "richTextContent", "", "emojiAlign", "", "emojiSizeDp", "", "a", "", "emojiId", "type", "d", "", "stRichTextContents", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f231412a = new d();

    d() {
    }

    private final void a(SpannableStringBuilder spannableStringBuilder, GProStRichTextContent richTextContent, int emojiAlign, float emojiSizeDp) {
        Drawable drawable;
        if (!TextUtils.isEmpty(richTextContent.emojiContent.idd) && !TextUtils.isEmpty(richTextContent.emojiContent.type)) {
            int c16 = az.c(richTextContent.emojiContent.type, 0);
            int serverToLocal = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(richTextContent.emojiContent.idd, c16);
            drawable = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getDynamicDrawable(serverToLocal, c16);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.profile.GuildProfileFeedParser", "[parseEmojiRichText] getDynamicDrawable[" + serverToLocal + ", " + c16 + "]");
            }
        } else {
            drawable = null;
        }
        String str = richTextContent.emojiContent.url;
        if (drawable == null && !TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mRetryCount = 3;
            drawable = URLDrawable.getDrawable(str, obtain);
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.profile.GuildProfileFeedParser", "[parseEmojiRichText] URLDrawable[" + str + "]");
            }
        }
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, ViewUtils.dpToPx(emojiSizeDp), ViewUtils.dpToPx(emojiSizeDp));
        nb0.c cVar = new nb0.c(drawable, emojiAlign);
        String str2 = richTextContent.emojiContent.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "richTextContent.emojiContent.idd");
        String str3 = richTextContent.emojiContent.type;
        Intrinsics.checkNotNullExpressionValue(str3, "richTextContent.emojiContent.type");
        SpannableString spannableString = new SpannableString(d(str2, str3));
        spannableString.setSpan(cVar, 0, spannableString.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString);
    }

    public static /* synthetic */ SpannableStringBuilder c(d dVar, List list, int i3, float f16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            f16 = 14.0f;
        }
        return dVar.b(list, i3, f16);
    }

    private final String d(String emojiId, String type) {
        if (!TextUtils.isEmpty(emojiId) && !TextUtils.isEmpty(type)) {
            Integer valueOf = Integer.valueOf(type);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(type)");
            return QzoneEmotionUtils.EMO_PREFIX + ((char) (valueOf.intValue() + 97)) + emojiId + QzoneEmotionUtils.EMO_TAIL;
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @NotNull
    public final SpannableStringBuilder b(@NotNull List<GProStRichTextContent> stRichTextContents, int emojiAlign, float emojiSizeDp) {
        String replace$default;
        Intrinsics.checkNotNullParameter(stRichTextContents, "stRichTextContents");
        Logger.f235387a.d().d("Guild.profile.GuildProfileFeedParser", 1, "[parseFeedRichText] emojiAlign[" + emojiAlign + "], emojiSizeDp[" + emojiSizeDp + "]");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (GProStRichTextContent gProStRichTextContent : stRichTextContents) {
            if (gProStRichTextContent.type == 4) {
                f231412a.a(spannableStringBuilder, gProStRichTextContent, emojiAlign, emojiSizeDp);
            } else {
                String text = gProStRichTextContent.textContent.text;
                Intrinsics.checkNotNullExpressionValue(text, "text");
                replace$default = StringsKt__StringsJVMKt.replace$default(text, "\n", " ", false, 4, (Object) null);
                spannableStringBuilder.append((CharSequence) replace$default);
            }
        }
        return spannableStringBuilder;
    }
}
