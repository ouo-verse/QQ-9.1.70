package com.tencent.qqlive.module.videoreport.report;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ProcessUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EventStatisticsManager {
    private static final String KEY_SEQ_TIME_BASE_KEY = "key_seqtime_base_key";
    private static final long MAX_COUNT_VALUE = 300000;
    private static final int MSG_SAVE_DATA = 1;
    private static final String SP_NAME = "SP_seq_";
    private static final String TAG = "common.EventStatisticsManager";
    private static volatile EventStatisticsManager sInstance;
    private static final Object sLockEventGroupCount = new Object();
    private String mSpName = "";
    private String mSeqTimeKey = "";
    private Map<String, Long> mEventCountMap = new ConcurrentHashMap();
    private Handler mHandler = new a(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                EventStatisticsManager.this.saveData();
            }
            super.handleMessage(message);
        }
    }

    EventStatisticsManager() {
        init();
    }

    private static String getEventKey(String str, String str2, long j3, String str3) {
        return str + "_" + str2 + "_" + j3 + "_" + str3;
    }

    public static EventStatisticsManager getInstance() {
        if (sInstance == null) {
            synchronized (EventStatisticsManager.class) {
                if (sInstance == null) {
                    sInstance = new EventStatisticsManager();
                }
            }
        }
        return sInstance;
    }

    private long getMaxCountValue() {
        return 300000L;
    }

    private long getSeqTime(String str) {
        long longValue = ((Long) SPUtils.get(ReportUtils.getContext(), this.mSpName, this.mSeqTimeKey + str, 0L)).longValue();
        if (longValue == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            SPUtils.put(ReportUtils.getContext(), this.mSpName, this.mSeqTimeKey + str, Long.valueOf(currentTimeMillis));
            return currentTimeMillis;
        }
        return longValue;
    }

    private String getSeqTimeKey() {
        String str = (String) SPUtils.get(ReportUtils.getContext(), this.mSpName, KEY_SEQ_TIME_BASE_KEY, "");
        if (TextUtils.isEmpty(str)) {
            return resetSeqTimeKey();
        }
        return str;
    }

    private void init() {
        this.mSpName = SP_NAME + ProcessUtils.getProcessName(ReportUtils.getContext());
        this.mSeqTimeKey = getSeqTimeKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveData$0() {
        SharedPreferences.Editor edit = SPUtils.getEdit(ReportUtils.getContext(), this.mSpName);
        for (String str : this.mEventCountMap.keySet()) {
            edit.putString(str, String.valueOf(this.mEventCountMap.get(str)));
        }
        edit.apply();
    }

    private String resetSeqTimeKey() {
        String str = System.currentTimeMillis() + "";
        SPUtils.put(ReportUtils.getContext(), this.mSpName, KEY_SEQ_TIME_BASE_KEY, str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveData() {
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.a
            @Override // java.lang.Runnable
            public final void run() {
                EventStatisticsManager.this.lambda$saveData$0();
            }
        });
    }

    public void addStatisticsInnerParam(String str, String str2, Map<String, Object> map) {
        long j3;
        long j16;
        long longValue;
        if (map == null) {
            return;
        }
        String removeDTPrefix = DTStandardEvent.removeDTPrefix(str2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        synchronized (sLockEventGroupCount) {
            long j17 = 0;
            try {
                j3 = getSeqTime(str);
                try {
                    String eventKey = getEventKey(str, this.mSeqTimeKey, j3, removeDTPrefix);
                    if (this.mEventCountMap.containsKey(eventKey)) {
                        longValue = this.mEventCountMap.get(eventKey).longValue();
                    } else {
                        longValue = ((Long) SPUtils.get(ReportUtils.getContext(), this.mSpName, eventKey, 0L)).longValue();
                    }
                    j16 = 1;
                    j17 = longValue + 1;
                    this.mEventCountMap.put(eventKey, Long.valueOf(j17));
                } catch (Exception e16) {
                    e = e16;
                }
            } catch (Exception e17) {
                e = e17;
                j3 = 0;
            }
            if (j17 > getMaxCountValue()) {
                this.mSeqTimeKey = resetSeqTimeKey();
                try {
                    long seqTime = getSeqTime(str);
                    try {
                        this.mEventCountMap.put(getEventKey(str, this.mSeqTimeKey, seqTime, removeDTPrefix), 1L);
                        j3 = seqTime;
                    } catch (Exception e18) {
                        e = e18;
                        j3 = seqTime;
                        j17 = 1;
                        Log.e(TAG, "addStatisticsInnerParam(), getEventCount error " + e);
                        j16 = j17;
                        this.mHandler.removeMessages(1);
                        this.mHandler.sendEmptyMessageDelayed(1, 500L);
                        map.put(DTParamKey.REPORT_KEY_SEQID, Long.valueOf(j16));
                        map.put(DTParamKey.REPORT_KEY_SEQ_TIME, Long.valueOf(j3));
                    }
                } catch (Exception e19) {
                    e = e19;
                }
            }
            j16 = j17;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 500L);
        try {
            map.put(DTParamKey.REPORT_KEY_SEQID, Long.valueOf(j16));
            map.put(DTParamKey.REPORT_KEY_SEQ_TIME, Long.valueOf(j3));
        } catch (Exception e26) {
            Log.e(TAG, "addStatisticsInnerParam exception " + e26);
        }
    }
}
