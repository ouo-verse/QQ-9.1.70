package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.custom.ICustomDataEditorForIssue;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ICustomDataCollectorForIssue extends IBaseListener {
    void collectCustomData(String str, String str2, ICustomDataEditorForIssue iCustomDataEditorForIssue);
}
