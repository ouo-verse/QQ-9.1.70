package com.tencent.wcdb;

import android.os.Binder;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class c extends Binder implements i {
    static IPatchRedirector $redirector_;

    public static i j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        i iVar = (i) iBinder.queryLocalInterface("android.content.IBulkCursor");
        if (iVar != null) {
            return iVar;
        }
        return new d(iBinder);
    }
}
