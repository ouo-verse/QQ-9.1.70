package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.listitem.QUIDoubleLineListItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SoundAndVibrateActivity extends IphoneTitleBarActivity implements MessageNotificationSettingManager.c {
    static IPatchRedirector $redirector_;
    private static String E0;
    static String F0;
    public static int G0;
    public static int H0;
    public static String I0;
    private FormSwitchItem A0;
    private FormSwitchItem B0;
    private QUIDoubleLineListItem C0;
    private com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> D0;

    /* renamed from: a0, reason: collision with root package name */
    View f177080a0;

    /* renamed from: b0, reason: collision with root package name */
    private FormSimpleItem f177081b0;

    /* renamed from: c0, reason: collision with root package name */
    private FormSimpleItem f177082c0;

    /* renamed from: d0, reason: collision with root package name */
    private FormSimpleItem f177083d0;

    /* renamed from: e0, reason: collision with root package name */
    private FormSimpleItem f177084e0;

    /* renamed from: f0, reason: collision with root package name */
    private FormSwitchItem f177085f0;

    /* renamed from: g0, reason: collision with root package name */
    private FormSwitchItem f177086g0;

    /* renamed from: h0, reason: collision with root package name */
    private FormSimpleItem f177087h0;

    /* renamed from: i0, reason: collision with root package name */
    private MediaPlayer f177088i0;

    /* renamed from: j0, reason: collision with root package name */
    FormSwitchItem f177089j0;

    /* renamed from: k0, reason: collision with root package name */
    FormSwitchItem f177090k0;

    /* renamed from: l0, reason: collision with root package name */
    FormSimpleItem f177091l0;

    /* renamed from: m0, reason: collision with root package name */
    private FormSwitchItem f177092m0;

    /* renamed from: n0, reason: collision with root package name */
    private FormSimpleItem f177093n0;

    /* renamed from: o0, reason: collision with root package name */
    private FormSimpleItem f177094o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f177095p0;

    /* renamed from: q0, reason: collision with root package name */
    private HashMap<Integer, r> f177096q0;

    /* renamed from: r0, reason: collision with root package name */
    private final int f177097r0;

    /* renamed from: s0, reason: collision with root package name */
    private final int f177098s0;

    /* renamed from: t0, reason: collision with root package name */
    private final int f177099t0;

    /* renamed from: u0, reason: collision with root package name */
    private final int f177100u0;

    /* renamed from: v0, reason: collision with root package name */
    private final int f177101v0;

    /* renamed from: w0, reason: collision with root package name */
    private final int f177102w0;

    /* renamed from: x0, reason: collision with root package name */
    private FormSwitchItem f177103x0;

    /* renamed from: y0, reason: collision with root package name */
    float f177104y0;

    /* renamed from: z0, reason: collision with root package name */
    MessageNotificationSettingManager f177105z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (z16) {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingVibrate(SoundAndVibrateActivity.this.app, 1);
                } else {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingVibrate(SoundAndVibrateActivity.this.app, 0);
                }
                ReportController.o(SoundAndVibrateActivity.this.app, "CliOper", "", "", "Setting_tab", "Clk_notice_grpshake", 0, z16 ? 1 : 0, "", "", "", "");
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_group_vibration_switch", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SoundAndVibrateActivity.this.l3(QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SoundAndVibrateActivity.this.l3(QQNotificationManager.CHANNEL_ID_GROUP_MSG);
                ReportController.o(null, "CliOper", "", "", "0X800AC8A", "0X800AC8A", 0, 0, "", "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f177109d;

        d(SharedPreferences sharedPreferences) {
            this.f177109d = sharedPreferences;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this, (Object) sharedPreferences);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                SharedPreferences.Editor edit = this.f177109d.edit();
                edit.putBoolean("theme_voice_setting_" + SoundAndVibrateActivity.this.app.getCurrentAccountUin(), z16);
                edit.commit();
                ReportController.o(SoundAndVibrateActivity.this.app, "CliOper", "", "", "ThemeSound", "SwitchTabSound", 0, z16 ? 1 : 0, "", "", "", "");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 4, 0, "", "", "", "");
                VasWebviewUtil.reportCommercialDrainage(SoundAndVibrateActivity.this.app.getCurrentAccountUin(), "bell", "click", "", 1, 0, 0, "", "", "");
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_prompt_tone", null);
                Intent intent = new Intent(SoundAndVibrateActivity.this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl(IndividuationUrlHelper.UrlId.SPECIALCARE_MALL_URL).replace("[uid]", "").replace("[lType]", "1"));
                SoundAndVibrateActivity.this.startActivity(intent);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SoundAndVibrateActivity.this.Z2(z16);
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_pay_special_attention_beep", Boolean.valueOf(z16));
            } else {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SoundAndVibrateActivity.this.Z2(z16);
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_pay_special_attention_beep", Boolean.valueOf(z16));
            } else {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h extends ClickableSpan {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SoundAndVibrateActivity.this.Y2();
                com.tencent.mobileqq.utils.ff.T(SoundAndVibrateActivity.this.app, "Vip_SpecialCare", "0X80049EE", "0X80049EE", 0, 1, null);
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_special_attention_friend_settings", null);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) textPaint);
            } else {
                textPaint.setUnderlineText(false);
                textPaint.setColor(SoundAndVibrateActivity.this.getResources().getColor(R.color.skin_blue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements com.tencent.mobileqq.widget.bf {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f177115a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f177116b;

        i(int i3, boolean z16) {
            this.f177115a = i3;
            this.f177116b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SoundAndVibrateActivity.this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void a(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void b(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void c(View view, int i3, int i16, int i17, int i18) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            int i19 = this.f177115a / 2;
            if (i16 <= 0) {
                f16 = 0.0f;
            } else if (i16 < i19) {
                f16 = (i16 * 1.0f) / i19;
            } else {
                f16 = 1.0f;
            }
            if (this.f177116b) {
                SoundAndVibrateActivity.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                SoundAndVibrateActivity.this.quiSecNavBar.setTitleAlpha(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void d(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SoundAndVibrateActivity.this.p3(0);
                SoundAndVibrateActivity soundAndVibrateActivity = SoundAndVibrateActivity.this;
                SettingCloneUtil.writeValueForInt(soundAndVibrateActivity, soundAndVibrateActivity.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, R.raw.f169334j);
                if (SoundAndVibrateActivity.this.W2().booleanValue()) {
                    SoundAndVibrateActivity.this.j3();
                    SoundAndVibrateActivity.this.i3(Uri.parse("android.resource://" + SoundAndVibrateActivity.this.getApplicationContext().getPackageName() + "/" + R.raw.f169334j));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SoundAndVibrateActivity.this.p3(1);
                SoundAndVibrateActivity soundAndVibrateActivity = SoundAndVibrateActivity.this;
                SettingCloneUtil.writeValueForInt(soundAndVibrateActivity, soundAndVibrateActivity.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, R.raw.f169398k);
                if (SoundAndVibrateActivity.this.W2().booleanValue()) {
                    SoundAndVibrateActivity.this.j3();
                    SoundAndVibrateActivity.this.i3(Uri.parse("android.resource://" + SoundAndVibrateActivity.this.getApplicationContext().getPackageName() + "/" + R.raw.f169398k));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SoundAndVibrateActivity.this.p3(2);
                SoundAndVibrateActivity soundAndVibrateActivity = SoundAndVibrateActivity.this;
                SettingCloneUtil.writeValueForInt(soundAndVibrateActivity, soundAndVibrateActivity.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, SoundAndVibrateActivity.G0);
                if (SoundAndVibrateActivity.this.W2().booleanValue()) {
                    Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
                    SoundAndVibrateActivity.this.j3();
                    SoundAndVibrateActivity.this.i3(uri);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SoundAndVibrateActivity.this.p3(3);
                SoundAndVibrateActivity soundAndVibrateActivity = SoundAndVibrateActivity.this;
                SettingCloneUtil.writeValueForInt(soundAndVibrateActivity, soundAndVibrateActivity.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, SoundAndVibrateActivity.H0);
                if (SoundAndVibrateActivity.this.W2().booleanValue()) {
                    SoundAndVibrateActivity.this.j3();
                    String themeVoiceRootPath = ThemeUtil.getThemeVoiceRootPath();
                    if (themeVoiceRootPath != null) {
                        File file = new File(themeVoiceRootPath + File.separatorChar + "message.mp3");
                        if (file.exists()) {
                            SoundAndVibrateActivity.this.j3();
                            SoundAndVibrateActivity.this.i3(Uri.fromFile(file));
                        }
                    }
                    SoundAndVibrateActivity.this.j3();
                    SoundAndVibrateActivity.this.i3(Uri.parse("android.resource://" + SoundAndVibrateActivity.this.getApplicationContext().getPackageName() + "/" + R.raw.f169398k));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            byte b16;
            ThemeUtil.ThemeInfo themeInfo;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                SoundAndVibrateActivity soundAndVibrateActivity = SoundAndVibrateActivity.this;
                int readValueForInt = SettingCloneUtil.readValueForInt(soundAndVibrateActivity, soundAndVibrateActivity.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, SoundAndVibrateActivity.H0);
                if (z16) {
                    SoundAndVibrateActivity.this.f177089j0.setClickable(true);
                    if (SoundAndVibrateActivity.this.f177089j0.getVisibility() != 0) {
                        com.tencent.qqnt.notification.report.h.B(SoundAndVibrateActivity.E0, "em_bas_group_sound_switch", Boolean.valueOf(SoundAndVibrateActivity.this.f177089j0.isChecked()));
                    }
                    SoundAndVibrateActivity.this.f177089j0.setVisibility(0);
                    if (SoundAndVibrateActivity.this.f177093n0.getVisibility() != 0) {
                        com.tencent.qqnt.notification.report.h.B(SoundAndVibrateActivity.E0, "em_bas_prompt_tone", null);
                    }
                    SoundAndVibrateActivity.this.f177093n0.setVisibility(0);
                    VasWebviewUtil.reportCommercialDrainage(SoundAndVibrateActivity.this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
                    SoundAndVibrateActivity.this.f177085f0.setBgType(1);
                    String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(SoundAndVibrateActivity.this.app);
                    if (!userCurrentThemeId.equals("1000") && (themeInfo = ThemeUtil.getThemeInfo(SoundAndVibrateActivity.this, userCurrentThemeId)) != null && themeInfo.isVoiceTheme) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    if (b16 != false) {
                        SoundAndVibrateActivity.this.f177103x0.setBackgroundResource(R.drawable.common_strip_setting_bg);
                        SoundAndVibrateActivity.this.f177103x0.setVisibility(0);
                    }
                    if (readValueForInt == R.raw.f169334j) {
                        SoundAndVibrateActivity.this.f177081b0.setRightIcon(SoundAndVibrateActivity.this.getResources().getDrawable(R.drawable.hb8));
                        SoundAndVibrateActivity.this.f177082c0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177083d0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177084e0.setRightIcon(null);
                        SoundAndVibrateActivity.this.r3(0);
                        if (AppSetting.f99565y) {
                            SoundAndVibrateActivity.this.f177081b0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173158ho3) + SoundAndVibrateActivity.this.getString(R.string.f170750a34));
                            SoundAndVibrateActivity.this.f177082c0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173159ho4) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177083d0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho5) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177084e0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho6) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                        }
                    } else if (readValueForInt == R.raw.f169398k) {
                        SoundAndVibrateActivity.this.f177081b0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177082c0.setRightIcon(SoundAndVibrateActivity.this.getResources().getDrawable(R.drawable.hb8));
                        SoundAndVibrateActivity.this.f177083d0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177084e0.setRightIcon(null);
                        SoundAndVibrateActivity.this.r3(1);
                        if (AppSetting.f99565y) {
                            SoundAndVibrateActivity.this.f177081b0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173158ho3) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177082c0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173159ho4) + SoundAndVibrateActivity.this.getString(R.string.f170750a34));
                            SoundAndVibrateActivity.this.f177083d0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho5) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177084e0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho6) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                        }
                    } else if (readValueForInt == SoundAndVibrateActivity.G0) {
                        SoundAndVibrateActivity.this.f177081b0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177082c0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177083d0.setRightIcon(SoundAndVibrateActivity.this.getResources().getDrawable(R.drawable.hb8));
                        SoundAndVibrateActivity.this.f177084e0.setRightIcon(null);
                        SoundAndVibrateActivity.this.r3(2);
                        if (AppSetting.f99565y) {
                            SoundAndVibrateActivity.this.f177081b0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173158ho3) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177082c0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173159ho4) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177083d0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho5) + SoundAndVibrateActivity.this.getString(R.string.f170750a34));
                            SoundAndVibrateActivity.this.f177084e0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho6) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                        }
                    } else if (readValueForInt == SoundAndVibrateActivity.H0) {
                        SoundAndVibrateActivity.this.f177081b0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177082c0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177083d0.setRightIcon(null);
                        SoundAndVibrateActivity.this.f177084e0.setRightIcon(SoundAndVibrateActivity.this.getResources().getDrawable(R.drawable.hb8));
                        SoundAndVibrateActivity.this.r3(3);
                        if (AppSetting.f99565y) {
                            SoundAndVibrateActivity.this.f177081b0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173158ho3) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177082c0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.f173159ho4) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177083d0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho5) + SoundAndVibrateActivity.this.getString(R.string.i_z));
                            SoundAndVibrateActivity.this.f177084e0.setContentDescription(SoundAndVibrateActivity.this.getString(R.string.ho6) + SoundAndVibrateActivity.this.getString(R.string.f170750a34));
                        }
                    }
                    if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(SoundAndVibrateActivity.this.app) == 0) {
                        SoundAndVibrateActivity.this.f177089j0.setChecked(false);
                    } else {
                        SoundAndVibrateActivity.this.f177089j0.setChecked(true);
                    }
                    SoundAndVibrateActivity.this.app.setALLGeneralSettingRing(1);
                    SoundAndVibrateActivity.this.f177092m0.setChecked(true);
                } else {
                    SoundAndVibrateActivity.this.f177085f0.setBgType(0);
                    SoundAndVibrateActivity.this.f177089j0.setVisibility(8);
                    SoundAndVibrateActivity.this.f177093n0.setVisibility(8);
                    SoundAndVibrateActivity.this.f177103x0.setVisibility(8);
                    SoundAndVibrateActivity.this.f177103x0.setBackgroundResource(R.drawable.common_strip_setting_bg);
                    SoundAndVibrateActivity.this.f177103x0.setVisibility(8);
                    SoundAndVibrateActivity.this.app.setALLGeneralSettingRing(0);
                }
                ReportController.o(SoundAndVibrateActivity.this.app, "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, z16 ? 1 : 0, "", "", "", "");
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_sound_tips", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (z16) {
                    SoundAndVibrateActivity.this.n3(0);
                    SoundAndVibrateActivity.this.f177086g0.setBgType(2);
                    if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(SoundAndVibrateActivity.this.app) == 0) {
                        SoundAndVibrateActivity.this.f177090k0.setChecked(false);
                    } else {
                        SoundAndVibrateActivity.this.f177090k0.setChecked(true);
                    }
                    SoundAndVibrateActivity.this.app.setALLGeneralSettingVibrate(1);
                } else {
                    SoundAndVibrateActivity.this.n3(8);
                    SoundAndVibrateActivity.this.f177086g0.setBgType(3);
                    SoundAndVibrateActivity.this.app.setALLGeneralSettingVibrate(0);
                }
                ReportController.o(SoundAndVibrateActivity.this.app, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, z16 ? 1 : 0, "", "", "", "");
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_vibrating_switch", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_ring_tone", null);
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(view.getContext(), com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl("call"), IVipTraceDetailReport.FROM.FUN_CALL_SETTING));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoundAndVibrateActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (z16) {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingRing(SoundAndVibrateActivity.this.app, 1);
                } else {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingRing(SoundAndVibrateActivity.this.app, 0);
                }
                ReportController.o(SoundAndVibrateActivity.this.app, "CliOper", "", "", "Setting_tab", "Clk_notice_gupsound", 0, z16 ? 1 : 0, "", "", "", "");
                com.tencent.qqnt.notification.report.h.w(SoundAndVibrateActivity.E0, "em_bas_group_sound_switch", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f177126a;

        /* renamed from: b, reason: collision with root package name */
        String f177127b;

        /* renamed from: c, reason: collision with root package name */
        boolean f177128c;

        r(int i3, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SoundAndVibrateActivity.this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
                return;
            }
            this.f177126a = i3;
            this.f177127b = str;
            this.f177128c = z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        E0 = "pg_bas_message_reminder_settings";
        F0 = "setting_search_title";
        G0 = AppSetting.P;
        H0 = AppSetting.Q;
        I0 = "user_choose_";
    }

    public SoundAndVibrateActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177096q0 = new HashMap<>();
        this.f177097r0 = 1;
        this.f177098s0 = 0;
        this.f177099t0 = 1;
        this.f177100u0 = 2;
        this.f177101v0 = 3;
        this.f177102w0 = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2() {
        startActivity(new Intent(getActivity(), (Class<?>) SpecailCareListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(boolean z16) {
        if (z16) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(this.app, 1);
            if (AppSetting.f99565y) {
                this.f177092m0.getSwitch().setContentDescription(getString(R.string.hox));
            }
            com.tencent.mobileqq.utils.ff.T(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
            return;
        }
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(this.app, 2);
        if (AppSetting.f99565y) {
            this.f177092m0.getSwitch().setContentDescription(getString(R.string.how));
        }
        com.tencent.mobileqq.utils.ff.T(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
    }

    private void c3() {
        r rVar = new r(0, getResources().getString(R.string.f173158ho3), false);
        r rVar2 = new r(1, getResources().getString(R.string.f173159ho4), false);
        r rVar3 = new r(2, getResources().getString(R.string.ho5), false);
        r rVar4 = new r(3, getResources().getString(R.string.ho6), false);
        r rVar5 = new r(R.id.fgb, getResources().getString(R.string.f170647xd), false);
        this.f177096q0.put(0, rVar);
        this.f177096q0.put(1, rVar2);
        this.f177096q0.put(2, rVar3);
        this.f177096q0.put(3, rVar4);
        this.f177096q0.put(4, rVar5);
    }

    private void d3() {
        this.A0 = (FormSwitchItem) findViewById(R.id.iss);
        this.B0 = (FormSwitchItem) findViewById(R.id.egr);
        this.A0.setVisibility(8);
        this.B0.setVisibility(8);
    }

    private void e3() {
        this.f177092m0 = (FormSwitchItem) findViewById(R.id.izo);
        boolean z16 = false;
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app) == 0) {
            FormSwitchItem formSwitchItem = this.f177092m0;
            if (this.app.getALLGeneralSettingRing() != 0) {
                z16 = true;
            }
            formSwitchItem.setChecked(z16);
        } else {
            FormSwitchItem formSwitchItem2 = this.f177092m0;
            if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app) == 1) {
                z16 = true;
            }
            formSwitchItem2.setChecked(z16);
        }
        if (AppSetting.f99565y) {
            if (this.f177092m0.isChecked()) {
                this.f177092m0.getSwitch().setContentDescription(getString(R.string.hox));
            } else {
                this.f177092m0.getSwitch().setContentDescription(getString(R.string.how));
            }
        }
        this.f177092m0.setOnCheckedChangeListener(new g());
    }

    private void f3(TextView textView) {
        String string = getResources().getString(R.string.hib);
        int currentTextColor = textView.getCurrentTextColor();
        String str = ((Object) textView.getText()) + string;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new h(), str.length() - string.length(), str.length(), 17);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        textView.setClickable(false);
        textView.setTextColor(currentTextColor);
    }

    public static boolean g3() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (!(waitAppRuntime instanceof QQAppInterface) || ((QQAppInterface) waitAppRuntime).getALLGeneralSettingRing() == 0) {
            return false;
        }
        return true;
    }

    public static boolean h3() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (!(waitAppRuntime instanceof QQAppInterface) || ((QQAppInterface) waitAppRuntime).getALLGeneralSettingRing() == 0) {
            return false;
        }
        return true;
    }

    private void initBlur() {
        BounceScrollView bounceScrollView;
        if (!needBlur() || this.quiSecNavBar == null) {
            return;
        }
        View view = this.mContentView;
        if (!(view instanceof BounceScrollView)) {
            return;
        }
        BounceScrollView bounceScrollView2 = (BounceScrollView) view;
        int b16 = com.tencent.biz.qui.quisecnavbar.e.b(bounceScrollView2.getContext());
        bounceScrollView2.setPadding(0, b16, 0, 0);
        bounceScrollView2.setClipToPadding(false);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (isSettingPageNavNeedBlur) {
            bounceScrollView = bounceScrollView2;
        } else {
            bounceScrollView = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, bounceScrollView);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        bounceScrollView2.setScrollListener(new i(b16, isSettingPageNavNeedBlur));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", str);
                startActivity(intent);
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarActivity", 2, "go to channel setting  notificationChannelId: " + str);
                }
                com.tencent.qqnt.notification.report.h.w(E0, "em_bas_vibrating_switch", null);
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", getPackageName(), null));
                    startActivity(intent2);
                    if (QLog.isColorLevel()) {
                        QLog.d("IphoneTitleBarActivity", 2, "go to system setting");
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    QLog.e("IphoneTitleBarActivity", 2, "go to setting fail");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(int i3) {
        if (Build.VERSION.SDK_INT <= 28 && i3 == 0) {
            ViewUtils.setVisible(this.f177090k0, 0);
            FormSwitchItem formSwitchItem = this.f177086g0;
            if (formSwitchItem != null) {
                formSwitchItem.setBgType(2);
                return;
            }
            return;
        }
        ViewUtils.setVisible(this.f177090k0, 8);
        FormSwitchItem formSwitchItem2 = this.f177086g0;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setBgType(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(int i3) {
        for (r rVar : this.f177096q0.values()) {
            if (rVar.f177126a == i3) {
                rVar.f177128c = true;
                this.f177105z0.W(this.f177093n0, this.f177105z0.q());
            } else {
                rVar.f177128c = false;
            }
        }
    }

    Boolean W2() {
        if (!this.app.isRingerVibrate() && !this.app.isRingEqualsZero() && this.app.isCallIdle()) {
            this.app.getCheckPttListener();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void b3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QUIDoubleLineListItem qUIDoubleLineListItem = (QUIDoubleLineListItem) findViewById(R.id.yjk);
        this.C0 = qUIDoubleLineListItem;
        qUIDoubleLineListItem.setBackgroundType(QUIListItemBackgroundType.NoneRound);
        if (!ElderModeManager.j() && !FontSettingManager.isFontSizeLarge()) {
            this.C0.setStyle(QUIListItemStyle.Card);
        } else {
            this.C0.setStyle(QUIListItemStyle.FullWidth);
        }
        boolean z16 = true;
        QLog.i("qqls", 1, "initLineListSpecialFriendItem:" + ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isNowThemeIsNight() + ": switch: " + ElderModeManager.j() + ": size:" + FontSettingManager.isFontSizeLarge());
        if (((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isNowThemeIsNight() && (ElderModeManager.j() || FontSettingManager.isFontSizeLarge())) {
            QLog.i("qqls", 1, "initLineListSpecialFriendItem in:" + ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isNowThemeIsNight() + ": switch: " + ElderModeManager.j() + ": size:" + FontSettingManager.isFontSizeLarge());
            this.C0.setBackgroundType(QUIListItemBackgroundType.None);
            this.C0.setBackground(com.tencent.mobileqq.widget.o.h(getResources(), 2, true, true));
        }
        this.D0 = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.f("\u7279\u522b\u5173\u5fc3\u63d0\u793a\u97f3", "\u7279\u522b\u5173\u5fc3\u7684\u597d\u53cb\u6d88\u606f\u5c06\u6709\u4e2a\u6027\u5316\u63d0\u793a\u97f3"), new c.b.C8994b(false, null, true));
        this.C0.setFocusable(true);
        AccessibilityUtil.s(this.C0, "\u7279\u522b\u5173\u5fc3\u63d0\u793a\u97f3, \u7279\u522b\u5173\u5fc3\u7684\u597d\u53cb\u6d88\u606f\u5c06\u6709\u4e2a\u6027\u5316\u63d0\u793a\u97f3");
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app) == 0) {
            c.b.C8994b O = this.D0.O();
            if (this.app.getALLGeneralSettingRing() == 0) {
                z16 = false;
            }
            O.e(z16);
        } else {
            c.b.C8994b O2 = this.D0.O();
            if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app) != 1) {
                z16 = false;
            }
            O2.e(z16);
        }
        com.tencent.qqnt.notification.report.h.B(E0, "em_bas_pay_special_attention_beep", Boolean.valueOf(this.D0.O().getIsChecked()));
        this.D0.O().f(new f());
        this.C0.setConfig(this.D0.K(), this.D0.O());
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.byz);
        setTitle(getString(R.string.f226506oi));
        s3();
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.app);
        this.f177105z0 = l3;
        l3.V(this);
        initUI();
        initBlur();
        com.tencent.qqnt.notification.report.h.o(E0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        j3();
        MediaPlayer mediaPlayer = this.f177088i0;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f177088i0 = null;
        }
        this.f177105z0.P(this);
        com.tencent.qqnt.notification.report.h.s(E0);
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnResume();
        this.f177105z0.W(this.f177093n0, this.f177105z0.q());
        QQAppInterface qQAppInterface = this.app;
        this.f177094o0.setRightText(VipFunCallUtil.getFunCallName(this.app, VipFunCallUtil.getResIdByUin(qQAppInterface, qQAppInterface.getAccount(), 6, false, this.app.getAccount())));
    }

    void i3(Uri uri) {
        Throwable th5;
        FileInputStream fileInputStream;
        MediaPlayer mediaPlayer;
        if (this.f177088i0 == null) {
            this.f177088i0 = new ReportMediaPlayer();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                mediaPlayer = this.f177088i0;
            } catch (Exception unused) {
            } catch (Throwable th6) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th5 = th6;
                fileInputStream = fileInputStream3;
            }
            if (mediaPlayer == null) {
                return;
            }
            mediaPlayer.reset();
            if (uri.getScheme().equals("file")) {
                fileInputStream = new FileInputStream(new File(uri.getPath()));
                try {
                    this.f177088i0.setDataSource(fileInputStream.getFD());
                    this.f177088i0.setAudioStreamType(3);
                    this.f177088i0.prepare();
                    fileInputStream.close();
                    fileInputStream2 = fileInputStream;
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return;
                } catch (Throwable th7) {
                    th5 = th7;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } else {
                this.f177088i0.setDataSource(this, uri);
                this.f177088i0.setAudioStreamType(3);
                this.f177088i0.prepare();
            }
            this.f177088i0.start();
            this.f177088i0.setLooping(false);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public void initUI() {
        int i3;
        boolean z16;
        ThemeUtil.ThemeInfo themeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f177104y0 = getResources().getDisplayMetrics().density;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
        int aLLGeneralSettingRing = this.app.getALLGeneralSettingRing();
        int aLLGeneralSettingVibrate = this.app.getALLGeneralSettingVibrate();
        this.f177085f0 = (FormSwitchItem) findViewById(R.id.iyt);
        this.f177086g0 = (FormSwitchItem) findViewById(R.id.kom);
        this.f177089j0 = (FormSwitchItem) findViewById(R.id.cxd);
        this.f177090k0 = (FormSwitchItem) findViewById(R.id.cxe);
        this.f177087h0 = (FormSimpleItem) findViewById(R.id.f165305lj3);
        this.f177091l0 = (FormSimpleItem) findViewById(R.id.vgg);
        this.f177085f0.setText("\u6d88\u606f\u63d0\u793a\u97f3");
        this.f177089j0.setText("\u7fa4\u6d88\u606f\u63d0\u793a\u97f3");
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f177085f0.getLayoutParams();
        layoutParams.topMargin = 30;
        this.f177085f0.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT <= 28) {
            ViewUtils.setVisible(this.f177086g0, 0);
            ViewUtils.setVisible(this.f177090k0, 0);
            ViewUtils.setVisible(this.f177087h0, 8);
            ViewUtils.setVisible(this.f177091l0, 8);
            ((FormSimpleItem) findViewById(R.id.iyu)).setBgType(2);
        } else {
            ViewUtils.setVisible(this.f177086g0, 8);
            ViewUtils.setVisible(this.f177090k0, 8);
            ViewUtils.setVisible(this.f177087h0, 0);
            this.f177087h0.setBgType(0);
        }
        this.f177092m0 = (FormSwitchItem) findViewById(R.id.izo);
        this.f177093n0 = (FormSimpleItem) findViewById(R.id.iyu);
        this.f177094o0 = (FormSimpleItem) findViewById(R.id.f86964t3);
        com.tencent.qqnt.notification.report.h.B(E0, "em_bas_ring_tone", null);
        if (this.f177085f0.isChecked()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (i3 == 0) {
            com.tencent.qqnt.notification.report.h.B(E0, "em_bas_prompt_tone", null);
        }
        this.f177093n0.setVisibility(i3);
        d3();
        if (AppSetting.f99565y) {
            this.f177086g0.setContentDescription(getString(R.string.ic6));
            this.f177090k0.setContentDescription(getString(R.string.boa));
            this.f177085f0.setContentDescription(getString(R.string.f173157ho1));
            this.f177089j0.setContentDescription(getString(R.string.bo6));
        }
        this.f177080a0 = findViewById(R.id.f166897iz3);
        this.f177081b0 = (FormSimpleItem) findViewById(R.id.kfy);
        this.f177082c0 = (FormSimpleItem) findViewById(R.id.kfx);
        this.f177083d0 = (FormSimpleItem) findViewById(R.id.kfz);
        c3();
        this.f177084e0 = (FormSimpleItem) findViewById(R.id.f167072kg0);
        this.f177103x0 = (FormSwitchItem) findViewById(R.id.iys);
        if (aLLGeneralSettingVibrate != 0) {
            this.f177086g0.setChecked(true);
            n3(0);
            int troopGeneralSettingVibrate = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this.app);
            if (QLog.isColorLevel()) {
                QLog.d("SoundSetting", 2, "canVibratorGroup :" + troopGeneralSettingVibrate);
            }
            if (troopGeneralSettingVibrate == 0) {
                this.f177090k0.setChecked(false);
            } else {
                this.f177090k0.setChecked(true);
            }
        } else {
            this.f177086g0.setChecked(false);
            n3(8);
        }
        if (aLLGeneralSettingRing != 0) {
            this.f177085f0.setChecked(true);
            this.f177089j0.setVisibility(0);
            int readValueForInt = SettingCloneUtil.readValueForInt(this, this.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, H0);
            if (!defaultSharedPreferences.getBoolean(I0 + this.app.getCurrentAccountUin(), false) && readValueForInt == H0) {
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putBoolean(I0 + this.app.getCurrentAccountUin(), true);
                edit.commit();
            }
            this.f177081b0.setRightIcon(null);
            this.f177082c0.setRightIcon(null);
            this.f177083d0.setRightIcon(null);
            this.f177084e0.setRightIcon(null);
            if (readValueForInt == R.raw.f169334j) {
                this.f177081b0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                r3(0);
                if (AppSetting.f99565y) {
                    this.f177081b0.setContentDescription(getString(R.string.f173158ho3) + getString(R.string.f170750a34));
                }
            } else if (readValueForInt == R.raw.f169398k) {
                this.f177082c0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                r3(1);
                if (AppSetting.f99565y) {
                    this.f177082c0.setContentDescription(getString(R.string.f173159ho4) + getString(R.string.f170750a34));
                }
            } else if (readValueForInt == G0) {
                this.f177083d0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                r3(2);
                if (AppSetting.f99565y) {
                    this.f177083d0.setContentDescription(getString(R.string.ho5) + getString(R.string.f170750a34));
                }
            } else if (readValueForInt == H0) {
                this.f177084e0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                r3(3);
                SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, H0);
            } else {
                this.f177082c0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                r3(1);
            }
            int troopGeneralSettingRing = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.app);
            if (QLog.isColorLevel()) {
                QLog.d("SoundSetting", 2, "canPlayGroupSound :" + troopGeneralSettingRing);
            }
            if (troopGeneralSettingRing == 0) {
                this.f177089j0.setChecked(false);
            } else {
                this.f177089j0.setChecked(true);
            }
            com.tencent.qqnt.notification.report.h.B(E0, "em_bas_group_sound_switch", Boolean.valueOf(this.f177089j0.isChecked()));
            String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(this.app);
            if (!userCurrentThemeId.equals("1000") && (themeInfo = ThemeUtil.getThemeInfo(this, userCurrentThemeId)) != null && themeInfo.isVoiceTheme) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (defaultSharedPreferences.getBoolean("theme_voice_setting_" + this.app.getCurrentAccountUin(), true)) {
                    this.f177103x0.setChecked(true);
                } else {
                    this.f177103x0.setChecked(false);
                }
            } else {
                this.f177103x0.setVisibility(8);
            }
        } else {
            this.f177085f0.setChecked(false);
            this.f177089j0.setVisibility(8);
            this.f177103x0.setVisibility(8);
            this.f177093n0.setVisibility(8);
        }
        this.f177081b0.setOnClickListener(new j());
        this.f177082c0.setOnClickListener(new k());
        this.f177083d0.setOnClickListener(new l());
        this.f177084e0.setOnClickListener(new m());
        if (this.f177085f0.isChecked()) {
            this.f177085f0.setBgType(1);
        } else {
            this.f177085f0.setBgType(0);
        }
        this.f177085f0.setOnCheckedChangeListener(new n());
        if (this.f177086g0.isChecked()) {
            this.f177086g0.setBgType(2);
        } else {
            this.f177086g0.setBgType(3);
        }
        this.f177086g0.setOnCheckedChangeListener(new o());
        this.f177094o0.setOnClickListener(new p());
        this.f177089j0.setOnCheckedChangeListener(new q());
        this.f177090k0.setOnCheckedChangeListener(new a());
        this.f177087h0.setOnClickListener(new b());
        this.f177091l0.setOnClickListener(new c());
        this.f177103x0.setOnCheckedChangeListener(new d(defaultSharedPreferences));
        TextView textView = (TextView) findViewById(R.id.izp);
        this.f177095p0 = textView;
        f3(textView);
        b3();
        this.f177095p0.setVisibility(8);
        this.f177086g0.setVisibility(8);
        this.f177090k0.setVisibility(8);
        this.f177087h0.setVisibility(8);
        this.f177091l0.setVisibility(8);
        this.f177093n0.setBgType(2);
        this.f177092m0.setBgType(2);
        this.f177092m0.setVisibility(8);
        this.C0.setVisibility(0);
        ((TextView) findViewById(R.id.f86954t2)).setVisibility(8);
        com.tencent.qqnt.notification.report.h.B(E0, "em_bas_sound_tips", Boolean.valueOf(this.f177085f0.isChecked()));
        findViewById(R.id.yjl);
        this.f177093n0.setOnClickListener(new e());
        if (this.f177093n0.getVisibility() == 0) {
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
        }
        e3();
    }

    void j3() {
        MediaPlayer mediaPlayer = this.f177088i0;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f177088i0.stop();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void p3(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.f177081b0.setRightIcon(null);
                        this.f177082c0.setRightIcon(null);
                        this.f177083d0.setRightIcon(null);
                        this.f177084e0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                        if (AppSetting.f99565y) {
                            this.f177081b0.setContentDescription(getString(R.string.f173158ho3) + getString(R.string.i_z));
                            this.f177082c0.setContentDescription(getString(R.string.f173159ho4) + getString(R.string.i_z));
                            this.f177083d0.setContentDescription(getString(R.string.ho5) + getString(R.string.i_z));
                            this.f177084e0.setContentDescription(getString(R.string.ho6) + getString(R.string.f170750a34));
                        }
                        ReportController.o(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
                        return;
                    }
                    return;
                }
                this.f177081b0.setRightIcon(null);
                this.f177082c0.setRightIcon(null);
                this.f177083d0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
                this.f177084e0.setRightIcon(null);
                if (AppSetting.f99565y) {
                    this.f177081b0.setContentDescription(getString(R.string.f173158ho3) + getString(R.string.i_z));
                    this.f177082c0.setContentDescription(getString(R.string.f173159ho4) + getString(R.string.i_z));
                    this.f177083d0.setContentDescription(getString(R.string.ho5) + getString(R.string.f170750a34));
                    this.f177084e0.setContentDescription(getString(R.string.ho6) + getString(R.string.i_z));
                }
                ReportController.o(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
                return;
            }
            this.f177081b0.setRightIcon(null);
            this.f177082c0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
            this.f177083d0.setRightIcon(null);
            this.f177084e0.setRightIcon(null);
            if (AppSetting.f99565y) {
                this.f177081b0.setContentDescription(getString(R.string.f173158ho3) + getString(R.string.i_z));
                this.f177082c0.setContentDescription(getString(R.string.f173159ho4) + getString(R.string.f170750a34));
                this.f177083d0.setContentDescription(getString(R.string.ho5) + getString(R.string.i_z));
                this.f177084e0.setContentDescription(getString(R.string.ho6) + getString(R.string.i_z));
            }
            ReportController.o(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
            return;
        }
        this.f177081b0.setRightIcon(getResources().getDrawable(R.drawable.hb8));
        this.f177082c0.setRightIcon(null);
        this.f177083d0.setRightIcon(null);
        this.f177084e0.setRightIcon(null);
        if (AppSetting.f99565y) {
            this.f177081b0.setContentDescription(getString(R.string.f173158ho3) + getString(R.string.f170750a34));
            this.f177082c0.setContentDescription(getString(R.string.f173159ho4) + getString(R.string.i_z));
            this.f177083d0.setContentDescription(getString(R.string.ho5) + getString(R.string.i_z));
            this.f177084e0.setContentDescription(getString(R.string.ho6) + getString(R.string.i_z));
        }
        ReportController.o(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
    }

    @Override // com.tencent.mobileqq.chat.MessageNotificationSettingManager.c
    public void r8(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f177105z0.W(this.f177093n0, i3);
        }
    }

    public void s3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            E0 = "pg_bas_audio";
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
