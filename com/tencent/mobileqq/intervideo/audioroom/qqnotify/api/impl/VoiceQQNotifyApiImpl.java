package com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.IQQNotifyCallback;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.IQQNotifySubscribeCallback;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.IVoiceQQNotifyListener;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.VoiceQQNotifyHelper;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.IVoiceQQNotifyApi;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VoiceQQNotifyApiImpl implements IVoiceQQNotifyApi {
    @Override // com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.IVoiceQQNotifyApi
    public void querySubscribe(String str, String str2, String str3, final IQQNotifyCallback iQQNotifyCallback) {
        VoiceQQNotifyHelper.querySubscribe(str, str2, str3, new IVoiceQQNotifyListener() { // from class: com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.impl.VoiceQQNotifyApiImpl.1
            @Override // com.tencent.mobileqq.intervideo.audioroom.qqnotify.IVoiceQQNotifyListener, com.tencent.mobileqq.activity.activateFriend.ae.b
            public void queryHasSetNotify(Bundle bundle, Bundle bundle2) {
                IQQNotifyCallback iQQNotifyCallback2 = iQQNotifyCallback;
                if (iQQNotifyCallback2 != null) {
                    iQQNotifyCallback2.queryHasSetNotify(bundle, bundle2);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.IVoiceQQNotifyApi
    public void showSubscribeDialog(Context context, String str, String str2, String str3, int i3) {
        VoiceQQNotifyHelper.showSubscribeDialog(context, str, str2, str3, i3);
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.IVoiceQQNotifyApi
    public void subscribeDirectly(String str, String str2, String str3, final IQQNotifySubscribeCallback iQQNotifySubscribeCallback) {
        VoiceQQNotifyHelper.subscribeDirectly(str, str2, str3, new ae.c() { // from class: com.tencent.mobileqq.intervideo.audioroom.qqnotify.api.impl.a
            @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
            public final void onResult(Bundle bundle, Bundle bundle2) {
                IQQNotifySubscribeCallback.this.onResult(bundle, bundle2);
            }
        });
    }
}
