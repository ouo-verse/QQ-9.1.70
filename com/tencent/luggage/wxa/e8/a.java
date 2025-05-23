package com.tencent.luggage.wxa.e8;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.luggage.wxa.a8.p;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {
    c a();

    String a(@NonNull LifecycleOwner lifecycleOwner, @NonNull p pVar);

    void a(int i3, int i16, Bundle bundle);

    void a(com.tencent.luggage.wxa.z7.c cVar);

    void a(com.tencent.luggage.wxa.z7.c cVar, Bitmap bitmap);

    void a(com.tencent.luggage.wxa.z7.c cVar, Bundle bundle);

    void a(LivePlayerPluginHandler livePlayerPluginHandler);

    boolean a(LivePlayerPluginHandler livePlayerPluginHandler, com.tencent.luggage.wxa.z7.c cVar, int i3);

    b b();

    boolean b(com.tencent.luggage.wxa.z7.c cVar);

    boolean c(com.tencent.luggage.wxa.z7.c cVar);

    void d(com.tencent.luggage.wxa.z7.c cVar);
}
