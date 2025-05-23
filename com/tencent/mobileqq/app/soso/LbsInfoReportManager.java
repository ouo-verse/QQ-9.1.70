package com.tencent.mobileqq.app.soso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.m;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs$LbsData;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs$ReqLbsReport;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.q;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class LbsInfoReportManager implements Manager, BusinessObserver {
    static IPatchRedirector $redirector_;
    private ArrayList<LbsReportInfo> C;
    private boolean D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f196554d;

    /* renamed from: e, reason: collision with root package name */
    private long f196555e;

    /* renamed from: f, reason: collision with root package name */
    private long f196556f;

    /* renamed from: h, reason: collision with root package name */
    private double f196557h;

    /* renamed from: i, reason: collision with root package name */
    private double f196558i;

    /* renamed from: m, reason: collision with root package name */
    private int f196559m;

    public LbsInfoReportManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.D = false;
        this.E = false;
        this.f196554d = qQAppInterface;
        this.C = new ArrayList<>();
        r(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> m(ArrayList<LbsReportInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                LbsReportInfo lbsReportInfo = arrayList.get(i3);
                if (lbsReportInfo != null && !TextUtils.isEmpty(lbsReportInfo.content)) {
                    arrayList2.add("dc01864");
                }
            }
            return arrayList2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        List<? extends Entity> query = this.f196554d.getEntityManagerFactory().createEntityManager().query(LbsReportInfo.class);
        if (query != null && !query.isEmpty()) {
            this.C.addAll(query);
            if (QLog.isColorLevel()) {
                QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list size is: " + query.size());
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list is empty.");
        }
        this.D = true;
    }

    private void r(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                String s16 = s(this.f196554d.getApp(), this.f196554d.getCurrentAccountUin());
                if (TextUtils.isEmpty(s16)) {
                    return;
                } else {
                    jSONObject = new JSONObject(s16);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("LBSReport", 2, e16, new Object[0]);
                    return;
                }
                return;
            }
        }
        boolean z16 = true;
        if (jSONObject.optInt("is_close_old_report") != 1) {
            z16 = false;
        }
        this.E = z16;
    }

    private String s(Context context, String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str + "_" + AppConstants.Preferences.LBS_REPORT_CONFIG, "");
        if (QLog.isColorLevel()) {
            QLog.d("LBSReport", 2, "getLBSNewReport,lbs_report_config:" + string);
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int t() {
        int i3 = this.f196559m;
        if (i3 <= 0) {
            this.f196559m = new Random().nextInt(1000000) + 100;
        } else if (i3 >= 1000100) {
            this.f196559m = 100;
        } else {
            this.f196559m = i3 + 1;
        }
        return this.f196559m;
    }

    public static void v(SosoLocation sosoLocation, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LBSReport", 2, "LbsInfoReportManager.reportLbsInfo2DC(), location = " + sosoLocation + ", businessTag = " + str);
        }
        if (sosoLocation.mLat02 != 0.0d && sosoLocation.mLon02 != 0.0d) {
            boolean z16 = true;
            if (MobileQQ.sProcessId != 1) {
                z16 = false;
            }
            Intent intent = new Intent();
            intent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("is_runtime", 1001);
            intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, sosoLocation.mLat02);
            intent.putExtra("lng", sosoLocation.mLon02);
            intent.putExtra(QCircleSchemeAttr.Polymerize.ALT, sosoLocation.altitude);
            intent.putExtra("accuracy", sosoLocation.accuracy);
            intent.putExtra("businessTag", str);
            if (!TextUtils.isEmpty(sosoLocation.nation)) {
                intent.putExtra("nation", sosoLocation.nation);
            }
            if (!TextUtils.isEmpty(sosoLocation.province)) {
                intent.putExtra("province", sosoLocation.province);
            }
            if (!TextUtils.isEmpty(sosoLocation.city)) {
                intent.putExtra("city", sosoLocation.city);
            }
            if (!TextUtils.isEmpty(sosoLocation.district)) {
                intent.putExtra("district", sosoLocation.district);
            }
            if (z16) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface != null) {
                    ((LbsInfoReportManager) qQAppInterface.getManager(QQManagerFactory.LBS_REPORT_MANAGER)).u(intent);
                    return;
                }
                return;
            }
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        }
    }

    private void w(byte[] bArr, int i3) {
        QQAppInterface qQAppInterface = this.f196554d;
        if (qQAppInterface != null && bArr != null) {
            NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), m.class);
            newIntent.putExtra("cmd", "LbsSvc.lbs_report");
            newIntent.putExtra("data", bArr);
            newIntent.putExtra("DataType", 2);
            newIntent.putExtra("retryTime", i3 + 1);
            newIntent.putExtra("copyData", bArr);
            newIntent.setObserver(this);
            qQAppInterface.startServlet(newIntent);
        }
    }

    private void x(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str + "_" + AppConstants.Preferences.LBS_REPORT_CONFIG, str2).commit();
    }

    public void n(ArrayList<LbsReportInfo> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("LBSReport", 2, "ProtoServlet StorySvc.lbs_report doNewReportLbsInfo: size = " + arrayList.size());
            }
            qqstory_lbs$ReqLbsReport qqstory_lbs_reqlbsreport = new qqstory_lbs$ReqLbsReport();
            Iterator<LbsReportInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                LbsReportInfo next = it.next();
                qqstory_lbs$LbsData qqstory_lbs_lbsdata = new qqstory_lbs$LbsData();
                qqstory_lbs_lbsdata.alt.set(next.alt);
                qqstory_lbs_lbsdata.lng.set(next.lng);
                qqstory_lbs_lbsdata.lat.set(next.lat);
                qqstory_lbs_lbsdata.accuracy.set(next.accuracy);
                if (!TextUtils.isEmpty(next.businessTag)) {
                    qqstory_lbs_lbsdata.bussinessTag.set(next.businessTag);
                }
                if (!TextUtils.isEmpty(next.nation)) {
                    qqstory_lbs_lbsdata.nation.set(next.nation);
                }
                if (!TextUtils.isEmpty(next.province)) {
                    qqstory_lbs_lbsdata.province.set(next.province);
                }
                if (!TextUtils.isEmpty(next.city)) {
                    qqstory_lbs_lbsdata.city.set(next.city);
                }
                if (!TextUtils.isEmpty(next.district)) {
                    qqstory_lbs_lbsdata.district.set(next.district);
                }
                qqstory_lbs_lbsdata.plat_type.set(2);
                qqstory_lbs_lbsdata.oper_time.set((int) next.operTime);
                qqstory_lbs_reqlbsreport.list_data.add(qqstory_lbs_lbsdata);
            }
            w(qqstory_lbs_reqlbsreport.toByteArray(), i3);
        }
    }

    public void o(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, arrayList, arrayList2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (arrayList != null && !arrayList.isEmpty() && arrayList2 != null && !arrayList2.isEmpty()) {
            QQAppInterface qQAppInterface = this.f196554d;
            NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), q.class);
            newIntent.putExtra("sendType", 10);
            newIntent.putExtra("seqKey", i3);
            newIntent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, arrayList);
            newIntent.putExtra("contents", arrayList2);
            newIntent.putExtra("retryTime", i16 + 1);
            newIntent.setObserver(this);
            qQAppInterface.startServlet(newIntent);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 == 10) {
            int i17 = bundle.getInt("seqKey");
            if (QLog.isColorLevel()) {
                QLog.d("LBSReport", 2, "OnReceive: isSuccess-" + z16 + ", seqKey = " + i17);
            }
            if (!z16) {
                i16 = bundle.getInt("retryTime");
            }
            QQAppInterface qQAppInterface = this.f196554d;
            if (!z16 && i16 < 2 && qQAppInterface != null) {
                o(bundle.getStringArrayList(ComicCancelRedPointPopItemData.JSON_KEY_TAGS), bundle.getStringArrayList("contents"), i17, i16);
                return;
            }
            return;
        }
        if (bundle.containsKey("cmd") && "LbsSvc.lbs_report".equals(bundle.getString("cmd"))) {
            if (!z16) {
                i16 = bundle.getInt("retryTime");
            }
            if (QLog.isColorLevel()) {
                QLog.d("LBSReport", 2, "ProtoServlet StorySvc.lbs_report OnReceive: isSuccess =" + z16 + ", retryTime = " + i16);
            }
            if (!z16 && i16 < 2) {
                w(bundle.getByteArray("copyData"), i16);
            }
        }
    }

    public void p(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(AppConstants.Preferences.LBS_REPORT_CONFIG);
        if (optJSONObject != null) {
            x(this.f196554d.getApp(), this.f196554d.getCurrentAccountUin(), optJSONObject.toString());
        }
        r(optJSONObject);
    }

    public void u(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.i("LBSReport", 2, "onReceiveLbsInfo intent is null. return.");
                return;
            }
            return;
        }
        double doubleExtra = intent.getDoubleExtra(QCircleSchemeAttr.Polymerize.LAT, 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("lng", 0.0d);
        double doubleExtra3 = intent.getDoubleExtra(QCircleSchemeAttr.Polymerize.ALT, 0.0d);
        float floatExtra = intent.getFloatExtra("accuracy", 0.0f);
        String stringExtra = intent.getStringExtra("businessTag");
        String stringExtra2 = intent.getStringExtra("nation");
        String stringExtra3 = intent.getStringExtra("province");
        String stringExtra4 = intent.getStringExtra("city");
        String stringExtra5 = intent.getStringExtra("district");
        if (doubleExtra != 0.0d && doubleExtra2 != 0.0d) {
            double distanceBetween = TencentLocationUtils.distanceBetween(doubleExtra, doubleExtra2, this.f196557h, this.f196558i);
            double elapsedRealtime = SystemClock.elapsedRealtime() - this.f196555e;
            if (distanceBetween < 20.0d && elapsedRealtime < 180000.0d) {
                if (QLog.isColorLevel()) {
                    QLog.i("LBSReport", 2, "onReceiveLbsInfo distance is: " + distanceBetween + " collectGap: " + elapsedRealtime);
                    return;
                }
                return;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable(doubleExtra, doubleExtra2, doubleExtra3, floatExtra, stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5) { // from class: com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String C;
                final /* synthetic */ String D;
                final /* synthetic */ String E;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ double f196560d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ double f196561e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ double f196562f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ float f196563h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f196564i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f196565m;

                {
                    this.f196560d = doubleExtra;
                    this.f196561e = doubleExtra2;
                    this.f196562f = doubleExtra3;
                    this.f196563h = floatExtra;
                    this.f196564i = stringExtra;
                    this.f196565m = stringExtra2;
                    this.C = stringExtra3;
                    this.D = stringExtra4;
                    this.E = stringExtra5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LbsInfoReportManager.this, Double.valueOf(doubleExtra), Double.valueOf(doubleExtra2), Double.valueOf(doubleExtra3), Float.valueOf(floatExtra), stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    LbsReportInfo lbsReportInfo = new LbsReportInfo();
                    lbsReportInfo.operTime = NetConnInfoCenter.getServerTime();
                    lbsReportInfo.lat = this.f196560d;
                    lbsReportInfo.lng = this.f196561e;
                    lbsReportInfo.alt = this.f196562f;
                    lbsReportInfo.accuracy = this.f196563h;
                    lbsReportInfo.businessTag = this.f196564i;
                    lbsReportInfo.nation = this.f196565m;
                    lbsReportInfo.province = this.C;
                    lbsReportInfo.city = this.D;
                    lbsReportInfo.district = this.E;
                    lbsReportInfo.createContent();
                    LbsInfoReportManager.this.C.add(lbsReportInfo);
                    LbsInfoReportManager.this.f196557h = this.f196560d;
                    LbsInfoReportManager.this.f196558i = this.f196561e;
                    LbsInfoReportManager.this.f196555e = SystemClock.elapsedRealtime();
                    if (QLog.isColorLevel()) {
                        QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + LbsInfoReportManager.this.C.size() + " lastReportTime: " + LbsInfoReportManager.this.f196556f + " currentTime: " + NetConnInfoCenter.getServerTime());
                    }
                    if (LbsInfoReportManager.this.f196554d.mAutomator != null && !LbsInfoReportManager.this.f196554d.mAutomator.isInRealActionLoginB()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        return;
                    }
                    if (!LbsInfoReportManager.this.D) {
                        LbsInfoReportManager.this.q();
                    }
                    if (LbsInfoReportManager.this.C.size() < 20 && NetConnInfoCenter.getServerTime() - LbsInfoReportManager.this.f196556f < 1200) {
                        LbsInfoReportManager.this.f196554d.getEntityManagerFactory().createEntityManager().persist(lbsReportInfo);
                        if (QLog.isColorLevel()) {
                            QLog.d("LBSReport", 2, "update db");
                            return;
                        }
                        return;
                    }
                    LbsInfoReportManager lbsInfoReportManager = LbsInfoReportManager.this;
                    lbsInfoReportManager.n(lbsInfoReportManager.C, 0);
                    if (!LbsInfoReportManager.this.E) {
                        LbsInfoReportManager lbsInfoReportManager2 = LbsInfoReportManager.this;
                        lbsInfoReportManager2.o(lbsInfoReportManager2.m(lbsInfoReportManager2.C), LbsReportInfo.convert2StrList(LbsInfoReportManager.this.C), LbsInfoReportManager.this.t(), 0);
                    }
                    LbsInfoReportManager.this.C.clear();
                    LbsInfoReportManager.this.f196554d.getEntityManagerFactory().createEntityManager().delete(LbsReportInfo.class.getSimpleName(), null, null);
                    LbsInfoReportManager.this.f196556f = NetConnInfoCenter.getServerTime();
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LBSReport", 2, "onReceiveLbsInfo lat or lng is 0.0d. return.");
        }
    }
}
