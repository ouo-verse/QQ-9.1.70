package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208062a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Long> f208063b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Boolean> f208064c = new HashMap();

    public c(QQAppInterface qQAppInterface) {
        this.f208062a = qQAppInterface;
    }

    private String b(int i3, int i16, int i17, String str) {
        long c16 = c(i3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("select * from " + str + " ");
        if (c16 != -1) {
            sb5.append("where time <= " + c16 + " ");
        }
        sb5.append("order by time desc ");
        sb5.append("limit " + i16 + "," + i17 + " ");
        return sb5.toString();
    }

    private synchronized boolean d(int i3) {
        if (this.f208064c.containsKey("msg_transform_finish_" + i3)) {
            return this.f208064c.get("msg_transform_finish_" + i3).booleanValue();
        }
        boolean z16 = this.f208062a.getApp().getSharedPreferences("dataline_msg_transform_" + this.f208062a.getCurrentUin(), 0).getBoolean("msg_transform_finish_" + i3, false);
        this.f208064c.put("msg_transform_finish_" + i3, Boolean.valueOf(z16));
        if (QLog.isColorLevel()) {
            QLog.i("DatalineMsgDbTransformer", 1, "getTransformFinishFlag: type[" + i3 + "] finishFlag[" + z16 + "]");
        }
        return z16;
    }

    private synchronized void h(int i3, boolean z16) {
        this.f208064c.put("msg_transform_finish_" + i3, Boolean.valueOf(z16));
        SharedPreferences.Editor edit = this.f208062a.getApp().getSharedPreferences("dataline_msg_transform_" + this.f208062a.getCurrentUin(), 0).edit();
        edit.putBoolean("msg_transform_finish_" + i3, z16);
        if (QLog.isColorLevel()) {
            QLog.i("DatalineMsgDbTransformer", 1, "saveTransformFinishFlag:save finish flag type[" + i3 + "] finish[" + z16 + "]");
        }
        edit.apply();
    }

    public synchronized void a(int i3) {
        if (d(i3)) {
            QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: finish, do not check.");
            return;
        }
        long c16 = c(i3);
        if (c16 == -1) {
            long f16 = f(i3);
            QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: query beginId[" + f16 + "]");
            if (f16 != -1) {
                g(i3, f16);
            } else {
                h(i3, true);
            }
        } else {
            QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: save beginId[" + c16 + "]");
        }
    }

    public synchronized long c(int i3) {
        if (this.f208063b.containsKey("msg_transform_begin_id_" + i3)) {
            return this.f208063b.get("msg_transform_begin_id_" + i3).longValue();
        }
        long j3 = this.f208062a.getApp().getSharedPreferences("dataline_msg_transform_" + this.f208062a.getCurrentUin(), 0).getLong("msg_transform_begin_id_" + i3, -1L);
        this.f208063b.put("msg_transform_begin_id_" + i3, Long.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.i("DatalineMsgDbTransformer", 1, "getTransformBeginItemId: type[" + i3 + "] beginItemId[" + j3 + "]");
        }
        return j3;
    }

    protected List<DataLineMsgRecord> e(int i3, int i16, int i17) {
        String b16 = b(i17, i3, i16, DataLineMsgRecord.tableName(i17));
        if (QLog.isColorLevel()) {
            QLog.i("DatalineMsgDbTransformer", 1, "loadMessageRecordFromDB: sql[" + b16 + "]");
        }
        EntityManager createEntityManager = this.f208062a.getEntityManagerFactory().createEntityManager();
        List rawQuery = DBMethodProxy.rawQuery(createEntityManager, DataLineMsgRecord.class, b16, null);
        createEntityManager.close();
        if (rawQuery == null) {
            return new ArrayList();
        }
        return rawQuery;
    }

    public long f(int i3) {
        List<DataLineMsgRecord> e16 = e(0, 1, i3);
        if (e16.size() > 0) {
            return e16.get(0).time;
        }
        return -1L;
    }

    public synchronized void g(int i3, long j3) {
        if (j3 == 0) {
            return;
        }
        this.f208063b.put("msg_transform_begin_id_" + i3, Long.valueOf(j3));
        SharedPreferences.Editor edit = this.f208062a.getApp().getSharedPreferences("dataline_msg_transform_" + this.f208062a.getCurrentUin(), 0).edit();
        edit.putLong("msg_transform_begin_id_" + i3, j3);
        if (QLog.isColorLevel()) {
            QLog.i("DatalineMsgDbTransformer", 1, "saveTransformBeginItemId: type[" + i3 + "] beginItemId[" + j3 + "]");
        }
        edit.apply();
    }
}
