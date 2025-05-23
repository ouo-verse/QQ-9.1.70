package com.tencent.qqnt.miniaio.api.impl;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.miniaio.MiniAIOEmoticonPanel;
import com.tencent.qqnt.miniaio.api.IMiniaioApi;
import com.tencent.qqnt.miniaio.c;
import com.tencent.qqnt.miniaio.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/miniaio/api/impl/MiniaioApiNtImpl;", "Lcom/tencent/qqnt/miniaio/api/IMiniaioApi;", "", "handleHorizontalMiniaioFinish", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "toMainMsgList", "Landroid/view/ViewGroup;", "containerView", "Lcom/tencent/qqnt/miniaio/d;", "callback", "Lcom/tencent/qqnt/miniaio/c;", "getEmoticonPanel", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniaioApiNtImpl implements IMiniaioApi {
    static IPatchRedirector $redirector_;

    public MiniaioApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.miniaio.api.IMiniaioApi
    @NotNull
    public c getEmoticonPanel(@NotNull ViewGroup containerView, @NotNull d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) containerView, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new MiniAIOEmoticonPanel(containerView, callback);
    }

    @Override // com.tencent.qqnt.miniaio.api.IMiniaioApi
    public void handleHorizontalMiniaioFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.miniaio.api.IMiniaioApi
    public void toMainMsgList(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            QRoute.startUri(new ActivityURIRequest(BaseApplication.context, "/base/start/main"));
        }
    }
}
