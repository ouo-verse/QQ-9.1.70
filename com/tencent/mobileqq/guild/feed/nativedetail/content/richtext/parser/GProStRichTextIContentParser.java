package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextAtContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextChannelContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextEmojiContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextGroupContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTopicContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J2\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\f\u0010\f\u001a\u00020\u0003*\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002JP\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00150\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/GProStRichTextIContentParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "Landroid/text/SpannableStringBuilder;", "builder", "", "contents", "", "index", "Lkotlin/Pair;", "", "b", "e", "c", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "parseConfig", "", "channelId", "guildId", "Lcom/tencent/aio/widget/textView/view/b;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GProStRichTextIContentParser implements b<GProStRichTextContent> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GProStRichTextIContentParser f221623a = new GProStRichTextIContentParser();

    GProStRichTextIContentParser() {
    }

    private final Pair<Boolean, Boolean> b(SpannableStringBuilder builder, List<GProStRichTextContent> contents, int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(contents, index + 1);
        final GProStRichTextContent gProStRichTextContent = (GProStRichTextContent) orNull;
        return d.e(builder, new Function0<String>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.GProStRichTextIContentParser$getCheckAdjacentContentWhitespace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                GProStRichTextTextContent gProStRichTextTextContent;
                GProStRichTextContent gProStRichTextContent2 = GProStRichTextContent.this;
                if (gProStRichTextContent2 == null || (gProStRichTextTextContent = gProStRichTextContent2.textContent) == null) {
                    return null;
                }
                return gProStRichTextTextContent.text;
            }
        }, new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.GProStRichTextIContentParser$getCheckAdjacentContentWhitespace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                GProStRichTextContent gProStRichTextContent2 = GProStRichTextContent.this;
                if (gProStRichTextContent2 != null) {
                    return Integer.valueOf(gProStRichTextContent2.type);
                }
                return null;
            }
        });
    }

    private final boolean c(List<GProStRichTextContent> list) {
        GProStRichTextEmojiContent emojiContent;
        int i3 = 0;
        for (GProStRichTextContent gProStRichTextContent : list) {
            if (gProStRichTextContent.type == 4 && (emojiContent = gProStRichTextContent.emojiContent) != null) {
                Intrinsics.checkNotNullExpressionValue(emojiContent, "emojiContent");
                i3++;
                if (i3 >= 40) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, com.tencent.aio.widget.textView.view.b] */
    private static final void d(StringBuilder sb5, Ref.BooleanRef booleanRef, TrimSpaceType trimSpaceType, SpannableStringBuilder spannableStringBuilder, IParseRichTextConfig<GProStRichTextContent> iParseRichTextConfig, Ref.ObjectRef<com.tencent.aio.widget.textView.view.b> objectRef) {
        boolean z16;
        CharSequence trimStart;
        boolean z17 = true;
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "currentTextBuilder.toString()");
            if (booleanRef.element && trimSpaceType.shouldTrim()) {
                trimStart = StringsKt__StringsKt.trimStart((CharSequence) sb6);
                sb6 = trimStart.toString();
            }
            if (trimSpaceType == TrimSpaceType.LeadingSpaceAndEmptyLine) {
                sb6 = d.m(sb6);
            }
            if (sb6.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
                ?? l3 = feedRichTextContentParser.l(sb6, spannableStringBuilder, iParseRichTextConfig);
                if (l3 != 0) {
                    objectRef.element = l3;
                }
                ?? j3 = feedRichTextContentParser.j(spannableStringBuilder, iParseRichTextConfig);
                if (j3 != 0) {
                    objectRef.element = j3;
                }
            }
            StringsKt__StringBuilderJVMKt.clear(sb5);
        }
        booleanRef.element = false;
    }

    private final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder) {
        boolean z16;
        boolean isWhitespace;
        while (true) {
            if (spannableStringBuilder.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                break;
            }
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(spannableStringBuilder.charAt(spannableStringBuilder.length() - 1));
            if (!isWhitespace || (spannableStringBuilder.length() - 2 >= 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 2) == 20)) {
                break;
            }
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r2v24, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r2v26, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r2v29, types: [T, com.tencent.aio.widget.textView.view.b] */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.b
    @NotNull
    public Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> a(@NotNull List<? extends GProStRichTextContent> contents, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull IParseRichTextConfig<GProStRichTextContent> parseConfig, @Nullable String channelId, @Nullable String guildId) {
        int i3;
        Ref.BooleanRef booleanRef;
        StringBuilder sb5;
        int i16;
        Ref.BooleanRef booleanRef2;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelInfo gProStChannelInfo2;
        GProStChannelSign gProStChannelSign;
        GProStChannelInfo gProStChannelInfo3;
        GProStChannelSign gProStChannelSign2;
        GProStChannelInfo gProStChannelInfo4;
        GProStChannelInfo gProStChannelInfo5;
        GProStChannelSign gProStChannelSign3;
        GProStRichTextContent gProStRichTextContent;
        Long l3;
        GProStChannelInfo gProStChannelInfo6;
        GProStChannelInfo gProStChannelInfo7;
        GProStChannelSign gProStChannelSign4;
        GProStChannelInfo gProStChannelInfo8;
        GProStChannelSign gProStChannelSign5;
        GProStChannelInfo gProStChannelInfo9;
        GProStChannelInfo gProStChannelInfo10;
        GProStChannelSign gProStChannelSign6;
        List<? extends GProStRichTextContent> contents2 = contents;
        Intrinsics.checkNotNullParameter(contents2, "contents");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TrimSpaceType f16 = parseConfig.f();
        StringBuilder sb6 = new StringBuilder();
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        int i17 = 1;
        booleanRef3.element = true;
        boolean c16 = c(contents);
        for (GProStRichTextContent gProStRichTextContent2 : contents) {
            int i18 = gProStRichTextContent2.type;
            if (i18 != 0 && i18 != i17) {
                d(sb6, booleanRef3, f16, spannableStringBuilder, parseConfig, objectRef);
                switch (gProStRichTextContent2.type) {
                    case 2:
                        i3 = i17;
                        booleanRef = booleanRef3;
                        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
                        GProStRichTextAtContent gProStRichTextAtContent = gProStRichTextContent2.atContent;
                        int i19 = gProStRichTextAtContent.type;
                        String str = gProStRichTextAtContent.user.nick;
                        Intrinsics.checkNotNullExpressionValue(str, "content.atContent.user.nick");
                        String str2 = gProStRichTextContent2.atContent.user.idd;
                        Intrinsics.checkNotNullExpressionValue(str2, "content.atContent.user.idd");
                        String str3 = gProStRichTextContent2.atContent.roleGroupId.name;
                        Intrinsics.checkNotNullExpressionValue(str3, "content.atContent.roleGroupId.name");
                        String str4 = gProStRichTextContent2.atContent.guildInfo.name;
                        Intrinsics.checkNotNullExpressionValue(str4, "content.atContent.guildInfo.name");
                        Pair<Boolean, Boolean> b16 = b(spannableStringBuilder, contents2, eh1.b.INSTANCE.a());
                        sb5 = sb6;
                        ?? h16 = feedRichTextContentParser.h(channelId, guildId, i19, str, str2, str3, str4, spannableStringBuilder, parseConfig, b16);
                        if (h16 != 0) {
                            objectRef.element = h16;
                            break;
                        }
                        break;
                    case 3:
                        i16 = i17;
                        booleanRef2 = booleanRef3;
                        if (parseConfig.a(gProStRichTextContent2)) {
                            FeedRichTextContentParser feedRichTextContentParser2 = FeedRichTextContentParser.f221393a;
                            boolean e16 = parseConfig.e();
                            boolean d16 = parseConfig.d();
                            Drawable m3 = parseConfig.m(gProStRichTextContent2);
                            String str5 = gProStRichTextContent2.urlContent.url;
                            Intrinsics.checkNotNullExpressionValue(str5, "content.urlContent.url");
                            feedRichTextContentParser2.x(e16, d16, m3, str5, spannableStringBuilder);
                            String str6 = gProStRichTextContent2.urlContent.url;
                            Intrinsics.checkNotNullExpressionValue(str6, "content.urlContent.url");
                            String str7 = gProStRichTextContent2.urlContent.displayText;
                            Intrinsics.checkNotNullExpressionValue(str7, "content.urlContent.displayText");
                            ?? w3 = feedRichTextContentParser2.w(str6, str7, spannableStringBuilder, parseConfig, b(spannableStringBuilder, contents2, eh1.b.INSTANCE.a()));
                            if (w3 != 0) {
                                objectRef.element = w3;
                            }
                        }
                        i17 = i16;
                        booleanRef3 = booleanRef2;
                        break;
                    case 4:
                        i16 = i17;
                        booleanRef2 = booleanRef3;
                        GProStRichTextEmojiContent gProStRichTextEmojiContent = gProStRichTextContent2.emojiContent;
                        if (gProStRichTextEmojiContent != null) {
                            FeedRichTextContentParser feedRichTextContentParser3 = FeedRichTextContentParser.f221393a;
                            String str8 = gProStRichTextEmojiContent.idd;
                            Intrinsics.checkNotNullExpressionValue(str8, "it.idd");
                            String str9 = gProStRichTextEmojiContent.type;
                            Intrinsics.checkNotNullExpressionValue(str9, "it.type");
                            spannableStringBuilder.append((CharSequence) FeedRichTextContentParser.o(feedRichTextContentParser3, str8, str9, parseConfig.getF221022d(), (!parseConfig.h() || c16) ? 0 : i16, null, 16, null));
                        }
                        i17 = i16;
                        booleanRef3 = booleanRef2;
                        break;
                    case 5:
                        i16 = i17;
                        booleanRef2 = booleanRef3;
                        FeedRichTextContentParser feedRichTextContentParser4 = FeedRichTextContentParser.f221393a;
                        GProStRichTextChannelContent gProStRichTextChannelContent = gProStRichTextContent2.channelContent;
                        Integer valueOf = (gProStRichTextChannelContent == null || (gProStChannelInfo5 = gProStRichTextChannelContent.channelInfo) == null || (gProStChannelSign3 = gProStChannelInfo5.sign) == null) ? null : Integer.valueOf(gProStChannelSign3.channelType);
                        GProStRichTextChannelContent gProStRichTextChannelContent2 = gProStRichTextContent2.channelContent;
                        String str10 = (gProStRichTextChannelContent2 == null || (gProStChannelInfo4 = gProStRichTextChannelContent2.channelInfo) == null) ? null : gProStChannelInfo4.name;
                        String valueOf2 = String.valueOf((gProStRichTextChannelContent2 == null || (gProStChannelInfo3 = gProStRichTextChannelContent2.channelInfo) == null || (gProStChannelSign2 = gProStChannelInfo3.sign) == null) ? null : Long.valueOf(gProStChannelSign2.channelId));
                        GProStRichTextChannelContent gProStRichTextChannelContent3 = gProStRichTextContent2.channelContent;
                        String valueOf3 = String.valueOf((gProStRichTextChannelContent3 == null || (gProStChannelInfo2 = gProStRichTextChannelContent3.channelInfo) == null || (gProStChannelSign = gProStChannelInfo2.sign) == null) ? null : Long.valueOf(gProStChannelSign.guildId));
                        GProStRichTextChannelContent gProStRichTextChannelContent4 = gProStRichTextContent2.channelContent;
                        ?? i26 = feedRichTextContentParser4.i(valueOf, str10, valueOf2, valueOf3, (gProStRichTextChannelContent4 == null || (gProStChannelInfo = gProStRichTextChannelContent4.channelInfo) == null) ? null : Boolean.valueOf(gProStChannelInfo.isSquare), joinInfoParam, spannableStringBuilder, parseConfig, b(spannableStringBuilder, contents2, eh1.b.INSTANCE.a()));
                        if (i26 != 0) {
                            objectRef.element = i26;
                        }
                        i17 = i16;
                        booleanRef3 = booleanRef2;
                        break;
                    case 6:
                        i16 = i17;
                        FeedRichTextContentParser feedRichTextContentParser5 = FeedRichTextContentParser.f221393a;
                        GProStRichTextChannelContent gProStRichTextChannelContent5 = gProStRichTextContent2.channelContent;
                        Integer valueOf4 = (gProStRichTextChannelContent5 == null || (gProStChannelInfo10 = gProStRichTextChannelContent5.channelInfo) == null || (gProStChannelSign6 = gProStChannelInfo10.sign) == null) ? null : Integer.valueOf(gProStChannelSign6.channelType);
                        GProStRichTextChannelContent gProStRichTextChannelContent6 = gProStRichTextContent2.channelContent;
                        String str11 = (gProStRichTextChannelContent6 == null || (gProStChannelInfo9 = gProStRichTextChannelContent6.channelInfo) == null) ? null : gProStChannelInfo9.name;
                        String valueOf5 = String.valueOf((gProStRichTextChannelContent6 == null || (gProStChannelInfo8 = gProStRichTextChannelContent6.channelInfo) == null || (gProStChannelSign5 = gProStChannelInfo8.sign) == null) ? null : Long.valueOf(gProStChannelSign5.channelId));
                        GProStRichTextChannelContent gProStRichTextChannelContent7 = gProStRichTextContent2.channelContent;
                        if (gProStRichTextChannelContent7 == null || (gProStChannelInfo7 = gProStRichTextChannelContent7.channelInfo) == null || (gProStChannelSign4 = gProStChannelInfo7.sign) == null) {
                            gProStRichTextContent = gProStRichTextContent2;
                            l3 = null;
                        } else {
                            gProStRichTextContent = gProStRichTextContent2;
                            l3 = Long.valueOf(gProStChannelSign4.guildId);
                        }
                        String valueOf6 = String.valueOf(l3);
                        GProStRichTextChannelContent gProStRichTextChannelContent8 = gProStRichTextContent.channelContent;
                        booleanRef2 = booleanRef3;
                        ?? i27 = feedRichTextContentParser5.i(valueOf4, str11, valueOf5, valueOf6, (gProStRichTextChannelContent8 == null || (gProStChannelInfo6 = gProStRichTextChannelContent8.channelInfo) == null) ? null : Boolean.valueOf(gProStChannelInfo6.isSquare), joinInfoParam, spannableStringBuilder, parseConfig, b(spannableStringBuilder, contents2, eh1.b.INSTANCE.a()));
                        if (i27 != 0) {
                            objectRef.element = i27;
                        }
                        i17 = i16;
                        booleanRef3 = booleanRef2;
                        break;
                    case 7:
                        FeedRichTextContentParser.f221393a.k(gProStRichTextContent2.iconContent.url, spannableStringBuilder);
                        break;
                    case 8:
                        i3 = i17;
                        FeedRichTextContentParser feedRichTextContentParser6 = FeedRichTextContentParser.f221393a;
                        Long valueOf7 = Long.valueOf(gProStRichTextContent2.topicContent.topicId);
                        GProStRichTextTopicContent gProStRichTextTopicContent = gProStRichTextContent2.topicContent;
                        ?? u16 = feedRichTextContentParser6.u(valueOf7, gProStRichTextTopicContent.topicName, guildId, Integer.valueOf(gProStRichTextTopicContent.showStatus), spannableStringBuilder, parseConfig, b(spannableStringBuilder, contents2, eh1.b.INSTANCE.a()));
                        if (u16 != 0) {
                            objectRef.element = u16;
                        }
                        i17 = i3;
                        break;
                    case 9:
                        FeedRichTextContentParser feedRichTextContentParser7 = FeedRichTextContentParser.f221393a;
                        GProStRichTextGroupContent gProStRichTextGroupContent = gProStRichTextContent2.groupContent;
                        i3 = i17;
                        ?? v3 = feedRichTextContentParser7.v(gProStRichTextGroupContent.groupCode, gProStRichTextGroupContent.groupName, gProStRichTextGroupContent.groupAvatar, gProStRichTextGroupContent.groupJoinAuth, spannableStringBuilder, parseConfig, b(spannableStringBuilder, contents2, eh1.b.INSTANCE.a()));
                        if (v3 != 0) {
                            objectRef.element = v3;
                            i17 = i3;
                            break;
                        } else {
                            booleanRef = booleanRef3;
                            sb5 = sb6;
                            break;
                        }
                    default:
                        i3 = i17;
                        booleanRef = booleanRef3;
                        sb5 = sb6;
                        break;
                }
            } else {
                i3 = i17;
                booleanRef = booleanRef3;
                sb5 = sb6;
                sb5.append(gProStRichTextContent2.textContent.text);
            }
            sb6 = sb5;
            i17 = i3;
            booleanRef3 = booleanRef;
            contents2 = contents;
        }
        d(sb6, booleanRef3, f16, spannableStringBuilder, parseConfig, objectRef);
        if (parseConfig.b()) {
            FeedRichTextContentParser.f221393a.t(spannableStringBuilder);
            objectRef.element = null;
        }
        if (f16.shouldTrim()) {
            spannableStringBuilder = e(spannableStringBuilder);
        }
        return new Pair<>(spannableStringBuilder, objectRef.element);
    }
}
