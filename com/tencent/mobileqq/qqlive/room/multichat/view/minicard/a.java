package com.tencent.mobileqq.qqlive.room.multichat.view.minicard;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sail.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(long j3, long j16, String str, String str2, Context context) {
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.headUrl = str2;
        liveUserInfo.uid = j16;
        liveUserInfo.nick = str;
        kk4.a.g(context, c.f272176a.k(j3, 1), liveUserInfo, 6, false);
    }
}
