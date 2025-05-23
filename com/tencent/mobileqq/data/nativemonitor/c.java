package com.tencent.mobileqq.data.nativemonitor;

import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.nativememorymonitor.library.ISoLoader;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements ISoLoader {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f203165a = new c();
    }

    public static c a() {
        return a.f203165a;
    }

    @Override // com.tencent.mobileqq.nativememorymonitor.library.ISoLoader
    public boolean loadSo(String str) {
        return SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), str);
    }
}
