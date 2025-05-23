package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchNineBoxGrid implements ISSOReqModel, ISSORspModel<QSearchNineBoxGrid> {
    public final QSearchButton button;
    public final List<QSearchNineBoxContent> content;
    public final QSearchIcon describe;
    public final String extension;
    public final QSearchIcon icon;
    public final int nineBoxGridType;
    public final QSearchRichText richText;
    public final QSearchText text;
    public final QSearchText title;

    public QSearchNineBoxGrid(QSearchText qSearchText, QSearchButton qSearchButton, QSearchIcon qSearchIcon, QSearchText qSearchText2, List<QSearchNineBoxContent> list, QSearchIcon qSearchIcon2, String str, int i3, QSearchRichText qSearchRichText) {
        this.title = qSearchText;
        this.button = qSearchButton;
        this.icon = qSearchIcon;
        this.text = qSearchText2;
        this.content = list;
        this.describe = qSearchIcon2;
        this.extension = str;
        this.nineBoxGridType = i3;
        this.richText = qSearchRichText;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchButton qSearchButton = this.button;
        if (qSearchButton != null) {
            eVar.v("button", qSearchButton.encode());
        }
        QSearchIcon qSearchIcon = this.icon;
        if (qSearchIcon != null) {
            eVar.v("icon", qSearchIcon.encode());
        }
        QSearchText qSearchText2 = this.text;
        if (qSearchText2 != null) {
            eVar.v("text", qSearchText2.encode());
        }
        b bVar = new b();
        List<QSearchNineBoxContent> list = this.content;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((QSearchNineBoxContent) it.next()).encode());
            }
        }
        eVar.v("content", bVar);
        QSearchIcon qSearchIcon2 = this.describe;
        if (qSearchIcon2 != null) {
            eVar.v("describe", qSearchIcon2.encode());
        }
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        eVar.t("nine_box_grid_type", this.nineBoxGridType);
        QSearchRichText qSearchRichText = this.richText;
        if (qSearchRichText != null) {
            eVar.v("rich_text", qSearchRichText.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchNineBoxGrid decode(e eVar) {
        ArrayList arrayList;
        QSearchRichText qSearchRichText;
        ArrayList arrayList2;
        b bVar;
        e m3 = eVar.m("title");
        QSearchText m16 = m3 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m3) : null;
        e m17 = eVar.m("button");
        QSearchButton decode = m17 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m17) : null;
        e m18 = eVar.m("icon");
        QSearchIcon decode2 = m18 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m18) : null;
        e m19 = eVar.m("text");
        QSearchText m26 = m19 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m19) : null;
        b l3 = eVar.l("content");
        int i3 = 0;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i16 = 0; i16 < c16; i16++) {
                Object d16 = l3.d(i16);
                if (d16 != null) {
                    QSearchNineBoxContent qSearchNineBoxContent = new QSearchNineBoxContent(0, null, null, null, 15, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qSearchNineBoxContent.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        e m27 = eVar.m("describe");
        QSearchIcon decode3 = m27 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m27) : null;
        String q16 = eVar.q(MimeTypeParser.ATTR_EXTENSION, "");
        int k3 = eVar.k("nine_box_grid_type", 0);
        e m28 = eVar.m("rich_text");
        if (m28 != null) {
            b l16 = m28.l("highlight_text");
            if (l16 != null) {
                arrayList2 = new ArrayList();
                int c17 = l16.c();
                while (i3 < c17) {
                    Object d17 = l16.d(i3);
                    if (d17 != null) {
                        bVar = l16;
                        QSearchText qSearchText = new QSearchText(null, null, 15);
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList2.add(qSearchText.decode((e) d17));
                    } else {
                        bVar = l16;
                    }
                    i3++;
                    l16 = bVar;
                }
            } else {
                arrayList2 = null;
            }
            qSearchRichText = new QSearchRichText(arrayList2);
        } else {
            qSearchRichText = null;
        }
        return new QSearchNineBoxGrid(m16, decode, decode2, m26, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, decode3, q16, k3, qSearchRichText);
    }
}
