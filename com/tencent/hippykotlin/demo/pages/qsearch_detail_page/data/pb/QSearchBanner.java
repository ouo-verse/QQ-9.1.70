package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchBanner implements ISSOReqModel, ISSORspModel<QSearchBanner> {
    public final QSearchIcon background;
    public final QSearchButton button;
    public final QSearchIcon icon;
    public final QSearchText subTitle;
    public final List<QSearchText> textLink;
    public final QSearchText title;

    public QSearchBanner(QSearchIcon qSearchIcon, QSearchIcon qSearchIcon2, QSearchText qSearchText, QSearchText qSearchText2, QSearchButton qSearchButton, List<QSearchText> list) {
        this.background = qSearchIcon;
        this.icon = qSearchIcon2;
        this.title = qSearchText;
        this.subTitle = qSearchText2;
        this.button = qSearchButton;
        this.textLink = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchIcon qSearchIcon = this.background;
        if (qSearchIcon != null) {
            eVar.v("background", qSearchIcon.encode());
        }
        QSearchIcon qSearchIcon2 = this.icon;
        if (qSearchIcon2 != null) {
            eVar.v("icon", qSearchIcon2.encode());
        }
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
        b bVar = new b();
        List<QSearchText> list = this.textLink;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((QSearchText) it.next()).encode());
            }
        }
        eVar.v("text_link", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchBanner decode(e eVar) {
        List list;
        ArrayList arrayList;
        List list2;
        List list3;
        e m3 = eVar.m("background");
        QSearchIcon decode = m3 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m3) : null;
        e m16 = eVar.m("icon");
        QSearchIcon decode2 = m16 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m16) : null;
        e m17 = eVar.m("title");
        QSearchText m18 = m17 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m17) : null;
        e m19 = eVar.m("sub_title");
        QSearchText m26 = m19 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m19) : null;
        e m27 = eVar.m("button");
        QSearchButton decode3 = m27 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m27) : null;
        b l3 = eVar.l("text_link");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QSearchText qSearchText = new QSearchText(null, null, 15);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qSearchText.decode((e) d16));
                }
            }
            list = null;
        } else {
            list = null;
            arrayList = null;
        }
        if (arrayList != null) {
            list3 = CollectionsKt___CollectionsKt.toList(arrayList);
            list2 = list3;
        } else {
            list2 = list;
        }
        return new QSearchBanner(decode, decode2, m18, m26, decode3, list2);
    }
}
