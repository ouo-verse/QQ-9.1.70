package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StYouZanGood;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.NotificationActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommodityBean implements Parcelable {
    public static final Parcelable.Creator<CommodityBean> CREATOR = new a();
    public String mAlias;
    public String mImg;
    public long mItemID;
    public long mPrice;
    public String mTitle;
    public String mUrl;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<CommodityBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommodityBean createFromParcel(Parcel parcel) {
            return new CommodityBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommodityBean[] newArray(int i3) {
            return new CommodityBean[i3];
        }
    }

    public CommodityBean() {
        this.mTitle = "";
        this.mItemID = 0L;
        this.mPrice = 0L;
        this.mImg = "";
        this.mUrl = "";
        this.mAlias = "";
    }

    private String checkNumString(String str) {
        if (str == null) {
            return "0";
        }
        return str;
    }

    public CertifiedAccountMeta$StYouZanGood convertToYouzanGood() {
        CertifiedAccountMeta$StYouZanGood certifiedAccountMeta$StYouZanGood = new CertifiedAccountMeta$StYouZanGood();
        certifiedAccountMeta$StYouZanGood.title.set(this.mTitle);
        certifiedAccountMeta$StYouZanGood.itemID.set(this.mItemID);
        certifiedAccountMeta$StYouZanGood.price.set(this.mPrice);
        certifiedAccountMeta$StYouZanGood.img.set(this.mImg);
        certifiedAccountMeta$StYouZanGood.url.set(this.mUrl);
        String str = this.mAlias;
        if (str != null) {
            certifiedAccountMeta$StYouZanGood.alias.set(str);
        }
        return certifiedAccountMeta$StYouZanGood;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mItemID);
        parcel.writeLong(this.mPrice);
        parcel.writeString(this.mImg);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mAlias);
    }

    public CommodityBean(JSONObject jSONObject) throws JSONException {
        this.mTitle = "";
        this.mItemID = 0L;
        this.mPrice = 0L;
        this.mImg = "";
        this.mUrl = "";
        this.mAlias = "";
        this.mTitle = jSONObject.getString("title");
        if (jSONObject.has("itemId")) {
            this.mItemID = Long.valueOf(checkNumString(jSONObject.getString("itemId"))).longValue();
        }
        this.mImg = jSONObject.getString("img");
        this.mPrice = Long.valueOf(checkNumString(jSONObject.getString("price"))).longValue();
        this.mUrl = jSONObject.getString("url");
        if (jSONObject.has(NotificationActivity.KEY_ALIAS)) {
            this.mAlias = jSONObject.getString(NotificationActivity.KEY_ALIAS);
        }
    }

    protected CommodityBean(Parcel parcel) {
        this.mTitle = "";
        this.mItemID = 0L;
        this.mPrice = 0L;
        this.mImg = "";
        this.mUrl = "";
        this.mAlias = "";
        this.mTitle = parcel.readString();
        this.mItemID = parcel.readLong();
        this.mPrice = parcel.readLong();
        this.mImg = parcel.readString();
        this.mUrl = parcel.readString();
        this.mAlias = parcel.readString();
    }
}
