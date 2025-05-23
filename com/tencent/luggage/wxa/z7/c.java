package com.tencent.luggage.wxa.z7;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void onBackground(int i3);

        void onDestroy();

        void onForeground();
    }

    String a(com.tencent.luggage.wxa.af.c cVar);

    String a(com.tencent.luggage.wxa.af.c cVar, Map map);

    String a(String str);

    String a(String str, com.tencent.luggage.wxa.af.c cVar);

    String a(String str, Map map);

    JSONObject a();

    void a(a aVar);

    boolean b();

    String c();

    void d();

    com.tencent.luggage.wxa.xd.d e();

    String getAppId();

    Context getContext();
}
