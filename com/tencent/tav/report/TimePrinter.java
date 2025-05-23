package com.tencent.tav.report;

import android.util.Log;
import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TimePrinter {
    private String TAG = "TimeDebug";
    private CMTime currentSyncTime;
    private long currentTimeUs;
    private static Map<String, TimePrinter> printerMap = new HashMap();
    private static Map<String, TimePrinter> constMap = new HashMap();

    public TimePrinter(String str) {
        this.TAG += "-" + str;
    }

    public static synchronized void print(String str, CMTime cMTime) {
        synchronized (TimePrinter.class) {
            TimePrinter timePrinter = printerMap.get(str);
            if (timePrinter == null) {
                timePrinter = new TimePrinter(str);
                printerMap.put(str, timePrinter);
            }
            timePrinter.print(cMTime);
        }
    }

    public static synchronized void printCons(String str) {
        synchronized (TimePrinter.class) {
            TimePrinter timePrinter = constMap.get(str);
            if (timePrinter == null) {
                constMap.put(str, new TimePrinter(str, System.nanoTime() / 1000));
            } else {
                timePrinter.printCons();
                constMap.remove(str);
            }
        }
    }

    public TimePrinter(String str, long j3) {
        this.TAG += "-" + str;
        this.currentTimeUs = j3;
    }

    public void print(CMTime cMTime) {
        if (this.currentSyncTime == null) {
            this.currentSyncTime = cMTime;
            return;
        }
        Log.d(this.TAG, "print: timeSub = " + cMTime.sub(this.currentSyncTime).getTimeUs());
        this.currentSyncTime = cMTime;
    }

    public void printCons() {
        long nanoTime = System.nanoTime() / 1000;
        Log.d(this.TAG, "printConst: const = " + (nanoTime - this.currentTimeUs));
    }
}
