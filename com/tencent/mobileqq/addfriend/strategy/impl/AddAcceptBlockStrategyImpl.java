package com.tencent.mobileqq.addfriend.strategy.impl;

import android.content.Context;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.app.identity.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddAcceptBlockStrategyImpl extends com.tencent.mobileqq.identification.a implements IAddAcceptBlockStrategy {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AddAcceptBlockStrategy";
    private static ArrayList<Integer> hashCodeList;
    private Context context;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IAddAcceptBlockStrategy.a f187365a;

        a(IAddAcceptBlockStrategy.a aVar) {
            this.f187365a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddAcceptBlockStrategyImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.app.identity.f
        public void cancel(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AddAcceptBlockStrategyImpl.TAG, 2, "[AccountIdentity] agree add cancelled, state = " + i3);
            }
            if (i3 != 3) {
                onSuccess();
            }
        }

        @Override // com.tencent.mobileqq.app.identity.f
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.d(AddAcceptBlockStrategyImpl.TAG, 2, "[AccountIdentity] agree add failed");
            }
        }

        @Override // com.tencent.mobileqq.app.identity.f
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f187365a.onSuccess();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            hashCodeList = new ArrayList<>();
        }
    }

    public AddAcceptBlockStrategyImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.context = context;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy
    public void checkAccountIdentity(AppRuntime appRuntime, int i3, Context context, IAddAcceptBlockStrategy.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appRuntime, Integer.valueOf(i3), context, aVar);
        } else {
            ((IAccountApi) QRoute.api(IAccountApi.class)).checkAccountIdentity(appRuntime, i3, new AddAcceptBlockStrategyImpl(context), new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.identification.a
    public boolean isFollowIdentityProcess() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        Context context = this.context;
        if (context != null) {
            hashCode = context.hashCode();
        } else {
            hashCode = hashCode();
        }
        if (hashCodeList.contains(Integer.valueOf(hashCode))) {
            return false;
        }
        hashCodeList.add(Integer.valueOf(hashCode));
        return true;
    }

    public AddAcceptBlockStrategyImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
