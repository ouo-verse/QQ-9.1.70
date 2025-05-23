package b9;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.publish.outbox.Outbox;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import common.config.service.QzoneConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WnsNetworkConst;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends com.qzone.publish.outbox.a implements IQZoneServiceListener {
    public static final String SID = "sessionId";
    private QZoneTask J;
    private IQZoneServiceListener K;
    private int L;
    private static final int[] M = {513, 516, 514, WnsNetworkConst.WRITE_FAIL, WnsNetworkConst.NETWORK_DISABLE};
    private static final int[] N = {513, 516, 514, WnsNetworkConst.WRITE_FAIL, WnsNetworkConst.NETWORK_DISABLE, 517, 515};
    public static final IDBCacheDataWrapper.a<com.qzone.publish.outbox.a> DB_CREATOR = new d();

    /* compiled from: P */
    /* renamed from: b9.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0109a implements c9.b {
        C0109a() {
        }

        @Override // c9.b
        public void a(com.qzone.publish.outbox.a aVar) {
            if (a.this.K != null) {
                a.this.K.onTaskResponse(a.this.J);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements c9.b {
        b() {
        }

        @Override // c9.b
        public void a(com.qzone.publish.outbox.a aVar) {
            if (a.this.K != null) {
                a.this.K.onTaskResponse(a.this.J);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements c9.b {
        c() {
        }

        @Override // c9.b
        public void a(com.qzone.publish.outbox.a aVar) {
            if (a.this.K != null) {
                a.this.K.onTaskResponse(a.this.J);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements IDBCacheDataWrapper.a<com.qzone.publish.outbox.a> {
        d() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.publish.outbox.a createFromCursor(Cursor cursor) {
            QZoneRequest qZoneRequest;
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("taskData"));
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex("data"));
            a aVar = null;
            if (blob2 == null) {
                return null;
            }
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                QZoneTask qZoneTask = (QZoneTask) ParcelableWrapper.createDataFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
                Parcel obtain2 = Parcel.obtain();
                obtain2.unmarshall(blob2, 0, blob2.length);
                obtain2.setDataPosition(0);
                IQZoneServiceListener v06 = QZoneWriteOperationService.v0();
                if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && qZoneRequest.getRequestCmd() != null && qZoneTask.mRequest.getRequestCmd().equals("setCover")) {
                    v06 = q6.a.b();
                }
                a aVar2 = new a(obtain2, v06, qZoneTask);
                try {
                    aVar2.setOnSessionCallback(Outbox.C());
                    OaidMonitor.parcelRecycle(obtain2);
                    return aVar2;
                } catch (Exception e16) {
                    e = e16;
                    aVar = aVar2;
                    QZLog.w(e);
                    return aVar;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("sessionId", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("data", "BLOB"), new IDBCacheDataWrapper.c("taskData", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 0;
        }
    }

    public a(IQZoneServiceListener iQZoneServiceListener, QZoneTask qZoneTask, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f51254d = str;
        }
        this.f51255e = str.hashCode();
        this.f51256f = (int) this.D;
        this.f51259m = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_OUTBOX, QzoneConfig.SECONDARY_OUTBOX_MAX_RETRY_COUNT_PER_PERIOD, 1);
        this.F = (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_OUTBOX, QzoneConfig.SECONDARY_OUTBOX_MAX_RETRY_TIMEOUT, 4) <= 0 ? 4 : r7) * 60 * 60 * 1000;
        this.K = iQZoneServiceListener;
        this.J = qZoneTask;
        qZoneTask.setListener(this);
        this.G = new C0109a();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "create session." + toString());
        }
    }

    public int getResultCode() {
        return this.L;
    }

    public QZoneTask getTask() {
        return this.J;
    }

    @Override // com.qzone.publish.outbox.a
    public void increaseRetry() {
        int i3 = this.L;
        if (i3 > 300000) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("Outbox", 4, "don't increase retry count:" + i3);
                return;
            }
            return;
        }
        int length = M.length;
        for (int i16 = 0; i16 < length; i16++) {
            if (i3 == M[i16]) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("Outbox", 4, "don't increase retry count:" + i3);
                    return;
                }
                return;
            }
        }
        super.increaseRetry();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        String str;
        int i3 = qZoneTask.mResultCode;
        this.L = i3;
        if (!f(i3)) {
            StringBuilder sb5 = new StringBuilder();
            if (getTask() != null && getTask().mRequest != null) {
                str = getTask().mRequest.getCmdString();
            } else {
                str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            sb5.append("b:");
            sb5.append(str);
            sb5.append(",o:");
            sb5.append(getResultCode());
            sb5.append(",c:");
            sb5.append(getRetryCount());
            sb5.append(",t:");
            sb5.append(System.currentTimeMillis() - getmCreateTime());
            AccManager.reportOutboxResult(0, i3, qZoneTask.f45835msg, sb5.toString());
        }
        c9.a aVar = this.H;
        if (aVar != null) {
            if (i3 != -11210) {
                if (i3 == -5069) {
                    aVar.b(this);
                    return;
                }
                if (i3 == 0) {
                    aVar.a(this);
                    return;
                } else if (i3 != 1054) {
                    if (f(i3)) {
                        this.H.c(this);
                        return;
                    } else {
                        this.H.a(this);
                        return;
                    }
                }
            }
            aVar.c(this);
        }
    }

    @Override // com.qzone.publish.outbox.a
    public void resume() {
        this.J.setTaskRetryCount(this.f51258i);
        this.I = System.currentTimeMillis();
        QZoneBusinessLooper.getInstance().runTask(this.J);
    }

    @Override // com.qzone.publish.outbox.a
    public void setOnSessionCallback(c9.a aVar) {
        this.H = aVar;
    }

    @Override // com.qzone.publish.outbox.a
    public void start() {
        this.J.setTaskRetryCount(this.f51258i);
        this.I = System.currentTimeMillis();
        QZoneBusinessLooper.getInstance().runTask(this.J);
    }

    @Override // com.qzone.publish.outbox.a
    public String toString() {
        return "QzoneRequestSession [mRetryCountPerHeartbeat=" + this.f51259m + ", mGroupId=" + this.f51255e + ", mSessionId=" + this.f51256f + ", mMaxTry=" + this.f51257h + ", mRetryCount=" + this.f51258i + ", mCreateTime=" + this.D + ", mState=" + this.E + ", mTimeoutDistrict=" + this.F + "]";
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this.J);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Parcel obtain2 = Parcel.obtain();
        writeToParcel(obtain2);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put("taskData", marshall);
        contentValues.put("data", marshall2);
        contentValues.put("sessionId", Integer.valueOf(this.f51256f));
    }

    @Override // com.qzone.publish.outbox.a
    public void writeToParcel(Parcel parcel) {
        super.writeToParcel(parcel);
    }

    private static final boolean f(int i3) {
        if (i3 > 300000) {
            return true;
        }
        int length = N.length;
        for (int i16 = 0; i16 < length; i16++) {
            if (i3 == N[i16]) {
                return true;
            }
        }
        return false;
    }

    public a(IQZoneServiceListener iQZoneServiceListener, QZoneTask qZoneTask, String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            this.f51254d = str;
        }
        this.f51255e = str.hashCode();
        this.f51256f = (int) this.D;
        this.f51259m = i3;
        this.F = (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_OUTBOX, QzoneConfig.SECONDARY_OUTBOX_MAX_RETRY_TIMEOUT, 4) <= 0 ? 4 : r5) * 60 * 60 * 1000;
        this.K = iQZoneServiceListener;
        this.J = qZoneTask;
        qZoneTask.setListener(this);
        this.G = new b();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "create session." + toString());
        }
    }

    @Override // com.qzone.publish.outbox.a
    public void cancel() {
    }

    @Override // com.qzone.publish.outbox.a
    public void pause() {
    }

    @Override // com.qzone.publish.outbox.a
    public void stop() {
    }

    protected a(Parcel parcel, IQZoneServiceListener iQZoneServiceListener, QZoneTask qZoneTask) {
        super(parcel);
        this.K = iQZoneServiceListener;
        this.J = qZoneTask;
        if (qZoneTask != null) {
            qZoneTask.setListener(this);
        }
        this.G = new c();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "create session." + toString());
        }
    }
}
