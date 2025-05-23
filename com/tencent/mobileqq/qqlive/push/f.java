package com.tencent.mobileqq.qqlive.push;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f implements ni2.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private LivePushRepository f271426d;

    /* renamed from: e, reason: collision with root package name */
    private IQQLiveSDK f271427e;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // ni2.b
    public ni2.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ni2.c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new d(this.f271426d);
    }

    @Override // ni2.b
    public SharedFlow<fp4.c> d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        LivePushRepository livePushRepository = this.f271426d;
        if (livePushRepository != null) {
            return livePushRepository.l(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        LivePushRepository livePushRepository = this.f271426d;
        if (livePushRepository != null) {
            livePushRepository.c();
        }
    }

    @Override // ni2.b
    public void e(long j3, long j16, @Nullable String str) {
        IQQLiveSDK iQQLiveSDK;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), str);
        } else if (this.f271426d != null && (iQQLiveSDK = this.f271427e) != null && !iQQLiveSDK.isDestroyed()) {
            this.f271426d.c();
            this.f271426d.f(this.f271427e.getAppId(), j16, str);
        }
    }

    @Override // ni2.b
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        LivePushRepository livePushRepository = this.f271426d;
        if (livePushRepository != null) {
            return livePushRepository.d();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.f271427e = iQQLiveSDK;
            this.f271426d = new LivePushRepository();
        }
    }

    @Override // ni2.b
    public void registerMessageSmoothConfig(MessagePushConfig messagePushConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messagePushConfig);
            return;
        }
        LivePushRepository livePushRepository = this.f271426d;
        if (livePushRepository != null) {
            livePushRepository.j(messagePushConfig);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        LivePushRepository livePushRepository = this.f271426d;
        if (livePushRepository != null) {
            livePushRepository.c();
        }
    }

    @Override // ni2.b
    public void unRegisterMessageSmooth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        LivePushRepository livePushRepository = this.f271426d;
        if (livePushRepository != null) {
            livePushRepository.j(null);
        }
    }
}
