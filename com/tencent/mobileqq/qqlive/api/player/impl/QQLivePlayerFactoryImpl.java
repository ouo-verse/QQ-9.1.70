package com.tencent.mobileqq.qqlive.api.player.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.player.IQQLivePlayerFactory;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/impl/QQLivePlayerFactoryImpl;", "Lcom/tencent/mobileqq/qqlive/api/player/IQQLivePlayerFactory;", "()V", "getQQLivePlayer", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLivePlayerFactoryImpl implements IQQLivePlayerFactory {
    static IPatchRedirector $redirector_;

    public QQLivePlayerFactoryImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.player.IQQLivePlayerFactory
    @NotNull
    public IQQLivePlayer getQQLivePlayer(@NotNull PlayerConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IQQLivePlayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        return new QQLivePlayerImpl(config);
    }
}
