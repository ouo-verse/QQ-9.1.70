package com.tencent.rmonitor.launch;

import android.text.TextUtils;
import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<TraceSpan> f365634a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final String f365635b;

    public b(String str) {
        this.f365635b = str;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.f365497g.i("RMonitor_launch_Span", "spanStart, spanName is empty.");
            return true;
        }
        if (e(str) == null) {
            return false;
        }
        Logger.f365497g.i("RMonitor_launch_Span", "spanStart, span[", str, "] has appended before.");
        return true;
    }

    public void a(String str, String str2, long j3, long j16) {
        if (b(str)) {
            return;
        }
        this.f365634a.add(new TraceSpan(this.f365635b, str, e(str2), j3, j16));
    }

    public void c() {
        this.f365634a.clear();
    }

    public long d() {
        Iterator<TraceSpan> it = this.f365634a.iterator();
        long j3 = Long.MAX_VALUE;
        while (it.hasNext()) {
            TraceSpan next = it.next();
            if (next.getStartTimeInMs() < j3) {
                j3 = next.getStartTimeInMs();
            }
        }
        return j3;
    }

    public TraceSpan e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<TraceSpan> it = this.f365634a.iterator();
        while (it.hasNext()) {
            TraceSpan next = it.next();
            if (next != null && TextUtils.equals(next.name, str)) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<TraceSpan> f() {
        ArrayList<TraceSpan> arrayList = new ArrayList<>();
        Iterator<TraceSpan> it = this.f365634a.iterator();
        while (it.hasNext()) {
            TraceSpan next = it.next();
            if (next.isSpanEnd()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.f365497g.i("RMonitor_launch_Span", "spanEnd, spanName is empty.");
            return;
        }
        TraceSpan e16 = e(str);
        if (e16 == null) {
            Logger.f365497g.i("RMonitor_launch_Span", "spanEnd, span[", str, "] not exist.");
        } else {
            e16.onSpanEnd();
        }
    }

    public void h(String str, String str2) {
        if (b(str)) {
            return;
        }
        this.f365634a.add(new TraceSpan(this.f365635b, str, e(str2)));
    }
}
