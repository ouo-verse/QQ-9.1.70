package com.tencent.biz.richframework.network.request;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetQUICFailStat {
    private static final int DEF_LIST_UPPER_LIMIT_COUNT = 100;
    private static final int DEF_QUIC_FAIL_MAX_RANGE_COUNT = 5;
    private static final long DEF_QUIC_FAIL_MAX_RANGE_TIME = 1800000;
    private static volatile VSNetQUICFailStat INSTANCE = null;
    private static final String TAG = "VSNetQUICFailStat";
    private final CopyOnWriteArrayList<FailErrorRecord> mTimeRangeFailList = new CopyOnWriteArrayList<>();
    private final AtomicBoolean mIsFailUpperLimit = new AtomicBoolean(false);
    private boolean mIsEnabledQUICUpperLimitFailRollbackPrint = false;
    private boolean mIsFailUpperLimitPrint = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class FailErrorRecord {
        private String errorCode;
        private long mTime;
        private String traceId;

        public FailErrorRecord(long j3, String str, String str2) {
            this.mTime = j3;
            this.errorCode = str;
            this.traceId = str2;
        }
    }

    private int getConfigQUICFailMaxRangeCount() {
        return o.q0(5);
    }

    private long getConfigQUICFailMaxRangeTime() {
        return o.r0(1800000L);
    }

    public static VSNetQUICFailStat instance() {
        if (INSTANCE == null) {
            synchronized (VSNetQUICFailStat.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VSNetQUICFailStat();
                }
            }
        }
        return INSTANCE;
    }

    private boolean isEnabledQUICUpperLimitFailRollback() {
        return o.D1();
    }

    private boolean isExistsErrorRecord(String str) {
        Iterator<FailErrorRecord> it = this.mTimeRangeFailList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().traceId, str)) {
                return true;
            }
        }
        return false;
    }

    private void removeAllFailTimeBound() {
        ArrayList arrayList = new ArrayList();
        long configQUICFailMaxRangeTime = getConfigQUICFailMaxRangeTime();
        Iterator<FailErrorRecord> it = this.mTimeRangeFailList.iterator();
        while (it.hasNext()) {
            FailErrorRecord next = it.next();
            if (System.currentTimeMillis() - next.mTime >= configQUICFailMaxRangeTime) {
                arrayList.add(next);
            }
        }
        if (this.mTimeRangeFailList.size() > 100) {
            int size = this.mTimeRangeFailList.size() - 100;
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(this.mTimeRangeFailList.get(i3));
            }
        }
        try {
            this.mTimeRangeFailList.removeAll(arrayList);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[removeAllFailTimeBound] ex: ", th5);
        }
    }

    public boolean isFailUpperLimit() {
        boolean isEnabledQUICUpperLimitFailRollback = isEnabledQUICUpperLimitFailRollback();
        boolean z16 = this.mIsFailUpperLimit.get();
        if (isEnabledQUICUpperLimitFailRollback != this.mIsEnabledQUICUpperLimitFailRollbackPrint || this.mIsFailUpperLimitPrint != z16) {
            this.mIsFailUpperLimitPrint = z16;
            this.mIsEnabledQUICUpperLimitFailRollbackPrint = isEnabledQUICUpperLimitFailRollback;
            QLog.d(TAG, 1, "[isFailUpperLimit] isEnabledQUICUpperLimitFailRollback: " + isEnabledQUICUpperLimitFailRollback + " | isFailUpperLimit: " + z16);
        }
        if (isEnabledQUICUpperLimitFailRollback() && z16) {
            return true;
        }
        return false;
    }

    public void updateReqQUICInfo(VSBaseRequest vSBaseRequest, VSNetQUICEvent vSNetQUICEvent) {
        if (vSBaseRequest == null || vSNetQUICEvent == null || !isEnabledQUICUpperLimitFailRollback()) {
            return;
        }
        String traceId = vSBaseRequest.getTraceId();
        String retCode = VSNetQUICUtils.getRetCode(vSBaseRequest);
        boolean isFailUpperLimit = isFailUpperLimit();
        if (!isFailUpperLimit) {
            removeAllFailTimeBound();
        }
        if (TextUtils.equals(retCode, "0") || TextUtils.equals(retCode, String.valueOf(100003)) || isExistsErrorRecord(traceId)) {
            return;
        }
        int configQUICFailMaxRangeCount = getConfigQUICFailMaxRangeCount();
        String eventKey = vSNetQUICEvent.getEventKey();
        if (!isFailUpperLimit) {
            this.mTimeRangeFailList.add(new FailErrorRecord(System.currentTimeMillis(), retCode, traceId));
            if (this.mTimeRangeFailList.size() >= configQUICFailMaxRangeCount) {
                isFailUpperLimit = true;
            } else {
                isFailUpperLimit = false;
            }
            this.mIsFailUpperLimit.set(isFailUpperLimit);
        }
        QLog.d(TAG, 1, "[updateReqQUICInfo] retCode: " + retCode + " | eventKey: " + eventKey + " | failMaxRangeCount: " + configQUICFailMaxRangeCount + " | failSize: " + this.mTimeRangeFailList.size() + " | isFailUpperLimit: " + isFailUpperLimit + " | request traceId: " + traceId);
    }
}
