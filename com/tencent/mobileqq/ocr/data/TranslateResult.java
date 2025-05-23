package com.tencent.mobileqq.ocr.data;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TranslateResult implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<TranslateResult> CREATOR;
    public List<String> C;
    public int D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public int f254721d;

    /* renamed from: e, reason: collision with root package name */
    public String f254722e;

    /* renamed from: f, reason: collision with root package name */
    public String f254723f;

    /* renamed from: h, reason: collision with root package name */
    public List<Record> f254724h;

    /* renamed from: i, reason: collision with root package name */
    public String f254725i;

    /* renamed from: m, reason: collision with root package name */
    public String f254726m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class Record implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<Record> CREATOR;
        public String C;

        /* renamed from: d, reason: collision with root package name */
        public String f254727d;

        /* renamed from: e, reason: collision with root package name */
        public String f254728e;

        /* renamed from: f, reason: collision with root package name */
        public int f254729f;

        /* renamed from: h, reason: collision with root package name */
        public int f254730h;

        /* renamed from: i, reason: collision with root package name */
        public int f254731i;

        /* renamed from: m, reason: collision with root package name */
        public int f254732m;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        class a implements Parcelable.Creator<Record> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Record createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Record) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new Record(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Record[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Record[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new Record[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32287);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                CREATOR = new a();
            }
        }

        public Record() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "Record{srcText='" + this.f254727d + "', dstText='" + this.f254728e + "', x=" + this.f254729f + ", y=" + this.f254730h + ", width=" + this.f254731i + ", height=" + this.f254732m + ", angle='" + this.C + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeString(this.f254727d);
            parcel.writeString(this.f254728e);
            parcel.writeInt(this.f254729f);
            parcel.writeInt(this.f254730h);
            parcel.writeInt(this.f254731i);
            parcel.writeInt(this.f254732m);
            parcel.writeString(this.C);
        }

        protected Record(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.f254727d = parcel.readString();
            this.f254728e = parcel.readString();
            this.f254729f = parcel.readInt();
            this.f254730h = parcel.readInt();
            this.f254731i = parcel.readInt();
            this.f254732m = parcel.readInt();
            this.C = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<TranslateResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranslateResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TranslateResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new TranslateResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranslateResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TranslateResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new TranslateResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            CREATOR = new a();
        }
    }

    public TranslateResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f254721d = i3;
            this.f254724h = new ArrayList();
        }
    }

    public CharSequence a() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (CharSequence) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        List<Record> list = this.f254724h;
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            ArrayList<Pair> arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f254724h.size(); i3++) {
                Record record = this.f254724h.get(i3);
                if (!TextUtils.isEmpty(record.f254727d) && !TextUtils.isEmpty(record.f254728e)) {
                    sb5.append(record.f254727d);
                    sb5.append("\n");
                    int length = sb5.length();
                    sb5.append(record.f254728e);
                    arrayList.add(new Pair(Integer.valueOf(length), Integer.valueOf(sb5.length())));
                    sb5.append("\n");
                    sb5.append("\n");
                }
            }
            SpannableString spannableString = new SpannableString(sb5.toString());
            if (QQTheme.isNowThemeIsNight()) {
                str = "#0066CC";
            } else {
                str = "#12B7F5";
            }
            for (Pair pair : arrayList) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str)), ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 33);
            }
            return spannableString;
        }
        return "";
    }

    public CharSequence b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CharSequence) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        List<Record> list = this.f254724h;
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.f254724h.size(); i3++) {
                Record record = this.f254724h.get(i3);
                if (!TextUtils.isEmpty(record.f254727d) && !TextUtils.isEmpty(record.f254728e)) {
                    sb5.append(record.f254728e);
                    sb5.append("\n\n");
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public CharSequence c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CharSequence) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        CharSequence e16 = e();
        if (TextUtils.isEmpty(e16)) {
            return e16;
        }
        if (QQTheme.isNowThemeIsNight()) {
            str = "#0066CC";
        } else {
            str = "#12B7F5";
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor(str));
        SpannableString spannableString = new SpannableString(e16);
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
        return spannableString;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public CharSequence e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        List<Record> list = this.f254724h;
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.f254724h.size(); i3++) {
                Record record = this.f254724h.get(i3);
                if (!TextUtils.isEmpty(record.f254727d) && !TextUtils.isEmpty(record.f254728e)) {
                    sb5.append(record.f254728e);
                    if (i3 < this.f254724h.size() - 1) {
                        sb5.append("\n\n");
                    }
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        List<Record> list = this.f254724h;
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.f254724h.size(); i3++) {
                Record record = this.f254724h.get(i3);
                if (!TextUtils.isEmpty(record.f254728e)) {
                    sb5.append(record.f254728e);
                    if (i3 + 1 != this.f254724h.size()) {
                        sb5.append("\n");
                    }
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        List<Record> list = this.f254724h;
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.D == 0) {
            return true;
        }
        return false;
    }

    public void k(String str, String str2, List<String> list, List<String> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, list, list2);
            return;
        }
        if (list != null && list2 != null) {
            this.f254722e = str;
            this.f254723f = str2;
            int min = Math.min(list.size(), list2.size());
            for (int i3 = 0; i3 < min; i3++) {
                Record record = new Record();
                record.f254727d = list.get(i3);
                record.f254728e = list2.get(i3);
                this.f254724h.add(record);
            }
        }
    }

    public void l(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4);
            return;
        }
        this.f254722e = str;
        this.f254723f = str2;
        Record record = new Record();
        record.f254727d = str3;
        record.f254728e = str4;
        this.f254724h.add(record);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "TranslateResult{type=" + this.f254721d + ", srcLang='" + this.f254722e + "', dstLang='" + this.f254723f + "', records=" + this.f254724h + ", imagePath='" + this.f254725i + "', uuid='" + this.f254726m + "', sLanguages=" + this.C + ", errCode=" + this.D + ", errMsg='" + this.E + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f254721d);
        parcel.writeString(this.f254722e);
        parcel.writeString(this.f254723f);
        parcel.writeTypedList(this.f254724h);
        parcel.writeString(this.f254725i);
        parcel.writeString(this.f254726m);
        parcel.writeStringList(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
    }

    protected TranslateResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f254721d = parcel.readInt();
        this.f254722e = parcel.readString();
        this.f254723f = parcel.readString();
        this.f254724h = parcel.createTypedArrayList(Record.CREATOR);
        this.f254725i = parcel.readString();
        this.f254726m = parcel.readString();
        this.C = parcel.createStringArrayList();
        this.D = parcel.readInt();
        this.E = parcel.readString();
    }
}
