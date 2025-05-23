package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IChatHistorySave2WeiYunApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ChatHistorySave2WeiYunApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistorySave2WeiYunApi;", "()V", "chatHistorySave2WeiYun", "", "context", "Landroid/content/Context;", "msgRecordList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ChatHistorySave2WeiYunApiNtImpl implements IChatHistorySave2WeiYunApi {
    static IPatchRedirector $redirector_;

    public ChatHistorySave2WeiYunApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistorySave2WeiYunApi
    public void chatHistorySave2WeiYun(@NotNull Context context, @NotNull List<MsgRecord> msgRecordList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgRecordList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        Toast.makeText(context, "NT\u6682\u672a\u5b9e\u73b0", 0).show();
    }
}
