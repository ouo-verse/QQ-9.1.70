package com.tencent.mobileqq.guild.util;

import android.text.Spannable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.emoji.text.EmojiSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class cb {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class a extends c {
        a() {
        }

        private boolean j(char c16) {
            if (c16 < '\u0080') {
                return false;
            }
            return true;
        }

        private boolean k(char c16) {
            if (j(c16)) {
                this.f235496e = true;
                return false;
            }
            if (c16 < '\u0080') {
                this.f235494c++;
            } else {
                this.f235495d++;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.util.cb.c
        public int g(CharSequence charSequence, int i3, int i16, float f16) {
            float i17 = i() + f16;
            int i18 = i3;
            while (true) {
                if (i18 >= i16 || f16 <= 0.0f) {
                    break;
                }
                if (f16 >= 1.0f) {
                    b(charSequence.charAt(i18));
                    i18++;
                } else {
                    if (!k(charSequence.charAt(i18))) {
                        this.f235496e = true;
                        break;
                    }
                    i18++;
                }
                f16 = i17 - i();
            }
            if (f16 <= 0.0f) {
                this.f235496e = true;
            }
            return i18 - i3;
        }

        @Override // com.tencent.mobileqq.guild.util.cb.c
        public float i() {
            return this.f235492a + this.f235493b + this.f235495d + (this.f235494c * 0.5f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f235488a;

        /* renamed from: b, reason: collision with root package name */
        public final int f235489b;

        /* renamed from: c, reason: collision with root package name */
        public final int f235490c;

        /* renamed from: d, reason: collision with root package name */
        public final int f235491d;

        b(int i3, int i16, int i17, int i18) {
            this.f235488a = i3;
            this.f235489b = i16;
            this.f235491d = i18;
            this.f235490c = i17;
        }

        public int a() {
            return this.f235488a + this.f235489b + this.f235491d + ((this.f235490c + 1) / 2);
        }

        public float b() {
            return this.f235488a + this.f235489b + this.f235491d + (this.f235490c / 2.0f);
        }

        public int c() {
            return this.f235488a + this.f235489b + this.f235491d + this.f235490c;
        }

        public String toString() {
            return "CharacterCountInfo{emojiCount=" + this.f235488a + ", emoticonCount=" + this.f235489b + ", asciiCount=" + this.f235490c + ", textCount=" + this.f235491d + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        protected int f235492a = 0;

        /* renamed from: b, reason: collision with root package name */
        protected int f235493b = 0;

        /* renamed from: c, reason: collision with root package name */
        protected int f235494c = 0;

        /* renamed from: d, reason: collision with root package name */
        protected int f235495d = 0;

        /* renamed from: e, reason: collision with root package name */
        protected boolean f235496e = false;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            return this.f235496e;
        }

        void b(char c16) {
            if (c16 < '\u0080') {
                this.f235494c++;
            } else {
                this.f235495d++;
            }
        }

        void c(e eVar) {
            if (eVar.f235499c == 0) {
                this.f235492a++;
            } else {
                this.f235493b++;
            }
        }

        void d(CharSequence charSequence, int i3, int i16) {
            while (i3 < i16) {
                b(charSequence.charAt(i3));
                i3++;
            }
        }

        int f(e eVar, float f16) {
            if (f16 < 1.0f) {
                this.f235496e = true;
                return 0;
            }
            c(eVar);
            return eVar.f235498b - eVar.f235497a;
        }

        abstract int g(CharSequence charSequence, int i3, int i16, float f16);

        b h() {
            return new b(this.f235492a, this.f235493b, this.f235494c, this.f235495d);
        }

        abstract float i();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class d extends c {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.util.cb.c
        public int g(CharSequence charSequence, int i3, int i16, float f16) {
            float i17 = i() + f16;
            int i18 = i3;
            while (true) {
                if (i18 >= i16 || f16 <= 0.0f) {
                    break;
                }
                if (f16 >= 1.0f) {
                    int i19 = i18 + 1;
                    b(charSequence.charAt(i18));
                    i18 = i19;
                    f16 = i17 - i();
                } else {
                    this.f235496e = true;
                    break;
                }
            }
            if (f16 <= 0.0f) {
                this.f235496e = true;
            }
            return i18 - i3;
        }

        @Override // com.tencent.mobileqq.guild.util.cb.c
        public float i() {
            return this.f235492a + this.f235493b + this.f235495d + this.f235494c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f235497a;

        /* renamed from: b, reason: collision with root package name */
        public final int f235498b;

        /* renamed from: c, reason: collision with root package name */
        public final int f235499c;

        e(int i3, int i16, int i17) {
            this.f235497a = i3;
            this.f235498b = i16;
            this.f235499c = i17;
        }

        public static e a(Spannable spannable, Object obj) {
            int spanEnd = spannable.getSpanEnd(obj);
            int spanStart = spannable.getSpanStart(obj);
            if (obj instanceof EmoticonSpan) {
                QLog.d("QQGuildTextUtils", 4, "SpanPair.from EmoticonSpan: type: ", Integer.valueOf(((EmoticonSpan) obj).emojiType), " start: ", Integer.valueOf(spanStart), " end: ", Integer.valueOf(spanEnd));
            }
            return new e(spanStart, spanEnd, !(obj instanceof EmojiSpan) ? 1 : 0);
        }

        public String toString() {
            return "SpanPair{start=" + this.f235497a + ", end=" + this.f235498b + ", type=" + this.f235499c + '}';
        }
    }

    public static int a(CharSequence charSequence, int i3, float f16, int i16) {
        c aVar;
        int length;
        int g16;
        SparseArray<e> c16 = c(new QQText(charSequence, 3));
        if (i16 == 1) {
            aVar = new d();
        } else {
            aVar = new a();
        }
        float i17 = aVar.i();
        while (true) {
            float f17 = f16 - i17;
            if (i3 >= charSequence.length() || aVar.e() || f17 <= 0.0f) {
                break;
            }
            int indexOfKey = c16.indexOfKey(i3);
            if (indexOfKey >= 0) {
                g16 = aVar.f(c16.valueAt(indexOfKey), f17);
            } else {
                int i18 = (-indexOfKey) - 1;
                if (i18 < c16.size()) {
                    length = c16.valueAt(i18).f235497a;
                } else {
                    length = charSequence.length();
                }
                g16 = aVar.g(charSequence, i3, length, f17);
            }
            i3 += g16;
            i17 = aVar.i();
        }
        return i3;
    }

    public static b b(CharSequence charSequence) {
        int length;
        QQText qQText = new QQText(charSequence, 3);
        a aVar = new a();
        SparseArray<e> c16 = c(qQText);
        int i3 = 0;
        while (i3 < charSequence.length()) {
            int indexOfKey = c16.indexOfKey(i3);
            if (indexOfKey >= 0) {
                e valueAt = c16.valueAt(indexOfKey);
                i3 += valueAt.f235498b - valueAt.f235497a;
                aVar.c(valueAt);
            } else {
                int i16 = (-indexOfKey) - 1;
                if (i16 < c16.size()) {
                    length = c16.valueAt(i16).f235497a;
                } else {
                    length = charSequence.length();
                }
                aVar.d(charSequence, i3, length);
                i3 += length - i3;
            }
        }
        return aVar.h();
    }

    @NonNull
    private static SparseArray<e> c(@NonNull Spannable spannable) {
        SparseArray<e> sparseArray = new SparseArray<>();
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if ((obj instanceof EmojiSpan) || (obj instanceof EmoticonSpan)) {
                e a16 = e.a(spannable, obj);
                sparseArray.append(a16.f235497a, a16);
            }
        }
        return sparseArray;
    }

    public static String d(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
