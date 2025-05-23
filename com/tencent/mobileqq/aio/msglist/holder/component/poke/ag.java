package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ag {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f191651a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f191652b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f191653c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f191654d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f191651a = "PokeItemHelper";
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
        f191652b = sDKPrivatePath;
        String str = sDKPrivatePath + "/Tencent/MobileQQ/";
        f191653c = str;
        f191654d = str + ".vaspoke/";
    }
}
