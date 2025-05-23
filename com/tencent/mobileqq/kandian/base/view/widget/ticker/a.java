package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f239213a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f239214b;

    /* renamed from: c, reason: collision with root package name */
    private String f239215c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Character, Integer> f239216d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.base.view.widget.ticker.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7956a {

        /* renamed from: a, reason: collision with root package name */
        final int f239217a;

        /* renamed from: b, reason: collision with root package name */
        final int f239218b;

        public C7956a(int i3, int i16) {
            this.f239217a = i3;
            this.f239218b = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        int i3 = 0;
        if (!str.contains(Character.toString((char) 0))) {
            this.f239215c = str;
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            this.f239213a = length;
            this.f239216d = new HashMap(length);
            for (int i16 = 0; i16 < length; i16++) {
                this.f239216d.put(Character.valueOf(charArray[i16]), Integer.valueOf(i16));
            }
            char[] cArr = new char[(length * 2) + 1];
            this.f239214b = cArr;
            cArr[0] = 0;
            while (i3 < length) {
                char[] cArr2 = this.f239214b;
                int i17 = i3 + 1;
                cArr2[i17] = charArray[i3];
                cArr2[length + 1 + i3] = charArray[i3];
                i3 = i17;
            }
            return;
        }
        throw new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
    }

    private int c(char c16) {
        if (c16 == 0) {
            return 0;
        }
        if (this.f239216d.containsKey(Character.valueOf(c16))) {
            return this.f239216d.get(Character.valueOf(c16)).intValue() + 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7956a a(char c16, char c17, int i3) {
        int c18 = c(c16);
        int c19 = c(c17);
        if (c18 >= 0 && c19 >= 0) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (c17 == 0) {
                            c19 = this.f239214b.length;
                        } else if (c19 < c18) {
                            c19 += this.f239213a;
                        }
                    }
                } else if (c18 < c19) {
                    c18 += this.f239213a;
                }
            } else if (c16 != 0 && c17 != 0) {
                if (c19 < c18) {
                    int i16 = c18 - c19;
                    int i17 = this.f239213a;
                    if ((i17 - c18) + c19 < i16) {
                        c19 += i17;
                    }
                } else if (c18 < c19) {
                    int i18 = c19 - c18;
                    int i19 = this.f239213a;
                    if ((i19 - c19) + c18 < i18) {
                        c18 += i19;
                    }
                }
            }
            return new C7956a(c18, c19);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[] b() {
        return this.f239214b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f239215c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Character> e() {
        return this.f239216d.keySet();
    }
}
