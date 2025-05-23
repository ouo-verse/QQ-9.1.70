package com.tencent.qqnt.emotion.stickerrecommended.ad;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class f extends com.tencent.qqnt.emotion.stickerrecommended.b {
    static IPatchRedirector $redirector_;

    public f(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    private static boolean d(List<String> list, String str) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.b, com.tencent.qqnt.emotion.stickerrecommended.h
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseQQAppInterface, (Object) str)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.h
    public List<e> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return c(str, b.a(this.f356489a.getApp(), this.f356489a.getCurrentUin()));
    }

    public List<e> c(String str, a aVar) {
        List<d> list;
        List<c> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar);
        }
        ArrayList arrayList = null;
        if (aVar != null && aVar.f356432a && (list = aVar.f356434c) != null && list.size() != 0) {
            arrayList = new ArrayList();
            for (d dVar : list) {
                if (d(dVar.f356443a, str) && (list2 = dVar.f356444b) != null && list2.size() > 0) {
                    Iterator<c> it = dVar.f356444b.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new e(it.next(), str));
                    }
                }
            }
            if (aVar.f356433b == 1) {
                Collections.shuffle(arrayList);
            }
        }
        return arrayList;
    }
}
