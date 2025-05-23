package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed;

import android.os.Build;
import android.text.SpannableStringBuilder;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedUIData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.j;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProParagraph;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J2\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015J \u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eJ\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010)\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010+\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010,\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u0006\u0010.\u001a\u00020-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/b;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/j;", "Lkotlin/collections/ArrayList;", "c", "", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "l", "", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "b", "width", "height", "", "widthPercent", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "sceneType", "Lkotlin/Pair;", "f", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "textContainer", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "type", "", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/c;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "video", "elemIndex", "paragraphIndex", "j", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "pic", "g", "url", h.F, "i", "", "k", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f221426a = new b();

    b() {
    }

    private final ArrayList<j> c(GProStFeed stFeed) {
        ArrayList<j> arrayList = new ArrayList<>();
        try {
            Iterator<GProParagraph> it = stFeed.contentWithStyle.paragraphs.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                GProParagraph p16 = it.next();
                Intrinsics.checkNotNullExpressionValue(p16, "p");
                arrayList.add(new j(p16, i3, stFeed));
                i3 = i16;
            }
        } catch (Exception e16) {
            QLog.i("LongFeedParserUtils", 1, "getLongFeedParagraphs exception: " + e16.getMessage());
            s.e("LongFeedParserUtils", "getLongFeedParagraphs", e16);
        }
        return arrayList;
    }

    private final int e() {
        float dimension = BaseApplication.context.getResources().getDimension(R.dimen.cgr);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("LongFeedParserUtils", 1, "getMaxWidthForShare maxWidthForShare:" + dimension);
        }
        return (int) dimension;
    }

    @Nullable
    public final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c a(@NotNull TextViewContainer textContainer, @NotNull BaseLongFeedViewAdapter.TYPE type, @NotNull String identifier) {
        Intrinsics.checkNotNullParameter(textContainer, "textContainer");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> r16 = textContainer.r();
        if (r16 != null) {
            for (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar : r16) {
                if (cVar.i() instanceof BaseLongFeedViewAdapter) {
                    g i3 = cVar.i();
                    Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter");
                    if (((BaseLongFeedViewAdapter) i3).k() == type) {
                        g i16 = cVar.i();
                        Intrinsics.checkNotNull(i16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter");
                        if (Intrinsics.areEqual(((BaseLongFeedViewAdapter) i16).j(), identifier)) {
                            return cVar;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final List<IFeedDetailDataParser.MediaInfo> b(@NotNull GProStFeed stFeed) {
        int collectionSizeOrDefault;
        List<IFeedDetailDataParser.MediaInfo> flatten;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        ArrayList<j> c16 = c(stFeed);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = c16.iterator();
        while (it.hasNext()) {
            arrayList.add(((j) it.next()).a());
        }
        flatten = CollectionsKt__IterablesKt.flatten(arrayList);
        return flatten;
    }

    public final int d(@NotNull LongFeedParseSceneType sceneType) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        if (c.a(sceneType)) {
            return e();
        }
        return GuildSplitViewUtils.j(GuildSplitViewUtils.f235370a, false, null, 3, null) - (ViewUtils.dpToPx(16.0f) * 2);
    }

    @NotNull
    public final Pair<Integer, Integer> f(int width, int height, float widthPercent, @NotNull LongFeedParseSceneType sceneType) {
        float d16;
        float f16;
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        if (widthPercent <= 0.0f) {
            d16 = Math.min(width, d(sceneType));
        } else {
            d16 = (d(sceneType) * widthPercent) / 100.0f;
        }
        if (width > 0) {
            f16 = d16 / width;
        } else {
            f16 = 1.0f;
        }
        float f17 = height * f16;
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("LongFeedParserUtils", 1, "getMediaSize targetWidth:" + d16 + " targetHeight:" + f17 + " factor:" + f16);
        }
        return new Pair<>(Integer.valueOf((int) d16), Integer.valueOf((int) f17));
    }

    @NotNull
    public final String g(@NotNull GProStImage pic, int elemIndex, int paragraphIndex) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        String str = pl1.a.d(pic) + "_" + elemIndex + "_" + paragraphIndex;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(p\u2026aragraphIndex).toString()");
        return str;
    }

    @NotNull
    public final String h(@NotNull String url, int elemIndex, int paragraphIndex) {
        Intrinsics.checkNotNullParameter(url, "url");
        String str = url + "_" + elemIndex + "_" + paragraphIndex;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(u\u2026aragraphIndex).toString()");
        return str;
    }

    @NotNull
    public final String i(@NotNull String url, int elemIndex, int paragraphIndex) {
        Intrinsics.checkNotNullParameter(url, "url");
        String str = url + "_" + elemIndex + "_" + paragraphIndex;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(u\u2026aragraphIndex).toString()");
        return str;
    }

    @NotNull
    public final String j(@NotNull GProStVideo video, int elemIndex, int paragraphIndex) {
        Intrinsics.checkNotNullParameter(video, "video");
        String str = com.tencent.mobileqq.guild.feed.video.e.f223991a.b(video) + "_" + elemIndex + "_" + paragraphIndex;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026aragraphIndex).toString()");
        return str;
    }

    public final boolean k() {
        boolean contains;
        boolean contains2;
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        contains = StringsKt__StringsKt.contains((CharSequence) MODEL, (CharSequence) "16s Pro", true);
        if (contains) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            contains2 = StringsKt__StringsKt.contains((CharSequence) MANUFACTURER, (CharSequence) "meizu", true);
            if (contains2) {
                return true;
            }
            return false;
        }
        return false;
    }

    @NotNull
    public final LongFeedUIData l(@NotNull LongFeedParseParam parseParam, @NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        ArrayList<j> c16 = c(stFeed);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        com.tencent.aio.widget.textView.view.b bVar = null;
        boolean z16 = false;
        try {
            Iterator<j> it = c16.iterator();
            while (it.hasNext()) {
                LongFeedUIData b16 = it.next().b(parseParam);
                spannableStringBuilder.append((CharSequence) b16.getSpannable());
                if (b16.getTouchMovementMethod() != null) {
                    bVar = b16.getTouchMovementMethod();
                }
                arrayList.addAll(b16.b());
                if (b16.getHasItalicText()) {
                    z16 = true;
                }
            }
        } catch (Exception e16) {
            QLog.i("LongFeedParserUtils", 1, "parseLongFeed exception: " + e16.getMessage());
            s.e("LongFeedParserUtils", "parseLongFeed", e16);
        }
        return new LongFeedUIData(spannableStringBuilder, arrayList, bVar, z16);
    }
}
