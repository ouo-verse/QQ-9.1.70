package com.tencent.mobileqq.icgame.push;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e implements t32.a {

    /* renamed from: d, reason: collision with root package name */
    private LivePushRepository f237415d;

    /* renamed from: e, reason: collision with root package name */
    private IQQLiveSDK f237416e;

    @Override // t32.a
    public t32.b b() {
        return new c(this.f237415d);
    }

    @Override // t32.a
    public SharedFlow<bz0.c> d(int i3) {
        LivePushRepository livePushRepository = this.f237415d;
        if (livePushRepository != null) {
            return livePushRepository.j(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        LivePushRepository livePushRepository = this.f237415d;
        if (livePushRepository != null) {
            livePushRepository.c();
        }
    }

    @Override // t32.a
    public long getRoomId() {
        LivePushRepository livePushRepository = this.f237415d;
        if (livePushRepository != null) {
            return livePushRepository.getRoomId();
        }
        return 0L;
    }

    @Override // t32.a
    public void h(long j3, long j16) {
        IQQLiveSDK iQQLiveSDK;
        if (this.f237415d != null && (iQQLiveSDK = this.f237416e) != null && !iQQLiveSDK.isDestroyed()) {
            this.f237415d.c();
            this.f237415d.e(this.f237416e.getAppId(), j16);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.f237416e = iQQLiveSDK;
        this.f237415d = new LivePushRepository();
    }

    @Override // t32.a
    public void registerMessageSmoothConfig(MessagePushConfig messagePushConfig) {
        LivePushRepository livePushRepository = this.f237415d;
        if (livePushRepository != null) {
            livePushRepository.h(messagePushConfig);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        LivePushRepository livePushRepository = this.f237415d;
        if (livePushRepository != null) {
            livePushRepository.c();
        }
    }

    @Override // t32.a
    public void unRegisterMessageSmooth() {
        LivePushRepository livePushRepository = this.f237415d;
        if (livePushRepository != null) {
            livePushRepository.h(null);
        }
    }
}
