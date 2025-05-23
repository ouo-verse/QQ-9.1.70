package com.tencent.mobileqq.troop.troopgame;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopgame.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes19.dex */
public class TroopGameCardConfigProcessor extends l<com.tencent.mobileqq.troop.troopgame.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f300240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements c.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGameCardConfigProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.c.b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadProgress and percent is " + i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.c.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadStart");
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.c.b
        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.i("TroopGameCardConfigProcessor", 1, "onResDownloadFailed");
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.c.b
        public void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadReady");
            }
            BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).edit().putString("resPath", str).commit();
        }
    }

    /* loaded from: classes19.dex */
    public interface b {
        void a(int i3);
    }

    public TroopGameCardConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f300240a = new LinkedList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.tencent.mobileqq.troop.troopgame.a aVar) {
        if (aVar == null) {
            return;
        }
        new c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).d(new c.C8810c(aVar.c(), aVar.b()), new a());
    }

    public static com.tencent.mobileqq.troop.troopgame.a e() {
        com.tencent.mobileqq.troop.troopgame.a aVar = (com.tencent.mobileqq.troop.troopgame.a) am.s().x(695);
        if (aVar == null) {
            return new com.tencent.mobileqq.troop.troopgame.a();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardConfigProcessor", 2, "[notifyListeners]:" + this.f300240a.size());
        }
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
        try {
            synchronized (this.f300240a) {
                if (this.f300240a.size() > 0) {
                    Iterator<b> it = this.f300240a.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().a(i3);
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.e("TroopGameCardConfigProcessor", 1, th5, new Object[0]);
                            }
                        }
                    }
                    this.f300240a.clear();
                }
            }
        } catch (Throwable th6) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopGameCardConfigProcessor", 1, th6, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<com.tencent.mobileqq.troop.troopgame.a> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopgame.a.class;
    }

    public void d(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardConfigProcessor", 2, "[getConfig]");
        }
        synchronized (this.f300240a) {
            if (this.f300240a.size() > 0) {
                this.f300240a.add(bVar);
                return;
            }
            this.f300240a.add(bVar);
            am.s().M(new int[]{695});
            ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
            ThreadManager.getSubThreadHandler().postAtTime(new Runnable() { // from class: com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopGameCardConfigProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopGameCardConfigProcessor.this.g(-1);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, this, SystemClock.uptimeMillis() + 10000);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.troopgame.a migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.troopgame.a) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        QLog.d("TroopGameCardConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + i3);
        return new com.tencent.mobileqq.troop.troopgame.a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.troopgame.a onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.troopgame.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            com.tencent.mobileqq.troop.troopgame.a e16 = com.tencent.mobileqq.troop.troopgame.a.e(aiVarArr[0].f202268b);
            ThreadManager.getSubThreadHandler().post(new Runnable(e16) { // from class: com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.troop.troopgame.a f300241d;

                {
                    this.f300241d = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopGameCardConfigProcessor.this, (Object) e16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopGameCardConfigProcessor.this.c(this.f300241d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
            return e16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onUpdate(com.tencent.mobileqq.troop.troopgame.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardConfigProcessor", 1, "onUpdate, newConf = " + aVar);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.troop.troopgame.a f300242d;

            {
                this.f300242d = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopGameCardConfigProcessor.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopGameCardConfigProcessor.this.c(this.f300242d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedUpgradeReset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        QLog.d("TroopGameCardConfigProcessor", 1, "onReqFailed, failCode = " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 695;
    }
}
