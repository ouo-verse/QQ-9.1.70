package com.tencent.mobileqq.hotpic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.hotpic.NTHotPicPageView;
import com.tencent.mobileqq.hotpic.NTHotPicRecyclerView;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.hotpic.p;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;

/* loaded from: classes9.dex */
public class NTHotPicMainPanel extends RelativeLayout implements f, Handler.Callback, com.tencent.qqnt.aio.shortcutbar.g, NTHotPicRecyclerView.b, AdapterView.OnItemClickListener, p.a {
    static IPatchRedirector $redirector_;
    public static final int Q;
    public static int R;
    protected View C;
    protected View D;
    protected com.tencent.aio.api.runtime.a E;
    protected AIOContact F;
    public ViewPager G;
    protected p H;
    public int I;
    protected PopupWindow J;
    protected HotPicTab K;
    Set<String> L;
    Handler M;
    float N;
    int P;

    /* renamed from: d, reason: collision with root package name */
    protected int f236962d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f236963e;

    /* renamed from: f, reason: collision with root package name */
    public BaseQQAppInterface f236964f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f236965h;

    /* renamed from: i, reason: collision with root package name */
    protected e f236966i;

    /* renamed from: m, reason: collision with root package name */
    protected View f236967m;

    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicMainPanel.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            PopupWindow popupWindow = NTHotPicMainPanel.this.J;
            if (popupWindow != null && popupWindow.isShowing()) {
                NTHotPicMainPanel.this.J.dismiss();
            }
            NTHotPicMainPanel.this.C.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicMainPanel.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NTHotPicMainPanel.this.f();
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            Q = EmotionUtils.a(1.0f, BaseApplication.getContext().getResources());
        }
    }

    public NTHotPicMainPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f236966i = new e();
        this.I = 0;
        this.L = new HashSet();
        this.M = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ((IHotPicApi) QRoute.api(IHotPicApi.class)).markGuide();
        this.D.setVisibility(8);
    }

    private int i() {
        return ((h.b) this.E.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d)).a();
    }

    private int j() {
        return ((com.tencent.mobileqq.aio.event.h) this.E.e().k(new ShortcutEventIntent.OnGetIconBarHeightIntent())).a();
    }

    private void l() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            QLog.d("HotPicManager.Panel", 1, "hot pic is landscape");
            R = (int) (this.f236962d * 1.1d);
        } else {
            QLog.d("HotPicManager.Panel", 1, "hot pic is portrait");
            R = (int) (r0.getDisplayMetrics().heightPixels * 0.6d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        t(((Integer) valueAnimator.getAnimatedValue()).intValue() - this.f236962d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i3, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue == i3) {
            AbstractGifImage.resumeAll();
        }
        t(intValue - this.f236962d);
    }

    private boolean o() {
        if (R > this.f236962d) {
            return true;
        }
        return false;
    }

    private boolean s() {
        if (!com.tencent.mobileqq.utils.m.b().equalsIgnoreCase("oppo-x907") && !DeviceInfoMonitor.getModel().toLowerCase().equals("mi 1s")) {
            return false;
        }
        return true;
    }

    private void t(int i3) {
        this.E.e().h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent("HotPicManager.Panel", i3, true));
    }

    @Override // com.tencent.mobileqq.hotpic.f
    public void a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Message obtainMessage = this.M.obtainMessage(i3);
        obtainMessage.arg1 = i16;
        obtainMessage.arg2 = i17;
        this.M.sendMessage(obtainMessage);
    }

    protected boolean e() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) this.f236965h.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (memoryInfo.totalMem < 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice mi.totalMem is " + memoryInfo.totalMem + " checkIsLowPerformanceDevice is 1073741824");
        }
        return z16;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f165714d93);
        if (s()) {
            PopupWindow popupWindow = this.J;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.J.dismiss();
            }
            this.C.setVisibility(8);
            return;
        }
        if (VersionUtils.isHoneycomb()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.4f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.4f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.1f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.addListener(new a());
            animatorSet.start();
        }
    }

    protected void h(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, i17);
        ofInt.setDuration(i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.hotpic.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NTHotPicMainPanel.this.m(valueAnimator);
            }
        });
        ofInt.start();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        p pVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.arg1;
        int i16 = message.arg2;
        if (getVisibility() != 8 && this.f236966i.c(i3) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager.Panel", 2, "handleMessage, tagHotPic = " + i3 + ", version = " + i16 + ", msg = " + message.what + ", index = " + this.K.r());
            }
            int i17 = message.what;
            if (i17 == 8) {
                p pVar2 = this.H;
                if (pVar2 != null) {
                    pVar2.f(i3, i17);
                }
                return true;
            }
            int i18 = this.f236966i.c(i3).version;
            if (i18 == i16) {
                p pVar3 = this.H;
                if (pVar3 != null) {
                    pVar3.f(i3, message.what);
                }
                if (NetworkUtil.isNetworkAvailable(this.f236965h) && message.what == 7) {
                    int i19 = this.f236966i.c(i3).position + 1;
                    while (true) {
                        if (i19 < this.f236966i.f()) {
                            int i26 = this.f236966i.d(i19).tagId;
                            if (i26 == -20) {
                                i19++;
                            } else {
                                ((IHotPicApi) QRoute.api(IHotPicApi.class)).requestHotPicList(null, i26);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else if (i18 == 0 && i3 == 2) {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_hot_pic_first_update_119486238", true);
                QLog.i("HotPicManager.Panel", 1, "handleMessage() ----- version=0, switchOn:" + isSwitchOn + ", what:" + message.what);
                if (isSwitchOn && (pVar = this.H) != null) {
                    pVar.f(i3, message.what);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r1 != 3) goto L49;
     */
    @Override // com.tencent.qqnt.aio.shortcutbar.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z17 = false;
        if (!o()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                int y16 = (int) ((motionEvent.getY() - this.N) + 0.5f);
                int i16 = i();
                int i17 = i16 - y16;
                int i18 = R;
                if (i17 > i18 || i17 < (i18 = this.f236962d)) {
                    i17 = i18;
                }
                if (i17 != i16) {
                    AbstractGifImage.pauseAll();
                    t(i17 - this.f236962d);
                }
            }
            return true;
        }
        int i19 = i();
        final int i26 = R;
        if (i19 != i26 && i19 != (i3 = this.f236962d)) {
            int i27 = this.P;
            if (i19 <= i27) {
                i26 = i3;
            }
            if (Math.abs(i19 - i27) <= 100) {
                i26 = this.P;
            }
            int i28 = this.P;
            int i29 = R;
            if (i28 != i29 && i26 == i29) {
                z16 = true;
            } else {
                z16 = false;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(i19, i26);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.hotpic.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NTHotPicMainPanel.this.n(i26, valueAnimator);
                }
            });
            ofInt.start();
            z17 = z16;
        } else {
            AbstractGifImage.resumeAll();
            int i36 = this.P;
            int i37 = R;
            if (i36 != i37 && i19 == i37) {
                z17 = true;
            }
        }
        if (z17) {
            ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B21", "0X8007B21", 0, 0, "", "", "", "");
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.g
    public boolean interceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!o()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                if (getParent() == null) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            float y16 = motionEvent.getY();
            if (Math.abs((int) ((y16 - this.N) + 0.5f)) <= j() * 0.6f) {
                return false;
            }
            this.N = y16;
            return true;
        }
        this.N = motionEvent.getY();
        this.P = i();
        return false;
    }

    public void k(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, aVar);
            return;
        }
        this.f236964f = baseQQAppInterface;
        this.f236965h = context;
        this.E = aVar;
        this.F = aVar.g().r().c();
        this.f236967m = findViewById(R.id.loading);
        this.D = findViewById(R.id.f165715d94);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167601bi, (ViewGroup) null);
        this.C = inflate;
        inflate.setVisibility(8);
        this.G = (ViewPager) findViewById(R.id.d9_);
        HotPicTab hotPicTab = (HotPicTab) findViewById(R.id.d8r);
        this.K = hotPicTab;
        hotPicTab.setOnItemClickListener(this);
        setId(R.id.k_);
        VideoReport.setElementId(this, "em_aio_gif_panel");
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(this, EmotionReportDtImpl.IS_RED_TIPS_BEFORE, Integer.valueOf(((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicRedDotStatus(this.f236964f.getCurrentUin())));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            if (i3 == 0) {
                ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B12", "0X8007B12", 0, 0, "", "", "", "");
            } else if (i3 == 1) {
                ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B13", "0X8007B13", 0, 0, "", "", "", "");
            } else if (this.f236966i.f() > i3 && this.f236966i.d(i3).tagType == 2) {
                ReportController.o(this.f236964f, "dc00898", "", "", "0X8007ED3", "0X8007ED3", 0, 0, "", "", "", "");
            }
            this.K.setSelection(i3);
            this.G.setCurrentItem(i3);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // com.tencent.mobileqq.hotpic.p.a
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        NTHotPicPageView.f236975c0 = true;
        f();
        if (this.K.r() != i3) {
            this.K.setSelection(i3);
        }
        this.H.d(i3);
        HotPicTagInfo d16 = this.f236966i.d(i3);
        if (d16 != null) {
            ReportController.o(this.f236964f, "dc00898", "", "", "0X8008076", "0X8008076", 0, 0, i3 + "", "", d16.tagName, "");
        }
    }

    @Override // com.tencent.mobileqq.hotpic.NTHotPicRecyclerView.b
    public void onPullDown() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (o() && (i3 = i()) == R) {
            h(250, i3, this.f236962d);
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager.Panel", 2, "onPullDown");
            }
        }
    }

    @Override // com.tencent.mobileqq.hotpic.NTHotPicRecyclerView.b
    public void onPullUp() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (!o() || (i3 = i()) >= (i16 = R)) {
                return;
            }
            h(200, i3, i16);
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotPicManager.Panel", 2, "onHide");
        }
        this.E.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(null));
        NTHotPicPageView.f236975c0 = true;
        HotPicTagInfo s16 = this.K.s();
        if (s16 != null) {
            ((IHotPicApi) QRoute.api(IHotPicApi.class)).processData(s16);
        }
        this.K.q();
        ((IHotPicApi) QRoute.api(IHotPicApi.class)).clearHotPicListener();
        this.H.e();
        this.H = null;
        this.G.setAdapter(null);
        this.G.setOnPageChangeListener(null);
        this.G.removeAllViews();
        this.f236966i.b();
        this.L.clear();
        ((IHotPicApi) QRoute.api(IHotPicApi.class)).cleanResource();
        setVisibility(8);
        QQEmoticonPicLoader.f356316a.b().release();
    }

    public void q() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.E.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(this));
        this.f236962d = ((h.b) this.E.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d)).b();
        l();
        int i3 = 0;
        if (R > this.f236962d) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f236963e = z16;
        if (QLog.isColorLevel()) {
            QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.l() + " init panelH " + this.f236962d + " needExtendPanel " + this.f236963e);
        }
        Manager hotPicManager = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicManager();
        ((IHotPicApi) QRoute.api(IHotPicApi.class)).initHotPicManager(hotPicManager, this);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicTags(hotPicManager));
        boolean e16 = e();
        if (this.F.e() != 99 && this.F.e() != 100 && this.F.e() != 101 && this.F.e() != 102 && this.F.e() != 103 && this.F.e() != 115) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17 || e16) {
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.l() + " isTempSession is true mSessionInfo.curType is " + this.F.e());
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                HotPicTagInfo hotPicTagInfo = (HotPicTagInfo) it.next();
                if (hotPicTagInfo.tagType == 2) {
                    arrayList2.add(hotPicTagInfo);
                }
            }
            if (arrayList2.size() > 0) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    HotPicTagInfo hotPicTagInfo2 = (HotPicTagInfo) it5.next();
                    if (arrayList.contains(hotPicTagInfo2)) {
                        arrayList.remove(hotPicTagInfo2);
                    }
                }
            }
        }
        Iterator it6 = arrayList.iterator();
        int i16 = -1;
        while (it6.hasNext()) {
            HotPicTagInfo hotPicTagInfo3 = (HotPicTagInfo) it6.next();
            if (this.F.e() == 2) {
                if (!hotPicTagInfo3.tagName.equals(com.tencent.mobileqq.hotpic.a.f237005b)) {
                    if (hotPicTagInfo3.tagName.equals(com.tencent.mobileqq.hotpic.a.f237004a)) {
                        this.I = i3 + 2;
                    }
                }
            }
            if (this.F.e() == 1) {
                if (!hotPicTagInfo3.tagName.equals(com.tencent.mobileqq.hotpic.a.f237004a)) {
                    if (hotPicTagInfo3.tagName.equals(com.tencent.mobileqq.hotpic.a.f237005b)) {
                        this.I = i3 + 2;
                    }
                }
            }
            this.f236966i.a(hotPicTagInfo3);
            if (hotPicTagInfo3.tagId == ((IHotPicApi) QRoute.api(IHotPicApi.class)).getLastClickId(hotPicManager)) {
                i16 = i3;
            }
            i3++;
        }
        p pVar = new p(this, this.G);
        this.H = pVar;
        this.G.setAdapter(pVar);
        this.G.setOnPageChangeListener(this.H);
        this.K.t(this.f236966i.e(), i16);
        this.K.setOnItemClickListener(this);
        if (i16 != -1) {
            this.G.setCurrentItem(i16);
        }
        if (NetworkUtil.isNetworkAvailable(this.f236965h)) {
            Iterator<HotPicTagInfo> it7 = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicTags(hotPicManager).iterator();
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                HotPicTagInfo next = it7.next();
                int i17 = next.tagId;
                int i18 = next.tagType;
                if (i17 != 2 && i18 != 255 && !((IHotPicApi) QRoute.api(IHotPicApi.class)).checkData(hotPicManager, i17)) {
                    ((IHotPicApi) QRoute.api(IHotPicApi.class)).requestHotPicList(hotPicManager, i17);
                    break;
                }
            }
        }
        ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
        int e17 = this.F.e();
        if (e17 != 1) {
            if (e17 != 2) {
                if (e17 == 3) {
                    ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B15", "0X8007B15", 0, 0, "", "", "", "");
                }
            } else {
                ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B16", "0X8007B16", 0, 0, "", "", "", "");
            }
        } else {
            ReportController.o(this.f236964f, "dc00898", "", "", "0X8007B14", "0X8007B14", 0, 0, "", "", "", "");
        }
        u();
    }

    public void r(HotPicData hotPicData) {
        int i3;
        boolean z16;
        int i16;
        Size c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) hotPicData);
            return;
        }
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f165714d93);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        int i17 = hotPicData.width;
        int i18 = hotPicData.height;
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT && (getContext() instanceof FragmentActivity) && (c16 = com.tencent.mobileqq.pad.m.c((FragmentActivity) getContext())) != null) {
            QLog.i("HotPicManager.Panel", 1, "getRealScreenWidth  size:" + c16);
            i3 = c16.getWidth();
            z16 = true;
        } else {
            i3 = 0;
            z16 = false;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (z16) {
            i16 = (i3 - (Q * 6)) / 2;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = 17;
                layoutParams2.topMargin = 0;
                imageView.setLayoutParams(layoutParams2);
            }
        } else {
            i16 = (getContext().getResources().getDisplayMetrics().widthPixels - (Q * 6)) / 2;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams3.gravity = 1;
                layoutParams3.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.d98);
                imageView.setLayoutParams(layoutParams3);
            }
        }
        int i19 = (int) ((i16 * 1.5f) + 0.5f);
        float f16 = i17 / i19;
        marginLayoutParams.width = i19;
        marginLayoutParams.height = (int) ((i18 / f16) + 0.5f);
        int i26 = (int) ((160.0f / f16) + 0.5f);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = true;
        obtain.mExtraInfo = hotPicData;
        URL hotPicURL = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicURL(hotPicData.originalUrl);
        if (hotPicURL == null) {
            return;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(hotPicURL, obtain);
        drawable2.setTargetDensity(i26);
        imageView.setImageDrawable(drawable2);
        if (drawable2.getStatus() == 2 && NetworkUtil.isNetworkAvailable(this.f236965h)) {
            drawable2.restartDownload();
        }
        if (this.J == null) {
            this.J = new PopupWindow(this.C, getResources().getDisplayMetrics().widthPixels, getRootView().getHeight());
        }
        if (!this.J.isShowing()) {
            this.J.showAtLocation(this, 0, 0, 0);
        }
        this.C.setVisibility(0);
        File diskFile = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicData.originalUrl);
        if (diskFile != null && diskFile.exists()) {
            v(imageView);
        } else {
            drawable2.setDownloadListener(new URLDrawable.DownloadListener(imageView) { // from class: com.tencent.mobileqq.hotpic.NTHotPicMainPanel.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ImageView f236968d;

                {
                    this.f236968d = imageView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTHotPicMainPanel.this, (Object) imageView);
                    }
                }

                @Override // com.tencent.image.URLDrawable.DownloadListener
                public void onFileDownloadFailed(int i27) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, i27);
                    }
                }

                @Override // com.tencent.image.URLDrawable.DownloadListener
                public void onFileDownloadStarted() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }

                @Override // com.tencent.image.URLDrawable.DownloadListener
                public void onFileDownloadSucceed(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, j3);
                    } else {
                        NTHotPicMainPanel.this.M.post(new Runnable() { // from class: com.tencent.mobileqq.hotpic.NTHotPicMainPanel.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    NTHotPicMainPanel.this.v(anonymousClass1.f236968d);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void setOnHotPicItemClickListener(NTHotPicPageView.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            if (!((IHotPicApi) QRoute.api(IHotPicApi.class)).isNeedGuide() || !((IHotPicApi) QRoute.api(IHotPicApi.class)).checkData(null, 2)) {
                return;
            }
            this.D.setVisibility(0);
            this.D.setOnTouchListener(new b());
        }
    }

    public void v(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        if (s()) {
            view.setVisibility(0);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.2f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.4f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.start();
    }
}
