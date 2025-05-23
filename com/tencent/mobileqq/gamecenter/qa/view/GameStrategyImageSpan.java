package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameStrategyImageSpan extends ImageSpan implements Handler.Callback, Drawable.Callback {
    private final b C;
    private WeakReference<EditText> D;
    private int E;
    private int F;
    private a G;
    private boolean H;
    private ae I;
    private boolean J;
    private Paint K;
    private Drawable L;
    private Rect M;
    private Rect N;
    private Rect P;
    private Rect Q;
    private Rect R;
    private int S;

    /* renamed from: d, reason: collision with root package name */
    private int f212885d;

    /* renamed from: e, reason: collision with root package name */
    private int f212886e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f212887f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f212888h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f212889i;

    /* renamed from: m, reason: collision with root package name */
    private final WeakReferenceHandler f212890m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface ClickType {
        public static final int DELETE = 0;
        public static final int EDIT_PIC = 3;
        public static final int RETRY = 1;
        public static final int VIDEO_PLAY = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface Status {
        public static final int FAIL = 2;
        public static final int LOADING = 0;
        public static final int SUCCESS = 1;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void onClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f212891a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f212892b;

        /* renamed from: c, reason: collision with root package name */
        public String f212893c;

        /* renamed from: d, reason: collision with root package name */
        public int f212894d;

        /* renamed from: e, reason: collision with root package name */
        public int f212895e;

        /* renamed from: f, reason: collision with root package name */
        public String f212896f;

        /* renamed from: g, reason: collision with root package name */
        public String f212897g;

        /* renamed from: h, reason: collision with root package name */
        public long f212898h;

        /* renamed from: i, reason: collision with root package name */
        public int f212899i;

        public String a() {
            String str = this.f212892b;
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            String str2 = this.f212893c;
            if (str2 != null) {
                return String.valueOf(str2.hashCode());
            }
            return "";
        }
    }

    public GameStrategyImageSpan(@NonNull Drawable drawable, int i3, int i16) {
        super(drawable);
        this.f212890m = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.C = new b();
        this.D = new WeakReference<>(null);
        this.F = 0;
        this.K = new Paint();
        this.M = new Rect();
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new Rect();
        this.R = new Rect();
        drawable.setCallback(this);
        s(i3, i16);
    }

    private void A() {
        EditText editText = this.D.get();
        if (editText != null) {
            ViewCompat.postOnAnimation(editText, new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.t
                @Override // java.lang.Runnable
                public final void run() {
                    GameStrategyImageSpan.this.u();
                }
            });
        }
    }

    private void K() {
        Editable editableText;
        int spanStart;
        EditText editText = this.D.get();
        if (editText != null && (spanStart = (editableText = editText.getEditableText()).getSpanStart(this)) >= 0) {
            editableText.setSpan(this, spanStart, editableText.getSpanEnd(this), 33);
            if (QLog.isColorLevel()) {
                QLog.d("GameStrategyImageSpan", 2, "updateCurrentSpan");
            }
        }
    }

    public static GameStrategyImageSpan d(Context context, int i3, String str, String str2, int i16, int i17) {
        int[] iArr;
        String str3;
        int[] iArr2 = new int[2];
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            iArr = com.tencent.mobileqq.gamecenter.qa.util.k.j(str, m(i3), l(i3));
            str3 = str;
        } else if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
            iArr = com.tencent.mobileqq.gamecenter.qa.util.k.i(i16, i17, m(i3), l(i3));
        } else {
            iArr = iArr2;
            str3 = "";
        }
        URLDrawable m3 = com.tencent.mobileqq.gamecenter.qa.util.k.m(str3, k(iArr[0], iArr[1]));
        GameStrategyImageSpan gameStrategyImageSpan = new GameStrategyImageSpan(m3, iArr[0], iArr[1]);
        gameStrategyImageSpan.F(str2, str, i16, i17, 0);
        gameStrategyImageSpan.D(i3);
        QLog.i("GameStrategyImageSpan", 2, "[createImageSpan],drawableWidth:" + iArr[0] + ",drawableHeight:" + iArr[1] + ",drawable:" + m3 + ",finalUrl:" + str3);
        return gameStrategyImageSpan;
    }

    public static GameStrategyImageSpan e(String str, int i3, String str2, String str3, int i16, int i17) {
        String str4;
        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
            str4 = str2;
        } else if (!TextUtils.isEmpty(str)) {
            str4 = str;
        } else {
            str4 = "";
        }
        int[] k3 = com.tencent.mobileqq.gamecenter.qa.util.k.k(str2, m(i3), i16, i17);
        URLDrawable m3 = com.tencent.mobileqq.gamecenter.qa.util.k.m(str4, k(k3[0], k3[1]));
        GameStrategyImageSpan gameStrategyImageSpan = new GameStrategyImageSpan(m3, k3[0], k3[1]);
        gameStrategyImageSpan.v();
        gameStrategyImageSpan.F(str3, str2, i16, i17, 1);
        gameStrategyImageSpan.q().f212897g = str;
        gameStrategyImageSpan.D(i3);
        QLog.i("GameStrategyImageSpan", 2, "[createVideoSpan],drawableWidth:" + k3[0] + ",drawableHeight:" + k3[1] + ",drawable:" + m3 + ",finalUrl:" + str4);
        return gameStrategyImageSpan;
    }

    private void f(@NonNull Canvas canvas, int i3, int i16, int i17) {
        canvas.save();
        int i18 = (int) (com.tencent.mobileqq.utils.ah.f307408i * 10.0f);
        int width = this.f212888h.getBounds().width();
        int height = this.f212888h.getBounds().height();
        int i19 = ((i16 + i3) - i18) - (width / 2);
        int i26 = height / 2;
        int i27 = i18 + i26;
        if (getDrawable() == null || getDrawable().getBounds().height() >= i18 + height) {
            i26 = i27;
        }
        canvas.translate(i19, i26);
        this.f212888h.draw(canvas);
        canvas.restore();
        int i28 = i26 + i17;
        this.P = new Rect(i19 - this.f212888h.getBounds().width(), i28 - this.f212888h.getBounds().height(), i19 + this.f212888h.getBounds().width(), i28 + this.f212888h.getBounds().height());
    }

    private void g(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18) {
        canvas.save();
        canvas.translate(i17, 0.0f);
        paint.setTextSize(com.tencent.mobileqq.utils.ah.f307408i * 14.0f);
        paint.setColor(DownloadCardView.COLOR_APP_VERSION);
        float measureText = paint.measureText("\u52a0\u8f7d\u5931\u8d25");
        float f16 = com.tencent.mobileqq.utils.ah.f307408i * 20.0f;
        float f17 = i3;
        float f18 = (f17 - measureText) / 2.0f;
        int i19 = i16 / 2;
        float f19 = i19;
        canvas.drawText("\u52a0\u8f7d\u5931\u8d25", f18, f19 - f16, paint);
        canvas.save();
        float width = (this.f212887f.getBounds().width() / 2) + f18;
        canvas.translate(width, f19);
        this.f212887f.draw(canvas);
        canvas.restore();
        canvas.translate(width + this.f212887f.getBounds().width(), f19 + (this.f212887f.getBounds().height() / 3));
        paint.setColor(RichStatus.TOPIC_COLOR);
        canvas.drawText("\u91cd\u8bd5", 0.0f, 0.0f, paint);
        canvas.restore();
        int i26 = i18 + i19;
        this.Q = new Rect(((int) f18) + i17, (int) (i26 - f16), i17 + ((int) ((f17 + measureText) / 2.0f)), i26 + this.f212887f.getBounds().height());
    }

    private void h(Canvas canvas, int i3, int i16, int i17) {
        canvas.save();
        canvas.clipRect(i16, 0, i3 + i16, i17);
        canvas.drawColor(Integer.MIN_VALUE);
        canvas.restore();
    }

    private void i(@NonNull Canvas canvas, int i3, int i16) {
        canvas.save();
        canvas.translate(i3, i16);
        this.I.e(canvas);
        canvas.restore();
    }

    private void j(Canvas canvas, int i3, int i16, int i17, int i18) {
        canvas.save();
        int i19 = i3 / 2;
        int i26 = i16 / 2;
        canvas.translate(i19, i26);
        this.f212889i.draw(canvas);
        canvas.restore();
        int i27 = i17 + i19;
        int i28 = i18 + i26;
        this.R = new Rect(i27 - (this.f212889i.getBounds().width() / 2), i28 - (this.f212889i.getBounds().height() / 2), i27 + (this.f212889i.getBounds().width() / 2), i28 + (this.f212889i.getBounds().height() / 2));
    }

    private static URLDrawable.URLDrawableOptions k(int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (i3 > 0 && i16 > 0) {
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
        }
        obtain.mLoadingDrawable = new ColorDrawable(14211288);
        obtain.mFailedDrawable = new ColorDrawable(14211288);
        obtain.mGifRoundCorner = 0.0f;
        obtain.mPlayGifImage = true;
        return obtain;
    }

    private static int l(int i3) {
        return (i3 * 16) / 9;
    }

    private static int m(int i3) {
        return i3 - 10;
    }

    private static Resources o() {
        return BaseApplication.getContext().getResources();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void s(int i3, int i16) {
        this.K.setColor(RichStatus.TOPIC_COLOR);
        this.K.setStrokeWidth(com.tencent.aio.base.tool.a.INSTANCE.b(BaseApplication.getContext(), 2));
        this.K.setStyle(Paint.Style.STROKE);
        this.f212885d = i3;
        this.f212886e = i16;
        this.f212888h = o().getDrawable(R.drawable.mwy);
        this.f212887f = o().getDrawable(R.drawable.mx6);
        this.f212889i = o().getDrawable(R.drawable.mxa);
        Drawable drawable = o().getDrawable(R.drawable.mvu);
        this.L = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.L.getIntrinsicHeight());
        t(this.f212888h);
        t(this.f212887f);
        t(this.f212889i);
        ae aeVar = new ae();
        this.I = aeVar;
        aeVar.j(this.f212885d, this.f212886e);
        QLog.i("GameStrategyImageSpan", 1, "[init] mDrawableWidth:" + this.f212885d + ",mDrawableHeight:" + this.f212886e);
    }

    private void t(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
            drawable.setBounds(-intrinsicWidth, -intrinsicHeight, intrinsicWidth, intrinsicHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f212890m.removeMessages(15);
        this.f212890m.sendEmptyMessage(15);
    }

    private void v() {
        this.H = true;
    }

    private void w(int i3) {
        a aVar = this.G;
        if (aVar != null) {
            aVar.onClick(i3);
        }
        QLog.i("GameStrategyImageSpan", 1, "[notifyClickListener] " + this + ",mSpanClickListener:" + this.G);
    }

    public void B() {
        this.J = false;
        this.f212890m.removeMessages(16);
        this.f212890m.removeMessages(15);
        this.f212890m.sendEmptyMessage(15);
    }

    public void C(a aVar) {
        this.G = aVar;
    }

    public void D(int i3) {
        this.E = i3;
    }

    public void E(String str) {
        this.C.f212893c = str;
    }

    public void F(String str, String str2, int i3, int i16, int i17) {
        b bVar = this.C;
        bVar.f212892b = str2;
        bVar.f212893c = str;
        bVar.f212894d = i3;
        bVar.f212895e = i16;
        bVar.f212891a = i17;
        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
            if (i3 <= 0 || i16 <= 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str2, options);
                b bVar2 = this.C;
                bVar2.f212894d = options.outWidth;
                bVar2.f212895e = options.outHeight;
            }
        }
    }

    public void G(boolean z16) {
        this.I.n(z16);
    }

    public void H(long j3) {
        this.C.f212898h = j3;
    }

    public void I(String str) {
        this.C.f212896f = str;
    }

    public void J(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("GameStrategyImageSpan", 2, "[changeState] oldState:" + this.F + ",curState:" + i3);
        }
        this.F = i3;
        this.f212890m.removeMessages(15);
        this.f212890m.sendEmptyMessage(15);
    }

    public GameStrategyImageSpan L(EditText editText) {
        if (editText == null) {
            return this;
        }
        this.D = new WeakReference<>(editText);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.1
            @Override // java.lang.Runnable
            public void run() {
                GameStrategyImageSpan.this.J(1);
            }
        }, 200L);
        return this;
    }

    public GameStrategyImageSpan b(EditText editText) {
        if (TextUtils.isEmpty(this.C.f212892b)) {
            QLog.e("GameStrategyImageSpan", 1, "bindTextView localPath is empty");
            return this;
        }
        this.D = new WeakReference<>(editText);
        Editable editableText = editText.getEditableText();
        int selectionStart = editText.getSelectionStart();
        String n3 = n(true);
        SpannableString spannableString = new SpannableString(n3);
        spannableString.setSpan(this, 0, n3.length() - 1, 33);
        if (selectionStart >= 0 && selectionStart < editableText.length()) {
            editableText.insert(selectionStart, spannableString);
            editText.setSelection(selectionStart + spannableString.length());
        } else {
            editableText.append((CharSequence) spannableString);
            editText.setSelection(editableText.length());
        }
        editText.requestFocus();
        J(0);
        return this;
    }

    public GameStrategyImageSpan c() {
        GameStrategyImageSpan gameStrategyImageSpan = new GameStrategyImageSpan(getDrawable(), this.f212885d, this.f212886e);
        b bVar = this.C;
        gameStrategyImageSpan.F(bVar.f212893c, bVar.f212892b, bVar.f212894d, bVar.f212895e, bVar.f212891a);
        gameStrategyImageSpan.q().f212896f = this.C.f212896f;
        gameStrategyImageSpan.D(this.E);
        gameStrategyImageSpan.F = this.F;
        if (this.H) {
            gameStrategyImageSpan.v();
        }
        gameStrategyImageSpan.D = new WeakReference<>(this.D.get());
        gameStrategyImageSpan.G = this.G;
        return gameStrategyImageSpan;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006f  */
    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        int height;
        int i26;
        int scrollY;
        QLog.d("GameStrategyImageSpan", 2, "draw");
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, this.f212885d, this.f212886e);
            int width = drawable.getBounds().width();
            int i27 = (this.E - width) / 2;
            int i28 = i19 - drawable.getBounds().bottom;
            int i29 = ((ImageSpan) this).mVerticalAlignment;
            if (i29 == 1) {
                height = paint.getFontMetricsInt().descent;
            } else {
                if (i29 == 2) {
                    i28 = (i19 - i17) / 2;
                    height = drawable.getBounds().height() / 2;
                }
                this.S = i28;
                canvas.save();
                float f17 = i27 + f16;
                float f18 = i28;
                canvas.translate(f17, f18);
                drawable.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.translate(f16, f18);
                int height2 = drawable.getBounds().height();
                i26 = this.F;
                if (i26 != 0) {
                    h(canvas, width, i27, height2);
                    i(canvas, i27, 0);
                    A();
                } else if (i26 == 2) {
                    h(canvas, width, i27, height2);
                    g(canvas, paint, width, height2, i27, i28);
                } else if (i26 == 1 && this.H) {
                    j(canvas, width, height2, i27, i28);
                }
                f(canvas, width, i27, i28);
                canvas.restore();
                if (this.F != 1 && !this.H && this.J) {
                    canvas.save();
                    canvas.translate(f17, f18);
                    canvas.drawRect(new Rect(0, 0, this.f212885d, this.f212886e), this.K);
                    canvas.restore();
                    canvas.save();
                    int i36 = this.f212886e + i28;
                    EditText editText = this.D.get();
                    if (editText != null && (editText.getParent() instanceof View) && ((View) editText.getParent()).getScrollY() > i28) {
                        i28 = ((View) editText.getParent()).getScrollY();
                    }
                    if (editText != null && (editText.getParent() instanceof View) && i36 > (scrollY = ((View) editText.getParent()).getScrollY() + ((View) editText.getParent()).getHeight())) {
                        i36 = scrollY;
                    }
                    canvas.translate(f17, i28);
                    int intrinsicWidth = (this.f212885d - this.L.getIntrinsicWidth()) / 2;
                    int intrinsicHeight = ((i36 - i28) - this.L.getIntrinsicHeight()) / 2;
                    float f19 = intrinsicWidth;
                    canvas.translate(f19, intrinsicHeight);
                    this.L.draw(canvas);
                    canvas.restore();
                    int i37 = (int) (f17 + f19);
                    int intrinsicWidth2 = (this.L.getIntrinsicWidth() / 2) + i37;
                    int i38 = i28 + intrinsicHeight;
                    int intrinsicHeight2 = this.L.getIntrinsicHeight() + i38;
                    this.M.set(i37, i38, intrinsicWidth2, intrinsicHeight2);
                    this.N = new Rect(intrinsicWidth2, i38, (this.L.getIntrinsicWidth() / 2) + intrinsicWidth2, intrinsicHeight2);
                    return;
                }
                return;
            }
            i28 -= height;
            this.S = i28;
            canvas.save();
            float f172 = i27 + f16;
            float f182 = i28;
            canvas.translate(f172, f182);
            drawable.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(f16, f182);
            int height22 = drawable.getBounds().height();
            i26 = this.F;
            if (i26 != 0) {
            }
            f(canvas, width, i27, i28);
            canvas.restore();
            if (this.F != 1) {
                return;
            } else {
                return;
            }
        }
        super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        super.getSize(paint, charSequence, i3, i16, fontMetricsInt);
        return this.E;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i3 = message.what;
        if (i3 != 15) {
            if (i3 == 16) {
                this.J = !this.J;
                this.f212890m.removeMessages(15);
                this.f212890m.sendEmptyMessage(15);
                return false;
            }
            return false;
        }
        K();
        QLog.d("GameStrategyImageSpan", 2, "handleMessage,what:" + message.what);
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        this.f212890m.removeMessages(15);
        this.f212890m.sendEmptyMessage(15);
        if (QLog.isColorLevel()) {
            QLog.i("GameStrategyImageSpan", 2, "[invalidateDrawable]");
        }
    }

    @NonNull
    public String n(boolean z16) {
        String str = "{{pic:" + this.C.a() + "}}";
        if (this.C.f212891a == 1) {
            str = "{{video:" + this.C.a() + "}}";
        }
        if (z16) {
            return str + "\n";
        }
        return str;
    }

    public int p() {
        return this.S;
    }

    public b q() {
        return this.C;
    }

    public void r() {
        EditText editText = this.D.get();
        if (editText == null) {
            return;
        }
        Editable editableText = editText.getEditableText();
        int spanStart = editableText.getSpanStart(this);
        int spanEnd = editableText.getSpanEnd(this);
        if (spanStart >= 0 && spanEnd <= editableText.length()) {
            editableText.delete(spanStart, spanEnd);
            int selectionStart = editText.getSelectionStart();
            if (selectionStart >= spanEnd) {
                editText.setSelection(selectionStart - (spanEnd - spanStart));
            }
        }
        w(0);
    }

    public void x(TextView textView, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("GameStrategyImageSpan", 2, "onClick touchX:", Integer.valueOf(i3), " touchY:", Integer.valueOf(i16), "mDeleteClickRect:", this.P);
        }
        if (this.D.get() == null) {
            return;
        }
        if (this.P.contains(i3, i16)) {
            r();
            return;
        }
        if (this.F == 2 && this.Q.contains(i3, i16)) {
            w(1);
            return;
        }
        if (this.F == 1 && this.R.contains(i3, i16)) {
            w(2);
            return;
        }
        if (!this.H) {
            if (this.J && this.M.contains(i3, i16)) {
                w(3);
                return;
            }
            if (this.J && this.N.contains(i3, i16)) {
                r();
            } else if (this.F == 1) {
                this.f212890m.removeMessages(16);
                this.f212890m.sendEmptyMessageDelayed(16, 300L);
            }
        }
    }

    public void y(float f16, String str) {
        this.I.l(f16, str);
    }

    public void z(float f16, String str) {
        this.I.m(f16, str);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
    }
}
