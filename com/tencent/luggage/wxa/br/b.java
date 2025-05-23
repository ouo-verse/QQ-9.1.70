package com.tencent.luggage.wxa.br;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.tenpay.ndk.FitScUtil;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends AppCompatEditText {
    public boolean C;
    public byte[] D;

    /* renamed from: a, reason: collision with root package name */
    public FitScUtil f123124a;

    /* renamed from: b, reason: collision with root package name */
    public String f123125b;

    /* renamed from: c, reason: collision with root package name */
    public String f123126c;

    /* renamed from: d, reason: collision with root package name */
    public long f123127d;

    /* renamed from: e, reason: collision with root package name */
    public long f123128e;

    /* renamed from: f, reason: collision with root package name */
    public e f123129f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f123130g;

    /* renamed from: h, reason: collision with root package name */
    public float f123131h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f123132i;

    /* renamed from: j, reason: collision with root package name */
    public char[] f123133j;

    /* renamed from: k, reason: collision with root package name */
    public char[] f123134k;

    /* renamed from: l, reason: collision with root package name */
    public int f123135l;

    /* renamed from: m, reason: collision with root package name */
    public int f123136m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (!z16) {
                b bVar = b.this;
                bVar.setCompoundDrawables(bVar.getCompoundDrawables()[0], b.this.getCompoundDrawables()[1], null, b.this.getCompoundDrawables()[3]);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.br.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnTouchListenerC6087b implements View.OnTouchListener {
        public ViewOnTouchListenerC6087b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
        super(context, null);
        this.f123135l = 6;
        this.f123136m = 6;
        this.C = true;
    }

    private String getInputText() {
        return super.getText().toString().trim();
    }

    private void setBlackListChar(char[] cArr) {
        this.f123134k = cArr;
    }

    private void setClearBtnDrawableId(int i3) {
        try {
            this.f123132i = getResources().getDrawable(i3);
        } catch (Exception unused) {
            this.f123132i = null;
        }
        Drawable drawable = this.f123132i;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f123132i.getIntrinsicHeight());
            setOnFocusChangeListener(new a());
            setOnTouchListener(new ViewOnTouchListenerC6087b());
        } else {
            setOnFocusChangeListener(new c());
            setOnTouchListener(new d());
        }
    }

    private void setIsPasswordFormat(boolean z16) {
        if (z16) {
            setPadding(-1500000, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            Paint paint = new Paint(1);
            this.f123130g = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f123130g.setColor(-16777216);
            setInputType(2);
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f123136m)});
            return;
        }
        this.f123130g = null;
    }

    private void setWhiteListChar(char[] cArr) {
        this.f123133j = cArr;
    }

    public void a(int i3, int i16) {
        this.f123135l = i3;
        this.f123136m = i16;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i16)});
        this.C = i3 == i16;
    }

    public void b() {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        this.D = this.f123124a.md5(this.D);
    }

    public void c() {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        this.D = this.f123124a.sha1(this.D);
    }

    public void d() {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        this.D = this.f123124a.sha256(this.D);
    }

    public void e() {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        this.D = this.f123124a.sm3(this.D);
    }

    public String getEncryptedData() {
        String encryptPassWithCert;
        String inputText = getInputText();
        if (!TextUtils.isEmpty(inputText) && inputText.length() >= this.f123135l && this.f123126c != null && this.f123127d != 0 && this.f123128e != 0) {
            synchronized (FitScUtil.f386595a) {
                encryptPassWithCert = this.f123124a.encryptPassWithCert(this.f123125b, inputText.getBytes(), this.f123126c.getBytes(), this.f123127d, String.valueOf(this.f123128e), 7, false);
            }
            return encryptPassWithCert;
        }
        return null;
    }

    public int getLastError() {
        return this.f123124a.getLastError();
    }

    public String getVersion() {
        return this.f123124a.getVersion();
    }

    @Override // android.widget.TextView, android.view.View
    public void onCreateContextMenu(ContextMenu contextMenu) {
        if ((getInputType() & 128) <= 0) {
            super.onCreateContextMenu(contextMenu);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        synchronized (FitScUtil.f386595a) {
            FitScUtil fitScUtil = this.f123124a;
            if (fitScUtil != null) {
                fitScUtil.release();
                this.f123124a = null;
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        e eVar;
        super.onTextChanged(charSequence, i3, i16, i17);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        for (int i18 = i3; i18 < i3 + i17; i18++) {
            if (!a(charSequence.charAt(i18))) {
                String charSequence2 = charSequence.toString();
                setText(charSequence2.substring(0, i18) + charSequence2.substring(i18 + 1));
                setSelection(i18);
                return;
            }
        }
        if (this.C && charSequence.length() == this.f123136m && (eVar = this.f123129f) != null) {
            eVar.a();
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if ((getInputType() & 128) > 0) {
            return true;
        }
        return super.onTextContextMenuItem(i3);
    }

    public void setNonce(long j3) {
        this.f123128e = j3;
    }

    public void setOnPasswdInputListener(e eVar) {
        this.f123129f = eVar;
    }

    public void setSalt(String str) {
        this.f123126c = str;
    }

    public void setTimeStamp(long j3) {
        this.f123127d = j3;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        byte[] bArr = new byte[this.D.length + str.length()];
        System.arraycopy(str.getBytes(), 0, bArr, 0, str.length());
        System.arraycopy(this.D, 0, bArr, str.length(), this.D.length);
        this.D = bArr;
    }

    public final boolean a(char c16) {
        boolean z16;
        char[] cArr = this.f123133j;
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = true;
                    break;
                }
                if (cArr[i3] == c16) {
                    z16 = false;
                    break;
                }
                i3++;
            }
            if (z16) {
                return false;
            }
        }
        if (this.f123134k != null) {
            for (char c17 : this.f123133j) {
                if (c17 == c16) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i3 = width / this.f123136m;
        int length = getInputText().length();
        for (int i16 = 0; i16 < length; i16++) {
            canvas.drawCircle((i3 / 2) + (i16 * i3), height / 2, this.f123131h * 7.0f, this.f123130g);
        }
    }

    public boolean a(String str, String str2, String str3) {
        boolean init;
        synchronized (FitScUtil.f386595a) {
            FitScUtil fitScUtil = new FitScUtil();
            this.f123124a = fitScUtil;
            this.f123125b = str;
            init = fitScUtil.init(str2, str3, null, null);
        }
        return init;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() < 2) {
                sb5.append(0);
            }
            sb5.append(hexString.toLowerCase());
        }
        return sb5.toString();
    }

    public void a() {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        this.D = getInputText().getBytes();
    }

    public void a(String str) {
        if (TextUtils.isEmpty(getInputText())) {
            return;
        }
        byte[] bArr = new byte[this.D.length + str.length()];
        byte[] bArr2 = this.D;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        System.arraycopy(str.getBytes(), 0, bArr, this.D.length, str.length());
        this.D = bArr;
    }

    public String a(long j3, long j16) {
        byte[] bArr;
        String encryptPassWithCert;
        String inputText = getInputText();
        if (TextUtils.isEmpty(inputText) || inputText.length() < this.f123135l || this.f123124a == null || (bArr = this.D) == null || j3 == 0 || j16 == 0) {
            return null;
        }
        String a16 = a(bArr);
        synchronized (FitScUtil.f386595a) {
            encryptPassWithCert = this.f123124a.encryptPassWithCert(this.f123125b, a16.getBytes(), null, j3, String.valueOf(j16), 0, false);
            this.D = null;
        }
        return encryptPassWithCert;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
        }
    }
}
