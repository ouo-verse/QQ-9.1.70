package com.tencent.biz.pubaccount.imagecollection;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f79729a = "PublicAccountImageCollectionActivityManager";

    /* renamed from: b, reason: collision with root package name */
    private static Stack<Activity> f79730b = null;

    /* renamed from: c, reason: collision with root package name */
    private static a f79731c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f79732d = 3;

    a() {
    }

    public static a b() {
        if (f79731c == null) {
            f79731c = new a();
        }
        return f79731c;
    }

    private void d() {
        Activity firstElement = f79730b.firstElement();
        if (firstElement != null) {
            firstElement.finish();
            f79730b.remove(firstElement);
        }
    }

    public int a() {
        Stack<Activity> stack = f79730b;
        if (stack == null) {
            return 0;
        }
        int size = stack.size();
        if (QLog.isColorLevel()) {
            QLog.d(f79729a, 2, "getActivityStackNum = " + size);
        }
        return size;
    }

    public void c(Activity activity) {
        Stack<Activity> stack = f79730b;
        if (stack == null || activity == null) {
            return;
        }
        stack.remove(activity);
    }

    public void e(Activity activity) {
        if (f79730b == null) {
            f79730b = new Stack<>();
        }
        f79730b.add(activity);
    }

    public void f() {
        Stack<Activity> stack = f79730b;
        if (stack == null || stack.size() <= f79732d) {
            return;
        }
        int size = f79730b.size() - f79732d;
        for (int i3 = 0; i3 < size; i3++) {
            d();
        }
    }
}
