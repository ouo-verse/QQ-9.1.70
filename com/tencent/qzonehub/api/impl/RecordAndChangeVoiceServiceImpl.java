package com.tencent.qzonehub.api.impl;

import android.content.Intent;
import com.tencent.qzonehub.api.IRecordAndChangeVoiceService;
import cooperation.qzone.RecordAndChangeVoiceService;

/* compiled from: P */
/* loaded from: classes34.dex */
public class RecordAndChangeVoiceServiceImpl implements IRecordAndChangeVoiceService {
    @Override // com.tencent.qzonehub.api.IRecordAndChangeVoiceService
    public void cleanData() {
        RecordAndChangeVoiceService.getInstance().cleanData();
    }

    @Override // com.tencent.qzonehub.api.IRecordAndChangeVoiceService
    public void onReceiveRecordData(Intent intent, int i3) {
        RecordAndChangeVoiceService.getInstance().onReceiveRecordData(intent, i3);
    }

    @Override // com.tencent.qzonehub.api.IRecordAndChangeVoiceService
    public void stopPlayingMoodVoice() {
        RecordAndChangeVoiceService.getInstance().stopPlayingMoodVoice();
    }
}
