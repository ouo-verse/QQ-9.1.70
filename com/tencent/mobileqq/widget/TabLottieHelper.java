package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.activity.ActivateTenpayAccount;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TabLottieHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316458a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316459b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316460c = new c();

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316461d = new i(R.color.qui_common_icon_tabbar_primary, R.color.qui_common_icon_white);

    /* renamed from: e, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316462e = new i(R.color.qui_common_icon_white, R.color.qui_common_icon_tabbar_primary);

    /* renamed from: f, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316463f = new i(R.color.qui_common_icon_tabbar_primary, R.color.qui_common_brand_standard);

    /* renamed from: g, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316464g = new i(R.color.qui_common_brand_standard, R.color.qui_common_icon_tabbar_primary);

    /* renamed from: h, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316465h = new i(R.color.qui_common_brand_standard, R.color.qui_common_icon_white);

    /* renamed from: i, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316466i = new h(R.color.qui_common_icon_tabbar_primary, R.color.qui_common_brand_standard, R.color.qui_common_icon_white);

    /* renamed from: j, reason: collision with root package name */
    private static final SimpleLottieValueCallback<ColorFilter> f316467j = new h(R.color.qui_common_icon_white, R.color.qui_common_brand_standard, R.color.qui_common_icon_tabbar_primary);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum STATE {
        ENTER,
        BACK,
        IDLE
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements SimpleLottieValueCallback<ColorFilter> {
        a() {
        }

        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
            return new LightingColorFilter(0, BaseApplication.getContext().getResources().getColor(R.color.qui_common_brand_standard));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements SimpleLottieValueCallback<ColorFilter> {
        b() {
        }

        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
            return new LightingColorFilter(0, BaseApplication.getContext().getResources().getColor(R.color.qui_common_icon_tabbar_primary));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements SimpleLottieValueCallback<ColorFilter> {
        c() {
        }

        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
            return new LightingColorFilter(0, BaseApplication.getContext().getResources().getColor(R.color.qui_common_icon_white));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final f f316469a = new f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public f a() {
            return this.f316469a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e b(boolean z16) {
            this.f316469a.f316470a = z16;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e c(boolean z16) {
            this.f316469a.f316471b = z16;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e d(STATE state) {
            this.f316469a.f316472c = state;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        boolean f316470a;

        /* renamed from: b, reason: collision with root package name */
        boolean f316471b;

        /* renamed from: c, reason: collision with root package name */
        STATE f316472c;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        LottieDrawable f316473a;

        /* renamed from: b, reason: collision with root package name */
        LottieDrawable f316474b;

        /* renamed from: c, reason: collision with root package name */
        LottieDrawable f316475c;

        /* renamed from: d, reason: collision with root package name */
        LottieDrawable f316476d;

        /* renamed from: e, reason: collision with root package name */
        LottieDrawable f316477e;

        /* renamed from: f, reason: collision with root package name */
        private STATE f316478f = STATE.IDLE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean c() {
            if (Build.VERSION.SDK_INT >= 26) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f316478f = STATE.IDLE;
            this.f316473a = null;
            this.f316474b = null;
            this.f316475c = null;
            this.f316476d = null;
            this.f316477e = null;
        }

        public STATE b() {
            return this.f316478f;
        }

        public void d(STATE state) {
            STATE state2 = this.f316478f;
            STATE state3 = STATE.ENTER;
            if (state2 == state3) {
                STATE state4 = STATE.BACK;
                if (state == state4) {
                    this.f316478f = state4;
                    return;
                }
                return;
            }
            if (state2 == STATE.BACK || state2 == STATE.IDLE) {
                if (state == state3) {
                    this.f316478f = state3;
                } else {
                    this.f316478f = STATE.IDLE;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class h implements SimpleLottieValueCallback<ColorFilter> {

        /* renamed from: a, reason: collision with root package name */
        private ArgbEvaluator f316479a = new ArgbEvaluator();

        /* renamed from: b, reason: collision with root package name */
        @ColorRes
        private int f316480b;

        /* renamed from: c, reason: collision with root package name */
        @ColorRes
        private int f316481c;

        /* renamed from: d, reason: collision with root package name */
        @ColorRes
        private int f316482d;

        h(@ColorRes int i3, @ColorRes int i16, @ColorRes int i17) {
            this.f316480b = i3;
            this.f316481c = i16;
            this.f316482d = i17;
        }

        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
            int intValue;
            int color = ResourcesCompat.getColor(BaseApplication.getContext().getResources(), this.f316480b, null);
            int color2 = ResourcesCompat.getColor(BaseApplication.getContext().getResources(), this.f316481c, null);
            int color3 = ResourcesCompat.getColor(BaseApplication.getContext().getResources(), this.f316482d, null);
            if (lottieFrameInfo.getInterpolatedKeyframeProgress() < 0.5d) {
                intValue = ((Integer) this.f316479a.evaluate(lottieFrameInfo.getInterpolatedKeyframeProgress() * 2.0f, Integer.valueOf(color), Integer.valueOf(color2))).intValue();
            } else {
                intValue = ((Integer) this.f316479a.evaluate((lottieFrameInfo.getInterpolatedKeyframeProgress() * 2.0f) - 1.0f, Integer.valueOf(color2), Integer.valueOf(color3))).intValue();
            }
            return new LightingColorFilter(0, intValue);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class i implements SimpleLottieValueCallback<ColorFilter> {

        /* renamed from: a, reason: collision with root package name */
        private ArgbEvaluator f316483a = new ArgbEvaluator();

        /* renamed from: b, reason: collision with root package name */
        @ColorRes
        private int f316484b;

        /* renamed from: c, reason: collision with root package name */
        @ColorRes
        private int f316485c;

        i(@ColorRes int i3, @ColorRes int i16) {
            this.f316484b = i3;
            this.f316485c = i16;
        }

        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
            return new LightingColorFilter(0, ((Integer) this.f316483a.evaluate(lottieFrameInfo.getInterpolatedKeyframeProgress(), Integer.valueOf(ResourcesCompat.getColor(BaseApplication.getContext().getResources(), this.f316484b, null)), Integer.valueOf(ResourcesCompat.getColor(BaseApplication.getContext().getResources(), this.f316485c, null)))).intValue());
        }
    }

    private static synchronized void b(Context context, String str, String str2, boolean z16) {
        synchronized (TabLottieHelper.class) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str3 = File.separator;
            String substring = str.substring(str.lastIndexOf(str3));
            AssetManager assets = context.getAssets();
            try {
                FileUtils.delete(str2, false);
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                InputStream open = assets.open(str);
                String str4 = str2 + str3 + substring;
                TabDragAnimationView.E(str4, open);
                if (z16) {
                    ZipUtils.unZipFile(new File(str4), str2 + str3);
                }
            } catch (IOException e16) {
                QLog.e("TabDragAnimationView", 1, "copyFilesFromAssets called error: " + e16);
            } catch (Exception e17) {
                QLog.e("TabDragAnimationView", 1, "copyFilesFromAssets called error: " + e17);
            }
        }
    }

    private static String c(String str, String str2, String str3, f fVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || fVar == null) {
            return null;
        }
        String str4 = str3 + File.separator;
        if (fVar.f316472c != STATE.BACK && !fVar.f316471b) {
            return str4 + str;
        }
        return str4 + str2;
    }

    public static LottieDrawable d(f fVar, String str, String str2) {
        String e16;
        LottieDrawable lottieDrawable;
        boolean z16;
        LottieDrawable lottieDrawable2 = null;
        try {
            e16 = e(fVar, str, str2);
            LottieComposition fromInputStreamSync = LottieComposition.Factory.fromInputStreamSync(new BufferedInputStream(new FileInputStream(e16)));
            lottieDrawable = new LottieDrawable();
            lottieDrawable.setComposition(fromInputStreamSync);
            z16 = false;
            lottieDrawable.loop(false);
        } catch (Exception e17) {
            e = e17;
        }
        try {
            if (!e16.contains("default_immerse")) {
                STATE state = fVar.f316472c;
                STATE state2 = STATE.BACK;
                if (state == state2 || fVar.f316471b) {
                    str = str2;
                }
                if (state == state2 || fVar.f316471b) {
                    z16 = true;
                }
                f(lottieDrawable, str, z16);
                return lottieDrawable;
            }
            return lottieDrawable;
        } catch (Exception e18) {
            e = e18;
            lottieDrawable2 = lottieDrawable;
            QLog.e("TabDragAnimationView.TabLottieHelper", 1, "lottieCC generateLottieDrawable() called error: " + e);
            return lottieDrawable2;
        }
    }

    private static String e(f fVar, String str, String str2) {
        String str3 = "default_day";
        if (fVar != null) {
            if (fVar.f316471b) {
                str3 = "default_immerse";
            } else if (!fVar.f316470a) {
                str3 = "default_night";
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append("tablottie");
        sb5.append(str4);
        sb5.append(str3);
        String sb6 = sb5.toString();
        String c16 = c(str, str2, sb6, fVar);
        if (!new File(c16).exists()) {
            b(BaseApplication.getContext(), "tab" + str4 + str3 + ".zip", sb6, true);
        }
        return c16;
    }

    private static void f(LottieDrawable lottieDrawable, String str, boolean z16) {
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback2;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback3;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback4;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback5;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback6;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback7;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback8;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback9;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback10;
        SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback11;
        if ("conversation.json".equals(str)) {
            KeyPath keyPath = new KeyPath("normal", "**");
            ColorFilter colorFilter = LottieProperty.COLOR_FILTER;
            if (z16) {
                simpleLottieValueCallback11 = f316464g;
            } else {
                simpleLottieValueCallback11 = f316463f;
            }
            lottieDrawable.addValueCallback(keyPath, (KeyPath) colorFilter, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback11);
            lottieDrawable.addValueCallback(new KeyPath("eyes", "**"), (KeyPath) colorFilter, (SimpleLottieValueCallback<KeyPath>) f316460c);
            KeyPath keyPath2 = new KeyPath(ActivateTenpayAccount.PARAM_ACTIVATE_MAP, "**");
            SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback12 = f316458a;
            lottieDrawable.addValueCallback(keyPath2, (KeyPath) colorFilter, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback12);
            lottieDrawable.addValueCallback(new KeyPath("Shape Layer 1", "**"), (KeyPath) colorFilter, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback12);
            return;
        }
        if ("conversation_back.json".equals(str)) {
            KeyPath keyPath3 = new KeyPath("normal", "**");
            ColorFilter colorFilter2 = LottieProperty.COLOR_FILTER;
            if (z16) {
                simpleLottieValueCallback10 = f316464g;
            } else {
                simpleLottieValueCallback10 = f316463f;
            }
            lottieDrawable.addValueCallback(keyPath3, (KeyPath) colorFilter2, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback10);
            lottieDrawable.addValueCallback(new KeyPath("eyes", "**"), (KeyPath) colorFilter2, (SimpleLottieValueCallback<KeyPath>) f316460c);
            KeyPath keyPath4 = new KeyPath(ActivateTenpayAccount.PARAM_ACTIVATE_MAP, "**");
            SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback13 = f316458a;
            lottieDrawable.addValueCallback(keyPath4, (KeyPath) colorFilter2, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback13);
            lottieDrawable.addValueCallback(new KeyPath("Shape Layer 1", "**"), (KeyPath) colorFilter2, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback13);
            return;
        }
        if (!"contact.json".equals(str) && !"contact_back.json".equals(str)) {
            if (!"activity.json".equals(str) && !"activity_back.json".equals(str)) {
                if (!"littleworld.json".equals(str) && !"littleworld_back.json".equals(str)) {
                    if (!"channel.json".equals(str) && !"channel_back.json".equals(str)) {
                        if ("meta_dream.json".equals(str) || "meta_dream_back.json".equals(str)) {
                            KeyPath keyPath5 = new KeyPath("yuanmeng_surface", "**");
                            ColorFilter colorFilter3 = LottieProperty.COLOR_FILTER;
                            SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback14 = f316458a;
                            lottieDrawable.addValueCallback(keyPath5, (KeyPath) colorFilter3, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback14);
                            lottieDrawable.addValueCallback(new KeyPath("Shape Layer 4", "**"), (KeyPath) colorFilter3, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback14);
                            KeyPath keyPath6 = new KeyPath("yuanmeng_line", "**");
                            if (z16) {
                                simpleLottieValueCallback9 = f316464g;
                            } else {
                                simpleLottieValueCallback9 = f316463f;
                            }
                            lottieDrawable.addValueCallback(keyPath6, (KeyPath) colorFilter3, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback9);
                        }
                    } else {
                        KeyPath keyPath7 = new KeyPath("01copy", "**");
                        ColorFilter colorFilter4 = LottieProperty.COLOR_FILTER;
                        if (z16) {
                            simpleLottieValueCallback5 = f316467j;
                        } else {
                            simpleLottieValueCallback5 = f316466i;
                        }
                        lottieDrawable.addValueCallback(keyPath7, (KeyPath) colorFilter4, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback5);
                        KeyPath keyPath8 = new KeyPath("02copy", "**");
                        if (z16) {
                            simpleLottieValueCallback6 = f316467j;
                        } else {
                            simpleLottieValueCallback6 = f316466i;
                        }
                        lottieDrawable.addValueCallback(keyPath8, (KeyPath) colorFilter4, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback6);
                        KeyPath keyPath9 = new KeyPath("03copy", "**");
                        if (z16) {
                            simpleLottieValueCallback7 = f316467j;
                        } else {
                            simpleLottieValueCallback7 = f316466i;
                        }
                        lottieDrawable.addValueCallback(keyPath9, (KeyPath) colorFilter4, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback7);
                        KeyPath keyPath10 = new KeyPath("04", "**");
                        if (z16) {
                            simpleLottieValueCallback8 = f316467j;
                        } else {
                            simpleLottieValueCallback8 = f316466i;
                        }
                        lottieDrawable.addValueCallback(keyPath10, (KeyPath) colorFilter4, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback8);
                        lottieDrawable.addValueCallback(new KeyPath("Ellipse 32", "**"), (KeyPath) colorFilter4, (SimpleLottieValueCallback<KeyPath>) f316458a);
                    }
                } else {
                    KeyPath keyPath11 = new KeyPath("\u692d\u5706\u5f62 2", "**");
                    ColorFilter colorFilter5 = LottieProperty.COLOR_FILTER;
                    SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback15 = f316459b;
                    lottieDrawable.addValueCallback(keyPath11, (KeyPath) colorFilter5, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback15);
                    lottieDrawable.addValueCallback(new KeyPath("normal", "**"), (KeyPath) colorFilter5, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback15);
                }
            } else {
                KeyPath keyPath12 = new KeyPath("Shape Layer 1", "**");
                ColorFilter colorFilter6 = LottieProperty.COLOR_FILTER;
                lottieDrawable.addValueCallback(keyPath12, (KeyPath) colorFilter6, (SimpleLottieValueCallback<KeyPath>) f316460c);
                KeyPath keyPath13 = new KeyPath("star copy 2", "**");
                if (z16) {
                    simpleLottieValueCallback3 = f316467j;
                } else {
                    simpleLottieValueCallback3 = f316465h;
                }
                lottieDrawable.addValueCallback(keyPath13, (KeyPath) colorFilter6, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback3);
                KeyPath keyPath14 = new KeyPath("normal", "**");
                if (z16) {
                    simpleLottieValueCallback4 = f316464g;
                } else {
                    simpleLottieValueCallback4 = f316463f;
                }
                lottieDrawable.addValueCallback(keyPath14, (KeyPath) colorFilter6, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback4);
                KeyPath keyPath15 = new KeyPath("Ellipse 32", "**");
                SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback16 = f316458a;
                lottieDrawable.addValueCallback(keyPath15, (KeyPath) colorFilter6, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback16);
                lottieDrawable.addValueCallback(new KeyPath("Ellipse 34", "**"), (KeyPath) colorFilter6, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback16);
                lottieDrawable.addValueCallback(new KeyPath("star", "**"), (KeyPath) colorFilter6, (SimpleLottieValueCallback<KeyPath>) f316459b);
            }
        } else {
            KeyPath keyPath16 = new KeyPath("Rectangle 617", "**");
            ColorFilter colorFilter7 = LottieProperty.COLOR_FILTER;
            if (z16) {
                simpleLottieValueCallback = f316464g;
            } else {
                simpleLottieValueCallback = f316463f;
            }
            lottieDrawable.addValueCallback(keyPath16, (KeyPath) colorFilter7, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback);
            KeyPath keyPath17 = new KeyPath("Union", "**");
            if (z16) {
                simpleLottieValueCallback2 = f316464g;
            } else {
                simpleLottieValueCallback2 = f316463f;
            }
            lottieDrawable.addValueCallback(keyPath17, (KeyPath) colorFilter7, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback2);
            KeyPath keyPath18 = new KeyPath("head", "**");
            SimpleLottieValueCallback<ColorFilter> simpleLottieValueCallback17 = f316458a;
            lottieDrawable.addValueCallback(keyPath18, (KeyPath) colorFilter7, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback17);
            lottieDrawable.addValueCallback(new KeyPath("Shape Layer 2", "**"), (KeyPath) colorFilter7, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback17);
            lottieDrawable.addValueCallback(new KeyPath("Rectangle 616", "**"), (KeyPath) colorFilter7, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback17);
            lottieDrawable.addValueCallback(new KeyPath("Shape Layer 1", "**"), (KeyPath) colorFilter7, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback17);
        }
        lottieDrawable.addAnimatorListener(new d(lottieDrawable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieDrawable f316468d;

        d(LottieDrawable lottieDrawable) {
            this.f316468d = lottieDrawable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f316468d.addValueCallback(new KeyPath("star", "**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) TabLottieHelper.f316459b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
