package com.tencent.qqnt.aio.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.aio.api.IBubbleTokenApi;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/BubbleTokenApiImpl;", "Lcom/tencent/qqnt/aio/api/IBubbleTokenApi;", "()V", "useTokenForBubble", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class BubbleTokenApiImpl implements IBubbleTokenApi {
    static IPatchRedirector $redirector_;

    public BubbleTokenApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IBubbleTokenApi
    public boolean useTokenForBubble(@NotNull AIOMsgItem msgItem) {
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!msgItem.g2()) {
            return true;
        }
        if (msgItem.getMsgRecord().peerUin > 0) {
            valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
        } else {
            IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IUixConvertAdapterApi.class);
            String str = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
            valueOf = String.valueOf(iUixConvertAdapterApi.getUinFromUid(str));
        }
        if (((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(valueOf, Integer.valueOf(msgItem.getMsgRecord().chatType))) {
            return true;
        }
        if (QQTheme.isVasTheme()) {
            return false;
        }
        String b16 = com.tencent.mobileqq.aio.utils.m.f194167a.b(msgItem);
        if (TextUtils.isEmpty(b16) || Intrinsics.areEqual("0", b16)) {
            return true;
        }
        return false;
    }
}
