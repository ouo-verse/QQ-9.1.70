package com.qzone.reborn.message.data;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGiftInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.feedx.util.n;
import com.qzone.reborn.util.r;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.QZoneHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0006H\u0002J\f\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\u0011*\u0004\u0018\u00010\u0002H\u0002J\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$2\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010'\u001a\u00020\u0006*\u0004\u0018\u00010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010)R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010)\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/message/data/QZonePassiveMessageFeedPreprocessor;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/CellLeftThumb;", "p", "", "summaryText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "leftThumb", h.F, "url", "a", "", "i", "", "r", DomainData.DOMAIN_NAME, "Lcom/qzone/proxy/feedcomponent/model/CellGiftInfo;", "Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", "t", "o", "b", "g", "text", "convertToNormalText", "k", ReportConstant.COSTREPORT_PREFIX, "", "e", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)Ljava/lang/Integer;", "d", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "Lkotlin/collections/ArrayList;", "f", "Lcom/qzone/proxy/feedcomponent/model/CellSummary;", "c", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "AT_USER_REGEX", "URL_REGEX", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageFeedPreprocessor {

    /* renamed from: a, reason: collision with root package name */
    public static final QZonePassiveMessageFeedPreprocessor f58250a = new QZonePassiveMessageFeedPreprocessor();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Regex AT_USER_REGEX = new Regex("@\\{uin:\\d+,nick:[^}]*\\}");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Regex URL_REGEX = new Regex("\\n?\\{url:.*,text:\\s?\u7acb\u5373\u8bbe\u7f6e\\}");

    QZonePassiveMessageFeedPreprocessor() {
    }

    private final CellLeftThumb a(BusinessFeedData feedData, String url) {
        CellLeftThumb cellLeftThumb = new CellLeftThumb();
        cellLeftThumb.setActionType(feedData.getFeedCommInfoV2().actiontype);
        cellLeftThumb.setActionUrl(feedData.getFeedCommInfoV2().actionurl);
        if (url.length() > 0) {
            PictureItem pictureItem = new PictureItem();
            pictureItem.currentUrl = new PictureUrl(url, 0, 0);
            cellLeftThumb.setPictureItem(pictureItem);
        }
        return cellLeftThumb;
    }

    private final String h(CellLeftThumb leftThumb) {
        String substringBefore;
        String str = "@{uin:" + LoginData.getInstance().getUinString() + ",nick:" + LoginData.getInstance().getNickName("") + "}";
        substringBefore = StringsKt__StringsKt.substringBefore(d(leftThumb), " \u8f6c\u81ea " + str + "\uff1a", "");
        return substringBefore;
    }

    private final boolean i(BusinessFeedData businessFeedData) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean z16;
        String oriSummary = n.e(businessFeedData);
        Intrinsics.checkNotNullExpressionValue(oriSummary, "oriSummary");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(oriSummary, "[em]e10038[/em]", false, 2, null);
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(oriSummary, "[em]e10035[/em] \u63d0\u5230\u6211", false, 2, null);
        if (startsWith$default2) {
            if (h(businessFeedData.getLeftThumb()).length() > 0) {
                z16 = true;
                return !startsWith$default || z16;
            }
        }
        z16 = false;
        if (startsWith$default) {
        }
    }

    private final String m(BusinessFeedData feedData, String summaryText) {
        String str;
        if (f.f58260a.g(feedData)) {
            str = "\u8bc4\u8bba\u4e86\u76f8\u518c\uff1a";
        } else if (feedData.isBlogFeed()) {
            str = "\u8bc4\u8bba\u4e86\u65e5\u5fd7\uff1a";
        } else {
            str = "";
        }
        return str + summaryText;
    }

    private final void n(BusinessFeedData businessFeedData) {
        CellDecorateInfo.CellCustomPraise cellCustomPraise;
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        String str = null;
        String str2 = cellSummaryV2 != null ? cellSummaryV2.customPraiseStr : null;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        CellDecorateInfo cellDecorateInfo = businessFeedData.cellDecorateInfo;
        if (cellDecorateInfo != null && (cellCustomPraise = cellDecorateInfo.cellCustomPraise) != null) {
            str = cellCustomPraise.strPraisePic;
        }
        if (str == null) {
            return;
        }
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            CellSummary cellSummaryV22 = businessFeedData.getCellSummaryV2();
            if (cellSummaryV22 == null) {
                return;
            }
            r rVar = r.f59560a;
            cellSummaryV22.customPraiseStr = "{img:" + encode + ",w:" + rVar.e(16) + ",h:" + rVar.e(16) + "}";
        } catch (Exception e16) {
            e16.printStackTrace();
            CellSummary cellSummaryV23 = businessFeedData.getCellSummaryV2();
            if (cellSummaryV23 == null) {
                return;
            }
            r rVar2 = r.f59560a;
            cellSummaryV23.customPraiseStr = "{img:" + str + ",w:" + rVar2.e(16) + ",h:" + rVar2.e(16) + "}";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r3 == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CellLeftThumb p(BusinessFeedData feedData) {
        boolean z16;
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        String str;
        boolean startsWith$default;
        CellLeftThumb b16 = b(feedData);
        if (b16 != null && (pictureItem = b16.getPictureItem()) != null && (pictureUrl = pictureItem.currentUrl) != null && (str = pictureUrl.url) != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "https://qzonestyle.gtimg.cn/aoi/img/photo/anp.jpg", false, 2, null);
            z16 = true;
        }
        z16 = false;
        if (z16) {
            PictureItem pictureItem2 = b16.getPictureItem();
            PictureUrl pictureUrl2 = pictureItem2 != null ? pictureItem2.currentUrl : null;
            if (pictureUrl2 != null) {
                pictureUrl2.url = "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/photo_library.png";
            }
            PictureItem pictureItem3 = b16.getPictureItem();
            PictureUrl pictureUrl3 = pictureItem3 != null ? pictureItem3.bigUrl : null;
            if (pictureUrl3 != null) {
                pictureUrl3.url = "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/photo_library.png";
            }
            PictureItem pictureItem4 = b16.getPictureItem();
            PictureUrl pictureUrl4 = pictureItem4 != null ? pictureItem4.downloadUrl : null;
            if (pictureUrl4 != null) {
                pictureUrl4.url = "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/photo_library.png";
            }
        }
        f fVar = f.f58260a;
        if (fVar.m(feedData) && b16 == null) {
            b16 = a(feedData, "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/liuyan.png");
        }
        if (fVar.y(feedData) && b16 != null) {
            PictureItem pictureItem5 = new PictureItem();
            pictureItem5.currentUrl = new PictureUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/news/qiugengxin.png", 0, 0);
            b16.setPictureItem(pictureItem5);
        }
        if (fVar.j(feedData) && b16 == null) {
            b16 = a(feedData, "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/daka.png");
        }
        return b16 == null ? a(feedData, "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/kongjianxiaoxi.png") : b16;
    }

    private final String q(BusinessFeedData feedData, String summaryText) {
        String substringAfter$default;
        boolean startsWith$default;
        boolean startsWith$default2;
        String substringAfter$default2;
        String replace$default;
        String replace$default2;
        substringAfter$default = StringsKt__StringsKt.substringAfter$default(summaryText, "[em]e10037[/em] ", (String) null, 2, (Object) null);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(substringAfter$default, "\u8d5e\u4e86\u6211\u7684\u8bc4\u8bba", false, 2, null);
        if (startsWith$default) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(substringAfter$default, "\u8d5e\u4e86\u6211\u7684\u8bc4\u8bba", "\u8d5e\u4e86\u8bc4\u8bba", false, 4, (Object) null);
            return replace$default2;
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(substringAfter$default, "\u8d5e\u4e86\u6211\u7684\u56de\u590d", false, 2, null);
        if (startsWith$default2) {
            replace$default = StringsKt__StringsJVMKt.replace$default(substringAfter$default, "\u8d5e\u4e86\u6211\u7684\u56de\u590d", "\u8d5e\u4e86\u56de\u590d", false, 4, (Object) null);
            return replace$default;
        }
        f fVar = f.f58260a;
        if (fVar.g(feedData)) {
            return "\u8d5e\u4e86\u76f8\u518c";
        }
        if (feedData.isBlogFeed()) {
            return "\u8d5e\u4e86\u65e5\u5fd7";
        }
        if (!fVar.n(feedData)) {
            substringAfter$default2 = StringsKt__StringsKt.substringAfter$default(summaryText, "[em]e10037[/em] ", (String) null, 2, (Object) null);
            return substringAfter$default2;
        }
        return "";
    }

    public final CellLeftThumb b(BusinessFeedData feedData) {
        ArrayList<PictureItem> arrayList;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        CellLeftThumb leftThumb = feedData.getLeftThumb();
        CellGiftInfo giftInfo = feedData.getGiftInfo();
        if (giftInfo != null && !TextUtils.isEmpty(giftInfo.smallGiftUrl)) {
            if (leftThumb == null) {
                leftThumb = new CellLeftThumb();
            }
            leftThumb.setSummary(giftInfo.giftDesc);
            if (TextUtils.isEmpty(leftThumb.getSummary())) {
                leftThumb.setSummary(giftInfo.giftName);
            }
            CellPictureInfo t16 = t(giftInfo);
            CellPictureInfo pictureInfo = feedData.getPictureInfo();
            if ((pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.isEmpty()) ? false : true) {
                leftThumb.setPictureItem(feedData.getPictureInfo().pics.get(0));
            } else if (t16 != null) {
                leftThumb.setPictureItem(t16.pics.get(0));
            }
            leftThumb.setActionType(giftInfo.actionType);
            leftThumb.setActionUrl(giftInfo.actionUrl);
            leftThumb.isPassive = true;
        }
        if (leftThumb != null) {
            return leftThumb;
        }
        BusinessFeedData originalInfo = feedData.getOriginalInfo();
        if ((originalInfo != null ? originalInfo.getLeftThumb() : null) == null) {
            return leftThumb;
        }
        BusinessFeedData originalInfo2 = feedData.getOriginalInfo();
        if (originalInfo2 != null) {
            return originalInfo2.getLeftThumb();
        }
        return null;
    }

    public final String c(CellSummary cellSummary) {
        Map<String, String> map;
        if (((cellSummary == null || (map = cellSummary.mapExt) == null) ? null : map.get("guide_text")) == null || cellSummary.barrageEffectInfo == null) {
            return "";
        }
        String str = cellSummary.mapExt.get("guide_text");
        String replace$default = str != null ? StringsKt__StringsJVMKt.replace$default(str, "{id}", String.valueOf(cellSummary.barrageEffectInfo.f51896id), false, 4, (Object) null) : null;
        return replace$default == null ? "" : replace$default;
    }

    public final String d(CellLeftThumb leftThumb) {
        String displayText;
        String displayText2;
        String displayText3 = "";
        if (leftThumb == null) {
            return "";
        }
        String str = leftThumb.title;
        if (!(str == null || str.length() == 0)) {
            displayText3 = leftThumb.title;
        } else {
            String summary = leftThumb.getSummary();
            if (!(summary == null || summary.length() == 0)) {
                displayText3 = leftThumb.getSummary();
            }
        }
        Intrinsics.checkNotNullExpressionValue(displayText3, "displayText");
        displayText = StringsKt__StringsKt.removePrefix(displayText3, (CharSequence) ":");
        Intrinsics.checkNotNullExpressionValue(displayText, "displayText");
        displayText2 = StringsKt__StringsKt.removePrefix(displayText, (CharSequence) "\uff1a");
        Intrinsics.checkNotNullExpressionValue(displayText2, "displayText");
        return displayText2;
    }

    public final Integer e(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        f fVar = f.f58260a;
        if (fVar.w(feedData)) {
            return Integer.valueOf(R.drawable.qui_like_qzone);
        }
        if (fVar.v(feedData)) {
            return Integer.valueOf(R.drawable.qui_highfive_testing);
        }
        if (i(feedData)) {
            return Integer.valueOf(R.drawable.qui_share_qzone);
        }
        return null;
    }

    public final ArrayList<PictureItem> f(BusinessFeedData feedData) {
        CellPictureInfo pictureInfo;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        CellSummary cellSummaryV2 = feedData.getCellSummaryV2();
        ArrayList<PictureItem> arrayList = null;
        if ((cellSummaryV2 != null ? cellSummaryV2.summarypic : null) != null) {
            ArrayList<PictureItem> arrayList2 = feedData.getCellSummaryV2().summarypic;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "feedData.cellSummaryV2.summarypic");
            return arrayList2;
        }
        CellPictureInfo pictureInfo2 = feedData.getPictureInfo();
        if ((pictureInfo2 != null ? pictureInfo2.pics : null) != null) {
            ArrayList<PictureItem> arrayList3 = feedData.getPictureInfo().pics;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "feedData.pictureInfo.pics");
            return arrayList3;
        }
        BusinessFeedData originalInfo = feedData.getOriginalInfo();
        if (originalInfo != null && (pictureInfo = originalInfo.getPictureInfo()) != null) {
            arrayList = pictureInfo.pics;
        }
        if (arrayList != null) {
            ArrayList<PictureItem> arrayList4 = feedData.getOriginalInfo().getPictureInfo().pics;
            Intrinsics.checkNotNullExpressionValue(arrayList4, "feedData.originalInfo.pictureInfo.pics");
            return arrayList4;
        }
        return new ArrayList<>();
    }

    public final String g(BusinessFeedData feedData) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String substringAfter$default;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        String e16 = n.e(feedData);
        if (e16 == null) {
            return "";
        }
        CellSummary cellSummaryV2 = feedData.getCellSummaryV2();
        String str = cellSummaryV2 != null ? cellSummaryV2.customPraiseStr : null;
        if (!(str == null || str.length() == 0)) {
            e16 = str + e16;
        }
        f fVar = f.f58260a;
        if (fVar.w(feedData)) {
            e16 = q(feedData, e16);
        } else if (fVar.v(feedData)) {
            e16 = StringsKt__StringsKt.substringAfter$default(e16, "[em]e10071[/em]", (String) null, 2, (Object) null);
        } else {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(e16, "[em]e10038[/em]", false, 2, null);
            if (startsWith$default) {
                substringAfter$default = StringsKt__StringsKt.substringAfter$default(e16, "[em]e10038[/em]", (String) null, 2, (Object) null);
                e16 = StringsKt__StringsKt.removePrefix(substringAfter$default, (CharSequence) " ");
            } else {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(e16, "[em]e10035[/em] \u63d0\u5230\u6211", false, 2, null);
                if (startsWith$default2) {
                    e16 = j(feedData, e16);
                } else if (fVar.k(feedData)) {
                    e16 = m(feedData, e16);
                }
            }
        }
        String l3 = l(this, e16, false, 2, null);
        if (fVar.f(feedData)) {
            l3 = s(l3 + c(feedData.getCellSummaryV2()));
        }
        CellFeedCommInfo feedCommInfoV2 = feedData.getFeedCommInfoV2();
        return ((feedCommInfoV2 != null && feedCommInfoV2.appid == 333) || fVar.y(feedData) || fVar.r(feedData)) ? d(feedData.getLeftThumb()) : l3;
    }

    public final String k(String text, final boolean convertToNormalText) {
        Intrinsics.checkNotNullParameter(text, "text");
        return AT_USER_REGEX.replace(text, new Function1<MatchResult, CharSequence>() { // from class: com.qzone.reborn.message.data.QZonePassiveMessageFeedPreprocessor$preprocessAtPattern$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult it) {
                String substringBefore$default;
                String removePrefix;
                String substringAfter$default;
                String removeSuffix;
                Intrinsics.checkNotNullParameter(it, "it");
                substringBefore$default = StringsKt__StringsKt.substringBefore$default(it.getValue(), ",nick:", (String) null, 2, (Object) null);
                removePrefix = StringsKt__StringsKt.removePrefix(substringBefore$default, (CharSequence) "@{uin:");
                if (!convertToNormalText) {
                    if (Intrinsics.areEqual(removePrefix, LoginData.getInstance().getUinString())) {
                        return "@{uin:" + removePrefix + ",nick:\u6211}";
                    }
                    return it.getValue();
                }
                if (Intrinsics.areEqual(removePrefix, LoginData.getInstance().getUinString())) {
                    return "@\u6211";
                }
                substringAfter$default = StringsKt__StringsKt.substringAfter$default(it.getValue(), ",nick:", (String) null, 2, (Object) null);
                removeSuffix = StringsKt__StringsKt.removeSuffix(substringAfter$default, (CharSequence) "}");
                return "@" + removeSuffix;
            }
        });
    }

    public final BusinessFeedData o(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        feedData.setLeftThumb(p(feedData));
        n(feedData);
        r(feedData);
        return feedData;
    }

    public final String s(String summaryText) {
        Intrinsics.checkNotNullParameter(summaryText, "summaryText");
        return URL_REGEX.replace(summaryText, new Function1<MatchResult, CharSequence>() { // from class: com.qzone.reborn.message.data.QZonePassiveMessageFeedPreprocessor$preprocessSettingText$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult it) {
                String substringAfter$default;
                String substringBefore$default;
                Intrinsics.checkNotNullParameter(it, "it");
                substringAfter$default = StringsKt__StringsKt.substringAfter$default(it.getValue(), "{url:", (String) null, 2, (Object) null);
                substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfter$default, ",text:", (String) null, 2, (Object) null);
                return " {url:" + substringBefore$default + ",text:\u8bbe\u7f6e}";
            }
        });
    }

    private final String j(BusinessFeedData feedData, String summaryText) {
        boolean startsWith$default;
        String removePrefix;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(summaryText, "[em]e10035[/em] \u63d0\u5230\u6211: ", false, 2, null);
        if (startsWith$default) {
            removePrefix = StringsKt__StringsKt.removePrefix(summaryText, (CharSequence) "[em]e10035[/em] \u63d0\u5230\u6211: ");
            return removePrefix;
        }
        String h16 = h(feedData.getLeftThumb());
        if (h16.length() > 0) {
            return "\u8f6c\u53d1: " + h16;
        }
        return "@{uin:" + LoginData.getInstance().getUinString() + ",nick:\u6211}";
    }

    private final void r(BusinessFeedData businessFeedData) {
        if ((businessFeedData != null ? businessFeedData.getFeedCommInfoV2() : null) == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfoV2().appid != 202 && businessFeedData.getLeftThumb() != null && businessFeedData.getLeftThumb().getActionType() != businessFeedData.getFeedCommInfoV2().actiontype) {
            businessFeedData.getFeedCommInfoV2().actiontype = businessFeedData.getLeftThumb().getActionType();
            businessFeedData.getFeedCommInfoV2().actionurl = businessFeedData.getLeftThumb().getActionUrl();
        }
        if (businessFeedData.getFeedCommInfoV2().actiontype == 2) {
            String str = businessFeedData.getFeedCommInfoV2().actionurl;
            Intrinsics.checkNotNullExpressionValue(str, "feedCommInfoV2.actionurl");
            if (str.length() == 0) {
                businessFeedData.getFeedCommInfoV2().actiontype = 6;
                return;
            }
            if (Intrinsics.areEqual(businessFeedData.getFeedCommInfoV2().actionurl, QZoneHelper.SCHEME_OPEN_HOME_PAGE)) {
                long j3 = businessFeedData.getLeftThumb().user.uin;
                String uinString = LoginData.getInstance().getUinString();
                CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
                feedCommInfoV2.actionurl = feedCommInfoV2.actionurl + "?uin=" + j3 + "&from_uin=" + uinString;
            }
        }
    }

    private final CellPictureInfo t(CellGiftInfo cellGiftInfo) {
        if (cellGiftInfo == null || TextUtils.isEmpty(cellGiftInfo.smallGiftUrl)) {
            return null;
        }
        PictureItem pictureItem = new PictureItem();
        PictureUrl pictureUrl = new PictureUrl();
        pictureItem.bigUrl = pictureUrl;
        String str = cellGiftInfo.bigGitUrl;
        pictureUrl.url = str;
        if (TextUtils.isEmpty(str)) {
            pictureItem.bigUrl.url = cellGiftInfo.smallGiftUrl;
        }
        PictureUrl pictureUrl2 = new PictureUrl();
        pictureItem.currentUrl = pictureUrl2;
        pictureUrl2.url = cellGiftInfo.smallGiftUrl;
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        cellPictureInfo.pics = arrayList;
        arrayList.add(pictureItem);
        return cellPictureInfo;
    }

    public static /* synthetic */ String l(QZonePassiveMessageFeedPreprocessor qZonePassiveMessageFeedPreprocessor, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return qZonePassiveMessageFeedPreprocessor.k(str, z16);
    }
}
