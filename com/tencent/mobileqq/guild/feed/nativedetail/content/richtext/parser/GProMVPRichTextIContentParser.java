package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPChannelContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPEmojiContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTextContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002JP\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00130\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/GProMVPRichTextIContentParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/b;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;", "Landroid/text/SpannableStringBuilder;", "builder", "", "contents", "", "index", "Lkotlin/Pair;", "", "b", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "parseConfig", "", "channelId", "guildId", "Lcom/tencent/aio/widget/textView/view/b;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GProMVPRichTextIContentParser implements b<IGProMVPRichTextContent> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GProMVPRichTextIContentParser f221622a = new GProMVPRichTextIContentParser();

    GProMVPRichTextIContentParser() {
    }

    private final Pair<Boolean, Boolean> b(SpannableStringBuilder builder, List<? extends IGProMVPRichTextContent> contents, int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(contents, index + 1);
        final IGProMVPRichTextContent iGProMVPRichTextContent = (IGProMVPRichTextContent) orNull;
        return d.e(builder, new Function0<String>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.GProMVPRichTextIContentParser$getCheckAdjacentContentWhitespace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                IGProMVPTextContent textContent;
                IGProMVPRichTextContent iGProMVPRichTextContent2 = IGProMVPRichTextContent.this;
                if (iGProMVPRichTextContent2 == null || (textContent = iGProMVPRichTextContent2.getTextContent()) == null) {
                    return null;
                }
                return textContent.getText();
            }
        }, new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.GProMVPRichTextIContentParser$getCheckAdjacentContentWhitespace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                IGProMVPRichTextContent iGProMVPRichTextContent2 = IGProMVPRichTextContent.this;
                if (iGProMVPRichTextContent2 != null) {
                    return Integer.valueOf(iGProMVPRichTextContent2.getType());
                }
                return null;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0114, code lost:
    
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x019b, code lost:
    
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x022c, code lost:
    
        if (r1 == null) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0206  */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.b
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> a(@NotNull List<? extends IGProMVPRichTextContent> contents, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull IParseRichTextConfig<IGProMVPRichTextContent> parseConfig, @Nullable String channelId, @Nullable String guildId) {
        int i3;
        com.tencent.aio.widget.textView.view.b j3;
        int type;
        com.tencent.aio.widget.textView.view.b bVar;
        Intrinsics.checkNotNullParameter(contents, "contents");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        com.tencent.aio.widget.textView.view.b bVar2 = null;
        for (Object obj : contents) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProMVPRichTextContent iGProMVPRichTextContent = (IGProMVPRichTextContent) obj;
            int type2 = iGProMVPRichTextContent.getType();
            if (type2 != 0) {
                if (type2 != 1) {
                    int i17 = 4;
                    if (type2 == 2) {
                        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
                        int type3 = iGProMVPRichTextContent.getAtContent().getType();
                        if (type3 != 1) {
                            if (type3 == 2) {
                                i17 = 3;
                            } else if (type3 != 3) {
                                type = type3 != 4 ? iGProMVPRichTextContent.getAtContent().getType() : 1;
                            } else {
                                i17 = 2;
                            }
                            String nick = iGProMVPRichTextContent.getAtContent().getUser().getNick();
                            Intrinsics.checkNotNullExpressionValue(nick, "content.atContent.user.nick");
                            String valueOf = String.valueOf(iGProMVPRichTextContent.getAtContent().getUser().getTinyid());
                            String name = iGProMVPRichTextContent.getAtContent().getRoleGroup().getName();
                            Intrinsics.checkNotNullExpressionValue(name, "content.atContent.roleGroup.name");
                            String atAllText = iGProMVPRichTextContent.getAtContent().getType() != 2 ? iGProMVPRichTextContent.getAtContent().getAtAllText() : iGProMVPRichTextContent.getAtContent().getText();
                            Intrinsics.checkNotNullExpressionValue(atAllText, "when {\n                 \u2026                        }");
                            bVar = bVar2;
                            j3 = feedRichTextContentParser.h(channelId, guildId, i17, nick, valueOf, name, atAllText, spannableStringBuilder, parseConfig, f221622a.b(spannableStringBuilder, contents, i3));
                        }
                        i17 = type;
                        String nick2 = iGProMVPRichTextContent.getAtContent().getUser().getNick();
                        Intrinsics.checkNotNullExpressionValue(nick2, "content.atContent.user.nick");
                        String valueOf2 = String.valueOf(iGProMVPRichTextContent.getAtContent().getUser().getTinyid());
                        String name2 = iGProMVPRichTextContent.getAtContent().getRoleGroup().getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "content.atContent.roleGroup.name");
                        String atAllText2 = iGProMVPRichTextContent.getAtContent().getType() != 2 ? iGProMVPRichTextContent.getAtContent().getAtAllText() : iGProMVPRichTextContent.getAtContent().getText();
                        Intrinsics.checkNotNullExpressionValue(atAllText2, "when {\n                 \u2026                        }");
                        bVar = bVar2;
                        j3 = feedRichTextContentParser.h(channelId, guildId, i17, nick2, valueOf2, name2, atAllText2, spannableStringBuilder, parseConfig, f221622a.b(spannableStringBuilder, contents, i3));
                    } else if (type2 != 3) {
                        if (type2 == 4) {
                            IGProMVPEmojiContent emojiContent = iGProMVPRichTextContent.getEmojiContent();
                            if (emojiContent != null) {
                                Intrinsics.checkNotNullExpressionValue(emojiContent, "emojiContent");
                                FeedRichTextContentParser feedRichTextContentParser2 = FeedRichTextContentParser.f221393a;
                                String id5 = emojiContent.getId();
                                Intrinsics.checkNotNullExpressionValue(id5, "it.id");
                                String type4 = emojiContent.getType();
                                Intrinsics.checkNotNullExpressionValue(type4, "it.type");
                                spannableStringBuilder.append((CharSequence) FeedRichTextContentParser.o(feedRichTextContentParser2, id5, type4, parseConfig.getF221022d(), false, null, 24, null));
                            }
                        } else if (type2 == 5) {
                            FeedRichTextContentParser feedRichTextContentParser3 = FeedRichTextContentParser.f221393a;
                            IGProMVPChannelContent channelContent = iGProMVPRichTextContent.getChannelContent();
                            String channelName = channelContent != null ? channelContent.getChannelName() : null;
                            IGProMVPChannelContent channelContent2 = iGProMVPRichTextContent.getChannelContent();
                            String valueOf3 = String.valueOf(channelContent2 != null ? Long.valueOf(channelContent2.getChannelId()) : null);
                            IGProMVPChannelContent channelContent3 = iGProMVPRichTextContent.getChannelContent();
                            j3 = feedRichTextContentParser3.i(null, channelName, valueOf3, String.valueOf(channelContent3 != null ? Long.valueOf(channelContent3.getGuildId()) : null), Boolean.FALSE, joinInfoParam, spannableStringBuilder, parseConfig, f221622a.b(spannableStringBuilder, contents, i3));
                        } else if (type2 == 8) {
                        }
                        bVar = bVar2;
                        bVar2 = bVar;
                    } else if (parseConfig.a(iGProMVPRichTextContent)) {
                        FeedRichTextContentParser feedRichTextContentParser4 = FeedRichTextContentParser.f221393a;
                        boolean e16 = parseConfig.e();
                        boolean d16 = parseConfig.d();
                        Drawable m3 = parseConfig.m(iGProMVPRichTextContent);
                        String url = iGProMVPRichTextContent.getUrlContent().getUrl();
                        Intrinsics.checkNotNullExpressionValue(url, "content.urlContent.url");
                        feedRichTextContentParser4.x(e16, d16, m3, url, spannableStringBuilder);
                        String url2 = iGProMVPRichTextContent.getUrlContent().getUrl();
                        Intrinsics.checkNotNullExpressionValue(url2, "content.urlContent.url");
                        String displayText = iGProMVPRichTextContent.getUrlContent().getDisplayText();
                        Intrinsics.checkNotNullExpressionValue(displayText, "content.urlContent.displayText");
                        j3 = feedRichTextContentParser4.w(url2, displayText, spannableStringBuilder, parseConfig, f221622a.b(spannableStringBuilder, contents, i3));
                    }
                }
            }
            com.tencent.aio.widget.textView.view.b bVar3 = bVar2;
            FeedRichTextContentParser feedRichTextContentParser5 = FeedRichTextContentParser.f221393a;
            String text = iGProMVPRichTextContent.getTextContent().getText();
            Intrinsics.checkNotNullExpressionValue(text, "content.textContent.text");
            bVar2 = feedRichTextContentParser5.l(text, spannableStringBuilder, parseConfig);
            if (bVar2 == null) {
                bVar2 = bVar3;
            }
            j3 = feedRichTextContentParser5.j(spannableStringBuilder, parseConfig);
            i3 = j3 == null ? i16 : 0;
            bVar2 = j3;
        }
        return new Pair<>(spannableStringBuilder, bVar2);
    }
}
