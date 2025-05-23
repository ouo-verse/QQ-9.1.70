package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser;

import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextProps;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedTextParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTextElem;", "()V", QZoneImageUtils.KEY_MATCH, "", "data", "Lorg/json/JSONObject;", "matchTextType", "type", "", "parse", QCircleScheme.AttrDetail.FEED_INFO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "toGProElem", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "t", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class LongFeedTextParser implements ILongFeedParser<GProTextElem> {
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    public boolean match(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!matchTextType(data.optInt("type")) && (data.optInt("type") != 2 || data.optInt("emojiType") != 2)) {
            return false;
        }
        return true;
    }

    public final boolean matchTextType(int type) {
        if (type == 1 || type == 12) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProElem parseAsElem(@NotNull JSONObject jSONObject, @NotNull LongFeedInfo longFeedInfo) {
        return ILongFeedParser.a.a(this, jSONObject, longFeedInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProTextElem parse(@NotNull JSONObject data, @NotNull LongFeedInfo feedInfo) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
        JSONObject optJSONObject = data.optJSONObject("props");
        int optInt = optJSONObject != null ? optJSONObject.optInt("fontWeight") : 0;
        boolean optBoolean = optJSONObject != null ? optJSONObject.optBoolean("underline") : false;
        boolean optBoolean2 = optJSONObject != null ? optJSONObject.optBoolean("italic") : false;
        GProStRichTextContent poll = feedInfo.f().poll();
        if (poll == null) {
            return null;
        }
        GProTextElem gProTextElem = new GProTextElem();
        gProTextElem.textContent = poll.textContent;
        GProTextProps gProTextProps = new GProTextProps();
        gProTextProps.fontWeight = optInt;
        gProTextProps.underline = optBoolean;
        gProTextProps.italic = optBoolean2;
        gProTextElem.props = gProTextProps;
        return gProTextElem;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @NotNull
    public GProElem toGProElem(@NotNull GProTextElem t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        GProElem gProElem = new GProElem();
        gProElem.type = 1;
        gProElem.text = t16;
        return gProElem;
    }
}
