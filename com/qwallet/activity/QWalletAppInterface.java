package com.qwallet.activity;

import com.qwallet.activity.sso.QWalletBaseProtocol;
import com.qwallet.activity.sso.d;
import com.qwallet.activity.sso.e;
import com.qwallet.activity.sso.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletAppInterface {
    public static final int PROTOCOL_ID_GET_PUBACC_LIST = 4;
    public static final int PROTOCOL_ID_GET_SIGN = 5;
    public static final int PROTOCOL_ID_PATTERN_LOCK_GET_PWD = 3;
    public static final int PROTOCOL_ID_PATTERN_LOCK_SET_PWD = 2;
    public static final int PROTOCOL_ID_PERSONAL_INFO = 1;
    private final List<WeakReference<f>> mQWalletUIObserversRef = new ArrayList();
    private final List<QWalletBaseProtocol> mQWalletBaseProtocols = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static QWalletAppInterface f41263a = new QWalletAppInterface();
    }

    QWalletAppInterface() {
        e.a(this);
    }

    private QWalletBaseProtocol createQWalletProtocolById(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return null;
                    }
                    return new com.qwallet.activity.sso.b();
                }
                return new com.qwallet.activity.sso.a();
            }
            return new com.qwallet.activity.sso.c();
        }
        return new d();
    }

    private void dispatchMessage(final f fVar, final int i3, final boolean z16, final boolean z17, final Object obj) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qwallet.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                QWalletAppInterface.lambda$dispatchMessage$0(f.this, i3, z16, z17, obj);
            }
        });
    }

    public static QWalletAppInterface getInstance() {
        return a.f41263a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$dispatchMessage$0(f fVar, int i3, boolean z16, boolean z17, Object obj) {
        if ((fVar instanceof QWalletBaseFragment) && ((QWalletBaseFragment) fVar).isFinishing()) {
            return;
        }
        fVar.g3(i3, z16, z17, obj);
    }

    public QWalletBaseProtocol getQWalletProtocolById(int i3) {
        for (QWalletBaseProtocol qWalletBaseProtocol : this.mQWalletBaseProtocols) {
            if (qWalletBaseProtocol.f() == i3) {
                return qWalletBaseProtocol;
            }
        }
        QWalletBaseProtocol createQWalletProtocolById = createQWalletProtocolById(i3);
        this.mQWalletBaseProtocols.add(createQWalletProtocolById);
        return createQWalletProtocolById;
    }

    public void notifyUI(int i3, int i16, boolean z16, boolean z17, Object obj) {
        Iterator<WeakReference<f>> it = this.mQWalletUIObserversRef.iterator();
        while (it.hasNext()) {
            f fVar = it.next().get();
            if (fVar != null && i3 == fVar.H9()) {
                dispatchMessage(fVar, i16, z16, z17, obj);
            }
        }
    }

    public void registUIObserver(f fVar) {
        Iterator<WeakReference<f>> it = this.mQWalletUIObserversRef.iterator();
        while (it.hasNext()) {
            if (it.next().get() == fVar) {
                return;
            }
        }
        this.mQWalletUIObserversRef.add(new WeakReference<>(fVar));
    }

    public void unRegistUIObserver(f fVar) {
        for (WeakReference<f> weakReference : this.mQWalletUIObserversRef) {
            if (weakReference.get() == fVar) {
                this.mQWalletUIObserversRef.remove(weakReference);
                return;
            }
        }
    }
}
