package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends CaptureSet {
    public j(Object obj) {
        super(obj);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.CaptureSet, com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "apply " + toString());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.C.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof c) {
                arrayList.add(((c) next).f66710m);
            }
        }
        ((d) fr.f.c(5)).L[i3].h(this);
        QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) this.f66709i;
        m.n().L(qIMFilterCategoryItem, i3);
        if (QLog.isDevelopLevel() && qIMFilterCategoryItem != null) {
            QLog.i("QCombo", 2, "setApplyedFilterGroup" + qIMFilterCategoryItem.f66698e);
        }
        if (qIMFilterCategoryItem != null && "AIFilter".equals(qIMFilterCategoryItem.f66697d)) {
            return 0;
        }
        c.r(activity, arrayList, this, i3);
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void o(Activity activity, int i3) {
        super.o(activity, i3);
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "select " + toString());
        }
        m.n().V((QIMFilterCategoryItem) this.f66709i, activity, i3);
    }

    public String toString() {
        return "Filter" + this.f66709i;
    }

    public int v() {
        Iterator<a> it = this.C.iterator();
        boolean z16 = false;
        boolean z17 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i3 = it.next().f66706e;
            if (i3 == 2) {
                z16 = true;
                break;
            }
            if (i3 == 1) {
                z17 = true;
            }
        }
        if (z16) {
            u(2);
            return 2;
        }
        if (z17) {
            u(2);
            return 1;
        }
        u(3);
        return 3;
    }

    public boolean w() {
        FilterDesc filterDesc;
        Iterator<a> it = this.C.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof c) && (filterDesc = ((c) next).f66710m) != null && filterDesc.predownload == 0) {
                return false;
            }
        }
        return true;
    }
}
