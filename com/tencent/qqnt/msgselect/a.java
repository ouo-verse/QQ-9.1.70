package com.tencent.qqnt.msgselect;

import android.os.Bundle;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/msgselect/a;", "Lcom/tencent/qqnt/msgselect/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "Landroid/os/Bundle;", "result", "", "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msgselect.b
    public void a(@NotNull com.tencent.aio.api.runtime.a context, @NotNull List<? extends AIOMsgItem> msgList, @NotNull Bundle result) {
        int collectionSizeOrDefault;
        long[] longArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, msgList, result);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("DefaultMsgSelectProcessor", 1, "return msgIds");
        List<? extends AIOMsgItem> list = msgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgId()));
        }
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        result.putLongArray("key_select_msg_ids", longArray);
    }
}
