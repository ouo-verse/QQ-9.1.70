package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ac extends DynamicTextItem {

    /* renamed from: p, reason: collision with root package name */
    StaticLayout f66934p;

    /* renamed from: q, reason: collision with root package name */
    TextPaint f66935q;

    /* renamed from: r, reason: collision with root package name */
    RectF f66936r;

    /* renamed from: s, reason: collision with root package name */
    Random f66937s;

    /* renamed from: t, reason: collision with root package name */
    public int[] f66938t;

    /* renamed from: u, reason: collision with root package name */
    private float f66939u;

    /* renamed from: v, reason: collision with root package name */
    private String f66940v;

    /* renamed from: w, reason: collision with root package name */
    private RectF f66941w;

    /* renamed from: x, reason: collision with root package name */
    Context f66942x;

    /* renamed from: y, reason: collision with root package name */
    public int f66943y;

    /* renamed from: z, reason: collision with root package name */
    private InputFilter f66944z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DynamicTextItem.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            return TroopFileUtils.g(str);
        }
    }

    public ac(Context context, int i3, List<String> list, Typeface typeface) {
        super(i3, list);
        this.f66936r = new RectF();
        this.f66937s = new Random();
        this.f66938t = new int[]{12, 20, 24};
        this.f66940v = "";
        this.f66941w = new RectF();
        this.f66943y = 0;
        this.f66944z = null;
        this.f66942x = context;
        this.f66943y = R(context, 235.0f);
        TextPaint textPaint = new TextPaint();
        this.f66935q = textPaint;
        textPaint.setAntiAlias(true);
        this.f66935q.setTypeface(typeface);
        this.f66935q.setTextSize(BaseAIOUtils.f(28.0f, context.getResources()));
        this.f66935q.setColor(-1);
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    public static int R(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean D() {
        return TextUtils.isEmpty(this.f66940v) || super.D();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        if (this.f66934p != null) {
            canvas.save();
            canvas.translate(0.0f, 0.0f);
            this.f66934p.draw(canvas);
            if (super.H(0)) {
                int f16 = BaseAIOUtils.f(5.0f, this.f66942x.getResources());
                RectF rectF = this.f66941w;
                float f17 = f16;
                rectF.left = f17;
                rectF.top = -f16;
                rectF.right = w() + f17;
                this.f66941w.bottom = m() + f17;
                canvas.drawRoundRect(this.f66941w, 6.0f, 6.0f, j());
            }
            canvas.restore();
        }
    }

    public ArrayList<Integer> Q(String[] strArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 : this.f66938t) {
            arrayList2.add(Integer.valueOf(i3));
        }
        Collections.shuffle(arrayList2);
        int i16 = 0;
        for (String str : strArr) {
            Integer num = (Integer) arrayList2.get(i16 % arrayList2.size());
            int length = str.length();
            for (int i17 = 0; i17 < length; i17++) {
                char charAt = str.charAt(i17);
                if (charAt != '\u201c' && charAt != '\u201d') {
                    arrayList.add(num);
                } else {
                    arrayList.add(48);
                }
            }
            i16++;
        }
        return arrayList;
    }

    public String[] S(String str) {
        int length = str.length();
        int i3 = 0;
        if (length <= 7) {
            String[] strArr = new String[length];
            while (i3 < length) {
                int i16 = i3 + 1;
                strArr[i3] = str.substring(i3, i16);
                i3 = i16;
            }
            return strArr;
        }
        String[] strArr2 = new String[7];
        int i17 = 0;
        while (i3 < 7) {
            int nextInt = this.f66937s.nextInt((length - (7 - i3)) + 1) + 1;
            length -= nextInt;
            int i18 = nextInt + i17;
            strArr2[i3] = str.substring(i17, i18);
            i3++;
            i17 = i18;
        }
        return strArr2;
    }

    public CharSequence T(String[] strArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u201c");
        for (String str : strArr) {
            sb5.append(str);
        }
        sb5.append("\u201d");
        ArrayList<Integer> Q = Q(strArr);
        Q.add(0, 48);
        Q.add(48);
        SpannableString spannableString = new SpannableString(sb5.toString());
        int length = spannableString.length();
        int i3 = 1;
        while (i3 < length - 1) {
            int i16 = i3 + 1;
            spannableString.setSpan(new AbsoluteSizeSpan(BaseAIOUtils.f(Q.get(i3).intValue(), this.f66942x.getResources())), i3, i16, 33);
            i3 = i16;
        }
        return spannableString;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int h() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        if (this.f66934p != null) {
            return r0.getHeight();
        }
        return 0.0f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.f66944z == null) {
            this.f66944z = new b(20);
        }
        return this.f66944z;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        if (this.f66934p != null) {
            return r0.getWidth();
        }
        return 0.0f;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends EditTextDialog.j {
        b(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            String str = spanned.subSequence(0, i17).toString() + charSequence.subSequence(i3, i16).toString() + spanned.subSequence(i18, spanned.length()).toString();
            String g16 = TroopFileUtils.g(str);
            CharSequence T = ac.this.T(ac.this.S(ac.this.y(g16)));
            int length = T.length();
            ac acVar = ac.this;
            if (ag.a(T, 0, length, acVar.f66935q, acVar.f66943y, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false, null, 0, 4).getLineCount() > 3) {
                if (!TextUtils.equals("", charSequence)) {
                    b();
                }
                return "";
            }
            this.f68129d = (str.length() - g16.length()) + 20;
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        if (!TextUtils.equals(super.p(0), str) || this.f66934p == null) {
            super.M(i3, str);
            String l3 = super.l(i3, new a());
            this.f66940v = l3;
            CharSequence T = T(S(l3));
            StaticLayout a16 = ag.a(T, 0, T.length(), this.f66935q, this.f66943y, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false, null, 0, 3);
            this.f66934p = a16;
            if (a16.getLineCount() >= 3) {
                String str2 = ((Object) T.subSequence(0, this.f66934p.getLineEnd(2) - 1)) + "\u201d";
                this.f66934p = ag.a(str2, 0, str2.length(), this.f66935q, this.f66943y, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false, null, 0, 3);
            }
            int lineCount = this.f66934p.getLineCount();
            float f16 = 0.0f;
            for (int i16 = 0; i16 < lineCount; i16++) {
                f16 = Math.max(f16, this.f66934p.getLineWidth(i16));
            }
            this.f66939u = f16;
        }
    }
}
