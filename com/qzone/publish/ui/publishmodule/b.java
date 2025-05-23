package com.qzone.publish.ui.publishmodule;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.event.Event;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private QZonePublishMoodBaseActivity f51993d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneUploadPhotoActivity f51994e;

    /* renamed from: f, reason: collision with root package name */
    private c f51995f;

    public <T extends View> T a(int i3) {
        return (T) b().findViewById(i3);
    }

    public PhotoActivity b() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f51993d;
        return qZonePublishMoodBaseActivity != null ? qZonePublishMoodBaseActivity : this.f51994e;
    }

    public Intent c() {
        return b().getIntent();
    }

    public <T extends b> T d(Class<T> cls) {
        return (T) this.f51995f.a(cls);
    }

    public QZonePublishMoodBaseActivity e() {
        return this.f51993d;
    }

    public Resources f() {
        return b().getResources();
    }

    public void r(PhotoActivity photoActivity) {
        if (photoActivity instanceof QZonePublishMoodBaseActivity) {
            this.f51993d = (QZonePublishMoodBaseActivity) photoActivity;
        } else if (photoActivity instanceof QZoneUploadPhotoActivity) {
            this.f51994e = (QZoneUploadPhotoActivity) photoActivity;
        }
    }

    public void s(c cVar) {
        this.f51995f = cVar;
    }

    public void g() {
    }

    public void h() {
    }

    public void j() {
    }

    public void k(Intent intent) {
    }

    public void l() {
    }

    public void m() {
    }

    public void n(Event event) {
    }

    public void o(Message message) {
    }

    public void p(Intent intent) {
    }

    public void q() {
    }

    public void i(int i3, int i16, Intent intent) {
    }
}
