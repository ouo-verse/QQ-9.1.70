package com.tencent.mobileqq.mutualmark.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkModel implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<MutualMarkModel> CREATOR;

    /* renamed from: b0, reason: collision with root package name */
    public static int f252152b0;

    /* renamed from: c0, reason: collision with root package name */
    public static int f252153c0;

    /* renamed from: d0, reason: collision with root package name */
    public static int f252154d0;
    public long C;
    public long D;
    public String E;
    public int F;
    public int G;
    public long H;
    public long I;
    public long J;
    public long K;
    public float L;
    public boolean M;
    public boolean N;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public String U;
    public long V;
    public long W;
    public long X;
    public List<Graded> Y;
    public List<Button> Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f252155a0;

    /* renamed from: d, reason: collision with root package name */
    public int f252156d;

    /* renamed from: e, reason: collision with root package name */
    public int f252157e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f252158f;

    /* renamed from: h, reason: collision with root package name */
    public String f252159h;

    /* renamed from: i, reason: collision with root package name */
    public String f252160i;

    /* renamed from: m, reason: collision with root package name */
    public String f252161m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<MutualMarkModel> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MutualMarkModel createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MutualMarkModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new MutualMarkModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MutualMarkModel[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MutualMarkModel[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new MutualMarkModel[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f252152b0 = 0;
        f252153c0 = 1;
        f252154d0 = 2;
        CREATOR = new a();
    }

    public MutualMarkModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252156d = -1;
        this.f252157e = f252154d0;
        this.f252158f = true;
        this.f252159h = "";
        this.f252160i = "";
        this.f252161m = "";
        this.C = 0L;
        this.D = 0L;
        this.E = "";
        this.F = 0;
        this.G = 0;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0.0f;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = "";
        this.V = 0L;
        this.W = 0L;
        this.X = 0L;
        this.f252155a0 = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f252157e);
        parcel.writeInt(this.f252158f ? 1 : 0);
        parcel.writeString(this.f252159h);
        parcel.writeString(this.f252160i);
        parcel.writeString(this.f252161m);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeString(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeLong(this.H);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
        parcel.writeFloat(this.L);
        parcel.writeInt(this.M ? 1 : 0);
        parcel.writeInt(this.N ? 1 : 0);
        parcel.writeInt(this.P ? 1 : 0);
        parcel.writeInt(this.Q ? 1 : 0);
        parcel.writeInt(this.R ? 1 : 0);
        parcel.writeInt(this.T ? 1 : 0);
        parcel.writeInt(this.S ? 1 : 0);
        parcel.writeString(this.U);
        parcel.writeLong(this.V);
        parcel.writeLong(this.W);
        parcel.writeLong(this.X);
        parcel.writeList(this.Y);
        parcel.writeList(this.Z);
        parcel.writeString(this.f252155a0);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Graded implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<Graded> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        public int f252168d;

        /* renamed from: e, reason: collision with root package name */
        public String f252169e;

        /* renamed from: f, reason: collision with root package name */
        public int f252170f;

        /* renamed from: h, reason: collision with root package name */
        public String f252171h;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<Graded> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Graded createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Graded) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new Graded(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Graded[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Graded[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new Graded[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33273);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        public Graded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f252168d = 0;
            this.f252169e = "";
            this.f252170f = 3;
            this.f252171h = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeInt(this.f252168d);
            parcel.writeString(this.f252169e);
            parcel.writeInt(this.f252170f);
            parcel.writeString(this.f252171h);
        }

        public Graded(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.f252168d = 0;
            this.f252169e = "";
            this.f252170f = 3;
            this.f252171h = "";
            this.f252168d = parcel.readInt();
            this.f252169e = parcel.readString();
            this.f252170f = parcel.readInt();
            this.f252171h = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Button implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<Button> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        public String f252162d;

        /* renamed from: e, reason: collision with root package name */
        public String f252163e;

        /* renamed from: f, reason: collision with root package name */
        public String f252164f;

        /* renamed from: h, reason: collision with root package name */
        public String f252165h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f252166i;

        /* renamed from: m, reason: collision with root package name */
        public int f252167m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<Button> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Button createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Button) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new Button(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Button[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Button[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new Button[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33266);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        public Button() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f252162d = "";
            this.f252163e = "";
            this.f252164f = "";
            this.f252165h = "";
            this.f252166i = false;
            this.f252167m = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeString(this.f252162d);
            parcel.writeString(this.f252163e);
            parcel.writeString(this.f252164f);
            parcel.writeString(this.f252165h);
            parcel.writeInt(this.f252166i ? 1 : 0);
            parcel.writeInt(this.f252167m);
        }

        public Button(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.f252162d = "";
            this.f252163e = "";
            this.f252164f = "";
            this.f252165h = "";
            this.f252166i = false;
            this.f252167m = 0;
            this.f252162d = parcel.readString();
            this.f252163e = parcel.readString();
            this.f252164f = parcel.readString();
            this.f252165h = parcel.readString();
            this.f252166i = parcel.readInt() == 1;
            this.f252167m = parcel.readInt();
        }
    }

    protected MutualMarkModel(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f252156d = -1;
        this.f252157e = f252154d0;
        this.f252158f = true;
        this.f252159h = "";
        this.f252160i = "";
        this.f252161m = "";
        this.C = 0L;
        this.D = 0L;
        this.E = "";
        this.F = 0;
        this.G = 0;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0.0f;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = "";
        this.V = 0L;
        this.W = 0L;
        this.X = 0L;
        this.f252155a0 = "";
        this.f252157e = parcel.readInt();
        this.f252158f = parcel.readInt() == 1;
        this.f252159h = parcel.readString();
        this.f252160i = parcel.readString();
        this.f252161m = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readString();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readLong();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
        this.L = parcel.readFloat();
        this.M = parcel.readInt() == 1;
        this.N = parcel.readInt() == 1;
        this.P = parcel.readInt() == 1;
        this.Q = parcel.readInt() == 1;
        this.R = parcel.readInt() == 1;
        this.T = parcel.readInt() == 1;
        this.S = parcel.readInt() == 1;
        this.U = parcel.readString();
        this.V = parcel.readLong();
        this.W = parcel.readLong();
        this.X = parcel.readLong();
        this.Y = parcel.readArrayList(Graded.class.getClassLoader());
        this.Z = parcel.readArrayList(Button.class.getClassLoader());
        this.f252155a0 = parcel.readString();
    }

    public MutualMarkModel(MutualMarkModel mutualMarkModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mutualMarkModel);
            return;
        }
        this.f252156d = -1;
        this.f252157e = f252154d0;
        this.f252158f = true;
        this.f252159h = "";
        this.f252160i = "";
        this.f252161m = "";
        this.C = 0L;
        this.D = 0L;
        this.E = "";
        this.F = 0;
        this.G = 0;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0.0f;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = "";
        this.V = 0L;
        this.W = 0L;
        this.X = 0L;
        this.f252155a0 = "";
        this.f252157e = mutualMarkModel.f252157e;
        this.f252158f = mutualMarkModel.f252158f;
        this.f252159h = mutualMarkModel.f252159h;
        this.f252160i = mutualMarkModel.f252160i;
        this.f252161m = mutualMarkModel.f252161m;
        this.C = mutualMarkModel.C;
        this.D = mutualMarkModel.D;
        this.E = mutualMarkModel.E;
        this.F = mutualMarkModel.F;
        this.G = mutualMarkModel.G;
        this.H = mutualMarkModel.H;
        this.I = mutualMarkModel.I;
        this.J = mutualMarkModel.J;
        this.K = mutualMarkModel.K;
        this.L = mutualMarkModel.L;
        this.M = mutualMarkModel.M;
        this.N = mutualMarkModel.N;
        this.P = mutualMarkModel.P;
        this.Q = mutualMarkModel.Q;
        this.R = mutualMarkModel.R;
        this.T = mutualMarkModel.T;
        this.S = mutualMarkModel.S;
        this.U = mutualMarkModel.U;
        this.V = mutualMarkModel.V;
        this.W = mutualMarkModel.W;
        this.X = mutualMarkModel.X;
        this.Y = mutualMarkModel.Y;
        this.Z = mutualMarkModel.Z;
        this.f252155a0 = mutualMarkModel.f252155a0;
    }
}
