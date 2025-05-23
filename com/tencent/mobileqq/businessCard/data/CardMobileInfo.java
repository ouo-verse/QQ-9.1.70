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
public class CardMobileInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<CardMobileInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f200887d;

    /* renamed from: e, reason: collision with root package name */
    public String f200888e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f200889f;

    /* renamed from: h, reason: collision with root package name */
    public String f200890h;

    /* renamed from: i, reason: collision with root package name */
    public String f200891i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<CardMobileInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CardMobileInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CardMobileInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new CardMobileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CardMobileInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CardMobileInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new CardMobileInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71107);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public CardMobileInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static String a(List<CardMobileInfo> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (CardMobileInfo cardMobileInfo : list) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(0, cardMobileInfo.f200887d);
                    jSONArray2.put(1, cardMobileInfo.f200891i);
                    jSONArray2.put(2, cardMobileInfo.f200889f);
                    jSONArray2.put(3, cardMobileInfo.f200890h);
                    jSONArray2.put(4, cardMobileInfo.f200888e);
                    jSONArray.mo162put(jSONArray2);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static List<CardMobileInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i3);
                CardMobileInfo cardMobileInfo = new CardMobileInfo();
                cardMobileInfo.f200887d = (String) jSONArray2.get(0);
                cardMobileInfo.f200891i = jSONArray2.getString(1);
                cardMobileInfo.f200889f = jSONArray2.getBoolean(2);
                cardMobileInfo.f200890h = jSONArray2.getString(3);
                cardMobileInfo.f200888e = (String) jSONArray2.get(4);
                arrayList.add(cardMobileInfo);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard", 2, "unPackMoblieInfos has exception");
            }
            e16.printStackTrace();
        }
        return arrayList;
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
        return "CardMobileInfo{, isFriend=" + this.f200889f + "bindqq='" + this.f200888e + ",nickName=" + this.f200890h + ", mobile='" + this.f200887d + ",format= " + this.f200891i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f200887d);
        parcel.writeString(this.f200888e);
        parcel.writeByte(this.f200889f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f200890h);
        parcel.writeString(this.f200891i);
    }

    public CardMobileInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f200887d = parcel.readString();
        this.f200888e = parcel.readString();
        this.f200889f = parcel.readByte() != 0;
        this.f200890h = parcel.readString();
        this.f200891i = parcel.readString();
    }
}
