package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.ntcompat.TextPreviewNTFoldCompat;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.textpreview.TextPreviewBottomMenu;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IAIOConfigService;
import com.tencent.qqnt.textpreview.AbsTextPreviewActivity;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import com.tencent.qqnt.textpreview.api.IFontSettingApi;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
/* loaded from: classes9.dex */
public class TextPreviewActivity extends AbsTextPreviewActivity {
    static IPatchRedirector $redirector_;
    public static long E0;
    private LinearLayout A0;
    private final Runnable B0;
    CharSequence C0;
    private boolean D0;

    /* renamed from: a0, reason: collision with root package name */
    public int f177217a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f177218b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f177219c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f177220d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f177221e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f177222f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f177223g0;

    /* renamed from: h0, reason: collision with root package name */
    protected String f177224h0;

    /* renamed from: i0, reason: collision with root package name */
    protected String f177225i0;

    /* renamed from: j0, reason: collision with root package name */
    protected boolean f177226j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f177227k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f177228l0;

    /* renamed from: m0, reason: collision with root package name */
    public PreviewTextContainerView f177229m0;

    /* renamed from: n0, reason: collision with root package name */
    public ScrollView f177230n0;

    /* renamed from: o0, reason: collision with root package name */
    protected long f177231o0;

    /* renamed from: p0, reason: collision with root package name */
    protected MotionEvent f177232p0;

    /* renamed from: q0, reason: collision with root package name */
    protected Rect f177233q0;

    /* renamed from: r0, reason: collision with root package name */
    protected long f177234r0;

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.qqnt.textpreview.inject.c<TextPreviewActivity> f177235s0;

    /* renamed from: t0, reason: collision with root package name */
    private MergeForwardRevokeHelper f177236t0;

    /* renamed from: u0, reason: collision with root package name */
    public ParticipleView f177237u0;

    /* renamed from: v0, reason: collision with root package name */
    public ParticipleBottomMenuView f177238v0;

    /* renamed from: w0, reason: collision with root package name */
    public View f177239w0;

    /* renamed from: x0, reason: collision with root package name */
    private RelativeLayout f177240x0;

    /* renamed from: y0, reason: collision with root package name */
    private List<com.tencent.qqnt.textpreview.inject.b> f177241y0;

    /* renamed from: z0, reason: collision with root package name */
    private com.tencent.qqnt.textpreview.inject.e f177242z0;

    /* loaded from: classes9.dex */
    class a implements com.tencent.qqnt.textpreview.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextPreviewActivity.this);
            }
        }

        @Override // com.tencent.qqnt.textpreview.a
        public View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return TextPreviewActivity.this.f177239w0;
        }

        @Override // com.tencent.qqnt.textpreview.a
        public ParticipleBottomMenuView b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ParticipleBottomMenuView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return TextPreviewActivity.this.f177238v0;
        }

        @Override // com.tencent.qqnt.textpreview.a
        public View c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (View) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return TextPreviewActivity.this.f177230n0;
        }

        @Override // com.tencent.qqnt.textpreview.a
        public ParticipleView d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ParticipleView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return TextPreviewActivity.this.f177237u0;
        }

        @Override // com.tencent.qqnt.textpreview.a
        public View getContainerView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (View) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return TextPreviewActivity.this.f177229m0;
        }
    }

    /* loaded from: classes9.dex */
    private static final class b extends FlingGestureHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<TextPreviewActivity> f177244d;

        b(TextPreviewActivity textPreviewActivity) {
            super(textPreviewActivity);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) textPreviewActivity);
            } else {
                this.f177244d = new WeakReference<>(textPreviewActivity);
            }
        }

        @Override // com.tencent.mobileqq.activity.fling.FlingGestureHandler, com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingLToR() {
            ParticipleView participleView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TextPreviewActivity textPreviewActivity = this.f177244d.get();
            boolean z16 = false;
            if (textPreviewActivity != null && (participleView = textPreviewActivity.f177237u0) != null && participleView.getVisibility() == 0) {
                z16 = true;
            }
            if (!z16) {
                super.flingLToR();
            }
        }
    }

    public TextPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177217a0 = 0;
        this.f177218b0 = 1;
        this.f177219c0 = null;
        this.f177220d0 = null;
        this.f177222f0 = false;
        this.f177223g0 = null;
        this.f177226j0 = true;
        this.f177227k0 = -1;
        this.f177228l0 = null;
        this.f177231o0 = 0L;
        this.f177233q0 = null;
        this.f177234r0 = 0L;
        this.f177241y0 = com.tencent.qqnt.textpreview.inject.g.a().e();
        this.f177242z0 = com.tencent.qqnt.textpreview.inject.g.a().f();
        this.B0 = new Runnable() { // from class: com.tencent.mobileqq.activity.TextPreviewActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextPreviewActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                long j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!TextPreviewActivity.this.T2()) {
                    if (((IAIOConfigService) TextPreviewActivity.this.getAppRuntime().getRuntimeService(IAIOConfigService.class, "")).linkUseNewStyle()) {
                        TextPreviewActivity.this.f177229m0.h().setLinkTextColor(TextPreviewActivity.this.getColor(R.color.qui_common_text_link));
                    }
                    try {
                        j3 = Long.parseLong(TextPreviewActivity.this.f177219c0);
                    } catch (NumberFormatException unused) {
                        QLog.e("TextPreviewActivity", 1, "peeruin parse err " + TextPreviewActivity.this.f177219c0);
                        j3 = 0;
                    }
                    long j16 = j3;
                    com.tencent.qqnt.textpreview.inject.e eVar = TextPreviewActivity.this.f177242z0;
                    TextPreviewActivity textPreviewActivity = TextPreviewActivity.this;
                    TextPreviewActivity.this.f177229m0.h().setText(eVar.c(textPreviewActivity.f177224h0, textPreviewActivity.f177225i0, 61, j16, textPreviewActivity.f177218b0));
                }
                TextPreviewActivity textPreviewActivity2 = TextPreviewActivity.this;
                textPreviewActivity2.f177229m0.setAniStickerShowBig(textPreviewActivity2.f177226j0);
                TextPreviewActivity textPreviewActivity3 = TextPreviewActivity.this;
                textPreviewActivity3.f177229m0.setAniStickerLocID(textPreviewActivity3.f177227k0);
                TextPreviewActivity textPreviewActivity4 = TextPreviewActivity.this;
                textPreviewActivity4.f177229m0.setAniStickerResult(textPreviewActivity4.f177228l0);
                TextPreviewActivity textPreviewActivity5 = TextPreviewActivity.this;
                textPreviewActivity5.f177229m0.setIsSendMsg(textPreviewActivity5.f177220d0.equalsIgnoreCase(textPreviewActivity5.getAppRuntime().getCurrentAccountUin()));
                TextPreviewActivity.this.f177229m0.h().setTextColor(TextPreviewActivity.this.getResources().getColorStateList(R.color.qui_common_text_primary));
                TextPreviewActivity.this.f177229m0.h().setMovementMethod(PreviewTextContainerView.a.getInstance());
                if (TextPreviewActivity.this.f177235s0 == null) {
                    return;
                }
                TextPreviewActivity.this.f177235s0.c(TextPreviewActivity.this.f177229m0.h().getText().toString());
            }
        };
        this.C0 = null;
        this.D0 = false;
    }

    private void Q2() {
        LiuHaiUtils.initLiuHaiProperty(this);
    }

    private void R2() {
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
    }

    private Map<String, Object> S2() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "em_bas_font_setting_entry");
        hashMap.put("dt_pgid", "pg_bas_text_detail");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("op_result", 1);
        hashMap.put("cur_pg", hashMap2);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T2() {
        return TextPreviewNTFoldCompat.f183705a.e(this, this.f177229m0, this.f177218b0);
    }

    private void U2() {
        this.A0 = (LinearLayout) findViewById(R.id.f95615fg);
        if (F2() > 0) {
            this.A0.setVisibility(8);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.f95605ff);
        textView.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        textView.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary_selector));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.fo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextPreviewActivity.this.W2(view);
            }
        });
        VideoReport.reportEvent("dt_imp", S2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W2(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        startActivity(((IFontSettingApi) QRoute.api(IFontSettingApi.class)).getFontSettingIntent(this));
        VideoReport.reportEvent("dt_clck", S2());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Y2(Runnable runnable) {
        runnable.run();
    }

    private void Z2(RelativeLayout relativeLayout) {
        if (relativeLayout == null) {
            QLog.e("TextPreviewActivity", 1, "updateRootLayout: rootLayout == null");
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.jtc);
        relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        imageView.setVisibility(4);
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public int F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f177227k0;
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public String G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f177220d0;
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public int H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f177221e0;
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public com.tencent.qqnt.textpreview.a I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.qqnt.textpreview.a) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public boolean J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f177222f0;
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public void K2(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) bundle);
            return;
        }
        Iterator<com.tencent.qqnt.textpreview.inject.b> it = this.f177241y0.iterator();
        while (it.hasNext() && !it.next().d(i3, bundle)) {
        }
    }

    protected boolean V2(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (view.getVisibility() != 0) {
            return false;
        }
        if (this.f177233q0 == null) {
            this.f177233q0 = new Rect();
        }
        view.getDrawingRect(this.f177233q0);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = this.f177233q0;
        int i17 = iArr[0];
        rect.left = i17;
        int i18 = iArr[1];
        rect.top = i18;
        rect.right += i17;
        rect.bottom += i18;
        return rect.contains(i3, i16);
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            dispatchTouchEvent = ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        } else if (this.D0) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        } else if (this.f177237u0.getVisibility() == 0) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        } else {
            Iterator<com.tencent.qqnt.textpreview.inject.b> it = this.f177241y0.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b(motionEvent)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16 && !V2(this.f177239w0, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && !V2(this.f177237u0, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && !V2(this.f177238v0, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && !V2(this.A0, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                if (!this.f177229m0.i()) {
                    if (motionEvent.getAction() == 0) {
                        if (this.f177229m0.j()) {
                            this.f177232p0 = MotionEvent.obtain(motionEvent);
                        } else {
                            this.f177232p0 = null;
                        }
                    } else if (this.f177232p0 != null && motionEvent.getAction() == 1) {
                        if (!this.f177229m0.i()) {
                            int x16 = ((int) this.f177232p0.getX()) - ((int) motionEvent.getX());
                            int y16 = ((int) this.f177232p0.getY()) - ((int) motionEvent.getY());
                            if ((x16 * x16) + (y16 * y16) < 10000 && motionEvent.getEventTime() - this.f177232p0.getEventTime() < 200) {
                                this.f177232p0 = null;
                                finish();
                            }
                        } else {
                            this.f177232p0 = null;
                        }
                    }
                } else if (this.f177229m0.i() && motionEvent.getAction() == 1) {
                    CharSequence text = this.f177229m0.h().getText();
                    if (text instanceof Spannable) {
                        Selection.removeSelection((Spannable) text);
                    }
                }
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            } else {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            }
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.doOnActivityResult(i3, i16, intent);
            this.f177242z0.onActivityResult(this, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (!this.f177235s0.onBackPress()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        Iterator<com.tencent.qqnt.textpreview.inject.b> it = this.f177241y0.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        PreviewTextContainerView previewTextContainerView = this.f177229m0;
        if (previewTextContainerView != null) {
            this.f177235s0.b(previewTextContainerView);
            this.f177235s0 = null;
        }
        MergeForwardRevokeHelper mergeForwardRevokeHelper = this.f177236t0;
        if (mergeForwardRevokeHelper != null) {
            mergeForwardRevokeHelper.j(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.doOnPause();
            this.f177235s0.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.doOnStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        PreviewTextContainerView previewTextContainerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (z16 && (previewTextContainerView = this.f177229m0) != null && this.f177230n0 != null && previewTextContainerView.getHeight() < this.f177230n0.getHeight()) {
            this.f177229m0.setMinimumHeight(this.f177230n0.getHeight());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f177231o0;
        String str = this.f177224h0;
        if (str != null) {
            i3 = str.length();
        } else {
            i3 = 0;
        }
        com.tencent.qqnt.textpreview.inject.g.a().b(getAppRuntime(), "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(uptimeMillis), String.valueOf(i3), "", "");
        super.finish();
        overridePendingTransition(0, R.anim.f154469ad);
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f177217a0;
    }

    @Override // com.tencent.qqnt.textpreview.AbsTextPreviewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
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
        this.mActNeedImmersive = false;
        this.f177241y0.add(new TextPreviewBottomMenu());
        super.onCreate(bundle);
        if (getAppRuntime() == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TextPreviewActivity", 2, "TextPreviewActivity onCreate,  the app is null");
            }
            finish();
            return;
        }
        try {
            super.setContentView(R.layout.f167627c8);
            Iterator<com.tencent.qqnt.textpreview.inject.b> it = this.f177241y0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            Intent intent = super.getIntent();
            this.f177219c0 = intent.getStringExtra("peeruin");
            this.f177220d0 = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
            this.f177223g0 = intent.getStringExtra("real_msg_sender_uin");
            this.f177217a0 = intent.getIntExtra(IPublicAccountBrowser.KEY_UIN_TYPE, 0);
            this.f177218b0 = intent.getIntExtra(AppConstants.Key.NT_CHAT_TYPE, 1);
            this.f177222f0 = intent.getBooleanExtra("isMultiMsg", false);
            this.f177224h0 = intent.getStringExtra("content");
            this.f177225i0 = intent.getStringExtra("troop_at_info");
            this.f177221e0 = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, -2);
            this.f177226j0 = intent.getBooleanExtra("anistickerShowBig", true);
            this.f177227k0 = intent.getIntExtra("anistickerLocID", -1);
            if (intent.hasExtra("anistickerResultID")) {
                this.f177228l0 = intent.getStringExtra("anistickerResultID");
            }
            long longExtra = intent.getLongExtra("uniseq", 0L);
            if (E0 != longExtra) {
                PreviewTextContainerView.f362309d = 0.0f;
                E0 = longExtra;
            }
            this.f177229m0 = com.tencent.qqnt.textpreview.inject.g.a().d(this);
            if (com.tencent.util.l.f383986a.b("disable_outside_click", true)) {
                this.f177229m0.setDispatchTouchToTv(false);
            }
            this.f177229m0.setId(R.id.content);
            ((RelativeLayout) super.findViewById(R.id.lyv)).addView(this.f177229m0, new RelativeLayout.LayoutParams(-1, -1));
            ScrollView scrollView = (ScrollView) super.findViewById(R.id.j8l);
            this.f177230n0 = scrollView;
            scrollView.setOverScrollMode(2);
            this.f177229m0.setOutScrollView(this.f177230n0);
            this.f177229m0.h().setLineSpacing(0.0f, 1.5f);
            this.f177237u0 = (ParticipleView) findViewById(R.id.m0t);
            this.f177238v0 = (ParticipleBottomMenuView) findViewById(R.id.lyt);
            this.f177239w0 = findViewById(R.id.acl);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root);
            this.f177240x0 = relativeLayout;
            Z2(relativeLayout);
            U2();
            Iterator<com.tencent.qqnt.textpreview.inject.b> it5 = this.f177241y0.iterator();
            while (it5.hasNext()) {
                it5.next().c(this, intent, getAppRuntime());
            }
            if (TextUtils.isEmpty(this.f177223g0)) {
                return;
            }
            if (this.f177224h0 != null) {
                QLog.i("TextPreviewActivity.hotWordDebug", 1, "" + this.f177224h0);
                if (QLog.isColorLevel()) {
                    QLog.i("TextPreviewActivity.hotWordDebug", 2, "" + Base64.encodeToString(this.f177224h0.getBytes(), 0));
                }
            }
            com.tencent.qqnt.textpreview.inject.c a16 = com.tencent.qqnt.textpreview.inject.g.a().a();
            this.f177235s0 = a16;
            a16.a(this, this.f177229m0);
            Y2(this.B0);
            MergeForwardRevokeHelper mergeForwardRevokeHelper = new MergeForwardRevokeHelper(longExtra, intent.getLongExtra("realMsgId", -1L));
            this.f177236t0 = mergeForwardRevokeHelper;
            mergeForwardRevokeHelper.i(this);
            com.tencent.qqnt.textpreview.inject.g.a().g(this, new b(this));
            Q2();
            if (AppSetting.f99565y) {
                if (this.f177227k0 >= 0) {
                    this.f177229m0.setContentDescription(new QQText(this.f177224h0, 5).toPlainText().replace("/", ""));
                } else {
                    this.f177229m0.h().setContentDescription(com.tencent.qqnt.emotion.utils.s.b(this.f177224h0));
                }
            }
        } catch (Exception e16) {
            QLog.e("TextPreviewActivity", 1, "", e16);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onPause();
        Iterator<com.tencent.qqnt.textpreview.inject.b> it = this.f177241y0.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
        ApngImage.pauseByTag(0);
        AbstractGifImage.pauseAll();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        ParticipleView participleView = this.f177237u0;
        if (participleView != null) {
            participleView.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onResume();
        Iterator<com.tencent.qqnt.textpreview.inject.b> it = this.f177241y0.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
        ApngImage.playByTag(0);
        AbstractGifImage.resumeAll();
        this.f177236t0.k(this);
        this.f177235s0.onResume();
        R2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStart();
            this.f177231o0 = SystemClock.uptimeMillis();
        }
    }
}
