package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.views.RichTextAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AccessibilityRichTextAttr extends RichTextAttr {
    public boolean hasCustomAccessibilitySet;
    public boolean internalAccessibilitySet;
    public String lastAccessibility = "";

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
}
