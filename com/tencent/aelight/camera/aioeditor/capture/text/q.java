package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q extends DynamicTextItem {
    private Rect A;
    private InputFilter B;

    /* renamed from: p, reason: collision with root package name */
    private TextPaint f67141p;

    /* renamed from: q, reason: collision with root package name */
    private TextPaint f67142q;

    /* renamed from: r, reason: collision with root package name */
    private Resources f67143r;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<String> f67144s;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<Integer> f67145t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<ArrayList<Integer>> f67146u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<Integer> f67147v;

    /* renamed from: w, reason: collision with root package name */
    private Bitmap f67148w;

    /* renamed from: x, reason: collision with root package name */
    private int f67149x;

    /* renamed from: y, reason: collision with root package name */
    private int f67150y;

    /* renamed from: z, reason: collision with root package name */
    private int f67151z;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends EditTextDialog.j {
        b(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            String str = spanned.subSequence(0, i17).toString() + charSequence.subSequence(i3, i16).toString() + spanned.subSequence(i18, spanned.length()).toString();
            this.f68129d = (str.length() - TroopFileUtils.g(str).length()) + 20;
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    public q(int i3, List<String> list, Typeface typeface, Typeface typeface2, Bitmap bitmap) {
        super(i3, list);
        this.f67144s = new ArrayList<>();
        this.f67145t = new ArrayList<>();
        this.f67146u = new ArrayList<>();
        this.f67147v = new ArrayList<>();
        this.A = new Rect();
        this.B = null;
        S(BaseApplication.getContext(), typeface, typeface2, bitmap);
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    private int Q(float f16) {
        return (int) (f16 * this.f67143r.getDisplayMetrics().density);
    }

    private int R(ArrayList<Integer> arrayList) {
        int i3 = this.f67150y * 2;
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() > i3) {
                i3 = next.intValue();
            }
        }
        return i3;
    }

    private void S(Context context, Typeface typeface, Typeface typeface2, Bitmap bitmap) {
        this.f67143r = context.getResources();
        this.f67148w = bitmap;
        T(typeface2, typeface);
        this.A.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    private void T(Typeface typeface, Typeface typeface2) {
        TextPaint textPaint = new TextPaint();
        this.f67141p = textPaint;
        textPaint.setTypeface(typeface2);
        this.f67141p.setAntiAlias(true);
        this.f67141p.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.f67141p.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f67141p.setTextSize(Q(79.5f));
        this.f67141p.setTextAlign(Paint.Align.CENTER);
        this.f67150y = (int) this.f67141p.measureText(HardCodeUtil.qqStr(R.string.nl6));
        TextPaint textPaint2 = new TextPaint();
        this.f67142q = textPaint2;
        textPaint2.setTypeface(typeface);
        this.f67142q.setAntiAlias(true);
        this.f67142q.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.f67142q.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f67142q.setTextSize(Q(14.0f));
        this.f67141p.setTextAlign(Paint.Align.LEFT);
        this.f67151z = (int) (this.f67150y * 1.3f);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        this.f67144s.clear();
        this.f67147v.clear();
        String[] split = super.l(i3, new a()).split("\n");
        int length = split.length;
        for (String str2 : split) {
            if (str2.length() == 6 && length == 1) {
                this.f67144s.add(str2);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(str2)));
            } else if (str2.length() > 15) {
                String substring = str2.substring(0, 5);
                this.f67144s.add(substring);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring)));
                String substring2 = str2.substring(5, 10);
                this.f67144s.add(substring2);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring2)));
                String substring3 = str2.substring(10, 15);
                this.f67144s.add(substring3);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring3)));
                String substring4 = str2.substring(15, str2.length());
                this.f67144s.add(substring4);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring4)));
            } else if (str2.length() > 10) {
                String substring5 = str2.substring(0, 5);
                this.f67144s.add(substring5);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring5)));
                String substring6 = str2.substring(5, 10);
                this.f67144s.add(substring6);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring6)));
                String substring7 = str2.substring(10, str2.length());
                this.f67144s.add(substring7);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring7)));
            } else if (str2.length() > 5) {
                String substring8 = str2.substring(0, 5);
                this.f67144s.add(substring8);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring8)));
                String substring9 = str2.substring(5, str2.length());
                this.f67144s.add(substring9);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(substring9)));
            } else {
                this.f67144s.add(str2);
                this.f67147v.add(Integer.valueOf((int) this.f67141p.measureText(str2)));
            }
        }
        this.f67149x = R(this.f67147v);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return (this.f67151z * (this.f67144s.size() == 0 ? 1 : this.f67144s.size())) + 10;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.B == null) {
            this.B = new b(20);
        }
        return this.B;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67149x + 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DynamicTextItem.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            if (i3 == 0) {
                return TroopFileUtils.g(str);
            }
            return "";
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        int i3;
        int i16 = 0;
        if (super.H(0)) {
            canvas.drawRoundRect(new RectF(5.0f, 5.0f, w() - 5.0f, m() - 5.0f), 6.0f, 6.0f, j());
        }
        canvas.save();
        canvas.translate(this.f67149x - Q(77.0f), this.f67151z - Q(78.0f));
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, Q(45.0f), Q(45.0f));
        canvas.drawBitmap(this.f67148w, this.A, rectF, (Paint) null);
        canvas.restore();
        int i17 = this.f67151z;
        int size = this.f67144s.size();
        int i18 = 0;
        while (i18 < size) {
            int intValue = (this.f67149x - this.f67147v.get(i18).intValue()) / 2;
            String str = this.f67144s.get(i18);
            int i19 = i16;
            int i26 = i19;
            while (i19 < str.length()) {
                int i27 = i19 + 1;
                String substring = str.substring(i19, i27);
                String str2 = af.a(substring.charAt(i16)) == 3 ? substring : ChnToSpell.e(substring, 1).f306907b;
                Rect rect = new Rect();
                this.f67141p.getTextBounds(substring, i16, 1, rect);
                int abs = Math.abs(rect.top - rect.bottom) + 20;
                int abs2 = Math.abs(rect.right - rect.left) + 20;
                float f16 = intValue;
                canvas.drawText(substring, f16, i17 - (this.f67151z * 0.085f), this.f67141p);
                int i28 = this.f67151z;
                int i29 = size;
                int i36 = intValue + abs2;
                String str3 = str;
                RectF rectF2 = new RectF(f16, (i17 - i28) + ((i28 - abs) / 2), i36, (i17 - i28) + ((i28 + abs) / 2));
                if (TextUtils.isEmpty(str2)) {
                    i3 = 0;
                } else {
                    Rect rect2 = new Rect();
                    i3 = 0;
                    this.f67142q.getTextBounds(str2, 0, str2.length(), rect2);
                    int i37 = rect2.right - rect2.left;
                    if (i26 % 2 == 0) {
                        canvas.drawText(str2, intValue + ((abs2 - i37) / 2), rectF2.top, this.f67142q);
                    } else {
                        canvas.drawText(str2, intValue + ((abs2 - i37) / 2), rectF2.bottom + 30.0f, this.f67142q);
                    }
                }
                i26++;
                intValue = i36;
                i19 = i27;
                i16 = i3;
                size = i29;
                str = str3;
            }
            i17 += this.f67151z;
            i18++;
            i16 = i16;
        }
    }
}
