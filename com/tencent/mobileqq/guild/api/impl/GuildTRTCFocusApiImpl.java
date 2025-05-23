package com.tencent.mobileqq.guild.api.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi;
import com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCFocusManager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildTRTCFocusApiImpl implements IGuildTRTCFocusApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi
    public void onReleaseTRTCFocus(@NonNull IGuildTRTCFocusApi.a aVar) {
        TRTCFocusManager.j().l(aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi
    public void requestTRTCFocus(@NonNull IGuildTRTCFocusApi.a aVar, @NonNull IGuildTRTCFocusApi.b bVar, @Nullable Handler handler) {
        TRTCFocusManager.j().m(aVar, bVar, handler);
    }
}
