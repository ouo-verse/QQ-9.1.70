package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEssenceApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEssenceApi;", "()V", "getEssenceMenuType", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "isFullScreenEssenceEnable", "", "aioParam", "Lcom/tencent/aio/data/AIOParam;", "onEssenceMenuClicked", "", "context", "Landroid/content/Context;", "isCancel", "setEssenceMsgFromFullScreen", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOEssenceApiNtImpl implements IAIOEssenceApi {
    static IPatchRedirector $redirector_;

    public AIOEssenceApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public int getEssenceMenuType(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return 0;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public boolean isFullScreenEssenceEnable(@NotNull AIOParam aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioParam)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        if (aioParam.r().c().e() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public void onEssenceMenuClicked(@NotNull Context context, @NotNull AIOMsgItem msgItem, boolean isCancel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, msgItem, Boolean.valueOf(isCancel));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public void setEssenceMsgFromFullScreen(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }
    }
}
