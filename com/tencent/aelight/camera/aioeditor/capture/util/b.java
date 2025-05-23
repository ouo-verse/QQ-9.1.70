package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static b f67187c;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<DoodleLayout> f67188a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<DoodleLayout> f67189b;

    b() {
    }

    public static b c() {
        if (f67187c == null) {
            f67187c = new b();
        }
        return f67187c;
    }

    public void a(int i3, DoodleLayout doodleLayout) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleLayoutConnector", 2, "bind " + i3);
        }
        if (i3 == 0) {
            this.f67188a = new WeakReference<>(doodleLayout);
        } else {
            this.f67189b = new WeakReference<>(doodleLayout);
        }
    }

    public void d(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleLayoutConnector", 2, "unbind " + i3);
        }
        if (i3 == 0) {
            this.f67188a = null;
        } else {
            this.f67189b = null;
        }
    }

    public DoodleLayout b(int i3) {
        DoodleLayout doodleLayout;
        if (i3 == 0) {
            WeakReference<DoodleLayout> weakReference = this.f67188a;
            if (weakReference != null && weakReference.get() != null) {
                doodleLayout = this.f67188a.get();
            }
            doodleLayout = null;
        } else {
            WeakReference<DoodleLayout> weakReference2 = this.f67189b;
            if (weakReference2 != null && weakReference2.get() != null) {
                doodleLayout = this.f67189b.get();
            }
            doodleLayout = null;
        }
        if (doodleLayout == null && QLog.isColorLevel()) {
            QLog.e("DoodleLayoutConnector", 2, "getDoodleLayout null, not init yet");
        }
        return doodleLayout;
    }
}
