package com.tencent.mobileqq.guild.feed.nativeinterface.kt;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProParagraph;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeedSummary;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativeinterface/kt/GProStFeedKt;", "", "", "jsonFeed", "", "isShortFeed", "patternInfo", "Lorg/json/JSONObject;", "thirdBarObj", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/FeedRichTextConvertTool;", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/FeedRichTextConvertTool;", "richTextConvertTool", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GProStFeedKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GProStFeedKt f221782a = new GProStFeedKt();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy richTextConvertTool;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FeedRichTextConvertTool>() { // from class: com.tencent.mobileqq.guild.feed.nativeinterface.kt.GProStFeedKt$richTextConvertTool$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedRichTextConvertTool invoke() {
                return new FeedRichTextConvertTool();
            }
        });
        richTextConvertTool = lazy;
    }

    GProStFeedKt() {
    }

    public static /* synthetic */ GProStFeed b(GProStFeedKt gProStFeedKt, String str, boolean z16, String str2, JSONObject jSONObject, int i3, Object obj) throws JSONException {
        if ((i3 & 8) != 0) {
            jSONObject = null;
        }
        return gProStFeedKt.a(str, z16, str2, jSONObject);
    }

    private final FeedRichTextConvertTool c() {
        return (FeedRichTextConvertTool) richTextConvertTool.getValue();
    }

    @Nullable
    public final GProStFeed a(@NotNull String jsonFeed, boolean isShortFeed, @Nullable String patternInfo, @Nullable JSONObject thirdBarObj) throws JSONException {
        int e16;
        boolean z16;
        Intrinsics.checkNotNullParameter(jsonFeed, "jsonFeed");
        GProStFeed a16 = c().a(jsonFeed);
        if (a16 != null) {
            a.o(a16, jsonFeed, isShortFeed);
            a.q(a16);
            a.p(a16, thirdBarObj);
            GProStFeedSummary gProStFeedSummary = a16.summary;
            e16 = a.e(a16);
            gProStFeedSummary.layoutType = e16;
            if (!isShortFeed) {
                if (patternInfo != null && patternInfo.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    LinkedList<GProParagraph> d16 = c().d(patternInfo, a16);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("FakeStFeedEx", 1, "\u8865\u5145\u957f\u8d34 paragraphs \u6761\u6570\uff1a" + d16.size() + ", from " + patternInfo + " ");
                    }
                    a16.contentWithStyle.paragraphs = bg.f302144a.n(d16);
                }
            }
            return a16;
        }
        return null;
    }
}
