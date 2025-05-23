package com.tencent.tbs.one.optional;

import android.content.Context;
import android.view.View;
import com.tencent.tbs.one.TBSOneCallback;
import java.util.Map;

/* loaded from: classes26.dex */
public abstract class TBSOneDebugPlugin {
    public View createDebuggingView(Context context, String str) {
        return null;
    }

    public void executeCommand(Context context, String str, String str2, Map<String, Object> map, TBSOneCallback<Void> tBSOneCallback) {
        throw new UnsupportedOperationException();
    }
}
