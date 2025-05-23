package com.tencent.mobileqq.qqexpand.widget.voice;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qqexpand.utils.c;
import com.tencent.mobileqq.qqexpand.utils.e;
import com.tencent.mobileqq.qqexpand.utils.i;
import com.tencent.mobileqq.qqexpand.utils.q;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import jj2.b;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OldExpandVoiceView extends FrameLayout implements ExpandVoicePlayer.b, View.OnClickListener {
    private static final int[] S = {-13900833, -37464, -12331403, -5544982};
    private static final int[] T = {-14167603, -1350502, -12728981, -6464553};
    private static final Map<String, WeakReference<Bitmap>> U = new HashMap();
    private final View C;
    private final View D;
    private String E;
    private String F;
    private a G;
    private QBaseActivity H;
    private ExpandVoicePlayer I;
    private LottieDrawable J;
    private final FrameAnimationDrawable K;
    private boolean L;
    private boolean M;
    private long N;
    private long P;
    private int Q;
    private int R;

    /* renamed from: d, reason: collision with root package name */
    private final int f264298d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f264299e;

    /* renamed from: f, reason: collision with root package name */
    Paint f264300f;

    /* renamed from: h, reason: collision with root package name */
    private final View f264301h;

    /* renamed from: i, reason: collision with root package name */
    private final View f264302i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f264303m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String b16;
            if (OldExpandVoiceView.this.f264298d == 0) {
                b16 = e.e("expand_voice_animation.json");
                ViewUtils.dip2px(19.0f);
                ViewUtils.dip2px(19.0f);
            } else {
                b16 = c.b("expand_voice_animation2.json");
                ViewUtils.dip2px(16.0f);
                ViewUtils.dip2px(17.0f);
            }
            try {
                LottieComposition.Factory.fromInputStream(new BufferedInputStream(new FileInputStream(b16)), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.1.1
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (lottieComposition == null) {
                            QLog.e("ExtendFriendVoiceView", 1, "onCompositionLoaded lottieComposition is null");
                            return;
                        }
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setComposition(lottieComposition);
                        lottieDrawable.loop(true);
                        OldExpandVoiceView.this.J = lottieDrawable;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (OldExpandVoiceView.this.f264302i != null) {
                                    OldExpandVoiceView.this.f264302i.setBackgroundDrawable(OldExpandVoiceView.this.J);
                                }
                            }
                        });
                    }
                });
            } catch (Exception e16) {
                QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a();
    }

    public OldExpandVoiceView(Context context) {
        this(context, null);
    }

    private Bitmap h(String str) {
        String[] strArr = e.f264091d;
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        int charAt = str.toUpperCase().charAt(0) % strArr.length;
        this.R = charAt;
        String e16 = e.e(strArr[charAt]);
        Map<String, WeakReference<Bitmap>> map = U;
        WeakReference<Bitmap> weakReference = map.get(e16);
        if (weakReference != null) {
            bitmap = weakReference.get();
        }
        if (bitmap == null || bitmap.isRecycled()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap a16 = e.a(e16, options);
            map.put(e16, new WeakReference<>(a16));
            return a16;
        }
        return bitmap;
    }

    private void k() {
        ThreadManagerV2.post(new AnonymousClass1(), 5, null, true);
    }

    private void m(int i3, int i16) {
        if (this.f264301h != null) {
            float c16 = x.c(getContext(), 50.0f);
            GradientDrawable a16 = i.a(i3, c16, c16, c16, c16);
            GradientDrawable a17 = i.a(i16, c16, c16, c16, c16);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, a17);
            stateListDrawable.addState(new int[0], a16);
            this.f264301h.setBackgroundDrawable(stateListDrawable);
        }
    }

    private void q() {
        int width;
        int i3;
        View view;
        if (getVisibility() == 0) {
            int i16 = this.Q;
            if ((i16 == 1 || i16 == 3) && (width = getWidth() - x.c(getContext(), 22.0f)) > 0) {
                int c16 = x.c(getContext(), 110.0f);
                View view2 = this.D;
                if (view2 != null && view2.getVisibility() == 0) {
                    i3 = x.c(getContext(), 33.0f);
                } else {
                    i3 = 0;
                }
                int i17 = (width - c16) - i3;
                int min = (int) (i17 * Math.min(((float) this.N) / ((float) this.P), 1.0f));
                if (min >= 0 && (view = this.f264301h) != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.width = c16 + i3 + min;
                    this.f264301h.setLayoutParams(layoutParams);
                    post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            OldExpandVoiceView.this.f264301h.requestLayout();
                        }
                    });
                    QLog.d("ExtendFriendVoiceView", 2, String.format("updateBubbleSize mVoiceDuration=%s mMaxVoiceDuration=%s maxWidth=%s increaseWidth=%s layoutParams.width=%s this=%s", Long.valueOf(this.N), Long.valueOf(this.P), Integer.valueOf(i17), Integer.valueOf(min), Integer.valueOf(layoutParams.width), this));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void a1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("onFocusChanged focused=%s", Boolean.valueOf(z16)));
        }
        if (!z16) {
            p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f264299e && "1103".equals(ThemeUtil.curThemeId)) {
            if (this.f264300f.getColorFilter() == null) {
                this.f264300f.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
            }
            canvas.saveLayer(null, this.f264300f, 31);
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void g(boolean z16) {
        if (z16 && this.f264301h != null) {
            int i3 = (int) (getContext().getResources().getDisplayMetrics().density * 20.0f);
            BaseAIOUtils.h(this.f264301h, i3, i3, i3, i3);
        }
    }

    public boolean i() {
        return this.M;
    }

    public boolean j() {
        return this.L;
    }

    public void l() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", this.E));
        }
        if (this.I == null) {
            this.I = new ExpandVoicePlayer(this, this.H);
        }
        if (!TextUtils.isEmpty(this.E)) {
            try {
                this.I.i(this.E);
                this.L = true;
                n();
            } catch (Exception unused) {
                QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
            }
        }
    }

    public void n() {
        String str;
        FrameAnimationDrawable frameAnimationDrawable;
        File[] listFiles;
        if (this.Q != 3) {
            int i3 = this.R;
            String[] strArr = null;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            str = null;
                        } else {
                            str = "expand_animate_logo4";
                        }
                    } else {
                        str = "expand_animate_logo3";
                    }
                } else {
                    str = "expand_animate_logo2";
                }
            } else {
                str = "expand_animate_logo1";
            }
            if (!TextUtils.isEmpty(str)) {
                File file = new File(e.e(str));
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    strArr = new String[listFiles.length];
                    for (int i16 = 0; i16 < listFiles.length; i16++) {
                        strArr[i16] = listFiles[i16].getAbsolutePath();
                    }
                }
            }
            if (strArr != null && strArr.length > 0 && (frameAnimationDrawable = this.K) != null) {
                View view = this.C;
                if (view != null) {
                    view.setBackgroundDrawable(frameAnimationDrawable);
                }
                this.K.b(strArr);
                this.K.d();
            }
        }
        LottieDrawable lottieDrawable = this.J;
        if (lottieDrawable != null) {
            lottieDrawable.playAnimation();
        }
        this.M = true;
    }

    public void o() {
        Bitmap h16;
        FrameAnimationDrawable frameAnimationDrawable = this.K;
        if (frameAnimationDrawable != null) {
            frameAnimationDrawable.e();
        }
        LottieDrawable lottieDrawable = this.J;
        if (lottieDrawable != null) {
            lottieDrawable.endAnimation();
        }
        if (this.C != null && (h16 = h(this.F)) != null) {
            this.C.setBackgroundDrawable(new BitmapDrawable(h16));
        }
        this.M = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == com.tencent.mobileqq.R.id.dgw && (aVar = this.G) != null) {
            try {
                aVar.a();
            } catch (Exception unused) {
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.b
    public void onDownloadFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFailed errCode=%s", Integer.valueOf(i3)));
        }
        p();
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
        q();
    }

    public void p() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", this.E));
        }
        ExpandVoicePlayer expandVoicePlayer = this.I;
        if (expandVoicePlayer != null) {
            try {
                expandVoicePlayer.k();
                this.L = false;
                o();
            } catch (Exception unused) {
                QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
            }
        }
    }

    public void setActivity(QBaseActivity qBaseActivity) {
        this.H = qBaseActivity;
        this.P = ((IExpandManagerProxy) QRoute.api(IExpandManagerProxy.class)).getVoiceMaxDuration(this.H.getAppRuntime());
    }

    public void setDeleteIconEnable(boolean z16, a aVar) {
        int i3;
        View view = this.D;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        this.G = aVar;
    }

    public void setMode(int i3) {
        int i16;
        int i17;
        float f16;
        int c16 = x.c(getContext(), 35.0f);
        int c17 = x.c(getContext(), 22.0f);
        int c18 = x.c(getContext(), 19.0f);
        int c19 = x.c(getContext(), 19.0f);
        int c26 = x.c(getContext(), 40.0f);
        int c27 = x.c(getContext(), 30.0f);
        int c28 = x.c(getContext(), 70.0f);
        int c29 = x.c(getContext(), 10.0f);
        int c36 = x.c(getContext(), 60.0f);
        int c37 = x.c(getContext(), 49.0f);
        this.Q = i3;
        if (i3 == 2) {
            i16 = (int) (c16 * 0.8f);
            c17 = (int) (c17 * 0.8f);
            c18 = (int) (c18 * 0.8f);
            c19 = (int) (c19 * 0.8f);
            c26 = (int) (c26 * 0.8f);
            c27 = (int) (c27 * 0.8f);
            c28 = (int) (c28 * 0.8f);
            c29 = (int) (c29 * 0.8f);
            c36 = (int) (c36 * 0.8f);
            c37 = (int) (c37 * 0.8f);
            i17 = -1;
            f16 = 11.2f;
        } else {
            if (i3 == 3) {
                c26 = ViewUtils.dip2px(20.0f);
                c29 = ViewUtils.dip2px(16.0f);
                c18 = ViewUtils.dip2px(16.0f);
                c19 = ViewUtils.dip2px(17.0f);
                c17 = 0;
            }
            i16 = c16;
            i17 = -2;
            f16 = 14.0f;
        }
        View view = this.f264301h;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i17;
            layoutParams.height = i16;
            layoutParams.leftMargin = c17;
        }
        View view2 = this.f264302i;
        if (view2 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view2.getLayoutParams();
            layoutParams2.width = c18;
            layoutParams2.height = c19;
            layoutParams2.leftMargin = c26;
        }
        TextView textView = this.f264303m;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams3.width = c27;
            layoutParams3.leftMargin = c28;
            layoutParams3.rightMargin = c29;
            this.f264303m.setTextSize(1, f16);
        }
        View view3 = this.C;
        if (view3 != null) {
            if (this.Q == 3) {
                view3.setVisibility(8);
                return;
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view3.getLayoutParams();
            layoutParams4.width = c36;
            layoutParams4.height = c37;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view;
        if (this.Q == 1 && (view = this.f264301h) != null) {
            view.setOnClickListener(onClickListener);
        } else {
            super.setOnClickListener(onClickListener);
        }
    }

    public void setVoiceDuration(long j3) {
        if (this.f264303m != null) {
            this.f264303m.setText((j3 + "\"").intern());
            this.N = j3;
            q();
        }
    }

    public void setVoiceFileMD5(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("setVoiceFileMD5 md5=%s", str));
        }
        if (!TextUtils.isEmpty(str)) {
            String upperCase = str.toUpperCase();
            this.F = upperCase;
            Bitmap h16 = h(upperCase);
            View view = this.C;
            if (view != null && h16 != null) {
                view.setBackgroundDrawable(new BitmapDrawable(h16));
            }
            char charAt = MD5Utils.toMD5(this.F).toUpperCase().charAt(0);
            int[] iArr = S;
            int length = charAt % iArr.length;
            m(iArr[length], T[length]);
        }
    }

    public void setVoiceUrl(String str) {
        int lastIndexOf;
        this.E = str;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = this.E.lastIndexOf(61)) >= 0) {
            setVoiceFileMD5(this.E.substring(lastIndexOf + 1));
        }
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", this.E));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView.3
            @Override // java.lang.Runnable
            public void run() {
                OldExpandVoiceView.this.L = false;
                OldExpandVoiceView.this.o();
            }
        });
        ExpandVoicePlayer expandVoicePlayer = this.I;
        if (expandVoicePlayer != null) {
            expandVoicePlayer.a();
        }
    }

    public OldExpandVoiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OldExpandVoiceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264299e = false;
        this.Q = 1;
        this.f264298d = context.obtainStyledAttributes(attributeSet, b.F1).getInteger(b.G1, 0);
        LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.gwf, (ViewGroup) this, true);
        this.f264301h = findViewById(com.tencent.mobileqq.R.id.f167117l01);
        this.f264302i = findViewById(com.tencent.mobileqq.R.id.di5);
        this.f264303m = (TextView) findViewById(com.tencent.mobileqq.R.id.kew);
        this.C = findViewById(com.tencent.mobileqq.R.id.dgv);
        View findViewById = findViewById(com.tencent.mobileqq.R.id.dgw);
        this.D = findViewById;
        findViewById.setOnClickListener(this);
        findViewById.setOnTouchListener(q.f264107a);
        k();
        FrameAnimationDrawable frameAnimationDrawable = new FrameAnimationDrawable();
        this.K = frameAnimationDrawable;
        frameAnimationDrawable.a(3000L);
        frameAnimationDrawable.c(true);
        Paint paint = new Paint();
        this.f264300f = paint;
        paint.setAntiAlias(true);
        this.f264300f.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}
