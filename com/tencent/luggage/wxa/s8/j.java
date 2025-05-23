package com.tencent.luggage.wxa.s8;

import android.graphics.Typeface;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public Typeface f140164a;

    /* renamed from: b, reason: collision with root package name */
    public String f140165b;

    /* renamed from: c, reason: collision with root package name */
    public float f140166c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f140167d;

    /* renamed from: e, reason: collision with root package name */
    public float f140168e;

    /* renamed from: f, reason: collision with root package name */
    public a f140169f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);


        /* renamed from: a, reason: collision with root package name */
        public int f140175a;

        a(int i3) {
            this.f140175a = i3;
        }

        public boolean b() {
            if (this != BOLD && this != BOLD_ITALIC) {
                return false;
            }
            return true;
        }

        public boolean c() {
            if (this != ITALIC && this != BOLD_ITALIC) {
                return false;
            }
            return true;
        }

        public static a a(boolean z16, boolean z17) {
            if (z16 && z17) {
                return BOLD_ITALIC;
            }
            if (z16) {
                return ITALIC;
            }
            if (z17) {
                return BOLD;
            }
            return NORMAL;
        }
    }

    public j(Typeface typeface, String str, float f16, boolean z16, float f17, a aVar) {
        this.f140164a = typeface;
        this.f140165b = str;
        this.f140166c = f16;
        this.f140167d = z16;
        this.f140168e = f17;
        this.f140169f = aVar;
    }

    public String toString() {
        return "MBFontStyle[" + this.f140165b + "][" + this.f140166c + "][" + this.f140168e + "]";
    }
}
