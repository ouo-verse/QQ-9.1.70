package com.tencent.mobileqq.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import java.util.Comparator;

/* compiled from: P */
@PluginInterface
/* loaded from: classes18.dex */
public class ResultRecord implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ResultRecord> CREATOR;
    public String gameLevelIcon;
    public String groupUin;
    public String guildAvatarUrl;
    public String guildId;
    public boolean isNewTroop;
    public long lastChooseTime;
    public String matchFriendAvatarUrl;
    public TroopMemberNickInfo memberNickInfo;
    public String name;
    public String phone;
    public int source;
    public int type;
    public String uid;
    public String uin;
    public int uinType;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class DefaultComparator implements Comparator<ResultRecord> {
        static IPatchRedirector $redirector_;

        public DefaultComparator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(ResultRecord resultRecord, ResultRecord resultRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultRecord, (Object) resultRecord2)).intValue();
            }
            long j3 = resultRecord == null ? 0L : resultRecord.lastChooseTime;
            long j16 = resultRecord2 == null ? 0L : resultRecord2.lastChooseTime;
            if (j3 == j16) {
                return 0;
            }
            return (j3 != 0 && (j16 == 0 || j3 >= j16)) ? 1 : -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<ResultRecord> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultRecord createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ResultRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ResultRecord(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultRecord[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ResultRecord[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ResultRecord[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26364);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ ResultRecord(Parcel parcel, a aVar) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel, (Object) aVar);
    }

    public static ResultRecord copyResultRecord(ResultRecord resultRecord) {
        if (resultRecord != null) {
            ResultRecord resultRecord2 = new ResultRecord();
            resultRecord2.uin = resultRecord.uin;
            resultRecord2.uid = resultRecord.uid;
            resultRecord2.name = resultRecord.name;
            resultRecord2.type = resultRecord.type;
            resultRecord2.groupUin = resultRecord.groupUin;
            resultRecord2.phone = resultRecord.phone;
            resultRecord2.uinType = resultRecord.uinType;
            resultRecord2.isNewTroop = resultRecord.isNewTroop;
            resultRecord2.gameLevelIcon = resultRecord.gameLevelIcon;
            resultRecord2.guildId = resultRecord.guildId;
            resultRecord2.guildAvatarUrl = resultRecord.guildAvatarUrl;
            resultRecord2.matchFriendAvatarUrl = resultRecord.matchFriendAvatarUrl;
            resultRecord2.source = resultRecord.source;
            return resultRecord2;
        }
        return null;
    }

    public static ResultRecord readFromParcel(Parcel parcel) {
        return CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof ResultRecord) {
            ResultRecord resultRecord = (ResultRecord) obj;
            if (resultRecord.uin.equals(this.uin) && resultRecord.type == this.type) {
                if (TextUtils.isEmpty(this.phone) || TextUtils.isEmpty(resultRecord.phone) || !this.phone.equals(resultRecord.phone)) {
                    if (TextUtils.isEmpty(this.phone) && TextUtils.isEmpty(resultRecord.phone)) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = this.uinType;
        if (i3 == -1 && this.type == 4) {
            return 1006;
        }
        return i3;
    }

    public void init(String str, String str2, String str3, int i3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, Integer.valueOf(i3), str4);
            return;
        }
        this.uin = str;
        this.name = str4;
        this.uinType = i3;
        this.guildId = str2;
        this.guildAvatarUrl = str3;
        this.groupUin = "";
        this.phone = "";
        this.lastChooseTime = 0L;
        this.isNewTroop = false;
        this.gameLevelIcon = "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "[uin:" + this.uin + "[uid:" + this.uid + ", name:" + this.name + ", type:" + this.type + ", groupUin:" + this.groupUin + ", uinType:" + this.uinType + ", guildId:" + this.guildId + ", guildAvatarUrl" + this.guildAvatarUrl + ", matchFriendAvatarUrl:" + this.matchFriendAvatarUrl + ", source:" + this.source + ", phone:" + this.phone + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.uin);
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.type);
        parcel.writeString(this.groupUin);
        parcel.writeParcelable(this.memberNickInfo, i3);
        parcel.writeString(this.phone);
        parcel.writeLong(this.lastChooseTime);
        parcel.writeInt(this.uinType);
        parcel.writeInt(this.isNewTroop ? 1 : 0);
        parcel.writeString(this.gameLevelIcon);
        parcel.writeString(this.guildId);
        parcel.writeString(this.guildAvatarUrl);
        parcel.writeString(this.matchFriendAvatarUrl);
        parcel.writeInt(this.source);
    }

    public ResultRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uinType = -1;
            this.source = 2;
        }
    }

    public ResultRecord(String str, String str2, int i3, int i16, String str3, String str4, long j3, boolean z16, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, str4, Long.valueOf(j3), Boolean.valueOf(z16), str5);
            return;
        }
        this.source = 2;
        this.uin = str;
        this.name = str2;
        this.type = i3;
        this.uinType = i16;
        this.groupUin = str3;
        this.phone = str4;
        this.lastChooseTime = j3;
        this.isNewTroop = z16;
        this.gameLevelIcon = str5;
    }

    public void init(String str, String str2, int i3, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3), str3, str4);
            return;
        }
        this.uin = str;
        this.name = str2;
        this.uinType = i3;
        this.groupUin = str3;
        this.phone = str4;
        this.lastChooseTime = 0L;
        this.isNewTroop = false;
        this.gameLevelIcon = "";
    }

    public ResultRecord(String str, String str2, int i3, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), str3, str4);
            return;
        }
        this.uinType = -1;
        this.source = 2;
        init(str, str2, i3, str3, str4);
    }

    public ResultRecord(String str, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), str3);
            return;
        }
        this.source = 2;
        this.uin = str;
        this.name = str2;
        this.uinType = i3;
        this.guildId = str3;
        this.groupUin = "";
        this.phone = "";
        this.lastChooseTime = 0L;
        this.isNewTroop = false;
        this.gameLevelIcon = "";
        this.guildAvatarUrl = "";
    }

    ResultRecord(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel);
            return;
        }
        this.uinType = -1;
        this.source = 2;
        this.uin = parcel.readString();
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.type = parcel.readInt();
        this.groupUin = parcel.readString();
        this.memberNickInfo = (TroopMemberNickInfo) parcel.readParcelable(TroopMemberNickInfo.class.getClassLoader());
        this.phone = parcel.readString();
        this.lastChooseTime = parcel.readLong();
        this.uinType = parcel.readInt();
        this.isNewTroop = parcel.readInt() == 1;
        this.gameLevelIcon = parcel.readString();
        this.guildId = parcel.readString();
        this.guildAvatarUrl = parcel.readString();
        this.matchFriendAvatarUrl = parcel.readString();
        this.source = parcel.readInt();
    }
}
