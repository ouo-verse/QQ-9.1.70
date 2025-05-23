package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.views.ce;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AccessibilityTextAttr extends ce {
    public boolean hasCustomAccessibilitySet;
    public boolean internalAccessibilitySet;
    public String lastAccessibility = "";
    public String internalText = "";

    @Override // com.tencent.kuikly.core.base.Attr
    public final d accessibility(String str) {
        if (!this.internalAccessibilitySet) {
            this.hasCustomAccessibilitySet = true;
        }
        if (Intrinsics.areEqual(this.lastAccessibility, str)) {
            return this;
        }
        this.lastAccessibility = str;
        return super.accessibility(str);
    }

    @Override // com.tencent.kuikly.core.views.ce
    public final ce text(String str) {
        this.internalText = str;
        return super.text(str);
    }

    @Override // com.tencent.kuikly.core.views.ce
    public final ce value(String str) {
        this.internalText = str;
        return super.text(str);
    }
}
