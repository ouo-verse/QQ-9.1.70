package com.tencent.mobileqq.mutualmark.oldlogic;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class OldMutualMarkLogicHelper {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper$1$a */
            /* loaded from: classes15.dex */
            class a implements hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ HashSet f252237a;

                a(HashSet hashSet) {
                    this.f252237a = hashSet;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) hashSet);
                    }
                }

                @Override // hx3.c
                public void onUpdateResult(@Nullable e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    } else {
                        this.f252237a.clear();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashSet<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> g16 = com.tencent.mobileqq.mutualmark.oldlogic.a.g();
                ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> arrayList = new ArrayList<>();
                if (g16 != null && !g16.isEmpty()) {
                    Iterator<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> it = g16.iterator();
                    while (it.hasNext()) {
                        com.tencent.qqnt.ntrelation.intimateinfo.bean.a next = it.next();
                        if (next != null) {
                            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(next.getUid(), next.n());
                            aVar.q();
                            aVar.z(next.m());
                            arrayList.add(aVar);
                        }
                    }
                    ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(arrayList, "OldMutualMarkLogicHelper", new a(g16));
                }
            }
        }, 5, null, true);
    }
}
