package com.huya.huyasdk.api;

import hynb.l.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaSubscribe {
    public static void checkSubscriptionStatusWithRequest(HuyaGetSubscribeStatusRequest huyaGetSubscribeStatusRequest, SubscribeStatusCallback subscribeStatusCallback) {
        a.f406746d.a(huyaGetSubscribeStatusRequest, subscribeStatusCallback);
    }

    public static void setSubscribeCallback(SubscribeCallback subscribeCallback) {
        a.f406746d.a(subscribeCallback);
    }

    public static void subscribeActionWithRequest(HuyaPresenterSubscriptionRequest huyaPresenterSubscriptionRequest, SubscribeActionCallback subscribeActionCallback) {
        a.f406746d.a(huyaPresenterSubscriptionRequest, subscribeActionCallback);
    }

    public static void unsubscribeActionWithRequest(HuyaPresenterUnsubscriptionRequest huyaPresenterUnsubscriptionRequest, SubscribeActionCallback subscribeActionCallback) {
        a.f406746d.a(huyaPresenterUnsubscriptionRequest, subscribeActionCallback);
    }
}
