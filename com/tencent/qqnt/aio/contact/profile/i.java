package com.tencent.qqnt.aio.contact.profile;

import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;

/* compiled from: P */
/* loaded from: classes23.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayMap<Integer, d> f349855a;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.contact.profile.i.d
        public AllInOne a(QQAppInterface qQAppInterface, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AllInOne) iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, str2);
            }
            AllInOne allInOne = new AllInOne(str2, 70);
            allInOne.nickname = ac.G(qQAppInterface, str2);
            return allInOne;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.contact.profile.i.d
        public AllInOne a(QQAppInterface qQAppInterface, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AllInOne) iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, str2);
            }
            AllInOne allInOne = new AllInOne(str2, 21);
            allInOne.subSourceId = 11;
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "NewAllInOneFactory");
            if (troopMemberInfoSync != null) {
                allInOne.nickname = troopMemberInfoSync.nickInfo.getShowName();
            }
            return allInOne;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class c implements d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.contact.profile.i.d
        public AllInOne a(QQAppInterface qQAppInterface, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AllInOne) iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, str2);
            }
            AllInOne allInOne = new AllInOne(str2, 46);
            allInOne.nickname = ac.n(qQAppInterface, str, str2);
            return allInOne;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface d {
        AllInOne a(QQAppInterface qQAppInterface, String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayMap<Integer, d> arrayMap = new ArrayMap<>();
        f349855a = arrayMap;
        arrayMap.put(1, new a());
        arrayMap.put(2, new b());
        arrayMap.put(3, new c());
    }

    public static AllInOne a(QQAppInterface qQAppInterface, String str, int i3, String str2, String str3) {
        ArrayMap<Integer, d> arrayMap = f349855a;
        if (arrayMap.containsKey(Integer.valueOf(i3))) {
            return arrayMap.get(Integer.valueOf(i3)).a(qQAppInterface, str, str3);
        }
        if (i3 == 111) {
            AllInOne allInOne = new AllInOne(str3, 34);
            allInOne.nickname = str2;
            return allInOne;
        }
        if (i3 == 101) {
            AllInOne allInOne2 = new AllInOne(str3, 70);
            allInOne2.nickname = str2;
            return allInOne2;
        }
        AllInOne allInOne3 = new AllInOne(str3, 19);
        allInOne3.nickname = str2;
        return allInOne3;
    }
}
