package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser;

import androidx.annotation.Keep;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001f\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&\u00a2\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/ILongFeedParser;", "T", "", QZoneImageUtils.KEY_MATCH, "", "data", "Lorg/json/JSONObject;", "parse", "feedContents", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "(Lorg/json/JSONObject;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;)Ljava/lang/Object;", "parseAsElem", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "toGProElem", "t", "(Ljava/lang/Object;)Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public interface ILongFeedParser<T> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        @Nullable
        public static <T> GProElem a(@NotNull ILongFeedParser<T> iLongFeedParser, @NotNull JSONObject data, @NotNull LongFeedInfo feedContents) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(feedContents, "feedContents");
            T parse = iLongFeedParser.parse(data, feedContents);
            if (parse == null) {
                return null;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ILongFeedParser", 1, "[" + iLongFeedParser.getClass().getSimpleName() + "] parseAsElem: " + parse);
            }
            return iLongFeedParser.toGProElem(parse);
        }
    }

    boolean match(@NotNull JSONObject data);

    @Nullable
    T parse(@NotNull JSONObject data, @NotNull LongFeedInfo feedContents);

    @Nullable
    GProElem parseAsElem(@NotNull JSONObject data, @NotNull LongFeedInfo feedContents);

    @NotNull
    GProElem toGProElem(T t16);
}
