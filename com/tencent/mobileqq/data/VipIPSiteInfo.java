package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class VipIPSiteInfo implements Parcelable {
    public static final Parcelable.Creator<VipIPSiteInfo> CREATOR = new a();
    public int extId;
    public String extStr;
    public String ipContent;
    public String ipDesc;
    public int ipID;
    public List<Object> ipList;
    public String ipLogo;
    public String ipName;
    public String ipUrl;
    public int itemSize;
    public String strType;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VipIPSiteInfo createFromParcel(Parcel parcel) {
            VipIPSiteInfo vipIPSiteInfo = new VipIPSiteInfo();
            vipIPSiteInfo.ipID = parcel.readInt();
            vipIPSiteInfo.ipName = parcel.readString();
            vipIPSiteInfo.ipDesc = parcel.readString();
            vipIPSiteInfo.ipUrl = parcel.readString();
            vipIPSiteInfo.itemSize = parcel.readInt();
            vipIPSiteInfo.strType = parcel.readString();
            vipIPSiteInfo.extId = parcel.readInt();
            vipIPSiteInfo.extStr = parcel.readString();
            vipIPSiteInfo.ipLogo = parcel.readString();
            vipIPSiteInfo.ipContent = parcel.readString();
            if (vipIPSiteInfo.ipList == null) {
                vipIPSiteInfo.ipList = new ArrayList();
            }
            vipIPSiteInfo.ipList.clear();
            if ("gxzb".equals(vipIPSiteInfo.strType)) {
                parcel.readList(vipIPSiteInfo.ipList, IPSiteModel$Gxzb.class.getClassLoader());
            } else if ("game".equals(vipIPSiteInfo.strType)) {
                parcel.readList(vipIPSiteInfo.ipList, IPSiteModel$Game.class.getClassLoader());
            } else if ("goods".equals(vipIPSiteInfo.strType)) {
                parcel.readList(vipIPSiteInfo.ipList, IPSiteModel$Goods.class.getClassLoader());
            } else if ("video".equals(vipIPSiteInfo.strType)) {
                parcel.readList(vipIPSiteInfo.ipList, IPSiteModel$Video.class.getClassLoader());
            } else if ("book".equals(vipIPSiteInfo.strType)) {
                parcel.readList(vipIPSiteInfo.ipList, IPSiteModel$Book.class.getClassLoader());
            } else if ("comic".equals(vipIPSiteInfo.strType)) {
                parcel.readList(vipIPSiteInfo.ipList, IPSiteModel$Comic.class.getClassLoader());
            }
            return vipIPSiteInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VipIPSiteInfo[] newArray(int i3) {
            return new VipIPSiteInfo[i3];
        }
    }

    public VipIPSiteInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "VipIPSiteInfo{ipID=" + this.ipID + ", ipName='" + this.ipName + "', ipDesc='" + this.ipDesc + "', ipUrl='" + this.ipUrl + "', itemSize=" + this.itemSize + ", strType='" + this.strType + "', extId=" + this.extId + ", extStr='" + this.extStr + "', ipLogo='" + this.ipLogo + "', ipContent='" + this.ipContent + "', ipList=" + this.ipList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.ipID);
        parcel.writeString(this.ipName);
        parcel.writeString(this.ipDesc);
        parcel.writeString(this.ipUrl);
        parcel.writeInt(this.itemSize);
        parcel.writeString(this.strType);
        parcel.writeInt(this.extId);
        parcel.writeString(this.extStr);
        parcel.writeString(this.ipLogo);
        parcel.writeString(this.ipContent);
        parcel.writeList(this.ipList);
    }

    public VipIPSiteInfo(int i3, String str, String str2, String str3, int i16, String str4, int i17, String str5, String str6, String str7, List<Object> list) {
        this.ipID = i3;
        this.ipName = str;
        this.ipDesc = str2;
        this.ipUrl = str3;
        this.itemSize = i16;
        this.strType = str4;
        this.extId = i17;
        this.extStr = str5;
        this.ipLogo = str6;
        this.ipContent = str7;
        this.ipList = list;
    }
}
