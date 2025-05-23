package com.tencent.mobileqq.mutualmark.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.h;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f252287b = {"mutual_mark_lottie/star.json", "mutual_mark_lottie/confetti_frist.json", "mutual_mark_lottie/confetti_special.json", "mutual_mark_lottie/boom.json"};

    /* renamed from: a, reason: collision with root package name */
    h f252288a = new h();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f252289a = new b();
    }

    b() {
    }

    public static b c() {
        return a.f252289a;
    }

    public void a(QQAppInterface qQAppInterface, String str, String str2) {
        if (d(str, str2)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkManger", 2, "checkDownloadCartoonResource download url:" + str + " md5:" + str2);
        }
        this.f252288a.i(qQAppInterface, 10089, PreDownloadConstants.DEPARTMENT_PRD, str, str2, f252287b, null);
    }

    public String b(String str, String str2) {
        return h.m(str, str2) + "/";
    }

    public boolean d(String str, String str2) {
        boolean o16 = h.o(str, str2, f252287b);
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkManger", 2, "isCartoonResourceReady url:" + str + " md5:" + str2 + " res:" + o16);
        }
        return o16;
    }
}
