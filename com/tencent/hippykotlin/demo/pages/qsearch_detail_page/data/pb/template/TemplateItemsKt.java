package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateAttr;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TemplateItemsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$configAttr(QSearchBaseTemplateAttr qSearchBaseTemplateAttr, QSearchBaseTemplateModel qSearchBaseTemplateModel, int i3, String str, String str2, QSearchTabContentViewModel qSearchTabContentViewModel, QSearchDetailViewModel qSearchDetailViewModel, UnifySearchTabInfo unifySearchTabInfo) {
        qSearchBaseTemplateAttr.data = qSearchBaseTemplateModel;
        qSearchBaseTemplateAttr.index = i3;
        qSearchBaseTemplateAttr.keyword = str;
        qSearchBaseTemplateAttr.traceId = str2;
        int playIndex = qSearchTabContentViewModel.getPlayIndex();
        ReadWriteProperty readWriteProperty = qSearchBaseTemplateAttr.playIndex$delegate;
        KProperty<?>[] kPropertyArr = QSearchBaseTemplateAttr.$$delegatedProperties;
        readWriteProperty.setValue(qSearchBaseTemplateAttr, kPropertyArr[0], Integer.valueOf(playIndex));
        qSearchBaseTemplateAttr.muted$delegate.setValue(qSearchBaseTemplateAttr, kPropertyArr[1], Boolean.valueOf(qSearchDetailViewModel.getMuted()));
        qSearchBaseTemplateAttr.tabData = unifySearchTabInfo;
        qSearchBaseTemplateAttr.viewModel = qSearchTabContentViewModel;
        if (qSearchBaseTemplateModel.layoutInfo.useWholeCard) {
            qSearchBaseTemplateAttr.isFirstItem = i3 == 0;
            qSearchBaseTemplateAttr.isLastItem$delegate.setValue(qSearchBaseTemplateAttr, kPropertyArr[2], Boolean.valueOf(i3 == qSearchTabContentViewModel.getDataList().size() - 1));
        }
    }

    public static final QSearchBaseTemplateModel createTemplateItem(String str) throws Exception {
        QSearchTemplate decode = new QSearchTemplate(0, "", null, null, null).decode(new e(str));
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("createTemplateItem:   templateData:  id:");
        m3.append(decode.templateId);
        m3.append("   reportInfo == null:");
        m3.append(decode.reportInfo == null);
        m3.append("    eid:");
        QSearchReportInfo qSearchReportInfo = decode.reportInfo;
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, qSearchReportInfo != null ? qSearchReportInfo.eid : null, kLog, "TemplateItems");
        switch (decode.templateId) {
            case 1:
                QSearchGameTemplateModel qSearchGameTemplateModel = new QSearchGameTemplateModel();
                qSearchGameTemplateModel.parseContent(decode);
                return qSearchGameTemplateModel;
            case 2:
                QSearchHorizontalTemplateModel qSearchHorizontalTemplateModel = new QSearchHorizontalTemplateModel();
                qSearchHorizontalTemplateModel.parseContent(decode);
                return qSearchHorizontalTemplateModel;
            case 3:
                QSearchVerticalTemplateModel qSearchVerticalTemplateModel = new QSearchVerticalTemplateModel();
                qSearchVerticalTemplateModel.parseContent(decode);
                return qSearchVerticalTemplateModel;
            case 4:
                QSearchBannerTemplateModel qSearchBannerTemplateModel = new QSearchBannerTemplateModel();
                qSearchBannerTemplateModel.parseContent(decode);
                return qSearchBannerTemplateModel;
            case 5:
                QSearchMultiImageVideoTemplateModel qSearchMultiImageVideoTemplateModel = new QSearchMultiImageVideoTemplateModel();
                qSearchMultiImageVideoTemplateModel.parseContent(decode);
                return qSearchMultiImageVideoTemplateModel;
            case 6:
                QSearchTitleTemplateModel qSearchTitleTemplateModel = new QSearchTitleTemplateModel();
                qSearchTitleTemplateModel.parseContent(decode);
                return qSearchTitleTemplateModel;
            case 7:
                QSearchFileTemplateModel qSearchFileTemplateModel = new QSearchFileTemplateModel();
                qSearchFileTemplateModel.parseContent(decode);
                return qSearchFileTemplateModel;
            case 8:
                QSearchDoubleColumnTemplateModel qSearchDoubleColumnTemplateModel = new QSearchDoubleColumnTemplateModel();
                qSearchDoubleColumnTemplateModel.parseContent(decode);
                return qSearchDoubleColumnTemplateModel;
            case 9:
                QSearchCommonItemTemplateModel qSearchCommonItemTemplateModel = new QSearchCommonItemTemplateModel();
                qSearchCommonItemTemplateModel.parseContent(decode);
                return qSearchCommonItemTemplateModel;
            case 10:
                QSearchPlayletTemplateModel qSearchPlayletTemplateModel = new QSearchPlayletTemplateModel();
                qSearchPlayletTemplateModel.parseContent(decode);
                return qSearchPlayletTemplateModel;
            default:
                Utils utils = Utils.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("#createTemplateItem: unknown template id:");
                m16.append(decode.templateId);
                utils.logToNative(m16.toString());
                return null;
        }
    }

    public static final e getReportParams(QSearchReportInfo qSearchReportInfo, e eVar) {
        e mergeTransferInfo;
        if (!(qSearchReportInfo.reportInfo.length() == 0) && (mergeTransferInfo = mergeTransferInfo(qSearchReportInfo.reportInfo, eVar)) != null) {
            eVar.v("transfer_info", mergeTransferInfo);
            inflateTransferInfo(eVar, mergeTransferInfo);
        }
        return eVar;
    }

    public static final void inflateTransferInfo(e eVar, e eVar2) {
        for (String str : eVar2.b()) {
            Object e16 = eVar2.e(str);
            if (e16 != null && (Intrinsics.areEqual("serial_number", str) || !eVar.a(str))) {
                eVar.v(str, e16);
            }
        }
    }

    public static final e mergeTransferInfo(String str, e eVar) {
        String p16 = eVar.p("transfer_info");
        try {
            e eVar2 = new e(str);
            if (p16.length() == 0) {
                return eVar2;
            }
            e eVar3 = new e(p16);
            for (String str2 : eVar2.b()) {
                Object e16 = eVar2.e(str2);
                if (e16 != null) {
                    eVar3.v(str2, e16);
                }
            }
            return eVar3;
        } catch (JSONException unused) {
            return null;
        }
    }
}
