package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser;

import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImageElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImageProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import cooperation.qzone.util.QZoneImageUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedImageParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImageElem;", "()V", QZoneImageUtils.KEY_MATCH, "", "data", "Lorg/json/JSONObject;", "parse", "feedContents", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "toGProElem", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "t", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class LongFeedImageParser implements ILongFeedParser<GProImageElem> {
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    public boolean match(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual(data.optString("type"), "6");
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProElem parseAsElem(@NotNull JSONObject jSONObject, @NotNull LongFeedInfo longFeedInfo) {
        return ILongFeedParser.a.a(this, jSONObject, longFeedInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProImageElem parse(@NotNull JSONObject data, @NotNull LongFeedInfo feedContents) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(feedContents, "feedContents");
        String optString = data.optString("id");
        if (optString == null) {
            optString = "";
        }
        double optDouble = data.optDouble("widthPercentage", data.optDouble("widthPercent", 100.0d));
        GProStImage c16 = feedContents.c(optString);
        if (c16 == null) {
            QLog.i("LongFeedImageParser", 1, "Fail to getImageByPatternId: " + optString + ", " + feedContents.d());
            return null;
        }
        GProImageElem gProImageElem = new GProImageElem();
        String picUrl = c16.picUrl;
        Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(picUrl, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
        c16.isGif = endsWith$default;
        gProImageElem.image = c16;
        GProImageProps gProImageProps = new GProImageProps();
        gProImageProps.widthPercent = (float) optDouble;
        gProImageElem.props = gProImageProps;
        return gProImageElem;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @NotNull
    public GProElem toGProElem(@NotNull GProImageElem t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        GProElem gProElem = new GProElem();
        gProElem.type = 2;
        gProElem.image = t16;
        return gProElem;
    }
}
