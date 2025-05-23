package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHeadTopic implements ISSOReqModel, ISSORspModel<QSearchHeadTopic> {
    public final QSearchGameButton appInfo;
    public final List<String> avatarGroup;
    public final String avatarText;
    public final String background;
    public final QSearchButton button;
    public final String extension;
    public final List<QSearchIcon> icon;
    public final QSearchReportInfo reportInfo;
    public final QSearchText subTitle;
    public final QSearchText text;
    public final QSearchText title;
    public final QSearchIcon topIcon;

    public QSearchHeadTopic(String str, QSearchText qSearchText, QSearchText qSearchText2, QSearchButton qSearchButton, QSearchGameButton qSearchGameButton, List<String> list, String str2, List<QSearchIcon> list2, QSearchText qSearchText3, String str3, QSearchReportInfo qSearchReportInfo, QSearchIcon qSearchIcon) {
        this.background = str;
        this.title = qSearchText;
        this.subTitle = qSearchText2;
        this.button = qSearchButton;
        this.appInfo = qSearchGameButton;
        this.avatarGroup = list;
        this.avatarText = str2;
        this.icon = list2;
        this.text = qSearchText3;
        this.extension = str3;
        this.reportInfo = qSearchReportInfo;
        this.topIcon = qSearchIcon;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("background", this.background);
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchText qSearchText2 = this.subTitle;
        if (qSearchText2 != null) {
            eVar.v("sub_title", qSearchText2.encode());
        }
        QSearchButton qSearchButton = this.button;
        if (qSearchButton != null) {
            eVar.v("button", qSearchButton.encode());
        }
        QSearchGameButton qSearchGameButton = this.appInfo;
        if (qSearchGameButton != null) {
            eVar.v(j.T0, qSearchGameButton.encode());
        }
        b bVar = new b();
        List<String> list = this.avatarGroup;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        eVar.v("avatar_group", bVar);
        b a16 = o.a(eVar, "avatar_text", this.avatarText);
        List<QSearchIcon> list2 = this.icon;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                a16.t(((QSearchIcon) it5.next()).encode());
            }
        }
        eVar.v("icon", a16);
        QSearchText qSearchText3 = this.text;
        if (qSearchText3 != null) {
            eVar.v("text", qSearchText3.encode());
        }
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        if (qSearchReportInfo != null) {
            eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, qSearchReportInfo.encode());
        }
        QSearchIcon qSearchIcon = this.topIcon;
        if (qSearchIcon != null) {
            eVar.v("top_icon", qSearchIcon.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchHeadTopic decode(e eVar) {
        QSearchGameButton qSearchGameButton;
        ArrayList arrayList;
        ArrayList arrayList2;
        QSearchIcon qSearchIcon;
        QSearchText qSearchText;
        ?? r95;
        ?? r112;
        List list;
        List list2;
        int i3;
        String q16 = eVar.q("background", "");
        e m3 = eVar.m("title");
        QSearchText m16 = m3 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m3) : null;
        e m17 = eVar.m("sub_title");
        QSearchText m18 = m17 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m17) : null;
        e m19 = eVar.m("button");
        QSearchButton decode = m19 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m19) : null;
        e m26 = eVar.m(j.T0);
        if (m26 != null) {
            String q17 = m26.q("app_id", "");
            String q18 = m26.q("channel_id", "");
            String q19 = m26.q("pkg_name", "");
            String q26 = m26.q("name", "");
            String q27 = m26.q("icon", "");
            String q28 = m26.q("url", "");
            String q29 = m26.q("app_size", "");
            String q36 = m26.q("business_channel", "");
            e m27 = m26.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
            qSearchGameButton = new QSearchGameButton(q17, q18, q19, q26, q27, q28, q29, q36, m27 != null ? new QSearchReportInfo(m27.q("eid", ""), m27.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : null);
        } else {
            qSearchGameButton = null;
        }
        b l3 = eVar.l("avatar_group");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i16 = 0; i16 < c16; i16++) {
                String o16 = l3.o(i16);
                if (o16 != null) {
                    arrayList.add(o16);
                }
            }
        } else {
            arrayList = null;
        }
        String q37 = eVar.q("avatar_text", "");
        b l16 = eVar.l("icon");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            int i17 = 0;
            while (i17 < c17) {
                Object d16 = l16.d(i17);
                b bVar = l16;
                if (d16 != null) {
                    QSearchIcon qSearchIcon2 = new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null);
                    i3 = c17;
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(qSearchIcon2.decode((e) d16));
                } else {
                    i3 = c17;
                }
                i17++;
                c17 = i3;
                l16 = bVar;
            }
        } else {
            arrayList2 = null;
        }
        e m28 = eVar.m("text");
        if (m28 != null) {
            qSearchIcon = null;
            qSearchText = QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m28);
        } else {
            qSearchIcon = null;
            qSearchText = null;
        }
        String q38 = eVar.q(MimeTypeParser.ATTR_EXTENSION, "");
        e m29 = eVar.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
        ISSORspModel qSearchReportInfo = m29 != null ? new QSearchReportInfo(m29.q("eid", ""), m29.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "")) : qSearchIcon;
        e m36 = eVar.m("top_icon");
        QSearchIcon decode2 = m36 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m36) : qSearchIcon;
        if (arrayList != null) {
            list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            r95 = list2;
        } else {
            r95 = qSearchIcon;
        }
        if (arrayList2 != null) {
            list = CollectionsKt___CollectionsKt.toList(arrayList2);
            r112 = list;
        } else {
            r112 = qSearchIcon;
        }
        return new QSearchHeadTopic(q16, m16, m18, decode, qSearchGameButton, r95, q37, r112, qSearchText, q38, qSearchReportInfo, decode2);
    }
}
