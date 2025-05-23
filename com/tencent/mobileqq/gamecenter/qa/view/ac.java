package com.tencent.mobileqq.gamecenter.qa.view;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.BoldSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.CopyParagraphSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.ItalicSpan;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private boolean f212966a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, GameStrategyImageSpan> f212967b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ab> f212968c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, w> f212969d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private GameStrategyEditTextView.f f212970e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(GameStrategyEditTextView.f fVar) {
        this.f212970e = fVar;
    }

    private void a(GameStrategyEditTextView gameStrategyEditTextView) {
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) gameStrategyEditTextView.getEditableText();
        GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), GameStrategyImageSpan.class);
        if (gameStrategyImageSpanArr.length > 0) {
            for (GameStrategyImageSpan gameStrategyImageSpan : gameStrategyImageSpanArr) {
                this.f212967b.put(gameStrategyImageSpan.n(false), gameStrategyImageSpan);
            }
        }
        ab[] abVarArr = (ab[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ab.class);
        if (abVarArr.length > 0) {
            for (ab abVar : abVarArr) {
                this.f212968c.put(abVar.n(abVar.getMTitle(), abVar.getMLink()), abVar);
            }
        }
        w[] wVarArr = (w[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), w.class);
        if (wVarArr.length > 0) {
            for (w wVar : wVarArr) {
                this.f212969d.put(wVar.i(), wVar);
            }
        }
    }

    private static List<Integer> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(str2);
        while (indexOf >= 0) {
            arrayList.add(Integer.valueOf(indexOf));
            if (str2.length() + indexOf >= str.length()) {
                break;
            }
            indexOf = str.indexOf(str2, indexOf + str2.length());
        }
        return arrayList;
    }

    private void g(SpannableStringBuilder spannableStringBuilder) {
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class)) {
            QLog.d("GameStrategyMenuSupport", 2, "all span:", obj);
            if ((obj instanceof CharacterStyle) || (obj instanceof ParagraphStyle)) {
                if (AbsoluteSizeSpan.class.getName().equals(obj.getClass().getName())) {
                    int spanStart = spannableStringBuilder.getSpanStart(obj);
                    int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                    int spanFlags = spannableStringBuilder.getSpanFlags(obj);
                    spannableStringBuilder.removeSpan(obj);
                    spannableStringBuilder.setSpan(new com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan(((AbsoluteSizeSpan) obj).getSize()), spanStart, spanEnd, spanFlags);
                } else if (UnderlineSpan.class.getName().equals(obj.getClass().getName())) {
                    int spanStart2 = spannableStringBuilder.getSpanStart(obj);
                    int spanEnd2 = spannableStringBuilder.getSpanEnd(obj);
                    int spanFlags2 = spannableStringBuilder.getSpanFlags(obj);
                    spannableStringBuilder.removeSpan(obj);
                    spannableStringBuilder.setSpan(new com.tencent.mobileqq.gamecenter.qa.editor.span.UnderlineSpan(), spanStart2, spanEnd2, spanFlags2);
                } else if (StyleSpan.class.getName().equals(obj.getClass().getName())) {
                    int spanStart3 = spannableStringBuilder.getSpanStart(obj);
                    int spanEnd3 = spannableStringBuilder.getSpanEnd(obj);
                    int spanFlags3 = spannableStringBuilder.getSpanFlags(obj);
                    spannableStringBuilder.removeSpan(obj);
                    StyleSpan styleSpan = (StyleSpan) obj;
                    if (1 == styleSpan.getStyle()) {
                        spannableStringBuilder.setSpan(new BoldSpan(), spanStart3, spanEnd3, spanFlags3);
                    } else if (2 == styleSpan.getStyle()) {
                        spannableStringBuilder.setSpan(new ItalicSpan(), spanStart3, spanEnd3, spanFlags3);
                    } else if (3 == styleSpan.getStyle()) {
                        spannableStringBuilder.setSpan(new ItalicSpan(), spanStart3, spanEnd3, spanFlags3);
                        spannableStringBuilder.setSpan(new BoldSpan(), spanStart3, spanEnd3, spanFlags3);
                    }
                } else if (AlignmentSpan.Standard.class.getName().equals(obj.getClass().getName())) {
                    spannableStringBuilder.removeSpan(obj);
                } else if (TypefaceSpan.class.getName().equals(obj.getClass().getName())) {
                    int spanStart4 = spannableStringBuilder.getSpanStart(obj);
                    int spanEnd4 = spannableStringBuilder.getSpanEnd(obj);
                    int spanFlags4 = spannableStringBuilder.getSpanFlags(obj);
                    spannableStringBuilder.removeSpan(obj);
                    if (obj instanceof TypefaceSpan) {
                        String family = ((TypefaceSpan) obj).getFamily();
                        if (!TextUtils.isEmpty(family)) {
                            if (family.startsWith("BulletSpan")) {
                                spannableStringBuilder.setSpan(CopyParagraphSpan.c(family), spanStart4, spanEnd4, spanFlags4);
                            } else {
                                spannableStringBuilder.setSpan(CopyParagraphSpan.e(family), spanStart4, spanEnd4, spanFlags4);
                            }
                        }
                        QLog.d("GameStrategyMenuSupport", 1, "onTextChanged span: customData" + family);
                    }
                } else {
                    QLog.i("GameStrategyMenuSupport", 1, "onTextChanged span:" + obj);
                }
            }
        }
    }

    public void c(GameStrategyEditTextView gameStrategyEditTextView) {
        int selectionStart = gameStrategyEditTextView.getSelectionStart();
        int selectionEnd = gameStrategyEditTextView.getSelectionEnd();
        Editable text = gameStrategyEditTextView.getText();
        for (Object obj : text.getSpans(0, text.length(), Object.class)) {
            if (obj instanceof CopyParagraphSpan) {
                text.removeSpan(obj);
            }
        }
        if (selectionEnd > selectionStart && selectionEnd > 0 && selectionStart >= 0) {
            zd1.b[] bVarArr = (zd1.b[]) text.getSpans(selectionStart, selectionEnd, zd1.b.class);
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                int spanStart = text.getSpanStart(bVarArr[i3]);
                int spanEnd = text.getSpanEnd(bVarArr[i3]);
                int spanFlags = text.getSpanFlags(bVarArr[i3]);
                if (spanStart >= selectionStart && spanEnd - 1 <= selectionEnd) {
                    text.setSpan(CopyParagraphSpan.a(bVarArr[i3]), selectionStart, selectionEnd, spanFlags);
                }
            }
            zd1.c[] cVarArr = (zd1.c[]) text.getSpans(selectionStart, selectionEnd, zd1.c.class);
            for (int i16 = 0; i16 < cVarArr.length; i16++) {
                int spanStart2 = text.getSpanStart(cVarArr[i16]);
                int spanEnd2 = text.getSpanEnd(cVarArr[i16]);
                int spanFlags2 = text.getSpanFlags(cVarArr[i16]);
                if (spanStart2 >= selectionStart && spanEnd2 - 1 <= selectionEnd) {
                    text.setSpan(CopyParagraphSpan.b(cVarArr[i16]), selectionStart, selectionEnd, spanFlags2);
                }
            }
        }
        this.f212967b.clear();
        this.f212967b.clear();
        this.f212969d.clear();
        a(gameStrategyEditTextView);
    }

    public void d(GameStrategyEditTextView gameStrategyEditTextView) {
        a(gameStrategyEditTextView);
    }

    public void e(GameStrategyEditTextView gameStrategyEditTextView) {
        this.f212966a = true;
    }

    public void f(GameStrategyEditTextView gameStrategyEditTextView) {
        GameStrategyEditTextView.f fVar;
        GameStrategyEditTextView.f fVar2;
        if (this.f212966a) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) gameStrategyEditTextView.getEditableText();
            gameStrategyEditTextView.f0();
            GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), GameStrategyImageSpan.class);
            if (gameStrategyImageSpanArr.length > 0) {
                for (GameStrategyImageSpan gameStrategyImageSpan : gameStrategyImageSpanArr) {
                    this.f212967b.put(gameStrategyImageSpan.n(false), gameStrategyImageSpan);
                }
            }
            for (String str : this.f212967b.keySet()) {
                for (Integer num : b(spannableStringBuilder.toString(), str)) {
                    if (((GameStrategyImageSpan[]) spannableStringBuilder.getSpans(num.intValue(), num.intValue(), GameStrategyImageSpan.class)).length == 0) {
                        spannableStringBuilder.setSpan(this.f212967b.get(str).c(), num.intValue(), num.intValue() + str.length(), 33);
                    }
                }
            }
            ab[] abVarArr = (ab[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ab.class);
            if (abVarArr.length > 0) {
                for (ab abVar : abVarArr) {
                    this.f212968c.put(abVar.n(abVar.getMTitle(), abVar.getMLink()), abVar);
                }
            }
            for (String str2 : this.f212968c.keySet()) {
                for (Integer num2 : b(spannableStringBuilder.toString(), str2)) {
                    if (((ab[]) spannableStringBuilder.getSpans(num2.intValue(), num2.intValue(), ab.class)).length == 0 && (fVar2 = this.f212970e) != null) {
                        spannableStringBuilder.setSpan(fVar2.a(this.f212968c.get(str2)), num2.intValue(), num2.intValue() + str2.length(), 33);
                    }
                }
            }
            w[] wVarArr = (w[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), w.class);
            if (wVarArr.length > 0) {
                for (w wVar : wVarArr) {
                    this.f212969d.put(wVar.i(), wVar);
                }
            }
            for (String str3 : this.f212969d.keySet()) {
                for (Integer num3 : b(spannableStringBuilder.toString(), str3)) {
                    if (((w[]) spannableStringBuilder.getSpans(num3.intValue(), num3.intValue(), w.class)).length == 0 && (fVar = this.f212970e) != null) {
                        spannableStringBuilder.setSpan(fVar.b(this.f212969d.get(str3)), num3.intValue(), num3.intValue() + str3.length(), 33);
                    }
                }
            }
            g(spannableStringBuilder);
            gameStrategyEditTextView.K();
            this.f212966a = false;
        }
    }
}
