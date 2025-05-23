package com.tencent.ams.monitor.metric;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f70585a;

    public h(WeakReference<j> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
        } else {
            this.f70585a = new d(weakReference);
        }
    }

    private boolean a(i iVar) {
        if (iVar == null) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, mMetric is null");
            return false;
        }
        if (iVar.getId() <= 0) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, id:" + iVar.getId());
            return false;
        }
        if (iVar.getTimeMillis() <= 0) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, timeMillis:" + iVar.getTimeMillis());
            return false;
        }
        return true;
    }

    public boolean b(i iVar, ConcurrentHashMap<String, String> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar, (Object) concurrentHashMap)).booleanValue();
        }
        if (!a(iVar)) {
            return false;
        }
        ConcurrentHashMap<String, String> tagSets = iVar.getTagSets();
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty() && tagSets != null && !tagSets.isEmpty()) {
            for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                if (entry == null) {
                    this.f70585a.c("AdMetricValidator", "[isValid] error, commonTagSet is null");
                } else {
                    String key = entry.getKey();
                    if (tagSets.contains(key)) {
                        this.f70585a.c("AdMetricValidator", "[isValid] error, tag key duplicated, id:" + iVar.getId() + " tagKey:" + key);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean c(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lVar)).booleanValue();
        }
        if (lVar == null) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, config is null");
            return false;
        }
        if (lVar.getBusinessType() <= 0) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, businessType:" + lVar.getBusinessType());
            return false;
        }
        if (TextUtils.isEmpty(lVar.getUrl())) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, url:" + lVar.getUrl());
            return false;
        }
        if (lVar.getMaxCount() <= 0) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, maxCount:" + lVar.getMaxCount());
            return false;
        }
        if (lVar.getCountThreshold() <= 0) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, countThreshold:" + lVar.getCountThreshold());
            return false;
        }
        if (lVar.getMaxCount() < lVar.getCountThreshold()) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, maxCount < countThreshold, maxCount:" + lVar.getMaxCount() + " countThreshold:" + lVar.getCountThreshold() + " ");
            return false;
        }
        if (lVar.getIntervalMillisThreshold() <= 0) {
            this.f70585a.c("AdMetricValidator", "[isValid] error, intervalMillisThreshold(:" + lVar.getIntervalMillisThreshold());
            return false;
        }
        return true;
    }
}
