package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.R;
import android.content.res.ColorStateList;
import android.util.Pair;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ColorUtil {
    public static ColorStateList getColorStateList(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (str3 != null) {
            arrayList.add(new Pair(Integer.valueOf(R.attr.state_selected), Integer.valueOf(Utils.parseColor(str3))));
        }
        if (str2 != null) {
            arrayList.add(new Pair(Integer.valueOf(R.attr.state_pressed), Integer.valueOf(Utils.parseColor(str2))));
        }
        if (str != null) {
            arrayList.add(new Pair(Integer.MIN_VALUE, Integer.valueOf(Utils.parseColor(str))));
        }
        int[] iArr = new int[arrayList.size()];
        int[][] iArr2 = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Pair pair = (Pair) arrayList.get(i3);
            iArr[i3] = ((Integer) pair.second).intValue();
            if (((Integer) pair.first).intValue() != Integer.MIN_VALUE) {
                int[] iArr3 = new int[1];
                iArr3[0] = ((Integer) pair.first).intValue();
                iArr2[i3] = iArr3;
            } else {
                iArr2[i3] = new int[0];
            }
        }
        return new ColorStateList(iArr2, iArr);
    }
}
