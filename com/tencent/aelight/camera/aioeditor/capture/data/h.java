package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends CaptureSet {
    public h(Object obj) {
        super(obj);
    }

    public boolean equals(Object obj) {
        return obj.hashCode() == hashCode();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.CaptureSet, com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        return super.g(activity, i3);
    }

    public int hashCode() {
        return ((QIMFilterCategoryItem) this.f66709i).f66697d.hashCode();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void o(Activity activity, int i3) {
        super.o(activity, i3);
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "select " + toString());
        }
        m.n().U((QIMFilterCategoryItem) this.f66709i, activity, i3);
        ((d) fr.f.c(5)).L[i3].g(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.CaptureSet, com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        super.q(activity, i3);
        m n3 = m.n();
        h hVar = n3.f66502i[i3];
        if (hVar == null || !hVar.t().equals(t())) {
            return;
        }
        n3.M(null, activity, i3);
    }

    public String toString() {
        QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) this.f66709i;
        return qIMFilterCategoryItem.f66697d + qIMFilterCategoryItem.hashCode() + qIMFilterCategoryItem.E + this.f66709i;
    }
}
