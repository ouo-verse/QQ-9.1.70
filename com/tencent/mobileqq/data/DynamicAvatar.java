package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.avatar.dynamicavatar.b;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DynamicAvatar extends Entity implements Parcelable {
    public static final Parcelable.Creator<DynamicAvatar> CREATOR = new a();
    public String basicBigUrl;
    public String basicMiddleUrl;
    public int basicOverdueTimeStamp;
    public int basicSetTimeStamp;
    public String basicSmallUrl;
    public String basicStaticUrl;
    public int getTimeStamp;
    public String nearbyBigUrl;
    public String nearbyMiddleUrl;
    public int nearbyOverdueTimeStamp;
    public int nearbySetTimeStamp;
    public String nearbySmallUrl;
    public String nearbyStaticUrl;
    public long playTimeStamp;
    public long tinyId;
    public long uin;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<DynamicAvatar> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicAvatar createFromParcel(Parcel parcel) {
            return new DynamicAvatar(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DynamicAvatar[] newArray(int i3) {
            return new DynamicAvatar[i3];
        }
    }

    public DynamicAvatar() {
        this.basicSmallUrl = "";
        this.basicMiddleUrl = "";
        this.basicBigUrl = "";
        this.nearbySmallUrl = "";
        this.nearbyMiddleUrl = "";
        this.nearbyBigUrl = "";
        this.basicStaticUrl = "";
        this.nearbyStaticUrl = "";
    }

    public static DynamicAvatar convertFrom(b.a aVar) {
        if (aVar == null) {
            return null;
        }
        DynamicAvatar dynamicAvatar = new DynamicAvatar();
        dynamicAvatar.tinyId = aVar.f200068c;
        dynamicAvatar.uin = aVar.f200066a;
        dynamicAvatar.getTimeStamp = aVar.f200067b;
        ArrayList<b.C7433b> arrayList = aVar.f200069d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<b.C7433b> it = aVar.f200069d.iterator();
            while (it.hasNext()) {
                b.C7433b next = it.next();
                if (next != null) {
                    ArrayList<b.c> arrayList2 = next.f200075f;
                    int i3 = next.f200074e;
                    if (i3 == 17) {
                        dynamicAvatar.basicSetTimeStamp = next.f200073d;
                        dynamicAvatar.basicOverdueTimeStamp = next.f200071b;
                        dynamicAvatar.basicStaticUrl = next.f200072c;
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            Iterator<b.c> it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                b.c next2 = it5.next();
                                if (next2 != null) {
                                    int i16 = next2.f200077b;
                                    if (i16 != 80 && i16 != 100) {
                                        if (i16 == 200) {
                                            dynamicAvatar.basicMiddleUrl = next2.f200076a;
                                        } else if (i16 == 640) {
                                            dynamicAvatar.basicBigUrl = next2.f200076a;
                                        }
                                    } else {
                                        dynamicAvatar.basicSmallUrl = next2.f200076a;
                                    }
                                }
                            }
                        }
                    } else if (i3 == 18) {
                        dynamicAvatar.nearbySetTimeStamp = next.f200073d;
                        dynamicAvatar.nearbyOverdueTimeStamp = next.f200071b;
                        dynamicAvatar.nearbyStaticUrl = next.f200072c;
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            Iterator<b.c> it6 = arrayList2.iterator();
                            while (it6.hasNext()) {
                                b.c next3 = it6.next();
                                if (next3 != null) {
                                    int i17 = next3.f200077b;
                                    if (i17 != 80 && i17 != 100) {
                                        if (i17 == 200) {
                                            dynamicAvatar.nearbyMiddleUrl = next3.f200076a;
                                        } else if (i17 == 640) {
                                            dynamicAvatar.nearbyBigUrl = next3.f200076a;
                                        }
                                    } else {
                                        dynamicAvatar.nearbySmallUrl = next3.f200076a;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return dynamicAvatar;
        }
        QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 1, "convertFrom oneUinHeadInfo's headInfos is null.");
        return dynamicAvatar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\n************************************************\ntinid: " + this.tinyId + "\nuin: " + this.uin + "\ngetTimeStamp: " + this.getTimeStamp + "\nbasicOverdueTimeStamp: " + this.basicOverdueTimeStamp + "\nnearbyOverdueTimeStamp: " + this.nearbyOverdueTimeStamp + "\nbasicSetTimeStamp: " + this.basicSetTimeStamp + "\nnearbySetTimeStamp: " + this.nearbySetTimeStamp + "\nplayTimeStamp: " + this.playTimeStamp + "\nbasicSmallUrl: " + this.basicSmallUrl + "\nbasicMiddleUrl: " + this.basicMiddleUrl + "\nbasicBigUrl: " + this.basicBigUrl + "\nnearbySmallUrl: " + this.nearbySmallUrl + "\nnearbyMiddleUrl: " + this.nearbyMiddleUrl + "\nnearbyBigUrl: " + this.nearbyBigUrl + "\nnearbyStaticUrl: " + this.nearbyStaticUrl + "\n************************************************";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.tinyId);
        parcel.writeLong(this.uin);
        parcel.writeInt(this.getTimeStamp);
        parcel.writeInt(this.basicOverdueTimeStamp);
        parcel.writeInt(this.nearbyOverdueTimeStamp);
        parcel.writeInt(this.basicSetTimeStamp);
        parcel.writeInt(this.nearbySetTimeStamp);
        parcel.writeString(this.basicSmallUrl);
        parcel.writeString(this.basicMiddleUrl);
        parcel.writeString(this.basicBigUrl);
        parcel.writeString(this.nearbySmallUrl);
        parcel.writeString(this.nearbyMiddleUrl);
        parcel.writeString(this.nearbyBigUrl);
        parcel.writeLong(this.playTimeStamp);
    }

    protected DynamicAvatar(Parcel parcel) {
        this.basicSmallUrl = "";
        this.basicMiddleUrl = "";
        this.basicBigUrl = "";
        this.nearbySmallUrl = "";
        this.nearbyMiddleUrl = "";
        this.nearbyBigUrl = "";
        this.basicStaticUrl = "";
        this.nearbyStaticUrl = "";
        this.tinyId = parcel.readLong();
        this.uin = parcel.readLong();
        this.getTimeStamp = parcel.readInt();
        this.basicOverdueTimeStamp = parcel.readInt();
        this.nearbyOverdueTimeStamp = parcel.readInt();
        this.basicSetTimeStamp = parcel.readInt();
        this.nearbySetTimeStamp = parcel.readInt();
        this.basicSmallUrl = parcel.readString();
        this.basicMiddleUrl = parcel.readString();
        this.basicBigUrl = parcel.readString();
        this.nearbySmallUrl = parcel.readString();
        this.nearbyMiddleUrl = parcel.readString();
        this.nearbyBigUrl = parcel.readString();
        this.playTimeStamp = parcel.readLong();
    }
}
