package com.tencent.biz.pubaccount.weishi.net.common;

import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {
    public static int a() {
        if (d()) {
            return 1;
        }
        return SimpleUIUtil.isNowElderMode() ? 2 : 0;
    }

    public static int b() {
        return d() ? 1 : 0;
    }

    public static boolean c() {
        return false;
    }

    public static boolean d() {
        return StudyModeManager.t();
    }
}
