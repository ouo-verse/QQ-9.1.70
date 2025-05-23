package com.tencent.mobileqq.musicgene;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.h;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MusicGeneQQBrowserActivity extends QQBrowserActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private BroadcastReceiver f251885a0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class MusicGeneQQBrowserFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;

        public MusicGeneQQBrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicGeneQQBrowserActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("BROAD_CAST_SHARE_MUSIC_GENE".equals(action)) {
                String stringExtra = intent.getStringExtra("BUNDLE_KEY_TITLE");
                String stringExtra2 = intent.getStringExtra("BUNDLE_KEY_DESC");
                MusicGeneQQBrowserActivity.this.I2(intent.getStringExtra("BUDNLE_KEY_IMG_URL"), intent.getStringExtra("BUNDLE_KEY_SRC"), "", stringExtra2, stringExtra, intent.getStringExtra("BUNDLE_KEY_ICON_URL"), 1101244924L);
                return;
            }
            if ("BROAD_CAST_SHARE_SONG".equals(action)) {
                String stringExtra3 = intent.getStringExtra("BUNDLE_KEY_TITLE");
                String stringExtra4 = intent.getStringExtra("BUNDLE_KEY_DESC");
                MusicGeneQQBrowserActivity.this.I2(intent.getStringExtra("BUDNLE_KEY_IMG_URL"), intent.getStringExtra("BUNDLE_KEY_SRC"), intent.getStringExtra("BUNDLE_KEY_AUDIO_URL"), stringExtra4, stringExtra3, intent.getStringExtra("BUNDLE_KEY_ICON_URL"), 1101244924L);
                return;
            }
            "BROAD_CAST_UPDATE_TITLE".equals(action);
        }
    }

    public MusicGeneQQBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251885a0 = new a();
            this.mFragmentClass = MusicGeneQQBrowserFragment.class;
        }
    }

    private void H2() {
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            if (currentWebViewFragment.getWebView() != null && currentWebViewFragment.getWebView().canGoBack()) {
                currentWebViewFragment.getWebView().goBack();
                return;
            } else {
                finish();
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(String str, String str2, String str3, String str4, String str5, String str6, long j3) {
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForAudioShare.class).g(2).d(HardCodeUtil.qqStr(R.string.oca)).a();
        a16.mContentSrc = str3;
        a16.mContentTitle = str5;
        a16.mContentCover = str;
        a16.mContentSummary = str4;
        a16.mMsgUrl = str2;
        a16.mSourceName = "QQ\u97f3\u4e50";
        a16.mSourceAction = "app";
        a16.mSourceAppid = j3;
        com.tencent.mobileqq.structmsg.a c16 = h.c(2);
        c16.o(str, str5, str4);
        a16.addItem(c16);
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 11);
        if (!TextUtils.isEmpty(str3)) {
            bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 2);
        } else {
            bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        }
        bundle.putString("app_name", HardCodeUtil.qqStr(R.string.oc_));
        bundle.putString("detail_url", a16.mMsgUrl);
        bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, a16.mContentSrc);
        bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, a16.mContentCover);
        bundle.putString("title", a16.mContentTitle);
        bundle.putString("desc", a16.mContentSummary);
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, a16.mSourceIcon);
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, a16.mSourceAction);
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, a16.mSource_A_ActionData);
        bundle.putLong("req_share_id", a16.mSourceAppid);
        bundle.putString(AppConstants.Key.SHARE_BRIEF, a16.mMsgBrief);
        bundle.putBoolean("k_send", false);
        bundle.putBoolean("k_qzone", false);
        bundle.putBoolean("k_favorites", false);
        bundle.putBoolean("k_dataline", false);
        Intent intent = new Intent();
        intent.putExtra("refuse_show_share_result_dialog", true);
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivity(this, intent);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            H2();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            super.doOnStart();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("BROAD_CAST_SHARE_MUSIC_GENE");
            intentFilter.addAction("BROAD_CAST_SHARE_SONG");
            intentFilter.addAction("BROAD_CAST_UPDATE_TITLE");
            registerReceiver(this.f251885a0, intentFilter, "com.tencent.music.data.permission", null);
        } catch (Exception e16) {
            QLog.e("MusicGeneQQBrowserActivity", 1, "doOnStart() exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            unregisterReceiver(this.f251885a0);
            super.doOnStop();
        } catch (Exception e16) {
            QLog.e("MusicGeneQQBrowserActivity", 1, "doOnStop() exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, android.app.Activity
    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }
}
