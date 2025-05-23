package com.tencent.sqshow.zootopia.nativeui.menu;

import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/menu/MenuDefine;", "", "str", "", "iconResId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIconResId", "()I", "getStr", "()Ljava/lang/String;", "MENU_DETAIL", "MENU_LIKE", "MENU_UNLIKE", "MENU_GIFT", "MENU_DELETE", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum MenuDefine {
    MENU_DETAIL("\u8be6\u60c5", R.drawable.ikv),
    MENU_LIKE("\u6536\u85cf", R.drawable.ikz),
    MENU_UNLIKE("\u5df2\u6536\u85cf", R.drawable.ikw),
    MENU_GIFT("\u8d60\u9001", R.drawable.ikx),
    MENU_DELETE("\u5220\u9664", R.drawable.iku);

    private final int iconResId;
    private final String str;

    MenuDefine(String str, int i3) {
        this.str = str;
        this.iconResId = i3;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final String getStr() {
        return this.str;
    }
}
