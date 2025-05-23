package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ErrorData {
    public final String btnText;
    public final int clickType;
    public final String content;
    public final String title;

    public ErrorData(String str, String str2, int i3, String str3) {
        this.title = str;
        this.content = str2;
        this.clickType = i3;
        this.btnText = str3;
    }

    public final int hashCode() {
        return this.btnText.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.clickType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.content, this.title.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ErrorData(title=");
        m3.append(this.title);
        m3.append(", content=");
        m3.append(this.content);
        m3.append(", clickType=");
        m3.append(this.clickType);
        m3.append(", btnText=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.btnText, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorData)) {
            return false;
        }
        ErrorData errorData = (ErrorData) obj;
        return Intrinsics.areEqual(this.title, errorData.title) && Intrinsics.areEqual(this.content, errorData.content) && this.clickType == errorData.clickType && Intrinsics.areEqual(this.btnText, errorData.btnText);
    }
}
