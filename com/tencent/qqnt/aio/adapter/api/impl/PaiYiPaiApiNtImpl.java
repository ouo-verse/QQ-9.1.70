package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PaiYiPaiApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPaiYiPaiApi;", "()V", "jumpToWeb", "", "context", "Landroid/content/Context;", "sendDoubleClickReq", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "sendRevokePaiYiPaiReq", "uin", "", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/Long;)V", "shouldAddGuideTip", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class PaiYiPaiApiNtImpl implements IPaiYiPaiApi {
    static IPatchRedirector $redirector_;

    public PaiYiPaiApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public void jumpToWeb(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Toast.makeText(BaseApplication.getContext(), "PaiYiPaiApiNtImpl.jumpToWeb is not implemented.", 0).show();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public void sendDoubleClickReq(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Toast.makeText(BaseApplication.getContext(), "PaiYiPaiHandlerNtImpl.sendDoubleClickReq is not implemented.", 0).show();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public void sendRevokePaiYiPaiReq(@NotNull MsgRecord msgRecord, @Nullable Long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord, (Object) uin);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Toast.makeText(BaseApplication.getContext(), "PaiYiPaiHandlerNtImpl.sendRevokePaiYiPaiReq is not implemented.", 0).show();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public synchronized boolean shouldAddGuideTip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
