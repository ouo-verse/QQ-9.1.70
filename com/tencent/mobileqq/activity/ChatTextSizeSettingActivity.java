package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatTextSizeSettingActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    private static int f175424i0;

    /* renamed from: a0, reason: collision with root package name */
    int f175425a0;

    /* renamed from: b0, reason: collision with root package name */
    private ViewGroup f175426b0;

    /* renamed from: c0, reason: collision with root package name */
    private ViewGroup f175427c0;

    /* renamed from: d0, reason: collision with root package name */
    private ViewGroup f175428d0;

    /* renamed from: e0, reason: collision with root package name */
    private ViewGroup f175429e0;

    /* renamed from: f0, reason: collision with root package name */
    private ArrayList<ViewGroup> f175430f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<Integer> f175431g0;

    /* renamed from: h0, reason: collision with root package name */
    private View.OnClickListener f175432h0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatTextSizeSettingActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.jix) {
                    ChatTextSizeSettingActivity.this.f175425a0 = 1;
                } else if (id5 == R.id.jiw) {
                    ChatTextSizeSettingActivity.this.f175425a0 = 2;
                } else if (id5 == R.id.jiu) {
                    ChatTextSizeSettingActivity.this.f175425a0 = 3;
                } else {
                    ChatTextSizeSettingActivity.this.f175425a0 = 0;
                }
                ChatTextSizeSettingActivity chatTextSizeSettingActivity = ChatTextSizeSettingActivity.this;
                chatTextSizeSettingActivity.G2(chatTextSizeSettingActivity.f175425a0);
                ChatTextSizeSettingActivity chatTextSizeSettingActivity2 = ChatTextSizeSettingActivity.this;
                ReportController.o(chatTextSizeSettingActivity2.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(chatTextSizeSettingActivity2.f175425a0), "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f175424i0 = 0;
        }
    }

    public ChatTextSizeSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175425a0 = 0;
        this.f175430f0 = new ArrayList<>();
        this.f175431g0 = new ArrayList<>();
        this.f175432h0 = new a();
    }

    public static int H2(Context context) {
        int i3 = context.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
        context.getResources().getDimensionPixelSize(R.dimen.f158274c0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return context.getResources().getDimensionPixelSize(R.dimen.f158274c0);
                }
                return context.getResources().getDimensionPixelSize(R.dimen.f158272bx);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.by);
        }
        return context.getResources().getDimensionPixelSize(R.dimen.f158273bz);
    }

    public static int getChatEmotionSizeWithDP() {
        return getChatTextSizeWithDP() + 2;
    }

    public static int getChatTextSizeWithDP() {
        float dimension;
        int i3 = f175424i0;
        if (i3 != 0) {
            return i3;
        }
        int i16 = BaseApplication.getContext().getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    dimension = BaseApplication.getContext().getResources().getDimension(R.dimen.f158274c0);
                } else {
                    dimension = BaseApplication.getContext().getResources().getDimension(R.dimen.f158272bx);
                }
            } else {
                dimension = BaseApplication.getContext().getResources().getDimension(R.dimen.by);
            }
        } else {
            dimension = BaseApplication.getContext().getResources().getDimension(R.dimen.f158273bz);
        }
        int i17 = (int) ((dimension / BaseApplication.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        f175424i0 = i17;
        return i17;
    }

    void G2(int i3) {
        for (int i16 = 0; i16 < this.f175430f0.size(); i16++) {
            ImageView imageView = (ImageView) this.f175430f0.get(i16).findViewById(R.id.jiv);
            if (i16 == i3) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
            }
        }
        SharedPreferences.Editor edit = getSharedPreferences("setting_text_size", 0).edit();
        edit.putInt("chat_text_size_type", i3);
        edit.commit();
        f175424i0 = 0;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        super.setContentView(R.layout.g_);
        setTitle(getString(R.string.cxz));
        this.f175426b0 = (ViewGroup) findViewById(R.id.jiy);
        this.f175427c0 = (ViewGroup) findViewById(R.id.jix);
        this.f175428d0 = (ViewGroup) findViewById(R.id.jiw);
        this.f175429e0 = (ViewGroup) findViewById(R.id.jiu);
        this.f175430f0.add(this.f175426b0);
        this.f175430f0.add(this.f175427c0);
        this.f175430f0.add(this.f175428d0);
        this.f175430f0.add(this.f175429e0);
        this.f175426b0.setOnClickListener(this.f175432h0);
        this.f175427c0.setOnClickListener(this.f175432h0);
        this.f175428d0.setOnClickListener(this.f175432h0);
        this.f175429e0.setOnClickListener(this.f175432h0);
        this.f175431g0.add(Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.f158274c0)));
        this.f175431g0.add(Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.f158273bz)));
        this.f175431g0.add(Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.by)));
        this.f175431g0.add(Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.f158272bx)));
        int i3 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
        this.f175425a0 = i3;
        G2(i3);
    }
}
