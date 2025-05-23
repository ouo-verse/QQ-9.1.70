package com.tencent.qqmini.minigame.task;

import com.tencent.qqmini.minigame.api.TritonPlatformManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqmini/minigame/task/e;", "", "", "a", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f346742a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/minigame/task/e$a", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$SoLoadListener;", "", "soPath", "", "onSuccess", "", "errorCode", "onFail", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class a implements DownloaderProxy.SoLoadListener {
        a() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
        public void onFail(int errorCode) {
            QMLog.e("WebAudioSoLoader", "loadWebAudioSo fail, errorCode=" + errorCode);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
        public void onSuccess(@Nullable String soPath) {
            if (soPath == null) {
                QMLog.e("WebAudioSoLoader", "loadWebAudioSo onSuccess, but soPath is null!");
            } else {
                TritonPlatformManager.INSTANCE.setWebAudioSoPath(soPath);
            }
        }
    }

    e() {
    }

    public final void a() {
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).loadMiniGameSo("qqminigamewebaudio", new a());
    }
}
