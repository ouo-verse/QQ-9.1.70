package com.qzone.shakead;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.homepage.ui.Facade.FacadeVideoDownLoaderManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.RenderFactory;
import com.tencent.jalpha.videoplayer.view.JalphaTextureView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ih.j;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ShakeAdCaiDan implements RenderFactory {
    private int C;
    private d D;
    private Activity E;

    /* renamed from: d, reason: collision with root package name */
    private final Context f59701d;

    /* renamed from: e, reason: collision with root package name */
    private final FrameLayout f59702e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f59703f;

    /* renamed from: h, reason: collision with root package name */
    private JalphaTextureView f59704h;

    /* renamed from: m, reason: collision with root package name */
    private BusinessFeedData f59706m;

    /* renamed from: i, reason: collision with root package name */
    private boolean f59705i = false;
    private IVideoPLayListener F = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void onHide();
    }

    public ShakeAdCaiDan(Context context, Activity activity, d dVar) {
        this.f59701d = context;
        this.E = activity;
        this.D = dVar;
        this.f59702e = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.hku, (ViewGroup) null);
        g();
        c();
    }

    private void c() {
        this.f59704h = new JalphaTextureView(this.f59701d);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        this.f59704h.setLoopState(false);
        this.f59704h.setPlayListener(this.F);
        this.f59704h.setLayoutParams(layoutParams);
        this.f59704h.setRenderFactory(this);
        this.f59704h.setEnabled(true);
        this.f59704h.setOpaque(false);
        this.f59703f.addView(this.f59704h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3, int i16) {
        float f16 = (i3 * 2) / 3;
        float f17 = i16;
        float max = Math.max(ViewUtils.getScreenWidth() / f16, ViewUtils.getScreenHeight() / f17);
        int i17 = (int) (f16 * max);
        int i18 = (int) (f17 * max);
        ViewGroup.LayoutParams layoutParams = this.f59704h.getLayoutParams();
        layoutParams.width = i17;
        layoutParams.height = i18;
        this.f59704h.setLayoutParams(layoutParams);
        this.f59704h.setTranslationX((r0 - i17) / 2);
        this.f59704h.setTranslationY((r1 - i18) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        FrameLayout frameLayout;
        BusinessFeedData businessFeedData;
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.shakead.ShakeAdCaiDan.3
            @Override // java.lang.Runnable
            public void run() {
                ShakeAdCaiDan.this.f();
            }
        }, 500L);
        Activity activity = this.E;
        if (activity == null || (frameLayout = this.f59702e) == null || (businessFeedData = this.f59706m) == null) {
            return;
        }
        QZoneAdFeedUtils.f55717a.H(activity, frameLayout, businessFeedData, FeedElement.GDT_ACTION_SHAKE, 80, this.C, null);
    }

    private void g() {
        this.f59703f = (FrameLayout) this.f59702e.findViewById(R.id.tkz);
        this.f59702e.setOnClickListener(new a());
        this.f59702e.setOnTouchListener(new b());
    }

    private void i(String str) {
        String d16 = FacadeVideoDownLoaderManager.d(str);
        if (this.f59704h == null || TextUtils.isEmpty(d16) || d16.trim().equals("")) {
            return;
        }
        this.f59704h.setContentVisible(true);
        this.f59704h.playFile(d16);
    }

    private void k() {
        try {
            i(new JSONObject(j.b(this.f59706m)).optString("transition_animation_url"));
        } catch (Exception e16) {
            QLog.e("ShakeAdCaiDan", 1, "error show Caidan " + e16);
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.RenderFactory
    public BaseRender createRender() {
        return new com.qzone.shakead.a();
    }

    public void f() {
        if (this.f59705i) {
            this.f59705i = false;
            if (this.f59702e.getParent() != null) {
                ((ViewGroup) this.f59702e.getParent()).removeView(this.f59702e);
            }
            JalphaTextureView jalphaTextureView = this.f59704h;
            if (jalphaTextureView != null) {
                jalphaTextureView.setContentVisible(false);
                this.f59704h.stop();
            }
            d dVar = this.D;
            if (dVar != null) {
                dVar.onHide();
            }
        }
    }

    public boolean h() {
        return this.f59705i;
    }

    public void j(FrameLayout frameLayout, BusinessFeedData businessFeedData, int i3) {
        if (this.f59705i) {
            return;
        }
        try {
            Vibrator vibrator = (Vibrator) BaseApplication.getContext().getApplicationContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("ShakeAdCaiDan", "exception when doVibrate.", th5);
        }
        this.f59706m = businessFeedData;
        this.C = i3;
        if (this.f59702e.getParent() != null) {
            ((ViewGroup) this.f59702e.getParent()).removeView(this.f59702e);
        }
        frameLayout.addView(this.f59702e, new ViewGroup.LayoutParams(-1, -1));
        this.f59705i = true;
        k();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c implements IVideoPLayListener {
        c() {
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onEnd() {
            ShakeAdCaiDan.this.e();
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onError(int i3) {
            QLog.e("ShakeAdCaiDan", 1, "play video error " + i3);
            ShakeAdCaiDan.this.e();
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onVideoSize(int i3, int i16) {
            ShakeAdCaiDan.this.d(i3, i16);
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onStart() {
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onPlayAtTime(long j3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
