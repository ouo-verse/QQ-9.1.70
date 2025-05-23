package com.tencent.mobileqq.flashchat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.etrump.mixlayout.ETTextView;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.an;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import mqq.app.MobileQQ;

@TargetApi(11)
/* loaded from: classes12.dex */
public class FlashChatPanel extends RelativeLayout implements View.OnClickListener, Runnable, d, TabBarView.d, ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;
    public static final int T;
    public static final int U;
    public static int V;
    public static final int W;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f209805a0;

    /* renamed from: b0, reason: collision with root package name */
    protected static final int f209806b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final int f209807c0;
    public View C;
    public ArkAppRootLayout D;
    public ETTextView E;
    public View F;
    public FlashChatTextEffectView[] G;
    public Random H;
    public HashMap<Integer, ArkFlashChatContainerWrapper> I;
    public MessageForArkFlashChat J;
    public HashMap<Integer, ArkFlashChatContainerWrapper> K;
    int L;
    ArkAppView M;
    ArkAppLoadLayout N;
    a61.c P;
    public int[] Q;
    public int R;
    public boolean S;

    /* renamed from: d, reason: collision with root package name */
    QQViewPager f209808d;

    /* renamed from: e, reason: collision with root package name */
    TabBarView f209809e;

    /* renamed from: f, reason: collision with root package name */
    int f209810f;

    /* renamed from: h, reason: collision with root package name */
    int f209811h;

    /* renamed from: i, reason: collision with root package name */
    int f209812i;

    /* renamed from: m, reason: collision with root package name */
    RelativeLayout f209813m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements ArkAppView.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashChatPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppView.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppView.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f209820a;

        /* renamed from: b, reason: collision with root package name */
        public String f209821b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f209822c;

        /* renamed from: d, reason: collision with root package name */
        public int f209823d;

        /* renamed from: e, reason: collision with root package name */
        public FlashChatItem f209824e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements an {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashChatPanel.this);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0);
                view.dispatchTouchEvent(obtain);
                obtain.recycle();
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (view instanceof ArkAppView) {
                ((ArkAppView) view).onTouch(view, motionEvent);
                return true;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71959);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        Resources resources = BaseApplicationImpl.sApplication.getResources();
        T = BaseAIOUtils.f(400.0f, resources);
        int f16 = BaseAIOUtils.f(1.0f, resources);
        W = f16;
        U = (resources.getDisplayMetrics().widthPixels - (f16 * 2)) / 3;
        V = BaseAIOUtils.f(100.0f, resources);
        f209805a0 = BaseChatItemLayout.P + BaseChatItemLayout.W;
        f209806b0 = BaseChatItemLayout.Q + BaseChatItemLayout.f178043a0;
        f209807c0 = BaseChatItemLayout.c() + BaseChatItemLayout.g();
    }

    public FlashChatPanel(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        this.f209808d = null;
        this.f209809e = null;
        this.f209811h = -1;
        this.f209812i = -1;
        this.f209813m = null;
        this.G = new FlashChatTextEffectView[2];
        this.H = new Random();
        this.I = new HashMap<>();
        this.K = new HashMap<>();
        this.L = -1;
        this.Q = new int[2];
        this.R = 0;
        this.S = false;
    }

    public static float h() {
        return (i() * 3.0f) / 4.0f;
    }

    public static float i() {
        return f.f199482b + (MobileQQ.sMobileQQ.getResources().getDisplayMetrics().scaledDensity * 20.0f);
    }

    private void q(QQAppInterface qQAppInterface, View view, Drawable drawable) {
        if (drawable != null && view != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            int paddingTop = view.getPaddingTop() + rect.top;
            int paddingLeft = view.getPaddingLeft() + rect.left;
            int paddingRight = view.getPaddingRight() + rect.right;
            int paddingBottom = view.getPaddingBottom() + rect.bottom;
            view.setBackgroundDrawable(drawable);
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    @Override // com.tencent.mobileqq.widget.TabBarView.d
    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f209808d.setCurrentItem(i16, true);
            this.f209812i = i16;
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        n(this.f209811h, -1);
        m();
        QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.mkz), 0).show();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        m();
        this.P.p();
        r(false);
    }

    public RelativeLayout g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
        if (!z16) {
            return this.f209813m;
        }
        if (this.f209813m == null) {
            Context context = getContext();
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.auo, (ViewGroup) null);
            this.f209813m = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.f209813m.findViewById(R.id.close).setOnClickListener(this);
            View findViewById = this.f209813m.findViewById(R.id.aor);
            this.C = findViewById;
            findViewById.setOnClickListener(this);
            QQAppInterface qQAppInterface = this.P.f25577b;
            ((ImageView) this.f209813m.findViewById(R.id.bdp)).setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 1, qQAppInterface.getCurrentUin()));
            this.f209813m.findViewById(R.id.f164471yu).setPadding(0, 0, 0, 0);
            ArkAppLoadLayout arkAppLoadLayout = (ArkAppLoadLayout) this.f209813m.findViewById(R.id.eet);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) arkAppLoadLayout.getLayoutParams();
            layoutParams.setMargins(5, 5, 5, 5);
            arkAppLoadLayout.setLayoutParams(layoutParams);
            ETTextView eTTextView = (ETTextView) this.f209813m.findViewById(R.id.jjy);
            this.E = eTTextView;
            eTTextView.setTextColor(context.getResources().getColorStateList(R.color.skin_chat_buble));
            this.E.setLinkTextColor(context.getResources().getColorStateList(R.color.skin_blue_link));
            this.E.setSpannableFactory(QQText.SPANNABLE_FACTORY);
            this.E.setMaxWidth(BaseChatItemLayout.M);
            this.E.setMovementMethod(LinkMovementMethod.getInstance());
            Resources resources = qQAppInterface.getApp().getResources();
            Drawable drawable = resources.getDrawable(R.drawable.skin_aio_user_bubble_pressed);
            Drawable drawable2 = resources.getDrawable(R.drawable.skin_aio_user_bubble_nor);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable);
            stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, drawable2);
            q(qQAppInterface, this.E, stateListDrawable);
            ColorStateList colorStateList = resources.getColorStateList(R.color.skin_chat_buble_mine);
            this.E.setPadding(BaseChatItemLayout.f(), f209805a0, BaseChatItemLayout.e(), f209806b0);
            this.E.setTextColor(colorStateList);
            this.E.setTextSize(0, this.P.f25589n.N);
            this.D = (ArkAppRootLayout) this.f209813m.findViewById(R.id.f164460yj);
            this.M = (ArkAppView) this.f209813m.findViewById(R.id.y_);
            this.N = (ArkAppLoadLayout) this.f209813m.findViewById(R.id.eet);
            this.M.setClipRadius(14.0f);
            this.M.setBorderType(2);
            this.M.setAlignLeft(false);
            new c();
            this.M.setCallback(new a());
        }
        return this.f209813m;
    }

    public FlashChatItem j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (FlashChatItem) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return k(this.f209811h, this.f209810f);
    }

    public FlashChatItem k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (FlashChatItem) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            return this.G[i3].g(i16);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("FlashChat", 2, "recordChoose " + i3 + " " + this.f209810f + "" + i16);
                return null;
            }
            return null;
        }
    }

    public Pair<Integer, Integer> l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Pair) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        ArrayList arrayList = new ArrayList();
        try {
            FlashChatTextEffectView flashChatTextEffectView = this.G[i3];
            if (flashChatTextEffectView != null) {
                for (int i16 = 0; i16 < flashChatTextEffectView.h(); i16++) {
                    FlashChatItem g16 = flashChatTextEffectView.g(i16);
                    if (FlashChatManager.x(this.P.f25577b, g16) == null && g16.f209775id != -100000) {
                        arrayList.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i16)));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            int nextInt = this.H.nextInt(arrayList.size());
            if (this.L == nextInt) {
                nextInt = (nextInt + 1) / arrayList.size();
            }
            this.L = nextInt;
            return (Pair) arrayList.get(nextInt);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        FlashChatItem j3 = j();
        if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 1, "recordChoose" + this.f209811h + " " + j3);
        }
        StringBuilder sb5 = new StringBuilder();
        if (j3 != null) {
            sb5.append(this.f209811h);
        } else {
            sb5.append(this.f209812i);
        }
        sb5.append(":");
        if (j3 == null) {
            sb5.append(-1);
        } else {
            sb5.append(j3.f209775id);
        }
        ((FlashChatManager) this.P.f25577b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).C(sb5.toString());
    }

    public void n(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            o(i3, i16, false);
        }
    }

    public void o(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "selectItem " + i3 + " " + i16);
        }
        FlashChatItem k3 = k(i3, i16);
        if (k3 != null) {
            if (k3.f209775id == -100000) {
                Pair<Integer, Integer> l3 = l(i3);
                if (l3 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FlashChat", 2, "random empty");
                    }
                } else {
                    QLog.d("FlashChat", 2, QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM + l3.first + " " + l3.second);
                    n(l3.first.intValue(), l3.second.intValue());
                    return;
                }
            } else if (i3 == 0) {
                String x16 = FlashChatManager.x(this.P.f25577b, k3);
                if (x16 != null) {
                    VasH5PayUtil.openH5Pay(getContext(), "mvip.g.a.sl_" + k3.f209775id, x16, 0, false, false);
                    return;
                }
                if (z16) {
                    this.f209809e.setSelectedTab(this.f209811h, false);
                }
                setupArkUI(k3);
            } else if (i3 == 1 && z16) {
                this.f209809e.setSelectedTab(i3, false);
            }
        } else {
            String obj = this.P.f25587l.getText().toString();
            if (obj != null) {
                obj = obj.trim();
            }
            if (TextUtils.isEmpty(obj)) {
                obj = HardCodeUtil.qqStr(R.string.f171986ml0);
            }
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "cancelChoose");
            }
            this.E.setVisibility(0);
            this.E.setText(obj);
            this.D.setVisibility(8);
            if (z16 && i3 >= 0 && i3 <= 1) {
                this.f209809e.setSelectedTab(i3, false);
            }
        }
        this.f209810f = i16;
        this.f209811h = i3;
        while (true) {
            FlashChatTextEffectView[] flashChatTextEffectViewArr = this.G;
            if (i17 < flashChatTextEffectViewArr.length) {
                FlashChatTextEffectView flashChatTextEffectView = flashChatTextEffectViewArr[i17];
                if (flashChatTextEffectView != null) {
                    if (i17 != this.f209811h) {
                        flashChatTextEffectView.n(-1);
                    } else {
                        flashChatTextEffectView.n(i16);
                    }
                }
                i17++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.send_btn) {
                p();
                f();
            } else if (id5 == R.id.close) {
                f();
                this.S = true;
            } else if (id5 == R.id.aor) {
                e();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f209809e.setSelectedTab(i3, false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (getVisibility() != 0 || TextUtils.isEmpty(this.P.f25587l.getText().toString())) {
            return false;
        }
        m();
        this.P.u();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[Catch: Exception -> 0x0104, LOOP:0: B:30:0x00d9->B:41:0x0101, LOOP_START, PHI: r5 r8
  0x00d9: PHI (r5v1 int) = (r5v0 int), (r5v2 int) binds: [B:29:0x00d7, B:41:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x00d9: PHI (r8v6 int) = (r8v0 int), (r8v8 int) binds: [B:29:0x00d7, B:41:0x0101] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x0104, blocks: (B:73:0x00c3, B:28:0x00d3, B:30:0x00d9, B:32:0x00df, B:34:0x00e5, B:37:0x00f1, B:47:0x00fb), top: B:72:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(boolean z16) {
        int i3;
        String[] split;
        int intValue;
        int intValue2;
        FlashChatTextEffectView flashChatTextEffectView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        int i16 = 0;
        if (z16) {
            XPanelContainer.f384714h0 = (int) (getResources().getDisplayMetrics().density * 246.0f);
            RelativeLayout g16 = g(true);
            int i17 = -1;
            if (g16.getParent() == null) {
                ((FrameLayout) this.P.f25594s.findViewById(R.id.fyc)).addView(g16, new RelativeLayout.LayoutParams(-1, -1));
            } else {
                g16.setVisibility(0);
            }
            this.P.f25594s.findViewById(R.id.fun_btn).setVisibility(8);
            this.P.f25583h.setVisibility(8);
            AIOShortcutBarHelper aIOShortcutBarHelper = (AIOShortcutBarHelper) this.P.k(52);
            if (aIOShortcutBarHelper != null) {
                aIOShortcutBarHelper.y(11);
            }
            String obj = this.P.f25587l.getEditableText().toString();
            if (obj != null) {
                obj = obj.trim();
            }
            if (obj != null && obj.length() != 0 && obj.length() <= 20) {
                this.F.setEnabled(true);
            } else {
                this.F.setEnabled(false);
            }
            String p16 = ((FlashChatManager) this.P.f25577b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).p();
            if (p16 != null) {
                try {
                    split = p16.split(":");
                } catch (Exception e16) {
                    e = e16;
                    i3 = -1;
                    e.printStackTrace();
                    int i18 = i17;
                    i17 = i3;
                    intValue = i18;
                    o(intValue, i17, true);
                    if (intValue != 0) {
                    }
                }
                if (split.length == 2) {
                    intValue = Integer.valueOf(split[0]).intValue();
                    try {
                        intValue2 = Integer.valueOf(split[1]).intValue();
                        flashChatTextEffectView = this.G[intValue];
                        if (flashChatTextEffectView != null) {
                            while (true) {
                                if (i16 >= flashChatTextEffectView.h()) {
                                    break;
                                }
                                FlashChatItem g17 = flashChatTextEffectView.g(i16);
                                if (intValue == 0) {
                                    if (FlashChatManager.x(this.P.f25577b, g17) == null && g17 != null && g17.f209775id == intValue2) {
                                        i17 = i16;
                                    }
                                } else if (intValue == 1 && g17 != null && g17.f209775id == intValue2) {
                                    i17 = i16;
                                    break;
                                }
                                i16++;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        int i19 = i17;
                        i17 = intValue;
                        i3 = i19;
                        e.printStackTrace();
                        int i182 = i17;
                        i17 = i3;
                        intValue = i182;
                        o(intValue, i17, true);
                        if (intValue != 0) {
                        }
                    }
                    o(intValue, i17, true);
                    if (intValue != 0) {
                        FlashChatManager flashChatManager = (FlashChatManager) this.P.f25577b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
                        if (flashChatManager.l().size() < 3) {
                            flashChatManager.B();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            intValue2 = -1;
            intValue = -1;
            flashChatTextEffectView = this.G[intValue];
            if (flashChatTextEffectView != null) {
            }
            o(intValue, i17, true);
            if (intValue != 0) {
            }
        } else {
            this.P.f25583h.setVisibility(0);
            AIOShortcutBarHelper aIOShortcutBarHelper2 = (AIOShortcutBarHelper) this.P.k(52);
            if (aIOShortcutBarHelper2 != null) {
                aIOShortcutBarHelper2.y(12);
            }
            RelativeLayout g18 = g(false);
            if (g18 != null) {
                g18.setVisibility(8);
            }
            this.P.f25594s.findViewById(R.id.fun_btn).setVisibility(0);
            if (this.M != null) {
                for (ArkFlashChatContainerWrapper arkFlashChatContainerWrapper : this.K.values()) {
                    if (arkFlashChatContainerWrapper != null) {
                        arkFlashChatContainerWrapper.doOnEvent(2);
                    }
                }
                this.K.clear();
            }
            if (QLog.isColorLevel()) {
                QLog.i("FlashChat", 2, "restore layout");
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        RelativeLayout g16 = g(false);
        if (g16 != null && (layoutParams = g16.getLayoutParams()) != null) {
            ((ViewGroup) this.P.f25594s.findViewById(R.id.inputBar)).getLocationInWindow(this.Q);
            layoutParams.height = this.Q[1] - ImmersiveUtils.getStatusBarHeight(getContext());
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 == 0) {
            r(true);
            return;
        }
        if (!this.S) {
            m();
        }
        r(false);
    }

    public void setupArkUI(FlashChatItem flashChatItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) flashChatItem);
            return;
        }
        String obj = this.P.f25587l.getText().toString();
        if (obj != null) {
            obj = obj.trim();
        }
        if (TextUtils.isEmpty(obj)) {
            obj = HardCodeUtil.qqStr(R.string.f171987ml1);
        }
        if (flashChatItem.f209775id == -100000) {
            int nextInt = this.H.nextInt(2);
            int nextInt2 = this.H.nextInt(this.G[nextInt].h());
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "setupArkUI  random " + nextInt + " " + nextInt2);
            }
            n(nextInt, nextInt2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "setupArkUI" + flashChatItem);
        }
        this.E.setVisibility(8);
        this.D.setVisibility(0);
        int i3 = flashChatItem.f209775id;
        ArkAppView arkAppView = this.M;
        if (arkAppView != null) {
            ArkFlashChatContainerWrapper arkFlashChatContainerWrapper = this.K.get(Integer.valueOf(i3));
            if (arkFlashChatContainerWrapper == null) {
                arkFlashChatContainerWrapper = new ArkFlashChatContainerWrapper();
                this.K.put(Integer.valueOf(i3), arkFlashChatContainerWrapper);
            }
            MessageForArkFlashChat messageForArkFlashChat = new MessageForArkFlashChat();
            messageForArkFlashChat.uniseq = i3;
            ArkFlashChatMessage arkFlashChatMessage = new ArkFlashChatMessage();
            messageForArkFlashChat.ark_app_message = arkFlashChatMessage;
            arkFlashChatMessage.promptText = obj;
            messageForArkFlashChat.arkContainer = arkFlashChatContainerWrapper;
            MessageForArkFlashChat messageForArkFlashChat2 = this.J;
            this.J = messageForArkFlashChat;
            arkFlashChatContainerWrapper.w(this.P.f25577b, getContext(), flashChatItem.appName, flashChatItem.mainView, flashChatItem.ver, flashChatItem.f209775id, messageForArkFlashChat.ark_app_message.getMeta(messageForArkFlashChat.uniseq, false), getContext().getResources().getDisplayMetrics().scaledDensity, this.P.m(), i(), h(), i(), h(), this.J);
            arkAppView.a(arkFlashChatContainerWrapper, this.N);
            arkAppView.setCallback(new ArkAppView.b(flashChatItem, messageForArkFlashChat2, messageForArkFlashChat) { // from class: com.tencent.mobileqq.flashchat.FlashChatPanel.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlashChatItem f209814a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ MessageForArkFlashChat f209815b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ MessageForArkFlashChat f209816c;

                {
                    this.f209814a = flashChatItem;
                    this.f209815b = messageForArkFlashChat2;
                    this.f209816c = messageForArkFlashChat;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashChatPanel.this, flashChatItem, messageForArkFlashChat2, messageForArkFlashChat);
                    }
                }

                @Override // com.tencent.mobileqq.activity.aio.item.ArkAppView.b
                public void a() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.activity.aio.item.ArkAppView.b
                public void b() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    } else {
                        ArkDispatchTask.getInstance().post(this.f209814a.appName, new Runnable() { // from class: com.tencent.mobileqq.flashchat.FlashChatPanel.1.1
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
                                    return;
                                }
                                MessageForArkFlashChat messageForArkFlashChat3 = AnonymousClass1.this.f209815b;
                                if (messageForArkFlashChat3 != null) {
                                    messageForArkFlashChat3.stopAnim();
                                }
                                AnonymousClass1.this.f209816c.playAnim();
                            }
                        });
                    }
                }
            });
            arkAppView.a(arkFlashChatContainerWrapper, this.N);
        }
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void t0(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (AppSetting.f99565y) {
            try {
                FlashChatItem k3 = k(i16, i3);
                if (k3 != null) {
                    com.tencent.mobileqq.util.c.a(view, k3.name);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        n(i16, i3);
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void zb(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public FlashChatPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f209808d = null;
        this.f209809e = null;
        this.f209811h = -1;
        this.f209812i = -1;
        this.f209813m = null;
        this.G = new FlashChatTextEffectView[2];
        this.H = new Random();
        this.I = new HashMap<>();
        this.K = new HashMap<>();
        this.L = -1;
        this.Q = new int[2];
        this.R = 0;
        this.S = false;
    }

    public FlashChatPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f209808d = null;
        this.f209809e = null;
        this.f209811h = -1;
        this.f209812i = -1;
        this.f209813m = null;
        this.G = new FlashChatTextEffectView[2];
        this.H = new Random();
        this.I = new HashMap<>();
        this.K = new HashMap<>();
        this.L = -1;
        this.Q = new int[2];
        this.R = 0;
        this.S = false;
    }
}
