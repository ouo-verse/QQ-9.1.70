package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.c;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* loaded from: classes33.dex */
public class SPEventReportSwitch {

    /* renamed from: a, reason: collision with root package name */
    private static int f239836a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f239837b = 30;

    /* renamed from: c, reason: collision with root package name */
    private static int f239838c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f239839d = 30;

    /* renamed from: e, reason: collision with root package name */
    private static int f239840e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f239841f;

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<Integer, SPEventReportCondition> f239842g;

    /* renamed from: h, reason: collision with root package name */
    private static SparseArray<Boolean> f239843h = new SparseArray<>();

    /* loaded from: classes33.dex */
    public static class SPEventReportCondition implements Serializable {
        private boolean needReportNextTime;
        private ArrayList<TreeSet<Integer>> timeSeq;

        public String toString() {
            return "SPEventReportCondition{needReportNextTime=" + this.needReportNextTime + ", timeSeq=" + this.timeSeq + '}';
        }
    }

    public static boolean a() {
        int i3 = f239840e;
        if (i3 != -1) {
            return i3 == 1;
        }
        SharedPreferences b16 = c.b((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), true, true);
        if (b16 == null) {
            f239840e = f239841f;
        } else {
            f239840e = b16.getInt("kd_user_idle_report", f239841f);
        }
        return f239840e == 1;
    }

    public static int b() {
        int i3 = f239836a;
        if (i3 != -1) {
            return i3;
        }
        SharedPreferences b16 = c.b((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), true, true);
        if (b16 == null) {
            f239836a = f239837b;
        } else {
            f239836a = b16.getInt("kd_fore_ground_gap_in_seconds", f239837b);
        }
        return f239836a;
    }

    public static int c() {
        int i3 = f239838c;
        if (i3 != -1) {
            return i3;
        }
        SharedPreferences b16 = c.b((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), true, true);
        if (b16 == null) {
            f239838c = f239839d;
        } else {
            f239838c = b16.getInt("kd_screen_switch_in_seconds", f239839d);
        }
        return f239838c;
    }

    public static boolean d(int i3) {
        SPEventReportCondition sPEventReportCondition;
        int i16;
        if (e(i3)) {
            return true;
        }
        HashMap<Integer, SPEventReportCondition> hashMap = f239842g;
        if (hashMap == null || hashMap.isEmpty() || (sPEventReportCondition = f239842g.get(Integer.valueOf(i3))) == null) {
            return false;
        }
        if (!sPEventReportCondition.needReportNextTime && sPEventReportCondition.timeSeq == null) {
            return false;
        }
        boolean z16 = sPEventReportCondition.needReportNextTime;
        int i17 = (Calendar.getInstance().get(11) * 3600) + (Calendar.getInstance().get(12) * 60) + Calendar.getInstance().get(13);
        if (sPEventReportCondition.timeSeq != null && !sPEventReportCondition.timeSeq.isEmpty()) {
            while (i16 < sPEventReportCondition.timeSeq.size()) {
                TreeSet treeSet = (TreeSet) sPEventReportCondition.timeSeq.get(i16);
                Integer num = (Integer) treeSet.floor(Integer.valueOf(i17));
                i16 = num == null ? i16 + 1 : 0;
                do {
                    treeSet.remove(num);
                    num = (Integer) treeSet.floor(Integer.valueOf(i17));
                } while (num != null);
                if (treeSet.size() == 1) {
                    treeSet.clear();
                    sPEventReportCondition.timeSeq.remove(treeSet);
                }
                z16 = true;
            }
        }
        return z16;
    }

    private static synchronized boolean e(int i3) {
        synchronized (SPEventReportSwitch.class) {
            if (f239843h.get(i3) != null) {
                return false;
            }
            f239843h.put(i3, Boolean.TRUE);
            return true;
        }
    }

    public static void f(List<oidb_cmd0x80a.ReportConditionParam> list) {
        if (list == null) {
            return;
        }
        if (f239842g == null) {
            f239842g = new HashMap<>();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            oidb_cmd0x80a.ReportConditionParam reportConditionParam = list.get(i3);
            if (reportConditionParam.uint32_event_id.has()) {
                SPEventReportCondition sPEventReportCondition = f239842g.get(Integer.valueOf(reportConditionParam.uint32_event_id.get()));
                if (sPEventReportCondition == null) {
                    sPEventReportCondition = new SPEventReportCondition();
                    sPEventReportCondition.timeSeq = new ArrayList();
                    f239842g.put(Integer.valueOf(reportConditionParam.uint32_event_id.get()), sPEventReportCondition);
                }
                boolean z16 = true;
                boolean z17 = reportConditionParam.uint32_report_next_time.has() && reportConditionParam.uint32_report_next_time.get() != 0;
                if (z17 != sPEventReportCondition.needReportNextTime) {
                    sPEventReportCondition.needReportNextTime = z17;
                }
                if (reportConditionParam.report_time_seg.has()) {
                    List<Long> list2 = reportConditionParam.report_time_seg.get();
                    TreeSet treeSet = new TreeSet();
                    for (int i16 = 0; i16 < list2.size(); i16++) {
                        treeSet.add(Integer.valueOf(list2.get(i16).intValue()));
                    }
                    int i17 = 0;
                    while (true) {
                        if (i17 >= sPEventReportCondition.timeSeq.size()) {
                            z16 = false;
                            break;
                        } else if (((TreeSet) sPEventReportCondition.timeSeq.get(i17)).equals(treeSet)) {
                            break;
                        } else {
                            i17++;
                        }
                    }
                    if (!z16) {
                        sPEventReportCondition.timeSeq.add(treeSet);
                    }
                }
                QLog.d("ReadinjoySPEventReport", 2, "update eventID : " + reportConditionParam.uint32_event_id.get() + ", condition : " + sPEventReportCondition);
            }
        }
    }
}
