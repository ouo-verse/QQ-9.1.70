package com.tencent.mobileqq.jubao;

import android.os.Bundle;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/jubao/d;", "Lcom/tencent/qqnt/msgselect/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "Landroid/os/Bundle;", "result", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d implements com.tencent.qqnt.msgselect.b {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msgselect.b
    public void a(@NotNull com.tencent.aio.api.runtime.a context, @NotNull List<? extends AIOMsgItem> msgList, @NotNull Bundle result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, msgList, result);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(result, "result");
        String q16 = a.q(msgList);
        Intrinsics.checkNotNullExpressionValue(q16, "generateNTOpenChatMsgCallbackStr(msgList)");
        Bundle l3 = context.g().l();
        String string = l3.getString("uin", "");
        int i3 = l3.getInt("uintype", 0);
        result.putString("chatuin", string);
        result.putInt("chattype", i3);
        result.putString("msgs", q16);
        QLog.d("JubaoMsgSelectProcessor", 1, "uinType:" + i3 + ", uin:" + string + ", msgs: " + q16);
    }
}
