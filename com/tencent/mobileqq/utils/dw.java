package com.tencent.mobileqq.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dw {
    public static ShareActionSheetBuilder.ActionSheetItem a(int i3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        arrayList.add(build);
        return build;
    }

    public static void b(int i3, int i16, @NonNull ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = arrayList.get(i17);
            if (actionSheetItem != null && actionSheetItem.action == i16) {
                arrayList.add(i17, build);
                return;
            }
        }
        arrayList.add(build);
    }
}
