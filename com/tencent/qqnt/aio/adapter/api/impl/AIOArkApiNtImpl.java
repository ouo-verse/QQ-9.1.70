package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.adapter.api.IAIOArkApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOArkApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOArkApi;", "", "app", "view", "", "canReplyByFreesia", "Lcom/tencent/qqnt/aio/adapter/api/a;", "getArkPlatformConfig", "url", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/aio/adapter/api/b;", WadlProxyConsts.EXTRA_DATA, WadlProxyConsts.KEY_JUMP_URL, "", "jumpToPreViewImage", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOArkApiNtImpl implements IAIOArkApi {
    static IPatchRedirector $redirector_;

    public AIOArkApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    public boolean canReplyByFreesia(@Nullable String app, @Nullable String view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) app, (Object) view)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    @Nullable
    public com.tencent.qqnt.aio.adapter.api.a getArkPlatformConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.aio.adapter.api.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    public void jumpToPreViewImage(@NotNull Activity activity, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(url, "url");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOArkApi
    public boolean jumpUrl(@NotNull String url, @Nullable MsgRecord msgRecord, @Nullable Activity activity, @NotNull com.tencent.qqnt.aio.adapter.api.b extraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, url, msgRecord, activity, extraData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        return false;
    }
}
