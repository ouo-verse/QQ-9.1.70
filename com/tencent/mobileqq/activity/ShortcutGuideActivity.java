package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ShortcutGuideActivity extends AppActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f177059a0;

    /* renamed from: b0, reason: collision with root package name */
    private BitmapDrawable f177060b0;

    /* renamed from: c0, reason: collision with root package name */
    String f177061c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f177062d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f177063e0;

    public ShortcutGuideActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177059a0 = false;
        this.f177061c0 = null;
        this.f177062d0 = null;
    }

    private Bitmap F2(boolean z16, String str) {
        AppRuntime appRuntime;
        Bitmap G2 = G2(z16, str);
        if (G2 == null && (appRuntime = getAppRuntime()) != null && (appRuntime instanceof QQAppInterface)) {
            G2 = ((QQAppInterface) appRuntime).getFaceBitmap(getIntent().getStringExtra("uin"), (byte) 3, true);
        }
        if (G2 != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.avp);
            Bitmap roundFaceBitmap = BaseImageUtil.getRoundFaceBitmap(G2, dimensionPixelSize, dimensionPixelSize);
            this.f177063e0 = true;
            return roundFaceBitmap;
        }
        return G2;
    }

    private Bitmap G2(boolean z16, String str) {
        String i3;
        if (z16) {
            i3 = QQAppInterface.getBuddyFaceFilePath(str);
        } else {
            i3 = QQUtils.i(str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return com.tencent.mobileqq.util.j.d(i3, options);
    }

    private Bitmap H2() {
        return BaseImageUtil.getRoundedCornerBitmap2(com.tencent.mobileqq.util.j.g(getResources(), R.drawable.f9h), 14.0f, 540, 620);
    }

    private boolean I2(Activity activity, MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(activity).getScaledWindowTouchSlop();
        View decorView = activity.getWindow().getDecorView();
        int i3 = -scaledWindowTouchSlop;
        if (x16 >= i3 && y16 >= i3 && x16 <= decorView.getWidth() + scaledWindowTouchSlop && y16 <= decorView.getHeight() + scaledWindowTouchSlop) {
            return false;
        }
        return true;
    }

    private void initView() {
        Bitmap F2;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("from");
        if (QLog.isColorLevel()) {
            QLog.d("ShortcutGuideActivity", 2, "showPreview from=" + stringExtra);
        }
        if (QZoneHelper.SHORT_CUT_FROM_QZONE_PHOTO_LIST.equals(stringExtra)) {
            return;
        }
        if (QZoneHelper.SHORT_CUT_FROM_QZONE_PHOTO_LIST.equals(stringExtra)) {
            findViewById(R.id.bja).setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("starShortcut")) {
            findViewById(R.id.gst).setVisibility(8);
            findViewById(R.id.gsw).setVisibility(8);
            F2 = F2(false, intent.getStringExtra("sid"));
        } else {
            findViewById(R.id.gst).setOnClickListener(this);
            findViewById(R.id.gsw).setOnClickListener(this);
            F2 = F2(true, intent.getStringExtra("uin"));
        }
        if (this.f177060b0 == null) {
            this.f177060b0 = new BitmapDrawable(H2());
        }
        findViewById(R.id.bja).setBackgroundDrawable(this.f177060b0);
        if (F2 != null) {
            ((ImageView) findViewById(R.id.gss)).setImageBitmap(F2);
        } else {
            ((ImageView) findViewById(R.id.gss)).setImageResource(R.drawable.icon);
        }
        String stringExtra2 = intent.getStringExtra("uinname");
        TextView textView = (TextView) findViewById(R.id.gsu);
        if (stringExtra2 != null) {
            textView.setText(stringExtra2);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("starShortcut")) {
                textView.setText(stringExtra2 + HardCodeUtil.qqStr(R.string.tga));
                textView.setTextSize(16.0f);
                ((TextView) findViewById(R.id.gsv)).setVisibility(8);
                ((TextView) findViewById(R.id.j1d)).setVisibility(0);
                TextView textView2 = (TextView) findViewById(R.id.j1e);
                String str = (String) textView2.getText();
                int indexOf = str.indexOf("TA");
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ahi)), indexOf, indexOf + 2, 17);
                textView2.setText(spannableStringBuilder);
                textView2.setVisibility(0);
            }
        }
        AppRuntime appRuntime = this.mRuntime;
        if (appRuntime != null && (appRuntime instanceof QQAppInterface) && QidianManager.P((QQAppInterface) appRuntime, intent.getStringExtra("uin"))) {
            findViewById(R.id.gsw).setVisibility(8);
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Bitmap F2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        try {
            this.f177061c0 = intent.getStringExtra("from");
            if (QLog.isColorLevel()) {
                QLog.d("ShortcutGuideActivity", 2, "doOnCreate from=" + this.f177061c0);
            }
            if (QQBrowserActivity.WEB_FLOAT_SHORTCUT_FROM.equals(this.f177061c0)) {
                if (!getAppRuntime().isLogin()) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("action_name", "webview");
                    intent2.putExtra("key_isReadModeEnabled", true);
                    intent2.putExtra("url", intent.getStringExtra("url"));
                    RouteUtils.startActivity(this, intent2, RouterConstants.UI_ROUTER_LOGIN);
                    finish();
                    return false;
                }
                Intent intent3 = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent3.putExtra("key_isReadModeEnabled", true);
                intent3.putExtra("url", intent.getStringExtra("url"));
                startActivity(intent3);
                finish();
                return true;
            }
            if (QZoneHelper.SHORT_CUT_FROM_QZONE_PHOTO_LIST.equals(this.f177061c0)) {
                if (!getAppRuntime().isLogin()) {
                    Intent intent4 = new Intent();
                    intent4.putExtra(QZoneHelper.Constants.KEY_FROM_ALBUM_SHORTCUT, true);
                    intent4.putExtras(intent);
                    RouteUtils.startActivity(this, intent4, RouterConstants.UI_ROUTER_LOGIN);
                    finish();
                    return true;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
                if (qQAppInterface != null) {
                    qQAppInterface.initFaceSettingCache();
                    qQAppInterface.registerHeadBroadcastReceiver();
                }
                QZoneHelper.goQZoneAlbumPhotoList(this, getIntent().getStringExtra("UploadPhoto.key_album_id"), getIntent().getLongExtra(QZoneHelper.Constants.KEY_ALBUM_OWNER_UID, 0L), String.valueOf(getAppRuntime().getLongAccountUin()));
                finish();
                return true;
            }
            if (!this.f177059a0 && !showPreview()) {
                finish();
                return false;
            }
            if (!this.f177063e0) {
                try {
                    if (!TextUtils.isEmpty(this.f177061c0) && this.f177061c0.equals("starShortcut")) {
                        F2 = F2(false, intent.getStringExtra("starId"));
                    } else {
                        F2 = F2(true, intent.getStringExtra("uin"));
                    }
                    if (F2 != null) {
                        ((ImageView) findViewById(R.id.gss)).setImageBitmap(F2);
                    } else {
                        ((ImageView) findViewById(R.id.gss)).setImageResource(R.drawable.icon);
                    }
                } catch (Throwable unused) {
                    finish();
                    return false;
                }
            }
            ReportController.o((QQAppInterface) this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_head", 0, 0, "", "", "", "");
            if (!TextUtils.isEmpty(this.f177061c0) && this.f177061c0.equals("starShortcut")) {
                intent.putExtra("shotcut_forward", ChatActivity.class.getName());
                intent.putExtra("forward", "starClub");
                intent.setClassName(this, ShortcutRouterActivity.class.getName());
                startActivity(intent);
                finish();
            }
            if (com.tencent.mobileqq.startup.a.f289664e > 0) {
                Log.d("AutoMonitor", "actStartShort, cost=" + (SystemClock.uptimeMillis() - com.tencent.mobileqq.startup.a.f289664e));
            }
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            finish();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        setIntent(intent);
        try {
            initView();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intent intent = getIntent();
            int id5 = view.getId();
            if (id5 == R.id.gst) {
                intent.putExtra("shotcut_forward", SplashActivity.getAliasName());
                BaseAIOUtils.m(intent, new int[]{2});
                ReportController.o((QQAppInterface) this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "0", "", "", "");
            } else if (id5 == R.id.gsw) {
                intent.putExtra("shotcut_forward", AVActivity.class.getName());
                ReportController.o((QQAppInterface) this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_call", 0, 0, "", "", "", "");
            }
            intent.setClassName(this, ShortcutRouterActivity.class.getName());
            startActivity(intent);
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0 && I2(this, motionEvent)) {
            finish();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            String stringExtra = getIntent().getStringExtra("from");
            if (QLog.isColorLevel()) {
                QLog.d("ShortcutGuideActivity", 2, "showPreview from=" + stringExtra);
            }
            if (QZoneHelper.SHORT_CUT_FROM_QZONE_PHOTO_LIST.equals(stringExtra)) {
                return true;
            }
            super.setContentView(R.layout.b2s);
            initView();
            this.f177059a0 = true;
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("ShortcutGuideActivity", 2, "create exception :" + th5.getMessage());
                return false;
            }
            return false;
        }
    }
}
