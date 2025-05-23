package com.tencent.qqnt.emotion.constant;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f356198a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43981);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f356198a = 0;
        }
    }

    private static int a(Context context) {
        float dimension;
        int i3 = f356198a;
        if (i3 != 0) {
            return i3;
        }
        int i16 = context.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    dimension = context.getResources().getDimension(R.dimen.f158274c0);
                } else {
                    dimension = context.getResources().getDimension(R.dimen.f158272bx);
                }
            } else {
                dimension = context.getResources().getDimension(R.dimen.by);
            }
        } else {
            dimension = context.getResources().getDimension(R.dimen.f158273bz);
        }
        int i17 = (int) ((dimension / context.getResources().getDisplayMetrics().density) + 0.5f);
        f356198a = i17;
        return i17;
    }

    public static int b() {
        return a(MobileQQ.sMobileQQ) + 2;
    }
}
