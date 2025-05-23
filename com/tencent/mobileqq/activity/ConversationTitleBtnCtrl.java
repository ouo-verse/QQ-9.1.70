package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory;
import com.tencent.mobileqq.zplan.aio.IZPlanBadgeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import qqcircle.QQCircleCounter$RedPointInfo;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ConversationTitleBtnCtrl implements QzoneConfig.QzoneConfigChangeListener {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;
    private final com.tencent.mobileqq.util.conversationtitlebutton.c E;

    /* renamed from: d, reason: collision with root package name */
    private final IZPlanBadgeManager f175489d;

    /* renamed from: e, reason: collision with root package name */
    private final Conversation f175490e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.mobileqq.util.conversationtitlebutton.d f175491f;

    /* renamed from: h, reason: collision with root package name */
    private int f175492h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f175493i;

    /* renamed from: m, reason: collision with root package name */
    private final QQCircleCounter$RedPointInfo f175494m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class UpdateEntranceUIRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ConversationTitleBtnCtrl> f175495d;

        UpdateEntranceUIRunnable(ConversationTitleBtnCtrl conversationTitleBtnCtrl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversationTitleBtnCtrl);
            } else {
                this.f175495d = new WeakReference<>(conversationTitleBtnCtrl);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ConversationTitleBtnCtrl conversationTitleBtnCtrl = this.f175495d.get();
            if (conversationTitleBtnCtrl != null) {
                conversationTitleBtnCtrl.x(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements com.tencent.mobileqq.util.conversationtitlebutton.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationTitleBtnCtrl.this);
            }
        }

        private SplashActivity d() {
            WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.util.conversationtitlebutton.c
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return ConversationTitleBtnCtrl.this.C;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }

        @Override // com.tencent.mobileqq.util.conversationtitlebutton.c
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            SplashActivity d16 = d();
            if (d16 != null) {
                return com.tencent.mobileqq.onlinestatus.utils.a.b(d16);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.util.conversationtitlebutton.c
        public boolean c() {
            FrameHelperActivity ji5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            SplashActivity d16 = d();
            if (d16 != null && (ji5 = FrameHelperActivity.ji(d16)) != null) {
                return ji5.R;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.util.conversationtitlebutton.c
        @NonNull
        public View getContainerView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return ConversationTitleBtnCtrl.this.f175490e.getContentView();
        }

        @Override // com.tencent.mobileqq.util.conversationtitlebutton.c
        @NonNull
        public Context getContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ConversationTitleBtnCtrl.this.f175490e.getContentView().getContext();
        }
    }

    public ConversationTitleBtnCtrl(Conversation conversation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
            return;
        }
        this.f175492h = 0;
        this.f175494m = new QQCircleCounter$RedPointInfo();
        this.C = true;
        this.D = false;
        a aVar = new a();
        this.E = aVar;
        this.f175490e = conversation;
        QBaseActivity activity = conversation.getActivity();
        this.f175493i = new Handler(Looper.getMainLooper());
        com.tencent.mobileqq.util.conversationtitlebutton.d createConversationTitleBtn = ((IConversationTitleBtnFactory) QRoute.api(IConversationTitleBtnFactory.class)).createConversationTitleBtn(aVar);
        this.f175491f = createConversationTitleBtn;
        if (createConversationTitleBtn.e()) {
            this.f175489d = null;
            return;
        }
        IZPlanBadgeManager iZPlanBadgeManager = (IZPlanBadgeManager) QRoute.api(IZPlanBadgeManager.class);
        this.f175489d = iZPlanBadgeManager;
        iZPlanBadgeManager.init(activity, this);
    }

    public static void c(View view, int i3) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i3;
            layoutParams.width = i3;
            view.setPadding(0, 0, 0, 0);
            view.setLayoutParams(layoutParams);
        }
    }

    private void e() {
        QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.hideEntrance();
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && !dVar.e()) {
            this.f175491f.resetVisibility();
        }
    }

    private void s() {
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.resetVisibility();
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && !dVar.e()) {
            this.f175491f.resetVisibility();
        }
    }

    private void t() {
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if ((dVar == null || !dVar.e()) && this.f175492h != 0) {
            this.f175492h = 0;
        }
    }

    private void y() {
        IZPlanBadgeManager iZPlanBadgeManager;
        s();
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if ((dVar == null || !dVar.e()) && (iZPlanBadgeManager = this.f175489d) != null && this.f175492h == 3) {
            iZPlanBadgeManager.updateVisibility();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            w();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            this.f175491f.f();
            this.f175491f.i();
            return;
        }
        QzoneConfig.getInstance().addListener(this);
        this.f175489d.onCreateView(this.f175490e.getContentView(), false);
        this.f175490e.fitElderMode();
        if (this.C != this.f175490e.isForeground()) {
            this.C = this.f175490e.isForeground();
        }
    }

    public void g(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        if (this.D) {
            return;
        }
        this.D = true;
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            this.f175491f.f();
            this.f175491f.g(view);
        } else {
            QzoneConfig.getInstance().addListener(this);
            this.f175489d.onCreateView(view, true);
            this.f175490e.fitElderMode();
        }
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.C;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            this.f175491f.onAccountChanged();
            return;
        }
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.onAccountChanged();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.d("ConversationTitleBtnCtrl", 1, "onAfterSyncMsg " + this.f175492h);
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            this.f175491f.onBeforeAccountChanged();
            return;
        }
        t();
        e();
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.onBeforeAccountChanged();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.qcircle.utils.c.g().releaseWhenExitQCircle();
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.onDestroy();
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            this.f175491f.a();
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConversationTitleBtnCtrl", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.C = false;
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.onPause();
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.onPostThemeChanged();
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null) {
            dVar.onPostThemeChanged();
        }
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f175493i.post(new Runnable() { // from class: com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConversationTitleBtnCtrl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ConversationTitleBtnCtrl.this.x(false);
                    }
                }
            });
        }
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConversationTitleBtnCtrl", 1, "onResume");
        }
        this.C = true;
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.onResume();
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null) {
            dVar.onResume(z16);
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            this.f175491f.h(false);
        }
    }

    public void r() {
        IZPlanBadgeManager iZPlanBadgeManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if ((dVar == null || !dVar.e()) && this.f175492h == 3 && (iZPlanBadgeManager = this.f175489d) != null) {
            iZPlanBadgeManager.refreshRedTouch();
        }
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.setTitleEntranceImageAlpha(i3);
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null) {
            dVar.b(i3);
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null) {
            iZPlanBadgeManager.setTitleEntranceImageColorFilter(i3);
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null) {
            dVar.d(i3);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            return;
        }
        t();
        this.f175493i.post(new UpdateEntranceUIRunnable(this));
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.util.conversationtitlebutton.d dVar = this.f175491f;
        if (dVar != null && dVar.e()) {
            return;
        }
        QLog.d("ConversationTitleBtnCtrl", 1, "updateQQCircle " + z16);
        IZPlanBadgeManager iZPlanBadgeManager = this.f175489d;
        if (iZPlanBadgeManager != null && iZPlanBadgeManager.getIsEntranceShow()) {
            this.f175492h = 3;
            y();
        } else {
            this.f175492h = 0;
            s();
        }
    }
}
