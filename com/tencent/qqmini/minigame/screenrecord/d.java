package com.tencent.qqmini.minigame.screenrecord;

import android.view.ViewGroup;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private b f346687a;

    public d(int i3, ViewGroup viewGroup) {
        this.f346687a = null;
        if (i3 == 0) {
            this.f346687a = new c(viewGroup);
            return;
        }
        if (i3 == 1) {
            this.f346687a = new ScreenRecordOvertimeCtrl(viewGroup);
            return;
        }
        QMLog.w("ScreenRecordShareManager", "stopType is not defined. stopType:" + i3);
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public void a(IMiniAppContext iMiniAppContext, TritonEngine tritonEngine, IScreenRecord iScreenRecord) {
        b bVar = this.f346687a;
        if (bVar != null) {
            bVar.a(iMiniAppContext, tritonEngine, iScreenRecord);
        }
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public boolean e(String str, boolean z16) {
        b bVar = this.f346687a;
        if (bVar == null) {
            return false;
        }
        return bVar.e(str, z16);
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public boolean remove() {
        b bVar = this.f346687a;
        if (bVar == null) {
            return false;
        }
        return bVar.remove();
    }
}
