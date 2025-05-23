package com.tencent.hippykotlin.demo.pages.base.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MsgBox implements ISSOModel {
    public final boolean display;
    public final Btn leftBtn;
    public final Btn rightBtn;
    public final String text;
    public final String title;

    public MsgBox() {
        this(false, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.w("display", this.display);
        eVar.v("title", this.title);
        eVar.v("text", this.text);
        Btn btn = this.leftBtn;
        if (btn != null) {
            eVar.v("left_btn", btn.encode());
        }
        Btn btn2 = this.rightBtn;
        if (btn2 != null) {
            eVar.v("right_btn", btn2.encode());
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z16 = this.display;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, r06 * 31, 31), 31);
        Btn btn = this.leftBtn;
        int hashCode = (m3 + (btn == null ? 0 : btn.hashCode())) * 31;
        Btn btn2 = this.rightBtn;
        return hashCode + (btn2 != null ? btn2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("MsgBox(display=");
        m3.append(this.display);
        m3.append(", title=");
        m3.append(this.title);
        m3.append(", text=");
        m3.append(this.text);
        m3.append(", leftBtn=");
        m3.append(this.leftBtn);
        m3.append(", rightBtn=");
        m3.append(this.rightBtn);
        m3.append(')');
        return m3.toString();
    }

    public MsgBox(boolean z16, String str, String str2, Btn btn, Btn btn2) {
        this.display = z16;
        this.title = str;
        this.text = str2;
        this.leftBtn = btn;
        this.rightBtn = btn2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgBox)) {
            return false;
        }
        MsgBox msgBox = (MsgBox) obj;
        return this.display == msgBox.display && Intrinsics.areEqual(this.title, msgBox.title) && Intrinsics.areEqual(this.text, msgBox.text) && Intrinsics.areEqual(this.leftBtn, msgBox.leftBtn) && Intrinsics.areEqual(this.rightBtn, msgBox.rightBtn);
    }

    public /* synthetic */ MsgBox(boolean z16, String str, String str2, Btn btn, Btn btn2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, "", "", null, null);
    }
}
