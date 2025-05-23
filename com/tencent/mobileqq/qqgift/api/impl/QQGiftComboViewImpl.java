package com.tencent.mobileqq.qqgift.api.impl;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgift.api.IQQGiftComboView;
import com.tencent.mobileqq.vasgift.mvvm.business.anim.c;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vasgift.utils.b;
import com.tencent.mobileqq.vasgift.view.QQLiveGiftComboSendView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftComboViewImpl implements IQQGiftComboView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQGiftComboViewImpl";
    private volatile List<IQQGiftComboView.a> callbackList;
    private volatile boolean isLoading;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f264852a;

        a(Context context) {
            this.f264852a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftComboViewImpl.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.c.a
        public void onComplete(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QQGiftComboViewImpl.this.checkSoLoadStatus(this.f264852a);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.c.a
        public void onError(int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.c.a
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public QQGiftComboViewImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.callbackList = new ArrayList();
            this.isLoading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSoLoadStatus(Context context) {
        if (QQGiftPAGAnimationViewImpl.f311895g.a()) {
            notifyLoadSuccess();
        } else {
            QQGiftPAGAnimationViewImpl.f311895g.b(context, new b.InterfaceC8940b() { // from class: com.tencent.mobileqq.qqgift.api.impl.a
                @Override // com.tencent.mobileqq.vasgift.utils.b.InterfaceC8940b
                public final void onComplete(boolean z16) {
                    QQGiftComboViewImpl.this.lambda$checkSoLoadStatus$0(z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSoLoadStatus$0(boolean z16) {
        if (z16) {
            notifyLoadSuccess();
        } else {
            QLog.e(TAG, 2, "QQGiftPAGAnimationViewImpl.loader.loadPag fail!");
        }
        this.isLoading = false;
    }

    private void notifyLoadSuccess() {
        Iterator<IQQGiftComboView.a> it = this.callbackList.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView
    public View createView(Context context, nh2.c cVar, ph2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, cVar, bVar);
        }
        QQLiveGiftComboSendView qQLiveGiftComboSendView = new QQLiveGiftComboSendView(context);
        qQLiveGiftComboSendView.n(false);
        if (bVar != null) {
            qQLiveGiftComboSendView.setListener(bVar);
        }
        return qQLiveGiftComboSendView;
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView
    public void hideAnimation(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view instanceof QQLiveGiftComboSendView) {
            ((QQLiveGiftComboSendView) view).E();
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView
    public boolean isPagSoReady(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        if (c.f311706a.l(context) && QQGiftPAGAnimationViewImpl.f311895g.a()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView
    public void loadPag(Context context, IQQGiftComboView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        if (isPagSoReady(context)) {
            aVar.onComplete();
            return;
        }
        this.callbackList.add(aVar);
        if (this.isLoading) {
            QLog.i(TAG, 2, "loadPag processing, just add callback");
            return;
        }
        this.isLoading = true;
        QQGiftPAGAnimationViewImpl.f311895g.b(context, null);
        c.f311706a.d(context, new a(context));
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView
    public void removePagloadCallbacks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.callbackList.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView
    public void showAnimation(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view instanceof QQLiveGiftComboSendView) {
            QQLiveGiftComboSendView qQLiveGiftComboSendView = (QQLiveGiftComboSendView) view;
            qQLiveGiftComboSendView.E();
            qQLiveGiftComboSendView.H(0, Integer.MAX_VALUE);
        }
    }
}
