package com.tencent.av;

import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.jni.dav.NtrtcEngineCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i implements NtrtcEngineCallback {

    /* renamed from: a, reason: collision with root package name */
    private static String f73839a = "NtrtcEngineCallbackImpl";

    @Override // com.tencent.avcore.jni.dav.NtrtcEngineCallback
    public void onHasGotSharpConfigPayload(int i3) {
        QLog.i(f73839a, 1, "NtrtcEngineCallbackImpl. onHasGotSharpConfigPayload. version[" + i3 + "]");
        BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i3));
        zv.c.c().a("load", i3);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcEngineCallback
    public void onUseXgNetworkForQualityOptimization() {
        QLog.i(f73839a, 1, "NtrtcEngineCallbackImpl. onUseXgNetworkForQualityOptimization.");
        if (!n.e().f().Q2.booleanValue()) {
            VideoAppInterface.N().k0(new Object[]{527});
            n.e().f().Q2 = Boolean.TRUE;
        }
    }
}
