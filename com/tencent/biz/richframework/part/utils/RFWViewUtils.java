package com.tencent.biz.richframework.part.utils;

import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWViewUtils {
    public static Object getClosestViewTagData(int i3, View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(i3);
        if (tag != null) {
            return tag;
        }
        if (!(view.getParent() instanceof View)) {
            return null;
        }
        return getClosestViewTagData(i3, (View) view.getParent());
    }
}
