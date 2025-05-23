package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.af;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

/* loaded from: classes32.dex */
public class SendPanelManager implements Manager {
    private b C;
    private Handler E;
    private volatile String H;

    /* renamed from: d, reason: collision with root package name */
    private af f68798d;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, String> f68800f;

    /* renamed from: e, reason: collision with root package name */
    private List<RecentUser> f68799e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f68801h = false;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f68802i = false;

    /* renamed from: m, reason: collision with root package name */
    private CopyOnWriteArrayList<e> f68803m = new CopyOnWriteArrayList<>();
    private int D = 0;
    public volatile boolean F = false;
    public volatile String G = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final SendPanelManager f68810a = new SendPanelManager();
    }

    SendPanelManager() {
        p();
    }

    private void B(e eVar, int i3, int i16) {
        int i17 = eVar.f68838e;
        if (i17 != 1) {
            if (i17 == 0) {
                if (i3 == 1003 || i3 == 1007) {
                    eVar.f68838e = 3;
                    eVar.f68839f = 100;
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1003 || i3 == 1007) {
            eVar.f68838e = 3;
            eVar.f68839f = 100;
        } else if (i3 != 1004 && i3 != 1005 && i3 != 1006) {
            eVar.f68839f = i16;
        } else {
            eVar.f68838e = 2;
        }
    }

    private void g() {
        this.f68799e.clear();
        this.D = 0;
        this.f68801h = false;
        this.f68802i = false;
        HashMap<String, String> hashMap = this.f68800f;
        if (hashMap != null) {
            hashMap.clear();
            this.f68800f = null;
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f68803m;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
    }

    private void h() {
        Pair<Boolean, Boolean> c16;
        if (this.f68801h && this.f68802i) {
            if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "conformAllData");
            }
            List<RecentUser> list = this.f68799e;
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (RecentUser recentUser : this.f68799e) {
                    e eVar = new e();
                    eVar.f68834a = recentUser.uin;
                    eVar.f68835b = recentUser.troopUin;
                    if (recentUser.getType() == 1000) {
                        eVar.f68836c = recentUser.displayName;
                        arrayList.add(recentUser);
                    } else {
                        eVar.f68836c = l(recentUser);
                    }
                    if (recentUser.getType() == 1 && (c16 = com.tencent.aelight.camera.aioeditor.editipc.a.c(recentUser.uin)) != null) {
                        if (c16.first.booleanValue()) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SendPanelManager", 2, "conformAllData troop is disband");
                            }
                        } else {
                            eVar.f68844k = c16.second.booleanValue();
                        }
                    }
                    eVar.f68837d = recentUser.getType();
                    if (recentUser.getType() == 0 && !TextUtils.isEmpty(eVar.f68834a) && (TextUtils.isEmpty(eVar.f68836c) || eVar.f68834a.equals(eVar.f68836c))) {
                        eVar.f68836c = com.tencent.aelight.camera.aioeditor.editipc.a.b(eVar.f68834a);
                    }
                    this.f68803m.add(eVar);
                }
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        l((RecentUser) it.next());
                    }
                }
                List<RecentUser> list2 = this.f68799e;
                if (list2 != null) {
                    list2.clear();
                }
                HashMap<String, String> hashMap = this.f68800f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                if (this.C != null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish");
                    }
                    this.D = 2;
                    t();
                    return;
                }
                return;
            }
            if (this.C != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish recentUserList is empty");
                }
                this.D = 2;
                t();
            }
        }
    }

    private boolean i(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 3000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.F = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).getBoolean("send_panel_animation_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true);
    }

    public static SendPanelManager k() {
        return a.f68810a;
    }

    private String l(RecentUser recentUser) {
        HashMap<String, String> hashMap;
        String str = "";
        if (recentUser == null || (hashMap = this.f68800f) == null || hashMap.isEmpty()) {
            return "";
        }
        int type = recentUser.getType();
        if (type == 0) {
            str = this.f68800f.get(recentUser.uin + 0);
        } else if (type == 1) {
            str = this.f68800f.get(recentUser.uin + 1);
        } else if (type == 1000) {
            com.tencent.aelight.camera.aioeditor.editipc.a.d(recentUser.troopUin, recentUser.uin);
        } else if (type == 1004) {
            str = this.f68798d.c(recentUser.troopUin, recentUser.uin);
        } else if (type == 3000) {
            str = this.f68798d.e(recentUser.uin);
        }
        return TextUtils.isEmpty(str) ? recentUser.displayName : str;
    }

    private void o() {
        this.f68800f = new HashMap<>();
    }

    private void p() {
        af afVar = new af();
        this.f68798d = afVar;
        afVar.b();
        this.E = new Handler(Looper.getMainLooper());
        com.tencent.aelight.camera.aioeditor.editipc.b.registerModule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f68798d.g(0, this.f68800f);
        this.f68798d.k(1, this.f68800f);
        this.f68802i = true;
        if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "loadNameList finish");
        }
        h();
    }

    private void r() {
        if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "loadPanelData");
        }
        b bVar = this.C;
        if (bVar != null) {
            bVar.onLoadStart();
        }
        g();
        o();
        this.D = 1;
        try {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.1
                @Override // java.lang.Runnable
                public void run() {
                    SendPanelManager.this.j();
                }
            });
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.2
                @Override // java.lang.Runnable
                public void run() {
                    SendPanelManager.this.q();
                }
            });
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.3
                @Override // java.lang.Runnable
                public void run() {
                    SendPanelManager.this.s();
                }
            });
        } catch (Exception e16) {
            if (this.C != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("SendPanelManager", 2, "loadPanelData exception = " + e16.getMessage());
                }
                this.D = 3;
                t();
            }
        } catch (OutOfMemoryError unused) {
            if (this.C != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("SendPanelManager", 2, "loadPanelData OutOfMemoryError");
                }
                this.D = 3;
                t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        f(this.f68798d.j(RecentUser.class, "select * from recent order by lastmsgtime desc", null));
        x();
        this.f68801h = true;
        if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "loadRecentUserList finish");
        }
        h();
    }

    private void t() {
        if (this.C != null) {
            this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.4
                @Override // java.lang.Runnable
                public void run() {
                    SendPanelManager.this.C.a(SendPanelManager.this.f68803m);
                }
            });
        }
    }

    private void x() {
        List<RecentUser> list = this.f68799e;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (RecentUser recentUser : this.f68799e) {
            if (recentUser.showUpTime > 0) {
                arrayList.add(recentUser);
            } else {
                arrayList2.add(recentUser);
            }
        }
        this.f68799e.clear();
        if (arrayList.size() > 0) {
            Collections.sort(arrayList, new c());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f68799e.add((RecentUser) it.next());
            }
        }
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, new c());
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                this.f68799e.add((RecentUser) it5.next());
            }
        }
    }

    public void A(String str, int i3, String str2, String str3, boolean z16) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f68803m;
            final e eVar = null;
            final int i16 = -1;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                int size = this.f68803m.size();
                for (int i17 = 0; i17 < size; i17++) {
                    e eVar2 = this.f68803m.get(i17);
                    eVar2.f68845l = str2;
                    eVar2.f68846m = str3;
                    eVar2.f68842i = z16;
                    if (!TextUtils.isEmpty(eVar2.f68834a) && eVar2.f68834a.equals(str) && i3 == eVar2.f68837d) {
                        i16 = i17;
                        eVar = eVar2;
                    }
                }
            }
            if (eVar != null) {
                eVar.f68838e = 1;
                if (this.C != null) {
                    this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.7
                        @Override // java.lang.Runnable
                        public void run() {
                            SendPanelManager.this.C.Q(i16, eVar);
                        }
                    });
                }
                if (z16) {
                    com.tencent.aelight.camera.aioeditor.editipc.a.k(eVar.f68845l, str3, eVar, this.G, this.H);
                } else {
                    com.tencent.aelight.camera.aioeditor.editipc.a.j(str2, eVar, this.G, this.H);
                }
                eVar.f68843j = true;
                com.tencent.aelight.camera.aioeditor.b.j(eVar);
                ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportPostBtn(eVar.f68847n, eVar.f68837d);
                ms.a.f("SendPanelManager", "\u3010updateFilePath\u3011messageType:" + eVar.f68837d);
                z(str, i3, eVar.f68847n);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "updateFilePath can not find sendItemInfo");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "updateFilePath fail uin = " + str + " ,filePath = " + str2);
        }
        b bVar = this.C;
        if (bVar != null) {
            bVar.q();
        }
    }

    public void C(String str, int i3, int i16, int i17, long j3) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "updateOperateStatus uin is null");
                return;
            }
            return;
        }
        if (this.C == null || (copyOnWriteArrayList = this.f68803m) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        int size = this.f68803m.size();
        for (final int i18 = 0; i18 < size; i18++) {
            final e eVar = this.f68803m.get(i18);
            if (!TextUtils.isEmpty(eVar.f68834a) && eVar.f68834a.equals(str) && eVar.f68837d == i3 && eVar.f68843j) {
                B(eVar, i16, i17);
                if (eVar.f68848o <= 0) {
                    eVar.f68848o = j3;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("SendPanelManager", 2, "updateOperateStatus operateStatus = " + eVar.f68838e + " ,progress = " + eVar.f68839f + " ,position = " + i18 + ", uinseq:" + eVar.f68848o);
                }
                this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SendPanelManager.this.C.Q(i18, eVar);
                    }
                });
                return;
            }
        }
    }

    public void D(String str, String str2) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.C != null && (copyOnWriteArrayList = this.f68803m) != null && copyOnWriteArrayList.size() > 0) {
                int size = this.f68803m.size();
                for (final int i3 = 0; i3 < size; i3++) {
                    final e eVar = this.f68803m.get(i3);
                    if (!TextUtils.isEmpty(eVar.f68834a) && eVar.f68834a.equals(str) && eVar.f68837d == 1000) {
                        eVar.f68836c = str2;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendPanelManager", 2, "updateTroopMemberName");
                        }
                        this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager.5
                            @Override // java.lang.Runnable
                            public void run() {
                                SendPanelManager.this.C.Q(i3, eVar);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "updateTroopMemberName exception uin = " + str + " ,name = " + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "updateTroopMemberName uin = " + str + " ,name = " + str2);
        }
    }

    public List<e> m() {
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f68803m;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            return this.f68803m;
        }
        r();
        return null;
    }

    public String n() {
        return this.H;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "onDestroy()");
        }
        g();
        b bVar = this.C;
        if (bVar != null) {
            bVar.destroy();
            this.C = null;
        }
    }

    public void u(String str) {
        this.G = str;
    }

    public void v(b bVar) {
        this.C = bVar;
    }

    public void w(String str) {
        this.H = str;
    }

    public void y(boolean z16) {
        BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).edit().putBoolean("send_panel_animation_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), z16).apply();
    }

    public void z(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "updateFilePath fileMd5 is null");
                return;
            }
            return;
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f68803m;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<e> it = this.f68803m.iterator();
        while (it.hasNext()) {
            it.next().f68847n = str2;
        }
    }

    private void f(List<RecentUser> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (RecentUser recentUser : list) {
            if (i(recentUser.getType())) {
                this.f68799e.add(recentUser);
            }
        }
    }
}
