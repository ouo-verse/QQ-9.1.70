package com.tencent.mobileqq.activity.contacts.mayknow;

import android.content.SharedPreferences;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactReportUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ReportExposeInterval f181612a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ReportExposeInterval implements Runnable {
        static IPatchRedirector $redirector_;
        private volatile boolean C;

        /* renamed from: d, reason: collision with root package name */
        private volatile long f181613d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f181614e;

        /* renamed from: f, reason: collision with root package name */
        private final Object f181615f;

        /* renamed from: h, reason: collision with root package name */
        private List<a> f181616h;

        /* renamed from: i, reason: collision with root package name */
        private Handler f181617i;

        /* renamed from: m, reason: collision with root package name */
        private WeakReference<QQAppInterface> f181618m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            int f181619a;

            /* renamed from: b, reason: collision with root package name */
            ArrayList<String> f181620b;

            /* renamed from: c, reason: collision with root package name */
            ArrayList<String> f181621c;

            /* renamed from: d, reason: collision with root package name */
            ArrayList<Integer> f181622d;

            /* renamed from: e, reason: collision with root package name */
            ArrayList<byte[]> f181623e;

            /* renamed from: f, reason: collision with root package name */
            int f181624f;

            /* renamed from: g, reason: collision with root package name */
            String f181625g;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        ReportExposeInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f181615f = new Object();
            this.C = false;
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            this.f181614e = false;
            this.f181613d = 0L;
            this.f181616h = new LinkedList();
            this.f181617i = new Handler(ThreadManagerV2.getSubThreadLooper());
            i(qQAppInterface);
            if (QLog.isColorLevel()) {
                QLog.d("ContactReportUtils", 2, "create ReportExposeInterval, enable = " + this.f181614e + ", interval = " + this.f181613d);
            }
        }

        private void a(a aVar) {
            QQAppInterface qQAppInterface;
            if (QLog.isColorLevel()) {
                QLog.d("ContactReportUtils", 2, "really do delay report, mApp = " + this.f181618m);
            }
            WeakReference<QQAppInterface> weakReference = this.f181618m;
            if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
                ContactReportUtils.g(qQAppInterface, aVar.f181619a, aVar.f181620b, aVar.f181621c, aVar.f181622d, aVar.f181623e, aVar.f181624f, aVar.f181625g, true);
            }
        }

        private void i(QQAppInterface qQAppInterface) {
            if (qQAppInterface != null) {
                this.f181618m = new WeakReference<>(qQAppInterface);
                SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq.ReportExposeInterval_" + qQAppInterface.getCurrentAccountUin(), 0);
                a aVar = new a();
                this.f181614e = sharedPreferences.getBoolean("ReportExposeInterval_enable", aVar.f181626a);
                this.f181613d = sharedPreferences.getLong("ReportExposeInterval_interval", aVar.f181627b);
                synchronized (this.f181615f) {
                    this.f181616h.clear();
                }
            }
        }

        public long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
            }
            return this.f181613d;
        }

        public long f() {
            long size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
            }
            synchronized (this.f181615f) {
                size = this.f181616h.size();
            }
            return size;
        }

        public boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.f181614e;
        }

        public void h(QQAppInterface qQAppInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16, String str) {
            QQAppInterface qQAppInterface2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, qQAppInterface, Integer.valueOf(i3), arrayList, arrayList2, arrayList3, arrayList4, Integer.valueOf(i16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactReportUtils", 2, "reportExpose delay, app = " + qQAppInterface);
            }
            if (qQAppInterface == null) {
                return;
            }
            WeakReference<QQAppInterface> weakReference = this.f181618m;
            if (weakReference != null) {
                qQAppInterface2 = weakReference.get();
            } else {
                qQAppInterface2 = null;
            }
            if (qQAppInterface2 != qQAppInterface) {
                i(qQAppInterface);
            }
            a aVar = new a();
            aVar.f181619a = i3;
            aVar.f181620b = arrayList;
            aVar.f181621c = arrayList2;
            aVar.f181622d = arrayList3;
            aVar.f181623e = arrayList4;
            aVar.f181624f = i16;
            aVar.f181625g = str;
            synchronized (this.f181615f) {
                this.f181616h.add(aVar);
            }
        }

        public void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.f181614e = z16;
                stop();
            }
        }

        public void k(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, j3);
                return;
            }
            this.f181613d = j3;
            if (this.f181613d <= 0) {
                this.f181613d = 0L;
                stop();
            }
        }

        public synchronized void l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (!this.C || z16) {
                this.f181617i.removeCallbacks(this);
                this.f181617i.post(this);
                this.C = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f181613d > 0) {
                ArrayList arrayList = new ArrayList();
                synchronized (this.f181615f) {
                    arrayList.addAll(this.f181616h);
                    this.f181616h.clear();
                }
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a((a) it.next());
                    }
                    this.f181617i.postDelayed(this, this.f181613d);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ContactReportUtils", 2, "last report size is 0, stop delay report");
                }
                stop();
            }
        }

        public synchronized void stop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f181617i.removeCallbacks(this);
                this.C = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f181626a;

        /* renamed from: b, reason: collision with root package name */
        public long f181627b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f181626a = false;
                this.f181627b = MiniBoxNoticeInfo.MIN_5;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "{isEnable=" + this.f181626a + ",interval=" + this.f181627b + "}";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f181612a = new ReportExposeInterval();
        }
    }

    public static void a() {
        boolean z16;
        if (f181612a.g() && f181612a.e() > 0 && f181612a.f() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f181612a.l(true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactReportUtils", 2, "flushReportRecommendExposeInterval " + z16);
        }
    }

    public static String b(List<MayKnowRecommend.MayKnowRecommendLabel> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append(list.get(i3).bytes_name);
                if (i3 < list.size() - 1) {
                    sb5.append(",");
                }
            }
        }
        return sb5.toString();
    }

    @NonNull
    private static StringBuilder c(ArrayList arrayList) {
        StringBuilder sb5 = new StringBuilder();
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 > 0) {
                    sb5.append(",");
                }
                sb5.append(arrayList.get(i3));
            }
        }
        return sb5;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(QQAppInterface qQAppInterface, String str, String str2, int i3, int i16, String str3, int i17, byte[] bArr, int i18, String str4) {
        String str5;
        String str6;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exp_reason", str3);
            jSONObject.put("exp_position", i17);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("", 2, "reportRecommend error: " + e16.getMessage());
            }
        }
        if (bArr != null && bArr.length > 0) {
            try {
                str6 = new String(bArr);
            } catch (Throwable unused) {
            }
            jSONObject.put("algh_id", str6);
            if (str4 != null) {
                str5 = "";
            } else {
                str5 = str4;
            }
            ReportController.o(qQAppInterface, "dc00898", "", str, "frd_recom", str2, i3, i16, String.valueOf(i18), str5, jSONObject.toString(), "");
        }
        str6 = "";
        jSONObject.put("algh_id", str6);
        if (str4 != null) {
        }
        ReportController.o(qQAppInterface, "dc00898", "", str, "frd_recom", str2, i3, i16, String.valueOf(i18), str5, jSONObject.toString(), "");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(QQAppInterface qQAppInterface, String str, String str2, int i3, int i16, String str3, int i17, byte[] bArr, String str4, int i18, String str5) {
        String str6;
        String str7;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exp_reason", str3);
            jSONObject.put("exp_position", i17);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("", 2, "reportRecommend error: " + e16.getMessage());
            }
        }
        if (bArr != null && bArr.length > 0) {
            try {
                str7 = new String(bArr);
            } catch (Throwable unused) {
            }
            jSONObject.put("algh_id", str7);
            jSONObject.put("item_tag", str4);
            if (str5 != null) {
                str6 = "";
            } else {
                str6 = str5;
            }
            ReportController.o(qQAppInterface, "dc00898", "", str, "frd_recom", str2, i3, i16, String.valueOf(i18), str6, jSONObject.toString(), "");
        }
        str7 = "";
        jSONObject.put("algh_id", str7);
        jSONObject.put("item_tag", str4);
        if (str5 != null) {
        }
        ReportController.o(qQAppInterface, "dc00898", "", str, "frd_recom", str2, i3, i16, String.valueOf(i18), str6, jSONObject.toString(), "");
    }

    public static void f(QQAppInterface qQAppInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16, String str) {
        g(qQAppInterface, i3, arrayList, arrayList2, arrayList3, arrayList4, i16, str, false);
    }

    public static void g(QQAppInterface qQAppInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16, String str, boolean z16) {
        h(qQAppInterface, i3, arrayList, arrayList2, arrayList3, arrayList4, i16, str, z16, null, null, null);
    }

    public static void h(QQAppInterface qQAppInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16, String str, boolean z16, ArrayList<Short> arrayList5, ArrayList<Short> arrayList6, ArrayList<String> arrayList7) {
        if (arrayList == null || arrayList2 == null || arrayList3 == null || arrayList4 == null || arrayList.isEmpty() || arrayList.size() != arrayList2.size() || arrayList.size() != arrayList3.size() || arrayList.size() != arrayList4.size()) {
            return;
        }
        String str2 = str == null ? "" : str;
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            if (i17 > 0) {
                sb5.append(",");
                sb6.append(",");
                sb7.append(",");
                sb8.append(",");
            }
            sb5.append(arrayList.get(i17));
            sb6.append(arrayList2.get(i17));
            sb7.append(arrayList3.get(i17));
            if (arrayList4.get(i17) != null && arrayList4.get(i17).length > 0) {
                try {
                    sb8.append(new String(arrayList4.get(i17)));
                } catch (Throwable unused) {
                }
            }
        }
        StringBuilder c16 = c(arrayList5);
        StringBuilder c17 = c(arrayList6);
        StringBuilder c18 = c(arrayList7);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exp_uin", sb5.toString());
            jSONObject.put("exp_reason", sb6.toString());
            jSONObject.put("exp_position", sb7.toString());
            jSONObject.put("algh_id", sb8.toString());
            jSONObject.put("exp_age", c16.toString());
            jSONObject.put("exp_gender", c17.toString());
            jSONObject.put("expTags", c18.toString());
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ContactReportUtils", 2, "reportRecommend error: " + e16.getMessage());
            }
        }
        if (z16) {
            ReportController.r(qQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_exp", i3, 0, String.valueOf(i16), str2, jSONObject.toString(), "");
        } else {
            ReportController.o(qQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_exp", i3, 0, String.valueOf(i16), str2, jSONObject.toString(), "");
        }
    }

    public static void i(QQAppInterface qQAppInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16, String str, ArrayList<Short> arrayList5, ArrayList<Short> arrayList6, ArrayList<String> arrayList7) {
        if (QLog.isColorLevel()) {
            QLog.d("ContactReportUtils", 2, "reportRecommendExposeInterval");
        }
        if (f181612a.g()) {
            if (f181612a.e() > 0) {
                f181612a.h(qQAppInterface, i3, arrayList, arrayList2, arrayList3, arrayList4, i16, str);
                f181612a.l(false);
                return;
            } else {
                h(qQAppInterface, i3, arrayList, arrayList2, arrayList3, arrayList4, i16, str, true, arrayList5, arrayList6, arrayList7);
                return;
            }
        }
        h(qQAppInterface, i3, arrayList, arrayList2, arrayList3, arrayList4, i16, str, false, arrayList5, arrayList6, arrayList7);
    }

    public static void j(QQAppInterface qQAppInterface, String str, String str2) {
        ReportController.o(qQAppInterface, "dc00898", "", str, "frd_recom", str2, 0, 0, "", "", "", "");
    }

    public static void k(a aVar) {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("ContactReportUtils", 2, "setReportExposeIntervalConfig: " + aVar);
        }
        if (aVar != null && (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null) {
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq.ReportExposeInterval_" + qQAppInterface.getCurrentAccountUin(), 0).edit();
            edit.putBoolean("ReportExposeInterval_enable", aVar.f181626a);
            edit.putLong("ReportExposeInterval_interval", aVar.f181627b);
            edit.apply();
            f181612a.j(aVar.f181626a);
            f181612a.k(aVar.f181627b);
        }
    }
}
