package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.n;
import com.tencent.imcore.message.y;
import com.tencent.imcore.message.z;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.msgbackup.data.e;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.p;
import cooperation.qlink.ReliableReportProxy;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements Provider<SparseArray<BaseProxy>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<BaseProxy> f196531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AppRuntime appRuntime, BaseProxyManager baseProxyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) baseProxyManager);
            return;
        }
        this.f196531a = new SparseArray<>();
        if (appRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            b(0, new z(qQAppInterface, baseProxyManager, new MsgPool()));
            b(1, new y(qQAppInterface, baseProxyManager, new MsgPool()));
            b(2, new MultiMsgProxy(qQAppInterface, baseProxyManager));
            b(3, new DataLineMsgPcProxy(qQAppInterface, baseProxyManager));
            b(4, new DataLineMsgIpadProxy(qQAppInterface, baseProxyManager));
            b(5, new MpfileTaskProxy(qQAppInterface, baseProxyManager));
            b(6, new FileManagerProxy(qQAppInterface, baseProxyManager));
            b(7, new com.tencent.mobileqq.troop.filemanager.a(qQAppInterface, baseProxyManager));
            b(9, new p(qQAppInterface, baseProxyManager));
            b(10, new ReliableReportProxy(qQAppInterface, baseProxyManager));
            b(11, new n(qQAppInterface, baseProxyManager));
            b(12, new QCallProxy(qQAppInterface, baseProxyManager));
            b(13, new ConfessProxy(qQAppInterface, baseProxyManager));
            b(14, new e(qQAppInterface, baseProxyManager));
            b(15, new DatalineMsgPhoneProxy(qQAppInterface, baseProxyManager));
        }
    }

    private void b(int i3, BaseProxy baseProxy) {
        this.f196531a.put(i3, baseProxy);
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SparseArray<BaseProxy> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f196531a;
    }
}
