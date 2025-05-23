package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.IMiniGameService;
import com.tencent.mobileqq.minigame.report.MiniGameCrashReporter;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameServiceImpl implements IMiniGameService {
    @Override // com.tencent.mobileqq.mini.api.IMiniGameService
    public String getCrashReportExtAppId() {
        return MiniGameCrashReporter.getCurrentMiniGameAppId();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameService
    public Integer getCrashReportExtState() {
        return MiniGameCrashReporter.getCurrentMiniGameState();
    }
}
