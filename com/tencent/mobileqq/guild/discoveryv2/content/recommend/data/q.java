package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsListSection;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeedsGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendOneToOne;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichText;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0006*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0011"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "baseExt", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "a", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeedsGuild;", "data", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedsGuildData;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryTabContentRsp;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/u;", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q {
    @NotNull
    public static final List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> a(@NotNull ArrayList<IGProRecommendContentItem> arrayList, @NotNull RecommendExtData baseExt) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(baseExt, "baseExt");
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            baseExt.g(i3);
            com.tencent.mobileqq.guild.discoveryv2.content.base.h d16 = d((IGProRecommendContentItem) obj, baseExt);
            if (d16 != null) {
                arrayList2.add(d16);
            }
            i3 = i16;
        }
        return arrayList2;
    }

    @Nullable
    public static final SpecialActivityListData b(@NotNull IGProGetCategoryTabContentRsp iGProGetCategoryTabContentRsp, @NotNull RecommendExtData baseExt) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String joinToString$default;
        String title;
        Intrinsics.checkNotNullParameter(iGProGetCategoryTabContentRsp, "<this>");
        Intrinsics.checkNotNullParameter(baseExt, "baseExt");
        ArrayList<IGProRecommendContentItem> hotActivities = iGProGetCategoryTabContentRsp.getHotActivities();
        Intrinsics.checkNotNullExpressionValue(hotActivities, "hotActivities");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(hotActivities, 10);
        ArrayList<SpecialActivityData> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = hotActivities.iterator();
        while (it.hasNext()) {
            IGProContentRecommendH5Kuikly h5kuikly = ((IGProRecommendContentItem) it.next()).getH5kuikly();
            String iconUrl = h5kuikly.getIconUrl();
            Intrinsics.checkNotNullExpressionValue(iconUrl, "activityInfo.iconUrl");
            String name = h5kuikly.getName();
            Intrinsics.checkNotNullExpressionValue(name, "activityInfo.name");
            String jumpUrl = h5kuikly.getJumpUrl();
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "activityInfo.jumpUrl");
            arrayList.add(new SpecialActivityData(iconUrl, name, jumpUrl));
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (SpecialActivityData specialActivityData : arrayList) {
            arrayList2.add(specialActivityData.getName() + "-" + specialActivityData.getJumpUrl());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
        boolean z16 = true;
        QLog.i("specialActivityList", 1, joinToString$default);
        if (arrayList.size() < 2) {
            return null;
        }
        String hotTitle = iGProGetCategoryTabContentRsp.getHotTitle();
        if (hotTitle != null && hotTitle.length() != 0) {
            z16 = false;
        }
        if (z16) {
            title = "\u7279\u8272\u6d3b\u52a8";
        } else {
            title = iGProGetCategoryTabContentRsp.getHotTitle();
        }
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return new SpecialActivityListData(title, arrayList, RecommendExtData.b(baseExt, null, 0, null, null, 0, 31, null));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:5|(4:9|(2:10|(3:12|(2:154|155)(2:16|17)|(1:19)(1:153))(2:156|157))|20|(12:26|(1:28)|29|30|31|(6:36|37|38|(1:40)|41|42)|150|37|38|(0)|41|42))|158|(0)|29|30|31|(7:33|36|37|38|(0)|41|42)|150|37|38|(0)|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00d5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x00d6, code lost:
    
        r12 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m476constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[LOOP:2: B:93:0x047e->B:124:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01a8 A[LOOP:3: B:177:0x0175->B:190:0x01a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x056d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final RecommendFeedsGuildData c(IGProContentRecommendFeedsGuild iGProContentRecommendFeedsGuild, RecommendExtData recommendExtData) {
        String str;
        int i3;
        String str2;
        String str3;
        h hVar;
        RecommendAbsFeedData recommendAbsFeedData;
        IGProContentRecommendFeed iGProContentRecommendFeed;
        RecommendAbsFeedData recommendAbsFeedData2;
        char c16;
        List listOf;
        Object firstOrNull;
        IGProImage image;
        Object obj;
        boolean isBlank;
        IGProMVPURLContent urlContent;
        IGProMVPThirdVideoInfo thirdVideoInfo;
        boolean z16;
        IGProMVPThirdVideoInfo thirdVideoInfo2;
        String str4;
        ArrayList<IGProMVPRichTextContent> contents;
        Object obj2;
        IGProMVPURLContent urlContent2;
        IGProMVPCommThirdShareInfo thirdShareInfo;
        Object m476constructorimpl;
        float coerceIn;
        Object m476constructorimpl2;
        float coerceIn2;
        float f16;
        Object m476constructorimpl3;
        float coerceIn3;
        float f17;
        Object firstOrNull2;
        IGProImage image2;
        Object m476constructorimpl4;
        float coerceIn4;
        float f18;
        Object obj3;
        boolean isBlank2;
        Object m476constructorimpl5;
        float coerceIn5;
        float f19;
        IGProMVPURLContent urlContent3;
        IGProMVPThirdVideoInfo thirdVideoInfo3;
        boolean z17;
        IGProMVPThirdVideoInfo thirdVideoInfo4;
        Object m476constructorimpl6;
        float coerceIn6;
        float f26;
        String str5;
        k h16;
        Object m476constructorimpl7;
        float coerceIn7;
        float f27;
        ArrayList<IGProMVPRichTextContent> contents2;
        Object obj4;
        IGProMVPURLContent urlContent4;
        IGProMVPCommThirdShareInfo thirdShareInfo2;
        RecommendFeedsListSection.Companion companion = RecommendFeedsListSection.INSTANCE;
        float[] a16 = companion.a();
        int[] b16 = companion.b();
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        h hVar2 = new h(false, 1.0f, a16, b16, 2, DEFAULT, Integer.MAX_VALUE);
        IGProContentRecommendFeed iGProContentRecommendFeed2 = iGProContentRecommendFeedsGuild.getFeeds().get(0);
        str = "";
        if (iGProContentRecommendFeed2 != null) {
            switch (iGProContentRecommendFeed2.getFeedContentType()) {
                case 1:
                    i3 = 3;
                    str2 = "videos";
                    str3 = "richText.contents";
                    hVar = hVar2;
                    if (com.tencent.mobileqq.guild.discoveryv2.util.e.e(iGProContentRecommendFeed2)) {
                        IGProImage customCover = iGProContentRecommendFeed2.getCustomCover();
                        Intrinsics.checkNotNullExpressionValue(customCover, "customCover");
                        k g16 = com.tencent.mobileqq.guild.discoveryv2.util.e.g(customCover);
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                        } catch (Throwable th5) {
                            Result.Companion companion3 = Result.INSTANCE;
                            m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        if (g16 != null && g16.getMediaRawSize().getWidth() != 0) {
                            f16 = g16.getMediaRawSize().getHeight() / g16.getMediaRawSize().getWidth();
                            m476constructorimpl2 = Result.m476constructorimpl(Float.valueOf(f16));
                            Float valueOf = Float.valueOf(1.0f);
                            if (Result.m482isFailureimpl(m476constructorimpl2)) {
                                m476constructorimpl2 = valueOf;
                            }
                            coerceIn2 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl2).floatValue(), 1.0f, 1.25f);
                            hVar.setMediaRatio(coerceIn2);
                            recommendAbsFeedData = new RecommendPicMixData(iGProContentRecommendFeed2, g16, hVar, recommendExtData);
                            break;
                        }
                        f16 = 1.0f;
                        m476constructorimpl2 = Result.m476constructorimpl(Float.valueOf(f16));
                        Float valueOf2 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl2)) {
                        }
                        coerceIn2 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl2).floatValue(), 1.0f, 1.25f);
                        hVar.setMediaRatio(coerceIn2);
                        recommendAbsFeedData = new RecommendPicMixData(iGProContentRecommendFeed2, g16, hVar, recommendExtData);
                    } else {
                        try {
                            Result.Companion companion4 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(Float.valueOf(1.0f));
                        } catch (Throwable th6) {
                            Result.Companion companion5 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                        }
                        Float valueOf3 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl)) {
                            m476constructorimpl = valueOf3;
                        }
                        coerceIn = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl).floatValue(), 1.0f, 1.25f);
                        hVar.setMediaRatio(coerceIn);
                        recommendAbsFeedData = new RecommendFeedTextData(iGProContentRecommendFeed2, hVar, recommendExtData);
                        break;
                    }
                    break;
                case 2:
                    i3 = 3;
                    str2 = "videos";
                    str3 = "richText.contents";
                    hVar = hVar2;
                    IGProImage a17 = com.tencent.mobileqq.guild.discoveryv2.util.e.a(iGProContentRecommendFeed2);
                    if (a17 == null) {
                        a17 = iGProContentRecommendFeed2.getImage();
                    }
                    Intrinsics.checkNotNullExpressionValue(a17, "customCoverOrNull() ?: image");
                    k g17 = com.tencent.mobileqq.guild.discoveryv2.util.e.g(a17);
                    try {
                        Result.Companion companion6 = Result.INSTANCE;
                    } catch (Throwable th7) {
                        Result.Companion companion7 = Result.INSTANCE;
                        m476constructorimpl3 = Result.m476constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (g17 != null && g17.getMediaRawSize().getWidth() != 0) {
                        f17 = g17.getMediaRawSize().getHeight() / g17.getMediaRawSize().getWidth();
                        m476constructorimpl3 = Result.m476constructorimpl(Float.valueOf(f17));
                        Float valueOf4 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl3)) {
                            m476constructorimpl3 = valueOf4;
                        }
                        coerceIn3 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl3).floatValue(), 1.0f, 1.25f);
                        hVar.setMediaRatio(coerceIn3);
                        recommendAbsFeedData = new RecommendPicMixData(iGProContentRecommendFeed2, g17, hVar, recommendExtData);
                        break;
                    }
                    f17 = 1.0f;
                    m476constructorimpl3 = Result.m476constructorimpl(Float.valueOf(f17));
                    Float valueOf42 = Float.valueOf(1.0f);
                    if (Result.m482isFailureimpl(m476constructorimpl3)) {
                    }
                    coerceIn3 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl3).floatValue(), 1.0f, 1.25f);
                    hVar.setMediaRatio(coerceIn3);
                    recommendAbsFeedData = new RecommendPicMixData(iGProContentRecommendFeed2, g17, hVar, recommendExtData);
                    break;
                case 3:
                    ArrayList<IGProVideo> videos = iGProContentRecommendFeed2.getVideos();
                    Intrinsics.checkNotNullExpressionValue(videos, "videos");
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) videos);
                    IGProVideo iGProVideo = (IGProVideo) firstOrNull2;
                    if (iGProVideo == null || (image2 = iGProVideo.getCover()) == null) {
                        image2 = iGProContentRecommendFeed2.getImage();
                    }
                    Intrinsics.checkNotNullExpressionValue(image2, "video?.cover ?: image");
                    k g18 = com.tencent.mobileqq.guild.discoveryv2.util.e.g(image2);
                    GProStVideo i16 = iGProVideo != null ? com.tencent.mobileqq.guild.discoveryv2.util.e.i(iGProVideo) : null;
                    try {
                        Result.Companion companion8 = Result.INSTANCE;
                    } catch (Throwable th8) {
                        Result.Companion companion9 = Result.INSTANCE;
                        m476constructorimpl4 = Result.m476constructorimpl(ResultKt.createFailure(th8));
                    }
                    if (g18 != null && g18.getMediaRawSize().getWidth() != 0) {
                        f18 = g18.getMediaRawSize().getHeight() / g18.getMediaRawSize().getWidth();
                        m476constructorimpl4 = Result.m476constructorimpl(Float.valueOf(f18));
                        Float valueOf5 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl4)) {
                            m476constructorimpl4 = valueOf5;
                        }
                        coerceIn4 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl4).floatValue(), 1.0f, 1.25f);
                        hVar2.setMediaRatio(coerceIn4);
                        str2 = "videos";
                        str3 = "richText.contents";
                        GProStVideo gProStVideo = i16;
                        i3 = 3;
                        hVar = hVar2;
                        recommendAbsFeedData = new RecommendVideoMixData(iGProContentRecommendFeed2, g18, gProStVideo, hVar2, recommendExtData);
                        break;
                    }
                    f18 = 1.0f;
                    m476constructorimpl4 = Result.m476constructorimpl(Float.valueOf(f18));
                    Float valueOf52 = Float.valueOf(1.0f);
                    if (Result.m482isFailureimpl(m476constructorimpl4)) {
                    }
                    coerceIn4 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl4).floatValue(), 1.0f, 1.25f);
                    hVar2.setMediaRatio(coerceIn4);
                    str2 = "videos";
                    str3 = "richText.contents";
                    GProStVideo gProStVideo2 = i16;
                    i3 = 3;
                    hVar = hVar2;
                    recommendAbsFeedData = new RecommendVideoMixData(iGProContentRecommendFeed2, g18, gProStVideo2, hVar2, recommendExtData);
                    break;
                case 4:
                    ArrayList<IGProMVPRichTextContent> contents3 = iGProContentRecommendFeed2.getRichText().getContents();
                    Intrinsics.checkNotNullExpressionValue(contents3, "richText.contents");
                    Iterator<T> it = contents3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj3 = it.next();
                            IGProMVPRichTextContent iGProMVPRichTextContent = (IGProMVPRichTextContent) obj3;
                            if (iGProMVPRichTextContent.getType() == 3) {
                                IGProMVPURLContent urlContent5 = iGProMVPRichTextContent.getUrlContent();
                                if (!TextUtils.isEmpty((urlContent5 == null || (thirdVideoInfo4 = urlContent5.getThirdVideoInfo()) == null) ? null : thirdVideoInfo4.getCover())) {
                                    z17 = true;
                                    if (!z17) {
                                    }
                                }
                            }
                            z17 = false;
                            if (!z17) {
                            }
                        } else {
                            obj3 = null;
                        }
                    }
                    IGProMVPRichTextContent iGProMVPRichTextContent2 = (IGProMVPRichTextContent) obj3;
                    String cover = (iGProMVPRichTextContent2 == null || (urlContent3 = iGProMVPRichTextContent2.getUrlContent()) == null || (thirdVideoInfo3 = urlContent3.getThirdVideoInfo()) == null) ? null : thirdVideoInfo3.getCover();
                    String b17 = com.tencent.mobileqq.guild.discoveryv2.util.e.b(iGProContentRecommendFeed2);
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(b17);
                    if (!(!isBlank2)) {
                        b17 = null;
                    }
                    if (b17 != null) {
                        cover = b17;
                    } else if (cover == null) {
                        cover = "";
                    }
                    k h17 = com.tencent.mobileqq.guild.discoveryv2.util.e.h(cover, 400, 300);
                    try {
                        Result.Companion companion10 = Result.INSTANCE;
                    } catch (Throwable th9) {
                        Result.Companion companion11 = Result.INSTANCE;
                        m476constructorimpl5 = Result.m476constructorimpl(ResultKt.createFailure(th9));
                    }
                    if (h17 != null && h17.getMediaRawSize().getWidth() != 0) {
                        f19 = h17.getMediaRawSize().getHeight() / h17.getMediaRawSize().getWidth();
                        m476constructorimpl5 = Result.m476constructorimpl(Float.valueOf(f19));
                        Float valueOf6 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl5)) {
                            m476constructorimpl5 = valueOf6;
                        }
                        coerceIn5 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl5).floatValue(), 1.0f, 1.25f);
                        hVar2.setMediaRatio(coerceIn5);
                        recommendAbsFeedData = new RecommendThirdVideoData(iGProContentRecommendFeed2, h17, hVar2, recommendExtData);
                        str2 = "videos";
                        str3 = "richText.contents";
                        hVar = hVar2;
                        i3 = 3;
                        break;
                    }
                    f19 = 1.0f;
                    m476constructorimpl5 = Result.m476constructorimpl(Float.valueOf(f19));
                    Float valueOf62 = Float.valueOf(1.0f);
                    if (Result.m482isFailureimpl(m476constructorimpl5)) {
                    }
                    coerceIn5 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl5).floatValue(), 1.0f, 1.25f);
                    hVar2.setMediaRatio(coerceIn5);
                    recommendAbsFeedData = new RecommendThirdVideoData(iGProContentRecommendFeed2, h17, hVar2, recommendExtData);
                    str2 = "videos";
                    str3 = "richText.contents";
                    hVar = hVar2;
                    i3 = 3;
                    break;
                case 5:
                    k h18 = com.tencent.mobileqq.guild.discoveryv2.util.e.h("", 200, 205);
                    try {
                        Result.Companion companion12 = Result.INSTANCE;
                    } catch (Throwable th10) {
                        Result.Companion companion13 = Result.INSTANCE;
                        m476constructorimpl6 = Result.m476constructorimpl(ResultKt.createFailure(th10));
                    }
                    if (h18 != null && h18.getMediaRawSize().getWidth() != 0) {
                        f26 = h18.getMediaRawSize().getHeight() / h18.getMediaRawSize().getWidth();
                        m476constructorimpl6 = Result.m476constructorimpl(Float.valueOf(f26));
                        Float valueOf7 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl6)) {
                            m476constructorimpl6 = valueOf7;
                        }
                        coerceIn6 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl6).floatValue(), 1.0f, 1.25f);
                        hVar2.setMediaRatio(coerceIn6);
                        recommendAbsFeedData = new RecommendFileData(iGProContentRecommendFeed2, hVar2, recommendExtData);
                        i3 = 3;
                        str2 = "videos";
                        str3 = "richText.contents";
                        hVar = hVar2;
                        break;
                    }
                    f26 = 1.0f;
                    m476constructorimpl6 = Result.m476constructorimpl(Float.valueOf(f26));
                    Float valueOf72 = Float.valueOf(1.0f);
                    if (Result.m482isFailureimpl(m476constructorimpl6)) {
                    }
                    coerceIn6 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl6).floatValue(), 1.0f, 1.25f);
                    hVar2.setMediaRatio(coerceIn6);
                    recommendAbsFeedData = new RecommendFileData(iGProContentRecommendFeed2, hVar2, recommendExtData);
                    i3 = 3;
                    str2 = "videos";
                    str3 = "richText.contents";
                    hVar = hVar2;
                    break;
                case 6:
                    IGProMVPRichText richText = iGProContentRecommendFeed2.getRichText();
                    if (richText != null && (contents2 = richText.getContents()) != null) {
                        Iterator<T> it5 = contents2.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                obj4 = it5.next();
                                IGProMVPRichTextContent iGProMVPRichTextContent3 = (IGProMVPRichTextContent) obj4;
                                if (iGProMVPRichTextContent3.getType() == 3 && iGProMVPRichTextContent3.getUrlContent().getType() == 6) {
                                }
                            } else {
                                obj4 = null;
                            }
                        }
                        IGProMVPRichTextContent iGProMVPRichTextContent4 = (IGProMVPRichTextContent) obj4;
                        if (iGProMVPRichTextContent4 != null && (urlContent4 = iGProMVPRichTextContent4.getUrlContent()) != null && (thirdShareInfo2 = urlContent4.getThirdShareInfo()) != null) {
                            str5 = thirdShareInfo2.getImageUrl();
                            if (str5 == null) {
                                str5 = "";
                            }
                            h16 = com.tencent.mobileqq.guild.discoveryv2.util.e.h(str5, 205, 222);
                            Result.Companion companion14 = Result.INSTANCE;
                            if (h16 != null && h16.getMediaRawSize().getWidth() != 0) {
                                f27 = h16.getMediaRawSize().getHeight() / h16.getMediaRawSize().getWidth();
                                m476constructorimpl7 = Result.m476constructorimpl(Float.valueOf(f27));
                                Float valueOf8 = Float.valueOf(1.0f);
                                if (Result.m482isFailureimpl(m476constructorimpl7)) {
                                    m476constructorimpl7 = valueOf8;
                                }
                                coerceIn7 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl7).floatValue(), 1.0f, 1.25f);
                                hVar2.setMediaRatio(coerceIn7);
                                recommendAbsFeedData = new RecommendThirdShareLinkData(iGProContentRecommendFeed2, h16, hVar2, recommendExtData);
                                i3 = 3;
                                str2 = "videos";
                                str3 = "richText.contents";
                                hVar = hVar2;
                                break;
                            }
                            f27 = 1.0f;
                            m476constructorimpl7 = Result.m476constructorimpl(Float.valueOf(f27));
                            Float valueOf82 = Float.valueOf(1.0f);
                            if (Result.m482isFailureimpl(m476constructorimpl7)) {
                            }
                            coerceIn7 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl7).floatValue(), 1.0f, 1.25f);
                            hVar2.setMediaRatio(coerceIn7);
                            recommendAbsFeedData = new RecommendThirdShareLinkData(iGProContentRecommendFeed2, h16, hVar2, recommendExtData);
                            i3 = 3;
                            str2 = "videos";
                            str3 = "richText.contents";
                            hVar = hVar2;
                        }
                    }
                    str5 = null;
                    if (str5 == null) {
                    }
                    h16 = com.tencent.mobileqq.guild.discoveryv2.util.e.h(str5, 205, 222);
                    Result.Companion companion142 = Result.INSTANCE;
                    if (h16 != null) {
                        f27 = h16.getMediaRawSize().getHeight() / h16.getMediaRawSize().getWidth();
                        m476constructorimpl7 = Result.m476constructorimpl(Float.valueOf(f27));
                        Float valueOf822 = Float.valueOf(1.0f);
                        if (Result.m482isFailureimpl(m476constructorimpl7)) {
                        }
                        coerceIn7 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl7).floatValue(), 1.0f, 1.25f);
                        hVar2.setMediaRatio(coerceIn7);
                        recommendAbsFeedData = new RecommendThirdShareLinkData(iGProContentRecommendFeed2, h16, hVar2, recommendExtData);
                        i3 = 3;
                        str2 = "videos";
                        str3 = "richText.contents";
                        hVar = hVar2;
                    }
                    f27 = 1.0f;
                    m476constructorimpl7 = Result.m476constructorimpl(Float.valueOf(f27));
                    Float valueOf8222 = Float.valueOf(1.0f);
                    if (Result.m482isFailureimpl(m476constructorimpl7)) {
                    }
                    coerceIn7 = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl7).floatValue(), 1.0f, 1.25f);
                    hVar2.setMediaRatio(coerceIn7);
                    recommendAbsFeedData = new RecommendThirdShareLinkData(iGProContentRecommendFeed2, h16, hVar2, recommendExtData);
                    i3 = 3;
                    str2 = "videos";
                    str3 = "richText.contents";
                    hVar = hVar2;
                    break;
            }
            iGProContentRecommendFeed = iGProContentRecommendFeedsGuild.getFeeds().get(1);
            if (iGProContentRecommendFeed != null) {
                switch (iGProContentRecommendFeed.getFeedContentType()) {
                    case 1:
                        if (com.tencent.mobileqq.guild.discoveryv2.util.e.e(iGProContentRecommendFeed)) {
                            IGProImage customCover2 = iGProContentRecommendFeed.getCustomCover();
                            Intrinsics.checkNotNullExpressionValue(customCover2, "customCover");
                            recommendAbsFeedData2 = new RecommendPicMixData(iGProContentRecommendFeed, com.tencent.mobileqq.guild.discoveryv2.util.e.g(customCover2), hVar, recommendExtData);
                            break;
                        } else {
                            recommendAbsFeedData2 = new RecommendFeedTextData(iGProContentRecommendFeed, hVar, recommendExtData);
                            break;
                        }
                    case 2:
                        IGProImage a18 = com.tencent.mobileqq.guild.discoveryv2.util.e.a(iGProContentRecommendFeed);
                        if (a18 == null) {
                            a18 = iGProContentRecommendFeed.getImage();
                        }
                        Intrinsics.checkNotNullExpressionValue(a18, "customCoverOrNull() ?: image");
                        recommendAbsFeedData2 = new RecommendPicMixData(iGProContentRecommendFeed, com.tencent.mobileqq.guild.discoveryv2.util.e.g(a18), hVar, recommendExtData);
                        break;
                    case 3:
                        ArrayList<IGProVideo> videos2 = iGProContentRecommendFeed.getVideos();
                        Intrinsics.checkNotNullExpressionValue(videos2, str2);
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) videos2);
                        IGProVideo iGProVideo2 = (IGProVideo) firstOrNull;
                        if (iGProVideo2 == null || (image = iGProVideo2.getCover()) == null) {
                            image = iGProContentRecommendFeed.getImage();
                        }
                        Intrinsics.checkNotNullExpressionValue(image, "video?.cover ?: image");
                        recommendAbsFeedData2 = new RecommendVideoMixData(iGProContentRecommendFeed, com.tencent.mobileqq.guild.discoveryv2.util.e.g(image), iGProVideo2 != null ? com.tencent.mobileqq.guild.discoveryv2.util.e.i(iGProVideo2) : null, hVar, recommendExtData);
                        break;
                    case 4:
                        ArrayList<IGProMVPRichTextContent> contents4 = iGProContentRecommendFeed.getRichText().getContents();
                        Intrinsics.checkNotNullExpressionValue(contents4, str3);
                        Iterator<T> it6 = contents4.iterator();
                        while (true) {
                            if (it6.hasNext()) {
                                obj = it6.next();
                                IGProMVPRichTextContent iGProMVPRichTextContent5 = (IGProMVPRichTextContent) obj;
                                if (iGProMVPRichTextContent5.getType() == i3) {
                                    IGProMVPURLContent urlContent6 = iGProMVPRichTextContent5.getUrlContent();
                                    if (!TextUtils.isEmpty((urlContent6 == null || (thirdVideoInfo2 = urlContent6.getThirdVideoInfo()) == null) ? null : thirdVideoInfo2.getCover())) {
                                        z16 = true;
                                        if (!z16) {
                                        }
                                    }
                                }
                                z16 = false;
                                if (!z16) {
                                }
                            } else {
                                obj = null;
                            }
                        }
                        IGProMVPRichTextContent iGProMVPRichTextContent6 = (IGProMVPRichTextContent) obj;
                        String cover2 = (iGProMVPRichTextContent6 == null || (urlContent = iGProMVPRichTextContent6.getUrlContent()) == null || (thirdVideoInfo = urlContent.getThirdVideoInfo()) == null) ? null : thirdVideoInfo.getCover();
                        String b18 = com.tencent.mobileqq.guild.discoveryv2.util.e.b(iGProContentRecommendFeed);
                        isBlank = StringsKt__StringsJVMKt.isBlank(b18);
                        if (!(!isBlank)) {
                            b18 = null;
                        }
                        if (b18 != null) {
                            str = b18;
                        } else if (cover2 != null) {
                            str = cover2;
                        }
                        recommendAbsFeedData2 = new RecommendThirdVideoData(iGProContentRecommendFeed, com.tencent.mobileqq.guild.discoveryv2.util.e.h(str, 400, 300), hVar, recommendExtData);
                        break;
                    case 5:
                        com.tencent.mobileqq.guild.discoveryv2.util.e.h("", 200, 205);
                        recommendAbsFeedData2 = new RecommendFileData(iGProContentRecommendFeed, hVar, recommendExtData);
                        break;
                    case 6:
                        IGProMVPRichText richText2 = iGProContentRecommendFeed.getRichText();
                        if (richText2 != null && (contents = richText2.getContents()) != null) {
                            Iterator<T> it7 = contents.iterator();
                            while (true) {
                                if (it7.hasNext()) {
                                    obj2 = it7.next();
                                    IGProMVPRichTextContent iGProMVPRichTextContent7 = (IGProMVPRichTextContent) obj2;
                                    if (iGProMVPRichTextContent7.getType() == i3 && iGProMVPRichTextContent7.getUrlContent().getType() == 6) {
                                    }
                                } else {
                                    obj2 = null;
                                }
                            }
                            IGProMVPRichTextContent iGProMVPRichTextContent8 = (IGProMVPRichTextContent) obj2;
                            if (iGProMVPRichTextContent8 != null && (urlContent2 = iGProMVPRichTextContent8.getUrlContent()) != null && (thirdShareInfo = urlContent2.getThirdShareInfo()) != null) {
                                str4 = thirdShareInfo.getImageUrl();
                                recommendAbsFeedData2 = new RecommendThirdShareLinkData(iGProContentRecommendFeed, com.tencent.mobileqq.guild.discoveryv2.util.e.h(str4 != null ? str4 : "", 205, 222), hVar, recommendExtData);
                                break;
                            }
                        }
                        str4 = null;
                        recommendAbsFeedData2 = new RecommendThirdShareLinkData(iGProContentRecommendFeed, com.tencent.mobileqq.guild.discoveryv2.util.e.h(str4 != null ? str4 : "", 205, 222), hVar, recommendExtData);
                        break;
                }
                if ((recommendAbsFeedData instanceof RecommendFeedTextData) || !(recommendAbsFeedData2 instanceof RecommendFeedTextData)) {
                    c16 = 0;
                } else {
                    c16 = 0;
                    hVar.a(0);
                }
                if (recommendAbsFeedData == null && recommendAbsFeedData2 != null) {
                    RecommendAbsFeedData[] recommendAbsFeedDataArr = new RecommendAbsFeedData[2];
                    recommendAbsFeedDataArr[c16] = recommendAbsFeedData;
                    recommendAbsFeedDataArr[1] = recommendAbsFeedData2;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) recommendAbsFeedDataArr);
                    return new RecommendFeedsGuildData(iGProContentRecommendFeedsGuild, recommendExtData, listOf, hVar, 0L, 16, null);
                }
                QLog.i("newRecommendFeedsGuildData", 1, "error data " + iGProContentRecommendFeedsGuild);
                return null;
            }
            recommendAbsFeedData2 = null;
            if (recommendAbsFeedData instanceof RecommendFeedTextData) {
            }
            c16 = 0;
            if (recommendAbsFeedData == null) {
            }
            QLog.i("newRecommendFeedsGuildData", 1, "error data " + iGProContentRecommendFeedsGuild);
            return null;
        }
        i3 = 3;
        str2 = "videos";
        str3 = "richText.contents";
        hVar = hVar2;
        recommendAbsFeedData = null;
        iGProContentRecommendFeed = iGProContentRecommendFeedsGuild.getFeeds().get(1);
        if (iGProContentRecommendFeed != null) {
        }
        recommendAbsFeedData2 = null;
        if (recommendAbsFeedData instanceof RecommendFeedTextData) {
        }
        c16 = 0;
        if (recommendAbsFeedData == null) {
        }
        QLog.i("newRecommendFeedsGuildData", 1, "error data " + iGProContentRecommendFeedsGuild);
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0035. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[LOOP:1: B:70:0x0149->B:101:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017b A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final com.tencent.mobileqq.guild.discoveryv2.content.base.h d(@NotNull IGProRecommendContentItem iGProRecommendContentItem, @NotNull RecommendExtData baseExt) {
        Object m476constructorimpl;
        com.tencent.mobileqq.guild.discoveryv2.content.base.h pVar;
        com.tencent.mobileqq.guild.discoveryv2.content.base.h recommendFeedTextData;
        Object firstOrNull;
        IGProImage image;
        GProStVideo gProStVideo;
        Object obj;
        String str;
        boolean isBlank;
        IGProMVPURLContent urlContent;
        IGProMVPThirdVideoInfo thirdVideoInfo;
        boolean z16;
        String str2;
        IGProMVPThirdVideoInfo thirdVideoInfo2;
        ArrayList<IGProMVPRichTextContent> contents;
        Object obj2;
        IGProMVPURLContent urlContent2;
        IGProMVPCommThirdShareInfo thirdShareInfo;
        boolean z17;
        Intrinsics.checkNotNullParameter(iGProRecommendContentItem, "<this>");
        Intrinsics.checkNotNullParameter(baseExt, "baseExt");
        IGProExtra extra = iGProRecommendContentItem.getExtra();
        byte[] tianShuAdItem = iGProRecommendContentItem.getTianShuAdItem();
        Intrinsics.checkNotNullExpressionValue(tianShuAdItem, "tianShuAdItem");
        RecommendExtData b16 = RecommendExtData.b(baseExt, null, 0, extra, tianShuAdItem, 0, 19, null);
        int itemType = iGProRecommendContentItem.getItemType();
        Object obj3 = null;
        if (itemType != 16) {
            if (itemType != 18) {
                switch (itemType) {
                    case 1:
                        IGProContentRecommendFeed feed = iGProRecommendContentItem.getFeed();
                        Intrinsics.checkNotNullExpressionValue(feed, "feed");
                        String str3 = "";
                        switch (feed.getFeedContentType()) {
                            case 1:
                                if (com.tencent.mobileqq.guild.discoveryv2.util.e.e(feed)) {
                                    IGProImage customCover = feed.getCustomCover();
                                    Intrinsics.checkNotNullExpressionValue(customCover, "customCover");
                                    k g16 = com.tencent.mobileqq.guild.discoveryv2.util.e.g(customCover);
                                    recommendFeedTextData = new RecommendPicMixData(feed, g16, com.tencent.mobileqq.guild.discoveryv2.util.e.f(g16), b16);
                                    break;
                                } else {
                                    recommendFeedTextData = new RecommendFeedTextData(feed, com.tencent.mobileqq.guild.discoveryv2.util.e.f(null), b16);
                                    break;
                                }
                            case 2:
                                IGProImage a16 = com.tencent.mobileqq.guild.discoveryv2.util.e.a(feed);
                                if (a16 == null) {
                                    a16 = feed.getImage();
                                }
                                Intrinsics.checkNotNullExpressionValue(a16, "customCoverOrNull() ?: image");
                                k g17 = com.tencent.mobileqq.guild.discoveryv2.util.e.g(a16);
                                recommendFeedTextData = new RecommendPicMixData(feed, g17, com.tencent.mobileqq.guild.discoveryv2.util.e.f(g17), b16);
                                break;
                            case 3:
                                ArrayList<IGProVideo> videos = feed.getVideos();
                                Intrinsics.checkNotNullExpressionValue(videos, "videos");
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) videos);
                                IGProVideo iGProVideo = (IGProVideo) firstOrNull;
                                if (iGProVideo == null || (image = iGProVideo.getCover()) == null) {
                                    image = feed.getImage();
                                }
                                Intrinsics.checkNotNullExpressionValue(image, "video?.cover ?: image");
                                k g18 = com.tencent.mobileqq.guild.discoveryv2.util.e.g(image);
                                if (iGProVideo != null) {
                                    gProStVideo = com.tencent.mobileqq.guild.discoveryv2.util.e.i(iGProVideo);
                                } else {
                                    gProStVideo = null;
                                }
                                pVar = new RecommendVideoMixData(feed, g18, gProStVideo, com.tencent.mobileqq.guild.discoveryv2.util.e.f(g18), b16);
                                break;
                            case 4:
                                ArrayList<IGProMVPRichTextContent> contents2 = feed.getRichText().getContents();
                                Intrinsics.checkNotNullExpressionValue(contents2, "richText.contents");
                                Iterator<T> it = contents2.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        obj = it.next();
                                        IGProMVPRichTextContent iGProMVPRichTextContent = (IGProMVPRichTextContent) obj;
                                        if (iGProMVPRichTextContent.getType() == 3) {
                                            IGProMVPURLContent urlContent3 = iGProMVPRichTextContent.getUrlContent();
                                            if (urlContent3 != null && (thirdVideoInfo2 = urlContent3.getThirdVideoInfo()) != null) {
                                                str2 = thirdVideoInfo2.getCover();
                                            } else {
                                                str2 = null;
                                            }
                                            if (!TextUtils.isEmpty(str2)) {
                                                z16 = true;
                                                if (!z16) {
                                                }
                                            }
                                        }
                                        z16 = false;
                                        if (!z16) {
                                        }
                                    } else {
                                        obj = null;
                                    }
                                }
                                IGProMVPRichTextContent iGProMVPRichTextContent2 = (IGProMVPRichTextContent) obj;
                                if (iGProMVPRichTextContent2 != null && (urlContent = iGProMVPRichTextContent2.getUrlContent()) != null && (thirdVideoInfo = urlContent.getThirdVideoInfo()) != null) {
                                    str = thirdVideoInfo.getCover();
                                } else {
                                    str = null;
                                }
                                String b17 = com.tencent.mobileqq.guild.discoveryv2.util.e.b(feed);
                                isBlank = StringsKt__StringsJVMKt.isBlank(b17);
                                if (!isBlank) {
                                    obj3 = b17;
                                }
                                if (obj3 == null) {
                                    if (str != null) {
                                        str3 = str;
                                    }
                                } else {
                                    str3 = obj3;
                                }
                                k h16 = com.tencent.mobileqq.guild.discoveryv2.util.e.h(str3, 400, 300);
                                recommendFeedTextData = new RecommendThirdVideoData(feed, h16, com.tencent.mobileqq.guild.discoveryv2.util.e.f(h16), b16);
                                break;
                            case 5:
                                return new RecommendFileData(feed, com.tencent.mobileqq.guild.discoveryv2.util.e.f(com.tencent.mobileqq.guild.discoveryv2.util.e.h("", 200, 205)), b16);
                            case 6:
                                IGProMVPRichText richText = feed.getRichText();
                                if (richText != null && (contents = richText.getContents()) != null) {
                                    Iterator<T> it5 = contents.iterator();
                                    while (true) {
                                        if (it5.hasNext()) {
                                            obj2 = it5.next();
                                            IGProMVPRichTextContent iGProMVPRichTextContent3 = (IGProMVPRichTextContent) obj2;
                                            if (iGProMVPRichTextContent3.getType() == 3 && iGProMVPRichTextContent3.getUrlContent().getType() == 6) {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            if (z17) {
                                            }
                                        } else {
                                            obj2 = null;
                                        }
                                    }
                                    IGProMVPRichTextContent iGProMVPRichTextContent4 = (IGProMVPRichTextContent) obj2;
                                    if (iGProMVPRichTextContent4 != null && (urlContent2 = iGProMVPRichTextContent4.getUrlContent()) != null && (thirdShareInfo = urlContent2.getThirdShareInfo()) != null) {
                                        obj3 = thirdShareInfo.getImageUrl();
                                    }
                                }
                                if (obj3 != null) {
                                    str3 = obj3;
                                }
                                k h17 = com.tencent.mobileqq.guild.discoveryv2.util.e.h(str3, 205, 222);
                                recommendFeedTextData = new RecommendThirdShareLinkData(feed, h17, com.tencent.mobileqq.guild.discoveryv2.util.e.f(h17), b16);
                                break;
                            default:
                                return null;
                        }
                        return recommendFeedTextData;
                    case 2:
                        if (iGProRecommendContentItem.getRobot().getType() == 0) {
                            pVar = new RecommendRobotData(iGProRecommendContentItem, b16);
                            break;
                        } else {
                            pVar = new RecommendRobotData(iGProRecommendContentItem, b16);
                            break;
                        }
                    case 3:
                        return new RecommendGroupData(iGProRecommendContentItem, b16);
                    case 4:
                        return new RecommendHotLiveData(iGProRecommendContentItem, b16);
                    case 5:
                        return new RecommendSelectedGuildData(iGProRecommendContentItem, b16);
                    case 6:
                        return new RecommendGuildData(iGProRecommendContentItem, b16);
                    case 7:
                        return new RecommendLiveData(iGProRecommendContentItem, b16);
                    case 8:
                        if (iGProRecommendContentItem.getContentRecommendVoice().getThemeType() == 7) {
                            pVar = new RecommendScreenShareData(iGProRecommendContentItem, b16);
                            break;
                        } else {
                            pVar = new RecommendVoiceData(iGProRecommendContentItem, b16);
                            break;
                        }
                    case 9:
                        return new RecommendSchemeData(iGProRecommendContentItem, b16);
                    case 10:
                        return new RecommendFeedTopicData(iGProRecommendContentItem, b16);
                    case 11:
                        IGProContentRecommendFeedsGuild feedsGuild = iGProRecommendContentItem.getFeedsGuild();
                        Intrinsics.checkNotNullExpressionValue(feedsGuild, "this.feedsGuild");
                        return c(feedsGuild, b16);
                    default:
                        return null;
                }
            } else {
                IGProContentRecommendOneToOne oneToOne = iGProRecommendContentItem.getOneToOne();
                Intrinsics.checkNotNullExpressionValue(oneToOne, "this.oneToOne");
                return RecommendDataKt.b(oneToOne, b16);
            }
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(new GdtAd(new qq_ad_get.QQAdGetRsp.AdInfo().mergeFrom(iGProRecommendContentItem.getAdFeedModel())));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl == null) {
                obj3 = m476constructorimpl;
            } else if (QLog.isDebugVersion()) {
                throw m479exceptionOrNullimpl;
            }
            pVar = new p((GdtAd) obj3, iGProRecommendContentItem, b16);
        }
        return pVar;
    }
}
