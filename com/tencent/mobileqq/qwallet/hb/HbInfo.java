package com.tencent.mobileqq.qwallet.hb;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HbInfo {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private static Map<Integer, Integer> f277193a = new HashMap<Integer, Integer>() { // from class: com.tencent.mobileqq.qwallet.hb.HbInfo.1
        {
            put(0, 1);
            put(1, 1);
            put(2, 32);
            put(3, 64);
            put(5, 2048);
            put(6, 65536);
            put(7, 131072);
            put(8, 262144);
            put(9, 524288);
            put(10, 1000001);
            put(11, 1024);
            put(15, 1000002);
            put(16, 1000003);
            put(17, 1000004);
            put(18, Integer.valueOf(QAdConfigDefine$APPID.QQLIVE));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f277194b = new ArrayList(Arrays.asList("4", "5", "7"));

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f277195c = new ArrayList(Arrays.asList("1", "4", "5", "7"));

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f277196d = new ArrayList(Arrays.asList("2", "3", "6", "", null));

    /* renamed from: e, reason: collision with root package name */
    public static final List<String> f277197e = new ArrayList(Arrays.asList("2", "3", "11", "", null));

    /* renamed from: f, reason: collision with root package name */
    public static final List<String> f277198f = new ArrayList(Arrays.asList("2", "3", "11"));

    /* renamed from: g, reason: collision with root package name */
    public static final List<String> f277199g = new ArrayList(Arrays.asList("6", "11"));

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        public String biz_params;
        public String bus_type;
        public String guild_id = "0";
        public String panel_name;
        public String people_num;
        public String pick_entry;
        public String recv_type;
        public String recv_uin;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("people_num: " + this.people_num);
            stringBuffer.append("recv_type: " + this.recv_type);
            stringBuffer.append("bus_type: " + this.bus_type);
            stringBuffer.append("pick_entry: " + this.pick_entry);
            stringBuffer.append("biz_params: " + this.biz_params);
            stringBuffer.append("panel_name: " + this.panel_name);
            stringBuffer.append("guild_id: " + this.guild_id);
            return stringBuffer.toString();
        }
    }

    @Nullable
    public static Integer a(int i3) {
        return f277193a.get(Integer.valueOf(i3));
    }

    public static int b(int i3, int i16) {
        if (i3 == 1) {
            if (i16 != 1) {
                return 1;
            }
            return 0;
        }
        for (Integer num : f277193a.keySet()) {
            Integer num2 = f277193a.get(num);
            if (num2 != null && num2.intValue() == i3) {
                return num.intValue();
            }
        }
        return 1;
    }

    public static void c(Bundle bundle, a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = aVar.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Field field = (Field) arrayList.get(i3);
            String name = field.getName();
            String simpleName = field.getType().getSimpleName();
            if (QLog.isDebugVersion()) {
                QLog.i("HbInfo", 4, "key = " + name + " tname = " + simpleName);
            }
            String string = bundle.getString(name);
            if (string != null) {
                try {
                    if (QLog.isDebugVersion()) {
                        QLog.i("HbInfo", 4, "set " + name + " = " + string);
                    }
                    if (simpleName.equals(Entry.DATA_TYPE_STRING)) {
                        field.set(aVar, string);
                    }
                } catch (Exception e16) {
                    QLog.e("HbInfo", 1, "error msg in qqpay-api module: ", e16);
                }
            }
        }
    }
}
