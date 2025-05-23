package com.tencent.android.androidbypass.enhance;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h implements Bypass.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    g f72146a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: v, reason: collision with root package name */
        private static int f72147v;

        /* renamed from: m, reason: collision with root package name */
        private final String f72148m;

        /* renamed from: n, reason: collision with root package name */
        private final WeakReference<TextView> f72149n;

        /* renamed from: o, reason: collision with root package name */
        private String f72150o;

        /* renamed from: p, reason: collision with root package name */
        private String f72151p;

        /* renamed from: q, reason: collision with root package name */
        private Integer f72152q;

        /* renamed from: r, reason: collision with root package name */
        private String f72153r;

        /* renamed from: s, reason: collision with root package name */
        private Resources f72154s;

        /* renamed from: t, reason: collision with root package name */
        private int f72155t;

        /* renamed from: u, reason: collision with root package name */
        private Context f72156u;

        /* compiled from: P */
        /* renamed from: com.tencent.android.androidbypass.enhance.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class ViewTreeObserverOnGlobalLayoutListenerC0718a implements ViewTreeObserver.OnGlobalLayoutListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TextView f72157d;

            ViewTreeObserverOnGlobalLayoutListenerC0718a(TextView textView) {
                this.f72157d = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) textView);
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                this.f72157d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int b16 = (int) c.a(this.f72157d.getContext()).b((this.f72157d.getMeasuredWidth() - this.f72157d.getPaddingLeft()) - this.f72157d.getPaddingRight());
                if (b16 != a.this.f72155t) {
                    a.this.f72155t = b16;
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f72157d.setTag(-619017319, Integer.valueOf(a.this.f72155t));
                int unused = a.f72147v = a.this.f72155t;
                a.this.E();
                if (z16) {
                    a.this.D();
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8320);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 15)) {
                redirector.redirect((short) 15);
            } else {
                f72147v = 0;
            }
        }

        a(String str, String str2, TextView textView) {
            super(str, str2, new b.c());
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, textView);
                return;
            }
            this.f72155t = 360;
            this.f72148m = str;
            this.f72151p = str2;
            this.f72156u = textView.getContext().getApplicationContext();
            this.f72154s = textView.getContext().getResources();
            if (textView.getTag(-619017319) != null) {
                this.f72155t = ((Integer) textView.getTag(-619017319)).intValue();
            } else {
                int i3 = f72147v;
                if (i3 != 0) {
                    this.f72155t = i3;
                }
            }
            this.f72149n = new WeakReference<>(textView);
            E();
            if (A(this.f72151p) != null) {
                num = Integer.valueOf(u(r8.intValue()));
            } else {
                num = null;
            }
            this.f72152q = num;
            this.f72153r = w(this.f72151p);
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0718a(textView));
            setBounds(0, 0, this.f72162d, this.f72163e);
        }

        public static Integer A(String str) {
            if (str == null) {
                return null;
            }
            Matcher matcher = Pattern.compile("cornerRadius=\\d+").matcher(str);
            if (matcher.find()) {
                try {
                    return Integer.valueOf(Integer.parseInt(matcher.group().split(ContainerUtils.KEY_VALUE_DELIMITER)[1]));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }

        public static int[] B(String str) {
            if (str != null && str.contains("#")) {
                String[] split = str.split("#");
                if (split.length >= 2) {
                    try {
                        return new int[]{Integer.parseInt(split[split.length - 2].trim().replace("px", "")), Integer.parseInt(split[split.length - 1].trim().replace("px", ""))};
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D() {
            Drawable drawable = this.f72159a;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.f72162d, this.f72163e);
            }
            setBounds(0, 0, this.f72162d, this.f72163e);
            if (this.f72149n.get() != null) {
                TextView textView = this.f72149n.get();
                textView.setText(textView.getText());
            } else {
                com.tencent.android.androidbypass.config.a.f72049a.e("ImageGetter", "setDrawable: reference is null");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E() {
            int[] B = B(this.f72151p);
            if (B != null) {
                int[] F = F(this.f72155t, 600, B[0], B[1]);
                this.f72162d = u(F[0]);
                this.f72163e = u(F[1]);
                String[] split = this.f72148m.split(" ");
                if (split.length >= 2) {
                    this.f72150o = split[0];
                    return;
                } else {
                    this.f72150o = this.f72148m;
                    return;
                }
            }
            throw new IllegalArgumentException(" can't get wh");
        }

        private int u(float f16) {
            return (int) (TypedValue.applyDimension(1, f16, this.f72154s.getDisplayMetrics()) + 0.5d);
        }

        public static String w(String str) {
            if (str == null) {
                return null;
            }
            Matcher matcher = Pattern.compile("scheme=\"(.*?)\"").matcher(str);
            if (!matcher.find()) {
                return null;
            }
            String str2 = matcher.group().split(ContainerUtils.KEY_VALUE_DELIMITER, 2)[1];
            return str2.substring(1, str2.length() - 1);
        }

        public int C() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f72162d;
        }

        public int[] F(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (int[]) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            }
            if (i16 > 0 && i3 >= 0 && i17 > 0 && i18 > 0) {
                if (i17 / i18 > i3 / i16) {
                    int[] iArr = new int[2];
                    if (i17 > i3) {
                        iArr[0] = i3;
                        iArr[1] = (i18 * i3) / i17;
                    } else {
                        iArr[0] = i17;
                        iArr[1] = i18;
                    }
                    return iArr;
                }
                int[] iArr2 = new int[2];
                if (i18 > i16) {
                    iArr2[0] = (i17 * i16) / i18;
                    iArr2[1] = i16;
                } else {
                    iArr2[0] = i17;
                    iArr2[1] = i18;
                }
                return iArr2;
            }
            return new int[]{Math.min(i17, i3), Math.min(i18, i16)};
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b
        public void b(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) drawable);
                return;
            }
            super.b(drawable);
            if (this.f72162d == 0 || this.f72163e == 0) {
                int[] F = F(this.f72155t, 600, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.f72162d = u(F[0]);
                this.f72163e = u(F[1]);
            }
            D();
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b
        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f72151p;
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b
        public String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f72150o;
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return -1;
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return -1;
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b
        public void l(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable);
            } else {
                super.l(drawable);
                D();
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.h.b
        public void m(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
                return;
            }
            this.f72160b = drawable;
            com.tencent.android.androidbypass.config.a.f72049a.d("ImageGetter", "setLoadingDrawable = " + getBounds());
            Drawable drawable2 = this.f72160b;
            if (drawable2 != null) {
                drawable2.setBounds(getBounds());
            }
        }

        public String v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.f72153r;
        }

        public Context x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Context) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.f72156u;
        }

        public int y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f72163e;
        }

        public int z(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
            }
            Integer num = this.f72152q;
            if (num != null) {
                return num.intValue();
            }
            return i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends Drawable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected Drawable f72159a;

        /* renamed from: b, reason: collision with root package name */
        protected Drawable f72160b;

        /* renamed from: c, reason: collision with root package name */
        protected Drawable f72161c;

        /* renamed from: d, reason: collision with root package name */
        protected int f72162d;

        /* renamed from: e, reason: collision with root package name */
        protected int f72163e;

        /* renamed from: f, reason: collision with root package name */
        private final String f72164f;

        /* renamed from: g, reason: collision with root package name */
        private final String f72165g;

        /* renamed from: h, reason: collision with root package name */
        private final c f72166h;

        /* renamed from: i, reason: collision with root package name */
        private volatile Map<String, Object> f72167i;

        /* renamed from: j, reason: collision with root package name */
        private InterfaceC0719b f72168j;

        /* renamed from: k, reason: collision with root package name */
        private WeakReference<Consumer<Drawable>> f72169k;

        /* renamed from: l, reason: collision with root package name */
        private final Drawable.Callback f72170l;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements Drawable.Callback {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                    return;
                }
                Drawable.Callback callback = b.this.getCallback();
                if (callback != null) {
                    callback.invalidateDrawable(drawable);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, drawable, runnable, Long.valueOf(j3));
                    return;
                }
                Drawable.Callback callback = b.this.getCallback();
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j3);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) runnable);
                    return;
                }
                Drawable.Callback callback = b.this.getCallback();
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.android.androidbypass.enhance.h$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC0719b {
            @Nullable
            Drawable a(@Nullable Drawable drawable);

            @Nullable
            Drawable b(@Nullable Bitmap bitmap);
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static class c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public long f72172a;

            /* renamed from: b, reason: collision with root package name */
            @Nullable
            public Size f72173b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f72174c;

            /* renamed from: d, reason: collision with root package name */
            @Nullable
            public ImageView.ScaleType f72175d;

            public c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public b(@NonNull String str, @Nullable String str2, @Nullable c cVar) {
            Size size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, cVar);
                return;
            }
            this.f72162d = -1;
            this.f72163e = -1;
            this.f72170l = new a();
            this.f72164f = str;
            this.f72165g = str2;
            this.f72166h = cVar;
            if (cVar != null) {
                size = cVar.f72173b;
            } else {
                size = null;
            }
            if (size != null) {
                this.f72162d = size.getWidth();
                this.f72163e = size.getHeight();
            }
        }

        private void a(@Nullable Drawable drawable) {
            if (drawable != null) {
                drawable.setBounds(getBounds());
            }
        }

        public void b(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
                return;
            }
            if (drawable != null) {
                drawable.setCallback(this.f72170l);
            }
            this.f72159a = drawable;
            j(drawable);
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (String) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return this.f72165g;
        }

        @NonNull
        public Map<String, Object> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Map) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            if (this.f72167i == null) {
                synchronized (this) {
                    if (this.f72167i == null) {
                        this.f72167i = new ConcurrentHashMap();
                    }
                }
            }
            return this.f72167i;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
                return;
            }
            Drawable drawable = this.f72159a;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            Drawable drawable2 = this.f72161c;
            if (drawable2 != null) {
                drawable2.draw(canvas);
                return;
            }
            Drawable drawable3 = this.f72160b;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
        }

        @Nullable
        public c e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (c) iPatchRedirector.redirect((short) 27, (Object) this);
            }
            return this.f72166h;
        }

        @Nullable
        public final Drawable f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Drawable) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            return this.f72159a;
        }

        public String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return this.f72164f;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.f72163e;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.f72162d;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            Drawable drawable = this.f72159a;
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return 0;
        }

        public void h(@Nullable InterfaceC0719b interfaceC0719b) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) interfaceC0719b);
            } else {
                this.f72168j = interfaceC0719b;
            }
        }

        public boolean i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.f72159a != null) {
                return true;
            }
            return false;
        }

        @CallSuper
        protected void j(@Nullable Drawable drawable) {
            Consumer<Drawable> consumer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
                return;
            }
            a(drawable);
            invalidateSelf();
            WeakReference<Consumer<Drawable>> weakReference = this.f72169k;
            if (weakReference != null) {
                consumer = weakReference.get();
            } else {
                consumer = null;
            }
            if (consumer != null) {
                consumer.accept(drawable);
            }
        }

        public void k(@Nullable Consumer<Drawable> consumer) {
            WeakReference<Consumer<Drawable>> weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) consumer);
                return;
            }
            if (consumer != null) {
                weakReference = new WeakReference<>(consumer);
            } else {
                weakReference = null;
            }
            this.f72169k = weakReference;
            Drawable drawable = this.f72159a;
            if (drawable != null && consumer != null) {
                consumer.accept(drawable);
            }
        }

        public void l(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
            } else {
                this.f72161c = drawable;
                a(drawable);
            }
        }

        public void m(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
                return;
            }
            this.f72160b = drawable;
            com.tencent.android.androidbypass.config.a.f72049a.d("ImageGetter", "[" + hashCode() + "]: setLoadingDrawable = " + getBounds());
            a(drawable);
        }

        public final void n(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
                return;
            }
            InterfaceC0719b interfaceC0719b = this.f72168j;
            if (interfaceC0719b != null) {
                drawable = interfaceC0719b.a(drawable);
            }
            b(drawable);
        }

        public final void o(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
                return;
            }
            InterfaceC0719b interfaceC0719b = this.f72168j;
            if (interfaceC0719b != null) {
                b(interfaceC0719b.b(bitmap));
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, i3);
                return;
            }
            Drawable drawable = this.f72159a;
            if (drawable != null) {
                drawable.setAlpha(i3);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            super.setBounds(i3, i16, i17, i18);
            a(this.f72159a);
            a(this.f72160b);
            a(this.f72161c);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) colorFilter);
                return;
            }
            Drawable drawable = this.f72159a;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public h(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
        } else {
            this.f72146a = gVar;
        }
    }

    @Override // com.tencent.android.androidbypass.Bypass.e
    public Drawable a(long j3, String str, String str2, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, textView);
        }
        try {
            a aVar = new a(str, str2, textView);
            this.f72146a.c(str, aVar);
            b.c e16 = aVar.e();
            if (e16 != null) {
                e16.f72172a = j3;
            }
            aVar.m(this.f72146a.b(textView.getContext()));
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.android.androidbypass.Bypass.e
    @NonNull
    public b b(@Nullable Context context, @NonNull String str, @Nullable b.c cVar, @Nullable b.InterfaceC0719b interfaceC0719b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, context, str, cVar, interfaceC0719b);
        }
        b bVar = new b(str, null, cVar);
        bVar.h(interfaceC0719b);
        try {
            this.f72146a.a(context, str, bVar);
            bVar.m(this.f72146a.b(context));
        } catch (Exception unused) {
            com.tencent.android.androidbypass.config.a.f72049a.e("ImageGetter", "getProxyDrawable for [" + str + "] failed");
        }
        return bVar;
    }
}
