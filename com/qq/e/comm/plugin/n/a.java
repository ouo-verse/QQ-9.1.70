package com.qq.e.comm.plugin.n;

import com.tencent.mtt.tbs.smartaccelerator.TbsSmartAcceleratorManager;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static boolean a() {
        if (!com.qq.e.comm.plugin.j.c.a("tbsSmartAccelerator", 0, 1) || !TbsSmartAcceleratorManager.isUseTbsPreload()) {
            return false;
        }
        return true;
    }
}
