package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QuickCommentItem {

    /* renamed from: id, reason: collision with root package name */
    public final String f114209id;
    public final String text;
    public final String trace;

    public QuickCommentItem(String str, String str2, String str3) {
        this.f114209id = str;
        this.text = str2;
        this.trace = str3;
    }

    public final int hashCode() {
        return this.trace.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, this.f114209id.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QuickCommentItem(id=");
        m3.append(this.f114209id);
        m3.append(", text=");
        m3.append(this.text);
        m3.append(", trace=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.trace, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickCommentItem)) {
            return false;
        }
        QuickCommentItem quickCommentItem = (QuickCommentItem) obj;
        return Intrinsics.areEqual(this.f114209id, quickCommentItem.f114209id) && Intrinsics.areEqual(this.text, quickCommentItem.text) && Intrinsics.areEqual(this.trace, quickCommentItem.trace);
    }
}
