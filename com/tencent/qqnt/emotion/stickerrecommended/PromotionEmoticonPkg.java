package com.tencent.qqnt.emotion.stickerrecommended;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes24.dex */
public class PromotionEmoticonPkg extends EmotionPanelData {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<PromotionEmoticonPkg> CREATOR;
    public static int K;
    public static int L;
    public static int M;
    public static int N;
    public static int P;
    public static int Q;
    public static int R;
    public static int S;
    public static int T;
    public static int U;
    public static int V;
    public static int W;
    public static int X;
    public String C;
    public String D;
    public String E;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;

    /* renamed from: d, reason: collision with root package name */
    public String f356422d;

    /* renamed from: e, reason: collision with root package name */
    public int f356423e;

    /* renamed from: f, reason: collision with root package name */
    public int f356424f;

    /* renamed from: h, reason: collision with root package name */
    public String f356425h;

    /* renamed from: i, reason: collision with root package name */
    public String f356426i;

    /* renamed from: m, reason: collision with root package name */
    public String f356427m;

    /* loaded from: classes24.dex */
    class a implements Parcelable.Creator<PromotionEmoticonPkg> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PromotionEmoticonPkg createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PromotionEmoticonPkg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PromotionEmoticonPkg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PromotionEmoticonPkg[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PromotionEmoticonPkg[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PromotionEmoticonPkg[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        K = 1;
        L = 2;
        M = 3;
        N = 4;
        P = 5;
        Q = 6;
        R = 7;
        S = 8;
        T = 0;
        U = 1;
        V = 6;
        W = 1;
        X = 2;
        CREATOR = new a();
    }

    public PromotionEmoticonPkg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.I = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f356422d);
        parcel.writeInt(this.f356423e);
        parcel.writeInt(this.f356424f);
        parcel.writeString(this.f356425h);
        parcel.writeString(this.f356426i);
        parcel.writeString(this.f356427m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
    }

    protected PromotionEmoticonPkg(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.I = 0;
        this.f356422d = parcel.readString();
        this.f356423e = parcel.readInt();
        this.f356424f = parcel.readInt();
        this.f356425h = parcel.readString();
        this.f356426i = parcel.readString();
        this.f356427m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readByte() != 0;
    }
}
