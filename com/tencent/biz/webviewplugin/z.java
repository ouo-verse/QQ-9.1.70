package com.tencent.biz.webviewplugin;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class z extends WebViewPlugin implements View.OnClickListener {
    public static int F = 10000;
    public static int G = 10001;
    public static int H = 10002;
    public static int I = 10003;
    public static int J = 10004;
    public static int K = 5;
    public ViewGroup C;
    public ViewGroup D;
    private h E;

    /* renamed from: d, reason: collision with root package name */
    private QQBrowserActivity f97655d;

    /* renamed from: e, reason: collision with root package name */
    private WebViewFragment f97656e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f97657f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f97658h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f97659i = false;

    /* renamed from: m, reason: collision with root package name */
    public int f97660m = 40;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            z.this.D.setClickable(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public int f97678a;

        /* renamed from: b, reason: collision with root package name */
        public String f97679b;

        /* renamed from: c, reason: collision with root package name */
        public String f97680c;

        /* renamed from: d, reason: collision with root package name */
        public int f97681d;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f97682a;

        /* renamed from: b, reason: collision with root package name */
        public String f97683b;

        /* renamed from: c, reason: collision with root package name */
        public List<g> f97684c;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f97685d;
    }

    private void A(h hVar) {
        if (hVar != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = hVar.f97682a;
            if (i3 != 0) {
                this.E.f97682a = i3;
                this.C.setBackgroundColor(hVar.f97682a);
                sb5.append("color=" + Integer.toHexString(this.E.f97682a));
            }
            String str = hVar.f97683b;
            if (str != null) {
                this.E.f97683b = str;
                sb5.append(";callback=" + this.E.f97683b);
            }
            List<g> list = hVar.f97684c;
            if (list != null) {
                int size = list.size();
                int i16 = K;
                if (size > i16) {
                    this.E.f97684c = hVar.f97684c.subList(0, i16);
                } else {
                    this.E.f97684c = hVar.f97684c;
                }
                this.D.removeAllViews();
                int size2 = this.E.f97684c.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    p(this.E.f97684c.get(i17), i17);
                    sb5.append(";buttonInfo index=" + i17 + ";id=" + this.E.f97684c.get(i17).f97678a + ";icon=" + this.E.f97684c.get(i17).f97679b + ";text=" + this.E.f97684c.get(i17).f97680c + ";textColor=" + Integer.toHexString(this.E.f97684c.get(i17).f97681d));
                }
            }
            List<String> list2 = hVar.f97685d;
            if (list2 != null) {
                this.E.f97685d = list2;
                int size3 = list2.size();
                for (int i18 = 0; i18 < size3; i18++) {
                    URLDrawable drawable = URLDrawable.getDrawable(this.E.f97685d.get(i18), ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f), (Drawable) null, (Drawable) null, true);
                    if (drawable != null && drawable.getStatus() == 2) {
                        drawable.restartDownload();
                    }
                    sb5.append(";emoIcons index=" + i18 + JefsClass.INDEX_URL + this.E.f97685d.get(i18));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountUIPlugin", 2, "updatePAArticleBottomBar" + sb5.toString());
            }
        }
    }

    private void p(g gVar, int i3) {
        URLImageView uRLImageView = new URLImageView(this.f97655d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f));
        String str = gVar.f97679b;
        if (str == null && TextUtils.isEmpty(str)) {
            int i16 = gVar.f97678a;
            if (i16 == F) {
                if (this.f97658h) {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6h));
                } else {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6g));
                }
            } else if (i16 == G) {
                if (this.f97658h) {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6j));
                } else {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6i));
                }
            } else if (i16 == H) {
                if (this.f97658h) {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6q));
                } else {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6p));
                }
            } else if (i16 == I) {
                if (this.f97658h) {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6n));
                } else {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6m));
                }
            } else if (i16 == J) {
                if (this.f97658h) {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6l));
                } else {
                    uRLImageView.setImageDrawable(this.f97655d.getResources().getDrawable(R.drawable.d6k));
                }
            } else {
                return;
            }
        } else {
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
            URLDrawable drawable = URLDrawable.getDrawable(gVar.f97679b, ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f), (Drawable) colorDrawable, (Drawable) colorDrawable, true);
            uRLImageView.setImageDrawable(drawable);
            if (drawable != null && drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
        }
        if (i3 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = (s() + ViewUtils.dip2px(24.0f)) * i3;
        }
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setTag(gVar);
        uRLImageView.setOnClickListener(this);
        this.D.addView(uRLImageView);
        if (gVar.f97680c != null && i3 != this.E.f97684c.size() - 1) {
            TextView textView = new TextView(this.f97655d);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = layoutParams.leftMargin + ViewUtils.dip2px(27.0f);
            textView.setLayoutParams(layoutParams2);
            layoutParams2.addRule(9);
            layoutParams2.addRule(15);
            textView.setGravity(16);
            textView.setText(gVar.f97680c);
            int i17 = gVar.f97681d;
            if (i17 != 0) {
                textView.setTextColor(i17);
            } else if (this.f97658h) {
                textView.setTextColor(Color.parseColor("#999999"));
            } else {
                textView.setTextColor(Color.parseColor("#919191"));
            }
            textView.setTextSize(11.0f);
            textView.setTag(gVar);
            textView.setOnClickListener(this);
            this.D.addView(textView);
        }
    }

    private void q() {
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment != null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mRuntime.a()).inflate(R.layout.a3q, (ViewGroup) null);
            if (webViewFragment.getUIStyleHandler().V != null) {
                webViewFragment.getUIStyleHandler().V.addView(viewGroup);
            }
        } else {
            ((ViewStub) this.f97655d.findViewById(R.id.fgp)).inflate();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f97655d.findViewById(R.id.g3l);
        this.C = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.setVisibility(0);
        ImageView imageView = (ImageView) this.f97655d.findViewById(R.id.bmt);
        if (this.f97658h) {
            imageView.setBackgroundColor(Color.parseColor("#333333"));
        } else {
            imageView.setBackgroundColor(Color.parseColor("#dedfe0"));
        }
        ViewGroup viewGroup3 = (ViewGroup) this.f97655d.findViewById(R.id.ach);
        this.D = viewGroup3;
        viewGroup3.setOnClickListener(new a());
        this.D.setEnabled(false);
        h hVar = this.E;
        if (hVar != null) {
            this.C.setBackgroundColor(hVar.f97682a);
            List<g> list = this.E.f97684c;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    p(this.E.f97684c.get(i3), i3);
                }
            }
        }
    }

    private static String r(int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("btnId", i3);
            jSONObject.put("data", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountUIPlugin", 2, "getClickBottomBarCallBackResult json error!");
            }
            return null;
        }
    }

    private int s() {
        int i3 = this.f97655d.getResources().getDisplayMetrics().widthPixels;
        int size = this.E.f97684c.size();
        return ((i3 - (ViewUtils.dip2px(12.0f) * 2)) - (ViewUtils.dip2px(24.0f) * size)) / (size - 1);
    }

    private void t() {
        h hVar = new h();
        this.E = hVar;
        hVar.f97684c = new ArrayList();
        if (this.f97658h) {
            this.E.f97682a = -16777216;
        } else {
            this.E.f97682a = -1;
        }
        g gVar = new g();
        gVar.f97678a = 10000;
        this.E.f97684c.add(gVar);
    }

    private boolean u() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + account, 0).getBoolean("public_account_bottom_bar", false)) {
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountUIPlugin", 2, "config is false");
            }
            return false;
        }
        return true;
    }

    private boolean v(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.contains("mp.qq.com")) {
                Uri parse = Uri.parse(str);
                if (str.contains("www.urlshare.cn/umirror_url_check")) {
                    parse = Uri.parse(parse.getQueryParameter("url"));
                }
                String queryParameter = parse.getQueryParameter("_pflag");
                if (queryParameter != null) {
                    try {
                        long parseLong = Long.parseLong(queryParameter, 10) & 7;
                        if (parseLong == 1 || parseLong == 2) {
                            if (parseLong == 2) {
                                this.f97658h = true;
                            }
                            return true;
                        }
                        return false;
                    } catch (NumberFormatException unused) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("PubAccountUIPlugin", 4, "_pflag param not found");
                            return false;
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            QLog.e("PubAccountUIPlugin", 1, "isPflagRulesNeedShowBottomBar exception: " + e16);
            return false;
        }
    }

    private void w(URLImageView uRLImageView, URLDrawable uRLDrawable) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.1f, 1.2f, 0.1f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100L);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.2f, 0.9f, 1.2f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(100L);
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.9f, 1.1f, 0.9f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation4.setDuration(100L);
        ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.1f, 0.95f, 1.1f, 0.95f, 1, 0.5f, 1, 0.5f);
        scaleAnimation5.setDuration(100L);
        ScaleAnimation scaleAnimation6 = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation6.setDuration(100L);
        uRLImageView.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new b(uRLImageView, uRLDrawable, scaleAnimation2));
        scaleAnimation2.setAnimationListener(new c(uRLImageView, scaleAnimation3));
        scaleAnimation3.setAnimationListener(new d(uRLImageView, scaleAnimation4));
        scaleAnimation4.setAnimationListener(new e(uRLImageView, scaleAnimation5));
        scaleAnimation5.setAnimationListener(new f(uRLImageView, scaleAnimation6));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "pubAccountUI";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 1L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.a() instanceof QQBrowserActivity)) {
            this.f97655d = (QQBrowserActivity) this.mRuntime.a();
        }
        WebViewPlugin.b bVar2 = this.mRuntime;
        if (bVar2 == null || this.f97655d == null) {
            return false;
        }
        WebViewFragment webViewFragment = (WebViewFragment) bVar2.f();
        this.f97656e = webViewFragment;
        if (webViewFragment == null) {
            QLog.e("PubAccountUIPlugin", 1, "handleEvent webViewFragment is null");
            return false;
        }
        if (j3 == 8589934593L) {
            if (!this.f97657f) {
                return false;
            }
            if (!this.f97659i) {
                t();
                x(this.E);
                this.f97659i = true;
            }
        } else if (j3 == 8589934611L) {
            x(this.E);
        } else if (j3 == 1 && u() && v(str)) {
            this.f97657f = true;
            this.f97656e.getUIStyleHandler().f314512m.f314618a = true;
            this.f97656e.getUIStyleHandler().f314512m.f314622e = 0L;
            if (this.f97658h) {
                this.f97656e.getUIStyleHandler().f314502d0 = -16777216;
            }
        }
        return super.handleEvent(str, j3, map);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String r16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getTag() instanceof g) {
            g gVar = (g) view.getTag();
            int i3 = gVar.f97678a;
            if (i3 == F) {
                this.f97655d.onBackPressed();
            } else if (i3 == I) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(IPublicAccountH5AbilityPlugin.OPEN_QQ_BROWSER);
                arrayList.add(IPublicAccountH5AbilityPlugin.OPEN_SYS_BROWSER);
                arrayList.add(IPublicAccountH5AbilityPlugin.FAVORITE);
                arrayList.add(IPublicAccountH5AbilityPlugin.COPY_URL);
                arrayList.add(IPublicAccountH5AbilityPlugin.EXPOSE_ARTICLE);
                arrayList.add(IPublicAccountH5AbilityPlugin.SCREEN_SHOT_SHARE);
                arrayList.add(IPublicAccountH5AbilityPlugin.SET_FONT);
                arrayList.add(IPublicAccountH5AbilityPlugin.SHARE_KANDIAN);
                arrayList.add(IPublicAccountH5AbilityPlugin.SHARE_DIANDIAN);
                arrayList.add(IPublicAccountH5AbilityPlugin.EXPORT_TENCENT_DOCS);
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.f97656e.mComponentsProvider.a(4);
                if (swiftBrowserShareMenuHandler != null) {
                    swiftBrowserShareMenuHandler.D.addAll(arrayList);
                    this.f97656e.showActionSheet();
                    swiftBrowserShareMenuHandler.D.clear();
                }
            } else if (i3 == J) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_QQ);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_CHANNEL);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_QZONE);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND_LINE);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_SINA_WEIBO);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_QIDIAN);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_QIYEQQ);
                arrayList2.add(IPublicAccountH5AbilityPlugin.SHARE_KANDIAN);
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler2 = (SwiftBrowserShareMenuHandler) this.f97656e.mComponentsProvider.a(4);
                if (swiftBrowserShareMenuHandler2 != null) {
                    swiftBrowserShareMenuHandler2.D.addAll(arrayList2);
                    this.f97656e.showActionSheet();
                    swiftBrowserShareMenuHandler2.D.clear();
                }
            }
            if (!TextUtils.isEmpty(this.E.f97683b) && (r16 = r(gVar.f97678a)) != null) {
                this.f97656e.getWebView().callJs(this.E.f97683b, r16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void x(h hVar) {
        if (!this.f97657f) {
            return;
        }
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            A(hVar);
        } else {
            q();
        }
    }

    public void y(boolean z16, int i3) {
        ViewGroup viewGroup;
        if (this.f97657f && (viewGroup = this.C) != null) {
            int height = viewGroup.getHeight();
            if (z16) {
                this.C.setVisibility(0);
                if (i3 != 0) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, height, 0.0f);
                    translateAnimation.setDuration(i3);
                    translateAnimation.setFillAfter(true);
                    this.C.startAnimation(translateAnimation);
                    return;
                }
                return;
            }
            if (!z16) {
                this.C.setVisibility(8);
                if (i3 != 0) {
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, height);
                    translateAnimation2.setDuration(i3);
                    translateAnimation2.setFillAfter(true);
                    this.C.startAnimation(translateAnimation2);
                }
            }
        }
    }

    public void z(g gVar) {
        h hVar;
        if (this.f97657f && (hVar = this.E) != null && hVar.f97684c != null && gVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountUIPlugin", 2, "updateButton buttonInfo id=" + gVar.f97678a + ",icon=" + gVar.f97679b + ",text=" + gVar.f97680c + ",textColor=" + Integer.toHexString(gVar.f97681d));
            }
            int size = this.E.f97684c.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.E.f97684c.get(i3).f97678a == gVar.f97678a) {
                    Drawable drawable = null;
                    URLImageView uRLImageView = null;
                    TextView textView = null;
                    for (int i16 = 0; i16 < this.D.getChildCount(); i16++) {
                        View childAt = this.D.getChildAt(i16);
                        if ((childAt.getTag() instanceof g) && ((g) childAt.getTag()).f97678a == gVar.f97678a) {
                            if (childAt instanceof TextView) {
                                textView = (TextView) childAt;
                            } else {
                                uRLImageView = (URLImageView) childAt;
                            }
                        }
                    }
                    if (uRLImageView == null && textView == null) {
                        return;
                    }
                    String str = gVar.f97679b;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        this.E.f97684c.get(i3).f97679b = gVar.f97679b;
                        int i17 = gVar.f97678a;
                        if (i17 == G) {
                            if (this.f97658h) {
                                drawable = this.f97655d.getResources().getDrawable(R.drawable.d6j);
                            } else {
                                drawable = this.f97655d.getResources().getDrawable(R.drawable.d6i);
                            }
                        } else if (i17 == H) {
                            if (this.f97658h) {
                                drawable = this.f97655d.getResources().getDrawable(R.drawable.d6q);
                            } else {
                                drawable = this.f97655d.getResources().getDrawable(R.drawable.d6p);
                            }
                        }
                        Drawable drawable2 = drawable;
                        URLDrawable drawable3 = URLDrawable.getDrawable(gVar.f97679b, ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f), drawable2, drawable2, true);
                        if (drawable3 != null && drawable3.getStatus() == 2) {
                            drawable3.restartDownload();
                        }
                        if (drawable3 != null && drawable3.getStatus() == 1) {
                            QLog.d("PubAccountUIPlugin", 2, "updateButton download newImage Successed url = " + gVar.f97679b);
                        }
                        if (uRLImageView != null) {
                            w(uRLImageView, drawable3);
                        }
                    }
                    String str2 = gVar.f97680c;
                    if (str2 != null) {
                        if (textView != null) {
                            textView.setText(str2);
                        } else {
                            TextView textView2 = new TextView(this.f97655d);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                            layoutParams.leftMargin = ((RelativeLayout.LayoutParams) uRLImageView.getLayoutParams()).leftMargin + ViewUtils.dip2px(27.0f);
                            textView2.setLayoutParams(layoutParams);
                            layoutParams.addRule(9);
                            layoutParams.addRule(15);
                            textView2.setGravity(16);
                            textView2.setTextSize(11.0f);
                            textView2.setTag(gVar);
                            textView2.setOnClickListener(this);
                            textView2.setText(gVar.f97680c);
                            this.D.addView(textView2);
                            textView = textView2;
                        }
                        this.E.f97684c.get(i3).f97680c = gVar.f97680c;
                    }
                    int i18 = gVar.f97681d;
                    if (i18 != 0) {
                        if (textView != null) {
                            textView.setTextColor(i18);
                            this.E.f97684c.get(i3).f97681d = gVar.f97681d;
                        }
                    } else if (textView != null) {
                        if (this.f97658h) {
                            textView.setTextColor(Color.parseColor("#999999"));
                        } else {
                            textView.setTextColor(Color.parseColor("#919191"));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f97662d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f97663e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f97664f;

        b(URLImageView uRLImageView, URLDrawable uRLDrawable, ScaleAnimation scaleAnimation) {
            this.f97662d = uRLImageView;
            this.f97663e = uRLDrawable;
            this.f97664f = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f97662d.setImageDrawable(this.f97663e);
            this.f97662d.startAnimation(this.f97664f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f97666d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f97667e;

        c(URLImageView uRLImageView, ScaleAnimation scaleAnimation) {
            this.f97666d = uRLImageView;
            this.f97667e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f97666d.startAnimation(this.f97667e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f97669d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f97670e;

        d(URLImageView uRLImageView, ScaleAnimation scaleAnimation) {
            this.f97669d = uRLImageView;
            this.f97670e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f97669d.startAnimation(this.f97670e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f97672d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f97673e;

        e(URLImageView uRLImageView, ScaleAnimation scaleAnimation) {
            this.f97672d = uRLImageView;
            this.f97673e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f97672d.startAnimation(this.f97673e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f97675d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f97676e;

        f(URLImageView uRLImageView, ScaleAnimation scaleAnimation) {
            this.f97675d = uRLImageView;
            this.f97676e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f97675d.startAnimation(this.f97676e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
