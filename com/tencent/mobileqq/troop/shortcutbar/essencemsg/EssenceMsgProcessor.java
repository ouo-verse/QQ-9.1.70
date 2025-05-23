package com.tencent.mobileqq.troop.shortcutbar.essencemsg;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.essencemsg.s;
import com.tencent.mobileqq.troop.essencemsg.u;
import com.tencent.mobileqq.troop.observer.f;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class EssenceMsgProcessor extends com.tencent.mobileqq.troop.shortcutbar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final long f298640a;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f298641b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298642c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.a f298643d;

    /* renamed from: e, reason: collision with root package name */
    private long f298644e;

    /* renamed from: f, reason: collision with root package name */
    private f f298645f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.f f298646g;

    /* renamed from: h, reason: collision with root package name */
    private Context f298647h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class EssenceMsgShortcurBarInfo extends ShortcutBarInfo {
        static IPatchRedirector $redirector_;

        EssenceMsgShortcurBarInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo
        public int getPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return 2;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
    }

    /* loaded from: classes19.dex */
    class a extends f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EssenceMsgProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.f
        protected void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                EssenceMsgProcessor.this.j(j3);
            }
        }
    }

    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.troop.shortcutbar.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EssenceMsgProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void e(long j3, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (i3 == 0) {
                EssenceMsgProcessor.this.p(false);
            } else {
                EssenceMsgProcessor.this.j(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements TroopEssenceMsgManager.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EssenceMsgProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
        public void a(long j3, HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), hashMap);
                return;
            }
            if (hashMap == null) {
                return;
            }
            long j16 = 0;
            for (TroopEssenceMsgItem.c cVar : hashMap.values()) {
                if (cVar.f295274a == 1) {
                    long j17 = cVar.f295277d;
                    if (j16 < j17) {
                        z16 = true;
                        j16 = j17;
                    }
                }
            }
            if (z16) {
                EssenceMsgProcessor.this.n(j16);
            }
        }
    }

    public EssenceMsgProcessor(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, com.tencent.mobileqq.troop.shortcutbar.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        this.f298640a = 86400L;
        if (aVar == null) {
            return;
        }
        this.f298642c = aVar;
        this.f298641b = (QQAppInterface) aVar.d();
        this.f298643d = aVar2;
        this.f298647h = aVar.e();
        try {
            this.f298644e = Long.valueOf(this.f298642c.f()).longValue();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("EssenceMsgProcessor", 2, "mTroopUin init error: ", e16);
            }
        }
        this.f298645f = new a();
        this.f298646g = new b();
    }

    private boolean k(long j3) {
        TroopShortcutBarInfo m3 = ((TroopShortcutBarManager) this.f298641b.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(this.f298644e));
        if (m3 == null) {
            return false;
        }
        if (m3.getDisabled() != 1 && m3.getGroupDisabled() != 1) {
            return false;
        }
        long z16 = ((TroopEssenceMsgManager) this.f298641b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).z(this.f298644e);
        if (j3 == 0 || z16 > j3 || (NetConnInfoCenter.getServerTime() - j3) / 86400 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ArrayList arrayList) {
        com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f298643d;
        if (aVar != null) {
            aVar.h(5, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j3) {
        p(k(j3));
    }

    private void o(final ArrayList<ShortcutBarInfo> arrayList) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.essencemsg.a
                @Override // java.lang.Runnable
                public final void run() {
                    EssenceMsgProcessor.this.l(arrayList);
                }
            });
            return;
        }
        com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f298643d;
        if (aVar != null) {
            aVar.h(5, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16) {
        if (!z16) {
            o(null);
            return;
        }
        EssenceMsgShortcurBarInfo essenceMsgShortcurBarInfo = new EssenceMsgShortcurBarInfo();
        essenceMsgShortcurBarInfo.setIconUrl(this.f298641b.getApplication().getResources().getString(R.string.f23302765));
        essenceMsgShortcurBarInfo.setMsgSummary(this.f298641b.getApplication().getResources().getString(R.string.f23303766));
        essenceMsgShortcurBarInfo.setShowFrame(0);
        essenceMsgShortcurBarInfo.setShowDel(false);
        ArrayList<ShortcutBarInfo> arrayList = new ArrayList<>();
        arrayList.add(essenceMsgShortcurBarInfo);
        o(arrayList);
        s.n(this.f298641b, this.f298644e, false);
        s.o(this.f298641b, this.f298644e, false);
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f298641b.addObserver(this.f298645f);
        this.f298641b.addObserver(this.f298646g);
        m(this.f298644e);
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
            return;
        }
        if (obj instanceof EssenceMsgShortcurBarInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("EssenceMsgProcessor", 2, NodeProps.ON_CLICK);
            }
            ((TroopEssenceMsgManager) this.f298641b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).l0(this.f298644e, NetConnInfoCenter.getServerTime());
            u.r(this.f298641b, String.valueOf(this.f298644e), 0L, 0, this.f298647h, 2);
            p(false);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d("EssenceMsgProcessor", 1, "onChatPieDestroy");
        this.f298641b.removeObserver(this.f298645f);
        this.f298641b.removeObserver(this.f298646g);
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void e(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, obj);
        }
    }

    public void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else if (j3 != 0 && j3 == this.f298644e) {
            n(((TroopEssenceMsgManager) this.f298641b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).A(j3));
        }
    }

    public void m(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            if (j3 == 0) {
                return;
            }
            ((TroopEssenceMsgManager) this.f298641b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).y(j3, new c());
        }
    }
}
