package com.qq.e.tg.nativ;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MediaListenerAdapter implements ADListener {

    /* renamed from: a, reason: collision with root package name */
    private MediaListener f40536a;

    public MediaListenerAdapter(MediaListener mediaListener) {
        this.f40536a = mediaListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f40536a.onVideoReady(((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 2:
                this.f40536a.onVideoStart();
                return;
            case 3:
                this.f40536a.onVideoPause();
                return;
            case 4:
                this.f40536a.onVideoComplete();
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f40536a.onVideoError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 6:
                this.f40536a.onReplayButtonClicked();
                return;
            case 7:
                this.f40536a.onADButtonClicked();
                return;
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Boolean)) {
                    this.f40536a.onFullScreenChanged(((Boolean) aDEvent.getParas()[0]).booleanValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            default:
                return;
        }
    }
}
