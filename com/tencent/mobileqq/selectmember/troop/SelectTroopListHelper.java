package com.tencent.mobileqq.selectmember.troop;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.adapter.contact.d;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectTroopListHelper {
    static IPatchRedirector $redirector_;

    static /* synthetic */ AppInterface a() {
        return d();
    }

    public static void b(boolean z16, Consumer<List<TroopInfo>> consumer) {
        if (d() == null) {
            return;
        }
        c(z16, consumer);
    }

    private static void c(boolean z16, Consumer<List<TroopInfo>> consumer) {
        if (d() == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(z16, consumer) { // from class: com.tencent.mobileqq.selectmember.troop.SelectTroopListHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f286003e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Consumer f286004f;

            {
                this.f286003e = z16;
                this.f286004f = consumer;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, RecentUserProxy.this, Boolean.valueOf(z16), consumer);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List<TroopInfo> sortedJoinedValidTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedValidTroopInfoFromCache();
                IDiscussionService iDiscussionService = (IDiscussionService) SelectTroopListHelper.a().getRuntimeService(IDiscussionService.class, "");
                ArrayList<DiscussionInfo> arrayList3 = (ArrayList) iDiscussionService.getDiscussList();
                ArrayList<DiscussionInfo> arrayList4 = new ArrayList();
                int i3 = 0;
                for (DiscussionInfo discussionInfo : arrayList3) {
                    if (discussionInfo != null && !TextUtils.isEmpty(discussionInfo.uin)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SelectTroopListHelper", 2, "load data asyncLoadTroopListAndNotifyUi discussion : " + discussionInfo);
                        }
                        if (!TextUtils.isEmpty(discussionInfo.discussionName)) {
                            arrayList4.add(discussionInfo);
                        } else if (i3 >= 40) {
                            arrayList4.add(discussionInfo);
                        } else if (iDiscussionService.getDiscussionMemberNum(discussionInfo.uin) > 0) {
                            arrayList4.add(discussionInfo);
                            i3++;
                        } else {
                            i3++;
                            QLog.d("SelectTroopListHelper", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + discussionInfo);
                        }
                    }
                }
                List<TroopInfo> sortedJoinedTopTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTopTroopInfoFromCache();
                if (QLog.isColorLevel()) {
                    QLog.d("SelectTroopListHelper", 2, "getCommonlyUsedTroopList troops size= " + sortedJoinedTopTroopInfoFromCache.size());
                }
                Iterator<TroopInfo> it = sortedJoinedTopTroopInfoFromCache.iterator();
                while (it.hasNext()) {
                    SelectTroopListHelper.e(it.next(), RecentUserProxy.this);
                }
                String currentUin = SelectTroopListHelper.a().getCurrentUin();
                for (TroopInfo troopInfo : sortedJoinedValidTroopInfoFromCache) {
                    SelectTroopListHelper.e(troopInfo, RecentUserProxy.this);
                    int troopMaskPriority = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMaskPriority(troopInfo.troopuin);
                    if (troopInfo.isOwner()) {
                        arrayList.add(new d(troopMaskPriority, troopInfo));
                    } else if (troopInfo.isAdmin()) {
                        arrayList2.add(new d(troopMaskPriority, troopInfo));
                    }
                }
                for (DiscussionInfo discussionInfo2 : arrayList4) {
                    discussionInfo2.lastMsgTime = RecentUserProxy.this.findRecentUserByUin(discussionInfo2.uin, 3000).lastmsgtime;
                    if (currentUin.equals(discussionInfo2.ownerUin)) {
                        arrayList.add(new d(1, discussionInfo2));
                    }
                }
                com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
                Collections.sort(arrayList, bVar);
                Collections.sort(arrayList2, bVar);
                ArrayList arrayList5 = new ArrayList();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    Object obj = ((d) it5.next()).f293809b;
                    if (obj instanceof TroopInfo) {
                        arrayList5.add((TroopInfo) obj);
                    }
                }
                if (!this.f286003e) {
                    Iterator it6 = arrayList2.iterator();
                    while (it6.hasNext()) {
                        Object obj2 = ((d) it6.next()).f293809b;
                        if (obj2 instanceof TroopInfo) {
                            arrayList5.add((TroopInfo) obj2);
                        }
                    }
                }
                this.f286004f.accept(arrayList5);
            }
        }, 32, null, true);
    }

    private static AppInterface d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e("SelectTroopListHelper", 1, "getAppInterface appRuntime error");
            return null;
        }
        return (AppInterface) peekAppRuntime;
    }

    public static void e(TroopInfo troopInfo, RecentUserProxy recentUserProxy) {
        if (d() == null) {
            return;
        }
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(d(), troopInfo.troopuin) == GroupMsgMask.ASSISTANT) {
            long j3 = ((IMessageFacade) d().getRuntimeService(IMessageFacade.class, "")).getLastMessage(troopInfo.troopuin, 1).time;
            if (j3 != 0) {
                troopInfo.lastMsgTime = j3;
                return;
            }
            return;
        }
        long j16 = recentUserProxy.findRecentUserByUin(troopInfo.troopuin, 1).lastmsgtime;
        if (j16 != 0) {
            troopInfo.lastMsgTime = j16;
        }
    }
}
