package com.qzone.business.qboss;

import BOSSStrategyCenter.tAdvDesc;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QbossAdvDesc extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<QbossAdvDesc> DB_CREATOR = new a();
    public static final String QBOSS_ADV_DESC_DATA = "qboss_adv_desc_data";
    public static final String TYPE_QBOSS_ADV_DESC_DATA = "BLOB";
    public static final String TYPE_UIN_QBOSS_ID = "TEXT UNIQUE";
    public static final String UIN_QBOSSID = "uin_qboss_id";
    public static final int VERSION = 1;

    @NeedParcel
    public Map<String, String> adv_config_info;

    @NeedParcel
    public Map<String, String> adv_user_feed;

    @NeedParcel
    public long expose_time;

    @NeedParcel
    public int parent_id;

    @NeedParcel
    public int pattern_id;

    @NeedParcel
    public int resource_id;

    @NeedParcel
    public int ret;

    @NeedParcel
    public int task_id;

    @NeedParcel
    public int type;

    @NeedParcel
    public String uin_qboss_id;

    @NeedParcel
    public String name = "";

    @NeedParcel
    public String res_data = "";

    @NeedParcel
    public String res_preprocess = "";

    @NeedParcel
    public String pattern_logic = "";

    @NeedParcel
    public String pattern_data = "";

    @NeedParcel
    public String res_traceinfo = "";

    @NeedParcel
    public String s_ret_msg = "";

    @NeedParcel
    public String s_cmd_info = "";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<QbossAdvDesc> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            if (r0 != null) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        
            com.tencent.qmethod.pandoraex.monitor.OaidMonitor.parcelRecycle(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        
            if (r0 == null) goto L12;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public QbossAdvDesc createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(QbossAdvDesc.QBOSS_ADV_DESC_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    QbossAdvDesc qbossAdvDesc = (QbossAdvDesc) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return qbossAdvDesc;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    b.i("QbossAdvDesc", "QbossAdvDesc createFromCursor Error");
                }
            } catch (Throwable th5) {
                if (obtain != null) {
                    OaidMonitor.parcelRecycle(obtain);
                }
                throw th5;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(QbossAdvDesc.UIN_QBOSSID, "TEXT UNIQUE"), new IDBCacheDataWrapper.c(QbossAdvDesc.QBOSS_ADV_DESC_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(UIN_QBOSSID, this.uin_qboss_id);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(QBOSS_ADV_DESC_DATA, marshall);
    }

    public static QbossAdvDesc toQbossAdvDesc(long j3, long j16, tAdvDesc tadvdesc) {
        if (tadvdesc == null) {
            return null;
        }
        QbossAdvDesc qbossAdvDesc = new QbossAdvDesc();
        qbossAdvDesc.uin_qboss_id = j3 + "_" + j16;
        qbossAdvDesc.task_id = tadvdesc.task_id;
        qbossAdvDesc.type = tadvdesc.type;
        qbossAdvDesc.name = tadvdesc.name;
        qbossAdvDesc.resource_id = tadvdesc.resource_id;
        qbossAdvDesc.res_data = tadvdesc.res_data;
        qbossAdvDesc.res_preprocess = tadvdesc.res_preprocess;
        qbossAdvDesc.pattern_id = tadvdesc.pattern_id;
        qbossAdvDesc.pattern_logic = tadvdesc.pattern_logic;
        qbossAdvDesc.pattern_data = tadvdesc.pattern_data;
        qbossAdvDesc.parent_id = tadvdesc.parent_id;
        qbossAdvDesc.res_traceinfo = tadvdesc.res_traceinfo;
        qbossAdvDesc.ret = tadvdesc.ret;
        qbossAdvDesc.s_ret_msg = tadvdesc.s_ret_msg;
        qbossAdvDesc.s_cmd_info = tadvdesc.s_cmd_info;
        qbossAdvDesc.expose_time = tadvdesc.expose_time;
        qbossAdvDesc.adv_config_info = tadvdesc.adv_config_info;
        qbossAdvDesc.adv_user_feed = tadvdesc.adv_user_feed;
        return qbossAdvDesc;
    }

    @Override // com.qzone.component.cache.database.a, com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }
}
