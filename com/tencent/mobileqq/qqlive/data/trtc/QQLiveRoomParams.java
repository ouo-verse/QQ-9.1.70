package com.tencent.mobileqq.qqlive.data.trtc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes17.dex */
public class QQLiveRoomParams implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<QQLiveRoomParams> CREATOR;
    private String mBusinessInfo;
    private int mRoleType;
    private long mRoomId;
    private int mScene;
    private String mStreamId;
    private String mUserDefineRecordId;
    private String mUserId;
    private String mUserSig;

    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private QQLiveRoomParams mRoomParam;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mRoomParam = new QQLiveRoomParams();
            }
        }

        public QQLiveRoomParams build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (QQLiveRoomParams) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.mRoomParam;
        }

        public Builder setBussinessInfo(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.mRoomParam.mBusinessInfo = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }

        public Builder setRoleType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.mRoomParam.mRoleType = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }

        public Builder setRoomId(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.mRoomParam.mRoomId = j3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }

        public Builder setScene(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                this.mRoomParam.mScene = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }

        public Builder setStreamId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.mRoomParam.mStreamId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }

        public Builder setUserDefineRecordId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.mRoomParam.mUserDefineRecordId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }

        public Builder setUserId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mRoomParam.mUserId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }

        public Builder setUserSig(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.mRoomParam.mUserSig = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            CREATOR = new Parcelable.Creator<QQLiveRoomParams>() { // from class: com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QQLiveRoomParams createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new QQLiveRoomParams(parcel) : (QQLiveRoomParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QQLiveRoomParams[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new QQLiveRoomParams[i3] : (QQLiveRoomParams[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    QQLiveRoomParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUserId = "";
        this.mRoomId = 0L;
        this.mRoleType = 0;
        this.mUserDefineRecordId = "";
        this.mBusinessInfo = "";
        this.mScene = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String getBussinessInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mBusinessInfo;
    }

    public int getRoleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mRoleType;
    }

    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mRoomId;
    }

    public int getScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mScene;
    }

    public String getStreamId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mStreamId;
    }

    public String getUserDefineRecordId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mUserDefineRecordId;
    }

    public String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mUserId;
    }

    public String getUserSig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mUserSig;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "QQLiveRoomParams{mUserId='" + this.mUserId + "', mRoomId=" + this.mRoomId + ", mUserSig='" + this.mUserSig + "', mRoleType=" + this.mRoleType + ", mStreamId='" + this.mStreamId + "', mUserDefineRecordId='" + this.mUserDefineRecordId + "', mBusinessInfo='" + this.mBusinessInfo + "', mScene=" + this.mScene + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.mUserId);
        parcel.writeLong(this.mRoomId);
        parcel.writeString(this.mUserSig);
        parcel.writeInt(this.mRoleType);
        parcel.writeString(this.mStreamId);
        parcel.writeString(this.mUserDefineRecordId);
        parcel.writeString(this.mBusinessInfo);
        parcel.writeInt(this.mScene);
    }

    protected QQLiveRoomParams(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mUserId = "";
        this.mRoomId = 0L;
        this.mRoleType = 0;
        this.mUserDefineRecordId = "";
        this.mBusinessInfo = "";
        this.mScene = 1;
        this.mUserId = parcel.readString();
        this.mRoomId = parcel.readLong();
        this.mUserSig = parcel.readString();
        this.mRoleType = parcel.readInt();
        this.mStreamId = parcel.readString();
        this.mUserDefineRecordId = parcel.readString();
        this.mBusinessInfo = parcel.readString();
        this.mScene = parcel.readInt();
    }
}
