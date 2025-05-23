package com.tencent.mobileqq.aio.title;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "AutoInjectYml/Business/AIO/title/Inject_AIO_Title_Nick_Provider.yml", version = 3)
    private static final ArrayList<Class<? extends pv3.a>> f194004a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends pv3.a>> arrayList = new ArrayList<>();
        f194004a = arrayList;
        arrayList.add(ak.class);
        arrayList.add(com.tencent.biz.pubaccount.aio.h.class);
        arrayList.add(jd1.c.class);
        arrayList.add(z.class);
        arrayList.add(com.tencent.mobileqq.troop.nt.a.class);
    }

    public static CharSequence a(CharSequence charSequence) {
        int i3 = 0;
        while (true) {
            ArrayList<Class<? extends pv3.a>> arrayList = f194004a;
            if (i3 < arrayList.size()) {
                try {
                    charSequence = arrayList.get(i3).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).a(charSequence);
                } catch (Exception e16) {
                    QLog.e("AIOTitleNickProvider", 1, "filterNick exception", e16);
                }
                i3++;
            } else {
                return charSequence;
            }
        }
    }

    public static CharSequence b(com.tencent.aio.api.runtime.a aVar) {
        CharSequence b16;
        int i3 = 0;
        while (true) {
            ArrayList<Class<? extends pv3.a>> arrayList = f194004a;
            if (i3 < arrayList.size()) {
                try {
                    b16 = arrayList.get(i3).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).b(aVar);
                } catch (Exception e16) {
                    QLog.e("AIOTitleNickProvider", 1, "getNick exception", e16);
                }
                if (!TextUtils.isEmpty(b16)) {
                    return b16;
                }
                i3++;
            } else {
                return "";
            }
        }
    }
}
