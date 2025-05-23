package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyViewEvent {
    private final String mEventName;

    public HippyViewEvent(String str) {
        this.mEventName = str;
    }

    public void send(int i3, HippyEngineContext hippyEngineContext, Object obj) {
        HippyModuleManager moduleManager;
        if (hippyEngineContext == null || (moduleManager = hippyEngineContext.getModuleManager()) == null) {
            return;
        }
        ((EventDispatcher) moduleManager.getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(i3, this.mEventName, obj);
    }

    public void send(View view, Object obj) {
        if (view == null || !(view.getContext() instanceof HippyInstanceContext)) {
            return;
        }
        send(view.getId(), ((HippyInstanceContext) view.getContext()).getEngineContext(), obj);
    }
}
