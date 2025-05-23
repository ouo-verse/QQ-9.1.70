package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser;

import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser;
import com.tencent.mobileqq.guild.feed.nativeinterface.kt.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVideoElem;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedVideoParser;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProVideoElem;", "()V", QZoneImageUtils.KEY_MATCH, "", "data", "Lorg/json/JSONObject;", "parse", "feedContents", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "toGProElem", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "t", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class LongFeedVideoParser implements ILongFeedParser<GProVideoElem> {
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    public boolean match(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Intrinsics.areEqual(data.optString("type"), "7");
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProElem parseAsElem(@NotNull JSONObject jSONObject, @NotNull LongFeedInfo longFeedInfo) {
        return ILongFeedParser.a.a(this, jSONObject, longFeedInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @Nullable
    public GProVideoElem parse(@NotNull JSONObject data, @NotNull LongFeedInfo feedContents) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(feedContents, "feedContents");
        String optString = data.optString("id");
        if (optString == null) {
            optString = "";
        }
        GProStVideo h16 = feedContents.h(optString);
        if (h16 == null) {
            QLog.i("LongFeedImageParser", 1, "Fail to getImageByPatternId: " + optString);
            return null;
        }
        String str = h16.playUrl;
        Intrinsics.checkNotNullExpressionValue(str, "video.playUrl");
        if (str.length() == 0) {
            String optString2 = data.optString("videoId");
            if (!Intrinsics.areEqual(optString2, "") && RFWFileUtils.isLocalPath(optString2)) {
                h16.playUrl = optString2;
            }
        }
        String str2 = h16.playUrl;
        Intrinsics.checkNotNullExpressionValue(str2, "video.playUrl");
        if (str2.length() == 0) {
            String it = data.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            h16.playUrl = a.n(it);
        }
        GProVideoElem gProVideoElem = new GProVideoElem();
        gProVideoElem.video = h16;
        return gProVideoElem;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.ILongFeedParser
    @NotNull
    public GProElem toGProElem(@NotNull GProVideoElem t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        GProElem gProElem = new GProElem();
        gProElem.type = 3;
        gProElem.video = t16;
        return gProElem;
    }
}
