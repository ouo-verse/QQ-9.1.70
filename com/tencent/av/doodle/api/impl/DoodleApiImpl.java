package com.tencent.av.doodle.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleSurfaceView;
import com.tencent.av.doodle.a;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleApiImpl implements IDoodleApi {
    @Override // com.tencent.av.doodle.api.IDoodleApi
    public View createDoodleSurfaceView(Context context) {
        return new DoodleSurfaceView(context);
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public String getUnableTip(Context context) {
        return a.b(context);
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public int getUnableTipResId() {
        return a.c();
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public void hideDoodle(long j3, Activity activity) {
        if (activity instanceof AVActivity) {
            a.d(j3, (AVActivity) activity);
        }
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public boolean isDoodleShow(long j3, Activity activity) {
        if (activity instanceof AVActivity) {
            return a.e(j3, (AVActivity) activity);
        }
        return false;
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public boolean isDoodleUsable() {
        return a.f();
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public void restoreDoodle(long j3, Activity activity) {
        if (activity instanceof AVActivity) {
            a.h(j3, (AVActivity) activity);
        }
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public int sendAVFunChatMsg(int i3, byte[] bArr) {
        return r.h0().t2(i3, bArr);
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public void showDoodle(long j3, Activity activity) {
        if (activity instanceof AVActivity) {
            a.i(j3, (AVActivity) activity);
        }
    }

    @Override // com.tencent.av.doodle.api.IDoodleApi
    public void notifyAddDoodleSurfaceView() {
        VideoAppInterface.N().k0(new Object[]{161});
    }
}
