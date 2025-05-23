package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.kuikly.core.base.h;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class RichTextSpanUnit {
    public h color;
    public int end;
    public QSearchJump jump;
    public QSearchReportInfo reportInfo;
    public int start;

    public RichTextSpanUnit(int i3, int i16, h hVar, QSearchJump qSearchJump, QSearchReportInfo qSearchReportInfo) {
        this.start = i3;
        this.end = i16;
        this.color = hVar;
        this.jump = qSearchJump;
        this.reportInfo = qSearchReportInfo;
    }

    public final int hashCode() {
        int hashCode = (this.color.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.end, this.start * 31, 31)) * 31;
        QSearchJump qSearchJump = this.jump;
        int hashCode2 = (hashCode + (qSearchJump == null ? 0 : qSearchJump.hashCode())) * 31;
        QSearchReportInfo qSearchReportInfo = this.reportInfo;
        return hashCode2 + (qSearchReportInfo != null ? qSearchReportInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RichTextSpanUnit(start=");
        m3.append(this.start);
        m3.append(", end=");
        m3.append(this.end);
        m3.append(", color=");
        m3.append(this.color);
        m3.append(", jump=");
        m3.append(this.jump);
        m3.append(", reportInfo=");
        m3.append(this.reportInfo);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RichTextSpanUnit)) {
            return false;
        }
        RichTextSpanUnit richTextSpanUnit = (RichTextSpanUnit) obj;
        return this.start == richTextSpanUnit.start && this.end == richTextSpanUnit.end && Intrinsics.areEqual(this.color, richTextSpanUnit.color) && Intrinsics.areEqual(this.jump, richTextSpanUnit.jump) && Intrinsics.areEqual(this.reportInfo, richTextSpanUnit.reportInfo);
    }
}
