package com.tencent.biz.richframework.layoutinflater.redirect;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/redirect/AttrRedirectHandler;", "Lcom/tencent/biz/richframework/layoutinflater/redirect/ICreateViewRedirectHandler;", "()V", "getCheckAttrName", "", "isTargetVersion", "", "needCreateViewInMain", "name", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "parseAttr", Node.ATTRS_ATTR, "checkAttrName", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class AttrRedirectHandler implements ICreateViewRedirectHandler {
    private final boolean parseAttr(AttributeSet attrs, String checkAttrName) {
        if (isTargetVersion()) {
            int attributeCount = attrs.getAttributeCount();
            for (int i3 = 0; i3 < attributeCount; i3++) {
                if (Intrinsics.areEqual(attrs.getAttributeName(i3), checkAttrName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public abstract String getCheckAttrName();

    public abstract boolean isTargetVersion();

    @Override // com.tencent.biz.richframework.layoutinflater.redirect.ICreateViewRedirectHandler
    public boolean needCreateViewInMain(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attr) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        return parseAttr(attr, getCheckAttrName());
    }
}
