package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.aio.adapter.api.IAIOWeiYunSaveApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOWeiYunSaveApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeiYunSaveApi;", "()V", "saveMessageToWeiYun", "", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOWeiYunSaveApiNtImpl implements IAIOWeiYunSaveApi {
    static IPatchRedirector $redirector_;

    public AIOWeiYunSaveApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveMessageToWeiYun$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "Save to WeiYun is not Supported", 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeiYunSaveApi
    public void saveMessageToWeiYun(@NotNull final Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ae
            @Override // java.lang.Runnable
            public final void run() {
                AIOWeiYunSaveApiNtImpl.saveMessageToWeiYun$lambda$0(context);
            }
        });
    }
}
