package kj;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.config.download.QZoneIntimateDownloadDbTaskState;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f412543b;

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f412544a;

    private static boolean a() {
        return new Random().nextDouble() <= 0.20000000298023224d;
    }

    public static c c() {
        if (f412543b == null) {
            synchronized (c.class) {
                if (f412543b == null) {
                    f412543b = new c();
                }
            }
        }
        return f412543b;
    }

    private AppRuntime d() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private EntityManager e(String str) {
        AppRuntime d16 = d();
        if (d16 == null) {
            QLog.e("QZoneIntimateDownloadDbDataHelper", 1, "initEntityManager  appRunTime == null");
            return null;
        }
        if (!TextUtils.equals(str, d16.getAccount())) {
            QLog.e("QZoneIntimateDownloadDbDataHelper", 1, "uin not equal");
            return null;
        }
        if (this.f412544a == null) {
            f(str);
        }
        return this.f412544a;
    }

    private void f(String str) {
        QLog.d("QZoneIntimateDownloadDbDataHelper", 1, "initEntityManager  uin = " + str);
        AppRuntime d16 = d();
        if (d16 == null) {
            QLog.e("QZoneIntimateDownloadDbDataHelper", 1, "initEntityManager  appRunTime == null");
            return;
        }
        try {
            this.f412544a = d16.getEntityManagerFactory(str).createEntityManager();
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public void g() {
        this.f412544a = null;
    }

    public void b(QZoneIntimateDownloadDbTaskState qZoneIntimateDownloadDbTaskState) {
        if (qZoneIntimateDownloadDbTaskState == null) {
            QLog.w("QZoneIntimateDownloadDbDataHelper", 1, "[deleteDownloadTaskStateEntry]  taskState = null");
            return;
        }
        String[] strArr = {qZoneIntimateDownloadDbTaskState.getUin(), qZoneIntimateDownloadDbTaskState.getUrl(), qZoneIntimateDownloadDbTaskState.getBusinessKey()};
        EntityManager e16 = e(qZoneIntimateDownloadDbTaskState.getUin());
        if (e16 == null) {
            QLog.e("QZoneIntimateDownloadDbDataHelper", 1, "entity manager is null, don't delete");
            return;
        }
        synchronized (e16) {
            e16.delete(new QZoneIntimateDownloadDbTaskState().getTableName(), "mUin=? and mUrl=? and mBusinessKey=?", strArr);
        }
        QLog.d("QZoneIntimateDownloadDbDataHelper", 1, "[deleteDownloadTaskStateEntry]  taskState = " + qZoneIntimateDownloadDbTaskState);
    }

    public void i(QZoneIntimateDownloadDbTaskState qZoneIntimateDownloadDbTaskState) {
        if (qZoneIntimateDownloadDbTaskState == null) {
            QLog.w("QZoneIntimateDownloadDbDataHelper", 1, "[updateDownloadTaskStateEntry]  taskState = null");
            return;
        }
        if (qZoneIntimateDownloadDbTaskState.getState() == DownloadState.STATE_RUNNING.ordinal() && a()) {
            return;
        }
        EntityManager e16 = e(qZoneIntimateDownloadDbTaskState.getUin());
        if (e16 == null) {
            QLog.e("QZoneIntimateDownloadDbDataHelper", 1, "entity manager is null, don't update");
            return;
        }
        synchronized (e16) {
            if (qZoneIntimateDownloadDbTaskState.getStatus() == 1000) {
                e16.persistOrReplace(qZoneIntimateDownloadDbTaskState);
            } else {
                e16.update(qZoneIntimateDownloadDbTaskState);
            }
        }
    }

    public List<QZoneIntimateDownloadDbTaskState> h(String str, String str2) {
        String str3;
        String[] strArr;
        List query;
        if (TextUtils.isEmpty(str)) {
            QLog.w("QZoneIntimateDownloadDbDataHelper", 1, "[queryDownloadTaskStateEntry]  businessKey = null");
            return null;
        }
        String uinString = LoginData.getInstance().getUinString();
        EntityManager e16 = e(uinString);
        ArrayList arrayList = new ArrayList();
        if (e16 == null) {
            return arrayList;
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "mUin=? and mBusinessKey=?";
            strArr = new String[]{uinString, str};
        } else {
            str3 = "mUin=? and mUrl=? and mBusinessKey=?";
            strArr = new String[]{uinString, str2, str};
        }
        synchronized (e16) {
            query = e16.query(QZoneIntimateDownloadDbTaskState.class, new QZoneIntimateDownloadDbTaskState().getTableName(), false, str3, strArr, null, null, null, null, null);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("queryDownloadTaskStateEntry  | businessKey = ");
        sb5.append(str);
        sb5.append(" | url = ");
        sb5.append(str2);
        sb5.append(" | entryList = ");
        sb5.append(query != null ? Arrays.toString(query.toArray()) : null);
        QLog.d("QZoneIntimateDownloadDbDataHelper", 1, sb5.toString());
        return query;
    }
}
