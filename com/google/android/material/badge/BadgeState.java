package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import g1.d;
import java.util.Locale;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class BadgeState {

    /* renamed from: a, reason: collision with root package name */
    private final State f33259a;

    /* renamed from: b, reason: collision with root package name */
    private final State f33260b;

    /* renamed from: c, reason: collision with root package name */
    final float f33261c;

    /* renamed from: d, reason: collision with root package name */
    final float f33262d;

    /* renamed from: e, reason: collision with root package name */
    final float f33263e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState(Context context, @XmlRes int i3, @AttrRes int i16, @StyleRes int i17, @Nullable State state) {
        int i18;
        CharSequence charSequence;
        int i19;
        int i26;
        boolean z16;
        int i27;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        Locale locale;
        Locale.Category category;
        State state2 = new State();
        this.f33260b = state2;
        state = state == null ? new State() : state;
        if (i3 != 0) {
            state.f33264d = i3;
        }
        TypedArray a16 = a(context, state.f33264d, i16, i17);
        Resources resources = context.getResources();
        this.f33261c = a16.getDimensionPixelSize(w0.a.G, resources.getDimensionPixelSize(R.dimen.crb));
        this.f33263e = a16.getDimensionPixelSize(w0.a.I, resources.getDimensionPixelSize(R.dimen.cra));
        this.f33262d = a16.getDimensionPixelSize(w0.a.J, resources.getDimensionPixelSize(R.dimen.crg));
        if (state.f33267h != -2) {
            i18 = state.f33267h;
        } else {
            i18 = 255;
        }
        state2.f33267h = i18;
        if (state.D != null) {
            charSequence = state.D;
        } else {
            charSequence = context.getString(R.string.f168462fp);
        }
        state2.D = charSequence;
        if (state.E != 0) {
            i19 = state.E;
        } else {
            i19 = R.plurals.f169246a;
        }
        state2.E = i19;
        if (state.F != 0) {
            i26 = state.F;
        } else {
            i26 = R.string.f168482fr;
        }
        state2.F = i26;
        if (state.H != null && !state.H.booleanValue()) {
            z16 = false;
        } else {
            z16 = true;
        }
        state2.H = Boolean.valueOf(z16);
        if (state.f33269m != -2) {
            i27 = state.f33269m;
        } else {
            i27 = a16.getInt(w0.a.M, 4);
        }
        state2.f33269m = i27;
        if (state.f33268i != -2) {
            state2.f33268i = state.f33268i;
        } else {
            int i28 = w0.a.N;
            if (a16.hasValue(i28)) {
                state2.f33268i = a16.getInt(i28, 0);
            } else {
                state2.f33268i = -1;
            }
        }
        if (state.f33265e == null) {
            intValue = u(context, a16, w0.a.E);
        } else {
            intValue = state.f33265e.intValue();
        }
        state2.f33265e = Integer.valueOf(intValue);
        if (state.f33266f != null) {
            state2.f33266f = state.f33266f;
        } else {
            int i29 = w0.a.H;
            if (a16.hasValue(i29)) {
                state2.f33266f = Integer.valueOf(u(context, a16, i29));
            } else {
                state2.f33266f = Integer.valueOf(new d(context, R.style.abz).i().getDefaultColor());
            }
        }
        if (state.G == null) {
            intValue2 = a16.getInt(w0.a.F, 8388661);
        } else {
            intValue2 = state.G.intValue();
        }
        state2.G = Integer.valueOf(intValue2);
        if (state.I == null) {
            intValue3 = a16.getDimensionPixelOffset(w0.a.K, 0);
        } else {
            intValue3 = state.I.intValue();
        }
        state2.I = Integer.valueOf(intValue3);
        if (state.I == null) {
            intValue4 = a16.getDimensionPixelOffset(w0.a.O, 0);
        } else {
            intValue4 = state.J.intValue();
        }
        state2.J = Integer.valueOf(intValue4);
        if (state.K == null) {
            intValue5 = a16.getDimensionPixelOffset(w0.a.L, state2.I.intValue());
        } else {
            intValue5 = state.K.intValue();
        }
        state2.K = Integer.valueOf(intValue5);
        if (state.L == null) {
            intValue6 = a16.getDimensionPixelOffset(w0.a.P, state2.J.intValue());
        } else {
            intValue6 = state.L.intValue();
        }
        state2.L = Integer.valueOf(intValue6);
        if (state.M == null) {
            intValue7 = 0;
        } else {
            intValue7 = state.M.intValue();
        }
        state2.M = Integer.valueOf(intValue7);
        state2.N = Integer.valueOf(state.N != null ? state.N.intValue() : 0);
        a16.recycle();
        if (state.C != null) {
            state2.C = state.C;
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                category = Locale.Category.FORMAT;
                locale = Locale.getDefault(category);
            } else {
                locale = Locale.getDefault();
            }
            state2.C = locale;
        }
        this.f33259a = state;
    }

    private TypedArray a(Context context, @XmlRes int i3, @AttrRes int i16, @StyleRes int i17) {
        AttributeSet attributeSet;
        int i18;
        int i19;
        if (i3 != 0) {
            AttributeSet a16 = b1.a.a(context, i3, "badge");
            i18 = a16.getStyleAttribute();
            attributeSet = a16;
        } else {
            attributeSet = null;
            i18 = 0;
        }
        if (i18 == 0) {
            i19 = i17;
        } else {
            i19 = i18;
        }
        return o.h(context, attributeSet, w0.a.D, i16, i19, new int[0]);
    }

    private static int u(Context context, @NonNull TypedArray typedArray, @StyleableRes int i3) {
        return g1.c.a(context, typedArray, i3).getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int b() {
        return this.f33260b.M.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int c() {
        return this.f33260b.N.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f33260b.f33267h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int e() {
        return this.f33260b.f33265e.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f33260b.G.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int g() {
        return this.f33260b.f33266f.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @StringRes
    public int h() {
        return this.f33260b.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i() {
        return this.f33260b.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @PluralsRes
    public int j() {
        return this.f33260b.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int k() {
        return this.f33260b.K.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int l() {
        return this.f33260b.I.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f33260b.f33269m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f33260b.f33268i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale o() {
        return this.f33260b.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State p() {
        return this.f33259a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int q() {
        return this.f33260b.L.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int r() {
        return this.f33260b.J.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        if (this.f33260b.f33268i != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.f33260b.H.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(@Dimension(unit = 1) int i3) {
        this.f33259a.M = Integer.valueOf(i3);
        this.f33260b.M = Integer.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(@Dimension(unit = 1) int i3) {
        this.f33259a.N = Integer.valueOf(i3);
        this.f33260b.N = Integer.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i3) {
        this.f33259a.f33267h = i3;
        this.f33260b.f33267h = i3;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();
        private Locale C;

        @Nullable
        private CharSequence D;

        @PluralsRes
        private int E;

        @StringRes
        private int F;
        private Integer G;
        private Boolean H;

        @Dimension(unit = 1)
        private Integer I;

        @Dimension(unit = 1)
        private Integer J;

        @Dimension(unit = 1)
        private Integer K;

        @Dimension(unit = 1)
        private Integer L;

        @Dimension(unit = 1)
        private Integer M;

        @Dimension(unit = 1)
        private Integer N;

        /* renamed from: d, reason: collision with root package name */
        @XmlRes
        private int f33264d;

        /* renamed from: e, reason: collision with root package name */
        @ColorInt
        private Integer f33265e;

        /* renamed from: f, reason: collision with root package name */
        @ColorInt
        private Integer f33266f;

        /* renamed from: h, reason: collision with root package name */
        private int f33267h;

        /* renamed from: i, reason: collision with root package name */
        private int f33268i;

        /* renamed from: m, reason: collision with root package name */
        private int f33269m;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<State> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(@NonNull Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i3) {
                return new State[i3];
            }
        }

        public State() {
            this.f33267h = 255;
            this.f33268i = -2;
            this.f33269m = -2;
            this.H = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            String charSequence;
            parcel.writeInt(this.f33264d);
            parcel.writeSerializable(this.f33265e);
            parcel.writeSerializable(this.f33266f);
            parcel.writeInt(this.f33267h);
            parcel.writeInt(this.f33268i);
            parcel.writeInt(this.f33269m);
            CharSequence charSequence2 = this.D;
            if (charSequence2 == null) {
                charSequence = null;
            } else {
                charSequence = charSequence2.toString();
            }
            parcel.writeString(charSequence);
            parcel.writeInt(this.E);
            parcel.writeSerializable(this.G);
            parcel.writeSerializable(this.I);
            parcel.writeSerializable(this.J);
            parcel.writeSerializable(this.K);
            parcel.writeSerializable(this.L);
            parcel.writeSerializable(this.M);
            parcel.writeSerializable(this.N);
            parcel.writeSerializable(this.H);
            parcel.writeSerializable(this.C);
        }

        State(@NonNull Parcel parcel) {
            this.f33267h = 255;
            this.f33268i = -2;
            this.f33269m = -2;
            this.H = Boolean.TRUE;
            this.f33264d = parcel.readInt();
            this.f33265e = (Integer) parcel.readSerializable();
            this.f33266f = (Integer) parcel.readSerializable();
            this.f33267h = parcel.readInt();
            this.f33268i = parcel.readInt();
            this.f33269m = parcel.readInt();
            this.D = parcel.readString();
            this.E = parcel.readInt();
            this.G = (Integer) parcel.readSerializable();
            this.I = (Integer) parcel.readSerializable();
            this.J = (Integer) parcel.readSerializable();
            this.K = (Integer) parcel.readSerializable();
            this.L = (Integer) parcel.readSerializable();
            this.M = (Integer) parcel.readSerializable();
            this.N = (Integer) parcel.readSerializable();
            this.H = (Boolean) parcel.readSerializable();
            this.C = (Locale) parcel.readSerializable();
        }
    }
}
