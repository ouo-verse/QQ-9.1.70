package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class NavBarQQGamePub extends NavBarCommon {
    static IPatchRedirector $redirector_;
    private static final String G;
    private String C;
    private String D;
    private int E;
    private String F;

    /* renamed from: d, reason: collision with root package name */
    private TextView f264766d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f264767e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f264768f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f264769h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f264770i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f264771m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NavBarQQGamePub.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00f4  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (NavBarQQGamePub.this.f264766d != null && NavBarQQGamePub.this.f264766d.getVisibility() == 0) {
                    NavBarQQGamePub.this.f264766d.setVisibility(4);
                }
                HashMap hashMap = new HashMap();
                int i3 = 1;
                if (NavBarQQGamePub.this.E == 1) {
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterGameCenter(((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl());
                    i3 = 2;
                } else {
                    if (NavBarQQGamePub.this.E == 2) {
                        if (!TextUtils.isEmpty(NavBarQQGamePub.this.C) && (NavBarQQGamePub.this.C.startsWith("http") || NavBarQQGamePub.this.C.startsWith("https"))) {
                            NavBarQQGamePub navBarQQGamePub = NavBarQQGamePub.this;
                            navBarQQGamePub.i(navBarQQGamePub.C);
                        }
                        str = NavBarQQGamePub.this.D;
                        NavBarQQGamePub.this.k();
                        i3 = 3;
                    } else if (NavBarQQGamePub.this.E == 3) {
                        if (!TextUtils.isEmpty(NavBarQQGamePub.this.C) && (NavBarQQGamePub.this.C.startsWith("http") || NavBarQQGamePub.this.C.startsWith("https"))) {
                            NavBarQQGamePub navBarQQGamePub2 = NavBarQQGamePub.this;
                            navBarQQGamePub2.i(navBarQQGamePub2.C);
                        }
                        str = NavBarQQGamePub.this.D;
                        NavBarQQGamePub.this.k();
                    } else {
                        i3 = 0;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(2, str);
                    }
                    hashMap.put(3, i3 + "");
                    hashMap.put(4, "20");
                    hashMap.put(24, NavBarQQGamePub.this.F);
                    com.tencent.mobileqq.qqgamepub.utils.a.l(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "770", "207023", "", "77002", "1", "160", hashMap);
                    GamePubAccountHelper.c();
                    GamePubAccountHelper.d();
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                }
                hashMap.put(3, i3 + "");
                hashMap.put(4, "20");
                hashMap.put(24, NavBarQQGamePub.this.F);
                com.tencent.mobileqq.qqgamepub.utils.a.l(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "770", "207023", "", "77002", "1", "160", hashMap);
                GamePubAccountHelper.c();
                GamePubAccountHelper.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29003);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        G = "QQGamePub_" + NavBarQQGamePub.class.getSimpleName();
    }

    public NavBarQQGamePub(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = 0;
        this.F = "";
        h();
    }

    private void h() {
        this.f264769h = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        this.f264769h.setOrientation(0);
        layoutParams.rightMargin = g.a(40.0f, getResources());
        addView(this.f264769h, layoutParams);
        this.f264768f = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g.a(30.0f, getResources()), g.a(64.0f, getResources()));
        layoutParams2.gravity = 17;
        this.f264769h.addView(this.f264768f, layoutParams2);
        ImageView imageView = new ImageView(getContext());
        this.f264767e = imageView;
        imageView.setImageResource(R.drawable.ncn);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g.a(24.0f, getResources()), g.a(24.0f, getResources()));
        layoutParams3.addRule(15);
        this.f264768f.addView(this.f264767e, layoutParams3);
        TextView textView = new TextView(getContext());
        this.f264766d = textView;
        textView.setText("");
        this.f264766d.setTextColor(-1);
        this.f264766d.setTextSize(10.0f);
        this.f264766d.setGravity(17);
        this.f264766d.setBackgroundResource(R.drawable.fem);
        int a16 = g.a(1.0f, getResources());
        this.f264766d.setPadding(a16, a16, a16, a16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(g.a(6.0f, getResources()), g.a(6.0f, getResources()));
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = g.a(16.0f, getResources());
        layoutParams4.rightMargin = g.a(6.0f, getResources());
        this.f264768f.addView(this.f264766d, layoutParams4);
        this.f264766d.setVisibility(4);
        this.f264771m = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        this.f264771m.setSingleLine();
        this.f264771m.setTextColor(-1);
        this.f264771m.setTextSize(10.0f);
        this.f264771m.setGravity(17);
        this.f264769h.addView(this.f264771m, layoutParams5);
        this.f264769h.setOnClickListener(new a());
        this.f264769h.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        if (str.startsWith("mqqapi://miniapp/")) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), str, 2016, null);
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        getContext().startActivity(intent);
    }

    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f264767e;
    }

    public TextView getTitleTextView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TextView) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (this.f264770i == null) {
            this.f264770i = (TextView) findViewById(R.id.ivTitleName);
        }
        if (this.f264770i == null) {
            this.f264770i = new TextView(getContext());
            QLog.e(G, 2, "[getTitleTextView] titleTv is null");
        }
        return this.f264770i;
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        ImageView imageView = this.f264767e;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f264767e.setImageResource(R.drawable.ncn);
            this.f264771m.setText("");
            this.C = str;
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ImageView imageView = this.f264767e;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f264767e.setImageResource(R.drawable.ncn);
            this.f264771m.setText("");
            setmBubbleid("");
            setCurType(1);
        }
    }

    public void l(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, str3);
            return;
        }
        if (this.f264767e != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = getResources().getDrawable(R.drawable.f161598e80);
            obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.f161598e80);
            this.f264767e.setImageDrawable(URLDrawable.getDrawable(str, obtain));
            this.f264767e.setVisibility(0);
            this.C = str3;
            setCurType(2);
        }
        if (this.f264771m != null) {
            if (str2.length() > 5) {
                str2 = str2.substring(0, 5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            this.f264771m.setText(str2);
            this.f264771m.setVisibility(0);
        }
    }

    public void m(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        TextView textView = this.f264766d;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            textView.setVisibility(i3);
        }
    }

    public void setCurType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.E = i3;
        if (i3 == 0) {
            this.f264769h.setVisibility(8);
        } else {
            this.f264769h.setVisibility(0);
        }
    }

    public void setGamePubType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.F = str;
        }
    }

    @Override // com.tencent.mobileqq.widget.navbar.NavBarCommon
    public void setRightImage2(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.title);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setmBubbleid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.D = str;
        }
    }

    public NavBarQQGamePub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = 0;
        this.F = "";
        h();
    }

    public NavBarQQGamePub(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = 0;
        this.F = "";
        h();
    }
}
