package ni2;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface b extends IQQLiveModule {
    c b();

    SharedFlow<fp4.c> d(int i3);

    void e(long j3, long j16, @Nullable String str);

    long getRoomId();

    void registerMessageSmoothConfig(MessagePushConfig messagePushConfig);

    void unRegisterMessageSmooth();
}
