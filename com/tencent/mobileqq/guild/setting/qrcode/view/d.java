package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.view.View;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {
    public static boolean a(View view) {
        Object tag = view.getTag(view.getId());
        if (tag == null || ((Boolean) tag).booleanValue()) {
            return false;
        }
        return true;
    }
}
