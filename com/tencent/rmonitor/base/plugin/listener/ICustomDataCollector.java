package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.custom.ICustomDataEditor;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ICustomDataCollector extends IBaseListener {
    void collectCustomData(String str, String str2, ICustomDataEditor iCustomDataEditor);
}
