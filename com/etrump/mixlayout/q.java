package com.etrump.mixlayout;

import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f32783a;

    /* renamed from: b, reason: collision with root package name */
    private LongSparseArray<CharacterStyle> f32784b;

    public q(CharSequence charSequence) {
        this.f32783a = charSequence;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, charSequence.length(), CharacterStyle.class);
            if (characterStyleArr != null && characterStyleArr.length > 0) {
                this.f32784b = new LongSparseArray<>(characterStyleArr.length);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    if ((characterStyle instanceof EmoticonSpan) || (characterStyle instanceof p)) {
                        this.f32784b.put(d(spanned.getSpanStart(characterStyle), spanned.getSpanEnd(characterStyle)), characterStyle);
                    }
                }
            }
        }
    }

    private static int c(long j3) {
        return (int) (j3 & 4294967295L);
    }

    private static long d(int i3, int i16) {
        return (i3 << 32) + (i16 & 4294967295L);
    }

    private static int e(long j3) {
        return (int) (j3 >>> 32);
    }

    private void f(String str, int i3, int i16) {
        String str2 = str + ":" + i3 + "," + i16 + " > " + this.f32783a.length() + ":" + ((Object) this.f32783a);
        QLog.e("ETTextView", 1, str2);
        if (com.tencent.mobileqq.vas.api.g.f308459b.isPublicVersion()) {
        } else {
            throw new IndexOutOfBoundsException(str2);
        }
    }

    public int a(int i3) {
        CharSequence charSequence = this.f32783a;
        if (charSequence == null) {
            return i3;
        }
        if (i3 >= 0 && i3 <= charSequence.length()) {
            LongSparseArray<CharacterStyle> longSparseArray = this.f32784b;
            if (longSparseArray != null) {
                int size = longSparseArray.size();
                int i16 = i3;
                for (int i17 = 0; i17 < size; i17++) {
                    long keyAt = this.f32784b.keyAt(i17);
                    int e16 = e(keyAt);
                    int c16 = c(keyAt);
                    if (e16 >= i3) {
                        break;
                    }
                    if (c16 <= i3) {
                        i16 -= (c16 - e16) - 1;
                    } else {
                        return i16 - (i3 - e16);
                    }
                }
                return i16;
            }
            return i3;
        }
        if (i3 > 0) {
            f("convertToGraphIndex", i3, 0);
            return -1;
        }
        return -1;
    }

    public int b(int i3) {
        int i16;
        CharSequence charSequence = this.f32783a;
        if (charSequence == null) {
            return i3;
        }
        if (i3 >= 0 && i3 <= charSequence.length()) {
            LongSparseArray<CharacterStyle> longSparseArray = this.f32784b;
            if (longSparseArray != null) {
                int size = longSparseArray.size();
                i16 = i3;
                for (int i17 = 0; i17 < size; i17++) {
                    long keyAt = this.f32784b.keyAt(i17);
                    int e16 = e(keyAt);
                    int c16 = c(keyAt);
                    if (e16 >= i16) {
                        break;
                    }
                    i16 += (c16 - e16) - 1;
                }
            } else {
                i16 = i3;
            }
            if (i16 > this.f32783a.length()) {
                f("convertToTextIndex2", i3, i16);
                return -1;
            }
            return i16;
        }
        if (i3 > 0) {
            f("convertToTextIndex1", i3, 0);
        }
        return -1;
    }
}
