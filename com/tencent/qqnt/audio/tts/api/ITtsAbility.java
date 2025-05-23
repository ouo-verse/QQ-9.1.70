package com.tencent.qqnt.audio.tts.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tts.data.i;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ITtsAbility extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e(String str);

        void f(i iVar);

        void g();

        void h();

        void onError(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
        void a(String str);
    }

    void destroy();

    void getRobotTargetTtsId(String str, b bVar);

    void init();

    boolean isWorking();

    void muteAudioFocus(Context context, boolean z16);

    void setStateListener(a aVar);

    boolean speak(i iVar);

    void stop();
}
