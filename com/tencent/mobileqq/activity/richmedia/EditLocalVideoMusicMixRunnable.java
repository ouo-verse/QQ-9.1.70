package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.b;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EditLocalVideoMusicMixRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private long f185809d;

    /* renamed from: e, reason: collision with root package name */
    private long f185810e;

    /* renamed from: f, reason: collision with root package name */
    private long f185811f;

    /* renamed from: h, reason: collision with root package name */
    private String f185812h;

    /* renamed from: i, reason: collision with root package name */
    private jd0.d f185813i;

    /* renamed from: m, reason: collision with root package name */
    private b.d f185814m;

    public EditLocalVideoMusicMixRunnable(long j3, long j16, long j17, String str, jd0.d dVar, b.d dVar2) {
        this.f185809d = j3;
        this.f185810e = j16;
        this.f185811f = j17;
        this.f185812h = str;
        this.f185813i = dVar;
        this.f185814m = dVar2;
    }

    private boolean b(String str) {
        if (str == null) {
            if (this.f185814m != null) {
                QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditLocalVideoMusicMixRunnable.this.f185814m.c();
                    }
                });
                return true;
            }
            return true;
        }
        return false;
    }

    private void c(final String str) {
        if (this.f185814m != null) {
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable.2
                @Override // java.lang.Runnable
                public void run() {
                    EditLocalVideoMusicMixRunnable.this.f185814m.b(str);
                }
            });
        }
    }

    private void e() {
        if (this.f185814m != null) {
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable.3
                @Override // java.lang.Runnable
                public void run() {
                    EditLocalVideoMusicMixRunnable.this.f185814m.a();
                }
            });
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        e();
        if (this.f185813i.f409844h == 0) {
            c(a.f(this.f185812h));
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        String c16 = a.c(this.f185813i.f409846j);
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 1, run() returned: " + c16);
        arrayList.add(c16);
        if (b(c16)) {
            return;
        }
        String g16 = a.g(c16);
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 2, run() returned: " + g16);
        arrayList.add(g16);
        if (b(g16)) {
            return;
        }
        jd0.d dVar = this.f185813i;
        int i3 = dVar.f409847k - 1000;
        dVar.f409847k = i3;
        if (i3 > 0) {
            str = a.a(i3, dVar.f409848l - i3, g16);
        } else {
            str = g16;
        }
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 3, run() returned: " + str);
        arrayList.add(str);
        if (b(str)) {
            return;
        }
        long j3 = this.f185810e;
        long j16 = this.f185809d;
        long j17 = j3 - j16;
        int i16 = this.f185813i.f409849m;
        if (j17 > i16) {
            str = a.h(str, (int) (((j3 - j16) / i16) + 1));
        }
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 4, run() returned: " + str);
        arrayList.add(str);
        if (b(str)) {
            return;
        }
        long j18 = this.f185809d;
        if (j18 > 0) {
            String d16 = a.d(j18, g16, this.f185813i.f409849m);
            str = a.b(Arrays.asList(d16, str));
            arrayList.add(d16);
        }
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 5, run() returned: " + str);
        arrayList.add(str);
        if (b(str)) {
            return;
        }
        String e16 = a.e(this.f185812h, str, this.f185811f);
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 6, run() returned: " + e16);
        if (b(e16)) {
            return;
        }
        for (String str2 : arrayList) {
            if (str2 != null && new File(str2).delete()) {
                QZLog.d("EditLocalVideoMusicMixR", 2, "step 7, run() clear: " + str2);
            }
        }
        c(e16);
    }
}
