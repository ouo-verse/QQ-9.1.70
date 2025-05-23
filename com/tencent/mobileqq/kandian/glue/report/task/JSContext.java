package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: P */
/* loaded from: classes33.dex */
public class JSContext {

    /* renamed from: a, reason: collision with root package name */
    private long f239869a;

    /* renamed from: b, reason: collision with root package name */
    private long f239870b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.mobileqq.kandian.glue.report.task.a f239871c;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, Timer> f239872d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<String, a> f239873e = new HashMap();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface a {
    }

    public JSContext() {
        synchronized (JSContext.class) {
            try {
                try {
                    long createGroup = createGroup();
                    this.f239870b = createGroup;
                    this.f239869a = create(createGroup);
                } catch (Error e16) {
                    QLog.d("JSContext", 2, "JSContext init unexpected error: " + e16.getMessage());
                    c.a("JSContext init unexpected error: " + e16.getMessage());
                }
            } catch (Exception e17) {
                QLog.d("JSContext", 2, "JSContext init unexpected exception: " + e17.getMessage());
                c.a("JSContext init unexpected exception: " + e17.getMessage());
            }
        }
    }

    private native long create(long j3);

    private native long createGroup();

    private native Object evaluteStringWithException(long j3, String str, StringBuffer stringBuffer);

    private native void initRIJStrorage(long j3);

    private native void registerFunction(long j3, String str);

    private native void release(long j3, long j16);

    public Object a(String str, StringBuffer stringBuffer) {
        return evaluteStringWithException(this.f239869a, str, stringBuffer);
    }

    public void b() {
        initRIJStrorage(this.f239869a);
    }

    public void c(String str, a aVar) {
        this.f239873e.put(str, aVar);
        registerFunction(this.f239869a, str);
    }
}
