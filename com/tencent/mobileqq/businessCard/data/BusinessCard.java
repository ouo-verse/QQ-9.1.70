package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BusinessCard extends Entity implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final int CARD_SRC_AB = 3;
    public static final int CARD_SRC_BA = 4;
    public static final int CARD_SRC_FX = 2;
    public static final int CARD_SRC_SS = 1;
    public static final int CARD_SRC_ZL = 5;
    public static final Parcelable.Creator<BusinessCard> CREATOR;
    public static final int TYPE_CARD_ADD = 2;
    public static final int TYPE_CARD_MINE = 1;
    public static final int TYPE_CARD_MINE_ADD = 3;
    public static final int TYPE_CARD_OTHER = 0;

    @notColumn
    public CardOCRInfo OCRInfo;
    public String OCRInfoPacked;
    public String allPinyin;
    public String bindMobile;
    public String bindUin;

    @unique
    public String cardId;
    public String cardName;
    public int cardSrc;
    public int cardType;
    public String company;

    @notColumn
    public List<String> descs;
    public String descsPacked;

    @notColumn
    public String firstPinyin;
    public int lastUpdateTime;

    @notColumn
    public List<CardMobileInfo> mobileInfos;

    @notColumn
    public List<String> mobilesNum;
    public String moblieInfoPacked;
    public String mobulesNumPacked;
    public String picUrl;

    @notColumn
    public List<String> qqNum;
    public String sortDesc;
    public String uinInfoPacked;

    @notColumn
    public List<CardUinInfo> uinInfos;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<BusinessCard> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusinessCard createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BusinessCard) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new BusinessCard(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BusinessCard[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BusinessCard[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BusinessCard[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public BusinessCard(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.cardSrc = 1;
        this.mobilesNum = new ArrayList();
        this.qqNum = new ArrayList();
        this.descs = new ArrayList();
        this.cardType = 0;
        this.mobileInfos = new ArrayList();
        this.uinInfos = new ArrayList();
        this.cardId = parcel.readString();
        this.cardName = parcel.readString();
        this.company = parcel.readString();
        this.picUrl = parcel.readString();
        this.bindUin = parcel.readString();
        this.bindMobile = parcel.readString();
        this.cardSrc = parcel.readInt();
        parcel.readList(this.mobilesNum, getClass().getClassLoader());
        parcel.readList(this.qqNum, getClass().getClassLoader());
        parcel.readList(this.descs, getClass().getClassLoader());
        parcel.readList(this.mobileInfos, getClass().getClassLoader());
        parcel.readList(this.uinInfos, getClass().getClassLoader());
        this.OCRInfo = (CardOCRInfo) parcel.readParcelable(getClass().getClassLoader());
        this.cardType = parcel.readInt();
        this.lastUpdateTime = parcel.readInt();
        this.sortDesc = parcel.readString();
    }

    public static String pack(List<String> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static List<String> unPack(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String str2 = (String) jSONArray.get(i3);
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    public CardMobileInfo getMobileInfoByMobile(String str) {
        List<CardMobileInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CardMobileInfo) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        if (str != null && (list = this.mobileInfos) != null) {
            for (CardMobileInfo cardMobileInfo : list) {
                if (str.equals(cardMobileInfo.f200887d)) {
                    return cardMobileInfo;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.postRead();
        if (!TextUtils.isEmpty(this.mobulesNumPacked)) {
            this.mobilesNum = unPack(this.mobulesNumPacked);
        }
        if (!TextUtils.isEmpty(this.descsPacked)) {
            this.descs = unPack(this.descsPacked);
        }
        if (!TextUtils.isEmpty(this.moblieInfoPacked)) {
            this.mobileInfos = CardMobileInfo.b(this.moblieInfoPacked);
        }
        if (!TextUtils.isEmpty(this.uinInfoPacked)) {
            this.uinInfos = CardUinInfo.b(this.uinInfoPacked);
        }
        if (!TextUtils.isEmpty(this.OCRInfoPacked)) {
            this.OCRInfo = CardOCRInfo.b(this.OCRInfoPacked);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.prewrite();
        if (this.mobilesNum.size() > 0) {
            this.mobulesNumPacked = pack(this.mobilesNum);
        }
        if (this.descs.size() > 0) {
            this.descsPacked = pack(this.descs);
        }
        if (this.mobileInfos.size() > 0) {
            this.moblieInfoPacked = CardMobileInfo.a(this.mobileInfos);
        }
        if (this.uinInfos.size() > 0) {
            this.uinInfoPacked = CardUinInfo.a(this.uinInfos);
        }
        this.OCRInfoPacked = CardOCRInfo.a(this.OCRInfo);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("BusinessCard{");
        sb5.append("cardId=" + this.cardId);
        sb5.append(", bindUin=" + this.bindUin);
        sb5.append(", bindMobile = " + this.bindMobile);
        sb5.append("\n picUrl=" + this.picUrl);
        sb5.append("\n ocrInfo=" + this.OCRInfo);
        sb5.append("\n qqNum=" + this.qqNum);
        sb5.append("\n uinInfo=" + this.uinInfos);
        sb5.append("\n mobilesNum=" + this.mobilesNum);
        sb5.append("\n mobileInfo=" + this.mobileInfos);
        sb5.append(", cardType=" + this.cardType);
        sb5.append(", lastUpdateTime=" + this.lastUpdateTime);
        sb5.append('}');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.cardId);
        parcel.writeString(this.cardName);
        parcel.writeString(this.company);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.bindUin);
        parcel.writeString(this.bindMobile);
        parcel.writeInt(this.cardSrc);
        parcel.writeList(this.mobilesNum);
        parcel.writeList(this.qqNum);
        parcel.writeList(this.descs);
        parcel.writeList(this.mobileInfos);
        parcel.writeList(this.uinInfos);
        parcel.writeParcelable(this.OCRInfo, 0);
        parcel.writeInt(this.cardType);
        parcel.writeInt(this.lastUpdateTime);
        parcel.writeString(this.sortDesc);
    }

    public BusinessCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.cardSrc = 1;
        this.mobilesNum = new ArrayList();
        this.qqNum = new ArrayList();
        this.descs = new ArrayList();
        this.cardType = 0;
        this.mobileInfos = new ArrayList();
        this.uinInfos = new ArrayList();
    }
}
