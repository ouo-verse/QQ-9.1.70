package com.tencent.ams.dsdk.monitor.metric.core.inner;

import android.text.TextUtils;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.monitor.metric.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class Metric implements i {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Metric";
    private final long mId;
    private final ConcurrentHashMap<String, String> mTagSets;
    private final long mTimeMillis;
    private double mValue;

    public Metric(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.mValue = 1.0d;
        this.mTagSets = new ConcurrentHashMap<>();
        this.mId = j3;
        this.mTimeMillis = System.currentTimeMillis();
    }

    @Override // com.tencent.ams.monitor.metric.i
    public long getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.mId;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public ConcurrentHashMap<String, String> getTagSets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mTagSets;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public long getTimeMillis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.mTimeMillis;
    }

    @Override // com.tencent.ams.monitor.metric.i
    public double getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) this)).doubleValue();
        }
        return this.mValue;
    }

    public Metric setTagSet(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Metric) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mTagSets.put(str, str2);
        } else {
            DLog.e(TAG, "tagName and tagValue must not be null or empty");
        }
        return this;
    }

    public Metric setValue(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Metric) iPatchRedirector.redirect((short) 5, this, Double.valueOf(d16));
        }
        this.mValue = d16;
        return this;
    }
}
