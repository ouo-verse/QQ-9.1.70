package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TimeCounter {
    static IPatchRedirector $redirector_ = null;
    private static String TAG = "TimeCounter";
    private static HashMap<String, TimeCounter> allMap;
    private float average;
    private long beginTime;
    private int count;
    private float last;
    private float max;
    private float min;
    private String name;
    private float sum;

    public TimeCounter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.sum = 0.0f;
        this.count = 0;
        this.average = 0.0f;
        this.min = 0.0f;
        this.max = 0.0f;
        this.last = 0.0f;
        this.beginTime = 0L;
        this.name = str;
    }

    public static void clearIns() {
        allMap.clear();
        allMap = null;
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis() * 1000;
    }

    public static TimeCounter ins(String str) {
        if (allMap == null) {
            allMap = new HashMap<>();
        }
        if (allMap.get(str) == null) {
            allMap.put(str, new TimeCounter(str));
        }
        return allMap.get(str);
    }

    public static String printAll() {
        Iterator<String> it = allMap.keySet().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + "\n" + allMap.get(it.next()).print();
        }
        return str;
    }

    public void begin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.beginTime = getCurrentTime();
        }
    }

    public void end() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            end(true);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public String print() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = this.name + " count:" + this.count + " avg:" + this.average + "ms max:" + this.max + "ms min:" + this.min + "ms last:" + this.last + "ms";
        Log.i(TAG, str);
        return str;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.sum = 0.0f;
        this.average = 0.0f;
        this.min = 0.0f;
        this.max = 0.0f;
        this.last = 0.0f;
        this.beginTime = 0L;
    }

    public void end(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        float currentTime = ((float) (getCurrentTime() - this.beginTime)) / 1000.0f;
        float f16 = this.sum + currentTime;
        this.sum = f16;
        int i3 = this.count + 1;
        this.count = i3;
        this.average = f16 / i3;
        if (i3 == 1) {
            this.min = currentTime;
            this.max = currentTime;
        } else {
            if (currentTime < this.min) {
                this.min = currentTime;
            }
            if (currentTime > this.max) {
                this.max = currentTime;
            }
        }
        this.last = currentTime;
        if (z16) {
            print();
        }
    }
}
