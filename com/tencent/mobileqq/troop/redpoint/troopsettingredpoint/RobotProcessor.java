package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class RobotProcessor extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private boolean f298274c;

    /* renamed from: d, reason: collision with root package name */
    private ct2.b f298275d;

    public RobotProcessor(QQAppInterface qQAppInterface, String str) {
        super(qQAppInterface, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        this.f298274c = false;
        ct2.b bVar = new ct2.b() { // from class: com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.RobotProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotProcessor.this);
                }
            }

            @Override // ct2.b
            protected void e(boolean z16, long j3, ArrayList<String> arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), arrayList);
                } else if (z16) {
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.RobotProcessor.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z17;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (RobotProcessor.this.f298278b != null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if ((!TextUtils.isEmpty(r0.f298277a)) & z17) {
                                RobotProcessor robotProcessor = RobotProcessor.this;
                                IRobotUtilApi iRobotUtilApi = (IRobotUtilApi) QRoute.api(IRobotUtilApi.class);
                                RobotProcessor robotProcessor2 = RobotProcessor.this;
                                robotProcessor.f298274c = iRobotUtilApi.getNeedShowRobotRedDotAio(robotProcessor2.f298278b, robotProcessor2.f298277a);
                                if (QLog.isColorLevel()) {
                                    QLog.d("RobotProcessor", 2, "onGetRobotsRedList : needShowRobotRedPoint = " + RobotProcessor.this.f298274c);
                                }
                                IRedPointUtilsApi iRedPointUtilsApi = (IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class);
                                RobotProcessor robotProcessor3 = RobotProcessor.this;
                                iRedPointUtilsApi.updateRedPointInfo(robotProcessor3.f298278b, robotProcessor3.f298277a, "troop", 1, robotProcessor3.f298274c ? 1 : 0);
                            }
                        }
                    });
                }
            }
        };
        this.f298275d = bVar;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(bVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RobotProcessor", 2, "cleanTroopSettingRedPointInfo : needShowRobotRedPoint = " + this.f298274c);
        }
        if (this.f298274c && this.f298278b != null) {
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setNeedShowRobotRedDotAio(this.f298278b, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f298278b;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f298275d);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "RobotProcessor";
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f298278b != null && !TextUtils.isEmpty(this.f298277a)) {
            this.f298274c = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getNeedShowRobotRedDotAio(this.f298278b, this.f298277a);
            if (QLog.isColorLevel()) {
                QLog.d("RobotProcessor", 2, "initTroopSettingRedPointInfo : needShowRobotRedPoint = " + this.f298274c);
            }
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.f298278b, this.f298277a, "troop", 1, this.f298274c ? 1 : 0);
        }
    }
}
