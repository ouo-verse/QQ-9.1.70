package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.view.WindowManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f312420d = false;

    /* renamed from: a, reason: collision with root package name */
    private UECPageStayViewer f312421a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f312422b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f312423c = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vastrash.uec.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static class C8947a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f312424a = new a();
    }

    public static a b() {
        return C8947a.f312424a;
    }

    public void a(ArrayList<QQStayTimeInfo> arrayList) {
        UECPageStayViewer uECPageStayViewer;
        if (arrayList != null && f312420d && (uECPageStayViewer = this.f312421a) != null) {
            uECPageStayViewer.i(arrayList);
        }
    }

    public void c() {
        if (this.f312423c) {
            this.f312422b.removeViewImmediate(this.f312421a);
        }
        this.f312423c = false;
    }
}
