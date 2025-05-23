package com.tencent.mobileqq.qqgamepub.view;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes16.dex */
public class GamePubNav extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private static final ColorFilter M;
    private static final ColorFilter N;
    private String C;
    private String D;
    private String E;
    private LinearLayout F;
    private LinearLayout G;
    public TextView H;
    public LinearLayout I;
    public TextView J;
    public TextView K;
    private int L;

    /* renamed from: d, reason: collision with root package name */
    private TextView f264736d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f264737e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f264738f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f264739h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f264740i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f264741m;

    /* renamed from: com.tencent.mobileqq.qqgamepub.view.GamePubNav$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ GamePubNav this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.f264741m.setAlpha(0.0f);
            this.this$0.f264741m.setVisibility(0);
            this.this$0.f264741m.animate().alpha(1.0f).setDuration(500L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f264742d;

        a(String str) {
            this.f264742d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GamePubNav.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                GamePubAccountHelper.c();
                GamePubAccountHelper.d();
                if (!TextUtils.isEmpty(this.f264742d) && !TextUtils.isEmpty(GamePubNav.this.D)) {
                    GamePubNav gamePubNav = GamePubNav.this;
                    gamePubNav.h(gamePubNav.D);
                } else {
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterGameCenter(((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl());
                }
                GamePubNav.this.i();
                GamePubNav.this.f();
                WadlReportBuilder ext = GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("770").setModuleType("77002").setOperId("209089").setExt(2, this.f264742d);
                if (GamePubNav.this.f264737e.getVisibility() == 0) {
                    str = "1";
                } else {
                    str = "2";
                }
                ext.setExt(3, str).setExt(4, "20").setExt(12, "160").report();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GamePubNav.this);
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
            } else {
                GamePubNav.this.f264741m.setVisibility(8);
            }
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            M = new LightingColorFilter(Color.argb(255, 0, 0, 0), 0);
            N = new LightingColorFilter(Color.argb(255, 0, 0, 0), 3355443);
        }
    }

    public GamePubNav(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.L = 0;
            g();
        }
    }

    private void g() {
        QLog.d("QQGamePub_GamePubNav", 4, "initUI");
        LayoutInflater.from(getContext()).inflate(R.layout.eba, this);
        this.J = (TextView) findViewById(R.id.f112026mt);
        this.K = (TextView) findViewById(R.id.f112016ms);
        this.f264736d = (TextView) findViewById(R.id.f108216ci);
        this.f264737e = (TextView) findViewById(R.id.dec);
        this.f264738f = (ImageView) findViewById(R.id.xjl);
        this.f264739h = (ImageView) findViewById(R.id.xkf);
        this.f264740i = (ImageView) findViewById(R.id.xkb);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.yed);
        this.f264741m = linearLayout;
        linearLayout.setVisibility(8);
        this.I = (LinearLayout) findViewById(R.id.f166122yr4);
        this.H = (TextView) findViewById(R.id.f112036mu);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GamePubNav jump url,urlType:");
        if (TextUtils.isEmpty(this.E)) {
            str2 = "";
        } else {
            str2 = this.E;
        }
        sb5.append(str2);
        sb5.append("jumpUrl=");
        sb5.append(str);
        QLog.i("QQGamePub_GamePubNav", 1, sb5.toString());
        if ("1".equals(this.E)) {
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterGameCenter(str);
        } else {
            if (str.startsWith("mqqapi://miniapp/")) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), str, 2016, null);
                return;
            }
            Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            getContext().startActivity(intent);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            e();
            this.f264741m.animate().alpha(0.0f).setDuration(500L).setListener(new b()).start();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            j(false, "", "", false);
        }
    }

    public void j(boolean z16, String str, String str2, boolean z17) {
        String str3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17));
            return;
        }
        try {
            if (!StringUtil.isEmpty(str)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = getResources().getDrawable(R.drawable.njr);
                obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.njr);
                this.f264738f.setImageDrawable(URLDrawable.getDrawable(str, obtain));
                this.f264738f.clearColorFilter();
            } else {
                boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
                this.f264738f.setImageDrawable(getResources().getDrawable(R.drawable.njr));
                ImageView imageView = this.f264738f;
                if (isNowThemeIsNight) {
                    i3 = -1862270977;
                } else {
                    i3 = -16777216;
                }
                imageView.setColorFilter(i3);
            }
            this.f264738f.setVisibility(0);
            this.f264738f.setOnClickListener(new a(str2));
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePubNav", 1, th5, new Object[0]);
        }
        TextView textView = this.f264737e;
        if (!z16) {
            i16 = 4;
        }
        textView.setVisibility(i16);
        if (z17) {
            WadlReportBuilder ext = GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("770").setModuleType("77002").setOperId("209088").setExt(2, str2);
            if (this.f264737e.getVisibility() == 0) {
                str3 = "1";
            } else {
                str3 = "2";
            }
            ext.setExt(3, str3).setExt(4, "8").setExt(12, "160").report();
        }
    }

    public void setBubbleJumpUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.D = str;
        }
    }

    public void setMoreClick(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onClickListener);
        } else {
            this.f264740i.setOnClickListener(onClickListener);
        }
    }

    public void setNoticeId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.C = str;
        }
    }

    public void setReturnClick(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onClickListener);
        } else {
            this.f264739h.setOnClickListener(onClickListener);
        }
    }

    public void setRootLayout(LinearLayout linearLayout, LinearLayout linearLayout2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) linearLayout, (Object) linearLayout2);
        } else {
            this.F = linearLayout;
            this.G = linearLayout2;
        }
    }

    public void setUrlType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.E = str;
        }
    }

    public GamePubNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.L = 0;
            g();
        }
    }

    public GamePubNav(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.L = 0;
            g();
        }
    }

    private void e() {
    }
}
