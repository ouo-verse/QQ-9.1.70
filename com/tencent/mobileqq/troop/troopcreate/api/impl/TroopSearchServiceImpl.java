package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.mobileqq.troop.troopcreate.api.impl.TroopSearchServiceImpl;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqnt.troop.TroopListRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSearchServiceImpl implements ITroopSearchService {
    static IPatchRedirector $redirector_;
    private AppInterface mApp;
    ITroopInfoService troopInfoService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class TroopSearchTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ITroopSearchService.b f299992d;

        /* renamed from: e, reason: collision with root package name */
        final ArrayList<ResultRecord> f299993e;

        /* renamed from: f, reason: collision with root package name */
        int f299994f;

        /* renamed from: h, reason: collision with root package name */
        final ArrayList<ITroopSearchService.a> f299995h;

        TroopSearchTask(ITroopSearchService.b bVar, ArrayList<ResultRecord> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopSearchServiceImpl.this, bVar, arrayList);
                return;
            }
            this.f299995h = new ArrayList<>();
            this.f299992d = bVar;
            this.f299993e = arrayList;
        }

        private void b(ArrayList<ITroopSearchService.a> arrayList) {
            ITroopSearchService.b bVar = this.f299992d;
            if (bVar != null) {
                bVar.onResult(arrayList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(TroopInfo troopInfo, boolean z16, List list) {
            e(troopInfo, new ArrayList(list));
            synchronized (this.f299995h) {
                int i3 = this.f299994f - 1;
                this.f299994f = i3;
                if (i3 == 0) {
                    Collections.sort(this.f299995h);
                    b(this.f299995h);
                }
            }
        }

        private void e(TroopInfo troopInfo, List<TroopMemberInfo> list) {
            boolean z16;
            if (list == null || list.size() <= 0 || !c(list.size(), this.f299993e.size()) || this.f299993e.size() != list.size()) {
                return;
            }
            Iterator<ResultRecord> it = this.f299993e.iterator();
            boolean z17 = true;
            while (it.hasNext()) {
                ResultRecord next = it.next();
                Iterator<TroopMemberInfo> it5 = list.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (TextUtils.equals(next.uin, it5.next().memberuin)) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (z17) {
                ITroopSearchService.a aVar = new ITroopSearchService.a();
                aVar.f299977d = troopInfo;
                aVar.f299978e = list.size();
                aVar.f299979f = ChnToSpell.e(troopInfo.getTroopDisplayName(), 1).f306907b;
                troopInfo.lastMsgTime = ((IRecentUserProxyService) TroopSearchServiceImpl.this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().findRecentUserByUin(troopInfo.troopuin, 1).lastmsgtime;
                if (this.f299993e.size() == aVar.f299978e) {
                    aVar.f299980h = 1;
                    synchronized (this.f299995h) {
                        this.f299995h.add(aVar);
                    }
                }
            }
        }

        public boolean c(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            if (i16 <= 5) {
                if (i3 > 20) {
                    return false;
                }
            } else if (i16 > 6 && i16 < 20 && i3 > 50) {
                if (i3 > 50) {
                    return false;
                }
            } else if (i16 >= 20 && i3 > 100) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            List<TroopInfo> joinedTroopInfoFromCache = TroopListRepo.INSTANCE.getJoinedTroopInfoFromCache();
            if (joinedTroopInfoFromCache != null && joinedTroopInfoFromCache.size() != 0) {
                ArrayList<TroopInfo> arrayList = new ArrayList(joinedTroopInfoFromCache);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    TroopInfo troopInfo = (TroopInfo) arrayList.get(size);
                    if (!c(troopInfo.wMemberNum, this.f299993e.size())) {
                        arrayList.remove(troopInfo);
                    }
                }
                int size2 = arrayList.size();
                this.f299994f = size2;
                if (size2 == 0) {
                    b(this.f299995h);
                    return;
                }
                for (final TroopInfo troopInfo2 : arrayList) {
                    ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(troopInfo2.troopuin, null, false, "TroopSearchTask", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.k
                        @Override // com.tencent.qqnt.troopmemberlist.f
                        public final void a(boolean z16, List list) {
                            TroopSearchServiceImpl.TroopSearchTask.this.d(troopInfo2, z16, list);
                        }
                    });
                }
                return;
            }
            b(this.f299995h);
        }
    }

    public TroopSearchServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mApp = appInterface;
        this.troopInfoService = (ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService
    public void search(ArrayList<ResultRecord> arrayList, boolean z16, ITroopSearchService.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, arrayList, Boolean.valueOf(z16), bVar);
            return;
        }
        if (z16) {
            com.tencent.mobileqq.troop.troopcreate.a.a(this.mApp, arrayList);
        }
        ThreadManagerV2.postImmediately(new TroopSearchTask(bVar, arrayList), null, false);
    }
}
