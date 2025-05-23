package com.tencent.mobileqq.activity.aio.helper;

import androidx.annotation.NonNull;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public class ay implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f178823d;

    /* renamed from: e, reason: collision with root package name */
    private String f178824e;

    /* renamed from: f, reason: collision with root package name */
    ITroopCardAppInfoHelperApi f178825f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f178826h = false;

    /* renamed from: i, reason: collision with root package name */
    ITroopCardAppInfoHelperApi.a f178827i = new a();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements ITroopCardAppInfoHelperApi.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.a
        public void onFailed() {
            ChatActivityUtils.G(ay.this.f178824e, ay.this.g().getCurrentAccountUin());
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_AIO, 2, "getAppIds onFailed, reqNotifyItems");
            }
            TroopAioNotifyManager.d(ay.this.g(), ay.this.f178824e);
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.a
        public void onSuccess(ArrayList<TroopAppInfo> arrayList) {
            if (ay.this.g() == null || ay.this.f178824e == null || ChatActivityUtils.G(ay.this.f178824e, ay.this.g().getCurrentAccountUin()) != null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(1L);
            arrayList2.add(2L);
            arrayList2.add(1101236949L);
            arrayList2.add(1101484419L);
            arrayList2.add(1102858908L);
            arrayList2.add(1104445552L);
            arrayList2.add(1106717414L);
            arrayList2.add(101509131L);
            arrayList2.add(1106588005L);
            arrayList2.add(1106664488L);
            arrayList2.add(101618516L);
            arrayList2.add(101872323L);
            arrayList2.add(101890494L);
            arrayList2.add(101896870L);
            TroopInfo k3 = ((TroopManager) ay.this.g().getManager(QQManagerFactory.TROOP_MANAGER)).k(ay.this.f178824e);
            if (k3 != null && k3.isOwnerOrAdmin(ay.this.g().getCurrentAccountUin())) {
                arrayList2.add(101913298L);
            }
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<TroopAppInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(it.next().appId));
                }
            }
            qt2.a aVar = (qt2.a) ay.this.g().getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER);
            if (aVar != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_AIO, 2, "send_oidb_0x8c9_2, appIds.size=" + arrayList2.size());
                }
                aVar.b2(ay.this.f178824e, arrayList2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface g() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str, boolean z16) {
        if (this.f178826h && str.equals(this.f178824e)) {
            n(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(final String str) {
        final boolean z16;
        if (!this.f178826h) {
            return;
        }
        if (ChatActivityUtils.G(this.f178824e, g().getCurrentAccountUin()) == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.ax
            @Override // java.lang.Runnable
            public final void run() {
                ay.this.h(str, z16);
            }
        });
    }

    private void n(boolean z16) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_AIO, 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
            }
            ITroopCardAppInfoHelperApi iTroopCardAppInfoHelperApi = this.f178825f;
            if (iTroopCardAppInfoHelperApi != null) {
                iTroopCardAppInfoHelperApi.getAppInfoBriefList(this.f178824e, this.f178827i, true);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_AIO, 2, "onShow_troopType, reqNotifyItems");
        }
        TroopAioNotifyManager.d(g(), this.f178824e);
        ((TroopShortcutBarManager) g().getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).e(this.f178824e);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350652m;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopRedTipHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NonNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    protected void j() {
        if (g() != null) {
            ITroopCardAppInfoHelperApi iTroopCardAppInfoHelperApi = (ITroopCardAppInfoHelperApi) QRoute.api(ITroopCardAppInfoHelperApi.class);
            this.f178825f = iTroopCardAppInfoHelperApi;
            iTroopCardAppInfoHelperApi.init(g());
        }
    }

    protected void k() {
        ITroopCardAppInfoHelperApi iTroopCardAppInfoHelperApi = this.f178825f;
        if (iTroopCardAppInfoHelperApi != null) {
            iTroopCardAppInfoHelperApi.destroy();
            this.f178825f = null;
        }
    }

    protected void m() {
        final String str;
        if (g() != null && (str = this.f178824e) != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.aw
                @Override // java.lang.Runnable
                public final void run() {
                    ay.this.i(str);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        this.f178826h = true;
        com.tencent.aio.api.runtime.a a16 = bVar.a();
        this.f178823d = a16;
        this.f178824e = a16.g().r().c().j();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.f178826h = false;
        this.f178823d = null;
        this.f178824e = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
        if (i3 != 0) {
            if (i3 != 3) {
                if (i3 == 12) {
                    k();
                    return;
                }
                return;
            }
            m();
            return;
        }
        j();
    }
}
