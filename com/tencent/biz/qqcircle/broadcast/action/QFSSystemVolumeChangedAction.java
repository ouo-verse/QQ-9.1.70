package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleKeyVolumeChangeEvent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSystemVolumeChangedAction extends QCircleBaseBroadcastAction {

    /* renamed from: a, reason: collision with root package name */
    private int f83140a = -1;

    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "android.media.VOLUME_CHANGED_ACTION";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra;
        int intExtra2;
        int i3;
        try {
            if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && (intExtra2 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1)) != (intExtra = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", this.f83140a)) && intExtra != -1 && intExtra2 != -1) {
                if (intExtra2 > intExtra) {
                    i3 = 24;
                } else {
                    i3 = 25;
                }
                SimpleEventBus.getInstance().dispatchEvent(new QCircleKeyVolumeChangeEvent(i3, intExtra2));
                this.f83140a = intExtra2;
            }
        } catch (IllegalArgumentException e16) {
            QLog.e("QFSSystemVolumeChangedAction", 1, "[onReceive] e:" + e16.getMessage());
            if (!HostAppSettingUtil.isDebugVersion()) {
                return;
            }
            throw new RuntimeException("QFSSystemVolumeChangedAction onReceive error " + e16);
        }
    }
}
