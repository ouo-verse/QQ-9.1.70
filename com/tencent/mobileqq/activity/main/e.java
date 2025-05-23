package com.tencent.mobileqq.activity.main;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildABTestApi;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.api.IGuildUnreadEventApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements IQQGuildService.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<SplashActivity> f183432a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f183433b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f183434c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f183435d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f183436e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f183437f;

    /* renamed from: g, reason: collision with root package name */
    private final Function0<Unit> f183438g;

    public e(SplashActivity splashActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) splashActivity);
            return;
        }
        this.f183433b = -1L;
        this.f183434c = -1;
        this.f183435d = false;
        this.f183436e = false;
        this.f183437f = false;
        this.f183438g = new Function0() { // from class: com.tencent.mobileqq.activity.main.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit h16;
                h16 = e.this.h();
                return h16;
            }
        };
        this.f183432a = new WeakReference<>(splashActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f183432a.get() != null && this.f183432a.get().app != null) {
            final IGuildUnreadCntService.b e16 = e(this.f183432a.get().app);
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.activity.main.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.g(e16);
                }
            });
        } else {
            QLog.w("GuildTabRedSubObserver", 1, "getUnreadInfoOnSubThread app is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h() {
        n();
        return null;
    }

    private boolean j(IGuildUnreadCntService.b bVar) {
        if (this.f183434c != bVar.f230841e) {
            return true;
        }
        if (this.f183433b == bVar.f230840d) {
            return false;
        }
        if (this.f183433b <= 99 || bVar.f230840d <= 99) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void g(IGuildUnreadCntService.b bVar) {
        boolean z16;
        if (this.f183432a.get() != null && this.f183432a.get().app != null) {
            QQAppInterface qQAppInterface = this.f183432a.get().app;
            if (!j(bVar)) {
                QLog.i("GuildTabRedSubObserver", 1, "updateGuildTabUI no need update=" + bVar);
                this.f183433b = bVar.f230840d;
                this.f183434c = bVar.f230841e;
                return;
            }
            this.f183433b = bVar.f230840d;
            this.f183434c = bVar.f230841e;
            int i3 = (int) bVar.f230840d;
            if (bVar.f230841e == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 > 0) {
                ((IGuildABTestApi) QRoute.api(IGuildABTestApi.class)).setGuildTabGrayRedPointShowTime(System.currentTimeMillis(), "GuildTabRedSubObserver");
                if (!this.f183437f) {
                    QLog.i("GuildPerformance", 1, "Guild Performance guild tab red dot load");
                    this.f183437f = true;
                }
            }
            m(z16, i3);
            QLog.i("GuildTabRedSubObserver", 1, "updateGuildTabUI showType=" + bVar.f230841e + " unreadCount=" + i3);
            if (qQAppInterface.isLogin()) {
                ((IAppBadgeService) qQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver\u5c0f\u7ad9tab, nUnreadCount[%s]", Integer.valueOf(i3)));
                return;
            }
            return;
        }
        QLog.w("GuildTabRedSubObserver", 1, "updateGuildTabByUnreadInfo app is null!");
    }

    private void m(boolean z16, int i3) {
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        if (z16) {
            redTypeInfo.red_type.set(5);
            p(48, 18, Boolean.FALSE);
            p(48, 16, Integer.valueOf(i3));
        } else {
            boolean z17 = false;
            redTypeInfo.red_type.set(0);
            p(48, 16, 0);
            if (i3 > 0) {
                z17 = true;
            }
            p(48, 18, Boolean.valueOf(z17));
        }
        q(48, redTypeInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void o() {
        if (this.f183432a.get() != null && this.f183432a.get().app != null) {
            if (!GuildInjectImpl.L()) {
                QLog.w("GuildTabRedSubObserver", 1, "updateGuildTabUnreadNumOnUiThread guild tab not ready ignore call this time");
                return;
            } else if (this.f183435d) {
                this.f183436e = true;
                QLog.w("GuildTabRedSubObserver", 1, "updateGuildTabUI dragging");
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.main.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.f();
                    }
                }, 16, null, true);
                return;
            }
        }
        QLog.w("GuildTabRedSubObserver", 1, "updateGuildTabUnreadNum app is null!");
    }

    private void p(int i3, int i16, Object obj) {
        if (this.f183432a.get() == null) {
            QLog.i("GuildTabRedSubObserver", 1, "updateMain\uff1amActivityRef.get() is null");
        } else {
            this.f183432a.get().updateMain(i3, i16, obj);
        }
    }

    private void q(int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (this.f183432a.get() == null) {
            QLog.i("GuildTabRedSubObserver", 1, "updateTabRedTouch\uff1amActivityRef.get() is null");
        } else {
            this.f183432a.get().updateTabRedTouch(i3, redTypeInfo);
        }
    }

    public IGuildUnreadCntService.b e(QQAppInterface qQAppInterface) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IGuildUnreadCntService.b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface);
        }
        UnreadInfo.a guildTabUnreadCountSafely = ((IGuildDelayInitializeService) qQAppInterface.getRuntimeService(IGuildDelayInitializeService.class, "")).getGuildTabUnreadCountSafely();
        long count = guildTabUnreadCountSafely.getCount();
        if (guildTabUnreadCountSafely.getIsStrongUnread()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        return new IGuildUnreadCntService.b(count, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService.b
    public void endDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("GuildTabRedSubObserver", 1, "endDrag: mDragging=" + this.f183435d + ",mHasWaitUpdateEvent=" + this.f183436e);
        if (!this.f183435d) {
            return;
        }
        this.f183435d = false;
        this.f183433b = -1L;
        this.f183434c = -1;
        if (this.f183436e) {
            this.f183436e = false;
            n();
        }
    }

    public void i() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.f183432a.get() == null || (qQAppInterface = this.f183432a.get().app) == null) {
                return;
            }
            ((IGuildUnreadEventApi) QRoute.api(IGuildUnreadEventApi.class)).addEventListener(this.f183438g);
            ((IQQGuildService) qQAppInterface.getRuntimeService(IQQGuildService.class, "")).addRedDragListener(this);
            QLog.i("GuildTabRedSubObserver", 1, "registerObserversAndListensers");
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ((IGuildUnreadEventApi) QRoute.api(IGuildUnreadEventApi.class)).removeEventListener(this.f183438g);
        if (this.f183432a.get() != null) {
            ((IQQGuildService) this.f183432a.get().app.getRuntimeService(IQQGuildService.class, "")).removeRedDragListener(this);
        }
        QLog.i("GuildTabRedSubObserver", 1, "ungisterObserversAndListensers");
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.activity.main.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.o();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildService.b
    public void startDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.i("GuildTabRedSubObserver", 1, "startDrag");
            this.f183435d = true;
        }
    }
}
