package com.tencent.mobileqq.activity.qqsettingme.utils;

import android.graphics.Color;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.activity.qqsettingme.bo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static AlphaAnimation a(float f16, float f17) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f17);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    public static String b(List<bo> list) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (bo boVar : list) {
                stringBuffer.append(boVar.f184979b + boVar.f184981d + "\u9884\u8b66");
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public static int c(String str, int i3) {
        try {
            return Color.parseColor("#" + str);
        } catch (IllegalArgumentException unused) {
            return i3;
        }
    }
}
