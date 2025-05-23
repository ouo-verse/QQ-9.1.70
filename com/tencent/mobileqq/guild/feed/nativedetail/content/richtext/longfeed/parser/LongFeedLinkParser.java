package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProURLElem;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedLinkParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProURLElem;", "()V", QZoneImageUtils.KEY_MATCH, "", "data", "Lorg/json/JSONObject;", "parse", "feedContents", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "toGProElem", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "t", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class LongFeedLinkParser implements ILongFeedParser<GProURLElem> {
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    public boolean match(@NotNull JSONObject data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!Intrinsics.areEqual(data.optString("type"), "5")) {
            return false;
        }
        String optString = data.optString("playUrl");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProElem parseAsElem(@NotNull JSONObject jSONObject, @NotNull LongFeedInfo longFeedInfo) {
        return ILongFeedParser.a.a(this, jSONObject, longFeedInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @NotNull
    public GProURLElem parse(@NotNull JSONObject data, @NotNull LongFeedInfo feedContents) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(feedContents, "feedContents");
        data.optString("id");
        String optString = data.optString(CssStyleSet.HREF_STYLE);
        if (optString == null) {
            optString = "";
        }
        int optInt = data.optInt("urlType");
        String optString2 = data.optString("desc");
        String str = optString2 != null ? optString2 : "";
        GProURLElem gProURLElem = new GProURLElem();
        GProStRichTextURLContent gProStRichTextURLContent = new GProStRichTextURLContent();
        gProStRichTextURLContent.type = optInt;
        gProStRichTextURLContent.url = optString;
        gProStRichTextURLContent.displayText = str;
        gProURLElem.urlContent = gProStRichTextURLContent;
        return gProURLElem;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @NotNull
    public GProElem toGProElem(@NotNull GProURLElem t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        GProElem gProElem = new GProElem();
        gProElem.type = 4;
        gProElem.url = t16;
        return gProElem;
    }
}
