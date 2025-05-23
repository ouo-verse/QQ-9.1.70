package com.tencent.mobileqq.qqlive.data.gift;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAudienceGiftData implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<QQLiveAudienceGiftData> CREATOR;
    public String anchorHead;
    public String anchorNick;
    public long anchorUin;
    public int busId;
    public String gameId;
    public boolean isSpecialAnchor;
    public int panelStyle;
    public String programmeId;
    public long roomId;
    public String traceInfo;
    public String userHead;
    public String userNick;
    public long userUin;
    public String videoSource;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56679);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new Parcelable.Creator<QQLiveAudienceGiftData>() { // from class: com.tencent.mobileqq.qqlive.data.gift.QQLiveAudienceGiftData.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QQLiveAudienceGiftData createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new QQLiveAudienceGiftData(parcel) : (QQLiveAudienceGiftData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QQLiveAudienceGiftData[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new QQLiveAudienceGiftData[i3] : (QQLiveAudienceGiftData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public QQLiveAudienceGiftData(int i3, String str, long j3, long j16, long j17, String str2, String str3, String str4, int i16, String str5, String str6, String str7, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str2, str3, str4, Integer.valueOf(i16), str5, str6, str7, Boolean.valueOf(z16));
            return;
        }
        this.gameId = "";
        this.busId = i3;
        this.userNick = str;
        this.roomId = j3;
        this.userUin = j16;
        this.anchorUin = j17;
        this.userHead = str2;
        this.anchorNick = str3;
        this.anchorHead = str4;
        this.panelStyle = i16;
        this.traceInfo = str5;
        this.programmeId = str6;
        this.videoSource = str7;
        this.isSpecialAnchor = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.busId = parcel.readInt();
        this.userNick = parcel.readString();
        this.roomId = parcel.readLong();
        this.userUin = parcel.readLong();
        this.anchorUin = parcel.readLong();
        this.userHead = parcel.readString();
        this.anchorNick = parcel.readString();
        this.anchorHead = parcel.readString();
        this.panelStyle = parcel.readInt();
        this.traceInfo = parcel.readString();
        this.programmeId = parcel.readString();
        this.videoSource = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.isSpecialAnchor = zArr[0];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.busId);
        parcel.writeString(this.userNick);
        parcel.writeLong(this.roomId);
        parcel.writeLong(this.userUin);
        parcel.writeLong(this.anchorUin);
        parcel.writeString(this.userHead);
        parcel.writeString(this.anchorNick);
        parcel.writeString(this.anchorHead);
        parcel.writeInt(this.panelStyle);
        parcel.writeString(this.traceInfo);
        parcel.writeString(this.programmeId);
        parcel.writeString(this.videoSource);
        parcel.writeBooleanArray(new boolean[]{this.isSpecialAnchor});
    }

    protected QQLiveAudienceGiftData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.userNick = "";
        this.userHead = "";
        this.anchorNick = "";
        this.anchorHead = "";
        this.traceInfo = "";
        this.isSpecialAnchor = false;
        this.gameId = "";
        this.busId = parcel.readInt();
        this.userNick = parcel.readString();
        this.roomId = parcel.readLong();
        this.userUin = parcel.readLong();
        this.anchorUin = parcel.readLong();
        this.userHead = parcel.readString();
        this.anchorNick = parcel.readString();
        this.anchorHead = parcel.readString();
        this.panelStyle = parcel.readInt();
        this.traceInfo = parcel.readString();
        this.programmeId = parcel.readString();
        this.videoSource = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.isSpecialAnchor = zArr[0];
    }
}
