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
public class CardUinInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<CardUinInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f200898d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f200899e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f200900f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<CardUinInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CardUinInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CardUinInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new CardUinInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CardUinInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CardUinInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new CardUinInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public CardUinInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static String a(List<CardUinInfo> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (CardUinInfo cardUinInfo : list) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(0, cardUinInfo.f200898d);
                    jSONArray2.put(1, cardUinInfo.f200899e);
                    jSONArray2.put(2, cardUinInfo.f200900f);
                    jSONArray.mo162put(jSONArray2);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static List<CardUinInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i3);
                CardUinInfo cardUinInfo = new CardUinInfo();
                cardUinInfo.f200898d = jSONArray2.getString(0);
                cardUinInfo.f200899e = jSONArray2.getBoolean(1);
                cardUinInfo.f200900f = jSONArray2.getBoolean(2);
                arrayList.add(cardUinInfo);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard", 2, "unPackUinInfos has exception");
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
        return "CardUinInfo{uin='" + this.f200898d + ", isFriend='" + this.f200899e + ", isSearchable=" + this.f200900f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f200898d);
        parcel.writeByte(this.f200899e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f200900f ? (byte) 1 : (byte) 0);
    }

    public CardUinInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f200898d = parcel.readString();
        this.f200899e = parcel.readByte() != 0;
        this.f200900f = parcel.readByte() != 0;
    }
}
