package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchItemsKt {
    public static final String access$toPBToken(String str) {
        return str.hashCode() + Utils.INSTANCE.currentBridgeModule().getPagerId();
    }

    /* JADX WARN: Type inference failed for: r4v31, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v34, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v37, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v40, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
    public static final void setSerialNumber(ISearchItemModel iSearchItemModel, ArrayList<Integer> arrayList, ISearchItemModel iSearchItemModel2) {
        if (iSearchItemModel instanceof BaseSearchItemModel) {
            int intValue = arrayList.get(0).intValue();
            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("setSerialNumber:    currentIndex: ", intValue, KLog.INSTANCE, "SearchItems");
            BaseSearchItemModel baseSearchItemModel = (BaseSearchItemModel) iSearchItemModel;
            baseSearchItemModel.serialNumber = intValue;
            arrayList.set(0, Integer.valueOf(intValue + 1));
            if (iSearchItemModel instanceof SearchContactCardItemModel) {
                Iterator it = ((SearchContactCardItemModel) iSearchItemModel).contactList.iterator();
                while (it.hasNext()) {
                    ((SearchContactItemModel) it.next()).serialNumber = baseSearchItemModel.serialNumber;
                }
                return;
            }
            if (iSearchItemModel instanceof SearchTroopCardItemModel) {
                Iterator it5 = ((SearchTroopCardItemModel) iSearchItemModel).troopList.iterator();
                while (it5.hasNext()) {
                    ((SearchTroopItemModel) it5.next()).serialNumber = baseSearchItemModel.serialNumber;
                }
                return;
            }
            if (iSearchItemModel instanceof SearchMiniAppCardItemModel) {
                Iterator it6 = ((SearchMiniAppCardItemModel) iSearchItemModel).miniAppList.iterator();
                while (it6.hasNext()) {
                    ((SearchMiniAppItemModel) it6.next()).serialNumber = baseSearchItemModel.serialNumber;
                }
                return;
            }
            if (iSearchItemModel instanceof SearchGuildChannelCardItemModel) {
                Iterator it7 = ((SearchGuildChannelCardItemModel) iSearchItemModel).channelList.iterator();
                while (it7.hasNext()) {
                    ((SearchGuildChannelItemModel) it7.next()).serialNumber = baseSearchItemModel.serialNumber;
                }
                return;
            }
            return;
        }
        if (iSearchItemModel instanceof QSearchBaseTemplateModel) {
            if (iSearchItemModel2 instanceof QSearchBaseTemplateModel) {
                if (((QSearchBaseTemplateModel) iSearchItemModel2).reportInfo == null) {
                    arrayList.set(0, Integer.valueOf(arrayList.get(0).intValue() + 1));
                    return;
                }
                try {
                    QSearchTemplateReportInfo qSearchTemplateReportInfo = ((QSearchBaseTemplateModel) iSearchItemModel2).reportInfo;
                    Intrinsics.checkNotNull(qSearchTemplateReportInfo);
                    int j3 = new e(qSearchTemplateReportInfo.transferInfo).j(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID);
                    QSearchTemplateReportInfo qSearchTemplateReportInfo2 = ((QSearchBaseTemplateModel) iSearchItemModel).reportInfo;
                    Intrinsics.checkNotNull(qSearchTemplateReportInfo2);
                    int j16 = new e(qSearchTemplateReportInfo2.transferInfo).j(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID);
                    if (j16 != 7) {
                        switch (j16) {
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                                break;
                            default:
                                arrayList.set(0, Integer.valueOf(arrayList.get(0).intValue() + 1));
                                break;
                        }
                        return;
                    }
                    if (j16 != j3) {
                        arrayList.set(0, Integer.valueOf(arrayList.get(0).intValue() + 1));
                    }
                    return;
                } catch (Exception unused) {
                    arrayList.set(0, Integer.valueOf(arrayList.get(0).intValue() + 1));
                    return;
                }
            }
            arrayList.set(0, Integer.valueOf(arrayList.get(0).intValue() + 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v40, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v45, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v20, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchEmptyCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchRecommendGuideItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.AIPictureCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    public static final boolean parseContent(UnifySearchTabContent unifySearchTabContent) {
        ?? doubleVideoItemModel;
        e m3;
        boolean isBlank;
        ISearchItemModel iSearchItemModel;
        try {
            switch (unifySearchTabContent.layoutId) {
                case 1:
                    String str = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new DoubleVideoItemModel();
                    b bVar = new b(str);
                    int c16 = bVar.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        e l3 = bVar.l(i3);
                        if (l3 != null && (m3 = l3.m("feed")) != null) {
                            StFeed decode = new StFeed().decode(m3);
                            String p16 = l3.p("raw_data");
                            isBlank = StringsKt__StringsJVMKt.isBlank(p16);
                            if (!isBlank) {
                                ?? r85 = doubleVideoItemModel.dataList;
                                StFeedEx stFeedEx = new StFeedEx(decode, p16);
                                stFeedEx.loadFeedPB();
                                r85.add(stFeedEx);
                            }
                        }
                    }
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    break;
                case 2:
                    String str2 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new AIPictureCardItemModel();
                    e eVar = new e(str2);
                    doubleVideoItemModel.cardInfo = new AIPictureCardInfo(eVar.p("icon"), eVar.q("topic", "AI\u751f\u6210\u56fe\u7247"), eVar.p("prompt"), eVar.p("action_text"), eVar.p("action_url"), eVar.f("is_show"), eVar.q("loading_text", "AI\u6b63\u5728\u52aa\u529b\u521b\u4f5c\u4e2d\uff0c\u8bf7\u7b49\u5f85\u51e0\u79d2\u949f..."));
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    break;
                case 3:
                    BaseSearchItemModel create = SearchGuildBaseItemModel.Companion.create(unifySearchTabContent.layoutContent);
                    create.setExtension(unifySearchTabContent.extension);
                    iSearchItemModel = create;
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
                case 4:
                    String str3 = unifySearchTabContent.layoutContent;
                    ?? expressionCardItemModel = new ExpressionCardItemModel();
                    b bVar2 = new b(str3);
                    int min = Math.min(bVar2.c(), 4);
                    for (int i16 = 0; i16 < min; i16++) {
                        e l16 = bVar2.l(i16);
                        if (l16 != null) {
                            expressionCardItemModel.itemList.add(new ExpressionInfo(l16.q("md5", ""), l16.q("url", ""), l16.q("thumb_md5", ""), l16.q(FacadeCacheData.THUMB_URL, ""), l16.q("src_desc", ""), l16.q("src_pack_name", ""), l16.q("src_web_url", ""), l16.q("src_icon_url", ""), l16.q("img_other", "")));
                        }
                    }
                    expressionCardItemModel.setExtension(unifySearchTabContent.extension);
                    iSearchItemModel = expressionCardItemModel;
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
                case 5:
                case 16:
                case 17:
                default:
                    Utils.INSTANCE.logToNative("unknown layoutId: " + unifySearchTabContent.layoutId);
                    return false;
                case 6:
                    String str4 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new SearchContactCardItemModel();
                    b bVar3 = new b(str4);
                    int c17 = bVar3.c();
                    for (int i17 = 0; i17 < c17; i17++) {
                        e l17 = bVar3.l(i17);
                        if (l17 != null) {
                            SearchContactItemModel create2 = SearchContactItemModel.Companion.create(l17);
                            if (create2.isValid()) {
                                doubleVideoItemModel.contactList.add(create2);
                            }
                        }
                    }
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    Iterator it = doubleVideoItemModel.contactList.iterator();
                    while (it.hasNext()) {
                        ((SearchContactItemModel) it.next()).setExtension(unifySearchTabContent.extension);
                    }
                    break;
                case 7:
                    BaseSearchItemModel create3 = SearchContactItemModel.Companion.create(new e(unifySearchTabContent.layoutContent));
                    create3.setExtension(unifySearchTabContent.extension);
                    iSearchItemModel = create3;
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
                case 8:
                    String str5 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new SearchTroopCardItemModel();
                    b bVar4 = new b(str5);
                    int c18 = bVar4.c();
                    for (int i18 = 0; i18 < c18; i18++) {
                        e l18 = bVar4.l(i18);
                        if (l18 != null) {
                            SearchTroopItemModel create4 = SearchTroopItemModel.Companion.create(l18);
                            if (create4.isValid()) {
                                doubleVideoItemModel.troopList.add(create4);
                            }
                        }
                    }
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    Iterator it5 = doubleVideoItemModel.troopList.iterator();
                    while (it5.hasNext()) {
                        ((SearchTroopItemModel) it5.next()).setExtension(unifySearchTabContent.extension);
                    }
                    break;
                case 9:
                    SearchTroopItemModel.Companion companion = SearchTroopItemModel.Companion;
                    String str6 = unifySearchTabContent.layoutContent;
                    companion.getClass();
                    BaseSearchItemModel create5 = companion.create(new e(str6));
                    create5.setExtension(unifySearchTabContent.extension);
                    iSearchItemModel = create5;
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
                case 10:
                    SearchGuildChannelItemModel.Companion companion2 = SearchGuildChannelItemModel.Companion;
                    String str7 = unifySearchTabContent.layoutContent;
                    companion2.getClass();
                    BaseSearchItemModel create6 = companion2.create(new e(str7));
                    create6.setExtension(unifySearchTabContent.extension);
                    iSearchItemModel = create6;
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
                case 11:
                    BaseSearchItemModel create7 = SearchMiniAppItemModel.Companion.create(new e(unifySearchTabContent.layoutContent));
                    create7.setExtension(unifySearchTabContent.extension);
                    iSearchItemModel = create7;
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
                case 12:
                    String str8 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new SearchMiniAppCardItemModel();
                    b bVar5 = new b(str8);
                    int c19 = bVar5.c();
                    for (int i19 = 0; i19 < c19; i19++) {
                        e l19 = bVar5.l(i19);
                        if (l19 != null) {
                            SearchMiniAppItemModel create8 = SearchMiniAppItemModel.Companion.create(l19);
                            if (create8.isValid()) {
                                doubleVideoItemModel.miniAppList.add(create8);
                            }
                        }
                    }
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    Iterator it6 = doubleVideoItemModel.miniAppList.iterator();
                    while (it6.hasNext()) {
                        ((SearchMiniAppItemModel) it6.next()).setExtension(unifySearchTabContent.extension);
                    }
                    break;
                case 13:
                    String str9 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new SearchGuildChannelCardItemModel();
                    b bVar6 = new b(str9);
                    int c26 = bVar6.c();
                    for (int i26 = 0; i26 < c26; i26++) {
                        e l26 = bVar6.l(i26);
                        if (l26 != null) {
                            SearchGuildChannelItemModel create9 = SearchGuildChannelItemModel.Companion.create(l26);
                            if (create9.isValid()) {
                                doubleVideoItemModel.channelList.add(create9);
                            }
                        }
                    }
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    Iterator it7 = doubleVideoItemModel.channelList.iterator();
                    while (it7.hasNext()) {
                        ((SearchGuildChannelItemModel) it7.next()).setExtension(unifySearchTabContent.extension);
                    }
                    break;
                case 14:
                    String str10 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new SearchEmptyCardItemModel();
                    doubleVideoItemModel.text = new e(str10).q("text", "\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u7528\u6237\u3001\u7fa4\u804a\u6216\u9891\u9053");
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    break;
                case 15:
                    String str11 = unifySearchTabContent.layoutContent;
                    doubleVideoItemModel = new SearchRecommendGuideItemModel();
                    doubleVideoItemModel.text = new e(str11).q("text", "\u4e3a\u4f60\u641c\u7d22\u5230\u5176\u4ed6\u5185\u5bb9");
                    doubleVideoItemModel.setExtension(unifySearchTabContent.extension);
                    break;
                case 18:
                    iSearchItemModel = TemplateItemsKt.createTemplateItem(unifySearchTabContent.layoutContent);
                    unifySearchTabContent.searchItem = iSearchItemModel;
                    return true;
            }
            iSearchItemModel = doubleVideoItemModel;
            unifySearchTabContent.searchItem = iSearchItemModel;
            return true;
        } catch (Exception e16) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UnifySearchTabContent.parseContent:");
            m16.append(e16.getMessage());
            utils.logToNative(m16.toString());
            return false;
        }
    }
}
