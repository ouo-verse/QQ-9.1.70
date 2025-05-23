package com.tencent.ams.monitor.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f70579a;

    public c(WeakReference<j> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
        } else {
            this.f70579a = new d(weakReference);
        }
    }

    private JSONArray a(int i3, ConcurrentHashMap<String, String> concurrentHashMap, Collection<i> collection) {
        if (collection != null && !collection.isEmpty()) {
            JSONObject b16 = b(i3, concurrentHashMap, collection);
            if (b16 != null && !JSONObject.NULL.equals(b16)) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(b16);
                    return jSONArray;
                } catch (Throwable th5) {
                    this.f70579a.d("AdMetricJSONBuilder", "[buildBatchMetricJSONArray]", th5);
                    return null;
                }
            }
            this.f70579a.c("AdMetricJSONBuilder", "[buildBatchMetricJSONObject] error, batchMetricJSONObject is null");
        }
        return null;
    }

    private JSONObject b(int i3, ConcurrentHashMap<String, String> concurrentHashMap, Collection<i> collection) {
        if (collection != null && !collection.isEmpty()) {
            JSONArray c16 = c(collection);
            if (c16 != null && c16.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("business_type", i3);
                    JSONArray f16 = f(concurrentHashMap);
                    if (f16 != null && f16.length() > 0) {
                        jSONObject.put("common_tag_sets", f16);
                    }
                    jSONObject.put("metrics", c16);
                    return jSONObject;
                } catch (Throwable th5) {
                    this.f70579a.d("AdMetricJSONBuilder", "[buildBatchMetricJSONObject]", th5);
                    return null;
                }
            }
            this.f70579a.c("AdMetricJSONBuilder", "[buildBatchMetricJSONObject] error, metricsJSONArray is null");
        }
        return null;
    }

    private JSONArray c(Collection<i> collection) {
        if (collection != null && !collection.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (i iVar : collection) {
                    if (iVar == null) {
                        this.f70579a.c("AdMetricJSONBuilder", "[buildMetricJSONArray] error, metric is null");
                    } else {
                        JSONObject d16 = d(iVar);
                        if (d16 != null && !JSONObject.NULL.equals(d16)) {
                            jSONArray.mo162put(d16);
                        }
                        this.f70579a.c("AdMetricJSONBuilder", "[buildMetricJSONArray] error, metricJSONObject is null, id:" + iVar.getId());
                    }
                }
                if (jSONArray.length() <= 0) {
                    return null;
                }
                return jSONArray;
            } catch (Throwable th5) {
                this.f70579a.d("AdMetricJSONBuilder", "[buildMetricJSONArray]", th5);
            }
        }
        return null;
    }

    private JSONObject d(i iVar) {
        if (iVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("metric_id", iVar.getId());
            jSONObject.put("curve_value", iVar.getValue());
            JSONArray f16 = f(iVar.getTagSets());
            if (f16 != null && f16.length() > 0) {
                jSONObject.put("tag_sets", f16);
            }
            return jSONObject;
        } catch (Throwable th5) {
            this.f70579a.d("AdMetricJSONBuilder", "[toJSONObject]", th5);
            return null;
        }
    }

    private JSONArray f(ConcurrentHashMap<String, String> concurrentHashMap) {
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                    if (entry == null) {
                        this.f70579a.c("AdMetricJSONBuilder", "[buildTagSetsJSONArray] error, tagSet is null");
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tag_name", entry.getKey());
                        jSONObject.put("tag_value", entry.getValue());
                        jSONArray.mo162put(jSONObject);
                    }
                }
                return jSONArray;
            } catch (Throwable th5) {
                this.f70579a.d("AdMetricJSONBuilder", "[buildTagSetsJSONArray]", th5);
            }
        }
        return null;
    }

    public JSONObject e(int i3, ConcurrentHashMap<String, String> concurrentHashMap, Collection<i> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), concurrentHashMap, collection);
        }
        JSONArray a16 = a(i3, concurrentHashMap, collection);
        if (a16 != null && a16.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("batch_metrics", a16);
                return jSONObject;
            } catch (Throwable th5) {
                this.f70579a.d("AdMetricJSONBuilder", "[buildMetricReportRequestJSONObject]", th5);
                return null;
            }
        }
        this.f70579a.c("AdMetricJSONBuilder", "[buildMetricReportRequestJSONObject] error, batchMetricJSONArray is null");
        return null;
    }
}
