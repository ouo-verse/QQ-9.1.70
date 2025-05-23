package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopTagViewActivity extends QQBrowserActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f293692a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f293693b0;

    /* renamed from: c0, reason: collision with root package name */
    protected String f293694c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f293695d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f293696e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f293697f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f293698g0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class TroopTagViewFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;
        protected String C;
        protected String D;
        protected String E;
        protected int F;
        protected boolean G;
        public int H;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            a(t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTagViewFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                    return;
                }
                super.onFinalState(bundle);
                TroopTagViewFragment troopTagViewFragment = TroopTagViewFragment.this;
                if (troopTagViewFragment.F == 1 && troopTagViewFragment.G) {
                    troopTagViewFragment.getSwiftTitleUI().C.setText(R.string.f170869aw3);
                    TroopTagViewFragment.this.getSwiftTitleUI().C.setVisibility(0);
                    TroopTagViewFragment.this.getSwiftTitleUI().E.setVisibility(8);
                    TroopTagViewFragment.this.getSwiftTitleUI().C.setOnClickListener(TroopTagViewFragment.this);
                    return;
                }
                troopTagViewFragment.getSwiftTitleUI().C.setVisibility(8);
                TroopTagViewFragment.this.getSwiftTitleUI().E.setVisibility(8);
            }
        }

        public TroopTagViewFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.G = false;
                this.H = 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
            }
            Bundle extras = this.intent.getExtras();
            this.F = extras.getInt("act_type", 3);
            this.D = extras.getString(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (extras.containsKey("subclass")) {
                this.E = extras.getString("subclass");
            } else {
                this.E = "";
            }
            this.C = extras.getString("troopuin");
            this.G = extras.getBoolean("isAdmin");
            this.H = extras.getInt("modifyToSrv", 1);
            return super.doOnCreate(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (t) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new a(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            } else if (view == getSwiftTitleUI().C) {
                if (this.F == 1 && this.G) {
                    Intent intent = new Intent(super.getActivity(), (Class<?>) TroopTagViewActivity.class);
                    intent.putExtra("troopuin", this.C);
                    intent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, this.D);
                    intent.putExtra("act_type", 2);
                    intent.putExtra("modifyToSrv", this.H);
                    intent.putExtra("uin", getAppRuntime().getCurrentAccountUin());
                    super.getActivity().startActivity(intent);
                } else {
                    super.onClick(view);
                }
            } else {
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TroopTagViewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293692a0 = false;
        this.f293697f0 = 1;
        this.mFragmentClass = TroopTagViewFragment.class;
    }

    public void G2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f293698g0 = str;
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        Intent intent = super.getIntent();
        if (intent == null) {
            super.finish();
            return true;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            super.finish();
            return true;
        }
        this.f293696e0 = extras.getInt("act_type", 3);
        this.f293694c0 = extras.getString(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        String str = "";
        if (extras.containsKey("subclass")) {
            this.f293695d0 = extras.getString("subclass");
        } else {
            this.f293695d0 = "";
        }
        String string = extras.getString("troopuin");
        this.f293693b0 = string;
        if (TextUtils.isEmpty(string)) {
            super.finish();
            return true;
        }
        this.f293692a0 = extras.getBoolean("isAdmin");
        intent.putExtra("hide_operation_bar", true);
        if (!TextUtils.isEmpty(this.f293694c0)) {
            str = URLEncoder.encode(this.f293694c0).replace(Marker.ANY_NON_NULL_MARKER, "%20");
        }
        int i3 = extras.getInt("modifyToSrv", 1);
        this.f293697f0 = i3;
        int i16 = this.f293696e0;
        if (i16 == 1) {
            intent.putExtra("url", String.format("https://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s", Long.valueOf(System.currentTimeMillis() / 1000), str, this.f293693b0, this.f293695d0, Integer.valueOf(this.f293697f0)));
        } else if (i16 == 2) {
            intent.putExtra("url", String.format("https://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s", str, this.f293693b0, this.f293695d0, Integer.valueOf(i3)));
        } else {
            intent.putExtra("url", extras.getString("url"));
        }
        intent.putExtra("isShowAd", false);
        super.doOnCreate(bundle);
        intent.putExtra("act_type", 3);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.f293698g0)) {
            Intent intent = new Intent();
            intent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, this.f293698g0);
            setResult(-1, intent);
        }
        super.finish();
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
