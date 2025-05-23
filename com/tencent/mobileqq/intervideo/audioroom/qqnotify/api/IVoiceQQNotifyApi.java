package com.tencent.mobileqq.intervideo.audioroom.qqnotify.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.IQQNotifyCallback;
import com.tencent.mobileqq.intervideo.audioroom.qqnotify.IQQNotifySubscribeCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVoiceQQNotifyApi extends QRouteApi {
    void querySubscribe(@NonNull String str, String str2, String str3, @NonNull IQQNotifyCallback iQQNotifyCallback);

    void showSubscribeDialog(@NonNull Context context, String str, String str2, String str3, int i3);

    void subscribeDirectly(String str, String str2, String str3, @Nullable IQQNotifySubscribeCallback iQQNotifySubscribeCallback);
}
