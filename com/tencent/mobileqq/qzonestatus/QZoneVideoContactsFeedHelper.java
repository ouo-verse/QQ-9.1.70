package com.tencent.mobileqq.qzonestatus;

import android.app.Activity;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.aj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonestatus.a;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cw.e;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QZoneVideoContactsFeedHelper {
    static IPatchRedirector $redirector_;

    public static void b() {
        i(a.h().f(), a.h().i(), a.h().g());
    }

    public static void c(VideoAppInterface videoAppInterface, SessionInfo sessionInfo, Activity activity) {
        if (videoAppInterface == null) {
            QLog.e("QZoneVideoContactsFeedHelper", 1, "app interface is null");
        } else {
            i(videoAppInterface, sessionInfo, activity);
        }
    }

    public static void d() {
        a.h().e();
        a.h().u(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(VideoAppInterface videoAppInterface, SessionInfo sessionInfo, Activity activity) {
        RFWThreadManager.getUIHandler().post(new Runnable(activity, videoAppInterface) { // from class: com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Activity f280129e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ VideoAppInterface f280130f;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper$2$a */
            /* loaded from: classes16.dex */
            class a implements View.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else if (FastClickUtils.isFastDoubleClick("QZoneVideoContactsFeedHelper", 1000L)) {
                        QLog.d("QZoneVideoContactsFeedHelper", 2, "fast click , return");
                    } else {
                        if (QZoneVideoContactsFeedHelper.g(true)) {
                            SimpleEventBus.getInstance().dispatchEvent(new QAVBackPressedBeforeEnterQZoneEvent(), true);
                        }
                        ReportController.o(null, "dc00898", "", "", "0X800C4B0", "0X800C4B0", 0, 0, "", "", "", "");
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        QZoneVideoContactsFeedHelper.h(SessionInfo.this, anonymousClass2.f280129e);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            {
                this.f280129e = activity;
                this.f280130f = videoAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SessionInfo.this, activity, videoAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                a aVar = new a();
                VideoAppInterface videoAppInterface2 = this.f280130f;
                if (videoAppInterface2 != null && videoAppInterface2.getApp() != null) {
                    e.m(this.f280130f, new cw.c().c(this.f280130f.getApp().getString(R.string.f17824365)).d(aVar));
                }
            }
        });
    }

    public static void f(VideoAppInterface videoAppInterface, SessionInfo sessionInfo, Activity activity) {
        a.h().l(videoAppInterface);
        a.h().v(sessionInfo);
        a.h().s(activity);
    }

    public static boolean g(boolean z16) {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QAV_BACK_PRESS_SWITCH, 1);
        if (z16 && config == 1) {
            return true;
        }
        return false;
    }

    public static void h(SessionInfo sessionInfo, Activity activity) {
        if (sessionInfo == null) {
            QLog.e("QZoneVideoContactsFeedHelper", 1, "session info is null");
            return;
        }
        if (aj.c()) {
            QLog.i("QZoneVideoContactsFeedHelper", 1, "already enter home page " + aj.c());
            SimpleEventBus.getInstance().dispatchEvent(new QAVChangeToSmallScreenEvent());
            return;
        }
        try {
            ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(activity, Long.parseLong(sessionInfo.f73091w), false, 28);
        } catch (Exception e16) {
            QLog.e("QZoneVideoContactsFeedHelper", 1, "parse peer uin exception " + e16);
        }
    }

    private static void i(VideoAppInterface videoAppInterface, SessionInfo sessionInfo, Activity activity) {
        if (!a.h().n(sessionInfo)) {
            QLog.e("QZoneVideoContactsFeedHelper", 1, "entrance info is not valid");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable(sessionInfo, activity) { // from class: com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper.1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SessionInfo f280125e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Activity f280126f;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper$1$a */
                /* loaded from: classes16.dex */
                class a implements a.InterfaceC8492a {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.qzonestatus.a.InterfaceC8492a
                    public void a(boolean z16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                            return;
                        }
                        if (z16) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            QZoneVideoContactsFeedHelper.e(VideoAppInterface.this, anonymousClass1.f280125e, anonymousClass1.f280126f);
                            if (!AnonymousClass1.this.f280125e.T2) {
                                ReportController.o(null, "dc00898", "", "", "0X800C4AF", "0X800C4AF", 0, 0, "", "", "", "");
                                AnonymousClass1.this.f280125e.T2 = true;
                            }
                        }
                    }
                }

                {
                    this.f280125e = sessionInfo;
                    this.f280126f = activity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, VideoAppInterface.this, sessionInfo, activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    long j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (VideoAppInterface.this == null) {
                        QLog.e("QZoneVideoContactsFeedHelper", 1, "app interface is null");
                        return;
                    }
                    SessionInfo sessionInfo2 = this.f280125e;
                    if (sessionInfo2 == null) {
                        QLog.e("QZoneVideoContactsFeedHelper", 1, "session info is null");
                        return;
                    }
                    try {
                        j3 = Long.parseLong(sessionInfo2.f73091w);
                    } catch (Exception unused) {
                        RFWLog.e("QZoneVideoContactsFeedHelper", RFWLog.USR, "pare peer uin false");
                        j3 = 0;
                    }
                    Activity activity2 = this.f280126f;
                    if (activity2 != null && !activity2.isFinishing() && !this.f280126f.isDestroyed()) {
                        com.tencent.mobileqq.qzonestatus.a.h().u(new a());
                        com.tencent.mobileqq.qzonestatus.a.h().d(j3);
                    }
                }
            });
        }
    }

    public static void j(boolean z16) {
        a.h().t(z16);
    }
}
