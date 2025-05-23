package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchLabel implements ISSOReqModel, ISSORspModel<QSearchLabel> {
    public final QSearchIcon icon;
    public final int layout;
    public final QSearchText text;

    public QSearchLabel() {
        this(null, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchText qSearchText = this.text;
        if (qSearchText != null) {
            eVar.v("text", qSearchText.encode());
        }
        QSearchIcon qSearchIcon = this.icon;
        if (qSearchIcon != null) {
            eVar.v("icon", qSearchIcon.encode());
        }
        eVar.t(TtmlNode.TAG_LAYOUT, this.layout);
        return eVar;
    }

    public QSearchLabel(QSearchText qSearchText, QSearchIcon qSearchIcon, int i3) {
        this.text = qSearchText;
        this.icon = qSearchIcon;
        this.layout = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchLabel decode(e eVar) {
        e m3 = eVar.m("text");
        QSearchText m16 = m3 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m3) : null;
        e m17 = eVar.m("icon");
        return new QSearchLabel(m16, m17 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m17) : null, eVar.k(TtmlNode.TAG_LAYOUT, 0));
    }

    public /* synthetic */ QSearchLabel(QSearchText qSearchText, QSearchIcon qSearchIcon, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, 0);
    }
}
