package com.tencent.mobileqq.guild.live.viewmodel;

import androidx.lifecycle.ViewModel;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a extends ViewModel {
    /* JADX INFO: Access modifiers changed from: protected */
    public AppRuntime L1() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public void destroy() {
    }

    public void init() {
    }
}
