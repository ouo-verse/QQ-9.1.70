package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MsgQueueItem extends BaseQueueItem {
    static IPatchRedirector $redirector_;

    public MsgQueueItem(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        super(str, i3, str2, entity, i16, proxyListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
    }

    public MsgQueueItem(String str, int i3, String str2, ContentValues contentValues, String str3, String[] strArr, int i16, ProxyListener proxyListener) {
        super(str, i3, str2, contentValues, str3, strArr, i16, proxyListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, contentValues, str3, strArr, Integer.valueOf(i16), proxyListener);
    }
}
