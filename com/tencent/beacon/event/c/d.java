package com.tencent.beacon.event.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.a.b.i;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.pack.EventRecordV2;
import com.tencent.beacon.pack.RequestPackageV2;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f77907a = Pattern.compile("rqd_.*");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f77908b = Pattern.compile("A[0-9]{1,3}");

    /* renamed from: c, reason: collision with root package name */
    private static final Random f77909c = new Random();

    public static boolean a(int i3) {
        return i3 != 0;
    }

    private static EventRecordV2 b(EventBean eventBean) {
        if (eventBean == null) {
            return null;
        }
        EventRecordV2 eventRecordV2 = new EventRecordV2();
        eventRecordV2.appKey = eventBean.getAppKey();
        eventRecordV2.apn = eventBean.getApn() != null ? eventBean.getApn() : "";
        eventRecordV2.srcIp = eventBean.getSrcIp() != null ? eventBean.getSrcIp() : "";
        eventRecordV2.eventCode = eventBean.getEventCode();
        eventRecordV2.valueType = eventBean.getValueType();
        eventRecordV2.mapValue = eventBean.getEventValue();
        eventRecordV2.byteValue = eventBean.getByteValue();
        eventRecordV2.eventTime = eventBean.getEventTime();
        eventRecordV2.eventResult = eventBean.getEventResult();
        eventRecordV2.eventType = eventBean.getEventType();
        eventRecordV2.reserved = eventBean.getReserved();
        return eventRecordV2;
    }

    public static String c(String str) {
        if (str != null && str.length() != 0) {
            return str;
        }
        return "";
    }

    public static String d(String str) {
        if (str != null && str.length() != 0) {
            if (str.length() > 50) {
                return str.substring(0, 50);
            }
            return str;
        }
        return "DefaultPageID";
    }

    public static String e(String str) {
        if (str == null || str.length() == 0) {
            return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
        }
        String trim = str.replace(QbAddrData.DATA_SPLITER, util.base64_pad_url).trim();
        if (g(trim)) {
            if (trim.length() < 5) {
                com.tencent.beacon.base.util.c.e("[core] userID length should < 5!", new Object[0]);
            }
            if (trim.length() > 128) {
                return trim.substring(0, 128);
            }
            return trim;
        }
        com.tencent.beacon.base.util.c.e("[core] userID should be ASCII code in 32-126! userID:" + str, new Object[0]);
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    public static BeaconModule f(String str) throws Exception {
        return (BeaconModule) Class.forName(str).newInstance();
    }

    private static boolean g(String str) {
        int length = str.length();
        boolean z16 = true;
        while (true) {
            length--;
            if (length >= 0) {
                char charAt = str.charAt(length);
                if (charAt < ' ' || charAt >= '\u007f') {
                    z16 = false;
                }
            } else {
                return z16;
            }
        }
    }

    public static String a(String str) {
        if (str != null && str.trim().length() != 0) {
            if (g(str.trim())) {
                String trim = str.trim();
                return trim.length() > 16 ? trim.substring(0, 16) : trim;
            }
            com.tencent.beacon.base.util.c.e("[core] channelID should be Numeric! channelID:" + str, new Object[0]);
        }
        return "unknown";
    }

    public static RequestPackageV2 a(EventBean eventBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        return a(arrayList);
    }

    public static RequestPackageV2 a(List<EventBean> list) {
        RequestPackageV2 requestPackageV2 = new RequestPackageV2();
        requestPackageV2.appVersion = com.tencent.beacon.a.c.b.a();
        requestPackageV2.f78091common = a();
        ArrayList<EventRecordV2> arrayList = new ArrayList<>();
        Iterator<EventBean> it = list.iterator();
        while (it.hasNext()) {
            EventRecordV2 b16 = b(it.next());
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        requestPackageV2.events = arrayList;
        com.tencent.beacon.a.c.c c16 = com.tencent.beacon.a.c.c.c();
        requestPackageV2.mainAppKey = c16.e();
        requestPackageV2.model = com.tencent.beacon.a.c.f.e().h();
        requestPackageV2.osVersion = com.tencent.beacon.a.c.e.l().t();
        requestPackageV2.packageName = com.tencent.beacon.a.c.b.b();
        requestPackageV2.platformId = c16.g();
        requestPackageV2.sdkId = c16.h();
        requestPackageV2.sdkVersion = c16.i();
        requestPackageV2.reserved = "";
        return requestPackageV2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            if (com.tencent.beacon.base.util.e.f77791a.get()) {
                i.e().a("101", "eventCode == null");
                com.tencent.beacon.base.util.e.a("eventCode == null");
            }
            return "";
        }
        String trim = str.replace(QbAddrData.DATA_SPLITER, util.base64_pad_url).trim();
        if (g(trim)) {
            if (trim.length() <= 128) {
                return trim;
            }
            String str2 = str + " length > 128.";
            i.e().a("101", str2);
            com.tencent.beacon.base.util.e.a(str2);
            return trim.substring(0, 128);
        }
        String str3 = str + " is not ASCII";
        i.e().a("101", str3);
        com.tencent.beacon.base.util.e.a(str3);
        return "";
    }

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        com.tencent.beacon.a.c.e l3 = com.tencent.beacon.a.c.e.l();
        com.tencent.beacon.a.c.c c16 = com.tencent.beacon.a.c.c.c();
        hashMap.put("A31", "" + l3.p());
        hashMap.put("A67", com.tencent.beacon.a.c.b.c(c16.b()));
        hashMap.put("A76", com.tencent.beacon.a.c.b.d());
        hashMap.put("A89", l3.a(c16.b()));
        hashMap.put("A52", String.valueOf(l3.z()));
        hashMap.put("A58", l3.m() ? "Y" : "N");
        hashMap.put("A12", l3.n());
        hashMap.put("A17", l3.v());
        hashMap.put("A159", l3.F());
        hashMap.put("A9", Build.BRAND);
        hashMap.put("A158", l3.d());
        com.tencent.beacon.a.c.f e16 = com.tencent.beacon.a.c.f.e();
        if (!TextUtils.isEmpty(e16.h())) {
            hashMap.put("A10", e16.h());
        }
        if (!TextUtils.isEmpty(e16.b())) {
            hashMap.put(NowProxyConstants.AccountInfoKey.A2, "" + e16.b());
        }
        if (!TextUtils.isEmpty(e16.d())) {
            hashMap.put("A4", e16.d());
        }
        if (!TextUtils.isEmpty(e16.f())) {
            hashMap.put("A6", e16.f());
        }
        if (!TextUtils.isEmpty(e16.a())) {
            hashMap.put("A7", e16.a());
        }
        if (!TextUtils.isEmpty(e16.j())) {
            hashMap.put("A20", e16.j());
        }
        if (!TextUtils.isEmpty(e16.k())) {
            hashMap.put("A69", e16.k());
        }
        if (!TextUtils.isEmpty(e16.i())) {
            hashMap.put("A144", e16.i());
        }
        return hashMap;
    }

    public static int a(EventType eventType) {
        int i3 = c.f77906a[eventType.ordinal()];
        if (i3 == 3 || i3 == 4) {
            return 1;
        }
        if (i3 != 5) {
            return i3 != 6 ? 0 : 3;
        }
        return 2;
    }

    public static JceRequestEntity a(List<EventBean> list, boolean z16) {
        return JceRequestEntity.builder().a(RequestType.EVENT).a(z16 ? 2 : 1).b(com.tencent.beacon.base.net.b.b.a(false)).a(com.tencent.beacon.base.net.b.b.a(true), 8081).a(com.tencent.beacon.a.c.c.c().e()).a("version", "v2").a(a(list)).a();
    }

    public static void a(String str, Map<String, String> map) {
        if (com.tencent.beacon.base.util.b.b(1) && !f77907a.matcher(str).matches()) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (f77908b.matcher(str2).matches()) {
                    sb5.append(str2);
                    sb5.append(" ");
                }
            }
            if (sb5.length() == 0) {
                return;
            }
            String format = String.format("use Axx for key, eventCode is %s, key is %s.", str, sb5.toString());
            com.tencent.beacon.base.util.c.b(format, new Object[0]);
            i.e().a("106", format);
        }
    }
}
