package com.tencent.mobileqq.leba.utils;

import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(List<n> list, List<n> list2) {
        if (LebaPluginLogic.e() != 0) {
            list.addAll(list2);
            return;
        }
        for (n nVar : list2) {
            if (nVar.f240505b != null) {
                list.add(nVar);
            }
        }
    }
}
