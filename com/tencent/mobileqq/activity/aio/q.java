package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q implements Manager {
    private static int[] E = {MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED, MessageRecord.MSG_TYPE_PL_NEWS, MessageRecord.MSG_TYPE_MEDAL_NEWS, MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED, MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE, MessageRecord.MSG_TYPE_AIO_FOR_STORY_VIDEO, -7009, -7010, -7011, -7012, MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED, -7015, -7016};
    public static final int[] F = {-7015};
    public static final int[] G = {13, 1, 3, 14, 15, 16, 17, 6};
    public static int[] H = {14, 15};
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f179766d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<Integer> f179767e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Map<Integer, BeancurdMsg>> f179768f = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Long> f179769h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private final int f179770i = 10000;

    /* renamed from: m, reason: collision with root package name */
    private boolean f179771m = true;
    private int D = 3;

    public q(QQAppInterface qQAppInterface) {
        this.f179766d = qQAppInterface;
        g();
    }

    private boolean a(BeancurdMsg beancurdMsg) {
        boolean z16;
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (K0 > beancurdMsg.startTime + beancurdMsg.validTime) {
            z16 = false;
        } else {
            z16 = true;
        }
        i(String.format("busiID:%d,now:%d,BeancurdMsg.startTime:%d,validTime:%d", Integer.valueOf(beancurdMsg.busiid), Long.valueOf(K0), Long.valueOf(beancurdMsg.startTime), Long.valueOf(beancurdMsg.validTime)));
        return z16;
    }

    private int e(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = E;
            if (i16 >= iArr.length) {
                return 0;
            }
            if (iArr[i16] == i3) {
                return i16 + 1;
            }
            i16++;
        }
    }

    private String f() {
        return "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
    }

    private void g() {
        String str;
        com.tencent.mobileqq.tofumsg.j jVar = (com.tencent.mobileqq.tofumsg.j) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101424");
        if (jVar != null) {
            str = jVar.f293264m;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = f();
        }
        k(str);
        EntityManager createEntityManager = this.f179766d.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(BeancurdMsg.class, new BeancurdMsg().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            i(String.format("init.beancurd table count = %d", Integer.valueOf(query.size())));
        }
        if (query != null && query.size() > 10000) {
            query.clear();
            createEntityManager.drop(BeancurdMsg.class);
        }
        if (query != null && query.size() > 0) {
            i(String.format("init: has BeancurdMsg  size = %d ", Integer.valueOf(query.size())));
            Iterator<? extends Entity> it = query.iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                BeancurdMsg beancurdMsg = (BeancurdMsg) it.next();
                i(" the table pending show msg :" + beancurdMsg);
                if (!a(beancurdMsg)) {
                    i(String.format("init: has invalid msg  ", new Object[0]));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(beancurdMsg);
                } else {
                    String str2 = beancurdMsg.frienduin;
                    Map<Integer, BeancurdMsg> map = this.f179768f.get(str2);
                    if (map == null) {
                        map = new ConcurrentHashMap<>(6);
                    }
                    map.put(Integer.valueOf(beancurdMsg.busiid), beancurdMsg);
                    this.f179768f.put(str2, map);
                }
            }
            if (arrayList != null) {
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    createEntityManager.remove((BeancurdMsg) it5.next());
                }
            }
        } else {
            i(String.format("init: has no BeancurdMsg  ", new Object[0]));
        }
        createEntityManager.close();
    }

    public static boolean h(MessageRecord messageRecord) {
        for (int i3 : E) {
            if (messageRecord.msgtype == i3) {
                return true;
            }
        }
        return false;
    }

    private void i(String str) {
        if (QLog.isColorLevel() && this.f179771m) {
            QLog.d("BeancurdManager", 2, "fight: " + str);
        }
    }

    public void b(String str, int i3, int i16) {
        BeancurdMsg beancurdMsg;
        if (TextUtils.isEmpty(str)) {
            QLog.d("BeancurdManager", 1, "deleteBeancurdMsg, uin is null");
            return;
        }
        Map<Integer, BeancurdMsg> map = this.f179768f.get(str);
        if (map != null && (beancurdMsg = map.get(Integer.valueOf(i16))) != null) {
            map.remove(Integer.valueOf(i16));
            this.f179768f.put(str, map);
            this.f179766d.getEntityManagerFactory().createEntityManager().remove(beancurdMsg);
        }
    }

    public boolean c(List<MessageRecord> list, boolean z16) {
        boolean z17;
        int i3 = this.D;
        int size = list.size();
        if (i3 > 0 && size > 0) {
            int i16 = 0;
            while (i16 < Math.min(i3, size) && e(list.get((size - i16) - 1).msgtype) <= 0) {
                i16++;
            }
            if (i16 < Math.min(i3, size)) {
                MessageRecord remove = list.remove((size - i16) - 1);
                if (remove != null && z16) {
                    this.f179766d.getMessageFacade().A0(remove.frienduin, remove.istroop, remove.msgtype, remove.uniseq);
                    this.f179766d.getMessageFacade().T1(remove.frienduin, remove.istroop, remove.uniseq);
                }
                z17 = true;
                i(String.format(" filter beancurd is = %b", Boolean.valueOf(z17)));
                return z17;
            }
        }
        z17 = false;
        i(String.format(" filter beancurd is = %b", Boolean.valueOf(z17)));
        return z17;
    }

    public BeancurdMsg d(String str, int i3, int i16) {
        Map<Integer, BeancurdMsg> map;
        if (!TextUtils.isEmpty(str) && (map = this.f179768f.get(str)) != null) {
            return map.get(Integer.valueOf(i16));
        }
        return null;
    }

    public void j(String str) {
        i(String.format(" onDelFriend = %s", str));
        for (int i3 = 1; i3 <= 18; i3++) {
            b(str, 0, i3);
        }
    }

    public void k(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("priority") && (jSONObject = jSONObject2.getJSONObject("priority")) != null && jSONObject.length() > 0) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    this.f179767e.append(Integer.parseInt(obj), Integer.valueOf(jSONObject.optInt(obj)));
                }
            }
            if (jSONObject2.has(WidgetCacheConstellationData.INTERVAL)) {
                this.D = jSONObject2.optInt(WidgetCacheConstellationData.INTERVAL);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            i("parseConfig.error:" + e16.getMessage());
        }
    }

    public boolean l(BeancurdMsg beancurdMsg) {
        return false;
    }

    public void m(int i3, int i16) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        str = "";
                    } else {
                        str = "0x8009434";
                    }
                } else {
                    str = "0x8009433";
                }
            } else {
                str = "0x8009432";
            }
        } else {
            str = "0x8009431";
        }
        String str2 = str;
        ReportController.o(this.f179766d, "dc00898", "", "", str2, str2, 0, 0, "", Integer.toString(i16), "", "");
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        i(" onDestory...");
        this.C = true;
        this.f179767e.clear();
        this.f179768f.clear();
        this.f179769h.clear();
    }
}
