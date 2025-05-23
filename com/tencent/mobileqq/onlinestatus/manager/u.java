package com.tencent.mobileqq.onlinestatus.manager;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.ab;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.aa;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class u implements h {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f255982d;

    /* renamed from: f, reason: collision with root package name */
    private LottieDrawable f255984f;

    /* renamed from: e, reason: collision with root package name */
    private pc2.a f255983e = null;

    /* renamed from: h, reason: collision with root package name */
    private long f255985h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f255986i = -1;

    /* renamed from: m, reason: collision with root package name */
    private Handler f255987m = new a(ThreadManagerV2.getQQCommonThreadLooper());
    private com.tencent.mobileqq.widget.f C = new b();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    u.this.N();
                    return;
                }
                return;
            }
            ((OnlineStatusHandler) u.this.f255982d.getBusinessHandler(OnlineStatusHandler.class.getName())).J2(u.this.L());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements LottieHelper.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f255990a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f255991b;

        c(int i3, View view) {
            this.f255990a = i3;
            this.f255991b = view;
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            if (lottieDrawable == null) {
                return;
            }
            if (u.this.f255984f != null && u.this.f255984f.isRunning()) {
                u.this.f255984f.stop();
                u.this.f255984f.removeAllAnimatorListeners();
            }
            u.this.f255984f = lottieDrawable;
            u.this.f255986i = this.f255990a;
            u.this.f255984f.addAnimatorListener(u.this.C);
            ((ImageView) this.f255991b).setImageDrawable(u.this.f255984f);
            u.this.f255984f.start();
        }
    }

    public u(AppInterface appInterface) {
        this.f255982d = appInterface;
    }

    private boolean H(pc2.a aVar) {
        if (aVar != null && aVar.b() && I(aVar)) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis >= aVar.d() || (this.f255983e != null && currentTimeMillis >= aVar.d())) {
                return false;
            }
            QLog.d("OnlineStatusOlympicManager", 1, "NeedPlayDynamicImage.");
            return true;
        }
        QLog.d("OnlineStatusOlympicManager", 1, "checkIsNeedPlayDynamicImage valid ." + this.f255983e);
        return false;
    }

    private boolean I(pc2.a aVar) {
        if (aVar == null || this.f255983e == null) {
            return true;
        }
        if (aVar.e() >= this.f255983e.e() && aVar.d() >= this.f255983e.d()) {
            return true;
        }
        return false;
    }

    private boolean J() {
        if (Build.VERSION.SDK_INT > 24) {
            return true;
        }
        return false;
    }

    private void M(View view) {
        String str = ab.a() + "/aio/animation/data.json";
        String str2 = ab.a() + "/aio/animation/images/";
        if (FileUtils.fileExistsAndNotEmpty(str) && FileUtils.fileExistsAndNotEmpty(str2)) {
            LottieHelper.c(this.f255982d.getApplicationContext(), str, str2, view.getWidth(), view.getHeight(), new c(this.f255983e.a(), view));
            return;
        }
        QLog.e("OnlineStatusOlympicManager", 1, "loadAndPlayOlympicLottie failed. animJsonPath=" + str + " animImageDirPath=" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ((OnlineStatusHandler) this.f255982d.getBusinessHandler(OnlineStatusHandler.class.getName())).notifyUI(8, true, this.f255983e);
    }

    private void P(View view) {
        if (!J()) {
            QLog.d("OnlineStatusOlympicManager", 1, "version too low not surpport lottie");
            return;
        }
        LottieDrawable lottieDrawable = this.f255984f;
        if (lottieDrawable == null) {
            M(view);
            return;
        }
        if (lottieDrawable.isRunning()) {
            this.f255984f.stop();
        }
        this.f255986i = this.f255983e.a();
        ((ImageView) view).setImageDrawable(this.f255984f);
        this.f255984f.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        LottieDrawable lottieDrawable = this.f255984f;
        if (lottieDrawable != null && lottieDrawable.isRunning()) {
            this.f255984f.stop();
        }
    }

    public void G() {
        LottieDrawable lottieDrawable = this.f255984f;
        if (lottieDrawable != null && lottieDrawable.isRunning()) {
            this.f255984f.cancelAnimation();
        }
    }

    public boolean K(View view) {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int g16 = aa.g(this.f255982d.getApplicationContext());
        pc2.a aVar = this.f255983e;
        if (aVar != null && aVar.d() > currentTimeMillis && g16 != this.f255983e.a() && currentTimeMillis - this.f255985h >= 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            P(view);
        } else {
            Q();
        }
        return z16;
    }

    boolean L() {
        boolean z16;
        String currChatUin = ((IMessageFacade) this.f255982d.getRuntimeService(IMessageFacade.class, "")).getCurrChatUin();
        if (currChatUin != null && !currChatUin.equals(this.f255982d.getCurrentAccountUin())) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("OnlineStatusOlympicManager", 1, "handleMessage getOlympicMedalEvent isAioShown=" + z16 + " currentChatUin=" + currChatUin);
        return z16;
    }

    public void O(Activity activity, String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            QLog.d("OnlineStatusOlympicManager", 1, "openH5 fail");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public void R(pc2.a aVar) {
        pc2.a aVar2;
        QLog.d("OnlineStatusOlympicManager", 1, "updateOlympicMedalEventInfo " + aVar + " curInfo=" + this.f255983e, new Throwable("\u6253\u5370\u5806\u6808"));
        if (aVar != null) {
            int f16 = aVar.f();
            if (f16 > 0) {
                Message obtainMessage = this.f255987m.obtainMessage();
                obtainMessage.what = 0;
                this.f255987m.removeMessages(0);
                this.f255987m.sendMessageDelayed(obtainMessage, f16 * 1000);
                QLog.d("OnlineStatusOlympicManager", 1, "MSG_GET_OLYMPIC_MEDAL_EVENT  " + f16);
            }
            if (this.f255983e != null && aVar.a() == this.f255983e.a()) {
                return;
            }
            boolean H = H(aVar);
            if (!H && (aVar2 = this.f255983e) != null) {
                aVar2.g(aVar);
            } else {
                this.f255983e = aVar;
                if (H) {
                    N();
                    Message obtainMessage2 = this.f255987m.obtainMessage();
                    obtainMessage2.what = 1;
                    this.f255987m.removeMessages(1);
                    this.f255987m.sendMessageDelayed(obtainMessage2, (aVar.d() * 1000) - System.currentTimeMillis());
                }
            }
            af.C().s0(this.f255983e);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        this.f255983e = null;
        this.f255987m.removeMessages(0);
        af.C().s0(null);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            aa.k(u.this.f255982d.getApplicationContext(), u.this.f255986i);
            u.this.Q();
            u.this.f255985h = System.currentTimeMillis() / 1000;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
