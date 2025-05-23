package mh;

import com.qzone.reborn.feedx.video.QZonePlayer;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f416753a = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (f416753a || QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        try {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.context, new C10783a());
        } catch (RuntimeException e16) {
            QLog.e("BasePlayerManager", 1, e16.getMessage());
            e16.printStackTrace();
        }
    }

    /* compiled from: P */
    /* renamed from: mh.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10783a implements SDKInitListener {
        C10783a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (z16) {
                a.f416753a = true;
            } else {
                QLog.e("BasePlayerManager", 1, "onSDKInited failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Iterator<Map.Entry<String, QZonePlayer>> it) {
        if (it == null) {
            return;
        }
        while (it.hasNext()) {
            it.next().getValue().H(QZonePlayer.L);
            it.remove();
        }
    }
}
