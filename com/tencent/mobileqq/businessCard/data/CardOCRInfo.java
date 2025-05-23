package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CardOCRInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<CardOCRInfo> CREATOR;
    public float C;
    public int D;
    public String E;
    public String F;

    /* renamed from: d, reason: collision with root package name */
    public String f200892d;

    /* renamed from: e, reason: collision with root package name */
    public String f200893e;

    /* renamed from: f, reason: collision with root package name */
    public List<String> f200894f;

    /* renamed from: h, reason: collision with root package name */
    public List<String> f200895h;

    /* renamed from: i, reason: collision with root package name */
    public float f200896i;

    /* renamed from: m, reason: collision with root package name */
    public float f200897m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<CardOCRInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CardOCRInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CardOCRInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new CardOCRInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CardOCRInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CardOCRInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new CardOCRInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71109);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public CardOCRInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200894f = new ArrayList();
            this.f200895h = new ArrayList();
        }
    }

    public static String a(CardOCRInfo cardOCRInfo) {
        if (cardOCRInfo == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(0, cardOCRInfo.f200892d);
            jSONArray.put(1, cardOCRInfo.f200893e);
            jSONArray.put(2, BusinessCard.pack(cardOCRInfo.f200894f));
            jSONArray.put(3, BusinessCard.pack(cardOCRInfo.f200895h));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONArray.toString();
    }

    public static CardOCRInfo b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        CardOCRInfo cardOCRInfo = new CardOCRInfo();
        try {
            JSONArray jSONArray = new JSONArray(str);
            cardOCRInfo.f200892d = jSONArray.getString(0);
            cardOCRInfo.f200893e = jSONArray.getString(1);
            cardOCRInfo.f200894f = BusinessCard.unPack(jSONArray.getString(2));
            cardOCRInfo.f200895h = BusinessCard.unPack(jSONArray.getString(3));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard", 2, "unPackOCRInfo has exception");
            }
            e16.printStackTrace();
        }
        return cardOCRInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "erroCode: " + this.D + " errMsg: " + this.E + " uin:" + this.f200894f + " uincon:" + this.f200897m + " phone: " + this.f200895h + " phoneConfidence: " + this.C + " name:" + this.f200892d + " nameConfidence:" + this.f200896i + " imgUrl:" + this.F;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f200892d);
        parcel.writeString(this.f200893e);
        parcel.writeList(this.f200894f);
        parcel.writeList(this.f200895h);
        parcel.writeFloat(this.f200896i);
        parcel.writeFloat(this.f200897m);
        parcel.writeFloat(this.C);
    }

    public CardOCRInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f200894f = new ArrayList();
        this.f200895h = new ArrayList();
        this.f200892d = parcel.readString();
        this.f200893e = parcel.readString();
        parcel.readList(this.f200894f, getClass().getClassLoader());
        parcel.readList(this.f200895h, getClass().getClassLoader());
        this.f200896i = parcel.readFloat();
        this.f200897m = parcel.readFloat();
        this.C = parcel.readFloat();
    }
}
