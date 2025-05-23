package com.tencent.mobileqq.qqlive.api.impl.room;

/* loaded from: classes17.dex */
public interface PlayRetryStrategy {
    void bindPlayModule(RoomPlayModule roomPlayModule);

    void onError(int i3, int i16, int i17, String str);

    void onPrepared();

    void reset();
}
