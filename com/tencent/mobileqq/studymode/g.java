package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"", "a", "", "isSimple", "isStudy", "isElder", "b", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g {
    public static final int a() {
        if (ElderModeManager.j()) {
            return 3;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return 1;
        }
        if (StudyModeManager.t()) {
            return 2;
        }
        return 0;
    }

    public static final int b(boolean z16, boolean z17, boolean z18) {
        if (z16) {
            return 1;
        }
        if (z17) {
            return 2;
        }
        if (z18) {
            return 3;
        }
        return 0;
    }
}
