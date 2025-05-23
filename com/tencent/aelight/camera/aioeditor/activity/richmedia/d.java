package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.aelight.camera.aioeditor.takevideo.u;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private int f66434a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66435b;

    /* renamed from: c, reason: collision with root package name */
    private final int f66436c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<? extends u> f66437d;

    /* renamed from: e, reason: collision with root package name */
    private Set<Integer> f66438e = new HashSet();

    d(int i3, int i16, int i17, Class<? extends u> cls) {
        this.f66434a = i3;
        this.f66435b = i16;
        this.f66436c = i17;
        this.f66437d = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d d(int i3, int i16, int i17, Class<? extends u> cls) {
        return new d(i3, i16, i17, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Set<Integer> set) {
        this.f66438e.addAll(set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<? extends u> b() {
        return this.f66437d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f66438e.size() > 0) {
            for (Integer num : this.f66438e) {
                LpReportInfo_pf00064.allReport(this.f66434a, this.f66435b, num.intValue());
                QZLog.d("QzoneEditPictureAndVide", 2, "performReport ", toString() + " with " + num);
            }
            return;
        }
        LpReportInfo_pf00064.allReport(this.f66434a, this.f66435b, this.f66436c);
        QZLog.d("QzoneEditPictureAndVide", 2, "performReport " + toString());
    }

    public String toString() {
        return "QzoneEditPictureReportModel{actionType=" + this.f66434a + ", subActionType=" + this.f66435b + ", reserve=" + this.f66436c + '}';
    }
}
