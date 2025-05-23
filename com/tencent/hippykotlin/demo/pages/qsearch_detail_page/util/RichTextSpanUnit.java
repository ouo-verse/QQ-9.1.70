package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.kuikly.core.base.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class RichTextSpanUnit {
    public Function0<Unit> clickFun;
    public h color;
    public int end;
    public QSearchJump jump;
    public int start;

    public RichTextSpanUnit(int i3, int i16, h hVar, QSearchJump qSearchJump, Function0<Unit> function0) {
        this.start = i3;
        this.end = i16;
        this.color = hVar;
        this.jump = qSearchJump;
        this.clickFun = function0;
    }

    public final int hashCode() {
        int hashCode = (this.color.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.end, this.start * 31, 31)) * 31;
        QSearchJump qSearchJump = this.jump;
        int hashCode2 = (hashCode + (qSearchJump == null ? 0 : qSearchJump.hashCode())) * 31;
        Function0<Unit> function0 = this.clickFun;
        return hashCode2 + (function0 != null ? function0.hashCode() : 0);
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
        m3.append(", clickFun=");
        m3.append(this.clickFun);
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
        return this.start == richTextSpanUnit.start && this.end == richTextSpanUnit.end && Intrinsics.areEqual(this.color, richTextSpanUnit.color) && Intrinsics.areEqual(this.jump, richTextSpanUnit.jump) && Intrinsics.areEqual(this.clickFun, richTextSpanUnit.clickFun);
    }
}
