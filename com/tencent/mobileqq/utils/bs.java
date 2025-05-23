package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.RefreshProgressRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bs {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, RefreshProgressRunnable> f307498a = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final bs f307499a = new bs();
    }

    bs() {
    }

    public static final bs c() {
        return a.f307499a;
    }

    public void a(String str, RefreshProgressRunnable refreshProgressRunnable) {
        if (!TextUtils.isEmpty(str)) {
            this.f307498a.put(str, refreshProgressRunnable);
        }
    }

    public RefreshProgressRunnable b(String str) {
        if (TextUtils.isEmpty(str) || this.f307498a.isEmpty()) {
            return null;
        }
        return this.f307498a.get(str);
    }

    public void d() {
        Iterator<String> it = this.f307498a.keySet().iterator();
        while (it.hasNext()) {
            e(it.next());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|(1:5)(2:21|(6:23|7|8|9|10|(2:12|13)(1:15)))|6|7|8|9|10|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        com.tencent.qphone.base.util.QLog.e("MessageProgressView", 2, "removeAnimRunnable exception = " + r6.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            RefreshProgressRunnable refreshProgressRunnable = this.f307498a.get(str);
            if (refreshProgressRunnable != null) {
                refreshProgressRunnable.stop();
            } else if (QLog.isDevelopLevel()) {
                str2 = ", key not found, key=" + str;
                this.f307498a.remove(str);
                if (!QLog.isDevelopLevel()) {
                    QLog.i("MessageProgressView", 2, " after removeAnimRunnable size=" + this.f307498a.size() + str2);
                    return;
                }
                return;
            }
            str2 = "";
            this.f307498a.remove(str);
            if (!QLog.isDevelopLevel()) {
            }
        }
    }
}
