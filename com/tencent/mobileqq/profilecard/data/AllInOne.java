package com.tencent.mobileqq.profilecard.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AllInOne implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<AllInOne> CREATOR;
    public int age;
    public String aioDistance;
    public String alias;
    public boolean bindQQ;
    public int chatAbility;
    public byte[] chatCookie;
    public int chatEntrance;
    public String circleName;
    public int colorScreen;
    public byte constellation;
    public ArrayList<ProfileContactInfo> contactArray;
    public String contactName;
    public String discussUin;
    public String distanceTime;
    public String encId;
    public byte[] extendFriendVoiceCode;
    public Bundle extras;
    public short faceId;
    public byte gender;
    public int lastActivity;
    public long likeSource;
    public byte maritalStatus;
    public String nickname;

    /* renamed from: pa, reason: collision with root package name */
    public int f260789pa;
    public int preWinType;
    public String preWinUin;
    public int professionId;
    public int profileEntryType;
    public String recommendName;
    public String remark;
    public Bundle reportExtra;
    public int sourceID;
    public int subSourceId;
    public String troopCode;
    public String troopNickName;
    public String troopUin;
    public String uid;
    public String uin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new Parcelable.Creator<AllInOne>() { // from class: com.tencent.mobileqq.profilecard.data.AllInOne.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public AllInOne createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (AllInOne) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                    }
                    AllInOne allInOne = new AllInOne();
                    allInOne.uin = parcel.readString();
                    allInOne.f260789pa = parcel.readInt();
                    allInOne.age = parcel.readInt();
                    allInOne.gender = parcel.readByte();
                    allInOne.faceId = (short) parcel.readInt();
                    allInOne.maritalStatus = parcel.readByte();
                    allInOne.professionId = parcel.readInt();
                    allInOne.constellation = parcel.readByte();
                    allInOne.distanceTime = parcel.readString();
                    allInOne.troopCode = parcel.readString();
                    allInOne.troopUin = parcel.readString();
                    allInOne.discussUin = parcel.readString();
                    ArrayList<ProfileContactInfo> arrayList = new ArrayList<>();
                    allInOne.contactArray = arrayList;
                    parcel.readTypedList(arrayList, ProfileContactInfo.CREATOR);
                    allInOne.chatAbility = parcel.readInt();
                    allInOne.preWinUin = parcel.readString();
                    allInOne.preWinType = parcel.readInt();
                    allInOne.nickname = parcel.readString();
                    allInOne.remark = parcel.readString();
                    allInOne.alias = parcel.readString();
                    allInOne.contactName = parcel.readString();
                    allInOne.recommendName = parcel.readString();
                    allInOne.troopNickName = parcel.readString();
                    allInOne.circleName = parcel.readString();
                    allInOne.lastActivity = parcel.readInt();
                    allInOne.profileEntryType = parcel.readInt();
                    allInOne.sourceID = parcel.readInt();
                    allInOne.chatCookie = parcel.createByteArray();
                    allInOne.chatEntrance = parcel.readInt();
                    allInOne.encId = parcel.readString();
                    allInOne.uid = parcel.readString();
                    allInOne.likeSource = parcel.readLong();
                    allInOne.subSourceId = parcel.readInt();
                    allInOne.aioDistance = parcel.readString();
                    allInOne.extras = (Bundle) parcel.readParcelable(Bundle.class.getClassLoader());
                    allInOne.colorScreen = parcel.readInt();
                    allInOne.reportExtra = (Bundle) parcel.readParcelable(Bundle.class.getClassLoader());
                    allInOne.extendFriendVoiceCode = parcel.createByteArray();
                    return allInOne;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public AllInOne[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AllInOne[i3] : (AllInOne[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
            };
        }
    }

    AllInOne() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.profileEntryType = 999;
        this.age = -1;
        this.gender = (byte) -1;
        this.faceId = (short) -1;
        this.maritalStatus = (byte) 0;
        this.professionId = 0;
        this.constellation = (byte) 0;
        this.preWinUin = "";
        this.preWinType = -1;
        this.lastActivity = 0;
        this.chatEntrance = 0;
        this.encId = "";
        this.uid = "";
        this.likeSource = 0L;
        this.reportExtra = new Bundle();
        this.extras = new Bundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "AllInOne{uin='" + this.uin + "', pa=" + this.f260789pa + ", profileEntryType=" + this.profileEntryType + ", sourceID=" + this.sourceID + ", subSourceId=" + this.subSourceId + ", age=" + this.age + ", gender=" + ((int) this.gender) + ", faceId=" + ((int) this.faceId) + ", maritalStatus=" + ((int) this.maritalStatus) + ", professionId=" + this.professionId + ", constellation=" + ((int) this.constellation) + ", distanceTime='" + this.distanceTime + "', troopCode='" + this.troopCode + "', troopUin='" + this.troopUin + "', discussUin='" + this.discussUin + "', contactArray=" + this.contactArray + ", chatAbility=" + this.chatAbility + ", preWinUin='" + this.preWinUin + "', preWinType=" + this.preWinType + ", colorScreen=" + this.colorScreen + ", nickname='" + this.nickname + "', remark='" + this.remark + "', alias='" + this.alias + "', contactName='" + this.contactName + "', recommendName='" + this.recommendName + "', troopNickName='" + this.troopNickName + "', circleName='" + this.circleName + "', lastActivity=" + this.lastActivity + ", chatCookie=" + Arrays.toString(this.chatCookie) + ", chatEntrance=" + this.chatEntrance + ", encId='" + this.encId + "', uid='" + this.uid + "', likeSource=" + this.likeSource + ", bindQQ=" + this.bindQQ + ", aioDistance='" + this.aioDistance + "', extendFriendVoiceCode=" + Arrays.toString(this.extendFriendVoiceCode) + ", reportExtra=" + this.reportExtra + ", extras=" + this.extras + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.uin);
        parcel.writeInt(this.f260789pa);
        parcel.writeInt(this.age);
        parcel.writeByte(this.gender);
        parcel.writeInt(this.faceId);
        parcel.writeByte(this.maritalStatus);
        parcel.writeInt(this.professionId);
        parcel.writeByte(this.constellation);
        parcel.writeString(this.distanceTime);
        parcel.writeString(this.troopCode);
        parcel.writeString(this.troopUin);
        parcel.writeString(this.discussUin);
        parcel.writeTypedList(this.contactArray);
        parcel.writeInt(this.chatAbility);
        parcel.writeString(this.preWinUin);
        parcel.writeInt(this.preWinType);
        parcel.writeString(this.nickname);
        parcel.writeString(this.remark);
        parcel.writeString(this.alias);
        parcel.writeString(this.contactName);
        parcel.writeString(this.recommendName);
        parcel.writeString(this.troopNickName);
        parcel.writeString(this.circleName);
        parcel.writeInt(this.lastActivity);
        parcel.writeInt(this.profileEntryType);
        parcel.writeInt(this.sourceID);
        parcel.writeByteArray(this.chatCookie);
        parcel.writeInt(this.chatEntrance);
        parcel.writeString(this.encId);
        parcel.writeString(this.uid);
        parcel.writeLong(this.likeSource);
        parcel.writeInt(this.subSourceId);
        parcel.writeString(this.aioDistance);
        parcel.writeParcelable(this.extras, i3);
        parcel.writeInt(this.colorScreen);
        parcel.writeParcelable(this.reportExtra, i3);
        parcel.writeByteArray(this.extendFriendVoiceCode);
    }

    public AllInOne(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            return;
        }
        this.profileEntryType = 999;
        this.age = -1;
        this.gender = (byte) -1;
        this.faceId = (short) -1;
        this.maritalStatus = (byte) 0;
        this.professionId = 0;
        this.constellation = (byte) 0;
        this.preWinUin = "";
        this.preWinType = -1;
        this.lastActivity = 0;
        this.chatEntrance = 0;
        this.encId = "";
        this.uid = "";
        this.likeSource = 0L;
        this.reportExtra = new Bundle();
        this.extras = new Bundle();
        this.uin = str;
        this.f260789pa = i3;
    }
}
