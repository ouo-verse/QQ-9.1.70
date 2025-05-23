package com.tencent.hippykotlin.demo.pages.base.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Btn implements ISSOModel {
    public final boolean shouldKeepMsgBox;
    public final boolean shouldPopPage;
    public final String text;
    public final String url;

    public Btn() {
        this(null, null, false, false, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("text", this.text);
        eVar.v("url", this.url);
        eVar.w("should_pop_page", this.shouldPopPage);
        eVar.w("should_keep_msg_box", this.shouldKeepMsgBox);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, this.text.hashCode() * 31, 31);
        boolean z16 = this.shouldPopPage;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m3 + i3) * 31;
        boolean z17 = this.shouldKeepMsgBox;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Btn(text=");
        m3.append(this.text);
        m3.append(", url=");
        m3.append(this.url);
        m3.append(", shouldPopPage=");
        m3.append(this.shouldPopPage);
        m3.append(", shouldKeepMsgBox=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.shouldKeepMsgBox, ')');
    }

    public Btn(String str, String str2, boolean z16, boolean z17) {
        this.text = str;
        this.url = str2;
        this.shouldPopPage = z16;
        this.shouldKeepMsgBox = z17;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Btn)) {
            return false;
        }
        Btn btn = (Btn) obj;
        return Intrinsics.areEqual(this.text, btn.text) && Intrinsics.areEqual(this.url, btn.url) && this.shouldPopPage == btn.shouldPopPage && this.shouldKeepMsgBox == btn.shouldKeepMsgBox;
    }

    public /* synthetic */ Btn(String str, String str2, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", false, false);
    }
}
