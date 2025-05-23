package com.tencent.mobileqq.vas.theme.video;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeMMKVPreference;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k implements com.tencent.mobileqq.vas.theme.api.a {

    /* renamed from: j, reason: collision with root package name */
    private static final boolean f310959j = ar.b("linkliang", "2024-11-13", "vas_bug_133618933").isEnable(true);

    /* renamed from: a, reason: collision with root package name */
    private Context f310960a;

    /* renamed from: b, reason: collision with root package name */
    private ISuperPlayer f310961b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f310962c;

    /* renamed from: d, reason: collision with root package name */
    private ISPlayerVideoView f310963d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f310964e;

    /* renamed from: f, reason: collision with root package name */
    private b f310965f;

    /* renamed from: g, reason: collision with root package name */
    private b f310966g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f310967h = new AtomicBoolean(true);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f310968i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ISuperPlayer.OnErrorListener {
        a() {
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            long j3;
            ReportInfo num2 = VasCommonReporter.getThemeNewScid().setValue1("error").setNum1(i17).setNum2(i16);
            if (k.this.f310965f != null) {
                j3 = k.this.f310965f.f310947f;
            } else {
                j3 = -1;
            }
            num2.setNum3(j3).setValue2(str).setValue3(ThemeUtil.getCurrentThemeId()).report(false);
            return false;
        }
    }

    public k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(boolean z16) {
        H("init so end.");
        ViewGroup viewGroup = this.f310964e;
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.z();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        H("postPlayVideo");
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        ImageView imageView = this.f310962c;
        if (imageView != null) {
            b bVar = this.f310965f;
            Drawable drawable = bVar.f310946e;
            if (drawable == null) {
                drawable = this.f310960a.getDrawable(bVar.f310945d);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    private void D() {
        ViewGroup viewGroup = this.f310964e;
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.c
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.B();
                }
            });
        }
    }

    private void E() {
        ViewGroup viewGroup = this.f310964e;
        if (viewGroup != null) {
            ImageView imageView = this.f310962c;
            if (imageView != null) {
                viewGroup.removeView(imageView);
            }
            Object obj = this.f310963d;
            if (obj != null) {
                this.f310964e.removeView((View) obj);
            }
        }
    }

    private void F() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_AUDIO_RENDERER_TYPE, new int[]{-1}));
        if (f310959j) {
            arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_VIDEO_ADAPTIVE_FRAMERATE, true));
        }
        this.f310961b.setPlayerOptionalParamList(arrayList);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void G() {
        ImageView imageView = this.f310962c;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.C();
                }
            });
        }
    }

    private void H(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ThemeVideoPlayerImpl", 2, this + "-" + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void o() {
        Drawable drawable;
        if (this.f310963d == null) {
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.f310960a);
            this.f310963d = createPlayerVideoView;
            this.f310964e.addView((View) createPlayerVideoView, 0, new ViewGroup.LayoutParams(-1, -1));
            H("videoView added");
        }
        if (this.f310962c == null) {
            ImageView imageView = new ImageView(this.f310960a);
            this.f310962c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f310964e.addView(this.f310962c, 0, new ViewGroup.LayoutParams(-1, -1));
            if (this.f310962c != null) {
                String q16 = q();
                if (!TextUtils.isEmpty(q16)) {
                    this.f310962c.setImageDrawable(new BitmapDrawable(q16));
                } else {
                    ImageView imageView2 = this.f310962c;
                    if (t(this.f310965f)) {
                        drawable = this.f310960a.getDrawable(R.drawable.skin_background);
                    } else {
                        b bVar = this.f310965f;
                        Drawable drawable2 = bVar.f310946e;
                        if (drawable2 == null) {
                            drawable = this.f310960a.getDrawable(bVar.f310945d);
                        } else {
                            drawable = drawable2;
                        }
                    }
                    imageView2.setImageDrawable(drawable);
                }
            }
            H("bgImageView added");
        }
    }

    private String q() {
        String str = "";
        try {
            String string = new ThemeMMKVPreference().getPreference().getString("theme_root", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            String str2 = File.separator;
            if (!string.endsWith(str2)) {
                string = string + str2;
            }
            String str3 = string + "drawable-xxhdpi/skin_conversation_frame.png";
            try {
                if (!new File(str3).exists()) {
                    return "";
                }
                return str3;
            } catch (Exception e16) {
                e = e16;
                str = str3;
                H("getFirstFramePath, exception" + e.getMessage());
                return str;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void r() {
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(this.f310960a, 132, this.f310963d);
        this.f310961b = createMediaPlayer;
        createMediaPlayer.setXYaxis(2);
        this.f310961b.setOutputMute(true);
        this.f310961b.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.vas.theme.video.f
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                boolean x16;
                x16 = k.this.x(iSuperPlayer, i3, i16, i17, str);
                return x16;
            }
        });
        this.f310961b.setOnInfoListener(new ISuperPlayer.OnInfoListener() { // from class: com.tencent.mobileqq.vas.theme.video.g
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
            public final boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
                boolean y16;
                y16 = k.this.y(iSuperPlayer, i3, j3, j16, obj);
                return y16;
            }
        });
    }

    private boolean s() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(this.f310960a, new SDKInitListener() { // from class: com.tencent.mobileqq.vas.theme.video.h
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    k.this.A(z16);
                }
            });
            H("init so");
            return true;
        }
        return false;
    }

    private boolean t(b bVar) {
        if (bVar != null && bVar.f310942a != null) {
            return false;
        }
        return true;
    }

    private boolean u(b bVar) {
        if (bVar != null && bVar.f() == 0 && bVar.e() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ISuperPlayer iSuperPlayer) {
        iSuperPlayer.start();
        H("playFullVideo start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(ISuperPlayer iSuperPlayer) {
        b bVar = this.f310966g;
        if (bVar != null) {
            this.f310965f = bVar;
            this.f310966g = null;
            H("playFullVideo next");
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        H("player error! module=" + i3 + ",errorType=" + i16 + ",errorCode=" + i17 + ",extraInfo=" + str);
        D();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x001f, code lost:
    
        if (r7 == 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ boolean y(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        boolean z16;
        b bVar = this.f310965f;
        if (bVar == null) {
            return false;
        }
        try {
            long f16 = bVar.f();
            if (this.f310965f.e() > 0) {
                if (j3 == 1) {
                    if (!u(this.f310965f)) {
                        z16 = true;
                    }
                }
                z16 = false;
            }
            if (i3 == 109 && z16 && this.f310967h.get()) {
                this.f310961b.seekTo((int) f16, 3);
            }
        } catch (Exception e16) {
            H("player onInfo error!" + e16.getMessage());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        init(this.f310964e);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public void a() {
        float f16;
        H("playExitAnimation");
        if (e()) {
            H("playExitAnimation disable");
            return;
        }
        try {
            if (!u(this.f310965f) && this.f310967h.compareAndSet(true, false)) {
                ISuperPlayer iSuperPlayer = this.f310961b;
                if (ThemeUtil.isNowThemeIsSuperTheme()) {
                    f16 = 200.0f;
                } else {
                    f16 = 1.0f;
                }
                iSuperPlayer.setPlaySpeedRatio(f16);
            }
        } catch (Exception e16) {
            H("playExitAnimation e:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public boolean b(Activity activity) {
        Context context = this.f310960a;
        if (context == null || !(context instanceof Activity) || activity != ((Activity) context)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public boolean c(ViewGroup viewGroup) {
        if (this.f310968i.get() && viewGroup == this.f310964e) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public void d(b bVar) {
        if (!e() && !t(bVar)) {
            H("playStartAnimation:" + bVar.f310942a.toString());
            try {
                if (this.f310961b.isPlaying()) {
                    this.f310966g = bVar;
                    a();
                } else {
                    this.f310965f = bVar;
                    p();
                }
                return;
            } catch (Exception e16) {
                H("playStartAnimation e:" + e16.getMessage());
                return;
            }
        }
        if (!t(bVar) && this.f310965f == null) {
            this.f310965f = bVar;
        }
        H("playStartAnimation disable" + this);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public boolean e() {
        if (c(this.f310964e) && this.f310961b != null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public synchronized void init(ViewGroup viewGroup) {
        try {
            H("init start.");
        } catch (Exception e16) {
            H(e16.getMessage());
        }
        if (viewGroup != null && !c(viewGroup)) {
            this.f310964e = viewGroup;
            this.f310960a = viewGroup.getContext();
            o();
            if (s()) {
                return;
            }
            r();
            D();
            this.f310968i.set(true);
            H("init finished.");
            return;
        }
        H("should not init.");
    }

    protected synchronized void p() {
        if (t(this.f310965f)) {
            H("playFullVideo VideoInfo null" + this);
            return;
        }
        G();
        if (e()) {
            H("disabled!");
            return;
        }
        try {
            this.f310961b.stop();
            this.f310961b.reset();
            this.f310961b.updatePlayerVideoView(this.f310963d);
            this.f310967h.set(true);
            this.f310961b.setPlaySpeedRatio(1.0f);
            this.f310961b.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.vas.theme.video.d
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
                public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                    k.this.v(iSuperPlayer);
                }
            });
            this.f310961b.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.vas.theme.video.e
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
                public final void onCompletion(ISuperPlayer iSuperPlayer) {
                    k.this.w(iSuperPlayer);
                }
            });
            this.f310961b.setOnErrorListener(new a());
            this.f310961b.setLoopback(u(this.f310965f));
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.isPrePlay = true;
            F();
            this.f310961b.openMediaPlayer(this.f310960a, this.f310965f.f310942a, 0L, obtain);
        } catch (Exception e16) {
            H("playFullVideo error:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public void pause() {
        if (e()) {
            return;
        }
        try {
            this.f310961b.pause();
            H("pause");
        } catch (Exception e16) {
            H("pause error:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public void release() {
        try {
            ISuperPlayer iSuperPlayer = this.f310961b;
            if (iSuperPlayer != null) {
                iSuperPlayer.stop();
                this.f310961b.reset();
                this.f310961b.release();
            }
            this.f310961b = null;
        } catch (Exception e16) {
            H("release error:" + e16.getMessage());
        }
        E();
        this.f310968i.set(false);
        this.f310960a = null;
        this.f310962c = null;
        this.f310963d = null;
        this.f310964e = null;
        this.f310966g = null;
        this.f310967h.set(true);
        H("release");
    }

    @Override // com.tencent.mobileqq.vas.theme.api.a
    public void resume() {
        if (e()) {
            return;
        }
        try {
            this.f310961b.start();
            H("resume");
        } catch (Exception e16) {
            H("resume error:" + e16.getMessage());
        }
    }

    public k(b bVar) {
        this.f310965f = bVar;
    }
}
