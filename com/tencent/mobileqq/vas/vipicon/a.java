package com.tencent.mobileqq.vas.vipicon;

import LBSClientInterfaceV2.POITYPE;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends QQVasUpdateBusiness {

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f311305b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f311306c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f311307a = false;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f311305b = hashMap;
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        f311306c = hashMap2;
        hashMap.put(0, 49);
        hashMap.put(1, 22);
        hashMap.put(2, 21);
        hashMap.put(3, 20);
        hashMap.put(4, 25);
        hashMap.put(5, 24);
        hashMap.put(6, 23);
        hashMap.put(17, 29);
        hashMap.put(7, 28);
        hashMap.put(8, 27);
        hashMap.put(9, 26);
        hashMap.put(18, 34);
        hashMap.put(19, 33);
        hashMap.put(10, 32);
        hashMap.put(11, 31);
        hashMap.put(12, 30);
        hashMap.put(20, 39);
        hashMap.put(21, 38);
        hashMap.put(13, 37);
        hashMap.put(14, 36);
        hashMap.put(15, 35);
        hashMap.put(22, 44);
        hashMap.put(23, 43);
        hashMap.put(24, 42);
        hashMap.put(25, 41);
        hashMap.put(26, 40);
        hashMap.put(16, 45);
        hashMap2.put(Integer.valueOf(POITYPE._POI_INFRA), 22);
        hashMap2.put(Integer.valueOf(POITYPE._POI_WORK), 21);
        hashMap2.put(290000, 20);
        hashMap2.put(370000, 25);
        hashMap2.put(380000, 24);
        hashMap2.put(390000, 23);
        hashMap2.put(460000, 29);
        hashMap2.put(470000, 28);
        hashMap2.put(480000, 27);
        hashMap2.put(490000, 26);
        hashMap2.put(550000, 34);
        hashMap2.put(560000, 33);
        hashMap2.put(570000, 32);
        hashMap2.put(580000, 31);
        hashMap2.put(590000, 30);
        hashMap2.put(650000, 39);
        hashMap2.put(660000, 38);
        hashMap2.put(670000, 37);
        hashMap2.put(680000, 36);
        hashMap2.put(690000, 35);
        hashMap2.put(750000, 44);
        hashMap2.put(760000, 43);
        hashMap2.put(770000, 42);
        hashMap2.put(780000, 41);
        hashMap2.put(790000, 40);
        hashMap2.put(850000, 45);
        hashMap2.put(860000, 47);
    }

    private static void h() {
        if (com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
            QLog.d("VasUpdate_QQBusiness", 1, "initWzryConfig");
        }
        JSONObject json = VasNtToggle.VIP_KING_ID_CONFIG.getJson();
        try {
            if (json.has("gamerank_ids")) {
                JSONObject optJSONObject = json.optJSONObject("gamerank_ids");
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    f311305b.put(Integer.valueOf(Integer.parseInt(str)), Integer.valueOf(optJSONObject.optInt(str)));
                    if (com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
                        QLog.d("VasUpdate_QQBusiness", 1, "add gamerank_ids " + str + " - " + optJSONObject.optInt(str));
                    }
                }
            }
            if (json.has("gamelevel_ids")) {
                JSONObject optJSONObject2 = json.optJSONObject("gamelevel_ids");
                Iterator keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String str2 = (String) keys2.next();
                    f311306c.put(Integer.valueOf(Integer.parseInt(str2)), Integer.valueOf(optJSONObject2.optInt(str2)));
                    if (com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
                        QLog.d("VasUpdate_QQBusiness", 1, "add gamelevel_ids " + str2 + " - " + optJSONObject2.optInt(str2));
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("VasUpdate_QQBusiness", 1, e16, new Object[0]);
        }
    }

    public String e(int i3) {
        return getSavePath(getScid(i3)) + File.separator + "gamenameplate/ext_icon.png";
    }

    public String f(int i3) {
        return getSavePath(getScid(i3)) + File.separator + "gamenameplate/icon.png";
    }

    public int g(int i3, boolean z16) {
        if (!this.f311307a) {
            synchronized (this) {
                if (!this.f311307a) {
                    this.f311307a = true;
                    h();
                }
            }
        }
        if (z16) {
            Integer num = f311306c.get(Integer.valueOf(i3));
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        Integer num2 = f311305b.get(Integer.valueOf(i3));
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 55L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "gamenameplate";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "gamenameplate";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "55." + i3;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
