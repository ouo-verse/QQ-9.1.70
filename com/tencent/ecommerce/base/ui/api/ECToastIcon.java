package com.tencent.ecommerce.base.ui.api;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "", "icon", "", "(Ljava/lang/String;II)V", "getIcon", "()I", "setIcon", "(I)V", "ICON_NONE", "ICON_DEFAULT", "ICON_ERROR", "ICON_SUCCESS", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public enum ECToastIcon {
    ICON_NONE(-1),
    ICON_DEFAULT(0),
    ICON_ERROR(1),
    ICON_SUCCESS(2);

    private int icon;

    ECToastIcon(int i3) {
        this.icon = i3;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final void setIcon(int i3) {
        this.icon = i3;
    }
}
