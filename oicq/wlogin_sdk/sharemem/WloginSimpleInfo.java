package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WloginSimpleInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<WloginSimpleInfo> CREATOR = new Parcelable.Creator<WloginSimpleInfo>() { // from class: oicq.wlogin_sdk.sharemem.WloginSimpleInfo.1
        @Override // android.os.Parcelable.Creator
        public WloginSimpleInfo createFromParcel(Parcel parcel) {
            return new WloginSimpleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WloginSimpleInfo[] newArray(int i3) {
            return new WloginSimpleInfo[i3];
        }
    };
    private static final long serialVersionUID = 1;
    public byte[] _age;
    public byte[] _face;
    public byte[] _gender;
    public byte[] _img_format;
    public byte[] _img_type;
    public byte[] _img_url;
    public byte[] _nick;
    public long _uin;
    public byte[] mainDisplayName;

    public WloginSimpleInfo() {
        this._uin = 0L;
        this._face = new byte[0];
        this._age = new byte[0];
        this._gender = new byte[0];
        this._nick = new byte[0];
        this._img_type = new byte[0];
        this._img_format = new byte[0];
        this._img_url = new byte[0];
        this.mainDisplayName = new byte[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WloginSimpleInfo get_clone() {
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        wloginSimpleInfo._uin = this._uin;
        byte[] bArr = this._face;
        if (bArr != null) {
            wloginSimpleInfo._face = (byte[]) bArr.clone();
        }
        byte[] bArr2 = this._age;
        if (bArr2 != null) {
            wloginSimpleInfo._age = (byte[]) bArr2.clone();
        }
        byte[] bArr3 = this._gender;
        if (bArr3 != null) {
            wloginSimpleInfo._gender = (byte[]) bArr3.clone();
        }
        byte[] bArr4 = this._nick;
        if (bArr4 != null) {
            wloginSimpleInfo._nick = (byte[]) bArr4.clone();
        }
        byte[] bArr5 = this._img_type;
        if (bArr5 != null) {
            wloginSimpleInfo._img_type = (byte[]) bArr5.clone();
        }
        byte[] bArr6 = this._img_format;
        if (bArr6 != null) {
            wloginSimpleInfo._img_format = (byte[]) bArr6.clone();
        }
        byte[] bArr7 = this._img_url;
        if (bArr7 != null) {
            wloginSimpleInfo._img_url = (byte[]) bArr7.clone();
        }
        byte[] bArr8 = this.mainDisplayName;
        if (bArr8 != null) {
            wloginSimpleInfo.mainDisplayName = (byte[]) bArr8.clone();
        }
        return wloginSimpleInfo;
    }

    public void readFromParcel(Parcel parcel) {
        this._uin = parcel.readLong();
        this._face = parcel.createByteArray();
        this._age = parcel.createByteArray();
        this._gender = parcel.createByteArray();
        this._nick = parcel.createByteArray();
        this._img_type = parcel.createByteArray();
        this._img_format = parcel.createByteArray();
        this._img_url = parcel.createByteArray();
        this.mainDisplayName = parcel.createByteArray();
    }

    public void setAge(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._age = (byte[]) bArr.clone();
        }
    }

    public void setFace(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._face = (byte[]) bArr.clone();
        }
    }

    public void setGender(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._gender = (byte[]) bArr.clone();
        }
    }

    public void setImgFormat(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._img_format = (byte[]) bArr.clone();
        }
    }

    public void setImgType(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._img_type = (byte[]) bArr.clone();
        }
    }

    public void setImgUrl(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._img_url = (byte[]) bArr.clone();
        }
    }

    public void setMainDisplayName(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.mainDisplayName = (byte[]) bArr.clone();
        }
    }

    public void setNick(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._nick = (byte[]) bArr.clone();
        }
    }

    public void setReserveUinInfo(byte[][] bArr) {
        if (bArr != null && bArr.length == 3) {
            byte[] bArr2 = bArr[0];
            if (bArr2.length > 0 && bArr[1].length > 0 && bArr[2].length > 0) {
                this._img_type = (byte[]) bArr2.clone();
                this._img_format = (byte[]) bArr[1].clone();
                this._img_url = (byte[]) bArr[2].clone();
            }
        }
    }

    public void setUin(long j3) {
        this._uin = j3;
    }

    public void set_info(WloginSimpleInfo wloginSimpleInfo) {
        this._uin = wloginSimpleInfo._uin;
        byte[] bArr = wloginSimpleInfo._face;
        if (bArr != null) {
            this._face = (byte[]) bArr.clone();
        } else {
            this._face = new byte[0];
        }
        byte[] bArr2 = wloginSimpleInfo._age;
        if (bArr2 != null) {
            this._age = (byte[]) bArr2.clone();
        } else {
            this._age = new byte[0];
        }
        byte[] bArr3 = wloginSimpleInfo._gender;
        if (bArr3 != null) {
            this._gender = (byte[]) bArr3.clone();
        } else {
            this._gender = new byte[0];
        }
        byte[] bArr4 = wloginSimpleInfo._nick;
        if (bArr4 != null) {
            this._nick = (byte[]) bArr4.clone();
        } else {
            this._nick = new byte[0];
        }
        byte[] bArr5 = wloginSimpleInfo._img_type;
        if (bArr5 != null) {
            this._img_type = (byte[]) bArr5.clone();
        } else {
            this._img_type = new byte[0];
        }
        byte[] bArr6 = wloginSimpleInfo._img_format;
        if (bArr6 != null) {
            this._img_format = (byte[]) bArr6.clone();
        } else {
            this._img_format = new byte[0];
        }
        byte[] bArr7 = wloginSimpleInfo._img_url;
        if (bArr7 != null) {
            this._img_url = (byte[]) bArr7.clone();
        } else {
            this._img_url = new byte[0];
        }
        byte[] bArr8 = wloginSimpleInfo.mainDisplayName;
        if (bArr8 != null) {
            this.mainDisplayName = (byte[]) bArr8.clone();
        } else {
            this.mainDisplayName = new byte[0];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this._uin);
        parcel.writeByteArray(this._face);
        parcel.writeByteArray(this._age);
        parcel.writeByteArray(this._gender);
        parcel.writeByteArray(this._nick);
        parcel.writeByteArray(this._img_type);
        parcel.writeByteArray(this._img_format);
        parcel.writeByteArray(this._img_url);
        parcel.writeByteArray(this.mainDisplayName);
    }

    public WloginSimpleInfo(long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        this._uin = j3;
        if (bArr != null) {
            this._face = (byte[]) bArr.clone();
        } else {
            this._face = new byte[0];
        }
        if (bArr2 != null) {
            this._age = (byte[]) bArr2.clone();
        } else {
            this._age = new byte[0];
        }
        if (bArr3 != null) {
            this._gender = (byte[]) bArr3.clone();
        } else {
            this._gender = new byte[0];
        }
        if (bArr4 != null) {
            this._nick = (byte[]) bArr4.clone();
        } else {
            this._nick = new byte[0];
        }
        if (bArr5 != null) {
            this._img_type = (byte[]) bArr5.clone();
        } else {
            this._img_type = new byte[0];
        }
        if (bArr6 != null) {
            this._img_format = (byte[]) bArr6.clone();
        } else {
            this._img_format = new byte[0];
        }
        if (bArr7 != null) {
            this._img_url = (byte[]) bArr7.clone();
        } else {
            this._img_url = new byte[0];
        }
    }

    public void get_clone(WloginSimpleInfo wloginSimpleInfo) {
        this._uin = wloginSimpleInfo._uin;
        byte[] bArr = wloginSimpleInfo._face;
        if (bArr != null) {
            this._face = (byte[]) bArr.clone();
        } else {
            this._face = new byte[0];
        }
        byte[] bArr2 = wloginSimpleInfo._age;
        if (bArr2 != null) {
            this._age = (byte[]) bArr2.clone();
        } else {
            this._age = new byte[0];
        }
        byte[] bArr3 = wloginSimpleInfo._gender;
        if (bArr3 != null) {
            this._gender = (byte[]) bArr3.clone();
        } else {
            this._gender = new byte[0];
        }
        byte[] bArr4 = wloginSimpleInfo._nick;
        if (bArr4 != null) {
            this._nick = (byte[]) bArr4.clone();
        } else {
            this._nick = new byte[0];
        }
        byte[] bArr5 = wloginSimpleInfo._img_type;
        if (bArr5 != null) {
            this._img_type = (byte[]) bArr5.clone();
        } else {
            this._img_type = new byte[0];
        }
        byte[] bArr6 = wloginSimpleInfo._img_format;
        if (bArr6 != null) {
            this._img_format = (byte[]) bArr6.clone();
        } else {
            this._img_format = new byte[0];
        }
        byte[] bArr7 = wloginSimpleInfo._img_url;
        if (bArr7 != null) {
            this._img_url = (byte[]) bArr7.clone();
        } else {
            this._img_url = new byte[0];
        }
    }

    public WloginSimpleInfo(long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][] bArr5) {
        this._uin = j3;
        if (bArr != null) {
            this._face = (byte[]) bArr.clone();
        } else {
            this._face = new byte[0];
        }
        if (bArr2 != null) {
            this._age = (byte[]) bArr2.clone();
        } else {
            this._age = new byte[0];
        }
        if (bArr3 != null) {
            this._gender = (byte[]) bArr3.clone();
        } else {
            this._gender = new byte[0];
        }
        if (bArr4 != null) {
            this._nick = (byte[]) bArr4.clone();
        } else {
            this._nick = new byte[0];
        }
        if (bArr5 == null || bArr5.length != 3) {
            this._img_type = new byte[0];
            this._img_format = new byte[0];
            this._img_url = new byte[0];
        } else {
            this._img_type = (byte[]) bArr5[0].clone();
            this._img_format = (byte[]) bArr5[1].clone();
            this._img_url = (byte[]) bArr5[2].clone();
        }
    }

    WloginSimpleInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
