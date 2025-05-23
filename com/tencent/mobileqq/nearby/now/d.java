package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.nearby.now.view.SplitedProgressBar;
import java.security.InvalidParameterException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private SplitedProgressBar f252644a;

    public d(SplitedProgressBar splitedProgressBar) {
        if (splitedProgressBar != null) {
            this.f252644a = splitedProgressBar;
            return;
        }
        throw new InvalidParameterException("ProgressControler: progressBar is null");
    }

    public void a(boolean z16) {
        int i3;
        SplitedProgressBar splitedProgressBar = this.f252644a;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        splitedProgressBar.setVisibility(i3);
    }

    public void b(int i3, int i16) {
        SplitedProgressBar splitedProgressBar = this.f252644a;
        if (i3 < splitedProgressBar.f252833e) {
            splitedProgressBar.setProgress(i3, i16);
        }
    }

    public void c(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f252644a.setShowMaxCount(i3);
    }

    public void d(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f252644a.setTotalCount(i3);
    }
}
