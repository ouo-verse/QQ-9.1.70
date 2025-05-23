package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f263797a = new ArrayList(20);

    /* renamed from: b, reason: collision with root package name */
    private final QQAppInterface f263798b;

    public c(QQAppInterface qQAppInterface) {
        this.f263798b = qQAppInterface;
    }

    public void a(String str) {
        this.f263797a.add(str);
        if (this.f263797a.size() >= 20) {
            b();
        }
    }

    void b() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.f263797a.size(); i3++) {
            if (i3 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(this.f263797a.get(i3));
        }
        QQAppInterface qQAppInterface = this.f263798b;
        if (qQAppInterface != null) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009324", "0X8009324", 0, 0, "", "", stringBuffer.toString(), "");
        }
        this.f263797a.clear();
    }

    public void c() {
        if (this.f263797a.size() > 0) {
            b();
        }
    }
}
