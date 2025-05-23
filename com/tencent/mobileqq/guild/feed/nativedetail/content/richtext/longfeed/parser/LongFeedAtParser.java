package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser;

import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextAtContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedAtParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAtElem;", "()V", QZoneImageUtils.KEY_MATCH, "", "data", "Lorg/json/JSONObject;", "parse", "feedContents", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "toGProElem", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "t", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class LongFeedAtParser implements ILongFeedParser<GProAtElem> {
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    public boolean match(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual(data.optString("type"), "3");
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProElem parseAsElem(@NotNull JSONObject jSONObject, @NotNull LongFeedInfo longFeedInfo) {
        return ILongFeedParser.a.a(this, jSONObject, longFeedInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProAtElem parse(@NotNull JSONObject data, @NotNull LongFeedInfo feedContents) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(feedContents, "feedContents");
        GProAtElem gProAtElem = new GProAtElem();
        GProStRichTextAtContent gProStRichTextAtContent = new GProStRichTextAtContent();
        int optInt = data.optInt("atType");
        gProStRichTextAtContent.type = optInt;
        if (optInt == 1) {
            JSONObject optJSONObject = data.optJSONObject(QCircleAlphaUserReporter.KEY_USER);
            if (optJSONObject == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "data.optJSONObject(\"user\") ?: return null");
            GProStUser gProStUser = new GProStUser();
            gProStUser.idd = optJSONObject.optString("id");
            gProStUser.nick = optJSONObject.optString("nick");
            gProStRichTextAtContent.user = gProStUser;
        }
        gProAtElem.atContent = gProStRichTextAtContent;
        return gProAtElem;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @NotNull
    public GProElem toGProElem(@NotNull GProAtElem t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        GProElem gProElem = new GProElem();
        gProElem.type = 6;
        gProElem.f359287at = t16;
        return gProElem;
    }
}
