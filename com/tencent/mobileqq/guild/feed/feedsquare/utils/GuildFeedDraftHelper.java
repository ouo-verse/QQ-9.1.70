package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002Jj\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\rJ \u0010\u001a\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\n\u0010\u001b\u001a\u00020\u0019*\u00020\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedDraftHelper;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextURLContent;", "", "b", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "guildId", "channelId", "draftKey", "", "draftType", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "draft", "mediaSize", "", "callback", "Lkotlinx/coroutines/Job;", "c", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "Landroid/text/SpannableStringBuilder;", "a", "e", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDraftHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedDraftHelper f219277a = new GuildFeedDraftHelper();

    GuildFeedDraftHelper() {
    }

    private final boolean b(GProStRichTextURLContent gProStRichTextURLContent) {
        int i3 = gProStRichTextURLContent.type;
        if (i3 != 6 && i3 != 7) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ Job d(GuildFeedDraftHelper guildFeedDraftHelper, CoroutineScope coroutineScope, String str, String str2, String str3, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str3 = "";
        }
        String str4 = str3;
        if ((i16 & 16) != 0) {
            i3 = 0;
        }
        return guildFeedDraftHelper.c(coroutineScope, str, str2, str4, i3, function2);
    }

    @NotNull
    public final SpannableStringBuilder a(@NotNull List<GProStRichTextContent> list, @NotNull String guildId, @NotNull String channelId) {
        String str;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        SpannableStringBuilder e16 = e((SpannableStringBuilder) FeedRichTextContentParser.s(FeedRichTextContentParser.f221393a, list, null, IParseRichTextConfig.INSTANCE.d(), channelId, guildId, 1, null).getFirst());
        if (TextUtils.isEmpty(e16) && (!list.isEmpty())) {
            GProStRichTextURLContent gProStRichTextURLContent = list.get(0).urlContent;
            Intrinsics.checkNotNullExpressionValue(gProStRichTextURLContent, "this[0].urlContent");
            if (b(gProStRichTextURLContent)) {
                int i3 = list.get(0).urlContent.type;
                if (i3 != 6) {
                    if (i3 != 7) {
                        str = "";
                    } else {
                        str = "[\u89c6\u9891]";
                    }
                } else {
                    str = "[\u94fe\u63a5]";
                }
                String str2 = list.get(0).urlContent.displayText;
                if (!TextUtils.isEmpty(str2)) {
                    e16.append((CharSequence) str).append(" ").append((CharSequence) str2);
                }
            }
        }
        return e16;
    }

    @NotNull
    public final Job c(@NotNull CoroutineScope scope, @NotNull String guildId, @NotNull String channelId, @NotNull String draftKey, int draftType, @NotNull Function2<? super CharSequence, ? super Integer, Unit> callback) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(draftKey, "draftKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, ae.a().c(), null, new GuildFeedDraftHelper$observeFeedDraft$1(guildId, draftType, draftKey, channelId, callback, null), 2, null);
        return launch$default;
    }

    @NotNull
    public final SpannableStringBuilder e(@NotNull SpannableStringBuilder spannableStringBuilder) {
        char charAt;
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        int i3 = 0;
        while (i3 < spannableStringBuilder.length()) {
            char charAt2 = spannableStringBuilder.charAt(i3);
            if (charAt2 != '\r' && charAt2 != '\n') {
                i3++;
            } else {
                int i16 = i3 + 1;
                int i17 = i16;
                while (i17 < spannableStringBuilder.length() && ((charAt = spannableStringBuilder.charAt(i17)) == '\r' || charAt == '\n')) {
                    i17++;
                }
                spannableStringBuilder.replace(i3, i17, " ");
                i3 = i16;
            }
        }
        return spannableStringBuilder;
    }
}
