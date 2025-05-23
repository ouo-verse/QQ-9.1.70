package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasRes implements AbsVasRes, Handler.Callback {
    private Handler mUIHandler;
    private VasResAdapter mVasResAdapter;
    private VasResController mVasResController;

    public VasRes(AppRuntime appRuntime, int i3) {
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.mUIHandler = handler;
        this.mVasResController = new VasResController(i3, handler);
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public VasResAdapter getVasResAdapter() {
        return this.mVasResAdapter;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public VasResController getVasResController() {
        return this.mVasResController;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        VasResAdapter vasResAdapter = this.mVasResAdapter;
        if (vasResAdapter == null) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 10002) {
            if (i3 == 10003) {
                vasResAdapter.load();
            }
            return true;
        }
        vasResAdapter.downloadDone(message.arg1, (Bundle) message.obj);
        return true;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public void recycle() {
        VasResAdapter vasResAdapter = this.mVasResAdapter;
        if (vasResAdapter != null) {
            vasResAdapter.destroy();
        }
    }

    public void setAdapter(VasResAdapter vasResAdapter) {
        this.mVasResAdapter = vasResAdapter;
        vasResAdapter.load();
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public void update(int i3) {
        this.mVasResController.update(i3);
        VasResAdapter vasResAdapter = this.mVasResAdapter;
        if (vasResAdapter != null) {
            vasResAdapter.load();
        }
    }
}
