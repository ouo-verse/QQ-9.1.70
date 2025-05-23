package com.tencent.rfix.loader.safemode;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.AbsStorableInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixSafeModeInfo extends AbsStorableInfo {
    private static final String P1_COUNT = "p1_count";
    private static final String P2_COUNT = "p2_count";
    private static final String P3_CRASH_TIMES = "p3_crash_times";
    private static final String TAG = "RFix.RFixSafeModeInfo";
    public int p1Count;
    public int p2Count;
    public List<Long> p3CrashTimes;

    public RFixSafeModeInfo(Context context, String str) {
        super(context, str);
    }

    private static List<Long> deserializeCrashTimes(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] split = str.split(",");
        if (split.length == 0) {
            return arrayList;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(Long.valueOf(Long.parseLong(str2)));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static String serializeCrashTimes(List<Long> list) {
        StringBuilder sb5 = new StringBuilder();
        for (Long l3 : list) {
            if (sb5.length() != 0) {
                sb5.append(',');
            }
            sb5.append(l3);
        }
        return sb5.toString();
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void loadStoreInfo() {
        super.loadStoreInfo();
        this.p1Count = this.storage.getInt(P1_COUNT, 0);
        this.p2Count = this.storage.getInt(P2_COUNT, 0);
        this.p3CrashTimes = deserializeCrashTimes(this.storage.getString(P3_CRASH_TIMES, ""));
        RFixLog.i(TAG, "loadStoreInfo " + this);
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void saveStoreInfo() {
        this.storage.putInt(P1_COUNT, this.p1Count);
        this.storage.putInt(P2_COUNT, this.p2Count);
        this.storage.putString(P3_CRASH_TIMES, serializeCrashTimes(this.p3CrashTimes));
        super.saveStoreInfo();
        RFixLog.i(TAG, "saveStoreInfo " + this);
    }

    public String toString() {
        return "RFixSafeModeInfo{p1Count=" + this.p1Count + ", p2Count=" + this.p2Count + ", p3CrashTimes=" + this.p3CrashTimes + '}';
    }
}
