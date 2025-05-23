package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f294201a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f294201a = new int[]{-1000, -2000, -20000, -2002, MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO, MessageRecord.MSG_TYPE_MIX, -2001, -2007, MessageRecord.MSG_TYPE_REPLY_TEXT, MessageRecord.MSG_TYPE_STICKER_MSG, -8018};
        }
    }
}
