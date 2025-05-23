package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.widget.Toast;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ChatHistoryShortVideoApiNTImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi;", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "source", "", "seqList", "", "forwardToShortVideoLayer", "key", "obtainJumpUrlKeyVal", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$a;", "listener", "setOnHistoryShortEventListener", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoApiNTImpl implements IChatHistoryShortVideoApi {
    static IPatchRedirector $redirector_;

    public ChatHistoryShortVideoApiNTImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi
    public void forwardToShortVideoLayer(@NotNull Context context, @NotNull String jumpUrl, @NotNull String entrance, @NotNull List<String> source, @NotNull List<Long> seqList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, jumpUrl, entrance, source, seqList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(seqList, "seqList");
        Toast.makeText(context, "NT\u6682\u672a\u5b9e\u73b0", 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi
    @NotNull
    public String obtainJumpUrlKeyVal(@NotNull Context context, @NotNull String jumpUrl, @NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, context, jumpUrl, key);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(key, "key");
        Toast.makeText(context, "NT\u6682\u672a\u5b9e\u73b0", 0).show();
        return "";
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi
    public void setOnHistoryShortEventListener(@Nullable IChatHistoryShortVideoApi.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        }
    }
}
