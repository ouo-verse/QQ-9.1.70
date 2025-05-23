package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class CustomEmoRoamingBaseHandler<T extends CustomEmotionBase> extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "CustomEmoRoamingBaseHandler";
    public AppInterface app;

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomEmoRoamingBaseHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.app = appInterface;
        }
    }

    public abstract void delUserEmoRoamingReq(List<String> list, boolean z16);

    protected abstract void handleDelMessage(Object obj, boolean z16);

    public abstract void queryUserEmoRoamingReq();
}
