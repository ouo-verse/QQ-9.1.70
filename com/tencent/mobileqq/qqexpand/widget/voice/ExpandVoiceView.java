package com.tencent.mobileqq.qqexpand.widget.voice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qqexpand.utils.e;
import com.tencent.mobileqq.qqexpand.utils.q;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import jj2.b;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandVoiceView extends FrameLayout implements ExpandVoicePlayer.b, View.OnClickListener {
    private static final Map<String, WeakReference<Bitmap>> N = new HashMap();
    private final View C;
    private String D;
    private String E;
    private QBaseActivity F;
    private ExpandVoicePlayer G;
    private ApngDrawable H;
    private boolean I;
    private boolean J;
    private long K;
    private long L;
    private int M;

    /* renamed from: d, reason: collision with root package name */
    private final int f264284d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f264285e;

    /* renamed from: f, reason: collision with root package name */
    Paint f264286f;

    /* renamed from: h, reason: collision with root package name */
    private final View f264287h;

    /* renamed from: i, reason: collision with root package name */
    private final URLImageView f264288i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f264289m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView$3, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f264290d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f264291e;

        @Override // java.lang.Runnable
        public void run() {
            HttpDownloadUtil.downloadData(this.f264290d, "https://downv6.qq.com/extendfriend/voicewave.png", this.f264291e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
    }

    public ExpandVoiceView(Context context) {
        this(context, null);
    }

    public static String f() {
        return e.f().concat("/voicewave.png");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z16) {
        if (!z16) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            this.f264288i.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/voicewave.png", obtain));
            if (QLog.isColorLevel()) {
                QLog.i("ExtendFriendVoiceView", 2, "load voice wave png in a default way!");
            }
            return true;
        }
        return false;
    }

    private void h() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.1
            /* JADX WARN: Removed duplicated region for block: B:11:0x0064 A[RETURN] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                if (ExpandVoiceView.this.f264288i != null) {
                    File file = new File(ExpandVoiceView.f());
                    boolean z16 = true;
                    if (file.exists() && file.isFile()) {
                        try {
                            ExpandVoiceView.this.H = new ApngDrawable(new ApngImage(file.getAbsoluteFile(), true));
                        } catch (IOException e16) {
                            QLog.e("ExtendFriendVoiceView", 1, "IOException! ", e16);
                            e16.printStackTrace();
                            z16 = false;
                            if (ExpandVoiceView.this.g(z16)) {
                            }
                            ExpandVoiceView.this.H.getImage().setSupportGlobalPasued(false);
                            ExpandVoiceView.this.H.pause();
                            ExpandVoiceView.this.f264288i.setImageDrawable(ExpandVoiceView.this.H);
                        } catch (RuntimeException e17) {
                            QLog.e("ExtendFriendVoiceView", 1, "Apng decode RuntimeException! ", e17);
                            z16 = false;
                            if (ExpandVoiceView.this.g(z16)) {
                            }
                            ExpandVoiceView.this.H.getImage().setSupportGlobalPasued(false);
                            ExpandVoiceView.this.H.pause();
                            ExpandVoiceView.this.f264288i.setImageDrawable(ExpandVoiceView.this.H);
                        } catch (UnsatisfiedLinkError e18) {
                            QLog.e("ExtendFriendVoiceView", 1, "link error: nativeStartDecode, ", e18);
                            z16 = false;
                            if (ExpandVoiceView.this.g(z16)) {
                            }
                            ExpandVoiceView.this.H.getImage().setSupportGlobalPasued(false);
                            ExpandVoiceView.this.H.pause();
                            ExpandVoiceView.this.f264288i.setImageDrawable(ExpandVoiceView.this.H);
                        } catch (Throwable th5) {
                            QLog.e("ExtendFriendVoiceView", 1, "unknow error!", th5);
                            th5.printStackTrace();
                            z16 = false;
                            if (ExpandVoiceView.this.g(z16)) {
                            }
                            ExpandVoiceView.this.H.getImage().setSupportGlobalPasued(false);
                            ExpandVoiceView.this.H.pause();
                            ExpandVoiceView.this.f264288i.setImageDrawable(ExpandVoiceView.this.H);
                        }
                        if (ExpandVoiceView.this.g(z16)) {
                            return;
                        }
                    } else {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mUseApngImage = true;
                        URLDrawable drawable = URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/voicewave.png", obtain);
                        if (drawable.getCurrent() instanceof ApngDrawable) {
                            try {
                                ExpandVoiceView.this.H = (ApngDrawable) drawable.getCurrent();
                            } catch (Throwable th6) {
                                QLog.e("ExtendFriendVoiceView", 1, th6, new Object[0]);
                                z16 = false;
                            }
                            if (ExpandVoiceView.this.g(z16)) {
                                return;
                            }
                        } else {
                            ExpandVoiceView.this.f264288i.setImageDrawable(drawable);
                            return;
                        }
                    }
                    ExpandVoiceView.this.H.getImage().setSupportGlobalPasued(false);
                    ExpandVoiceView.this.H.pause();
                    ExpandVoiceView.this.f264288i.setImageDrawable(ExpandVoiceView.this.H);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void a1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("onFocusChanged focused=%s", Boolean.valueOf(z16)));
        }
        if (!z16) {
            j();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f264285e && "1103".equals(ThemeUtil.curThemeId)) {
            if (this.f264286f.getColorFilter() == null) {
                this.f264286f.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
            }
            canvas.saveLayer(null, this.f264286f, 31);
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void i() {
        ApngDrawable apngDrawable = this.H;
        if (apngDrawable != null) {
            apngDrawable.pause();
        }
        this.J = false;
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", this.D));
        }
        ExpandVoicePlayer expandVoicePlayer = this.G;
        if (expandVoicePlayer != null) {
            try {
                expandVoicePlayer.k();
                this.I = false;
                i();
            } catch (Exception unused) {
                QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.getId();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void onDownloadFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFailed errCode=%s", Integer.valueOf(i3)));
        }
        j();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void onDownloadFinish(File file) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFinish path=%s", file.getAbsoluteFile()));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    public void setActivity(QBaseActivity qBaseActivity) {
        this.F = qBaseActivity;
        this.L = ((IExpandManagerProxy) QRoute.api(IExpandManagerProxy.class)).getVoiceMaxDuration(this.F.getAppRuntime());
    }

    public void setDeleteIconEnable(boolean z16, a aVar) {
        int i3;
        View view = this.C;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view;
        if (this.M == 1 && (view = this.f264287h) != null) {
            view.setOnClickListener(onClickListener);
        } else {
            super.setOnClickListener(onClickListener);
        }
    }

    public void setVoiceDuration(long j3) {
        String valueOf;
        if (this.f264289m != null) {
            String valueOf2 = String.valueOf(j3 / 60);
            long j16 = j3 % 60;
            if (j16 < 10) {
                valueOf = "0".concat(String.valueOf(j16));
            } else {
                valueOf = String.valueOf(j16);
            }
            this.f264289m.setText((valueOf2 + ":" + valueOf).intern());
            this.K = j3;
        }
    }

    public void setVoiceFileMD5(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("setVoiceFileMD5 md5=%s", str));
        }
        if (!TextUtils.isEmpty(str)) {
            this.E = str.toUpperCase();
        }
    }

    public void setVoiceUrl(String str) {
        int lastIndexOf;
        this.D = str;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = this.D.lastIndexOf(61)) >= 0) {
            setVoiceFileMD5(this.D.substring(lastIndexOf + 1));
        }
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", this.D));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.2
            @Override // java.lang.Runnable
            public void run() {
                ExpandVoiceView.this.I = false;
                ExpandVoiceView.this.i();
            }
        });
        ExpandVoicePlayer expandVoicePlayer = this.G;
        if (expandVoicePlayer != null) {
            expandVoicePlayer.a();
        }
    }

    public ExpandVoiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandVoiceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264285e = false;
        this.M = 1;
        this.f264284d = context.obtainStyledAttributes(attributeSet, b.F1).getInteger(b.G1, 0);
        LayoutInflater.from(context).inflate(R.layout.gwj, (ViewGroup) this, true);
        this.f264287h = findViewById(R.id.f167117l01);
        this.f264288i = (URLImageView) findViewById(R.id.di5);
        this.f264289m = (TextView) findViewById(R.id.kew);
        View findViewById = findViewById(R.id.dgw);
        this.C = findViewById;
        findViewById.setOnClickListener(this);
        findViewById.setOnTouchListener(q.f264107a);
        h();
        Paint paint = new Paint();
        this.f264286f = paint;
        paint.setAntiAlias(true);
        this.f264286f.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    }

    public void setMode(int i3) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}
