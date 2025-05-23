package com.tencent.mobileqq.activity.aio.voicetextpanel.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Voice2TxtApiImpl implements IVoice2TxtApi {
    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi
    public BaseVoicetoTextView getVoice2TxtView(Context context) {
        return (BaseVoicetoTextView) View.inflate(context, R.layout.c6o, null);
    }
}
