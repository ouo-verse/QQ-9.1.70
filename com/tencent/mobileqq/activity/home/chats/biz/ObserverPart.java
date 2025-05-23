package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.bm;
import com.tencent.mobileqq.activity.home.chats.avatar.AvatarRefreshHelper;
import com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.cq;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.utils.bh;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.af;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForNum;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class ObserverPart extends com.tencent.mobileqq.activity.home.chats.biz.d {
    static IPatchRedirector $redirector_;
    private Runnable C;
    private WeakReference<ObserverPart> D;
    private final BusinessObserver E;
    private final BusinessObserver F;
    private final BroadcastReceiver G;
    private final AVObserverStatic H;
    private final com.tencent.mobileqq.simpleui.f I;
    private ExpandObserver J;
    private StudyModeChangeListener K;
    private AccountObserver L;
    private av M;
    private final com.tencent.mobileqq.avatar.observer.a N;
    private cq P;
    private final bs Q;

    /* loaded from: classes10.dex */
    static class AVObserverStatic extends AVObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<com.tencent.mobileqq.activity.home.chats.callbcak.a> f182890d;

        AVObserverStatic() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f182890d = new WeakReference<>(null);
            }
        }

        private QQAppInterface a() {
            if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
                return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            }
            return null;
        }

        protected void b(long j3, AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), appRuntime);
                return;
            }
            bh bhVar = (bh) appRuntime.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
            if (bhVar != null) {
                bhVar.c(j3);
            }
        }

        public void c(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                this.f182890d = new WeakReference<>(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onAudioChatting(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.AVObserverStatic.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVObserverStatic.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BannerManager l3 = BannerManager.l();
                        if (l3 != null) {
                            l3.D(MultiVideoBannerProcessor.f185233d, 2000);
                            l3.A(-1, null);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMemberInfo(int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            QQAppInterface a16 = a();
            if (a16 == null) {
                return;
            }
            b(j3, a16);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(a16, j3) { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.AVObserverStatic.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f182891d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f182892e;

                {
                    this.f182891d = a16;
                    this.f182892e = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AVObserverStatic.this, a16, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BannerManager l3 = BannerManager.l();
                    if (l3 != null) {
                        int i16 = MultiVideoBannerProcessor.f185233d;
                        l3.D(i16, 2000);
                        if (this.f182891d.getAVNotifyCenter().l(this.f182892e) == 2) {
                            Message message = new Message();
                            message.obj = Long.valueOf(this.f182892e);
                            l3.A(i16, message);
                        }
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMemberJoin(int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            QQAppInterface a16 = a();
            if (a16 != null && j16 == Long.valueOf(a().getCurrentAccountUin()).longValue()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(a16, j3) { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.AVObserverStatic.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f182893d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f182894e;

                    {
                        this.f182893d = a16;
                        this.f182894e = j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AVObserverStatic.this, a16, Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BannerManager l3 = BannerManager.l();
                        if (l3 != null) {
                            int i16 = MultiVideoBannerProcessor.f185233d;
                            l3.D(i16, 2000);
                            if (this.f182893d.getAVNotifyCenter().l(this.f182894e) == 2) {
                                Message message = new Message();
                                message.obj = Long.valueOf(this.f182894e);
                                l3.A(i16, message);
                                return;
                            }
                            l3.A(-1, null);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMemberQuit(int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            QQAppInterface a16 = a();
            if (a16 != null && j16 == Long.valueOf(a().getCurrentAccountUin()).longValue()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(a16, j3) { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.AVObserverStatic.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f182895d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f182896e;

                    {
                        this.f182895d = a16;
                        this.f182896e = j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AVObserverStatic.this, a16, Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BannerManager l3 = BannerManager.l();
                        if (l3 != null) {
                            int i16 = MultiVideoBannerProcessor.f185233d;
                            l3.D(i16, 2000);
                            if (this.f182895d.getAVNotifyCenter().l(this.f182896e) == 2) {
                                Message message = new Message();
                                message.obj = Long.valueOf(this.f182896e);
                                l3.A(i16, message);
                                return;
                            }
                            l3.A(-1, null);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onSmallScreenStateChange(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else {
                super.onSmallScreenStateChange(str);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.AVObserverStatic.6
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVObserverStatic.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BannerManager l3 = BannerManager.l();
                        if (l3 != null) {
                            l3.D(MultiVideoBannerProcessor.f185233d, 2000);
                            l3.A(-1, null);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onUpdateTime(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
                return;
            }
            super.onUpdateTime(str, str2);
            if (this.f182890d.get() != null && this.f182890d.get().h()) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.AVObserverStatic.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVObserverStatic.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BannerManager l3 = BannerManager.l();
                    if (l3 != null) {
                        l3.D(MultiVideoBannerProcessor.f185233d, 2000);
                        l3.A(-1, null);
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            ObserverPart observerPart = (ObserverPart) ObserverPart.this.D.get();
            if (observerPart != null) {
                observerPart.va(intent);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.simpleui.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void d(boolean z16, boolean z17, int i3, boolean z18, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Boolean.valueOf(z18), str, Long.valueOf(j3));
                return;
            }
            if (z16 && z17 && z18) {
                AppRuntime X9 = ObserverPart.this.X9();
                if (!(X9 instanceof QQAppInterface)) {
                    return;
                }
                ServiceAccountFolderManager.d().y("pa_WhiteList_in_ConciseMode_867012523", (QQAppInterface) X9);
            }
        }
    }

    /* loaded from: classes10.dex */
    class c extends ExpandObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void A(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            bm aa5 = ObserverPart.this.aa();
            if (aa5 != null) {
                aa5.r();
            }
        }
    }

    /* loaded from: classes10.dex */
    class d implements StudyModeChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            bm aa5 = ObserverPart.this.aa();
            AppRuntime X9 = ObserverPart.this.X9();
            if (!(X9 instanceof QQAppInterface)) {
                return;
            }
            ServiceAccountFolderManager.d().y("pa_WhiteList_in_studyMode_860178803", (QQAppInterface) X9);
            if (aa5 != null) {
                aa5.r();
            }
            ObserverPart.this.ua(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements IOperateCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                QLog.d("ObserverPart", 1, "setIsTroopAssistEnable, result: ", Integer.valueOf(i3), " errMsg: ", str);
            }
        }
    }

    /* loaded from: classes10.dex */
    class f extends AccountObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // mqq.observer.AccountObserver
        protected void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, boolean z18, long j16, boolean z19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), status, Long.valueOf(j3), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j16), Boolean.valueOf(z19));
                return;
            }
            FrameHelperActivity ba5 = ObserverPart.this.ba();
            if (ba5 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ObserverPart", 2, String.format("onOnlineStatusChanged, currentStatus = %s", status));
                }
                ba5.rj("AccountObserver.onOnlineStatusChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusPush(AppRuntime.Status status, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, status, Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ObserverPart", 2, String.format("onOnlineStatusPush, currentStatus = %s , extOnlineStatus = %d", status, Long.valueOf(j3)));
            }
            FrameHelperActivity ba5 = ObserverPart.this.ba();
            if (ba5 == null) {
                return;
            }
            ba5.rj("AccountObserver.onOnlineStatusPush");
        }
    }

    /* loaded from: classes10.dex */
    class g extends av {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            FrameHelperActivity ba5 = ObserverPart.this.ba();
            if (ba5 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ObserverPart", 2, "onSetOnlineStatus, isSuccess", Boolean.valueOf(z16));
                }
                ba5.rj("OnlineStatusObserver.onSetOnlineStatus");
                ba5.oi();
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void j(boolean z16, pc2.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
                return;
            }
            FrameHelperActivity ba5 = ObserverPart.this.ba();
            if (ba5 == null) {
                return;
            }
            AppRuntime X9 = ObserverPart.this.X9();
            if ((X9 instanceof QQAppInterface) && ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(X9) == 1080) {
                ba5.mUiHandler.sendEmptyMessage(19);
            }
        }
    }

    /* loaded from: classes10.dex */
    class h extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            FrameHelperActivity ba5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ObserverPart", 2, " Conversation.onUpdateCustomHead: uin:" + str + ", success :" + z16);
            }
            if (!z16 || (ba5 = ObserverPart.this.ba()) == null) {
                return;
            }
            if (Utils.p(str, ObserverPart.this.X9().getCurrentAccountUin())) {
                ba5.mUiHandler.sendEmptyMessage(3);
            } else {
                AvatarRefreshHelper.f182873a.c(str);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                AvatarRefreshHelper.f182873a.c(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    class i extends cq {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cq
        protected void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (AppSetting.p(BaseApplication.getContext())) {
                return;
            }
            QLog.i("ObserverPart", 1, "onRegPrxyUpdateLoginDevStatus int iState = " + i3);
            BannerManager Y9 = ObserverPart.this.Y9();
            if (Y9 == null) {
                return;
            }
            if (i3 == 1) {
                Y9.O(LoginDevicesBannerProcessor.f185224h, 2, null);
            } else {
                Y9.D(LoginDevicesBannerProcessor.f185224h, 2000);
            }
        }
    }

    public ObserverPart(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.D = new WeakReference<>(this);
        this.E = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferErrObserver();
        this.F = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferProgressObserver();
        this.G = new a();
        AVObserverStatic aVObserverStatic = new AVObserverStatic();
        this.H = aVObserverStatic;
        this.I = new b();
        this.J = new c();
        this.K = new d();
        this.L = new f();
        this.M = new g();
        this.N = new h();
        this.P = new i();
        this.Q = new bs() { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ObserverPart.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bs
            protected void onPushUpdateLoginDevStatusNotify(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                } else {
                    ObserverPart.this.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.home.chats.biz.ObserverPart.10.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f182888d;

                        {
                            this.f182888d = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (AppSetting.p(BaseApplication.getContext())) {
                                return;
                            }
                            QLog.i("ObserverPart", 1, "onPushUpdateLoginDevStatusNotify int iState = " + this.f182888d);
                            BannerManager Y9 = ObserverPart.this.Y9();
                            if (Y9 == null) {
                                return;
                            }
                            if (this.f182888d == 1) {
                                Y9.O(LoginDevicesBannerProcessor.f185224h, 2, null);
                            } else {
                                Y9.D(LoginDevicesBannerProcessor.f185224h, 2000);
                            }
                        }
                    });
                }
            }
        };
        aVObserverStatic.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void sa() {
        com.tencent.qqnt.lightbusinesskit.a.f();
        LIAConfigManager.INSTANCE.a().d();
        com.tencent.qqnt.lightbusinesskit.c.b();
    }

    private void ta() {
        ua(StudyModeManager.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(boolean z16) {
        QLog.d("ObserverPart", 2, "notifyNtStudyMode is StudyMode:" + z16);
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        IKernelSettingService settingService = ((IKernelService) X9.getRuntimeService(IKernelService.class, "")).getSettingService();
        if (settingService == null) {
            QLog.d("ObserverPart", 1, "notifyNtStudyMode but settingService is null");
            return;
        }
        HashMap<SettingKeyForNum, Integer> hashMap = new HashMap<>();
        hashMap.put(SettingKeyForNum.KTEENAGERMODE, Integer.valueOf(z16 ? 1 : 0));
        settingService.setSettingForNum(hashMap, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(Intent intent) {
        BannerManager Y9;
        if (AppSetting.p(BaseApplication.getContext()) || (Y9 = Y9()) == null) {
            return;
        }
        if ("login".equals(intent.getStringExtra("status"))) {
            Message obtain = Message.obtain();
            obtain.what = 2002;
            obtain.getData().putString("pcLoginInfo", intent.getStringExtra("loginInfo"));
            int i3 = LoginDevicesBannerProcessor.f185224h;
            Y9.G(i3, obtain);
            Message obtain2 = Message.obtain();
            obtain2.what = 2003;
            obtain2.getData().putString("pcLoginInfo", intent.getStringExtra("loginInfo"));
            int i16 = PCOnlineBannerProcessor.D;
            Y9.G(i16, obtain2);
            Message obtain3 = Message.obtain();
            obtain3.what = 2001;
            obtain3.getData().putLong("loginDevAppid", intent.getLongExtra("subappid", 1L));
            Y9.G(i3, obtain3);
            Message obtain4 = Message.obtain();
            obtain4.what = 2002;
            obtain4.getData().putLong("loginAppType", intent.getLongExtra("subappid", 1L));
            Y9.G(i16, obtain4);
            Y9.O(i3, 2, null);
            return;
        }
        Y9.D(LoginDevicesBannerProcessor.f185224h, 2000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wa, reason: merged with bridge method [inline-methods] */
    public void ra() {
        try {
            if (AppSetting.p(BaseApplication.getContext())) {
                return;
            }
            BannerManager Y9 = Y9();
            if (Y9 == null) {
                QLog.i("ObserverPart", 1, "[tryRefreshLoginDevicesBanner] bannerManager is null.");
                return;
            }
            int i3 = LoginDevicesBannerProcessor.f185224h;
            if (Y9.o(i3)) {
                QLog.i("ObserverPart", 1, "[tryRefreshLoginDevicesBanner] Banner is showing.");
                return;
            }
            if (X9() == null) {
                QLog.i("ObserverPart", 1, "[tryRefreshLoginDevicesBanner] appRuntime is null.");
            } else {
                if (TextUtils.isEmpty(((rd0.g) X9().getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).h())) {
                    return;
                }
                QLog.i("ObserverPart", 1, "[tryRefreshLoginDevicesBanner] real update.");
                Y9.O(i3, 2, null);
            }
        } catch (Exception e16) {
            QLog.e("ObserverPart", 1, "[tryRefreshLoginDevicesBanner] error.", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.qqnt.chats.biz.main.part.a
    public void A9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        super.A9(appRuntime);
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        qQAppInterface.addObserver(this.Q);
        if (!af.i()) {
            qQAppInterface.registObserver(this.L);
            qQAppInterface.addObserver(this.M);
        }
        qQAppInterface.addObserver(this.J);
        qQAppInterface.addObserver(this.I);
        qQAppInterface.addObserver(this.P);
        StudyModeManager.H(this.K);
        if (appRuntime.isLogin()) {
            if (!af.i()) {
                qQAppInterface.addObserver(this.N, true);
            }
            if (qQAppInterface.getAVNotifyCenter() != null) {
                qQAppInterface.getAVNotifyCenter().addObserver(this.H);
            }
        }
        qQAppInterface.addObserver(this.E);
        qQAppInterface.addObserver(this.F);
        ta();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void Q9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.Q9();
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.j
            @Override // java.lang.Runnable
            public final void run() {
                ObserverPart.this.ra();
            }
        });
        this.C = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.k
            @Override // java.lang.Runnable
            public final void run() {
                ObserverPart.sa();
            }
        }, 16, null, true, 5000L);
        ForegroundNotifyManager.y();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.qqnt.chats.biz.main.part.a
    public void R9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        qQAppInterface.removeObserver(this.Q);
        if (!af.i()) {
            qQAppInterface.removeObserver(this.N);
            qQAppInterface.unRegistObserver(this.L);
            qQAppInterface.removeObserver(this.M);
        }
        qQAppInterface.removeObserver(this.J);
        qQAppInterface.removeObserver(this.I);
        qQAppInterface.removeObserver(this.P);
        StudyModeManager.U(this.K);
        if (qQAppInterface.getAVNotifyCenter() != null) {
            qQAppInterface.getAVNotifyCenter().deleteObserver(this.H);
        }
        qQAppInterface.removeObserver(this.E);
        qQAppInterface.removeObserver(this.F);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ObserverPart";
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        Runnable runnable = this.C;
        this.C = null;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
        }
    }
}
