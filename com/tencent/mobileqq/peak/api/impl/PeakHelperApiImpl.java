package com.tencent.mobileqq.peak.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PeakHelperApiImpl implements IPeakHelperApi {
    static IPatchRedirector $redirector_;

    public PeakHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.peak.api.IPeakHelperApi
    public void cancelPeakAlive(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(context) { // from class: com.tencent.mobileqq.peak.api.impl.PeakHelperApiImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f257465d;

                {
                    this.f257465d = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PeakHelperApiImpl.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(this.f257465d)) {
                        return;
                    }
                    Intent intent = new Intent(this.f257465d, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
                    intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 5);
                    intent.putExtra(AECameraConstants.INTENT_KEY_ALIVE, false);
                    try {
                        this.f257465d.startService(intent);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QCirclePluginInitHelper", 2, "preload peak fail ", e16);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.peak.api.IPeakHelperApi
    public boolean isPeakAlive(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).booleanValue();
        }
        return ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(context);
    }

    @Override // com.tencent.mobileqq.peak.api.IPeakHelperApi
    public void preloadPeakProcess(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(context) { // from class: com.tencent.mobileqq.peak.api.impl.PeakHelperApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f257464d;

                {
                    this.f257464d = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PeakHelperApiImpl.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(this.f257464d)) {
                            return;
                        }
                        Intent intent = new Intent(this.f257464d, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
                        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 2);
                        intent.putExtra(AECameraConstants.INTENT_KEY_ALIVE, true);
                        this.f257464d.startService(intent);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QCirclePluginInitHelper", 2, "preload peak fail ", e16);
                        }
                    }
                }
            });
        }
    }
}
