package com.tencent.luggage.wxa.g8;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.luggage.wxa.a8.p;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6237a extends b {
        void onLoadFailure(String str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void onLoad(@Nullable String str, String str2);
    }

    c a();

    String a(com.tencent.luggage.wxa.z7.c cVar, Bundle bundle, @NonNull LifecycleOwner lifecycleOwner, @NonNull p pVar);

    void a(@Nullable x xVar);

    void a(com.tencent.luggage.wxa.z7.c cVar, Bitmap bitmap);

    void a(com.tencent.luggage.wxa.z7.c cVar, b bVar);

    void a(com.tencent.luggage.wxa.z7.c cVar, String str, String str2, b bVar);

    void a(com.tencent.luggage.wxa.z7.c cVar, String str, String str2, boolean z16, InterfaceC6237a interfaceC6237a);

    void a(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar);

    void a(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, Bundle bundle);

    void a(boolean z16);

    boolean a(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, int i3);

    com.tencent.luggage.wxa.g8.b b();

    void b(com.tencent.luggage.wxa.z7.c cVar, b bVar);

    void b(LivePusherPluginHandler livePusherPluginHandler, @Nullable com.tencent.luggage.wxa.z7.c cVar);

    void b(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, Bundle bundle);

    boolean b(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, int i3);

    void c();

    void c(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar);
}
