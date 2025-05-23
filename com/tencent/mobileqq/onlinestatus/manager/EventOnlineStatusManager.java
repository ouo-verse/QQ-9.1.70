package com.tencent.mobileqq.onlinestatus.manager;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.aa;
import com.tencent.mobileqq.onlinestatus.utils.ak;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class EventOnlineStatusManager implements d {
    public static final String[] C = {"aio/animation/data.json", "aio/animation/images/"};

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f255925d;

    /* renamed from: e, reason: collision with root package name */
    private ak f255926e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f255927f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f255928h;

    /* renamed from: i, reason: collision with root package name */
    protected ApngDrawable.OnPlayRepeatListener f255929i;

    /* renamed from: m, reason: collision with root package name */
    protected LottieDrawable f255930m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements LottieHelper.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ au f255939a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f255940b;

        b(au auVar, ViewGroup viewGroup) {
            this.f255939a = auVar;
            this.f255940b = viewGroup;
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            if (lottieDrawable == null) {
                EventOnlineStatusManager.this.O();
            } else {
                EventOnlineStatusManager.this.P(lottieDrawable, this.f255939a, this.f255940b);
            }
        }
    }

    public EventOnlineStatusManager(AppInterface appInterface) {
        this.f255925d = appInterface;
    }

    protected String A(au auVar, String str) {
        return str + "_" + this.f255925d.getCurrentAccountUin() + "_" + auVar.f255489b;
    }

    protected ak B() {
        if (this.f255926e == null) {
            this.f255926e = new ak();
        }
        return this.f255926e;
    }

    protected void C(@NonNull com.tencent.mobileqq.onlinestatus.model.c cVar, @NonNull Activity activity) {
        if (TextUtils.isEmpty(cVar.f256007d)) {
            QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "gotoEventDetailPage url is empty");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", cVar.f256007d);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    protected void D(au auVar, Activity activity, boolean z16) {
        com.tencent.mobileqq.onlinestatus.model.c cVar = auVar.A;
        if (TextUtils.isEmpty(cVar.f256005b)) {
            QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "gotoEventSharePage url is empty");
            return;
        }
        String addParameter = URLUtil.addParameter(cVar.f256005b, "id", String.valueOf(auVar.f255489b));
        if (z16 && !TextUtils.isEmpty(cVar.f256006c)) {
            addParameter = URLUtil.addParameter(addParameter, "qrcode", cVar.f256006c);
        }
        Intent intent = new Intent();
        intent.putExtra("url", addParameter);
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_HIDE_FLOAT_BAR, true);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER);
    }

    protected boolean E(au auVar) {
        return aa.c(this.f255925d.getApplicationContext()).getBoolean(A(auVar, "event_status_has_egg_played"), false);
    }

    protected boolean F(au auVar) {
        return aa.c(this.f255925d.getApplicationContext()).getBoolean(A(auVar, "event_status_has_set"), false);
    }

    public boolean G(com.tencent.mobileqq.onlinestatus.model.c cVar) {
        if (!TextUtils.isEmpty(cVar.f256010g) && !TextUtils.isEmpty(cVar.f256011h)) {
            return ak.k(cVar.f256010g, cVar.f256011h, C);
        }
        return false;
    }

    public boolean H(au auVar) {
        if (auVar != null && auVar.A != null) {
            return true;
        }
        return false;
    }

    protected boolean I() {
        if (!this.f255928h && this.f255927f != null) {
            return false;
        }
        return true;
    }

    protected void J(au auVar, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(auVar.A.f256009f)) {
            QLog.e("OnlineStatus.EventOnlineStatusManager", 1, "loadApngDrawable apngUrl is empty");
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setLoadListener(new a(auVar, viewGroup));
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("OnlineStatus.EventOnlineStatusManager", auVar.A.f256009f, apngOptions);
        if (apngURLDrawable == null) {
            O();
            return;
        }
        this.f255927f.setImageDrawable(apngURLDrawable);
        this.f255927f.setVisibility(0);
        viewGroup.addView(this.f255927f);
    }

    public void K(au auVar, int i3, int i16, ViewGroup viewGroup) {
        if (!H(auVar)) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.model.c cVar = auVar.A;
        QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "getEventStatusEggDrawable type=" + cVar.f256008e);
        int i17 = cVar.f256008e;
        if (i17 != 1) {
            if (i17 == 2) {
                L(auVar, i3, i16, viewGroup);
                return;
            }
            return;
        }
        J(auVar, viewGroup);
    }

    protected void L(au auVar, int i3, int i16, ViewGroup viewGroup) {
        if (!y()) {
            QLog.d("OnlineStatus.EventOnlineStatusManager", 1, "loadLottieDrawable version not support");
            return;
        }
        com.tencent.mobileqq.onlinestatus.model.c cVar = auVar.A;
        if (!G(cVar)) {
            QLog.d("OnlineStatus.EventOnlineStatusManager", 1, "loadLottieDrawable res not ready");
            z(cVar.f256010g, cVar.f256011h);
            return;
        }
        String i17 = ak.i(cVar.f256010g, cVar.f256011h);
        LottieHelper.c(this.f255925d.getApplicationContext(), i17 + "/aio/animation/data.json", i17 + "/aio/animation/images/", i3, i16, new b(auVar, viewGroup));
    }

    protected void M(Drawable drawable, final au auVar, ViewGroup viewGroup) {
        QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "onApngDrawableLoaded");
        if (!I() && drawable != null) {
            if (!(drawable instanceof URLDrawable)) {
                QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "onApngDrawableLoaded not URLDrawable");
                return;
            }
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (!(uRLDrawable.getCurrDrawable() instanceof ApngDrawable)) {
                QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "onApngDrawableLoaded not ApngDrawable");
                return;
            }
            ApngDrawable apngDrawable = (ApngDrawable) uRLDrawable.getCurrDrawable();
            ApngDrawable.OnPlayRepeatListener onPlayRepeatListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.onlinestatus.manager.EventOnlineStatusManager.2
                @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
                public void onPlayRepeat(int i3) {
                    EventOnlineStatusManager.this.f255925d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.EventOnlineStatusManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "onPlayRepeat ");
                            if (EventOnlineStatusManager.this.I()) {
                                return;
                            }
                            EventOnlineStatusManager.this.f255927f.setVisibility(8);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            EventOnlineStatusManager.this.N(auVar);
                        }
                    });
                }
            };
            this.f255929i = onPlayRepeatListener;
            apngDrawable.setOnPlayRepeatListener(onPlayRepeatListener);
            return;
        }
        QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "onApngDrawableLoaded EggAnimIvEnd");
    }

    protected void N(au auVar) {
        R(auVar);
        Q();
    }

    protected void O() {
        QLog.e("OnlineStatus.EventOnlineStatusManager", 1, "onLoadFailed");
        if (I()) {
            return;
        }
        this.f255927f.setVisibility(8);
        Q();
    }

    protected void P(Drawable drawable, au auVar, ViewGroup viewGroup) {
        if (I() || drawable == null || !(drawable instanceof LottieDrawable)) {
            return;
        }
        LottieDrawable lottieDrawable = (LottieDrawable) drawable;
        this.f255930m = lottieDrawable;
        lottieDrawable.setRepeatCount(0);
        lottieDrawable.addAnimatorListener(new c(lottieDrawable, auVar));
        this.f255927f.setImageDrawable(lottieDrawable);
        this.f255927f.setVisibility(0);
        viewGroup.addView(this.f255927f);
        lottieDrawable.start();
    }

    protected void Q() {
        this.f255928h = true;
        LottieDrawable lottieDrawable = this.f255930m;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
            this.f255930m = null;
        }
        ImageView imageView = this.f255927f;
        if (imageView != null) {
            if (imageView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f255927f.getParent()).removeView(this.f255927f);
            }
            this.f255927f = null;
        }
        this.f255929i = null;
    }

    protected void R(au auVar) {
        aa.c(this.f255925d.getApplicationContext()).edit().putBoolean(A(auVar, "event_status_has_egg_played"), true).apply();
    }

    protected void S(au auVar) {
        aa.c(this.f255925d.getApplicationContext()).edit().putBoolean(A(auVar, "event_status_has_set"), true).apply();
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public void c(ArrayList<au> arrayList) {
        Iterator<au> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.onlinestatus.model.c cVar = it.next().A;
            if (cVar != null && cVar.f256008e == 2) {
                z(cVar.f256010g, cVar.f256011h);
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public boolean g(au auVar) {
        if (!H(auVar) || auVar.A.f256008e == 0) {
            return false;
        }
        return !E(auVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public boolean i(au auVar) {
        if (H(auVar) && !TextUtils.isEmpty(auVar.A.f256007d)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public void l() {
        Q();
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public void m(au auVar, Activity activity, ViewGroup viewGroup, int i3, int i16) {
        if (this.f255927f != null) {
            QLog.e("OnlineStatus.EventOnlineStatusManager", 1, "handleEventStatusEgg mEggAnimIV is exist");
            return;
        }
        this.f255928h = false;
        this.f255927f = new ImageView(activity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.topMargin = i16;
        layoutParams.addRule(14);
        this.f255927f.setLayoutParams(layoutParams);
        K(auVar, i3, i3, viewGroup);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        ak akVar = this.f255926e;
        if (akVar != null) {
            akVar.m();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public boolean r(au auVar, Activity activity) {
        boolean z16 = false;
        if (!H(auVar)) {
            return false;
        }
        QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "handleSwitchSuccess id=" + auVar.f255489b + ", type=" + auVar.A.f256004a);
        com.tencent.mobileqq.onlinestatus.model.c cVar = auVar.A;
        if (cVar.f256004a == 0) {
            QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "handleSwitchSuccess show none");
            return true;
        }
        if (F(auVar)) {
            QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "handleSwitchSuccess not first set");
            return true;
        }
        S(auVar);
        int i3 = cVar.f256004a;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "handleSwitchSuccess unknown shareDialogType");
            } else {
                if (i3 == 3) {
                    z16 = true;
                }
                D(auVar, activity, z16);
            }
        } else {
            C(cVar, activity);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.d
    public boolean w(au auVar, Activity activity) {
        if (!H(auVar)) {
            return false;
        }
        QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "handleMyStatusClick " + auVar.f255489b);
        C(auVar.A, activity);
        return true;
    }

    protected boolean y() {
        if (Build.VERSION.SDK_INT > 24) {
            return true;
        }
        return false;
    }

    protected void z(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (ak.k(str, str2, C)) {
                QLog.d("OnlineStatus.EventOnlineStatusManager", 1, "downloadEggRes res is ready");
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.EventOnlineStatusManager.5
                    @Override // java.lang.Runnable
                    public void run() {
                        String str3 = str;
                        String str4 = str2;
                        String[] strArr = EventOnlineStatusManager.C;
                        if (ak.k(str3, str4, strArr)) {
                            QLog.d("OnlineStatus.EventOnlineStatusManager", 1, "downloadEggRes res is ready");
                        } else {
                            QLog.d("OnlineStatus.EventOnlineStatusManager", 1, "downloadEggRes res downloading...");
                            EventOnlineStatusManager.this.B().d(EventOnlineStatusManager.this.f255925d, 10096, PreDownloadConstants.DEPARTMENT_PRD, str, str2, strArr, null);
                        }
                    }
                }, 16, null, false);
                return;
            }
        }
        QLog.d("OnlineStatus.EventOnlineStatusManager", 1, "downloadEggRes resUrl or md5 is empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieDrawable f255942d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ au f255943e;

        c(LottieDrawable lottieDrawable, au auVar) {
            this.f255942d = lottieDrawable;
            this.f255943e = auVar;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.e("OnlineStatus.EventOnlineStatusManager", 1, "onAnimationEnd");
            if (EventOnlineStatusManager.this.I()) {
                return;
            }
            if (this.f255942d.isRunning()) {
                this.f255942d.stop();
            }
            EventOnlineStatusManager.this.f255927f.setVisibility(8);
            EventOnlineStatusManager.this.N(this.f255943e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ au f255936d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f255937e;

        a(au auVar, ViewGroup viewGroup) {
            this.f255936d = auVar;
            this.f255937e = viewGroup;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            EventOnlineStatusManager.this.O();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            EventOnlineStatusManager.this.O();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("OnlineStatus.EventOnlineStatusManager", 1, "success");
            EventOnlineStatusManager.this.M(uRLDrawable, this.f255936d, this.f255937e);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
