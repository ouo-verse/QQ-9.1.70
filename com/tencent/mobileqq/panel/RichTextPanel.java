package com.tencent.mobileqq.panel;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatPanelView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IFontBubbleManagerExt;
import com.tencent.mobileqq.vas.api.IVasRichPanelToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class RichTextPanel extends RelativeLayout implements QUIPageTabBar.i, ViewPager.OnPageChangeListener, View.OnClickListener, com.tencent.mobileqq.flashchat.d {
    static IPatchRedirector $redirector_;
    private static long Q;
    public static int R;
    private boolean C;
    private ImageView D;
    private Button E;
    private int F;
    private int G;
    private boolean H;
    private final ArrayMap<Integer, RichTextPanelView> I;
    private final ArrayList<Integer> J;
    private final ArrayList<RichTextPanelView> K;
    private f L;
    private EditText M;
    private boolean N;
    private final PagerAdapter P;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f257140d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f257141e;

    /* renamed from: f, reason: collision with root package name */
    private QQViewPager f257142f;

    /* renamed from: h, reason: collision with root package name */
    private int f257143h;

    /* renamed from: i, reason: collision with root package name */
    private QUIPageTabBar f257144i;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f257145m;

    /* renamed from: com.tencent.mobileqq.panel.RichTextPanel$3, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RichTextPanelView f257146d;
        final /* synthetic */ RichTextPanel this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((FlashChatPanelView) this.f257146d).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends RelativeLayout {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RichTextPanel.this, (Object) context);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes16.dex */
    class b extends PagerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RichTextPanel.this);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
            } else {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return RichTextPanel.this.K.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, obj)).intValue();
            }
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("RichTextPanel", 2, "instantiateItem position = " + i3);
            }
            ViewParent parent = ((RichTextPanelView) RichTextPanel.this.K.get(i3)).getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView((View) RichTextPanel.this.K.get(i3));
            }
            viewGroup.addView((View) RichTextPanel.this.K.get(i3));
            return RichTextPanel.this.K.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            Q = -1L;
            R = 1;
        }
    }

    public RichTextPanel(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f257143h = -1;
        this.f257145m = Boolean.FALSE;
        this.I = new ArrayMap<>();
        this.J = new ArrayList<>();
        this.K = new ArrayList<>();
        this.N = false;
        this.P = new b();
    }

    private void b(RichTextPanelView richTextPanelView) {
        int i3;
        AppRuntime appRuntime = this.f257140d;
        if (appRuntime != null) {
            i3 = com.tencent.mobileqq.flashchat.e.d((QQAppInterface) appRuntime).i();
        } else {
            i3 = 0;
        }
        boolean z16 = richTextPanelView instanceof ZhituPanelView;
        if (z16 && i3 == 1) {
            this.E.setVisibility(8);
        }
        if (z16 && this.E.getVisibility() == 8) {
            s(this.E, R.anim.f154476ii);
            if (i3 != 1) {
                this.E.setVisibility(0);
                return;
            }
            return;
        }
        if (this.E.getVisibility() == 0) {
            s(this.E, R.anim.f154480ae);
            this.E.setVisibility(8);
        }
    }

    private void c(com.tencent.aio.api.runtime.a aVar, EditText editText, com.tencent.qqnt.aio.api.e eVar) {
        this.I.put(0, new ZhituPanelView(getContext(), aVar, this.f257140d, editText, eVar, this.L, this.E));
        if (!((IVasRichPanelToggle) QRoute.api(IVasRichPanelToggle.class)).isEnable()) {
            this.I.put(3, new FontBubblePanelView(getContext(), aVar, this.f257140d, editText, this.L, new c()));
            this.I.put(4, new FontBubblePanelView(getContext(), aVar, this.f257140d, editText, this.L, new com.tencent.mobileqq.panel.b()));
        } else {
            FontBubbleManager.j((QQAppInterface) this.f257140d).v(aVar, getContext());
            this.I.put(3, (RichTextPanelView) ((IFontBubbleManagerExt) QRoute.api(IFontBubbleManagerExt.class)).createKuiklyFontPanel(getContext(), ((IVasRichPanelToggle) QRoute.api(IVasRichPanelToggle.class)).fontUrl()));
            this.I.put(4, (RichTextPanelView) ((IFontBubbleManagerExt) QRoute.api(IFontBubbleManagerExt.class)).createKuiklyBubblePanel(getContext(), ((IVasRichPanelToggle) QRoute.api(IVasRichPanelToggle.class)).bubbleUrl()));
        }
        this.I.put(5, new EmoticonHotPicSearchPanelView(getContext(), aVar, this.f257140d, editText, eVar, this.L));
    }

    private void d(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i3 = 0; i3 < this.K.size(); i3++) {
            strArr[i3] = list.get(i3);
        }
        this.f257144i.setTabData(strArr);
        this.f257144i.setViewPager(this.f257142f);
        int e16 = com.tencent.mobileqq.flashchat.e.d((QQAppInterface) this.f257140d).e((QQAppInterface) this.f257140d, this.J);
        QLog.d("RichTextPanel", 2, "lastTab=" + e16 + ", mShowPages.size()=" + this.K.size());
        if (this.K.size() == 0) {
            return;
        }
        if (e16 < this.K.size()) {
            this.N = true;
            this.f257144i.setCurrentPosition(e16, false);
            if (e16 == 0) {
                I0(0, false);
                return;
            }
            return;
        }
        this.f257144i.setCurrentPosition(0, false);
        I0(0, false);
    }

    private void e() {
        int i3;
        if (this.f257144i == null || !this.K.isEmpty()) {
            return;
        }
        ArrayList<Integer> b16 = com.tencent.mobileqq.flashchat.e.d((QQAppInterface) this.f257140d).b(this.f257140d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it = b16.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue == 0 && ZhituManager.I((AppInterface) this.f257140d).i0()) {
                this.K.add(this.I.get(Integer.valueOf(intValue)));
                this.J.add(0);
                arrayList.add(this.I.get(Integer.valueOf(intValue)).a());
                arrayList2.add(Integer.valueOf(R.id.m67));
            } else if (intValue != 3 && intValue != 4) {
                if (intValue == 5) {
                    this.K.add(this.I.get(Integer.valueOf(intValue)));
                    this.J.add(5);
                    arrayList.add(this.I.get(Integer.valueOf(intValue)).a());
                    arrayList2.add(Integer.valueOf(R.id.f74323vy));
                }
            } else {
                this.K.add(this.I.get(Integer.valueOf(intValue)));
                this.J.add(Integer.valueOf(intValue));
                arrayList.add(this.I.get(Integer.valueOf(intValue)).a());
                if (intValue == 3) {
                    i3 = R.id.m65;
                } else {
                    i3 = R.id.f166791m63;
                }
                arrayList2.add(Integer.valueOf(i3));
            }
        }
        this.P.notifyDataSetChanged();
        d(arrayList);
    }

    private boolean g(int i3) {
        if (i3 >= 0 && i3 < this.J.size()) {
            String str = AppConstants.Preferences.HAD_SHOW_FONTBUBBLE_GUIDE + this.J.get(i3);
            SharedPreferences preferences = this.f257140d.getPreferences();
            boolean z16 = preferences.getBoolean(str, false);
            preferences.edit().putBoolean(str, true).apply();
            return !z16;
        }
        QLog.e("RichTextPanel", 1, "needShowGuide outofindex: " + i3 + "," + this.J.size());
        return false;
    }

    private void m(Context context, Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof SkinnableBitmapDrawable) {
            bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setDither(true);
        setBackground(bitmapDrawable);
    }

    private void n() {
        ImageView imageView = new ImageView(getContext());
        this.D = imageView;
        imageView.setId(R.id.ci8);
        this.D.setOnClickListener(this);
        this.D.setVisibility(8);
        this.D.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void o(Drawable drawable) {
        QQViewPager qQViewPager = new QQViewPager(getContext());
        this.f257142f = qQViewPager;
        qQViewPager.setId(R.id.i_6);
        this.f257142f.setBackground(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f257142f.setFocusable(true);
        this.f257142f.setFocusableInTouchMode(true);
        this.f257142f.requestParentDisallowInterecptTouchEvent(true);
        layoutParams.addRule(2, R.id.i_8);
        addView(this.f257142f, layoutParams);
        this.f257142f.setAdapter(this.P);
        this.f257142f.setOnPageChangeListener(this);
    }

    private void p(Drawable drawable) {
        a aVar = new a(getContext());
        aVar.setId(R.id.i_8);
        aVar.setBackground(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, x.c(getContext(), 40.0f));
        layoutParams.addRule(12, -1);
        q(aVar);
        r(aVar, layoutParams);
    }

    private void q(RelativeLayout relativeLayout) {
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) View.inflate(getContext(), R.layout.c6i, null);
        this.f257144i = qUIPageTabBar;
        qUIPageTabBar.setId(R.id.i_7);
        this.f257144i.setTabChangeListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, x.c(getContext(), 40.0f));
        layoutParams.addRule(0, R.id.imy);
        relativeLayout.addView(this.f257144i, layoutParams);
    }

    private void r(RelativeLayout relativeLayout, RelativeLayout.LayoutParams layoutParams) {
        Button button = new Button(getContext());
        this.E = button;
        button.setId(R.id.imy);
        this.E.setBackground(getResources().getDrawable(R.drawable.f160271eh));
        this.E.setText(getResources().getString(R.string.ihk));
        this.E.setTextColor(getResources().getColor(R.color.skin_white));
        this.E.setContentDescription(getResources().getString(R.string.ihk));
        this.E.setTextSize(2, 14.0f);
        this.E.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(x.c(getContext(), 60.0f), x.c(getContext(), 40.0f));
        layoutParams2.addRule(11);
        this.E.setOnClickListener(this);
        relativeLayout.addView(this.E, layoutParams2);
        addView(relativeLayout, layoutParams);
    }

    private void s(View view, int i3) {
        if (view == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i3);
        loadAnimation.setFillAfter(false);
        view.startAnimation(loadAnimation);
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
    public void I0(int i3, boolean z16) {
        int i16;
        String str;
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 != this.f257143h && this.K.size() > 0) {
            if (this.f257140d == null) {
                return;
            }
            if (!z16) {
                i17 = 1;
            }
            R = i17;
            int i18 = this.f257143h;
            if (i18 >= 0 && i18 < this.K.size()) {
                this.K.get(this.f257143h).c(false);
            } else {
                this.f257145m = Boolean.TRUE;
            }
            if (i3 >= 0 && i3 < this.K.size()) {
                RichTextPanelView richTextPanelView = this.K.get(i3);
                if (richTextPanelView != null) {
                    if (this.f257145m.booleanValue()) {
                        this.f257145m = Boolean.FALSE;
                    } else {
                        richTextPanelView.c(true);
                    }
                    if (richTextPanelView instanceof ZhituPanelView) {
                        str = "0X80094D2";
                    } else if (richTextPanelView instanceof FlashChatPanelView) {
                        str = "0X80094D3";
                    } else if (richTextPanelView instanceof FontBubblePanelView) {
                        if (!this.N) {
                            ((FontBubblePanelView) richTextPanelView).s();
                        }
                        this.N = false;
                        str = "";
                    } else {
                        str = null;
                    }
                    String str2 = str;
                    if (!TextUtils.isEmpty(str2)) {
                        ReportController.o(this.f257140d, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                    if ((richTextPanelView instanceof EmoticonHotPicSearchPanelView) && (editText = this.M) != null) {
                        ReportController.o(this.f257140d, "dc00898", "", "", "0X800AE34", "0X800AE34", 0, 0, "", "", editText.getText().toString(), "");
                        ((EmoticonHotPicSearchPanelView) richTextPanelView).g();
                    }
                }
                if ((richTextPanelView instanceof FontBubblePanelView) && g(i3)) {
                    this.D.setVisibility(0);
                }
                b(richTextPanelView);
            }
            int max = Math.max(i3, 0);
            this.f257143h = max;
            if (max != this.f257142f.getCurrentItem()) {
                this.f257142f.setCurrentItem(this.f257143h, true);
            }
            ArrayList<Integer> arrayList = this.J;
            if (arrayList != null && (i16 = this.f257143h) >= 0 && i16 < arrayList.size()) {
                com.tencent.mobileqq.core.util.b.g(this.f257140d.getApplication(), this.f257140d.getCurrentAccountUin(), this.J.get(this.f257143h).intValue());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichTextPanel", 2, "onTabSelected: already at the position: " + i3 + " mShowPages.size: " + this.K.size());
        }
    }

    public void f(Context context, com.tencent.aio.api.runtime.a aVar, EditText editText, com.tencent.qqnt.aio.api.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, aVar, editText, eVar);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.f257140d = peekAppRuntime;
        if (peekAppRuntime == null) {
            QLog.e("RichTextPanel", 1, "initPanel Error: appRuntime is null");
            return;
        }
        this.f257141e = aVar;
        this.M = editText;
        this.L = new f((QQAppInterface) peekAppRuntime, aVar, this);
        Drawable drawable = getResources().getDrawable(R.drawable.skin_panel_background);
        m(context, drawable);
        this.G = BaseAIOUtils.f(250.0f, getResources());
        this.C = this.f257140d.getPreferences().getBoolean("isHiBoomFirstShow", true);
        p(drawable);
        o(drawable);
        n();
        c(aVar, editText, eVar);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.f257140d = null;
        if (this.I.size() > 0) {
            for (RichTextPanelView richTextPanelView : this.I.values()) {
                if (richTextPanelView != null) {
                    richTextPanelView.b();
                }
            }
        }
    }

    public void i() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.K.size() > 0 && (i3 = this.f257143h) > 0 && i3 < this.K.size()) {
            RichTextPanelView richTextPanelView = this.K.get(this.f257143h);
            if (richTextPanelView instanceof FlashChatPanelView) {
                ((FlashChatPanelView) richTextPanelView).e();
            }
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.L.m(z16);
            ((EmoticonHotPicSearchPanelView) this.I.get(5)).e(z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(boolean z16) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichTextPanel", 2, "onPanelStatusChanged show = " + z16);
        }
        if (z16) {
            e();
        }
        if (this.f257143h < this.K.size() && (i3 = this.f257143h) >= 0) {
            RichTextPanelView richTextPanelView = this.K.get(i3);
            richTextPanelView.c(z16);
            if (z16) {
                if (richTextPanelView instanceof ZhituPanelView) {
                    str3 = "SmartPic";
                    str4 = "0X80094D2";
                } else if (richTextPanelView instanceof FlashChatPanelView) {
                    str3 = "FlashChat";
                    str4 = "0X80094D3";
                } else {
                    if (richTextPanelView instanceof FontBubblePanelView) {
                        if (!this.H && (Q <= 0 || SystemClock.uptimeMillis() - Q > 300)) {
                            ((FontBubblePanelView) richTextPanelView).s();
                            Q = SystemClock.uptimeMillis();
                        }
                        str = "";
                        str2 = str;
                    } else {
                        str = null;
                        str2 = "";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ReportController.o(this.f257140d, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
                        VasWebviewUtil.reportCommercialDrainage(this.f257140d.getCurrentUin(), "InputFunc", "EnterFunc", "", 1, 0, 0, "", "", str2);
                    }
                }
                str2 = str3;
                str = str4;
                if (!TextUtils.isEmpty(str)) {
                }
            }
            this.H = z16;
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.L.n();
            ((EmoticonHotPicSearchPanelView) this.I.get(5)).f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ZhituManager I;
        ZhituPanelView zhituPanelView;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.i_5) {
                String str = IndividuationUrlHelper.getMarketUrl(getContext(), "font", IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG) + "&haibao=1";
                if (QLog.isColorLevel()) {
                    QLog.d("RichTextPanel", 2, "enter hiboom mall url = " + str);
                }
                VasWebviewUtil.openQQBrowserWithoutAD(getContext(), str, 4096L, null, false, -1);
            } else if (id5 == R.id.ci8) {
                this.D.setVisibility(8);
            } else if (id5 == R.id.imy && (I = ZhituManager.I((AppInterface) this.f257140d)) != null && (zhituPanelView = I.S) != null) {
                zhituPanelView.I();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (this.H && (fVar = this.L) != null) {
            fVar.l();
        }
        this.H = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        f fVar = this.L;
        if (fVar != null && fVar.h() && this.D.getVisibility() == 0) {
            if (this.D.getVisibility() == 0) {
                this.F = ((i17 - i3) * 598) / 750;
            } else {
                this.F = this.G;
            }
            int a16 = h.a(this.f257141e);
            if (this.F != h.b(this.f257141e)) {
                QLog.d("RichTextPanel", 2, "showGuide curPanelHeight = " + a16);
                if (a16 == 0) {
                    h.c(this.f257141e, this.F);
                } else {
                    h.c(this.f257141e, this.F - a16);
                }
                if (this.D.getVisibility() == 0) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    ColorDrawable colorDrawable = new ColorDrawable(16777215);
                    obtain.mFailedDrawable = colorDrawable;
                    obtain.mLoadingDrawable = colorDrawable;
                    this.D.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/vipData/app/imageStore/7e2fb795e29a9d0c4bc54f62adf2aa2e.png", obtain));
                }
                requestLayout();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (this.f257143h != i3) {
            this.f257144i.setCurrentPosition(i3, true);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void t0(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void zb(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public RichTextPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f257143h = -1;
        this.f257145m = Boolean.FALSE;
        this.I = new ArrayMap<>();
        this.J = new ArrayList<>();
        this.K = new ArrayList<>();
        this.N = false;
        this.P = new b();
    }

    public RichTextPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f257143h = -1;
        this.f257145m = Boolean.FALSE;
        this.I = new ArrayMap<>();
        this.J = new ArrayList<>();
        this.K = new ArrayList<>();
        this.N = false;
        this.P = new b();
    }
}
