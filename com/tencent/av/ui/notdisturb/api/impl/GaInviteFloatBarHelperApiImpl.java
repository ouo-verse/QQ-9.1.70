package com.tencent.av.ui.notdisturb.api.impl;

import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.notdisturb.GaInviteFloatBarUICtr;
import com.tencent.av.ui.notdisturb.api.IGaInviteFloatBarHelperApi;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GaInviteFloatBarHelperApiImpl implements IGaInviteFloatBarHelperApi {
    @Override // com.tencent.av.ui.notdisturb.api.IGaInviteFloatBarHelperApi
    public void showHalfScreen(long j3, Intent intent) {
        GaInviteFloatBarUICtr gaInviteFloatBarUICtr = new GaInviteFloatBarUICtr(VideoAppInterface.N(), intent);
        gaInviteFloatBarUICtr.r();
        gaInviteFloatBarUICtr.s(j3, intent);
    }
}
