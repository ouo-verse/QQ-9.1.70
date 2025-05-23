package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.weiyun.poi.PoiDbManager;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchReqBody implements ISSOReqModel, ISSORspModel<UnifySearchReqBody> {
    public final String busiSessionInfo;
    public final UnifySearchChannelConditonFilter channelConditionFilter;
    public final UnifySearchDeviceInfo deviceInfo;
    public final boolean disableCorrectionQuery;
    public final String extension;
    public final UnifySearchGroupConditonFilter groupConditionFilter;
    public final String keyWord;
    public final String lbs;
    public final String sessionInfo;
    public final UnifySearchTabInfo tabs;
    public final String version;

    public UnifySearchReqBody(String str, String str2, UnifySearchTabInfo unifySearchTabInfo, String str3, UnifySearchDeviceInfo unifySearchDeviceInfo, UnifySearchGroupConditonFilter unifySearchGroupConditonFilter, boolean z16, String str4, UnifySearchChannelConditonFilter unifySearchChannelConditonFilter, String str5, String str6) {
        this.keyWord = str;
        this.version = str2;
        this.tabs = unifySearchTabInfo;
        this.sessionInfo = str3;
        this.deviceInfo = unifySearchDeviceInfo;
        this.groupConditionFilter = unifySearchGroupConditonFilter;
        this.disableCorrectionQuery = z16;
        this.lbs = str4;
        this.channelConditionFilter = unifySearchChannelConditonFilter;
        this.busiSessionInfo = str5;
        this.extension = str6;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v(QCircleSchemeAttr.Detail.KEY_WORD, this.keyWord);
        eVar.v("version", this.version);
        UnifySearchTabInfo unifySearchTabInfo = this.tabs;
        if (unifySearchTabInfo != null) {
            eVar.v("tabs", unifySearchTabInfo.encode());
        }
        eVar.v(AppConstants.Key.SESSION_INFO, this.sessionInfo);
        UnifySearchDeviceInfo unifySearchDeviceInfo = this.deviceInfo;
        if (unifySearchDeviceInfo != null) {
            eVar.v("device_info", unifySearchDeviceInfo.encode());
        }
        UnifySearchGroupConditonFilter unifySearchGroupConditonFilter = this.groupConditionFilter;
        if (unifySearchGroupConditonFilter != null) {
            eVar.v("group_condition_filter", unifySearchGroupConditonFilter.encode());
        }
        eVar.w("disable_correction_query", this.disableCorrectionQuery);
        eVar.v("lbs", this.lbs);
        UnifySearchChannelConditonFilter unifySearchChannelConditonFilter = this.channelConditionFilter;
        if (unifySearchChannelConditonFilter != null) {
            eVar.v("channel_condition_filter", unifySearchChannelConditonFilter.encode());
        }
        eVar.v("busi_session_info", this.busiSessionInfo);
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchReqBody decode(e eVar) {
        UnifySearchDeviceInfo unifySearchDeviceInfo;
        UnifySearchGroupConditonFilter unifySearchGroupConditonFilter;
        ArrayList arrayList;
        String q16 = eVar.q(QCircleSchemeAttr.Detail.KEY_WORD, "");
        String q17 = eVar.q("version", "");
        e m3 = eVar.m("tabs");
        UnifySearchTabInfo unifySearchTabInfo = m3 != null ? new UnifySearchTabInfo(m3.q("tab_name", ""), m3.o("tab_mask", 0L)) : null;
        String q18 = eVar.q(AppConstants.Key.SESSION_INFO, "");
        e m16 = eVar.m("device_info");
        if (m16 != null) {
            boolean g16 = m16.g("study_mode_status", false);
            m16.g("night_mode_status", false);
            unifySearchDeviceInfo = new UnifySearchDeviceInfo(g16, false);
        } else {
            unifySearchDeviceInfo = null;
        }
        e m17 = eVar.m("group_condition_filter");
        if (m17 != null) {
            int k3 = m17.k("group_rank_type", 0);
            b l3 = m17.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    String o16 = l3.o(i3);
                    if (o16 != null) {
                        arrayList.add(o16);
                    }
                }
            } else {
                arrayList = null;
            }
            e m18 = m17.m("geo_info");
            unifySearchGroupConditonFilter = new UnifySearchGroupConditonFilter(k3, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, m18 != null ? new UnifySearchGeoInfo(m18.k(PoiDbManager.COL_POI_CITY_ID, 0)) : null);
        } else {
            unifySearchGroupConditonFilter = null;
        }
        boolean f16 = eVar.f("disable_correction_query");
        String q19 = eVar.q("lbs", "");
        e m19 = eVar.m("channel_condition_filter");
        return new UnifySearchReqBody(q16, q17, unifySearchTabInfo, q18, unifySearchDeviceInfo, unifySearchGroupConditonFilter, f16, q19, m19 != null ? new UnifySearchChannelConditonFilter(m19.k("rank_type", 0), m19.k("content_type", 0)) : null, eVar.q("busi_session_info ", ""), eVar.q(MimeTypeParser.ATTR_EXTENSION, ""));
    }

    public /* synthetic */ UnifySearchReqBody(String str, String str2, UnifySearchTabInfo unifySearchTabInfo, String str3, UnifySearchDeviceInfo unifySearchDeviceInfo, UnifySearchGroupConditonFilter unifySearchGroupConditonFilter, boolean z16, String str4, UnifySearchChannelConditonFilter unifySearchChannelConditonFilter, String str5, String str6, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : unifySearchTabInfo, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? null : unifySearchDeviceInfo, (i3 & 32) != 0 ? null : unifySearchGroupConditonFilter, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? "" : str4, (i3 & 256) == 0 ? unifySearchChannelConditonFilter : null, (i3 & 512) != 0 ? "" : str5, (i3 & 1024) == 0 ? str6 : "");
    }
}
