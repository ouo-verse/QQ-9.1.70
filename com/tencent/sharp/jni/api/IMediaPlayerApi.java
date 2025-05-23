package com.tencent.sharp.jni.api;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.sharp.jni.callback.OnCompletionListener;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IMediaPlayerApi extends QRouteApi {
    public static final int TRAE_MEDIA_PLAYER_DATASOURCE_FILEPATH = 2;
    public static final int TRAE_MEDIA_PLAYER_DATASOURCE_RID = 0;
    public static final int TRAE_MEDIA_PLAYER_DATASOURCE_URI = 1;

    int getDuration();

    int getStreamType();

    boolean hasCall();

    void init(Context context, OnCompletionListener onCompletionListener);

    boolean playRing(long j3, int i3, int i16, Uri uri, String str, boolean z16, int i17, boolean z17, boolean z18, int i18);

    void stopRing(long j3);
}
