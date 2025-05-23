package com.tencent.qqnt.chathistory.util;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes23.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Calendar f354061a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f354061a = Calendar.getInstance();
        }
    }

    public static String a(long j3) {
        f354061a.setTimeInMillis(System.currentTimeMillis());
        int i3 = f354061a.get(1);
        int i16 = f354061a.get(2);
        int i17 = f354061a.get(5);
        f354061a.setTimeInMillis(j3);
        int i18 = f354061a.get(1);
        int i19 = f354061a.get(2);
        int i26 = f354061a.get(5);
        if (i3 != i18) {
            return new SimpleDateFormat("yyyy-MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i16 != i19) {
            return new SimpleDateFormat("MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i17 == i26) {
            return new SimpleDateFormat("HH:mm ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i17 - i26 <= 1) {
            return HardCodeUtil.qqStr(R.string.f213775r4);
        }
        return new SimpleDateFormat("MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
    }
}
