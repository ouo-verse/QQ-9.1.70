package com.hihonor.push.sdk;

import android.content.Context;
import java.util.List;

/* loaded from: classes2.dex */
public class HonorPushClient {

    /* renamed from: a, reason: collision with root package name */
    public static final HonorPushClient f36346a = new HonorPushClient();

    public static HonorPushClient getInstance() {
        return f36346a;
    }

    public boolean checkSupportHonorPush(Context context) {
        return l.f36402e.a(context);
    }

    public void deletePushToken(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.f36402e;
        lVar.a(new g(lVar, honorPushCallback), honorPushCallback);
    }

    public void getNotificationCenterStatus(HonorPushCallback<Boolean> honorPushCallback) {
        l lVar = l.f36402e;
        lVar.a(new h(lVar, honorPushCallback), honorPushCallback);
    }

    public void getPushToken(HonorPushCallback<String> honorPushCallback) {
        l lVar = l.f36402e;
        lVar.a(new f(lVar, honorPushCallback, false), honorPushCallback);
    }

    public void getUnReadMessageBox(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        l lVar = l.f36402e;
        lVar.a(new k(lVar, honorPushCallback), honorPushCallback);
    }

    public void init(Context context, boolean z16) {
        l lVar = l.f36402e;
        v vVar = new v();
        vVar.f36444a = context.getApplicationContext();
        vVar.f36445b = z16;
        b1.a(new e(lVar, vVar));
    }

    public void turnOffNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.f36402e;
        lVar.a(new j(lVar, honorPushCallback), honorPushCallback);
    }

    public void turnOnNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.f36402e;
        lVar.a(new i(lVar, honorPushCallback), honorPushCallback);
    }
}
