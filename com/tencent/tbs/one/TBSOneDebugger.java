package com.tencent.tbs.one;

import android.content.Context;
import android.view.View;
import com.tencent.tbs.one.TBSOneManager;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TBSOneDebugger {
    View createPanelView(Context context);

    void executeCommand(Context context, String str, Map<String, Object> map, TBSOneCallback<Void> tBSOneCallback);

    void setDebuggerPolicy(TBSOneManager.Policy policy);
}
