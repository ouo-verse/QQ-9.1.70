package com.tencent.tuxmetersdk.export.injector.event;

import com.tencent.tuxmetersdk.impl.event.EventType;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxRemoteEventReport {
    void report(String str, EventType eventType, String str2, Map<String, String> map);
}
