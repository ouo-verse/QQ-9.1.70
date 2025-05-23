package com.tencent.qqmini.sdk.launcher.shell;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniGameEnv {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IMiniGameFloatViewOperator {
        void addFloatView(String str, @Nullable Bundle bundle);

        void removeFloatView(String str, @Nullable Bundle bundle);

        void updateFloatView(@NonNull String str, @Nullable HashMap<String, String> hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IMiniGameReporter {
        void reportNetRequest(MiniAppInfo miniAppInfo, @NonNull HashMap<String, String> hashMap, boolean z16, boolean z17);
    }

    void completeGameBoxTask(String str, String str2);

    @Nullable
    IMiniGameFloatViewOperator getFloatViewOperator(int i3);

    IMiniGameReporter getMiniGameReporter();
}
