package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;
import v62.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReadinjoyReportUtils {

    /* renamed from: a, reason: collision with root package name */
    public static long f239845a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Long, Map<Long, Object>> f239846b;

    static {
        ReadinjoySPEventReport.d.a(new a());
        f239845a = 0L;
        f239846b = new HashMap();
    }

    public static void a(String str, boolean z16, long j3) {
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(1);
        attributeList.att_name.set("BusiType");
        attributeList.att_value.set(str);
        oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
        attributeList2.att_id.set(2);
        attributeList2.att_name.set("HasRedPnt");
        attributeList2.att_value.set(String.valueOf(z16 ? 1 : 0));
        oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
        attributeList3.att_id.set(3);
        attributeList3.att_name.set("Time");
        attributeList3.att_value.set(String.valueOf(ReadinjoySPEventReport.I(j3)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(attributeList);
        arrayList.add(attributeList2);
        arrayList.add(attributeList3);
        b(2, arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("ReadinjoyReportUtils", 2, "report dt entry ! busiName : " + str + " , redDot : " + z16);
        }
    }

    public static void b(final int i3, final List<oidb_cmd0x80a.AttributeList> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.2
            @Override // java.lang.Runnable
            public void run() {
                Lock lock = ReadinjoySPEventReport.f239770p;
                lock.lock();
                try {
                    try {
                        UserOperationModule userOperationModule = UserOperationModule.getInstance();
                        list.addAll(ReadinjoySPEventReport.J().G(i3));
                        userOperationModule.request0x80aPushEffectEvent(i3, "", list);
                        lock.unlock();
                    } catch (Exception e16) {
                        QLog.e("ReadinjoyReportUtils", 1, "reportPushEffectEvent", e16);
                        l.r("ReadinjoyReportUtils", e16.toString(), e16);
                        ReadinjoySPEventReport.f239770p.unlock();
                    }
                } catch (Throwable th5) {
                    ReadinjoySPEventReport.f239770p.unlock();
                    throw th5;
                }
            }
        }, 128, null, true);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements b {
        a() {
        }

        @Override // v62.b
        public void a() {
        }

        @Override // v62.b
        public void b() {
        }
    }
}
