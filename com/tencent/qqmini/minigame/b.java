package com.tencent.qqmini.minigame;

import androidx.annotation.NonNull;
import com.tencent.qqmini.minigame.report.MiniGameMonitorReport;
import com.tencent.qqmini.minigame.ui.GameUIProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b implements IMiniGameEnv {

    /* renamed from: a, reason: collision with root package name */
    C9389b f346362a = new C9389b();

    /* renamed from: b, reason: collision with root package name */
    WeakReference<GameUIProxy> f346363b;

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.minigame.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C9389b implements IMiniGameEnv.IMiniGameReporter {
        C9389b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv.IMiniGameReporter
        public void reportNetRequest(MiniAppInfo miniAppInfo, @NonNull HashMap<String, String> hashMap, boolean z16, boolean z17) {
            MiniGameMonitorReport.q(miniAppInfo, hashMap, z16, z17);
        }
    }

    public b(GameUIProxy gameUIProxy) {
        this.f346363b = new WeakReference<>(gameUIProxy);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv
    public void completeGameBoxTask(String str, String str2) {
        com.tencent.qqmini.minigame.a.a().b(str, str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv
    public IMiniGameEnv.IMiniGameFloatViewOperator getFloatViewOperator(int i3) {
        GameUIProxy gameUIProxy = this.f346363b.get();
        if (gameUIProxy == null) {
            QMLog.e("MiniGameEnv", "[getFloatViewOperator] uiProxy is null.");
            return null;
        }
        GameRuntime gameRuntime = gameUIProxy.getGameRuntime();
        if (gameRuntime == null) {
            QMLog.e("MiniGameEnv", "[getFloatViewOperator] runtime is null.");
            return null;
        }
        return gameRuntime.getFloatViewOperator(i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv
    public IMiniGameEnv.IMiniGameReporter getMiniGameReporter() {
        return this.f346362a;
    }
}
