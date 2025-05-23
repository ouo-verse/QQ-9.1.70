package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ListTitle$Companion {
    public final int fromInt$enumunboxing$(int i3) {
        for (int i16 : BoxType$EnumUnboxingSharedUtility.values(2)) {
            if (ListTitle$EnumUnboxingLocalUtility.getValue(i16) == i3) {
                return i16;
            }
        }
        return 0;
    }
}
