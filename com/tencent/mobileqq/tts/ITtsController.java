package com.tencent.mobileqq.tts;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.tts.data.i;
import xt2.a;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITtsController extends QRouteApi {
    public static final int BUSINESS_ID_CHAT_BOT = 2;
    public static final int BUSINESS_MESSAGE_READ = 0;
    public static final int BUSINESS_VOICE_ASSISTANT = 1;

    void destroy();

    String getSpeech();

    void init(int i3);

    boolean isWorking();

    void setTtsListener(a aVar);

    void speak(String str, String str2);

    boolean speak(i iVar);

    void stop();
}
