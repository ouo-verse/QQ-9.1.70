package com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedAtParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedEmojiParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedImageParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedLineBreakParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedLinkParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedTextParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedThirdVideoParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedVideoParser;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBaseFeedGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProParagraph;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProParagraphProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextAtContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextEmojiContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b3\u00104J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\f\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002J\f\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002J\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0001J\u0010\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001dJ\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\b2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020 R#\u0010+\u001a\n '*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010(\u001a\u0004\b)\u0010*R;\u00102\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020.0-0,j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020.0-`/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/FeedRichTextConvertTool;", "", "Lorg/json/JSONObject;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProParagraphProps;", h.F, "Lorg/json/JSONArray;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "feedContents", "Ljava/util/LinkedList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "g", "Lcom/google/gson/FieldNamingStrategy;", "namingStrategy", "Lcom/google/gson/JsonElement;", "l", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean$EmojiContent;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextEmojiContent;", "j", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean$Text;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextTextContent;", "k", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean$AtUser;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextAtContent;", "i", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "bean", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichText;", "c", "feed", "", "b", "feedJson", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "a", "patternInfo", "stFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProParagraph;", "d", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "f", "()Lcom/google/gson/Gson;", "stFeedDeserializerGson", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "Ljava/io/Serializable;", "Lkotlin/collections/ArrayList;", "e", "()Ljava/util/ArrayList;", "longFeedParsers", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedRichTextConvertTool {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f220842c = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy stFeedDeserializerGson;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy longFeedParsers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/FeedRichTextConvertTool$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FeedRichTextConvertTool() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool$stFeedDeserializerGson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Iterator<T> it = com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.a.d().iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    gsonBuilder.registerTypeAdapter((Class) pair.component1(), (JsonDeserializer) pair.component2());
                }
                return gsonBuilder.create();
            }
        });
        this.stFeedDeserializerGson = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<ILongFeedParser<? extends Serializable>>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool$longFeedParsers$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<ILongFeedParser<? extends Serializable>> invoke() {
                ArrayList<ILongFeedParser<? extends Serializable>> arrayListOf;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new LongFeedTextParser(), new LongFeedEmojiParser(), new LongFeedImageParser(), new LongFeedLineBreakParser(), new LongFeedLinkParser(), new LongFeedVideoParser(), new LongFeedThirdVideoParser(), new LongFeedAtParser());
                return arrayListOf;
            }
        });
        this.longFeedParsers = lazy2;
    }

    private final ArrayList<ILongFeedParser<? extends Serializable>> e() {
        return (ArrayList) this.longFeedParsers.getValue();
    }

    private final Gson f() {
        return (Gson) this.stFeedDeserializerGson.getValue();
    }

    private final LinkedList<GProElem> g(JSONArray jSONArray, LongFeedInfo longFeedInfo) {
        Object lastOrNull;
        Object obj;
        LinkedList<GProElem> linkedList = new LinkedList<>();
        int length = jSONArray.length();
        boolean z16 = false;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject elemObj = jSONArray.getJSONObject(i3);
            Iterator<T> it = e().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    Intrinsics.checkNotNullExpressionValue(elemObj, "elemObj");
                    if (((ILongFeedParser) obj).match(elemObj)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ILongFeedParser iLongFeedParser = (ILongFeedParser) obj;
            if (iLongFeedParser == null) {
                Logger.f235387a.d().w("ILongFeedParser", 1, "no parser match elem: " + elemObj);
            } else {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("ILongFeedParser", 1, "[" + iLongFeedParser.getClass().getSimpleName() + "] match elem: " + elemObj);
                }
                Intrinsics.checkNotNullExpressionValue(elemObj, "elemObj");
                GProElem parseAsElem = iLongFeedParser.parseAsElem(elemObj, longFeedInfo);
                if (parseAsElem != null) {
                    linkedList.add(parseAsElem);
                }
            }
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) linkedList);
        GProElem gProElem = (GProElem) lastOrNull;
        if (gProElem != null && gProElem.type == 10) {
            z16 = true;
        }
        if (!z16) {
            GProElem gProElem2 = new GProElem();
            gProElem2.type = 10;
            linkedList.add(gProElem2);
        }
        return linkedList;
    }

    private final GProParagraphProps h(JSONObject jSONObject) {
        GProParagraphProps gProParagraphProps = new GProParagraphProps();
        gProParagraphProps.alignment = jSONObject.optInt("textAlignment");
        return gProParagraphProps;
    }

    private final GProStRichTextAtContent i(GuildFeedRichContentResultBean.AtUser atUser) {
        GProStRichTextAtContent gProStRichTextAtContent = new GProStRichTextAtContent();
        gProStRichTextAtContent.type = atUser.getType();
        GProStUser gProStUser = gProStRichTextAtContent.user;
        gProStUser.idd = atUser.user.getUserId();
        gProStUser.nick = atUser.user.getUserNick();
        GuildFeedRichContentResultBean.RoleInfo roleInfo = atUser.roleInfo;
        if (roleInfo != null) {
            GProRoleGroupInfo gProRoleGroupInfo = gProStRichTextAtContent.roleGroupId;
            String str = roleInfo.roleId;
            Intrinsics.checkNotNullExpressionValue(str, "role.roleId");
            gProRoleGroupInfo.roleId = MiscKt.l(str);
            gProRoleGroupInfo.name = roleInfo.name;
            gProRoleGroupInfo.color = (int) roleInfo.color;
        }
        GuildFeedRichContentResultBean.GuildInfo guildInfo = atUser.guildInfo;
        if (guildInfo != null) {
            GProBaseFeedGuildInfo gProBaseFeedGuildInfo = gProStRichTextAtContent.guildInfo;
            gProBaseFeedGuildInfo.guildId = guildInfo.guildId;
            gProBaseFeedGuildInfo.name = guildInfo.name;
        }
        return gProStRichTextAtContent;
    }

    private final GProStRichTextEmojiContent j(GuildFeedRichContentResultBean.EmojiContent emojiContent) {
        GProStRichTextEmojiContent gProStRichTextEmojiContent = new GProStRichTextEmojiContent();
        gProStRichTextEmojiContent.idd = emojiContent.f224299id;
        gProStRichTextEmojiContent.type = emojiContent.type;
        return gProStRichTextEmojiContent;
    }

    private final GProStRichTextTextContent k(GuildFeedRichContentResultBean.Text text) {
        GProStRichTextTextContent gProStRichTextTextContent = new GProStRichTextTextContent();
        gProStRichTextTextContent.text = text.getText();
        return gProStRichTextTextContent;
    }

    private final JsonElement l(Object obj, FieldNamingStrategy fieldNamingStrategy) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new GsonBuilder().setFieldNamingStrategy(fieldNamingStrategy).setExclusionStrategies(new ExclusionStrategy[0]).create().toJsonTree(obj));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            QLog.e("FeedRichTextConvertTool", 1, obj + " to json failed");
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (JsonElement) m476constructorimpl;
    }

    @Nullable
    public final GProStFeed a(@NotNull String feedJson) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(feedJson, "feedJson");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl((GProStFeed) f().fromJson(feedJson, GProStFeed.class));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("FeedRichTextConvertTool", 1, "failed to convert json to stFeed: " + feedJson, m479exceptionOrNullimpl);
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (GProStFeed) m476constructorimpl;
    }

    @Nullable
    public final String b(@NotNull Object feed) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (feed instanceof GProStFeed) {
            jsonElement = l(feed, com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.b.f221028d);
        } else {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.toString();
    }

    @NotNull
    public final GProStRichText c(@NotNull GuildFeedRichContentResultBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        GProStRichText gProStRichText = new GProStRichText();
        List<GuildFeedRichContentResultBean.RichContent> list = bean.contents;
        Intrinsics.checkNotNullExpressionValue(list, "bean.contents");
        ArrayList<GProStRichTextContent> arrayList = gProStRichText.contents;
        for (GuildFeedRichContentResultBean.RichContent richContent : list) {
            GProStRichTextContent gProStRichTextContent = new GProStRichTextContent();
            gProStRichTextContent.type = richContent.getType();
            if (richContent instanceof GuildFeedRichContentResultBean.RichTextContent) {
                GuildFeedRichContentResultBean.Text content = ((GuildFeedRichContentResultBean.RichTextContent) richContent).getContent();
                Intrinsics.checkNotNullExpressionValue(content, "it.content");
                gProStRichTextContent.textContent = k(content);
            } else if (richContent instanceof GuildFeedRichContentResultBean.RichAtContent) {
                GuildFeedRichContentResultBean.AtUser user = ((GuildFeedRichContentResultBean.RichAtContent) richContent).getUser();
                Intrinsics.checkNotNullExpressionValue(user, "it.user");
                gProStRichTextContent.atContent = i(user);
            } else if (richContent instanceof GuildFeedRichContentResultBean.RichEmojiContent) {
                GuildFeedRichContentResultBean.EmojiContent emojiContent = ((GuildFeedRichContentResultBean.RichEmojiContent) richContent).getEmojiContent();
                Intrinsics.checkNotNullExpressionValue(emojiContent, "it.emojiContent");
                gProStRichTextContent.emojiContent = j(emojiContent);
            }
            arrayList.add(gProStRichTextContent);
        }
        List<GuildFeedRichContentResultBean.ImageContent> list2 = bean.images;
        Intrinsics.checkNotNullExpressionValue(list2, "bean.images");
        ArrayList<GProStImage> arrayList2 = gProStRichText.images;
        for (GuildFeedRichContentResultBean.ImageContent imageContent : list2) {
            GProStImage gProStImage = new GProStImage();
            gProStImage.picUrl = imageContent.picUrl;
            gProStImage.width = imageContent.width;
            gProStImage.height = imageContent.height;
            gProStImage.isOrig = imageContent.isOrig;
            gProStImage.origSize = (int) imageContent.origSize;
            gProStImage.isGif = imageContent.isGif;
            arrayList2.add(gProStImage);
        }
        return gProStRichText;
    }

    @NotNull
    public final LinkedList<GProParagraph> d(@NotNull String patternInfo, @NotNull GProStFeed stFeed) {
        Object lastOrNull;
        GProElem gProElem;
        Object lastOrNull2;
        ArrayList<GProElem> arrayList;
        Object removeLast;
        ArrayList<GProElem> arrayList2;
        Object lastOrNull3;
        Intrinsics.checkNotNullParameter(patternInfo, "patternInfo");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        LinkedList<GProParagraph> linkedList = new LinkedList<>();
        LongFeedInfo a16 = LongFeedInfo.INSTANCE.a(stFeed);
        try {
            JSONArray jSONArray = new JSONArray(patternInfo);
            int length = jSONArray.length();
            for (int i3 = 1; i3 < length; i3++) {
                JSONObject patternObj = jSONArray.getJSONObject(i3);
                JSONArray optJSONArray = patternObj.optJSONArray("data");
                if (optJSONArray != null) {
                    GProParagraph gProParagraph = new GProParagraph();
                    Intrinsics.checkNotNullExpressionValue(patternObj, "patternObj");
                    gProParagraph.props = h(patternObj);
                    gProParagraph.elems = bg.f302144a.n(g(optJSONArray, a16));
                    linkedList.add(gProParagraph);
                }
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) linkedList);
            GProParagraph gProParagraph2 = (GProParagraph) lastOrNull;
            if (gProParagraph2 != null && (arrayList2 = gProParagraph2.elems) != null) {
                lastOrNull3 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList2);
                gProElem = (GProElem) lastOrNull3;
            } else {
                gProElem = null;
            }
            if (gProElem != null && gProElem.type == 10) {
                lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) linkedList);
                GProParagraph gProParagraph3 = (GProParagraph) lastOrNull2;
                if (gProParagraph3 != null && (arrayList = gProParagraph3.elems) != null) {
                    removeLast = CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                }
            }
        } catch (Exception e16) {
            QLog.i("FeedRichTextConvertTool", 1, "getLongFeedParagraphs exception: " + e16.getMessage());
        }
        return linkedList;
    }
}
