package com.tencent.mobileqq.phonecontact.processor;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface a {
    void a(List<PhoneContact> list);

    void b();

    void c();

    void d(AppInterface appInterface);

    void e();

    boolean f(boolean z16, boolean z17, boolean z18, int i3, RespondQueryQQBindingStat respondQueryQQBindingStat, boolean z19, long j3);

    boolean g(boolean z16);

    void h();

    void i(boolean z16);

    void j(String str, JSONObject jSONObject);

    void onDestroy();

    void refreshAppBadge();
}
